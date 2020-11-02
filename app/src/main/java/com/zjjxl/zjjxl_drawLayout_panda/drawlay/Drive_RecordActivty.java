package com.zjjxl.zjjxl_drawLayout_panda.drawlay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.PendingIntent;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.heyue.adpu_manager.module.BalanceData;
import com.heyue.adpu_manager.module.BalanceRecordBean;
import com.heyue.adpu_manager.nfc.CardManager;
import com.zjjxl.zjjxl_drawLayout_panda.R;
import com.zjjxl.zjjxl_drawLayout_panda.adapters.RecordSaveAdapter;
import com.zjjxl.zjjxl_drawLayout_panda.utils.LUtils;
import com.zjjxl.zjjxl_drawLayout_panda.utils.StatusBarUtil;
import com.zjjxl.zjjxl_drawLayout_panda.utils.ToastUtils;

import java.util.List;

public class Drive_RecordActivty extends AppCompatActivity implements View.OnClickListener {

    private TextView mDraw_savemoney_back;

    private PendingIntent mPendingIntent;
    NfcAdapter mNfcAdapter;
    private LinearLayout mLly_shownfcload;
    private RecyclerView mTrain_record_save;
    private RecordSaveAdapter mAdapter;
    private String TAG = "Drive_RecordActivty";
    private TextView mNulldate_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setStatusBarLightMode(getWindow());
        StatusBarUtil.setDrawable(this, R.drawable.fragment_bennefit_boxframe);
        setContentView(R.layout.activity_drive__record_activty);

        initview();

        initEventAndData();
    }

    private void initview() {

        mDraw_savemoney_back = findViewById(R.id.draw_savemoney_back);
        mTrain_record_save = findViewById(R.id.train_record_save);
        mNulldate_text = findViewById(R.id.nulldate_text);

        mLly_shownfcload = findViewById(R.id.lly_shownfcload);
        mLly_shownfcload.setVisibility(View.VISIBLE);
        mDraw_savemoney_back.setOnClickListener(this);

        mAdapter = new RecordSaveAdapter(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //设置布局管理器
        mTrain_record_save.setLayoutManager(layoutManager);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        mTrain_record_save.setAdapter(mAdapter);
    }

    protected void initEventAndData() {
        //此处adapter需要重新获取，否则无法获取message
        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
        if (mNfcAdapter != null) {
            //一旦截获NFC消息，就会通过PendingIntent调用窗口
            mPendingIntent = PendingIntent.getActivity(this,
                    0, new Intent(this,
                            getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.draw_savemoney_back:
                finish();
                break;
        }
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Parcelable mParcelableExtra = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
        if (mParcelableExtra != null) {
            BalanceData data = CardManager.getInfoData(mParcelableExtra);
            if (data != null) {
                String mMCardid = data.card_id;
                if (mMCardid != null) {
                    mLly_shownfcload.setVisibility(View.GONE);
                    List<BalanceRecordBean> recordList = data.recordList;
                    if (recordList.size() < 1) {
                        mNulldate_text.setVisibility(View.VISIBLE);
                        mTrain_record_save.setVisibility(View.GONE);
                        mAdapter.setDate(recordList);
                        mAdapter.notifyDataSetChanged();
                    } else {
                        mAdapter.setDate(recordList);
                        mTrain_record_save.setVisibility(View.VISIBLE);
                        mNulldate_text.setVisibility(View.GONE);
                        mAdapter.notifyDataSetChanged();
                    }
//
//                    for (int i = 0; i < recordList.size(); i++) {
//                        BalanceRecordBean balanceRecordBean = recordList.get(i);
//                        LUtils.d(TAG, balanceRecordBean.time);
//                    }


                } else {
                    ToastUtils.showToast(this, "检查卡片是否损坏");
                }
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        //设置处理优于所有其他NFC的处理
        if (mNfcAdapter != null) {
            mNfcAdapter.enableForegroundDispatch(this,
                    mPendingIntent, CardManager.FILTERS, CardManager.TECHLISTS);
        }
    }

    /**
     * 暂停Activity，界面获取焦点，按钮可以点击
     */
    @Override
    public void onPause() {
        super.onPause();
        //恢复默认状态
        if (mNfcAdapter != null)
            mNfcAdapter.disableForegroundDispatch(this);
    }

}

package com.zjjxl.zjjxl_drawLayout_panda.drawlay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.heyue.pay.TSMPay;
import com.heyue.pay.alipay.Alipay;
import com.heyue.pay.api.BaseSubscriber;
import com.heyue.pay.listener.BaseCallback;
import com.heyue.pay.protocol.BaseResp;
import com.heyue.pay.protocol.PayRequestRec;
import com.zjjxl.zjjxl_drawLayout_panda.R;
import com.zjjxl.zjjxl_drawLayout_panda.adapters.ChargeMoneyRecordAdapter;
import com.zjjxl.zjjxl_drawLayout_panda.beans.Bean_BaseCard;
import com.zjjxl.zjjxl_drawLayout_panda.beans.ChargeMoneyRecordbean;
import com.zjjxl.zjjxl_drawLayout_panda.https.HttpManager;
import com.zjjxl.zjjxl_drawLayout_panda.utils.Contants;
import com.zjjxl.zjjxl_drawLayout_panda.utils.LUtils;
import com.zjjxl.zjjxl_drawLayout_panda.utils.ShareUtil;
import com.zjjxl.zjjxl_drawLayout_panda.utils.ToastUtils;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChargeMoneyRecord extends AppCompatActivity implements View.OnClickListener, ChargeMoneyRecordAdapter.SkuInterface {

    private RecyclerView mCharge_record_save;
    private TextView mChargemoney_back;
    private ChargeMoneyRecordAdapter mAd;
    private TextView mCharge_record_save_tv;
    private String TAG = "ChargeMoneyRecord";
    private List<ChargeMoneyRecordbean.DataBean> mData;
    private ChargeMoneyRecordbean.DataBean mDataBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charge_money_record);

        initView();

    }

    @Override
    protected void onResume() {
        super.onResume();
        initDate();
    }


    private void initDate() {

        Call<ChargeMoneyRecordbean> chargeMoneyRecordbeanCall = HttpManager.getInstance().getHttpClient3().
                rechargeRecordList(ShareUtil.getString(Contants.LOGIN_USER_PHONE),
                        "", ShareUtil.getString(Contants.LOGIN_USERMEMBERID));
        chargeMoneyRecordbeanCall.enqueue(new Callback<ChargeMoneyRecordbean>() {
            @Override
            public void onResponse(Call<ChargeMoneyRecordbean> call, Response<ChargeMoneyRecordbean> response) {
                if (response != null) {
                    if (response.body().isStatus()) {
                        mData = response.body().getData();
                        if (mData.size() > 0) {
                            mCharge_record_save_tv.setVisibility(View.GONE);
                            mAd.setDate(mData);
                            mAd.notifyDataSetChanged();
                        } else {
                            mCharge_record_save_tv.setVisibility(View.VISIBLE);
                            mCharge_record_save.setVisibility(View.GONE);


                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<ChargeMoneyRecordbean> call, Throwable t) {

            }
        });


    }

    private void initView() {

        mChargemoney_back = findViewById(R.id.chargemoney_back);
        mCharge_record_save = findViewById(R.id.charge_record_save);
        mCharge_record_save_tv = findViewById(R.id.charge_record_save_tv);

        mChargemoney_back.setOnClickListener(this);
        mAd = new ChargeMoneyRecordAdapter(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //设置布局管理器
        mCharge_record_save.setLayoutManager(layoutManager);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        mCharge_record_save.setAdapter(mAd);
        mAd.setOnItemClick(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.chargemoney_back:
                finish();
                break;
        }
    }

    @Override
    public void setdatecircleState(int po, int sta) {
        Intent intent = new Intent(this, ShuangYSaveMoneyActivity.class);
        ChargeMoneyRecordbean.DataBean dataBean = mData.get(po);
        Bundle bundle = new Bundle();
        bundle.putSerializable("ChargeMoneyRecordbean", dataBean);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }

    @Override
    public void setdatestate(int pos, int state) {
        mDataBean = mData.get(pos);
        if (state == 1) {
            tozhifuSave(pos);
        } else if (state == 2) {
            //退款
            refund();
        }


    }

    // 退款
    private void refund() {
        Call<Bean_BaseCard> refund = HttpManager.getInstance().getHttpClient3()
                .payOrderRefund(
                        mDataBean.getTradeNo(),
                        mDataBean.getOrderCode(),
                        mDataBean.getTradeAmount(),
                        "", "", "REFUND");
        refund.enqueue(new Callback<Bean_BaseCard>() {
            @Override
            public void onResponse(Call<Bean_BaseCard> call, Response<Bean_BaseCard> response) {
                if (response.body() != null) {
                    boolean status = response.body().isStatus();
                    if (status) {
                        String code = response.body().getData().getCode();
                        LUtils.d(TAG, " String code ====" + code);
                        if (code.equals("1000")) {
                            ToastUtils.showToast(ChargeMoneyRecord.this,
                                    response.body().getData().getMessage());
                            rechargeRecordUpdatestate(mDataBean.getOrderCode(), 6);
                        } else {
//                            ToastUtils.showToast(ChargeMoneyRecord.this,
//                                    response.body().getData().getMessage());
//                            rechargeRecordUpdatestate(mDataBean.getOrderCode(), 7);
                        }

                    } else {
                        ToastUtils.showToast(ChargeMoneyRecord.this, response.body().getData().getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<Bean_BaseCard> call, Throwable t) {
                ToastUtils.showToast(ChargeMoneyRecord.this, "退款失败");
            }
        });
    }


    // 支付宝支付
    private void tozhifuSave(int pos) {
        final ChargeMoneyRecordbean.DataBean dataBean = mData.get(pos);

        HashMap params = new HashMap();
        params.put("out_trade_no", dataBean.getOrderCode());//必传字段 订单号
        params.put("trade_amount", dataBean.getTradeAmount());//必传字段 交易金额（单位元）
        params.put("subject", "四通一卡通充值");//必传字段   交易说明（subject不能超过16）
        params.put("user_id", ShareUtil.getString(Contants.LOGIN_USER_PHONE));//非//非必传字段(根据业务要求有的话就传入；否则不需要传) 接入商后台结果通知地址必传字段
        //        params.put("notify_url", "");
        TSMPay.payRequest(this, params, mlistener,
                new Alipay.AlipayResultCallBack() {
                    @Override
                    public void onSuccess() {
                        LUtils.d(TAG, "AlipayResultCallBack   onSuccess    ");
                        toQuery(dataBean.getOrderCode());
                    }

                    @Override
                    public void onDealing() {
                        LUtils.d(TAG, "AlipayResultCallBack   onDealing    ");
                    }

                    @Override
                    public void onError(int error_code) {
                        LUtils.d(TAG, "AlipayResultCallBack   onError    ");
                    }

                    @Override
                    public void onCancel() {
                        LUtils.d(TAG, "AlipayResultCallBack   onCancel    ");
                    }
                });
    }

    BaseCallback mlistener = new BaseCallback() {
        @Override
        public void callBack(BaseResp result) {
            //result 支付结果回调
            Log.e(TAG, " mlistener  支付回调结果  payAli: " + result.trace_id);
            Log.e(TAG, " mlistener  支付回调结果  payAli: " + result.message);
            Log.e(TAG, " mlistener  支付回调结果  payAli: " + result.biz_content);
            Log.e(TAG, " mlistener  支付回调结果  payAli: " + result.server_time);
            Log.e(TAG, " mlistener  支付回调结果  payAli: " + result.sign);
            Log.e(TAG, " mlistener  支付回调结果  payAli: " + result.code);
            Log.e(TAG, " mlistener  支付回调结果  payAli: " + result.biz_type);
            Log.e(TAG, " mlistener  支付回调结果  payAli: " + result.data);
            Log.e(TAG, " mlistener  支付回调结果  payAli: " + result.token);
            Log.e(TAG, " mlistener  支付回调结果  payAli: " + result.sign_type);

        }
    };

    private void toQuery(String out_trade_no) {
        //在您app需要查询订单的地方调用TSM查询订单的方法
        HashMap params = new HashMap();
        params.put("out_trade_no", out_trade_no);//订单号
        TSMPay.reqOrderStatus(params, new BaseSubscriber<PayRequestRec>() {
            @Override
            public void onNext(PayRequestRec payRequestRec) {
                //服务器返回结果
                super.onNext(payRequestRec);
//                Log.e(TAG, "   支付服务器返回结果  payAli: " + payRequestRec.trace_id);
//                Log.e(TAG, "   支付服务器返回结果  payAli: " + payRequestRec.message);
//                Log.e(TAG, "   支付服务器返回结果  payAli: " + payRequestRec.biz_content);
//                Log.e(TAG, "   支付服务器返回结果  payAli: " + payRequestRec.server_time);
//                Log.e(TAG, "   支付服务器返回结果  payAli: " + payRequestRec.sign);
//                Log.e(TAG, "   支付服务器返回结果  payAli: " + payRequestRec.code);
//                Log.e(TAG, "   支付服务器返回结果  payAli: " + payRequestRec.biz_type);
//                Log.e(TAG, "   支付服务器返回结果  data payAli: " + payRequestRec.data);
//                Log.e(TAG, "   支付服务器返回结果  payAli: " + payRequestRec.token);
//                Log.e(TAG, "   支付服务器返回结果  payAli: " + payRequestRec.sign_type);
                if (payRequestRec.code == 1000) {
                    rechargeRecordUpdatestate(out_trade_no, 2);
                }
//
            }
            //////////
        });
    }

    private void rechargeRecordUpdatestate(String out_trade_no, int state) {
        Call<ChargeMoneyRecordbean> chargeMoneyRecordbeanCall =
                HttpManager.getInstance().getHttpClient3().rechargeRecordUpdatestate(out_trade_no, state);
        chargeMoneyRecordbeanCall.enqueue(new Callback<ChargeMoneyRecordbean>() {
            @Override
            public void onResponse(Call<ChargeMoneyRecordbean> call, Response<ChargeMoneyRecordbean> response) {
                if (response.body() != null) {
                    if (response.body().isStatus()) {
                     }
                }

            }

            @Override
            public void onFailure(Call<ChargeMoneyRecordbean> call, Throwable t) {

            }
        });
    }
}

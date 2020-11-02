package com.zjjxl.zjjxl_drawLayout_panda.drawlay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.zjjxl.zjjxl_drawLayout_panda.R;
import com.zjjxl.zjjxl_drawLayout_panda.beans.QueryBindCradbean;
import com.zjjxl.zjjxl_drawLayout_panda.https.HttpManager;
import com.zjjxl.zjjxl_drawLayout_panda.drawlay.logins.LoginActivity;
import com.zjjxl.zjjxl_drawLayout_panda.utils.CircleImageView;
import com.zjjxl.zjjxl_drawLayout_panda.utils.Contants;
import com.zjjxl.zjjxl_drawLayout_panda.utils.LUtils;
import com.zjjxl.zjjxl_drawLayout_panda.utils.ShareUtil;
import com.zjjxl.zjjxl_drawLayout_panda.utils.StatusBarUtil;
import com.zjjxl.zjjxl_drawLayout_panda.utils.ToastUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.wechat.friends.Wechat;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main_DrawerLayout extends AppCompatActivity implements View.OnClickListener, DrawerLayout.DrawerListener, PlatformActionListener {

    DrawerLayout mDrawerlayout;
    LinearLayout mlinlayout;
    private CircleImageView mViewById;
    private ImageView mDraw_main_save;
    private ImageView mDraw_main_recharge;
    private ImageView mDraw_main_train;
    private ImageView mDraw_main_byorsend;
    private Button mDraw_mine_rely_btn;
    private String TAG = "Main_DrawerLayout";
    private boolean mIsclick;
    private CircleImageView mDrawleft_mine_mine;
    private TextView mDraw_loginnum;
    private TextView mDraw_main_tv;
    private Button mMenu_login_out;
    private LinearLayout mId_draw_menu_layout;
    private LinearLayout mMenu_addcard, mMenu_mrorder, mMenu_myinvoice, mMenu_myaddress;
    private Button mButton_cardequity;
    private Platform mWechat;
    private int PERMISSION_CODE = 1000;
    List<String> mPermissionList = new ArrayList<>();
    private String[] permissions = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CALL_PHONE,
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO,
            //            Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.READ_PHONE_STATE
    };
    AlertDialog mPermissionDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setDrawable(this, R.drawable.draw_mine_fragment_color);
        StatusBarUtil.setStatusBarLightMode(getWindow());
        setContentView(R.layout.activity_main__drawer_layout);
        initPermission();
        initView();
    }

    private void initPermission() {
        mPermissionList.clear();
        //逐个判断是否还有未通过的权限
        for (int i = 0; i < permissions.length; i++) {
            if (ContextCompat.checkSelfPermission(this, permissions[i]) !=
                    PackageManager.PERMISSION_GRANTED) {
                mPermissionList.add(permissions[i]);//添加还未授予的权限到mPermissionList中
            }
        }
        //申请权限
        if (mPermissionList.size() > 0) {//有权限没有通过，需要申请
            ActivityCompat.requestPermissions(this, permissions, PERMISSION_CODE);
        } else {
            //权限已经都通过了，可以将程序继续打开了
//            initFid();
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        boolean hasPermissionDismiss = false;//有权限没有通过
        if (PERMISSION_CODE == requestCode) {
            for (int i = 0; i < grantResults.length; i++) {
                if (grantResults[i] == -1) {
                    LUtils.d(TAG, "grantResults[i]==" + i);
                    hasPermissionDismiss = true;
                    break;
                }
            }
        }
        if (hasPermissionDismiss) {//如果有没有被允许的权限
            showPermissionDialog();

        } else {
            //权限已经都通过了，可以将程序继续打开了
//            initFid();
        }


    }
    private void showPermissionDialog() {
        if (mPermissionDialog == null) {
            mPermissionDialog = new AlertDialog.Builder(this)
                    .setMessage("已禁用权限，请手动授予")
                    .setPositiveButton("设置", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            cancelPermissionDialog();

                            Uri packageURI = Uri.parse("package:" + "com.estone.bank.estone_appsmartlock");
                            Intent intent = new Intent(Settings.
                                    ACTION_APPLICATION_DETAILS_SETTINGS, packageURI);
                            startActivity(intent);
                            Main_DrawerLayout.this.finish();
                        }
                    })
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //关闭页面或者做其他操作
                            cancelPermissionDialog();
                            Main_DrawerLayout.this.finish();
                        }
                    })
                    .create();
        }
        mPermissionDialog.show();

    }

    private void cancelPermissionDialog() {
        mPermissionDialog.cancel();
    }

    private void initView() {

        mDrawerlayout = findViewById(R.id.drawer_layout);
        mId_draw_menu_layout = findViewById(R.id.id_draw_menu_layout);
        mViewById = findViewById(R.id.draw_mine_minehead);
        mDraw_main_save = findViewById(R.id.draw_main_save);
        mDraw_main_recharge = findViewById(R.id.draw_main_recharge);
        mDraw_main_train = findViewById(R.id.draw_main_train);
        mDraw_mine_rely_btn = findViewById(R.id.draw_mine_rely_btn);
        mDraw_main_byorsend = findViewById(R.id.draw_main_byorsend);
        mDrawleft_mine_mine = findViewById(R.id.drawleft_mine_mine);
        mDraw_main_tv = findViewById(R.id.draw_main_tv);
        mDraw_loginnum = findViewById(R.id.draw_loginnum);
        mMenu_login_out = findViewById(R.id.menu_login_out);

        mMenu_addcard = findViewById(R.id.menu_addcard);
        mMenu_mrorder = findViewById(R.id.menu_mrorder);
        mMenu_myinvoice = findViewById(R.id.menu_myinvoice);
        mMenu_myaddress = findViewById(R.id.menu_myaddress);
        mButton_cardequity = findViewById(R.id.button_cardequity);
        mMenu_addcard.setOnClickListener(this);
        mMenu_mrorder.setOnClickListener(this);
        mMenu_myinvoice.setOnClickListener(this);
        mMenu_myaddress.setOnClickListener(this);
        mButton_cardequity.setOnClickListener(this);
        mDraw_main_byorsend.setOnClickListener(this);
        mDraw_main_train.setOnClickListener(this);
        mDraw_main_recharge.setOnClickListener(this);


        LinearLayout.LayoutParams linearParams = (LinearLayout.LayoutParams) mDraw_main_save.getLayoutParams(); //取控件textView当前的布局参数

        linearParams.width = getWindowManager().getDefaultDisplay().getWidth() / 3;// 控件的宽强制设成30
        linearParams.height = getWindowManager().getDefaultDisplay().getWidth() / 3;// 控件的高强制设成20

        mDraw_main_save.setLayoutParams(linearParams);
        mDraw_main_recharge.setLayoutParams(linearParams);
        mDraw_main_byorsend.setLayoutParams(linearParams);
        mDraw_main_train.setLayoutParams(linearParams);
        //================


        mDraw_mine_rely_btn.setOnClickListener(this);
        mViewById.setOnClickListener(this);
        mDraw_main_save.setOnClickListener(this);
        mMenu_login_out.setOnClickListener(this);
        mDrawerlayout.addDrawerListener(this);


        mWechat = ShareSDK.getPlatform(Wechat.NAME);
        mWechat.setPlatformActionListener(this);

    }

    @Override
    public void onClick(View v) {
        String string = ShareUtil.getString(Contants.LOGIN_USER_PHONE);
        if (string != null) {
            switch (v.getId()) {
                case R.id.button_cardequity:
                    Intent inss = new Intent(this, RightsActivityH5.class);
                    startActivity(inss);
                    break;
                case R.id.menu_myaddress:
                case R.id.menu_addcard:
                case R.id.menu_mrorder:
                case R.id.menu_myinvoice:
                    ToastUtils.showToast(this, "开发中，敬请期待。");
                    break;
                case R.id.draw_main_train:
                    Intent ins = new Intent(this, Drive_RecordActivty.class);
                    startActivity(ins);
                    break;
                case R.id.draw_main_recharge:
                    Intent ins2 = new Intent(this, ChargeMoneyRecord.class);
                    startActivity(ins2);
                    break;
                case R.id.draw_main_byorsend:
                    mWechat.showUser(null);
                    break;
                case R.id.draw_mine_minehead:
                    mDrawerlayout.openDrawer(Gravity.LEFT);
                    break;
                case R.id.draw_mine_rely_btn:
                    if (mIsclick) {
                        Intent intent = new Intent(this, LoginActivity.class);
                        startActivity(intent);
                    }
                    break;
                case R.id.menu_login_out:
                    if (mIsclick) {
                        Intent intent = new Intent(this, LoginActivity.class);
                        startActivity(intent);
                    } else {
                        ShareUtil.removeAllKey();
                        finish();
                        Intent in = new Intent(this, WelcomeActivit.class);
                        startActivity(in);
                    }
                    break;
                case R.id.draw_main_save:
//                    Intent intent = new Intent(this, ShowAccessChannelActivity.class);
//                    startActivity(intent);
                    Intent intent = new Intent(this, ShuangYSaveMoneyActivity.class);
                    startActivity(intent);
                    break;
            }
        } else {
            ToastUtils.showToast(this, "先登录一下吧");
            mDrawerlayout.closeDrawer(Gravity.LEFT);
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

    }


    @Override
    public void onResume() {
        super.onResume();
        LUtils.d(TAG, "onResume");

        String stringph = ShareUtil.getString(Contants.LOGIN_USER_PHONE);
        if (stringph != null) {
            mIsclick = false;
            mDraw_mine_rely_btn.setText(getResources().getString(R.string.draw_islogin));
            mDraw_main_tv.setText(stringph);
            mDraw_loginnum.setText(stringph);
            mMenu_login_out.setText(getResources().getString(R.string.menu_out));
        } else {
            mIsclick = true;
            mMenu_login_out.setText(getResources().getString(R.string.menu_login));
        }

        String snamehead = ShareUtil.getString(Contants.LOGIN_USER_HEAD);
        if (snamehead != null) {
//            Glide.with(this).load(snamehead.toString())
//                    .placeholder(R.mipmap.pandaapplogo)
//                    .dontAnimate().skipMemoryCache(true).
//                    diskCacheStrategy(DiskCacheStrategy.NONE).
//                    into(mViewById);
//            Glide.with(this).load(snamehead.toString())
//                    .placeholder(R.mipmap.pandaapplogo)
//                    .dontAnimate().skipMemoryCache(true).
//                    diskCacheStrategy(DiskCacheStrategy.NONE).
//                    into(mDrawleft_mine_mine);
        }
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        /**
         * 抽屉滑动时，调用此方法
         * */
    }

    @Override
    public void onDrawerOpened(View drawerView) {
        /**
         * 抽屉被完全展开时，调用此方法
         * */

    }

    @Override
    public void onDrawerClosed(View drawerView) {
        /**
         * 抽屉被完全关闭时，调用此方法
         * */

    }

    @Override
    public void onDrawerStateChanged(int newState) {
        /**
         * 抽屉状态改变时，调用此方法
         * */
    }

    @Override
    public void onError(Platform platform, int i, Throwable throwable) {

        LUtils.d(TAG, "微信登录失败!" + i + throwable);
        Toast.makeText(this, "微信登录失败!" + i + throwable, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCancel(Platform platform, int i) {
        LUtils.d(TAG, "微信取消登录!" + i);
        Toast.makeText(this, "微信取消登录!" + i, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
        LUtils.d(TAG, "微信登录成功!");
        Iterator ite = hashMap.entrySet().iterator();
        //        mDialog2.dismiss();

        while (ite.hasNext()) {
            Map.Entry entry = (Map.Entry) ite.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            LUtils.d(TAG, key + "：-------------- " + value);
            LUtils.d(TAG, hashMap.toString());
            LUtils.d(TAG, (String) hashMap.get("unionid"));

        }
//        queryUserInfoByUserMid((String) hashMap.get("unionid"));
        toWeChatproject();
    }


    private void queryUserInfoByUserMid(String unionid) {
        Call<QueryBindCradbean> queryCZCityCall = HttpManager.getInstance().getHttpClient3().
                updateUserOpenId(ShareUtil.getString(Contants.LOGIN_USERMEMBERID), unionid);
        queryCZCityCall.enqueue(new Callback<QueryBindCradbean>() {
            @Override
            public void onResponse(Call<QueryBindCradbean> call, Response<QueryBindCradbean> response) {
                if (response.body() != null) {
                    toWeChatproject();

                }
            }

            @Override
            public void onFailure(Call<QueryBindCradbean> call, Throwable t) {

            }
        });
    }

    public void toWeChatproject() {
        String appId = "wx066b02355bf9f39b"; // 填应用AppId
        IWXAPI api = WXAPIFactory.createWXAPI(this, appId);

        WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
        req.userName = "gh_ad3fcc78de0c"; // 小程序原始id
        req.path = "/pages/index/index";                  //拉起小程序页面的可带参路径，不填默认拉起小程序首页
        req.miniprogramType = WXLaunchMiniProgram.Req.MINIPTOGRAM_TYPE_RELEASE;
        api.sendReq(req);
    }


}

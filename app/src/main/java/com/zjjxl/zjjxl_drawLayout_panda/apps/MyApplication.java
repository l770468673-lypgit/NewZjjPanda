package com.zjjxl.zjjxl_drawLayout_panda.apps;

import android.app.Application;


import com.heyue.pay.TSMPay;
import com.heyue.pay.utils.ContextHolder;
//import com.mob.MobSDK;
import com.mob.MobSDK;
import com.zjjxl.zjjxl_drawLayout_panda.https.HttpManager;
import com.zjjxl.zjjxl_drawLayout_panda.utils.ShareUtil;

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;


import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;


/**
 * 双阳测试环境
 * //终端号248200000000
 * //用户名24820000
 * //密码00000000000000000000000000000000
 * //发卡机构代码05212482
 * //114.242.105.186 8800
 * sdkAccessChannel：xm100002
 */

/**
 * appkey:
 * E49B0A3AE672E077BA9C75EC903931
 * ;;;;
 * TSM平台公钥(E49B0A3AE672E077BA9C75EC903931)：
 * MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhnAX/krcS9aCshC04et8rGBiGcUpxNEWKDpTKfKzmp9i8P0e07Je2wNOy2UNoXOex49uBffadai2T6GuPY73kclXyARz33FlX5YiY1SroAFB/ZkVuqi0IP7Q0WmevHuDdgxmqMkWRxMh2h7DyzgHca8ZzXGAfeTaw9NeFlEAqY3xf1ourdn7vlrrlX8WrCaWRzEA4zISlpDnoVr+7qBYzHT3q6cizhMXAQfK4JKcf3zFCQGmGAgCA4eKMuFoZM9jA3Etqf3NCxBFojPeL/Sn0NN6gwbvFkKf1e8HHxtrALQ0jTrQEJjz9pbvz6Y0TUcxEwCmgOYpNW5p5jiEzsX+JQIDAQAB
 *对应的secret是OYH815GP47CKA5QYHYBDTWXTNVI5A1MH
 *
 */

public class MyApplication extends Application {
    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        ShareUtil.initShared(this);
        HttpManager.getInstance();
        ignoreSSLHandshake();
        MobSDK.init(this);
        MobSDK.submitPolicyGrantResult(true, null);
//        Utils.init(this);
        ContextHolder.initial(this);

        // 测试环境下
//        TSMPay.init("E49B0A3AE672E077BA9C75EC903931",
//                "OYH815GP47CKA5QYHYBDTWXTNVI5A1MH",
//                "http://47.114.7.135:7900/payment/v1/");

        // 正式环境下
        TSMPay.init("F6AA39D5211E47FFFD12CB4128CEEA03",
                "U4BRX44GY31524ELP54XMKRJ84XSL6XG",
                "http://119.53.211.78:9510/payment/v1/");


        handleSSLHandshake();
    }


    public static void handleSSLHandshake() {
        try {
            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }

                @Override
                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }};

            SSLContext sc = SSLContext.getInstance("TLS");
            // trustAllCerts信任所有的证书
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
        } catch (Exception ignored) {
        }
    }

    public static MyApplication getInstance() {
        return instance;
    }


    // 忽略 https 验证
    public static void ignoreSSLHandshake() {

        //  直接通过主机认证
        HostnameVerifier hv = new HostnameVerifier() {
            public boolean verify(String urlHostName, SSLSession session) {
                return true;
            }
        };

        try {
            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                @Override
                public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {

                }

                @Override
                public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {

                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }


            }};

            SSLContext sc = SSLContext.getInstance("TLS");
            // trustAllCerts信任所有的证书
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
        } catch (Exception e) {
        }
    }
    }

package com.zjjxl.zjjxl_drawLayout_panda.interceptor;

import android.util.Log;


import com.zjjxl.zjjxl_drawLayout_panda.utils.ShareUtil;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * @Author LD
 * @Time 2019/7/5 11:50
 * @Describe 拦截cookie保存在本地
 * @Modify
 */
public class ReceivedCookiesInterceptor implements Interceptor {

    private static final String TAG = "ceshi";

    @Override
    public Response intercept(Chain chain) throws IOException {

        Response originalResponse = chain.proceed(chain.request());
        Log.i(TAG, "intercept: "+originalResponse.headers().toString());
        //不为空
        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            HashSet<String> cookie = new HashSet<>();
            for (String header : originalResponse.headers("Set-Cookie")) {
                cookie.add(header);
            }
            ShareUtil.putStringSet("cookie", cookie);
        }
        return originalResponse;
    }
}

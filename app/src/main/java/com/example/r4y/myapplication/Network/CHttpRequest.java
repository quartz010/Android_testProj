package com.example.r4y.myapplication.Network;

import java.io.IOException;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by r4y on 2018/2/22.
 */

public class CHttpRequest {

    CHttpRequest() {}



    public String httpGetRequest(String urlRequested) {
        try {
            OkHttpClient okHttpClient = new OkHttpClient();
            Response response;
            URL url = new URL(urlRequested);

            Request request = new Request.Builder().url(url).get().build();
            response = okHttpClient.newCall(request).execute();
            return response.body().string();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

package com.example.r4y.myapplication.Network;

import android.util.Log;

import com.example.r4y.myapplication.Misc.BlockInfo;
import com.example.r4y.myapplication.Misc.TokenInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by r4y on 2018/2/23.
 */

public class CRemoteReq {

    private CHttpRequest httpCli;

    public CRemoteReq() {

        httpCli = new CHttpRequest();

    }

    private HashMap<String, String> urlMap = new HashMap<String, String>() {
        {
        // token
        put("token", "https://api.etherscan.io/api?module=stats&action=tokensupply&" +
                "contractaddress=0x57d90b64a1a57749b0f932f1a3395792e12e7055&apikey=YourApiKeyToken");
        // block
        put("block", "https://api.etherscan.io/api?module=block&action=getblockreward&"+
                "blockno=2165403&apikey=YourApiKeyToken");

        }

    };

    public TokenInfo reqToken() {

        String context = httpCli.httpGetRequest(urlMap.get("token"));

        if (!context.isEmpty()) {
            Log.i("Request", " onResponse() result=" + context);

            CJson json = new CJson();

            return json.resolveTokenI(context);

        }
        return new TokenInfo();
    }

    public BlockInfo reqBlock() {

        String context = httpCli.httpGetRequest(urlMap.get("block"));

        if (!context.isEmpty()) {
            Log.i("Request", " onResponse() result=" + context);

            CJson json = new CJson();

            return json.resolveBlockI(context);

        }
        return new BlockInfo();

    }

}

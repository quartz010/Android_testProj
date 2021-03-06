package com.example.r4y.myapplication.Network;

import android.util.Log;

import com.example.r4y.myapplication.Misc.BlockInfo;
import com.example.r4y.myapplication.Misc.TokenInfo;

import java.util.HashMap;

/**
 * Created by r4y on 2018/2/23.
 */
// contains Personal APIToken, so ignored
import com.example.r4y.myapplication.KeepOut.Personal;




public class CRemoteReq {

    private CHttpRequest httpCli;

    private HashMap<String, String> urlMap = new HashMap<String, String>() {
        {
            // token
            put("token", "https://api.etherscan.io/api?module=stats&action=tokensupply&" +
                    "contractaddress=0x57d90b64a1a57749b0f932f1a3395792e12e7055&apikey="+
                    Personal.apiKey);
            // block
            put("block", "https://api.etherscan.io/api?module=proxy&action=eth_blockNumber&apikey=" +
                    "YourApiKeyToken" + Personal.apiKey);

        }

    };

    public CRemoteReq() {

        httpCli = new CHttpRequest();

    }

    public TokenInfo reqToken() {

        String context = httpCli.httpGetRequest(urlMap.get("token"));

        if (!context.isEmpty()) {
//            Log.i("Request", " onResponse() result=" + context);

            CJson json = new CJson();

            return json.resolveTokenI(context);

        }
        return new TokenInfo();
    }

    public BlockInfo reqBlock() {

        String context = httpCli.httpGetRequest(urlMap.get("block"));

        if (!context.isEmpty()) {
//            Log.i("Request", " onResponse() result=" + context);

            CJson json = new CJson();

            return json.resolveBlockI(context);

        }
        return new BlockInfo();

    }

}



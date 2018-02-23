package com.example.r4y.myapplication.Network;

/**
 * Created by r4y on 2018/2/22.
 */
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import com.example.r4y.myapplication.Misc.TokenInfo;
import com.example.r4y.myapplication.Misc.BlockInfo;

public class CJson {

    private static final String TAG = CJson.class.getSimpleName();

    public  CJson() {}


    //json数据为数组使用这种方式获取，即地址有多条数据

    public TokenInfo resolveTokenI(String raw) {

        Gson gson = new Gson();

        Log.i(TAG, "resolveTokenI: " + raw);

        TokenInfo tokenInfo = gson.fromJson(raw, TokenInfo.class);

        return tokenInfo;

    }

    public BlockInfo resolveBlockI(String raw) {

        Gson gson = new Gson();

        ArrayList<BlockInfo> blockInfos =
                gson.fromJson(raw, new TypeToken<List<BlockInfo>>(){}.getType());

        return blockInfos.get(0);
    }


}

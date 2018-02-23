package com.example.r4y.myapplication.Network;

/**
 * Created by r4y on 2018/2/22.
 */

import com.example.r4y.myapplication.Misc.BlockInfo;
import com.example.r4y.myapplication.Misc.TokenInfo;
import com.google.gson.Gson;

public class CJson {

    private static final String TAG = CJson.class.getSimpleName();

    public CJson() {
    }


    //json数据为数组使用这种方式获取，即地址有多条数据

    public TokenInfo resolveTokenI(String raw) {

        Gson gson = new Gson();

        return gson.fromJson(raw, TokenInfo.class);

    }

    public BlockInfo resolveBlockI(String raw) {

        Gson gson = new Gson();

        return gson.fromJson(raw, BlockInfo.class);
    }
}

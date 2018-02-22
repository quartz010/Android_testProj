package com.example.r4y.myapplication.Network;

/**
 * Created by r4y on 2018/2/22.
 */
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CJson {

    public  CJson() {}

    public jsonResolve(String raw) {

        Gson gson = new Gson();

        ArrayList<int> showInformation =
                gson.fromJson(raw, new TypeToken<List<ShowInformation>>(){}.getType());
        //json数据为数组使用这种方式获取，即地址有多条数据
    }
}

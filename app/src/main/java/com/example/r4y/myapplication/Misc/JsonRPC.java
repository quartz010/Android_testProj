package com.example.r4y.myapplication.Misc;

import java.util.List;

/**
 * Created by r4y on 2018/2/24.
 */

public class JsonRPC {

    /**
     * jsonrpc : 2.0
     * method : eth_getBalance
     * params : ["0x407d73d8a49eeb85d32cf465507dd71d507100c1","latest"]
     * id : 1
     */

    private String jsonrpc;
    private String method;
    private int id;
    private List<String> params;

    public String getJsonrpc() {
        return jsonrpc;
    }

    public void setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }
}

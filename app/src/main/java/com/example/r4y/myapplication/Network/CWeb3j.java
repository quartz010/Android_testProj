package com.example.r4y.myapplication.Network;

/**
 * Created by r4y on 2018/2/24.
 */

import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jFactory;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;

public class CWeb3j {

    private Web3j web3;

    public CWeb3j() {
        web3 = Web3jFactory.build(new HttpService());  // defaults to http://localhost:8545/

    }
    public CWeb3j(String web3Url) {

        web3 = Web3jFactory.build(new HttpService(web3Url));  // defaults to http://localhost:8545/
    }

    public String getBlockNum() {

        return  web3.ethBlockNumber().toString();
    }

    public String getClientVersion() {
        try {
            return web3.web3ClientVersion().send().getWeb3ClientVersion();

        } catch (IOException e) {

            e.printStackTrace();
            return "";
        }


    }
}

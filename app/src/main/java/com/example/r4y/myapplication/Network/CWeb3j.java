package com.example.r4y.myapplication.Network;

/**
 * Created by r4y on 2018/2/24.
 */

import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jFactory;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.admin.AdminFactory;
import org.web3j.protocol.admin.methods.response.PersonalUnlockAccount;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;

import rx.functions.Function;

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

    public  String getBalance(String address) {


        DefaultBlockParameter blockParameter = new DefaultBlockParameter() {
            @Override
            public String getValue() {
                return null;
            }
        };

        try {

            return web3.ethGetBalance(address, blockParameter).send().getBalance().toString();

        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public void unlockAccount() {
        Admin web3j = Admin.class(new HttpService());  // defaults to http://localhost:8545/

        try {

            PersonalUnlockAccount personalUnlockAccount =
                    web3j.personalUnlockAccount("0xee0c2081b34000358b2d620088ab115dacb2f896",
                            "").sendAsync().get();
            if (personalUnlockAccount.accountUnlocked()) {
                // send a transaction
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
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

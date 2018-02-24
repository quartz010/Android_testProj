package com.example.r4y.myapplication;

import org.junit.Test;

/**
 * Created by r4y on 2018/2/24.
 */
import com.example.r4y.myapplication.Network.CWeb3j;

public class Web3jTest {

    private CWeb3j web3j = new CWeb3j();

    @Test
    public void getVersion() throws Exception {

        System.out.println(web3j.getClientVersion());
    }

    @Test
    public  void getBalance() throws Exception {

        String banlance;
        String address = "0x5d6aa4187c1788dc958566248c416e290437efbe";

        System.out.println(web3j.getBalance(address));
    }

    @Test
    public void unlockAccount() throws Exception {

        web3j.unlockAccount();
    }

}

package com.example.r4y.myapplication;

import org.junit.Test;

/**
 * Created by r4y on 2018/2/24.
 */
import com.example.r4y.myapplication.Network.CWeb3j;

public class Web3jTest {

    private CWeb3j web3j = new CWeb3j();

    @Test
    public void RequestTest() throws Exception {

        System.out.println(web3j.getClientVersion());
    }


}

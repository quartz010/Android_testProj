package com.example.r4y.myapplication;

import org.junit.Test;
import org.web3j.protocol.core.methods.response.EthBlock;

import static org.junit.Assert.assertEquals;

/**
 * Created by r4y on 2018/2/24.
 */

import com.example.r4y.myapplication.Misc.BlockInfo;
import com.example.r4y.myapplication.Misc.TokenInfo;
import com.example.r4y.myapplication.Network.CRemoteReq;

public class NetworkTest {

    private  CRemoteReq remoteReq = new CRemoteReq();

    @Test
    public void requestTokenTest() throws Exception {

        TokenInfo tokenInfo = remoteReq.reqToken();

        System.out.println(tokenInfo.getResult());

//        assertEquals(4, res);
    }

    @Test
    public  void  requestBlockTest() throws Exception {
        BlockInfo blockInfo = remoteReq.reqBlock();

        System.out.println(blockInfo.getResult());
    }

}

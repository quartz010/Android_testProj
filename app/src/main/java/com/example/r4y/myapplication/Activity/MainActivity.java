package com.example.r4y.myapplication.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import com.example.r4y.myapplication.Misc.BlockInfo;
import com.example.r4y.myapplication.Misc.TokenInfo;
import com.example.r4y.myapplication.Network.CRemoteReq;
import com.example.r4y.myapplication.R;

import java.sql.Time;
import java.sql.Timestamp;


public class MainActivity extends AppCompatActivity {

    final static int MESSAGE_INFO_GOT = 0;
    final static int MESSAGE_RESULT_ERR = -1;
    private static final String TAG = MainActivity.class.getSimpleName();
    Button b1;
    TextView t1;
    MultiAutoCompleteTextView tv1;
    Button b2;


    Looper looper = Looper.myLooper();
    MyHandler myHandler = new MyHandler(looper);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        t1 = findViewById(R.id.textView);
        tv1 = findViewById(R.id.multiAutoCompleteTextView);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String raw = tv1.getText().toString();
//                Log.i(TAG, "Got Text" + raw);
                tv1.setText("");
            }
        });

        //增加监听事件
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                t1.setText(String.format("%ld ", System.currentTimeMillis()));
                t1.setText(Long.toString(System.currentTimeMillis()));

                new Thread(new requestThread()).start();
            }
        });


    }

    private void httpRequest() {

        CRemoteReq remoteReq = new CRemoteReq();
        //TokenInfo tokenInfo = remoteReq.reqToken();
        BlockInfo blockInfo = remoteReq.reqBlock();

        sendTextMessage(blockInfo.getResult().getBlockMiner());


    }

    private void sendTextMessage(String context) {
        // 设置消息的数据
        Message message = new Message();
        message.obj = context;
        // 设置消息的类型值
        message.what = MESSAGE_INFO_GOT;
        // 发送消息到handler
        myHandler.sendMessage(message);
    }

    class MyHandler extends Handler {

        private MyHandler() {
        }

        private MyHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            // super.handleMessage(msg);
            switch (msg.what) {
                case MESSAGE_INFO_GOT:
                    tv1.append("\n");
                    tv1.append((String) msg.obj);
                    break;
                case MESSAGE_RESULT_ERR:
                    break;
                default:
                    break;
            }
            super.handleMessage(msg);
        }
    }

    public class requestThread implements Runnable {
        @Override
        public void run() {
            httpRequest();
        }
    }


}

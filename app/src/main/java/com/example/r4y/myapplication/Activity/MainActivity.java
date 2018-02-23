package com.example.r4y.myapplication.Activity;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.r4y.myapplication.R;
import com.example.r4y.myapplication.Network.CHttpRequest;
import com.example.r4y.myapplication.Misc.TokenInfo;
import com.example.r4y.myapplication.Misc.BlockInfo;
import com.example.r4y.myapplication.Network.CJson;

public class MainActivity extends AppCompatActivity {

    Button b1;
    TextView t1;
    EditText et1;
    Button b2;

    final static int MESSAGE_INFO_GOT = 0;
    final static int MESSAGE_RESULT_ERR = -1;

    Looper looper = Looper.myLooper();
    MyHandler myHandler = new MyHandler(looper);
    CHttpRequest httpCli = new CHttpRequest();

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        t1 = findViewById(R.id.textView);
        et1 = findViewById(R.id.editText2);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String raw = et1.getText().toString();
              Log.i(TAG, "Got Text" + raw);
            }
        });

        //增加监听事件
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText(System.currentTimeMillis() + "Hello World");
                new Thread(new requestThread()).start();
            }
        });


    }

    class MyHandler extends Handler {

        private MyHandler() {}

        private MyHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            // super.handleMessage(msg);
            switch (msg.what) {
                case MESSAGE_INFO_GOT:
                    et1.setText((String) msg.obj);
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

    private void httpRequest() {

        String tokenUrl = "https://api.etherscan.io/api?module=stats&action=tokensupply&" +
                "contractaddress=0x57d90b64a1a57749b0f932f1a3395792e12e7055&apikey=YourApiKeyToken";
//        String tokenUrl = "https://api.etherscan.io/api?module=block&action=getblockreward&" +
//                "blockno=2165403&apikey=YourApiKeyToken";

        String context = httpCli.httpGetRequest(tokenUrl);
        if (!context.isEmpty()) {
            Log.i("Request", " onResponse() result=" + context);

            CJson json = new CJson();

            TokenInfo tokenInfo = json.resolveTokenI(context);


            sendTextMessage(tokenInfo.getMessage());
        }

    }

    private void sendTextMessage(String context) {
        // 设置消息的数据
        Message message = new Message();
        message.obj = context;
        // 设置消息的类型值
        message.what = MESSAGE_INFO_GOT;
        //4.0 发送消息到handler
        myHandler.sendMessage(message);
    }


}

package com.info.wanggc.learnandroidui;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private int currentColor = 0;

    final int[] colors = new int[] {
            R.color.color1,
            R.color.color2,
            R.color.color3,
            R.color.color4,
            R.color.color5,
            R.color.color6
    };

    final int[] names = new int[] {
            R.id.textView1,
            R.id.textView2,
            R.id.textView3,
            R.id.textView4,
            R.id.textView5,
            R.id.textView6
    };

    TextView[] textViews = new TextView[names.length];

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            if(msg.what == 0x123) {
                for (int i = 0;i<names.length;i++) {
                    textViews[i].setBackgroundResource(colors[(i + currentColor) % names.length]);
                }
                currentColor ++;
            }
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.frame_layout_learn);

        for (int i = 0;i<names.length; i++) {
            textViews[i] = (TextView) findViewById(names[i]);
        }

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0x123);
            }
        },0,200);





//        LinearLayout main = findViewById(R.id.main);
//        DrawView drawView = new DrawView(this);
//        drawView.setMinimumWidth(300);
//        drawView.setMinimumHeight(500);
//        main.addView(drawView);

    }
}

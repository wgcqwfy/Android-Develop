package com.info.wanggc.learnandroidui;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by wanggc on 2017/11/26.
 */

public class BaseAdaptActivity extends Activity {

    private ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_adapt_learn);

        listView = findViewById(R.id.listViewForBaseAdaptTest);
        BaseAdapter baseAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return 40;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                LinearLayout linearLayout = new LinearLayout(BaseAdaptActivity.this);
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                ImageView imageView = new ImageView(BaseAdaptActivity.this);
                imageView.setImageResource(R.drawable.ic_launcher);
                TextView textView = new TextView(BaseAdaptActivity.this);
                textView.setText("第" + (position + 1) + "个列表项");
                textView.setTextSize(20);
                textView.setTextColor(Color.RED);
                linearLayout.addView(imageView);
                linearLayout.addView(textView);
                return linearLayout;
            }
        };
        listView.setAdapter(baseAdapter);
    }
}

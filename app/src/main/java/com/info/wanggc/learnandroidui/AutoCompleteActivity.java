package com.info.wanggc.learnandroidui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.SimpleAdapter;

/**
 * Created by wanggc on 2017/11/26.
 */

public class AutoCompleteActivity extends Activity {

    AutoCompleteTextView actv;
    MultiAutoCompleteTextView mauto;
    // 定义字符串数组，作为提示的文本
    String[] books = new String[]{
            "疯狂Java讲义",
            "疯狂Ajax讲义",
            "疯狂XML讲义",
            "疯狂Workflow讲义"
    };
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autocomplete_textview_learn);
        // 创建一个ArrayAdapter，封装数组
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, books);
        actv = (AutoCompleteTextView)findViewById(R.id.auto);
        // 设置Adapter
        actv.setAdapter(aa);
        mauto = (MultiAutoCompleteTextView)findViewById(R.id.mauto);
        // 设置Adapter
        mauto.setAdapter(aa);
        // 为MultiAutoCompleteTextView设置分隔符
        mauto.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }

}

package com.info.wanggc.learnandroidui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by wanggc on 2017/11/26.
 */

public class SpinnerActivity extends Activity {
    Spinner spinner;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner_learn);
        // 获取界面布局文件中的Spinner组件
        spinner = findViewById(R.id.spinner);
        String[] arr = { "孙悟空", "猪八戒", "唐僧" };
        // 创建ArrayAdapter对象
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice, arr);
        // 为Spinner设置Adapter
        spinner.setAdapter(adapter);
    }
}

package com.info.wanggc.learnandroidui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wanggc on 2017/11/26.
 */

public class SimpleAdaptActivity extends Activity {

    private String[] names = {"李清照","李白","杜甫","杜牧"};

    private String[] descs = {"李清照 簡述","李白簡述","杜甫簡述","杜牧簡述"};

    private int[] imageIds = {
            R.drawable.tiger,
            R.drawable.nongyu,
            R.drawable.qingzhao,
            R.drawable.libai
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_adapt_learn);

        List<Map<String,Object>> lisItems = new ArrayList<>();
        for (int i=0;i<names.length;i++) {
            Map<String,Object> listItem = new HashMap<>();
            listItem.put("header",imageIds[i]);
            listItem.put("personName",names[i]);
            listItem.put("desc",descs[i]);
            lisItems.add(listItem);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,lisItems,R.layout.simple_item,new String[] {"personName","header","desc"},new int[] {R.id.name,R.id.header,R.id.desc});
        ListView listView = findViewById(R.id.myList);
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(names[position] + "被点击了");
            }
        });

        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(names[position] + "被选中了");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                System.out.println("至少要选中一个");
            }
        });
    }
}

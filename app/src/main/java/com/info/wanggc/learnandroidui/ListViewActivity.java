package com.info.wanggc.learnandroidui;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by wanggc on 2017/11/26.
 */

public class ListViewActivity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstancState) {
        super.onCreate(savedInstancState);
//        setContentView(R.layout.list_view_adapt);

//        ListView listView = findViewById(R.id.list1);
        String[] arr1 = {"孫悟空","豬八戒","沙悟淨","唐僧"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,arr1);
        setListAdapter(adapter1);
//  listView.setAdapter(adapter1);




//        ListView listView1 = findViewById(R.id.list2);
//        String[] arr2 = {"Java","C#","Phyon","Linux","Spring","Android"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.checked_item,arr2);
//        listView1.setAdapter(adapter);
    }
}

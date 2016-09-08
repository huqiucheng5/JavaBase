package com.hu.javabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hu.javabase.utils.CollectionUtil;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Map<String,String> map = new HashMap<>();
        map.put("1","zhangsan");
        map.put("2","lisi");
        map.put("3","lisi");
        map.put("4","lisi");
        map.put("5","lisi");
        map.put("6","lisi");
        CollectionUtil.printMapBySet(map);
        CollectionUtil.printMapbyEntry(map);

    }
}

package com.hu.javabase.utils;

import android.util.Log;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by q623407474 on 2016/9/8.
 * 操作集合
 */

public class CollectionUtil {
    private static final String TAG = "CollectionUtil";

    /**
     * 把map中的key取出保存在set中，然后通过key取出map中的值
     * @param map
     */
    public static void printMapBySet(Map map){
        Set<String> ketSet = map.keySet();
        Iterator<String> iterator = ketSet.iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            String value = (String) map.get(key);
            Log.i(TAG,"----key = "+key+",value = "+value);
        }

    }


    public static void printMapbyEntry(Map map){
        Set<Map.Entry<String,String>> entrySet = map.entrySet();
        Iterator<Map.Entry<String,String>> iterator = entrySet.iterator();
        while (iterator.hasNext()){
            Map.Entry<String,String> entry = iterator.next();
            String key = entry.getKey();
            String value = entry.getValue();
            Log.i(TAG,"----key = "+key+",value = "+value);
        }
    }



}

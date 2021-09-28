package com.MapDifferences;


/*
* Hashtable are completely thread safe BUT very slow in performance as only one thread can
*  */


/*HashMaps are not thread safe
can be made synchronized using Collections.synchronizedMap method, can be made thread safe but slower performance
Accept a null key and multiple null values,
Entire map is locked when
*/


/*
* ConcurrentHashMap are faster in performance as they segment the map and multiple threads can read write on multiple threads,
* null key and values are not allowed, provides lock at segment level
* */
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {


    public static void main(String[] args) {

        Map<Integer, String> sync = Collections.synchronizedMap(getMap());

    }

    public static Map<Integer, String> getMap(){
        Map<Integer, String> hMap = new HashMap<Integer, String>();
        hMap.put(1,"Tom");
        hMap.put(2,"Sean");
        hMap.put(3,"Ted");
        hMap.put(4,"Julian");
        hMap.put(5,"Jennifer");
        return hMap;
    }

    public static ConcurrentHashMap<Integer, String> getConcurrentMap(){
        ConcurrentHashMap<Integer, String> hMap = new ConcurrentHashMap<Integer, String>();
        hMap.put(1,"Tom");
        hMap.put(2,"Sean");
        hMap.put(3,"Ted");
        hMap.put(4,"Julian");
        hMap.put(5,"Jennifer");
        return hMap;
    }
}

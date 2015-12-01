package com.util;

import java.util.*;

/**
 * Created by Felix Patzschke on 01.12.2015.
 */
public class PreciseMap<KeyType, ValueType> {

    private ArrayList<KeyType> keys;
    private ArrayList<ValueType> values;
    private int highestIndex;


    public PreciseMap() {
        keys = new ArrayList<>();
        values = new ArrayList<>();
        highestIndex = 0;
    }


    public int size() {
        return highestIndex;
    }

    public boolean isEmpty() {
        return (highestIndex==0);
    }

    public boolean containsKey(KeyType key) {
        return keys.contains(key);
    }

    public boolean containsValue(ValueType value) {
        return values.contains(value);
    }

    public ValueType get(KeyType key) {
        return values.get(keys.indexOf(key));
    }

    public ValueType put(KeyType key, ValueType value) {
        if(keys.contains(key)){
            int i = keys.indexOf(key);
            ValueType previous = values.get(i);
            values.add(i, value);
            return previous;
        }else{
            keys.add(highestIndex+1, key);
            values.add(highestIndex+1, value);
            highestIndex++;
            return null;
        }
    }

    public ValueType remove(KeyType key) {
        int i = keys.indexOf(key);
        ValueType res = values.get(i);
        if(i == highestIndex) {
            keys.remove(i);
            values.remove(i);
        } else {
            keys.add(i, keys.get(highestIndex));
            values.add(i, values.get(highestIndex));
            keys.remove(highestIndex);
            values.remove(highestIndex);
        }
        highestIndex--;
        return res;
    }

    public void clear() {
        keys.clear();
        values.clear();
        highestIndex = 0;
    }

    public List<KeyType> keys() {
        return keys;
    }

    public List<ValueType> values() {
        return values;
    }

}

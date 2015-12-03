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


    /**
     * @return the number of entries currently listed in the Map
     */
    public int size() {
        return highestIndex+1;
    }

    /**
     * @return true, if there are no entries listed in the Map
     */
    public boolean isEmpty() {
        return (highestIndex==0);
    }

    /**
     * @param key The key to be searched for
     * @return true, if the given key is listed in the Map
     */
    public boolean containsKey(KeyType key) {
        return keys.contains(key);
    }

    /**
     * @param value the value to be searched for
     * @return true, if the given Value is listed in the Map
     */
    public boolean containsValue(ValueType value) {
        return values.contains(value);
    }

    /**
     * Fetches a value from the Map
     * @param key the identifying key
     * @return the value, identified by the key
     */
    public ValueType get(KeyType key) {
        return values.get(keys.indexOf(key));
    }

    /**
     * Adds an entry to the Map
     * @param key the identifier
     * @param value the value
     * @return the value, which was formerly associated with the given key, null if it was not defined
     */
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

    /**
     * Removes an entry from the Map
     * @param key the identifier of the entry to be deleted
     * @return the value which was associated with the given key
     */
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

    /**
     * Deletes all entries
     */
    public void clear() {
        keys.clear();
        values.clear();
        highestIndex = 0;
    }

    /**
     * @return A List of all keys listed in the Map
     */
    public List<KeyType> keys() {
        return keys;
    }

    /**
     * @return a List of all values listed in the Map
     */
    public List<ValueType> values() {
        return values;
    }

    /**
     * @return a List of all key-value-pairs listed in the Map
     */
    public List<Map.Entry<KeyType, ValueType>> entries(){
        ArrayList<Map.Entry<KeyType, ValueType>> res = new ArrayList<Map.Entry<KeyType, ValueType>>();
        for(int c=0; c<=highestIndex; c++){
            res.add(c, new PreciseEntry<KeyType, ValueType>(keys.get(c), values.get(c)));
        }
        return res;
    }

}

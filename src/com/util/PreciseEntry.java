package com.util;

import java.util.Map;

/**
 * Created by felix on 03.12.2015.
 */
public class PreciseEntry<KeyType, ValueType> implements Map.Entry<KeyType, ValueType> {

    private KeyType key;
    private ValueType value;


    public PreciseEntry(KeyType key, ValueType value){
        this.key = key;
        this.value = value;
    }


    @Override
    public KeyType getKey() {
        return key;
    }

    @Override
    public ValueType getValue() {
        return value;
    }

    @Override
    public ValueType setValue(ValueType value) {
        ValueType res = this.value;
        this.value = value;
        return res;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof PreciseEntry && ((PreciseEntry) o).key.equals(key) && ((PreciseEntry) o).value.equals(value));
    }

    /**
     * @return Just 0 at the moment
     */
    @Override
    public int hashCode() {
        return 0;
    }
}

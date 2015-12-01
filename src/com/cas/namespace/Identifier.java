package com.cas.namespace;

/**
 * Created by felix on 01.12.2015.
 */
public class Identifier {

    private final String name;


    public Identifier(String name){
        this.name = name;
    }


    @Override
    public int hashCode(){
        int res = Integer.MIN_VALUE;
        // TODO add hash algorithm
        return res;
    }

}

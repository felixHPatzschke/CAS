package com.cas.namespace;

import java.util.ArrayList;

/**
 * Created by felix on 01.12.2015.
 */
public class Identifier {

    private final String name;


    public Identifier(String name){
        this.name = name;
    }


    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Identifier && (name.equals(((Identifier) o).name)));
    }

    @Override
    public String toString() {
        return name;
    }

}

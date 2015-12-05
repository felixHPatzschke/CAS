package com.cas.tree.structures;

import com.cas.tree.Term;

import java.util.ArrayList;

/**
 * Created by felix on 05.12.2015.
 */
public class Set {

    private ArrayList<Term> elements;


    public Set() {

    }


    public boolean contains(Term t) {
        return elements.contains(t);
    }

}

package com.cas.tree.structures;

import com.cas.tree.Term;
import com.cas.tree.parsers.NotCompletelyParsedException;
import com.sun.istack.internal.Nullable;

import java.util.ArrayList;

/**
 * Created by felix on 05.12.2015.
 */
public class Set /* should extend ArrayList<Term> ? */ implements Term {

    private ArrayList<Term> elements;


    public Set() {

    }


    public boolean contains(Term t) {
        return elements.contains(t);
    }

    public int indexOf(Term t) {
        return elements.indexOf(t);
    }

    public int size() {
        return elements.size();
    }

    public Term get(int i) {
        return elements.get(i-1);
    }

    public void add(Term t) {
        elements.add(elements.size(), t);
    }

    public Term remove(Term t) {
        if(contains(t)) {
            return elements.remove(elements.indexOf(t));
        }else {
            return null; // throw a NullPointerException?
        }
    }

    public Term remove(int i) {
        if(i<1) {
            return null; // throw a DimensionError? or NegativeArrayIndexException?
        }else if(i>elements.size()) {
            return null; // throw a DimensionError? or ArrayIndexOutOfBoundsException?
        }else {
            return elements.remove(i-1);
        }
    }

    @Override
    public String getStringRepresentation() {
        String res = "{";
        for(int c=0; c<elements.size(); c++) {
            if(c!=0) {
                res = res + "; ";
            }
            res = res + elements.get(c).getStringRepresentation();
        }
        res = res + "}";
        return res;
    }

    @Override
    public boolean isNumber() throws NotCompletelyParsedException {
        return false;
    }

}

package com.cas.tree.operators;

import com.cas.tree.Operator;
import com.cas.tree.Term;
import com.cas.tree.leaves.Variable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 24/11/15.
 */
public class Product implements Operator {
    Term factor, lowerBound, upperBound;
    Variable counter;

    @Override
    public List<Term> getOperands() {
        ArrayList<Term> res = new ArrayList<>();
        res.add(0, factor);
        res.add(1, counter);
        res.add(2, lowerBound);
        res.add(3, upperBound);
        return res;
    }

    @Override
    public String getLatexRepresentation() {
        return null;
    }

    @Override
    public String getStringRepresentation() {
        return ("product(" + factor.getStringRepresentation() + "; " + counter.getStringRepresentation() + "; " + lowerBound.getStringRepresentation() + "; " + upperBound.getStringRepresentation() + ")");
    }

    @Override
    public boolean isNumber() {
        return false;
    }
}

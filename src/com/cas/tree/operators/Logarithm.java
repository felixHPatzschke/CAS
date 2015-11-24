package com.cas.tree.operators;

import com.cas.tree.Operator;
import com.cas.tree.Term;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 24/11/15.
 */
public class Logarithm implements Operator {
    Term base, arg;

    @Override
    public List<Term> getOperands() {
        ArrayList<Term> res = new ArrayList<>();
        res.add(0, arg);
        res.add(1, base);
        return res;
    }

    @Override
    public String getLatexRepresentation() {
        return null;
    }

    @Override
    public String getStringRepresentation() {
        return ("log(" + arg.getStringRepresentation() + "; " + base.getStringRepresentation() + ")");
    }

    @Override
    public boolean isNumber() {
        return false;
    }
}

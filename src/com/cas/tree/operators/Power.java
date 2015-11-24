package com.cas.tree.operators;

import com.cas.tree.NotCompletelyParsedException;
import com.cas.tree.Operator;
import com.cas.tree.Term;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 24/11/15.
 */
public class Power implements Operator {
    Term base, exponent;

    @Override
    public List<Term> getOperands() {
        ArrayList<Term> res = new ArrayList<>();
        res.add(0, base);
        res.add(1, exponent);
        return res;
    }

    @Override
    public String getLatexRepresentation() {
        return null;
    }

    @Override
    public String getStringRepresentation() {
        return ("((" + base.getStringRepresentation() + ")^(" + exponent.getStringRepresentation() + "))");
    }

    @Override
    public boolean isNumber() throws NotCompletelyParsedException {
        return (base.isNumber() && exponent.isNumber());
    }
}

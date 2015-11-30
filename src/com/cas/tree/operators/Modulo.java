package com.cas.tree.operators;

import com.cas.tree.Operator;
import com.cas.tree.Term;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 24/11/15.
 */
public class Modulo implements Operator {
    Term a,b;

    @Override
    public void setOperands(List<Term> operands) {
        a = operands.get(0);
        b = operands.get(1);
    }

    @Override
    public List<Term> getOperands() {
        ArrayList<Term> res = new ArrayList<>();
        res.add(0, a);
        res.add(1, b);
        return res;
    }

    @Override
    public String getLatexRepresentation() {
        return null;
    }

    @Override
    public String getStringRepresentation() {
        return ("mod(" + a.getStringRepresentation() + "; " + b.getStringRepresentation() + ")");
    }

    @Override
    public boolean isNumber() {
        return false;
    }
}

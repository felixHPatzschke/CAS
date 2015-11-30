package com.cas.tree.operators;

import com.cas.tree.Operator;
import com.cas.tree.Term;
import com.cas.tree.leaves.Variable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 24/11/15.
 */
public class Derivative implements Operator {
    Term t;
    Variable x;

    public Derivative(){}


    @Override
    public void setOperands(List<Term> operands) {
        this.t = operands.get(0);
        this.x = (Variable) operands.get(1);
    }

    @Override
    public List<Term> getOperands() {
        List<Term> ret = new ArrayList<Term>();
        ret.add(0, t);
        ret.add(1, x);

        return ret;
    }

    @Override
    public String getLatexRepresentation() {
        return null;
    }

    @Override
    public String getStringRepresentation() {
        return null;
    }

    @Override
    public boolean isNumber() {
        return false;
    }
}

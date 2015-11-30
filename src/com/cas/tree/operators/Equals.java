package com.cas.tree.operators;

import com.cas.tree.Operator;
import com.cas.tree.Term;

import java.util.List;

/**
 * Created by user on 24/11/15.
 */
public class Equals implements Operator {
    Term leftSide, rightSide;

    public Equals(){}

    @Override
    public void setOperands(List<Term> operands) {
        leftSide = operands.get(0);
        rightSide = operands.get(1);
    }

    @Override
    public List<Term> getOperands() {
        return null;
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

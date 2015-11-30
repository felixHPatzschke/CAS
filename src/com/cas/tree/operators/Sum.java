package com.cas.tree.operators;

import com.cas.tree.Operator;
import com.cas.tree.Term;
import com.cas.tree.leaves.Variable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 24/11/15.
 */
public class Sum implements Operator {
    Term summand, lowerBound, upperBound;
    Variable counter;

    @Override
    public void setOperands(List<Term> operands) {
        summand = operands.get(0);
        counter = (Variable) operands.get(1);
        lowerBound = operands.get(2);
        upperBound = operands.get(3);
    }

    @Override
    public List<Term> getOperands() {
        ArrayList<Term> res = new ArrayList<>();
        res.add(0, summand);
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
        return ("sum(" + summand.getStringRepresentation() + "; " + counter.getStringRepresentation() + "; " + lowerBound.getStringRepresentation() + "; " + upperBound.getStringRepresentation() + ")");
    }

    @Override
    public boolean isNumber() {
        return false;
    }
}

package com.cas.tree.operators;

import com.cas.tree.Operator;
import com.cas.tree.Term;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 24/11/15.
 */
public class Multiplication implements Operator {
    List<Term> args;

    @Override
    public void setOperands(List<Term> operands) {
        args = operands;
    }

    @Override
    public List<Term> getOperands() {
        return args;
    }

    @Override
    public String getLatexRepresentation() {
        return null;
    }

    @Override
    public String getStringRepresentation() {
        String ret = new String();

        boolean firstTerm = true;
        for (Term t : args) {
            if (firstTerm) {
                ret = ret + "(" + t.getStringRepresentation() + ")";
                firstTerm = true;
            } else {
                ret = ret + " * (" + t.getStringRepresentation() + ")";
            }
        }

        return ("(" + ret + ")");
    }

    @Override
    public boolean isNumber() {
        return false;
    }
}

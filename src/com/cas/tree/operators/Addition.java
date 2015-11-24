package com.cas.tree.operators;

import com.cas.tree.NotCompletelyParsedException;
import com.cas.tree.Operator;
import com.cas.tree.Term;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 24/11/15.
 */
public class Addition implements Operator {
    ArrayList<Term> summands;

    Addition(ArrayList<Term> summands) {
        this.summands = summands;
    }

    @Override
    public List<Term> getOperands() {
        return summands;
    }

    @Override
    public String getStringRepresentation() {
        String ret = new String();

        boolean firstTerm = true;
        for (Term t : summands) {
            if (firstTerm) {
                ret = ret + "(" + t.getStringRepresentation() + ")";
                firstTerm = true;
            } else {
                ret = ret + " + (" + t.getStringRepresentation() + ")";
            }
        }

        return ret;
    }

    @Override
    public boolean isNumber() throws NotCompletelyParsedException {
        boolean ret = true;
        for (Term t : summands)
        {
            ret = ret && t.isNumber();
        }
        return ret;
    }

    @Override
    public String getLatexRepresentation() {
        return null;
    }
}
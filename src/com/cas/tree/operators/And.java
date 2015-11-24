package com.cas.tree.operators;

import com.cas.tree.NotCompletelyParsedException;
import com.cas.tree.Operator;
import com.cas.tree.Term;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 24/11/15.
 */
public class And implements Operator {

    ArrayList<Term> operands;

    And(ArrayList<Term> operands) {
        this.operands = operands;
    }

    @Override
    public List<Term> getOperands() {
        return operands;
    }

    @Override
    public String getStringRepresentation() {
        String ret = "";

        boolean firstTerm = true;
        for (Term t : operands) {
            if (firstTerm) {
                ret = ret + "(" + t.getStringRepresentation() + ")";
                firstTerm = false;
            } else {
                ret = ret + " and (" + t.getStringRepresentation() + ")";
            }
        }

        return ret;
    }

    @Override
    public boolean isNumber() throws NotCompletelyParsedException {
        boolean ret = true;
        for (Term t : operands)
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

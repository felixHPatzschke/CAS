package com.cas.tree.operators;

import com.cas.tree.parsers.NotCompletelyParsedException;
import com.cas.tree.Operator;
import com.cas.tree.Term;
import com.cas.tree.leaves.Variable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 24/11/15.
 */
public class Limit implements Operator {
    Term operand, towardValue;
    Variable x;

    @Override
    public void setOperands(List<Term> operands) {
        operand = operands.get(0);
        x = (Variable) operands.get(1);
        towardValue = operands.get(2);
    }

    @Override
    public List<Term> getOperands() {
        ArrayList<Term> res = new ArrayList<>();
        res.add(0, operand);
        res.add(1, x);
        res.add(2, towardValue);
        return res;
    }

    @Override
    public String getLatexRepresentation() {
        return null;
    }

    @Override
    public String getStringRepresentation() {
        return ("lim(" + operand.getStringRepresentation() + "; " + x.getStringRepresentation() + "; " + towardValue.getStringRepresentation() + ")");
    }

    @Override
    public boolean isNumber() throws NotCompletelyParsedException {
        return false;
    }
}

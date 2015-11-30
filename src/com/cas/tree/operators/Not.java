package com.cas.tree.operators;

import com.cas.tree.parsers.NotCompletelyParsedException;
import com.cas.tree.Operator;
import com.cas.tree.Term;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 24/11/15.
 */
public class Not implements Operator {
    Term operand;

    public Not() {}

    @Override
    public void setOperands(List<Term> operands) {
        operand = operands.get(0);
    }

    @Override
    public List<Term> getOperands() {
        ArrayList<Term> res = new ArrayList<>();
        res.add(0, operand);
        return res;
    }

    @Override
    public String getLatexRepresentation() {
        return null;
    }

    @Override
    public String getStringRepresentation() {
        return "( ~(" + operand.getStringRepresentation() + "))";
    }

    @Override
    public boolean isNumber() throws NotCompletelyParsedException {
        return operand.isNumber();
    }
}

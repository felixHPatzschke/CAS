package com.cas.tree.parsers;

import com.cas.tree.Operator;
import com.cas.tree.Term;
import com.cas.tree.operators.And;
import com.cas.tree.operators.Not;
import com.cas.tree.operators.Or;
import com.cas.tree.parsers.UnknownOperatorException;
import com.cas.tree.parsers.WrongArgumentNumberException;

import java.util.List;

/**
 * Created by user on 28/11/15.
 */
public class OperatorFactory {
    /**
     * Shouldn't the operator-creating going on within the StringParser? Or are StringParser, LatexParser, *Parser, supposed to use different OperatorFactories?
     */
    static public Term createOperator(String op, List<Term> operands) throws WrongArgumentNumberException, UnknownOperatorException {
        /*
        switch (op)
        {
            case "and":
                return new And(operands);

            case "or":
                return new Or(operands);

            case "not":
                if (operands.size() != 1)
                {
                    throw new WrongArgumentNumberException();
                }
                return new Not(operands.get(0));

            //TODO: implement other ops
        }
        */
        try {
            Operator res = StringParser.operatorMap.get(op).newInstance();
            res.setOperands(operands);
            return res;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        throw new UnknownOperatorException();
    }
}

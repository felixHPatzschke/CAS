package com.cas.tree.parsers;

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
    static public Term createOperator(String op, List<Term> operands) throws WrongArgumentNumberException, UnknownOperatorException {
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

        throw new UnknownOperatorException();
    }
}

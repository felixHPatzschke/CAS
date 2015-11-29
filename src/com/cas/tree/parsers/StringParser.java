package com.cas.tree.parsers;

import com.cas.tree.Parsed;
import com.cas.tree.Term;
import com.cas.tree.Unparsed;
import com.cas.tree.trans.StringInput;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 25/11/15.
 */
public class StringParser implements TermParser {

    ArrayList<String> operators = new ArrayList<String>();

    public StringParser() {
        operators.add(0, "and");
        operators.add(1, "or");
        operators.add(2, "~");

        operators.add(3, "<");
        operators.add(4, "<=");
        operators.add(5, ">");
        operators.add(6, ">=");
        operators.add(7, "=");

        operators.add(8, "+");
        operators.add(9, "*");
        operators.add(10, "/");
    }

    @Override
    public Term parse(Unparsed term) throws ParserException {

        String inp = term.getStringRepresentation();

        inp.replaceAll("-", "-1*");

        if (inp.length() == 0) {
            throw new ParserException();
        }

        inp.replaceAll("\\s+", "");

        while (inp.startsWith("(")) {
            if (inp.endsWith(")")) {
                inp = inp.substring(1, inp.length() - 2);
            } else {
                throw new ParserBracketException();
            }
        }

        for (String op : operators) {
            if (inp.contains(op)) {
                List<String> operands = new ArrayList<String>();
                operands.add("");
                int opChar = 0;
                int bracketCounter = 0;

                for (Character c : inp.toCharArray()) {
                    if (c == '(') {
                        bracketCounter += 1;
                    } else if (c == ')') {
                        bracketCounter -= 1;
                    }

                    if (bracketCounter < 0) {
                        throw new ParserBracketException();
                    }

                    if ((c == op.charAt(opChar)) && (bracketCounter == 0)) {
                        if (opChar + 1 != op.length()) {
                            opChar += 1;
                        } else {
                            operands.add("");
                        }
                    } else {
                        opChar = 0;
                        operands.get(operands.size() - 1).concat(String.valueOf(c));
                    }
                }

                if (op == "~") {
                    operands.remove(0);
                }

                List<Term> terms = new ArrayList<Term>();
                for (String o : operands) {
                    terms.add(parse(new StringInput(o)));
                }

                return OperatorFactory.createOperator(op, terms);
            }
        }

        //TODO: parse functions


        return null;
    }
}

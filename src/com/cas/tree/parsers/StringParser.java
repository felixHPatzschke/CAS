package com.cas.tree.parsers;

import com.cas.tree.Parsed;
import com.cas.tree.Term;
import com.cas.tree.Unparsed;
import com.cas.tree.operators.Addition;
import com.cas.tree.trans.StringInput;

import java.util.ArrayList;

/**
 * Created by user on 25/11/15.
 */
public class StringParser implements TermParser {

    @Override
    public Parsed parse(Unparsed term) {
        if(term.getStringRepresentation().contains("+"))
        {
            String[] operators = term.getStringRepresentation().split("\\+");
            ArrayList<Term> summands = new ArrayList<Term>();
            for(String summand : operators)
            {
                summands.add(parse(new StringInput(summand)));
            }
            return new Addition(summands);
        }

        return null;
    }
}

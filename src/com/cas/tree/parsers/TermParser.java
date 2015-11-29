package com.cas.tree.parsers;

import com.cas.tree.Term;
import com.cas.tree.Unparsed;

/**
 * Created by user on 25/11/15.
 */
public interface TermParser {
    public Term parse(Unparsed term) throws ParserException;
}

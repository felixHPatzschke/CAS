package com.cas.tree.trans;

import com.cas.tree.parsers.NotCompletelyParsedException;
import com.cas.tree.Unparsed;

/**
 * Created by user on 24/11/15.
 */
public class StringInput implements Unparsed {
    String term;

    public StringInput(String term) {
        this.term = term;
    }

    @Override
    public String getStringRepresentation() {
        return term;
    }

    @Override
    public boolean isNumber() throws NotCompletelyParsedException {
        throw new NotCompletelyParsedException();
    }
}

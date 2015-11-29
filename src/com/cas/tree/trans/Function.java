package com.cas.tree.trans;

import com.cas.tree.parsers.NotCompletelyParsedException;
import com.cas.tree.Unparsed;

/**
 * Created by user on 24/11/15.
 */
public class Function implements Unparsed {
    @Override
    public String getStringRepresentation() {
        return null;
    }

    @Override
    public boolean isNumber() throws NotCompletelyParsedException {
        throw new NotCompletelyParsedException();
    }

}

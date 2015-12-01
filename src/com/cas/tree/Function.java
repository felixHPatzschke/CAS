package com.cas.tree;

import com.cas.namespace.Identifier;
import com.cas.namespace.LocalNamespace;
import com.cas.tree.parsers.NotCompletelyParsedException;
import java.util.ArrayList;

/**
 * Created by felix on 01.12.2015.
 */
public class Function implements Term {

    LocalNamespace namespace;
    Identifier name;
    ArrayList<Term> args;
    Term definition;


    @Override
    public String getStringRepresentation() {
        return name.toString();
    }

    @Override
    public boolean isNumber() throws NotCompletelyParsedException {
        return false;
    }

}

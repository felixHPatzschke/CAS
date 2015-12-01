package com.cas.namespace;

import com.cas.tree.Term;
import com.cas.tree.leaves.Variable;

import java.util.Map;

/**
 * Created by felix on 01.12.2015.
 */
public class LocalNamespace extends AbstractNamespace{

    Map<Identifier, Variable> variables;
    // Map<Identifier, Term> functions;
    // Map<Identifier, Term> terms;


    @Override
    public void add(Identifier id, Class<? extends Term> value) {

    }

    @Override
    public Class<? extends Term> get(Identifier id) {
        return null;
    }

}

package com.cas.namespace;

import com.cas.tree.Term;

import java.util.HashMap;

/**
 * Created by felix on 01.12.2015.
 */
public abstract class AbstractNamespace {

    protected HashMap<Identifier, Term> variables;


    public AbstractNamespace(){
        variables = new HashMap<>();
    }


    public void add(Identifier id, Term value) {
        variables.put(id, value);
    }
    public void add(String id, Term value) {
        add(new Identifier(id), value);
    }
    public Term get(Identifier id) {
        return variables.get(id);
    }
    public Term get(String id) {
        return get(new Identifier(id));
    }

}

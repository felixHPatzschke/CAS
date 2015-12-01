package com.cas.namespace;

import com.cas.tree.Term;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by felix on 01.12.2015.
 */
public abstract class AbstractNamespace implements Namespace {

    protected HashMap<Identifier, Term> variables;


    public AbstractNamespace(){
        variables = new HashMap<>();
    }


    @Override
    public void add(Identifier id, Term value) {
        variables.put(id, value);
    }

    @Override
    public void add(String id, Term value) {
        add(new Identifier(id), value);
    }

    @Override
    public Term get(Identifier id) {
        return variables.get(id);
    }

    @Override
    public Term get(String id) {
        return get(new Identifier(id));
    }

    @Override
    public void remove(Identifier id) {
        variables.remove(id);
    }

    @Override
    public void remove(String id) {
        remove(new Identifier(id));
    }

    @Override
    public boolean containsIdentifier(Identifier id) {
        return variables.containsKey(id);
    }

    @Override
    public boolean containsIdentifier(String id) {
        return containsIdentifier(new Identifier(id));
    }

    @Override
    public boolean isEmpty() {
        return variables.isEmpty();
    }

    @Override
    public void clear() {
        variables.clear();
    }

}

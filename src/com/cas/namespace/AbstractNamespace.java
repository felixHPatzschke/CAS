package com.cas.namespace;

import com.cas.tree.Term;
import com.util.PreciseMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by felix on 01.12.2015.
 */
public abstract class AbstractNamespace implements Namespace {

    protected PreciseMap<Identifier, Term> variables;


    public AbstractNamespace(){
        variables = new PreciseMap<>();
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
    public void removeDefinition(Identifier id) {
        variables.put(id, null);
    }

    @Override
    public void removeDefinition(String id) {
        removeDefinition(new Identifier(id));
    }

    @Override
    public List<Identifier> getDefined() {
        ArrayList<Identifier> res = new ArrayList<>();
        int i=0;
        for(int c=0; c<variables.size(); c++) {
            if(variables.get(variables.keys().get(c)) != null) {
                res.add(i, variables.keys().get(c));
                i++;
            }
        }
        return res;
    }

    @Override
    public List<Identifier> getUndefined() {
        ArrayList<Identifier> res = new ArrayList<>();
        int i=0;
        for(int c=0; c<variables.size(); c++) {
            if(variables.get(variables.keys().get(c)) == null) {
                res.add(i, variables.keys().get(c));
                i++;
            }
        }
        return res;
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

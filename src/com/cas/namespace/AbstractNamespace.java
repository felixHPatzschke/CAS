package com.cas.namespace;

import com.cas.tree.Term;
import com.cas.tree.leaves.Variable;

import java.util.Map;

/**
 * Created by felix on 01.12.2015.
 */
public abstract class AbstractNamespace {

    public abstract void add(Identifier id, Class<? extends Term> value);
    public void add(String id, Class<? extends Term> value) {
        add(new Identifier(id), value);
    }
    public abstract Class<? extends Term> get(Identifier id);
    public Class<? extends Term> get(String id) {
        return get(new Identifier(id));
    }

}

package com.cas.namespace;

import com.cas.tree.Function;
import com.cas.tree.Term;
import com.cas.tree.leaves.Variable;

import java.util.Map;

/**
 * Created by felix on 01.12.2015.
 */
public class GlobalNamespace extends AbstractNamespace {

    public GlobalNamespace() {
        super();
    }


    public boolean isFunction(Identifier id) {
        return (variables.get(id) instanceof Function);
    }

    public boolean isTermOrVariable(Identifier id) {
        return !isFunction(id);
    }

}

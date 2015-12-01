package com.cas.namespace;

import com.cas.tree.Term;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by Felix Patzschke on 01.12.2015.
 */
public interface Namespace {

    void add(Identifier id, Term value);
    void add(String id, Term value);
    Term get(Identifier id);
    Term get(String id);
    void remove(Identifier id);
    void remove(String id);
    boolean containsIdentifier(Identifier id);
    boolean containsIdentifier(String id);

    boolean isEmpty();
    void clear();

}

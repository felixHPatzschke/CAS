package com.cas.namespace;

import com.cas.tree.Term;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Felix Patzschke on 01.12.2015.
 */
public interface Namespace {

    /**
     * Adds an entry to the Namespace
     * @param id The variable's Identifier
     * @param value The variable's definition
     */
    void add(Identifier id, Term value);

    /**
     * Adds an entry to the Namespace
     * @param id The String representation of the variable's Identifier
     * @param value The variable's definition
     */
    void add(String id, Term value);

    /**
     * Fetches the given variable's definition
     * @param id The Identifier of the requested variable
     * @return the definition of the identified variable
     */
    Term get(Identifier id);

    /**
     * Fetches the given variable's definition
     * @param id The String representation of the Identifier of the requested variable
     * @return the definition of the identified variable
     */
    Term get(String id);

    /**
     * Removes a variable from the Namespace
     * @param id The Identifier of the variable being deleted
     */
    void remove(Identifier id);

    /**
     * Removes a variable from the Namespace
     * @param id The String representation of the Identifier of the variable being deleted
     */
    void remove(String id);

    /**
     * Checks whether the Namespace contains a variable with the given Identifier
     * @param id The Identifier to be checked for
     * @return true if the Namespace contains a variable with the given Identifier, otherwise false
     */
    boolean containsIdentifier(Identifier id);

    /**
     * Checks whether the Namespace contains a variable with the given Identifier
     * @param id The String representation of the Identifier to be checked for
     * @return true if the Namespace contains a variable with the given Identifier, otherwise false
     */
    boolean containsIdentifier(String id);

    /**
     * Removes the definition from an entry in the Namespace, but keeps the Identifier reserved
     * @param id The Identifier
     */
    void removeDefinition(Identifier id);

    /**
     * Removes the definition from an entry in the Namespace, but keeps the Identifier reserved
     * @param id The Identifier's String representation
     */
    void removeDefinition(String id);

    /**
     * @return a List of all Identifiers in the Namespace to which a definition is available
     */
    List<Identifier> getDefined();

    /**
     * @return a List of all Identifiers in the Namespace which are declared, but not defined
     */
    List<Identifier> getUndefined();

    /**
     * @return true if there are no variables listed in the Namespace, otherwise false
     */
    boolean isEmpty();

    /**
     * Removes all entries from the Namespace
     */
    void clear();

}

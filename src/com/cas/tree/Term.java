package com.cas.tree;


/**
 * Created by user on 24/11/15.
 */
public interface Term {
    String getStringRepresentation();
    boolean isNumber() throws NotCompletelyParsedException;
}

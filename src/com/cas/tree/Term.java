package com.cas.tree;


import com.cas.tree.parsers.NotCompletelyParsedException;

/**
 * Created by user on 24/11/15.
 */
public interface Term {
    String getStringRepresentation();
    boolean isNumber() throws NotCompletelyParsedException;
}

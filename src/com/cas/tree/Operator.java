package com.cas.tree;

import java.util.List;

/**
 * Created by user on 24/11/15.
 */
public interface Operator extends Parsed {
    List<Term> getOperands();
}

package com.cas.tree.structures;

import com.cas.tree.Term;

import java.util.ArrayList;

/**
 * Created by felix on 08.12.2015.
 */
public class Tensor<T extends Term> {

    public interface Order {
        int SCALAR = 0,
            VECTOR = 1,
            MATRIX = 2;
    }

    protected final int ORDER;
    protected final int[] DIM;
    private ArrayList<T> values;


    public Tensor(int order, int... dim) throws DimensionError {
        if(order != dim.length) {
            throw new DimensionError("Created Tensor of order " + order + " with " + dim.length + " dimension arguments.");
        }
        ORDER = order;
        DIM = dim.clone();
        int d = 1;
        for(int c=0; c<order; c++) {
            d *= DIM[c];
        }
        values = new ArrayList<>(d);
    }


}

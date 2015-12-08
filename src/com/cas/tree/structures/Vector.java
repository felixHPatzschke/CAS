package com.cas.tree.structures;

import com.cas.tree.Term;
import com.cas.tree.parsers.NotCompletelyParsedException;

import java.util.ArrayList;

/**
 * Created by felix on 06.12.2015.
 */
public class Vector<Q extends Term> implements Term {

    ArrayList<Q> values;


    public Vector(int dim) {
        values = new ArrayList<>(dim);
    }


    private void checkDimensionCompatibility(int i) throws DimensionError {
        if(i<=0) {
            throw new DimensionError("Vector indices must be positive.");
        }else if(i>values.size()) {
            throw new DimensionError("Vector index out of bounds: " + i);
        }
    }

    public void set(int i, Q value) throws DimensionError {
        checkDimensionCompatibility(i);
        values.add(i-1, value);
    }

    public Term get(int i) throws DimensionError {
        checkDimensionCompatibility(i);
        return values.get(i-1);
    }

    @Override
    public String getStringRepresentation() {
        String res = "[";
        for(int c=0; c<values.size(); c++) {
            if(c!=0) {
                res = res + "; ";
            }
            res = res + values.get(c).getStringRepresentation();
        }
        res = res + "]";
        return res;
    }

    @Override
    public boolean isNumber() throws NotCompletelyParsedException {
        return false;
    }
}

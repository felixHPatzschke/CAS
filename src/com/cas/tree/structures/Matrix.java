package com.cas.tree.structures;

import com.cas.tree.Term;
import com.util.Log;

/**
 * Created by felix on 05.12.2015.
 */
public class Matrix{

    public final int rows, columns;
    private Term[][] values;


    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        values = new Term[rows][columns];
    }


    private boolean checkIndexValidity(int i, int j) throws DimensionError {
        if(i<1) {
            throw new DimensionError("Matrix indices must be positive.");
        }else if(i>rows) {
            throw new DimensionError("Overflow: i cannot be larger than " + rows);
        }else if(j<1) {
            throw new DimensionError("Matrix indices must be positive.");
        }else if(j>columns) {
            throw new DimensionError("Overflow: j cannot be larger than " + columns);
        }else {
            return true;
        }
    }

    public void set(int i, int j, Term value) throws DimensionError{
        checkIndexValidity(i, j);
        values[i][j] = value;
    }

    public Term get(int i, int j) throws DimensionError {
        checkIndexValidity(i, j);
        return values[i][j];
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Matrix){
            if(((Matrix) o).rows == rows && ((Matrix) o).columns==columns) {
                for(int i=1; i<=rows; i++) {
                    for(int j=1; j<=columns; j++) {
                        try {
                            if(((Matrix) o).get(i,j) != get(i,j)) {
                                return false;
                            }
                        } catch (DimensionError dimensionError) {
                            // TODO: include Logging here
                            return false;
                        }
                    }
                }
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

}

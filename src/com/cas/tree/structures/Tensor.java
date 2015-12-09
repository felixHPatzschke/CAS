package com.cas.tree.structures;

import com.cas.tree.Term;
import com.cas.tree.parsers.NotCompletelyParsedException;

import java.util.ArrayList;

/**
 * Created by felix on 08.12.2015.
 */
public class Tensor<T extends Term> implements Term, Structure {

    public interface Order {
        int SCALAR = 0,
            VECTOR = 1,
            MATRIX = 2;
    }

    protected final int ORDER;
    protected final int[] DIM;
    private ArrayList<T> values;


    public Tensor(int... dim) {
        ORDER = dim.length;
        DIM = dim.clone();
        int d = 1;
        for(int c=0; c<ORDER; c++) {
            d *= DIM[c];
        }
        values = new ArrayList<>(d);
    }


    public int getOrder() {
        return ORDER;
    }

    public int[] getDimension() {
        return DIM.clone();
    }

    public boolean checkIndexDimensionValidity(int... i) throws DimensionError {
        if(i.length == ORDER) {
            return true;
        }else if(i.length > ORDER) {
            throw new DimensionError("Invalid index count:\nExpected: " + ORDER + " - ... " + i.length + " or less");
        }
        return false;
    }

    public boolean checkIndexRangeValidity(int... i) throws DimensionError {
        for(int c=0; c<i.length; c++) {
            if(i[c]<=0) {
                throw new DimensionError("Indices must be positive: " + c + ": " + i[c]);
            }else if(i[c] > DIM[c]) {
                throw new DimensionError("Index out of range.");
            }
        }
        return true;
    }

    private int transformIndex(int... i) {
        if(i.length == 0) {
            return 0;
        }
        int res = 0;
        int factor = 1;
        for(int c=0; c<i.length; c++){
            res += factor*(i[c]-1);
            factor *= DIM[c];
        }
        return res;
    }

    public T get(int... i) throws DimensionError {
        if(checkIndexDimensionValidity(i)) {
            if(checkIndexRangeValidity(i)) {
                return values.get(transformIndex(i));
            }
        }else {
            throw new DimensionError("Index dimension incompatible.");
        }
        return null;
    }

    public void set(T v, int... i) throws DimensionError {
        if(checkIndexDimensionValidity(i)) {
            if(checkIndexRangeValidity(i)) {
                values.set(transformIndex(i), v);
            }
        }else {
            throw new DimensionError("Index dimension incompatible.");
        }
    }

    public Tensor<T> getSubTensor(int... i) throws DimensionError {
        if(checkIndexDimensionValidity(i)) {
            if(checkIndexRangeValidity(i)) {
                Tensor<T> res = new Tensor<>();
                res.set(get(i), 1);
                return res;
            }
        }else {
            if(checkIndexRangeValidity(i)) {
                int[] resDim = new int[DIM.length-i.length];
                for(int c=0; c<DIM.length-i.length; c++) {
                    resDim[c] = DIM[c+i.length];
                }
                Tensor<T> res = new Tensor<>(resDim);
                // TODO: !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                return res;
            }
        }
        return null;
    }

    public Tensor<T> plus(Tensor<T> arg) throws IncompatibleDimensionsException {
        return null; // TODO
    }

    public Tensor<T> minus(Tensor<T> arg) throws IncompatibleDimensionsException {
        return null; // TODO
    }

    public Tensor<T> times(Tensor<T> arg) throws IncompatibleDimensionsException {
        return null; // TODO
    }

    public Tensor<T> times(Term t) {
        return null; // TODO
    }

    public T determinant() throws IncompatibleDimensionsException {
        if(ORDER != 2) {
            throw new IncompatibleDimensionsException("Determinant is only defined for second-order-tensors (Matrices)");
        }
        if(DIM[0] != DIM[1]) {
            throw new IncompatibleDimensionsException("Determinant is only defined for square matrices.");
        }
        if(DIM[0] == 1) {
            return values.get(0);
        }else if(DIM[0] == 2) {
            return null; // TODO: (1,1)*(2,2)-(1,2)*(2,1)
        }else {
            return null; // TODO: use subtensors
        }

    }

    public Tensor<T> transpose() throws DimensionError {
        switch(ORDER) {
            case 0:
                return this;    // or throw dimension error
            case 1:
                Tensor<T> res1 = new Tensor<>(DIM[1], DIM[0]);
                for(int c=0; c<DIM[0]; c++) {
                    res1.set(values.get(c), 0, c);
                }
                return res1;
            case 2:
                Tensor<T> res2 = new Tensor<>(DIM[1], DIM[0]);
                for(int x=1; x<=DIM[0]; x++) {
                    for(int y=1; y<=DIM[1]; y++) {
                        res2.set(get(x,y), y,x);
                    }
                }
                return res2;
            default:
                throw new IncompatibleDimensionsException("Transposition is a matrix operation. No Tensors of higher order than two allowed.");
        }
    }

    @Override
    public String getStringRepresentation() {
        String res;
        switch(ORDER) {
            case 0:
                res = values.get(0).getStringRepresentation();
                break;
            case 1:
                res = "[";
                for(int c=0; c<DIM[0]; c++) {
                    if(c!=0) {
                        res = res + "; ";
                    }
                    res = res + values.get(c).getStringRepresentation();
                }
                res = res + "]";
                break;
            default:
                res = "[";
                for(int c=0; c<DIM[0]; c++) {
                    try {
                        res = res + getSubTensor(c).getStringRepresentation();
                    } catch (DimensionError ex) {
                        // TODO: log
                    }
                }
                res = res + "]";
                break;
        }
        return res;
    }

    @Override
    public boolean isNumber() throws NotCompletelyParsedException {
        return false;
    }

}

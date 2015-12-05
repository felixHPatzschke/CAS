package com.cas.tree.structures;

/**
 * Created by felix on 05.12.2015.
 */
public class IncompatibleDimensionsException extends DimensionError{

    public IncompatibleDimensionsException(){
        super();
    }

    public IncompatibleDimensionsException(String message){
        super(message);
    }

}

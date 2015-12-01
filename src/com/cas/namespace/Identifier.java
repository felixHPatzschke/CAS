package com.cas.namespace;

/**
 * Created by felix on 01.12.2015.
 */
public class Identifier {

    private final String name;

    private int[] REDUCED_CHAR_CODE;
    private int MAXIMUM_REDUCED_CHAR_CODE;


    public Identifier(String name){
        this.name = name;
    }

    private final void initCharCodes(){
        REDUCED_CHAR_CODE = new int[256];
        int c;
        for(c=Character.getNumericValue('a'); c<=Character.getNumericValue('z'); c++){
            REDUCED_CHAR_CODE[c] = c-Character.getNumericValue('a');
        }
        for(c=Character.getNumericValue('A'); c<=Character.getNumericValue('Z'); c++){
            REDUCED_CHAR_CODE[c] = c-Character.getNumericValue('A');
        }
    }


    @Override
    public int hashCode(){
        int res = Integer.MIN_VALUE;
        char[] s = name.toCharArray();
        for(int c=0; c<s.length; c++){
            // TODO need list of all acceptable characters in identifiers
            if(Character.isAlphabetic((s[c]))){
                s[c] = Character.toLowerCase(s[c]);
            }
        }
        return res;
    }

    @Override
    public String toString(){
        return name;
    }

}

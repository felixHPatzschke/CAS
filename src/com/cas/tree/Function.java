package com.cas.tree;

import com.cas.namespace.Identifier;
import com.cas.namespace.LocalNamespace;
import com.cas.tree.parsers.NotCompletelyParsedException;
import java.util.ArrayList;

/**
 * Created by felix on 01.12.2015.
 */
public class Function implements Term {

    LocalNamespace namespace;
    Identifier name;
    ArrayList<Term> args;
    Term definition;


    @Override
    public String getStringRepresentation() {
        String res = name.toString();
        res = res + "(";
        for(int c=0; c<args.size(); c++){
            if(c!=0){
                res = res + "; ";
            }
            res = res + args.get(c).getStringRepresentation();
        }
        res = res + ")";
        return res;
    }

    @Override
    public boolean isNumber() throws NotCompletelyParsedException {
        return false;
    }

}

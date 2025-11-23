package org.example.calculeStrategy;

import org.example.calculeInterface.Calcule;

public class Soustration implements Calcule {
    @Override
    public int calcule(int... arg) {
        int différence  = 0;
        for(int soustration = 0; soustration < arg.length; soustration++){
            différence-=arg[soustration];
        }
        return différence;
    }
}

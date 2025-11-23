package org.example.calculeStrategy;

import org.example.calculeInterface.Calcule;

public class Multiplication implements Calcule {
    @Override
    public int calcule(int... arg) {
        int produit = 0;
        for(int multiplication = 0; multiplication < arg.length; multiplication++){
            produit*=arg[multiplication];
        }
        return produit;
    }
}

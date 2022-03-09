package com.daniikercristobal.PrimitivaGrupal.Primitiva;

import com.daniikercristobal.PrimitivaGrupal.Lib.Lib;

public class Bombo {
    private final int[] numeros;
    private int bolas;
    private int min;
    private int max;

    public Bombo(int min, int max){
        bolas = Lib.aleatorioEntero(min,max);
        numeros = new int[bolas];
    }

    public int obtenerBola(){
        int pos = Lib.aleatorioEntero(0,bolas);
        int bolaObtenida = numeros[pos];
        //restamos una bola porque ya hemos quitado ua del array
        bolas--;
        return bolaObtenida;
    }
}

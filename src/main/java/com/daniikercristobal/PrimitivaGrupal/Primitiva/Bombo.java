package com.daniikercristobal.PrimitivaGrupal.Primitiva;

import com.daniikercristobal.PrimitivaGrupal.Lib.Lib;

public class Bombo {
    private final int[] bombo;
    private int bolas;
    private int min;
    private int max;

    public Bombo(int min, int max){
        bolas = max - min + 1;
        this.min = min;
        this.max = max;
        bombo = new int[bolas];
        rellenarBombo();
    }

    public void rellenarBombo() {
        int cont = min;
        for(int i = 0; i < bombo.length; i++) {
            bombo[i] = cont;
            cont++;
        }
        resetear();
    }

    public int obtenerBola(){
        int pos = Lib.aleatorioEntero(0,bolas -1);
        int bolaObtenida = bombo[pos];
        bolas--;
        return bolaObtenida;
    }

    public void resetear() {
        bolas = max - min + 1;
    }
}

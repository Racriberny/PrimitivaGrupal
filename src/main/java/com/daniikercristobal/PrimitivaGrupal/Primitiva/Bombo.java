package com.daniikercristobal.PrimitivaGrupal.Primitiva;
import java.util.Random;

public class Bombo {

    private final int[] bombo;
    private int validos;
    private final Random random;

    public Bombo(int min, int max) {
        random = new Random();
        bombo = new int[max - min + 1];
        for(int i = 0; i < bombo.length; i++) {
            bombo[i] = min;
            min++;
        }
        validos = max - 1;
    }

    public int extraerBola() {
        if(validos >= 0) {
            int indice = random.nextInt(validos - 0 + 1) + 0;
            int numero = bombo[indice];
            bombo[indice] = bombo[validos];
            bombo[validos] = numero;
            validos--;
            return numero;
        }
        return Integer.MIN_VALUE;
    }

    public void reset() {
        validos = bombo.length - 1;
    }
}

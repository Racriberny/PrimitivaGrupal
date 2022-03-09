package com.daniikercristobal.PrimitivaGrupal.Primitiva;

import com.daniikercristobal.PrimitivaGrupal.Lib.Lib;

public class Principal {
    private static final int NUMEROS_JUEGO = 6;

    public Principal() {
        if (menuPrincipal()) {
            System.out.println("Deberás introducir los números con los que deseas jugar");
        } else {
            System.out.println("El programa elegirá por ti de manera aleatoria los números con los que jugarás");
        }
    }

    private int menuModalidadJuego() {
        boolean validado = false;
        int opcion;

        do {
            System.out.println("************************");
            System.out.println("** MODALIDAD DE JUEGO **");
            System.out.println("************************");
            System.out.println("1. Juego único...");
            System.out.println("2. Jugar hasta obtener premio...");
            System.out.println("3. Jugar hasta obtener premio (sin reintegro)...");
            System.out.println("4. Ciclo de 10000 sorteos...");
            System.out.println("5. Jugar hasta obtener premio categoria especial...");
            opcion = Lib.leerInt("Introduce la modalidad de juego a la que deseas jugar: ");
            if (opcion > 0 && opcion < 6) {
                validado = true;
            } else {
                System.out.println("Debes de introducir una opción entre el 1 y el 5");
            }
        } while (!validado);

        return opcion;
    }

    private boolean menuPrincipal() {
        boolean resultado = false, validado = false;
        char opcion;

        do {
            System.out.println("***************");
            System.out.println("** PRIMITIVA **");
            System.out.println("***************");
            opcion = Lib.leerChar("Quieres introducir tú mismo los números con los que deseas jugar? (s/n): ");
            if (opcion == 's') {
                validado = true;
                resultado = true;
            } else if (opcion == 'n') {
                validado = true;
                resultado = false;
            } else {
                System.out.println("Debes introducir 's' o 'n'");
            }
        } while (!validado);

        return resultado;
    }
}

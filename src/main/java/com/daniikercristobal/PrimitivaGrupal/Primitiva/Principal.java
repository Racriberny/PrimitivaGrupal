package com.daniikercristobal.PrimitivaGrupal.Primitiva;

import com.daniikercristobal.PrimitivaGrupal.Lib.Lib;

public class Principal {
    public Principal() {

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

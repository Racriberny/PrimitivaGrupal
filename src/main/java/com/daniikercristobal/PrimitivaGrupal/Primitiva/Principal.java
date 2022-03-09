package com.daniikercristobal.PrimitivaGrupal.Primitiva;

import com.daniikercristobal.PrimitivaGrupal.Lib.Lib;

public class Principal {
    private static final int NUMEROS_JUEGO = 6;

    public Principal() {
        int[] combinacionJugador = new int[NUMEROS_JUEGO];
        int[] combinacionGanador = new int[NUMEROS_JUEGO];
        int reintegro;
        int complementario;
        int opcionPrincipal, opcionModalidad;
        Bombo bomboUno = new Bombo(1, 49);
        Bombo bomboDos = new Bombo(0, 9);

        do {
            for (int i = 0; i < combinacionGanador.length; i++) {
                combinacionGanador[i] = bomboUno.obtenerBola();
            }
            complementario = bomboUno.obtenerBola();
            reintegro = bomboDos.obtenerBola();
            opcionPrincipal = menuPrincipal();
            switch (opcionPrincipal) {
                case 1:
                    System.out.println("Deberás introducir los números con los que deseas jugar");
                    for (int i = 0; i < combinacionJugador.length; i++) {
                        do {
                            combinacionJugador[i] = Lib.leerInt("Introduce el número " + i + 1 + ", debe de estar comprendido entre 1 y 49: ");
                            if (combinacionJugador[i] < 1 && combinacionJugador[i] > 49) {
                                System.out.println("Debes de introducir un número entre el 1 y el 49");
                            }
                        } while (combinacionJugador[i] < 1 && combinacionJugador[i] > 49);
                    }
                    do {
                        opcionModalidad = menuModalidadJuego();
                        switch (opcionModalidad) {
                            case 1:
                                //juegoUnico();
                                break;
                            case 2:
                                //obtenerPremio();
                                break;
                            case 3:
                                //obtenerPremioSinReintegro();
                                break;
                            case 4:
                                //cicloSorteos();
                                break;
                            case 5:
                                //obtenerPremioEspecial();
                                break;
                            case 0:
                                System.out.println("Has salido del menú de modalidades!");
                                break;
                        }
                    } while (opcionModalidad != 0);

                    break;
                case 2:
                    System.out.println("El programa elegirá por ti de manera aleatoria los números con los que jugarás");
                    Lib.rellenarArrayEnteros(combinacionJugador, 1, 49);
                    do {
                        opcionModalidad = menuModalidadJuego();
                        switch (opcionModalidad) {
                            case 1:
                                //juegoUnico();
                                break;
                            case 2:
                                //obtenerPremio();
                                break;
                            case 3:
                                //obtenerPremioSinReintegro();
                                break;
                            case 4:
                                //cicloSorteos();
                                break;
                            case 5:
                                //obtenerPremioEspecial();
                                break;
                            case 0:
                                System.out.println("Has salido del menú de modalidades!");
                                break;
                        }
                    } while (opcionModalidad != 0);
                    break;
                case 0:
                    System.out.println("Has salido del programa!");
                    break;
            }
            bomboUno.resetear();
            bomboDos.resetear();
        } while (opcionPrincipal != 0);
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
            System.out.println("---------------------------------------------------");
            System.out.println("0. Salir del menú de modalidad de juego");
            opcion = Lib.leerInt("Introduce la modalidad de juego a la que deseas jugar: ");
            if (opcion >= 0 && opcion < 6) {
                validado = true;
            } else {
                System.out.println("Debes de introducir una opción entre el 1 y el 5");
            }
        } while (!validado);

        return opcion;
    }

    private int menuPrincipal() {
        boolean validado = false;
        int opcion;

        do {
            System.out.println("**************************");
            System.out.println("******* PRIMITIVA ********");
            System.out.println("**************************");
            System.out.println("1. Introducir números...");
            System.out.println("2. Combinación aleatoria...");
            System.out.println("---------------------------");
            System.out.println("0. Salir del programa");
            opcion = Lib.leerInt("Introduce una opción: ");
            if (opcion >= 0 && opcion < 3) {
                validado = true;
            } else {
                System.out.println("Debes de introducir una opción entre el 0 y el 2");
            }
        } while (!validado);

        return opcion;
    }
}

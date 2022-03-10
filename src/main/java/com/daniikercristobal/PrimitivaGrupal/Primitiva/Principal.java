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
                                juegoUnico(combinacionJugador,combinacionGanador,reintegro,complementario);
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
                    for (int i = 0; i < combinacionGanador.length; i++) {
                        combinacionJugador[i] = bomboUno.obtenerBola();
                    }
                    bomboUno.resetear();
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

    private void juegoUnico(int[] combinacionJugador, int[] combinacionGanador, int reintegro, int complementario) {
        //Numeroa alatorio para compara con el reintegro.
        int numeroAleatorio = Lib.aleatorioEntero(0,9);
        for (int i = 0; i <combinacionJugador.length ; i++) {
            for (int j = 0; j <combinacionGanador.length ; j++) {
                if (combinacionJugador[i] == combinacionGanador[j] && numeroAleatorio == reintegro){
                    System.out.println("Has ganado el " + Premio.ESPECIAL);
                }
            }
        }
    }

    private void obtenerPremio(int[] combinacionJugador, int[] combinacionGanador, int reintegro, int complementario) {
        int numeroAleatorio = Lib.aleatorioEntero(0,9);
        int cont = 0;
        boolean complementarioGanador = false, reintegroGanador = false;

        if (reintegro == numeroAleatorio) {
            reintegroGanador = true;
        }

        for (int i = 0; i < combinacionJugador.length; i++) {
            for (int j = 0; j < combinacionGanador.length; j++) {
                if (combinacionJugador[i] == combinacionGanador[j]) {
                    cont++;
                }
                if (cont == 5 && combinacionJugador[combinacionJugador.length-1] == complementario) {
                    complementarioGanador = true;
                }
            }
        }

        switch (cont) {
            case 0:
                System.out.println("No has obtenido ningún premio, lo sentimos");
                break;
            case 1:
                System.out.println("No has obtenido ningún premio, lo sentimos");
                break;
            case 2:
                System.out.println("No has obtenido ningún premio, lo sentimos");
                break;
            case 3:
                System.out.println("Enhorabuena!! Has obtenido el premio: " + Premio.QUINTO_PREMIO);
                break;
            case 4:
                System.out.println("Enhorabuena!! Has obtenido el premio: " + Premio.CUARTO_PREMIO);
                break;
            case 5:
                if (complementarioGanador == true) {
                    System.out.println("Enhorabuena!! Has obtenido el premio: " + Premio.SEGUNDO_PREMIO);
                } else {
                    System.out.println("Enhorabuena!! Has obtenido el premio: " + Premio.TERCER_PREMIO);
                }
                break;
            case 6:
                if (reintegroGanador == true) {
                    System.out.println("Enhorabuena!! Has obtenido el premio: " + Premio.ESPECIAL);
                } else {
                    System.out.println("Enhorabuena!! Has obtenido el premio: " + Premio.PRIMER_PREMIO);
                }
                break;
        }

        if (cont < 3) {

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

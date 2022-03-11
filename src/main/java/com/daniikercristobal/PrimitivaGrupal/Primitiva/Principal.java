package com.daniikercristobal.PrimitivaGrupal.Primitiva;

import com.daniikercristobal.PrimitivaGrupal.Lib.Lib;

import java.util.Arrays;

public class Principal {
    private static final int NUMEROS_JUEGO = 6;
    private static final Bombo bomboUno = new Bombo(1, 49);
    private static final Bombo bomboDos = new Bombo(0, 9);

    public Principal() {
        int[] combinacionJugador = new int[NUMEROS_JUEGO];
        int[] combinacionGanador = new int[NUMEROS_JUEGO];
        int reintegro;
        int complementario;
        int opcionPrincipal, opcionModalidad;
        //Crea la combinacion ganadora de la primitiva.
        do {
            for (int i = 0; i < combinacionGanador.length; i++) {
                combinacionGanador[i] = bomboUno.extraerBola();
            }
            //Extraerremos un numero complementario.
            complementario = bomboUno.extraerBola();
            //Extraerremos el reintegro.
            reintegro = bomboDos.extraerBola();



            opcionPrincipal = menuPrincipal();
            System.out.println("Tu número de reintegro es: " + reintegro);
            switch (opcionPrincipal) {
                case 1:
                    System.out.println("Deberás introducir los números con los que deseas jugar");
                    //Introducimos los numero del jugador por teclado.
                    for (int i = 0; i < combinacionJugador.length; i++) {
                        boolean validado = false;
                        do {
                            combinacionJugador[i] = Lib.leerInt("Introduce el número " + (i + 1) + ", debe de estar comprendido entre 1 y 49: ");
                            //Comprobacion de que el numero esta entre el 1 y 49
                            if (combinacionJugador[i] < 1 || combinacionJugador[i] > 49) {
                                System.out.println("Debes de introducir un número entre el 1 y el 49");
                            }else {
                                validado = true;
                            }
                        } while (!validado);
                    }
                    System.out.println("Tu combinación es: " + Arrays.toString(combinacionJugador));
                    //Menu del todo el juego.
                    do {
                        opcionModalidad = menuModalidadJuego();
                        switch (opcionModalidad) {
                            case 1:
                                juegoUnico(combinacionJugador,combinacionGanador,reintegro,complementario);
                                break;
                            case 2:
                                obtenerPremio(combinacionJugador, combinacionGanador, reintegro, complementario);
                                break;
                            case 3:
                                obtenerPremioSinReintregro(combinacionJugador, combinacionGanador, complementario);
                                break;
                            case 4:
                                cicloSorteos(combinacionJugador,combinacionGanador,reintegro,complementario);
                                break;
                            case 5:
                                obtenerPremioEspecial(combinacionJugador, combinacionGanador, reintegro, complementario);
                                break;
                            case 0:
                                System.out.println("Has salido del menú de modalidades!");
                                break;
                        }
                    } while (opcionModalidad != 0);

                    break;
                case 2:
                    //Se generaran los  nuemero aleatorio de la primitiva
                    System.out.println("El programa elegirá por ti de manera aleatoria los números con los que jugarás");
                    for (int i = 0; i < combinacionGanador.length; i++) {
                        combinacionJugador[i] = bomboUno.extraerBola();
                    }
                    bomboUno.reset();
                    System.out.println("Tu combinación es: " + Arrays.toString(combinacionJugador));
                    do {
                        opcionModalidad = menuModalidadJuego();

                        switch (opcionModalidad) {
                            case 1:
                                juegoUnico(combinacionJugador,combinacionGanador,reintegro,complementario);
                                break;
                            case 2:
                                obtenerPremio(combinacionJugador, combinacionGanador, reintegro, complementario);
                                break;
                            case 3:
                                obtenerPremioSinReintregro(combinacionJugador, combinacionGanador, complementario);
                                break;
                            case 4:
                                cicloSorteos(combinacionJugador,combinacionGanador,reintegro,complementario);
                                break;
                            case 5:
                                obtenerPremioEspecial(combinacionJugador, combinacionGanador, reintegro, complementario);
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
            bomboUno.reset();
            bomboUno.reset();
        } while (opcionPrincipal != 0);
    }
    /**
     * Este metodo busca comparar la combinacion ganadora con la del jugador y devuelve el premio que te ha tocado o puede estar sin premio.
     * @param combinacionJugador la combinacion introducida con por el teclado.
     * @param combinacionGanador la combinacion ganadora
     * @param reintegro el numero de reintegro que se ha generado aleatoriamente.
     * @param complementario el numero complementario que se ha generado aleatoriamente
     */

    private void juegoUnico(int[] combinacionJugador, int[] combinacionGanador, int reintegro, int complementario) {
        int numeroAleatorio = Lib.aleatorioEntero(0,9);
        int cont = 0;
        boolean complementarioGanador = false;
        boolean reintegroGanador = reintegro == numeroAleatorio;
        System.out.println(reintegro);

        for (int i = 0; i < combinacionJugador.length; i++) {
            for (int k : combinacionGanador) {
                if (combinacionJugador[i] == k) {
                    cont++;
                }
                if (cont == 5 && i == combinacionJugador.length - 1) {
                    for (int value : combinacionJugador) {
                        if (value == complementario) {
                            complementarioGanador = true;
                            break;
                        }
                    }
                }
            }
        }
        switch (cont) {
            case 0:
                System.out.println("No has obtenido ningún premio");
                System.out.println("La combinación ganadora era: " + Arrays.toString(combinacionGanador));
            break;
            case 1:
                System.out.println("No has obtenido ningún premio");
                System.out.println("La combinación ganadora era: " + Arrays.toString(combinacionGanador));
            break;
            case 2:
                System.out.println("No has obtenido ningún premio");
                System.out.println("La combinación ganadora era: " + Arrays.toString(combinacionGanador));
            break;
            case 3:
                System.out.println("Enhorabuena!! Has obtenido el premio: " + Premio.QUINTO_PREMIO);
                System.out.println("La combinación ganadora era: " + Arrays.toString(combinacionGanador));
            break;
            case 4:
                System.out.println("Enhorabuena!! Has obtenido el premio: " + Premio.CUARTO_PREMIO);
                System.out.println("La combinación ganadora era: " + Arrays.toString(combinacionGanador));
            break;
            case 5:
                if (complementarioGanador) {
                    System.out.println("Enhorabuena!! Has obtenido el premio: " + Premio.SEGUNDO_PREMIO);
                    System.out.println("La combinación ganadora era: " + Arrays.toString(combinacionGanador));
                } else {
                    System.out.println("Enhorabuena!! Has obtenido el premio: " + Premio.TERCER_PREMIO);
                    System.out.println("La combinación ganadora era: " + Arrays.toString(combinacionGanador));
                }
            break;
            case 6:
                if (reintegroGanador) {
                    System.out.println("Enhorabuena!! Has obtenido el premio: " + Premio.ESPECIAL);
                    System.out.println("La combinación ganadora era: " + Arrays.toString(combinacionGanador));
                } else {
                    System.out.println("Enhorabuena!! Has obtenido el premio: " + Premio.PRIMER_PREMIO);
                    System.out.println("La combinación ganadora era: " + Arrays.toString(combinacionGanador));
                }
            break;
        }
    }

    /**
     * Este metodo obtiene un premio sin reintegro, no se le pasa el numero del reintegro.
     * @param combinacionJugador la combinacion introducida con por el teclado.
     * @param combinacionGanador la combinacion ganadora aleatoriamente
     * @param complementario el numero complementario que se ha generado aleatoriamente.
     */

    private void obtenerPremioSinReintregro(int[] combinacionJugador, int[] combinacionGanador, int complementario) {
        int cont;
        boolean complementarioGanador;

        do {
            cont = 0;
            complementarioGanador = false;



            for (int i = 0; i < combinacionJugador.length; i++) {
                for (int value : combinacionGanador) {
                    if (combinacionJugador[i] == value) {
                        cont++;
                    }
                    if (cont == 5 && i == combinacionJugador.length - 1) {
                        for (int j : combinacionJugador) {
                            if (j == complementario) {
                                complementarioGanador = true;
                                break;
                            }
                        }
                    }
                }
            }

            switch (cont) {
                case 0:
                    System.out.println("No has obtenido ningún premio, lo sentimos");
                    System.out.println("La combinación ganadora era: " + Arrays.toString(combinacionGanador));
                    break;
                case 1:
                    System.out.println("No has obtenido ningún premio, lo sentimos");
                    System.out.println("La combinación ganadora era: " + Arrays.toString(combinacionGanador));
                    break;
                case 2:
                    System.out.println("No has obtenido ningún premio, lo sentimos");
                    System.out.println("La combinación ganadora era: " + Arrays.toString(combinacionGanador));
                    break;
                case 3:
                    System.out.println("Enhorabuena!! Has obtenido el premio: " + Premio.QUINTO_PREMIO);
                    System.out.println("La combinación ganadora era: " + Arrays.toString(combinacionGanador));
                    break;
                case 4:
                    System.out.println("Enhorabuena!! Has obtenido el premio: " + Premio.CUARTO_PREMIO);
                    System.out.println("La combinación ganadora era: " + Arrays.toString(combinacionGanador));
                    break;
                case 5:
                    if (complementarioGanador == true) {
                        System.out.println("Enhorabuena!! Has obtenido el premio: " + Premio.SEGUNDO_PREMIO);
                        System.out.println("La combinación ganadora era: " + Arrays.toString(combinacionGanador));
                    } else {
                        System.out.println("Enhorabuena!! Has obtenido el premio: " + Premio.TERCER_PREMIO);
                        System.out.println("La combinación ganadora era: " + Arrays.toString(combinacionGanador));
                    }
                    break;
                case 6:
                    System.out.println("Enhorabuena!! Has obtenido el premio: " + Premio.PRIMER_PREMIO);
                    System.out.println("La combinación ganadora era: " + Arrays.toString(combinacionGanador));
                    break;
            }

            if (cont < 3) {
                for (int i = 0; i < combinacionGanador.length; i++) {
                    combinacionGanador[i] = bomboUno.extraerBola();
                }
                bomboUno.reset();
            }
        } while (cont < 3);
    }

    /**
     * Este metodo no para hasta que consigue un premio.
     * @param combinacionJugador la combinacion introducida con por el teclado.
     * @param combinacionGanador la combinacion ganadora aleatoriamente
     * @param reintegro el numero de reintegro que se ha generado aleatoriamente.
     * @param complementario el numero complementario que se ha generado aleatoriamente.
     */

    private void obtenerPremio(int[] combinacionJugador, int[] combinacionGanador, int reintegro, int complementario) {
        int numeroAleatorio;
        int cont;
        boolean complementarioGanador, reintegroGanador;

        do {
            numeroAleatorio = Lib.aleatorioEntero(0,9);
            cont = 0;
            complementarioGanador = false;
            reintegroGanador = false;

            if (reintegro == numeroAleatorio) {
                reintegroGanador = true;
            }

            for (int i = 0; i < combinacionJugador.length; i++) {
                for (int value : combinacionGanador) {
                    if (combinacionJugador[i] == value) {
                        cont++;
                    }
                    if (cont == 5 && i == combinacionJugador.length - 1) {
                        for (int j : combinacionJugador) {
                            if (j == complementario) {
                                complementarioGanador = true;
                                break;
                            }
                        }
                    }
                }
            }

            switch (cont) {
                case 0:
                    System.out.println("No has obtenido ningún premio, lo sentimos");
                    System.out.println("La combinación ganadora era: " + Arrays.toString(combinacionGanador));
                    break;
                case 1:
                    System.out.println("No has obtenido ningún premio, lo sentimos");
                    System.out.println("La combinación ganadora era: " + Arrays.toString(combinacionGanador));
                    break;
                case 2:
                    System.out.println("No has obtenido ningún premio, lo sentimos");
                    System.out.println("La combinación ganadora era: " + Arrays.toString(combinacionGanador));
                    break;
                case 3:
                    System.out.println("Enhorabuena!! Has obtenido el premio: " + Premio.QUINTO_PREMIO);
                    System.out.println("La combinación ganadora era: " + Arrays.toString(combinacionGanador));
                    break;
                case 4:
                    System.out.println("Enhorabuena!! Has obtenido el premio: " + Premio.CUARTO_PREMIO);
                    System.out.println("La combinación ganadora era: " + Arrays.toString(combinacionGanador));
                    break;
                case 5:
                    if (complementarioGanador == true) {
                        System.out.println("Enhorabuena!! Has obtenido el premio: " + Premio.SEGUNDO_PREMIO);
                        System.out.println("La combinación ganadora era: " + Arrays.toString(combinacionGanador));
                    } else {
                        System.out.println("Enhorabuena!! Has obtenido el premio: " + Premio.TERCER_PREMIO);
                        System.out.println("La combinación ganadora era: " + Arrays.toString(combinacionGanador));
                    }
                    break;
                case 6:
                    if (reintegroGanador == true) {
                        System.out.println("Enhorabuena!! Has obtenido el premio: " + Premio.ESPECIAL);
                        System.out.println("La combinación ganadora era: " + Arrays.toString(combinacionGanador));
                    } else {
                        System.out.println("Enhorabuena!! Has obtenido el premio: " + Premio.PRIMER_PREMIO);
                        System.out.println("La combinación ganadora era: " + Arrays.toString(combinacionGanador));
                    }
                    break;
            }

            if (cont < 3) {
                for (int i = 0; i < combinacionGanador.length; i++) {
                    combinacionGanador[i] = bomboUno.extraerBola();
                }
                bomboUno.reset();
            }
        } while (cont < 3);
    }

    /**
     * No para de hacer sorteos hasta que consigue el premio especial.
     * @param combinacionJugador la combinacion introducida con por el teclado.
     * @param combinacionGanador la combinacion ganadora generada aleatoriamente.
     * @param reintegro el numero de reintegro que se ha generado aleatoriamente.
     * @param complementario el numero complementario que se ha generado aleatoriamente.
     */

    private void obtenerPremioEspecial(int[] combinacionJugador, int[] combinacionGanador, int reintegro, int complementario) {
        int numeroAleatorio;
        int cont;
        int contadorSorteos = 0;
        boolean complementarioGanador, reintegroGanador, ganadorPremioEspecial;


        do {
            contadorSorteos++;
            numeroAleatorio = Lib.aleatorioEntero(0,9);
            cont = 0;
            complementarioGanador = false;
            reintegroGanador = false;
            ganadorPremioEspecial = false;

            if (reintegro == numeroAleatorio) {
                reintegroGanador = true;
            }

            for (int i = 0; i < combinacionJugador.length; i++) {
                for (int value : combinacionGanador) {
                    if (combinacionJugador[i] == value) {
                        cont++;
                    }
                    if (cont == 5 && i == combinacionJugador.length - 1) {
                        for (int j : combinacionJugador) {
                            if (j == complementario) {
                                complementarioGanador = true;
                                break;
                            }
                        }
                    }
                }
            }

            if(cont == 6 && reintegroGanador == true){
                ganadorPremioEspecial = true;
            }

            switch (cont) {
                case 0:
                    System.out.println("No has obtenido ningún premio, lo sentimos");
                    System.out.println("La combinación ganadora era: " + Arrays.toString(combinacionGanador));
                    break;
                case 1:
                    System.out.println("No has obtenido ningún premio, lo sentimos");
                    System.out.println("La combinación ganadora era: " + Arrays.toString(combinacionGanador));
                    break;
                case 2:
                    System.out.println("No has obtenido ningún premio, lo sentimos");
                    System.out.println("La combinación ganadora era: " + Arrays.toString(combinacionGanador));
                    break;
                case 3:
                    System.out.println("Enhorabuena!! Has obtenido el premio: " + Premio.QUINTO_PREMIO);
                    System.out.println("La combinación ganadora era: " + Arrays.toString(combinacionGanador));
                    break;
                case 4:
                    System.out.println("Enhorabuena!! Has obtenido el premio: " + Premio.CUARTO_PREMIO);
                    System.out.println("La combinación ganadora era: " + Arrays.toString(combinacionGanador));
                    break;
                case 5:
                    if (complementarioGanador == true) {
                        System.out.println("Enhorabuena!! Has obtenido el premio: " + Premio.SEGUNDO_PREMIO);
                        System.out.println("La combinación ganadora era: " + Arrays.toString(combinacionGanador));
                    } else {
                        System.out.println("Enhorabuena!! Has obtenido el premio: " + Premio.TERCER_PREMIO);
                        System.out.println("La combinación ganadora era: " + Arrays.toString(combinacionGanador));
                    }
                    break;
                case 6:
                    if (reintegroGanador == true) {
                        System.out.println("Enhorabuena!! Has obtenido el premio: " + Premio.ESPECIAL);
                        System.out.println("La combinación ganadora era: " + Arrays.toString(combinacionGanador));
                        System.out.println("El numero de sorteos realizados ha sido de " +contadorSorteos);
                    } else {
                        System.out.println("Enhorabuena!! Has obtenido el premio: " + Premio.PRIMER_PREMIO);
                        System.out.println("La combinación ganadora era: " + Arrays.toString(combinacionGanador));
                    }
                    break;
            }

            if (!ganadorPremioEspecial) {
                for (int i = 0; i < combinacionGanador.length; i++) {
                    combinacionGanador[i] = bomboUno.extraerBola();
                }
                bomboUno.reset();
            }
        } while (!ganadorPremioEspecial);
    }

    /**
     * Este método hace un total de 10000 sorteos y muestra los resultados de cada uno de los premios
     * @param combinacionJugador combinacion de 6 numeros que tiene el jugador
     * @param combinacionGanador combinacion de 6 numeros la cual identifica los numeros ganadores
     * @param reintegro numero de reintegro del jugador, solo se usará cuando la combinacion del jugador tenga 6 coincidencias con los numeros ganadores
     * @param complementario numero complementario ganador, solo se usará si la combinacion del usuario tiene 5 coincidencias con los numeros ganadores
     */

    private void cicloSorteos(int[] combinacionJugador, int[] combinacionGanador, int reintegro, int complementario) {
        final int MAX_SORTEOS = 10000;
        int cont, contQuintoPremio = 0, contCuartoPremio = 0, contTercerPremio = 0, contSegundoPremio = 0, contPrimerPremio = 0, contPremioEspecial = 0;
        int numeroAleatorio;
        boolean complementarioGanador, reintegroGanador;

        for (int i = 0; i < MAX_SORTEOS; i++) {
            numeroAleatorio = Lib.aleatorioEntero(0,9);
            cont = 0;
            complementarioGanador = false;
            reintegroGanador = false;

            if (reintegro == numeroAleatorio) {
                reintegroGanador = true;
            }

            for (int j = 0; j < combinacionJugador.length; j++) {
                for (int value : combinacionGanador) {
                    if (combinacionJugador[j] == value) {
                        cont++;
                    }
                    if (cont == 5 && i == combinacionJugador.length - 1) {
                        for (int k : combinacionJugador) {
                            if (k == complementario) {
                                complementarioGanador = true;
                                break;
                            }
                        }
                    }
                }
            }

            switch (cont) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    contQuintoPremio++;
                    break;
                case 4:
                    contCuartoPremio++;
                    break;
                case 5:
                    if (complementarioGanador == true) {
                        contSegundoPremio++;
                    } else {
                        contTercerPremio++;
                    }
                    break;
                case 6:
                    if (reintegroGanador == true) {
                        contPremioEspecial++;
                    } else {
                        contPrimerPremio++;
                    }
                    break;
            }

            for (int l = 0; l < combinacionGanador.length; l++) {
                combinacionGanador[l] = bomboUno.extraerBola();
            }
            bomboUno.reset();
        }

        System.out.println("**************************************************");
        System.out.println("************* RESULTADOS SORTEOS *****************");
        System.out.println("**************************************************");
        System.out.println("Total premios obtenidos de categoría " + Premio.ESPECIAL + ": " + contPremioEspecial + " premios");
        System.out.println("Total premios obtenidos de categoría " + Premio.PRIMER_PREMIO + ": " + contPrimerPremio + " premios");
        System.out.println("Total premios obtenidos de categoría " + Premio.SEGUNDO_PREMIO + ": " + contSegundoPremio + " premios");
        System.out.println("Total premios obtenidos de categoría " + Premio.TERCER_PREMIO + ": " + contTercerPremio + " premios");
        System.out.println("Total premios obtenidos de categoría " + Premio.CUARTO_PREMIO + ": " + contCuartoPremio + " premios");
        System.out.println("Total premios obtenidos de categoría " + Premio.QUINTO_PREMIO + ": " + contQuintoPremio + " premios");
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

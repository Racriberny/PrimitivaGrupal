package com.daniikercristobal.PrimitivaGrupal.Lib;

import java.util.*;

public class Lib {
    public static final Scanner lector = new Scanner(System.in);
    private static final String ESCAPE = "\u001B[";

    public static int aleatorioEntero(int min, int max) {
        Random rd = new Random();
        int numeroAleatorio = rd.nextInt(max - min + 1) + min;

        return numeroAleatorio;
    }

    public static double aleatorioReal(int min, int max) {
        Random rd = new Random();

        return min + rd.nextDouble() * (max - min);
    }

    public static boolean booleanAleatorio() {
        Random rd = new Random();

        return rd.nextBoolean();
    }

    public static void presionarIntroParaContinuar() {
        System.out.println("Pulsa INTRO para continuar ...");
        lector.nextLine();
    }

    public static void limpiarPantalla() {
        System.out.print(ESCAPE + "H");
        System.out.print(ESCAPE + "2J");
        System.out.flush();
    }

    public static void espera(int x){
        try{
            Thread.sleep(x);
        }catch(InterruptedException ie) {

        }
    }

    public static String leerLinea(String linea){
        boolean validado = false;
        String resultado = "";

        do {
            try {
                System.out.println(linea);
                resultado = lector.nextLine();
                validado = true;
            } catch (InputMismatchException ime) {
                System.out.println("Datos introducidos incorrectos");
            }

            if (isEmpty(resultado)) {
                validado = false;
                System.out.println("Contenido introducido vacío, debes introducir algún dato");
            }
        } while (!validado);

        return resultado;
    }

    public static boolean isEmpty(String linea) {
        return linea.equalsIgnoreCase("");
    }

    public static int leerInt(String linea){
        boolean validado = false;
        int resultado = 0;

        do {
            try {
                System.out.println(linea);
                resultado = Integer.parseInt(lector.nextLine());
                validado = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Debes introducir un entero");
            }
        } while (!validado);

        return resultado;
    }

    public static float leerFloat(String linea){
        boolean validado = false;
        float resultado = 0;

        do {
            try {
                System.out.println(linea);
                resultado = Float.parseFloat(lector.nextLine());
                validado = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Debes introducir un real");
            }
        } while (!validado);

        return resultado;
    }

    public static double leerDouble(String linea){
        boolean validado = false;
        double resultado = 0;

        do {
            try {
                System.out.println(linea);
                resultado = Double.parseDouble(lector.nextLine());
                validado = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Debes introducir un real");
            }
        } while (!validado);

        return resultado;
    }

    public static char leerChar(String linea){
        System.out.println(linea);
        return lector.next().charAt(0);
    }

    public static void rellenarArrayEnteros(int[] array, int min, int max) {
        for(int i = 0; i < array.length; i++) {
            array[i] = aleatorioEntero(min, max);
        }
    }

    public static double[] crearArrayReal(double[] array, int min, int max) {
        for(int i = 0; i < array.length; i++) {
            array[i] = aleatorioReal(min, max);
        }

        return array;
    }

    public static void visualizarArrayEntero(int[] array) {
        System.out.printf("{ ");
        for(int i = 0; i < array.length; i++) {
            System.out.printf("%d ", array[i]);
        }
        System.out.printf("}\n");
    }

    public static void visualizarArrayReales(double[] array) {
        System.out.print("{ ");
        for(int i = 0; i < array.length; i++) {
            System.out.printf("%.2f ", array[i]);
        }
        System.out.println(" }");
    }

    public static void visualizarArrayChar(char[] array) {
        System.out.print("{");
        for(int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println(" }");
    }
}

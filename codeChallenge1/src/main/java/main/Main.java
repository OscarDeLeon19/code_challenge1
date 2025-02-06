package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Ingresa la primera palabra: ");
        Scanner scanner = new Scanner(System.in);
        String palabra1 = "";
        String palabra2 = "";
        palabra1 = scanner.nextLine();

        System.out.println("Ingresa la segunda palabra");
        palabra2 = scanner.nextLine();

        System.out.println("");

        // Palabras iguales no se comprueban
        if (palabra1.equals(palabra2)) {
            System.out.println(true);
        } else {
            System.out.println(getAnagrama(palabra1, palabra2));
        }

    }

    public static boolean getAnagrama(String palabra1, String palabra2) {

        boolean comprobacion = true;
        char[] caracteres1 = palabra1.toCharArray();
        char[] caracteres2 = palabra2.toCharArray();

        ArrayList<Character> comprobacionCaracteres = new ArrayList();

        // Se crea un ArrayList con los caracteres de la segunda palabra
        for (int i = 0; i < caracteres2.length; i++) {
            comprobacionCaracteres.add(caracteres2[i]);
        }

        //Iniciar comprobacion de caracteres
        for (int i = 0; i < caracteres1.length; i++) {
            char caracter = caracteres1[i];
            boolean comprobarCaracter = false;

            
            for (int j = 0; j < comprobacionCaracteres.size(); j++) {
                // Si dos caracteres coinciden, se elimina automaticamente de la lista
                if (caracter == comprobacionCaracteres.get(j)) {
                    comprobacionCaracteres.remove(j);
                    break;
                }
            }
        }

        // Si quedan caracteres en la lista, quiere decir que este no es un anagrama
        if (comprobacionCaracteres.size() > 0) {
            return false;
        } else {
            return true;
        }

    }
}

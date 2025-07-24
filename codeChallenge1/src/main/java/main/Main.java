package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Nada");
        System.out.println("Ingresa la primera palabra: ");
        Scanner scanner = new Scanner(System.in);
        String palabra1 = "";
        String palabra2 = "";
        palabra1 = scanner.nextLine();
        String palabra3 = "";

        System.out.println("Ingresa la segunda palabra");
        palabra2 = scanner.nextLine();

        System.out.println("");

        System.out.println(getAnagramaHash(palabra1, palabra2));;
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
        boolean comprobarCaracter = false;
        for (int i = 0; i < caracteres1.length; i++) {
            char caracter = caracteres1[i];
            comprobarCaracter = false;


            for (int j = 0; j < comprobacionCaracteres.size(); j++) {
                // Si dos caracteres coinciden, se elimina automaticamente de la lista
                if (caracter == comprobacionCaracteres.get(j)) {
                    comprobarCaracter = true;
                    comprobacionCaracteres.remove(j);
                    break;
                }
            }

            if(comprobarCaracter == false) {
                break;
            }
           //System.out.println(comprobacionCaracteres.size());
        }

        // Si quedan caracteres en la lista, quiere decir que este no es un anagrama
        if (comprobacionCaracteres.size() > 0 || comprobarCaracter == false) {
            return false;
        } else {
            return true;
        }

    }

    public static boolean getAnagramaHash(String palabra1, String palabra2){

        if(palabra1.length() != palabra2.length()){
            return false;
        } else {
            if(palabra1.equals(palabra2)){
                return true;
            } else {
                char[] arrayPalabra1 = palabra1.toCharArray();
                char[] arrayPalabra2 = palabra2.toCharArray();

                HashMap<Character, Integer> map1 = new HashMap();
                HashMap<Character, Integer> map2 = new HashMap();

                for (int i = 0; i < arrayPalabra1.length; i++) {
                    if(map1.containsKey(arrayPalabra1[i])){
                        int count = map1.get(arrayPalabra1[i]);
                        map1.put(arrayPalabra1[i], count + 1);
                    } else{
                        map1.put(arrayPalabra1[i], 1);
                    }
                }
                for (int i = 0; i < arrayPalabra2.length; i++) {
                    if(map2.containsKey(arrayPalabra2[i])){
                        int count = map2.get(arrayPalabra2[i]);
                        map2.put(arrayPalabra2[i], count + 1);
                    } else {
                        map2.put(arrayPalabra2[i], 1);
                    }
                }

                if(map1.equals(map2)){
                    return true;
                } else {
                    return false;
                }
            }
        }

    }
}

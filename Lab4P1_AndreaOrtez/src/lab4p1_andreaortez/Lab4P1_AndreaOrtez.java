package lab4p1_andreaortez;

import java.util.Scanner;

public class Lab4P1_AndreaOrtez {

    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;
        do {
            System.out.println("-- MENU --");
            System.out.println("1-> Sumador binario");
            System.out.println("2-> Contains");
            System.out.println("3-> Alpha");
            System.out.println("4-> Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1: {
                    System.out.println();
                    System.out.println("-- SUMADOR BINARIO EN PROCESO --");
                    System.out.print("Ingrese el primer numero: ");
                    String num1 = leer.next();
                    System.out.print("Ingrese el segundo numero: ");
                    String num2 = leer.next();
                    System.out.println();

                    for (int i = 0; i < num1.length(); i++) {
                        char a = num1.charAt(i);

                        if (a != '0' && a != '1') {
                            System.out.println("El primer número contiene caracteres distintos de '0' y '1'.");
                            System.out.println();
                            break;
                        } else {
                            for (int j = 0; j < num2.length(); j++) {
                                char b = num2.charAt(j);
                                if (b != '0' && b != '1') {
                                    System.out.println("El segundo número contiene caracteres distintos de '0' y '1'.");
                                    System.out.println();
                                    break;
                                } else if (num1.length() != num2.length()) {
                                    System.out.println("Los números deben de tener el mismo número de bits");
                                    System.out.println();
                                    break;
                            }
                        }
                    }
                }
                SumadorBinario(num1, num2);
                break;}
                case 2:{
                    System.out.println();
                    System.out.println("-- CONTAINS EN PROCESO --");
                    System.out.print("Ingrese la primera cadena: ");
                    leer.nextLine();
                    String cad1 = leer.nextLine().toLowerCase();
                    System.out.print("Ingrese la segunda cadena: ");
                    String cad2 = leer.nextLine();
                    System.out.println();
                    
                    if (cad1.length() < cad2.length()) {
                        System.out.println("El tamaño de la segunda cadena no puede ser mayor que el de la primera.");
                        break;
                    }
                    Contains (cad1, cad2);
                break;}
                case 3:{
                    System.out.println();
                    System.out.println("-- ALPHA EN PROCESO --");
                    System.out.print("Ingrese la cadena que desea evaluar: ");
                    String cad = leer.next().toLowerCase();
                    Alpha(cad);
                break;}
            }//Fin switch
        } while (opcion != 4);
    }//Fin main

    public static void SumadorBinario(String num1, String num2) {
        String cad = "";
        char resp = ' ';
        char y = '0';
        for (int i = num1.length() - 1; i >= 0; i--) {
            char a = num1.charAt(i);
            char b = num2.charAt(i);
            if (y == '0') {
                if (a == '0' && b == '0') {
                    cad += 0 + cad;
                    resp = 0;
                } else if (a == '0' && b == '1' || a == '1' && b == '0') {
                    cad = 1 + cad;
                    resp = 1;
                } else if (a == '1' && b == '1') {
                    y = '1';
                    cad = 0 + cad;
                    resp = 0;
                } else {
                    y = '1';
                    cad = 1 + cad;
                    resp = 1;
                }
            } else {
                if (a == '0' && b == '0') {
                    resp = 0;
                    cad=1+cad;
                    y='1';
                } else if (a == '0' && b == '1' || a == '1' && b == '0') {
                    resp = 1;
                    cad=0+cad;
                    y='1';
                } else if (a == '1' && b == '1') {
                    resp = 0;
                    cad=1+cad;
                    y='1';
                } 
            }
        }
        if(y=='1'){
            cad=1+cad;
        }
        System.out.println("La suma es:" + cad);
        System.out.println();
    }//Fin ejercicio 1

    public static void Contains (String cad1, String cad2){
        String pal="";
        for (int i=0; i<cad2.length(); i++){
            char a = cad2.charAt(i);
           
            for (int j=0; j<cad1.length(); j++) {
                char b = cad1.charAt(j);
                if (i+1<cad2.length() && j+1<cad1.length()){
                    char a1 = cad2.charAt(i+1);
                    char b1 = cad1.charAt(j+1);
                    if (a==b && a1==b1){
                        pal+=b;
                    }
                }else{
                    if (i==cad2.length()-1 && a==b){
                        pal+=b;
                        break;
                    }
                }
            }
        }
        
        if (cad2.equals(pal)){
            System.out.println("La cadena " + cad1 + " contiene a la cadena " + cad2);
            System.out.println();
        }else{
            System.out.println("La cadena " + cad1 + " no contiene a la cadena " + cad2);
            System.out.println();
        }
    }//Fin ejercccio 2
    
    public static void Alpha(String cad) {
        boolean valid=true;
        for (int i = 0; i < cad.length(); i++) {
            char a = cad.charAt(i);
            int valor = (int) a;
            if (valor >= 97 && valor <= 122) {
                valid=true;
            } else {
                System.out.println("La cadena contiene caracteres que no son letras.");
                System.out.println();
                valid=false;
                break;
            }
        }
        if (valid){
            System.out.println("La cadena sólo contiene letras.");
            System.out.println();
        }
    }//Fin ejercicio 3
}//Fin clase


///h
    package org.example;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MonedasMain {
    public MonedasMain() {
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);

        int opcion;
        do {
            try {
                System.out.println("|____________________________________________________________________________________|");
                System.out.println("|^^^^^^^^^   CONVERSIÓN DE MONEDAS    ^^^^^^^^^^^^|");
                System.out.println("|____________________________________________________________________________________|");
                System.out.println("|----------------------------------------------------------|");
                System.out.println("| ---   Ingresa el numero de la ooperacion que desea realizar  ---- |");
                System.out.println("|                                                          |");
                System.out.println("|         Operacion 1: Ingresa la moneda que quieres convertir:      |");
                System.out.println("|                                                          |");
                System.out.println("|         Opcion 0: Salir                 |");
                System.out.println("|                                                          |");
                System.out.println("|----------------------------------------------------------|");
                System.out.println("|--------------|");
                System.out.println("|--- Opción: --| ");
                System.out.println("|--------------|");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 0:
                        System.out.println("|--------//////////////////////////----------|");
                        System.out.println("|-----                                 ------|");
                        System.out.println("|      SALIENDO.......POR FAVOR ESPERE......................      |");
                        System.out.println("|-----                                 ------|");
                        System.out.println("|--------APLICACION FINALIZADA REINICIE PARA VOLVER A EMPEZAR----------|");
                        break;
                    case 1:
                        RealizarConversion.realizarConversion(sc);
                        break;
                    default:
                        System.out.println("La opcion ingresada es incorrecta intente de nuevo.");
                }
            } catch (InputMismatchException var4) {
                System.out.println("ERROR : Opción incorrecta ingresa un número válido.");
                sc.nextLine();
                opcion = -1;
            }
        } while(opcion != 0);

    }
}
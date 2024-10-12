package com.alura.conversordivisas.principal;


import com.alura.conversordivisas.modulos.ConsultarDivisas;
import com.alura.conversordivisas.modulos.Exchange;

import java.io.IOException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsultarDivisas precio = new ConsultarDivisas();
        int opcion = 0;

        while(true){


            System.out.println("""
                    Escribe una opcion:
                    1.-Comenzar con la conversion
                    2.-Salir
                    """);

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor, ingresa un numero valido");
                continue;
            }

            if (opcion == 1){
                try{
                    System.out.println("Escriba la divisa que desea consultar:");
                    var divisa = scanner.nextLine();
                    System.out.println("Escriba la divisa a la que desea hacer la conversion: ");
                    var conversion = scanner.nextLine();
                    System.out.println("Escriba la cantidad a convertir");
                    var valor = Double.valueOf(scanner.nextLine());
                    Exchange consulta = precio.consulta(divisa, conversion, valor);
                    System.out.println(consulta);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else if (opcion == 2) {
                System.out.println("Gracias por usar el programa");
                break;
            } else{
                System.out.println("Opcion no valida. Por favor, ingresa 1 o 2");
            }


        }

    }
}


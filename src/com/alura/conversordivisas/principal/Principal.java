package com.alura.conversordivisas.principal;

import com.alura.conversordivisas.modulos.ConsultarDivisas;
import com.alura.conversordivisas.modulos.Exchange;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsultarDivisas precio = new ConsultarDivisas();
        int opcion = 0;

        while (true) {
            System.out.println("""
                    Escribe una opción:
                    1.- Comenzar con la conversión
                    2.- Salir
                    """);

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor, ingresa un número válido.");
                continue;
            }

            if (opcion == 1) {
                try {
                    System.out.println("Escriba la divisa base (Ej: USD, EUR, etc.):");
                    var divisaBase = scanner.nextLine().toUpperCase();
                    if (divisaBase.isEmpty()) {
                        throw new IllegalArgumentException("Error: La divisa base no puede estar vacía.");
                    }

                    System.out.println("Escriba la cantidad a convertir:");
                    double valor;
                    try {
                        valor = Double.parseDouble(scanner.nextLine());
                        if (valor <= 0) {
                            throw new IllegalArgumentException("Error: El valor debe ser mayor que cero.");
                        }
                    } catch (NumberFormatException e) {
                        throw new InputMismatchException("Error: Por favor, ingresa un número válido para la cantidad.");
                    }


                    Exchange conversionUSD = precio.consulta(divisaBase, "USD", valor);
                    Exchange conversionARS = precio.consulta(divisaBase, "ARS", valor);
                    Exchange conversionCOP = precio.consulta(divisaBase, "COP", valor);


                    System.out.println("\n====== RESULTADO DE LA CONVERSIÓN ======");
                    System.out.printf("Monto en %s: %.2f%n", divisaBase, valor);
                    System.out.printf("Equivalente en Dólares (USD): %.2f%n", conversionUSD.conversion_result());
                    System.out.printf("Equivalente en Pesos Argentinos (ARS): %.2f%n", conversionARS.conversion_result());
                    System.out.printf("Equivalente en Pesos Colombianos (COP): %.2f%n", conversionCOP.conversion_result());
                    System.out.println("========================================\n");

                } catch (IllegalArgumentException | InputMismatchException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println("Error: Ocurrió un problema al procesar la conversión. Por favor, intente de nuevo.");
                }
            } else if (opcion == 2) {
                System.out.println("Gracias por usar el programa");
                break;
            } else {
                System.out.println("Opción no válida. Por favor, ingresa 1 o 2.");
            }
        }
    }
}

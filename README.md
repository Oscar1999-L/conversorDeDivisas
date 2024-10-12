# Conversor de Divisas

Este es un sencillo programa de consola que permite convertir entre diferentes divisas utilizando la API de ExchangeRate.

## ¿Cómo usarlo?

1. Al ejecutar el programa, se te dará la opción de comenzar la conversión o salir del programa.
2. Si eliges convertir, deberás ingresar:
   - La divisa base desde la cual deseas hacer la conversión (por ejemplo, USD, EUR, etc.).
   - La cantidad de dinero que deseas convertir.
3. El programa automáticamente te dará la conversión a tres monedas:
   - Dólar estadounidense (USD)
   - Peso argentino (ARS)
   - Peso colombiano (COP)

## Requisitos

- Tener Java instalado.
- Conexión a Internet, ya que el programa se conecta a una API para obtener las tasas de cambio.

## Instalación

1. Clona este repositorio.
2. Asegúrate de tener las dependencias de Gson configuradas en tu proyecto.
3. Ejecuta la clase principal (`Principal.java`).

## Manejo de errores

- Si ingresas una divisa inválida o la cantidad es incorrecta, el programa te notificará y te pedirá que ingreses los datos nuevamente.
- Si hay problemas con la API, se mostrará un mensaje de error.

## Ejemplo de uso

```bash
Escribe una opción:
1.- Comenzar con la conversión
2.- Salir
1
Escriba la divisa base (Ej: USD, EUR, etc.):
USD
Escriba la cantidad a convertir:
100

====== RESULTADO DE LA CONVERSIÓN ======
Monto en USD: 100.00
Equivalente en Dólares (USD): 100.00
Equivalente en Pesos Argentinos (ARS): 22,500.50
Equivalente en Pesos Colombianos (COP): 400,000.75
========================================

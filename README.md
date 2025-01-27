# Conversor de Divisas

Un programa en Java que permite convertir entre diferentes divisas utilizando la **API de ExchangeRate**. Esta aplicación interactiva te ayuda a realizar conversiones rápidas y precisas, ideal para aprender sobre manejo de APIs, manipulación de datos JSON, y conceptos básicos de programación en Java.

---

## **Características**

-  **Conversión de divisas**: Permite convertir una cantidad específica desde una moneda base a otras monedas objetivo (USD, ARS, COP).
-  **Integración con la API de ExchangeRate**: Obtiene las tasas de conversión en tiempo real.
-  **Validación de entradas**: Manejo de errores comunes como valores no numéricos, divisas no válidas o campos vacíos.
-  **Resultados detallados**: Muestra el monto ingresado y su equivalencia en las divisas seleccionadas.

---

## **Tecnologías utilizadas**

- **Java 17 o superior**.
- **API de ExchangeRate** para obtener tasas de cambio en tiempo real.
- **Gson** para deserializar datos JSON.

---

## **Estructura del proyecto**

El proyecto está organizado en tres clases principales:

### 1. **Principal**
Ubicada en el paquete `com.alura.conversordivisas.principal`. 
- Contiene la lógica principal del programa, incluyendo:
  - Menú interactivo.
  - Captura de entradas del usuario.
  - Validación de datos.
  - Llamadas al módulo de consulta de divisas.
  - Muestra los resultados al usuario en la consola.

### 2. **ConsultarDivisas**
Ubicada en el paquete `com.alura.conversordivisas.modulos`. 
- Se encarga de realizar la consulta a la **API de ExchangeRate** utilizando `HttpClient` y deserializar la respuesta JSON con **Gson**.
- Devuelve un objeto de tipo `Exchange` con los resultados de la conversión.

### 3. **Exchange**
Ubicada en el paquete `com.alura.conversordivisas.modulos`. 
- Clase tipo `record` que modela la respuesta de la API.
- Atributos:
  - `base_code`: La moneda base utilizada para la conversión.
  - `target_code`: La moneda objetivo de la conversión.
  - `conversion_result`: Resultado numérico de la conversión.

---

## **Cómo usar el programa**

### Requisitos previos
1. Tener instalado **Java 17** o superior.
2. Configurar tu entorno para ejecutar proyectos Java.
3. Asegúrate de tener acceso a Internet, ya que el programa se conecta a la API de ExchangeRate.

### Ejecución
1. Clona el repositorio o descarga el código fuente.
2. Ejecuta el programa principal `Principal.java`.
3. Sigue las instrucciones en la consola:
   - **Opción 1**: Iniciar una conversión.
     - Ingresa el código de la divisa base (por ejemplo: `USD`, `EUR`).
     - Ingresa la cantidad que deseas convertir.
   - El programa mostrará las equivalencias en:
     - Dólares (USD).
     - Pesos Argentinos (ARS).
     - Pesos Colombianos (COP).
   - **Opción 2**: Salir del programa.

---

## **Manejo de errores**

El programa valida múltiples escenarios:
- **Divisas no válidas o vacías**: Notifica al usuario si el código de la moneda no es reconocido.
- **Entradas no numéricas o negativas**: Solicita ingresar valores numéricos mayores a cero.
- **Errores de conexión o respuesta API**: Muestra un mensaje en caso de problemas con la API.

---

## **Ejemplo de uso**

### Entrada del usuario:
```
Escriba la divisa base (Ej: USD, EUR, etc.):
USD
Escriba la cantidad a convertir:
100
```

### Salida del programa:
```
====== RESULTADO DE LA CONVERSIÓN ======
Monto en USD: 100.00
Equivalente en Dólares (USD): 100.00
Equivalente en Pesos Argentinos (ARS): 17,500.00
Equivalente en Pesos Colombianos (COP): 452,000.00
========================================
```

---

## 🔗 **Enlaces útiles**

- [API de ExchangeRate](https://www.exchangerate-api.com/)
- [Gson Library](https://github.com/google/gson)

---

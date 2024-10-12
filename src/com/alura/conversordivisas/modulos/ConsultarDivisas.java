package com.alura.conversordivisas.modulos;

import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarDivisas {
    private String consulta;
    private String conversion;
    private double cantidad;

    public Exchange consulta(String consultaDivisa, String cambioDivisa, double cantidad) {
        this.consulta = consultaDivisa;
        this.conversion = cambioDivisa;
        this.cantidad = cantidad;

        try {
            URI direccion = URI.create(String.format("https://v6.exchangerate-api.com/v6/28418dd93b8db807469a125d/pair/%s/%s/%f", consultaDivisa, cambioDivisa, cantidad));
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("Error: No se pudo obtener una respuesta válida de la API.");
            }

            return new Gson().fromJson(response.body(), Exchange.class);
        } catch (Exception e) {
            throw new RuntimeException("Error: No se encontró la divisa o ocurrió un problema con la consulta.");
        }
    }

    @Override
    public String toString() {
        return String.format("ConsultarDivisas{consulta='%s', conversion='%s', cantidad=%.2f}", consulta, conversion, cantidad);
    }
}

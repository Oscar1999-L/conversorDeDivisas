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

    public Exchange consulta(String consultaDivisa, String cambioDivisa, double cantidad){
        this.consulta = consultaDivisa;
        this.conversion = cambioDivisa;
        this.cantidad = cantidad;

        URI direccion = URI.create(String.format("https://v6.exchangerate-api.com/v6/28418dd93b8db807469a125d/pair/%s/%s/%f", consultaDivisa, cambioDivisa, cantidad));

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Exchange.class);
        } catch (Exception e) {
            throw new RuntimeException("No se encontró la divisa");
        }
    }

    public String getConsulta() {
        return consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

    public String getConversion() {
        return conversion;
    }

    public void setConversion(String conversion) {
        this.conversion = conversion;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "ConsultarDivisas{" +
                "consulta = '" + consulta + '\'' +
                ", conversion = '" + conversion + '\'' +
                ", cantidad= " + cantidad +
                '}';
    }
}


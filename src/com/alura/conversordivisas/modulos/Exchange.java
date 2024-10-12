package com.alura.conversordivisas.modulos;


public record Exchange(String base_code,
                       String target_code,
                       Double conversion_result) {
}


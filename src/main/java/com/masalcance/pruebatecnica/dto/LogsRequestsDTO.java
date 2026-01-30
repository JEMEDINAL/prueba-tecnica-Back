package com.masalcance.pruebatecnica.dto;


import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class LogsRequestsDTO {
    public static final String CONSTANT_NOT_BLANK ="No puede ser null, vacío ni solo espacios.";
    @NotNull(message ="La fecha no puede ser nula" )
    @FutureOrPresent(message = "La Fecha debe ser presente o futura")
    private LocalDate fecha;
    @NotBlank(message = CONSTANT_NOT_BLANK)
    private String metodo;
    @NotBlank(message = CONSTANT_NOT_BLANK)
    private String retornados;

}

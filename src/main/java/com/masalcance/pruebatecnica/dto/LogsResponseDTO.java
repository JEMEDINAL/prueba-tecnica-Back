package com.masalcance.pruebatecnica.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.masalcance.pruebatecnica.entity.RequestLog;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
public class LogsResponseDTO {
    public LogsResponseDTO(RequestLog requestLog) {
        this.id = requestLog.getId();
        this.fecha = requestLog.getFecha();
        this.metodo = requestLog.getMetodo();
        this.retornados = requestLog.getRetornados();
    }

    private Long id;

    private LocalDate fecha;

    private String metodo;
    @JsonProperty("datosRetornados")
    private String retornados;

}

package com.masalcance.pruebatecnica.service;


import com.masalcance.pruebatecnica.dto.LogsRequestsDTO;
import com.masalcance.pruebatecnica.dto.LogsResponseDTO;
import com.masalcance.pruebatecnica.entity.RequestLog;
import com.masalcance.pruebatecnica.exception.logs.LogNotFound;
import com.masalcance.pruebatecnica.exception.logs.ThereAreNotLogs;
import com.masalcance.pruebatecnica.repository.RequestLogRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class LogsService {
    private final RequestLogRepository logRepository;

    public LogsService(RequestLogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public List<LogsResponseDTO> getAllLogs(){
        List<LogsResponseDTO> logsResponseDTOS =logRepository.findAll().stream().map(LogsResponseDTO::new).toList();
        if(logsResponseDTOS.isEmpty()){
            throw new ThereAreNotLogs();
        }
        return logsResponseDTOS;
    }

    public void patchLog(Long id, LogsRequestsDTO logsRequestsDTO){
        RequestLog logDb = logRepository.findById(id).orElseThrow(() -> new LogNotFound(id.toString()));
        logDb.setFecha(logsRequestsDTO.getFecha());
        logDb.setMetodo(logsRequestsDTO.getMetodo());
        logDb.setRetornados(logsRequestsDTO.getRetornados());
        logRepository.save(logDb);
    }

    public void deleteLog(Long id){
        RequestLog logDb = logRepository.findById(id).orElseThrow(() -> new LogNotFound(id.toString()));
        logRepository.delete(logDb);
    }


     public void createLog(String metodo,String retornado){
        logRepository.save(
                RequestLog.builder()
                        .fecha(LocalDate.now())
                        .metodo(metodo)
                        .retornados(retornado)
                        .build()
        );

     }

    public void postLog(LogsRequestsDTO logsRequestsDTO){
        logRepository.save(
                RequestLog.builder()
                        .fecha(logsRequestsDTO.getFecha())
                        .metodo(logsRequestsDTO.getMetodo())
                        .retornados(logsRequestsDTO.getRetornados())
                        .build()
        );

    }
}

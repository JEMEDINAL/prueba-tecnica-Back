package com.masalcance.pruebatecnica.controller;

import com.masalcance.pruebatecnica.dto.ApiResponse;
import com.masalcance.pruebatecnica.dto.LogsRequestsDTO;
import com.masalcance.pruebatecnica.dto.LogsResponseDTO;
import com.masalcance.pruebatecnica.service.LogsService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/logs/")
public class ControllerLogs {
    private static final String PATCH_LOG = "Se actualizado exitosamente el log";
    private static final String DELETE_LOG = "Se ha Eliminado exitosamente el log";
    private static final String POST_LOG = "Se ha creado exitosamente el log";
    private final LogsService logsService;

    public ControllerLogs(LogsService logsService) {
        this.logsService = logsService;
    }

    @GetMapping("get")
    public ResponseEntity<List<LogsResponseDTO>> logs(){
        return ResponseEntity.ok(logsService.getAllLogs());
    }

    @PatchMapping("patch/{id}")
    public ResponseEntity<ApiResponse> patchLog(@Valid @RequestBody LogsRequestsDTO logsRequestsDTO, @PathVariable Long id){
            logsService.patchLog(id, logsRequestsDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ApiResponse(PATCH_LOG,HttpStatus.ACCEPTED.value()));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ApiResponse> deleteLog(@PathVariable Long id){
            logsService.deleteLog(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ApiResponse(DELETE_LOG,HttpStatus.ACCEPTED.value()));
    }

    @PostMapping("post")
    public ResponseEntity<ApiResponse> postLog(@Valid @RequestBody LogsRequestsDTO logsRequestsDTO){
        logsService.postLog(logsRequestsDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(POST_LOG,HttpStatus.CREATED.value()));
    }
}

package com.masalcance.pruebatecnica.exception.logs;

import com.masalcance.pruebatecnica.constant.ErrorMessage;

public class LogNotFound extends RuntimeException{
    public LogNotFound(String id) {
        super(ErrorMessage.LOG_NOT_FOUND.getMessage() + id);
    }
}

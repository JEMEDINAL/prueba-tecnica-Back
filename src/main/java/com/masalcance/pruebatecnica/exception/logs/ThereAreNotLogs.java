package com.masalcance.pruebatecnica.exception.logs;

import com.masalcance.pruebatecnica.constant.ErrorMessage;

public class ThereAreNotLogs extends RuntimeException{
    public ThereAreNotLogs() {
        super(ErrorMessage.THERE_ARE_NO_LOGS.getMessage());
    }
}

package com.masalcance.pruebatecnica.exception.remoteapi;

import com.masalcance.pruebatecnica.constant.ErrorMessage;

public class NoRecordId extends RuntimeException{
    public NoRecordId(String id) {
        super(ErrorMessage.NO_RECORD_ID.getMessage() + id);
    }
}

package com.masalcance.pruebatecnica.exception.remoteapi;

import com.masalcance.pruebatecnica.constant.ErrorMessage;

public class ThereAreNoUsers extends  RuntimeException{
    public ThereAreNoUsers() {
        super(ErrorMessage.THERE_ARE_NO_USERS.getMessage());
    }
}

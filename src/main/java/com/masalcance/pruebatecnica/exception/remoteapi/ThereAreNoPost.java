package com.masalcance.pruebatecnica.exception.remoteapi;

import com.masalcance.pruebatecnica.constant.ErrorMessage;

public class ThereAreNoPost extends RuntimeException{
    public ThereAreNoPost() {
        super(ErrorMessage.THERE_ARE_NO_POSTS.getMessage());
    }
}

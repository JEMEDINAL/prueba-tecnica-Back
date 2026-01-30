package com.masalcance.pruebatecnica.constant;

public enum ErrorMessage {
    THERE_ARE_NO_USERS("No hay registros de usuarios"),
    THERE_ARE_NO_POSTS("No hay registrados Publicaciones"),
    NO_RECORD_ID("No hay registro con este ID: "),
    LOG_NOT_FOUND("No se ha encontrado el registro: "),
    THERE_ARE_NO_LOGS("No hay se han encontrado registros");




    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

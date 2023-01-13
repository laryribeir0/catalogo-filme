package com.filmes.api.exceptions;

public class FilmeException extends RuntimeException {

    private static final long serialVersionUID = -1357913276652480786L;


    private String message;

    public FilmeException(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }


}

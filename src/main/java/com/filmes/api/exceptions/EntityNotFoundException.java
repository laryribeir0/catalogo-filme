package com.filmes.api.exceptions;

public class EntityNotFoundException extends FilmeException {

    private static final long serialVersionUID = 8766566498150867601L;

    public EntityNotFoundException(String message) {
        super(message);

    }

}

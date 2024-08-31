package io.github.pablitohaddad.apipncp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResourceInternalServerException extends RuntimeException{
    public ResourceInternalServerException(String message) {
        super(message);
    }
}

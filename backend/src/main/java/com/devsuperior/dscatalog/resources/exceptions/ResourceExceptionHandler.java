package com.devsuperior.dscatalog.resources.exceptions;

import com.devsuperior.dscatalog.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

//Anotação que permite que essa classe intercepte exceções no controller
@ControllerAdvice
public class ResourceExceptionHandler {

//Diz que tipo de exceção que esse método irá interceptar
//Sempre que ocorrer uma exceção desse tipo em um dos controladores Rest, o tratamento da exceção será direcionado
//para este método
    @ExceptionHandler(ResourceNotFoundException.class)
    //HttpServletRequest tem as informações da requisição
    public ResponseEntity<StandardError> entityNotFound (ResourceNotFoundException e, HttpServletRequest request) {
        StandardError error = new StandardError();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setError("Resource not found");
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}

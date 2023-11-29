package fr.diginamic.hello.controleurs.services.entites.dao.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class RestResponseEntityExceptionHandler {
    @ExceptionHandler({AnomalieException.class})
    protected ResponseEntity<String> transformerAnomalie(AnomalieException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}

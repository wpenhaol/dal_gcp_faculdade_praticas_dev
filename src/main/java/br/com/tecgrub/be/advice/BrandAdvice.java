package br.com.tecgrub.be.advice;

import br.com.tecgrub.be.controller.BrandCarController;
import br.com.tecgrub.be.controller.ClientController;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = BrandCarController.class)
public class BrandAdvice {

    @ExceptionHandler({HttpMessageNotReadableException.class, EmptyResultDataAccessException.class})
    public ResponseEntity<HttpStatus> requestInvalidoNotFondRegister(Exception e) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(HttpStatus.NOT_FOUND);
    }

}
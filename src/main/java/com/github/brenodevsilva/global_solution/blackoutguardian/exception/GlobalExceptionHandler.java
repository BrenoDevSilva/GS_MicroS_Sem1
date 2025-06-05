package com.github.brenodevsilva.global_solution.blackoutguardian.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationErrors(MethodArgumentNotValidException ex) {

        List<String> mensagensDeErro = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(error -> {
                    if (error instanceof FieldError fieldError) {
                        return fieldError.getDefaultMessage();
                    }
                    return "Erro de validação genérico.";
                })
                .toList();

        Map<String, Object> resposta = new LinkedHashMap<>();
        resposta.put("status", 400);
        resposta.put("erros", mensagensDeErro);

        return ResponseEntity.badRequest().body(resposta);
    }
}

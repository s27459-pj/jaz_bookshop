package pw.karczewski;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;
import pw.karczewski.exception.APIException;
import pw.karczewski.openapi.model.Error;
import pw.karczewski.openapi.model.ValidationError;
import pw.karczewski.openapi.model.ValidationErrorErrorsInner;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(APIException.class)
    public ResponseEntity<Error> handleAPIException(APIException e) {
        var body = new Error().message(e.getMessage());
        return ResponseEntity.status(e.getStatus()).body(body);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ValidationError handleConstraintViolationException(ConstraintViolationException e) {
        var errors = e.getConstraintViolations().stream()
                .map((violation) -> new ValidationErrorErrorsInner()
                        .name(violation.getPropertyPath().toString())
                        .message(violation.getMessage()))
                .collect(Collectors.toList());
        return new ValidationError().message("Validation error").errors(errors);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ValidationError handleMetodArgumentNotValidException(MethodArgumentNotValidException e) {
        var errors = e.getFieldErrors().stream()
                .map((error) -> new ValidationErrorErrorsInner()
                        .name(error.getField())
                        .message(error.getDefaultMessage()))
                .collect(Collectors.toList());
        return new ValidationError().message("Validation error").errors(errors);
    }
}

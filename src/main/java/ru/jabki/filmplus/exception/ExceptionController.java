package ru.jabki.filmplus.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.jabki.filmplus.model.ApiError;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiError> handleServiceError(final BadRequestException e) {
        return ResponseEntity.badRequest().body(
                new ApiError(e.getMessage())
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleException(final Exception e) {
        return ResponseEntity.internalServerError().body(
                new ApiError(e.getMessage())
        );
    }
}
package com.arlam.api.exception;

import com.arlam.app.exception.ApiException;
import com.arlam.app.exception.BadRequestException;
import com.arlam.app.exception.NotFoundException;
import com.arlam.app.result.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalRestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<Object> handler(ApiException e, WebRequest request){
        return handleExceptionInternal(e, e.toResponse(), null, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<Object> handler(BadRequestException e, WebRequest request){
        return handleExceptionInternal(e, e.toResponse(), null, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> handler(NotFoundException e, WebRequest request){
        return handleExceptionInternal(e, e.toResponse(), null, HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handler(Exception e, WebRequest request){
        return handleExceptionInternal(e, Response.systemError(), null, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @Override
    protected ResponseEntity<Object> handleBindException(
            BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleExceptionInternal(ex, Response.error(ex.getBindingResult()), headers, status, request);
    }
}

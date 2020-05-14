package com.arlam.app.exception;

import com.arlam.app.constants.ErrorCode;
import com.arlam.app.result.Response;

public class ApiException extends RuntimeException{

    private final ErrorCode errorCode;

    public ApiException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public Response toResponse(){
        return Response.error(errorCode);
    }

    public String getCode(){
        return errorCode.getCode();
    }

}

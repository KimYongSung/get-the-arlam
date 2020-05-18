package com.arlam.app.exception;

import com.arlam.app.constants.ErrorCode;

public abstract class BadRequestException extends ApiException{

    public BadRequestException(ErrorCode errorCode) {
        super(errorCode);
    }
}

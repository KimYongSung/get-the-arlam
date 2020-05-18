package com.arlam.app.exception;

import com.arlam.app.constants.ErrorCode;

public abstract class NotFoundException extends ApiException{

    public NotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}

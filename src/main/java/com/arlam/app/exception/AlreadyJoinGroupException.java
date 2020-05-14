package com.arlam.app.exception;

import com.arlam.app.constants.ErrorCode;

public class AlreadyJoinGroupException extends ApiException{

    public AlreadyJoinGroupException() {
        super(ErrorCode.CD_3001);
    }
}

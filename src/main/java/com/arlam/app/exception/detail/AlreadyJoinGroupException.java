package com.arlam.app.exception.detail;

import com.arlam.app.constants.ErrorCode;
import com.arlam.app.exception.BadRequestException;

public class AlreadyJoinGroupException extends BadRequestException {

    public AlreadyJoinGroupException() {
        super(ErrorCode.CD_3001);
    }
}

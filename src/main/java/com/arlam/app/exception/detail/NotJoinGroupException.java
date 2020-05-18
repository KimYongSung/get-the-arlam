package com.arlam.app.exception.detail;

import com.arlam.app.constants.ErrorCode;
import com.arlam.app.exception.BadRequestException;

public class NotJoinGroupException extends BadRequestException {

    public NotJoinGroupException() {
        super(ErrorCode.CD_3002);
    }
}

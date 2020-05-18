package com.arlam.app.exception.detail;

import com.arlam.app.constants.ErrorCode;
import com.arlam.app.exception.NotFoundException;

public class GroupNotFoundException extends NotFoundException {

    public GroupNotFoundException() {
        super(ErrorCode.CD_2000);
    }
}

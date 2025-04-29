package com.whut.experiment2.exception;

import com.whut.experiment2.exception.BusinessException;

public class UserNotFoundException extends BusinessException{
        public UserNotFoundException() {
            super(404, "该用户不存在");
        }
}

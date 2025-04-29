package com.whut.experiment2.exception;
import com.whut.experiment2.exception.BusinessException;

public class ValidationException extends BusinessException{
    public ValidationException(String message) {
        super(400, message);
    }
}

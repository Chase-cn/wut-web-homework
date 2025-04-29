package com.whut.experiment2.exception;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 基础业务异常父类
 */
@Data                          // 自动生成 getter/setter
@EqualsAndHashCode(callSuper = false)  // 避免父类(RuntimeException)的equals/hashCode影响
public abstract class BusinessException extends RuntimeException{
    private final int errorCode;

    public BusinessException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}

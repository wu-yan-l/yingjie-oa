package com.lyj.common.config.exception;

import com.lyj.common.result.ResultCodeEnum;
import lombok.Data;

@Data
public class LyjException extends RuntimeException{
    private Integer code;
    private String msg;

    public LyjException(Integer code, String message) {
        super(message);
        this.code = code;
        this.msg = message;
    }

    public LyjException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
        this.msg = resultCodeEnum.getMessage();
    }

    @Override
    public String toString() {
        return "LyjException{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}

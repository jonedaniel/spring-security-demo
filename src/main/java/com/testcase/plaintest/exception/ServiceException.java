package com.testcase.plaintest.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ServiceException extends RuntimeException {
    private String code;
    private String desc;

    public ServiceException() {
        this.code = "F000";
        this.desc = "未知异常";
    }

    public String getInfo() {
        return "异常码：" + this.code + " 异常描述：" + this.desc;
    }

    public void setInfo() {
    }
}

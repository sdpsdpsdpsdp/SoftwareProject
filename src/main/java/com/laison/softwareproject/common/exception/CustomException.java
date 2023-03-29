package com.laison.softwareproject.common.exception;

public class CustomException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private Integer errorCode;
    public static final Integer NEED_LOGIN = 401;

    public static CustomException create(String errorMsg) {
        return new CustomException(500, errorMsg);
    }


    public static CustomException create(Integer errorCode, String errorMsg) {
        return new CustomException(errorCode, errorMsg);
    }

    public CustomException(Integer errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
    }


    public Integer getErrorCode() {
        return errorCode;
    }


    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
}

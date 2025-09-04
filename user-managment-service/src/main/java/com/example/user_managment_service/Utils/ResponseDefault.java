package com.example.user_managment_service.Utils;

public class ResponseDefault {

    private String code;
    private String message;
    private Object defaultObj;

    public ResponseDefault(String code, String message, Object defaultObj) {
        this.code = code;
        this.message = message;
        this.defaultObj = defaultObj;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getDefaultObj() {
        return defaultObj;
    }

    public void setDefaultObj(Object defaultObj) {
        this.defaultObj = defaultObj;
    }
}

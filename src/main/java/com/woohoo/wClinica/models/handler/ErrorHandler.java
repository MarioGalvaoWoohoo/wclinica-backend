package com.woohoo.wClinica.models.handler;

public class ErrorHandler {
    
    private String field;
    private String message;

    public ErrorHandler(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return this.field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}

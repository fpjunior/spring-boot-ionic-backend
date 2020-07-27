package com.fpedro.cursomc.resource.exception;

import java.io.Serializable;

public class FieldMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    private String feldName;

    private String message;



    public FieldMessage(){

    }

    public FieldMessage(String feldName, String message) {
        this.feldName = feldName;
        this.message = message;
    }

    public String getFeldName() {
        return feldName;
    }

    public void setFeldName(String feldName) {
        this.feldName = feldName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    
    
}
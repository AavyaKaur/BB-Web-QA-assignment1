package com.selenium.framework.frameworkExceptions;

public class ConfigurationException extends RuntimeException{

    String exceptionMessage;
    String cause;
    public ConfigurationException(String message){
        this.cause = message;

    }
    public String toString(){
        exceptionMessage = "Error in Configuration file.PLs check the file fpr any error/invalid Input";
        exceptionMessage += "Exception occurred due to:"+ this.cause;
        return exceptionMessage;
    }
}

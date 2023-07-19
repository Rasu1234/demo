package org.api.ShoopingApi.exception;

public class InvalidCredentialsException extends RuntimeException {
    @Override
    public String getMessage() {
    	return "Invalide phone number or password";
    	
    }
}

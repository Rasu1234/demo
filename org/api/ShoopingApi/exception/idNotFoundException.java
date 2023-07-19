package org.api.ShoopingApi.exception;

public class idNotFoundException extends RuntimeException {
   public String getMessage() {
	   return "Id is invalide";
   }
}

package com.services.myappointmentmonolithtic.exceptions;

public class NoSuchAdminException extends Exception{
    public NoSuchAdminException() {
        super("Admin wasn't found");
    }

    public NoSuchAdminException(String message) {
        super(message);
    }
}

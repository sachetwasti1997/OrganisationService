package com.sachet.organisationservice.exception;

public class OrganisationAlreadyExist extends RuntimeException{

    private String message;

    public OrganisationAlreadyExist(String message) {
        super(message);
        this.message = message;
    }
}

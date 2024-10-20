package org.suitesquad.likehome.rest;

/**
 * This class contains the response types for the REST API.
 * All these records are to be serialized to JSON. They are not used in the database.
 * <p>
 * There is a sample of each record in the class definition, for testing purposes.
 */
public class ResponseTypes {
    public record SignUpInfo(String email, String name) {}
}

package com.netcracker.devcourses.sd4.service.exceptions;

/**
 * Created by Konstantin on 02.11.16.
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}

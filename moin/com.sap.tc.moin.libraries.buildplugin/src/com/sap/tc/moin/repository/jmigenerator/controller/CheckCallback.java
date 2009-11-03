package com.sap.tc.moin.repository.jmigenerator.controller;

public interface CheckCallback {

    /**
     * This method tells about a check violation.
     * 
     * @param violationItem currently either a
     * {@link DeferredConstraintViolationStatusItem} or a
     * {@link ConsistencyViolation}
     * @param message a message that tells details about the check violation
     */
    public void handleViolation( Object violationItem, String message );
}

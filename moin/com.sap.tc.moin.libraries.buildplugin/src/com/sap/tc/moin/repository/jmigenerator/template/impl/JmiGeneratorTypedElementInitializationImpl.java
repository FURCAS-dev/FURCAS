package com.sap.tc.moin.repository.jmigenerator.template.impl;

import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorTypedElementInitialization;

public class JmiGeneratorTypedElementInitializationImpl implements JmiGeneratorTypedElementInitialization {

    private String initializationCode = null;

    public String getInitializationCode( ) {
        return initializationCode;
    }

    public void setInitializationCode( String initializationCode ) {
        this.initializationCode = initializationCode;
    }
}

package com.sap.tc.moin.repository.jmigenerator.template.impl;

import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorJavadocLine;

public class JmiGeneratorJavadocLineImpl implements JmiGeneratorJavadocLine {

    private String line = ""; //$NON-NLS-1$

    public JmiGeneratorJavadocLineImpl( String aLine ) {

        line = aLine;
    }

    public boolean isEmpty( ) {

        return line.length( ) == 0;
    }

    @Override
    public String toString( ) {

        return line;
    }
}

package com.sap.tc.moin.repository.jmigenerator.template.impl;

import static com.sap.tc.moin.repository.shared.util.SunSystemPropertyKeys.LINE_SEPARATOR;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorJavadoc;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorJavadocLine;

public class JmiGeneratorJavadocImpl implements JmiGeneratorJavadoc {

    private String annotation = ""; //$NON-NLS-1$

    public JmiGeneratorJavadocImpl( String anAnnotation ) {

        annotation = normalizeAnnotation( anAnnotation );
    }

    public List<JmiGeneratorJavadocLine> getDescription( ) {

        if ( annotation.length( ) == 0 ) {
            return new ArrayList<JmiGeneratorJavadocLine>( );
        } else {
            // would split into one single empty line if annotation.length() = 0
            String[] annotationLines = annotation.split( System.getProperty( LINE_SEPARATOR ) );
            List<JmiGeneratorJavadocLine> lines = new ArrayList<JmiGeneratorJavadocLine>( annotationLines.length );
            for ( int i = 0; i < annotationLines.length; i++ ) {
                lines.add( new JmiGeneratorJavadocLineImpl( annotationLines[i] ) );
            }
            return lines;
        }
    }

    private String normalizeAnnotation( String annotation ) {

        String normalizedAnnotation = annotation;
        // replace javadoc specific character sequences
        // don't remove "//" because it is used in URIs, like http://www.sap.com
        normalizedAnnotation = normalizedAnnotation.replace( "*/", "" ); //$NON-NLS-1$ //$NON-NLS-2$
        // replace new line sequence by system line separator for a better split possibility afterwards
        normalizedAnnotation = normalizedAnnotation.replace( "\n", System.getProperty( LINE_SEPARATOR ) ); //$NON-NLS-1$
        return normalizedAnnotation;
    }
}

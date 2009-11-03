package com.sap.tc.moin.xm.generation.core;

import java.util.Collection;

import javax.xml.XMLConstants;

import org.eclipse.xsd.XSDDiagnostic;
import org.eclipse.xsd.XSDDiagnosticSeverity;
import org.eclipse.xsd.XSDSchema;

import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.xm.generation.XmGeneratorException;

/**
 * Validator for an XML schema. It uses the eclipse xsd validator and suppresses
 * some errors of this validator.
 */
final class XsdValidator {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_XM, MoinLocationEnum.MOIN_XM_GEN, XsdValidator.class );


    /** Name {@value} of the partition for the built-in SOAP Encoding XSD model. */
    private final static String SOAP_ENCODING_NAMESPACE = "http://schemas.xmlsoap.org/soap/encoding/"; //$NON-NLS-1$

    XsdValidator( ) {

    }

    // The class XSDDiagnosticSeverity defines higher values for less severe
    // messages. FATAL = 0, INFORMATION = 3. Therefore, in order to keep
    // the code in validate() halfways understandable, we work with the negative
    // values
    // of these constants, which have the natural order.

    private final static int INFORMATION = -XSDDiagnosticSeverity.INFORMATION;

    private final static int ERROR = -XSDDiagnosticSeverity.ERROR;

    /**
     * Validates an XML schema. The method suppresses validator errors.
     * 
     * @param schema XML schema
     * @param ignoreUnresolved indicator whether errors with a key which starts
     * with &quot;_UI_Unresolved&quot; should be ignored
     * @throws XmGeneratorException if the schema is not valid, the message
     * contains the reason
     */
    public void validate( final XSDSchema schema, final boolean ignoreUnresolved ) throws XmGeneratorException {

        schema.validate( );

        final Collection<XSDDiagnostic> diag = schema.getAllDiagnostics( );

        if ( diag != null && !diag.isEmpty( ) ) {
            StringBuilder bu = null;
            boolean isImportFromWww = false;
            int maxSeverity = INFORMATION;

            for ( final XSDDiagnostic dia : diag ) {
                final Relevance relevance = isRelevant( dia, isImportFromWww || ignoreUnresolved );

                if ( relevance != Relevance.IRRELEVANT ) {
                    // The class XSDDiagnosticSeverity defines higher values for
                    // less severe
                    // messages. FATAL = 0, INFORMATION = 3. Therefore, in order
                    // to keep
                    // the following code halfways understandable, we work with
                    // the negative
                    // severity, which has the natural order.
                    final int sev = -dia.getSeverity( ).getValue( );

                    if ( bu == null ) {
                        bu = new StringBuilder( );
                    }

                    bu.append( '\n' );
                    bu.append( dia.getMessage( ) );
                    bu.append( "\tLine: " ); //$NON-NLS-1$
                    bu.append( dia.getLine( ) );
                    bu.append( "\tColumn: " ); //$NON-NLS-1$
                    bu.append( dia.getColumn( ) );

                    if ( sev > maxSeverity ) {
                        maxSeverity = sev;
                    }

                    if ( relevance == Relevance.IMPORT_FROM_WWW ) {
                        isImportFromWww = true;
                    }
                }
            }

            if ( bu != null ) {
                if ( maxSeverity >= ERROR ) {
                    final String msg = bu.toString( );
                    LOGGER.logAndTrace( MoinSeverity.ERROR, XmGenerationMessages.INVALIDXMLSCHEMA, new Object[] { schema.getTargetNamespace( ), msg } );
                    throw new XmGeneratorException( XmGenerationMessages.INVALIDXMLSCHEMA, new Object[] { schema.getTargetNamespace( ), msg } );
                }
            }
        }
        LOGGER.trace( MoinSeverity.DEBUG, "Validation of XML schema with namespace {0} successful", schema.getTargetNamespace( ) ); //$NON-NLS-1$
    }

    private static enum Relevance {
        /** Irrelevant. */
        IRRELEVANT,

        /** Relevant. */
        RELEVANT,

        /** Reference to an XML schema located in the WWW. */
        IMPORT_FROM_WWW;
    }

    private static Relevance isRelevant( final XSDDiagnostic dia, final boolean ignoreUnresolved ) {

        Relevance isRelevant = Relevance.RELEVANT;
        final String key = dia.getKey( );
        final String msg = dia.getMessage( );

        if ( "src-import.0".equals( key ) //$NON-NLS-1$
             && msg.startsWith( "XSD: The location 'http" ) ) { //$NON-NLS-1$
            // schema parser cannot resolve references into the WWW via HTTP
            // proxy
            isRelevant = Relevance.IMPORT_FROM_WWW;
        } else if ( ignoreUnresolved && key.startsWith( "_UI_Unresolved" ) //$NON-NLS-1$
                    && ( msg.contains( "http://" ) || msg.contains( "https://" ) ) ) { //$NON-NLS-1$ //$NON-NLS-2$
            isRelevant = Relevance.IRRELEVANT;
        } else if ( "_UI_UnresolvedAttributeDeclaration_message".equals( key ) //$NON-NLS-1$
                    && ( msg.contains( XMLConstants.XML_NS_URI ) || msg.contains( SOAP_ENCODING_NAMESPACE ) ) || "_UI_UnresolvedTypeDefinition_message".equals( key ) //$NON-NLS-1$
                    && msg.contains( SOAP_ENCODING_NAMESPACE ) ) {
            isRelevant = Relevance.IRRELEVANT;
            // because these attribute declarations are built in
        }

        return isRelevant;
    }

}

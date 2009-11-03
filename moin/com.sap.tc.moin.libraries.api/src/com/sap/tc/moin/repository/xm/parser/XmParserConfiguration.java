package com.sap.tc.moin.repository.xm.parser;

import javax.xml.validation.Schema;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.exception.MoinNullPointerException;


/**
 * Configuration of an XM Parser. Instances of this class can be used in
 * {@link Connection#createModelImporter(XmParserConfiguration)} or in the
 * Custom Parser/Serializer integration strategy (see
 * com.sap.tc.moin.repository.spi.ps.SpiXmParserSerializerConfiguration).
 */
public final class XmParserConfiguration {

    private final XmParserHandler parserHandler;

    private final Schema xmlSchema;

    private final ParserErrorHandler errorHandler;

    /**
     * Constructor.
     * 
     * @param handler parser handler
     * @param aXmlSchema XML schema for the XML documents which should be parsed
     * by the XM Parser, can be <code>null</code>
     * @param aErrorHander error handler, must not be <code>null</code> if
     * <tt>aXmlSchema</tt> is not <code>null</code>
     * @throws NullPointerException if <tt>handler</tt> is <tt>null</tt>
     * @throws IllegalArgumentException if <tt>aXmlSchema</tt> is not
     * <code>null</code> and <tt>aErrorHandler</tt> is <code>null</code>
     */
    private XmParserConfiguration( final XmParserHandler handler, final Schema aXmlSchema, final ParserErrorHandler aErrorHandler ) {

        if ( handler == null ) {
            throw new MoinNullPointerException( "handler" ); //$NON-NLS-1$
        }
        if ( aXmlSchema != null && aErrorHandler == null ) {
            throw new MoinIllegalStateException( XmApiMessages.ERRORHANDLERMISSING );
        }
        this.parserHandler = handler;
        this.xmlSchema = aXmlSchema;
        this.errorHandler = aErrorHandler;
    }

    /**
     * Returns a new parser configuration instance.
     * 
     * @param parserHandler parser handler
     * @param xmlSchema XML schema for the XML documents, can be
     * <code>null</code>; if provided then a validation of the XML document is
     * executed during the parsing; then validation errors are reported to
     * {@link ParserErrorHandler}
     * @param errorHandler error handler especially for the validation, must not
     * be <code>null</code>, if <tt>xmlSchema</tt> is not <code>null</code>;
     * @return parser configuration
     * @throws NullPointerException if <tt>parserHandler</tt> is <tt>null</tt>
     * @throws IllegalArgumentException if <tt>xmlSchema</tt> is not
     * <code>null</code> and <tt>errorHandler</tt> is <code>null</code>
     */
    public static XmParserConfiguration getInstance( final XmParserHandler parserHandler, final Schema xmlSchema, final ParserErrorHandler errorHandler ) {

        return new XmParserConfiguration( parserHandler, xmlSchema, errorHandler );
    }


    /**
     * Returns the parser handler.
     * 
     * @return handler instance, cannot be <code>null</code>
     */
    public XmParserHandler getHandler( ) {

        return this.parserHandler;
    }


    /**
     * Returns the XML schema.
     * 
     * @return XML schema; can be <code>null</code>
     */
    public Schema getXmlSchema( ) {

        return this.xmlSchema;
    }

    /**
     * Returns the error handler.
     * 
     * @return error handler, can be <code>null</code>; cannot be
     * <code>null</code> when XML schema is not <code>null</code>
     */
    public ParserErrorHandler getErrorHandler( ) {

        return this.errorHandler;
    }

}

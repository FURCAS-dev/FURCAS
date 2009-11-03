package com.sap.tc.moin.repository.xm.parser;

import org.xml.sax.SAXParseException;

import com.sap.tc.moin.repository.xm.XmInvalidXmlException;

/**
 * Error handler for the XM Parser. The error handler is mainly used for the
 * validation of XML documents. The interface is very similar to the interface
 * {@link org.xml.sax.ErrorHandler}.
 * <p>
 * If an application of an XM parser needs to implement customized error
 * handling, it must implement this interface. The parser will then report all
 * errors and warnings through this interface.
 * </p>
 * <strong>WARNING:</strong> If an application does <em>not</em> register an
 * ErrorHandler, XML parsing errors will go unreported, except that
 * <em>XmException</em>s will be thrown for fatal errors. In order to detect
 * validity errors, an ErrorHandler that does something with
 * {@link ParserErrorHandler#error()} calls must be registered. </p>
 * <p>
 * Note, the XM parser throws appropriate exceptions for non-XML errors.
 * </p>
 * <p>
 * It is recommended to build sub-classes of {@link ParserErrorHandlerDefault}.
 */
public interface ParserErrorHandler {


    /**
     * Receive notification of a warning.
     * <p>
     * SAX parsers will use this method to report conditions that are not errors
     * or fatal errors as defined by the XML recommendation. The default
     * behavior is to take no action.
     * </p>
     * <p>
     * The SAX parser must continue to provide normal parsing events after
     * invoking this method: it should still be possible for the application to
     * process the document through to the end.
     * </p>
     * <p>
     * Filters may use this method to report other, non-XML warnings as well.
     * </p>
     * 
     * @param exception the warning information encapsulated in a SAX parse
     * exception
     * @exception XmInvalidXmlException if you throw such an exception, then the
     * parsing is stopped
     */
    void warning( SAXParseException exception ) throws XmInvalidXmlException;


    /**
     * Receive notification of a recoverable error.
     * <p>
     * This corresponds to the definition of "error" in section 1.2 of the W3C
     * XML 1.0 Recommendation. For example, a validating parser would use this
     * callback to report the violation of a validity constraint. The default
     * behavior is to take no action.
     * </p>
     * <p>
     * The SAX parser must continue to provide normal parsing events after
     * invoking this method: it should still be possible for the application to
     * process the document through to the end. If the application cannot do so,
     * then the parser should report a fatal error even if the XML
     * recommendation does not require it to do so.
     * </p>
     * <p>
     * Filters may use this method to report other, non-XML errors as well.
     * </p>
     * 
     * @param exception The error information encapsulated in a SAX parse
     * exception.
     * @exception XmInvalidXmlException if you throw such an exception, then the
     * parsing is stopped
     */
    void error( SAXParseException exception ) throws XmInvalidXmlException;


    /**
     * Receive notification of a non-recoverable error.
     * <p>
     * This corresponds to the definition of "fatal error" in section 1.2 of the
     * W3C XML 1.0 Recommendation. For example, a parser would use this callback
     * to report the violation of a well-formedness constraint.
     * </p>
     * <p>
     * The application must assume that the document is unusable after the
     * parser has invoked this method, and should continue (if at all) only for
     * the sake of collecting additional error messages: in fact, SAX parsers
     * are free to stop reporting any other events once this method has been
     * invoked.
     * </p>
     * 
     * @param exception The error information encapsulated in a SAX parse
     * exception.
     * @exception XmInvalidXmlException if you throw such an exception, then the
     * parsing is stopped
     */
    void fatalError( SAXParseException exception ) throws XmInvalidXmlException;


}

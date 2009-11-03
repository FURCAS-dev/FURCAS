package com.sap.tc.moin.repository.test.jmitck;

import com.sap.tc.moin.repository.test.jmitck.javatest.util.I18NResourceBundle;

/**
 * Represents errors in test execution. This exception is to be caught and
 * converted to a return value of a Status instance, set to ERROR, by the top of
 * the test invocation.
 */
public class TestErrorException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Creates a new <code>TestErrorException</code> instance.
     * 
     * @param errorReason description of the test error. Most likely will become
     * the reason argument when a Status of <code>ERROR</code> is created.
     */
    public TestErrorException( String errorReason ) {

        super( errorReason );
    }

    /**
     * Creates a new <code>TestErrorException</code> instance, using a a
     * resource and MessageFormat to create the reason String.
     * 
     * @param i18n the resource bundle to find the reason message
     * @param key tne key to look within the resource for the message.
     */
    public TestErrorException( I18NResourceBundle i18n, String key ) {

        this( i18n.getString( key ) );
    }

    /**
     * Creates a new <code>TestErrorException</code> instance, using a a
     * resource and MessageFormat to create the reason String.
     * 
     * @param i18n the resource bundle to find the reason message
     * @param key tne key to look within the resource for the message.
     * @param value a single object used with the string found in the resource,
     * used to create the reason message, according to the MessageFormat's
     * format method.
     */
    public TestErrorException( I18NResourceBundle i18n, String key, Object value ) {

        this( i18n.getString( key, value ) );
    }

    /**
     * Creates an instance with the localized message created by the message
     * extracted by the key, and the array of objects to plug in the message.
     * <em>Warning: the values argument must not be
     * represented in the invocation as an <code>Object</code> type, or
     * another constructor will be accessed.</em>
     */
    public TestErrorException( I18NResourceBundle i18n, String key, Object[] values ) {

        this( i18n.getString( key, values ) );
    }

}

package com.sap.tc.moin.xm.kernel.impl;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>NotFetched_XMSG: "{0}" has not been fetched by method "{1}"</li>
 * <li>SAXExceptionReported_XMSG: A SAX Exception was reported, message: {0}</li>
 * <li>ExceptionDuringParse_XMSG: An Exception occurred during parsing</li>
 * <li>IOExceptionDuringParse_XMSG: An Input/Output problem occurred during parse</li>
 * <li>IncorrectEndName_XMSG: Either the end B name "{0}" is not a correct end-name for the association "{1}" or an inter-partition link of the association "{2}" must not be stored at the end B side with the end B name "{3}"</li>
 * <li>Error_handler_is_null_although_XML_schema_is_not_null_XMSG: Error handler is null although XML schema is not null</li>
 * <li>NoOpenXMLTag_XMSG: No open XML tag</li>
 * <li>OutputStructureNotWellformed_XMSG: Output structure is not wellformed</li>
 * <li>SAPParserConfigProblem_XMSG: The SAX parser is not correctly configured</li>
 * <li>WrongEndBName_XMSG: The end B name "{0}" is not a correct end name for the association "{1}"</li>
 * <li>HandlerReturnedException_XMSG: The handler returned an Exception, message: {0}</li>
 * <li>StringParameterEmpty_XMSG: The string parameter "{0}" is empty</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from XmExceptionMessages.properties
 */
 
public enum XmExceptionMessages implements MoinLocalizedString {


    /**
     * Message: "Error handler is null although XML schema is not null"
     */
    ERROR_HANDLER_IS_NULL_ALTHOUGH_XML_SCHEMA_IS_NOT_NULL("Error_handler_is_null_although_XML_schema_is_not_null_XMSG"), //$NON-NLS-1$

    /**
     * Message: "An Exception occurred during parsing"
     */
    EXCEPTIONDURINGPARSE("ExceptionDuringParse_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The handler returned an Exception, message: {0}"
     */
    HANDLERRETURNEDEXCEPTION("HandlerReturnedException_XMSG"), //$NON-NLS-1$

    /**
     * Message: "An Input/Output problem occurred during parse"
     */
    IOEXCEPTIONDURINGPARSE("IOExceptionDuringParse_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Either the end B name "{0}" is not a correct end-name for the association "{1}" or an inter-partition link of the association "{2}" must not be stored at the end B side with the end B name "{3}""
     */
    INCORRECTENDNAME("IncorrectEndName_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No open XML tag"
     */
    NOOPENXMLTAG("NoOpenXMLTag_XMSG"), //$NON-NLS-1$

    /**
     * Message: ""{0}" has not been fetched by method "{1}""
     */
    NOTFETCHED("NotFetched_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Output structure is not wellformed"
     */
    OUTPUTSTRUCTURENOTWELLFORMED("OutputStructureNotWellformed_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The SAX parser is not correctly configured"
     */
    SAPPARSERCONFIGPROBLEM("SAPParserConfigProblem_XMSG"), //$NON-NLS-1$

    /**
     * Message: "A SAX Exception was reported, message: {0}"
     */
    SAXEXCEPTIONREPORTED("SAXExceptionReported_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The string parameter "{0}" is empty"
     */
    STRINGPARAMETEREMPTY("StringParameterEmpty_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The end B name "{0}" is not a correct end name for the association "{1}""
     */
    WRONGENDBNAME("WrongEndBName_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( XmExceptionMessages.class );

    private final String myKey;

    private XmExceptionMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + XmExceptionMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
package com.sap.tc.moin.repository.core.transactions.transactionables;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>CannotCallOperationParameterUpperMultiplicity_XMSG: Can not call operation "{0}" of class "{1}" with parameter number {2} to "{3}" of type "{4}". The parameter has an upper multiplicity of "{5}", but it was tried to set {6} values.</li>
 * <li>CannotCallOperationMultiValuedParameterWrongType_XMSG: Can not call operation "{0}" of class "{1}" with parameter number {2} to "{3}" of type "{4}". The parameter is multi-valued and ordered. The value has to be of type "{5}", but it is of type {4}.</li>
 * <li>CannotCallOPerationWrongType2_XMSG: Can not call operation "{0}" of class "{1}" with parameter number {2} to "{3}" of type "{4}". The value has to be of type "{5}", but it is of type {4}.</li>
 * <li>CannotCallOperationWrongType_XMSG: Can not call operation "{0}" of class "{1}" with parameter number {2} to "{3}" of type "{4}". The value of the element "{5}" has to be of type "{6}", but it is of type {7}.</li>
 * <li>CannotCallOperationBecauseUnexpectedArgumentSize_XMSG: Can not call operation '{0}' with the argument list '{1}'. The operation has {2} arguments, but is was tried to call it with {3}.</li>
 * <li>CannotCallOperationWithoutArgumentList_XMSG: Can not call operation '{0}' without an argument list. The operation has '{1}' arguments.</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from TransactionablesMessages.properties
 */
 
public enum TransactionablesMessages implements MoinLocalizedString {


    /**
     * Message: "Can not call operation "{0}" of class "{1}" with parameter number {2} to "{3}" of type "{4}". The value has to be of type "{5}", but it is of type {4}."
     */
    CANNOTCALLOPERATIONWRONGTYPE2("CannotCallOPerationWrongType2_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Can not call operation '{0}' with the argument list '{1}'. The operation has {2} arguments, but is was tried to call it with {3}."
     */
    CANNOTCALLOPERATIONBECAUSEUNEXPECTEDARGUMENTSIZE("CannotCallOperationBecauseUnexpectedArgumentSize_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Can not call operation "{0}" of class "{1}" with parameter number {2} to "{3}" of type "{4}". The parameter is multi-valued and ordered. The value has to be of type "{5}", but it is of type {4}."
     */
    CANNOTCALLOPERATIONMULTIVALUEDPARAMETERWRONGTYPE("CannotCallOperationMultiValuedParameterWrongType_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Can not call operation "{0}" of class "{1}" with parameter number {2} to "{3}" of type "{4}". The parameter has an upper multiplicity of "{5}", but it was tried to set {6} values."
     */
    CANNOTCALLOPERATIONPARAMETERUPPERMULTIPLICITY("CannotCallOperationParameterUpperMultiplicity_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Can not call operation '{0}' without an argument list. The operation has '{1}' arguments."
     */
    CANNOTCALLOPERATIONWITHOUTARGUMENTLIST("CannotCallOperationWithoutArgumentList_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Can not call operation "{0}" of class "{1}" with parameter number {2} to "{3}" of type "{4}". The value of the element "{5}" has to be of type "{6}", but it is of type {7}."
     */
    CANNOTCALLOPERATIONWRONGTYPE("CannotCallOperationWrongType_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( TransactionablesMessages.class );

    private final String myKey;

    private TransactionablesMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + TransactionablesMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
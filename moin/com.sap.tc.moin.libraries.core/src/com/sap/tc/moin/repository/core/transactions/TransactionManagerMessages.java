package com.sap.tc.moin.repository.core.transactions;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>TxInsideMicroTx_XMSG: Running a Transaction inside a MicroTransaction is not allowed</li>
 * <li>TxRedoWrongState_XMSG: Trying to redo a Tx on a wrong state: {0}</li>
 * <li>TxWrongState_XMSG: Trying to run a Transaction on a wrong state: {0}</li>
 * <li>TxUndoWrongState_XMSG: Trying to undo a Transaction on a wrong state: {0}</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from TransactionManagerMessages.properties
 */
 
public enum TransactionManagerMessages implements MoinLocalizedString {


    /**
     * Message: "Running a Transaction inside a MicroTransaction is not allowed"
     */
    TXINSIDEMICROTX("TxInsideMicroTx_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Trying to redo a Tx on a wrong state: {0}"
     */
    TXREDOWRONGSTATE("TxRedoWrongState_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Trying to undo a Transaction on a wrong state: {0}"
     */
    TXUNDOWRONGSTATE("TxUndoWrongState_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Trying to run a Transaction on a wrong state: {0}"
     */
    TXWRONGSTATE("TxWrongState_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( TransactionManagerMessages.class );

    private final String myKey;

    private TransactionManagerMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + TransactionManagerMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
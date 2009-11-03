package com.sap.tc.moin.repository.core.commands;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>CancelGroupFailed_XMSG: An Exception was encountered while canceling a command group</li>
 * <li>CommandGroupClosed_XMSG: Command Group already closed</li>
 * <li>CommandStackInERRORState_XMSG: CommandStack in ERROR state due to UnrecoverableException. The repository can be in an inconsistent state!</li>
 * <li>IllegalClearCallState_XMSG: Illegal clear() call: state is: {0}</li>
 * <li>IllegalSetMaxUndoStackSizeCallState_XMSG: Illegal setMaxUndoStackSize() call: state is: {0}</li>
 * <li>IllegalCallWithState_XMSG: Illegal {0} call, state: {1}</li>
 * <li>NotOnTop_XMSG: Illegal {0} call: Command not on stack top</li>
 * <li>EmptyRedoStack_XMSG: Illegal {0} call: Empty redo stack</li>
 * <li>EmptyUndoStack_XMSG: Illegal {0} call: Empty undo stack</li>
 * <li>IllegalSetGroupDesc_XMSG: Illegal {0} call: no open group</li>
 * <li>ForeignConnection_XMSG: Illegal {0} call: the Command was created with other connection</li>
 * <li>JMIObjectFromDifferentConnectionAccessed_XMSG: JMI object from different connection accessed while executing a command </li>
 * <li>RootCommandEnded_XMSG: Root Command '{0}' ended. (Connection: {1})</li>
 * <li>RootCommandRolledBack_XMSG: Root Command '{0}' rolled-back</li>
 * <li>UnrecoverableExecutionException_XMSG: UnrecoverableExecutionException while executing root Command {0}. (Connection: {1})</li>
 * <li>moin_commands_bug_0000_XMSG: {0}</li>
 * <li>OperationWrongState_XMSG: {0} while in state {1}</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from CommandsExceptionMessages.properties
 */
 
public enum CommandsExceptionMessages implements MoinLocalizedString {


    /**
     * Message: "An Exception was encountered while canceling a command group"
     */
    CANCELGROUPFAILED("CancelGroupFailed_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Command Group already closed"
     */
    COMMANDGROUPCLOSED("CommandGroupClosed_XMSG"), //$NON-NLS-1$

    /**
     * Message: "CommandStack in ERROR state due to UnrecoverableException. The repository can be in an inconsistent state!"
     */
    COMMANDSTACKINERRORSTATE("CommandStackInERRORState_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Illegal {0} call: Empty redo stack"
     */
    EMPTYREDOSTACK("EmptyRedoStack_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Illegal {0} call: Empty undo stack"
     */
    EMPTYUNDOSTACK("EmptyUndoStack_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Illegal {0} call: the Command was created with other connection"
     */
    FOREIGNCONNECTION("ForeignConnection_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Illegal {0} call, state: {1}"
     */
    ILLEGALCALLWITHSTATE("IllegalCallWithState_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Illegal clear() call: state is: {0}"
     */
    ILLEGALCLEARCALLSTATE("IllegalClearCallState_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Illegal {0} call: no open group"
     */
    ILLEGALSETGROUPDESC("IllegalSetGroupDesc_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Illegal setMaxUndoStackSize() call: state is: {0}"
     */
    ILLEGALSETMAXUNDOSTACKSIZECALLSTATE("IllegalSetMaxUndoStackSizeCallState_XMSG"), //$NON-NLS-1$

    /**
     * Message: "JMI object from different connection accessed while executing a command "
     */
    JMIOBJECTFROMDIFFERENTCONNECTIONACCESSED("JMIObjectFromDifferentConnectionAccessed_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Illegal {0} call: Command not on stack top"
     */
    NOTONTOP("NotOnTop_XMSG"), //$NON-NLS-1$

    /**
     * Message: "{0} while in state {1}"
     */
    OPERATIONWRONGSTATE("OperationWrongState_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Root Command '{0}' ended. (Connection: {1})"
     */
    ROOTCOMMANDENDED("RootCommandEnded_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Root Command '{0}' rolled-back"
     */
    ROOTCOMMANDROLLEDBACK("RootCommandRolledBack_XMSG"), //$NON-NLS-1$

    /**
     * Message: "UnrecoverableExecutionException while executing root Command {0}. (Connection: {1})"
     */
    UNRECOVERABLEEXECUTIONEXCEPTION("UnrecoverableExecutionException_XMSG"), //$NON-NLS-1$

    /**
     * Message: "{0}"
     */
    MOIN_COMMANDS_BUG_0000("moin_commands_bug_0000_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( CommandsExceptionMessages.class );

    private final String myKey;

    private CommandsExceptionMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + CommandsExceptionMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
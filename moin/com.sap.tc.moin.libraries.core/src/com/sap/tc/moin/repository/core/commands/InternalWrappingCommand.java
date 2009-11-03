/**
 * 
 */
package com.sap.tc.moin.repository.core.commands;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.transactions.TransactionRecord;


/**
 * Internal representation of the command resulting from a direct Jmi call. 
 * @author d045996
 *
 */
public class InternalWrappingCommand extends InternalCommand {

    public InternalWrappingCommand( Connection conn, String wrappingCommandDesc, TransactionRecord rec ) {

        super( conn, wrappingCommandDesc );
        txRecord = rec;
        state = InternalCommand.CommandState.DONE;
    }

}

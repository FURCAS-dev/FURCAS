package com.sap.tc.moin.facility.primary.riservice;

import com.sap.tc.moin.repository.InvalidResourceIdentifierException;
import com.sap.tc.moin.repository.PRI;

/**
 * Facility internal IPI interface.
 * <p>
 * Provides means to perform dynamic resource identifier related checks based on
 * the current MOIN state.
 * 
 * @author d047015
 */
public interface ResourceIdentifierVerifier {

    /**
     * Performs dynamic checks on the given {@link PRI}. <br>
     * The result of those checks depends on the current state of MOIN.
     * <p>
     * The following checks are performed:<br>
     * - {@link PRI#getPartitionName()} starts with a prefix which is currently
     * backed by a registered resource folder for {@link PRI#getCri()}.<br>
     * - {@link PRI#getPartitionName()} is formed upon a currently registered
     * name pattern.
     * 
     * @param pri The {@link PRI} to check
     * @throws InvalidResourceIdentifierException if one of the performed checks
     * fails
     */
    public void performDynamicValidation( PRI pri );

}

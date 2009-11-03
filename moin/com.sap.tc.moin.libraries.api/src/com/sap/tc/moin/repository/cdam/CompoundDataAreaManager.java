package com.sap.tc.moin.repository.cdam;

import com.sap.tc.moin.repository.Moin;

/**
 * The CompoundDataAreaManager is manages CompoundDataAreas and
 * CompoundClientSpecs. In order to create a session to access MOIN,
 * {@link Moin#createSession(CompoundClientSpec)} is to be called which requires
 * a CompoundClientSpec. Each scenario (Eclipse, Engine, Build ...) has an own
 * implementation of the CompoundDataAreaManager. <br>
 * This interface contains the functionality that is common to all scenarios.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface CompoundDataAreaManager {

    /**
     * Returns a CompoundClientSpec for transient use. Partitions contained in a
     * DataArea contained in the corresponding CompoundDataArea cannot be
     * persisted.
     * 
     * @return CompoundClientSpec
     */
    CompoundClientSpec getCompoundClientSpecTransientOnly( );
}

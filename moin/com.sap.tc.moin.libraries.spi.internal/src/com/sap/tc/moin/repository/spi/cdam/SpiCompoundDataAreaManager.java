package com.sap.tc.moin.repository.spi.cdam;

import java.util.Collection;

import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.Facility;
import com.sap.tc.moin.repository.cdam.CompoundClientSpec;
import com.sap.tc.moin.repository.cdam.CompoundDataArea;
import com.sap.tc.moin.repository.cdam.CompoundDataAreaManager;

/**
 * Internal interface for the compound data area manager. This interface has to
 * be implemented by the scenario-specific compound data area managers.
 * 
 * @author d026715
 */
public interface SpiCompoundDataAreaManager extends CompoundDataAreaManager {

    /**
     * Returns the client spec names for a given compound data area.
     * 
     * @param dataArea
     * @return Collection of client names
     */
    public Collection<String> getCompoundClientNames( CompoundDataArea dataArea );

    /**
     * Returns a compound client specs.
     * 
     * @param name
     * @return compound client specs
     */
    public CompoundClientSpec getCompoundClientSpec( String name );

    /**
     * Returns a compound client spec for a given client spec TODO move to
     * IdeCompoundDataAreaManager interface
     * 
     * @param clientSpec
     * @return compound client spec
     */
    public CompoundClientSpec getDefaultCompoundClientSpec( ClientSpec clientSpec );

    /**
     * Initializes the metamodel data areas. If the method has already been
     * called, a second call adds further metamodel data areas if possible.
     * 
     * @param facilities collection of facilites
     */
    public void initializeMetamodelDataAreas( Collection<Facility> facilities );

    /**
     * Restarts the compound data area manager
     */
    public void reset( );
}

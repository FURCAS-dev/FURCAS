package com.sap.tc.moin.repository.cdam;

import java.util.Collection;

import com.sap.tc.moin.repository.DataArea;
import com.sap.tc.moin.repository.DataAreaDescriptor;

/**
 * Compound data area. Contains a set of data areas that can be defined in
 * different facilities.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @author d026715
 */
public interface CompoundDataArea {

    /**
     * Returns the name of the compound data area.
     * 
     * @return name of compound data area
     */
    public String getName( );

    /**
     * Returns all contained data areas.
     * 
     * @return all data areas
     */
    public Collection<DataArea> getDataAreas( );

    /**
     * Gets a data area specified by a {@link DataAreaDescriptor}.
     * 
     * @param descriptor
     * @return data area
     */
    public DataArea getDataArea( DataAreaDescriptor descriptor );

    /**
     * Returns all meta model data areas.
     * 
     * @return all meta model data areas
     */
    public DataArea getMetaModelDataArea( );

}

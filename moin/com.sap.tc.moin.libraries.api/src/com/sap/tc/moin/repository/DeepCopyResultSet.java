package com.sap.tc.moin.repository;

import java.util.Collection;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;


/**
 * Contains the result of a
 * {@link Connection#deepCopy(Collection, DeepCopyPolicyHandler, boolean)
 * DeepCopy} process.
 * 
 * @see Connection#deepCopy(Collection, DeepCopyPolicyHandler, boolean)
 * @author d045996
 */
public interface DeepCopyResultSet {

    /**
     * Returns the copied elements.
     * 
     * @return the copied elements
     */
    public Collection<RefObject> getCopiedElements( );

    /**
     * Returns the mapping table.
     * 
     * @return the mapping table
     */
    public DeepCopyMap getMappingTable( );

    /**
     * Returns the MRI mapping table.
     * 
     * @return the MRI mapping table
     */
    public Map<MRI, MRI> getMriMappingTable( );

    /**
     * Returns the inverse mri mapping table.
     * 
     * @return the inverse mri mapping table
     */
    public Map<MRI, MRI> getInverseMriMappingTable( );

    /**
     * Returns the errors.
     * 
     * @return the errors
     */
    public Collection<DeepCopyError> getCopyErrors( );
}

package com.sap.tc.moin.repository.core;

import java.util.Collection;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.DeepCopyError;
import com.sap.tc.moin.repository.DeepCopyMap;
import com.sap.tc.moin.repository.DeepCopyPolicyHandler;
import com.sap.tc.moin.repository.DeepCopyResultSet;
import com.sap.tc.moin.repository.MRI;


/**
 * Contains the result of a
 * {@link Connection#deepCopy(Collection, DeepCopyPolicyHandler, boolean)
 * DeepCopy} process.
 * 
 * @see Connection#deepCopy(Collection, DeepCopyPolicyHandler, boolean)
 * @author d045996
 */
public final class DeepCopyResultSetImpl implements DeepCopyResultSet {

    private Collection<RefObject> copiedElements;

    private DeepCopyMap mappingTable;

    private Map<MRI, MRI> mriMappingTable;

    private Map<MRI, MRI> inverseMriMappingTable;

    private Collection<DeepCopyError> copyErrors;

    /**
     * @param copiedElements
     * @param mappingTable
     * @param mriMappingTable
     * @param inverseMappingTable
     * @param copyErrors
     */
    public DeepCopyResultSetImpl( Collection<RefObject> copiedElements, DeepCopyMap mappingTable, Map<MRI, MRI> mriMappingTable, Map<MRI, MRI> inverseMappingTable, Collection<DeepCopyError> copyErrors ) {

        this.copiedElements = copiedElements;
        this.mappingTable = mappingTable;
        this.mriMappingTable = mriMappingTable;
        this.inverseMriMappingTable = inverseMappingTable;
        this.copyErrors = copyErrors;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.DeepCopyResultSet#getCopiedElements()
     */
    public Collection<RefObject> getCopiedElements( ) {

        return copiedElements;
    }


    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.DeepCopyResultSet#getMappingTable()
     */
    public DeepCopyMap getMappingTable( ) {

        return mappingTable;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.DeepCopyResultSet#getMriMappingTable()
     */
    public Map<MRI, MRI> getMriMappingTable( ) {

        return mriMappingTable;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.DeepCopyResultSet#getInverseMriMappingTable()
     */
    public Map<MRI, MRI> getInverseMriMappingTable( ) {

        return inverseMriMappingTable;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.DeepCopyResultSet#getCopyErrors()
     */
    public Collection<DeepCopyError> getCopyErrors( ) {

        return copyErrors;
    }
}

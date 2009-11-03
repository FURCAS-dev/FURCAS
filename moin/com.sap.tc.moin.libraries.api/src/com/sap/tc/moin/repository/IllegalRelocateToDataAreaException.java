package com.sap.tc.moin.repository;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * Is thrown if it is tried to relocate an element from its current
 * {@link DataArea data area} to a different one.
 * 
 * @author d044711
 */
public final class IllegalRelocateToDataAreaException extends MoinLocalizedBaseRuntimeException {

    private static final long serialVersionUID = 1L;

    private MRI elementMri;

    private DataAreaDescriptor from;

    private DataAreaDescriptor to;

    /**
     * Creates an instance of this exception.
     * 
     * @param message
     * @param objectToRelocate the element which was to be relocated
     * @param actFrom the data area where the element resides
     * @param actTo the data area where the element should be relocated to
     */
    public IllegalRelocateToDataAreaException( MoinLocalizedString message, Partitionable objectToRelocate, DataAreaDescriptor actFrom, DataAreaDescriptor actTo ) {

        super( message, objectToRelocate, actFrom, actTo );
        this.elementMri = objectToRelocate.get___Mri( );
        this.from = actFrom;
        this.to = actTo;
    }

    /**
     * The element which was tried to relocate.
     * 
     * @return The element which was tried to relocate.
     */
    public MRI getObjectToRelocate( ) {

        return this.elementMri;
    }

    /**
     * The data area of the {@link #getObjectToRelocate() element} to relocate.
     * 
     * @return The data area of the {@link #getObjectToRelocate() element} to
     * relocate.
     */
    public DataAreaDescriptor getFrom( ) {

        return this.from;
    }

    /**
     * The data area the {@link #getObjectToRelocate() element} was tried to
     * relocate to.
     * 
     * @return The data area the {@link #getObjectToRelocate() element} was
     * tried to relocate to.
     */
    public DataAreaDescriptor getTo( ) {

        return this.to;
    }

}
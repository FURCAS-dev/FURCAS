package com.sap.tc.moin.repository;

import java.util.Collection;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * Thrown if one or more partitions are not saved. Contains the collection of
 * partitions which are not saved.
 */
public class PartitionsNotSavedException extends MoinLocalizedBaseException {

    private static final long serialVersionUID = 1L;

    private Collection<PRI> partitions;

    /**
     * Creates a new instance of this exception.
     * 
     * @param cause the cause for this exception
     * @param unsavedPartitions partitions which weren't saved
     * @param message
     * @param args
     */
    public PartitionsNotSavedException( Throwable cause, Collection<PRI> unsavedPartitions, MoinLocalizedString message, Object... args ) {

        super( cause, message, args );
        this.partitions = unsavedPartitions;
    }

    /**
     * Returns the partitions which weren't saved.
     * 
     * @return the partitions which weren't saved.
     */
    public Collection<PRI> getPartitions( ) {

        return this.partitions;
    }
}
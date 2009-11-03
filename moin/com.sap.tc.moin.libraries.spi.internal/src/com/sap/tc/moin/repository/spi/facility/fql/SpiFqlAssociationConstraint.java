package com.sap.tc.moin.repository.spi.facility.fql;

import com.sap.tc.moin.repository.MRI;

/**
 * An association constraint defines a join constraint by limiting the instances
 * of the involved where entries by imposing the existence of links. There are
 * two forms as denoted by the subtypes.
 * 
 * @author D045917
 */
public interface SpiFqlAssociationConstraint extends SpiFqlJoinConstraint {

    /**
     * Returns the MRI of the association meta object
     * 
     * @return the MRI of the assocation
     */
    MRI getAssocMRI( );

    /**
     * Returns the integer encoding for the from-side
     * 
     * @return the integer encoding for the from-side
     */
    int getFromAssocEnd( );

    /**
     * Returns the query entry for the from-side
     * 
     * @retrun the query entry for the from-side
     */
    SpiFqlQueryEntry getFromEndEntry( );

    /**
     * Indicates if we have storage at the from-side
     * 
     * @return true if we have storage at the from-side, otherwise false
     */
    boolean hasStorageAtFromEnd( );

    /**
     * Indicates if we have storage at the to-side
     * 
     * @return true if we have storage at the to-side, otherwise false
     */
    boolean hasStorageAtToEnd( );

    /**
     * Returns the category of the association
     * 
     * @return the category of the association
     */
    SpiFqlAssociationCategory getAssocCategory( );

    /*
     * For debugging purposes
     */

    /**
     * Returns the name of the association
     * 
     * @return the name of the association
     */
    String getAssocName( );

    /**
     * Returns the name of the association end at the from-side
     * 
     * @return the name of the association end at the from-side
     */
    String getFromAssocEndName( );

    /**
     * Returns the name of the association end at the to-side
     * 
     * @return the name of the association end at the to-side
     */
    String getToAssocEndName( );

}

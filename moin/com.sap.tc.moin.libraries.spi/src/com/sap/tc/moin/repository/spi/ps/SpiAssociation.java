package com.sap.tc.moin.repository.spi.ps;

import com.sap.tc.moin.repository.mmi.model.Association;

/**
 * Instances of {@link SpiAssociation} represent an {@link Association} in a
 * metamodel.
 */
public interface SpiAssociation extends SpiType {

    /**
     * Returns the number of the {@link SpiAssociation association's} composite
     * end (can be 0 or 1), or -1 if the association is not composite.
     * 
     * @return the number of the association's composite end
     */
    public int get___CompositeEndNumber( );

    /**
     * Returns the number of the {@link SpiAssociation association's} ordered
     * end (can be 0 or 1), or -1 if the association is not ordered.
     * 
     * @return the number of the association's ordered end
     */
    public int get___OrderedEndNumber( );

    /**
     * Returns the number of the {@link SpiAssociation association's} stored
     * end, which is either 0 or 1.
     * 
     * @return the number of the association's stored end
     */
    public int get___StoredEndNumber( );

    /**
     * Returns the number of the association end with the given name. Returns
     * either 0 or 1 if the association end exists, and -1 otherwise.
     * 
     * @param nameOfAssociationEnd the name of the requested association end
     * @return the number of the association end with the given name
     */
    public int get___EndNumber( String nameOfAssociationEnd );

    /**
     * Returns the {@link SpiClass} that is the type of the association end with
     * the specified end number.
     * 
     * @throws IllegalArgumentException if the end number is neither 0 nor 1
     */
    public SpiClass get___EndType( int endNumber );
}

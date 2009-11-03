package com.sap.tc.moin.friends.merge;


/**
 * The type of an operation
 */
public enum OperationType {

    /**
     * New Object
     */
    NEW_OBJECT( true ),
    /**
     * Delete Object
     */
    DELETE_OBJECT( false ),
    /**
     * Set Attribute
     */
    SET_ATTRIBUTE,
    /**
     * Reorder Values
     */
    REORDER_VALUES,
    /**
     * Add Attribute value
     */
    ADD_ATTRIBUTE_VALUE( true ),
    /**
     * Remove Attribute value
     */
    DEL_ATTRIBUTE_VALUE( false ),
    /**
     * Add link
     */
    ADD_LINK( true ),
    /**
     * Remove link
     */
    REMOVE_LINK( false );

    public boolean isPositive( ) {

        if ( this.isPositive != null ) {
            return this.isPositive.booleanValue( );
        }
        return false;
    }

    public boolean isNegative( ) {

        if ( this.isPositive != null ) {
            return !this.isPositive.booleanValue( );
        }
        return false;
    }

    public boolean isNeutral( ) {

        return this.isPositive == null;
    }


    private final Boolean isPositive;

    private OperationType( boolean positive ) {

        this.isPositive = Boolean.valueOf( positive );
    }

    private OperationType( ) {

        this.isPositive = null;
    }

}

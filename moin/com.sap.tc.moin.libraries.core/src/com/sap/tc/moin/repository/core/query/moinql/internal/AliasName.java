package com.sap.tc.moin.repository.core.query.moinql.internal;

/**
 * This abstract data type represent an alias name. We keep it instead of a
 * String as it allows easy cloning with guaranteed uniqueness.
 */
public class AliasName {

    private String originalName;

    private boolean original;

    /**
     * This is the initial constructor, which sets the originalName
     * (unchangeable afterwards)
     */
    public AliasName( String _name ) {

        this.originalName = _name;
        this.original = true;
    }

    /**
     * This is the secondary constructor which allows the cloning.
     */
    public AliasName( AliasName _aliasName ) {

        this.originalName = _aliasName.getOriginalName( );
        this.original = false;
    }

    public String getOriginalName( ) {

        return this.originalName;
    }

    @Override
    public String toString( ) {

        if ( this.original ) {
            return this.originalName;
        } else {
            return this.originalName + "_" + String.valueOf( this.hashCode( ) ); //$NON-NLS-1$
        }
    }

    // the identity of this object is its hash code!

}

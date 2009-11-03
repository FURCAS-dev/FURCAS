/*
 * Created on 12.02.2006
 */
package com.sap.tc.moin.repository.mql;

/**
 * A where relation association verifies if the provided aliases live in the
 * relation given by the association. The latter is provided by its fully
 * qualified name, including an optional container name, as well as its two
 * association ends.
 */
final public class WhereRelationAssoc extends WhereRelation {

    /*
     * Container name can optionally be used to disambiguate the association
     */
    private String containerName;

    /*
     * The fully qualified name of the MOF association
     */
    private String[] assocQName;

    /*
     * The right-hand side assoc end name.
     */
    private String rightAssocEndName;

    /**
     * This predicate is true if there is a navigation from a model element
     * denoted by the left alias via the association to a element denoted by the
     * right alias. The provided association-end indicates the navigation from
     * left to right and corresponds to the right association-end relative to
     * the association.
     * 
     * @param _leftAlias the left alias.
     * @param _rightAssocEndName the right association end name.
     * @param _containerName the container name of the association
     * @param _assocQName the qualified association name.
     * @param _rightAlias the right alias.
     */
    public WhereRelationAssoc( String _leftAlias, String _rightAssocEndName, String _containerName, String[] _assocQName, String _rightAlias ) {

        this.leftAlias = _leftAlias;
        this.containerName = _containerName;
        this.assocQName = _assocQName;
        this.rightAssocEndName = _rightAssocEndName;
        this.rightAlias = _rightAlias;
    }

    /**
     * Returns the right-hand-side association-end name.
     * 
     * @return the right-hand-side association-end name.
     */
    public String getRightAssocEndName( ) {

        return this.rightAssocEndName;
    }

    /**
     * Returns the fully qualified name of the MOF association.
     * 
     * @return the fully qualified name of the MOF association.
     */
    public String[] getAssocQName( ) {

        return this.assocQName;
    }

    /**
     * Returns the container name, whenever provided. Otherwise, null is
     * returned.
     * 
     * @return the container name, whenever provided. Otherwise, null is
     * returned.
     */
    public String getContainerName( ) {

        return this.containerName;
    }

    @Override
    protected void toString( StringBuilder sb, int indent ) {

        sb.append( this.leftAlias );
        sb.append( "." ); //$NON-NLS-1$
        sb.append( this.rightAssocEndName );
        sb.append( "[" ); //$NON-NLS-1$
        sb.append( this.containerName );
        sb.append( "#" ); //$NON-NLS-1$
        if ( this.assocQName != null && this.assocQName.length > 0 ) {
            sb.append( this.assocQName[0] );
            for ( int i = 1; i < this.assocQName.length; i++ ) {
                sb.append( "::" ); //$NON-NLS-1$
                sb.append( this.assocQName[i] );
            }
        }
        sb.append( "] = " ); //$NON-NLS-1$
        sb.append( this.rightAlias );
    }
}

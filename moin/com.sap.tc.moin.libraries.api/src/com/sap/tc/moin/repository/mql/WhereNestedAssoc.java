/*
 * Created on 10.02.2006
 */
package com.sap.tc.moin.repository.mql;

/**
 * A where nested association defines a where-entry which constrains an alias by
 * connecting it via an association to the results of a nested query. The
 * association is expressed via a fully qualified name, optionally annotated
 * with a container name to disambiguate when multiple meta-models are loaded.
 */
final public class WhereNestedAssoc extends WhereNested {

    /*
     * The assoc end name, which is pointing towards the nested query
     */
    private String assocEndName;

    /*
     * The fully qualified name of the MOF association
     */
    private String[] assocQName;

    /*
     * Container name can optionally be used to disambiguate the association
     */
    private String containerName;

    /*
     * Constructors
     */
    /**
     * The provided qualified name has to identify an association and the
     * association end name has to identify an association end. The nested
     * select has to select one alias referring to the type of the provided
     * association end. The entry is true whenever the element chosen from the
     * alias is linked via the provided association to the element in the result
     * set of the nested query.
     * 
     * @param _alias the alias.
     * @param _assocQName the qualified association name.
     * @param _containerName the container name of the association
     * @param _assocEndName the association end name.
     * @param _nestedQuery the nested query.
     */
    public WhereNestedAssoc( String _alias, String[] _assocQName, String _containerName, String _assocEndName, MQLQuery _nestedQuery ) {

        this( false, _alias, _assocQName, _containerName, _assocEndName, _nestedQuery );
    }

    /**
     * The provided qualified name has to identify an association and the
     * association end name has to identify an association end. The nested
     * select has to select one alias referring to the type of the provided
     * association end. If the boolean is false, the entry is true whenever the
     * element chosen from the alias is linked via the provided association to
     * the element in the result set of the nested query. If the boolean is
     * true, the entry is true whenever the element chosen from the alias is not
     * linked via the provided association to the element in the result set of
     * the nested query.
     * 
     * @param _not the indicator if the nested association clause is negated
     * @param _alias the alias.
     * @param _assocQName the qualified association name.
     * @param _containerName the container name of the association
     * @param _assocEndName the association end name.
     * @param _nestedQuery the nested query.
     */
    public WhereNestedAssoc( boolean _not, String _alias, String[] _assocQName, String _containerName, String _assocEndName, MQLQuery _nestedQuery ) {

        this.not = _not;
        this.leftAlias = _alias;
        this.assocQName = _assocQName;
        this.containerName = _containerName;
        this.nestedQuery = _nestedQuery;
        this.assocEndName = _assocEndName;
    }

    /**
     * Returns the association end name, which is pointing towards the nested
     * query of this where entry.
     * 
     * @return the association end name, which is pointing towards the nested
     * query of this where entry.
     */
    public String getAssocEndName( ) {

        return this.assocEndName;
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
        sb.append( this.assocEndName );
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
        sb.append( "] " ); //$NON-NLS-1$

        if ( this.not ) {
            sb.append( "not " ); //$NON-NLS-1$
        }

        if ( this.nestedQuery != null ) {
            sb.append( "in\n" ); //$NON-NLS-1$
            this.nestedQuery.toString( sb, indent + 1 );
        } else {
            sb.append( "in NULL_QUERY" ); //$NON-NLS-1$
        }
    }
}

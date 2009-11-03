/*
 * Created on 10.02.2006
 */
package com.sap.tc.moin.repository.mql;

/**
 * A where nested feature defines a where-entry which constrains an alias by
 * connecting it via an association to the results of a nested query. The
 * association is expressed via a feature (i.e. reference, or attribute for
 * class-level attributes).
 */
final public class WhereNestedFeature extends WhereNested {

    /*
     * The feature which encodes the association (this is a reference or
     * attribute of a class-level attribute).
     */
    private String featureName;

    /**
     * The provided feature has to identify an object-valued attribute or
     * reference and the nested query has to select one alias referring to the
     * type of the feature. For an association, if no reference exists and if
     * there is no ambiguity, it is also allowed to use the association-end on
     * the other side. In case of ambiguity, use {@link WhereNestedAssoc}. The
     * entry is true whenever the feature value has at least one element, which
     * is contained in the result set of nested query.
     * 
     * @param _alias the alias.
     * @param _featureName the feature name.
     * @param _nestedQuery the nested query.
     */
    public WhereNestedFeature( String _alias, String _featureName, MQLQuery _nestedQuery ) {

        this( false, _alias, _featureName, _nestedQuery );
    }

    /**
     * The provided feature has to identify an object-valued attribute or
     * reference and the nested query has to select one alias referring to the
     * type of the feature. For an association, if no reference exists and if
     * there is no ambiguity, it is also allowed to use the association-end on
     * the other side. In case of ambiguity, use {@link WhereNestedAssoc}. If
     * the boolean is false, the entry is true whenever the feature value has at
     * least one element, which is contained in the result set of nested query.
     * If the boolean is true, the entry is true whenever the feature value has
     * no elements, which are contained in the result set of nested query.
     * 
     * @param _not the indicator if the nested association clause is negated
     * @param _alias the alias.
     * @param _featureName the feature name.
     * @param _nestedQuery the nested query.
     */
    public WhereNestedFeature( boolean _not, String _alias, String _featureName, MQLQuery _nestedQuery ) {

        this.leftAlias = _alias;
        this.featureName = _featureName;
        this.nestedQuery = _nestedQuery;
        this.not = _not;
    }

    /**
     * Returns the feature which encodes the association.
     * 
     * @return the feature which encodes the association.
     */
    public String getFeatureName( ) {

        return this.featureName;
    }

    @Override
    protected void toString( StringBuilder sb, int indent ) {

        sb.append( this.leftAlias );
        sb.append( "." ); //$NON-NLS-1$
        sb.append( this.featureName );

        if ( this.not ) {
            sb.append( " not " ); //$NON-NLS-1$
        }

        sb.append( " in\n" ); //$NON-NLS-1$
        this.nestedQuery.toString( sb, indent + 1 );
    }
}

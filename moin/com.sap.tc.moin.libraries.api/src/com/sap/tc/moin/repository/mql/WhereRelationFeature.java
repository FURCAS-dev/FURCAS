/*
 * Created on 13.02.2006
 */
package com.sap.tc.moin.repository.mql;

/**
 * A where relation feature verifies if the provided aliases live in the
 * relation given by the association. The latter is provided by a reference on
 * the left-hand alias.
 */
final public class WhereRelationFeature extends WhereRelation {

    /*
     * The feature which encodes the association (this is a reference or
     * attribute of a class-level attribute).
     */
    private String featureName;

    /**
     * This predicate is true whenever the right alias represents a model
     * element, which is equal to the provided class-typed feature value, i.e.
     * attribute or reference. For an association, if no reference exists and if
     * there is no ambiguity, it is also allowed to use the association-end on
     * the other side. In case of ambiguity, use {@link WhereRelationAssoc}. If
     * the multiplicity <> 1, then the predicate is true whenever the equality
     * holds for at least one element of the collection.
     * 
     * @param _leftAlias the left alias.
     * @param _featureName the feature name.
     * @param _rightAlias the right alias.
     */
    public WhereRelationFeature( String _leftAlias, String _featureName, String _rightAlias ) {

        this.leftAlias = _leftAlias;
        this.rightAlias = _rightAlias;
        this.featureName = _featureName;
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
        sb.append( " = " ); //$NON-NLS-1$
        sb.append( this.rightAlias );
    }
}

/*
 * Created on 10.02.2006
 */
package com.sap.tc.moin.repository.mql;

import com.sap.tc.moin.repository.MRI;

/**
 * A where nested association defines a where-entry which constrains an alias by
 * connecting it via an association to the results of a nested query. The
 * association is provided by its {@link MRI} (representing the meta object).
 * The one association end is provided with its internal encoding, i.e. 0 or 1.
 */
final public class WhereNestedAssocMri extends WhereNested {

    /*
     * The association end pointing towards the nested query
     */
    private int assocEnd;

    /*
     * The MRI of the meta-model element representing the association
     */
    private MRI assocMRI;

    /**
     * The provided {@link MRI} has to identify the meta-element of an
     * association and the integer identifies the association end number (0 or
     * 1). The nested select has to select one alias referring to the type of
     * the provided association end. The entry is true whenever the element
     * chosen from the alias is linked via the provided association to the
     * element in the result set of the nested query.
     * 
     * @param _alias the alias.
     * @param _attrMRI the MRI of the association itself
     * @param _assocEnd the encoding (0/1) of the association end
     * @param _nestedQuery the nested query.
     */
    public WhereNestedAssocMri( String _alias, MRI _attrMRI, int _assocEnd, MQLQuery _nestedQuery ) {

        this( false, _alias, _attrMRI, _assocEnd, _nestedQuery );
    }

    /**
     * The provided {@link MRI} has to identify the meta-element of an
     * association and the integer identifies the association end number (0 or
     * 1). The nested select has to select one alias referring to the type of
     * the provided association end. If the boolean is false, the entry is true
     * whenever the element chosen from the alias is linked via the provided
     * association to the element in the result set of the nested query. If the
     * boolean is true, the entry is true whenever the element chosen from the
     * alias is not linked via the provided association to the element in the
     * result set of the nested query.
     * 
     * @param _not the indicator if the nested association clause is negated
     * @param _alias the alias.
     * @param _assocMRI the MRI of the association itself
     * @param _assocEnd the encoding (0/1) of the association end
     * @param _nestedQuery the nested query.
     */
    public WhereNestedAssocMri( boolean _not, String _alias, MRI _assocMRI, int _assocEnd, MQLQuery _nestedQuery ) {

        this.not = _not;
        this.leftAlias = _alias;
        this.nestedQuery = _nestedQuery;
        this.assocMRI = _assocMRI;
        this.assocEnd = _assocEnd;
    }

    /**
     * Returns the association end pointing towards the nested query.
     * 
     * @return the association end pointing towards the nested query.
     */
    public int getAssocEnd( ) {

        return this.assocEnd;
    }

    /**
     * Returns the MRI of the meta-model element representing the association.
     * 
     * @return the MRI of the meta-model element representing the association.
     */
    public MRI getAssocMRI( ) {

        return this.assocMRI;
    }

    @Override
    protected void toString( StringBuilder sb, int indent ) {

        sb.append( this.leftAlias );
        sb.append( "." ); //$NON-NLS-1$
        sb.append( this.assocEnd );
        sb.append( "[" ); //$NON-NLS-1$
        sb.append( this.assocMRI.toString( ) );
        sb.append( "] " ); //$NON-NLS-1$

        if ( this.not ) {
            sb.append( "not " ); //$NON-NLS-1$
        }

        sb.append( "in\n" ); //$NON-NLS-1$
        this.nestedQuery.toString( sb, indent + 1 );
    }
}

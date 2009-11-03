/*
 * Created on 12.02.2006
 */
package com.sap.tc.moin.repository.mql;

import com.sap.tc.moin.repository.MRI;

/**
 * A where relation association verifies if the provided aliases live in the
 * relation given by the association. The latter is provided by its {@link MRI}
 * (representing the meta object). The two association ends are provided with
 * their internal encoding, i.e. 0 or 1.
 */
final public class WhereRelationAssocMri extends WhereRelation {

    /*
     * The MRI of the meta-model element representing the association
     */
    private MRI assocMRI;

    /*
     * The right side of the association
     */
    private int rightAssocEnd;

    /**
     * This predicate is true if there is a navigation from a model element
     * denoted by the left alias via the association to a element denoted by the
     * right alias. The provided association-end indicates the navigation from
     * left to right and corresponds to the right association-end relative to
     * the association.
     * 
     * @param _leftAlias the left alias.
     * @param _rightAssocEnd the right association end encoded as 0 or 1
     * @param _assocMRI the association in the form of its mri.
     * @param _rightAlias the right alias.
     */
    public WhereRelationAssocMri( String _leftAlias, int _rightAssocEnd, MRI _assocMRI, String _rightAlias ) {

        this.leftAlias = _leftAlias;
        this.assocMRI = _assocMRI;
        this.rightAssocEnd = _rightAssocEnd;
        this.rightAlias = _rightAlias;
    }

    /**
     * Returns the right hand association-end number.
     * 
     * @return the right hand association-end number.
     */
    public int getRightAssocEnd( ) {

        return this.rightAssocEnd;
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
        sb.append( this.rightAssocEnd );
        sb.append( "[" ); //$NON-NLS-1$
        sb.append( this.assocMRI.toString( ) );
        sb.append( "] = " ); //$NON-NLS-1$
        sb.append( this.rightAlias );
    }
}

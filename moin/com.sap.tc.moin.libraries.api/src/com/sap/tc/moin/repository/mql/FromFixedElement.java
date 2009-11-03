package com.sap.tc.moin.repository.mql;

import com.sap.tc.moin.repository.MRI;

/**
 * This type of from-entry is used to specify exactly one fixed element by means
 * of its {@link MRI}.
 */
public class FromFixedElement extends FromEntry {

    /*
     * The fixed element for this from entry
     */
    private MRI element;

    /**
     * With this type of from-entry, the from-set is fixed by the client
     * providing exactly one element in the form an {@link MRI}. The type is
     * implicitly derived. The alias can be used elsewhere to identify this
     * from-entry. Important NOTE: the provide MRI will always be resolved on
     * the connection and thus implicitly load the partition. If you do not want
     * this behavior, you have to use {@link FromFixedSet}, where the type of
     * the elements has to be explicitly provided.
     * 
     * @param _aliasName of the FromEntry
     * @param _element MRI of the fixed element
     */
    public FromFixedElement( String _aliasName, MRI _element ) {

        this.aliasName = _aliasName;
        this.element = _element;
        this.included = true;
    }

    /**
     * Returns the fixed element of this from-entry.
     * 
     * @return the fixed element of this from-entry.
     */
    public MRI getElement( ) {

        return this.element;
    }

    @Override
    protected void toString( StringBuilder sb, int indent ) {

        sb.append( "fixedElement: " ); //$NON-NLS-1$
        sb.append( this.element.toString( ) );
        super.toString( sb, indent + 14 );
    }
}

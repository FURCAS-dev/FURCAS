package com.sap.tc.moin.repository.mql;

import java.util.Arrays;
import java.util.Set;

import com.sap.tc.moin.repository.MRI;

/**
 * This type of from-entry is defined by the {@link MRI} of a meta-model element
 * and allows the provision of a fixed set of model elements.
 */
final public class FromMriTypeFixedSet extends FromTypeMri {

    /*
     * The fixed set of elements for this from entry
     */
    private MRI[] elements;

    /**
     * With this type of from-entry, the from-set is fixed by the client. All
     * provided elements have to be instances of the provided type or any of its
     * sub-types. The type is given by the {@link MRI} of a meta-model element.
     * The alias can be used elsewhere to identify this from-entry.
     * 
     * @param _aliasName of the FromEntry
     * @param type the MRI of the common supertype of the fixed elements
     * @param _elements the actual fixed elements, encoded as MRIs
     */
    public FromMriTypeFixedSet( String _aliasName, MRI type, MRI[] _elements ) {

        super( _aliasName, type, false );
        this.elements = _elements;
        this.included = true;
    }

    /**
     * With this type of from-entry, the from-set is fixed by the client. All
     * provided elements have to be instances of the provided type or any of its
     * sub-types. The type is given by the {@link MRI} of a meta-model element.
     * The alias can be used elsewhere to identify this from-entry.
     * 
     * @param _aliasName of the FromEntry
     * @param type the MRI of the common supertype of the fixed elements
     * @param _elements the actual fixed elements, encoded as MRIs
     */
    public FromMriTypeFixedSet( String _aliasName, MRI type, Set<MRI> _elements ) {

        super( _aliasName, type, false );
        this.elements = _elements.toArray( new MRI[_elements.size( )] );
        this.included = true;
    }

    /**
     * Returns the elements of the fixed set of this from-entry.
     * 
     * @return the elements of the fixed set of this from-entry.
     */
    public MRI[] getElements( ) {

        return this.elements;
    }

    @Override
    protected void toString( StringBuilder sb, int indent ) {

        super.toString( sb, indent );

        if ( this.elements.length > 0 ) {
            sb.append( '\n' );
            char[] whiteSpace = new char[indent + 6];
            Arrays.fill( whiteSpace, ' ' );
            sb.append( whiteSpace );
            sb.append( "in elements {" ); //$NON-NLS-1$

            sb.append( this.elements[0].toString( ) );

            for ( int i = 1; i < this.elements.length; i++ ) {
                sb.append( ",\n" ); //$NON-NLS-1$
                char[] whiteSpaceN = new char[indent + 13 + 6];
                Arrays.fill( whiteSpaceN, ' ' );
                sb.append( whiteSpaceN );
                sb.append( this.elements[i].toString( ) );
            }

            sb.append( "}" ); //$NON-NLS-1$
        }

    }
}

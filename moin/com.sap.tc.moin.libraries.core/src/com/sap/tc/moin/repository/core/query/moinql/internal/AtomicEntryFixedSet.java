package com.sap.tc.moin.repository.core.query.moinql.internal;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.query.messages.MQLBugMessages;
import com.sap.tc.moin.repository.core.query.moinql.shared.MQLAuxServices;
import com.sap.tc.moin.repository.core.query.moinql.shared.MQLBugException;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlEntryElements;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlFromTypeCategory;

/**
 * An AtomicEntryFixedSet is a special atomic entry, where the set of elements
 * to consider is fixed. All its elements have to be of the types provided in
 * the type-list. Moreover, an atomic entry with fixed elements always has an
 * implicit scope based on its elements, which is inclusive!
 */
final public class AtomicEntryFixedSet extends AtomicEntry implements SpiFqlEntryElements {

    private Set<MRI> elements;

    /**
     * This constructor sets the element set and determines the scope. The
     * provided scope may delimit the elements in the set
     */
    public AtomicEntryFixedSet( AliasName _aliasName, List<MRI> _classMRIs, List<String> _classNames, Set<MRI> _elements, boolean _isReflectElement, Set<PRI> _scope, Set<CRI> _containerScope, boolean isIncluded ) {

        // first set the aspects of a normal atomic entry
        super( _aliasName, _classMRIs, _classNames, SpiFqlFromTypeCategory.CLASS, _isReflectElement, null, null, false );

        // the set the fixed elements
        this.elements = ( _elements == null ? new HashSet<MRI>( 0 ) : _elements );

        // set the scope, which destructively adapts elements
        this.setScope( _scope, _containerScope, isIncluded );
    }

    @SuppressWarnings( "unchecked" )
    static public AtomicEntryFixedSet newAtomicEntryFixedSetWithClonedElements( AliasName _aliasName, List<MRI> _classMRIs, List<String> _classNames, Set<MRI> _elements, boolean _isReflectElement, Set<PRI> _scope, Set<CRI> _containerScope, boolean isIncluded ) {

        Set<MRI> clonedElements = null;
        if ( _elements instanceof HashSet ) {
            clonedElements = (Set<MRI>) ( (HashSet<MRI>) _elements ).clone( );
        } else if ( _elements != null ) {
            throw new MQLBugException( MQLBugMessages.FIXED_ELEMENT_SET_IN_CLONING_CONSTRUCTOR_HAS_TO_BE_HASHSET );
        }

        return new AtomicEntryFixedSet( _aliasName, _classMRIs, _classNames, clonedElements, _isReflectElement, _scope, _containerScope, isIncluded );
    }

    public Set<MRI> getElements( ) {

        return this.elements;
    }

    @Override
    public void setScope( Set<PRI> scope, Set<CRI> containerScope, boolean included ) {

        scope = ( scope == null ? new HashSet<PRI>( 0 ) : scope );
        containerScope = ( containerScope == null ? new HashSet<CRI>( 0 ) : containerScope );

        Set<PRI> pris = new HashSet<PRI>( );
        Set<CRI> cris = new HashSet<CRI>( );

        if ( included ) {
            for ( Iterator<MRI> elementIter = this.elements.iterator( ); elementIter.hasNext( ); ) {
                MRI element = elementIter.next( );
                PRI priOfMri = element.getPri( );
                CRI criOfMri = priOfMri.getCri( );

                if ( scope.contains( priOfMri ) || containerScope.contains( criOfMri ) ) {
                    pris.add( priOfMri );
                    cris.add( criOfMri );
                } else {
                    // not in scope, remove element
                    elementIter.remove( );
                }
            }
        } else {
            for ( Iterator<MRI> elementIter = this.elements.iterator( ); elementIter.hasNext( ); ) {
                MRI element = elementIter.next( );
                PRI priOfMri = element.getPri( );
                CRI criOfMri = priOfMri.getCri( );

                if ( !scope.contains( priOfMri ) || !containerScope.contains( criOfMri ) ) {
                    pris.add( priOfMri );
                    cris.add( criOfMri );
                } else {
                    // not in scope, remove element
                    elementIter.remove( );
                }
            }
        }
        super.setScope( pris, cris, true );
    }

    /**
     * the scope of a fixed set is always inclusive as it cannot be larger than
     * the implicit scope of the fixed set of elements.
     */
    @Override
    public boolean isScopeInclusive( ) {

        return true;
    }

    @Override
    protected void printScope( StringBuilder mainEntryString, int indent ) {

        Set<MRI> els = getElements( );

        els = ( els == null ? new HashSet<MRI>( 0 ) : els );

        String prefix = MQLAuxServices.SPACE_T + MQLAuxServices.IN_T + MQLAuxServices.SPACE_T + MQLAuxServices.ELEMENTS_T + MQLAuxServices.OPENCURLY_T;

        Iterator<MRI> elsIterator = els.iterator( );

        if ( elsIterator.hasNext( ) ) {
            mainEntryString.append( MQLAuxServices.newLine( indent ) + prefix + elsIterator.next( ).toString( ) );

            for ( ; elsIterator.hasNext( ); ) {
                MRI elMRI = elsIterator.next( );
                mainEntryString.append( MQLAuxServices.COMMA_T + MQLAuxServices.newLine( indent + prefix.length( ) ) );
                mainEntryString.append( elMRI.toString( ) );
            }
        }
        mainEntryString.append( MQLAuxServices.CLOSECURLY_T );
    }

    /*
     * FQL
     */

    public MRI[] getFixedElements( ) {

        Set<MRI> scopedMris = getElements( );
        return scopedMris.toArray( new MRI[scopedMris.size( )] );
    }

}

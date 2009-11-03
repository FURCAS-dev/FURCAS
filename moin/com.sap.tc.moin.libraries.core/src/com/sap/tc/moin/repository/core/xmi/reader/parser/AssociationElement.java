package com.sap.tc.moin.repository.core.xmi.reader.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationInternal;

import org.xml.sax.Attributes;

import com.sap.tc.moin.repository.core.xmi.reader.LinkEnd;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.messages.core.XMI;

/**
 * Instances of this class are created for top-level association elements in the
 * XMI document, directly below <code>&lt;XMI.content&gt;</code>.
 */
class AssociationElement extends XmiElement implements UnresolvedReferencesCounter {

    /**
     * The association represented by this XmiElement.
     */
    private AssociationInternal association;

    /**
     * Counts the number of still unresolved references. The variable is
     * modified by the methods in the {@link UnresolvedReferencesCounter}
     * interface. This counter being zero is one of the pre-conditions for link
     * creation, the other one being <code>{@link #endReached} == true</code>.
     */
    private int unresolvedRefsCounter;

    /**
     * This flag indicates that the complete association element including all
     * sub-elements has been read. Links will not be created until this flag is
     * <code>true</true> and the {@link #unresolvedRefsCounter} is zero.
     */
    private boolean endReached;

    /**
     * The list of read elements forming the link ends.
     */
    private List<Object> elements;

    AssociationElement( XmiElement parent, XmiContext context, AssociationInternal assoc ) {

        super( parent, context );
        association = assoc;
        unresolvedRefsCounter = 0;
        endReached = false;
        elements = new ArrayList<Object>( );
    }

    @Override
    XmiElement startElement( String qName, Attributes attrs ) {

        Object ref = context.resolveQualifiedName( qName );
        if ( !( ref instanceof AssociationEnd ) ) {
            throw new MoinLocalizedBaseRuntimeException( XMI.NOTASSOCEND, qName );
        }
        return new ObjectValues( this, context );
    }

    @Override
    void receiveValue( Object value ) {

        if ( value instanceof List ) {
            elements.add( ( (List) value ).get( 0 ) );
        } else {
            if ( value instanceof UnresolvedReference ) {
                ( (UnresolvedReference) value ).setOwner( this );
            }
            elements.add( value );
        }
    }

    @Override
    XmiElement endElement( String qName ) {

        // Check whether an even number of elements have been read or not.
        if ( elements.size( ) % 2 != 0 ) {
            throw new MoinLocalizedBaseRuntimeException( XMI.EVENNUMBEROFLINKENDSEXPECTED, elements.size( ) );
        }
        endReached = true;
        if ( unresolvedRefsCounter == 0 ) {
            createLinks( );
        }
        return parent;
    }

    /**
     * Creates one link for each pair of link ends in the {@link #elements}
     * list. The entries in this list are expected to be sorted correctly,
     * according to the order of association ends in the metamodel.
     */
    void createLinks( ) {

        for ( Iterator it = elements.iterator( ); it.hasNext( ); ) {
            Object first = it.next( );
            Object second = it.next( );
            LinkEnd firstEnd = null;
            LinkEnd secondEnd = null;
            if ( first instanceof UnresolvedReference ) {
                // must be resolvable now, since the ref-counter is zero
                firstEnd = (LinkEnd) ( (UnresolvedReference) first ).getValue( );
            } else {
                firstEnd = (LinkEnd) first;
            }
            if ( second instanceof UnresolvedReference ) {
                // must be resolvable now, since the ref-counter is zero
                secondEnd = (LinkEnd) ( (UnresolvedReference) second ).getValue( );
            } else {
                secondEnd = (LinkEnd) second;
            }
            context.linkComplete( association, firstEnd, secondEnd );
        }
    }

    boolean isReadingEvenEnd( ) {

        return ( elements.size( ) % 2 != 0 );
    }

    AssociationInternal getAssociation( ) {

        return association;
    }

    String getMofIdOfCurrentElement( ) {

        // Is the following cast always correct, or can UnresolvableReference occur?
        return ( (LinkEnd) elements.get( elements.size( ) - 1 ) ).getMofId( );
    }

    // implementation of UnresolvedReferencesCounter interface

    public void increaseUnresolvedRefs( ) {

        unresolvedRefsCounter++;
    }

    public void decreaseUnresolvedRefs( ) {

        unresolvedRefsCounter--;
        if ( endReached && ( unresolvedRefsCounter == 0 ) ) {
            createLinks( );
        }
    }
}
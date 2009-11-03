package com.sap.tc.moin.repository.core.xmi.reader.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.xmi.reader.InstanceInfo;
import com.sap.tc.moin.repository.core.xmi.reader.LinkEnd;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ReferenceInternal;

/**
 * Instances of this class are used to set the value of a reference later, as
 * soon as all needed references are resolved. It implements
 * {@link com.sap.tc.moin.repository.core.xmi.reader.parser.UnresolvedReferencesCounter}
 * , so it gets notified when the situation occurs.
 */
class ReferenceHandler implements UnresolvedReferencesCounter {

    // the instance containing this reference
    private InstanceInfo owner;

    // related reference
    private ReferenceInternal reference;

    // reference values
    private List<Object> values = new ArrayList<Object>( );

    // counter of unresolved references
    private int unresolvedRefsCounter = 0;

    // context
    private XmiContext context;

    // Whether the links for this reference should be ignored or not.
    private boolean ignoreLinks;

    ReferenceHandler( Reference ref, InstanceInfo instance, List args, XmiContext ctx ) {

        owner = instance;
        reference = (ReferenceInternal) ref;
        context = ctx;
        checkIgnoreLinks( );
        for ( Iterator it = args.iterator( ); it.hasNext( ); ) {
            Object value = it.next( );
            if ( value instanceof UnresolvedReference ) {
                Object val = ( (UnresolvedReference) value ).getValue( );
                if ( val != null ) {
                    value = val;
                } else {
                    ( (UnresolvedReference) value ).setOwner( this );
                }
            }
            values.add( value );
        }
        if ( unresolvedRefsCounter == 0 ) {
            setReference( );
        }
    }

    /**
     * Checks whether the links for this reference should be ignored or not, and
     * sets the {@link #ignoreLinks} variable accordingly.
     * <p>
     * Ignoring the links for the current reference is necessary if:
     * <ul>
     * <li>we are currently operating in <em>import mode</em></li>
     * <li>the association is ordered</li>
     * <li>the association has MOF references on both sides</li>
     * <li>the {@link #reference} exposes the ordered association end.
     * </ul>
     * If all these conditions are fulfilled, we know that:
     * <ul>
     * <li>each link appears <b>twice</b> in the set of imported XMI documents
     * (according to the XMI specification)</li>
     * <li>we are currently on that side of the association that does <b>not</b>
     * carry any ordering information.</li>
     * </ul>
     * Therefore, in order to get the correct ordering in the LinkContainer, we
     * need to skip the links on this side of the association.
     */
    private void checkIgnoreLinks( ) {

        ignoreLinks = false;
        if ( !context.isLoadingPartition( ) ) {
            //FIXME HACK!!!
            CoreConnection connection = context.getSession( ) != null ? context.getSession( ).getConnections( ).iterator( ).next( ) : null;
            AssociationEndInternal exposedEnd = (AssociationEndInternal) ( (AssociationEndInternal) reference.getReferencedEnd( connection ) ).otherEnd( connection );
            if ( exposedEnd.getMultiplicity( ).isOrdered( ) ) {
                AssociationEnd otherEnd = exposedEnd.otherEnd( connection );
                JmiList<Reference> refs = (JmiList<Reference>) context.getJmiHelper( ).getReferences( context.getSession( ), otherEnd );
                if ( refs != null && !refs.isEmpty( context.getSession( ) ) ) {
                    ignoreLinks = true;
                }
            }
        }
    }

    private void setReference( ) {

        if ( !ignoreLinks ) {
            // If the links are relevant, tell the XmiContext about them.
            for ( Iterator it = values.iterator( ); it.hasNext( ); ) {
                Object value = it.next( );
                Object referenced = value;
                if ( value instanceof UnresolvedReference ) {
                    // must be resolvable now, since the ref-counter is zero
                    referenced = ( (UnresolvedReference) value ).getValue( );
                } else if ( value instanceof Instance ) {
                    referenced = ( (Instance) value ).getInfo( );
                }
                AssociationEndInternal end = context.getReferencedEnd( reference );
                AssociationInternal association = (AssociationInternal) context.getContainer( end );
                List<AssociationEnd> ends = context.getAssociationEnds( association );
                boolean isFirst = ( ends.get( 0 ).equals( end ) );
                LinkEnd first = isFirst ? (LinkEnd) referenced : owner;
                LinkEnd second = isFirst ? owner : (LinkEnd) referenced;
                context.linkComplete( association, first, second );
            }
        }
    }

    public void increaseUnresolvedRefs( ) {

        unresolvedRefsCounter++;
    }

    public void decreaseUnresolvedRefs( ) {

        unresolvedRefsCounter--;
        if ( unresolvedRefsCounter == 0 ) {
            setReference( );
        }
    }
}

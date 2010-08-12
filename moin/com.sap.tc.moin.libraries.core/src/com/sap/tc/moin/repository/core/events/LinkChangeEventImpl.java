package com.sap.tc.moin.repository.core.events;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.__impl.ModelElementInternal;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.MoinReference;
import com.sap.tc.moin.repository.core.links.JmiListImpl;
import com.sap.tc.moin.repository.events.type.LinkChangeEvent;
import com.sap.tc.moin.repository.shared.util.QualifiedName;

/**
 * This is the implementation of
 * {@link com.sap.tc.moin.repository.events.type.LinkChangeEvent}
 * 
 * @author Daniel Vocke (D044825)
 */
public abstract class LinkChangeEventImpl extends ModelChangeEventImpl implements LinkChangeEvent {

    protected MRI associationMri = null;

    protected int position = 0;

    // needed for PartitionMembershipFilter
    protected List<PRI> affectedPartitionPRIs = new ArrayList<PRI>( 2 );

    // linkEndMetaObjectMris and linkEndInstanceMris are needed for ClassAtLinkEndFilter and InstanceAtLinkEndFilter.
    protected MRI linkEndInstanceMri0;

    protected MRI linkEndInstanceMri1;

    protected List<LRI> linkEndInstanceLris;

    protected MRI storedLinkEndMri;

    protected LRI nonStoredLinkEndLri;

    /**
     * Constructor
     * 
     * @param triggeringConnection
     */
    protected LinkChangeEventImpl( CoreConnection triggeringConnection ) {

        super( triggeringConnection );
        classFilterLris = new HashSet<LRI>( 4 );
    }

    protected LinkChangeEventImpl( CoreConnection triggeringConnection, EndStorageLink link, int position ) {

        super( triggeringConnection );
        classFilterLris = new HashSet<LRI>( 4 );
        associationMri = retrieveElementMri( link.getMetaObject( ) );

        this.position = position;

        storedLinkEndMri = link.getStorageEnd( ).getMri( triggeringConnection.getSession( ) );
        nonStoredLinkEndLri = link.getOtherEnd( ).getLri( );

        for ( int endNumber = 0; endNumber < 2; endNumber++ ) {
            MoinReference linkEndRef = link.getEnd( endNumber );
            RefFeatured elementAtLinkEnd = (RefFeatured) linkEndRef.getWithoutException( triggeringConnection.getSession( ) );
            if ( elementAtLinkEnd != null ) {
                if ( endNumber == 0 ) {
                    linkEndInstanceMri0 = retrieveElementMri( elementAtLinkEnd );
                } else {
                    linkEndInstanceMri1 = retrieveElementMri( elementAtLinkEnd );
                }
                classFilterLris.add( retrieveElementLri( elementAtLinkEnd.refMetaObject( ) ) );
                storeElementForCompositeParentCalculation( elementAtLinkEnd, endNumber );
            }
        }
        /*
         * Clients that registered using a PackageExtentFilter will only get
         * notifications if the Link's meta object is contained in the package
         * extent. The LinkEnd's package extents are ignored
         */
        immediatePackageExtentLri = retrieveElementLri( link.getMetaObject( ).refImmediatePackage( ) );

        /*
         * Clients that registered using a PartitionMembershipFilter will
         * probably expect to get notified about LinkChanges if the storage is
         * set to the appropriate partition
         */
        affectedPartitionPRIs.add( link.getStorageEndMri( ).getPri( ) );
    }



    /*
     * @see com.sap.tc.moin.repository.events.LinkChangeEvent#getLinkEndA()
     */
    public MRI getFirstLinkEndMri( ) {

        return linkEndInstanceMri0;
    }

    /*
     * @see
     * com.sap.tc.moin.repository.events.LinkChangeEvent#getLinkEndA(com.sap
     * .tc.moin.repository.core.impl.Connection)
     */
    public RefObject getFirstLinkEnd( Connection resolvingConnection ) {

        return (RefObject) ( resolvingConnection.getElement( getFirstLinkEndMri( ) ) );
    }

    /*
     * @see
     * com.sap.tc.moin.repository.events.LinkChangeEvent#getLinkEndAPosition()
     */
    public int getPosition( ) {

        return position;
    }

    /*
     * @see com.sap.tc.moin.repository.events.LinkChangeEvent#getLinkEndB()
     */
    public MRI getSecondLinkEndMri( ) {

        return linkEndInstanceMri1;
    }

    /*
     * @see
     * com.sap.tc.moin.repository.events.LinkChangeEvent#getLinkEndB(com.sap
     * .tc.moin.repository.core.impl.Connection)
     */
    public RefObject getSecondLinkEnd( Connection resolvingConnection ) {

        return (RefObject) ( resolvingConnection.getElement( getSecondLinkEndMri( ) ) );
    }

    /*
     * @see LinkChangeEvent#getAffectedMetaObjectMri()
     */
    public MRI getAffectedMetaObjectMri( ) {

        return associationMri;
    }

    /*
     * @see
     * com.sap.tc.moin.repository.events.LinkChangeEvent#getAffectedMetaObject
     * (com.sap.tc.moin.repository.core.impl.Connection)
     */
    public RefFeatured getAffectedMetaObject( Connection resolvingConnection ) {

        return (RefFeatured) ( resolvingConnection.getElement( getAffectedMetaObjectMri( ) ) );
    }

    /**
     * if a client registered with an InstanceFilter of a ClassFilter, no events
     * shall be received. This method always returns <code>null</code>.
     * 
     * @see com.sap.tc.moin.repository.events.ChangeEventImpl#getAffectedElementsMRIs()
     * @return <code>null</code>
     */
    @Override
    public Collection<LRI> getAffectedElementsLris( ) {

        if ( linkEndInstanceLris == null ) {
            linkEndInstanceLris = new ArrayList<LRI>( 2 );
            linkEndInstanceLris.add( linkEndInstanceMri0.getLri( ) );
            linkEndInstanceLris.add( linkEndInstanceMri1.getLri( ) );
        }
        return linkEndInstanceLris;
    }

    @Override
    public Object getAffectedPartitionsPRIs( ) {

        return affectedPartitionPRIs;
    }

    @Override
    protected String getParameterString() {

	StringBuilder buf = new StringBuilder("association="); //$NON-NLS-1$
	ModelElementInternal metaObject = (ModelElementInternal) getAffectedMetaObject(eventTriggerConnection);
	buf.append(QualifiedName.toDotSeparatedString(metaObject.getQualifiedName(eventTriggerConnection)));
	if (position != -1) {
	    buf.append(",position=").append(position); //$NON-NLS-1$
	}
	buf.append(",MRI1=").append(String.valueOf(getFirstLinkEndMri())); //$NON-NLS-1$
	buf.append(",MRI2=").append(String.valueOf(getSecondLinkEndMri())); //$NON-NLS-1$

	Association association = (Association) metaObject;

	int associationEnds = 0;

	Iterator<ModelElement> iter = ((JmiListImpl<ModelElement>) association.getContents()).iterator(eventTriggerConnection);

	while (iter.hasNext()) {
	    ModelElement content = iter.next();
	    if (content instanceof AssociationEnd) {
		associationEnds++;
		buf.append(",AE" + (associationEnds + 1) + "=").append(((AssociationEnd) content).getName());
	    } else {
		System.out.println("noAssocEnd: " + content);
	    }
	}
	assert associationEnds == 2;

	return buf.toString();
    }

    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode( ) {

        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ( ( linkEndInstanceLris == null ) ? 0 : linkEndInstanceLris.hashCode( ) );
        result = PRIME * result + ( ( associationMri == null ) ? 0 : associationMri.hashCode( ) );
        result = PRIME * result + position;
        return result;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals( Object obj ) {

        if ( this == obj ) {
            return true;
        }
        if ( obj == null ) {
            return false;
        }
        if ( getClass( ) != obj.getClass( ) ) {
            return false;
        }
        final LinkChangeEventImpl other = (LinkChangeEventImpl) obj;
        if ( linkEndInstanceLris == null ) {
            if ( other.linkEndInstanceLris != null ) {
                return false;
            }
        } else if ( !linkEndInstanceLris.equals( other.linkEndInstanceLris ) ) {
            return false;
        }
        if ( associationMri == null ) {
            if ( other.associationMri != null ) {
                return false;
            }
        } else if ( !associationMri.equals( other.associationMri ) ) {
            return false;
        }
        if ( position != other.position ) {
            return false;
        }
        return true;
    }

    public MRI getStoredLinkEndMri( ) {

        return storedLinkEndMri;
    }

    public LRI getNonStoredLinkEndLri( ) {

        return nonStoredLinkEndLri;
    }
}

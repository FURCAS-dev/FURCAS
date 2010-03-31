package com.sap.tc.moin.repository.test.ocl.ia.mockobjects;

import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.events.type.LinkChangeEvent;

/**
 * Abstract mock event
 */
public abstract class LinkChangeEventImpl extends ModelChangeEventImpl implements LinkChangeEvent {

    private RefFeatured affectedMetaObject;

    private MRI affectedMetaObjectMRI;

    private MRI linkA;

    private MRI linkB;

    /**
     * @param orderedElements
     * @param metaObject
     */
    public LinkChangeEventImpl( CoreConnection connection, List<MRI> orderedElements, RefFeatured metaObject ) {

        super( connection );
        this.affectedMetaObject = metaObject;
        this.affectedMetaObjectMRI = new MRIImpl( metaObject );
        this.linkA = orderedElements.get( 0 );
        this.linkB = orderedElements.get( 1 );

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.tc.moin.events.LinkChangeEvent#getAffectedMetaObject(com.sap.tc.moin.repository.core.Connection)
     */
    public RefFeatured getAffectedMetaObject( @SuppressWarnings( "unused" )
    Connection resolvingConnection ) {

        return this.affectedMetaObject;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.tc.moin.events.LinkChangeEvent#getAffectedMetaObjectMRI()
     */
    public MRI getAffectedMetaObjectMri( ) {

        return this.affectedMetaObjectMRI;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.tc.moin.events.LinkChangeEvent#getLinkEndA(com.sap.tc.moin.repository.core.Connection)
     */
    public RefObject getFirstLinkEnd( @SuppressWarnings( "unused" )
    Connection resolvingConnection ) {

        return (RefObject) ( (MRIImpl) this.linkA ).resolve( );
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.tc.moin.events.LinkChangeEvent#getLinkEndAMRI()
     */
    public MRI getFirstLinkEndMri( ) {

        return this.linkA;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.tc.moin.events.LinkChangeEvent#getLinkEndB(com.sap.tc.moin.repository.core.Connection)
     */
    public RefObject getSecondLinkEnd( @SuppressWarnings( "unused" )
    Connection resolvingConnection ) {

        return (RefObject) ( (MRIImpl) this.linkB ).resolve( );
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.tc.moin.events.LinkChangeEvent#getLinkEndBMRI()
     */
    public MRI getSecondLinkEndMri( ) {

        return this.linkB;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.tc.moin.events.LinkChangeEvent#getEndAPosition()
     */
    public int getPosition( ) {

        return -1;
    }

    public MRI getStoredLinkEndMri( ) {

        return null;
    }

    public LRI getNonStoredLinkEndLri( ) {

        return null;
    }

}

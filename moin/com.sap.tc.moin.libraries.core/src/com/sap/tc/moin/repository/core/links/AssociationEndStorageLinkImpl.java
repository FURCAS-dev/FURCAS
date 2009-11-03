/*
 * Created on 23.12.2004
 */
package com.sap.tc.moin.repository.core.links;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.core.AssociationExtent;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.MoinReference;
import com.sap.tc.moin.repository.core.MriReference;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;
import com.sap.tc.moin.repository.spi.ps.SpiAssociation;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiLink;

/**
 * This link implementation is for links that are instances of an association.
 * Therefore, the ends and their multiplicities are determined from that
 * association.
 * <p>
 * 
 * @author d043530
 */
public class AssociationEndStorageLinkImpl extends AbstractEndStorageLinkImpl implements EndStorageLink, SpiLink {

    /**
     * The association of which this link is an instance.
     */
    private final Association association;

    /**
     * The cached result for {@link #getOrderedEnd}.
     */
    private final byte orderedEnd;

    /**
     * Creates a new link that instantiates the association <tt>a</tt> and links
     * the model elements passed as <tt>ends</tt>.
     * 
     * @param connection
     * @param ends the references pointing to the elements that this link
     * connects
     * @param association the association of which the new link is an instance
     */
    public AssociationEndStorageLinkImpl( int storageEndNumber, MriReference storageEnd, MoinReference otherEnd, Association association, byte orderedEnd, byte compositeEnd ) {

        super( storageEndNumber, storageEnd, otherEnd );
        this.association = association;
        this.orderedEnd = orderedEnd;
        this.compositeEnd = compositeEnd;
    }

    /**
     * Retrieves the association of which this link is an instance
     */
    public Association getAssociation( ) {

        return association;
    }

    /**
     * Returns the {@link #attribute} that is the metaobject for this link
     */
    public RefObject getMetaObject( ) {

        return getAssociation( );
    }

    /**
     * If one of the association ends is composite, its index is returned.
     * Otherwise, <tt>-1</tt> is returned. The result is computed when this link
     * is constructed.
     */
    public int getOrderedEnd( ) {

        return orderedEnd;
    }

    /**
     * Links that are instance of an association never tolerate duplicates
     * because of MOF 1.4 constraint C-40. Even if an association end has its
     * uniqueness set to <tt>false</tt>, this can only be the case for
     * association ends with an upper multiplicity of 1 which in turn implies
     * that there can be no duplicate links.
     */
    public boolean canHaveDuplicates( ) {

        return false;
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.repository.core.impl.Link#getUpperBound(int)
     */
    public int getUpperBound( CoreSession session, int end ) {

        SpiJmiHelper jmiHelper = ( (CorePartitionable) association ).get___Workspace( ).getWorkspaceSet( ).getMoin( ).getJmiHelper( );
        AssociationExtent extent = (AssociationExtent) jmiHelper.getRefAssociationForAssociation( session, association );
        return extent.get___AssociationEnds( ).get( end ).getMultiplicity( ).getUpper( );
    }

    /**
     * The string representation of an attribute link contains the name of the
     * attribute, its MOF ID and a string representation of the ends which is
     * computed by {@link AbstractLinkImpl#toString}.
     */
    @Override
    public String toString( ) {

        StringBuffer result = new StringBuffer( );
        result.append( "Association link for association " ); //$NON-NLS-1$
        result.append( getAssociation( ).getName( ) );
        result.append( " with MOF ID " );//$NON-NLS-1$
        result.append( getAssociation( ).refMofId( ) );
        result.append( ". " );//$NON-NLS-1$
        result.append( super.toString( ) );
        return result.toString( );
    }

    //
    // Custom Parser / Serializer methods
    //

    public SpiAssociation get___Association( ) {

        SpiJmiHelper jmiHelper = ( (CorePartitionable) association ).get___Workspace( ).getWorkspaceSet( ).getMoin( ).getJmiHelper( );
        return (SpiAssociation) jmiHelper.getRefAssociationForAssociation( (CoreSession) null /* session */, association );
    }
}
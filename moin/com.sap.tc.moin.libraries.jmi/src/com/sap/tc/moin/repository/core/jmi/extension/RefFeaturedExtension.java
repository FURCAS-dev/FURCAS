package com.sap.tc.moin.repository.core.jmi.extension;

import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.RefException;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.EndStorageLink;

public interface RefFeaturedExtension extends RefFeatured, RefBaseObjectExtension {


    public void set___Value( Session session, String featureName, Object value );

    public void set___Value( Session session, int featureNumber, Object value );

    public void initialize___Values( Connection connection );

    public Object invoke___Operation( Connection connection, int operationNumber, List<? extends Object> args ) throws RefException;

    public void set___AssociationLink( String associationEndMofId, EndStorageLink value );

    public void set___AttributeLink( String attributeMofId, EndStorageLink value );

    public EndStorageLink get___AssociationLink( String associationEndMofId );

    public EndStorageLink get___AttributeLink( String attributeMofId );

    /**
     * Returns all links stored at this element (association links as well as
     * attribute links).
     */
    public List<EndStorageLink> get___AllStoredLinks( );

    /**
     * Returns all association links stored at this element.
     */
    public List<EndStorageLink> get___AllStoredAssociationLinks( );

    /**
     * Returns the multiplicity-n links stored at this element for the given
     * association end.
     */
    public Collection<EndStorageLink> get___AssociationLinks( String associationEndMofId );

    /**
     * Returns the multiplicity-n links stored at this element for the given
     * object-valued attribute.
     */
    public Collection<EndStorageLink> get___AttributeLinks( String attributeMofId );

    /**
     * Sets the multiplicity-n links stored at this element for the given
     * association end.
     */
    public void set___AssociationLinks( Collection<EndStorageLink> links, String associationEndMofId );

    /**
     * Sets the multiplicity-n links stored at this element for the given
     * object-valued attribute.
     */
    public void set___AttributeLinks( Collection<EndStorageLink> links, String attributeMofId );

    /**
     * Sets all member variables holding links or collections of links to
     * 'null'.
     */
    public List<EndStorageLink> clear___AllLinks( );


    public EndStorageLink get___EndStorageLink( CoreConnection connection, CorePartitionable linkedElement, RefObject attributeOrAssociation, int endNumberOfLinkedElement );

    /**
     * Required by custom parser / serializer functionality. For
     * multiplicity-one attributes it behaves like
     * {@link #set___Value(Connection, String, Object)}, while for
     * multiplicity-many attributes it allows to incrementally build up a
     * multi-valued attribute list instead of setting the complete list at once.
     */
    public void addOrSet___Value( CoreSession session, String attributeName, Object value );
}
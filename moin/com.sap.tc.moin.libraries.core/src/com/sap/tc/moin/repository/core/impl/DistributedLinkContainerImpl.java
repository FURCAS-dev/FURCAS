package com.sap.tc.moin.repository.core.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.DistributedLinkContainer;
import com.sap.tc.moin.repository.core.EndStorageLink;

public final class DistributedLinkContainerImpl implements DistributedLinkContainer {

    /**
     * This map contains all EndStorageLinks stored at elements in this
     * partition, keyed by the LRI of the element at the non-storage end (=
     * otherEnd).
     */
    private Map<LRI, Map<String /* metaObjectMofId */, List<EndStorageLink>>> distributedLinks;

    public DistributedLinkContainerImpl( ) {

        this.distributedLinks = null;
    }

    public void addLink( LRI lriOfElement, EndStorageLink link ) {

        if ( distributedLinks == null ) {
            distributedLinks = new HashMap<LRI, Map<String, List<EndStorageLink>>>( );
        }
        Map<String, List<EndStorageLink>> linksPerMetaObject = distributedLinks.get( lriOfElement );
        List<EndStorageLink> links;
        if ( linksPerMetaObject == null ) {
            distributedLinks.put( lriOfElement, linksPerMetaObject = new IdentityHashMap<String, List<EndStorageLink>>( ) );
            linksPerMetaObject.put( link.getMetaObject( ).refMofId( ), links = new ArrayList<EndStorageLink>( 4 ) );
        } else {
            String mofIdOfMetaObject = link.getMetaObject( ).refMofId( );
            links = linksPerMetaObject.get( mofIdOfMetaObject );
            if ( links == null ) {
                linksPerMetaObject.put( mofIdOfMetaObject, links = new ArrayList<EndStorageLink>( 4 ) );
            }
        }
        links.add( link );
    }

    public void clear( ) {

        distributedLinks = null;
    }

    public List<EndStorageLink> getLinksForElement( CorePartitionable element ) {

        List<EndStorageLink> result = null;
        if ( distributedLinks != null ) {
            Map<String, List<EndStorageLink>> linksPerMetaObject = distributedLinks.get( element.get___Mri( ).getLri( ) );
            if ( linksPerMetaObject != null ) {
                result = new ArrayList<EndStorageLink>( );
                for ( List<EndStorageLink> linkCollection : linksPerMetaObject.values( ) ) {
                    for ( int i = 0, n = linkCollection.size( ); i < n; i++ ) {
                        result.add( linkCollection.get( i ) );
                    }
                }
            }
        }
        return result;
    }

    public List<EndStorageLink> getLinksForMetaObject( String metaObjectMofId, CorePartitionable elementAtEnd ) {

        List<EndStorageLink> result = null;
        if ( distributedLinks != null ) {
            Map<String, List<EndStorageLink>> linksPerMetaObject = distributedLinks.get( elementAtEnd.get___Mri( ).getLri( ) );
            if ( linksPerMetaObject != null ) {
                result = linksPerMetaObject.get( metaObjectMofId );
            }
        }
        return result;
    }

    public void removeLink( LRI lriOfElement, EndStorageLink link ) {

        if ( distributedLinks != null ) {
            Map<String, List<EndStorageLink>> linksPerMetaObject = distributedLinks.get( lriOfElement );
            if ( linksPerMetaObject != null ) {
                String mofIdOfMetaObject = link.getMetaObject( ).refMofId( );
                Collection<EndStorageLink> links = linksPerMetaObject.get( mofIdOfMetaObject );
                if ( links != null ) {
                    links.remove( link );
                    if ( links.isEmpty( ) ) {
                        linksPerMetaObject.remove( mofIdOfMetaObject );
                        if ( linksPerMetaObject.isEmpty( ) ) {
                            distributedLinks.remove( lriOfElement );
                            if ( distributedLinks.isEmpty( ) ) {
                                distributedLinks = null;
                            }
                        }
                    }
                }
            }
        }
    }

    public void trimToSize( ) {

        if ( distributedLinks != null ) {
            Collection<Map<String, List<EndStorageLink>>> maps = distributedLinks.values( );
            for ( Map<String, List<EndStorageLink>> map : maps ) {
                Collection<List<EndStorageLink>> linkLists = map.values( );
                for ( List<EndStorageLink> linkList : linkLists ) {
                    ( (ArrayList<EndStorageLink>) linkList ).trimToSize( );
                }
            }
        }
    }
}
package com.sap.tc.moin.repository.core.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.core.EndAndMetaObject;
import com.sap.tc.moin.repository.core.EndAndMetaObjectPool;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.OverflowContainer;

public final class OverflowContainerImpl implements OverflowContainer {

    private Map<LRI, Map<EndAndMetaObject, Collection<EndStorageLink>>> overflowLinksMultiplicityOne;

    private final EndAndMetaObjectPool endAndMetaObjectPool;

    public OverflowContainerImpl( EndAndMetaObjectPool endAndMetaObjectPool ) {

        this.endAndMetaObjectPool = endAndMetaObjectPool;
        this.overflowLinksMultiplicityOne = null;
    }

    public void add( EndStorageLink link ) {

        if ( overflowLinksMultiplicityOne == null ) {
            overflowLinksMultiplicityOne = new HashMap<LRI, Map<EndAndMetaObject, Collection<EndStorageLink>>>( );
        }
        LRI lri = link.getStorageEnd( ).getLri( );
        Map<EndAndMetaObject, Collection<EndStorageLink>> mapForLri = overflowLinksMultiplicityOne.get( lri );
        if ( mapForLri == null ) {
            overflowLinksMultiplicityOne.put( lri, mapForLri = new IdentityHashMap<EndAndMetaObject, Collection<EndStorageLink>>( ) );
        }
        EndAndMetaObject endAndMetaObject = endAndMetaObjectPool.getEndAndMetaObject( link.getEndNumberOfStorageEnd( ), link.getMetaObject( ) );
        Collection<EndStorageLink> links = mapForLri.get( endAndMetaObject );
        if ( links == null ) {
            mapForLri.put( endAndMetaObject, links = new ArrayList<EndStorageLink>( ) );
        }
        links.add( link );
    }

    public void remove( EndStorageLink link ) {

        if ( overflowLinksMultiplicityOne == null ) {
            return;
        }
        LRI lri = link.getStorageEnd( ).getLri( );
        Map<EndAndMetaObject, Collection<EndStorageLink>> mapForLri = overflowLinksMultiplicityOne.get( lri );
        if ( mapForLri == null ) {
            return;
        }
        EndAndMetaObject endAndMetaObject = endAndMetaObjectPool.getEndAndMetaObject( link.getEndNumberOfStorageEnd( ), link.getMetaObject( ) );
        Collection<EndStorageLink> links = mapForLri.get( endAndMetaObject );
        if ( links == null ) {
            return;
        }
        links.remove( link );
        if ( links.isEmpty( ) ) {
            mapForLri.remove( endAndMetaObject );
            if ( mapForLri.isEmpty( ) ) {
                overflowLinksMultiplicityOne.remove( lri );
                if ( overflowLinksMultiplicityOne.isEmpty( ) ) {
                    overflowLinksMultiplicityOne = null;
                }
            }
        }
    }

    public Collection<EndStorageLink> getOverflowLinks( LRI lriOfElement, EndAndMetaObject endAndMetaObject ) {

        Collection<EndStorageLink> result = null;
        if ( overflowLinksMultiplicityOne != null ) {
            Map<EndAndMetaObject, Collection<EndStorageLink>> mapForLri = overflowLinksMultiplicityOne.get( lriOfElement );
            if ( mapForLri != null ) {
                result = mapForLri.get( endAndMetaObject );
            }
        }
        if ( result == null ) {
            result = Collections.emptyList( );
        }
        return result;
    }

    public Collection<EndStorageLink> getAllOverflowLinks( LRI lriOfElement ) {

        Collection<EndStorageLink> result = null;
        if ( overflowLinksMultiplicityOne != null ) {
            Map<EndAndMetaObject, Collection<EndStorageLink>> mapForLri = overflowLinksMultiplicityOne.get( lriOfElement );
            if ( mapForLri != null ) {
                result = new ArrayList<EndStorageLink>( );
                for ( Collection<EndStorageLink> links : mapForLri.values( ) ) {
                    result.addAll( links );
                }
            }
        }
        if ( result == null ) {
            result = Collections.emptyList( );
        }
        return result;
    }

    public List<EndStorageLink> getCompositeParentLinks( LRI lriOfElement ) {

        List<EndStorageLink> result = null;
        if ( overflowLinksMultiplicityOne != null ) {
            Map<EndAndMetaObject, Collection<EndStorageLink>> mapForLri = overflowLinksMultiplicityOne.get( lriOfElement );
            if ( mapForLri != null ) {
                result = new ArrayList<EndStorageLink>( );
                for ( Collection<EndStorageLink> links : mapForLri.values( ) ) {
                    for ( EndStorageLink link : links ) {
                        int componentEnd = link.getComponentEnd( );
                        if ( componentEnd != -1 && link.getEnd( componentEnd ).getLri( ).equals( lriOfElement ) ) {
                            result.add( link );
                        }
                    }
                }
            }
        }
        return result;
    }
}
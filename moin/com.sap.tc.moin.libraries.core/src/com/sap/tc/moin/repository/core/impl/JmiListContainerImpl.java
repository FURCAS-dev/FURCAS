package com.sap.tc.moin.repository.core.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.core.EndAndMetaObject;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.JmiListContainer;

@SuppressWarnings( "unchecked" )
public final class JmiListContainerImpl implements JmiListContainer {

    private Map<EndAndMetaObject, Map<LRI, JmiList>> jmiListsForEndAndMetaObject;

    public JmiListContainerImpl( ) {

        this.jmiListsForEndAndMetaObject = new IdentityHashMap<EndAndMetaObject, Map<LRI, JmiList>>( );
    }

    public final void registerJmiList( EndAndMetaObject endAndMetaObject, LRI fromEndLri, JmiList jmiList ) {

        Map<LRI, JmiList> jmiLists = jmiListsForEndAndMetaObject.get( endAndMetaObject );
        if ( jmiLists == null ) {
            jmiListsForEndAndMetaObject.put( endAndMetaObject, jmiLists = new HashMap<LRI, JmiList>( ) );
        }
        jmiLists.put( fromEndLri, jmiList );
    }

    public final JmiList findJmiList( EndAndMetaObject endAndMetaObject, LRI fromEndLri ) {

        Map<LRI, JmiList> jmiLists = jmiListsForEndAndMetaObject.get( endAndMetaObject );
        if ( jmiLists != null ) {
            return jmiLists.get( fromEndLri );
        }
        return null;
    }

    public Map<EndAndMetaObject, JmiList> getRegisteredJmiLists( LRI fromEndLri ) {

        Map<EndAndMetaObject, JmiList> result = null;
        for ( Entry<EndAndMetaObject, Map<LRI, JmiList>> entry : jmiListsForEndAndMetaObject.entrySet( ) ) {
            EndAndMetaObject endAndMetaObject = entry.getKey( );
            Map<LRI, JmiList> jmiLists = entry.getValue( );
            JmiList jmiList = jmiLists.get( fromEndLri );
            if ( jmiList != null ) {
                if ( result == null ) {
                    result = new HashMap<EndAndMetaObject, JmiList>( );
                }
                result.put( endAndMetaObject, jmiList );
            }
        }
        if ( result != null ) {
            return result;
        }
        return Collections.emptyMap( );
    }

    public void invalidateJmiLists( ) {

        for ( Map<LRI, JmiList> jmiLists : jmiListsForEndAndMetaObject.values( ) ) {
            for ( JmiList jmiList : jmiLists.values( ) ) {
                jmiList.invalidate( );
            }
        }
    }

    public void invalidateAndRemoveJmiLists( LRI fromEndLri ) {

        for ( Iterator<Entry<EndAndMetaObject, Map<LRI, JmiList>>> entryIt = jmiListsForEndAndMetaObject.entrySet( ).iterator( ); entryIt.hasNext( ); ) {
            Map<LRI, JmiList> jmiLists = entryIt.next( ).getValue( );
            JmiList jmiList = jmiLists.remove( fromEndLri );
            if ( jmiList != null ) {
                jmiList.invalidate( );
                if ( jmiLists.isEmpty( ) ) {
                    entryIt.remove( );
                }
            }
        }
    }
}

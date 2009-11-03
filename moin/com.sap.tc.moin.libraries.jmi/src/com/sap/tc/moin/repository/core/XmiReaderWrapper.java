package com.sap.tc.moin.repository.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.mmi.xmi.MalformedXMIException;

import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.repository.xmi.ImportService;
import com.sap.tc.moin.repository.xmi.XmiReader;

@SuppressWarnings( "unchecked" )
public final class XmiReaderWrapper extends AbstractConnectionAwareWrapper<XmiReader> implements XmiReader {

    private final XmiReader xmiReader;

    public XmiReaderWrapper( CoreConnection connection ) {

        super( connection, connection.getSession( ).getWorkspaceSet( ).getSynchronizationManager( ) );
        this.xmiReader = connection.getXmiReader( );
    }

    @Override
    public boolean equals( Object obj ) {

        if ( obj == this ) {
            return true;
        }
        if ( obj instanceof XmiReaderWrapper ) {
            return xmiReader.equals( ( (XmiReaderWrapper) obj ).xmiReader );
        }
        return false;
    }

    @Override
    public int hashCode( ) {

        return xmiReader.hashCode( );
    }

    @Override
    public String toString( ) {

        return xmiReader.toString( );
    }

    public Collection read( String uriOfXmiDocument, RefPackage extent ) throws IOException, MalformedXMIException {

        Collection readerResult;
        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            if ( extent != null ) {
                readerResult = xmiReader.read( uriOfXmiDocument, ( (Wrapper<RefPackage>) extent ).unwrap( ) );
            } else {
                readerResult = xmiReader.read( uriOfXmiDocument, (RefPackage) null );
            }
        }

        return getWrappedCollection( readerResult );
    }

    public Collection read( String uriOfXmiDocument, RefPackage[] extents ) throws IOException, MalformedXMIException {

        Collection readerResult;
        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );

            RefPackage[] unwrappedExtents = new RefPackage[extents.length];
            for ( int i = 0; i < extents.length; i++ ) {
                if ( extents[i] != null ) {
                    unwrappedExtents[i] = ( (Wrapper<RefPackage>) extents[i] ).unwrap( );
                } else {
                    unwrappedExtents[i] = null;
                }
            }

            attachConnectionIfRequired( );
            readerResult = xmiReader.read( uriOfXmiDocument, unwrappedExtents );
        }
        return getWrappedCollection( readerResult );
    }

    public Collection read( InputStream stream, String uriOfXmiDocument, RefPackage extent ) throws IOException, MalformedXMIException {

        Collection readerResult;
        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            if ( extent != null ) {
                readerResult = xmiReader.read( stream, uriOfXmiDocument, ( (Wrapper<RefPackage>) extent ).unwrap( ) );
            } else {
                readerResult = xmiReader.read( stream, uriOfXmiDocument, (RefPackage) null );
            }
        }
        return getWrappedCollection( readerResult );
    }

    public Collection read( InputStream stream, String uriOfXmiDocument, RefPackage[] extents ) throws IOException, MalformedXMIException {

        Collection readerResult;

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );

            RefPackage[] unwrappedExtents = new RefPackage[extents.length];
            for ( int i = 0; i < extents.length; i++ ) {
                if ( extents[i] != null ) {
                    unwrappedExtents[i] = ( (Wrapper<RefPackage>) extents[i] ).unwrap( );
                } else {
                    unwrappedExtents[i] = null;
                }
            }
            attachConnectionIfRequired( );
            readerResult = xmiReader.read( stream, uriOfXmiDocument, unwrappedExtents );
        }
        return getWrappedCollection( readerResult );
    }

    public void setImportService( ImportService importService ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            xmiReader.setImportService( importService );
        } finally {
            synchronizationManager.releaseReadLock( );
        }

    }

    public ImportService getImportService( ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            return xmiReader.getImportService( );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public XmiReader unwrap( ) {

        return xmiReader;
    }

    private Collection getWrappedCollection( Collection collection ) {

        Collection<RefObject> result = new LinkedHashSet<RefObject>( );
        for ( Iterator<RefObject> it = collection.iterator( ); it.hasNext( ); ) {
            result.add( connection.getWrapperForJmiObject( it.next( ) ) );
        }
        return result;
    }
}
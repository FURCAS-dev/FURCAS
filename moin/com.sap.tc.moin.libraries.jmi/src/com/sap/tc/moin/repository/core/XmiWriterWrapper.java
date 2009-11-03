package com.sap.tc.moin.repository.core;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.repository.xmi.XmiReferenceProvider;
import com.sap.tc.moin.repository.xmi.XmiWriter;

public class XmiWriterWrapper extends AbstractConnectionAwareWrapper<XmiWriter> implements XmiWriter {

    private final XmiWriter xmiWriter;

    public XmiWriterWrapper( CoreConnection connection ) {

        super( connection, connection.getSession( ).getWorkspaceSet( ).getSynchronizationManager( ) );
        this.xmiWriter = connection.getXmiWriter( );
    }

    public String getEncoding( ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            return xmiWriter.getEncoding( );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public XmiReferenceProvider getReferenceProvider( ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            return xmiWriter.getReferenceProvider( );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public boolean getUseIndentation( ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            return xmiWriter.getUseIndentation( );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public boolean getUseNamespaces( ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            return xmiWriter.getUseNamespaces( );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public boolean getUseTimestamp( ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            return xmiWriter.getUseTimestamp( );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public void setEncoding( String encoding ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            xmiWriter.setEncoding( encoding );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public void setReferenceProvider( XmiReferenceProvider provider ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            xmiWriter.setReferenceProvider( provider );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public void setUseIndentation( boolean indent ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            xmiWriter.setUseIndentation( indent );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public void setUseNamespaces( boolean useNamespaces ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            xmiWriter.setUseNamespaces( useNamespaces );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public void setUseTimestamp( boolean useTimestamp ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            xmiWriter.setUseTimestamp( useTimestamp );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public void write( OutputStream os, Collection objects, String xmiVersion ) throws IOException {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            xmiWriter.write( os, getUnwrappedCollection( objects ), xmiVersion );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public void write( OutputStream os, RefPackage extent, String xmiVersion ) throws IOException {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            xmiWriter.write( os, ( (Wrapper<RefPackage>) extent ).unwrap( ), xmiVersion );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public XmiWriter unwrap( ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            return xmiWriter;
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    @SuppressWarnings( "unchecked" )
    private Collection getUnwrappedCollection( Collection collection ) {

        if ( collection == null || collection.isEmpty( ) ) {
            return collection;
        }
        Collection result = new ArrayList<RefObject>( );
        for ( Iterator it = collection.iterator( ); it.hasNext( ); ) {
            Object obj = it.next( );
            if ( obj instanceof Wrapper ) {
                result.add( ( (Wrapper) obj ).unwrap( ) );
            } else {
                result.add( obj );
            }
        }
        return result;
    }

}
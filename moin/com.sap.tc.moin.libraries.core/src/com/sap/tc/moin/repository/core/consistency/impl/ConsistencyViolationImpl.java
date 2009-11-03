package com.sap.tc.moin.repository.core.consistency.impl;

import java.util.Locale;

import com.sap.tc.moin.repository.mmi.reflect.InvalidCallException;
import com.sap.tc.moin.repository.mmi.reflect.InvalidNameException;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.consistency.ConsistencyCorrectionHandle;
import com.sap.tc.moin.repository.consistency.ConsistencyViolation;
import com.sap.tc.moin.repository.core.ConnectionWrapper;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.util.MoinLocaleProvider;

public abstract class ConsistencyViolationImpl implements ConsistencyViolation {

    private static String[] NAME_ATTRIBUTES_TO_BE_TRIED = new String[] { "name", "id" }; //$NON-NLS-1$ //$NON-NLS-2$

    private String id;

    protected ConsistencyViolationRegistryImpl registry;

    public ConsistencyViolationImpl( ConsistencyViolationRegistryImpl eventRegistry ) {

        this.registry = eventRegistry;
    }

    public String getId( ) {

        if ( this.id == null ) {
            this.id = this.calculateId( );
        }
        return this.id;
    }

    /**
     * Calculate unique id.
     * 
     * @return
     */
    protected abstract String calculateId( );

    public abstract boolean validate( CoreConnection connection );

    public abstract String getDescription( CoreConnection connection, Locale locale );

    public abstract ConsistencyCorrectionHandle[] getCorrectionHandles( CoreConnection connection );

    protected String getElementName( MRI mri, CoreConnection connection ) {

        if ( connection != null ) {
            RefBaseObject element = connection.getElement( mri );
            return getElementName( connection, element );
        }
        return null;

    }

    protected String getElementName( LRI lri, CoreConnection connection ) {

        if ( connection != null ) {
            RefBaseObject element = connection.getElement( lri );
            return getElementName( connection, element );
        }
        return null;

    }

    private String getElementName( CoreConnection connection, RefBaseObject element ) {

        if ( element instanceof RefObject ) {
            RefObject refObject = (RefObject) element;
            for ( String attrName : NAME_ATTRIBUTES_TO_BE_TRIED ) {
                try {
                    Object name = ( (RefObjectImpl) refObject ).refGetValue( connection, attrName );
                    if ( name != null ) {
                        return name.toString( );
                    } else {
                        continue;
                    }
                } catch ( InvalidCallException ex ) {
                    continue;
                } catch ( InvalidNameException ex ) {
                    continue;
                }
            }
        }
        return null;
    }

    protected String shortenString( String string ) {

        String result = string;
        if ( string.length( ) > 40 ) {
            // take the first and last 15 characters
            String firstPart = string.substring( 0, 15 );
            String endPart = string.substring( string.length( ) - 40 );
            result = firstPart + " ... " + endPart; //$NON-NLS-1$
        }

        return result;
    }

    @Override
    public boolean equals( Object obj ) {

        if ( obj instanceof ConsistencyViolationImpl ) {
            return ( (ConsistencyViolationImpl) obj ).getId( ).equals( this.getId( ) );
        }
        return false;
    }

    @Override
    public int hashCode( ) {

        return this.id.hashCode( );
    }

    public boolean validate( Connection connection ) {

        CoreConnection coreConnection = null;

        if ( connection instanceof ConnectionWrapper ) {
            coreConnection = ( (ConnectionWrapper) connection ).unwrap( );
        } else {
            coreConnection = (CoreConnection) connection;
        }

        return this.validate( coreConnection );
    }

    public ConsistencyCorrectionHandle[] getCorrectionHandles( Connection connection ) {

        CoreConnection coreConnection = null;

        if ( connection instanceof ConnectionWrapper ) {
            coreConnection = ( (ConnectionWrapper) connection ).unwrap( );
        } else {
            coreConnection = (CoreConnection) connection;
        }

        return this.getCorrectionHandles( coreConnection );
    }

    public String getDescription( Connection connection, Locale locale ) {

        CoreConnection coreConnection = null;

        if ( connection instanceof ConnectionWrapper ) {
            coreConnection = ( (ConnectionWrapper) connection ).unwrap( );
        } else {
            coreConnection = (CoreConnection) connection;
        }

        return this.getDescription( coreConnection, locale );
    }

    public String getDescription( Connection connection ) {

        return this.getDescription( connection, MoinLocaleProvider.getInstance( ).getCurrentLocale( ) );
    }

}

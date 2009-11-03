package com.sap.tc.moin.query.repository;

import java.lang.reflect.InvocationTargetException;

import com.sap.tc.moin.js.query.service.client.QsResourceIdentifierConstants;
import com.sap.tc.moin.js.query.service.client.RemoteMqlProcessor;


/**
 * Factory for creating {@link RepositoryHelper} instances.
 * 
 * @author D044522
 */
public class RepositoryHelperFactory {

    /**
     * Creates {@link RepositoryHelper} instances.
     * 
     * @param facilityId id of the facility to which the
     * {@link RepositoryHelper} instance should be able to "translate".
     * @param rmp underlying Remote MQL Processor representing the connection to
     * the MOIN Team Server.
     * @return a Repository Helper capable of translating between MOIN and
     * resource repository concepts.
     * @throws ClassNotFoundException
     * @throws IllegalArgumentException
     * @throws SecurityException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     */
    @SuppressWarnings( "unchecked" )
    public RepositoryHelper createRepositoryHelper( String facilityId, RemoteMqlProcessor rmp ) throws ClassNotFoundException, IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        if ( facilityId.equals( QsResourceIdentifierConstants.PRIMARY_FACILITY_ID ) ) {
            Class wmpi = Class.forName( "com.sap.tc.moin.query.repository.impl.DiRepositoryHelperImpl" ); //$NON-NLS-1$
            return (RepositoryHelper) wmpi.getConstructor( RemoteMqlProcessor.class ).newInstance( rmp );


        } else
            //TODO I18N
            throw new IllegalArgumentException( facilityId );
    }

}

package com.sap.tc.moin.js.query.service.client;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;

import com.sap.tc.moin.repository.exception.MoinIllegalNullArgumentException;


/**
 * Entry point for creating {@link RemoteMqlProcessor} instances.
 * 
 * @author D044522
 * @see com.sap.tc.moin.repository.mql.MQLProcessor
 */
public class RemoteMqlProcessorFactory {

    /**
     * Creates RemoteMqlProcessors for a Web Service end point and a local MOIN
     * connection.
     * 
     * @param serviceUrl location of the Query Service's WSDL, e.g.,
     * <tt>http://myhost:50000/QueryService/QueryImplBean?wsdl</tt>
     * @return a processor for executing remote MQL queries.
     * @throws ClassNotFoundException cannot instantiate default implementation.
     * @throws NoSuchMethodException cannot instantiate default implementation.
     * @throws InvocationTargetException cannot instantiate default
     * implementation.
     * @throws IllegalAccessException cannot instantiate default implementation.
     * @throws InstantiationException cannot instantiate default implementation.
     * @throws SecurityException cannot instantiate default implementation.
     * @throws IllegalArgumentException cannot instantiate default
     * implementation.
     */
    @SuppressWarnings( "unchecked" )
    public final RemoteMqlProcessor createRemoteMqlProcessor( URL serviceUrl ) throws ClassNotFoundException, IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        if ( serviceUrl == null ) {
            throw new MoinIllegalNullArgumentException( "serviceUrl" ); //$NON-NLS-1$
        }
        Class wmpi = Class.forName( "com.sap.tc.moin.js.query.service.client.impl.WsMqlProcessorImpl" ); //$NON-NLS-1$
        return (RemoteMqlProcessor) wmpi.getConstructor( URL.class ).newInstance( serviceUrl );
    }

}

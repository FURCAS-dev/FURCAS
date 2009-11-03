package com.sap.tc.moin.repository.runtimehost.deployment;

import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.runtimehost.RuntimehostMessages;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;

/**
 * Instance reference implementation. Keeps a reference as a class name. An
 * instance of this class can later be instantiated.
 * 
 * @author D026715
 * @param <T>
 */
public class InstanceReferenceImpl<T> implements IpiInstanceReference {

    private static MoinLogger log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_RUNTIME_HOST, MoinLocationEnum.MOIN_RUNTIMHOST, InstanceReferenceImpl.class );

    private String className;

    private T instance;

    public InstanceReferenceImpl( String className ) {

        this.className = className;
    }

    public String getClassName( ) {

        return className;
    }


    /**
     * Returns the instance or null if the instance is not yet created.
     * 
     * @return Instance
     */
    public T getInstance( ) {

        if ( this.instance == null ) {
            log.trace( MoinSeverity.ERROR, RuntimehostMessages.CLASS_NOT_FOUND, new Object[] { className } );
        }
        return instance;
    }

    public void createInstance( IpiCustomSerializationClassLoader loader ) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        Class<T> clazz = (Class<T>) loader.loadClass( this.className );
        this.instance = clazz.newInstance( );
    }

    /**
     * Method indirectly needed by test case
     * 
     * @param newInstance
     */
    public void setInstance( T newInstance ) {

        if ( this.instance == null ) {
            this.instance = newInstance;
        } else {
            throw new MoinIllegalStateException( RuntimeHostDeploymentMessages.INSTANCESCANNOTBEOVERWRITTEN );
        }
    }

    public void releaseInstance( ) {

        this.instance = null;

    }


}
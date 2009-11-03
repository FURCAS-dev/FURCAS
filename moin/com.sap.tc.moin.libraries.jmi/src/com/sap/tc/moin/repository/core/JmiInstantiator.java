package com.sap.tc.moin.repository.core;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.spi.core.SpiModelPartition;

/**
 * This interface provides methods to create JMI instances.
 * <p>
 * This interface is not intended to be implemented by service providers. The
 * implementation will be provided by the MOIN Core.
 * 
 * @author d024227
 */
public interface JmiInstantiator {

    /**
     * @param mofId
     * @param immediatePackage
     * @param mofPackage
     * @return the newly created RefPackage
     * @throws JmiInstantiationException
     */
    public RefPackage createRefPackage( String mofId, RefPackage immediatePackage, MofPackage mofPackage ) throws JmiInstantiationException;

    /**
     * @param mofId
     * @param immediatePackage
     * @param mofClass
     * @param refClass
     * @param partition
     * @return the newly created RefObject
     * @throws JmiInstantiationException
     */
    public RefObject createRefObject( Connection connection, String mofId, RefPackage immediatePackage, MofClass mofClass, RefClass refClass, SpiModelPartition partition ) throws JmiInstantiationException;

}
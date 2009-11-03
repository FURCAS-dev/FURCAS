package com.sap.tc.moin.repository.core;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;

/**
 * Get the JMI implementation class for a given MofClass or MofPackage
 * <p>
 * Different implementations of this interface are expected in the different
 * environments supported by the the Modeling Infrastructure, each of which
 * encapsulate the class loading mechanisms as required by the specific
 * environments.
 */
public interface JmiClassResolver {

    /**
     * Determine the JMI class for a given {@link MofClass}
     * 
     * @param mofClass
     * @return the JMI class
     * @throws ClassNotFoundException if a matching class cannot be found
     */
    @SuppressWarnings( "unchecked" )
    public Class getClass( MofClass mofClass ) throws ClassNotFoundException;

    /**
     * Determine the JMI class for a given {@link MofPackage}
     * 
     * @param mofPackage
     * @return the JMI class
     * @throws ClassNotFoundException if a matching class cannot be found
     */
    @SuppressWarnings( "unchecked" )
    public Class getClass( MofPackage mofPackage ) throws ClassNotFoundException;

}
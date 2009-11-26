package com.sap.tc.logging.interfaces;

/**
 * Title:        Logging
 * Description:  Logging API
 * Copyright:    Copyright (c) 2008
 * Company:      SAP AG.
 *               Sofia, Bulgaria
 *               All rights reserved.
 *
 *               This software is the confidential and proprietary information
 *               of SAP AG. ("Confidential Information").  You shall
 *               not disclose such Confidential Information and shall use it
 *               only in accordance with the terms of the license agreement
 *               you entered into with SAP AG.
 * @version      $Id:$
 */

/**
 *  Defines the way CSN Component and DC Name properties are retrieved
 *  for each Location that is created
 */
public interface IClassLoadRuntimeInfoProvider {

    /**
     * 
     * @param classloaderName Name of a ClassLoader to use for retrieving CSN Component
     * @return CSN Component if successfully retreived
     *         or null if:
     *          1. ClassLoader with provided name cannot be found
     *          2. CSN component is not set for class loader with the name provided           
     */
    public String getCsnComponent(String classLoaderName);
    
    /**
     * 
     * @param classLoader ClassLoader to use for retrieving CSN Component
     * @return CSN Component if successfully retreived
     *         or null if:
     *          1. ClassLoader cannot be found
     *          2. CSN component is not set for class loader provided           
     */
    public String getCsnComponent(ClassLoader classLoader);    

    /**
     * 
     * @param classloaderName ClassLoader to use for retrieving DC Name
     * @return DC Name if successfully retreived
     *         or null if:
     *          1. ClassLoader with provided name cannot be found
     */
    public String getDcName(String classLoaderName);
    
    /**
     * 
     * @param classloader ClassLoader to use for retrieving DC Name
     * @return DC Name if successfully retreived
     *         or null if:
     *          1. ClassLoader cannot be found
     */
    public String getDcName(ClassLoader classLoader);    
    
    /**
     * 
     * @return class loader name of the caller.
     * May be null if the classLoader is a system loader, or is not registered by the class loader manager.
     */
    public String getCallerClassLoaderName();
   
}

package com.sap.tc.moin.repository.core.ocl.service;

import java.util.Map;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.exception.MoinBaseException;

/**
 * The internal interface for OCL services
 */
public interface OclService {


    /**
     * This is used to enable OclBodyExpressions defined in OCL to be called
     * from the generated JMI code
     * 
     * @param connection
     * @param opName the name of the operation
     * @param context the context (i.e. the Java instance on which the method is
     * called)
     * @param inputParameters a Map of the input parameter names to the
     * parameter values
     * @return an Object which is the result of the operation
     * @throws MoinBaseException
     */
    public Object evaluateOclBodyExpression( CoreConnection connection, String opName, RefObject context, Map<String, Object> inputParameters ) throws MoinBaseException;

}

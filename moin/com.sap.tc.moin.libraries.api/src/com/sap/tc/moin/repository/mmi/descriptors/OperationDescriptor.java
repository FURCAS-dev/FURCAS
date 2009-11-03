package com.sap.tc.moin.repository.mmi.descriptors;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * Represents an {@link Operation operation} of a {@link MofClass}.
 */
public class OperationDescriptor<MOF_TYPE extends Operation, CONTAINER_TYPE extends RefObject, VALUE_TYPE> extends BehavioralFeatureDescriptor<MOF_TYPE> {

    public OperationDescriptor( String mofId, String modelContainerName, String[] qualifiedName ) {

        super( mofId, modelContainerName, qualifiedName );
    }
}

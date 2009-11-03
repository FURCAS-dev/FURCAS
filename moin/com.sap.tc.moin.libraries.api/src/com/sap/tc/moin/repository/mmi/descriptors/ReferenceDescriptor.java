package com.sap.tc.moin.repository.mmi.descriptors;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * Represents a {@link Reference reference} of a {@link MofClass}.
 */
public class ReferenceDescriptor<MOF_TYPE extends Reference, CONTAINER_TYPE extends RefObject, VALUE_TYPE> extends StructuralFeatureDescriptor<MOF_TYPE, CONTAINER_TYPE, VALUE_TYPE> {

    public ReferenceDescriptor( String mofId, String modelContainerName, String[] qualifiedName ) {

        super( mofId, modelContainerName, qualifiedName );
    }
}

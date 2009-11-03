package com.sap.tc.moin.repository.mmi.descriptors;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * Represents an {@link Attribute attribute} of a {@link MofClass}.
 */
public class AttributeDescriptor<MOF_TYPE extends Attribute, CONTAINER_TYPE extends RefObject, VALUE_TYPE> extends StructuralFeatureDescriptor<MOF_TYPE, CONTAINER_TYPE, VALUE_TYPE> {

    public AttributeDescriptor( String mofId, String modelContainerName, String[] qualifiedName ) {

        super( mofId, modelContainerName, qualifiedName );
    }
}

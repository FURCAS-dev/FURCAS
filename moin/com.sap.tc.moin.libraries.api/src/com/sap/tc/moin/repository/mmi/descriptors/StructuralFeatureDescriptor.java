package com.sap.tc.moin.repository.mmi.descriptors;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * Represents a {@link StructuralFeature} of a {@link MofClass}.
 */
public class StructuralFeatureDescriptor<MOF_TYPE extends StructuralFeature, CONTAINER_TYPE extends RefObject, VALUE_TYPE> extends MetamodelElementDescriptor<MOF_TYPE> {

    public StructuralFeatureDescriptor( String mofId, String modelContainerName, String[] qualifiedName ) {

        super( mofId, modelContainerName, qualifiedName );
    }
}

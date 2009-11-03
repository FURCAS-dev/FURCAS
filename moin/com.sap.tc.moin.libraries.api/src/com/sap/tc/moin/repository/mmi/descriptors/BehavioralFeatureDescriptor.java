package com.sap.tc.moin.repository.mmi.descriptors;

import com.sap.tc.moin.repository.mmi.model.BehavioralFeature;
import com.sap.tc.moin.repository.mmi.model.MofClass;

/**
 * Represents a {@link BehavioralFeature} of a {@link MofClass}.
 */
public class BehavioralFeatureDescriptor<MOF_TYPE extends BehavioralFeature> extends MetamodelElementDescriptor<MOF_TYPE> {

    public BehavioralFeatureDescriptor( String mofId, String modelContainerName, String[] qualifiedName ) {

        super( mofId, modelContainerName, qualifiedName );
    }
}

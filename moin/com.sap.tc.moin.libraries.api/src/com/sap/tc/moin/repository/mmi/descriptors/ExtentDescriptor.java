package com.sap.tc.moin.repository.mmi.descriptors;

import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

/**
 * The ExtentDescriptor is the base class for all descriptors of extents in MOIN ({@link RefPackage},
 * {@link RefClass} and {@link RefAssociation}).
 */
public abstract class ExtentDescriptor extends MetamodelElementDescriptor<RefBaseObject> {

    ExtentDescriptor( String mofIdOfMetaObject, String modelContainerName, String... qualifiedName ) {

        super( mofIdOfMetaObject, modelContainerName, qualifiedName );
    }

    /**
     * Returns the MOF id of the extent.
     * 
     * @return the MOF id of the extent
     */
    public String getMofIdOfMetaObject( ) {

        return super.getMofId( );
    }
}

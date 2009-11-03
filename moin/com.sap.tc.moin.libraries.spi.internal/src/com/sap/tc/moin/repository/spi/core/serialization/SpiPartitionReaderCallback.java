package com.sap.tc.moin.repository.spi.core.serialization;

import org.xml.sax.Attributes;

@Deprecated
public interface SpiPartitionReaderCallback {

    @Deprecated
    public void notifyOnModelElement( String mofId, String mofIdOfMetaObject, Attributes xmlAttributes );

    @Deprecated
    public void notifyOnLink( String idOfFirstEnd, String idOfSecondEnd, String mofIdOfMetaObject );

    @Deprecated
    public boolean isMetamodelAvailable( String containerName );
}

package com.sap.tc.moin.repository.core.cps.serializer;

import java.io.IOException;
import java.io.OutputStream;

import com.sap.tc.moin.repository.core.cps.serializer.v1.PartitionSerializerV1;
import com.sap.tc.moin.repository.core.cps.serializer.v2.PartitionSerializerV2;
import com.sap.tc.moin.repository.shared.util.MoinSystemPropertyKeys;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiCustomSerializer;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiSerializerCallback;

public final class PartitionSerializerImpl implements SpiCustomSerializer {

    private static final String FORMAT_VERSION = System.getProperty( MoinSystemPropertyKeys.MOIN_SERIALIZATION_FORMAT_VERSION, "1" ); //$NON-NLS-1$

    private final SpiCustomSerializer realSerializer;

    public PartitionSerializerImpl( ) {

        if ( FORMAT_VERSION.equals( "2" ) ) { //$NON-NLS-1$
            realSerializer = new PartitionSerializerV2( );
        } else {
            realSerializer = new PartitionSerializerV1( );
        }
    }

    public PartitionSerializerImpl( String version ) {

        if ( version != null && version.equals( "2" ) ) { //$NON-NLS-1$
            realSerializer = new PartitionSerializerV2( );
        } else {
            realSerializer = new PartitionSerializerV1( );
        }
    }

    public void serialize( OutputStream stream, SpiSerializerCallback cb ) throws IOException {

        realSerializer.serialize( stream, cb );
    }
}

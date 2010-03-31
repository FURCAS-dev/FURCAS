package com.sap.tc.moin.repository.cps.test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import com.sap.tc.moin.repository.spi.ps.SpiCustomParserSerializerFactory;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiCustomSerializer;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiSerializerCallback;


public class DelegatingTestCustomSerializer implements SpiCustomSerializer {

    public void serialize( OutputStream stream, SpiSerializerCallback callback ) {

        // delegate
        try {

            ByteArrayOutputStream buffer = new ByteArrayOutputStream( );

            callback.callOtherSerializer( SpiCustomParserSerializerFactory.DEFAULT_SERIALIZATION, buffer, callback );

            byte[] bytes = DelegationTestCustomParserFactory.getEncryptionCipher( ).doFinal( buffer.toByteArray( ) );

            stream.write( bytes );

        } catch ( Exception e ) {
            throw new RuntimeException( e );
        }
    }


}

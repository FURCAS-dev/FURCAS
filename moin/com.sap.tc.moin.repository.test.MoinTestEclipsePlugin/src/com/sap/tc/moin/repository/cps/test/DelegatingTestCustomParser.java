package com.sap.tc.moin.repository.cps.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.crypto.Cipher;

import com.sap.tc.moin.repository.spi.ps.SpiCustomParserSerializerFactory;
import com.sap.tc.moin.repository.spi.ps.parser.SpiCustomParser;
import com.sap.tc.moin.repository.spi.ps.parser.SpiParserCallback;


public class DelegatingTestCustomParser implements SpiCustomParser {

    public void parse( InputStream stream, SpiParserCallback callback, long fileSize ) {

        // delegate
        try {
            //since CipherInputStream does not support reset(), which is needed by the moin parser,
            // the content has to be copied first
            Cipher decryptionCipher = DelegationTestCustomParserFactory.getDecryptionCipher( );

            ByteArrayOutputStream buffer = new ByteArrayOutputStream( );

            // reading bytes since cipherInput.available() is not supported
            byte[] bytes = new byte[1024];
            int i = stream.read( bytes );
            while ( i != -1 ) {

                buffer.write( bytes, 0, i );
                i = stream.read( bytes );
            }
            buffer.flush( );
            buffer.close( );

            byte[] decrypted = decryptionCipher.doFinal( buffer.toByteArray( ) );

            ByteArrayInputStream input = new ByteArrayInputStream( decrypted );

            callback.callOtherParser( SpiCustomParserSerializerFactory.DEFAULT_SERIALIZATION, input, callback, fileSize );

        } catch ( Exception e ) {
            // TODO exception strategy !!
            throw new RuntimeException( e );
        }

    }
}

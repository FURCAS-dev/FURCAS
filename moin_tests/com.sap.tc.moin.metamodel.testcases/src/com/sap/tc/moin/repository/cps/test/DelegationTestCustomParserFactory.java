package com.sap.tc.moin.repository.cps.test;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import com.sap.tc.moin.repository.spi.ps.SpiCustomParserSerializerFactory;
import com.sap.tc.moin.repository.spi.ps.parser.SpiCustomParser;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiCustomSerializer;
import com.sap.tc.moin.repository.spi.s2x.serializer.SpiS2XSerializerCustomCallback;

/**
 * Test custom parser factory.
 * 
 * @author d026715
 */
public class DelegationTestCustomParserFactory implements SpiCustomParserSerializerFactory {

    private static final String PBEWITH_M_D5_AND_D_E_S = "PBEWithMD5AndDES";

    public static final String[] SUFFIXES = { ".mointestcrypt" };

    public static final String ZIP_ENTRY = "PartitionContent";

    // Salt
    private static byte[] salt = { (byte) 0xc7, (byte) 0x73, (byte) 0x21, (byte) 0x8c, (byte) 0x7e, (byte) 0xc8, (byte) 0xee, (byte) 0x99 };

    // Iteration count
    private static int count = 20;

    // Create PBE parameter set
    private static PBEParameterSpec pbeParamSpec = new PBEParameterSpec( salt, count );

    // 
    private static PBEKeySpec pbeKeySpec = new PBEKeySpec( "hoppelflieger".toCharArray( ) );

    private static SecretKeyFactory keyFac;

    private static SecretKey pbeKey;

    static {
        try {
            keyFac = SecretKeyFactory.getInstance( PBEWITH_M_D5_AND_D_E_S );
            pbeKey = keyFac.generateSecret( pbeKeySpec );
        } catch ( Exception e ) {
            throw new RuntimeException( e );
        }

    }

    public SpiCustomParser getParser( ) {

        return new DelegatingTestCustomParser( );
    }

    public SpiCustomSerializer getSerializer( ) {

        return new DelegatingTestCustomSerializer( );
    }

    public SpiS2XSerializerCustomCallback getS2XSerializerCallback( ) {

        return new SimpleTestS2XSerializerCallback( );
    }

    public static Cipher getDecryptionCipher( ) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException {

        // Create PBE Cipher
        Cipher pbeCipher = Cipher.getInstance( PBEWITH_M_D5_AND_D_E_S );

        // Initialize PBE Cipher with key and parameters
        pbeCipher.init( Cipher.DECRYPT_MODE, pbeKey, pbeParamSpec );
        return pbeCipher;
    }

    public static Cipher getEncryptionCipher( ) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException {

        // Create PBE Cipher
        Cipher pbeCipher = Cipher.getInstance( PBEWITH_M_D5_AND_D_E_S );

        // Initialize PBE Cipher with key and parameters
        pbeCipher.init( Cipher.ENCRYPT_MODE, pbeKey, pbeParamSpec );
        return pbeCipher;
    }


}
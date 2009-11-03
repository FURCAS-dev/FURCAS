package com.sap.tc.moin.xm.generation.core.code.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.antlr.stringtemplate.CommonGroupLoader;
import org.antlr.stringtemplate.StringTemplateErrorListener;

/**
 * Group loader implementation for StringTemplate.
 */
public final class CommonClassLoaderGroupLoader extends CommonGroupLoader {

    private final ClassLoader classLoader;

    /**
     * @param dirStr
     * @param errorListener
     * @param templateClassLoader
     */
    public CommonClassLoaderGroupLoader( final String dirStr, final StringTemplateErrorListener errorListener, final ClassLoader templateClassLoader ) {

        super( dirStr, errorListener );
        this.classLoader = templateClassLoader;
    }

    @Override
    protected BufferedReader locate( final String name ) throws IOException {

        for ( int i = 0; i < this.dirs.size( ); i++ ) {
            final String dir = (String) this.dirs.get( i );
            final String fileName = dir + "/" + name; //$NON-NLS-1$
            ClassLoader cl = this.classLoader;
            byte[] buffer = null;
            if ( buffer == null ) {
                cl = this.getClass( ).getClassLoader( );
                InputStream is = null;
                try {
                    is = cl.getResourceAsStream( fileName );

                    final int size = is.available( );
                    buffer = new byte[size];
                    is.read( buffer );
                } finally {
                    if ( is != null ) {
                        is.close( );
                    }
                }
            }
            if ( buffer != null ) {
                final ByteArrayInputStream is = new ByteArrayInputStream( buffer );
                return new BufferedReader( getInputStreamReader( is ) );
            }
        }
        return null;
    }
}
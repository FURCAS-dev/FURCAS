// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: RootRegistry.java

package com.sap.tc.moin.repository.test.jmitck.javatest.httpd;

import java.io.PrintWriter;
import java.util.Hashtable;

// Referenced classes of package com.sun.javatest.httpd:
// ProviderRegistry, JThttpProvider, httpURL, PageGenerator

@SuppressWarnings( "nls" )
public class RootRegistry extends ProviderRegistry {

    private class SpecialURLHandler extends JThttpProvider {

        @Override
        public void serviceRequest( httpURL httpurl, PrintWriter printwriter ) {

            httpurl.resetIterator( );
            String s = httpurl.getNextFile( );
            if ( s.equals( "version" ) ) {
                printVersionInfo( printwriter );
            }
            printwriter.close( );
        }

        private void printVersionInfo( PrintWriter printwriter ) {

            JThttpProvider.println( printwriter, PageGenerator.getSWName( ) + " " + PageGenerator.getSWVersion( ) );
            JThttpProvider.println( printwriter, "Built on " + PageGenerator.getSWBuildDate( ) );
        }

        private SpecialURLHandler( ) {

        }

    }

    private RootRegistry( ) {

        httpHandle = new SpecialURLHandler( );
        addHandler( "/version", "Version information handler", httpHandle );
    }

    public static RootRegistry getInstance( ) {

        if ( myInstance == null ) {
            myInstance = new RootRegistry( );
        }
        return myInstance;
    }

    @Override
    public void addHandler( String s, String s1, JThttpProvider jthttpprovider ) {

        if ( !s.equals( "/" ) ) {
            super.addHandler( s, s1, jthttpprovider );
        } else {
            if ( ProviderRegistry.debug ) {
                System.out.println( "RPR-Adding Handler: " + s1 );
                System.out.println( "   RPR-Adding URL: " + s );
                System.out.println( "   RPR-Adding OBJ: " + jthttpprovider );
            }
            String as[] = { s };
            insertHandler( as, s1, jthttpprovider, false );
        }
    }

    public static JThttpProvider getObjectHandler( Object obj ) {

        return obj2prov.get( obj );
    }

    public static void associateObject( Object obj, JThttpProvider jthttpprovider ) {

        if ( obj != null && jthttpprovider != null ) {
            obj2prov.put( obj, jthttpprovider );
        }
    }

    public static void unassociateObject( Object obj, JThttpProvider jthttpprovider ) {

        if ( obj != null && jthttpprovider != null ) {
            Object obj1 = obj2prov.get( obj );
            if ( obj1 == jthttpprovider ) {
                obj2prov.remove( obj );
            } else {
                throw new IllegalArgumentException( "RR-Unable to unassociateObject, providers do not match." );
            }
        }
    }

    private static RootRegistry myInstance;

    private SpecialURLHandler httpHandle;

    protected static Hashtable<Object, JThttpProvider> obj2prov = new Hashtable<Object, JThttpProvider>( );

    static {
        myInstance = new RootRegistry( );
        myInstance.addHandler( "/", "JavaTest Web Server Root", new ProviderRegistry.IndexHandler( ( (ProviderRegistry) ( myInstance ) ).url2prov ) );
        myInstance.addHandler( "/index.html", "JavaTest Web Server Root", new ProviderRegistry.IndexHandler( ( (ProviderRegistry) ( myInstance ) ).url2prov ) );
    }
}

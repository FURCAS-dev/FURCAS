// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: ProviderRegistry.java

package com.sap.tc.moin.repository.test.jmitck.javatest.httpd;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;

import com.sap.tc.moin.repository.test.jmitck.javatest.util.DynamicArray;

// Referenced classes of package com.sun.javatest.httpd:
// JThttpProvider, httpURL, PageGenerator

@SuppressWarnings( "nls" )
public class ProviderRegistry {

    protected static class IndexHandler extends JThttpProvider {

        @Override
        public void serviceRequest( httpURL httpurl, PrintWriter printwriter ) {

            PageGenerator.generateDocType( printwriter, 0 );
            PageGenerator.writeBeginDoc( printwriter );
            PageGenerator.writeHeader( printwriter, "JavaTest Webserver Root Page" );
            PageGenerator.startBody( printwriter );
            printwriter.println( "<h2>JavaTest Webserver Root Page</h2>" );
            printwriter.println( "(NOTE: Invalid URL requests will produce this page)<br>" );
            writeWebAvailPages( printwriter );
            printwriter.println( "<hr>" );
            PageGenerator.writeFooter( printwriter );
            PageGenerator.endBody( printwriter );
            PageGenerator.writeEndDoc( printwriter );
            printwriter.close( );
        }

        private void writeWebAvailPages( PrintWriter printwriter ) {

            printwriter.println( "<h3>Available Web Pages</h3>" );
            printwriter.println( "<ul>" );
            for ( Enumeration<Object> enumeration = urlMap.elements( ); enumeration.hasMoreElements( ); ) {
                Object obj = enumeration.nextElement( );
                if ( obj instanceof HandlerEntry ) {
                    HandlerEntry handlerentry = (HandlerEntry) obj;
                    printwriter.print( "<li><a href=\"" );
                    printwriter.print( handlerentry.getURL( ) );
                    printwriter.print( "\">" );
                    printwriter.print( handlerentry.getDescription( ) );
                    printwriter.println( "</a>" );
                }
            }

            printwriter.println( "</ul>" );
            printwriter.println( );
        }

        private Hashtable<String, Object> urlMap;

        IndexHandler( Hashtable<String, Object> hashtable ) {

            urlMap = hashtable;
        }
    }

    private static class HandlerEntry {

        public String getURL( ) {

            return url;
        }

        public String getDescription( ) {

            return descrip;
        }

        public JThttpProvider getProvider( ) {

            return obj;
        }

        private String url;

        private String descrip;

        private JThttpProvider obj;

        HandlerEntry( String s, String s1, JThttpProvider jthttpprovider ) {

            url = s;
            descrip = s1;
            obj = jthttpprovider;
        }
    }

    public ProviderRegistry( ) {

        url2prov = new Hashtable<String, Object>( );
    }

    public void addHandler( String s, String s1, JThttpProvider jthttpprovider ) {

        if ( debug ) {
            System.out.println( "PR-Adding Handler: " + s1 );
            System.out.println( "   PR-Adding URL: " + s );
            System.out.println( "   PR-Adding OBJ: " + jthttpprovider );
        }
        try {
            boolean flag = insertHandler( disassembleURL( s ), s1, jthttpprovider, false );
            if ( flag ) {
                jthttpprovider.addRegistredURL( s );
            }
        } catch ( IllegalArgumentException illegalargumentexception ) {
            if ( debug ) {
                System.out.println( "   PR-Error while inserting " + jthttpprovider );
                System.out.println( "   PR-Ignoring insert of URL " + s );
                illegalargumentexception.printStackTrace( );
            }
        }
    }

    public void addPrivateHandler( String s, String s1, JThttpProvider jthttpprovider ) {

        if ( debug ) {
            System.out.println( "PR-Adding Private Handler: " + s1 );
            System.out.println( "   PR-Adding URL: " + s );
            System.out.println( "   PR-Adding OBJ: " + jthttpprovider );
        }
        try {
            boolean flag = insertHandler( disassembleURL( s ), s1, jthttpprovider, true );
            if ( flag ) {
                jthttpprovider.addRegistredURL( s );
            }
        } catch ( IllegalArgumentException illegalargumentexception ) {
            if ( debug ) {
                System.out.println( "   PR-Error while inserting " + jthttpprovider );
                System.out.println( "   PR-Ignoring insert of URL " + s );
                illegalargumentexception.printStackTrace( );
            }
        }
    }

    public boolean removeHandler( String s, JThttpProvider jthttpprovider ) {

        if ( debug ) {
            System.out.println( "PR-Removing Handler by URL: " + s );
            System.out.println( "   PR-Removing OBJ : " + jthttpprovider );
        }
        return deleteHandler( disassembleURL( s ), jthttpprovider );
    }

    public void removeHandler( JThttpProvider jthttpprovider ) {

        if ( debug ) {
            System.out.println( "PR-Removing Handler by Object: " + jthttpprovider );
        }
        String as[] = jthttpprovider.getRegisteredURLs( );
        for ( int i = 0; i < as.length; i++ ) {
            deleteHandler( disassembleURL( as[i] ), jthttpprovider );
        }

    }

    public JThttpProvider getHandler( httpURL httpurl ) {

        if ( httpurl == null ) {
            return null;
        }
        String s = httpurl.getNextFile( );
        JThttpProvider jthttpprovider;
        if ( s == null ) {
            if ( debug ) {
                System.out.println( "PR-End of URL, no handler, using default." );
            }
            jthttpprovider = null;
        } else {
            if ( debug ) {
                System.out.println( "PR-Looking up: " + s );
            }
            Object obj = url2prov.get( s );
            if ( obj == null ) {
                jthttpprovider = null;
            } else if ( obj instanceof HandlerEntry ) {
                HandlerEntry handlerentry = (HandlerEntry) obj;
                jthttpprovider = handlerentry.getProvider( );
            } else {
                jthttpprovider = ( (ProviderRegistry) obj ).getHandler( httpurl );
            }
        }
        if ( debug ) {
            System.out.println( "PR-URL resolved to: " + jthttpprovider );
        }
        return jthttpprovider != null ? jthttpprovider : getIndexProvider( );
    }

    public JThttpProvider getIndexProvider( ) {

        if ( myProvider == null ) {
            myProvider = new IndexHandler( url2prov );
        }
        return myProvider;
    }

    public int getSize( ) {

        return url2prov.size( );
    }

    public boolean isEmpty( ) {

        return url2prov.size( ) == 0;
    }

    protected Object lookupByName( String s ) {

        Object obj = url2prov.get( s );
        if ( debug ) {
            System.out.println( "PR-lookupName(" + s + "): " + obj );
        }
        return obj;
    }

    protected void deleteByName( String s ) {

        Object obj = url2prov.remove( s );
        if ( debug ) {
            System.out.println( "PR-Removed " + s + " from hashtable." + obj );
        }
    }

    static String stripDirName( String s ) {

        if ( s == null ) {
            return null;
        }
        int i = 0;
        if ( s.charAt( 0 ) == '/' ) {
            i = 1;
        }
        int j = s.indexOf( '/', i );
        String s1 = null;
        if ( j != -1 ) {
            s1 = s.substring( i, j );
        } else {
            s1 = s.substring( i, s.length( ) );
        }
        return s1;
    }

    protected final boolean insertHandler( String as[], String s, JThttpProvider jthttpprovider, boolean flag ) throws IllegalArgumentException {

        String s1 = as[0];
        as = (String[]) DynamicArray.remove( as, 0 );
        if ( debug ) {
            System.out.println( "    PR-Partial insert of " + s1 );
        }
        Object obj = lookupByName( s1 );
        boolean flag1;
        if ( obj == null ) {
            if ( as == null || as.length == 0 ) {
                url2prov.put( s1, new HandlerEntry( s1, s, jthttpprovider ) );
                if ( debug ) {
                    System.out.println( "    Inserted " + s1 + " into " + this );
                }
                flag1 = true;
            } else {
                ProviderRegistry providerregistry = new ProviderRegistry( );
                url2prov.put( s1, providerregistry );
                flag1 = providerregistry.insertHandler( as, s, jthttpprovider, flag );
                if ( debug ) {
                    System.out.println( "    Created new registry and recursed, " + s1 );
                }
            }
        } else if ( obj instanceof ProviderRegistry ) {
            if ( debug ) {
                System.out.println( "    Found existing registry and recursed, " + s1 );
            }
            flag1 = ( (ProviderRegistry) obj ).insertHandler( as, s, jthttpprovider, flag );
        } else {
            throw new IllegalArgumentException( "Supplied URL collides with another registred handler.  Ignoring new handler." );
        }
        return flag1;
    }

    protected final boolean deleteHandler( String as[], JThttpProvider jthttpprovider ) {

        if ( as.length == 0 ) {
            if ( debug ) {
                System.out.println( "    PR-(del) Reached end of URL before done." );
            }
            return false;
        }
        String s = as[0];
        as = (String[]) DynamicArray.remove( as, 0 );
        if ( debug ) {
            System.out.println( "    PR-(del)Partial remove of " + s );
        }
        Object obj = lookupByName( s );
        if ( obj == null ) {
            if ( debug ) {
                System.out.println( "    PR-(del) Unable to match URL at: " + s );
            }
            return false;
        }
        if ( obj instanceof HandlerEntry ) {
            HandlerEntry handlerentry = (HandlerEntry) obj;
            if ( handlerentry.getProvider( ) == jthttpprovider ) {
                deleteByName( s );
                return true;
            } else {
                throw new IllegalArgumentException( "Given Provider ref. does not match URL Provider.  Unable to complete handler removal." );
            }
        }
        if ( obj instanceof ProviderRegistry ) {
            if ( debug ) {
                System.out.println( "    PR-(del) Found existing registry and recursed, " + s );
            }
            ProviderRegistry providerregistry = (ProviderRegistry) obj;
            boolean flag = providerregistry.deleteHandler( as, jthttpprovider );
            if ( flag && providerregistry.isEmpty( ) ) {
                deleteByName( s );
                return true;
            } else {
                return false;
            }
        } else {
            throw new IllegalArgumentException( "Unknown object found in registry.  Unable to complete handler removal." );
        }
    }

    final String[] disassembleURL( String s ) {

        String as[] = new String[0];
        if ( s == null || s.length( ) == 0 ) {
            return as;
        }
        int i = s.length( );
        int j = s.charAt( 0 ) != '/' ? 0 : 1;
        int k = j + 1;
        boolean flag;
        for ( flag = false; k < i && !flag; k++ ) {
            char c = s.charAt( k );
            switch ( c ) {
                case 47: // '/'
                    if ( k > j + 1 ) {
                        as = (String[]) DynamicArray.append( as, s.substring( j, k ) );
                    }
                    j = k + 1;
                    k++;
                    break;

                case 32: // ' '
                case 63: // '?'
                    flag = true;
                    break;
            }
        }

        if ( !flag && k >= i && k - j >= 1 ) {
            as = (String[]) DynamicArray.append( as, s.substring( j, k ) );
        }
        if ( debug ) {
            System.out.println( "PR-Dissolved url " + s + " into " + as.length + " files." );
        }
        return as;
    }

    static Class<?> _mthclass$( String s ) {

        try {
            return Class.forName( s );
        } catch ( ClassNotFoundException classnotfoundexception ) {
            throw new NoClassDefFoundError( classnotfoundexception.getMessage( ) );
        }
    }

    protected Hashtable<String, Object> url2prov;

    protected static boolean debug;

    protected JThttpProvider myProvider;

    static {
        debug = Boolean.getBoolean( "debug." + ( com.sap.tc.moin.repository.test.jmitck.javatest.httpd.ProviderRegistry.class ).getName( ) );
    }
}

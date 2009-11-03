package com.sap.tc.moin.xm.test.xml;

import java.util.ArrayList;

import com.sap.tc.moin.repository.xm.parser.NodeType;

/**
 * Immutable Path with hash code and equals method.
 */
class ComparablePath {

    private final ArrayList<String> path;

    private final int[] ndepth;

    private final int hashCode;

    private final NodeType type;

    private String uniquePath;

    ComparablePath( Path aPath ) {

        type = aPath.nodeType;
        path = new ArrayList<String>( aPath.path.size( ) );
        path.addAll( aPath.path );
        int length = aPath.getLevel( );
        ndepth = new int[length];
        int code = 17;
        for ( int i = 0; i < length; i++ ) {
            int v = aPath.ndepth[i];
            ndepth[i] = v;
            code = 37 * code + v;
        }
        for ( String s : path ) {
            code = 37 * code + s.hashCode( );
        }
        this.hashCode = 37 * code + type.hashCode( );
    }

    private int getLevel( ) {

        return path.size( ) / 2;
    }


    @Override
    public boolean equals( Object xpath ) {

        if ( this == xpath ) {
            return true;
        }
        if ( xpath instanceof ComparablePath ) {
            if ( hashCode != xpath.hashCode( ) ) {
                return false;
            }
            ComparablePath path2 = (ComparablePath) xpath;
            if ( !path2.type.equals( this.type ) ) {
                return false;
            }
            if ( path2.path.size( ) != this.path.size( ) ) {
                return false;
            }
            int i = path.size( ) - 1;
            while ( i >= 0 ) {
                if ( !this.path.get( i ).equals( path2.path.get( i ) ) ) {
                    return false;
                }
                i--;
            }
            for ( int j = 0; j < this.getLevel( ); j++ ) {
                if ( this.ndepth[j] != path2.ndepth[j] ) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public int hashCode( ) {

        return this.hashCode;
    }

    public String getUniquePath( ) {

        if ( this.uniquePath == null ) {
            StringBuilder buf = new StringBuilder( "/" );
            for ( int i = 0; i < path.size( ) - 2; i = i + 2 ) {
                buf.append( path.get( i ) );
                buf.append( ':' );
                buf.append( path.get( i + 1 ) );
                int dpth = i / 2;
                if ( ndepth[dpth] > 0 ) {
                    buf.append( '[' ).append( ndepth[dpth] ).append( ']' );
                }
                buf.append( '/' );
            }
            // last part
            buf.append( path.get( path.size( ) - 2 ) );
            buf.append( ':' );
            if ( NodeType.Attribute.equals( this.type ) ) {
                buf.append( '@' );
            }
            buf.append( path.get( path.size( ) - 1 ) );
            int dpth = this.getLevel( ) - 1;
            if ( ndepth[dpth] > 0 ) {
                buf.append( '[' ).append( ndepth[dpth] ).append( ']' );
            }

            this.uniquePath = buf.toString( );
        }
        return this.uniquePath;
    }

    @Override
    public String toString( ) {

        return this.getUniquePath( );
    }

}

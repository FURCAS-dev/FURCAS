/**
 * 
 */
package com.sap.tc.moin.facility.componentmodel.adapter;

import java.util.Set;

public class CMFSFolder {

    @Override
    public int hashCode( ) {

        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( folder == null ) ? 0 : folder.hashCode( ) );
        result = prime * result + ( versioned ? 1231 : 1237 );
        return result;
    }

    @Override
    public boolean equals( Object obj ) {

        if ( this == obj ) {
            return true;
        }
        if ( obj == null ) {
            return false;
        }
        if ( getClass( ) != obj.getClass( ) ) {
            return false;
        }
        CMFSFolder other = (CMFSFolder) obj;
        if ( folder == null ) {
            if ( other.folder != null ) {
                return false;
            }
        } else if ( !folder.equals( other.folder ) ) {
            return false;
        }
        if ( versioned != other.versioned ) {
            return false;
        }
        return true;
    }

    public final String folder;

    public final boolean versioned;

    public CMFSFolder( String folder, boolean versioned ) {

        this.folder = folder;
        this.versioned = versioned;
    }


    public static String serializeFolderConfigString( Set<CMFSFolder> folders, String rootFolder ) {

        StringBuilder config = new StringBuilder( );
        for ( CMFSFolder cmfsFolder : folders ) {
            String part = cmfsFolder.folder.trim( );
            if ( part.length( ) == 0 ) {
                continue;
            }
            if ( config.length( ) > 0 ) {
                config.append( ';' );
            }
            config.append( part );
            if ( rootFolder != null ) {
                config.append( '=' );
                config.append( rootFolder );
            }
        }
        return config.toString( );
    }

}
package com.sap.tc.moin.facility.primary.diservice.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class PathUtilImpl {

    public static final boolean OVERLAP_DOESNT_INCLUDE_EQUAL = false;

    public static final boolean OVERLAP_INCLUDES_EQUAL = true;

    // The file-separator MUST be "/" 
    // Reason: checks like s1.startsWith(s2) in file system persistence 
    // (--> the system-dependent java.io.File.separator cannot be used)
    private static final String MOIN_SPECIFIC_FILE_SEPARATOR = "/"; //$NON-NLS-1$

    public static String ensureTrailingFileSeparator( String path ) {

        if ( !path.endsWith( MOIN_SPECIFIC_FILE_SEPARATOR ) ) {
            return path + MOIN_SPECIFIC_FILE_SEPARATOR;
        }
        return path;
    }

    // The for-loop is a bit more performant for List than for Collection --> is this worth the double impl?
    public static boolean doesResourceFoldersOverlap( String folderPath, List<String> moinResourceFolderPaths, boolean overlapIncludesEqual ) {

        int folderPathLength = folderPath.length( );
        for ( int i = 0; i < moinResourceFolderPaths.size( ); i++ ) {
            String resourceFolder = moinResourceFolderPaths.get( i );
            if ( overlapIncludesEqual && resourceFolder.length( ) == folderPathLength ) {
                return false; // Strings are equal (equal does not count as overlap) or do not overlap (unequal Strings)
            }
            if ( resourceFolder.length( ) > folderPathLength ) {
                if ( resourceFolder.startsWith( folderPath ) ) {
                    return true; // String overlap and are not equal
                }
            } else if ( folderPath.startsWith( resourceFolder ) ) {
                return true; // Strings overlap, also in case they are equal
            }
        }
        return false; // Strings for not overlap and are not equal
    }

    public static boolean doesResourceFolderOverlap( String folderPath, Map<String, String> moinResourceFolderPaths, boolean overlapIncludesEqual ) {

        Set<String> resourceFolders = moinResourceFolderPaths.keySet( );
        return doesResourceFolderOverlap( folderPath, resourceFolders, overlapIncludesEqual );
    }

    public static boolean doesResourceFolderOverlap( String folderPath, Collection<String> resourceFolders, boolean overlapIncludesEqual ) {

        int folderPathLength = folderPath.length( );
        for ( String resourceFolder : resourceFolders ) {
            if ( !overlapIncludesEqual && resourceFolder.length( ) == folderPathLength ) {
                return false; // Strings are equal (equal does not count as overlap) or do not overlap (unequal Strings)
            }
            if ( resourceFolder.length( ) > folderPathLength ) {
                if ( resourceFolder.startsWith( folderPath ) ) {
                    return true; // String overlap and are not equal
                }
            } else if ( folderPath.startsWith( resourceFolder ) ) {
                return true; // Strings overlap, also in case they are equal
            }
        }
        return false; // Strings do not overlap and are not equal
    }

    public static FolderOverlap getFolderOverlap( String newFolderPath, List<String> folderPaths ) {

        for ( String folderPath : folderPaths ) {

            if ( folderPath.equals( newFolderPath ) ) {
                return FolderOverlap.EQUAL;

            } else if ( folderPath.startsWith( newFolderPath ) ) {
                return FolderOverlap.OVERLAP;

            } else if ( newFolderPath.startsWith( folderPath ) ) {
                return FolderOverlap.OVERLAP;
            }
        }
        return FolderOverlap.NO_OVERLAP;
    }

    public enum FolderOverlap {
        NO_OVERLAP, EQUAL, OVERLAP
    }

}

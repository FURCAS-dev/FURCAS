package com.sap.tc.moin.test.fw.ide;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;

import com.sap.tc.moin.repository.PRI;

@SuppressWarnings( "nls" )
public interface FileUtil {

    static final String PLUGIN_RESOURCES_FOLDER = "resources/"; //$NON-NLS-1$

    void copyFile( File srcFile, File destFile ) throws IOException;

    void copyFile( InputStream in, OutputStream out ) throws IOException;

    // The input stream has to be determined via URL and plug-in bundle to ensure
    // that it can be determined when the plug-in is imported as IDE project 
    // and when the plug-in is deployed as plug-in in IDE.
    // relativeFilePath is the file path relative to the plug-in root url
    InputStream getInputStreamForFileInSamePlugin( String pluginID, String relativeFilePath ) throws Exception;

    URL getUrlForFileInSamePlugin( String pluginId, String relativeFilePath ) throws Exception;

    IFile getEclipseFile( IResource resourceInWorkspace, File file ) throws Exception;

    File getFile( IResource eclipseResourceHandle );

    File getFile( IProject eclipseProject, String projectRelativePath );

    File getFile( IProject eclipseProject, PRI pri );

    boolean isPartitionInFileSystem( IProject eclipseProject, PRI pri );

    long getTimestampFromFileSystem( IProject eclipseProject, PRI pri );
}

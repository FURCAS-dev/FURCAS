package com.sap.tc.moin.test.fw.ide;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

import com.sap.tc.moin.repository.PRI;


@SuppressWarnings( "nls" )
public class FileUtilImpl implements FileUtil {

    public void copyFile( File srcFile, File destFile ) throws IOException {

        InputStream in = new FileInputStream( srcFile );
        OutputStream out = new FileOutputStream( destFile );
        copyFile( in, out );

    }

    public void copyFile( InputStream in, OutputStream out ) throws IOException {

        // Transfer bytes from srcFile into destFile
        byte[] buf = new byte[1024];
        int len;
        while ( ( len = in.read( buf ) ) > 0 ) {
            out.write( buf, 0, len ); // if destFile does not exist then it is created
        }
        in.close( );
        out.close( );
    }

    // The input stream has to be determined via URL and plug-in bundle to ensure
    // that it can be determined when the plug-in is imported as IDE project 
    // and when the plug-in is deployed as plug-in in IDE.
    // relativeFilePath is the file path relative to the plug-in root url
    public InputStream getInputStreamForFileInSamePlugin( String pluginID, String relativeFilePath ) throws Exception {

        Bundle pluginBundle = Platform.getBundle( pluginID );
        URL pluginRootUrl = pluginBundle.getEntry( "/" );
        try {
            URL fileUrl = new URL( pluginRootUrl, relativeFilePath );
            URLConnection urlConnection = fileUrl.openConnection( );
            return urlConnection.getInputStream( );
        } catch ( MalformedURLException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace( );
            throw e;
        } catch ( IOException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace( );
            throw e;
        }
    }

    public URL getUrlForFileInSamePlugin( String pluginId, String relativeFilePath ) throws Exception {

        Bundle pluginBundle = Platform.getBundle( pluginId );
        URL pluginRootUrl = pluginBundle.getEntry( "/" );
        URL fileUrl;
        try {
            fileUrl = new URL( pluginRootUrl, relativeFilePath );
        } catch ( MalformedURLException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace( );
            throw e;
        }
        return fileUrl;
    }

    /** *************** Mapping java.io.File <--> Eclipse IFile ************* */

    public IFile getEclipseFile( IResource resourceInWorkspace, File file ) throws Exception {

        IPath path = new Path( file.getAbsolutePath( ) );
        IProject project = resourceInWorkspace.getProject( );
        IWorkspaceRoot workspaceRoot = project.getWorkspace( ).getRoot( );
        IFile eclipseFile = workspaceRoot.getFileForLocation( path );
        return eclipseFile;
    }

    public File getFile( IResource eclipseResourceHandle ) {

        return eclipseResourceHandle.getLocation( ).toFile( );
    }

    public File getFile( IProject eclipseProject, String projectRelativePath ) {

        File projectFolder = getFile( eclipseProject );
        String absoluteFilePath = projectFolder.getAbsolutePath( ) + File.separatorChar + projectRelativePath;
        return new File( absoluteFilePath );
    }

    public File getFile( IProject eclipseProject, PRI pri ) {

        return getFile( eclipseProject, pri.getPartitionName( ) );
    }

    public boolean isPartitionInFileSystem( IProject eclipseProject, PRI pri ) {

        return getFile( eclipseProject, pri ).exists( );
    }

    public long getTimestampFromFileSystem( IProject eclipseProject, PRI pri ) {

        return getFile( eclipseProject, pri ).lastModified( );
    }



}

package com.sap.tc.moin.primary.facility.test.ide.lfs;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.sap.tc.moin.facility.primary.ide.persistence.lfs.ecl.EclFsFactoryImpl;
import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalFsFactory;


public class TestEclLogicalFsFactory extends AbstractTestLogicalFsFactory {

    @Override
    protected IpiLogicalFsFactory createLogicalFsFactoryTestInstance( ) {

        return new EclFsFactoryImpl( );
    }

    @Override
    protected String getTransformedTemporaryDirectoryPath( ) {

        String workspaceRelativeBasePath;

        IPath tempDirectoryPath = Path.fromOSString( this.temporaryDirectory.getAbsolutePath( ) );
        IPath wsRootLocation = ResourcesPlugin.getWorkspace( ).getRoot( ).getLocation( );

        if ( wsRootLocation.isPrefixOf( tempDirectoryPath ) ) {
            workspaceRelativeBasePath = "/" + tempDirectoryPath.removeFirstSegments( wsRootLocation.segmentCount( ) ).setDevice( null ).toString( );
        } else {
            throw new RuntimeException( "Unable to calculate the path of the temporary directory relative to the workspace root." );
        }

        return workspaceRelativeBasePath;
    }

    @Override
    protected void refreshFileSystem( ) {

        // refreshes the workspace
        try {
            ResourcesPlugin.getWorkspace( ).getRoot( ).refreshLocal( IResource.DEPTH_INFINITE, null );
            Thread.sleep( 100 );
        } catch ( CoreException e ) {
            // $JL-EXC$ expected
        } catch ( InterruptedException e ) {
            // $JL-EXC$ expected
        }
    }
}

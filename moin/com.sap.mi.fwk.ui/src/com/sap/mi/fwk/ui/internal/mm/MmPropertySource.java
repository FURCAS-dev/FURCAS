package com.sap.mi.fwk.ui.internal.mm;

import java.io.IOException;
import java.util.Collection;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource2;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.osgi.framework.Bundle;

import com.sap.mi.fwk.ui.internal.MiFwkUIPlugin;
import com.sap.mi.fwk.ui.internal.messages.MiFwkUiMessages;
import com.sap.mi.fwk.ui.mm.MetamodelManagerUI;
import com.sap.tc.moin.repository.ide.metamodels.MmDeploymentInfo;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * Property source for {@link MmDeploymentInfo} objects
 * 
 * @author d031150
 */
final class MmPropertySource implements IPropertySource2 {

    private static final TracerI sTracer = TracingManager.getTracer( MmPropertySource.class );

    private static final String ID_NAME = "label"; //$NON-NLS-1$

    private static final String ID_ID = "containerName"; //$NON-NLS-1$

    private static final String ID_BUNDLE_ID = "bundleId"; //$NON-NLS-1$

    private static final String ID_LOCATION = "location"; //$NON-NLS-1$

    private static final String ID_VERSION = "version"; //$NON-NLS-1$

    private static final String ID_STATUS = "status"; //$NON-NLS-1$

    private static final String ID_ELEMENTS = "elements"; //$NON-NLS-1$

    private static final IPropertyDescriptor[] sDescs = new IPropertyDescriptor[] {
        new MmPropertyDescriptor( ID_ID, MiFwkUiMessages.MmPropertySource_containerName_label ),
        new MmPropertyDescriptor( ID_NAME, MiFwkUiMessages.MmPropertySource_label_label ),
        new MmPropertyDescriptor( ID_BUNDLE_ID, MiFwkUiMessages.MmPropertySource_plugin_label ),
        new MmPropertyDescriptor( ID_LOCATION, MiFwkUiMessages.MmPropertySource_location_label ),
        new MmPropertyDescriptor( ID_VERSION, MiFwkUiMessages.MmPropertySource_version_label ),
        new MmPropertyDescriptor( ID_STATUS, MiFwkUiMessages.MmPropertySource_status_label ),
        new MmPropertyDescriptor( ID_ELEMENTS, MiFwkUiMessages.MmPropertySource_elements ) };

    private final MmDeploymentInfo mMetamodel;

    MmPropertySource( MmDeploymentInfo metamodel ) {

        mMetamodel = metamodel;
    }

    public boolean isPropertyResettable( Object id ) {

        return false;
    }

    public boolean isPropertySet( Object id ) {

        return true;
    }

    public Object getEditableValue( ) {

        return this;
    }

    public IPropertyDescriptor[] getPropertyDescriptors( ) {

        return sDescs;
    }

    public Object getPropertyValue( Object id ) {

        if ( ID_ID.equals( id ) )
            return mMetamodel.getContainerName( );
        else if ( ID_NAME.equals( id ) )
            return mMetamodel.getLabel( );
        else if ( ID_BUNDLE_ID.equals( id ) )
            return mMetamodel.getBundleId( );
        else if ( ID_LOCATION.equals( id ) ) {
            try {
                Bundle bundle = mMetamodel.getBundle( );
                String location = FileLocator.resolve( bundle.getEntry( "/" ) ).toExternalForm( ); //$NON-NLS-1$

                // Jar'd metamodel: strip prefix and ugly trailing exlamation
                // mark: "jar:file:/C:/fooBar!/" -> "file:/C:/fooBar"
                if ( location.startsWith( "jar:" ) ) { //$NON-NLS-1$
                    location = new Path( location ).makeRelative( ).setDevice( null ).toString( );
                    int exlMarkIndex = location.lastIndexOf( '!' );
                    if ( exlMarkIndex > 0 )
                        location = location.substring( 0, exlMarkIndex );
                }

                // Unjar'd plugin or stripped from above:
                // "file:/C:/fooBar" -> "C:\fooBar"
                location = new Path( location ).makeRelative( ).setDevice( null ).removeTrailingSeparator( ).toOSString( );
                return location;
            } catch ( IOException e ) {
                MiFwkUIPlugin.logError( e, sTracer );
                return e.getMessage( );
            }
        } else if ( ID_VERSION.equals( id ) ) {
            return mMetamodel.getMetaModelPluginVersion( ).getVersionString( );
        } else if ( ID_STATUS.equals( id ) ) {
            return MetamodelManagerUI.getInstance( ).getStatusInfo( mMetamodel );
        } else if ( ID_ELEMENTS.equals( id ) ) {
            Collection<String> deployedRegistrationFiles = mMetamodel.getDeployedRegistrationFiles( );
            StringBuilder result = new StringBuilder( );
            int i = 0;
            for ( String regFile : deployedRegistrationFiles ) {
                result.append( regFile );
                i++;
                if ( i < deployedRegistrationFiles.size( ) ) {
                    result.append( ", " ); //$NON-NLS-1$
                }
            }
            return result.toString( );
        }
        return null;
    }

    public void resetPropertyValue( Object id ) {

    }

    public void setPropertyValue( Object id, Object value ) {

    }

    private static final class MmPropertyDescriptor extends PropertyDescriptor {

        public MmPropertyDescriptor( Object id, String displayName ) {

            super( id, displayName );
            setCategory( MiFwkUiMessages.MmPropertySource_category );
        }

        @Override
        protected boolean getAlwaysIncompatible( ) {

            return true;
        }
    }

}

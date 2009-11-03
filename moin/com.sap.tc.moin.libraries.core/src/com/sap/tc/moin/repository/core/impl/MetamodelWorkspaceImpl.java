package com.sap.tc.moin.repository.core.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.ResourceIdentifierFactory;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.MetamodelInstanceManager;
import com.sap.tc.moin.repository.core.MetamodelLriReference;
import com.sap.tc.moin.repository.core.MetamodelMriReference;
import com.sap.tc.moin.repository.core.MetamodelWorkspace;
import com.sap.tc.moin.repository.core.MriReference;
import com.sap.tc.moin.repository.core.QueryLinkManager;
import com.sap.tc.moin.repository.core.WorkspaceSet;
import com.sap.tc.moin.repository.core.links.QueryLinkManagerImpl;
import com.sap.tc.moin.repository.spi.core.SpiResourceInfo;
import com.sap.tc.moin.repository.spi.core.SpiStage;
import com.sap.tc.moin.repository.spi.facility.SpiClientSpec;
import com.sap.tc.moin.repository.spi.facility.SpiDataArea;

public final class MetamodelWorkspaceImpl extends SharedWorkspaceImpl implements MetamodelWorkspace {

    private SpiDataArea metamodelDataArea;

    private SpiClientSpec metamodelClientSpec;

    private ResourceIdentifierFactory riFactory;

    private QueryLinkManager queryLinkManager;

    Map<MRI, MetamodelMriReference> metamodelMriReferences;

    Map<LRI, MetamodelLriReference> metamodelLriReferences;

    public MetamodelWorkspaceImpl( WorkspaceSet workspaceSet, SpiStage stage, SpiClientSpec metamodelClientSpec, ResourceIdentifierFactory riFactory ) {

        super( workspaceSet, stage );
        this.metamodelClientSpec = metamodelClientSpec;
        this.metamodelDataArea = (SpiDataArea) metamodelClientSpec.getDataArea( );
        this.riFactory = riFactory;
        this.queryLinkManager = new QueryLinkManagerImpl( this );
        this.metamodelMriReferences = new HashMap<MRI, MetamodelMriReference>( 2048 );
        this.metamodelLriReferences = new HashMap<LRI, MetamodelLriReference>( 512 );
    }

    @Override
    protected void initInstanceManager( ) {

        this.instanceManager = new MetamodelInstanceManagerImpl( this );
    }

    @Override
    protected void initMriReferenceMap( ) {

        // Leave 'mriReferences' at null, since we override getMriReference() to always return 
        // MetamodelMriReferences instead of MriReferences.
    }

    @Override
    public boolean isMetamodelWorkspace( ) {

        return true;
    }

    @Override
    public MetamodelInstanceManager getInstanceManager( ) {

        return (MetamodelInstanceManager) instanceManager;
    }

    public CorePartitionable getMetamodelElement( String mofId ) {

        CorePartitionable element = getInstanceManager( ).getInstance( mofId );
        if ( element == null ) {
            LRI lri = riFactory.createLri( metamodelDataArea.getName( ), mofId );
            SpiResourceInfo resourceInfo = metamodelClientSpec.getResourceInfo( lri );
            if ( resourceInfo != null ) {
                PRI pri = resourceInfo.getPri( );
                if ( pri != null ) {
                    element = resolveElementMri( pri.createMri( mofId ) );
                }
            }
        }
        return element;
    }

    public CorePartitionable resolveElementMri( MRI mri ) {

        return resolveElementMri( null, mri );
    }

    public SpiDataArea getMetamodelDataArea( ) {

        return metamodelDataArea;
    }

    @Override
    public QueryLinkManager getQueryLinkManager( ) {

        return this.queryLinkManager;
    }

    @SuppressWarnings( "unchecked" )
    @Override
    public void destroy( ) {

        super.destroy( );
        this.metamodelClientSpec = null;
        this.metamodelDataArea = null;
        this.riFactory = null;
        this.metamodelMriReferences = Collections.EMPTY_MAP;
        this.metamodelLriReferences = Collections.EMPTY_MAP;
    }

    @Override
    public MriReference getMriReference( CorePartitionable partitionable, MRI mri ) {

        return getMetamodelMriReference( partitionable, mri );
    }

    @Override
    public void uncacheMriReference( MRI mri ) {

        uncacheMetamodelMriReference( mri );
    }

    public MetamodelMriReference getMetamodelMriReference( CorePartitionable partitionable, MRI mri ) {

        MetamodelMriReference result = null;
        synchronized ( metamodelMriReferences ) {
            if ( metamodelMriReferences != Collections.EMPTY_MAP ) { // otherwise destroy() has already run
                result = metamodelMriReferences.get( mri );
                if ( result == null ) {
                    metamodelMriReferences.put( mri, result = new MetamodelMriReferenceImpl( partitionable, mri, this ) );
                }
            }
        }
        return result;
    }

    public MetamodelLriReference getMetamodelLriReference( LRI lri ) {

        MetamodelLriReference result = null;
        synchronized ( metamodelLriReferences ) {
            if ( metamodelLriReferences != Collections.EMPTY_MAP ) { // otherwise destroy() has already run
                result = metamodelLriReferences.get( lri );
                if ( result == null ) {
                    metamodelLriReferences.put( lri, result = new MetamodelLriReferenceImpl( lri, this ) );
                }
            }
        }
        return result;
    }

    private void uncacheMetamodelMriReference( MRI mri ) {

        synchronized ( metamodelMriReferences ) {
            if ( metamodelMriReferences != Collections.EMPTY_MAP ) { // otherwise destroy() has already run
                MetamodelMriReference ref = metamodelMriReferences.get( mri );
                if ( ref != null ) {
                    ref.uncache( );
                }
            }
        }
    }
}
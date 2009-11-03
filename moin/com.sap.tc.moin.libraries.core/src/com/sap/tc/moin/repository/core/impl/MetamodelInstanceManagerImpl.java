package com.sap.tc.moin.repository.core.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.MetamodelInstanceManager;
import com.sap.tc.moin.repository.core.MetamodelWorkspace;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.jmi.extension.RefBaseObjectExtension;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.messages.core.RepositoryCoreMessages;

public class MetamodelInstanceManagerImpl implements MetamodelInstanceManager {

    private final MetamodelWorkspace workspace;

    private final Map<String, CorePartitionable> instances;

    /**
     * Constructor taking the owning {@link Workspace workspace} as parameter
     * and initializing the internal structure for holding the model element
     * instances.
     * 
     * @param workspace
     */
    public MetamodelInstanceManagerImpl( MetamodelWorkspace workspace ) {

        this.workspace = workspace;
        this.instances = new IdentityHashMap<String, CorePartitionable>( );
    }

    public void injectInstance( CoreConnection connection, CorePartitionable element ) {

        String mofId = element.refMofId( );
        CorePartitionable existingElement = this.instances.put( mofId, element );

        if ( existingElement != null ) {
            //there was already an element for the mofId -> Illegal!!
            //roll back to situation as it was before
            this.instances.put( mofId, existingElement );
            throw new MoinIllegalArgumentException( RepositoryCoreMessages.INSTANCE_ALREADY_HOSTED, element.get___Mri( ).toString( ) );
        }

    }

    public void injectInstance( CorePartitionable element ) {

        this.injectInstance( null, element );
    }

    public void evictInstance( CorePartitionable element ) {

        CorePartitionable removedElement = this.instances.remove( element.refMofId( ) );
        if ( removedElement != null ) {
            if ( removedElement.equals( element ) ) {
                workspace.getWorkspaceSet( ).getReferenceManager( ).notifyBeforeInstanceEviction( element );
                ( (RefBaseObjectExtension) element ).set___Workspace( null );
            } else {//the instance to remove doesn't match!
                //rollback to situation as it was before
                this.instances.put( removedElement.refMofId( ), removedElement );
            }
        }
    }

    public boolean isModelElementInjected( LRI lri ) {

        String mofId = lri.getMofId( );
        return getInstance( mofId ) != null;
    }

    public CorePartitionable getInstance( CoreSession session, LRI lri ) {

        String mofId = lri.getMofId( );
        return this.getInstance( mofId );
    }

    public CorePartitionable getInstance( String mofId ) {

        return this.instances.get( mofId );
    }

    public Collection<CorePartitionable> getInstances( LRI lri ) {

        // Duplicate element inconsistencies cannot be handled right now.
        CorePartitionable instance = getInstance( null /* session */, lri );
        if ( instance != null ) {
            return Collections.singletonList( instance );
        }
        return Collections.emptyList( );
    }

    public CorePartitionable getInstance( MRI mri ) {

        CorePartitionable element = getInstance( mri.getMofId( ) );
        if ( element == null ) {
            return null;
        }

        if ( element.get___Mri( ).equals( mri ) ) {
            return element;
        }

        return null;
    }

    public Set<CorePartitionable> getInstances( ) {

        Set<CorePartitionable> result = new HashSet<CorePartitionable>( );
        result.addAll( this.instances.values( ) );
        return result;
    }

    @SuppressWarnings( "unchecked" )
    public Collection<Object> getInstancesLive( ) {

        return (Collection) this.instances.values( );
    }

    public Object getInstancesRaw( LRI lri ) {

        return getInstance( null /* session */, lri );
    }

    public Workspace getWorkspace( ) {

        return this.workspace;
    }
}
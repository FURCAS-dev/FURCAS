package com.sap.tc.moin.repository.core.transactions.actions;

import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CompoundClientSpecWorkspace;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.jmi.extension.RefBaseObjectExtension;
import com.sap.tc.moin.repository.core.jmi.extension.RefClassExtension;
import com.sap.tc.moin.repository.core.jmi.extension.RefObjectExtension;

public class InstanceDeleteAction extends AbstractAction {

    MRI classMri = null;

    MRI instanceMri = null;

    PRI partitionPri = null;

    Workspace workspace = null;

    public InstanceDeleteAction( CoreConnection aConnection, MRI anInstanceMri ) {

        super( aConnection );
        instanceMri = anInstanceMri;
        CorePartitionable instance = getElement( instanceMri );
        classMri = ( (Partitionable) ( (RefObject) instance ).refClass( ) ).get___Mri( );
        partitionPri = instanceMri.getPri( );
        workspace = instance.get___Workspace( );
    }

    @Override
    public void execute( ) {

        CorePartitionable element = getElement( instanceMri );
        assert !( element.get___Workspace( ) instanceof CompoundClientSpecWorkspace ) : "Illegal modification of CompoundClientSpecWorkspace!"; //$NON-NLS-1$
        // The following sequence of calls is absolutely crucial for the
        // deletion process to work. Be careful with
        // changes here!
        getPartitionChangeRecorder( ).elementDeleted( element );
        getInstanceManager( ).evictInstance( element );
        ( element ).remove___PartitionAssignment( );
        ( (RefBaseObjectExtension) element ).___delete( );
        connection.removeNewElement( element );
    }

    @Override
    public void revert( ) {

        RefClass refClass = (RefClass) getElement( classMri );
        CoreModelPartition partition = getPartition( partitionPri );
        RefObjectExtension refObject = (RefObjectExtension) ( (RefClassExtension) refClass ).get___Instance( );
        // The following sequence of calls is absolutely crucial for the
        // initialization process to work. Be careful with
        // changes here!
        refObject.set___MofId( instanceMri.getMofId( ) );
        refObject.set___Workspace( workspace );
        getInstanceManager( ).injectInstance( connection, refObject );
        refObject.set___MetaObject( refClass.refMetaObject( ) );
        refObject.set___ImmediatePackage( refClass.refImmediatePackage( ) );
        refObject.set___RefClass( refClass );
        refObject.set___PartitionAssignment( partition );
        connection.addNewElement( refObject );
        getPartitionChangeRecorder( ).undoElementDeleted( refObject );
    }

    @Override
    public boolean equals( Object obj ) {

        boolean result = false;
        if ( obj == this ) {
            return true;
        } else if ( !( obj instanceof InstanceDeleteAction ) ) {
            return false;
        } else {
            result = instanceMri.equals( ( (InstanceDeleteAction) obj ).instanceMri );
        }
        return result;
    }

    @Override
    public int hashCode( ) {

        return instanceMri.hashCode( );
    }
}

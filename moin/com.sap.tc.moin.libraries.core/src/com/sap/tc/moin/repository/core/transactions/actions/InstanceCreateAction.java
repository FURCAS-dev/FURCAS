package com.sap.tc.moin.repository.core.transactions.actions;

import com.sap.tc.moin.repository.mmi.reflect.RefClass;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CompoundClientSpecWorkspace;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.jmi.extension.RefBaseObjectExtension;
import com.sap.tc.moin.repository.core.jmi.extension.RefClassExtension;
import com.sap.tc.moin.repository.core.jmi.extension.RefObjectExtension;

public class InstanceCreateAction extends AbstractAction {

    MRI classMri = null;

    MRI instanceMri = null;

    PRI partitionPri = null;

    Workspace workspace = null;

    public InstanceCreateAction( CoreConnection aConnection, MRI aClassMri, MRI anInstanceMri, PRI aPartitionPri, Workspace aWorkspace ) {

        super( aConnection );
        classMri = aClassMri;
        instanceMri = anInstanceMri;
        partitionPri = aPartitionPri;
        workspace = aWorkspace;
    }

    @Override
    public void execute( ) {

        assert !( workspace instanceof CompoundClientSpecWorkspace ) : "Illegal modification of CompoundClientSpecWorkspace!"; //$NON-NLS-1$
        RefClass refClass = (RefClass) getElement( classMri );
        CoreModelPartition partition = getPartition( partitionPri );
        RefObjectExtension refObject = (RefObjectExtension) ( (RefClassExtension) refClass ).get___Instance( );
        // The following sequence of calls is absolutely crucial for the
        // initialization process to work. Be careful with
        // changes here!        
        refObject.set___MofId( instanceMri.getMofId( ) );
        refObject.set___Workspace( workspace );
        refObject.set___PartitionAssignment( partition );

        getInstanceManager( ).injectInstance( connection, refObject );

        refObject.set___MetaObject( refClass.refMetaObject( ) );
        refObject.set___ImmediatePackage( refClass.refImmediatePackage( ) );
        refObject.set___RefClass( refClass );

        refObject.initialize___Values( connection );
        connection.addNewElement( refObject );
        getPartitionChangeRecorder( ).elementCreated( refObject );
    }

    @Override
    public void revert( ) {

        CorePartitionable element = getElement( instanceMri );
        // partitionChangeRecorder.undoElementCreated((Partitionable)
        // refObject);
        // The following sequence of calls is absolutely crucial for the
        // deletion process to work. Be careful with
        // changes here!
        getPartitionChangeRecorder( ).undoElementCreated( element );
        getInstanceManager( ).evictInstance( element );
        element.remove___PartitionAssignment( );
        ( (RefBaseObjectExtension) element ).___delete( );
        connection.removeNewElement( element );
    }

    @Override
    public boolean equals( Object obj ) {

        boolean result = false;
        if ( obj == this ) {
            return true;
        } else if ( !( obj instanceof InstanceCreateAction ) ) {
            return false;
        } else {
            result = instanceMri.equals( ( (InstanceCreateAction) obj ).instanceMri );
        }
        return result;
    }

    @Override
    public int hashCode( ) {

        return instanceMri.hashCode( );
    }
}
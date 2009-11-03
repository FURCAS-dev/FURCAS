package com.sap.tc.moin.facility.pde;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceRuleFactory;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.MultiRule;

import com.sap.tc.moin.facility.primary.ipi.IpiFacilityComponent;
import com.sap.tc.moin.facility.primary.ipi.IpiStorage;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement;
import com.sap.tc.moin.facility.primary.persistence.fs.StorageDirectoryImpl;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.commands.PartitionOperation.Operation;
import com.sap.tc.moin.repository.spi.facility.SpiExternalSaveLocking;

/**
 * Ide specific implementation of the external save locking protocol.
 * 
 * @author d047015
 * @author d046220
 */
public class IdeExternalSaveLocking implements SpiExternalSaveLocking, IpiFacilityComponent {

    private IpiFsResourceManagement resourceManagement;

    // facility component life cycle

    public void finalizeStartup( ) {

    }


    public void initialize( ) {

    }


    public void tearDown( ) {

    }

    /*
     * binding the different components
     */

    public void bind( IpiFsResourceManagement resourceManagement ) {

        this.resourceManagement = resourceManagement;
    }

    public Object acquireLock( Collection<PRI> partitionsToBeEdited, Collection<PRI> partitionsToBeCreated, Collection<PRI> partitionsToBeDeleted ) {

        boolean lockAcquired = false;
        ISchedulingRule rule = null;

        if ( partitionsToBeEdited == null || partitionsToBeCreated == null || partitionsToBeDeleted == null ) {
            throw new RuntimeException( "Lock acquisition expects no null argument" );
        } else {
            Set<ISchedulingRule> resourceRules = calculateRulesForPartitions( partitionsToBeCreated, Operation.CREATE );
            resourceRules.addAll( calculateRulesForPartitions( partitionsToBeDeleted, Operation.DELETE ) );
            // use operation CREATE for edited partitions because file might be deleted while partition was dirty
            resourceRules.addAll( calculateRulesForPartitions( partitionsToBeEdited, Operation.CREATE ) );

            ISchedulingRule[] resourcesForLocking = resourceRules.toArray( new ISchedulingRule[resourceRules.size( )] );

            rule = new MultiRule( resourcesForLocking );

        }

        try {
            Job.getJobManager( ).beginRule( rule, null );

            lockAcquired = true;
        } catch ( OperationCanceledException e ) {
            // $JL-EXC$ ignore
        } finally {
            if ( !lockAcquired ) {
                Job.getJobManager( ).endRule( rule );
            }
        }

        return rule;
    }

    public void releaseLock( Object lockHandle ) {

        if ( lockHandle != null && lockHandle instanceof ISchedulingRule ) {
            Job.getJobManager( ).endRule( (ISchedulingRule) lockHandle );
        } else {
            throw new RuntimeException( "Illegal lockHandle for releaseLock()!" );
        }
    }

    /*
     * private methods
     */

    private Set<ISchedulingRule> calculateRulesForPartitions( Collection<PRI> pris, Operation partitionOperation ) {

        Set<ISchedulingRule> iRules = new HashSet<ISchedulingRule>( pris.size( ) );
        IResourceRuleFactory ruleFactory = ResourcesPlugin.getWorkspace( ).getRuleFactory( );
        IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace( ).getRoot( );
        for ( PRI pri : pris ) {
            IpiStorage storage = this.resourceManagement.getStorageResponsibleForPRI( pri );
            if ( storage instanceof StorageDirectoryImpl ) {
                String sourcePath = storage.getSourcePath( );
                String resourceFolder = storage.getResourceFolder( );
                IResource resource = null;
                ISchedulingRule teamRule = null;
                switch ( partitionOperation ) {
                    case CREATE:
                        // use source path for pre creation locking since the resource folder may not exists yet
                        resource = workspaceRoot.findMember( sourcePath );
                        teamRule = ruleFactory.createRule( workspaceRoot.getFile( new Path( sourcePath + "/" + pri.getPartitionName( ) ) ) ); //$NON-NLS-1$
                        break;
                    case DELETE:
                        // use parent folder for pre deletion locking (wrt eclipse locking mechanism)  
                        resource = workspaceRoot.findMember( sourcePath + "/" + resourceFolder ); //$NON-NLS-1$
                        teamRule = ruleFactory.deleteRule( workspaceRoot.getFile( new Path( sourcePath + "/" + pri.getPartitionName( ) ) ) ); //$NON-NLS-1$
                        break;
                    case EDIT:
                        // use the edited resource itself for pre editing locking
                        resource = workspaceRoot.findMember( sourcePath + "/" + pri.getPartitionName( ) ); //$NON-NLS-1$
                        teamRule = ruleFactory.modifyRule( workspaceRoot.getFile( new Path( sourcePath + "/" + pri.getPartitionName( ) ) ) ); //$NON-NLS-1$
                        break;
                    default:
                        throw new RuntimeException( "Unexpected partition operation." );
                }

                if ( resource != null ) {
                    iRules.add( resource );
                }
                if ( teamRule != null ) {
                    iRules.add( teamRule );
                }
            }
        }

        return iRules;
    }



}

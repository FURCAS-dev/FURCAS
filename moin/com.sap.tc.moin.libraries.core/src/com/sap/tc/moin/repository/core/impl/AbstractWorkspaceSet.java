package com.sap.tc.moin.repository.core.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.sap.tc.moin.repository.DataArea;
import com.sap.tc.moin.repository.DuplicateElementException;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.ResourceIdentifierFactory;
import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.cdam.CompoundClientSpec;
import com.sap.tc.moin.repository.cdam.CompoundDataArea;
import com.sap.tc.moin.repository.consistency.DuplicateElementConsistencyViolation;
import com.sap.tc.moin.repository.core.CompoundClientSpecWorkspace;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CoreMoin;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.Extent;
import com.sap.tc.moin.repository.core.ExtentManager;
import com.sap.tc.moin.repository.core.LogicalLinkManager;
import com.sap.tc.moin.repository.core.PartitionLockManager;
import com.sap.tc.moin.repository.core.SessionWorkspace;
import com.sap.tc.moin.repository.core.SharedWorkspace;
import com.sap.tc.moin.repository.core.SynchronizationManager;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.WorkspaceSet;
import com.sap.tc.moin.repository.core.WrapperManager;
import com.sap.tc.moin.repository.exception.ExceptionWrapperMessages;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.cdam.SpiCompoundClientSpec;
import com.sap.tc.moin.repository.spi.core.SpiResourceInfo;
import com.sap.tc.moin.repository.spi.core.SpiSession;

/**
 * Contains common functionality for metamodel and model workspace sets.
 * 
 * @author D046220
 */
abstract class AbstractWorkspaceSet implements WorkspaceSet {

    protected static MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_CORE, WorkspaceSetImpl.class );

    private final CoreMoin moin;

    public AbstractWorkspaceSet( CoreMoin moin ) {

        this.moin = moin;
    }

    public CoreMoin getMoin( ) {

        return moin;
    }

    // FIXME: to be removed
    public ExtentManager getExtentManager( ) {

        return moin.getExtentManager( );
    }

    public CompoundClientSpecWorkspace getCompoundClientSpecWorkspace( CompoundClientSpec compoundClientSpec ) {

        // To be overwritten by subclasses
        return null;
    }

    private ElementInfo getElementInfo( CoreSession session, LRI lri, boolean avoidLoading ) {

        // Check whether element identified by LRI is located in the MetaModel
        // DataArea
        boolean isInMetaModelDataArea = lri.getDataAreaDescriptor( ).isMetamodelDataArea( );
        Workspace workspace;
        if ( isInMetaModelDataArea ) {
            workspace = this.moin.getMetamodelWorkspace( );
        } else {
            if ( session != null ) {
                workspace = session.getWorkspace( );
            } else {
                //no session and not in metamodel data area -> cannot be resolved
                if ( logger.isTraced( MoinSeverity.WARNING ) ) {
                    logger.traceWithStack( MoinSeverity.WARNING, "LRI " + lri + " should be resolved, but session was null and LRI is not from metamodel data area, therefore returning null" ); //$NON-NLS-1$ //$NON-NLS-2$
                }
                return null;

            }
        }

        // lookup in memory first
        CorePartitionable element = workspace.getInstanceManager( ).getInstance( session, lri );
        SpiResourceInfo resourceInfo = null;
        if ( element == null ) {
            if ( isInMetaModelDataArea && moin.getExtentManager( ).isExtentMofId( lri.getMofId( ) ) ) {
                element = resolveExtentLri( session, lri );
            } else {
                if ( session != null ) {
                    // not found in SessionWorkspace => try CompoundClientSpecWorkspace
                    element = session.getCompoundClientSpecWorkspace( ).getInstanceManager( ).getInstance( session, lri );
                }
                if ( element == null ) {
                    if ( avoidLoading ) {
                        resourceInfo = this.getResourceInfo( session, lri, true );
                    } else {
                        element = this.resolveLriPersisted( session, lri );
                    }
                }
            }
        }

        ElementInfo result;

        if ( element != null ) {
            result = new ElementInfo( element );
        } else if ( resourceInfo != null ) {
            //possible that element is still in persistence (resourceInfo != null) but element
            //could already be deleted in memory -> that's the case if the partition is loaded in
            //the SessionWorkspace (because changes can only happen there)
            //since the element wasn't found in memory (see algorithm above) despite the partition 
            //being loaded, it must be deleted in memory
            if ( session.getWorkspace( ).getPartitionManager( ).isPartitionLoaded( resourceInfo.getPri( ) ) ) {
                result = null;
            } else {
                //the partition is not loaded, therefore the truth lies in the persistence i.e. 
                //the resource info is correct and can be used to create the mri
                result = new ElementInfo( resourceInfo.getPri( ).createMri( lri.getMofId( ) ) );
            }
        } else {
            result = null;
        }
        return result;
    }

    // made public for inconsistency check
    public CorePartitionable resolveLriPersisted( CoreSession session, LRI lri ) {

        // use resource info to get the correct workspace
        SpiResourceInfo resourceInfo = this.getResourceInfo( session, lri, false );
        if ( resourceInfo == null ) {
            return null;
        }
        Workspace workspace = this.getWorkspace( resourceInfo.getStage( ), session );
        return workspace.resolveElementMri( session, resourceInfo.getPri( ).createMri( lri.getMofId( ) ) );
    }

    public CorePartitionable resolveMri( CoreSession session, MRI mri ) {

        CoreModelPartition partition = resolvePri( session, mri.getPri( ), false );
        if ( partition == null ) {
            return null;
        }
        CorePartitionable result = partition.getWorkspace( ).getInstanceManager( ).getInstance( mri );
        if ( result == null ) {
            // extent LRIs have to be treated differently, because the extents are not persisted and thus cannot be loaded
            // with the usual mechanisms
            if ( mri.getDataAreaDescriptor( ).isMetamodelDataArea( ) && moin.getExtentManager( ).isExtentMofId( mri.getMofId( ) ) ) {
                result = resolveExtentLri( session, mri.getLri( ) );
            }
        }
        return result;
    }

    public MRI getMriForLri( CoreSession session, LRI lri ) {

        ElementInfo elementInfo = this.getElementInfo( session, lri, true /* avoidLoading */);
        if ( elementInfo != null ) {
            return elementInfo.getMri( );
        }
        return null;
    }

    public CorePartitionable resolveLri( CoreSession session, LRI lri ) {

        ElementInfo elementInfo = getElementInfo( session, lri, false /* avoidLoading */);
        if ( elementInfo != null ) {
            return elementInfo.getElement( );
        }
        return null;
    }

    public CorePartitionable resolveLriInMemory( CoreSession session, LRI lri ) {

        ElementInfo elementInfo = getElementInfo( session, lri, true /* avoidLoading */);
        if ( elementInfo != null ) {
            return elementInfo.getElement( );
        }
        return null;
    }

    public Collection<CorePartitionable> resolveLriInMemoryIncludingInconsistencies( CoreSession session, LRI lri ) {

        ElementInfo elementInfo = getElementInfo( session, lri, true /* avoidLoading */);
        if ( elementInfo != null ) {
            CorePartitionable element = elementInfo.getElement( );
            if ( element != null ) {
                return element.get___Workspace( ).getInstanceManager( ).getInstances( lri );
            }
        }
        return Collections.emptyList( );
    }

    /**
     * @return
     */
    public CoreModelPartition resolvePri( CoreSession session, PRI pri ) {

        if ( pri == null ) {
            throw new MoinIllegalArgumentException( CoreImplMessages.CANNOTGETPARTITIONFORARGUMENTPRIEQUALSNULL );
        }
        return this.resolvePri( session, pri, false );
    }

    public CoreModelPartition resolvePri( CoreSession session, PRI pri, boolean includeDeletedInMemory ) {

        // check whether element identified by LRI is located in the MetaModelDataArea (could also be the extent partition, therefore
        // pri.isMetaModelPartition() is not sufficient!!!)
        if ( pri.getDataAreaDescriptor( ).isMetamodelDataArea( ) ) {
            return this.moin.getMetamodelWorkspace( ).getPartitionManager( ).getPartition( session, pri, true /* loadMissing */);
        }

        if ( session == null ) {
            // no session and not in metamodel data area -> cannot be resolved
            if ( logger.isTraced( MoinSeverity.WARNING ) ) {
                logger.traceWithStack( MoinSeverity.WARNING, "PRI " + pri + " should be resolved, but session was null and PRI is not from metamodel data area, therefore returning null" ); //$NON-NLS-1$ //$NON-NLS-2$
            }
            return null;
        }

        // try to get it from the session's private workspace first, with 'loadMissing == false'
        CoreModelPartition result = session.getWorkspace( ).getPartitionManager( ).getPartition( session, pri, false /* loadMissing */);
        if ( result == null ) {
            // not found in SessionWorkspace => try CompoundClientSpecWorkspace
            result = session.getCompoundClientSpecWorkspace( ).getPartitionManager( ).getPartition( session, pri, false /* loadMissing */);
            if ( result == null ) { // not found in memory, try the persistence
                // if pri is a transient partition pri, partition cannot be in
                // persistence: shortcut
                if ( pri.isVolatilePartition( ) ) {
                    return null;
                }
                SpiResourceInfo resourceInfo = session.getCompoundClientSpec( ).getResourceInfo( pri );
                if ( resourceInfo == null ) {
                    // the facility does not know the PRI
                    return null;
                }
                // use resource info to get the correct workspace
                Workspace workspace = this.getWorkspace( resourceInfo.getStage( ), session );
                result = workspace.getPartitionManager( ).getPartition( session, pri, true /* loadMissing */);
            } else { // found in memory
                if ( !includeDeletedInMemory && ( !result.isAlive( ) ) ) {
                    result = null;
                }
            }
        } else { // found in memory
            if ( !includeDeletedInMemory && ( !result.isAlive( ) ) ) {
                result = null;
            }
        }
        return result;
    }

    protected CorePartitionable resolveExtentLri( CoreSession session, LRI extentLri ) {

        CorePartitionable result = null;
        // get the metamodel element for the extent first
        DataArea dataArea = getCompoundDataArea( ).getDataArea( extentLri.getDataAreaDescriptor( ) );
        ResourceIdentifierFactory resourceIdentifierFactory = dataArea.getFacility( ).getRIFactory( );
        String metamodelElementMofId = moin.getExtentManager( ).convertToMetamodelElementMofId( extentLri.getMofId( ) );
        // TODO create LRI by use of DataAreaDescriptor and MofId instead of string ops
        String lriString = extentLri.toString( );
        lriString = lriString.substring( 0, lriString.length( ) - extentLri.getMofId( ).length( ) ) + metamodelElementMofId;
        LRI metamodelElementLri = resourceIdentifierFactory.createLri( lriString );

        ModelElement modelElement = (ModelElement) resolveLri( session, metamodelElementLri );
        if ( modelElement != null ) {
            List<String> qn = modelElement.getQualifiedName( );
            Extent[] extents = moin.getExtentManager( ).selectExtents( qn.toArray( new String[qn.size( )] ) );
            if ( extents.length == 1 ) {
                result = (CorePartitionable) extents[0];
            } else if ( extents.length > 1 ) {
                for ( Extent extent : extents ) {
                    CorePartitionable corePartitionable = (CorePartitionable) extent;
                    if ( corePartitionable.get___Mri( ).getLri( ).equals( extentLri ) ) {
                        result = corePartitionable;
                        break;
                    }
                }
            }
        }
        return result;
    }

    private SpiResourceInfo getResourceInfo( CoreSession session, LRI lri, boolean avoidLoading ) {

        if ( lri.getDataAreaDescriptor( ).isMetamodelDataArea( ) ) {
            return moin.getMetamodelClientSpec( ).getResourceInfo( lri );
        }
        try {
            return session.getCompoundClientSpec( ).getResourceInfo( lri );
        } catch ( DuplicateElementException ex ) {

            // return resource info of mri that is used according to the inconsistency handling
            MRI usedMri = null;

            // check transient data
            for ( MRI mri : ex.getMris( ) ) {
                SpiResourceInfo tempResourceInfo = session.getCompoundClientSpec( ).getResourceInfo( mri.getPri( ) );
                if ( tempResourceInfo == null ) {
                    continue;
                }
                Workspace workspace = this.getWorkspace( tempResourceInfo.getStage( ), session );
                CorePartitionable element = null;
                if ( avoidLoading ) {
                    element = workspace.getInstanceManager( ).getInstance( mri );
                } else {
                    element = workspace.resolveElementMri( session, mri );
                }
                if ( element != null ) {

                    // since partitions are loaded and instances are injected, there must be an inconsistency registered
                    // except if all elements have been deleted in memory
                    DuplicateElementConsistencyViolation existingViolation = session.getConsistencyViolationRegistry( ).checkRegisteredDuplicateElement( mri );
                    if ( existingViolation != null ) {
                        usedMri = existingViolation.getUsedElementsMri( );
                        // has to get the resource info for the used MRI
                        // this is not necessarily the resource info for mri of the current loop iteration
                        return session.getCompoundClientSpec( ).getResourceInfo( usedMri.getPri( ) );
                    } else {
                        if ( session.getElement( mri ) != null ) {
                            usedMri = mri;
                            if ( usedMri != null ) {
                                session.getConsistencyViolationRegistry( ).notifyDuplicateElementInconsistency( mri, usedMri );
                            }
                        }
                    }
                }
            }
            if ( usedMri != null ) {
                return session.getCompoundClientSpec( ).getResourceInfo( usedMri.getPri( ) );
            }
            // usedMri is null -> there is no element left, all have been deleted in memory
            return null;
        }
    }

    protected static final class ElementInfo {

        private CorePartitionable element;

        private MRI mri;

        public ElementInfo( CorePartitionable element ) {

            this.element = element;
        }

        public ElementInfo( MRI mri ) {

            this.mri = mri;
        }

        public CorePartitionable getElement( ) {

            return this.element;
        }

        public MRI getMri( ) {

            return element != null ? element.get___Mri( ) : this.mri;
        }
    }

    public LogicalLinkManager getLogicalLinkManager( ) {

        return moin.getLogicalLinkManager( );
    }

    // not implemented 
    public SpiSession createSession( SpiCompoundClientSpec compoundClientSpec ) {

        throw new MoinUnsupportedOperationException( ExceptionWrapperMessages.MUSTOVERRIDETHISABSTRACTMETHOD );
    }

    public Collection<SessionWorkspace> getClientSpecificWorkspaces( ) {

        throw new MoinUnsupportedOperationException( ExceptionWrapperMessages.MUSTOVERRIDETHISABSTRACTMETHOD );
    }

    public CompoundDataArea getCompoundDataArea( ) {

        throw new MoinUnsupportedOperationException( ExceptionWrapperMessages.MUSTOVERRIDETHISABSTRACTMETHOD );
    }

    public PartitionLockManager getLockManager( ) {

        throw new MoinUnsupportedOperationException( ExceptionWrapperMessages.MUSTOVERRIDETHISABSTRACTMETHOD );
    }

    public int getNumberOfSessions( ) {

        throw new MoinUnsupportedOperationException( ExceptionWrapperMessages.MUSTOVERRIDETHISABSTRACTMETHOD );
    }

    public RefPackage[] getPackages( String modelContainerName, String... qualifiedName ) {

        throw new MoinUnsupportedOperationException( ExceptionWrapperMessages.MUSTOVERRIDETHISABSTRACTMETHOD );
    }

    public Collection<CoreSession> getSessions( ) {

        throw new MoinUnsupportedOperationException( ExceptionWrapperMessages.MUSTOVERRIDETHISABSTRACTMETHOD );
    }

    public Collection<CoreSession> getSessionsForClientId( String clientId ) {

        throw new MoinUnsupportedOperationException( ExceptionWrapperMessages.MUSTOVERRIDETHISABSTRACTMETHOD );
    }

    public Collection<SharedWorkspace> getSharedWorkspaces( ) {

        throw new MoinUnsupportedOperationException( ExceptionWrapperMessages.MUSTOVERRIDETHISABSTRACTMETHOD );
    }

    public SynchronizationManager getSynchronizationManager( ) {

        throw new MoinUnsupportedOperationException( ExceptionWrapperMessages.MUSTOVERRIDETHISABSTRACTMETHOD );
    }


    public WrapperManager getWrapperManager( ) {

        throw new MoinUnsupportedOperationException( ExceptionWrapperMessages.MUSTOVERRIDETHISABSTRACTMETHOD );
    }


    public boolean lriExists( CoreSession session, LRI lri ) {

        throw new MoinUnsupportedOperationException( ExceptionWrapperMessages.MUSTOVERRIDETHISABSTRACTMETHOD );
    }

    public boolean mriExists( CoreSession session, MRI mri ) {

        throw new MoinUnsupportedOperationException( ExceptionWrapperMessages.MUSTOVERRIDETHISABSTRACTMETHOD );
    }

    public boolean priExists( CoreSession session, PRI pri ) {

        throw new MoinUnsupportedOperationException( ExceptionWrapperMessages.MUSTOVERRIDETHISABSTRACTMETHOD );
    }


    public void removeSession( Session session ) {

        throw new MoinUnsupportedOperationException( ExceptionWrapperMessages.MUSTOVERRIDETHISABSTRACTMETHOD );
    }

    public CompoundClientSpecWorkspace getCompoundClientSpecWorkspace( String clientId ) {

        throw new MoinUnsupportedOperationException( CoreImplMessages.THEMMWORKSPACEDOESNOTPROVIDEANYSERVICES );
    }

    public Collection<CompoundClientSpecWorkspace> getCompoundClientSpecWorkspaces( ) {

        throw new MoinUnsupportedOperationException( CoreImplMessages.THEMMWORKSPACEDOESNOTPROVIDEANYSERVICES );
    }
}

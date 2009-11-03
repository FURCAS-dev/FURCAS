package com.sap.tc.moin.friends.impl.merge;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationImpl;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.friends.merge.AttributeOperation;
import com.sap.tc.moin.friends.merge.ElementOperation;
import com.sap.tc.moin.friends.merge.ElementOperationParameters;
import com.sap.tc.moin.friends.merge.Operation;
import com.sap.tc.moin.friends.merge.OperationInvoker;
import com.sap.tc.moin.friends.merge.OperationInvokerConfiguration;
import com.sap.tc.moin.friends.merge.OperationResult;
import com.sap.tc.moin.friends.merge.OperationTransferObject;
import com.sap.tc.moin.friends.merge.OperationType;
import com.sap.tc.moin.friends.merge.ReorderAttributeValueOperationParameters;
import com.sap.tc.moin.friends.merge.ReorderLinkOperationParameters;
import com.sap.tc.moin.friends.merge.SetAttributeValueOperationParameters;
import com.sap.tc.moin.friends.merge.SetLinkOperationParameters;
import com.sap.tc.moin.repository.InvalidConnectionException;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.AbstractConnectionAwareWrapper;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.JmiCoreMessages;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.MultiValuedAttributesList;
import com.sap.tc.moin.repository.core.SynchronizationManager;
import com.sap.tc.moin.repository.core.jmi.reflect.RefAssociationImpl;
import com.sap.tc.moin.repository.core.jmi.reflect.RefClassImpl;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;
import com.sap.tc.moin.repository.spi.core.Wrapper;

/**
 * The {@link OperationInvoker} implementation
 */
public class OperationInvokerImpl implements OperationInvoker {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_UTIL, OperationInvokerImpl.class );

    private final Map<String, Set<OperationTransferObject>> pendingOperations = new HashMap<String, Set<OperationTransferObject>>( );

    private final Set<String> implicitDeletions = new HashSet<String>( );

    private final Map<OperationTransferObject, Object> operationToOwner = new HashMap<OperationTransferObject, Object>( );

    private final Set<OperationResult> operations = new HashSet<OperationResult>( );

    private static final class ResultTuple implements OperationResult {

        private final OperationTransferObject mytransfer;

        private final Object myResult;

        private final Set<String> myIds;

        private Object myOwner;

        private final Map<OperationResult, Object> dependentExecuted = new HashMap<OperationResult, Object>( );

        public ResultTuple( OperationTransferObject transfer, Object result, Set<String> mofids ) {

            this.myIds = Collections.unmodifiableSet( mofids );
            this.mytransfer = transfer;
            this.myResult = result;
        }


        public Set<String> getAffectedMofIds( ) {

            return this.myIds;
        }

        public Object retrieveResult( ) {

            return this.myResult;
        }

        public Map<OperationResult, Object> getDependentExecutedOperations( ) {

            return Collections.unmodifiableMap( this.dependentExecuted );
        }

        public void addDependentExecuted( OperationResult dependent, Object owner ) {

            this.dependentExecuted.put( dependent, owner );
        }

        public Object getOwner( ) {

            return this.myOwner;
        }

        public void setOwner( Object owner ) {

            this.myOwner = owner;
        }

        public OperationTransferObject getOperationTransferObject( ) {

            return this.mytransfer;
        }
    }

    private static final class ConnectionTriple {

        private final PRI myPri;

        private final CoreModelPartition myCorePartition;

        private CoreConnection myConnection;

        private final String myName;

        public ConnectionTriple( ModelPartition aPartition, String name ) {

            this.myName = name;
            this.myPri = aPartition.getPri( );
            this.myCorePartition = null;
            this.myConnection = ( (AbstractConnectionAwareWrapper) aPartition ).getCoreConnection( );
        }

        public ConnectionTriple( CoreModelPartition aCorePartition, CoreConnection aCoreConnection ) {

            this.myName = "Transient"; //$NON-NLS-1$
            this.myPri = null;
            this.myCorePartition = aCorePartition;
            this.myConnection = aCoreConnection;
        }

        public CoreSession getCoreSession( ) {

            return this.myConnection.getSession( );
        }

        public CoreModelPartition getCorePartition( ) {

            if ( this.myCorePartition == null ) {
                // the actual partition instance may be replaced by copyonwrite
                return this.myConnection.getPartition( this.myPri );
            }
            return this.myCorePartition;
        }


        public CoreConnection getCoreConnection( ) {

            return this.myConnection;
        }

        public Partitionable getElement( String mofid ) {


            for ( Partitionable p : getCorePartition( ).getElements( ) ) {
                if ( p.refMofId( ).equals( mofid ) ) {
                    return p;
                }
            }

            return null;
        }

        @Override
        public String toString( ) {

            return this.myName;
        }

    }

    private final ConnectionTriple sourceTriple;

    private final ConnectionTriple targetTriple;

    private final ConnectionTriple transientTriple;

    //this constant is used to find recently applied operations. It allows a certain speedup by finding the
    //needed data if recently created, instead of traversing the whole model partition
    private final static int DEPTH_SEARCH = 3;

    // objects that exist temporarily for undo of delete
    private final Map<String, String> objectAndParentId = new HashMap<String, String>( );

    // hold them to they survive
    private final Set<RefObject> objects = new HashSet<RefObject>( );

    private final boolean unitMode;

    /**
     * @param sourcePartition the partition on which to work
     * @param targetPartition the target partition
     * @param config configuration data
     */
    public OperationInvokerImpl( ModelPartition sourcePartition, ModelPartition targetPartition, OperationInvokerConfiguration config ) {

        this.sourceTriple = new ConnectionTriple( sourcePartition, "Source" ); //$NON-NLS-1$
        this.targetTriple = new ConnectionTriple( targetPartition, "Target" ); //$NON-NLS-1$
        CoreModelPartition transientPartition = this.sourceTriple.getCoreConnection( ).getOrCreateTransientPartition( "TransientForMergeObjects" ); //$NON-NLS-1$
        this.transientTriple = new ConnectionTriple( transientPartition, this.sourceTriple.getCoreConnection( ) );
        this.unitMode = config.getUnitMode( );

        LOGGER.trace( MoinSeverity.DEBUG, "Initializing the Operation Invoker for partition {0}", sourcePartition.getPri( ).toString( ) ); //$NON-NLS-1$
        LOGGER.trace( MoinSeverity.DEBUG, "Source connection: {0}", this.sourceTriple.getCoreConnection( ).toString( ) ); //$NON-NLS-1$
        LOGGER.trace( MoinSeverity.DEBUG, "Target connection: {0}", this.targetTriple.getCoreConnection( ).toString( ) ); //$NON-NLS-1$
        LOGGER.trace( MoinSeverity.DEBUG, "Unit mode: {0}", Boolean.toString( this.unitMode ) ); //$NON-NLS-1$
    }


    public OperationResult invokeOperation( OperationTransferObject operation, Object owner ) {

        SynchronizationManager mgr = this.sourceTriple.getCoreSession( ).getWorkspaceSet( ).getSynchronizationManager( );
        synchronized ( mgr.getProhibitWriteSyncObject( ) ) {

            LOGGER.trace( MoinSeverity.DEBUG, "Invoking operation {0}, owner {1}, ID {2}", operation.toString( ), owner.toString( ), operation.getId( ) ); //$NON-NLS-1$

            boolean alive;
            try {
                alive = this.sourceTriple.getCoreConnection( ).isAlive( );
            } catch ( Exception e ) {
                alive = false;
            }
            if ( !alive ) {
                throw new InvalidConnectionException( JmiCoreMessages.CONNECTIONISINVALID, this.sourceTriple.getCoreConnection( ).getId( ), this.sourceTriple.getCoreConnection( ).getLabel( ) );
            }
            mgr.acquireMicroWriteLock( );

            try {

                ResultTuple tuple = invokeInternal( operation );
                tuple.setOwner( owner );

                if ( !tuple.getAffectedMofIds( ).isEmpty( ) ) {
                    this.operations.add( tuple );
                } else {
                    this.operationToOwner.put( tuple.getOperationTransferObject( ), owner );
                }

                Set<String> affectedMofids = tuple.getAffectedMofIds( );

                while ( !affectedMofids.isEmpty( ) ) {
                    for ( String mofid : affectedMofids ) {
                        Set<String> dependentAffectedMofids = new HashSet<String>( );
                        Set<OperationTransferObject> ops = this.pendingOperations.get( mofid );
                        List<OperationTransferObject> opsToExecute = new ArrayList<OperationTransferObject>( );

                        if ( ops != null && ops.size( ) > 0 ) {
                            opsToExecute.addAll( ops );


                            for ( OperationTransferObject op : opsToExecute ) {
                                ResultTuple subResult = invokeInternal( op );
                                if ( !subResult.getAffectedMofIds( ).isEmpty( ) ) {
                                    dependentAffectedMofids.addAll( subResult.getAffectedMofIds( ) );
                                    this.operations.add( subResult );
                                    tuple.addDependentExecuted( subResult, this.operationToOwner.get( subResult.getOperationTransferObject( ) ) );
                                    ops.remove( op );
                                }
                            }
                        }
                        affectedMofids = dependentAffectedMofids;
                    }
                }

                if ( this.sourceTriple.getCoreConnection( ).hasReferencedTransientElements( ) ) {
                    // TODO localize
                    throw new IllegalStateException( "Links to transient" ); //$NON-NLS-1$
                }

                return tuple;

            } catch ( Exception e ) {
                throw new RuntimeException( e );
            } finally {
                mgr.releaseMicroWriteLock( );
            }
        }
    }

    private ResultTuple invokeInternal( OperationTransferObject operation ) {

        Operation operationToPerform = operation.getOperation( );

        switch ( operationToPerform.getType( ) ) {
            case NEW_OBJECT: {
                // if the parent is not yet here, this will become pending
                return invokeNewOperation( operation );
            }
            case DELETE_OBJECT: {
                // normally, this should not become pending
                return invokeDeleteOperation( operation );
            }

            case SET_ATTRIBUTE: {
                // attributes are isolated, should not become pending
                return executeSetAttributeOperation( operation, false, this.sourceTriple );
            }

            case ADD_LINK: // fall through
            case REMOVE_LINK: {
                // this is the main place where "pending" is important: if the
                // link is to be created before the object, it will have to wait
                // for the object
                return executeLinkOperation( operation, false, this.sourceTriple );
            }
            case REORDER_VALUES: {
                // similar to attributes, this is isolated, should not become pending
                return executeReorderValues( operation, false, this.sourceTriple );
            }

            case ADD_ATTRIBUTE_VALUE: {
                // attributes are isolated, should not become pending
                return executeSingleAttributeValueOperation( operation, false, true, this.sourceTriple );
            }

            case DEL_ATTRIBUTE_VALUE: {
                // attributes are isolated, should not become pending
                return executeSingleAttributeValueOperation( operation, false, false, this.sourceTriple );
            }
        }
        throw new MoinIllegalStateException( FriendsImplMergeMessages.NOHANDLERFOROPERATIONTYPE, operationToPerform.getType( ).toString( ) );
    }

    public OperationResult revertOperation( OperationTransferObject operation, Object owner ) {

        SynchronizationManager mgr = this.sourceTriple.getCoreSession( ).getWorkspaceSet( ).getSynchronizationManager( );
        synchronized ( mgr.getProhibitWriteSyncObject( ) ) {

            LOGGER.trace( MoinSeverity.DEBUG, "Reverting operation {0}, ID {1}", operation.toString( ), operation.getId( ) ); //$NON-NLS-1$

            try {
                this.sourceTriple.getCoreConnection( ).isAlive( );
            } catch ( Exception e ) {
                throw new InvalidConnectionException( JmiCoreMessages.CONNECTIONISINVALID, this.sourceTriple.getCoreConnection( ).getId( ), this.sourceTriple.getCoreConnection( ).getLabel( ) );
            }
            mgr.acquireMicroWriteLock( );

            try {

                ResultTuple result = revertInternal( operation );
                result.setOwner( owner );

                if ( !result.getAffectedMofIds( ).isEmpty( ) ) {
                    this.operations.add( result );
                } else {
                    this.operationToOwner.put( result.getOperationTransferObject( ), owner );
                }

                Set<String> affectedMofids = result.getAffectedMofIds( );

                while ( !affectedMofids.isEmpty( ) ) {
                    for ( String mofid : affectedMofids ) {
                        Set<String> dependentAffectedMofids = new HashSet<String>( );
                        Set<OperationTransferObject> ops = this.pendingOperations.get( mofid );
                        List<OperationTransferObject> opsToExecute = new ArrayList<OperationTransferObject>( );

                        if ( ops != null && ops.size( ) > 0 ) {
                            opsToExecute.addAll( ops );


                            for ( OperationTransferObject op : opsToExecute ) {
                                ResultTuple subResult = revertInternal( op );
                                if ( !subResult.getAffectedMofIds( ).isEmpty( ) ) {
                                    dependentAffectedMofids.addAll( subResult.getAffectedMofIds( ) );
                                    this.operations.add( subResult );
                                    result.addDependentExecuted( subResult, this.operationToOwner.get( subResult.getOperationTransferObject( ) ) );
                                    ops.remove( op );
                                }
                            }
                        }
                        affectedMofids = dependentAffectedMofids;
                    }
                }

                return result;

            } catch ( Exception e ) {
                throw new RuntimeException( e );
            } finally {
                mgr.releaseMicroWriteLock( );
            }
        }
    }

    private ResultTuple revertInternal( OperationTransferObject operation ) {

        Operation operationToPerform = operation.getOperation( );

        switch ( operationToPerform.getType( ) ) {
            case NEW_OBJECT: {
                return revertNewOperation( operation, this.sourceTriple );
            }

            case DELETE_OBJECT: {
                return revertDeleteOperation( operation );
            }
            case SET_ATTRIBUTE: {
                return executeSetAttributeOperation( operation, true, this.sourceTriple );
            }

            case ADD_LINK: // fall through
            case REMOVE_LINK: {
                return executeLinkOperation( operation, true, this.sourceTriple );
            }

            case REORDER_VALUES: {
                return executeReorderValues( operation, true, this.sourceTriple );
            }

            case ADD_ATTRIBUTE_VALUE: {
                return executeSingleAttributeValueOperation( operation, true, true, this.sourceTriple );
            }

            case DEL_ATTRIBUTE_VALUE: {
                return executeSingleAttributeValueOperation( operation, true, false, this.sourceTriple );
            }
        }

        throw new MoinIllegalStateException( FriendsImplMergeMessages.NOHANDLERFOROPERATIONTYPE, operationToPerform.getType( ).toString( ) );
    }

    public boolean hasPendingOperations( ) {

        Collection<Set<OperationTransferObject>> pendings = this.pendingOperations.values( );
        for ( Set<OperationTransferObject> pending : pendings ) {
            if ( !pending.isEmpty( ) ) {
                return true;
            }
        }

        return !this.implicitDeletions.isEmpty( );

    }

    public Set<OperationResult> getOperationResults( ) {

        if ( this.hasPendingOperations( ) ) {
            throw new IllegalStateException( );// TODO explain
        }
        Set<OperationResult> result = new HashSet<OperationResult>( );
        result.addAll( this.operations );
        this.operations.clear( );
        return result;
    }

    private ResultTuple invokeNewOperation( OperationTransferObject operation ) {

        ElementOperationParameters params = (ElementOperationParameters) operation.getParameters( );
        RefClass owner = ( (ElementOperation) operation.getOperation( ) ).getOwner( );
        String mofId = params.getId( );
        // check if it is to be created under a parent, if the parent doesn't exist, it must wait
        RefObjectImpl original = (RefObjectImpl) this.targetTriple.getElement( mofId );
        RefFeatured parent = original.refImmediateComposite( this.targetTriple.getCoreSession( ) );
        if ( parent != null ) {
            // verify the parent
            String parentId = parent.refMofId( );
            if ( this.sourceTriple.getElement( parentId ) == null ) {
                if ( this.unitMode ) {
                    this.addPendingOperation( operation, parentId );
                    return new ResultTuple( operation, null, new HashSet<String>( ) );
                }
                throw new MoinIllegalStateException( FriendsImplMergeMessages.PARENTNOTFOUND );
            }
        }

        RefObjectImpl trans = (RefObjectImpl) this.transientTriple.getElement( mofId );
        if ( trans != null ) {
            deleteObjectRecursive( trans, this.transientTriple );
        }

        return copyObject( operation, owner, mofId, this.targetTriple, this.sourceTriple );


    }

    private ResultTuple invokeDeleteOperation( OperationTransferObject operation ) {

        String ownerId = ( (ElementOperationParameters) operation.getParameters( ) ).getId( );
        //owner must not be referenced!! TODO - check whether any references exist..

        if ( this.implicitDeletions.contains( ownerId ) ) {
            // TODO dependent?
            ResultTuple tuple = new ResultTuple( operation, ownerId, new HashSet<String>( ) );
            return tuple;
        }

        RefObjectImpl objToCopy = (RefObjectImpl) this.sourceTriple.getElement( ownerId );
        RefObjectImpl parent = (RefObjectImpl) objToCopy.refImmediateComposite( this.sourceTriple.getCoreSession( ) );
        String parentId = null;
        if ( parent != null ) {
            parentId = parent.refMofId( );
        }
        RefClass clazz = getRefClassFromRefObject( objToCopy, this.sourceTriple );

        //deleteObjectRecursive( objToCopy, this.sourceTriple );

        Partitionable transientObject = this.transientTriple.getElement( objToCopy.refMofId( ) );
        if ( transientObject != null ) {
            deleteObjectRecursive( (RefObjectImpl) transientObject, this.transientTriple );
        }

        Set<String> copyResult = copyObjectRecursive( objToCopy, clazz, null, this.sourceTriple, this.transientTriple );

        if ( copyResult != null ) {
            this.objectAndParentId.put( ownerId, parentId );
            //this.objects.add( copyResult );
        }

        Set<String> mofids = deleteObjectRecursive( objToCopy, this.sourceTriple );
        deleteParentLink( objToCopy, this.sourceTriple );

        Set<String> implicits = new HashSet<String>( );
        // TODO
        implicits.addAll( mofids );
        implicits.remove( objToCopy.refMofId( ) );
        this.implicitDeletions.addAll( implicits );
        // TODO
        ResultTuple tuple = new ResultTuple( operation, ownerId, mofids );
        return tuple;
    }


    private void deleteParentLink( RefObjectImpl objToCopy, ConnectionTriple in ) {


        RefObjectImpl parent = (RefObjectImpl) objToCopy.refImmediateComposite( in.getCoreSession( ) );
        if ( parent == null ) {
            return;
        }
        EndStorageLink parentLink = objToCopy.get___CompositeParentLink( );

        LOGGER.trace( MoinSeverity.DEBUG, "Removing the composite parent link in " + in.toString( ) ); //$NON-NLS-1$

        AssociationImpl assoc = (AssociationImpl) this.sourceTriple.getCoreConnection( ).getElement( parentLink.getMetaObjectMri( ) );
        RefAssociationImpl refAssoc = (RefAssociationImpl) in.getCoreConnection( ).getCoreJmiHelper( ).getRefAssociationForAssociation( in.getCoreSession( ), assoc );

        byte composite = refAssoc.get___CompositeEnd( );

        RefObjectImpl firstEnd;
        RefObjectImpl secondEnd;

        if ( composite == 0 ) {
            firstEnd = parent;
            secondEnd = objToCopy;
        } else {
            firstEnd = objToCopy;
            secondEnd = parent;
        }
        refAssoc.refRemoveLink( in.getCoreConnection( ), firstEnd, secondEnd );


    }

    private ResultTuple executeLinkOperation( OperationTransferObject operation, boolean revert, ConnectionTriple in ) {

        SetLinkOperationParameters params = (SetLinkOperationParameters) operation.getParameters( );

        AssociationEndImpl end = (AssociationEndImpl) ( (Wrapper) params.getLinkOwner( ) ).unwrap( );
        Association assoc = (Association) end.refImmediateComposite( in.getCoreSession( ) );

        SpiJmiHelper helper = in.getCoreConnection( ).getCoreJmiHelper( );

        RefAssociationImpl refAssoc = (RefAssociationImpl) helper.getRefAssociationForAssociation( in.getCoreSession( ), assoc );

        String referencedId = params.getReferencedElementId( );
        String exposedId = params.getExposedElementId( );

        boolean exposedInTransient = false;
        boolean referencedInTransient = false;

        RefObject exposedObject = (RefObject) in.getElement( exposedId );
        if ( exposedObject == null ) {
            exposedObject = (RefObject) this.transientTriple.getElement( exposedId );
            if ( exposedObject != null ) {
                exposedInTransient = true;
            }
        }
        RefObject referencedObject = (RefObject) in.getElement( referencedId );
        if ( referencedObject == null ) {
            referencedObject = (RefObject) this.transientTriple.getElement( referencedId );
            if ( referencedObject != null ) {
                referencedInTransient = true;
            }
        }

        int number = helper.getAssociationEndNumber( in.getCoreSession( ), end );

        if ( exposedInTransient || referencedInTransient ) {

            if ( ( operation.getOperation( ).getType( ) == OperationType.ADD_LINK && !revert ) ) {
                // add the link, but object is in transient -> wrong state
                throw new IllegalStateException( ); // TODO explain
            }
            if ( ( operation.getOperation( ).getType( ) == OperationType.REMOVE_LINK && !revert ) || ( operation.getOperation( ).getType( ) == OperationType.ADD_LINK && revert ) ) {
                // delete the link
                boolean changed;
                if ( number == 0 ) {
                    changed = refAssoc.refRemoveLink( in.getCoreConnection( ), referencedObject, exposedObject );
                } else {
                    changed = refAssoc.refRemoveLink( in.getCoreConnection( ), exposedObject, referencedObject );
                }
                if ( changed ) {
                    Set<String> mofids = new HashSet<String>( );
                    mofids.add( exposedId );
                    return new ResultTuple( operation, null, mofids ); // TODO the owner object
                }
            }
            if ( ( operation.getOperation( ).getType( ) == OperationType.REMOVE_LINK && revert ) ) {
                // put into pending and see if the object is reverted eventually
                if ( exposedInTransient ) {
                    this.addPendingOperation( operation, exposedId );
                }
                if ( referencedInTransient ) {
                    this.addPendingOperation( operation, referencedId );
                }
                return new ResultTuple( operation, null, new HashSet<String>( ) );
            }
        }

        if ( exposedObject != null && referencedObject != null ) {
            //both ends for the link to be modified exist

            boolean changed;
            if ( number == 0 ) {
                changed = performLinkChange( in.getCoreConnection( ), referencedObject, exposedObject, refAssoc, operation.getOperation( ).getType( ), revert );
            } else {
                changed = performLinkChange( in.getCoreConnection( ), exposedObject, referencedObject, refAssoc, operation.getOperation( ).getType( ), revert );
            }
            if ( changed ) {
                Set<String> mofids = new HashSet<String>( );
                mofids.add( exposedId );
                return new ResultTuple( operation, null, mofids ); // TODO the owner object
            }
            throw new MoinIllegalStateException( FriendsImplMergeMessages.NOCHANGEDETECTED );
        } else if ( this.unitMode ) {
            if ( referencedObject == null ) {
                this.addPendingOperation( operation, referencedId );
            }
            if ( exposedObject == null ) {
                this.addPendingOperation( operation, exposedId );
            }

            return new ResultTuple( operation, null, new HashSet<String>( ) );
        } else {
            throw new MoinIllegalStateException( FriendsImplMergeMessages.ENDSCOULDNOTBERESOLVED );
        }

    }

    private boolean performLinkChange( CoreConnection connection, RefObject firstEnd, RefObject secondEnd, RefAssociationImpl refAssoc, OperationType type, boolean revert ) {

        boolean linkChanged = false;

        switch ( type ) {

            case ADD_LINK:
                if ( revert ) {
                    linkChanged = refAssoc.refRemoveLink( connection, firstEnd, secondEnd );
                } else {
                    linkChanged = refAssoc.refAddLink( connection, firstEnd, secondEnd );
                }
                break;


            case REMOVE_LINK:
                if ( revert ) {
                    linkChanged = refAssoc.refAddLink( connection, firstEnd, secondEnd );
                } else {
                    linkChanged = refAssoc.refRemoveLink( connection, firstEnd, secondEnd );
                }
                break;

            default:
                throw new IllegalStateException( );
        }


        return linkChanged;
    }

    private ResultTuple executeSetAttributeOperation( OperationTransferObject operation, boolean revert, ConnectionTriple in ) {

        SetAttributeValueOperationParameters params = (SetAttributeValueOperationParameters) operation.getParameters( );
        AttributeOperation setAttributeOperation = (AttributeOperation) operation.getOperation( );
        Attribute attrib = setAttributeOperation.getAttribute( );

        RefObjectImpl owner = (RefObjectImpl) in.getElement( params.getOwnerId( ) );
        Object value;
        if ( revert ) {
            value = params.getOldAttributeValue( );
        } else {
            value = params.getNewAttributeValue( );
        }

        RefObjectImpl result = setAttributeValue( attrib, owner, value, in );
        Set<String> mofIds = new HashSet<String>( );
        mofIds.add( result.refMofId( ) );
        RefObject wrapper = in.getCoreConnection( ).getWrapperForJmiObject( result );
        return new ResultTuple( operation, wrapper, mofIds );
    }

    private ResultTuple executeSingleAttributeValueOperation( OperationTransferObject operation, boolean revert, boolean add, ConnectionTriple in ) {

        SetAttributeValueOperationParameters params = (SetAttributeValueOperationParameters) operation.getParameters( );
        AttributeOperation setAttributeOperation = (AttributeOperation) operation.getOperation( );
        Attribute attrib = setAttributeOperation.getAttribute( );

        RefObjectImpl owner = (RefObjectImpl) in.getElement( params.getOwnerId( ) );
        Object value = params.getNewAttributeValue( );

        RefObjectImpl result;
        if ( add != revert ) {
            result = setAttributeValue( attrib, owner, value, in );
        } else {
            result = removeAttributeValue( attrib, owner, value, in );
        }

        Set<String> mofids = new HashSet<String>( );
        mofids.add( result.refMofId( ) );
        return new ResultTuple( operation, in.getCoreConnection( ).getWrapperForJmiObject( result ), mofids );
    }

    private ResultTuple executeReorderValues( OperationTransferObject operation, boolean revert, ConnectionTriple in ) {

        if ( operation.getParameters( ) instanceof ReorderAttributeValueOperationParameters ) {
            ReorderAttributeValueOperationParameters params = (ReorderAttributeValueOperationParameters) operation.getParameters( );
            // TODO implement this
            throw new MoinIllegalStateException( FriendsImplMergeMessages.REORDERINGATTVALUESNOTIMPLEMENTED );
        } else if ( operation.getParameters( ) instanceof ReorderLinkOperationParameters ) {

            ReorderLinkOperationParameters params = (ReorderLinkOperationParameters) operation.getParameters( );

            AssociationEndImpl end = (AssociationEndImpl) ( (Wrapper) params.getLinkOwner( ) ).unwrap( );
            Association assoc = (Association) end.refImmediateComposite( in.getCoreSession( ) );

            SpiJmiHelper helper = in.getCoreConnection( ).getCoreJmiHelper( );

            RefAssociationImpl refAssoc = (RefAssociationImpl) helper.getRefAssociationForAssociation( in.getCoreSession( ), assoc );
            RefObject exposedObject = (RefObject) in.getElement( params.getExposedElementId( ) );
            List<String> targetOrder;
            if ( revert ) {
                targetOrder = params.getOldMofIds( );
            } else {
                targetOrder = params.getNewMofIds( );
            }

            CoreSession session = in.getCoreSession( );
            CoreConnection connection = in.getCoreConnection( );

            List<String> sourceOrder = new ArrayList<String>( );

            JmiList<RefObjectImpl> list = (JmiList) refAssoc.refQuery( connection, end.otherEnd( in.getCoreConnection( ) ).getName( ), exposedObject );

            for ( int i = 0; i < list.size( session ); i++ ) {
                RefObjectImpl inst = list.get( session, i );
                sourceOrder.add( inst.get___MofId( ) );

            }

            if ( !sourceOrder.containsAll( targetOrder ) || !targetOrder.containsAll( sourceOrder ) ) {
                throw new MoinIllegalStateException( FriendsImplMergeMessages.DIFFERENTOBJECTDURINGREORDER );
            }

            int count = 0;
            boolean changed = true;
            while ( changed && count < 10000 ) {

                count++;
                changed = false;
                for ( int i = 0; i < list.size( session ); i++ ) {
                    RefObjectImpl inst = list.get( session, i );
                    String id = inst.get___MofId( );
                    if ( targetOrder.indexOf( id ) != i ) {
                        changed = true;
                        ArrayList<EndStorageLink> coll = (ArrayList<EndStorageLink>) list.getLinkCollection( );
                        coll.add( coll.remove( i ) );
                        break;
                    }
                }
            }

            if ( count > 9990 ) {
                // TODO localize
                throw new IllegalStateException( "Loop during reordering" ); //$NON-NLS-1$
            }

            Set<String> mofids = new HashSet<String>( );
            mofids.add( exposedObject.refMofId( ) );

            RefObject result = in.getCoreConnection( ).getWrapperForJmiObject( exposedObject );
            return new ResultTuple( operation, result, mofids );

        }
        throw new MoinIllegalStateException( FriendsImplMergeMessages.WRONGPARAMETERTYPE );

    }

    /**
     * Figure out the new index from the old index
     * <p>
     * This would be trivial for unique tables but is not quite for non-unique
     * ones
     * 
     * @param sourceOrder
     * @param targetOrder
     * @return
     */
    private int[] mapOrder( List<String> sourceOrder, List<String> targetOrder ) {

        Map<String, Integer> mofIdOccurences = new HashMap<String, Integer>( );
        int[] result = new int[targetOrder.size( )];

        for ( int targetIndex = 0; targetIndex < targetOrder.size( ); targetIndex++ ) {

            String targetId = targetOrder.get( targetIndex );

            int last;
            if ( mofIdOccurences.containsKey( targetId ) ) {
                last = mofIdOccurences.get( targetId ).intValue( );
            } else {
                last = 0;
            }

            int next = sourceOrder.subList( last, sourceOrder.size( ) ).indexOf( targetId );
            Integer nextOccurent = Integer.valueOf( last + next );
            mofIdOccurences.put( targetId, nextOccurent );
            result[targetIndex] = next;


        }

        return result;
    }


    private ResultTuple revertNewOperation( OperationTransferObject operation, ConnectionTriple in ) {

        ElementOperationParameters params = (ElementOperationParameters) operation.getParameters( );
        String mofId = params.getId( );

        if ( this.implicitDeletions.contains( mofId ) ) {
            // TODO dependent?
            ResultTuple tuple = new ResultTuple( operation, mofId, new HashSet<String>( ) );
            return tuple;
        }

        RefObjectImpl objectToDelete = (RefObjectImpl) in.getElement( mofId );
        deleteParentLink( objectToDelete, in );
        Set<String> mofids = deleteObjectRecursive( objectToDelete, in );
        return new ResultTuple( operation, mofId, mofids );

    }

    private ResultTuple revertDeleteOperation( OperationTransferObject operation ) {


        String objectId = ( (ElementOperationParameters) operation.getParameters( ) ).getId( );
        Set<String> mofids = this.restoreObject( objectId, this.transientTriple, this.sourceTriple );
        RefObject result = this.sourceTriple.getCoreConnection( ).getWrapperForJmiObject( (RefObject) this.sourceTriple.getElement( objectId ) );
        return new ResultTuple( operation, result, mofids );

    }



    private ResultTuple copyObject( OperationTransferObject otx, RefClass clazz, String mofId, ConnectionTriple from, ConnectionTriple to ) {

        RefObjectImpl objectToCopy = (RefObjectImpl) from.getElement( mofId );

        if ( objectToCopy == null ) {
            throw new MoinIllegalStateException( FriendsImplMergeMessages.COPYOBJECTNOTRESOLVED );
        }

        RefFeatured father = objectToCopy.refImmediateComposite( from.getCoreSession( ) );
        String fatherMofId = null;
        if ( father != null ) {
            fatherMofId = father.refMofId( );
        }

        ElementOperationParameters params = (ElementOperationParameters) otx.getParameters( );
        Set<String> mofids = copyObjectRecursive( objectToCopy, clazz, fatherMofId, from, to );
        RefObjectImpl copiedObject = (RefObjectImpl) to.getElement( mofId );
        RefObject wrapped = to.getCoreConnection( ).getWrapperForJmiObject( copiedObject );
        return new ResultTuple( otx, wrapped, mofids );

    }

    private Set<String> restoreObject( String mofId, ConnectionTriple from, ConnectionTriple to ) {

        RefObject restoredObject = (RefObject) from.getElement( mofId );
        Set<String> result = new HashSet<String>( );
        CoreModelPartition target = to.getCorePartition( );
        target.assignElementIncludingChildren( from.getCoreConnection( ), restoredObject );
        // TODO do we need to check the children?
        result.add( restoredObject.refMofId( ) );
        return result;
    }

    private RefClassImpl getRefClassFromRefObject( RefObjectImpl object, ConnectionTriple in ) {

        MofClass mofClass = (MofClass) object.refMetaObject( );
        return (RefClassImpl) in.getCoreConnection( ).getCoreJmiHelper( ).getRefClassForMofClass( in.getCoreSession( ), mofClass );
    }

    private Set<String> copyObjectRecursive( RefObjectImpl objectToCopy, RefClass clazz, String fatherMofId, ConnectionTriple from, ConnectionTriple to ) {

        LOGGER.trace( MoinSeverity.DEBUG, "Copying object {0} from {1} to {2}", objectToCopy.refMofId( ), from.toString( ), to.toString( ) ); //$NON-NLS-1$

        Set<String> result = new HashSet<String>( );
        RefClassImpl refClass;
        if ( clazz instanceof Wrapper ) {
            refClass = (RefClassImpl) ( (Wrapper) clazz ).unwrap( );
        } else {
            refClass = (RefClassImpl) clazz;
        }
        List<Object> args = new ArrayList<Object>( );
        RefObjectImpl newObject = (RefObjectImpl) refClass.refCreateInstanceInPartitionWithMofId( to.getCoreConnection( ), args, objectToCopy.refMofId( ), to.getCorePartition( ) );


        result.add( newObject.refMofId( ) );

        // copy the primitive attributes
        List<Attribute> atts = refClass.get___AllAttributes( );
        for ( Attribute att : atts ) {
            if ( att.isDerived( ) ) {
                continue;
            }

            Object value = objectToCopy.refGetValue( from.getCoreConnection( ), att );
            if ( value != null ) {
                if ( value instanceof RefObjectImpl ) {
                    // TODO object-valued attributes?
                } else {
                    setAttributeValue( att, newObject, value, to );
                }
            }
        }

        // we can only resolve this once the composite child was copied

        EndStorageLink compositeParentLink = objectToCopy.get___CompositeParentLink( );
        if ( compositeParentLink != null && fatherMofId != null && newObject.refImmediateComposite( to.getCoreSession( ) ) == null ) {
            if ( !copyLink( compositeParentLink, from, to ) ) {
                // TODO localize
                throw new RuntimeException( "Composite parent link could not be created" ); //$NON-NLS-1$
            }

        }

        // copy the non-composite, stored links
        List<EndStorageLink> storedLinks = objectToCopy.get___AllStoredAssociationLinks( );
        if ( storedLinks != null ) {
            for ( EndStorageLink storedLink : storedLinks ) {
                if ( storedLink == compositeParentLink ) {
                    continue;
                }
                int storageEndNumber = storedLink.getEndNumberOfStorageEnd( );
                // if the link is stored on the composite side, skip it, it will be handled by the compositeparentlink
                if ( storageEndNumber == storedLink.getCompositeEnd( ) ) {
                    continue;
                }
                copyLink( storedLink, from, to );
            }
        }

//        if ( deepCopy ) {
//            Collection<RefObject> children = from.getCoreConnection( ).getCoreJmiHelper( ).getCompositeChildrenStable( from.getCoreSession( ), objectToCopy, false );
//            for ( RefObject child : children ) {
//                RefObjectImpl childImpl = (RefObjectImpl) child;
//
//                RefClass actClass = getRefClassFromRefObject( childImpl, from );
//                result.addAll( copyObjectRecursive( childImpl, actClass, newObject.refMofId( ), from, to ) );
//            }
//        }

        return result;
    }

    private Set<String> deleteObjectRecursive( RefObjectImpl objectToDelete, ConnectionTriple in ) {

        if ( in != this.transientTriple && this.implicitDeletions.contains( objectToDelete.refMofId( ) ) ) {
            return new HashSet<String>( );
        }
        Set<String> mofids = new HashSet<String>( );

        Collection<RefObject> children = in.getCoreConnection( ).getCoreJmiHelper( ).getCompositeChildren( in.getCoreSession( ), objectToDelete, false );
        for ( RefObject child : children ) {
            RefObjectImpl childImpl = (RefObjectImpl) child;

            mofids.addAll( deleteObjectRecursive( childImpl, in ) );
        }

        LOGGER.trace( MoinSeverity.DEBUG, "Deleting object {0} isolated from {1}", objectToDelete.refMofId( ), in.toString( ) ); //$NON-NLS-1$
        mofids.add( objectToDelete.refMofId( ) );
        objectToDelete.delete___Isolated( in.getCoreConnection( ) );

        this.implicitDeletions.addAll( mofids );

        return mofids;
    }

    private boolean copyLink( EndStorageLink actLink, ConnectionTriple from, ConnectionTriple to ) {

        Association assoc = (Association) actLink.getMetaObject( );

        String firstElementId = actLink.getEnd( 0 ).getMofId( );
        String secondElementId = actLink.getEnd( 1 ).getMofId( );

        RefObject firstElement;
        try {
            firstElement = (RefObject) to.getElement( firstElementId );
        } catch ( Exception e ) {
            firstElement = null;
        }
        RefObject secondElement;
        try {
            secondElement = (RefObject) to.getElement( secondElementId );
        } catch ( Exception e ) {
            secondElement = null;
        }

        if ( firstElement == null && secondElement == null ) {
            throw new MoinIllegalStateException( FriendsImplMergeMessages.COULDNOTRESOLVEEITHERLINK );
        }

        if ( firstElement != null && secondElement != null ) {
            RefAssociationImpl refAssoc = (RefAssociationImpl) to.getCoreConnection( ).getCoreJmiHelper( ).getRefAssociationForAssociation( to.getCoreSession( ), assoc );
            return refAssoc.refAddLink( to.getCoreConnection( ), firstElement, secondElement );
        }

        // dangling on one end

        // we need to get both the host and the 
        LRI targetLri;
        RefObject host;
        AssociationEnd end;

        List<AssociationEnd> ends = to.getCoreConnection( ).getCoreJmiHelper( ).getAssociationEnds( to.getCoreSession( ), assoc );
        if ( firstElement == null ) {
            targetLri = actLink.getEnd( 0 ).getLri( );
            host = secondElement;
            end = ends.get( 0 );
        } else if ( secondElement == null ) {
            targetLri = actLink.getEnd( 1 ).getLri( );
            host = firstElement;
            end = ends.get( 1 );
        } else {
            return false;
        }
        to.getCoreConnection( ).addLinkTarget( host, end, targetLri );
        LOGGER.trace( MoinSeverity.DEBUG, "Dangling linke target added" ); //$NON-NLS-1$
        return true;
    }

    private RefObjectImpl setAttributeValue( Attribute attrib, RefObjectImpl refImpl, Object newValue, ConnectionTriple in ) {

        // TODO FROM AND TO
        boolean multiple = attrib.getMultiplicity( ).getUpper( ) > 1 || attrib.getMultiplicity( ).getUpper( ) == -1;

        if ( multiple ) {
            MultiValuedAttributesList<Object> values = (MultiValuedAttributesList<Object>) refImpl.refGetValue( in.getCoreConnection( ), attrib );

//            while ( values.size( ) > 0 ) {
//                values.___remove( 0 );
//            }

            if ( newValue != null ) {
                if ( newValue instanceof Collection ) {
                    for ( Object actNewVal : (Collection<Object>) newValue ) {
                        values.___add( actNewVal );
                    }
                } else {
                    values.___add( newValue );
                }
            }

        } else {
            refImpl.refSetValue( in.getCoreConnection( ), attrib, newValue );
        }

        return refImpl;
    }

    private RefObjectImpl removeAttributeValue( Attribute attrib, RefObjectImpl refImpl, Object objectToRemove, ConnectionTriple in ) {

        // TODO FROM AND TO
        boolean multiple = attrib.getMultiplicity( ).getUpper( ) > 1 || attrib.getMultiplicity( ).getUpper( ) == -1;

        if ( multiple ) {
            MultiValuedAttributesList<Object> values = (MultiValuedAttributesList<Object>) refImpl.refGetValue( in.getCoreConnection( ), attrib );

            values.___remove( objectToRemove );

        } else {
            refImpl.refSetValue( in.getCoreConnection( ), attrib, null );
        }

        return refImpl;
    }

    private void addPendingOperation( OperationTransferObject operation, String dependentId ) {

        Set<OperationTransferObject> resultList = this.pendingOperations.get( dependentId );
        if ( resultList == null ) {
            resultList = new HashSet<OperationTransferObject>( );
            this.pendingOperations.put( dependentId, resultList );
        }
        resultList.add( operation );
    }
}

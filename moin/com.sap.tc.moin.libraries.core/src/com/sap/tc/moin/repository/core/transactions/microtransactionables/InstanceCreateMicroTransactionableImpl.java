package com.sap.tc.moin.repository.core.transactions.microtransactionables;

import static com.sap.tc.moin.repository.JmiHelper.MULTIPLICITY_BOUND_INFINITE;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.SessionWorkspace;
import com.sap.tc.moin.repository.core.jmi.extension.RefClassExtension;
import com.sap.tc.moin.repository.core.jmi.reflect.RefClassImpl;
import com.sap.tc.moin.repository.core.transactions.actions.ActionFactory;
import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.ScopeKindEnum;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.reflect.AlreadyExistsException;
import com.sap.tc.moin.repository.mmi.reflect.InvalidCallException;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.TypeMismatchException;
import com.sap.tc.moin.repository.mmi.reflect.WrongSizeException;
import com.sap.tc.moin.repository.shared.util.Utilities;
import com.sap.tc.moin.repository.transactions.microtransactionables.InstanceCreateMicroTransactionable;

@SuppressWarnings( "unchecked" )
public class InstanceCreateMicroTransactionableImpl extends AbstractMicroTransactionable implements InstanceCreateMicroTransactionable {

    private RefClass instanceCreatedRefClass = null;

    private MRI instanceCreatedRefClassMri = null;

    private MRI instanceCreatedMri = null;

    private List<Object> instanceCreatedParameters = null;

    private SessionWorkspace instanceCreatedWorkspace = null;

    // the following maps contain as value
    // - instances of java.lang.Object for primitive attributes
    // - lists or collections of MRIs or java.lang.Objects for multiple attributes
    // - MRIs for object valued attributes
    // - null for nulls :)
    // the maps itself are null when no parameter is given
    private Map<Attribute, Object> initialParametersMri = null;

    private Map<Attribute, Object> finalParametersMri = null;

    private List<EndStorageLink> linksAdded = null;

    private ArrayList<Integer> indices = null;

    private Map<MRI, StateSet> elementsRepartitioned = null;

    private String calculatedMofId = null;

    private CoreModelPartition partitionOfNewElement = null;

    private PRI priOfNewElement = null;

    /**
     * Creates a Micro Transactionable that creates an instance of the specified
     * class with the specified parameter list in the null partition in the
     * client specific workspace
     */
    public InstanceCreateMicroTransactionableImpl( CoreConnection aConnection, RefClass aRefClass, List<Object> theParameters, CoreModelPartition partition ) {

        super( aConnection );
        instanceCreatedRefClass = aRefClass;
        instanceCreatedRefClassMri = ( (CorePartitionable) aRefClass ).get___Mri( );
        if ( theParameters != null && theParameters.size( ) != 0 ) {
            instanceCreatedParameters = new ArrayList<Object>( theParameters );
        }
        instanceCreatedWorkspace = connection.getSession( ).getWorkspace( );
        partitionOfNewElement = partition;
        if ( partitionOfNewElement == null ) {
            partitionOfNewElement = aConnection.getNullPartition( );
        }

        priOfNewElement = partitionOfNewElement.getPri( );
    }

    public InstanceCreateMicroTransactionableImpl( CoreConnection aConnection, RefClass aRefClass, List<Object> theParameters, CoreModelPartition partition, String mofId ) {

        this( aConnection, aRefClass, theParameters, partition );
        calculatedMofId = mofId;
    }

    @Override
    public void assertDoPreConstraints( ) throws JmiException {

        // TODO JMI Spec page 93: refCreateInstance should throw a DuplicateException, clarify in which case?
        List<Attribute> nonDerivedInstanceAttributes = getNonDerivedInstanceAttributes( instanceCreatedRefClass );
        // check abstract
        if ( ( (RefClassExtension) instanceCreatedRefClass ).is___Abstract( ) ) {
            InvalidCallException exception = new InvalidCallException( instanceCreatedRefClass, instanceCreatedRefClass.refMetaObject( ), MicroTransactionablesMessages.CANNOTCREATEINSTANCEOFABSTRACTCLASS, instanceCreatedRefClass.refMetaObject( ).getName( ) );
            log.preConstraintCheckException( exception );
            throw exception;
        }
        // check singleton, not allowed according to MOIN constraint
        if ( ( (RefClassExtension) instanceCreatedRefClass ).is___Singleton( ) == true ) {
            Collection allInstances = ( (RefClassImpl) instanceCreatedRefClass ).refAllOfClass( connection );
            if ( allInstances.size( ) > 0 ) {
                RefObject instanceAlreadyCreated = (RefObject) allInstances.iterator( ).next( );
                instanceAlreadyCreated = connection.getWrapperForJmiObject( instanceAlreadyCreated );
                throw new AlreadyExistsException( instanceAlreadyCreated );
            }
        }
        if ( instanceCreatedParameters == null ) {
            // default constructor called, no pre constraint check necessary
            finalParametersMri = null;
            return;
        }
        if ( nonDerivedInstanceAttributes == null ) {
            InvalidCallException exception = new InvalidCallException( instanceCreatedRefClass, instanceCreatedRefClass.refMetaObject( ), MicroTransactionablesMessages.NONONDERIVEDINSTANCELEVELATTRIBUTES, instanceCreatedRefClass.refMetaObject( ).getName( ), instanceCreatedParameters );
            log.preConstraintCheckException( exception );
            throw exception;
        }
        int parameterListSize = instanceCreatedParameters.size( );
        int attributeListSize = nonDerivedInstanceAttributes.size( );
        if ( parameterListSize != attributeListSize ) {
            InvalidCallException exception = new InvalidCallException( instanceCreatedRefClass, instanceCreatedRefClass.refMetaObject( ), MicroTransactionablesMessages.CANNOTCREATEINSTANCEBECAUSEATTRIBUTENUMBERMISMATCH, instanceCreatedRefClass.refMetaObject( ).getName( ), instanceCreatedParameters,
                                                                       attributeListSize, parameterListSize );
            log.preConstraintCheckException( exception );
            throw exception;
        }
        int initialCapacity = Utilities.calcInitialCapacity( attributeListSize );
        initialParametersMri = new LinkedHashMap<Attribute, Object>( initialCapacity );
        finalParametersMri = new LinkedHashMap<Attribute, Object>( initialCapacity );
        for ( int i = 0, n = instanceCreatedParameters.size( ); i < n; i++ ) {
            Object parameterToSet = instanceCreatedParameters.get( i );
            Attribute attribute = nonDerivedInstanceAttributes.get( i );
            int attributeLowerBound = attribute.getMultiplicity( ).getLower( );
            int attributeUpperBound = attribute.getMultiplicity( ).getUpper( );
            Classifier classifier = getJmiHelper( ).getType( connection.getSession( ), attribute );
            if ( attributeUpperBound == MULTIPLICITY_BOUND_INFINITE || attributeUpperBound > 1 ) {
                // multi-valued attribute
                initialParametersMri.put( attribute, Collections.EMPTY_LIST );
            } else {
                // single-valued attribute
                if ( attributeLowerBound == 0 ) {
                    // optional
                    initialParametersMri.put( attribute, null );
                } else {
                    // required, the initial value of a required single-valued primitive attribute is its Java default
                    initialParametersMri.put( attribute, getJmiHelper( ).getJavaReturnInitialWrapperValueFromClassifier( connection, classifier ) );
                }
            }
            if ( parameterToSet == null ) {
                // no parameter to set
                // the initialization of required attributes with null IS possible
                // don't check underflows
//                int attributeLowerBound = attribute.getMultiplicity( ).getLower( );
//                if ( attributeLowerBound != 0 ) {
//                    InvalidCallException exception = new InvalidCallException( refClass, refClass.refMetaObject( ), "Can not set attribute \"" + attribute.getName( ) + "\" of class \"" + ( (MofClass) refClass.refMetaObject( ) ).getName( )
//                                                                                                                    + "\" with value \"null\". The attribute is required (the lower bound is \"" + attributeLowerBound + "\"). The value has to be not \"null\"." );
//                    log.preConstraintCheckException( exception );
//                    throw exception;
//                }
                finalParametersMri.put( attribute, null );
            } else {
                // check the parameter
                if ( attributeUpperBound == MULTIPLICITY_BOUND_INFINITE || attributeUpperBound > 1 ) {
                    // multi-valued attribute
                    boolean attributeOrderd = attribute.getMultiplicity( ).isOrdered( );
                    if ( attributeOrderd && !( parameterToSet instanceof List ) ) {
                        // parameterToSet is not of the type List
                        TypeMismatchException exception = new TypeMismatchException( List.class, parameterToSet, instanceCreatedRefClass.refMetaObject( ), MicroTransactionablesMessages.CANNOTSETATTRIBUTEWRONGTYPE, attribute.getName( ), instanceCreatedRefClass.refMetaObject( ).getName( ),
                                                                                     parameterToSet, parameterToSet.getClass( ).getCanonicalName( ), List.class, parameterToSet.getClass( ) );
                        log.preConstraintCheckException( exception );
                        throw exception;
                    } else if ( !attributeOrderd && !( parameterToSet instanceof Collection ) ) {
                        // parameterToSet is not of the type Collection
                        TypeMismatchException exception = new TypeMismatchException( Collection.class, parameterToSet, instanceCreatedRefClass.refMetaObject( ), MicroTransactionablesMessages.CANNOTSETATTRIBUTEWRONGTYPE, attribute.getName( ), instanceCreatedRefClass.refMetaObject( ).getName( ),
                                                                                     parameterToSet, parameterToSet.getClass( ).getCanonicalName( ), Collection.class, parameterToSet.getClass( ) );
                        log.preConstraintCheckException( exception );
                        throw exception;
                    }
                    if ( attribute.getMultiplicity( ).isUnique( ) ) {
                        // eliminate duplicates if the attribute is unique
                        eliminateDuplicates( (Collection) parameterToSet );
                    }
                    if ( attributeUpperBound != MULTIPLICITY_BOUND_INFINITE && ( (Collection) parameterToSet ).size( ) > attributeUpperBound ) {
                        // upper multiplicity violated
                        WrongSizeException exception = new WrongSizeException( attribute, MicroTransactionablesMessages.CANNOTSETATTRIBUTEBECAUSEUPPERMULTIPLICITY, attribute.getName( ), instanceCreatedRefClass.refMetaObject( ).getName( ), parameterToSet, parameterToSet.getClass( )
                            .getCanonicalName( ), attributeUpperBound, ( (Collection) parameterToSet ).size( ) );
                        log.preConstraintCheckException( exception );
                        throw exception;
                    }
                    List<Object> parameterMri = new ArrayList<Object>( ( (Collection) parameterToSet ).size( ) );
                    for ( Object parameterToSetElement : (Collection) parameterToSet ) {
                        // for multi-valued attributes check each parameter element for type compatibility
                        if ( parameterToSetElement == null ) {
                            // attribute is multi-valued, so initializing an element with a null value results in a MoinNullPointerException (JMI Spec, page 68)
                            MoinNullPointerException exception = new MoinNullPointerException( MicroTransactionablesMessages.CANNOTSETATTRIBUTE, attribute.getName( ), instanceCreatedRefClass.refMetaObject( ).getName( ), parameterToSet, parameterToSet.getClass( ).getCanonicalName( ) );
                            log.preConstraintCheckException( exception );
                            throw exception;
                        } else {
                            if ( !checkTypeCompatibility( classifier, parameterToSetElement ) ) {
                                TypeMismatchException exception = new TypeMismatchException( classifier.getClass( ), parameterToSetElement, instanceCreatedRefClass.refMetaObject( ), MicroTransactionablesMessages.CANNOTSETATTRIBUTEWRONGTYPE, attribute.getName( ), instanceCreatedRefClass
                                    .refMetaObject( ).getName( ), parameterToSet, parameterToSet.getClass( ).getCanonicalName( ), parameterToSetElement, parameterToSetElement.getClass( ) );
                                log.preConstraintCheckException( exception );
                                throw exception;
                            }
                        }
                        if ( classifier instanceof MofClass ) {
                            parameterMri.add( ( (Partitionable) parameterToSetElement ).get___Mri( ) );
                        } else {
                            parameterMri.add( parameterToSetElement );
                        }
                    }
                    finalParametersMri.put( attribute, parameterMri );
                } else {
                    // single-valued attribute
                    if ( !checkTypeCompatibility( classifier, parameterToSet ) ) {
                        TypeMismatchException exception = new TypeMismatchException( classifier.getClass( ), parameterToSet, instanceCreatedRefClass.refMetaObject( ), MicroTransactionablesMessages.CANNOTSETATTRIBUTEWRONGTYPE, attribute.getName( ),
                                                                                     instanceCreatedRefClass.refMetaObject( ).getName( ), parameterToSet, parameterToSet.getClass( ).getCanonicalName( ), classifier.getName( ), parameterToSet.getClass( ) );
                        log.preConstraintCheckException( exception );
                        throw exception;
                    }
                    if ( classifier instanceof MofClass ) {
                        finalParametersMri.put( attribute, ( (Partitionable) parameterToSet ).get___Mri( ) );
                    } else {
                        finalParametersMri.put( attribute, parameterToSet );
                    }
                }
            }
        }
        // null-out the before stored parameters to set, only their MRIs are stored
        instanceCreatedParameters = null;
    }

    @Override
    public void assertDoPostConstraints( ) throws JmiException {

        // multiplicity check is done in a phase before
//        RefObject instance = (RefObject) connection.getElement( instanceCreatedMri );
//        for ( Iterator<MRI> attributeMriIter = attributeListMri.iterator( ); attributeMriIter.hasNext( ); ) {
//            Attribute attribute = (Attribute) connection.getElement( attributeMriIter.next( ) );
//            int attributeUpperBound = attribute.getMultiplicity( ).getUpper( );
//            if ( attributeUpperBound > 1 ) {
//                Collection elements = (Collection) instance.refGetValue( attribute );
//                if ( elements.size( ) > attributeUpperBound ) {
//                    // upper multiplicity violated
//                    throw new WrongSizeException( attribute, "feature \"" + attribute.getName( ) + "\" of class \"" + ( (MofClass) instance.refMetaObject( ) ).getName( ) + "\" has an upper multiplicity of \"" + attributeUpperBound + "\", but it was tried to set " + elements.size( ) + " values." );
//                }
//            }
//        }
        // composition cycle and closure rule violation detection
        if ( linksAdded != null ) {
            for ( EndStorageLink linkAdded : linksAdded ) {
                assertCompositionCycle( linkAdded );
                assertCompositionClosure( linkAdded );
            }
        }

    }

    @Override
    public void computeDoActionsAndDoEvents( ) {

        computeDoActionsAndDoEvents( true );
    }

    @Override
    public void computeUndoActionsAndUndoEvents( ) {

        // link remove actions
        if ( linksAdded != null ) {
            for ( int i = 0; i < linksAdded.size( ); i++ ) {
                EndStorageLink linkAdded = linksAdded.get( i );
                int position = indices.get( i );
                if ( linkAdded.getMetaObject( ) instanceof Association ) {
                    List<AssociationEnd> ends = connection.getCoreJmiHelper( ).getAssociationEnds( connection.getSession( ), (Association) linkAdded.getMetaObject( ) );
                    getOrCreateDoActions( ).add( ActionFactory.createEndStorageLinkRemoveAction( connection, linkAdded.getStorageEnd( ).getMri( ), ends.get( linkAdded.getEndNumberOfOtherEnd( ) ).refMofId( ), linkAdded, position ) );
                } else {
                    getOrCreateDoActions( ).add( ActionFactory.createEndStorageLinkRemoveAction( connection, linkAdded.getStorageEnd( ).getMri( ), linkAdded.getMetaObject( ).refMofId( ), linkAdded, position ) );
                }
            }
        }
        // instance delete action
        getOrCreateUndoActions( ).add( ActionFactory.createInstanceDeleteAction( connection, instanceCreatedMri ) );
        // partition assign actions
        if ( elementsRepartitioned != null ) {
            for ( Entry<MRI, StateSet> entry : elementsRepartitioned.entrySet( ) ) {
                MRI elementRepartitionedMri = entry.getKey( );
                StateSet ss = entry.getValue( );
                PRI oldPartitionPri = (PRI) ss.getInitialState( ).get( StateSet.STATE_PARAMETER_PRI );
                PRI newPartitionPri = (PRI) ss.getFinalState( ).get( StateSet.STATE_PARAMETER_PRI );
                // can not use old MRI because it has changed after repartitioning
                MRI newMri = newPartitionPri.createMri( elementRepartitionedMri.getMofId( ) );
                getOrCreateUndoActions( ).add( ActionFactory.createPartitionableAssignPartitionAction( connection, newMri, newPartitionPri, oldPartitionPri ) );
            }
        }
        // partition clear dirty actions
        addClearDirtyActionsToUndoActions( );
        // release lock actions
        addReleaseLockActionsToUndoActions( );
        // element delete event
        if ( eventCreationNeeded( ) ) {
            getOrCreateUndoEvents( ).add( getEventFactory( ).createElementDeleteEvent( connection, (RefObject) getExistingElement( instanceCreatedMri ) ) );
        }
    }

    @Override
    public void computeRedoActionsAndRedoEvents( ) {

        resolve( );
        copyOnWrite( );
        computeDoActionsAndDoEvents( false );
    }

    @Override
    public void doFinished( ) {

        super.doFinished( );
        unresolve( );
    }

    private void computeDoActionsAndDoEvents( boolean doCase ) {

        PRI partitionOfInstancePri = this.partitionOfNewElement.getPri( );
        if ( doCase ) {

            copyOnWrite( );

            CoreModelPartition partitionOfInstance = this.partitionOfNewElement;
            // get a new MOF ID and MRI for the instance to create
            String mofIdOfInstance;
            if ( calculatedMofId != null ) {
                // we have to take the calculated MOF id from the input
                // parameters
                mofIdOfInstance = calculatedMofId;
                // COW: special handling for instance creation with calculated MOF id
                connection.setMriReferenceOfJmiWrapperToSessionWorkspace( partitionOfInstancePri.createMri( mofIdOfInstance ) );
            } else {
                // delegate the MOF id creation
                mofIdOfInstance = instanceCreatedWorkspace.createMofId( this.partitionOfNewElement );
            }
            // compute the MRI of the instance to create, the logical links to add, the affected partitions
            // and the elements to repartition MRI of the instance to create and the affected partition
            Set<PRI> affectedPartitionsPri = new HashSet<PRI>( );
            instanceCreatedMri = partitionOfInstancePri.createMri( mofIdOfInstance );
            affectedPartitionsPri.add( partitionOfInstancePri );
            // process the parameters
            if ( finalParametersMri != null ) {
                List<Attribute> attributes = getJmiHelper( ).getAttributes( connection.getSession( ), instanceCreatedRefClass.refMetaObject( ), true );
                for ( int i = 0; i < attributes.size( ); i++ ) {
                    Attribute attribute = attributes.get( i );
                    if ( attribute.isDerived( ) || attribute.getScope( ) == ScopeKindEnum.CLASSIFIER_LEVEL ) {
                        continue;
                    }
                    Object parameterToSetMri = finalParametersMri.get( attribute );
                    Classifier classifier = getJmiHelper( ).getType( connection.getSession( ), attribute );
                    int attributeUpperBound = attribute.getMultiplicity( ).getUpper( );
                    if ( parameterToSetMri != null ) {
                        if ( attributeUpperBound == MULTIPLICITY_BOUND_INFINITE || attributeUpperBound > 1 ) {
                            // multi-valued attribute
                            if ( classifier instanceof MofClass ) {
                                // class attribute
                                int indexToAdd = 0;
                                for ( Object parameterToSetMriElement : (Collection) parameterToSetMri ) {
                                    CorePartitionable parameterToSetElement = getExistingElement( (MRI) parameterToSetMriElement );
                                    // logical link to add and affected partitions
                                    EndStorageLink linkToAdd = getLogicalLinkManager( ).createLinkForAttribute( connection.getSession( ), instanceCreatedWorkspace, instanceCreatedMri, parameterToSetElement, attribute );
                                    assertNoCompositeLinkToMetamodelIfStorageAtParent( linkToAdd );
                                    if ( linksAdded == null ) {
                                        linksAdded = new ArrayList<EndStorageLink>( 5 );
                                        indices = new ArrayList<Integer>( 5 );
                                    }
                                    linksAdded.add( linkToAdd );
                                    indices.add( indexToAdd );
                                    affectedPartitionsPri.add( linkToAdd.getStorageEndMri( ).getPri( ) );
                                    // elements to repartition and affected partitions
                                    List<CorePartitionable> elementsToRepartitionForLogicalLinkAddition = getElementsToRepartitionAfterLinkAdd( attribute, 0, parameterToSetElement, partitionOfInstance );
                                    if ( elementsRepartitioned == null && !elementsToRepartitionForLogicalLinkAddition.isEmpty( ) ) {
                                        elementsRepartitioned = new HashMap<MRI, StateSet>( 4 );
                                    }
                                    for ( CorePartitionable partitionable : elementsToRepartitionForLogicalLinkAddition ) {
                                        Map<String, Object> initialState = StateSet.createState( StateSet.STATE_PARAMETER_PRI, partitionable.get___Partition( ).getPri( ) );
                                        Map<String, Object> finalState = StateSet.createState( StateSet.STATE_PARAMETER_PRI, partitionOfInstance.getPri( ) );
                                        elementsRepartitioned.put( partitionable.get___Mri( ), new StateSet( initialState, finalState ) );
                                        affectedPartitionsPri.add( partitionable.get___Partition( ).getPri( ) );
                                    }
                                    indexToAdd++;
                                }
                            }
                        } else {
                            // single-valued attribute
                            if ( classifier instanceof MofClass ) {
                                // class attribute
                                CorePartitionable parameterToSet = getExistingElement( (MRI) parameterToSetMri );
                                // logical link to add and affected partitions
                                EndStorageLink linkToAdd = getLogicalLinkManager( ).createLinkForAttribute( connection.getSession( ), instanceCreatedWorkspace, instanceCreatedMri, parameterToSet, attribute );
                                assertNoCompositeLinkToMetamodelIfStorageAtParent( linkToAdd );
                                if ( linksAdded == null ) {
                                    linksAdded = new ArrayList<EndStorageLink>( 5 );
                                    indices = new ArrayList<Integer>( 5 );
                                }
                                linksAdded.add( linkToAdd );
                                indices.add( -1 );
                                affectedPartitionsPri.add( linkToAdd.getStorageEndMri( ).getPri( ) );
                                // elements to repartition and affected partitions
                                List<CorePartitionable> elementsToRepartitionForLogicalLinkAddition = getElementsToRepartitionAfterLinkAdd( attribute, 0, parameterToSet, partitionOfInstance );
                                if ( elementsRepartitioned == null && !elementsToRepartitionForLogicalLinkAddition.isEmpty( ) ) {
                                    elementsRepartitioned = new HashMap<MRI, StateSet>( 4 );
                                }
                                for ( CorePartitionable partitionable : elementsToRepartitionForLogicalLinkAddition ) {
                                    Map<String, Object> initialState = StateSet.createState( StateSet.STATE_PARAMETER_PRI, partitionable.get___Partition( ).getPri( ) );
                                    Map<String, Object> finalState = StateSet.createState( StateSet.STATE_PARAMETER_PRI, partitionOfInstance.getPri( ) );
                                    elementsRepartitioned.put( partitionable.get___Mri( ), new StateSet( initialState, finalState ) );
                                    affectedPartitionsPri.add( partitionable.get___Partition( ).getPri( ) );
                                }
                            }
                        }
                    }
                }
            }
            PRI[] affectedPartitionPris = affectedPartitionsPri.toArray( new PRI[affectedPartitionsPri.size( )] );
            computePartitionsToLock( affectedPartitionPris );
            computePartitionsToEnsureEditing( affectedPartitionPris );
            computePartitionsToMarkDirty( affectedPartitionPris );
        }
        // actions and events

        // aquire lock actions
        addEditLockActionsToDoActions( );
        // ensure editing allowed actions
        addEnsureEditingActionsToDoActions( );
        // instance create action
        getOrCreateDoActions( ).add( ActionFactory.createInstanceCreateAction( connection, instanceCreatedRefClassMri, instanceCreatedMri, partitionOfInstancePri, instanceCreatedWorkspace ) );
        // data type attribute change actions
        if ( finalParametersMri != null ) {
            // we need the complete feature list to get the correct id, i.e. index, of the attribute
            List<StructuralFeature> features = getJmiHelper( ).getStructuralFeatures( connection.getSession( ), instanceCreatedRefClass.refMetaObject( ), true );
            int featureId = -1;
            for ( int i = 0; i < features.size( ); i++ ) {
                StructuralFeature feature = features.get( i );
                featureId++;
                if ( feature instanceof Attribute ) {
                    Attribute attribute = (Attribute) feature;
                    if ( attribute.isDerived( ) || getJmiHelper( ).getType( connection.getSession( ), attribute ) instanceof MofClass ) {
                        continue;
                    }
                    if ( attribute.getScope( ) == ScopeKindEnum.CLASSIFIER_LEVEL ) {
                        featureId--;
                        continue;
                    }
                    Object initialParameter = initialParametersMri.get( attribute );
                    Object finalParameter = finalParametersMri.get( attribute );
                    if ( finalParameter != null ) {
                        getOrCreateDoActions( ).add( ActionFactory.createDataTypeAttributeChangeAction( connection, instanceCreatedMri, attribute.getName( ), featureId, initialParameter, finalParameter ) );
                    } else {
                        int attributeLowerBound = attribute.getMultiplicity( ).getLower( );
                        int attributeUpperBound = attribute.getMultiplicity( ).getUpper( );
                        if ( attributeUpperBound == MULTIPLICITY_BOUND_INFINITE || attributeUpperBound > 1 ) {
                            // multi-valued attribute, no action
                            // we currently host multi-valued primitive attributes in the generated class and
                            // ensure that an empty Collection or List is returned if these attributes are null
                        } else {
                            // single-valued attribute
                            if ( ( attributeLowerBound == 1 ) && ( attributeUpperBound == 1 ) ) {
                                // required, no action
                                // we currently host required single-valued primitive attributes in the generated class
                                // as Java primitives with their Java default value
                            } else {
                                // optional
                                getOrCreateDoActions( ).add( ActionFactory.createDataTypeAttributeChangeAction( connection, instanceCreatedMri, attribute.getName( ), featureId, initialParameter, finalParameter ) );
                            }
                        }
                    }
                }
            }
        }
        // link add actions
        if ( linksAdded != null ) {
            for ( int i = 0; i < linksAdded.size( ); i++ ) {
                EndStorageLink linkToAdd = linksAdded.get( i );
                int position = indices.get( i );
                if ( linkToAdd.getMetaObject( ) instanceof Association ) {
                    List<AssociationEnd> ends = connection.getCoreJmiHelper( ).getAssociationEnds( connection.getSession( ), (Association) linkToAdd.getMetaObject( ) );
                    getOrCreateDoActions( ).add( ActionFactory.createEndStorageLinkAddAction( connection, linkToAdd.getStorageEnd( ).getMri( ), ends.get( linkToAdd.getEndNumberOfOtherEnd( ) ).refMofId( ), linkToAdd, position ) );
                } else {
                    getOrCreateDoActions( ).add( ActionFactory.createEndStorageLinkAddAction( connection, linkToAdd.getStorageEnd( ).getMri( ), linkToAdd.getMetaObject( ).refMofId( ), linkToAdd, position ) );
                }
            }
        }
        // partition assign actions, not necessary for the just created instance (this is done in the instance manager), ugly but...
        if ( elementsRepartitioned != null ) {
            for ( Entry<MRI, StateSet> entry : elementsRepartitioned.entrySet( ) ) {
                StateSet ss = entry.getValue( );
                PRI oldPartitionPri = (PRI) ss.getInitialState( ).get( StateSet.STATE_PARAMETER_PRI );
                PRI newPartitionPri = (PRI) ss.getFinalState( ).get( StateSet.STATE_PARAMETER_PRI );
                getOrCreateDoActions( ).add( ActionFactory.createPartitionableAssignPartitionAction( connection, entry.getKey( ), oldPartitionPri, newPartitionPri ) );
            }
        }
        // partition mark dirty actions
        addMarkDirtyActionsToDoActions( );
        // element create event
        // resolve the parameters and bring them in the right order
        if ( eventCreationNeeded( ) ) {
            getOrCreateDoEvents( ).add( getEventFactory( ).createElementCreateEvent( connection, instanceCreatedMri, ( (CorePartitionable) instanceCreatedRefClass.refMetaObject( ) ).get___Mri( ), ( (CorePartitionable) instanceCreatedRefClass.refImmediatePackage( ) ).get___Mri( ) ) );
        }
    }

    private void copyOnWrite( ) {

        if ( partitionOfNewElement.getWorkspace( ) == connection.getSession( ).getCompoundClientSpecWorkspace( ) ) {
            createPrivateCopy( partitionOfNewElement.getPri( ) );
            resolve( );
        }
    }

    private void resolve( ) {

        instanceCreatedRefClass = (RefClass) getExistingElement( instanceCreatedRefClassMri );
        partitionOfNewElement = connection.getPartition( priOfNewElement );
    }

    private void unresolve( ) {

        instanceCreatedRefClass = null;
        partitionOfNewElement = null;
    }

    public RefObject getInstanceCreated( ) {

        return (RefObject) getExistingElement( instanceCreatedMri );
    }
}
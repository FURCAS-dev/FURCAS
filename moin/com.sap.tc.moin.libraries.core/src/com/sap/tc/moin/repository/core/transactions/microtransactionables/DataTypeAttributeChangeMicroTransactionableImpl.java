package com.sap.tc.moin.repository.core.transactions.microtransactionables;

import static com.sap.tc.moin.repository.JmiHelper.MULTIPLICITY_BOUND_INFINITE;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.PartitionEditingNotPossibleException;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.transactions.actions.ActionFactory;
import com.sap.tc.moin.repository.messages.core.RepositoryCoreMessages;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.reflect.InvalidCallException;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.TypeMismatchException;
import com.sap.tc.moin.repository.transactions.microtransactionables.DataTypeAttributeChangeMicroTransactionable;

public class DataTypeAttributeChangeMicroTransactionableImpl extends AbstractMicroTransactionable implements DataTypeAttributeChangeMicroTransactionable {

    private RefFeatured featured = null;

    private MRI featuredMri = null;

    private Attribute attribute = null;

    private int attributeId = -1;

    private Object oldValue = null;

    private Object newValue = null;

    /**
     * Creates a Micro Transactionable that changes a single-valued attribute
     * whose classifier is a data type
     */
    public DataTypeAttributeChangeMicroTransactionableImpl( CoreConnection aConnection, RefFeatured aFeatured, Attribute anAttribute, int anAttributeId, Object anOldValue, Object aNewValue ) {

        super( aConnection );
        featured = aFeatured;
        featuredMri = ( (CorePartitionable) featured ).get___Mri( );
        attribute = anAttribute;
        attributeId = anAttributeId;
        oldValue = anOldValue;
        newValue = aNewValue;
    }

    @Override
    public void assertDoPreConstraints( ) throws JmiException {

        if ( ( (Partitionable) featured ).get___Partition( ).getPri( ).isMetaModelPartition( ) ) {
            triggerRollback( new PartitionEditingNotPossibleException( RepositoryCoreMessages.MMPARTITIONCANNOTBECHANGED, ( (Partitionable) featured ).get___Partition( ).getPri( ) ) );
        }

        int attributeLowerBound = attribute.getMultiplicity( ).getLower( );
        int attributeUpperBound = attribute.getMultiplicity( ).getUpper( );
        Classifier classifier = getJmiHelper( ).getType( connection.getSession( ), attribute );
        if ( attributeUpperBound == MULTIPLICITY_BOUND_INFINITE || attributeUpperBound > 1 ) {
            // attribute is multi-valued, so setting the value as a whole
            // results in an InvalidCallException (JMI Spec, page 83)
            InvalidCallException exception = new InvalidCallException( newValue, attribute, MicroTransactionablesMessages.MULTIVALUEDATTRIBUTESNOTSETASWHOLE, attribute.getName( ), ( (MofClass) featured.refMetaObject( ) ).getName( ) );
            log.preConstraintCheckException( exception );
            throw exception;
        }
        if ( newValue != null ) {
            if ( !checkTypeCompatibility( classifier, newValue ) ) {
                // newValue is not of the correct attribute type
                TypeMismatchException exception = new TypeMismatchException( classifier.getClass( ), newValue, featured.refMetaObject( ), MicroTransactionablesMessages.FEATUREWRONGTYPE, attribute.getName( ), ( (MofClass) featured.refMetaObject( ) ).getName( ), classifier.getName( ), newValue
                    .getClass( ) );
                log.preConstraintCheckException( exception );
                throw exception;
            }
        }
        if ( ( newValue == null ) && ( attributeLowerBound == 1 ) && ( attributeUpperBound == 1 ) && ( classifier instanceof PrimitiveType ) ) {
            // we currently host required single-valued primitive attributes in
            // the generated class as Java primitives
            // and get a null pointer in the generated set___Value method
            // because value is null at code pieces like
            // "set__AttributeBoolean(((java.lang.Boolean)value).booleanValue());"
            // so, we correct the value here to a default one
            newValue = getJmiHelper( ).getJavaReturnInitialWrapperValueFromClassifier( connection, classifier );
        }
    }

    @Override
    public void computeDoActionsAndDoEvents( ) {

        computeDoActionsAndDoEvents( true );
    }

    @Override
    public void computeUndoActionsAndUndoEvents( ) {

        resolve( );
        // attribute change action
        getOrCreateUndoActions( ).add( ActionFactory.createDataTypeAttributeChangeAction( connection, featuredMri, attribute.getName( ), attributeId, newValue, oldValue ) );
        // partition clear dirty actions
        addClearDirtyActionsToUndoActions( );
        // release lock actions
        addReleaseLockActionsToUndoActions( );
        // events
        if ( eventCreationNeeded( ) ) {
            getOrCreateUndoEvents( ).add( getEventFactory( ).createAttributeValueChangeEvent( connection, featured, attribute, newValue, oldValue ) );
        }
    }

    @Override
    public boolean eventCreationNeeded() {
	boolean valueUnchanged = oldValue != null && oldValue.equals(newValue) || oldValue == null && newValue == null;
	return !valueUnchanged && super.eventCreationNeeded();
    }

    @Override
    public void computeRedoActionsAndRedoEvents( ) {

        resolve( );
        computeDoActionsAndDoEvents( false );
    }

    @Override
    public void doFinished( ) {

        super.doFinished( );
        unresolve( );
    }

    @Override
    public void undoFinished( ) {

        super.undoFinished( );
        unresolve( );
    }

    private void computeDoActionsAndDoEvents( boolean doCase ) {

        if ( doCase ) {
            PRI affectedPartitionPri = ( (CorePartitionable) featured ).get___Partition( ).getPri( );
            computePartitionsToLock( affectedPartitionPri );
            computePartitionsToEnsureEditing( affectedPartitionPri );
            computePartitionsToMarkDirty( affectedPartitionPri );
        }
        // actions and events
        // aquire locks
        addEditLockActionsToDoActions( );
        // ensure editing allowed
        addEnsureEditingActionsToDoActions( );
        // attribute change action
        getOrCreateDoActions( ).add( ActionFactory.createDataTypeAttributeChangeAction( connection, featuredMri, attribute.getName( ), attributeId, oldValue, newValue ) );
        // set the dirty state
        addMarkDirtyActionsToDoActions( );
        // adjust state of micro transactionable and action for copy-on-write
        copyOnWrite( );
        // events
        if ( eventCreationNeeded( ) ) {
            getOrCreateDoEvents( ).add( getEventFactory( ).createAttributeValueChangeEvent( connection, featured, attribute, oldValue, newValue ) );
        }
    }
    
    private void copyOnWrite( ) {

        CorePartitionable element = (CorePartitionable) featured;
        if ( element.get___Workspace( ) == connection.getSession( ).getCompoundClientSpecWorkspace( ) ) {
            createPrivateCopy( element.get___Partition( ).getPri( ) );
            resolve( );
        }
    }

    private void resolve( ) {

        featured = (RefFeatured) getExistingElement( featuredMri );
    }

    private void unresolve( ) {

        featured = null;
    }
}

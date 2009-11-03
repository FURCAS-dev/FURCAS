package com.sap.tc.moin.repository.core.transactions.microtransactionables;

import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.__impl.TypedElementInternal;
import com.sap.tc.moin.repository.mmi.reflect.DuplicateException;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.TypeMismatchException;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.jmi.reflect.RefFeaturedImpl;
import com.sap.tc.moin.repository.core.transactions.actions.ActionFactory;
import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.transactions.microtransactionables.DataTypeAttributeSetElementMicroTransactionable;

@SuppressWarnings( "unchecked" )
public class DataTypeAttributeSetElementMicroTransactionableImpl extends AbstractMicroTransactionable implements DataTypeAttributeSetElementMicroTransactionable {

    private RefFeatured featured = null;

    private MRI featuredMri = null;

    private Attribute attribute = null;

    private int index = -1;

    private Object oldValue = null;

    private Object newValue = null;

    /**
     * Creates a Micro Transactionable that sets the element at position
     * <code>index</code> of a multi-valued attribute whose classifier is a data
     * type
     */
    public DataTypeAttributeSetElementMicroTransactionableImpl( CoreConnection aConnection, RefFeatured aFeatured, Attribute anAttribute, int anIndex, Object aNewValue ) {

        super( aConnection );
        featured = aFeatured;
        featuredMri = ( (CorePartitionable) aFeatured ).get___Mri( );
        attribute = anAttribute;
        index = anIndex;
        oldValue = ( (List) ( (RefFeaturedImpl) aFeatured ).refGetValue( aConnection, anAttribute ) ).get( index );
        newValue = aNewValue;
    }

    @Override
    public void assertDoPreConstraints( ) throws JmiException, MoinNullPointerException {

        if ( newValue == null ) {
            // attribute is multi-valued, so setting a value to null results in
            // a MoinNullPointerException (JMI Spec, page 68)
            MoinNullPointerException exception = new MoinNullPointerException( MicroTransactionablesMessages.FEATUREOFCLASSISMULTIVALUEDNOSET, attribute.getName( ), ( (MofClass) featured.refMetaObject( ) ).getName( ) );
            log.preConstraintCheckException( exception );
            throw exception;
        }
        if ( !checkTypeCompatibility( ( (TypedElementInternal) attribute ).getType( this.connection ), newValue ) ) {
            // newValue is not of the correct attribute type (JMI Spec, page 68)
            TypeMismatchException exception = new TypeMismatchException( ( (TypedElementInternal) attribute ).getType( this.connection ).getClass( ), newValue, featured.refMetaObject( ), MicroTransactionablesMessages.FEATUREWRONGTYPE, attribute.getName( ), ( (MofClass) featured.refMetaObject( ) )
                .getName( ), ( (TypedElementInternal) attribute ).getType( this.connection ).getName( ), newValue.getClass( ) );
            log.preConstraintCheckException( exception );
            throw exception;
        }
        Collection elements = (Collection) ( (RefFeaturedImpl) featured ).refGetValue( connection, attribute );
        if ( attribute.getMultiplicity( ).isUnique( ) && elements.contains( newValue ) ) {
            DuplicateException exception = new DuplicateException( newValue, featured.refMetaObject( ), MicroTransactionablesMessages.FEATUREISUNIQUE, attribute.getName( ), ( (MofClass) featured.refMetaObject( ) ).getName( ) );
            log.preConstraintCheckException( exception );
            throw exception;
        }
    }

    @Override
    public void computeDoActionsAndDoEvents( ) {

        computeDoActionsAndDoEvents( true );
    }

    @Override
    public void computeUndoActionsAndUndoEvents( ) {

        resolve( );
        // element change action
        getOrCreateUndoActions( ).add( ActionFactory.createDataTypeAttributeChangeElementAction( connection, featuredMri, attribute.getName( ), index, newValue, oldValue ) );
        // partition clear dirty actions
        addClearDirtyActionsToUndoActions( );
        // release lock actions
        addReleaseLockActionsToUndoActions( );
        // events
        if ( eventCreationNeeded( ) ) {
            getOrCreateUndoEvents( ).add( getEventFactory( ).createAttributeValueRemoveEvent( connection, featured, attribute, newValue, index ) );
            getOrCreateUndoEvents( ).add( getEventFactory( ).createAttributeValueAddEvent( connection, featured, attribute, oldValue, index ) );
        }
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

        copyOnWrite( );

        // element change action
        getOrCreateDoActions( ).add( ActionFactory.createDataTypeAttributeChangeElementAction( connection, featuredMri, attribute.getName( ), index, oldValue, newValue ) );
        // set the dirty state
        addMarkDirtyActionsToDoActions( );
        // events
        if ( eventCreationNeeded( ) ) {
            getOrCreateDoEvents( ).add( getEventFactory( ).createAttributeValueRemoveEvent( connection, featured, attribute, oldValue, index ) );
            getOrCreateDoEvents( ).add( getEventFactory( ).createAttributeValueAddEvent( connection, featured, attribute, newValue, index ) );
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

package com.sap.tc.moin.repository.core.transactions.microtransactionables;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.__impl.TypedElementInternal;
import com.sap.tc.moin.repository.mmi.reflect.DuplicateException;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.TypeMismatchException;
import com.sap.tc.moin.repository.mmi.reflect.WrongSizeException;

import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.jmi.reflect.RefFeaturedImpl;
import com.sap.tc.moin.repository.core.transactions.actions.ActionFactory;
import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.shared.util.IndexedElement;
import com.sap.tc.moin.repository.transactions.microtransactionables.DataTypeAttributeAddElementMicroTransactionable;

public class DataTypeAttributeAddElementMicroTransactionableImpl extends AbstractMicroTransactionable implements DataTypeAttributeAddElementMicroTransactionable {

    private boolean attributeChanged = false;

    private RefFeatured featured = null;

    private MRI featuredMri = null;

    private Attribute attribute = null;

    private int index = -1;

    private List<Object> elementsToAdd = null;

    private List<IndexedElement<Object>> elementsAdded = null;

    /**
     * Creates a Micro Transactionable that adds elements to a multi-valued
     * attribute whose classifier is a data type
     */
    @SuppressWarnings( "unchecked" )
    public DataTypeAttributeAddElementMicroTransactionableImpl( CoreConnection aConnection, RefFeatured aFeatured, Attribute anAttribute, Collection theElementsToAdd ) {

        this( aConnection, aFeatured, anAttribute, -1, theElementsToAdd );
    }

    /**
     * Creates a Micro Transactionable that adds elements at position
     * <code>anIndex</code> to a multi-valued attribute whose classifier is a
     * data type
     */
    @SuppressWarnings( "unchecked" )
    public DataTypeAttributeAddElementMicroTransactionableImpl( CoreConnection aConnection, RefFeatured aFeatured, Attribute anAttribute, int anIndex, Collection theElementsToAdd ) {

        super( aConnection );
        featured = aFeatured;
        featuredMri = ( (CorePartitionable) aFeatured ).get___Mri( );
        attribute = anAttribute;
        index = anIndex;
        if ( theElementsToAdd != null ) {
            elementsToAdd = new ArrayList( theElementsToAdd );
            if ( anAttribute.getMultiplicity( ).isUnique( ) ) {
                // eliminate duplicates if the attribute is unique
                eliminateDuplicates( elementsToAdd );
            }
        }
    }

    @Override
    @SuppressWarnings( "unchecked" )
    public void assertDoPreConstraints( ) throws JmiException {

        Collection elements = (Collection) ( (RefFeaturedImpl) featured ).refGetValue( connection, attribute );
        if ( elementsToAdd != null ) {
            for ( int i = 0; i < elementsToAdd.size( ); i++ ) {
                Object elementToAdd = elementsToAdd.get( i );
                if ( elementToAdd == null ) {
                    // attribute is multi-valued, so adding a null value results in a MoinNullPointerException (JMI Spec, page 68)
                    MoinNullPointerException exception = new MoinNullPointerException( MicroTransactionablesMessages.FEATUREOFCLASSISMULTIVALUEDNOADD, attribute.getName( ), ( (MofClass) featured.refMetaObject( ) ).getName( ) );
                    log.preConstraintCheckException( exception );
                    throw exception;
                }
                if ( !checkTypeCompatibility( ( (TypedElementInternal) attribute ).getType( this.connection ), elementToAdd ) ) {
                    // elementToAdd is not of the correct attribute type (JMI Spec, page 68)
                    TypeMismatchException exception = new TypeMismatchException( ( (TypedElementInternal) attribute ).getType( this.connection ).getClass( ), elementToAdd, featured.refMetaObject( ), MicroTransactionablesMessages.FEATUREWRONGTYPE, attribute.getName( ), ( (MofClass) featured
                        .refMetaObject( ) ).getName( ), ( (TypedElementInternal) attribute ).getType( this.connection ).getName( ), elementToAdd.getClass( ) );
                    log.preConstraintCheckException( exception );
                    throw exception;
                }
                if ( attribute.getMultiplicity( ).isUnique( ) && elements.contains( elementToAdd ) ) {
                    DuplicateException exception = new DuplicateException( elementToAdd, featured.refMetaObject( ), MicroTransactionablesMessages.FEATUREISUNIQUE, attribute.getName( ), ( (MofClass) featured.refMetaObject( ) ).getName( ) );
                    log.preConstraintCheckException( exception );
                    throw exception;
                }
            }
        }
    }

    @Override
    @SuppressWarnings( "unchecked" )
    public void assertDoPostConstraints( ) throws JmiException {

        int attributeUpperBound = attribute.getMultiplicity( ).getUpper( );
        Collection elements = (Collection) ( (RefFeaturedImpl) featured ).refGetValue( connection, attribute );
        if ( attributeUpperBound != JmiHelper.MULTIPLICITY_BOUND_INFINITE && elements.size( ) > attributeUpperBound ) {
            // upper multiplicity violated
            WrongSizeException exception = new WrongSizeException( attribute, MicroTransactionablesMessages.FEATUREHASUPPERMULTIPLICITY, attribute.getName( ), ( (MofClass) featured.refMetaObject( ) ).getName( ), attributeUpperBound );
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

        if ( elementsAdded != null ) {
            resolve( );
            // element remove actions
            // reverse the added elements to ensures that the elements are
            // removed
            // from above to below
            for ( int i = elementsAdded.size( ) - 1; i >= 0; i-- ) {
                IndexedElement<Object> elementAdded = elementsAdded.get( i );
                getOrCreateUndoActions( ).add( ActionFactory.createDataTypeAttributeRemoveElementAction( connection, featuredMri, attribute.getName( ), elementAdded.index, elementAdded.element ) );
            }
            // partition clear dirty actions
            addClearDirtyActionsToUndoActions( );
            // release lock actions
            addReleaseLockActionsToUndoActions( );
            // events
            if ( eventCreationNeeded( ) ) {
                for ( int i = 0; i < elementsAdded.size( ); i++ ) {
                    IndexedElement<Object> elementAdded = elementsAdded.get( i );
                    getOrCreateUndoEvents( ).add( getEventFactory( ).createAttributeValueRemoveEvent( connection, featured, attribute, elementAdded.element, elementAdded.index ) );
                }
            }
            attributeChanged = false;
        }
    }

    @Override
    public void computeRedoActionsAndRedoEvents( ) {

        boolean doCase = false;
        copyOnWrite( doCase );
        computeDoActionsAndDoEvents( doCase );
    }

    @Override
    public void doFinished( ) {

        super.doFinished( );
        elementsToAdd = null;
        unresolve( );
    }

    @Override
    public void undoFinished( ) {

        super.undoFinished( );
        unresolve( );
    }

    @SuppressWarnings( "unchecked" )
    private void computeDoActionsAndDoEvents( boolean doCase ) {

        if ( doCase ) {
            if ( elementsToAdd != null ) {
                copyOnWrite( doCase );
                boolean isOrdered = attribute.getMultiplicity( ).isOrdered( );
                int indexToAdd = ( index == -1 && isOrdered ) ? ( (List) ( (RefFeaturedImpl) featured ).refGetValue( this.connection, attribute.getName( ) ) ).size( ) : index;
                // pre calculation of the effective remove list
                elementsAdded = new ArrayList<IndexedElement<Object>>( elementsToAdd.size( ) );
                for ( int i = 0; i < elementsToAdd.size( ); i++ ) {
                    Object elementToAdd = elementsToAdd.get( i );
                    IndexedElement<Object> indexedElement = new IndexedElement<Object>( indexToAdd, elementToAdd );
                    elementsAdded.add( indexedElement );
                    indexToAdd = indexToAdd != -1 ? indexToAdd + 1 : -1;
                }
                PRI affectedPartitionPri = ( (CorePartitionable) featured ).get___Partition( ).getPri( );
                computePartitionsToLock( affectedPartitionPri );
                computePartitionsToEnsureEditing( affectedPartitionPri );
                computePartitionsToMarkDirty( affectedPartitionPri );
            }
        }
        if ( elementsAdded != null ) {
            // actions and events
            // aquire locks
            addEditLockActionsToDoActions( );
            // ensure editing allowed
            addEnsureEditingActionsToDoActions( );

            // element add actions and events
            for ( int i = 0; i < elementsAdded.size( ); i++ ) {
                IndexedElement<Object> elementAdded = elementsAdded.get( i );
                // attribute add action
                getOrCreateDoActions( ).add( ActionFactory.createDataTypeAttributeAddElementAction( connection, featuredMri, attribute.getName( ), elementAdded.index, elementAdded.element ) );
                attributeChanged = true;
                // events
                if ( eventCreationNeeded( ) ) {
                    int eventIndex = elementAdded.index == -1 ? -1 : elementAdded.index;
                    getOrCreateDoEvents( ).add( getEventFactory( ).createAttributeValueAddEvent( connection, featured, attribute, elementAdded.element, eventIndex ) );
                }
            }
            // set the dirty state
            addMarkDirtyActionsToDoActions( );
        }
    }

    private void copyOnWrite( boolean doCase ) {

        CorePartitionable element = (CorePartitionable) featured;
        if ( doCase ) {
            if ( element.get___Workspace( ) == connection.getSession( ).getCompoundClientSpecWorkspace( ) ) {
                PRI affectedPri = element.get___Partition( ).getPri( );
                createPrivateCopy( affectedPri );
                resolve( );
            }
        } else {//redo
            List<PRI> affectedPartitionsForRedo = getAffectedPartitionsForCopyOnWriteRedo( );
            if ( affectedPartitionsForRedo.size( ) > 0 ) {
                createPrivateCopy( affectedPartitionsForRedo.get( 0 ) );
            }
            resolve( ); //we have to resolve anyway on redo, as volatile partitions are not part of the affected partitions for redo
        }
    }

    private void resolve( ) {

        featured = (RefFeatured) getExistingElement( featuredMri );
    }

    private void unresolve( ) {

        featured = null;
    }

    public boolean attributeChanged( ) {

        return attributeChanged;
    }
}
package com.sap.tc.moin.repository.core.transactions.microtransactionables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.__impl.AttributeInternal;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.TypeMismatchException;
import com.sap.tc.moin.repository.mmi.reflect.WrongSizeException;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.jmi.reflect.RefFeaturedImpl;
import com.sap.tc.moin.repository.core.transactions.actions.ActionFactory;
import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.shared.util.IndexedElement;
import com.sap.tc.moin.repository.transactions.microtransactionables.DataTypeAttributeRemoveElementMicroTransactionable;

@SuppressWarnings( "unchecked" )
public class DataTypeAttributeRemoveElementMicroTransactionableImpl extends AbstractMicroTransactionable implements DataTypeAttributeRemoveElementMicroTransactionable {

    private boolean attributeChanged = false;

    private RefFeatured featured = null;

    private MRI featuredMri = null;

    private AttributeInternal attribute = null;

    private int index = -1;

    private boolean removeAllOccurrences = false;

    private List<Object> elementsToRemove = null;

    private ArrayList<IndexedElement<Object>> elementsRemoved = null;

    /**
     * Creates a Micro Transactionable that removes elements from a multi-valued
     * attribute whose classifier is a data type
     */
    public DataTypeAttributeRemoveElementMicroTransactionableImpl( CoreConnection aConnection, RefFeatured aFeatured, Attribute anAttribute, Collection theElementsToRemove, boolean isRemoveAllOccurrences ) {

        this( aConnection, aFeatured, anAttribute );
        if ( theElementsToRemove != null ) {
            elementsToRemove = new ArrayList( theElementsToRemove );
            // eliminate duplicates
            // one element is enough in order to remove all its occurrences in a
            // collection
            eliminateDuplicates( elementsToRemove );
        }
        removeAllOccurrences = isRemoveAllOccurrences;
    }

    /**
     * Creates a Micro Transactionable that removes the element at position
     * <code>index</code> from a multi-valued attribute whose classifier is a
     * data type
     */
    public DataTypeAttributeRemoveElementMicroTransactionableImpl( CoreConnection aConnection, RefFeatured aFeatured, Attribute anAttribute, int anIndex ) {

        this( aConnection, aFeatured, anAttribute );
        index = anIndex;
    }

    private DataTypeAttributeRemoveElementMicroTransactionableImpl( CoreConnection aConnection, RefFeatured aFeatured, Attribute anAttribute ) {

        super( aConnection );
        featured = aFeatured;
        featuredMri = ( (CorePartitionable) aFeatured ).get___Mri( );
        attribute = (AttributeInternal) anAttribute;
    }

    @Override
    public void assertDoPreConstraints( ) throws JmiException, MoinNullPointerException {

        if ( index != -1 ) {
            // ok, we want to remove an element specified by an index
            List elements = (List) ( (RefFeaturedImpl) featured ).refGetValue( connection, attribute );
            if ( index > elements.size( ) ) {
                throw new WrongSizeException( attribute, MicroTransactionablesMessages.INDEXISBIGGERTHANNUMBEROFELEMENTS, index, attribute.getName( ), ( (MofClass) featured.refMetaObject( ) ).getName( ), elements.size( ) );
            }
            if ( elementsToRemove == null ) {
                elementsToRemove = new ArrayList( 1 );
            }
            elementsToRemove.add( elements.get( index ) );
        } else {
            // ok, we want to remove the elements specified
            if ( elementsToRemove != null ) {
                for ( int i = 0; i < elementsToRemove.size( ); i++ ) {
                    Object elementToRemove = elementsToRemove.get( i );
                    if ( elementToRemove == null ) {
                        // attribute is multi-valued, so it can not contain null values (JMI Spec, page 68),
                        // a MoinNullPointerException has to be thrown (see JavaDoc of Collection.remove(Object))
                        MoinNullPointerException exception = new MoinNullPointerException( MicroTransactionablesMessages.FEATUREOFCLASSISMULTIVALUEDNOREMOVE, attribute.getName( ), ( (MofClass) featured.refMetaObject( ) ).getName( ) );
                        log.preConstraintCheckException( exception );
                        throw exception;
                    }
                    if ( !checkTypeCompatibility( attribute.getType( connection ), elementToRemove ) ) {
                        // elementToRemove is not of the correct attribute type (JMI Spec, page 68)
                        TypeMismatchException exception = new TypeMismatchException( attribute.getType( connection ).getClass( ), elementToRemove, featured.refMetaObject( ), MicroTransactionablesMessages.FEATUREWRONGTYPE, attribute.getName( ), ( (MofClass) featured.refMetaObject( ) ).getName( ),
                                                                                     attribute.getType( connection ).getName( ), elementToRemove.getClass( ) );
                        log.preConstraintCheckException( exception );
                        throw exception;
                    }
                }
            } else {
            }
        }
    }

    @Override
    public void computeDoActionsAndDoEvents( ) {

        computeDoActionsAndDoEvents( true );
    }

    @Override
    public void computeUndoActionsAndUndoEvents( ) {

        if ( elementsRemoved != null ) {
            resolve( );
            // element add actions
            // sort the removed elements to ensures that the index gets not out
            // of
            // any array boundaries
            List<IndexedElement<Object>> tmpList = new ArrayList<IndexedElement<Object>>( elementsRemoved );
            Collections.sort( tmpList );
            for ( int i = 0; i < tmpList.size( ); i++ ) {
                IndexedElement<Object> elementRemoved = tmpList.get( i );
                getOrCreateUndoActions( ).add( ActionFactory.createDataTypeAttributeAddElementAction( connection, featuredMri, attribute.getName( ), elementRemoved.index, elementRemoved.element ) );
            }
            // partition clear dirty actions
            addClearDirtyActionsToUndoActions( );
            // release lock actions
            addReleaseLockActionsToUndoActions( );
            // events
            if ( eventCreationNeeded( ) ) {
                for ( int i = 0; i < elementsRemoved.size( ); i++ ) {
                    IndexedElement<Object> elementRemoved = elementsRemoved.get( i );
                    int eventIndex = elementRemoved.index == -1 ? -1 : elementRemoved.index - i;
                    getOrCreateUndoEvents( ).add( getEventFactory( ).createAttributeValueAddEvent( connection, featured, (Attribute) attribute, elementRemoved.element, eventIndex ) );

                }
            }
            // changed flag
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
        elementsToRemove = null;
        if ( elementsRemoved != null ) {
            elementsRemoved.trimToSize( );
        }
        unresolve( );
    }

    @Override
    public void undoFinished( ) {

        super.undoFinished( );
        unresolve( );
    }

    private void computeDoActionsAndDoEvents( boolean doCase ) {

        if ( doCase ) {
            if ( elementsToRemove != null ) {
                copyOnWrite( doCase );
                boolean isOrdered = attribute.getMultiplicity( ).isOrdered( );
                Collection elements = (Collection) ( (RefFeaturedImpl) featured ).refGetValue( connection, attribute );
                // pre calculation of the effective remove list
                elementsRemoved = new ArrayList<IndexedElement<Object>>( elementsToRemove.size( ) );
                if ( index == -1 ) {
                    int elementIndex = 0;
                    for ( Object element : elements ) {
                        if ( elementsToRemove.contains( element ) ) {
                            // ok element should be removed
                            int idx = isOrdered ? elementIndex : -1;
                            IndexedElement indexedElement = new IndexedElement( idx, element );
                            if ( !removeAllOccurrences && elementsRemoved.contains( indexedElement ) ) {
                                break;
                            }
                            elementsRemoved.add( indexedElement );
                        }
                        elementIndex++;
                    }
                } else {
                    int idx = isOrdered ? index : -1;
                    IndexedElement indexedElement = new IndexedElement( idx, elementsToRemove.get( 0 ) );
                    elementsRemoved.add( indexedElement );
                }

                PRI affectedPartitionPri = ( (CorePartitionable) featured ).get___Partition( ).getPri( );
                computePartitionsToLock( affectedPartitionPri );
                computePartitionsToEnsureEditing( affectedPartitionPri );
                computePartitionsToMarkDirty( affectedPartitionPri );
            }
        }
        if ( elementsRemoved != null ) {
            // actions and events
            // aquire locks
            addEditLockActionsToDoActions( );
            // ensure editing allowed
            addEnsureEditingActionsToDoActions( );

            // element remove actions
            // sort and reverse the removed elements to ensures that the index
            // gets not out of any array boundaries
            List<IndexedElement> tmpList = new ArrayList<IndexedElement>( elementsRemoved );
            Collections.sort( tmpList );
            for ( int i = tmpList.size( ) - 1; i >= 0; i-- ) {
                IndexedElement elementRemoved = tmpList.get( i );
                getOrCreateDoActions( ).add( ActionFactory.createDataTypeAttributeRemoveElementAction( connection, featuredMri, attribute.getName( ), elementRemoved.index, elementRemoved.element ) );
            }
            // set the dirty state
            addMarkDirtyActionsToDoActions( );
            // events
            if ( eventCreationNeeded( ) ) {
                int numberOfRemovedElements = 0;
                for ( IndexedElement elementRemoved : elementsRemoved ) {
                    int index = elementRemoved.index == -1 ? -1 : elementRemoved.index - numberOfRemovedElements;
                    numberOfRemovedElements++;
                    getOrCreateDoEvents( ).add( getEventFactory( ).createAttributeValueRemoveEvent( connection, featured, (Attribute) attribute, elementRemoved.element, index ) );
                }
            }
            // changed flag
            attributeChanged = true;
        }
    }

    private void copyOnWrite( boolean doCase ) {

        if ( doCase ) {
            CorePartitionable element = (CorePartitionable) featured;
            if ( element.get___Workspace( ) == connection.getSession( ).getCompoundClientSpecWorkspace( ) ) {
                createPrivateCopy( element.get___Partition( ).getPri( ) );
                resolve( );
            }
        } else {
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

    public List getElementsWithIndexRemoved( ) {

        if ( elementsRemoved != null ) {
            List elements = new ArrayList( elementsRemoved.size( ) );
            List indices = new ArrayList( elementsRemoved.size( ) );
            Collections.sort( elementsRemoved );
            for ( IndexedElement elementRemoved : elementsRemoved ) {
                elements.add( elementRemoved.element );
                indices.add( elementRemoved.index );
            }
            return Arrays.asList( elements, indices );
        }
        return Collections.emptyList( );
    }
}

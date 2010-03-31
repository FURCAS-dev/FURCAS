package com.sap.tc.moin.repository.test.transactions.microtransactionables;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.events.AttributeValueAddEventImpl;
import com.sap.tc.moin.repository.core.events.AttributeValueChangeEventImpl;
import com.sap.tc.moin.repository.core.events.AttributeValueRemoveEventImpl;
import com.sap.tc.moin.repository.core.events.PartitionMembershipChangeEventImpl;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.PartitionMembershipChangeEvent;
import com.sap.tc.moin.repository.shared.util.IndexedElement;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.repository.transactions.Transactionable;

@SuppressWarnings( "nls" )
public abstract class BaseMicroTransactionablesFeatureChangeTest extends BaseMicroTransactionablesTest {

    protected void featureAddAll( RefFeatured featured, String featureName, Collection<Object> elements ) {

        StructuralFeature feature = getFeatureByName( (MofClass) featured.refMetaObject( ), featureName );
        ModelPartition featuredPartition = ( (Partitionable) featured ).get___Partition( );
        Collection<Object> oldValues = getValues( featured, featureName );
        Collection<Object> newValues = getValues( featured, featureName );
        List<ChangeEvent> doEvents = new ArrayList<ChangeEvent>( );
        List<ChangeEvent> undoEvents = new ArrayList<ChangeEvent>( );
        Set<MRI> elementsToRepartitionMri = new LinkedHashSet<MRI>( );
        Set<ModelPartition> partitionslockedAndDirty = new HashSet<ModelPartition>( );
        if ( !featuredPartition.isDirty( ) ) {
            partitionslockedAndDirty.add( featuredPartition );
        }
        newValues.addAll( elements );
        int index = feature.getMultiplicity( ).isOrdered( ) ? oldValues.size( ) : -1;
        for ( Object element : newValues ) {
            if ( !oldValues.contains( element ) ) {
                if ( feature instanceof Attribute ) {
                    doEvents.add( new AttributeValueAddEventImpl( coreConnection, featured, (Attribute) feature, element, index ) );
                    undoEvents.add( new AttributeValueRemoveEventImpl( coreConnection, featured, (Attribute) feature, element, index ) );
                } else {
                    if ( element instanceof RefObject ) {
                        doEvents.add( new TestLinkAddEvent( (Reference) feature, (RefObject) featured, (RefObject) element ) );
                        undoEvents.add( new TestLinkRemoveEvent( (Reference) feature, (RefObject) featured, (RefObject) element ) );
                    }
                }
                if ( element instanceof RefObject ) {
                    ModelPartition childPartition = ( (Partitionable) element ).get___Partition( );
                    if ( !featuredPartition.getPri( ).equals( childPartition.getPri( ) ) ) {
                        elementsToRepartitionMri.add( ( (Partitionable) element ).get___Mri( ) );
                        if ( !childPartition.isDirty( ) ) {
                            partitionslockedAndDirty.add( childPartition );
                        }
                    }
                }
                index = feature.getMultiplicity( ).isOrdered( ) ? index + 1 : -1;
            }
        }
        for ( MRI elementToRepartitionMri : elementsToRepartitionMri ) {
            RefObject elementToRepartition = (RefObject) getMOINConnection( ).getElement( elementToRepartitionMri );
            ModelPartition childPartition = ( (Partitionable) elementToRepartition ).get___Partition( );
            doEvents.add( new PartitionMembershipChangeEventImpl( coreConnection, elementToRepartition, childPartition, featuredPartition ) );
            undoEvents.add( new TestPartitionMembershipChangeEvent( elementToRepartition.refMofId( ), featuredPartition.getPri( ), childPartition.getPri( ) ) );
        }
        featureChangeDoUndoRedoTransaction( new FeatureAddAllTransaction( featured, featureName, elements ), featured, featureName, oldValues, newValues, doEvents, undoEvents, partitionslockedAndDirty );
    }

    protected void featureAddAll( RefFeatured featured, String featureName, int index, Collection elements ) {

        StructuralFeature feature = getFeatureByName( (MofClass) featured.refMetaObject( ), featureName );
        ModelPartition featuredPartition = ( (Partitionable) featured ).get___Partition( );
        List oldValues = (List) getValues( featured, featureName );
        List newValues = (List) getValues( featured, featureName );
        newValues.addAll( index, elements );
        List<ChangeEvent> doEvents = new ArrayList<ChangeEvent>( );
        List<ChangeEvent> undoEvents = new ArrayList<ChangeEvent>( );
        Set<MRI> elementsToRepartitionMri = new LinkedHashSet<MRI>( );
        Set<ModelPartition> partitionslockedAndDirty = new HashSet<ModelPartition>( );
        if ( !featuredPartition.isDirty( ) ) {
            partitionslockedAndDirty.add( featuredPartition );
        }
        int valueAddedCount = 0;
        for ( Object element : newValues ) {
            if ( !oldValues.contains( element ) ) {
                // Only add really added elements!
                // TODO: This will not work if duplicates are allowed!
                if ( feature instanceof Attribute ) {
                    doEvents.add( new AttributeValueAddEventImpl( coreConnection, featured, (Attribute) feature, element, index + valueAddedCount ) );
                    undoEvents.add( new AttributeValueRemoveEventImpl( coreConnection, featured, (Attribute) feature, element, index + valueAddedCount ) );
                } else {
                    if ( element instanceof RefObject ) {
                        doEvents.add( new TestLinkAddEvent( (Reference) feature, (RefObject) featured, (RefObject) element ) );
                        undoEvents.add( new TestLinkRemoveEvent( (Reference) feature, (RefObject) featured, (RefObject) element ) );
                    }
                }
                if ( element instanceof RefObject ) {
                    ModelPartition childPartition = ( (Partitionable) element ).get___Partition( );
                    if ( !featuredPartition.getPri( ).equals( childPartition.getPri( ) ) ) {
                        elementsToRepartitionMri.add( ( (Partitionable) element ).get___Mri( ) );
                        if ( !childPartition.isDirty( ) ) {
                            partitionslockedAndDirty.add( childPartition );
                        }
                    }
                }
                valueAddedCount++;
            }
        }
        for ( MRI elementToRepartitionMri : elementsToRepartitionMri ) {
            RefObject elementToRepartition = (RefObject) getMOINConnection( ).getElement( elementToRepartitionMri );
            ModelPartition childPartition = ( (Partitionable) elementToRepartition ).get___Partition( );
            doEvents.add( new PartitionMembershipChangeEventImpl( coreConnection, elementToRepartition, childPartition, featuredPartition ) );
            undoEvents.add( new TestPartitionMembershipChangeEvent( elementToRepartition.refMofId( ), featuredPartition.getPri( ), childPartition.getPri( ) ) );
        }
        featureChangeDoUndoRedoTransaction( new FeatureAddAllTransaction( featured, featureName, index, elements ), featured, featureName, oldValues, newValues, doEvents, undoEvents, partitionslockedAndDirty );
    }

    protected void featureAdd( RefFeatured featured, String featureName, Object element ) {

        StructuralFeature feature = getFeatureByName( (MofClass) featured.refMetaObject( ), featureName );
        ModelPartition featuredPartition = ( (Partitionable) featured ).get___Partition( );
        Collection oldValues = getValues( featured, featureName );
        Collection newValues = getValues( featured, featureName );
        newValues.add( element );
        List<ChangeEvent> doEvents = new ArrayList<ChangeEvent>( );
        List<ChangeEvent> undoEvents = new ArrayList<ChangeEvent>( );
        Set<MRI> elementsToRepartitionMri = new LinkedHashSet<MRI>( );
        Set<ModelPartition> partitionslockedAndDirty = new HashSet<ModelPartition>( );
        if ( !featuredPartition.isDirty( ) ) {
            partitionslockedAndDirty.add( featuredPartition );
        }
        int index = feature.getMultiplicity( ).isOrdered( ) ? oldValues.size( ) : -1;
        if ( oldValues.size( ) < newValues.size( ) ) {
            if ( feature instanceof Attribute ) {
                doEvents.add( new AttributeValueAddEventImpl( coreConnection, featured, (Attribute) feature, element, index ) );
                undoEvents.add( new AttributeValueRemoveEventImpl( coreConnection, featured, (Attribute) feature, element, index ) );
            } else {
                if ( element instanceof RefObject ) {
                    doEvents.add( new TestLinkAddEvent( (Reference) feature, (RefObject) featured, (RefObject) element ) );
                    undoEvents.add( new TestLinkRemoveEvent( (Reference) feature, (RefObject) featured, (RefObject) element ) );
                }
            }
            if ( element instanceof RefObject ) {
                ModelPartition childPartition = ( (Partitionable) element ).get___Partition( );
                if ( !featuredPartition.getPri( ).equals( childPartition.getPri( ) ) ) {
                    elementsToRepartitionMri.add( ( (Partitionable) element ).get___Mri( ) );
                    if ( !childPartition.isDirty( ) ) {
                        partitionslockedAndDirty.add( childPartition );
                    }
                }
            }
            index = feature.getMultiplicity( ).isOrdered( ) ? index + 1 : -1;
        }
        for ( MRI elementToRepartitionMri : elementsToRepartitionMri ) {
            RefObject elementToRepartition = (RefObject) getMOINConnection( ).getElement( elementToRepartitionMri );
            ModelPartition childPartition = ( (Partitionable) elementToRepartition ).get___Partition( );
            doEvents.add( new PartitionMembershipChangeEventImpl( coreConnection, elementToRepartition, childPartition, featuredPartition ) );
            undoEvents.add( new TestPartitionMembershipChangeEvent( elementToRepartition.refMofId( ), featuredPartition.getPri( ), childPartition.getPri( ) ) );
        }
        featureChangeDoUndoRedoTransaction( new FeatureAddTransaction( featured, featureName, element ), featured, featureName, oldValues, newValues, doEvents, undoEvents, partitionslockedAndDirty );
    }

    protected void featureAdd( RefFeatured featured, String featureName, int index, Object element ) {

        StructuralFeature feature = getFeatureByName( (MofClass) featured.refMetaObject( ), featureName );
        ModelPartition featuredPartition = ( (Partitionable) featured ).get___Partition( );
        List oldValues = (List) getValues( featured, featureName );
        List newValues = (List) getValues( featured, featureName );
        newValues.add( index, element );
        List<ChangeEvent> doEvents = new ArrayList<ChangeEvent>( );
        List<ChangeEvent> undoEvents = new ArrayList<ChangeEvent>( );
        Set<MRI> elementsToRepartitionMri = new LinkedHashSet<MRI>( );
        Set<ModelPartition> partitionslockedAndDirty = new HashSet<ModelPartition>( );
        if ( !featuredPartition.isDirty( ) ) {
            partitionslockedAndDirty.add( featuredPartition );
        }
        if ( feature instanceof Attribute ) {
            doEvents.add( new AttributeValueAddEventImpl( coreConnection, featured, (Attribute) feature, element, index ) );
            undoEvents.add( new AttributeValueRemoveEventImpl( coreConnection, featured, (Attribute) feature, element, index ) );
        } else {
            if ( element instanceof RefObject ) {
                doEvents.add( new TestLinkAddEvent( (Reference) feature, (RefObject) featured, (RefObject) element ) );
                undoEvents.add( new TestLinkRemoveEvent( (Reference) feature, (RefObject) featured, (RefObject) element ) );
            }
        }
        if ( element instanceof RefObject ) {
            ModelPartition childPartition = ( (Partitionable) element ).get___Partition( );
            if ( !featuredPartition.getPri( ).equals( childPartition.getPri( ) ) ) {
                elementsToRepartitionMri.add( ( (Partitionable) element ).get___Mri( ) );
                if ( !childPartition.isDirty( ) ) {
                    partitionslockedAndDirty.add( childPartition );
                }
            }
        }
        for ( MRI elementToRepartitionMri : elementsToRepartitionMri ) {
            RefObject elementToRepartition = (RefObject) getMOINConnection( ).getElement( elementToRepartitionMri );
            ModelPartition childPartition = ( (Partitionable) elementToRepartition ).get___Partition( );
            doEvents.add( new PartitionMembershipChangeEventImpl( coreConnection, elementToRepartition, childPartition, featuredPartition ) );
            undoEvents.add( new TestPartitionMembershipChangeEvent( elementToRepartition.refMofId( ), featuredPartition.getPri( ), childPartition.getPri( ) ) );
        }
        featureChangeDoUndoRedoTransaction( new FeatureAddTransaction( featured, featureName, index, element ), featured, featureName, oldValues, newValues, doEvents, undoEvents, partitionslockedAndDirty );
    }

    protected void featureClear( RefFeatured featured, String featureName ) {

        StructuralFeature feature = getFeatureByName( (MofClass) featured.refMetaObject( ), featureName );
        ModelPartition featuredPartition = ( (Partitionable) featured ).get___Partition( );
        Collection oldValues = getValues( featured, featureName );
        Collection newValues = getValues( featured, featureName );
        newValues.clear( );
        List<ChangeEvent> doEvents = new ArrayList<ChangeEvent>( );
        List<ChangeEvent> undoEvents = new ArrayList<ChangeEvent>( );
        Set<MRI> elementsToRepartitionMri = new LinkedHashSet<MRI>( );
        Set<ModelPartition> partitionslockedAndDirty = new HashSet<ModelPartition>( );
        if ( !featuredPartition.isDirty( ) ) {
            partitionslockedAndDirty.add( featuredPartition );
        }
        List<IndexedElement<Object>> elementsToRemove = new ArrayList<IndexedElement<Object>>( );
        for ( Object element : oldValues ) {
            int index = feature.getMultiplicity( ).isOrdered( ) ? ( (List) oldValues ).indexOf( element ) : -1;
            elementsToRemove.add( new IndexedElement<Object>( index, element ) );
        }
        // do events
        for ( IndexedElement<Object> elementToRemove : elementsToRemove ) {
            Object element = elementToRemove.element;
            int index = elementToRemove.index;
            if ( feature instanceof Attribute ) {
                doEvents.add( new AttributeValueRemoveEventImpl( coreConnection, featured, (Attribute) feature, element ) );
                undoEvents.add( new AttributeValueAddEventImpl( coreConnection, featured, (Attribute) feature, element, index ) );
            } else {
                if ( element instanceof RefObject ) {
                    doEvents.add( new TestLinkRemoveEvent( (Reference) feature, (RefObject) featured, (RefObject) element ) );
                    undoEvents.add( new TestLinkAddEvent( (Reference) feature, (RefObject) featured, (RefObject) element ) );
                }
            }
            if ( element instanceof RefObject ) {
                ModelPartition childPartition = ( (Partitionable) element ).get___Partition( );
                if ( !nullPartition.getPri( ).equals( childPartition.getPri( ) ) ) {
                    elementsToRepartitionMri.add( ( (Partitionable) element ).get___Mri( ) );
                    if ( !childPartition.isDirty( ) ) {
                        partitionslockedAndDirty.add( childPartition );
                    }
                }
            }
        }
        for ( MRI elementToRepartitionMri : elementsToRepartitionMri ) {
            RefObject elementToRepartition = (RefObject) getMOINConnection( ).getElement( elementToRepartitionMri );
            ModelPartition childPartition = ( (Partitionable) elementToRepartition ).get___Partition( );
            doEvents.add( new PartitionMembershipChangeEventImpl( coreConnection, elementToRepartition, childPartition, nullPartition ) );
            undoEvents.add( new TestPartitionMembershipChangeEvent( elementToRepartition.refMofId( ), nullPartition.getPri( ), childPartition.getPri( ) ) );
        }
        featureChangeDoUndoRedoTransaction( new FeatureClearTransaction( featured, featureName ), featured, featureName, oldValues, newValues, doEvents, undoEvents, partitionslockedAndDirty );
    }

    protected void featureChange( RefFeatured featured, String featureName, Object value, List<PartitionMembershipChangeEvent> expectedDoPartitionMembershipChangeEvents, List<PartitionMembershipChangeEvent> expectedUnDoPartitionMembershipChangeEvents ) {
        StructuralFeature feature = getFeatureByName( (MofClass) featured.refMetaObject( ), featureName );
        ModelPartition featuredPartition = ( (Partitionable) featured ).get___Partition( );
        Object oldValue = featured.refGetValue( featureName );
        Object newValue = featured.refGetValue( featureName );
        List<ChangeEvent> doEvents = new ArrayList<ChangeEvent>( );
        List<ChangeEvent> undoEvents = new ArrayList<ChangeEvent>( );
        Set<ModelPartition> partitionslockedAndDirty = new HashSet<ModelPartition>( );
        if ( !featuredPartition.isDirty( ) ) {
            partitionslockedAndDirty.add( featuredPartition );
        }
        if ( feature instanceof Attribute && ( (Attribute) feature ).isDerived( ) ) {
            // simulate the change of the attribute
            try {
                featured.refSetValue( featureName, value );
                newValue = featured.refGetValue( featureName );
                featured.refSetValue( featureName, oldValue );
            } catch ( ClassCastException classCastEx ) {
            }
        } else {
            if ( ( value == null ) && ( feature.getMultiplicity( ).getLower( ) == 1 ) && ( feature.getMultiplicity( ).getUpper( ) == 1 ) && ( feature.getType( ) instanceof PrimitiveType ) ) {
                newValue = ( coreConnection.getCoreJmiHelper( ) ).getJavaReturnInitialWrapperValueFromClassifier( coreConnection, ( (Wrapper<PrimitiveType>) feature.getType( ) ).unwrap( ) );
            } else {
                newValue = value;
            }
            if ( !( ( value == null && oldValue == null ) || ( value != null && value.equals( oldValue ) ) || ( oldValue != null && oldValue.equals( value ) ) ) ) {
                // only when the values are different!
                Set<MRI> elementsToRepartitionMri = new LinkedHashSet<MRI>( );
                if ( feature instanceof Attribute ) {
                    doEvents.add( new AttributeValueChangeEventImpl( coreConnection, featured, (Attribute) feature, oldValue, value ) );
                    undoEvents.add( new AttributeValueChangeEventImpl( coreConnection, featured, (Attribute) feature, value, oldValue ) );
                } else {
                    // remove before add
                    if ( oldValue instanceof RefObject ) {
                        doEvents.add( new TestLinkRemoveEvent( (Reference) feature, (RefObject) featured, (RefObject) oldValue ) );
                    }
                    if ( value instanceof RefObject ) {
                        doEvents.add( new TestLinkAddEvent( (Reference) feature, (RefObject) featured, (RefObject) value ) );
                    }
                    if ( value instanceof RefObject ) {
                        undoEvents.add( new TestLinkRemoveEvent( (Reference) feature, (RefObject) featured, (RefObject) value ) );
                    }
                    if ( oldValue instanceof RefObject ) {
                        undoEvents.add( new TestLinkAddEvent( (Reference) feature, (RefObject) featured, (RefObject) oldValue ) );
                    }
                }
                if ( newValue instanceof RefObject ) {
                    ModelPartition childPartition = ( (Partitionable) newValue ).get___Partition( );
                    if ( childPartition.getPri( ).isVolatilePartition( ) && childPartition.equals( nullPartition ) ) {
                        if ( !featuredPartition.getPri( ).equals( childPartition.getPri( ) ) ) {
                            elementsToRepartitionMri.add( ( (Partitionable) newValue ).get___Mri( ) );
                            if ( !childPartition.isDirty( ) ) {
                                partitionslockedAndDirty.add( childPartition );
                            }
                        }
                    }
                }
                if ( oldValue instanceof RefObject ) {
                    ModelPartition childPartition = ( (Partitionable) oldValue ).get___Partition( );
                    if ( !( childPartition.getPri( ).isVolatilePartition( ) && childPartition.equals( nullPartition ) ) ) {
                        elementsToRepartitionMri.add( ( (Partitionable) oldValue ).get___Mri( ) );
                        if ( !childPartition.isDirty( ) ) {
                            partitionslockedAndDirty.add( childPartition );
                        }
                    }
                }
            }
        }
        if ( expectedDoPartitionMembershipChangeEvents != null ) {
            doEvents.addAll( expectedDoPartitionMembershipChangeEvents );
        }
        if ( expectedUnDoPartitionMembershipChangeEvents != null ) {
            undoEvents.addAll( expectedUnDoPartitionMembershipChangeEvents );
        }
        featureChangeDoUndoRedoTransaction( new FeatureChangeTransaction( featured, featureName, value ), featured, featureName, oldValue, newValue, doEvents, undoEvents, partitionslockedAndDirty );
    }

    protected void featureChange( RefFeatured featured, String featureName, Object value ) {
        featureChange( featured, featureName, value, null, null );
    }

    protected void featureRemoveAll( RefFeatured featured, String featureName, Collection elements ) {

        StructuralFeature feature = getFeatureByName( (MofClass) featured.refMetaObject( ), featureName );
        ModelPartition featuredPartition = ( (Partitionable) featured ).get___Partition( );
        Collection oldValues = getValues( featured, featureName );
        Collection newValues = getValues( featured, featureName );
        newValues.removeAll( elements );
        List<ChangeEvent> doEvents = new ArrayList<ChangeEvent>( );
        List<ChangeEvent> undoEvents = new ArrayList<ChangeEvent>( );
        Set<MRI> elementsToRepartitionMri = new LinkedHashSet<MRI>( );
        Set<ModelPartition> partitionslockedAndDirty = new HashSet<ModelPartition>( );
        if ( !featuredPartition.isDirty( ) ) {
            partitionslockedAndDirty.add( featuredPartition );
        }
        List<IndexedElement<Object>> elementsToRemove = new ArrayList<IndexedElement<Object>>( );
        for ( Object element : oldValues ) {
            if ( elements.contains( element ) ) {
                int index = feature.getMultiplicity( ).isOrdered( ) ? ( (List) oldValues ).indexOf( element ) : -1;
                elementsToRemove.add( new IndexedElement<Object>( index, element ) );
            }
        }
        int numberOfRemovedElements = 0;
        for ( IndexedElement<Object> elementToRemove : elementsToRemove ) {
            Object element = elementToRemove.element;
            if ( feature instanceof Attribute ) {
                int index = feature.getMultiplicity( ).isOrdered( ) ? elementToRemove.index - numberOfRemovedElements : -1;
                doEvents.add( new AttributeValueRemoveEventImpl( coreConnection, featured, (Attribute) feature, element, index ) );
                undoEvents.add( new AttributeValueAddEventImpl( coreConnection, featured, (Attribute) feature, element, index ) );
                numberOfRemovedElements++;
            } else {
                if ( element instanceof RefObject ) {
                    doEvents.add( new TestLinkRemoveEvent( (Reference) feature, (RefObject) featured, (RefObject) element ) );
                    undoEvents.add( new TestLinkAddEvent( (Reference) feature, (RefObject) featured, (RefObject) element ) );
                }
            }
            if ( element instanceof RefObject ) {
                ModelPartition childPartition = ( (Partitionable) element ).get___Partition( );
                if ( !nullPartition.getPri( ).equals( childPartition.getPri( ) ) ) {
                    elementsToRepartitionMri.add( ( (Partitionable) element ).get___Mri( ) );
                    if ( !childPartition.isDirty( ) ) {
                        partitionslockedAndDirty.add( childPartition );
                    }
                }
            }
        }
        for ( MRI elementToRepartitionMri : elementsToRepartitionMri ) {
            RefObject elementToRepartition = (RefObject) getMOINConnection( ).getElement( elementToRepartitionMri );
            ModelPartition childPartition = ( (Partitionable) elementToRepartition ).get___Partition( );
            doEvents.add( new PartitionMembershipChangeEventImpl( coreConnection, elementToRepartition, childPartition, nullPartition ) );
            undoEvents.add( new TestPartitionMembershipChangeEvent( elementToRepartition.refMofId( ), nullPartition.getPri( ), childPartition.getPri( ) ) );
        }
        featureChangeDoUndoRedoTransaction( new FeatureRemoveAllTransaction( featured, featureName, elements ), featured, featureName, oldValues, newValues, doEvents, undoEvents, partitionslockedAndDirty );
    }

    protected void featureRemove( RefFeatured featured, String featureName, Object element ) {

        StructuralFeature feature = getFeatureByName( (MofClass) featured.refMetaObject( ), featureName );
        ModelPartition featuredPartition = ( (Partitionable) featured ).get___Partition( );
        Collection<Object> oldValues = getValues( featured, featureName );
        Collection<Object> newValues = getValues( featured, featureName );
        newValues.remove( element );
        List<ChangeEvent> doEvents = new ArrayList<ChangeEvent>( );
        List<ChangeEvent> undoEvents = new ArrayList<ChangeEvent>( );
        Set<MRI> elementsToRepartitionMri = new LinkedHashSet<MRI>( );
        Set<ModelPartition> partitionslockedAndDirty = new HashSet<ModelPartition>( );
        if ( !featuredPartition.isDirty( ) ) {
            partitionslockedAndDirty.add( featuredPartition );
        }
        // only remove if contained!
        if ( oldValues.contains( element ) ) {
            int index = feature.getMultiplicity( ).isOrdered( ) ? ( (List) oldValues ).indexOf( element ) : -1;
            if ( feature instanceof Attribute ) {
                doEvents.add( new AttributeValueRemoveEventImpl( coreConnection, featured, (Attribute) feature, element, index ) );
                undoEvents.add( new AttributeValueAddEventImpl( coreConnection, featured, (Attribute) feature, element, index ) );
            } else {
                if ( element instanceof RefObject ) {
                    doEvents.add( new TestLinkRemoveEvent( (Reference) feature, (RefObject) featured, (RefObject) element ) );
                    undoEvents.add( new TestLinkAddEvent( (Reference) feature, (RefObject) featured, (RefObject) element ) );
                }
            }
            if ( element instanceof RefObject ) {
                ModelPartition childPartition = ( (Partitionable) element ).get___Partition( );
                if ( !nullPartition.getPri( ).equals( childPartition.getPri( ) ) ) {
                    elementsToRepartitionMri.add( ( (Partitionable) element ).get___Mri( ) );
                    if ( !childPartition.isDirty( ) ) {
                        partitionslockedAndDirty.add( childPartition );
                    }
                }
            }
        }
        for ( MRI elementToRepartitionMri : elementsToRepartitionMri ) {
            RefObject elementToRepartition = (RefObject) getMOINConnection( ).getElement( elementToRepartitionMri );
            ModelPartition childPartition = ( (Partitionable) elementToRepartition ).get___Partition( );
            doEvents.add( new PartitionMembershipChangeEventImpl( coreConnection, elementToRepartition, childPartition, nullPartition ) );
            undoEvents.add( new TestPartitionMembershipChangeEvent( elementToRepartition.refMofId( ), nullPartition.getPri( ), childPartition.getPri( ) ) );
        }
        featureChangeDoUndoRedoTransaction( new FeatureRemoveTransaction( featured, featureName, element ), featured, featureName, oldValues, newValues, doEvents, undoEvents, partitionslockedAndDirty );
    }

    protected void featureRemove( RefFeatured featured, String featureName, int index ) {

        StructuralFeature feature = getFeatureByName( (MofClass) featured.refMetaObject( ), featureName );
        ModelPartition featuredPartition = ( (Partitionable) featured ).get___Partition( );
        Collection oldValues = getValues( featured, featureName );
        Collection newValues = getValues( featured, featureName );
        List<ChangeEvent> doEvents = new ArrayList<ChangeEvent>( );
        List<ChangeEvent> undoEvents = new ArrayList<ChangeEvent>( );
        Set<MRI> elementsToRepartitionMri = new LinkedHashSet<MRI>( );
        Set<ModelPartition> partitionslockedAndDirty = new HashSet<ModelPartition>( );
        if ( !featuredPartition.isDirty( ) ) {
            partitionslockedAndDirty.add( featuredPartition );
        }
        if ( ( index > 0 ) && ( index <= newValues.size( ) ) ) {
            Object oldValue = ( (List) oldValues ).get( index );
            ( (List) newValues ).remove( index );
            if ( feature instanceof Attribute ) {
                doEvents.add( new AttributeValueRemoveEventImpl( coreConnection, featured, (Attribute) feature, oldValue, index ) );
                undoEvents.add( new AttributeValueAddEventImpl( coreConnection, featured, (Attribute) feature, oldValue, index ) );
            } else {
                if ( oldValue instanceof RefObject ) {
                    doEvents.add( new TestLinkRemoveEvent( (Reference) feature, (RefObject) featured, (RefObject) oldValue ) );
                    undoEvents.add( new TestLinkAddEvent( (Reference) feature, (RefObject) featured, (RefObject) oldValue ) );
                }
            }
            if ( oldValue instanceof RefObject ) {
                ModelPartition childPartition = ( (Partitionable) oldValue ).get___Partition( );
                if ( !nullPartition.getPri( ).equals( childPartition.getPri( ) ) ) {
                    elementsToRepartitionMri.add( ( (Partitionable) oldValue ).get___Mri( ) );
                    if ( !childPartition.isDirty( ) ) {
                        partitionslockedAndDirty.add( childPartition );
                    }
                }
            }
        }
        for ( MRI elementToRepartitionMri : elementsToRepartitionMri ) {
            RefObject elementToRepartition = (RefObject) getMOINConnection( ).getElement( elementToRepartitionMri );
            ModelPartition childPartition = ( (Partitionable) elementToRepartition ).get___Partition( );
            doEvents.add( new PartitionMembershipChangeEventImpl( coreConnection, elementToRepartition, childPartition, nullPartition ) );
            undoEvents.add( new TestPartitionMembershipChangeEvent( elementToRepartition.refMofId( ), nullPartition.getPri( ), childPartition.getPri( ) ) );
        }
        featureChangeDoUndoRedoTransaction( new FeatureRemoveTransaction( featured, featureName, index ), featured, featureName, oldValues, newValues, doEvents, undoEvents, partitionslockedAndDirty );
    }

    protected void featureIteratorRemove( RefFeatured featured, String featureName, String[] iteratorCallSequence ) {

        StructuralFeature feature = getFeatureByName( (MofClass) featured.refMetaObject( ), featureName );
        ModelPartition featuredPartition = ( (Partitionable) featured ).get___Partition( );
        boolean isOrdered = feature.getMultiplicity( ).isOrdered( );
        Collection oldValues = getValues( featured, featureName );
        Collection newValues = getValues( featured, featureName );
        List<ChangeEvent> doEvents = new ArrayList<ChangeEvent>( );
        List<ChangeEvent> undoEvents = new ArrayList<ChangeEvent>( );
        Set<MRI> elementsToRepartitionMri = new LinkedHashSet<MRI>( );
        Set<ModelPartition> partitionslockedAndDirty = new HashSet<ModelPartition>( );
        if ( !featuredPartition.isDirty( ) ) {
            partitionslockedAndDirty.add( featuredPartition );
        }
        Iterator iter = newValues.iterator( );
        Object nextValue = null;
        List<Object> removedValues = new ArrayList<Object>( );
        for ( int i = 0; i < iteratorCallSequence.length; i++ ) {
            String iteratorCall = iteratorCallSequence[i];
            if ( iteratorCall.equals( "next()" ) ) {
                nextValue = iter.next( );
            } else if ( iteratorCall.equals( "remove()" ) ) {
                iter.remove( );
                removedValues.add( nextValue );
            }
        }
        for ( int i = 0; i < removedValues.size( ); i++ ) {
            Object removedValue = removedValues.get( i );
            if ( removedValue instanceof RefObject ) {
                ModelPartition childPartition = ( (Partitionable) removedValue ).get___Partition( );
                if ( !nullPartition.getPri( ).equals( childPartition.getPri( ) ) ) {
                    elementsToRepartitionMri.add( ( (Partitionable) removedValue ).get___Mri( ) );
                    if ( !childPartition.isDirty( ) ) {
                        partitionslockedAndDirty.add( childPartition );
                    }
                }
            }
        }
        for ( int i = 0; i < removedValues.size( ); i++ ) {
            Object removedValue = removedValues.get( i );
            int index = isOrdered ? ( (List) oldValues ).indexOf( removedValue ) : -1;
            if ( feature instanceof Attribute ) {
                doEvents.add( new AttributeValueRemoveEventImpl( coreConnection, featured, (Attribute) feature, removedValue, index ) );
            } else {
                if ( removedValue instanceof RefObject ) {
                    doEvents.add( new TestLinkRemoveEvent( (Reference) feature, (RefObject) featured, (RefObject) removedValue ) );
                }
            }
            for ( MRI elementToRepartitionMri : elementsToRepartitionMri ) {
                RefObject elementToRepartition = (RefObject) getMOINConnection( ).getElement( elementToRepartitionMri );
                ModelPartition childPartition = ( (Partitionable) elementToRepartition ).get___Partition( );
                doEvents.add( new PartitionMembershipChangeEventImpl( coreConnection, elementToRepartition, childPartition, nullPartition ) );
            }
        }
        for ( int i = removedValues.size( ) - 1; i >= 0; i-- ) {
            Object removedValue = removedValues.get( i );
            int index = isOrdered ? ( (List) oldValues ).indexOf( removedValue ) : -1;
            if ( feature instanceof Attribute ) {
                undoEvents.add( new AttributeValueAddEventImpl( coreConnection, featured, (Attribute) feature, removedValue, index ) );
            } else {
                if ( removedValue instanceof RefObject ) {
                    undoEvents.add( new TestLinkAddEvent( (Reference) feature, (RefObject) featured, (RefObject) removedValue ) );
                }
            }
            for ( MRI elementToRepartitionMri : elementsToRepartitionMri ) {
                RefObject elementToRepartition = (RefObject) getMOINConnection( ).getElement( elementToRepartitionMri );
                ModelPartition childPartition = ( (Partitionable) elementToRepartition ).get___Partition( );
                undoEvents.add( new TestPartitionMembershipChangeEvent( elementToRepartition.refMofId( ), nullPartition.getPri( ), childPartition.getPri( ) ) );
            }
        }
        featureChangeDoUndoRedoTransaction( new FeatureIteratorRemoveTransaction( featured, featureName, iteratorCallSequence ), featured, featureName, oldValues, newValues, doEvents, undoEvents, partitionslockedAndDirty );
    }

    protected void featureRetainAll( RefFeatured featured, String featureName, Collection elements ) {

        StructuralFeature feature = getFeatureByName( (MofClass) featured.refMetaObject( ), featureName );
        ModelPartition featuredPartition = ( (Partitionable) featured ).get___Partition( );
        Collection oldValues = getValues( featured, featureName );
        Collection newValues = getValues( featured, featureName );
        newValues.retainAll( elements );
        List<ChangeEvent> doEvents = new ArrayList<ChangeEvent>( );
        List<ChangeEvent> undoEvents = new ArrayList<ChangeEvent>( );
        Set<MRI> elementsToRepartitionMri = new LinkedHashSet<MRI>( );
        Set<ModelPartition> partitionslockedAndDirty = new HashSet<ModelPartition>( );
        if ( !featuredPartition.isDirty( ) ) {
            partitionslockedAndDirty.add( featuredPartition );
        }
        List<IndexedElement<Object>> elementsToRemove = new ArrayList<IndexedElement<Object>>( );
        for ( Object element : oldValues ) {
            if ( !elements.contains( element ) ) {
                int index = feature.getMultiplicity( ).isOrdered( ) ? ( (List) oldValues ).indexOf( element ) : -1;
                elementsToRemove.add( new IndexedElement<Object>( index, element ) );
            }
        }
        // do events
        for ( IndexedElement<Object> elementToRemove : elementsToRemove ) {
            Object element = elementToRemove.element;
            int index = elementToRemove.index;
            if ( feature instanceof Attribute ) {
                doEvents.add( new AttributeValueRemoveEventImpl( coreConnection, featured, (Attribute) feature, element ) );
                undoEvents.add( new AttributeValueAddEventImpl( coreConnection, featured, (Attribute) feature, element, index ) );
            } else {
                if ( element instanceof RefObject ) {
                    doEvents.add( new TestLinkRemoveEvent( (Reference) feature, (RefObject) featured, (RefObject) element ) );
                    undoEvents.add( new TestLinkAddEvent( (Reference) feature, (RefObject) featured, (RefObject) element ) );
                }
            }
            if ( element instanceof RefObject ) {
                ModelPartition childPartition = ( (Partitionable) element ).get___Partition( );
                if ( !nullPartition.getPri( ).equals( childPartition.getPri( ) ) ) {
                    elementsToRepartitionMri.add( ( (Partitionable) element ).get___Mri( ) );
                    if ( !childPartition.isDirty( ) ) {
                        partitionslockedAndDirty.add( childPartition );
                    }
                }
            }
        }
        for ( MRI elementToRepartitionMri : elementsToRepartitionMri ) {
            RefObject elementToRepartition = (RefObject) getMOINConnection( ).getElement( elementToRepartitionMri );
            ModelPartition childPartition = ( (Partitionable) elementToRepartition ).get___Partition( );
            doEvents.add( new PartitionMembershipChangeEventImpl( coreConnection, elementToRepartition, childPartition, nullPartition ) );
            undoEvents.add( new TestPartitionMembershipChangeEvent( elementToRepartition.refMofId( ), nullPartition.getPri( ), childPartition.getPri( ) ) );
        }
        featureChangeDoUndoRedoTransaction( new FeatureRetainAllTransaction( featured, featureName, elements ), featured, featureName, oldValues, newValues, doEvents, undoEvents, partitionslockedAndDirty );
    }

    protected void featureSet( RefFeatured featured, String featureName, int index, Object value ) {

        StructuralFeature feature = getFeatureByName( (MofClass) featured.refMetaObject( ), featureName );
        ModelPartition featuredPartition = ( (Partitionable) featured ).get___Partition( );
        List oldValues = (List) getValues( featured, featureName );
        List newValues = (List) getValues( featured, featureName );
        List<ChangeEvent> doEvents = new ArrayList<ChangeEvent>( );
        List<ChangeEvent> undoEvents = new ArrayList<ChangeEvent>( );
        Set<ModelPartition> partitionslockedAndDirty = new HashSet<ModelPartition>( );
        if ( !featuredPartition.isDirty( ) ) {
            partitionslockedAndDirty.add( featuredPartition );
        }
        newValues.set( index, value );
        Set<MRI> elementsToRepartitionMri = new LinkedHashSet<MRI>( );
        if ( feature instanceof Attribute ) {
            doEvents.add( new AttributeValueRemoveEventImpl( coreConnection, featured, (Attribute) feature, oldValues.get( index ), index ) );
            doEvents.add( new AttributeValueAddEventImpl( coreConnection, featured, (Attribute) feature, value, index ) );
            undoEvents.add( new AttributeValueRemoveEventImpl( coreConnection, featured, (Attribute) feature, value, index ) );
            undoEvents.add( new AttributeValueAddEventImpl( coreConnection, featured, (Attribute) feature, oldValues.get( index ), index ) );
        } else {
            // remove before add
            if ( oldValues.get( index ) instanceof RefObject ) {
                doEvents.add( new TestLinkRemoveEvent( (Reference) feature, (RefObject) featured, (RefObject) oldValues.get( index ) ) );
            }
            if ( value instanceof RefObject ) {
                doEvents.add( new TestLinkAddEvent( (Reference) feature, (RefObject) featured, (RefObject) value ) );
            }
            if ( value instanceof RefObject ) {
                undoEvents.add( new TestLinkRemoveEvent( (Reference) feature, (RefObject) featured, (RefObject) value ) );
            }
            if ( oldValues.get( index ) instanceof RefObject ) {
                undoEvents.add( new TestLinkAddEvent( (Reference) feature, (RefObject) featured, (RefObject) oldValues.get( index ) ) );
            }
        }
        if ( value instanceof RefObject ) {
            ModelPartition childPartition = ( (Partitionable) value ).get___Partition( );
            if ( !featuredPartition.getPri( ).equals( childPartition.getPri( ) ) ) {
                elementsToRepartitionMri.add( ( (Partitionable) value ).get___Mri( ) );
                if ( !childPartition.isDirty( ) ) {
                    partitionslockedAndDirty.add( childPartition );
                }
            }
        }
        for ( MRI elementToRepartitionMri : elementsToRepartitionMri ) {
            RefObject elementToRepartition = (RefObject) getMOINConnection( ).getElement( elementToRepartitionMri );
            ModelPartition childPartition = ( (Partitionable) elementToRepartition ).get___Partition( );
            doEvents.add( new PartitionMembershipChangeEventImpl( coreConnection, elementToRepartition, childPartition, featuredPartition ) );
            undoEvents.add( new TestPartitionMembershipChangeEvent( elementToRepartition.refMofId( ), featuredPartition.getPri( ), childPartition.getPri( ) ) );
        }
        featureChangeDoUndoRedoTransaction( new FeatureSetTransaction( featured, featureName, index, value ), featured, featureName, oldValues, newValues, doEvents, undoEvents, partitionslockedAndDirty );
    }

    private void featureChangeDoUndoRedoTransaction( final Transactionable transactionable, final RefFeatured featured, final String featureName, final Object anInitialValue, final Object aFinalValue, final List<ChangeEvent> expectedDoEvents, final List<ChangeEvent> expectedUndoEvents,
        final Collection<ModelPartition> partitionsLockedAndDirty ) {

        DoUndoRedoTestAsserter asserter = new DoUndoRedoTestAsserter( ) {

            @Override
            public void assertBeforeDo( ) {

                assertEquals( anInitialValue, featured.refGetValue( featureName ) );
                testPartitionsUnlockedAndNotDirty( partitionsLockedAndDirty );
            }

            @Override
            public void assertAfterDo( ) {

                assertEquals( aFinalValue, featured.refGetValue( featureName ) );
                testPartitionsLockedAndDirty( partitionsLockedAndDirty );
            }

            @Override
            public void assertAfterUndo( ) {

                assertEquals( anInitialValue, featured.refGetValue( featureName ) );
                testPartitionsUnlockedAndNotDirty( partitionsLockedAndDirty );
            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

                checkEvents( expectedDoEvents, receivedEvents );
            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

                checkEvents( expectedUndoEvents, receivedEvents );
            }
        };
        runDoUndoRedoTest( getMOINConnection( ), transactionable, asserter );
    }

    private class FeatureAddAllTransaction implements Transactionable {

        private RefFeatured featured = null;

        private String featureName = null;

        private int index = -1;

        private Collection elements = null;

        private FeatureAddAllTransaction( RefFeatured aFeatured, String aFeatureName, Collection theElementsToAdd ) {

            featured = aFeatured;
            featureName = aFeatureName;
            elements = theElementsToAdd;
        }

        private FeatureAddAllTransaction( RefFeatured aFeatured, String aFeatureName, int anIndex, Collection theElementsToAdd ) {

            featured = aFeatured;
            featureName = aFeatureName;
            index = anIndex;
            elements = theElementsToAdd;
        }

        public void runInTransaction( ) {

            if ( index != -1 ) {
                ( (List) featured.refGetValue( featureName ) ).addAll( index, elements );
            } else {
                ( (Collection) featured.refGetValue( featureName ) ).addAll( elements );
            }
        }

        public CoreConnection getConnection( ) {

            return coreConnection;
        }
    }

    private class FeatureAddTransaction implements Transactionable {

        private RefFeatured featured = null;

        private String featureName = null;

        private int index = -1;

        private Object element = null;

        private FeatureAddTransaction( RefFeatured aFeatured, String aFeatureName, Object anElementToAdd ) {

            featured = aFeatured;
            featureName = aFeatureName;
            element = anElementToAdd;
        }

        private FeatureAddTransaction( RefFeatured aFeatured, String aFeatureName, int anIndex, Object anElementToAdd ) {

            featured = aFeatured;
            featureName = aFeatureName;
            index = anIndex;
            element = anElementToAdd;
        }

        public void runInTransaction( ) {

            if ( index != -1 ) {
                ( (List) featured.refGetValue( featureName ) ).add( index, element );
            } else {
                ( (Collection) featured.refGetValue( featureName ) ).add( element );
            }
        }

        public CoreConnection getConnection( ) {

            return coreConnection;
        }
    }

    private class FeatureClearTransaction implements Transactionable {

        private RefFeatured featured = null;

        private String featureName = null;

        private FeatureClearTransaction( RefFeatured aFeatured, String aFeatureName ) {

            featured = aFeatured;
            featureName = aFeatureName;
        }

        public void runInTransaction( ) {

            ( (Collection) featured.refGetValue( featureName ) ).clear( );
        }

        public CoreConnection getConnection( ) {

            return coreConnection;
        }
    }

    private class FeatureChangeTransaction implements Transactionable {

        private RefFeatured featured = null;

        private String featureName = null;

        private Object newValue;

        private FeatureChangeTransaction( RefFeatured aFeatured, String aFeatureName, Object aNewValue ) {

            featured = aFeatured;
            featureName = aFeatureName;
            newValue = aNewValue;
        }

        public void runInTransaction( ) {

            featured.refSetValue( featureName, newValue );
        }

        public CoreConnection getConnection( ) {

            return coreConnection;
        }
    }

    private class FeatureRemoveAllTransaction implements Transactionable {

        private RefFeatured featured = null;

        private String featureName = null;

        private Collection elements = null;

        private FeatureRemoveAllTransaction( RefFeatured aFeatured, String aFeatureName, Collection theElementsToRemove ) {

            featured = aFeatured;
            featureName = aFeatureName;
            elements = theElementsToRemove;
        }

        public void runInTransaction( ) {

            ( (Collection) featured.refGetValue( featureName ) ).removeAll( elements );
        }

        public CoreConnection getConnection( ) {

            return coreConnection;
        }
    }

    private class FeatureRemoveTransaction implements Transactionable {

        private RefFeatured featured = null;

        private String featureName = null;

        private int index = -1;

        private Object element = null;

        private FeatureRemoveTransaction( RefFeatured aFeatured, String aFeatureName, Object anElementToRemove ) {

            featured = aFeatured;
            featureName = aFeatureName;
            element = anElementToRemove;
        }

        private FeatureRemoveTransaction( RefFeatured aFeatured, String aFeatureName, int anIndex ) {

            featured = aFeatured;
            featureName = aFeatureName;
            index = anIndex;
        }

        public void runInTransaction( ) {

            if ( index != -1 ) {
                ( (List) featured.refGetValue( featureName ) ).remove( index );
            } else {
                ( (Collection) featured.refGetValue( featureName ) ).remove( element );
            }
        }

        public CoreConnection getConnection( ) {

            return coreConnection;
        }
    }

    private class FeatureIteratorRemoveTransaction implements Transactionable {

        private RefFeatured featured = null;

        private String featureName = null;

        private String[] iteratorCallSequence = null;

        private FeatureIteratorRemoveTransaction( RefFeatured aFeatured, String aFeatureName, String[] theIteratorCallSequence ) {

            featured = aFeatured;
            featureName = aFeatureName;
            iteratorCallSequence = theIteratorCallSequence;
        }

        public void runInTransaction( ) {

            Iterator iter = ( (Collection) featured.refGetValue( featureName ) ).iterator( );
            for ( int i = 0; i < iteratorCallSequence.length; i++ ) {
                String iteratorCall = iteratorCallSequence[i];
                if ( iteratorCall.equals( "next()" ) ) {
                    iter.next( );
                } else if ( iteratorCall.equals( "remove()" ) ) {
                    iter.remove( );
                }
            }
        }

        public CoreConnection getConnection( ) {

            return coreConnection;
        }
    }

    private class FeatureRetainAllTransaction implements Transactionable {

        private RefFeatured featured = null;

        private String featureName = null;

        private Collection elements = null;

        private FeatureRetainAllTransaction( RefFeatured aFeatured, String aFeatureName, Collection theElementsToRetain ) {

            featured = aFeatured;
            featureName = aFeatureName;
            elements = theElementsToRetain;
        }

        public void runInTransaction( ) {

            ( (Collection) featured.refGetValue( featureName ) ).retainAll( elements );
        }

        public CoreConnection getConnection( ) {

            return coreConnection;
        }
    }

    private class FeatureSetTransaction implements Transactionable {

        private RefFeatured featured = null;

        private String featureName = null;

        private int index = -1;

        private Object newValue;

        private FeatureSetTransaction( RefFeatured aFeatured, String aFeatureName, int anIndex, Object aNewValue ) {

            featured = aFeatured;
            featureName = aFeatureName;
            index = anIndex;
            newValue = aNewValue;
        }

        public void runInTransaction( ) {

            ( (List) featured.refGetValue( featureName ) ).set( index, newValue );
        }

        public CoreConnection getConnection( ) {

            return coreConnection;
        }
    }
}

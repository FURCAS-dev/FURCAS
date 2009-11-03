package com.sap.tc.moin.repository.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.commands.PartitionOperation.Operation;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor;

/**
 * This command allows to migrate a model element to one of its non-abstract
 * sub-types.<br>
 * The command creates a new element with the given sub-type. Then all
 * attributes and all links of the original element will be moved to the new
 * element. Finally the original element is deleted via
 * {@link RefObject#refDelete()}. This means that after {@link #execute()} is
 * called on this command, the original element will no longer be
 * {@link Partitionable#is___Alive() alive}.<br>
 * Note that the migrated element is a copy of the original element. This means
 * the new element will have a different {@link RefBaseObject#refMofId() MOF id}
 * .
 */
public final class MigrateToSubTypeCommand extends Command {

    private final ClassDescriptor<?, ?> classDescriptor;

    private final RefObject oldElement;

    private RefObject newElement;

    /**
     * Creates a command for migration of an element to its sub-type.
     * 
     * @param <T> Type of the original element
     * @param <U> Type of the new migrated element. Must be a sub-type of the
     * original element
     * @param connection to be used to execute the command
     * @param description Human readable description of the Command
     * @param element The element that shall be migrated
     * @param descriptor The {@link ClassDescriptor} of the sub-type
     */
    public <T extends RefObject, U extends T> MigrateToSubTypeCommand( Connection connection, String description, T element, ClassDescriptor<?, U> descriptor ) {

        super( connection, description );

        this.oldElement = element;
        this.classDescriptor = descriptor;

        // Check if descriptor is subtype
        RefClass refClassNewType = connection.getClass( classDescriptor );
        MofClass metaObjectNewType = refClassNewType.refMetaObject( );
        List<GeneralizableElement> superTypesOfNewType = metaObjectNewType.allSupertypes( );
        if ( !superTypesOfNewType.contains( element.refMetaObject( ) ) ) {
            throw new MoinIllegalArgumentException( MoinApiMessages.TYPEISNOTDIRECTSUBTYPE, classDescriptor, element.refMetaObject( ) );
        }
    }

    /**
     * Returns the newly created element that has the sub-type.
     * 
     * @return the newly created element
     */
    public RefObject getMigratedElement( ) {

        return newElement;
    }

    @Override
    public boolean canExecute( ) {

        return true;
    }

    @Override
    public void doExecute( ) {

        // Step One: Create new element with "SubType"
        newElement = ( (Partitionable) oldElement ).get___Partition( ).createElement( classDescriptor );

        // Step Two: Move all attribute values from "old" element to "new" element
        JmiHelper jmiHelper = getConnection( ).getJmiHelper( );
        List<Attribute> attributes = jmiHelper.getAttributes( (MofClass) oldElement.refMetaObject( ), true );
        for ( Attribute attribute : attributes ) {
            if ( !attribute.isDerived( ) ) {
                Object value = oldElement.refGetValue( attribute );
                if ( value instanceof Collection ) {
                    Collection newValue = (Collection) newElement.refGetValue( attribute );
                    // Collection of new element must be empty
                    assert newValue.isEmpty( );
                    Iterator iter = ( (Collection) value ).iterator( );
                    while ( iter.hasNext( ) ) {
                        Object collectionEntry = iter.next( );
                        // Element must first be disconnected from "oldElement", otherwise CompositionViolations might occur
                        iter.remove( );
                        newValue.add( collectionEntry );
                    }
                } else {
                    // Element must first be disconnected from "oldElement", otherwise CompositionViolations might occur
                    oldElement.refSetValue( attribute, null );
                    newElement.refSetValue( attribute, value );
                }
            }
        }

        // Step Three: Move all links from "old" element to "new" element
        Set<AssociationEnd> associationEnds = jmiHelper.getAssociationEnds( (MofClass) oldElement.refMetaObject( ), true );
        for ( AssociationEnd associationEnd : associationEnds ) {
            AssociationEnd otherEnd = associationEnd.otherEnd( );
            Association association = (Association) associationEnd.refImmediateComposite( );
            if ( !association.isDerived( ) ) {
                RefAssociation refAssociation = jmiHelper.getRefAssociationForAssociation( association );
                boolean elementAtFirstAssociationEnd = jmiHelper.isFirstAssociationEnd( association, associationEnd );

                // Check if element has a link
                Collection<RefObject> queryResult = refAssociation.refQuery( associationEnd, oldElement );
                if ( queryResult != null && queryResult.size( ) > 0 ) {
                    if ( associationEnd.getMultiplicity( ).isOrdered( ) ) {
                        // OldElement is located at the ordered end.
                        // This means that after migration it must appear at the same position in the collection.
                        List<RefObject> elementsAtOtherSide = new ArrayList<RefObject>( queryResult );
                        for ( RefObject elementAtOtherSide : elementsAtOtherSide ) {
                            List<RefObject> orderedElements = (List<RefObject>) refAssociation.refQuery( otherEnd, elementAtOtherSide );
                            int indexOfElement = orderedElements.indexOf( oldElement );
                            orderedElements.set( indexOfElement, newElement );
                        }
                    } else {
                        // OTHER END ORDERED or SIMPLE (no end ordered)

                        // Orderedness is preserved by using an ArrayList
                        // Remember other end's elements (queryResult is a "live collection")
                        List<RefObject> linkedElements = new ArrayList<RefObject>( queryResult );

                        // Delete all links of "oldElement" of the association
                        queryResult.clear( );

                        // Establish links to new element
                        for ( RefObject linkedElement : linkedElements ) {
                            if ( elementAtFirstAssociationEnd ) {
                                refAssociation.refAddLink( newElement, linkedElement );
                            } else {
                                refAssociation.refAddLink( linkedElement, newElement );
                            }
                        }
                    }
                }
            }
        }


        // Step Four: Delete "old" element
        oldElement.refDelete( );

    }

    @Override
    public Collection<PartitionOperation> getAffectedPartitions( ) {

        Set<PartitionOperation> affectedPartitions = new HashSet<PartitionOperation>( );

        affectedPartitions.add( new PartitionOperation( Operation.EDIT, ( (Partitionable) oldElement ).get___Partition( ).getPri( ) ) );

        // Check all links stored at the other end
        JmiHelper jmiHelper = getConnection( ).getJmiHelper( );
        Set<AssociationEnd> associationEnds = jmiHelper.getAssociationEnds( (MofClass) oldElement.refMetaObject( ), true );
        for ( AssociationEnd associationEnd : associationEnds ) {
            if ( jmiHelper.isEndStored( associationEnd.otherEnd( ) ) ) {

                // Check if element has a link
                Association association = (Association) associationEnd.refImmediateComposite( );
                RefAssociation refAssociation = jmiHelper.getRefAssociationForAssociation( association );
                Collection<RefObject> queryResult = refAssociation.refQuery( associationEnd, oldElement );
                if ( queryResult != null && queryResult.size( ) > 0 ) {
                    for ( RefObject elementAtStorageSide : queryResult ) {
                        affectedPartitions.add( new PartitionOperation( Operation.EDIT, ( (Partitionable) elementAtStorageSide ).get___Partition( ).getPri( ) ) );
                    }
                }
            }


        }

        return affectedPartitions;
    }
}

package com.sap.tc.moin.repository.core.cps.serializer;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.MoinReference;
import com.sap.tc.moin.repository.core.MriReference;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.jmi.reflect.RefStructImpl;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinIllegalNullArgumentException;
import com.sap.tc.moin.repository.runtimehost.deployment.PartitionSerializationManagerImpl;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;
import com.sap.tc.moin.repository.spi.core.cps.SpiMetamodelService;
import com.sap.tc.moin.repository.spi.ps.SpiAssociation;
import com.sap.tc.moin.repository.spi.ps.SpiClass;
import com.sap.tc.moin.repository.spi.ps.SpiStructureType;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiElement;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiLink;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiSerializerCallback;

@SuppressWarnings( "unchecked" )
public final class CoreSerializerCallbackImpl implements SpiSerializerCallback {

    private final CoreSession session;

    private final CoreModelPartition partition;

    private final SpiJmiHelper jmiHelper;

    private final List elementsStoredInPartition;

    private final List linksStoredInPartition;

    public CoreSerializerCallbackImpl( CoreSession session, CoreModelPartition partition ) {

        this.session = session;
        this.partition = partition;
        this.jmiHelper = partition.getWorkspace( ).getWorkspaceSet( ).getMoin( ).getJmiHelper( );
        // Prefetch elements and links (will be needed by the serializer anyway).
        this.elementsStoredInPartition = new ArrayList( partition.getElements( ) );
        this.linksStoredInPartition = new ArrayList( partition.getLinks( ) );
    }

    public PRI getPri( ) {

        return partition.getPri( );
    }

    public Collection<SpiClass> getUsedClasses( ) {

        if ( !elementsStoredInPartition.isEmpty( ) ) {
            Collection<SpiClass> result = new LinkedHashSet<SpiClass>( );
            for ( int i = 0, n = elementsStoredInPartition.size( ); i < n; i++ ) {
                MofClass mofClass = (MofClass) ( (RefObject) elementsStoredInPartition.get( i ) ).refMetaObject( );
                RefClass refClass = jmiHelper.getRefClassForMofClass( session, mofClass );
                result.add( (SpiClass) refClass );
            }
            return result;
        }
        return Collections.emptyList( );
    }

    public Collection<SpiAssociation> getUsedAssociations( ) {

        if ( !linksStoredInPartition.isEmpty( ) ) {
            Collection<SpiAssociation> result = new LinkedHashSet<SpiAssociation>( );
            for ( int i = 0, n = linksStoredInPartition.size( ); i < n; i++ ) {
                RefObject metaObject = ( (EndStorageLink) linksStoredInPartition.get( i ) ).getMetaObject( );
                if ( metaObject instanceof Association ) {
                    RefAssociation refAssociation = jmiHelper.getRefAssociationForAssociation( session, (Association) metaObject );
                    result.add( (SpiAssociation) refAssociation );
                }
            }
            return result;
        }
        return Collections.emptyList( );
    }

    public Collection<SpiStructureType> getUsedStructureTypes( ) {

        Collection<SpiStructureType> result = null;
        if ( !elementsStoredInPartition.isEmpty( ) ) {
            for ( int i = 0, n = elementsStoredInPartition.size( ); i < n; i++ ) {
                RefObjectImpl refObj = (RefObjectImpl) elementsStoredInPartition.get( i );
                MofClass mofClass = (MofClass) refObj.refMetaObject( );
                List<Attribute> attributes = jmiHelper.getAllStructureTypedAttributes( null /* session */, mofClass );
                for ( int j = 0, k = attributes.size( ); j < k; j++ ) {
                    Attribute attribute = attributes.get( j );
                    // Passing 'null' for the connection in the following refGetValue() call works since we are only 
                    // retrieving attribute values (and not references)!
                    Object value = refObj.refGetValue( null /* connection */, attribute );
                    if ( value instanceof RefStructImpl ) {
                        if ( result == null ) {
                            result = new LinkedHashSet<SpiStructureType>( );
                        }
                        result.addAll( getUsedStructureTypes( (RefStructImpl) value ) );
                    } else if ( value instanceof Collection ) {
                        Collection values = (Collection) value;
                        if ( !values.isEmpty( ) ) {
                            if ( result == null ) {
                                result = new LinkedHashSet<SpiStructureType>( );
                            }
                            for ( java.util.Iterator it = values.iterator( ); it.hasNext( ); ) {
                                RefStructImpl refStruct = (RefStructImpl) it.next( );
                                result.addAll( getUsedStructureTypes( refStruct ) );
                            }
                        }
                    }
                }
            }
        }
        if ( result != null ) {
            return result;
        }
        return Collections.emptyList( );
    }

    private Collection<SpiStructureType> getUsedStructureTypes( RefStructImpl refStruct ) {

        Collection<SpiStructureType> result = new LinkedHashSet<SpiStructureType>( );
        StructureType structureType = (StructureType) refStruct.get___MetaObject( );
        SpiMetamodelService metamodelService = session.getMoin( ).getCore( ).getMetamodelService( );
        result.add( (SpiStructureType) metamodelService.getSpiType( structureType ) );
        List<StructureField> structureFields = jmiHelper.getStructureFields( session, structureType, true /* includeSuperTypes */);
        for ( int l = 0, m = structureFields.size( ); l < m; l++ ) {
            StructureField field = structureFields.get( l );
            Classifier fieldType = jmiHelper.getType( null /* session */, field );
            if ( fieldType instanceof StructureType ) {
                RefStructImpl fieldValue = (RefStructImpl) refStruct.get___FieldValue( field.getName( ) );
                if ( fieldValue != null ) {
                    result.addAll( getUsedStructureTypes( fieldValue ) );
                }
            }
        }
        return result;
    }

    public Collection<SpiElement> getElements( ) {

        return elementsStoredInPartition;
    }

    public Map<SpiClass, Collection<SpiElement>> getElementsByClass( ) {

        if ( !elementsStoredInPartition.isEmpty( ) ) {
            Map result = new LinkedHashMap( );
            for ( int i = 0, n = elementsStoredInPartition.size( ); i < n; i++ ) {
                RefObject element = (RefObject) elementsStoredInPartition.get( i );
                MofClass mofClass = (MofClass) element.refMetaObject( );
                RefClass refClass = jmiHelper.getRefClassForMofClass( session, mofClass );
                List instances = (List) result.get( refClass );
                if ( instances == null ) {
                    result.put( refClass, instances = new ArrayList( ) );
                }
                instances.add( element );
            }
            return result;
        }
        return Collections.emptyMap( );
    }

    public List<SpiLink> getLinks( ) {

        return linksStoredInPartition;
    }

    public Map<SpiAssociation, List<SpiLink>> getLinksByAssociation( ) {

        return partition.getAssociationLinksStable( session );
    }

    public Object getElementAtLinkEnd( SpiLink link, int endNumber ) {

        if ( link == null ) {
            throw new MoinIllegalNullArgumentException( "link" ); //$NON-NLS-1$
        }
        if ( endNumber != 0 && endNumber != 1 ) {
            throw new MoinIllegalArgumentException( CoreCpsSerializerMessages.ENDNUMBERMUSTEITHERBE0OR1 );
        }
        EndStorageLink endStorageLink = (EndStorageLink) link;
        MoinReference ref = endStorageLink.getEnd( endNumber );
        int endNumberOfStorageEnd = endStorageLink.getEndNumberOfStorageEnd( );
        if ( endNumber == endNumberOfStorageEnd ) {
            // the element at the storageEnd is requested => we are allowed to call ref.get()
            return ( (MriReference) ref ).get( session );
        }
        // the element at the otherEnd is requested => we need to check whether it is in memory
        if ( ref.isCached( ) ) {
            CorePartitionable partitionable = ref.get( session );
            if ( partitionable.get___Partition( ).getPri( ).equals( partition.getPri( ) ) ) { // => inner-partition element
                return partitionable;
            }
            // the element is external => return the LRI
            return ref.getLri( );
        }
        LRI lri = ref.getLri( );
        CorePartitionable partitionable = session.getWorkspaceSet( ).resolveLriInMemory( session, lri );
        if ( partitionable != null ) {
            // ref is not cached, but the element is loaded in memory => check whether it belongs to our partition
            if ( partitionable.get___Partition( ).getPri( ).equals( partition.getPri( ) ) ) { // => inner-partition element
                return partitionable;
            }
        }
        return lri;
    }

    public SpiElement getElement( LRI lriOfElement ) {

        return (SpiElement) session.getElement( lriOfElement );
    }

    public SpiElement getElement( MRI mriOfElement ) {

        return (SpiElement) session.getElement( mriOfElement );
    }

    public void callOtherSerializer( String serializationId, OutputStream output, SpiSerializerCallback callback ) throws IOException {

        ( (PartitionSerializationManagerImpl) this.session.getMoin( ).getPartitionSerializationManager( ) ).serialize( serializationId, output, callback );
    }
}
package com.sap.tc.moin.repository.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.mmi.model.AggregationKind;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.model.TypedElement;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefEnum;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefStruct;

import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer;
import com.sap.tc.moin.repository.shared.util.Utilities;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;
import com.sap.tc.moin.repository.spi.core.Wrapper;

@SuppressWarnings( "unchecked" )
public class JmiHelperWrapper extends AbstractConnectionAwareWrapper<SpiJmiHelper> implements JmiHelper {

    private final SpiJmiHelper jmiHelper;

    public JmiHelperWrapper( CoreConnection connection, SynchronizationManager synchronizationManager ) {

        super( connection, synchronizationManager );
        this.jmiHelper = connection.getCoreJmiHelper( );
    }

    public SpiJmiHelper unwrap( ) {

        return this.jmiHelper;
    }

    public ModelElement findElementByQualifiedName( List<String> qnameToSearch, MofPackage mofPackage ) {

        MofPackage unwrapped = ( (Wrapper<MofPackage>) mofPackage ).unwrap( );
        boolean needsReadLock = needsReadLock( unwrapped );
        if ( needsReadLock ) {
            this.synchronizationManager.acquireReadLock( );
        }
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.connection.getWrapperForJmiObject( this.jmiHelper.findElementByQualifiedName( this.connection, qnameToSearch, unwrapped ) );
        } finally {
            if ( needsReadLock ) {
                this.synchronizationManager.releaseReadLock( );
            }
        }
    }

    public ModelElement findElementByQualifiedName( List<String> qualifiedNameToSearch, RefPackage outermostPackage ) {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.connection.getWrapperForJmiObject( this.jmiHelper.findElementByQualifiedName( this.connection.getSession( ), qualifiedNameToSearch, ( (Wrapper<RefPackage>) outermostPackage ).unwrap( ) ) );
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }
    }

    public RefPackage findRefPackageByQualifiedName( List<String> qualifiedNameToSearch, RefPackage outermostPackage ) {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.connection.getWrapperForJmiObject( this.jmiHelper.findRefPackageByQualifiedName( qualifiedNameToSearch, ( (Wrapper<RefPackage>) outermostPackage ).unwrap( ) ) );
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }
    }

    public Collection<PRI> getAffectedPartitionsForRefDelete( RefObject rootElement ) {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.jmiHelper.getAffectedPartitionsForRefDelete( this.connection.getSession( ), ( (Wrapper<RefObject>) rootElement ).unwrap( ) );
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }
    }

    public Collection<GeneralizableElement> getAllSubtypes( GeneralizableElement generalizableElement ) {

        GeneralizableElement unwrapped = ( (Wrapper<GeneralizableElement>) generalizableElement ).unwrap( );
        boolean needsReadLock = needsReadLock( unwrapped );
        if ( needsReadLock ) {
            this.synchronizationManager.acquireReadLock( );
        }
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            Collection<GeneralizableElement> allSubtypes = this.jmiHelper.getAllSubtypes( this.connection, unwrapped );
            Collection<GeneralizableElement> result = new HashSet<GeneralizableElement>( Utilities.calcInitialCapacity( allSubtypes.size( ) ) );
            for ( GeneralizableElement subtype : allSubtypes ) {
                result.add( this.connection.getWrapperForJmiObject( subtype ) );
            }
            return result;
        } finally {
            if ( needsReadLock ) {
                this.synchronizationManager.releaseReadLock( );
            }
        }
    }

    public List<GeneralizableElement> getAllSupertypes( GeneralizableElement generalizableElement ) {

        GeneralizableElement unwrapped = ( (Wrapper<GeneralizableElement>) generalizableElement ).unwrap( );
        boolean needsReadLock = needsReadLock( unwrapped );
        if ( needsReadLock ) {
            this.synchronizationManager.acquireReadLock( );
        }
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            List<GeneralizableElement> allSupertypes = this.jmiHelper.getAllSupertypes( this.connection.getSession( ), unwrapped );
            List<GeneralizableElement> result = new ArrayList<GeneralizableElement>( allSupertypes.size( ) );
            for ( int i = 0, n = allSupertypes.size( ); i < n; i++ ) {
                result.add( this.connection.getWrapperForJmiObject( allSupertypes.get( i ) ) );
            }
            return result;
        } finally {
            if ( needsReadLock ) {
                this.synchronizationManager.releaseReadLock( );
            }
        }
    }

    public List<AssociationEnd> getAssociationEnds( Association a ) {

        Association unwrapped = ( (Wrapper<Association>) a ).unwrap( );
        boolean needsReadLock = needsReadLock( unwrapped );
        if ( needsReadLock ) {
            this.synchronizationManager.acquireReadLock( );
        }
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            List<AssociationEnd> associationEnds = this.jmiHelper.getAssociationEnds( this.connection.getSession( ), unwrapped );
            List<AssociationEnd> result = new ArrayList<AssociationEnd>( 2 );
            result.add( this.connection.getWrapperForJmiObject( associationEnds.get( 0 ) ) );
            result.add( this.connection.getWrapperForJmiObject( associationEnds.get( 1 ) ) );
            return result;
        } finally {
            if ( needsReadLock ) {
                this.synchronizationManager.releaseReadLock( );
            }
        }
    }

    public Set<AssociationEnd> getAssociationEnds( Classifier classifier, boolean includeSupertypes ) {

        Classifier unwrapped = ( (Wrapper<Classifier>) classifier ).unwrap( );
        boolean needsReadLock = needsReadLock( unwrapped );
        if ( needsReadLock ) {
            this.synchronizationManager.acquireReadLock( );
        }
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            Set<AssociationEnd> associationEnds = this.jmiHelper.getAssociationEnds( this.connection.getSession( ), unwrapped, includeSupertypes );
            Set<AssociationEnd> result = new LinkedHashSet<AssociationEnd>( Utilities.calcInitialCapacity( associationEnds.size( ) ) );
            for ( AssociationEnd end : associationEnds ) {
                result.add( this.connection.getWrapperForJmiObject( end ) );
            }
            return result;
        } finally {
            if ( needsReadLock ) {
                this.synchronizationManager.releaseReadLock( );
            }
        }
    }

    public Attribute getAttributeByName( MofClass mofClass, String attributeName, boolean includeSupertypes ) {

        MofClass unwrapped = ( (Wrapper<MofClass>) mofClass ).unwrap( );
        boolean needsReadLock = needsReadLock( unwrapped );
        if ( needsReadLock ) {
            this.synchronizationManager.acquireReadLock( );
        }
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.connection.getWrapperForJmiObject( this.jmiHelper.getAttributeByName( this.connection, unwrapped, attributeName, includeSupertypes ) );
        } finally {
            if ( needsReadLock ) {
                this.synchronizationManager.releaseReadLock( );
            }
        }
    }

    public List<Attribute> getAttributes( MofClass mofClass, boolean includeSupertypes ) {

        MofClass unwrapped = ( (Wrapper<MofClass>) mofClass ).unwrap( );
        boolean needsReadLock = needsReadLock( unwrapped );
        if ( needsReadLock ) {
            this.synchronizationManager.acquireReadLock( );
        }
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            List<Attribute> attributes = this.jmiHelper.getAttributes( this.connection.getSession( ), unwrapped, includeSupertypes );
            List<Attribute> result = new ArrayList<Attribute>( attributes.size( ) );
            for ( int i = 0, n = attributes.size( ); i < n; i++ ) {
                result.add( this.connection.getWrapperForJmiObject( attributes.get( i ) ) );
            }
            return result;
        } finally {
            if ( needsReadLock ) {
                this.synchronizationManager.releaseReadLock( );
            }
        }
    }

    public Map<Attribute, Object> getAttributesWithValues( RefObject refObject, boolean includeSupertypes ) {

        RefObject unwrapped = ( (Wrapper<RefObject>) refObject ).unwrap( );
        boolean needsReadLock = needsReadLock( unwrapped );
        if ( needsReadLock ) {
            this.synchronizationManager.acquireReadLock( );
        }
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            Map<Attribute, Object> attributesWithValues = this.jmiHelper.getAttributesWithValues( this.connection, unwrapped, includeSupertypes );
            Map<Attribute, Object> result = new LinkedHashMap<Attribute, Object>( Utilities.calcInitialCapacity( attributesWithValues.size( ) ) );
            for ( Entry<Attribute, Object> entry : attributesWithValues.entrySet( ) ) {
                Attribute key = this.connection.getWrapperForJmiObject( entry.getKey( ) );
                Object value = entry.getValue( );
                if ( this.jmiHelper.getType( this.connection.getSession( ), entry.getKey( ) ) instanceof MofClass ) {
                    if ( value instanceof RefBaseObject ) {
                        value = this.connection.getWrapperForJmiObject( (RefBaseObject) value );
                    } else if ( value instanceof Collection ) {
                        int size = 0;
                        Iterator iterator;
                        if ( value instanceof JmiList ) {
                            JmiList jmiList = (JmiList) value;
                            size = jmiList.size( this.connection.getSession( ) );
                            iterator = jmiList.iteratorReadOnly( this.connection.getSession( ) );
                        } else {
                            Collection collection = (Collection) value;
                            size = collection.size( );
                            iterator = collection.iterator( );
                        }
                        Collection newValue = new ArrayList( size );
                        for ( Iterator it = iterator; it.hasNext( ); ) {
                            RefBaseObject rbo = (RefBaseObject) it.next( );
                            newValue.add( this.connection.getWrapperForJmiObject( rbo ) );
                        }
                        value = newValue;
                    }
                }
                result.put( key, value );
            }
            return result;
        } finally {
            if ( needsReadLock ) {
                this.synchronizationManager.releaseReadLock( );
            }
        }
    }

    public AssociationEnd getCompositeAssociationEnd( Association a ) {

        Association unwrapped = ( (Wrapper<Association>) a ).unwrap( );
        boolean needsReadLock = needsReadLock( unwrapped );
        if ( needsReadLock ) {
            this.synchronizationManager.acquireReadLock( );
        }
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.connection.getWrapperForJmiObject( this.jmiHelper.getCompositeAssociationEnd( this.connection, unwrapped ) );
        } finally {
            if ( needsReadLock ) {
                this.synchronizationManager.releaseReadLock( );
            }
        }
    }

    public Collection<Association> getCompositeAssociations( MofClass parentClass, MofClass childClass ) {

        MofClass unwrappedParent = ( (Wrapper<MofClass>) parentClass ).unwrap( );
        MofClass unwrappedChild = ( (Wrapper<MofClass>) childClass ).unwrap( );
        boolean needsReadLock = needsReadLock( unwrappedParent ) || needsReadLock( unwrappedChild );
        if ( needsReadLock ) {
            this.synchronizationManager.acquireReadLock( );
        }
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            Collection<Association> compositeAssociations = this.jmiHelper.getCompositeAssociations( this.connection, unwrappedParent, unwrappedChild );
            Collection<Association> result = new HashSet<Association>( Utilities.calcInitialCapacity( compositeAssociations.size( ) ) );
            for ( Association assoc : compositeAssociations ) {
                result.add( this.connection.getWrapperForJmiObject( assoc ) );
            }
            return result;
        } finally {
            if ( needsReadLock ) {
                this.synchronizationManager.releaseReadLock( );
            }
        }
    }

    public Collection<RefObject> getCompositeChildren( RefObject rootElement, boolean recursively ) {

        RefObject unwrapped = ( (Wrapper<RefObject>) rootElement ).unwrap( );
        boolean needsReadLock = needsReadLock( unwrapped );
        if ( needsReadLock ) {
            this.synchronizationManager.acquireReadLock( );
        }
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            Collection<RefObject> compositeChildren = jmiHelper.getCompositeChildren( connection.getSession( ), unwrapped, recursively );
            Collection<RefObject> result = new ArrayList<RefObject>( compositeChildren.size( ) );
            for ( RefObject child : compositeChildren ) {
                result.add( connection.getWrapperForJmiObject( child ) );
            }
            return result;
        } finally {
            if ( needsReadLock ) {
                this.synchronizationManager.releaseReadLock( );
            }
        }
    }

    public List<RefEnum> getEnumerationConstants( EnumerationType enumerationType ) {

        EnumerationType unwrapped = ( (Wrapper<EnumerationType>) enumerationType ).unwrap( );
        boolean needsReadLock = needsReadLock( unwrapped );
        if ( needsReadLock ) {
            this.synchronizationManager.acquireReadLock( );
        }
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.jmiHelper.getEnumerationConstants( this.connection.getSession( ), unwrapped );
        } finally {
            if ( needsReadLock ) {
                this.synchronizationManager.releaseReadLock( );
            }
        }
    }

    public Class<?> getJavaPrimitiveOrWrapperType( StructuralFeature structuralFeature ) {

        StructuralFeature unwrapped = ( (Wrapper<StructuralFeature>) structuralFeature ).unwrap( );
        boolean needsReadLock = needsReadLock( unwrapped );
        if ( needsReadLock ) {
            this.synchronizationManager.acquireReadLock( );
        }
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.jmiHelper.getJavaPrimitiveOrWrapperType( this.connection, unwrapped );
        } finally {
            if ( needsReadLock ) {
                this.synchronizationManager.releaseReadLock( );
            }
        }
    }

    public Classifier getNonAliasType( Classifier type ) {

        Classifier unwrapped = ( (Wrapper<Classifier>) type ).unwrap( );
        boolean needsReadLock = needsReadLock( unwrapped );
        if ( needsReadLock ) {
            this.synchronizationManager.acquireReadLock( );
        }
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.connection.getWrapperForJmiObject( this.jmiHelper.getNonAliasType( this.connection.getSession( ), unwrapped ) );
        } finally {
            if ( needsReadLock ) {
                this.synchronizationManager.releaseReadLock( );
            }
        }
    }

    public Classifier getNonAliasType( TypedElement typedElement ) {

        TypedElement unwrapped = ( (Wrapper<TypedElement>) typedElement ).unwrap( );
        boolean needsReadLock = needsReadLock( unwrapped );
        if ( needsReadLock ) {
            this.synchronizationManager.acquireReadLock( );
        }
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.connection.getWrapperForJmiObject( this.jmiHelper.getNonAliasType( this.connection.getSession( ), unwrapped ) );
        } finally {
            if ( needsReadLock ) {
                this.synchronizationManager.releaseReadLock( );
            }
        }
    }

    public RefAssociation getRefAssociationForAssociation( Association association ) {

        Association unwrapped = ( (Wrapper<Association>) association ).unwrap( );
        boolean needsReadLock = needsReadLock( unwrapped );
        if ( needsReadLock ) {
            this.synchronizationManager.acquireReadLock( );
        }
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.connection.getWrapperForJmiObject( this.jmiHelper.getRefAssociationForAssociation( this.connection.getSession( ), unwrapped ) );
        } finally {
            if ( needsReadLock ) {
                this.synchronizationManager.releaseReadLock( );
            }
        }
    }

    public RefClass getRefClassForMofClass( MofClass mofClass ) {

        MofClass unwrapped = ( (Wrapper<MofClass>) mofClass ).unwrap( );
        boolean needsReadLock = needsReadLock( unwrapped );
        if ( needsReadLock ) {
            this.synchronizationManager.acquireReadLock( );
        }
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.connection.getWrapperForJmiObject( this.jmiHelper.getRefClassForMofClass( this.connection.getSession( ), unwrapped ) );
        } finally {
            if ( needsReadLock ) {
                this.synchronizationManager.releaseReadLock( );
            }
        }
    }

    public <T extends RefStruct> T cloneStruct( T structToClone, StructureFieldContainer<? extends T> containerForFieldsToSet ) {

        return this.jmiHelper.cloneStruct( this.connection, structToClone, containerForFieldsToSet );
    }

    public RefPackage getRefPackageForMofPackage( MofPackage mofPackage ) {

        MofPackage unwrapped = ( (Wrapper<MofPackage>) mofPackage ).unwrap( );
        boolean needsReadLock = needsReadLock( unwrapped );
        if ( needsReadLock ) {
            this.synchronizationManager.acquireReadLock( );
        }
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.connection.getWrapperForJmiObject( this.jmiHelper.getRefPackageForMofPackage( this.connection.getSession( ), unwrapped ) );
        } finally {
            if ( needsReadLock ) {
                this.synchronizationManager.releaseReadLock( );
            }
        }
    }

    public Reference getReferenceByName( MofClass mofClass, String referenceName, boolean includeSupertypes ) {

        MofClass unwrapped = ( (Wrapper<MofClass>) mofClass ).unwrap( );
        boolean needsReadLock = needsReadLock( unwrapped );
        if ( needsReadLock ) {
            this.synchronizationManager.acquireReadLock( );
        }
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.connection.getWrapperForJmiObject( this.jmiHelper.getReferenceByName( this.connection, unwrapped, referenceName, includeSupertypes ) );
        } finally {
            if ( needsReadLock ) {
                this.synchronizationManager.releaseReadLock( );
            }
        }
    }

    public Collection<Reference> getReferences( AssociationEnd ae ) {

        AssociationEnd unwrapped = ( (Wrapper<AssociationEnd>) ae ).unwrap( );
        boolean needsReadLock = needsReadLock( unwrapped );
        if ( needsReadLock ) {
            this.synchronizationManager.acquireReadLock( );
        }
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return (Collection<Reference>) this.connection.getWrapperForJmiList( (JmiList) this.jmiHelper.getReferences( this.connection.getSession( ), unwrapped ) );
        } finally {
            if ( needsReadLock ) {
                this.synchronizationManager.releaseReadLock( );
            }
        }
    }

    public List<Reference> getReferences( MofClass mofClass, AggregationKind aggregationKind, boolean includeSupertypes ) {

        MofClass unwrapped = ( (Wrapper<MofClass>) mofClass ).unwrap( );
        boolean needsReadLock = needsReadLock( unwrapped );
        if ( needsReadLock ) {
            this.synchronizationManager.acquireReadLock( );
        }
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            List<Reference> references = this.jmiHelper.getReferences( this.connection.getSession( ), unwrapped, aggregationKind, includeSupertypes );
            List<Reference> result = new ArrayList<Reference>( references.size( ) );
            for ( int i = 0, n = references.size( ); i < n; i++ ) {
                result.add( this.connection.getWrapperForJmiObject( references.get( i ) ) );
            }
            return result;
        } finally {
            if ( needsReadLock ) {
                this.synchronizationManager.releaseReadLock( );
            }
        }
    }

    public Collection<RefObject> getCompositeChildrenStable( RefObject rootElement, boolean recursively ) {

        RefObject unwrapped = ( (Wrapper<RefObject>) rootElement ).unwrap( );
        boolean needsReadLock = needsReadLock( unwrapped );
        if ( needsReadLock ) {
            this.synchronizationManager.acquireReadLock( );
        }
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            List<RefObject> compositeChildren = this.jmiHelper.getCompositeChildrenStable( this.connection.getSession( ), unwrapped, recursively );
            Collection<RefObject> result = new ArrayList<RefObject>( compositeChildren.size( ) );
            for ( int i = 0, n = compositeChildren.size( ); i < n; i++ ) {
                result.add( this.connection.getWrapperForJmiObject( compositeChildren.get( i ) ) );
            }
            return result;

        } finally {
            if ( needsReadLock ) {
                this.synchronizationManager.releaseReadLock( );
            }
        }

    }

    public Collection<GeneralizableElement> getSubTypes( GeneralizableElement generalizableElement ) {

        GeneralizableElement unwrapped = ( (Wrapper<GeneralizableElement>) generalizableElement ).unwrap( );
        boolean needsReadLock = needsReadLock( unwrapped );
        if ( needsReadLock ) {
            this.synchronizationManager.acquireReadLock( );
        }
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return (Collection<GeneralizableElement>) this.connection.getWrapperForJmiList( (JmiList) this.jmiHelper.getSubTypes( this.connection, unwrapped ) );
        } finally {
            if ( needsReadLock ) {
                this.synchronizationManager.releaseReadLock( );
            }
        }
    }

    public boolean isEndStored( int endNumber, Association association ) {

        Association unwrapped = ( (Wrapper<Association>) association ).unwrap( );
        boolean needsReadLock = needsReadLock( unwrapped );
        if ( needsReadLock ) {
            this.synchronizationManager.acquireReadLock( );
        }
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.jmiHelper.isEndStored( this.connection.getSession( ), endNumber, unwrapped );
        } finally {
            if ( needsReadLock ) {
                this.synchronizationManager.releaseReadLock( );
            }
        }
    }

    public boolean isEndStored( AssociationEnd ae ) {

        AssociationEnd unwrapped = ( (Wrapper<AssociationEnd>) ae ).unwrap( );
        boolean needsReadLock = needsReadLock( unwrapped );
        if ( needsReadLock ) {
            this.synchronizationManager.acquireReadLock( );
        }
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.jmiHelper.isEndStored( this.connection.getSession( ), unwrapped );
        } finally {
            if ( needsReadLock ) {
                this.synchronizationManager.releaseReadLock( );
            }
        }
    }

    public boolean isFirstAssociationEnd( Association a, AssociationEnd ae ) {

        Association unwrappedAssociation = ( (Wrapper<Association>) a ).unwrap( );
        AssociationEnd unwrappedAssociationEnd = ( (Wrapper<AssociationEnd>) ae ).unwrap( );
        boolean needsReadLock = needsReadLock( unwrappedAssociation ) || needsReadLock( unwrappedAssociationEnd );
        if ( needsReadLock ) {
            this.synchronizationManager.acquireReadLock( );
        }
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.jmiHelper.isFirstAssociationEnd( this.connection, unwrappedAssociation, unwrappedAssociationEnd );
        } finally {
            if ( needsReadLock ) {
                this.synchronizationManager.releaseReadLock( );
            }
        }
    }

    private boolean needsReadLock( RefBaseObject refBaseObject ) {

        return !( (CorePartitionable) refBaseObject ).get___Workspace( ).isMetamodelWorkspace( );
    }
}
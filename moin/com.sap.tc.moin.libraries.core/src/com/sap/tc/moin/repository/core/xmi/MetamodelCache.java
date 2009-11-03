package com.sap.tc.moin.repository.core.xmi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.ScopeKindEnum;
import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.model.TypedElement;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.AttributeImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.AttributeInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ClassifierInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.EnumerationTypeInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ModelElementInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.MofClassInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.NamespaceInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ReferenceInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.StructuralFeatureInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.StructureFieldInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.StructureTypeInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.TypedElementInternal;
import com.sap.tc.moin.repository.mmi.reflect.RefEnum;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.jmi.util.JmiHelperImpl;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;

/**
 * This class provides a cache for M2-level information. It is used by both
 * XmiWriter and XmiReader to have quick access to the metamodel of the
 * currently processed model.
 * <p>
 * Note that this cache stores instances of
 * {@link com.sap.tc.moin.repository.Partitionable}, which is in general a
 * dangerous thing to do because the owning workspace could decide to evict the
 * instances, resulting in invalid Java objects inside this cache. In general it
 * is safer to store instances of
 * {@link com.sap.tc.moin.repository.core.MoinReference} instead. However, as
 * long as XmiWriter and XmiReader synchronize their operations on their owning
 * {@link com.sap.tc.moin.repository.core.Workspace} instance, and the
 * MetamodelCache is re-created before every operation, cache eviction should
 * not a problem, because
 * {@link com.sap.tc.moin.repository.core.Workspace#evictInstance(CorePartitionable)}
 * is synchronized as well.
 */
public class MetamodelCache {

    /**
     * Cache for all non-derived instance-level attributes of a MofClass and all
     * supertypes thereof.
     */
    private Map<MofClassInternal, List<AttributeInternal>> instanceAttributes;

    /**
     * Cache for all non-derived instance-level attributes of a MofClass and all
     * supertypes thereof.
     */
    private Map<MofClassInternal, Map<String, AttributeInternal>> instanceAttributesAsMap;

    /**
     * Cache for all non-derived classifier-level attributes of a MofClass and
     * all supertypes thereof.
     */
    private Map<MofClassInternal, List<AttributeInternal>> classAttributes;

    /**
     * Cache for all references of a MofClass and all supertypes thereof. Only
     * references referencing an end of a non-derived association are cached.
     */
    private Map<MofClassInternal, List<ReferenceInternal>> references;

    /**
     * Cache for all association ends that have as their type a MofClass or any
     * supertype thereof.
     */
    private Map<MofClassInternal, List<AssociationEndInternal>> associationEnds;

    /**
     * Cache for all {@link JmiHelperImpl#isEndStored(AssociationEnd) stored}
     * association ends that have as their type a MofClass or any supertype
     * thereof.
     */
    private Map<MofClassInternal, List<AssociationEndInternal>> storedAssociationEndsForModelPartitions;

    /**
     * Cache for all stored association ends according to standard XMI (i.e. a
     * MOF reference exists) that have as their type a MofClass or any supertype
     * thereof.
     */
    private Map<MofClassInternal, List<AssociationEndInternal>> storedAssociationEndsForStandardXmi;

    /**
     * For each StructureType, caches the list of contained StructureField
     * instances.
     */
    private Map<StructureTypeInternal, List<StructureFieldInternal>> structureFields;

    /**
     * Cache for <em>org.omg.xmi.enumerationUnprefix</em> tags per
     * EnumerationType. The prefixes contained in these tags have to be
     * <em>removed</em> from each enum literal before serialization.
     */
    private Map<EnumerationTypeInternal, String /* prefix */> enumTypeUnPrefixes;

    /**
     * Cache for the RefEnum instances of an EnumerationType .
     */
    private Map<EnumerationTypeInternal, Map<String /* label */, RefEnum>> enumerationConstants;

    private Map<ReferenceInternal, AssociationEndInternal> referencedEnds;

    private Map<ReferenceInternal, AssociationEndInternal> exposedEnds;

    private Map<AssociationEndInternal, Integer> associationEndNumbers;

    private Map<ModelElementInternal, NamespaceInternal> containers;

    private Map<StructuralFeatureInternal, Boolean> isMultiValued;

    private SpiJmiHelper jmiHelper;

    public MetamodelCache( SpiJmiHelper jmiHelper ) {

        this.jmiHelper = jmiHelper;
    }

    /**
     * For a given MofClass, returns the list of all non-derived instance-level
     * attributes, including inherited ones.
     */
    public List<AttributeInternal> getInstanceAttributes( CoreSession session, MofClassInternal mofClass ) {

        if ( instanceAttributes == null ) {
            instanceAttributes = new IdentityHashMap<MofClassInternal, List<AttributeInternal>>( 256 );
        }
        List<AttributeInternal> attributes = instanceAttributes.get( mofClass );
        if ( attributes == null ) {
            List<Attribute> allAttributes = this.jmiHelper.getAttributes( session, (MofClass) mofClass, true );
            for ( int i = 0, n = allAttributes.size( ); i < n; i++ ) {
                Attribute attr = allAttributes.get( i );
                if ( attr.getScope( ) == ScopeKindEnum.INSTANCE_LEVEL && !attr.isDerived( ) ) {
                    if ( attributes == null ) {
                        attributes = new ArrayList<AttributeInternal>( );
                    }
                    attributes.add( (AttributeInternal) attr );
                }
            }
            if ( attributes == null ) {
                attributes = Collections.emptyList( );
            } else {
                ( (ArrayList<AttributeInternal>) attributes ).trimToSize( );
            }
            instanceAttributes.put( mofClass, attributes );
        }
        return attributes;
    }

    /**
     * For a given MofClass, returns the requested instance-level attribute, or
     * null if the attribute is not found.
     */
    public AttributeInternal getInstanceAttribute( CoreSession session, MofClassInternal mofClass, String attributeName ) {

        if ( instanceAttributesAsMap == null ) {
            instanceAttributesAsMap = new IdentityHashMap<MofClassInternal, Map<String, AttributeInternal>>( );
        }
        Map<String, AttributeInternal> attributes = instanceAttributesAsMap.get( mofClass );
        if ( attributes == null ) {
            attributes = new HashMap<String, AttributeInternal>( );
            Map<String, ModelElement> containedElements = jmiHelper.getAllContentMap( session, (Namespace) mofClass );
            for ( Entry<String, ModelElement> entry : containedElements.entrySet( ) ) {
                ModelElement element = entry.getValue( );
                if ( element instanceof Attribute ) {
                    AttributeImpl attr = (AttributeImpl) element;
                    if ( !attr.isDerived( ) && attr.getScope( ).equals( ScopeKindEnum.INSTANCE_LEVEL ) ) {
                        attributes.put( entry.getKey( ), attr );
                    }
                }
            }
            instanceAttributesAsMap.put( mofClass, attributes );
        }
        return attributes.get( attributeName );
    }

    /**
     * For a given MofClass, returns the list of all non-derived
     * classifier-level attributes, including inherited ones.
     */
    public List<AttributeInternal> getClassAttributes( CoreSession session, MofClassInternal mofClass ) {

        if ( classAttributes == null ) {
            classAttributes = new IdentityHashMap<MofClassInternal, List<AttributeInternal>>( 256 );
        }
        List<AttributeInternal> attributes = classAttributes.get( mofClass );
        if ( attributes == null ) {
            List<Attribute> allAttributes = this.jmiHelper.getAttributes( session, (MofClass) mofClass, true );
            for ( int i = 0, n = allAttributes.size( ); i < n; i++ ) {
                Attribute attr = allAttributes.get( i );
                if ( attr.getScope( ) == ScopeKindEnum.CLASSIFIER_LEVEL && !attr.isDerived( ) ) {
                    if ( attributes == null ) {
                        attributes = new ArrayList<AttributeInternal>( );
                    }
                    attributes.add( (AttributeInternal) attr );
                }
            }
            if ( attributes == null ) {
                attributes = Collections.emptyList( );
            } else {
                ( (ArrayList<AttributeInternal>) attributes ).trimToSize( );
            }
            classAttributes.put( mofClass, attributes );
        }
        return attributes;
    }

    /**
     * For a given MofClass, returns the list of all references, including
     * inherited ones. Only references referencing an end of a non-derived
     * association are returned.
     */
    public List<ReferenceInternal> getReferences( CoreSession session, MofClassInternal mofClass ) {

        if ( references == null ) {
            references = new IdentityHashMap<MofClassInternal, List<ReferenceInternal>>( 256 );
        }
        List<ReferenceInternal> refs = references.get( mofClass );
        if ( refs == null ) {
            List<Reference> allReferences = this.jmiHelper.getReferences( session, (MofClass) mofClass, true );
            for ( int i = 0, n = allReferences.size( ); i < n; i++ ) {
                Reference ref = allReferences.get( i );
                //FIXME HACK!!! 
                CoreConnection connection = session != null ? session.getConnections( ).iterator( ).next( ) : null;
                Association assoc = (Association) ( (AssociationEndInternal) ( (ReferenceInternal) ref ).getReferencedEnd( connection ) ).getContainer( connection );
                if ( !assoc.isDerived( ) ) {
                    if ( refs == null ) {
                        refs = new ArrayList<ReferenceInternal>( );
                    }
                    refs.add( (ReferenceInternal) ref );
                }
            }
            if ( refs == null ) {
                refs = Collections.emptyList( );
            } else {
                ( (ArrayList<ReferenceInternal>) refs ).trimToSize( );
            }
            references.put( mofClass, refs );
        }
        return refs;
    }

    /**
     * For a given MofClass, returns the structural feature with the given name.
     * Inherited features are included in the search.
     */
    public StructuralFeatureInternal getStructuralFeature( CoreSession session, MofClassInternal mofClass, String name ) {

        Map<String, ModelElement> allContents = this.jmiHelper.getAllContentMap( session, (Namespace) mofClass );
        ModelElement modelElement = allContents.get( name );
        if ( modelElement instanceof StructuralFeatureInternal ) {
            return (StructuralFeatureInternal) modelElement;
        }
        return null;
    }

    /**
     * For a given MofClass, returns the list of all association ends of that
     * type or any supertype thereof.
     */
    public List<AssociationEndInternal> getAssociationEnds( CoreSession session, MofClassInternal mofClass ) {

        if ( associationEnds == null ) {
            associationEnds = new IdentityHashMap<MofClassInternal, List<AssociationEndInternal>>( 256 );
        }
        List<AssociationEndInternal> ends = associationEnds.get( mofClass );
        if ( ends == null ) {
            Set<AssociationEnd> assocEnds = this.jmiHelper.getAssociationEnds( session, (Classifier) mofClass, true /* includeSupertypes */);
            ends = new ArrayList<AssociationEndInternal>( assocEnds.size( ) );
            for ( AssociationEnd associationEnd : assocEnds ) {
                ends.add( (AssociationEndInternal) associationEnd );
            }
            associationEnds.put( mofClass, ends );
        }
        return ends;
    }

    /**
     * For a given MofClass, returns the list of all stored association ends of
     * that type or any supertype thereof. Since the definition of storage is
     * different in standard XMI and model partitions, the
     * <code>partitionMode</code> parameter controls which result is requested.
     * 
     * @param connection
     */
    public List<AssociationEndInternal> getStoredAssociationEnds( CoreSession session, MofClassInternal mofClass, boolean partitionMode ) {

        List<AssociationEndInternal> ends = null;
        if ( partitionMode ) {
            if ( storedAssociationEndsForModelPartitions == null ) {
                storedAssociationEndsForModelPartitions = new IdentityHashMap<MofClassInternal, List<AssociationEndInternal>>( 256 );
            }
            ends = storedAssociationEndsForModelPartitions.get( mofClass );
            if ( ends == null ) {
                Set<AssociationEnd> storedAssociationEnds = this.jmiHelper.getStoredAssociationEnds( session, (Classifier) mofClass, true /* includeSupertypes */);
                ends = new ArrayList<AssociationEndInternal>( storedAssociationEnds.size( ) );
                for ( AssociationEnd associationEnd : storedAssociationEnds ) {
                    ends.add( (AssociationEndInternal) associationEnd );
                }
                storedAssociationEndsForModelPartitions.put( mofClass, ends );
            }
        } else {
            if ( storedAssociationEndsForStandardXmi == null ) {
                storedAssociationEndsForStandardXmi = new IdentityHashMap<MofClassInternal, List<AssociationEndInternal>>( 256 );
            }
            ends = storedAssociationEndsForStandardXmi.get( mofClass );
            if ( ends == null ) {
                ends = new ArrayList<AssociationEndInternal>( );
                Set<AssociationEnd> associationEnds = this.jmiHelper.getAssociationEnds( session, (Classifier) mofClass, true /* includeSupertypes */);
                List<AssociationEndInternal> allEnds = new ArrayList<AssociationEndInternal>( associationEnds.size( ) );
                for ( AssociationEnd associationEnd : associationEnds ) {
                    ends.add( (AssociationEndInternal) associationEnd );
                }
                for ( AssociationEndInternal end : allEnds ) {
                    Collection<Reference> references = this.jmiHelper.getReferences( session, (AssociationEnd) end );
                    JmiList refs = (JmiList) references;
                    if ( refs.size( session ) > 0 ) {
                        ends.add( end );
                    }
                }
                storedAssociationEndsForStandardXmi.put( mofClass, ends );
            }
        }
        return ends;
    }

    /**
     * Returns list of all StructureField instances contained by the given
     * StructureType.
     */
    public List<StructureFieldInternal> getStructureFields( CoreSession session, StructureTypeInternal type ) {

        if ( structureFields == null ) {
            structureFields = new IdentityHashMap<StructureTypeInternal, List<StructureFieldInternal>>( );
        }
        List<StructureFieldInternal> fields = structureFields.get( type );
        if ( fields == null ) {
            List<StructureField> sfields = this.jmiHelper.getStructureFields( session, (StructureType) type, true /* includeSupertypes */);
            fields = new ArrayList<StructureFieldInternal>( sfields.size( ) );
            for ( StructureField structureField : sfields ) {
                fields.add( (StructureFieldInternal) structureField );
            }
            structureFields.put( type, fields );
        }
        return fields;
    }

    /**
     * Returns the enumeration prefix given by the
     * <em>org.omg.xmi.enumerationUnprefix</em> tag attached to the given
     * EnumerationType, or the empty String if no such tag is present. See page
     * 3-18 of XMI 1.2 specification.
     */
    public String getEnumerationTypeUnPrefix( CoreSession session, EnumerationTypeInternal type ) {

        if ( enumTypeUnPrefixes == null ) {
            enumTypeUnPrefixes = new IdentityHashMap<EnumerationTypeInternal, String>( );
        }
        String prefix = enumTypeUnPrefixes.get( type );
        if ( prefix != null ) {
            return prefix;
        }
        prefix = this.jmiHelper.getTagValue( session, (ModelElement) type, XmiConstants.TAGID_XMI_ENUMERATION_UNPREFIX );
        if ( prefix == null ) {
            prefix = ""; //$NON-NLS-1$
        }
        enumTypeUnPrefixes.put( type, prefix );
        return prefix;
    }

    public ClassifierInternal getType( CoreSession session, TypedElementInternal typedElement ) {

        return (ClassifierInternal) this.jmiHelper.getType( session, (TypedElement) typedElement );
    }

    @SuppressWarnings( "unchecked" )
    public RefEnum getEnumerationValue( CoreSession session, EnumerationTypeInternal type, String label ) {

        // Check for an enumeration label prefix that needs to be prepended.
        // Note: prefix is always != null (but can be the empty String)
        if ( enumerationConstants == null ) {
            enumerationConstants = new IdentityHashMap<EnumerationTypeInternal, Map<String, RefEnum>>( );
        }
        String prefixedLabel = getEnumerationTypeUnPrefix( session, type ) + label;
        Map<String, RefEnum> refEnums = enumerationConstants.get( type );
        if ( refEnums == null ) {
            refEnums = this.jmiHelper.getEnumerationConstantsMap( session, (EnumerationType) type );
            enumerationConstants.put( type, refEnums );
        }
        return refEnums.get( prefixedLabel );
    }

    public AssociationEndInternal getReferencedEnd( CoreSession session, ReferenceInternal reference ) {

        if ( referencedEnds == null ) {
            referencedEnds = new IdentityHashMap<ReferenceInternal, AssociationEndInternal>( 256 );
        }
        AssociationEndInternal end = referencedEnds.get( reference );
        if ( end == null ) {
            //FIXME HACK!!! 
            CoreConnection connection = session != null ? session.getConnections( ).iterator( ).next( ) : null;
            end = (AssociationEndInternal) reference.getReferencedEnd( connection );
            referencedEnds.put( reference, end );
        }
        return end;
    }

    public AssociationEndInternal getExposedEnd( CoreSession session, ReferenceInternal reference ) {

        if ( exposedEnds == null ) {
            exposedEnds = new IdentityHashMap<ReferenceInternal, AssociationEndInternal>( 256 );
        }
        AssociationEndInternal end = exposedEnds.get( reference );
        if ( end == null ) {
            //FIXME HACK!!! 
            CoreConnection connection = session != null ? session.getConnections( ).iterator( ).next( ) : null;
            end = (AssociationEndInternal) reference.getExposedEnd( connection );
            exposedEnds.put( reference, end );
        }
        return end;
    }

    public int getAssociationEndNumber( CoreSession session, AssociationEndInternal end ) {

        if ( associationEndNumbers == null ) {
            associationEndNumbers = new IdentityHashMap<AssociationEndInternal, Integer>( 256 );
        }
        Integer result = associationEndNumbers.get( end );
        if ( result == null ) {
            int endNumber = this.jmiHelper.getAssociationEndNumber( session, (AssociationEnd) end );
            result = Integer.valueOf( endNumber );
            associationEndNumbers.put( end, result );
            return endNumber;
        }
        return result.intValue( );
    }

    public NamespaceInternal getContainer( CoreSession session, ModelElementInternal element ) {

        if ( containers == null ) {
            containers = new IdentityHashMap<ModelElementInternal, NamespaceInternal>( 256 );
        }
        NamespaceInternal result = containers.get( element );
        if ( result == null ) {
            //FIXME HACK!!! 
            CoreConnection connection = session != null ? session.getConnections( ).iterator( ).next( ) : null;
            result = (NamespaceInternal) element.getContainer( connection );
            containers.put( element, result );
        }
        return result;
    }

    public boolean isMultiValued( StructuralFeatureInternal feature ) {

        if ( isMultiValued == null ) {
            isMultiValued = new IdentityHashMap<StructuralFeatureInternal, Boolean>( 256 );
        }
        Boolean result = isMultiValued.get( feature );
        if ( result == null ) {
            result = Boolean.valueOf( feature.getMultiplicity( ).getUpper( ) != 1 );
            isMultiValued.put( feature, result );
        }
        return result.booleanValue( );
    }
}
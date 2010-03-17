package com.sap.tc.moin.repository.core.jmi.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.mmi.model.AggregationKind;
import com.sap.tc.moin.repository.mmi.model.AggregationKindEnum;
import com.sap.tc.moin.repository.mmi.model.AliasType;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.AttachesTo;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.Constant;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.Generalizes;
import com.sap.tc.moin.repository.mmi.model.Import;
import com.sap.tc.moin.repository.mmi.model.IsOfType;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofException;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;
import com.sap.tc.moin.repository.mmi.model.NameNotFoundException;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.model.Tag;
import com.sap.tc.moin.repository.mmi.model.TypedElement;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.AttachesToInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.AttributeInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.EnumerationTypeImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.ExposesImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.GeneralizableElementInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.GeneralizesInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ImportImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.IsOfTypeImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.ModelElementInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ModelPackageImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.ModelPackageInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.MofClassImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.NamespaceInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ReferenceImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.StructureTypeImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.StructureTypeInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.TypedElementInternal;
import com.sap.tc.moin.repository.mmi.reflect.InvalidCallException;
import com.sap.tc.moin.repository.mmi.reflect.InvalidNameException;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefEnum;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefStruct;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.core.AssociationExtent;
import com.sap.tc.moin.repository.core.ClassExtent;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreMoin;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.EndAndMetaObject;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.Extent;
import com.sap.tc.moin.repository.core.ExtentManager;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.LogicalLinkManager;
import com.sap.tc.moin.repository.core.MemoryLinkManager;
import com.sap.tc.moin.repository.core.PackageExtent;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.WorkspaceSet;
import com.sap.tc.moin.repository.core.jmi.extension.AssociationEndExtension;
import com.sap.tc.moin.repository.core.jmi.extension.AssociationExtension;
import com.sap.tc.moin.repository.core.jmi.extension.RefObjectExtension;
import com.sap.tc.moin.repository.core.jmi.reflect.RefClassImpl;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.jmi.reflect.RefPackageImpl;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinIllegalNullArgumentException;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer;
import com.sap.tc.moin.repository.shared.util.QualifiedName;
import com.sap.tc.moin.repository.shared.util.StringUtils;
import com.sap.tc.moin.repository.shared.util.Utilities;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;
import com.sap.tc.moin.repository.spi.core.SpiSession;
import com.sap.tc.moin.repository.spi.core.Wrapper;

/**
 * This class provides some convenient methods related to the JMI reflective
 * interface. It is expected that these tasks will have to be solved in various
 * places and that the provided methods can help with that.
 * 
 * @author d024227 et al.
 */
@SuppressWarnings( "unchecked" )
public final class JmiHelperImpl implements SpiJmiHelper {

    private static final int CACHE_SIZE = 256;

    /**
     * The value for the <tt>com.sap.moin.store</tt> mark on association ends in
     * the metamodel that specifies that this end is stored in any case,
     * regardless of whether or not the association end is exposed by a
     * reference.
     */
    public static final String MARK_LINK_END_STORE = "yes"; //$NON-NLS-1$

    /**
     * The value for the <tt>com.sap.moin.store</tt> mark on association ends in
     * the metamodel that specifies that this end is definitely not stored,
     * regardless of whether or not the association end is exposed by a
     * reference.
     */
    public static final String MARK_LINK_END_DONTSTORE = "no"; //$NON-NLS-1$

    /**
     * The value for the <tt>com.sap.moin.store</tt> mark on association ends in
     * the metamodel that specifies that this end is stored if and only if the
     * corresponding association end is exposed by a reference. This value is at
     * the same time the default in case the tag is not present.
     */
    public static final String MARK_LINK_END_REFERENCE = "reference"; //$NON-NLS-1$

    /**
     * The name of the tag used on association ends on the metamodel to specify
     * whether or not to store references at that end. Possible values are
     * either one of {@link #MARK_LINK_END_DONTSTORE},
     * {@link #MARK_LINK_END_REFERENCE} and {@link #MARK_LINK_END_STORE}.
     */
    public static final String MARK_LINK_END = "org.omg.sap2mof.store"; //$NON-NLS-1$

    private static final byte DEFAULT_STORAGE_END_NUMBER = 0;

    public static final String JMI_TAG_ID_SUBSTITUTE_NAME = "javax.jmi.substituteName"; //$NON-NLS-1$

    public final static String JMI_TAG_ID_PACKAGE_PREFIX = "javax.jmi.packagePrefix"; //$NON-NLS-1$

    public final static String JMI_TAG_ID_IS_STRUCTURE_TYPE = "org.omg.sap2mof.isStructureType"; //$NON-NLS-1$

    /**
     * Name of the tag containing package prefixes For compatibility reasons,
     * use javax.jmi.packagePrefix instead
     */
    private static final String TAG_IDL_PREFIX = "org.omg.mof.idl_prefix"; //$NON-NLS-1$

    private final static String EXTENSION_EXCEPTION = "Exception"; //$NON-NLS-1$

    private Map<AssociationEnd, Boolean> IS_END_STORED;

    private Map<Namespace, Map<String, ModelElement>> CONTAINED_ELEMENTS_BY_NAME;

    private Map<TypedElement, Classifier> TYPE_OF_TYPED_ELEMENT;

    private Map<StructureType, List<StructureField>> FIELDS_OF_STRUCTURE_TYPE;

    private Map<StructureType, List<StructureField>> ALL_FIELDS_OF_STRUCTURE_TYPE;

    private static final String NON_SIG_CHARS = " _-\n\r\t"; //$NON-NLS-1$

    private final CoreMoin moin;

    public JmiHelperImpl( CoreMoin moin ) {

        this.moin = moin;
        initializeCaches( );
    }

    public void initializeCaches( ) {

        this.IS_END_STORED = null;
        this.CONTAINED_ELEMENTS_BY_NAME = null;
        this.TYPE_OF_TYPED_ELEMENT = null;
        this.FIELDS_OF_STRUCTURE_TYPE = null;
        this.ALL_FIELDS_OF_STRUCTURE_TYPE = null;
    }

    public List<RefEnum> getEnumerationConstants( Session session, EnumerationType enumerationType ) {

        List<RefEnum> result = new ArrayList<RefEnum>( );

        CoreSession coreSession = (CoreSession) session;
        //FIXME HACK!!!
        CoreConnection conn = coreSession != null ? coreSession.getConnections( ).iterator( ).next( ) : null;
        RefFeatured container = ( (RefObjectImpl) enumerationType ).refImmediateComposite( coreSession );
        if ( container instanceof MofPackage ) {
            RefPackageImpl refPackage = (RefPackageImpl) getRefPackageForMofPackage( session, (MofPackage) container );
            for ( String label : ( (EnumerationTypeImpl) enumerationType ).getLabels( conn ) ) {
                result.add( refPackage.refGetEnum( conn, enumerationType, label ) );
            }
        } else if ( container instanceof MofClass ) {
            RefClassImpl refClass = (RefClassImpl) getRefClassForMofClass( session, (MofClass) container );
            for ( String label : ( (EnumerationTypeImpl) enumerationType ).getLabels( conn ) ) {
                result.add( refClass.refGetEnum( conn, enumerationType, label ) );
            }
        } else {
            throw new MoinLocalizedBaseRuntimeException( JmiUtilMessages.CONTAINEROFENUMWRONGTYPE, ( (EnumerationTypeImpl) enumerationType ).getQualifiedName( conn ) );
        }
        return result;
    }

    public Map<String, RefEnum> getEnumerationConstantsMap( Session session, EnumerationType enumerationType ) {

        Map<String, RefEnum> result = new HashMap<String, RefEnum>( );
        CoreSession coreSession = (CoreSession) session;
        //FIXME HACK!!!
        CoreConnection connection = coreSession != null ? coreSession.getConnections( ).iterator( ).next( ) : null;
        RefFeatured container = ( (RefObjectImpl) enumerationType ).refImmediateComposite( coreSession );
        if ( container instanceof MofPackage ) {
            RefPackageImpl refPackage = (RefPackageImpl) getRefPackageForMofPackage( session, (MofPackage) container );
            for ( String label : ( (EnumerationTypeImpl) enumerationType ).getLabels( connection ) ) {
                result.put( label, refPackage.refGetEnum( connection, enumerationType, label ) );
            }
        } else if ( container instanceof MofClass ) {
            RefClassImpl refClass = (RefClassImpl) getRefClassForMofClass( session, (MofClass) container );
            for ( String label : ( (EnumerationTypeImpl) enumerationType ).getLabels( connection ) ) {
                result.put( label, refClass.refGetEnum( connection, enumerationType, label ) );
            }
        } else {
            throw new MoinLocalizedBaseRuntimeException( JmiUtilMessages.CONTAINEROFENUMWRONGTYPE, ( (EnumerationTypeImpl) enumerationType ).getQualifiedName( connection ) );
        }
        return result;
    }

    /**
     * Returns all {@link com.sap.tc.moin.repository.mmi.model.Attribute Attributes} of the given
     * {@link com.sap.tc.moin.repository.mmi.model.MofClass MofClass}. If includeSupertypes is set to
     * true, all {@link com.sap.tc.moin.repository.mmi.model.Attribute Attributes} of all supertypes
     * of the given {@link com.sap.tc.moin.repository.mmi.model.MofClass MofClass} are returned too.
     * 
     * @param mofClass the MofClass the attributes of which are returned
     * @param includeSupertypes the flag which controls if the
     * {@link com.sap.tc.moin.repository.mmi.model.Attribute Attributes} of the supertypes of the
     * {@link com.sap.tc.moin.repository.mmi.model.MofClass MofClass} should be returned too
     * @return the List of {@link com.sap.tc.moin.repository.mmi.model.Attribute Attributes} of the
     * given {@link com.sap.tc.moin.repository.mmi.model.MofClass MofClass}
     */
    @Deprecated
    public List<Attribute> getAttributes( MofClass mofClass, boolean includeSupertypes ) {

        return getAttributes( ( (Partitionable) mofClass ).get___Connection( ).getSession( ), mofClass, includeSupertypes );
    }

    public List<Attribute> getAttributes( Session session, MofClass mofClass, boolean includeSupertypes ) {

        //FIXME HACK!!!
        CoreSession coreSession = (CoreSession) session;
        CoreConnection connection = coreSession != null ? coreSession.getConnections( ).iterator( ).next( ) : null;
        ClassExtent classExtent = (ClassExtent) getRefClassForMofClass( session, mofClass );
        if ( classExtent != null ) {
            // The class is deployed. Return the information cached in the extent.
            List<Attribute> result = null;
            if ( includeSupertypes ) {
                result = classExtent.get___AllAttributes( );
            } else {
                result = classExtent.get___Attributes( );
            }
            if ( result == null ) { // not cached yet
                List<Attribute> list = getAttributesInternal( connection, mofClass, includeSupertypes );
                if ( list.isEmpty( ) ) {
                    result = Collections.emptyList( );
                } else {
                    result = Collections.unmodifiableList( list );
                }
                if ( includeSupertypes ) {
                    classExtent.set___AllAttributes( result );
                } else {
                    classExtent.set___Attributes( result );
                }
            }
            return result;
        }
        // Not deployed. We have to compute the result based on the current situation.
        return getAttributesInternal( connection, mofClass, includeSupertypes );
    }

    private List<Attribute> getAttributesInternal( Connection connection, MofClass mofClass, boolean includeSupertypes ) {

        ModelPackageImpl modelPackage = (ModelPackageImpl) mofClass.refMetaObject( ).refImmediatePackage( );
        List attributes = getStructuralFeatures( connection, mofClass, modelPackage.getAttribute( (CoreConnection) connection ), includeSupertypes );
        return attributes;
    }

    public List<Attribute> getTranslatableTextFragmentAttributes( SpiSession session, MofClass mofClass ) {

        //FIXME HACK!!!
        CoreSession coreSession = (CoreSession) session;
        CoreConnection connection = coreSession != null ? coreSession.getConnections( ).iterator( ).next( ) : null;
        ClassExtent classExtent = (ClassExtent) getRefClassForMofClass( session, mofClass );
        if ( classExtent != null ) {
            // The class is deployed. Return the information cached in the extent.
            List<Attribute> translatableTextAttributes = null;
            translatableTextAttributes = classExtent.get___AllTranslatableTextAttributes( );
            if ( translatableTextAttributes == null ) { // not cached yet
                List<Attribute> list = getTranslatableTextFragmentAttributesInternal( connection, mofClass );
                if ( list.isEmpty( ) ) {
                    translatableTextAttributes = Collections.emptyList( );
                } else {
                    translatableTextAttributes = Collections.unmodifiableList( list );
                }
                classExtent.set___AllTranslatableTextAttributes( translatableTextAttributes );
            }
            return translatableTextAttributes;
        }
        // Not deployed. We have to compute the result based on the current situation.
        return getTranslatableTextFragmentAttributesInternal( connection, mofClass );
    }

    private List<Attribute> getTranslatableTextFragmentAttributesInternal( CoreConnection connection, MofClass mofClass ) {

        ArrayList<Attribute> translatableTextAttributes = new ArrayList<Attribute>( ); // to preserve order
        CoreSession coreSession = connection.getSession( );
        ClassExtent classExtent = (ClassExtent) getRefClassForMofClass( coreSession, mofClass );
        List<Attribute> attrs = classExtent.get___AllAttributes( );
        if ( attrs != null ) {
            for ( Attribute attribute : attrs ) {
                Classifier type = ( (AttributeInternal) attribute ).getType( connection );
                if ( type instanceof StructureTypeInternal && isTranslatableTextFragment( coreSession, (StructureType) type ) ) {
                    translatableTextAttributes.add( attribute );
                }
            }
        }
        translatableTextAttributes.trimToSize( );
        return translatableTextAttributes;
    }

    public List<Attribute> getAllStructureTypedAttributes( Session session, MofClass mofClass ) {

        ClassExtent classExtent = (ClassExtent) getRefClassForMofClass( session, mofClass );
        if ( classExtent != null ) {
            // The class is deployed. Return the information cached in the extent.
            List<Attribute> result = null;
            result = classExtent.get___AllStructureTypedAttributes( );
            if ( result == null ) { // not cached yet
                List<Attribute> list = getAllStructureTypedAttributesInternal( session, mofClass );
                if ( list.isEmpty( ) ) {
                    result = Collections.emptyList( );
                } else {
                    result = Collections.unmodifiableList( list );
                }
                classExtent.set___AllStructureTypedAttributes( result );
            }
            return result;
        }
        // Not deployed. We have to compute the result based on the current situation.
        return getAllStructureTypedAttributesInternal( session, mofClass );
    }

    private List<Attribute> getAllStructureTypedAttributesInternal( Session session, MofClass mofClass ) {

        ArrayList<Attribute> result = null;
        List<Attribute> attributes = getAttributes( session, mofClass, true /* includeSupertypes */);
        for ( int i = 0, n = attributes.size( ); i < n; i++ ) {
            Attribute attribute = attributes.get( i );
            Classifier type = getNonAliasType( session, attribute );
            if ( type instanceof StructureType ) {
                if ( result == null ) {
                    result = new ArrayList<Attribute>( );
                }
                result.add( attribute );
            }
        }
        if ( result != null ) {
            result.trimToSize( );
            return result;
        }
        return Collections.emptyList( );
    }

    public List<Attribute> getAllObjectValuedAttributes( Session session, MofClass mofClass ) {

        ClassExtent classExtent = (ClassExtent) getRefClassForMofClass( session, mofClass );
        if ( classExtent != null ) {
            // The class is deployed. Return the information cached in the extent.
            List<Attribute> result = null;
            result = classExtent.get___AllObjectValuedAttributes( );
            if ( result == null ) { // not cached yet
                List<Attribute> list = getAllObjectValuedAttributesInternal( session, mofClass );
                if ( list.isEmpty( ) ) {
                    result = Collections.emptyList( );
                } else {
                    result = Collections.unmodifiableList( list );
                }
                classExtent.set___AllObjectValuedAttributes( result );
            }
            return result;
        }
        // Not deployed. We have to compute the result based on the current situation.
        return getAllObjectValuedAttributesInternal( session, mofClass );
    }

    private List<Attribute> getAllObjectValuedAttributesInternal( Session session, MofClass mofClass ) {

        ArrayList<Attribute> result = null;
        List<Attribute> attributes = getAttributes( session, mofClass, true /* includeSupertypes */);
        for ( int i = 0, n = attributes.size( ); i < n; i++ ) {
            Attribute attribute = attributes.get( i );
            Classifier type = getNonAliasType( session, attribute );
            if ( type instanceof MofClass ) {
                if ( result == null ) {
                    result = new ArrayList<Attribute>( );
                }
                result.add( attribute );
            }
        }
        if ( result != null ) {
            result.trimToSize( );
            return result;
        }
        return Collections.emptyList( );
    }

    public final boolean checkTypeCompatibility( Connection connection, Classifier classifier, Object objectToCheck ) {

        CoreConnection coreConnection = null;
        CoreSession coreSession = null;
        if ( objectToCheck instanceof Wrapper ) {
            objectToCheck = ( (Wrapper<Object>) objectToCheck ).unwrap( );
        }
        if ( connection instanceof Wrapper ) {
            coreConnection = ( (Wrapper<CoreConnection>) connection ).unwrap( );
        } else {
            coreConnection = (CoreConnection) connection;
        }
        if ( coreConnection != null ) {
            coreSession = coreConnection.getSession( );
        }
        if ( /**/
        classifier instanceof PrimitiveType && !getJavaWrapperType( connection, classifier ).isInstance( objectToCheck ) || /**/
        classifier instanceof EnumerationType && !( objectToCheck instanceof RefEnum && ( (RefEnum) objectToCheck ).refTypeName( ).equals( ( (EnumerationTypeImpl) classifier ).getQualifiedName( coreConnection ) ) ) || /**/
        classifier instanceof MofClass && !( objectToCheck instanceof RefObject && ( (RefObjectImpl) objectToCheck ).refIsInstanceOf( coreSession, classifier, true ) ) || /**/
        classifier instanceof StructureType && !( objectToCheck instanceof RefStruct && ( (RefStruct) objectToCheck ).refTypeName( ).equals( ( (StructureTypeImpl) classifier ).getQualifiedName( coreConnection ) ) /**/
        // TODO replace the line before this comment by the following line when the model persistence is able to handle sub structure instances as attribute values
            // the respective test case for this situation is
            // com.sap.tc.moin.repository.test.core.TestStructureTypeInheritance.testSaveAndLoad()
            // MM
//        classifier instanceof StructureType && !( objectToCheck instanceof RefStruct && ( (RefStruct) objectToCheck ).refIsInstanceOf( classifier.get___Mri( ), true ) ) /**/
            ) ) {
            // objectToCheck is not of the correct type
            return false;
        }
        return true;
    }

    public Attribute getAttributeByName( Connection connection, MofClass mofClass, String attributeName, boolean includeSupertypes ) {

        List<Attribute> attributes = getAttributes( connection.getSession( ), mofClass, includeSupertypes );
        for ( int i = 0, n = attributes.size( ); i < n; i++ ) {
            Attribute attribute = attributes.get( i );
            if ( attribute.getName( ).equals( attributeName ) ) {
                return attribute;
            }
        }
        return null;
    }

    public Set<AssociationEnd> getAssociationEnds( Session session, Classifier classifier, boolean includeSupertypes ) {

        if ( !( classifier instanceof MofClass ) ) {
            return Collections.emptySet( );
        }

        CoreSession coreSession = (CoreSession) session;
        //FIXME HACK!!! 
        CoreConnection connection = coreSession != null ? coreSession.getConnections( ).iterator( ).next( ) : null;

        LinkedHashSet<AssociationEnd> result = null;
        IsOfTypeImpl iot = (IsOfTypeImpl) ( (ModelPackageImpl) classifier.refImmediatePackage( ) ).getIsOfType( connection );
        JmiList typedElements = (JmiList) iot.getTypedElements( connection, classifier );
        for ( Iterator i = typedElements.iteratorReadOnly( coreSession ); i.hasNext( ); ) {
            Object o = i.next( );
            if ( o instanceof AssociationEnd ) {
                if ( result == null ) {
                    result = new LinkedHashSet<AssociationEnd>( );
                }
                result.add( (AssociationEnd) o );
            }
        }
        if ( includeSupertypes ) {
            JmiList supertypes = HACK_getSupertypes( coreSession, classifier );
            for ( int i = 0, n = supertypes.size( coreSession ); i < n; i++ ) {
                // can cast due to MOF 1.4 constraint C-7
                Classifier supertype = (Classifier) supertypes.get( coreSession, i );
                Set<AssociationEnd> associationEnds = getAssociationEnds( coreSession, supertype, includeSupertypes );
                if ( !associationEnds.isEmpty( ) ) {
                    if ( result == null ) {
                        result = new LinkedHashSet<AssociationEnd>( );
                    }
                    result.addAll( associationEnds );
                }
            }
        }
        if ( result == null ) {
            return Collections.emptySet( );
        }
        return result;
    }

    public Set<Attribute> getObjectValuedAttributesOfType( Session session, MofClass mofClass, boolean includeSupertypes ) {

        CoreSession coreSession = (CoreSession) session;
        //FIXME HACK!!!
        CoreConnection conn = coreSession != null ? coreSession.getConnections( ).iterator( ).next( ) : null;
        Set<Attribute> result = null;
        IsOfTypeImpl iot = (IsOfTypeImpl) moin.getExtent( IsOfType.ASSOCIATION_DESCRIPTOR );
        JmiList<TypedElement> typedElements = (JmiList) iot.getTypedElements( conn, mofClass );
        for ( Iterator i = typedElements.iterator( conn ); i.hasNext( ); ) {
            Object o = i.next( );
            if ( o instanceof Attribute ) {
                if ( result == null ) {
                    result = new LinkedHashSet<Attribute>( );
                }
                result.add( (Attribute) o );
            }
        }
        if ( includeSupertypes ) {
            JmiList supertypes = (JmiList) ( (MofClassImpl) mofClass ).getSupertypes( conn );
            for ( int i = 0, n = supertypes.size( conn.getSession( ) ); i < n; i++ ) {
                // can cast due to MOF 1.4 constraint C-7
                MofClass supertype = (MofClass) supertypes.get( coreSession, i );
                Set<Attribute> attributes = getObjectValuedAttributesOfType( session, supertype, includeSupertypes );
                if ( !attributes.isEmpty( ) ) {
                    if ( result == null ) {
                        result = new LinkedHashSet<Attribute>( );
                    }
                    result.addAll( attributes );
                }
            }
        }
        if ( result == null ) {
            return Collections.emptySet( );
        }
        return result;
    }

    public Set<AssociationEnd> getStoredAssociationEnds( Session session, Classifier classifier, boolean includeSupertypes ) {

        // C5074171: Covered by isEndStored(AssociationEnd)
        Set<AssociationEnd> allEnds = getAssociationEnds( session, classifier, includeSupertypes );
        LinkedHashSet<AssociationEnd> result = new LinkedHashSet<AssociationEnd>( );
        for ( AssociationEnd end : allEnds ) {
            if ( isEndStored( (SpiSession) session, end ) ) {
                result.add( end );
            }
        }
        return result;
    }

    public Set<AssociationEnd> getUnstoredCompositeAssociationEndsOnChild( Session session, Classifier classifier, boolean includeSupertypes, boolean findFirstOnly ) {

        // C5074171: Should be dealt with AssocEndExtension??
        Set<AssociationEnd> allEnds = getAssociationEnds( session, classifier, includeSupertypes );
        LinkedHashSet<AssociationEnd> result = new LinkedHashSet<AssociationEnd>( );
        CoreSession coreSession = (CoreSession) session;
        //FIXME HACK!!!
        CoreConnection conn = coreSession != null ? coreSession.getConnections( ).iterator( ).next( ) : null;
        for ( Iterator it = allEnds.iterator( ); ( !findFirstOnly || result.size( ) == 0 ) && it.hasNext( ); ) {
            AssociationEndImpl end = (AssociationEndImpl) it.next( );
            // C5074171: Check if OTHER END is an AssociationEndExtension
            AssociationEndImpl otherEnd = (AssociationEndImpl) end.otherEnd( conn );
            if ( otherEnd instanceof AssociationEndExtension ) {
                AssociationEndExtension otherEndExt = (AssociationEndExtension) otherEnd;
                if ( otherEndExt.is___EndComposite( ) && !isEndStored( coreSession, end ) ) {
                    result.add( end );
                }
            } else if ( otherEnd.getAggregation( ) == AggregationKindEnum.COMPOSITE && !isEndStored( coreSession, end ) ) {
                result.add( end );
            }
        }
        return result;
    }

    public Set<AssociationEnd> getUnstoredCompositeAssociationEndsOnParent( Session session, Classifier classifier, boolean includeSupertypes, boolean findFirstOnly ) {

        // C5074171: Should be dealt with AssocEndExtension??
        Set<AssociationEnd> allEnds = getAssociationEnds( session, classifier, includeSupertypes );
        LinkedHashSet<AssociationEnd> result = new LinkedHashSet<AssociationEnd>( );
        for ( Iterator it = allEnds.iterator( ); ( !findFirstOnly || result.size( ) == 0 ) && it.hasNext( ); ) {
            AssociationEnd end = (AssociationEnd) it.next( );
            // C5074171: Check if END is an AssociationEndExtension
            if ( end instanceof AssociationEndExtension ) {
                AssociationEndExtension endExt = (AssociationEndExtension) end;
                if ( endExt.is___EndComposite( ) && !isEndStored( (SpiSession) session, end ) ) {
                    result.add( end );
                }
            } else if ( ( (AssociationEndImpl) end ).getAggregation( ) == AggregationKindEnum.COMPOSITE && !isEndStored( (SpiSession) session, end ) ) {
                result.add( end );
            }
        }
        return result;
    }

    /**
     * Returns all {@link com.sap.tc.moin.repository.mmi.model.Reference references} of the given
     * {@link com.sap.tc.moin.repository.mmi.model.MofClass MofClass}. If includeSupertypes is set to
     * true, all {@link com.sap.tc.moin.repository.mmi.model.Reference references} of all supertypes
     * of the given {@link com.sap.tc.moin.repository.mmi.model.MofClass MofClass} are returned too.
     * The parameter aggregationKind of type
     * {@link com.sap.tc.moin.repository.mmi.model.AggregationKind AggregationKind} specifies the
     * kind of {@link com.sap.tc.moin.repository.mmi.model.Reference references} which should be
     * returned:
     * <p>
     * <ul>
     * <li>{@link AggregationKindEnum#COMPOSITE COMPOSITE}</li>
     * <li>{@link AggregationKindEnum#NONE NONE}</li>
     * <li>{@link AggregationKindEnum#SHARED SHARED}</li>
     * </ul>
     * <p>
     * If it is set to null, all kinds of {@link com.sap.tc.moin.repository.mmi.model.Reference
     * references} are returned.
     * 
     * @param mofClass the MofClass the attributes of which are returned
     * @param aggregationKind the kind of references which should be returned
     * @param includeSupertypes the flag which controls if the
     * {@link com.sap.tc.moin.repository.mmi.model.Reference references} of the supertypes of the
     * {@link com.sap.tc.moin.repository.mmi.model.MofClass MofClass} should be returned too
     * @return the List of {@link com.sap.tc.moin.repository.mmi.model.Reference references} of the
     * given {@link com.sap.tc.moin.repository.mmi.model.MofClass MofClass}
     */
    @Deprecated
    public List<Reference> getReferences( MofClass mofClass, AggregationKind aggregationKind, boolean includeSupertypes ) {

        return getReferences( ( (Partitionable) mofClass ).get___Connection( ).getSession( ), mofClass, aggregationKind, includeSupertypes );
    }

    public List<Reference> getReferences( Session session, MofClass mofClass, boolean includeSupertypes ) {

        //FIXME HACK!!!
        CoreSession coreSession = (CoreSession) session;
        CoreConnection coreConnection = coreSession != null ? coreSession.getConnections( ).iterator( ).next( ) : null;
        ClassExtent classExtent = (ClassExtent) getRefClassForMofClass( session, mofClass );
        if ( classExtent != null ) {
            // The class is deployed. Return the information cached in the extent.
            List<Reference> result = null;
            if ( includeSupertypes ) {
                result = classExtent.get___AllReferences( );
            } else {
                result = classExtent.get___References( );
            }
            if ( result == null ) { // not cached yet
                List<Reference> list = getReferencesInternal( coreConnection, mofClass, includeSupertypes );
                if ( list.isEmpty( ) ) {
                    result = Collections.emptyList( );
                } else {
                    result = Collections.unmodifiableList( list );
                }
                if ( includeSupertypes ) {
                    classExtent.set___AllReferences( result );
                } else {
                    classExtent.set___References( result );
                }
            }
            return result;
        }
        // Not deployed. We have to compute the result based on the current situation.
        return getReferencesInternal( coreConnection, mofClass, includeSupertypes );
    }

    private List<Reference> getReferencesInternal( Connection connection, MofClass mofClass, boolean includeSupertypes ) {

        ModelPackageImpl modelPackage = (ModelPackageImpl) mofClass.refMetaObject( ).refImmediatePackage( );
        List references = getStructuralFeatures( connection, mofClass, modelPackage.getReference( (CoreConnection) connection ), includeSupertypes );
        return references;
    }

    public List<Reference> getReferences( Session session, MofClass mofClass, AggregationKind aggregationKind, boolean includeSupertypes ) {

        List<Reference> references = getReferences( session, mofClass, includeSupertypes );
        if ( references.isEmpty( ) || aggregationKind == null ) {
            return references;
        }
        List<Reference> result = new ArrayList<Reference>( references.size( ) );
        //FIXME HACK!!!
        CoreSession coreSession = (CoreSession) session;
        CoreConnection conn = coreSession != null ? coreSession.getConnections( ).iterator( ).next( ) : null;
        for ( int i = 0, n = references.size( ); i < n; i++ ) {
            ReferenceImpl reference = (ReferenceImpl) references.get( i );
            if ( reference.getExposedEnd( conn ).getAggregation( ) == aggregationKind ) {
                result.add( reference );
            }
        }
        return result;
    }

    public Reference getReferenceByName( Connection connection, MofClass mofClass, String referenceName, boolean includeSupertypes ) {

        List<Reference> references = getReferences( connection.getSession( ), mofClass, includeSupertypes );
        for ( int i = 0, n = references.size( ); i < n; i++ ) {
            Reference reference = references.get( i );
            if ( reference.getName( ).equals( referenceName ) ) {
                return reference;
            }
        }
        return null;
    }

    public Map<Attribute, Object> getAttributesWithValues( Connection connection, RefObject refObject, boolean includeSupertypes ) {

        List<Attribute> attributes = getAttributes( connection.getSession( ), (MofClass) refObject.refMetaObject( ), includeSupertypes );
        LinkedHashMap<Attribute, Object> attributeValues = new LinkedHashMap<Attribute, Object>( );
        CoreConnection conn = (CoreConnection) connection;
        for ( int i = 0, n = attributes.size( ); i < n; i++ ) {
            Attribute attribute = attributes.get( i );
            attributeValues.put( attribute, ( (RefObjectImpl) refObject ).refGetValue( conn, attribute ) );
        }
        return attributeValues;
    }

    private List getStructuralFeatures( Connection connection, MofClass mofClass, RefClass structuralFeature, boolean includeSupertypes ) {

        MofClass structuralFeatureMofClass = structuralFeature.refMetaObject( );
        List allClasses = new LinkedList( includeSupertypes ? ( (MofClassImpl) mofClass ).allSupertypes( (CoreConnection) connection ) : Collections.emptyList( ) );
        allClasses.add( mofClass );
        Set allStructuralFeatures = new HashSet( ); // for performant contains()
        ArrayList structuralFeatures = new ArrayList( ); // to preserve order
        for ( Iterator i = allClasses.iterator( ); i.hasNext( ); ) {
            MofClassImpl currentMofClass = (MofClassImpl) i.next( );
            List currentStructuralFeatures = currentMofClass.findElementsByType( (CoreConnection) connection, structuralFeatureMofClass, false );
            for ( Iterator j = currentStructuralFeatures.iterator( ); j.hasNext( ); ) {
                Object object = j.next( );
                if ( !allStructuralFeatures.contains( object ) ) {
                    allStructuralFeatures.add( object );
                    structuralFeatures.add( object );
                }
            }
        }
        structuralFeatures.trimToSize( );
        return structuralFeatures;
    }

    public List<StructuralFeature> getStructuralFeatures( Session session, MofClass mofClass, boolean includeSupertypes ) {

        ClassExtent classExtent = (ClassExtent) getRefClassForMofClass( session, mofClass );
        if ( classExtent != null ) {
            // The class is deployed. Return the information cached in the extent.
            List<StructuralFeature> result = null;
            if ( includeSupertypes ) {
                result = classExtent.get___AllStructuralFeatures( );
            } else {
                result = classExtent.get___StructuralFeatures( );
            }
            if ( result == null ) { // not cached yet
                List<StructuralFeature> list = getStructuralFeaturesInternal( session, mofClass, includeSupertypes );
                if ( list.isEmpty( ) ) {
                    result = Collections.emptyList( );
                } else {
                    result = Collections.unmodifiableList( list );
                }
                if ( includeSupertypes ) {
                    classExtent.set___AllStructuralFeatures( result );
                } else {
                    classExtent.set___StructuralFeatures( result );
                }
            }
            return result;
        }
        // Not deployed. We have to compute the result based on the current situation.
        return getStructuralFeaturesInternal( session, mofClass, includeSupertypes );
    }

    private List<StructuralFeature> getStructuralFeaturesInternal( Session session, MofClass mofClass, boolean includeSupertypes ) {

        //FIXME HACK!!!
        CoreSession coreSession = (CoreSession) session;
        CoreConnection connection = coreSession != null ? coreSession.getConnections( ).iterator( ).next( ) : null;
        ModelPackageImpl modelPackage = (ModelPackageImpl) mofClass.refMetaObject( ).refImmediatePackage( );
        MofClass structuralFeatureMofClass = modelPackage.getStructuralFeature( connection ).refMetaObject( );
        List<MofClassImpl> allClasses = new LinkedList<MofClassImpl>( includeSupertypes ? (List) ( (MofClassImpl) mofClass ).allSupertypes( connection ) : Collections.emptyList( ) );
        allClasses.add( (MofClassImpl) mofClass );
        Set<StructuralFeature> allStructuralFeatures = new HashSet<StructuralFeature>( ); // for performant contains()
        ArrayList<StructuralFeature> structuralFeatures = new ArrayList<StructuralFeature>( ); // to preserve order
        for ( Iterator<MofClassImpl> i = allClasses.iterator( ); i.hasNext( ); ) {
            MofClassImpl currentMofClass = i.next( );
            List<StructuralFeature> currentStructuralFeatures = (List) currentMofClass.findElementsByType( connection, structuralFeatureMofClass, true );
            for ( Iterator<StructuralFeature> j = currentStructuralFeatures.iterator( ); j.hasNext( ); ) {
                StructuralFeature sf = j.next( );
                if ( !allStructuralFeatures.contains( sf ) ) {
                    allStructuralFeatures.add( sf );
                    structuralFeatures.add( sf );
                }
            }
        }
        structuralFeatures.trimToSize( );
        return structuralFeatures;
    }

    private boolean isLocatedInMetamodelWorkspace( RefObject refObj ) {

        return ( (CorePartitionable) refObj ).get___Workspace( ).isMetamodelWorkspace( );
    }

    public Collection<Reference> getReferences( Session session, AssociationEnd ae ) {

        ModelPackageImpl modelPackage = (ModelPackageImpl) ae.refImmediatePackage( );
        //FIXME HACK!!!
        CoreSession coreSession = (CoreSession) session;
        CoreConnection conn = coreSession != null ? coreSession.getConnections( ).iterator( ).next( ) : null;
        ExposesImpl exposes = (ExposesImpl) modelPackage.getExposes( conn );
        JmiList<Reference> references = (JmiList<Reference>) exposes.getReferrer( conn, ae );
        return references;
    }

    public Class getJavaPrimitiveOrWrapperType( Connection connection, StructuralFeature structuralFeature ) {

        //TODO change signature to session
        CoreSession session = (CoreSession) ( connection != null ? connection.getSession( ) : null );
        Class result = null;
        Classifier classifier = getNonAliasType( session, structuralFeature );
        if ( classifier instanceof PrimitiveType ) {
            String name = classifier.getName( );
            if ( name.equals( "String" ) ) { //$NON-NLS-1$
                result = String.class;
            } else {
                MultiplicityType multiplicityType = structuralFeature.getMultiplicity( );
                int lower = multiplicityType.getLower( );
                int upper = multiplicityType.getUpper( );
                if ( name.equals( "Boolean" ) ) { //$NON-NLS-1$
                    if ( lower == 1 && upper == 1 ) {
                        result = Boolean.TYPE;
                    } else {
                        result = Boolean.class;
                    }
                } else if ( name.equals( "Integer" ) ) { //$NON-NLS-1$
                    if ( lower == 1 && upper == 1 ) {
                        result = Integer.TYPE;
                    } else {
                        result = Integer.class;
                    }
                } else if ( name.equals( "Long" ) ) { //$NON-NLS-1$
                    if ( lower == 1 && upper == 1 ) {
                        result = Long.TYPE;
                    } else {
                        result = Long.class;
                    }
                } else if ( name.equals( "Float" ) ) { //$NON-NLS-1$
                    if ( lower == 1 && upper == 1 ) {
                        result = Float.TYPE;
                    } else {
                        result = Float.class;
                    }
                } else if ( name.equals( "Double" ) ) { //$NON-NLS-1$
                    if ( lower == 1 && upper == 1 ) {
                        result = Double.TYPE;
                    } else {
                        result = Double.class;
                    }
                }
            }
        }
        return result;
    }

    public Class getJavaWrapperType( Connection connection, Classifier type ) {

        //TODO change signature to session
        CoreSession session = (CoreSession) ( connection != null ? connection.getSession( ) : null );
        Class result = null;
        Classifier classifier = getNonAliasType( session, type );
        if ( classifier instanceof PrimitiveType ) {
            String name = classifier.getName( );
            if ( name.equals( "String" ) ) { //$NON-NLS-1$
                result = String.class;
            } else {
                if ( name.equals( "Boolean" ) ) { //$NON-NLS-1$
                    result = Boolean.class;
                } else if ( name.equals( "Integer" ) ) { //$NON-NLS-1$
                    result = Integer.class;
                } else if ( name.equals( "Long" ) ) { //$NON-NLS-1$
                    result = Long.class;
                } else if ( name.equals( "Float" ) ) { //$NON-NLS-1$
                    result = Float.class;
                } else if ( name.equals( "Double" ) ) { //$NON-NLS-1$
                    result = Double.class;
                }
            }
        }
        return result;
    }

    public Classifier getNonAliasType( Session session, TypedElement typedElement ) {

        return getNonAliasType( session, getType( session, typedElement ) );
    }

    public Classifier getNonAliasType( Session session, Classifier type ) {

        Classifier result = type;
        Set visitedTypes = null;
        while ( result instanceof AliasType ) {
            if ( visitedTypes == null ) {
                visitedTypes = new HashSet( 2 );
            }
            visitedTypes.add( result );
            Classifier classifier = getType( session, (AliasType) result );
            if ( visitedTypes.contains( classifier ) ) {
                throw new MoinLocalizedBaseRuntimeException( JmiUtilMessages.DEPENDENCYCYCLE );
            }
            result = classifier;
        }
        return result;
    }

    public Tag getTag( Session session, ModelElement modelElement, String tagId ) {

        Tag tag = null;
        CoreSession coreSession = null;
        if ( session instanceof Wrapper ) {
            coreSession = ( (Wrapper<CoreSession>) session ).unwrap( );
        } else {
            coreSession = (CoreSession) session;
        }

        //FIXME HACK!!!
        CoreConnection connection = coreSession != null ? coreSession.getConnections( ).iterator( ).next( ) : null;

        AttachesToInternal attachesTo = (AttachesToInternal) this.moin.getExtent( AttachesTo.ASSOCIATION_DESCRIPTOR );

        JmiList<Tag> tags = (JmiList<Tag>) attachesTo.getTag( connection, modelElement );
        Iterator<Tag> iter = tags.iteratorReadOnly( coreSession );
        while ( iter.hasNext( ) && tag == null ) {
            Tag t = iter.next( );
            if ( t.getTagId( ).equals( tagId ) ) {
                tag = t;
                break;
            }
        }
        return tag;
    }

    public String getTagValue( Session session, ModelElement tagged, String tagId ) {

        String result = null;
        CoreSession sessionUnwrapped = null;
        if ( session instanceof Wrapper ) {
            sessionUnwrapped = ( (Wrapper<CoreSession>) session ).unwrap( );
        } else {
            sessionUnwrapped = (CoreSession) session;
        }
        Tag tag = getTag( sessionUnwrapped, tagged, tagId );
        if ( tag != null ) {
            List values = tag.getValues( );
            if ( values.size( ) > 0 ) {
                result = values.get( 0 ).toString( );
            }
        }
        return result;
    }

    public List<AssociationEnd> getAssociationEnds( Session session, Association association ) {

        CoreSession coreSession = (CoreSession) session;
        AssociationExtent assocExtent = (AssociationExtent) getRefAssociationForAssociation( session, association );
        if ( assocExtent != null ) {
            // The association is deployed. Return the information cached in the extent.
            List<AssociationEnd> result = assocExtent.get___AssociationEnds( );
            if ( result == null ) { // not cached yet
                result = getAssociationEndsInternal( coreSession, association );
                assocExtent.set___AssociationEnds( Collections.unmodifiableList( result ) );
            }
            return result;
        }
        // Not deployed. We have to compute the result based on the current situation.
        return getAssociationEndsInternal( coreSession, association );
    }

    private List<AssociationEnd> getAssociationEndsInternal( CoreSession session, Association association ) {

        if ( association instanceof AssociationExtension ) {
            // MOF-ROM special treatment; connection is 'null' in that case
            return Arrays.asList( ( (AssociationExtension) association ).get___AssociationEnds( ) );
        }
        List<AssociationEnd> result = new ArrayList<AssociationEnd>( 2 ); // at most 2, could be 1 or 0 !
        JmiList contents = HACK_getContents( session, association );
        for ( int i = 0, n = contents.size( session ); i < n; i++ ) {
            Object obj = contents.get( session, i );
            if ( obj instanceof AssociationEnd ) {
                result.add( (AssociationEnd) obj );
            }
        }
        return result;
    }

    public boolean isFirstAssociationEnd( Connection connection, Association a, AssociationEnd ae ) {

        return getAssociationEnds( connection.getSession( ), a ).get( 0 ).equals( ae );
    }

    public byte getAssociationEndNumber( Session session, AssociationEnd ae ) {

        CoreSession coreSession = (CoreSession) session;
        if ( ae instanceof AssociationEndExtension ) {
            return ( (AssociationEndExtension) ae ).get___EndNumber( );
        }
        List<AssociationEnd> ends = getAssociationEnds( session, (Association) ( (RefObjectImpl) ae ).refImmediateComposite( coreSession ) );
        for ( int i = 0; i < 2; i++ ) {
            if ( ends.get( i ).equals( ae ) ) {
                return (byte) i;
            }
        }
        throw new MoinLocalizedBaseRuntimeException( JmiUtilMessages.ENDNOTFOUNDINASSOC, ae.toString( ), ae.refImmediateComposite( ).toString( ) );
    }

    public byte getCompositeEnd( Session session, Association association ) {

        AssociationExtent assocExtent = (AssociationExtent) getRefAssociationForAssociation( session, association );
        if ( assocExtent != null ) {
            // The association is deployed. Return the information cached in the extent.
            byte result = assocExtent.get___CompositeEnd( );
            if ( result == Byte.MIN_VALUE ) { // not cached yet
                result = getCompositeEndInternal( session, association );
                assocExtent.set___CompositeEnd( result );
            }
            return result;
        }
        // Not deployed. We have to compute the result based on the current situation.
        return getCompositeEndInternal( session, association );
    }

    private byte getCompositeEndInternal( Session session, Association association ) {

        List<AssociationEnd> ends = getAssociationEnds( session, association );
        for ( int i = 0; i < 2; i++ ) {
            AssociationEnd ae = ends.get( i );
            // C5074171: Check if we deal with an AssociationEndExtension
            if ( ae instanceof AssociationEndExtension ) {
                if ( ( (AssociationEndExtension) ae ).is___EndComposite( ) ) {
                    return (byte) i;
                }
            } else if ( ae.getAggregation( ).equals( AggregationKindEnum.COMPOSITE ) ) {
                return (byte) i;
            }
        }
        return -1;
    }

    public byte getComponentEnd( Session session, Association a ) {

        byte compositeEnd = getCompositeEnd( session, a );
        if ( compositeEnd != -1 ) {
            return (byte) ( 1 - compositeEnd );
        }
        return -1;
    }

    public AssociationEnd getCompositeAssociationEnd( Connection connection, Association a ) {

        List<AssociationEnd> ends = getAssociationEnds( connection.getSession( ), a );
        for ( int i = 0; i < 2; i++ ) {
            AssociationEnd ae = ends.get( i );
            if ( ae.getAggregation( ).equals( AggregationKindEnum.COMPOSITE ) ) {
                return ae;
            }
        }
        return null;
    }

    public boolean isEndStored( SpiSession session, int endNumber, RefObject metaObject ) {

        if ( metaObject instanceof Attribute ) {
            return this.isEndStored( endNumber, (Attribute) metaObject );
        } else if ( metaObject instanceof Association ) {
            return this.isEndStored( session, endNumber, (Association) metaObject );
        } else {
            throw new MoinIllegalArgumentException( JmiUtilMessages.METAOBJECTMUSTBEATTORASSOC );
        }
    }

    public boolean isEndStored( SpiSession session, int endNumber, Association association ) {

        if ( isValidEndNumber( (byte) endNumber ) ) {
            List<AssociationEnd> associationEnds = this.getAssociationEnds( session, association );
            return this.isEndStored( session, associationEnds.get( endNumber ) );
        }
        return false;
    }

    public byte getStoredEnd( SpiSession session, Association association ) {

        AssociationExtent assocExtent = (AssociationExtent) getRefAssociationForAssociation( session, association );
        if ( assocExtent != null ) {
            // The association is deployed. Return the information cached in the extent.
            byte result = assocExtent.get___StoredEnd( );
            if ( result == Byte.MIN_VALUE ) { // not cached yet
                result = getStoredEndInternal( session, association );
                assocExtent.set___StoredEnd( result );
            }
            return result;
        }
        // Not deployed. We have to compute the result based on the current situation.
        return getStoredEndInternal( session, association );
    }

    public byte getStoredEnd( SpiSession session, RefObject attributeOrAssociation ) {

        if ( attributeOrAssociation instanceof Association ) {
            return getStoredEnd( session, (Association) attributeOrAssociation );
        } else if ( attributeOrAssociation instanceof Attribute ) {
            return getStoredEnd( (Attribute) attributeOrAssociation );
        }
        throw new MoinIllegalArgumentException( JmiUtilMessages.REFOBJECTMUSTBEATTORASSOC );
    }

    private byte getStoredEndInternal( SpiSession session, Association association ) {

        CoreSession coreSession = (CoreSession) session;
        List<AssociationEnd> ends = getAssociationEnds( coreSession, association );
        boolean end0IsStored = isEndStored( coreSession, ends.get( 0 ) );
        boolean end1IsStored = isEndStored( coreSession, ends.get( 1 ) );
        return getStoredEnd( association, end0IsStored, end1IsStored );
    }

    /**
     * Returns an array of byte which contains the stored ends numbers of the
     * specified attribute.
     * 
     * @param attribute the attribute of which to retrieve the stored end
     * numbers
     * @return an array of byte which contains the stored ends numbers of the
     * specified attribute.
     */
    public byte getStoredEnd( Attribute attribute ) {

        boolean end0IsStored = this.isEndStored( 0, attribute );
        boolean end1IsStored = this.isEndStored( 1, attribute );

        return getStoredEnd( attribute, end0IsStored, end1IsStored );
    }

    private byte getStoredEnd( Object metaObject, boolean end0IsStored, boolean end1IsStored ) {

        if ( end0IsStored && !end1IsStored ) {
            return STORED_END_0;
        } else if ( !end0IsStored && end1IsStored ) {
            return STORED_END_1;
        } else if ( end0IsStored && end1IsStored ) {
            throw new MoinIllegalStateException( JmiUtilMessages.STORAGEONBOTHENDS, metaObject.toString( ) );
        } else {
            // no end is stored 
            throw new MoinIllegalStateException( JmiUtilMessages.STORAGEONNOEND, metaObject.toString( ) );
        }
    }

    /**
     * It is assumed that an object-valued attribute is very closely linked to
     * its owner. Therefore, both ends are stored, thus this operation always
     * returns <code>true</code> as long as the endNumber is 0 or 1. Otherwise,
     * <code>false</code> will be returned.
     * <p>
     * Note that introducing a "storage" mark for attributes (like for
     * association ends) will not work: the XMI DTD does not provide element
     * definitions for these "virtual" associations, thus they cannot be stored
     * in XMI documents without violating the DTD.
     */
    private boolean isEndStored( int endNumber, Attribute attribute ) {

        return ( endNumber == 0 );
    }

    private boolean isValidEndNumber( byte endNumber ) {

        return ( endNumber == 0 || endNumber == 1 );
    }

    public boolean isEndStored( SpiSession session, AssociationEnd ae ) {

        return isEndStored( (CoreSession) session, ae, true, false );
    }

    private boolean isEndStored( CoreSession session, AssociationEnd ae, boolean considerOtherEndIfNotStored, boolean withoutFallback ) {

        withoutFallback = true;

        if ( this.IS_END_STORED != null && isLocatedInMetamodelWorkspace( ae ) ) {
            Boolean res = this.IS_END_STORED.get( ae );
            if ( res != null ) {
                return res.booleanValue( );
            }
        }

        boolean result = true;
        // C5074171: Check if we deal with an AssociationEndExtension
        if ( ae instanceof AssociationEndExtension ) {
            return ( (AssociationEndExtension) ae ).is___EndStored( );
        }
        Tag tag = getTag( session, ae, MARK_LINK_END );
        if ( tag != null && areModelElementsFromSameMetamodel( tag, ae ) ) {
            String tagValue = ""; //$NON-NLS-1$
            List values = tag.getValues( );
            if ( values.size( ) > 0 ) {
                tagValue = String.valueOf( values.get( 0 ) );
            }
            if ( tagValue.equals( MARK_LINK_END_STORE ) ) {
                result = true;
            } else if ( tagValue.equals( MARK_LINK_END_DONTSTORE ) ) {
                result = false;
            } else if ( tagValue.equals( MARK_LINK_END_REFERENCE ) ) {
                result = hasDirectReferences( session, ae );
            } else {
                // If an invalid vaue is found, treat as "no storage"
                return false;

            }
        } else { // no tag; decide based on exposure by reference
            result = hasDirectReferences( session, ae );
        }

        if ( withoutFallback ) {
            return result;
        }

        if ( result == false ) {
            // the association end is not stored
            // if that's the "original" call, we also have to consider the other
            // end
            // because if the other end is also not stored, we define that the
            // association end
            // with the endNumber DEFAULT_STORAGE_END_NUMBER {= 0} has storage
            if ( considerOtherEndIfNotStored ) {
                // FIXME HACK!!!
                CoreConnection conn = ( session != null ? session.getConnections( ).iterator( ).next( ) : null );
                if ( isEndStored( session, ( (AssociationEndImpl) ae ).otherEnd( conn ), false, withoutFallback ) == false ) {
                    // other end is also not stored and is not the end of the
                    // default storage end number
                    // therefore, this end is defined to have storage as
                    // fallback mechanism
                    result = true;
                }
            } else {// we have detected that both ends are not stored
                // if this end is the one which corresponds to the default
                // storage end number, we define that it has storage
                if ( getAssociationEndNumber( session, ae ) == DEFAULT_STORAGE_END_NUMBER ) {
                    result = true;
                }
            }
        }

        if ( isLocatedInMetamodelWorkspace( ae ) ) {
            if ( this.IS_END_STORED == null ) {
                this.IS_END_STORED = new IdentityHashMap<AssociationEnd, Boolean>( CACHE_SIZE );
            }
            this.IS_END_STORED.put( ae, Boolean.valueOf( result ) );
        }
        return result;
    }

    /**
     * For the given AssociationEnd, returns whether there is at least one
     * Reference contained in the MofClass at the other end that refers to it.
     * This information is required for determining the storage property of an
     * AssociationEnd.
     */
    private boolean hasDirectReferences( Session session, AssociationEnd ae ) {

        CoreSession coreSession = (CoreSession) session;
        //FIXME HACK!!!
        CoreConnection connection = session != null ? coreSession.getConnections( ).iterator( ).next( ) : null;
        Classifier type = getType( session, ae );
        JmiList references = (JmiList) getReferences( session, ae );
        if ( references.size( coreSession ) > 0 ) {
            for ( Iterator it = references.iteratorReadOnly( coreSession ); it.hasNext( ); ) {
                ReferenceImpl reference = (ReferenceImpl) it.next( );
                if ( areModelElementsFromSameMetamodel( reference, ae ) ) {
                    MofClassImpl containingMofClass = (MofClassImpl) reference.getContainer( connection );
                    if ( containingMofClass.equals( type ) ) {
                        return true;
                    }
                    if ( containingMofClass.allSupertypes( connection ).contains( type ) ) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Checks whether the given two model elements are from the same metamodel.
     */
    private boolean areModelElementsFromSameMetamodel( ModelElement element1, ModelElement element2 ) {

        String containerName1 = ( (Partitionable) element1 ).get___Mri( ).getContainerName( );
        String containerName2 = ( (Partitionable) element2 ).get___Mri( ).getContainerName( );
        return containerName1.equals( containerName2 );
    }

    public RefPackage findRefPackageByQualifiedName( List qualifiedNameToSearch, RefPackage outermostPackage ) {

        String pkgName = (String) qualifiedNameToSearch.get( 0 ); // Qualified
        // names have at
        // least one
        // segment!
        // Recursively determine the RefPackage responsible for the first
        // segment of the qualified name.
        RefPackage refPkg = findRefPackage( outermostPackage, pkgName, new HashSet<RefPackage>( ) /* visitedPackages */);
        if ( refPkg == null ) {
            // Cannot be found in the context of the given outermost package.
            return null;
        }
        // In the context of the found RefPackage, traverse the remaining
        // segments by iteratively calling refPackage().
        for ( int i = 1; i < qualifiedNameToSearch.size( ); i++ ) {
            try {
                refPkg = ( (RefPackageImpl) refPkg ).refPackage( (String) qualifiedNameToSearch.get( i ) );
            } catch ( InvalidNameException ex ) {
                return null;
            } catch ( InvalidCallException ex ) {
                return null;
            }
        }
        return refPkg;
    }

    /**
     * Recursively searches for a RefPackage with the name <code>pkgName</code>,
     * starting at <code>refPkg</code> and descending via
     * {@link RefPackage#refAllPackages()}.
     * 
     * @author d027299
     */
    private RefPackage findRefPackage( RefPackage refPkg, String pkgName, Set<RefPackage> visitedPackages ) {

        if ( !visitedPackages.contains( refPkg ) ) {
            if ( refPkg.refMetaObject( ).getName( ).equals( pkgName ) ) {
                // We have a match!
                return refPkg;
            }
            visitedPackages.add( refPkg );
            for ( Iterator it = ( (RefPackageImpl) refPkg ).refAllPackages( ).iterator( ); it.hasNext( ); ) {
                RefPackage nestedOrClustered = (RefPackage) it.next( );
                RefPackage result = findRefPackage( nestedOrClustered, pkgName, visitedPackages );
                if ( result != null ) {
                    return result;
                }
            }
        }
        // Nothing found in the context of refPkg.
        return null;
    }

    public ModelElement findElementByQualifiedName( Session session, List<String> qualifiedNameToSearch, RefPackage outermostPackage ) {

        CoreSession coreSession = (CoreSession) session;
        String pkgName = qualifiedNameToSearch.get( 0 ); // Qualified
        // names have at
        // least one
        // segment!
        // Recursively determine the RefPackage responsible for the first
        // segment of the qualified name.
        RefPackage refPkg = findRefPackage( outermostPackage, pkgName, new HashSet<RefPackage>( ) /* visitedPackages */);
        if ( refPkg == null ) {
            // Cannot be found in the context of the given outermost package.
            return null;
        }
        // The responsible RefPackage was found. Now go up one meta layer.
        ModelElement element = refPkg.refMetaObject( );
        // Search for the remaining segments of the qualified name.
        for ( int i = 1; i < qualifiedNameToSearch.size( ); i++ ) {
            String nameToSearch = qualifiedNameToSearch.get( i );
            try {
                if ( element instanceof GeneralizableElement ) {
                    element = getAllContentMap( coreSession, (Namespace) element ).get( nameToSearch );
                } else if ( element instanceof Namespace ) {
                    element = ( (Namespace) element ).lookupElement( nameToSearch );
                }
            } catch ( NameNotFoundException e ) {
                return null;
            } catch ( JmiException e ) {
                return null;
            }
        }
        return element;
    }

    public ModelElement findElementByQualifiedName( Session session, String[] qualifiedNameToSearch, RefPackage outermostPackage ) {

        CoreSession coreSession = (CoreSession) session;
        String pkgName = qualifiedNameToSearch[0];
        // Qualified names have at least one segment!
        // Recursively determine the RefPackage responsible for the first
        // segment of the qualified name.
        RefPackage refPkg = findRefPackage( outermostPackage, pkgName, new HashSet<RefPackage>( ) /* visitedPackages */);
        if ( refPkg == null ) {
            // Cannot be found in the context of the given outermost package.
            return null;
        }
        // The responsible RefPackage was found. Now go up one meta layer.
        ModelElement element = refPkg.refMetaObject( );
        // Search for the remaining segments of the qualified name.
        for ( int i = 1; i < qualifiedNameToSearch.length; i++ ) {
            String nameToSearch = qualifiedNameToSearch[i];
            try {
                if ( element instanceof GeneralizableElement ) {
                    element = getAllContentMap( coreSession, (Namespace) element ).get( nameToSearch );
                } else if ( element instanceof Namespace ) {
                    element = ( (Namespace) element ).lookupElement( nameToSearch );
                }
            } catch ( NameNotFoundException e ) {
                return null;
            } catch ( JmiException e ) {
                return null;
            }
        }
        return element;
    }

    /**
     * @author dD044784
     */
    private static final class NestedAndClusteredPackages {

        protected Collection clustered;

        protected Collection nested;

        public NestedAndClusteredPackages( Collection clusterd, Collection nested ) {

            this.clustered = clusterd;
            this.nested = nested;
        }
    }

    /**
     * Returns all clusteredly imported packages of <tt>p</tt>
     * 
     * @param p
     * @return A {@link Collection} of {@link MofPackage MofPackages}
     * @author dD044784
     * @param connection 
     */
    private Collection getClusteredPackages( MofPackage p, Connection connection ) {

        Collection packages = new ArrayList( );
        JmiList contents = (JmiList) p.getContents( );
        for ( int i = 0, n = contents.size( ( (CoreConnection) connection).getSession() ); i < n; i++ ) {
            ModelElement element = (ModelElement) contents.get( ( (CoreConnection) connection).getSession(), i );
            if ( element instanceof Import && ( (Import) element ).isClustered( ) ) {
                Namespace namespace = ( (Import) element ).getImportedNamespace( );
                if ( namespace instanceof MofPackage ) {
                    packages.add( namespace );
                }
            }
        }
        return packages;
    }

    /**
     * Returns all nested packages of <tt>p</tt>
     * 
     * @param p
     * @return A {@link Collection} of {@link MofPackage MofPackages}
     * @author dD044784
     */
    private Collection getNestedPackages( MofPackage p, Connection connection ) {

        Collection packages = new ArrayList( );
        JmiList contents = (JmiList) p.getContents( );
        for ( int i = 0, n = contents.size( ( (CoreConnection) connection).getSession() ); i < n; i++ ) {
            ModelElement element = (ModelElement) contents.get( ( (CoreConnection) connection).getSession(), i );
            if ( element instanceof MofPackage ) {
                packages.add( element );
            }
        }
        return packages;
    }

    public RefBaseObject matchQNameInExtent( String[] qname, int index, RefBaseObject extent ) {

        RefBaseObject result = null;
        try {
            if ( qname.length - 1 >= index && index >= 0 ) {
                String pieceOfName = qname[index];
                ModelElement me = getAllContentMap( (CoreSession) null, (Namespace) extent.refMetaObject( ) ).get( pieceOfName );
                if ( me instanceof MofPackage ) {
                    result = ( (RefPackageImpl) extent ).refPackage( pieceOfName );
                } else if ( me instanceof MofClass ) {
                    result = ( (RefPackageImpl) extent ).refClass( pieceOfName );
                } else if ( me instanceof Association ) {
                    result = ( (RefPackageImpl) extent ).refAssociation( pieceOfName );
                }
                if ( qname.length - 1 != index && result != null ) {
                    result = matchQNameInExtent( qname, index + 1, result );
                }
            }
        } catch ( com.sap.tc.moin.repository.mmi.reflect.InvalidNameException ex ) {
            // $JL-EXC$ no-op return null;
        }
        return result;
    }

    public ModelElement findElementByQualifiedName( Connection connection, List qnameToSearch, MofPackage mofPackage ) {

        if ( mofPackage.getName( ).equals( qnameToSearch.get( 0 ) ) ) {
            ModelElement result = matchQNameInNamespace( qnameToSearch, 1, mofPackage, connection );
            if ( result != null ) {
                return result;
            }
        }
        // first check if the first part of the qname can be found here
        Map<MofPackage, NestedAndClusteredPackages> packageChildrenByParent = new HashMap<MofPackage, NestedAndClusteredPackages>( );
        Collection clusteredImports = getClusteredPackages( mofPackage, connection );
        Collection nestedPackages = getNestedPackages( mofPackage, connection );
        packageChildrenByParent.put( mofPackage, new NestedAndClusteredPackages( clusteredImports, nestedPackages ) );
        while ( packageChildrenByParent.size( ) > 0 ) {
            for ( Entry<MofPackage, NestedAndClusteredPackages> entry : packageChildrenByParent.entrySet( ) ) {
                MofPackage parent = entry.getKey( );
                NestedAndClusteredPackages children = entry.getValue( );
                // first search in the nested packages
                for ( Iterator iterMofPackageChildren = children.nested.iterator( ); iterMofPackageChildren.hasNext( ); ) {
                    MofPackage childMofPackage = (MofPackage) iterMofPackageChildren.next( );
                    if ( childMofPackage != null && childMofPackage.getName( ).equals( qnameToSearch.get( 0 ) ) ) {
                        // try to match the rest of the qname
                        ModelElement result = matchQNameInNamespace( qnameToSearch, 0, (MofPackage) parent.refMetaObject( ), connection );
                        if ( result != null ) {
                            return result;
                        }
                    }
                }
                // then in the clustered
                for ( Iterator iterMofPackageChildren = children.clustered.iterator( ); iterMofPackageChildren.hasNext( ); ) {
                    MofPackage childMofPackage = (MofPackage) iterMofPackageChildren.next( );
                    if ( childMofPackage != null && childMofPackage.getName( ).equals( qnameToSearch.get( 0 ) ) ) {
                        // try to match the rest of the qname
                        ModelElement result = matchQNameInNamespace( qnameToSearch, 1, childMofPackage, connection );
                        if ( result != null ) {
                            return result;
                        }
                    }

                }
            }
            // no direct match found, search only in clusteredly imported
            // packages because nested packages may not have any further
            // imports and the name didn't match the first part of the qname
            Map<MofPackage, NestedAndClusteredPackages> temp = new HashMap<MofPackage, NestedAndClusteredPackages>( );
            for ( Entry<MofPackage, NestedAndClusteredPackages> entry : packageChildrenByParent.entrySet( ) ) {
                clusteredImports = entry.getValue( ).clustered;
                for ( Iterator iterPackages = clusteredImports.iterator( ); iterPackages.hasNext( ); ) {
                    MofPackage childMofPackage = (MofPackage) iterPackages.next( );
                    temp.put( childMofPackage, new NestedAndClusteredPackages( getClusteredPackages( childMofPackage, connection ), getNestedPackages( childMofPackage, connection ) ) );
                }
            }
            packageChildrenByParent = temp;
        }
        // found nothing;
        return null;
    }

    /**
     * Tries to match the given qualified name (<tt>qname</tt>) using
     * {@link Namespace#lookupElement(String)} and calling itself recursively.
     * If the ModelElement cannot be found, the {@link NameNotFoundException} is
     * caught and <tt>null</tt> is returned.
     * 
     * @param qname
     * @param index
     * @param namespace
     * @return the {@link ModelElement} matching the given qualified name or
     * <tt>null</tt> if it cannot be found
     */
    private ModelElement matchQNameInNamespace( List qname, int index, Namespace namespace, Connection connection ) {

        try {
            ModelElement result = ((NamespaceInternal) namespace).lookupElement((CoreConnection) connection, (String) qname.get( index ) );
            if ( qname.size( ) - 1 == index ) {
                return result;
            } else if ( result instanceof Namespace ) {
                return matchQNameInNamespace( qname, index + 1, (Namespace) result, connection );
            } else {
                return null;
            }
        } catch ( NameNotFoundException e ) {
            return null;
        }
    }

    public Collection<GeneralizableElement> getSubTypes( Connection connection, GeneralizableElement generalizableElement ) {

        GeneralizesInternal generalizes = (GeneralizesInternal) connection.getAssociation( Generalizes.ASSOCIATION_DESCRIPTOR );
        return generalizes.getSubtype( (CoreConnection) connection, generalizableElement );
    }

    public Collection<GeneralizableElement> getAllSubtypes( Connection connection, GeneralizableElement aGeneralizableElement ) {

        if ( !( aGeneralizableElement instanceof MofClass || aGeneralizableElement instanceof MofPackage || aGeneralizableElement instanceof StructureType ) ) {
            return Collections.emptyList( );
        }
        Set<GeneralizableElement> subtypes = new HashSet<GeneralizableElement>( );
        if ( aGeneralizableElement instanceof MofClass ) {
            allSubtypesOfMofClass( (CoreConnection) connection, (MofClass) aGeneralizableElement, subtypes );
        } else if ( aGeneralizableElement instanceof MofPackage ) {
            allSubtypesOfMofPackage( (CoreConnection) connection, (MofPackage) aGeneralizableElement, subtypes );
        } else if ( aGeneralizableElement instanceof StructureType ) {
            allSubtypesOfStructureType( (CoreConnection) connection, (StructureType) aGeneralizableElement, subtypes );
        }
        return subtypes;
    }

    private void allSubtypesOfMofClass( CoreConnection connection, MofClass mofClass, Set<GeneralizableElement> theSubtypes ) {

        JmiList directSubtypes = (JmiList) getSubTypes( connection, mofClass );
        if ( directSubtypes != null ) {
            Iterator iter = directSubtypes.iterator( connection );
            while ( iter.hasNext( ) ) {
                MofClass mc = (MofClass) iter.next( );
                if ( !( theSubtypes.contains( mc ) ) ) {
                    theSubtypes.add( mc );
                    allSubtypesOfMofClass( connection, mc, theSubtypes );
                }
            }
        }
    }

    private void allSubtypesOfMofPackage( CoreConnection connection, MofPackage mofPackage, Set<GeneralizableElement> theSubtypes ) {

        JmiList directSubtypes = (JmiList) getSubTypes( connection, mofPackage );
        CoreSession session = connection != null ? connection.getSession( ) : null;
        if ( directSubtypes != null ) {
            Iterator iter = directSubtypes.iteratorReadOnly( session );
            while ( iter.hasNext( ) ) {
                MofPackage mp = (MofPackage) iter.next( );
                if ( !( theSubtypes.contains( mp ) ) ) {
                    theSubtypes.add( mp );
                    allSubtypesOfMofPackage( connection, mp, theSubtypes );
                }
            }
        }
    }

    private void allSubtypesOfStructureType( CoreConnection connection, StructureType structureType, Set<GeneralizableElement> theSubtypes ) {

        JmiList directSubtypes = (JmiList) getSubTypes( connection, structureType );
        if ( directSubtypes != null ) {
            Iterator iter = directSubtypes.iterator( connection );
            while ( iter.hasNext( ) ) {
                StructureType st = (StructureType) iter.next( );
                if ( !( theSubtypes.contains( st ) ) ) {
                    theSubtypes.add( st );
                    allSubtypesOfStructureType( connection, st, theSubtypes );
                }
            }
        }
    }

    public List<GeneralizableElement> getAllSupertypes( Session session, GeneralizableElement generalizableElement ) {

        CoreSession coreSession = (CoreSession) session;
        if ( generalizableElement instanceof MofClass ) {
            ClassExtent classExtent = (ClassExtent) getRefClassForMofClass( session, (MofClass) generalizableElement );
            if ( classExtent != null ) {
                // The class is deployed. Return the information cached in the extent.
                List<GeneralizableElement> result = classExtent.get___AllSupertypes( );
                if ( result == null ) { // not cached yet
                    List<GeneralizableElement> list = getAllSupertypesInternal( coreSession, generalizableElement );
                    if ( list.isEmpty( ) ) {
                        result = Collections.emptyList( );
                    } else {
                        result = Collections.unmodifiableList( list );
                    }
                    classExtent.set___AllSupertypes( result );
                }
                return result;
            }
            // Not deployed. We have to compute the result based on the current situation.
            return getAllSupertypesInternal( coreSession, generalizableElement );
        } else if ( generalizableElement instanceof MofPackage ) {
            PackageExtent packageExtent = (PackageExtent) getRefPackageForMofPackage( session, (MofPackage) generalizableElement );
            if ( packageExtent != null ) {
                // The package is deployed. Return the information cached in the extent.
                List<GeneralizableElement> result = packageExtent.get___AllSupertypes( );
                if ( result == null ) { // not cached yet
                    List<GeneralizableElement> list = getAllSupertypesInternal( coreSession, generalizableElement );
                    if ( list.isEmpty( ) ) {
                        result = Collections.emptyList( );
                    } else {
                        result = Collections.unmodifiableList( list );
                    }
                    packageExtent.set___AllSupertypes( result );
                }
                return result;
            }
            // Not deployed. We have to compute the result based on the current situation.
            return getAllSupertypesInternal( coreSession, generalizableElement );
        } else if ( generalizableElement instanceof StructureType ) {
            // Compute the result based on the current situation.
            return getAllSupertypesInternal( coreSession, generalizableElement );
        } else {
            return Collections.emptyList( );
        }
    }

    private List<GeneralizableElement> getAllSupertypesInternal( CoreSession coreSession, GeneralizableElement generalizableElement ) {

        ArrayList<GeneralizableElement> result = new ArrayList<GeneralizableElement>( );
        if ( generalizableElement instanceof MofClass ) {
            allSupertypesOfMofClass( coreSession, (MofClass) generalizableElement, result, new HashSet<GeneralizableElement>( ) );
        } else if ( generalizableElement instanceof MofPackage ) {
            allSupertypesOfMofPackage( coreSession, (MofPackage) generalizableElement, result, new HashSet<GeneralizableElement>( ) );
        } else if ( generalizableElement instanceof StructureType ) {
            allSupertypesOfStructureType( coreSession, (StructureType) generalizableElement, result, new HashSet<GeneralizableElement>( ) );
        }
        result.trimToSize( );
        return result;
    }

    private void allSupertypesOfMofClass( CoreSession session, MofClass mofClass, List<GeneralizableElement> list, Set<GeneralizableElement> theSupertypes ) {

        JmiList directSupertypes = HACK_getSupertypes( session, mofClass );
        if ( directSupertypes != null ) {
            for ( int i = 0, n = directSupertypes.size( session ); i < n; i++ ) {
                Object obj = directSupertypes.get( session, i );
                if ( obj instanceof MofClass ) {
                    MofClass mc = (MofClass) obj;
                    if ( !( theSupertypes.contains( mc ) ) ) {
                        // according to JMI spec page 60 depth-first search
                        theSupertypes.add( mc );
                        allSupertypesOfMofClass( session, mc, list, theSupertypes );
                        list.add( mc );
                    }
                }
            }
        }
    }

    private void allSupertypesOfMofPackage( CoreSession session, MofPackage mofPackage, List<GeneralizableElement> list, Set<GeneralizableElement> theSupertypes ) {

        JmiList directSupertypes = HACK_getSupertypes( session, mofPackage );
        if ( directSupertypes != null ) {
            for ( int i = 0, n = directSupertypes.size( session ); i < n; i++ ) {
                Object obj = directSupertypes.get( session, i );
                if ( obj instanceof MofPackage ) {
                    MofPackage mp = (MofPackage) obj;
                    if ( !( theSupertypes.contains( mp ) ) ) {
                        // according to JMI spec page 60 depth-first search
                        theSupertypes.add( mp );
                        allSupertypesOfMofPackage( session, mp, list, theSupertypes );
                        list.add( mp );
                    }
                }
            }
        }
    }

    private void allSupertypesOfStructureType( CoreSession session, StructureType structureType, List<GeneralizableElement> list, Set<GeneralizableElement> theSupertypes ) {

        JmiList directSupertypes = HACK_getSupertypes( session, structureType );
        if ( directSupertypes != null ) {
            for ( int i = 0, n = directSupertypes.size( session ); i < n; i++ ) {
                Object obj = directSupertypes.get( session, i );
                if ( obj instanceof StructureType ) {
                    StructureType st = (StructureType) obj;
                    if ( !( theSupertypes.contains( st ) ) ) {
                        // according to JMI spec page 60 depth-first search
                        theSupertypes.add( st );
                        allSupertypesOfStructureType( session, st, list, theSupertypes );
                        list.add( st );
                    }
                }
            }
        }
    }

    public List<ModelElement> getAllContent( Connection connection, ModelElement modelElement ) {

        CoreConnection connectionUnwrapped = null;
        ModelElement modelElementUnwrapped = null;
        if ( connection instanceof Wrapper ) {
            connectionUnwrapped = ( (Wrapper<CoreConnection>) connection ).unwrap( );
        } else {
            connectionUnwrapped = (CoreConnection) connection;
        }
        if ( modelElement instanceof Wrapper ) {
            modelElementUnwrapped = ( (Wrapper<ModelElement>) modelElement ).unwrap( );
        } else {
            modelElementUnwrapped = modelElement;
        }
        List<ModelElement> result = new ArrayList<ModelElement>( );
        if ( modelElementUnwrapped instanceof Namespace ) {
            // get the supertypes
            if ( modelElementUnwrapped instanceof GeneralizableElement ) {
                List<GeneralizableElement> superTypes = getAllSupertypes( connectionUnwrapped.getSession( ), (GeneralizableElement) modelElementUnwrapped );
                for ( Namespace superType : superTypes ) {
                    JmiList contents = (JmiList) ( (NamespaceInternal) superType ).getContents( connectionUnwrapped );
                    for ( int i = 0, n = contents.size( connectionUnwrapped.getSession( ) ); i < n; i++ ) {
                        result.add( (ModelElement) contents.get( connectionUnwrapped.getSession( ), i ) );
                    }
                }
            }
            JmiList contents = (JmiList) ( (NamespaceInternal) modelElementUnwrapped ).getContents( connectionUnwrapped );
            for ( int i = 0, n = contents.size( connectionUnwrapped.getSession( ) ); i < n; i++ ) {
                result.add( (ModelElement) contents.get( connectionUnwrapped.getSession( ), i ) );
            }
        }
        return result;
    }

    public Map<String, ModelElement> getAllContentMap( Session session, Namespace namespace ) {

        CoreSession coreSession = (CoreSession) session;
        Map<String, ModelElement> result = null;
        if ( this.CONTAINED_ELEMENTS_BY_NAME != null && isLocatedInMetamodelWorkspace( namespace ) ) {
            result = this.CONTAINED_ELEMENTS_BY_NAME.get( namespace );
            if ( result != null ) {
                return result;
            }
        }
        result = new LinkedHashMap<String, ModelElement>( );
        // get the supertypes
        if ( namespace instanceof GeneralizableElement ) {
            List<GeneralizableElement> superTypes = getAllSupertypes( coreSession, (GeneralizableElement) namespace );
            for ( int i = 0, n = superTypes.size( ); i < n; i++ ) {
                Namespace superType = superTypes.get( i );
                JmiList contents = HACK_getContents( coreSession, superType );
                for ( int j = 0, o = contents.size( coreSession ); j < o; j++ ) {
                    ModelElement element = (ModelElement) contents.get( coreSession, j );
                    result.put( element.getName( ), element );
                }
            }
        }
        JmiList contents = HACK_getContents( coreSession, namespace );
        for ( int i = 0, n = contents.size( coreSession ); i < n; i++ ) {
            ModelElement element = (ModelElement) contents.get( coreSession, i );
            result.put( element.getName( ), element );
        }
        if ( isLocatedInMetamodelWorkspace( namespace ) ) {
            if ( this.CONTAINED_ELEMENTS_BY_NAME == null ) {
                this.CONTAINED_ELEMENTS_BY_NAME = new IdentityHashMap<Namespace, Map<String, ModelElement>>( CACHE_SIZE );
            }
            this.CONTAINED_ELEMENTS_BY_NAME.put( namespace, result );
        }
        return result;
    }

    /**
     * This method computes the collection of enumeration labels of the
     * enumeration type passed and of all super enumeration types
     */
    public Collection<String> getAllEnumerationLabels( EnumerationType enumerationType ) {

        Set<String> set = new LinkedHashSet<String>( enumerationType.getLabels( ) );
        // remove 'empty' labels
        Iterator iter = set.iterator( );
        while ( iter.hasNext( ) ) {
            String label = (String) iter.next( );
            if ( label == null || label.trim( ).length( ) < 1 ) {
                iter.remove( );
            }
        }
        return set;
    }

    public StructureField getStructureFieldByName( Connection connection, StructureType structureType, String fieldName, boolean includeSupertypes ) {

        //FIXME HACK!!!
        CoreConnection conn = (CoreConnection) connection;
        List<StructureField> fields = getStructureFields( conn.getSession( ), structureType, includeSupertypes );
        for ( int i = 0, n = fields.size( ); i < n; i++ ) {
            StructureField field = fields.get( i );
            if ( field.getName( ).equals( fieldName ) ) {
                return field;
            }
        }
        return null;
    }

    public List<StructureField> getStructureFields( SpiSession session, StructureType type, boolean includeSupertypes ) {

        List<StructureField> result = null;
        if ( includeSupertypes ) {
            if ( this.ALL_FIELDS_OF_STRUCTURE_TYPE != null && isLocatedInMetamodelWorkspace( type ) ) {
                result = this.ALL_FIELDS_OF_STRUCTURE_TYPE.get( type );
                if ( result != null ) {
                    return result;
                }
            }
        } else {
            if ( this.FIELDS_OF_STRUCTURE_TYPE != null && isLocatedInMetamodelWorkspace( type ) ) {
                result = this.FIELDS_OF_STRUCTURE_TYPE.get( type );
                if ( result != null ) {
                    return result;
                }
            }
        }
        CoreSession coreSession = ( (CoreSession) session );
        //FIXME HACK!!!
        CoreConnection connection = session != null ? coreSession.getConnections( ).iterator( ).next( ) : null;
        if ( includeSupertypes ) {
            Map<String, ModelElement> allContentMap = getAllContentMap( coreSession, type );
            for ( Entry<String, ModelElement> entry : allContentMap.entrySet( ) ) {
                ModelElement me = entry.getValue( );
                if ( me instanceof StructureField ) {
                    if ( result == null ) {
                        result = new ArrayList<StructureField>( );
                    }
                    result.add( (StructureField) me );
                }
            }
        } else {
            JmiList<ModelElement> contents = (JmiList<ModelElement>) ( (StructureTypeInternal) type ).getContents( connection );
            for ( int i = 0, n = contents.size( coreSession ); i < n; i++ ) {
                ModelElement element = contents.get( coreSession, i );
                if ( element instanceof StructureField ) {
                    if ( result == null ) {
                        result = new ArrayList<StructureField>( );
                    }
                    result.add( (StructureField) element );
                }
            }
        }
        if ( result == null ) {
            result = Collections.emptyList( );
        } else {
            ( (ArrayList<StructureField>) result ).trimToSize( );
        }
        if ( isLocatedInMetamodelWorkspace( type ) ) {
            if ( includeSupertypes ) {
                if ( this.ALL_FIELDS_OF_STRUCTURE_TYPE == null ) {
                    this.ALL_FIELDS_OF_STRUCTURE_TYPE = new IdentityHashMap<StructureType, List<StructureField>>( 128 );
                }
                this.ALL_FIELDS_OF_STRUCTURE_TYPE.put( type, result );
            } else {
                if ( this.FIELDS_OF_STRUCTURE_TYPE == null ) {
                    this.FIELDS_OF_STRUCTURE_TYPE = new IdentityHashMap<StructureType, List<StructureField>>( 128 );
                }
                this.FIELDS_OF_STRUCTURE_TYPE.put( type, result );
            }
        }
        return result;
    }

    public boolean isTranslatableText( SpiSession session, StructureType type ) {

        CoreSession coreSession = ( (CoreSession) session );
        //FIXME HACK!!!
        CoreConnection connection = session != null ? coreSession.getConnections( ).iterator( ).next( ) : null;
        List<GeneralizableElement> superTypes = ( (StructureTypeInternal) type ).allSupertypes( connection );
        List<String> typeQNames = new ArrayList<String>( superTypes.size( ) + 1 );
        typeQNames.add( QualifiedName.toDotSeparatedString( ( (StructureTypeInternal) type ).getQualifiedName( connection ) ) );
        for ( GeneralizableElement generalizableElement : superTypes ) {
            typeQNames.add( QualifiedName.toDotSeparatedString( ( (GeneralizableElementInternal) generalizableElement ).getQualifiedName( connection ) ) );
        }
        return typeQNames.contains( SpiJmiHelper.TRANSLATABLE_TEXT_QNAME );
    }

    public boolean isTranslatableTextFragment( SpiSession session, StructureType type ) {

        CoreSession coreSession = ( (CoreSession) session );
        //FIXME HACK!!!
        CoreConnection connection = session != null ? coreSession.getConnections( ).iterator( ).next( ) : null;
        List<GeneralizableElement> superTypes = ( (StructureTypeInternal) type ).allSupertypes( connection );
        List<String> typeQNames = new ArrayList<String>( superTypes.size( ) + 1 );
        typeQNames.add( QualifiedName.toDotSeparatedString( ( (StructureTypeInternal) type ).getQualifiedName( connection ) ) );
        for ( GeneralizableElement generalizableElement : superTypes ) {
            typeQNames.add( QualifiedName.toDotSeparatedString( ( (GeneralizableElementInternal) generalizableElement ).getQualifiedName( connection ) ) );
        }
        return typeQNames.contains( SpiJmiHelper.TRANSLATABLE_TEXT_FRAGMENT_QNAME );
    }

    public boolean hasTranslatableTextFragmentAttribute( SpiSession session, MofClass mofClass ) {

        return !getTranslatableTextFragmentAttributes( session, mofClass ).isEmpty( );
    }

    public String getSubstituteName( Connection connection, ModelElement modelElement ) {

        Tag substituteNameTag = getTag( connection.getSession( ), modelElement, JMI_TAG_ID_SUBSTITUTE_NAME );
        if ( substituteNameTag != null ) {
            return substituteNameTag.getValues( ).get( 0 );
        }
        return null;
    }

    public String getJavaReturnInitialValueByType( String type ) {

        String str = "null"; //$NON-NLS-1$
        if ( type.compareToIgnoreCase( "boolean" ) == 0 ) { //$NON-NLS-1$
            str = "false"; //$NON-NLS-1$
        } else if ( type.compareToIgnoreCase( "unlimitedinteger" ) == 0 ) { //$NON-NLS-1$
            str = "0"; //$NON-NLS-1$
        } else if ( type.compareToIgnoreCase( "integer" ) == 0 ) { //$NON-NLS-1$
            str = "0"; //$NON-NLS-1$
        } else if ( type.compareToIgnoreCase( "int" ) == 0 ) { //$NON-NLS-1$
            str = "0"; //$NON-NLS-1$
        } else if ( type.compareToIgnoreCase( "long" ) == 0 ) { //$NON-NLS-1$
            str = "0l"; //$NON-NLS-1$
        } else if ( type.compareToIgnoreCase( "float" ) == 0 ) { //$NON-NLS-1$
            str = "0f"; //$NON-NLS-1$
        } else if ( type.compareToIgnoreCase( "double" ) == 0 ) { //$NON-NLS-1$
            str = "0d"; //$NON-NLS-1$
        }
        return str;
    }

    public Object getJavaReturnInitialWrapperValueFromClassifier( Connection connection, Classifier classifier ) {

        //TODO change signature to session
        CoreSession session = (CoreSession) ( connection != null ? connection.getSession( ) : null );
        Object result = null;
        classifier = getNonAliasType( session, classifier );
        if ( classifier instanceof PrimitiveType ) {
            PrimitiveType primitiveType = (PrimitiveType) classifier;
            String name = primitiveType.getName( );
            if ( name.equals( "String" ) ) { //$NON-NLS-1$
                result = null;
            } else {
                if ( name.equals( "Boolean" ) ) { //$NON-NLS-1$
                    result = Boolean.valueOf( getJavaReturnInitialValueByType( "boolean" ) ); //$NON-NLS-1$
                } else if ( name.equals( "Integer" ) ) { //$NON-NLS-1$
                    result = Integer.valueOf( getJavaReturnInitialValueByType( "integer" ) ); //$NON-NLS-1$
                } else if ( name.equals( "Long" ) ) { //$NON-NLS-1$
                    result = Long.valueOf( getJavaReturnInitialValueByType( "integer" ) ); // note //$NON-NLS-1$
                    // that
                    // specifying
                    // "long"
                    // here does not work
                } else if ( name.equals( "Float" ) ) { //$NON-NLS-1$
                    result = new Float( getJavaReturnInitialValueByType( "float" ) ); //$NON-NLS-1$
                } else if ( name.equals( "Double" ) ) { //$NON-NLS-1$
                    result = new Double( getJavaReturnInitialValueByType( "double" ) ); //$NON-NLS-1$
                }
            }
        }
        return result;
    }

    private void assertValidEndNumber( byte end ) {

        if ( !this.isValidEndNumber( end ) ) {
            throw new MoinLocalizedBaseRuntimeException( JmiUtilMessages.NOVALIDENDNUMBER, end );
        }
    }

    public boolean isOrdered( SpiSession session, RefObject metaObject, byte endNumber ) {

        this.assertValidEndNumber( endNumber );
        return getOrderedEnd( session, metaObject ) == endNumber;
    }

    public byte getOrderedEnd( SpiSession session, RefObject metaObject ) {

        byte result = -1;
        boolean ordered = false;
        if ( metaObject instanceof Attribute ) {
            ordered = ( (Attribute) metaObject ).getMultiplicity( ).isOrdered( );
            if ( ordered ) {
                result = 1;
            }
        } else if ( metaObject instanceof Association ) {
            return getOrderedEnd( session, (Association) metaObject );
        } else {
            throw new MoinLocalizedBaseRuntimeException( JmiUtilMessages.OBJECTNOATTORASSOC, metaObject.toString( ) );
        }
        return result;
    }

    public byte getOrderedEnd( SpiSession session, Association association ) {

        AssociationExtent assocExtent = (AssociationExtent) getRefAssociationForAssociation( session, association );
        if ( assocExtent != null ) {
            // The association is deployed. Return the information cached in the extent.
            byte result = assocExtent.get___OrderedEnd( );
            if ( result == Byte.MIN_VALUE ) { // not cached yet
                result = getOrderedEndInternal( session, association );
                assocExtent.set___OrderedEnd( result );
            }
            return result;
        }
        // Not deployed. We have to compute the result based on the current situation.
        return getOrderedEndInternal( session, association );
    }

    private byte getOrderedEndInternal( SpiSession session, Association association ) {

        List<AssociationEnd> associationEnds = getAssociationEnds( session, association );
        for ( int i = 0, size = associationEnds.size( ); i < size; i++ ) {
            AssociationEnd associationEnd = associationEnds.get( i );
            if ( associationEnd.getMultiplicity( ).isOrdered( ) ) {
                return (byte) i;
            }
        }
        return -1;
    }

    public ModelElement lookupElementExtended( Connection connection, GeneralizableElement namespace, String nameToSearch ) throws NameNotFoundException {

        CoreConnection conn = (CoreConnection) connection;
        ModelElement result = null;
        Map<String, ModelElement> allContentMap = getAllContentMap( connection.getSession( ), namespace );
        result = allContentMap.get( nameToSearch );
        if ( result == null && namespace instanceof MofPackage ) {
            // For MofPackages, we also have to check all instances of 'Import'
            // and their imported namespaces.
            for ( ModelElement containedElement : allContentMap.values( ) ) {
                if ( containedElement instanceof Import ) {
                    Namespace importedNamespace = ( (ImportImpl) containedElement ).getImportedNamespace( conn );
                    if ( importedNamespace.getName( ).equals( nameToSearch ) ) {
                        return importedNamespace;
                    }
                }
            }
        }
        if ( result == null ) {
            throw new NameNotFoundException( nameToSearch );
        }
        return result;
    }

    public Collection<RefObject> getCompositeChildren( Session session, RefObject rootElement, boolean recursively ) {

        CoreSession coreSession = (CoreSession) session;
        CorePartitionable partitionable = (CorePartitionable) rootElement;
        if ( recursively ) {
            return getAllComponentChildrenRecursive( coreSession, partitionable );
        }
        return (Collection) partitionable.get___Workspace( ).getWorkspaceSet( ).getLogicalLinkManager( ).getComponentChildren( coreSession, partitionable );
    }

    private final List<RefObject> getAllComponentChildrenRecursive( CoreSession session, CorePartitionable parent ) {

        List<RefObject> result = null;
        Collection<CorePartitionable> componentChildren = parent.get___Workspace( ).getWorkspaceSet( ).getLogicalLinkManager( ).getComponentChildren( session, parent );
        if ( !componentChildren.isEmpty( ) ) {
            result = new ArrayList<RefObject>( componentChildren.size( ) );
            for ( CorePartitionable componentChild : componentChildren ) {
                result.add( (RefObject) componentChild );
                result.addAll( getAllComponentChildrenRecursive( session, componentChild ) );
            }
            return result;
        }
        return Collections.emptyList( );
    }

    public List<RefObject> getCompositeChildrenStable( Session session, RefObject rootElement, boolean recursively ) {

        CoreSession coreSession = (CoreSession) session;
        CorePartitionable rootElementPartitionable = (CorePartitionable) rootElement;
        Workspace workspace = rootElementPartitionable.get___Workspace( );
        WorkspaceSet workspaceSet = workspace.getWorkspaceSet( );
        MemoryLinkManager memoryLinkManager = workspace.getMemoryLinkManager( );
        Collection<EndStorageLink> directChildrenLinks = workspaceSet.getLogicalLinkManager( ).getComponentChildrenLinks( coreSession, rootElementPartitionable );

        Collection<EndAndMetaObject> relevantEndAndMetaObjects = new HashSet<EndAndMetaObject>( );

        for ( EndStorageLink link : directChildrenLinks ) {
            int compositeEndNumber = link.getCompositeEnd( );
            RefObject metaObject = link.getMetaObject( );
            EndAndMetaObject endAndMetaObject = workspaceSet.getEndAndMetaObjectPool( ).getEndAndMetaObject( compositeEndNumber, metaObject );
            relevantEndAndMetaObjects.add( endAndMetaObject );
        }

        List<EndAndMetaObject> orderedEndAndMetaObjects = new ArrayList<EndAndMetaObject>( relevantEndAndMetaObjects );
        Collections.sort( orderedEndAndMetaObjects, new Comparator<EndAndMetaObject>( ) {

            public int compare( EndAndMetaObject o1, EndAndMetaObject o2 ) {

                int mofIdComparison = o1.getMetaObjectMofId( ).compareTo( o2.getMetaObjectMofId( ) );
                if ( mofIdComparison != 0 ) {
                    return mofIdComparison;
                } else {//mofIds are the same, compare the end number of the from ends
                    byte thisVal = o1.getFromEnd( );
                    byte anotherVal = o2.getFromEnd( );
                    return ( thisVal < anotherVal ? -1 : ( thisVal == anotherVal ? 0 : 1 ) );
                }
            }
        } );

        List<RefObject> result = new ArrayList<RefObject>( );
        for ( int i = 0, size = orderedEndAndMetaObjects.size( ); i < size; i++ ) {
            Collection<EndStorageLink> linksForEndAndMetaObject = memoryLinkManager.getLinksForEndAndMetaObject( coreSession, orderedEndAndMetaObjects.get( i ), rootElementPartitionable.get___Mri( ) );
            for ( EndStorageLink endStorageLink : linksForEndAndMetaObject ) {
                result.add( (RefObject) endStorageLink.getEnd( endStorageLink.getComponentEnd( ) ).get( coreSession ) );
            }
        }

        if ( recursively ) {

            if ( result.isEmpty( ) ) {
                return result;
            } else {
                Collection<RefObject> children = new ArrayList<RefObject>( );
                for ( RefObject refObject : result ) {
                    children.addAll( getCompositeChildrenStable( coreSession, refObject, recursively ) );
                }
                result.addAll( children );
                return result;
            }
        }

        return result;
    }

    public Collection<PRI> getAffectedPartitionsForRefDelete( Session session, RefObject rootElement ) {

        CoreSession coreSession = (CoreSession) session;
        List<CorePartitionable> instancesToDelete = new ArrayList( getAllComponentChildrenRecursive( coreSession, (CorePartitionable) rootElement ) );
        instancesToDelete.add( (CorePartitionable) rootElement );
        Set<PRI> affectedPartitionsPri = new HashSet<PRI>( );
        // Get all element PRIs and calculate all links
        for ( int i = 0, n = instancesToDelete.size( ); i < n; i++ ) {
            affectedPartitionsPri.add( instancesToDelete.get( i ).get___Mri( ).getPri( ) );
            // Calculate link PRIs
            List<EndStorageLink> linksForElement = getLogicalLinkManager( ).getLinksForElement( coreSession, instancesToDelete.get( i ) );
            for ( int j = 0, m = linksForElement.size( ); j < m; j++ ) {
                EndStorageLink linkToDelete = linksForElement.get( j );
                affectedPartitionsPri.add( linkToDelete.getStorageEnd( ).getPri( ) );
            }
        }
        return affectedPartitionsPri;
    }

    private final LogicalLinkManager getLogicalLinkManager( ) {

        return this.moin.getLogicalLinkManager( );
    }

    public Collection<Association> getCompositeAssociations( Connection connection, MofClass parentClass, MofClass childClass ) {

        Collection<AssociationEnd> parentEnds = getAssociationEnds( connection.getSession( ), parentClass, true );
        Collection<AssociationEnd> childEnds = getAssociationEnds( connection.getSession( ), childClass, true );
        Set<Association> parentAssocs = new HashSet<Association>( parentEnds.size( ) );
        CoreConnection conn = (CoreConnection) connection;
        for ( AssociationEnd end : parentEnds ) {
            if ( AggregationKindEnum.COMPOSITE.equals( end.getAggregation( ) ) ) {
                parentAssocs.add( (Association) ( (RefObjectImpl) end ).refImmediateComposite( conn.getSession( ) ) );
            }
        }
        Set<Association> commonAssocs = new HashSet<Association>( parentAssocs.size( ) );
        for ( AssociationEnd end : childEnds ) {
            if ( !AggregationKindEnum.COMPOSITE.equals( end.getAggregation( ) ) ) {
                Association assoc = (Association) ( (RefObjectImpl) end ).refImmediateComposite( conn.getSession( ) );
                if ( parentAssocs.contains( assoc ) ) {
                    commonAssocs.add( assoc );
                }
            }
        }
        return commonAssocs;
    }

    public Extent getExtentForModelElement( Session session, ModelElement element ) {

        if ( element == null ) {
            throw new MoinIllegalNullArgumentException( "modelElement" ); //$NON-NLS-1$
        }
        CoreSession coreSession = (CoreSession) session;
        //FIXME HACK!!!
        CoreConnection connection = coreSession != null ? coreSession.getConnections( ).iterator( ).next( ) : null;

        ExtentManager extentManager = moin.getExtentManager( );
        String mofId = element.refMofId( );
        List<String> qualifiedName = ( (ModelElementInternal) element ).getQualifiedName( connection );
        String[] qName = qualifiedName.toArray( new String[qualifiedName.size( )] );
        String modelContainerName = ( (CorePartitionable) element ).get___Partition( ).getPri( ).getContainerName( );
        return extentManager.selectExtent( mofId, qName, modelContainerName );
    }

    public RefPackage getRefPackageForMofPackage( Session session, MofPackage mofPackage ) {

        if ( !( (CorePartitionable) mofPackage ).get___Workspace( ).isMetamodelWorkspace( ) ) {
            return null; //there are only extents for deployed metamodel elements
        }
        Extent result = ( (RefObjectExtension) mofPackage ).get___Extent( );
        if ( result == null ) {
            result = getExtentForModelElement( session, mofPackage );

            ( (RefObjectExtension) mofPackage ).set___Extent( result );

        }
        return (RefPackage) result;
    }

    public RefAssociation getRefAssociationForAssociation( Session session, Association association ) {

        if ( !( (CorePartitionable) association ).get___Workspace( ).isMetamodelWorkspace( ) ) {
            return null; //there are only extents for deployed metamodel elements
        }
        Extent result = ( (RefObjectExtension) association ).get___Extent( );
        if ( result == null ) {
            result = getExtentForModelElement( session, association );
            ( (RefObjectExtension) association ).set___Extent( result );

        }
        return (RefAssociation) result;
    }

    @Deprecated
    public RefAssociation getRefAssociationForAssociation( Connection connection, Association association ) {

        Session session = connection != null ? connection.getSession( ) : null;
        return getRefAssociationForAssociation( session, association );
    }

    public RefClass getRefClassForMofClass( Session session, MofClass mofClass ) {

        if ( !( (CorePartitionable) mofClass ).get___Workspace( ).isMetamodelWorkspace( ) ) {
            return null; //there are only extents for deployed metamodel elements
        }
        Extent result = ( (RefObjectExtension) mofClass ).get___Extent( );

        if ( result == null ) {
            result = getExtentForModelElement( session, mofClass );
            ( (RefObjectExtension) mofClass ).set___Extent( result );

        }
        return (RefClass) result;
    }

    public <T extends RefStruct> T cloneStruct( Connection connection, T structToClone, StructureFieldContainer<? extends T> containerForFieldsToSet ) {

        CoreConnection coreConnection = (CoreConnection) connection;
        List<String> originalFields = structToClone.refFieldNames( );
        List<Object> clonedValues = new ArrayList<Object>( originalFields.size( ) );
        if ( containerForFieldsToSet != null ) {
            Map<String, Object> containerFields = containerForFieldsToSet.getNamedFields( );
            for ( String originalField : originalFields ) {
                if ( containerFields.keySet( ).contains( originalField ) ) {
                    clonedValues.add( containerFields.get( originalField ) );
                } else {
                    clonedValues.add( structToClone.refGetValue( originalField ) );
                }
            }
        } else {
            for ( String originalField : originalFields ) {
                clonedValues.add( structToClone.refGetValue( originalField ) );
            }
        }
        List<String> structQName = structToClone.refTypeName( );
        String[] structPackageQName = structQName.subList( 0, structQName.size( ) - 1 ).toArray( new String[structQName.size( ) - 1] );
        String structName = structQName.get( structQName.size( ) - 1 );
        RefPackageImpl structPackage = (RefPackageImpl) coreConnection.getPackage( null, structPackageQName );
        return (T) structPackage.refCreateStruct( coreConnection, structName, clonedValues );
    }

    public Classifier getType( Session session, TypedElement typedElement ) {

        Classifier result = null;
        if ( this.TYPE_OF_TYPED_ELEMENT != null && isLocatedInMetamodelWorkspace( typedElement ) ) {
            result = this.TYPE_OF_TYPED_ELEMENT.get( typedElement );
            if ( result != null ) {
                return result;
            }
        }
        //FIXME HACK!!!
        CoreConnection connection = session != null ? ( (CoreSession) session ).getConnections( ).iterator( ).next( ) : null;
        result = ( (TypedElementInternal) typedElement ).getType( connection );
        if ( result != null && isLocatedInMetamodelWorkspace( typedElement ) ) {
            if ( this.TYPE_OF_TYPED_ELEMENT == null ) {
                this.TYPE_OF_TYPED_ELEMENT = new IdentityHashMap<TypedElement, Classifier>( CACHE_SIZE );
            }
            this.TYPE_OF_TYPED_ELEMENT.put( typedElement, result );
        }
        return result;
    }

    public boolean isQueryNeededForNavigation( Attribute attribute ) {

        byte storedEnd = this.getStoredEnd( attribute );
        // "0" is always the "fromEnd" with attributes
        return isQueryNeededForNavigation( storedEnd, 0 );
    }

    public boolean isQueryNeededForNavigation( SpiSession session, Association association, int fromEnd ) {

        byte storedEnd = this.getStoredEnd( session, association );
        return isQueryNeededForNavigation( storedEnd, fromEnd );
    }

    public int getAttributeToEndNumber( Attribute attribute ) {

        return 1;
    }

    private boolean isQueryNeededForNavigation( byte storedEnd, int fromEnd ) {

        boolean result;

        if ( storedEnd == fromEnd ) {
            // the end where navigation starts is stored, therefore all
            // links are available in memory
            result = false;
        } else {// the end which is navigated to is stored, therefore a
            // query might be needed
            result = true;
        }

        return result;
    }

    public String getJMIPackageIdentifierQualified( Connection connection, Namespace namespace ) {

        CoreConnection coreConnection = (CoreConnection) connection;
        CoreSession session = coreConnection.getSession( );
        if ( namespace == null ) {
            return ""; //$NON-NLS-1$
        }
        List<String> list = new LinkedList<String>( );
        // Use the Packages of the containers ONLY
        // example in JMI TCK: Structure or Enumeration defined in Classs
        // there may be a tag with a prefix
        ModelElement container = ( (NamespaceInternal) namespace ).getContainer( coreConnection );
        while ( container != null ) {
            Tag tagJmiPrefix = null;
            if ( container instanceof MofPackage ) {
                MofPackage mp = (MofPackage) container;
                list.add( 0, mp.getName( ) );
                tagJmiPrefix = getTag( session, mp, JMI_TAG_ID_PACKAGE_PREFIX );
                if ( tagJmiPrefix != null ) {
                    list.addAll( 0, Utilities.getUtilities( ).decodeQualifiedName( tagJmiPrefix.getValues( ).get( 0 ) ) );
                }
            }
            // The MOF 1.4 XMI file contains a MOF prefix AND a JMI prefix
            // If the JMI prefix is present, don't use the MOF prefix, too
            if ( tagJmiPrefix == null && container instanceof Namespace ) {
                // there may be a tag with a prefix
                Tag tag = getTagPrefix( coreConnection, (Namespace) container );
                if ( tag != null ) {
                    String value = null;
                    List<String> values = tag.getValues( );
                    if ( values != null && values.size( ) > 0 ) {
                        value = values.get( 0 );
                    }
                    if ( value != null ) {
                        List<String> prefix = Utilities.getUtilities( ).decodeQualifiedName( value );
                        list.addAll( 0, prefix );
                    }
                }
            }
            container = ( (ModelElementInternal) container ).getContainer( coreConnection );
        }

        Tag tagJmiPrefix = getTag( session, namespace, JMI_TAG_ID_PACKAGE_PREFIX );
        if ( tagJmiPrefix != null ) {
            list.addAll( 0, Utilities.getUtilities( ).decodeQualifiedName( tagJmiPrefix.getValues( ).get( 0 ) ) );
        } else {
            Tag tag = getTagPrefix( coreConnection, namespace );
            if ( tag != null ) {
                String value = null;
                List<String> values = tag.getValues( );
                if ( values != null && values.size( ) > 0 ) {
                    value = values.get( 0 );
                }
                if ( value != null ) {
                    List<String> prefix = Utilities.getUtilities( ).decodeQualifiedName( value );
                    list.addAll( 0, prefix );
                }
            }
        }

        StringBuilder b = new StringBuilder( );
        Iterator<String> iter = list.iterator( );
        while ( iter.hasNext( ) ) {
            b.append( correctName( iter.next( ), false ).toLowerCase( Locale.ENGLISH ) );
            if ( iter.hasNext( ) ) {
                b.append( Utilities.JAVA_PACKAGE_DELIMITER );
            }
        }

        return b.toString( );
    }

    private Tag getTagPrefix( CoreConnection connection, Namespace ns ) {

        JmiList<ModelElement> contents = (JmiList<ModelElement>) ( (NamespaceInternal) ns ).getContents( connection );
        Iterator<ModelElement> contentsIterator = contents.iteratorReadOnly( connection.getSession( ) );
        for ( ; contentsIterator.hasNext( ); ) {
            ModelElement me = contentsIterator.next( );
            if ( me instanceof Tag ) {
                Tag tag = (Tag) me;
                if ( tag.getTagId( ).compareTo( TAG_IDL_PREFIX ) == 0 ) {
                    return tag;
                }
            }
        }
        return null;
    }

    public String correctName( String name, boolean forConstant ) {

        if ( name == null ) {
            return null;
        }
        // JMI specification 4.7.1 and 4.7.2 (page 53ff)
        // remove non-sig ::= {'_' | '-' | white-space }
        StringBuilder sb = new StringBuilder( );
        StringTokenizer st = new StringTokenizer( name, NON_SIG_CHARS );
        while ( st.hasMoreTokens( ) ) {
            StringBuilder s = correctWord( st.nextToken( ), forConstant );
            if ( s.charAt( 0 ) == '_' ) {
                s = (StringBuilder) s.subSequence( 1, s.length( ) - 1 );
            }
            if ( s.charAt( s.length( ) - 1 ) == '_' ) {
                s = (StringBuilder) s.subSequence( 0, s.length( ) - 1 );
            }
            sb.append( s );
            if ( forConstant && st.hasMoreTokens( ) ) {
                sb.append( '_' );
            }
        }
        if ( forConstant ) {
            return sb.toString( ).toUpperCase( Locale.ENGLISH );
        } else {
            return sb.toString( );
        }
    }

    private StringBuilder correctWord( String word, boolean forConstant ) {

        StringBuilder b = new StringBuilder( word.length( ) );
        // s = s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
        // first char must be upper
        // Specification says: All others must be lower
        // Conflict: The word may already contain a 'SmallTalk'-like name with upper/lower
        char cLast = ' ';
        for ( int i = 0; i < word.length( ); i++ ) {
            final char c = word.charAt( i );
            if ( i == 0 ) {
                b.append( Character.toUpperCase( c ) );
            } else {
                if ( Character.isUpperCase( c ) ) {
                    if ( Character.isUpperCase( cLast ) ) {
                        b.append( Character.toLowerCase( c ) );
                    } else {
                        if ( forConstant ) {
                            b.append( '_' );
                        }
                        b.append( c );
                    }
                } else {
                    b.append( c );
                }
            }
            cLast = c;
        }
        return b;
    }

    public String getJmiInterfaceName( Connection connection, Namespace namespace ) {

        StringBuilder b = new StringBuilder( );
        b.append( getJMIPackageIdentifierQualified( connection, namespace ) );
        b.append( Utilities.JAVA_PACKAGE_DELIMITER );
        String jmiIdentifier = getJMIIdentifier( connection, namespace );
        if ( namespace instanceof MofPackage ) {
            b.append( jmiIdentifier.toLowerCase( Locale.ENGLISH ) );
            b.append( Utilities.JAVA_PACKAGE_DELIMITER );
            b.append( jmiIdentifier );
            b.append( "Package" ); //$NON-NLS-1$
        } else {
            b.append( jmiIdentifier );
        }
        return b.toString( );
    }

    public String getJmiPackageName( Connection connection, MofPackage mofPackage ) {

        StringBuilder b = new StringBuilder( );
        b.append( getJMIPackageIdentifierQualified( connection, mofPackage ) );
        b.append( Utilities.JAVA_PACKAGE_DELIMITER );
        b.append( getJMIIdentifier( connection, mofPackage ).toLowerCase( Locale.ENGLISH ) );
        return b.toString( );
    }

    public String getJMIIdentifier( Connection connection, ModelElement modelElement ) {

        String identifier = modelElement.getName( );
        // Substitute Identifier of JMI specification
        String ident = getSubstituteName( connection, modelElement );
        if ( ident != null ) {
            identifier = ident;
        } // type specific rules
        if ( modelElement instanceof MofPackage ) {
            identifier = correctName( identifier, false );
            identifier = StringUtils.convertFirstCharToUpper( identifier );
        } else if ( modelElement instanceof MofClass ) {
            identifier = correctName( identifier, false );
            identifier = StringUtils.convertFirstCharToUpper( identifier );
        } else if ( modelElement instanceof Operation ) {
            identifier = correctName( identifier, false );
            identifier = StringUtils.convertFirstCharToLower( identifier );
        } else if ( modelElement instanceof Attribute ) {
            identifier = correctName( identifier, false );
            identifier = StringUtils.convertFirstCharToLower( identifier );
        } else if ( modelElement instanceof Reference ) {
            identifier = correctName( identifier, false );
            identifier = StringUtils.convertFirstCharToLower( identifier );
        } else if ( modelElement instanceof StructureField ) {
            identifier = correctName( identifier, false );
            identifier = StringUtils.convertFirstCharToLower( identifier );
        } else if ( modelElement instanceof Constant ) {
            identifier = correctName( identifier, true );
            identifier = StringUtils.convertFirstCharToUpper( identifier );
        } else if ( modelElement instanceof EnumerationType ) {
            identifier = correctName( identifier, false );
            identifier = StringUtils.convertFirstCharToUpper( identifier );
        } else if ( modelElement instanceof MofException ) {
            identifier = correctName( identifier, false );
            identifier = StringUtils.convertFirstCharToUpper( identifier );
            // at the end?
            int n = identifier.indexOf( EXTENSION_EXCEPTION );
            if ( ( n + EXTENSION_EXCEPTION.length( ) ) != identifier.length( ) ) {
                identifier += EXTENSION_EXCEPTION;
            }
        } else {
            identifier = correctName( identifier, false );
            identifier = StringUtils.convertFirstCharToUpper( identifier );
        }
        return identifier;
    }

    public String getQualifiedName( SpiSession session, ModelElement modelElement ) {

        //FIXME HACK!!!
        CoreSession coreSession = (CoreSession) session;
        CoreConnection connection = coreSession != null ? coreSession.getConnections( ).iterator( ).next( ) : null;
        return QualifiedName.toDotSeparatedString( ( (ModelElementInternal) modelElement ).getQualifiedName( connection ) );
    }

    public MultiplicityType createMultiplicityType( Connection connection, int lower, int upper, boolean isOrdered, boolean isUnique ) {

        //FIXME HACK!!!
        CoreConnection coreConnection = (CoreConnection) connection;
        MultiplicityType.Descriptors desc = MultiplicityType.DESCRIPTORS;
        StructureFieldContainer<MultiplicityType> container = new StructureFieldContainer<MultiplicityType>( );
        container.put( desc.LOWER( ), lower ).put( desc.UPPER( ), upper ).put( desc.IS_ORDERED( ), isOrdered ).put( desc.IS_UNIQUE( ), isUnique );
        return ( (ModelPackageInternal) coreConnection.getPackage( ModelPackage.PACKAGE_DESCRIPTOR ) ).createMultiplicityType( coreConnection, container );
    }

    private JmiList HACK_getSupertypes( CoreSession session, GeneralizableElement generalizableElement ) {

        //FIXME HACK!!! 
        CoreConnection connection = session != null ? session.getConnections( ).iterator( ).next( ) : null;
        return (JmiList) ( (GeneralizableElementInternal) generalizableElement ).getSupertypes( connection );
    }

    private JmiList HACK_getContents( CoreSession session, Namespace namespace ) {

        //FIXME HACK!!! 
        CoreConnection connection = session != null ? session.getConnections( ).iterator( ).next( ) : null;
        return (JmiList) ( (NamespaceInternal) namespace ).getContents( connection );
    }
}
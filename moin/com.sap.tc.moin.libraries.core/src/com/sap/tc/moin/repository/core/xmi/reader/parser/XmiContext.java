package com.sap.tc.moin.repository.core.xmi.reader.parser;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.mmi.model.AliasType;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.TypedElement;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.AttributeInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ClassifierInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.EnumerationTypeInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ModelElementInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.MofClassInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.NamespaceInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.PrimitiveTypeInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ReferenceInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.StructuralFeatureInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.StructureTypeInternal;
import com.sap.tc.moin.repository.mmi.reflect.RefEnum;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefStruct;

import org.xml.sax.Attributes;

import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.WorkspaceSet;
import com.sap.tc.moin.repository.core.xmi.MetamodelCache;
import com.sap.tc.moin.repository.core.xmi.XmiConstants;
import com.sap.tc.moin.repository.core.xmi.reader.CrossPartitionReference;
import com.sap.tc.moin.repository.core.xmi.reader.InstanceInfo;
import com.sap.tc.moin.repository.core.xmi.reader.LinkEnd;
import com.sap.tc.moin.repository.core.xmi.reader.LinkInfo;
import com.sap.tc.moin.repository.core.xmi.reader.TypeHelper;
import com.sap.tc.moin.repository.core.xmi.reader.XmiParseException;
import com.sap.tc.moin.repository.core.xmi.reader.XmiReaderImpl;
import com.sap.tc.moin.repository.core.xmi.util.XmiHrefUtil;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.messages.core.XMI;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;

/**
 * The XmiContext is the central class of the XMI reading scenario. It serves as
 * the global data container, storing all information found in the XMI
 * document(s) during parsing. Every
 * {@link com.sap.tc.moin.repository.core.xmi.reader.XmiReaderImpl} instance
 * holds exactly one instance of XmiContext, which is created once during the
 * XmiReader's construction, re-initialized before every <code>read</code>
 * operation, and cleaned up afterwards.
 * <p>
 * During the parsing process, a lot of instances of
 * {@link com.sap.tc.moin.repository.core.xmi.reader.parser.XmiElement} and
 * subclasses thereof are created. They all have access to the XmiContext
 * instance, which is passed as a constructor parameter, and thus can use the
 * context to query and modify the data that was already parsed.
 * <p>
 * For accomplishing its tasks, the XmiContext makes use of some helper classes.
 * The pure SAX parsing is handled by an instance of
 * {@link com.sap.tc.moin.repository.core.xmi.reader.parser.SaxReader}. All
 * methods providing type related services delegate to an instance of
 * {@link com.sap.tc.moin.repository.core.xmi.reader.TypeHelper}. When it comes
 * to creating new model elements or links, or querying existing repository
 * content, the method calls are delegated to an instance of
 * {@link com.sap.tc.moin.repository.core.xmi.reader.RepositoryService}.
 */
@SuppressWarnings( "unchecked" )
class XmiContext {

    /**
     * The {@link MetamodelCache} instance used by this XmiContext instance, for
     * quick access to the metamodel of the currently processed model.
     */
    private MetamodelCache mmCache;

    /**
     * The {@link TypeHelper} instance used by this XmiContext instance for
     * performing type lookups.
     */
    private TypeHelper typeHelper;

    /**
     * The URI of the XMI document that is currently being processed.
     */
    private String currentURI;

    /**
     * This map stores for each XMI document (represented by its URI) all
     * already resolved XMI references, by mapping the successfully resolved
     * <code>xmi.id</code> to the created {@link InstanceInfo} instance.
     */
    private Map<String /* uri */, Map<String /* xmiId */, InstanceInfo>> resolvedXmiReferences;

    /**
     * This map stores for each XMI document (represented by its URI) all still
     * unresolved XMI references. An entry is added to this map if an
     * <code>xmi.idref</code> attribute or a <code>href</code> attribute is
     * encountered, and the referenced RefObject instance is not found in the
     * {@link #resolvedXmiReferences} map.
     */
    private Map<String /* uri */, Map<String /* xmiId */, List<UnresolvedReference>>> unresolvedXmiReferences;

    /**
     * Shared {@link PrimitiveValue} instance. Can be re-initialized by calling
     * the {@link PrimitiveValue#init(XmiElement, PrimitiveType, Attributes)}
     * method.
     */
    private PrimitiveValue sharedPrimitiveValue;

    /**
     * Shared {@link EnumerationValue} instance. Can be re-initialized by
     * calling the
     * {@link EnumerationValue#init(XmiElement, EnumerationType, Attributes)}
     * method.
     */
    private EnumerationValue sharedEnumerationValue;

    /**
     * Shared {@link ReferenceValue} instance. Can be re-initialized by calling
     * the {@link ReferenceValue#init(XmiElement, String)} or
     * {@link ReferenceValue#initExternal(XmiElement, String, String)} methods.
     */
    private ReferenceValue sharedReferenceValue;

    /**
     * This set stores all model elements that were found during parsing.
     */
    private Set<InstanceInfo> modelElements;

    /**
     * This map stores all links of associations that were found during parsing.
     */
    private Map<AssociationInternal, Set<LinkInfo>> links;

    /**
     * This map stores the values of <code>order</code> attributes found during
     * the loading of a model partition.
     */
    private Map<AssociationInternal, Map<PairOfMofIds, Double>> linkOrderings;

    /**
     * This map stores all values of classifier-level attributes that were found
     * during parsing.
     */
    private Map<AttributeInternal, Object> staticAttributesToSet;

    /**
     * This set stores all InstanceInfo instances of packages for which an
     * import to the PrimitiveTypes package has been created (only relevant if
     * MOF 1.3 legacy metamodels are imported that contain Corba type
     * definitions).
     */
    private Set<InstanceInfo> primitiveTypesImports;

    private Set<String /* metamodel container name */> metamodelToplevelPackages;

    /**
     * The owning {@link XmiParser} instance. The context needs to know it in
     * order to be able to {@link XmiParser#queueDocument(String, String) queue}
     * additional XMI documents.
     */
    private XmiParser xmiParser;

    private final boolean isMofMode;

    private CoreSession session;

    private WorkspaceSet workspaceSet;

    /**
     * Creates a new instance of XmiContext and performs one-time
     * initializations of member variables. The constructor is called by
     * {@link XmiReaderImpl} only.
     */
    XmiContext( CoreSession session, WorkspaceSet workspaceSet, XmiParser parser, TypeHelper th, boolean mofMode ) {

        this.session = session;
        xmiParser = parser;
        typeHelper = th;
        sharedPrimitiveValue = new PrimitiveValue( this );
        sharedEnumerationValue = new EnumerationValue( this );
        sharedReferenceValue = new ReferenceValue( this );
        resolvedXmiReferences = new LinkedHashMap<String, Map<String, InstanceInfo>>( );
        unresolvedXmiReferences = new LinkedHashMap<String, Map<String, List<UnresolvedReference>>>( );
        modelElements = new LinkedHashSet<InstanceInfo>( );
        links = new LinkedHashMap<AssociationInternal, Set<LinkInfo>>( );
        linkOrderings = new HashMap<AssociationInternal, Map<PairOfMofIds, Double>>( );
        staticAttributesToSet = new LinkedHashMap<AttributeInternal, Object>( );
        primitiveTypesImports = new HashSet<InstanceInfo>( );
        metamodelToplevelPackages = new HashSet<String>( );
        mmCache = new MetamodelCache( workspaceSet.getMoin( ).getJmiHelper( ) );
        isMofMode = mofMode;
        this.workspaceSet = workspaceSet;
    }

    CoreSession getSession( ) {

        return session;
    }

    /**
     * Allows the owning {@link XmiParser} to set the URI of the currently
     * parsed XMI document.
     */
    void setCurrentUri( String uri ) {

        currentURI = uri;
    }

    /**
     * Returns the URI of the XMI documen that is currently being parsed.
     */
    String getCurrentURI( ) {

        return currentURI;
    }

    /**
     * Checks the validity of the XMI version as it was found in the document.
     */
    void checkXmiVersion( String xmiVersion ) {

        if ( xmiVersion == null || ( !xmiVersion.equals( "1.0" ) && !xmiVersion.equals( "1.1" ) && !xmiVersion.equals( "1.2" ) ) ) { //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            throw new XmiParseException( XMI.MOIN_XMI_1004, new Object[] { xmiVersion } );
        }
    }

    XmiElement resolveValue( XmiElement parent, Object type, Attributes attrs ) {

        if ( type instanceof PrimitiveTypeInternal ) {
            sharedPrimitiveValue.init( parent, (PrimitiveTypeInternal) type, attrs );
            return sharedPrimitiveValue;
        }
        if ( type instanceof EnumerationTypeInternal ) {
            sharedEnumerationValue.init( parent, (EnumerationTypeInternal) type, attrs );
            return sharedEnumerationValue;
        }
        if ( type instanceof AliasType ) {
            TypedElement typedElement = (TypedElement) type;
            Object baseType = getJmiHelper( ).getNonAliasType( session, typedElement );
            return resolveValue( parent, baseType, attrs );
        }
        if ( type instanceof MofClass ) {
            return new ObjectValues( parent, this );
        }
        if ( type instanceof StructureTypeInternal ) {
            return new StructureValues( parent, this, (StructureTypeInternal) type );
        }
        throw new XmiParseException( XMI.MOIN_XMI_1033, new Object[] { String.valueOf( type ) } );
    }

    /**
     * Checks the given XMI element <code>qName</code> and its attributes
     * <code>attrs</code> whether it represents a model element or an XMI proxy
     * pointing to a model element (via <code>xmi.idref</code> or
     * <code>href</code>). Depending on the answer, an instance of either
     * {@link Instance} or {@link ReferenceValue} is returned.
     * <p>
     * An exception to this rule is the <code>&lt;Model:DataType&gt;</code>
     * element, which can occur during the import of a legacy MOF 1.3 metamodel.
     * In this case, an instance of {@link DataTypeElement} is returned.
     */
    XmiElement resolveInstanceOrXmiReference( XmiElement parent, String qName, Attributes attrs ) {

        String idref = attrs.getValue( XmiConstants.XMI_IDREF );
        if ( idref != null ) {
            sharedReferenceValue.init( parent, idref );
            String order = attrs.getValue( XmiConstants.ORDERING_ATTRIBUTE );
            if ( order == null ) {
                order = attrs.getValue( XmiConstants.SAP_LINK_ORDER ); // legacy
                // XMI
                // files
            }
            if ( order != null ) {
                XmiElement element = parent.getParentElement( );
                if ( element instanceof Instance ) {
                    Instance instance = (Instance) element;
                    ReferenceInternal reference = (ReferenceInternal) instance.getCurrentFeature( );
                    AssociationEndInternal end = mmCache.getReferencedEnd( session, reference );
                    AssociationInternal association = (AssociationInternal) mmCache.getContainer( session, end );
                    List<AssociationEnd> ends = getJmiHelper( ).getAssociationEnds( session, (Association) association );
                    boolean isFirst = ( ends.get( 0 ).equals( end ) );
                    String mofId1 = isFirst ? idref : instance.getMofId( );
                    String mofId2 = isFirst ? instance.getMofId( ) : idref;
                    addLinkOrdering( association, mofId1, mofId2, order );
                } else if ( element instanceof AssociationElement ) {
                    AssociationElement assocElement = (AssociationElement) element;
                    if ( assocElement.isReadingEvenEnd( ) ) {
                        String mofId1 = assocElement.getMofIdOfCurrentElement( );
                        String mofId2 = idref;
                        addLinkOrdering( assocElement.getAssociation( ), mofId1, mofId2, order );
                    }
                }
            }
            return sharedReferenceValue;
        }
        String href = attrs.getValue( XmiConstants.XMI_HREF );
        if ( href != null ) {
            sharedReferenceValue.initExternal( parent, href, qName );
            String order = attrs.getValue( XmiConstants.ORDERING_ATTRIBUTE );
            if ( order == null ) {
                order = attrs.getValue( XmiConstants.SAP_LINK_ORDER ); // legacy
                // XMI
                // files
            }
            if ( order != null ) {
                XmiElement element = parent.getParentElement( );
                if ( element instanceof Instance ) {
                    Instance instance = (Instance) element;
                    ReferenceInternal reference = (ReferenceInternal) instance.getCurrentFeature( );
                    AssociationEndInternal end = mmCache.getReferencedEnd( session, reference );
                    AssociationInternal association = (AssociationInternal) mmCache.getContainer( session, end );
                    List<AssociationEnd> ends = getJmiHelper( ).getAssociationEnds( session, (Association) association );
                    boolean isFirst = ( ends.get( 0 ).equals( end ) );
                    String mofId1 = isFirst ? XmiHrefUtil.getIdPart( href, isLoadingPartition( ) /* partitionMode */) : instance.getMofId( );
                    String mofId2 = isFirst ? instance.getMofId( ) : XmiHrefUtil.getIdPart( href, isLoadingPartition( ) /* partitionMode */);
                    addLinkOrdering( association, mofId1, mofId2, order );
                } else if ( element instanceof AssociationElement ) {
                    AssociationElement assocElement = (AssociationElement) element;
                    if ( assocElement.isReadingEvenEnd( ) ) {
                        String mofId1 = assocElement.getMofIdOfCurrentElement( );
                        String mofId2 = XmiHrefUtil.getIdPart( href, isLoadingPartition( ) /* partitionMode */);
                        addLinkOrdering( assocElement.getAssociation( ), mofId1, mofId2, order );
                    }
                }
            }
            return sharedReferenceValue;
        }
        if ( qName.equals( "Model.DataType" ) || qName.equals( "Model:DataType" ) ) { //$NON-NLS-1$ //$NON-NLS-2$
            // MOF 1.3 compatibility (Model:DataType or Model.DataType)
            return new DataTypeElement( parent, this, attrs );
        }
        ModelElementInternal element = typeHelper.resolveQualifiedName( qName );
        Instance result = new Instance( parent, this, (MofClassInternal) element, attrs );
        if ( isLoadingPartition( ) ) {
            String order = attrs.getValue( XmiConstants.ORDERING_ATTRIBUTE );
            if ( order != null ) {
                XmiElement el = parent.getParentElement( );
                if ( el instanceof Instance ) {
                    Instance instance = (Instance) el;
                    StructuralFeatureInternal feature = instance.getCurrentFeature( );
                    if ( feature instanceof ReferenceInternal ) {
                        ReferenceInternal reference = (ReferenceInternal) feature;
                        AssociationEndInternal end = mmCache.getReferencedEnd( session, reference );
                        if ( end.getMultiplicity( ).isOrdered( ) ) {
                            AssociationInternal association = (AssociationInternal) mmCache.getContainer( session, end );
                            List<AssociationEnd> ends = getJmiHelper( ).getAssociationEnds( session, (Association) association );
                            boolean isFirst = ( ends.get( 0 ).equals( end ) );
                            String mofId1 = isFirst ? result.getMofId( ) : instance.getMofId( );
                            String mofId2 = isFirst ? instance.getMofId( ) : result.getMofId( );
                            addLinkOrdering( association, mofId1, mofId2, order );
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * If an instance identified by a given <code>xmi.id</code> has already been
     * created, it is returned; otherwise <code>null</code> is returned.
     */
    Object getReferencedObject( String xmiId ) {

        return getReferencedObject( currentURI, xmiId );
    }

    private Object getReferencedObject( String uri, String xmiId ) {

        Object result = null;
        Map map = resolvedXmiReferences.get( uri );
        if ( map != null ) {
            result = map.get( xmiId );
        }
        return result;
    }

    Object initExternal( String href, String qName ) {

        Object obj = null;
        if ( !isLoadingPartition( ) ) {
            // check href for consistency
            XmiHrefUtil.checkHref( href );
            // We are in import mode. The external document encoded in the href
            // attribute needs to be queued for later reading.
            String xmiId = XmiHrefUtil.getIdPart( href, false /* partitionMode */);
            // Add the document to the queue.
            String uri = queueDocument( XmiHrefUtil.getLocationPart( href ) );
            // Check if the XMI reference has already been resolved.
            obj = getReferencedObject( uri, xmiId );
            if ( obj == null ) {
                obj = new UnresolvedReference( );
                registerUnresolvedRef( uri, xmiId, (UnresolvedReference) obj );
            }
        } else {
            // In partition mode, a CrossPartitionReference has to be created.
            obj = new CrossPartitionReference( href );
        }
        return obj;
    }

    /**
     * Registers an UnresolvedReference, by storing it in the
     * {@link #unresolvedXmiReferences} map using <code>xmiId</code> as the key.
     */
    void registerUnresolvedRef( String xmiId, UnresolvedReference element ) {

        registerUnresolvedRef( currentURI, xmiId, element );
    }

    /**
     * Registers an UnresolvedReference, by storing it in a HashMap using
     * <code>xmiId</code> as a key.
     */
    private void registerUnresolvedRef( String uri, String xmiId, UnresolvedReference element ) {

        Map<String, List<UnresolvedReference>> map = unresolvedXmiReferences.get( uri );
        if ( map == null ) {
            map = new LinkedHashMap<String, List<UnresolvedReference>>( 50 );
            unresolvedXmiReferences.put( uri, map );
        }
        List<UnresolvedReference> list = map.get( xmiId );
        if ( list == null ) {
            list = new ArrayList<UnresolvedReference>( );
            map.put( xmiId, list );
        }
        list.add( element );
    }

    /**
     * Returns all the unresolved references. Used to report an error when the
     * reading is finished and there are still some unresolved references.
     */
    Map getUnresolvedReferences( ) {

        LinkedHashMap<String, Map<String, List<UnresolvedReference>>> result = new LinkedHashMap<String, Map<String, List<UnresolvedReference>>>( );
        for ( Iterator it = unresolvedXmiReferences.keySet( ).iterator( ); it.hasNext( ); ) {
            String uri = (String) it.next( );
            Map<String, List<UnresolvedReference>> map = unresolvedXmiReferences.get( uri );
            if ( map != null && !map.isEmpty( ) ) {
                result.put( uri, map );
            }
        }
        return result;
    }

    /**
     * Adds the document with the given <code>href</code> to the queue. This
     * method is only called if the XmiReader operates in <em>import mode</em>.
     */
    String queueDocument( String href ) {

        String uri = null;
        try {
            // Check the URI String for validity by creating an instance of
            // java.net.URI.
            uri = new URI( XmiHrefUtil.getLocationPart( href ) ).toString( );
        } catch ( URISyntaxException ex ) {
            throw new XmiParseException( XMI.MOIN_XMI_1032, new Object[] { href }, ex );
        }
        xmiParser.queueDocument( uri, currentURI );
        return uri;
    }

    /**
     * If at the end of an import there are still unresolved XMI references, we
     * normally throw an exception. But, this could be due to a bug in the
     * exporter producing the XMI document. This method tries to workaround such
     * bugs and to resolve the XMI IDs by looking at the complete set of parsed
     * documents.
     */
    private void checkForExporterSpecificBugs( Map unresolvedRefs ) {

        List<String> unresolvedIds = new ArrayList<String>( );
        for ( Iterator it = unresolvedRefs.values( ).iterator( ); it.hasNext( ); ) {
            Map map = (Map) it.next( );
            for ( Iterator it2 = map.entrySet( ).iterator( ); it2.hasNext( ); ) {
                Entry entry = (Entry) it2.next( );
                String xmiId = (String) entry.getKey( );
                Object match = null;
                for ( Iterator it3 = resolvedXmiReferences.values( ).iterator( ); it3.hasNext( ); ) {
                    Map resMap = (Map) it3.next( );
                    Object obj = resMap.get( xmiId );
                    if ( obj != null ) {
                        if ( match == null ) {
                            match = obj;
                        } else {
                            // found the XMI-ID more than once
                            throw new MoinLocalizedBaseRuntimeException( XMI.UNRESOLVEDREFERENCES );
                        }
                    }
                }
                if ( match == null ) {
                    unresolvedIds.add( xmiId );
                } else {
                    // We could resolve it unambiguously.
                    for ( Iterator it3 = ( (List) entry.getValue( ) ).iterator( ); it3.hasNext( ); ) {
                        UnresolvedReference ur = (UnresolvedReference) it3.next( );
                        ur.referenceResolved( match );
                    }
                    it2.remove( );
                }
            }
            if ( !unresolvedIds.isEmpty( ) ) {
                // We could not resolve all unresolved XMI references.
                StringBuilder buf = new StringBuilder( );
                for ( Iterator<String> it2 = unresolvedIds.iterator( ); it2.hasNext( ); ) {
                    buf.append( it2.next( ) );
                    if ( it2.hasNext( ) ) {
                        buf.append( ", " ); //$NON-NLS-1$
                    }
                }
                throw new MoinLocalizedBaseRuntimeException( XMI.UNRESOLVEDREFERENCESPARAM, buf.toString( ) );
            }
        }
    }

    /**
     * Returns whether we are currently loading a model partition, or whether we
     * are performing an import.
     */
    boolean isLoadingPartition( ) {

        return false; //TODO delete method
    }

    boolean isMofMode( ) {

        return isMofMode;
    }

    /***************************************************************************
     * Methods for retrieving metamodel information. All methods delegate to the
     * MetamodelCache.
     **************************************************************************/

    /**
     * For a given MofClass, returns the list of all instance-level attributes.
     */
    List getInstanceAttributes( MofClassInternal mofClass ) {

        return mmCache.getInstanceAttributes( this.session, mofClass );
    }

    /**
     * For a given MofClass, returns the list of all references.
     */
    List getReferences( MofClassInternal mofClass ) {

        return mmCache.getReferences( session, mofClass );
    }

    /**
     * For a given MofClass, returns the structural features with the given
     * name.
     */
    StructuralFeatureInternal getStructuralFeature( MofClassInternal mofClass, String name ) {

        return mmCache.getStructuralFeature( session, mofClass, name );
    }

    /**
     * For a given StructureType, returns the list of all structure fields.
     */
    List getStructureFields( StructureTypeInternal structType ) {

        return mmCache.getStructureFields( session, structType );
    }

    /***************************************************************************
     * Methods for type handling (type lookups, determining default values etc.)
     * All methods delegate to the TypeHelper.
     **************************************************************************/

    /**
     * This method returns the model element with the given name as specified in
     * the XMI document.
     */
    ModelElementInternal resolveQualifiedName( String xmiName ) {

        return typeHelper.resolveQualifiedName( xmiName );
    }

    /**
     * For the given PrimitiveType instance (one of the six predefined instances
     * in MOF 1.4), returns the value for the given String representation.
     * (Example: For the PrimitiveType "Boolean" and the String "true", returns
     * an instance of java.lang.Boolean representing the value <code>true</code>
     * .)
     * 
     * @param type The PrimitiveType for which the value should be resolved.
     * @param valueAsText The text representation of the value as found in the
     * XMI document.
     * @return The PrimitiveType's value.
     */
    Object resolvePrimitiveValue( PrimitiveTypeInternal type, String valueAsText ) {

        return typeHelper.resolvePrimitiveValue( type, valueAsText );
    }

    /**
     * Returns the RefEnum for the given EnumerationType and label.
     */
    RefEnum getEnumerationValue( EnumerationTypeInternal type, String label ) {

        return mmCache.getEnumerationValue( session, type, label );
    }

    /**
     * Returns whether the given StructuralFeature is multi-valued or not.
     */
    boolean isMultiValued( StructuralFeatureInternal feature ) {

        return mmCache.isMultiValued( feature );
    }

    /**
     * Creates an instance of the given StructureType, and initializes the
     * structure's fields with the values from the given list.
     */
    RefStruct createStructure( StructureTypeInternal structType, List fieldValues ) {

        return typeHelper.createStructure( structType, fieldValues );
    }

    /**
     * Perform a post-processing after the very last XMI document has been read.
     */
    void parsingFinished( ) {

        // Check whether there are still unresolved XMI references.
        Map unresolvedRefs = getUnresolvedReferences( );
        if ( !unresolvedRefs.isEmpty( ) ) {
            // Last chance for resolving. The following method tries to
            // workaround some exporter-specific bugs (esp. Unisys).
            checkForExporterSpecificBugs( unresolvedRefs );
        }
    }

    /**
     * Stores the <code>resolvedObject</code> under the given XMI-ID in the
     * {@link #resolvedXmiReferences} map. Furthermore, all unresolved
     * references waiting for this XMI-ID to be resolved are notified.
     */
    void instanceComplete( String xmiId, InstanceInfo resolvedInstance ) {

        Map<String, InstanceInfo> resolvedReferences = resolvedXmiReferences.get( currentURI );
        if ( resolvedReferences == null ) {
            resolvedReferences = new LinkedHashMap<String, InstanceInfo>( 50 );
            resolvedXmiReferences.put( currentURI, resolvedReferences );
        }
        if ( resolvedReferences.containsKey( xmiId ) ) {
            throw new XmiParseException( XMI.MOIN_XMI_1053, new Object[] { xmiId } );
        }
        resolvedReferences.put( xmiId, resolvedInstance );
        modelElements.add( resolvedInstance );
        Map unresolvedReferences = unresolvedXmiReferences.get( currentURI );
        if ( unresolvedReferences != null ) {
            List list = (List) unresolvedReferences.remove( xmiId );
            if ( list != null ) {
                for ( Iterator it = list.iterator( ); it.hasNext( ); ) {
                    ( (UnresolvedReference) it.next( ) ).referenceResolved( resolvedInstance );
                }
            }
        }
    }

    private boolean isAssociationOrdered( AssociationInternal association ) {

        List<AssociationEnd> ends = getJmiHelper( ).getAssociationEnds( session, (Association) association );
        return ends.get( 0 ).getMultiplicity( ).isOrdered( ) || ends.get( 1 ).getMultiplicity( ).isOrdered( );
    }

    /**
     * Adds the link between the given objects to the {@link #links} map. The
     * two link ends can be of different types: {@link InstanceInfo} or
     * {@link CrossPartitionReference}.
     */
    void linkComplete( AssociationInternal association, LinkEnd first, LinkEnd second ) {

        Set<LinkInfo> linksPerAssociation = links.get( association );
        if ( linksPerAssociation == null ) {
            if ( isLoadingPartition( ) ) {
                if ( isAssociationOrdered( association ) ) {
                    linksPerAssociation = new TreeSet<LinkInfo>( );
                } else {
                    linksPerAssociation = new LinkedHashSet<LinkInfo>( );
                }
            } else {
                linksPerAssociation = new LinkedHashSet<LinkInfo>( );
            }
            links.put( association, linksPerAssociation );
        }
        linksPerAssociation.add( new LinkInfo( session, getJmiHelper( ), association, first, second, getOrder( association, first, second ) ) );
    }

    private void addLinkOrdering( AssociationInternal association, String mofId1, String mofId2, String order ) {

        assert mofId1 != null && mofId2 != null : "XmiContext.addLinkOrdering(): mofId1 = " + mofId1 + ", mofId2 = " + mofId2 + ", order = " + order; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        assert !mofId1.equals( "" ) && !mofId2.equals( "" ) : "XmiContext.addLinkOrdering(): mofId1 = " + mofId1 + ", mofId2 = " + mofId2 + ", order = " + order; //$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
        Map<PairOfMofIds, Double> map = linkOrderings.get( association );
        if ( map == null ) {
            map = new HashMap<PairOfMofIds, Double>( );
            linkOrderings.put( association, map );
        }
        map.put( new PairOfMofIds( mofId1, mofId2 ), new Double( order ) );
    }

    private double getOrder( AssociationInternal association, LinkEnd first, LinkEnd second ) {

        if ( isLoadingPartition( ) ) {
            if ( linkOrderings.containsKey( association ) ) {
                PairOfMofIds pair = new PairOfMofIds( first.getMofId( ), second.getMofId( ) );
                Map<PairOfMofIds, Double> map = linkOrderings.get( association );
                Double d = map.get( pair );
                if ( d == null ) {
                    return 1.0;
                }
                return d;
            }
        }
        return -1;
    }

    /**
     * Adds a classifier-level attribute and its value to the
     * {@link #staticAttributesToSet} map.
     */
    void staticAttributeComplete( AttributeInternal attribute, Object value ) {

        staticAttributesToSet.put( attribute, value );
    }

    /**
     * Returns the result with all collected data.
     */
    ParserResult getResult( ) {

        return new ParserResult( resolvedXmiReferences.keySet( ), modelElements, links, staticAttributesToSet );
    }

    /**
     * Returns whether for the given package an import to the PrimitiveTypes
     * package has been created.
     * <p>
     * This method is only relevant when importing MOF 1.3 legacy metamodels
     * that contain Corba type definitions.
     */
    boolean hasPrimitiveTypesImport( InstanceInfo packageInfo ) {

        return primitiveTypesImports.contains( packageInfo );
    }

    /**
     * Adds the given import to the set {@link #modelElements}, and stores the
     * information that this has been done for the given package in the set
     * {@link #primitiveTypesImports}, in order to avoid multiple creations for
     * the same package.
     * <p>
     * This method is only relevant when importing MOF 1.3 legacy metamodels
     * that contain Corba type definitions.
     */
    void addPrimitiveTypesImport( InstanceInfo packageInfo, InstanceInfo importInfo ) {

        primitiveTypesImports.add( packageInfo );
        instanceComplete( "PrimitiveTypes" + primitiveTypesImports.size( ), importInfo ); //$NON-NLS-1$
    }

    /**
     * Simple helper class representing a pair of MOF-IDs in the given order.
     * Instances of this class serve as map keys only.
     */
    private static final class PairOfMofIds {

        private String mofId1;

        private String mofId2;

        public PairOfMofIds( String mofId1, String mofId2 ) {

            this.mofId1 = mofId1;
            this.mofId2 = mofId2;
        }

        @Override
        public boolean equals( Object obj ) {

            if ( obj == this ) {
                return true;
            }
            if ( obj instanceof PairOfMofIds ) {
                PairOfMofIds other = (PairOfMofIds) obj;
                return ( mofId1.equals( other.mofId1 ) && mofId2.equals( other.mofId2 ) );
            }
            return false;
        }

        @Override
        public int hashCode( ) {

            int result = 17;
            result = 37 * result + mofId1.hashCode( );
            result = 37 * result + mofId2.hashCode( );
            return result;
        }
    }

    public void addMetamodelContainer( String metamodelToplevelPackage ) {

        metamodelToplevelPackages.add( metamodelToplevelPackage );
    }

    public void endOfHeader( ) {

        if ( isLoadingPartition( ) && !metamodelToplevelPackages.isEmpty( ) ) {
            List<RefPackage> refPackages = new ArrayList<RefPackage>( );
            for ( String metamodelToplevelPackage : metamodelToplevelPackages ) {
                int pos = metamodelToplevelPackage.indexOf( '#' );
                String containerName = metamodelToplevelPackage.substring( 0, pos );
                String pkgName = metamodelToplevelPackage.substring( pos + 1 );
                RefPackage refPkg = session.getPackage( containerName, pkgName );
                if ( refPkg == null ) {
                    throw new MoinLocalizedBaseRuntimeException( XMI.FAILED_TO_LOAD_METAMODEL_PACKAGE, pkgName, containerName );
                }
                refPackages.add( refPkg );
            }
            typeHelper.setExtents( refPackages.toArray( new RefPackage[refPackages.size( )] ) );
        }
    }

    public ClassifierInternal getNonAliasType( StructuralFeatureInternal feature ) {

        return (ClassifierInternal) getJmiHelper( ).getNonAliasType( session, (Classifier) mmCache.getType( session, feature ) );
    }

    public AssociationEndInternal getReferencedEnd( ReferenceInternal reference ) {

        return mmCache.getReferencedEnd( session, reference );
    }

    public NamespaceInternal getContainer( ModelElementInternal element ) {

        return mmCache.getContainer( session, element );
    }

    public List<AssociationEnd> getAssociationEnds( AssociationInternal association ) {

        return getJmiHelper( ).getAssociationEnds( session, (Association) association );
    }

    public SpiJmiHelper getJmiHelper( ) {

        return workspaceSet.getMoin( ).getJmiHelper( );
    }
}

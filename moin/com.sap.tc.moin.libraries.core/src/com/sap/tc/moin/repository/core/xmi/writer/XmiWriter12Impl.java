package com.sap.tc.moin.repository.core.xmi.writer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
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
import java.util.TreeSet;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.mmi.model.AggregationKindEnum;
import com.sap.tc.moin.repository.mmi.model.AliasType;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.ScopeKindEnum;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.model.TypedElement;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.AttributeInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ClassifierInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.EnumerationTypeInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ModelElementInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.MofClassImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.MofClassInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.MofPackageInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ReferenceInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.StructuralFeatureInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.StructureFieldInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.StructureTypeInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.TypedElementInternal;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefStruct;

import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.consistency.ConsistencyViolation;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.EndAndMetaObject;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.MoinReference;
import com.sap.tc.moin.repository.core.ParentRetriever;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.WorkspaceSet;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.jmi.util.JmiHelperImpl;
import com.sap.tc.moin.repository.core.util.TreeSorter;
import com.sap.tc.moin.repository.core.xmi.MetamodelCache;
import com.sap.tc.moin.repository.core.xmi.XmiConstants;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinIllegalNullArgumentException;
import com.sap.tc.moin.repository.messages.core.XMI;
import com.sap.tc.moin.repository.shared.util.QualifiedName;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;
import com.sap.tc.moin.repository.spi.core.SpiLink;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.repository.xmi.XmiReferenceProvider;
import com.sap.tc.moin.repository.xmi.XmiWriter;

/**
 * This class provides an implementation of the
 * {@link com.sap.tc.moin.repository.core.xmi.writer.XmiWriterInternal}
 * interface, which in turn extends the {@link com.sap.tc.moin.repository.mmi.xmi.XmiWriter
 * XmiWriter} interface defined in the JMI 1.0 specification. In addition to the
 * two <code>write</code> methods defined in the standard interface, it offers
 * additional methods for writing
 * {@link com.sap.tc.moin.repository.ModelPartition model partitions}, and for
 * setting configuration options controlling the serialization process.
 */
class XmiWriter12Impl implements XmiWriterInternal {

    /**
     * The XMI version that documents written by this class conform to.
     */
    private static final String XMI_VERSION = "1.2"; //$NON-NLS-1$

    /**
     * The value of the <code>&lt;XMI.exporterVersion&gt;</code> element in the
     * XMI header.
     */
    private static final String EXPORTER_VERSION = "10"; //$NON-NLS-1$

    /**
     * The XmiWriterConfig instance providing access to all configuration
     * options. It is passed in the constructor.
     */
    private XmiWriter writer;

    /**
     * The model partition to serialize. A value <code>!= null</code> during
     * serialization indicates that the
     * {@link #write(OutputStream, ModelPartition)} method was called, i.e. the
     * XmiWriter operates in "partition mode".
     */
    private CoreModelPartition partitionToWrite;

    /**
     * Map of all namespaces required for serializing the current collection of
     * model elements. Note that this collection is only populated if the
     * configuration option
     * {@link com.sap.tc.moin.repository.xmi.XmiWriter#getUseNamespaces()
     * useNamespaces} is set to <code>true</code>. Otherwise it is
     * <code>null</code>.
     */
    private Map<String /* fullyQualifiedPackageName */, String /* namespacePrefix */> namespaces;

    /**
     * The list of model elements to be written. This list is populated in the
     * {@link #collectData(Collection, boolean)} method, and set to 'null' again
     * in {@link #cleanup()}. The model elements in this list are sorted
     * according to the composition hierarchy.
     * <p>
     * During processing, the written model elements are removed from the
     * collection. An the end of a <code>write</code> call, the collection has
     * to be empty.
     */
    private List<RefObject> instancesToWrite;

    /**
     * Redundant storage of the objects in {@link #instancesToWrite}, but in a
     * map with the object's MOF id as the key. This map is populated in
     * {@link #collectData(Collection, boolean)}, and set to 'null' again in
     * {@link #cleanup()}.
     * <p>
     * Such a mapping is required in order to find out whether a model element
     * at an end of a link is among the model elements to be written, or
     * external, resulting in the serialization of a <code>xmi.idref</code> or
     * <code>href</code> attribute.
     * <p>
     * As opposed to the {@link #instancesToWrite} collection, this collection
     * is not modified during the whole <code>write</code> call.
     */
    private Map<String /* MOF id */, RefObject> instancesToWriteByIdentifier;

    private Set<String /* metamodel container name */> metamodelToplevelPackages;

    /**
     * Contains all model elements that are values of classifier-level
     * attributes. This set is populated in
     * {@link #collectData(Collection, boolean)} if and only if the
     * {@link #write(OutputStream, RefPackage)} method was called, and set to
     * 'null' again in {@link #cleanup()}.
     * <p>
     * A separate collection for these model elements is necessary because they
     * must not be nested inside other model elements. According to the XMI
     * specification, they have to be stored on top-level, i.e. as sub-elements
     * of the <code>&lt;XMI.content&gt;</code> element.
     */
    private Set<RefObject> instancesToWriteAsStaticAttribute;

    /**
     * For each RefObject that is about to be serialized, this map holds all
     * links that can be stored as XML attributes. The links are not stored in a
     * single collection, but again in a map, with the Reference as the key. (A
     * reference must exist; otherwise the link would not be contained in this
     * collection, but in {@link #linksWithoutReferences}.)
     * <p>
     * This map is populated in {@link #findLinksToWrite(RefObject)}, and set to
     * 'null' again in {@link #cleanup()}.
     */
    private Map<RefObject, Map<ReferenceInternal, Collection<EndStorageLink>>> linksToBeSerializedAsXmlAttributes;

    /**
     * For each RefObject that is about to be serialized, this map holds all
     * links that have to be stored nested inside the XMI element representing
     * the RefObject. They cannot be serialized as XML attributes (otherwise,
     * they would be contained in the
     * {@link #linksToBeSerializedAsXmlAttributes} collection). The links are
     * not stored in a single collection, but again in a map, with the Reference
     * as the key. (A reference must exist; otherwise the link would not be
     * contained in this collection, but in {@link #linksWithoutReferences}.)
     * <p>
     * This map is populated in {@link #findLinksToWrite(RefObject)}, and set to
     * 'null' again in {@link #cleanup()}.
     */
    private Map<RefObject, Map<ReferenceInternal, Collection<EndStorageLink>>> linksWithReferences;

    /**
     * Map of all links per Association that need to be stored below the
     * <code>&lt;XMI.content&gt;</code> element at top-level. A link is
     * contained in this map only if
     * <ul>
     * <li>no reference for the association exists in the metamodel</li> <li>the
     * <em>org.omg.sap2mof.store</em> tag is set to <em>if_reference</em> for
     * the corresponding association end</li>
     * </ul>
     * <p>
     * This map is populated in {@link #findLinksToWrite(RefObject)}, and set to
     * 'null' again in {@link #cleanup()}.
     */
    private Map<AssociationInternal, Collection<EndStorageLink>> linksWithoutReferences;

    /**
     * Map of all links per Association that need to be stored as a SAP specific
     * extension using an <code>&lt;XMI.extensions&gt;</code> element. A link is
     * contained in this map only if
     * <ul>
     * <li>the <em>org.omg.sap2mof.store</em> tag is set to <em>yes</em> or <em>
     * no</em> for the corresponding association end</li> <li>the regular
     * storage (using references in the metamodel) is different from the tag
     * value</li>
     * </ul>
     * <p>
     * This map is populated in {@link #findLinksToWrite(RefObject)}, and set to
     * 'null' again in {@link #cleanup()}.
     */
    private Map<AssociationInternal, Collection<EndStorageLink>> linksToBeStoredAsSAPExtension;

    /**
     * The {@link ParentRetriever} instance used by the {@link #treeSorter tree
     * sorter} and in {@link #collectData(Collection, boolean)} to recursively
     * collect all composite children of a given model element.
     */
    private ParentRetriever<RefObject> parentRetriever;

    /**
     * The TreeSorter instance used by this XmiWriter instance. It is used in
     * the data collection phase (see {@link #collectData(Collection, boolean)})
     * before the serialization starts, to sort the collection of model elements
     * with respect to compositional relationship. The result is a list in which
     * a composite always preceeds its components. Such a sort order is required
     * because the XMI specification prescribes that a composite link between
     * two model elements must be mapped to XMI element nesting, components
     * being nested inside their composites.
     */
    private TreeSorter<RefObject> treeSorter;

    /**
     * The XmlHelper instance used by this XmiWriter instance. It completely
     * encapsulates the writing to the stream, offering methods to write opening
     * tags, closing tags, character sequences etc.
     */
    private XmlHelper xmlHelper;

    /**
     * The MetamodelCache instance used by this XmiWriter instance. It is
     * (re-)created before every <code>write</code> call in {@link #init()}, and
     * set to <code>null</code> again in {@link #cleanup()}.
     */
    private MetamodelCache mmCache;

    /**
     * Set used for marking a RefObject as written.
     */
    private Set<RefObject> writtenInstances;

    /**
     * Constant which indicates that the ordering criterion needs not to be
     * written.
     */
    private static final double NO_ORDERING = Double.MIN_VALUE;

    private Map<ModelElementInternal, String> qualifiedNames;

    private Map<MofPackageInternal, String> xmiNamespaces;

    private Map<AssociationInternal, Boolean> associationsOrderedness;

    private Map<AssociationEndInternal, Map<MofClassInternal, ReferenceInternal>> referenceToAssociationEnd;

    private Map<LinkInfo, Double> orderAssignedToLinks;

    private static final class LinkInfo {

        EndStorageLink link;

        public LinkInfo( EndStorageLink link ) {

            this.link = link;
        }

        @Override
        public boolean equals( Object obj ) {

            if ( obj == this ) {
                return true;
            }
            if ( obj instanceof LinkInfo ) {
                LinkInfo otherLink = (LinkInfo) obj;
                boolean result = link.getMetaObject( ).equals( otherLink.link.getMetaObject( ) );
                if ( result ) {
                    result = link.getEnd( 0 ).getLri( ).equals( otherLink.link.getEnd( 0 ).getLri( ) );
                    if ( result ) {
                        result = link.getEnd( 1 ).getLri( ).equals( otherLink.link.getEnd( 1 ).getLri( ) );
                    }
                }
                return result;
            }
            return false;
        }

        @Override
        public int hashCode( ) {

            int result = 17;
            result = 37 * result + link.getMetaObject( ).hashCode( );
            result = 37 * result + link.getEnd( 0 ).getLri( ).hashCode( );
            result = 37 * result + link.getEnd( 1 ).getLri( ).hashCode( );
            return result;
        }
    }



    final CoreSession session;

    private SpiJmiHelper jmiHelper;

    /**
     * Creates a new XmiWriter.
     * 
     * @param connection
     */
    XmiWriter12Impl( CoreSession sess, XmiWriter writer ) {

        this.session = sess;
        this.jmiHelper = this.session.getWorkspaceSet( ).getMoin( ).getJmiHelper( );
        // The enclosing XmiWriter instance carries the configuration options.
        this.writer = writer;
        // Create the parent retriever.
        parentRetriever = new ParentRetriever<RefObject>( ) {

            public RefObject getCompositionParent( RefObject modelElement ) {

                return (RefObject) ( (RefObjectImpl) modelElement ).refImmediateComposite( session );
            }
        };
        // Create the TreeSorter using the parent retriever.
        treeSorter = new TreeSorter<RefObject>( parentRetriever );
    }

    /**
     * Returns the XMI version that documents written by this class are
     * conforming to.
     */
    protected String getXmiVersion( ) {

        return XMI_VERSION;
    }

    /**
     * Default value of the <code>&lt;XMI.exporterVersion&gt;</code> element in
     * the XMI header.
     */
    protected String getExporterVersion( ) {

        return EXPORTER_VERSION;
    }

    /**
     * This method is called by each <code>write</code> method prior to
     * serialization, mainly to initialize some internal data structures.
     */
    private void init( WorkspaceSet workspaceSet ) {

        if ( mmCache == null ) {
            mmCache = new MetamodelCache( workspaceSet.getMoin( ).getJmiHelper( ) );
        }
        if ( xmiNamespaces == null ) {
            xmiNamespaces = new IdentityHashMap<MofPackageInternal, String>( );
        }
        if ( associationsOrderedness == null ) {
            associationsOrderedness = new IdentityHashMap<AssociationInternal, Boolean>( 256 );
        }
        if ( referenceToAssociationEnd == null ) {
            referenceToAssociationEnd = new IdentityHashMap<AssociationEndInternal, Map<MofClassInternal, ReferenceInternal>>( 512 );
        }
        xmlHelper = new XmlHelper( );
        instancesToWrite = new ArrayList<RefObject>( );
        instancesToWriteByIdentifier = new IdentityHashMap<String, RefObject>( 1024 );
        instancesToWriteAsStaticAttribute = new LinkedHashSet<RefObject>( );
        namespaces = new HashMap<String, String>( );
        linksWithReferences = new LinkedHashMap<RefObject, Map<ReferenceInternal, Collection<EndStorageLink>>>( );
        linksWithoutReferences = new LinkedHashMap<AssociationInternal, Collection<EndStorageLink>>( );
        linksToBeStoredAsSAPExtension = new LinkedHashMap<AssociationInternal, Collection<EndStorageLink>>( );
        linksToBeSerializedAsXmlAttributes = new LinkedHashMap<RefObject, Map<ReferenceInternal, Collection<EndStorageLink>>>( );
        writtenInstances = new HashSet<RefObject>( );
        metamodelToplevelPackages = new TreeSet<String>( );
        qualifiedNames = new IdentityHashMap<ModelElementInternal, String>( 1024 );
        orderAssignedToLinks = new HashMap<LinkInfo, Double>( 1024 );
    }

    /**
     * This method is called at the end of each <code>write</code> call, mainly
     * to clear some internal data structures for garbage collection purposes.
     */
    private void cleanup( ) {

        xmlHelper = null;
        instancesToWrite = null;
        instancesToWriteByIdentifier = null;
        instancesToWriteAsStaticAttribute = null;
        namespaces = null;
        linksWithReferences = null;
        linksWithoutReferences = null;
        linksToBeStoredAsSAPExtension = null;
        linksToBeSerializedAsXmlAttributes = null;
        writtenInstances = null;
        metamodelToplevelPackages = null;
        qualifiedNames = null;
        orderAssignedToLinks = null;
    }

    /**
     * Writes a complete package extent to the given OutputStream using the
     * specified XMI version. The OutputStream is left open after completion.
     * <p>
     * A package extent contains the extents of all nested or clustered
     * packages, as well as all class extents and association extents contained
     * by all the aforementioned packages.
     * <p>
     * According to the XMI specification, the serialization of a package extent
     * is not unlike dumping an entire part of a database into an XMI document,
     * for example to replicate it into another environment. The resulting
     * document has to include all model elements, all links (including links of
     * associations for which no reference exists in the metamodel), and all
     * values of classifier-level attributes. This distinguishes it from the
     * serialization of a collection of model elements via
     * {@link #write(OutputStream, Collection)}, which does <em>not</em> include
     * classifier-level attributes and links not represented by references.
     * 
     * @param os the OutputStream to use
     * @param extent the package extent to serialize
     * @throws IllegalArgumentException if the OutputStream or the RefPackage
     * are 'null'
     * @throws UnsupportedOperationException if an unsupported XMI version is
     * requested
     */
    public void write( OutputStream os, RefPackage extent ) throws java.io.IOException {

        // Check the input parameters.
        checkOutputStream( os );
        checkExtent( extent );
        init( getWorkspaceSet( extent ) );
        try {
            // Determine all model elements and links in the package extent.
            collectExtentData( extent );
            // All data is available, now start the serialization.
            xmlHelper.createStream( os, writer.getEncoding( ), writer.getUseIndentation( ) );
            writePreamble( );
            writeHeader( );
            if ( hasContentToWrite( ) ) {
                xmlHelper.startElement( XmiConstants.XMI_CONTENT );
                writeInstances( );
                writeStaticAttributes( extent, new HashSet<RefPackage>( ) /* visitedPackages */);
                writeLinksWithoutReference( );
                xmlHelper.endElement( XmiConstants.XMI_CONTENT );
            }
            // After the content has been written, add the SAP-specific
            // extensions (if any) surrounded by an
            // <XMI.extensions> element.
            writeSAPExtensions( );
            xmlHelper.endElement( XmiConstants.XMI_ROOT );
        } catch ( Exception ex ) {
            throw new IOException( ex.getLocalizedMessage( ) );
        } finally {
            try {
                xmlHelper.flushStream( );
            } finally {
                cleanup( );
            }
        }
    }

    private WorkspaceSet getWorkspaceSet( Partitionable element ) {

        CorePartitionable coreElement;
        if ( element instanceof Wrapper ) {
            coreElement = ( (Wrapper<CorePartitionable>) element ).unwrap( );
        } else {
            coreElement = (CorePartitionable) element;
        }

        return coreElement.get___Workspace( ).getWorkspaceSet( );
    }

    /**
     * Writes the given collection of model elements to the OutputStream using
     * the specified XMI version. This method serializes the complete
     * composition hierarchy of the model elements in the collection. The
     * OutputStream is left open after completion.
     * 
     * @param os the OutputStream to use
     * @param objects the collection of model elements to serialize. Only
     * instances of {@link RefObject}, which are at the same time instances of
     * {@link Partitionable}, are allowed as collection elements.
     * @throws IllegalArgumentException if the OutputStream or the collection
     * are 'null' or the collection contains objects of the wrong type.
     * @throws UnsupportedOperationException if an unsupported XMI version is
     * requested
     */
    public void write( OutputStream os, Collection objects ) throws java.io.IOException {

        WorkspaceSet workspaceSet = null;
        if ( objects != null && !objects.isEmpty( ) ) {
            Partitionable firstElement = (Partitionable) objects.iterator( ).next( );
            workspaceSet = getWorkspaceSet( firstElement );
        }
        write( os, objects, true /* includeComponents */, workspaceSet );
    }

    /**
     * Writes the given collection of model elements to the OutputStream using
     * the specified XMI version. The parameter <code>includeComponents</code>
     * controls whether the complete composition hierarchy of all model elements
     * in the collection should be serialized as well. The OutputStream is left
     * open after completion.
     * 
     * @param os the OutputStream to use
     * @param objects the collection of model elements to serialize. Only
     * instances of {@link RefObject}, which are at the same time instances of
     * {@link Partitionable}, are allowed as collection elements.
     * @param includeComponents Controls whether to serialize complete
     * composition hierarchies or not.
     * @throws IllegalArgumentException if the OutputStream or the collection
     * are 'null' or the collection contains objects of the wrong type.
     * @throws UnsupportedOperationException if an unsupported XMI version is
     * requested
     */
    @SuppressWarnings( { "unchecked" } )
    private void write( OutputStream os, Collection objects, boolean includeComponents, WorkspaceSet workspaceSet ) throws java.io.IOException {

        // check input parameters
        checkOutputStream( os );
        checkCollection( objects );
        init( workspaceSet );
        try {
            // Determine the collection of model elements and their links.
            collectData( objects, includeComponents );
            // All data is available; now start the serialization.
            xmlHelper.createStream( os, writer.getEncoding( ), writer.getUseIndentation( ) );
            writePreamble( );
            writeHeader( );
            if ( hasContentToWrite( ) ) {
                xmlHelper.startElement( XmiConstants.XMI_CONTENT );
                writeInstances( );
                writeLinksWithoutReference( );
                xmlHelper.endElement( XmiConstants.XMI_CONTENT );
            }
            // After the content has been written, add the SAP-specific
            // extensions (if any) surrounded by an
            // <XMI.extensions> element.
            writeSAPExtensions( );
            xmlHelper.endElement( XmiConstants.XMI_ROOT );
        } catch ( Exception ex ) {
            throw new IOException( ex );
        } finally {
            try {
                xmlHelper.flushStream( );
            } finally {
                cleanup( );
            }
        }
    }

    /**
     * Writes the model partition to the OutputStream using the specified XMI
     * version.
     * 
     * @param os the OutputStream to use
     * @param partition the model partition to serialize
     * @throws IllegalArgumentException if the OutputStream or the
     * ModelPartition are 'null', the ModelPartition is not assigned to a
     * workspace, or it is a transient partition.
     * @throws UnsupportedOperationException if an unsupported XMI version is
     * requested
     */
    public void write( OutputStream os, ModelPartition partition ) throws java.io.IOException {

        CoreModelPartition mp = (CoreModelPartition) partition;
        // check partition parameter
        checkModelPartition( mp );
        partitionToWrite = mp;
        try {
            write( os, mp.getElements( ), false /* includeComponents */, mp.getWorkspace( ).getWorkspaceSet( ) );
        } finally {
            // Make sure that the partition variable is reset.
            partitionToWrite = null;
        }
    }

    /**
     * Checks whether the given RefObject is the value of a classifier-level
     * attribute.
     */
    private boolean isValueOfStaticAttribute( RefObject refObj ) {

        RefFeatured immediateComposite = refObj.refImmediateComposite( );
        if ( immediateComposite instanceof Attribute ) {
            Attribute attr = (Attribute) immediateComposite;
            return ( attr.getScope( ) == ScopeKindEnum.CLASSIFIER_LEVEL );
        }
        return false;
    }

    /**
     * Writes the elements of {@link #instancesToWrite} to the stream.
     */
    private void writeInstances( ) throws IllegalLinkToTransientPartitionException {

        for ( RefObject instance : instancesToWrite ) {
            if ( !writtenInstances.contains( instance ) ) {
                writeInstance( instance, NO_ORDERING );
            }
        }
    }

    /**
     * This method writes all links to the stream that cannot not be nested
     * inside the XMI elements representing the model elements, because there is
     * no reference declared in the metamodel for their association. These links
     * are only persisted if the package extent is written using the
     * {@link #write(OutputStream, RefPackage)} method.
     * <p>
     * All these links are contained in the {@link #linksWithoutReferences}
     * collection, which is populated in the
     * {@link #findLinksToWrite(RefObject)} method.
     */
    private void writeLinksWithoutReference( ) throws IllegalLinkToTransientPartitionException {

        for ( Iterator it = linksWithoutReferences.keySet( ).iterator( ); it.hasNext( ); ) {
            AssociationInternal association = (AssociationInternal) it.next( );
            // All links of an association are surrounded by an element
            // consisting of the association's qualified name.
            String elementName = qualifiedName( association );
            xmlHelper.startElement( elementName );
            List assocEnds = jmiHelper.getAssociationEnds( session, (Association) association );
            Collection<EndStorageLink> links = linksWithoutReferences.get( association );
            for ( EndStorageLink link : links ) {
                writeLinkWithoutReference( assocEnds, link );
            }
            xmlHelper.endElement( elementName );
            // Mark all links as written by removing the map entry.
            it.remove( );
        }
    }

    /**
     * This method writes all those links to the stream that, according to the
     * XMI specification, would not be stored in this document, but for which
     * storage was explicitly declared using the special tag
     * <em>org.omg.sap2mof.store</em>. Since this is SAP specific information,
     * XMI's built-in extension mechanism is used: the information is written
     * inside an <code>&lt;XMI.extensions&gt;</code> element, which is a direct
     * sub-element of the <code>&lt;XMI&gt;</code> element.
     * <p>
     * All these links are contained in the
     * {@link #linksToBeStoredAsSAPExtension} collection, which is populated in
     * the {@link #findLinksToWrite(RefObject)} method.
     */
    private void writeSAPSpecificLinks( ) throws IllegalLinkToTransientPartitionException {

        if ( !hasSAPSpecificLinksToWrite( ) ) {
            return;
        }
        xmlHelper.startElement( XmiConstants.SAP_LINKS );
        // The map contains the links keyed by the corresponding association.
        Iterator<AssociationInternal> it = linksToBeStoredAsSAPExtension.keySet( ).iterator( );
        for ( ; it.hasNext( ); ) {
            AssociationInternal association = it.next( );
            String assocName = qualifiedName( association );
            // All links of an association are nested inside one element,
            // consisting of the association's qualified name.
            xmlHelper.startElement( assocName );
            List assocEnds = jmiHelper.getAssociationEnds( session, (Association) association );
            Collection<EndStorageLink> links = linksToBeStoredAsSAPExtension.get( association );
            for ( EndStorageLink link : links ) {
                writeLinkWithoutReference( assocEnds, link );
            }
            xmlHelper.endElement( assocName );
            it.remove( );
        }
        xmlHelper.endElement( XmiConstants.SAP_LINKS );
    }

    /**
     * Writes one link to the stream. The list of association ends and the link
     * is given. As opposed to the
     * {@link #writeLink(EndStorageLink, MoinReference, boolean, double)}
     * method, this method surrounds each link end with an XMI element
     * representing the corresponding association end.
     * <p>
     * Note that the XML schema for writing these links is different in XMI 1.2
     * and XMI 2.0:
     * <ul>
     * <li>In XMI 1.2, for each link end two XML elements have to be written:
     * one consisting of the qualified name of the AssociationEnd, and nested
     * inside this the XMI proxy referencing the model element.</li>
     * <li>In XMI 2.0, the surrounding association end element was dropped.
     * Thus, only one XML element per link end (the XMI proxy) needs to be
     * written.</li>
     * </ul>
     */
    protected void writeLinkWithoutReference( List associationEnds, EndStorageLink link ) throws IllegalLinkToTransientPartitionException {

        boolean writeOrdering = ( isWritingPartition( ) && isAssociationOrdered( (AssociationInternal) link.getMetaObject( ) ) );
        for ( int i = 0; i < 2; i++ ) {
            MoinReference ref = link.getEnd( i );
            // The XML element name is determined by the qualified name of the
            // association end.
            String endName = qualifiedName( (AssociationEndInternal) associationEnds.get( i ) );
            xmlHelper.startElement( endName );
            writeLink( link, ref, false /* isComposite */, writeOrdering ? 0.0 : NO_ORDERING );
            xmlHelper.endElement( endName );
        }
    }

    /**
     * Returns whether the model elements at both link ends of the given link
     * are members of the currently written {@link #partitionToWrite partition}.
     * It is expected that the {@link #instancesToWriteByIdentifier} collection
     * is already fully populated.
     */
    private boolean isInnerPartitionLink( EndStorageLink link ) {

        MoinReference end0 = link.getEnd( 0 );
        MoinReference end1 = link.getEnd( 1 );

        return instancesToWriteByIdentifier.containsKey( end0.getMofId( ) ) && instancesToWriteByIdentifier.containsKey( end1.getMofId( ) );

    }

    /**
     * Finds all links for the given RefObject that need to be written. The
     * resulting link sets are stored in one of the following collections:
     * <ul>
     * <li>{@link #linksWithReferences}, if the RefObject's MofClass or one of
     * its supertypes owns a Reference that references the opposite association
     * end</li> <li>{@link #linksWithoutReferences}, if we are in extent writing
     * mode and no such Reference exists</li> <li>
     * {@link #linksToBeStoredAsSAPExtension}, if we are in collection (resp.
     * partition) writing mode, no such Reference exists, but storage has been
     * explicitly declared via <em>org.omg.sap2mof.store=true</em></li>
     * </ul>
     */
    private void findLinksToWrite( RefObject refObj ) {

        Workspace workspace = ( (CorePartitionable) refObj ).get___Workspace( );
        MRI mriOfRefObject = ( (CorePartitionable) refObj ).get___Mri( );
        // Fetch all stored association ends that have refObj's MofClass or any
        // supertype thereof as their type.
        List<AssociationEndInternal> ends = mmCache.getStoredAssociationEnds( session, (MofClassInternal) refObj.refMetaObject( ), isWritingPartition( ) );
        // For each AssociationEnd, query the link set of the corresponding
        // Association.
        for ( AssociationEndInternal end : ends ) {
            AssociationInternal association = (AssociationInternal) mmCache.getContainer( session, end );
            int endNumber = mmCache.getAssociationEndNumber( session, end );
            EndAndMetaObject endAndMetaObject = workspace.getWorkspaceSet( ).getEndAndMetaObjectPool( ).getEndAndMetaObject( endNumber, association );
            Collection<EndStorageLink> links = workspace.getMemoryLinkManager( ).getLinksForEndAndMetaObject( session, endAndMetaObject, mriOfRefObject );
            if ( links != null && !links.isEmpty( ) ) {
                // We have a non-empty link set. Now determine whether the links
                // can be nested inside the model element
                // or not. The decision depends on the existence of a reference
                // in the metamodel.
                ReferenceInternal reference = getReferenceForAssociationEnd( (MofClassInternal) refObj.refMetaObject( ), end );
                if ( reference == null ) {
                    // In collection writing mode, the absence of a reference in
                    // the metamodel normally means that the
                    // links are not serialized at all. However, the SAP
                    // specific tag org.omg.sap2mof.store can still
                    // lead to a serialization, if its value for the current
                    // association end is "true".
                    String storageTag = jmiHelper.getTagValue( session, (ModelElement) end, JmiHelperImpl.MARK_LINK_END );
                    if ( storageTag != null && storageTag.equals( JmiHelperImpl.MARK_LINK_END_STORE ) ) {
                        // Storage because of org.omg.sap2mof.store = "true" =>
                        // store links as SAP extension
                        Collection<EndStorageLink> sapLinks = linksToBeStoredAsSAPExtension.get( association );
                        if ( sapLinks == null ) {
                            sapLinks = new LinkedHashSet<EndStorageLink>( );
                            linksToBeStoredAsSAPExtension.put( association, sapLinks );
                        }
                        sapLinks.addAll( links );
                    }
                } else {
                    boolean writeLinks = true;
                    if ( isWritingPartition( ) ) {
                        AssociationEndInternal referencedEnd = mmCache.getReferencedEnd( session, reference );
                        if ( referencedEnd.getAggregation( ) == AggregationKindEnum.COMPOSITE ) {
                            // Optimization in the partition case: do not
                            // serialize redundant composite links from child
                            // back to parent.
                            EndStorageLink link = links.iterator( ).next( );
                            if ( isInnerPartitionLink( link ) && ends.contains( mmCache.getReferencedEnd( session, reference ) ) ) {
                                writeLinks = false;
                            }
                        }
                    }
                    if ( writeLinks ) {
                        // The association end has storage and we have a MOF
                        // reference. The links can be stored in one
                        // of two different ways:
                        // 1. inlined as XML attributes, if all links are
                        // inner-document links and no ordering is given
                        // 2. nested as XML elements because at least one of the
                        // links is a cross-document link, or we
                        // are in partition mode and the links need to contain
                        // the link ordering information.
                        // Depending on which option holds, the links are put
                        // into a corresponding collection.
                        boolean nestLinks = false;
                        AssociationEndInternal exposedEnd = mmCache.getExposedEnd( session, reference );
                        if ( exposedEnd.getAggregation( ) == AggregationKindEnum.COMPOSITE || ( isWritingPartition( ) && isAssociationOrdered( association ) ) ) {
                            nestLinks = true;
                        } else {
                            for ( EndStorageLink link : links ) {
                                if ( !isInnerDocumentLink( link ) ) {
                                    nestLinks = true;
                                    break;
                                }
                            }
                        }
                        if ( nestLinks ) {
                            Map<ReferenceInternal, Collection<EndStorageLink>> map = linksWithReferences.get( refObj );
                            if ( map == null ) {
                                map = new LinkedHashMap<ReferenceInternal, Collection<EndStorageLink>>( );
                                linksWithReferences.put( refObj, map );
                            }
                            map.put( reference, links );
                        } else {
                            Map<ReferenceInternal, Collection<EndStorageLink>> map = linksToBeSerializedAsXmlAttributes.get( refObj );
                            if ( map == null ) {
                                map = new LinkedHashMap<ReferenceInternal, Collection<EndStorageLink>>( );
                                linksToBeSerializedAsXmlAttributes.put( refObj, map );
                            }
                            map.put( reference, links );
                        }
                    }
                }
            }
        }
    }

    private boolean isAssociationOrdered( AssociationInternal association ) {

        Boolean result = associationsOrderedness.get( association );
        if ( result == null ) {
            List<AssociationEnd> ends = jmiHelper.getAssociationEnds( session, (Association) association );
            result = Boolean.valueOf( ( ends.get( 0 ).getMultiplicity( ).isOrdered( ) || ends.get( 1 ).getMultiplicity( ).isOrdered( ) ) );
            associationsOrderedness.put( association, result );
        }
        return result.booleanValue( );
    }

    /**
     * Returns whether the model elements at both link ends of the given link
     * are members of the currently written XMI document. It is expected that
     * the {@link #instancesToWriteByIdentifier} collection is already fully
     * populated.
     */
    private boolean isInnerDocumentLink( EndStorageLink link ) {

        MoinReference end0 = link.getEnd( 0 );
        MoinReference end1 = link.getEnd( 1 );
        try {
            return instancesToWriteByIdentifier.containsKey( end0.getMofId( ) ) && instancesToWriteByIdentifier.containsKey( end1.getMofId( ) );
        } catch ( Exception ex ) {
            throw new RuntimeException( ex );
        }
    }

    /**
     * Performs a first iteration over the collection of model elements with the
     * goals of removing duplicates, finding all links to be stored, finding all
     * required XMI namespace declarations and sorting the elements according to
     * their composition hierarchy.
     * <p>
     * After calling this method, the collections {@link #instancesToWrite},
     * {@link #instancesToWriteByIdentifier}, {@link #linksWithReferences} and
     * {@link #linksWithoutReferences} are populated with all necessary
     * information for the subsequent main iteration.
     * <p>
     * In extent writing mode, model elements that are values of
     * classifier-level attributes are <em>not</em> added to the
     * {@link #instancesToWrite} collection, but instead added to the
     * {@link #instancesToWriteAsStaticAttribute} collection. They are written
     * later on in a call to {@link #writeStaticAttributes(RefPackage, Set)}).
     * 
     * @throws com.sap.tc.moin.repository.mmi.reflect.JmiException
     */
    private void collectData( Collection<RefObject> refObjs, boolean includeComponents ) {

        // Remove duplicates, keeping the order of elements in the collection.
        Set<RefObject> modelElements = new LinkedHashSet<RefObject>( refObjs );
        if ( includeComponents ) {
            // Resursively collect all composite children of all elements in the
            // collection.
            for ( RefObject refObj : new ArrayList<RefObject>( modelElements ) ) {
                modelElements.addAll( getAllCompositeChildren( refObj ) );
            }
        }
        // Initialize the set of packages that have already been searched for a
        // namespace prefix declaration.
        Set<MofPackageInternal> visitedPackages = new HashSet<MofPackageInternal>( );
        if ( !modelElements.isEmpty( ) ) {
            // Sort the collection according to the composition hierarchy.
            instancesToWrite.addAll( sortTopologically( modelElements ) );
            for ( Iterator it = modelElements.iterator( ); it.hasNext( ); ) {
                RefObject refObj = (RefObject) it.next( );
                instancesToWriteByIdentifier.put( ( (CorePartitionable) refObj ).refMofId( ), refObj );
                addMetamodelToplevelPackages( refObj );
            }
            for ( Iterator it = modelElements.iterator( ); it.hasNext( ); ) {
                RefObject refObj = (RefObject) it.next( );
                findLinksToWrite( refObj );
                if ( writer.getUseNamespaces( ) ) {
                    findXmlNamespaces( refObj, visitedPackages );
                }
            }
        }
    }

    private void addMetamodelToplevelPackages( RefObject refObj ) {

        List<GeneralizableElement> supertypes = new ArrayList<GeneralizableElement>( );
        GeneralizableElement metaObject = (GeneralizableElement) refObj.refMetaObject( );
        supertypes.add( metaObject );
        supertypes.addAll( jmiHelper.getAllSupertypes( session, metaObject ) );
        for ( GeneralizableElement supertype : supertypes ) {
            MofPackage pkg = (MofPackage) ( (MofClassImpl) supertype ).refOutermostComposite( session );
            String metamodelToplevelPackage = ( (CorePartitionable) pkg ).get___Partition( ).getPri( ).getContainerName( ) + "#" + pkg.getName( ); //$NON-NLS-1$
            metamodelToplevelPackages.add( metamodelToplevelPackage );
        }
    }

    /**
     * Sorts the given set of model elements topologically according to
     * composition relationship. Returns a list.
     */
    private List<RefObject> sortTopologically( Set<RefObject> modelElements ) {

        if ( isWritingPartition( ) ) {
            // In partition mode, we can sort more efficiently using
            // SpiModelPartition.getLinks().
            return partitionSort( modelElements );
        }
        return treeSorter.sort( modelElements );
    }

    /**
     * Performs a topological sort of the given set of model elements with
     * respect to "composed by" relationship. The resulting list guarantees that
     * no composition child precedes any of its direct or indirect composition
     * parents.
     */
    private List<RefObject> partitionSort( Set<RefObject> modelElements ) {

        Map<String, Object> mofIdsOfElements = new IdentityHashMap<String, Object>( Math.max( 4, modelElements.size( ) ) );
        for ( RefObject refObj : modelElements ) {
            mofIdsOfElements.put( refObj.refMofId( ), null );
        }
        // A set containing those model elements that have a direct predecessor
        // (= immediate composite).
        Set<Partitionable> elementsWithPredecessors = new HashSet<Partitionable>( modelElements.size( ) );
        // A map containing for each model element the set of direct successors
        // (= composite children).
        Map<Partitionable, Set<Partitionable>> successors = new IdentityHashMap<Partitionable, Set<Partitionable>>( modelElements.size( ) );
        for ( Iterator<SpiLink> it = partitionToWrite.getLinks( ).iterator( ); it.hasNext( ); ) {
            EndStorageLink link = (EndStorageLink) it.next( );
            int compositeEnd = link.getCompositeEnd( );
            if ( compositeEnd != -1 && link.isStorageEnd( compositeEnd ) ) {
                Partitionable child = null;
                MoinReference childRef = link.getOtherEnd( );
                // Check if the composition child is a member of the partition
                // to write, too.
                if ( mofIdsOfElements.containsKey( childRef.getMofId( ) ) ) {
                    child = childRef.get( session );
                    if ( !child.get___Partition( ).equals( partitionToWrite ) ) {
                        continue;
                    }
                    elementsWithPredecessors.add( child );
                    Partitionable parent = link.getStorageEnd( ).get( session );
                    Set<Partitionable> succ = successors.get( parent );
                    if ( succ == null ) {
                        succ = new HashSet<Partitionable>( );
                        successors.put( parent, succ );
                    }
                    succ.add( child );
                }
            }
        }
        // Create a working collection and initialize it with all elements
        // without predecessor (= roots).
        LinkedList<Partitionable> elementsWithoutPredecessors = new LinkedList<Partitionable>( );
        for ( RefObject element : modelElements ) {
            if ( !elementsWithPredecessors.contains( element ) ) {
                elementsWithoutPredecessors.add( element );
            }
        }
        Collections.sort( elementsWithoutPredecessors, this.partitionToWrite.getWorkspace( ).getWorkspaceSet( ).getMoin( ).getByMofIdComparator( ) );
        // The result list.
        List<RefObject> result = new ArrayList<RefObject>( modelElements.size( ) );
        // Main loop: take the next root element, add it to the result set, and
        // add its successors to the working
        // collection.
        while ( !elementsWithoutPredecessors.isEmpty( ) ) {
            Partitionable element = elementsWithoutPredecessors.remove( );
            result.add( (RefObject) element );
            Set<Partitionable> successorsOfElement = successors.get( element );
            if ( successorsOfElement != null ) {
                for ( Partitionable successor : successorsOfElement ) {
                    elementsWithoutPredecessors.add( successor );
                }
            }
        }
        return result;
    }

    /**
     * Recursively collects and returns all composite children of the given
     * model element.
     */
    private Collection<RefObject> getAllCompositeChildren( RefObject refObj ) {

        return jmiHelper.getCompositeChildren( this.session, refObj, true /* recursively */);
    }

    private void collectExtentData( RefPackage extent ) {

        LinkedHashSet<RefObject> refObjects = new LinkedHashSet<RefObject>( );
        findInstancesAndLinksAndNamespaces( extent, refObjects, new HashSet<RefPackage>( ) /* visitedPackages */);
        Set<RefObject> modelElements = new LinkedHashSet<RefObject>( );
        Set<RefObject> staticModelElements = new LinkedHashSet<RefObject>( );
        for ( RefObject refObj : refObjects ) {
            if ( isValueOfStaticAttribute( refObj ) ) {
                // If the RefObject is the value of a classifier-level
                // attribute, it must be serialized in its own XML element at
                // top-level.
                staticModelElements.add( refObj );
            } else {
                modelElements.add( refObj );
            }
            instancesToWriteByIdentifier.put( ( (CorePartitionable) refObj ).refMofId( ), refObj );
        }
        if ( !modelElements.isEmpty( ) ) {
            // Sort the collection according to the composition hierarchy.
            instancesToWrite.addAll( treeSorter.sort( modelElements ) );
        }
        if ( !staticModelElements.isEmpty( ) ) {
            // Sort the collection according to the composition hierarchy.
            instancesToWriteAsStaticAttribute.addAll( treeSorter.sort( staticModelElements ) );
        }
    }

    /**
     * For a given MofPackage, this method looks for a tag named
     * <code>org.omg.xmi.namespace</code>. If the tag is found, an entry is
     * added to the {@link #namespaces} map, mapping the fully qualified package
     * name to the namespace prefix found in the tag.
     */
    private void checkMofPackageForXmiNamespace( MofPackageInternal mofPackage ) {

        String namespacePrefix = xmiNamespaces.get( mofPackage );
        if ( namespacePrefix == null ) {
            namespacePrefix = jmiHelper.getTagValue( session, (ModelElement) mofPackage, XmiConstants.TAGID_XMI_NAMESPACE );
            if ( namespacePrefix == null ) {
                xmiNamespaces.put( mofPackage, "" ); //$NON-NLS-1$
                return;
            } else {
                xmiNamespaces.put( mofPackage, namespacePrefix );
            }
        }
        if ( !"".equals( namespacePrefix ) ) { //$NON-NLS-1$
            //FIXME HACK!!!
            CoreConnection connection = session != null ? session.getConnections( ).iterator( ).next( ) : null;
            namespaces.put( QualifiedName.toDotSeparatedString( mofPackage.getQualifiedName( connection ) ), namespacePrefix );
        }
    }

    /**
     * Finds and stores all XML namespaces that need to be declared at the
     * beginning of the XMI document for proper serialization of the given
     * RefObject. Not only the immediate package of the RefObject has to be
     * inspected, but also all links where the RefObject participates.
     * 
     * @throws com.sap.tc.moin.repository.mmi.reflect.JmiException
     */
    private void findXmlNamespaces( RefObject refObj, Set<MofPackageInternal> visitedPackages ) {

        // First check the immediate package for a org.omg.xmi.namespace tag.
        MofPackageInternal pkg = (MofPackageInternal) refObj.refImmediatePackage( ).refMetaObject( );
        checkMofPackageForXmiNamespace( pkg );
        visitedPackages.add( pkg );
        // Now check all links of refObj whether they introduce further
        // namespaces.
        Map<ReferenceInternal, Collection<EndStorageLink>> linksPerAssociationEnd = linksWithReferences.get( refObj );
        if ( linksPerAssociationEnd != null ) {
            for ( Entry<ReferenceInternal, Collection<EndStorageLink>> entry : linksPerAssociationEnd.entrySet( ) ) {
                for ( EndStorageLink link : entry.getValue( ) ) {
                    // determine the reference at the other end of the link
                    MoinReference otherRef = getOtherLinkEnd( link, entry.getKey( ) );
                    // check link end if it is dangling
                    ConsistencyViolation violation = session.getConsistencyViolationRegistry( ).checkLinkConsistency( link, session );
                    if ( violation == null ) {
                        // Check the containing package of the MofClass at the
                        // other side.
                        MofPackageInternal otherPackage = (MofPackageInternal) mmCache.getContainer( session, (ModelElementInternal) otherRef.getType( session ) );
                        if ( !visitedPackages.contains( otherPackage ) ) {
                            checkMofPackageForXmiNamespace( otherPackage );
                            visitedPackages.add( otherPackage );
                        }
                    }
                }
            }
        }
    }

    /**
     * Writes an object-valued attribute, i.e. an attribute whose type in the
     * metamodel is a MofClass. This method is callable for both instance-level
     * and classifier-level attributes. The <code>owner</code> parameter
     * contains the owning model element in case of an instance-level attribute,
     * and the owning class proxy in case of a classifier-level attribute.
     */
    private void writeObjectValuedAttribute( CorePartitionable owner, AttributeInternal attr ) throws IllegalLinkToTransientPartitionException {

        // In the MOIN, object-valued attributes are stored using a special kind
        // of links, the so-called attribute
        // links. Attribute links are always composite, as required by the MOF
        // specification. To determine the
        // collection of attribute values, we therefore have to query the
        // workspace for this special link set. (Note
        // that we do not use the RefFeatured.refGetValue() method here, as this
        // might result in the undesired loading
        // of model partitions).
        Workspace workspace = ( owner ).get___Workspace( );
        MRI mriOfOwner = owner.get___Mri( );
        // For attribute links, end 0 is always the composite end, and end 1 the
        // component end.
        EndAndMetaObject endAndMetaObject = workspace.getWorkspaceSet( ).getEndAndMetaObjectPool( ).getEndAndMetaObject( 0, attr );
        Collection<EndStorageLink> links = workspace.getMemoryLinkManager( ).getLinksForEndAndMetaObject( session, endAndMetaObject, mriOfOwner );
        if ( links != null && !links.isEmpty( ) ) {
            String elementName = qualifiedName( attr );
            xmlHelper.startElement( elementName );
            for ( Iterator<EndStorageLink> it = links.iterator( ); it.hasNext( ); ) {
                EndStorageLink link = it.next( );
                MoinReference otherRef = link.getEnd( 1 );
                if ( mmCache.getType( session, attr ) instanceof AliasType ) {
                    // In case of an AliasType, aggregation semantics do not
                    // apply. So we need to write an xmi.idref or
                    // href atribute instead of nesting the RefObject. See JMI
                    // 1.0 specification, section 4.8.10.
                    writeLink( link, otherRef, false /* isComposite */, NO_ORDERING /* order */);
                } else {
                    writeLink( link, otherRef, true /* isComposite */, NO_ORDERING /* order */);
                }
            }
            xmlHelper.endElement( elementName );
        }
    }

    /**
     * Writes all XML attributes of the given RefObject to the stream. First,
     * all MOF attributes are written that can be serialized as normal XML
     * attributes. Then, all links for this RefObject from the
     * {@link #linksToBeSerializedAsXmlAttributes} collection are serialized.
     * Finally, all attributes are written which have to serialized as XML
     * elements. Before this happens, the enclosing XML element is closed
     * automatically using "&gt;".
     */
    @SuppressWarnings( { "unchecked" } )
    private void writeXmlAttributesOfInstance( MofClassInternal metaObject, RefObject refObj, double compositeOrderingOfInstance ) throws IllegalLinkToTransientPartitionException {

        //FIXME HACK!!!
        CoreConnection connection = session != null ? session.getConnections( ).iterator( ).next( ) : null;
        List<AttributeInternal> attrsInContent = new ArrayList<AttributeInternal>( );
        List<AttributeInternal> attrsWithCData = new ArrayList<AttributeInternal>( );
        for ( AttributeInternal attr : mmCache.getInstanceAttributes( session, metaObject ) ) {
            Object value = null;
            Classifier type = jmiHelper.getNonAliasType( session, (Classifier) mmCache.getType( session, attr ) );
            if ( type instanceof MofClassInternal ) {
                // Object-valued attribute have to be serialized as elements.
                attrsInContent.add( attr );
                continue;
            } else {
                try {
                    value = ( (RefObjectImpl) refObj ).refGetValue( connection, attr.getName( ) );
                } catch ( Exception e ) {
                    JmiException jmiException = new JmiException( XMI.MOIN_XMI_1012, QualifiedName.toDotSeparatedString( ( (ModelElementInternal) refObj.refMetaObject( ) ).getQualifiedName( connection ) ), attr.getName( ) );
                    jmiException.initCause( e );
                    throw jmiException;
                }
            }
            Object valueToWrite = value;
            if ( value == null ) {
                // optional attribute with no value
                continue;
            }
            if ( isMultiValued( attr ) ) {
                // in case of a single value, there may be an object returned!
                Collection col = null;
                if ( value instanceof Collection ) {
                    col = (Collection) value;
                } else {
                    col = new ArrayList( 1 );
                    col.add( value );
                }
                if ( col.isEmpty( ) ) {
                    continue;
                }
                if ( col.size( ) > 1 ) {
                    // values have to be serialized in content
                    attrsInContent.add( attr );
                    continue;
                } else {
                    valueToWrite = col.iterator( ).next( );
                }
            }
            if ( !( type instanceof PrimitiveType ) && !( type instanceof EnumerationType ) ) {
                // non-primitive values have to be serialized as sub-elements
                // later on (see below)
                attrsInContent.add( attr );
            } else {
                if ( xmlHelper.requiresCData( valueToWrite.toString( ) ) ) {
                    attrsWithCData.add( attr );
                } else {
                    writeValueInAttr( attr, valueToWrite );
                }
            }
        }
        // Now serialize all links that can be written as XML attributes.
        Map<ReferenceInternal, Collection<EndStorageLink>> linkMap = linksToBeSerializedAsXmlAttributes.get( refObj );
        if ( linkMap != null ) {
            for ( Entry<ReferenceInternal, Collection<EndStorageLink>> entry : linkMap.entrySet( ) ) {
                StringBuilder value = new StringBuilder( );
                AssociationEndInternal referencedEnd = mmCache.getReferencedEnd( session, entry.getKey( ) );
                int otherEnd = mmCache.getAssociationEndNumber( session, referencedEnd );
                for ( Iterator<EndStorageLink> linksIt = entry.getValue( ).iterator( ); linksIt.hasNext( ); ) {
                    EndStorageLink link = linksIt.next( );
                    MoinReference otherRef = link.getEnd( otherEnd );
                    value.append( getXmiId( otherRef.getMri( session ) ) );
                    if ( linksIt.hasNext( ) ) {
                        value.append( ' ' );
                    }
                }
                xmlHelper.addAttribute( entry.getKey( ).getName( ), value.toString( ), false /* replaceSpecialChars */);
            }
            linksToBeSerializedAsXmlAttributes.remove( refObj );
        }
        if ( compositeOrderingOfInstance != NO_ORDERING ) {
            xmlHelper.addAttribute( XmiConstants.ORDERING_ATTRIBUTE, String.valueOf( compositeOrderingOfInstance ), false /* replaceSpecialChars */);
        }
        for ( Iterator it = attrsWithCData.iterator( ); it.hasNext( ); ) {
            AttributeInternal attr = (AttributeInternal) it.next( );
            writeValueInAttrAsCData( attr, ( (RefObjectImpl) refObj ).refGetValue( connection, attr.getName( ) ) );
        }
        for ( Iterator it = attrsInContent.iterator( ); it.hasNext( ); ) {
            AttributeInternal attr = (AttributeInternal) it.next( );
            Classifier type = jmiHelper.getNonAliasType( session, (TypedElement) attr );
            if ( type instanceof MofClassInternal ) {
                writeObjectValuedAttribute( (CorePartitionable) refObj, attr );
            } else {
                writeValueInContent( attr, ( (RefObjectImpl) refObj ).refGetValue( connection, attr.getName( ) ) );
            }
        }
    }

    /**
     * Writes a model element to the stream, including all attributes of its
     * MofClass and all supertypes thereof.
     * <p>
     * At the end of the call, the processed model element is removed from the
     * {@link #instancesToWrite} collection.
     */
    private void writeInstance( RefObject refObj, double order ) throws IllegalLinkToTransientPartitionException {

        MofClassInternal metaObject = (MofClassInternal) refObj.refMetaObject( );
        String name = qualifiedName( metaObject );
        xmlHelper.startElement( name );
        // Write the xmi.id attribute, potentially asking a registered
        // XmiReferenceProvider.
        MRI mri = null;
        try {
            mri = ( (CorePartitionable) refObj ).get___Mri( );
        } catch ( Exception ex ) {
            throw new XmiWriteException( XMI.MRIFAILURE, ex );
        }
        xmlHelper.addAttribute( XmiConstants.XMI_ID, getXmiId( mri ), !isWritingPartition( ) );
        // Write all instance attributes (as XML attributes as well as
        // elements).
        writeXmlAttributesOfInstance( metaObject, refObj, order );
        // Write all of refObj's links for which a MOF reference exist in the
        // metamodel (standard XMI).
        writeLinksWithReference( refObj );
        xmlHelper.endElement( name );
        // Finally, mark the model element as written.
        writtenInstances.add( refObj );
    }



    /**
     * Writes all links to the stream that have an end referencing the given
     * RefObject, and for which a reference in the metamodel exists, owned by
     * the MofClass (or a supertype thereof) of the RefObject.
     * <p>
     * Note: Links for which the conditions above do not hold, are (if at all)
     * serialized in the {@link #writeLinksWithoutReference()} method instead.
     */
    private void writeLinksWithReference( RefObject refObj ) throws IllegalLinkToTransientPartitionException {

        // Retrieve the links collected in the preparation phase, if any.
        Map<ReferenceInternal, Collection<EndStorageLink>> linksPerReference = linksWithReferences.get( refObj );
        if ( linksPerReference != null ) {
            for ( Iterator<Entry<ReferenceInternal, Collection<EndStorageLink>>> it = linksPerReference.entrySet( ).iterator( ); it.hasNext( ); ) {
                Entry<ReferenceInternal, Collection<EndStorageLink>> entry = it.next( );
                ReferenceInternal mofReference = entry.getKey( );
                boolean isComposite = ( mmCache.getExposedEnd( session, mofReference ).getAggregation( ) == AggregationKindEnum.COMPOSITE );
                boolean writeOrdering = ( isWritingPartition( ) && isAssociationOrdered( (AssociationInternal) mmCache.getContainer( session, mmCache.getReferencedEnd( session, mofReference ) ) ) );
                String enclosingElementName = qualifiedName( mofReference );
                xmlHelper.startElement( enclosingElementName );
                double ordering = -1.0;
                for ( EndStorageLink link : entry.getValue( ) ) {
                    LinkInfo key = new LinkInfo( link );
                    Double assignedOrder = orderAssignedToLinks.get( key );
                    if ( assignedOrder != null ) {
                        ordering = assignedOrder;
                    } else {
                        ordering++;
                        orderAssignedToLinks.put( key, ordering );
                    }
                    // Determine the reference at the other end of the link.
                    MoinReference otherRef = getOtherLinkEnd( link, mofReference );
                    writeLink( link, otherRef, isComposite, writeOrdering ? ordering : NO_ORDERING );
                }
                it.remove( );
                xmlHelper.endElement( enclosingElementName );
            }
            linksWithReferences.remove( refObj );
        }
    }

    /**
     * Writes a single link to the stream. Depending on whether the link is
     * composite or not, this results in a call to:
     * <ul>
     * <li>{@link #writeInstance(RefObject)}, if the link is composite and the
     * model element at the other end of the link is a member of the
     * {@link #instancesToWriteByIdentifier} collection</li> <li>
     * {@link #writeInstanceRef(RefObject, double)}, if the link is <em>not</em>
     * composite and the model element at the other end of the link is a member
     * of the {@link #instancesToWriteByIdentifier} collection</li> <li>
     * {@link #writeHref(MoinReference, double)}, if the link is either
     * composite or not composite, and the model element at the other end of the
     * link is <em>not</em> a member of the
     * {@link #instancesToWriteByIdentifier} collection</li>
     * </ul>
     * In partition mode, an {@link IllegalLinkToTransientPartitionException} is
     * thrown if the model element at the other end of the link is assigned to a
     * {@link Workspace#getNullPartition() transient partition}, which is
     * considered illegal during serialization.
     * 
     * @param otherRef The MOIN reference to the model element at the other end
     * of the link.
     * @param isComposite Whether the link is composite or not. Depending on the
     * value, the model element at the other end of the link is either nested,
     * or referenced using an XMI proxy.
     * @param order The ordering criterion of the link (see
     * {@link com.sap.tc.moin.repository.spi.core.SpiLink#getOrdering()}). This
     * value is only written to the stream if it is greater than
     * {@link #NO_ORDERING}. The calling code has to ensure that a value
     * different from {@link #NO_ORDERING} is only passed to this method in
     * <em>partition mode</em> and if the association is ordered.
     */
    private void writeLink( EndStorageLink link, MoinReference otherRef, boolean isComposite, double order ) throws IllegalLinkToTransientPartitionException {

        RefObject otherObj = instancesToWriteByIdentifier.get( otherRef.getMofId( ) );
        if ( otherObj != null ) {
            // The model element at the other end is also part of the instances
            // collection.
            if ( isComposite ) {
                writeInstance( otherObj, order );
            } else {
                writeInstanceRef( otherObj, order );
            }
        } else {
            // The model element at the other end is external to the instances
            // collection.
            if ( isWritingPartition( ) ) {
                // We are in partition mode. Check if the component lives in the
                // transient partition.
                checkLinkToTransientPartition( otherRef );
            }
            writeHref( link, otherRef, order );
        }
    }

    /**
     * This method gets called after the <code>&lt;XMI.content&gt;</code>
     * element has been written. If SAP specific information needs to be written
     * (like links with storage contrary to normal storage), an
     * <code>&lt;XMI.extensions&gt;</code> element is written containing this
     * information.
     */
    private void writeSAPExtensions( ) throws IllegalLinkToTransientPartitionException {

        // Check whether there is SAP specific information to write or not.
        if ( !hasSAPSpecificLinksToWrite( ) ) {
            return;
        }
        xmlHelper.startElement( XmiConstants.XMI_EXTENSIONS );
        xmlHelper.addAttribute( XmiConstants.XMI_EXTENDER, XmiConstants.SAP_EXTENDER, false /* replaceSpecialChars */);
        writeSAPSpecificLinks( );
        xmlHelper.endElement( XmiConstants.XMI_EXTENSIONS );
    }

    /**
     * Checks if the given {@link MoinReference} points to a model element
     * living in a transient partition. If yes, a
     * <code>IllegalLinkToTransientPartitionException</code> is thrown. Note
     * that the check is only performed if the {@link MoinReference} is cached
     * to prevent the undesired loading of partitions.
     */
    private void checkLinkToTransientPartition( MoinReference reference ) throws IllegalLinkToTransientPartitionException {

        if ( reference.isCached( ) ) {
            PRI pri = reference.getPri( session );
            if ( pri != null && ( pri.isVolatilePartition( ) ) ) {
                // TODO update message text
                throw new IllegalLinkToTransientPartitionException( XMI.MOIN_XMI_1015, new Object[] { reference.getMofId( ) } );
            }
        }
    }

    /**
     * Returns the "best-matching" reference exposing the given association end,
     * with respect to the given MofClass's supertype hierarchy. This means that
     * the supertype hierarchy is searched for the most specific reference
     * exposing the association end. This is necessary because that reference
     * determines the name of the XMI element that has to be written to the
     * stream.
     * <p>
     * Note that there might be an ambiguity in the metamodel, in case of
     * multiple inheritance and each supertype defining its own reference to the
     * same association end. The algorithm used in this method needs to provide
     * a stable answer in that case, which it does by sorting the ambiguous
     * references lexically.
     */
    @SuppressWarnings( "unchecked" )
    private ReferenceInternal getReferenceForAssociationEnd( MofClassInternal mofClass, AssociationEndInternal end ) {

        ReferenceInternal result = null;
        Map<MofClassInternal, ReferenceInternal> map = referenceToAssociationEnd.get( end );
        if ( map == null ) {
            map = new IdentityHashMap<MofClassInternal, ReferenceInternal>( );
            referenceToAssociationEnd.put( end, map );
        } else {
            if ( map.containsKey( mofClass ) ) {
                return map.get( mofClass );
            }
        }
        JmiList<Reference> references = (JmiList<Reference>) jmiHelper.getReferences( session, (AssociationEnd) end );
        if ( !references.isEmpty( this.session ) ) {
            ArrayList<Reference> referencesToEnd = new ArrayList<Reference>( );
            Iterator<Reference> referencesIterator = references.iteratorReadOnly( session );
            for ( ; referencesIterator.hasNext( ); ) {
                referencesToEnd.add( referencesIterator.next( ) );
            }

            /**
             * There are references defined in the metamodel that expose this
             * association end. If the collection contains more than one
             * reference, the following algorithm has to determine the correct
             * reference to use for the element name, by looking at the
             * inheritance graph. This situation can e.g. occur in the following
             * scenario: assume an association between the classes A and B, and
             * A has subclasses A' and A''. A does not declare a reference, but
             * A' declares a reference r1 and A'' declares a reference r2. Then
             * both references expose the same association end located at A,
             * possible using different names.
             * <p>
             * Now first, if more than one reference exists, throw out all
             * references not owned by refObj's type or one of its supertypes.
             * Only the remaining ones are candidates.
             */

            //FIXME HACK!!!
            CoreConnection connection = session != null ? session.getConnections( ).iterator( ).next( ) : null;
            if ( referencesToEnd.size( ) > 1 ) {
                ArrayList refObjSupertypes = new ArrayList( );
                refObjSupertypes.add( mofClass );

                refObjSupertypes.addAll( mofClass.allSupertypes( connection ) );
                for ( Iterator it = referencesToEnd.iterator( ); it.hasNext( ); ) {
                    Reference ref = (Reference) it.next( );
                    if ( !refObjSupertypes.contains( ref.getContainer( ) ) ) {
                        it.remove( );
                    }
                }
            }
            // Hopefully, only one reference is left now.
            if ( referencesToEnd.size( ) == 1 ) {
                // The most common case: use the only existing reference.
                result = (ReferenceInternal) referencesToEnd.iterator( ).next( );
            } else {
                // There is still more than one reference. We have to find the
                // one
                // owned by the most specific type.
                for ( Iterator outer = referencesToEnd.iterator( ); outer.hasNext( ); ) {
                    Reference ref1 = (Reference) outer.next( );
                    MofClass mc1 = (MofClass) ref1.getContainer( );
                    ArrayList refsClone = (ArrayList) referencesToEnd.clone( );
                    for ( Iterator inner = refsClone.iterator( ); inner.hasNext( ); ) {
                        Reference ref2 = (Reference) inner.next( );
                        if ( ref2 == ref1 ) {
                            continue;
                        }
                        MofClassInternal mc2 = (MofClassInternal) ref2.getContainer( );
                        List supertypes = mc2.allSupertypes( connection );
                        if ( supertypes.contains( mc1 ) ) {
                            // mc2 is more specific than mc1 => throw out mc1
                            outer.remove( );
                            break;
                        }
                    }
                }
                // Hopefully there is only one reference left now, the one with
                // the
                // most specific owning MofClass.
                if ( referencesToEnd.size( ) == 1 ) {
                    result = (ReferenceInternal) referencesToEnd.iterator( ).next( );
                } else {
                    /**
                     * There is an ambiguity, caused by multiple inheritance. We
                     * have to decide for one reference. This algorithm always
                     * chooses the first reference in the set ordered lexically
                     * by the reference's names, to provide a stable behaviour.
                     */
                    Set<Reference> sortedSet = new TreeSet<Reference>( new Comparator<Reference>( ) {

                        public int compare( Reference ref1, Reference ref2 ) {

                            return ref1.getName( ).toLowerCase( Locale.ENGLISH ).compareTo( ref2.getName( ).toLowerCase( Locale.ENGLISH ) );
                        }
                    } );
                    sortedSet.addAll( referencesToEnd );
                    result = (ReferenceInternal) sortedSet.iterator( ).next( );
                }
            }
        }
        map.put( mofClass, result );
        return result;
    }

    /**
     * Returns the character that separates the URI from the XMI ID. In XMI 1.2,
     * this is the '|' character. In XMI 2.0, the '#' character is used instead.
     */
    protected String getHrefDelimiter( ) {

        return XmiConstants.XMI_HREF_DELIMITER_12;
    }

    /**
     * Writes an XMI proxy for an external model element. The given
     * {@link MoinReference} points to the referenced model element.
     * <p>
     * Note that in partition mode, the XML element name of the XMI proxy is
     * always the (potentially prefixed) qualified name of the class directly
     * connected to the association, even if subclasses exist in the metamodel.
     * This is to avoid the loading of the external partition in case it is
     * evicted, just to find out about the concrete type of the referenced model
     * element. Only in non-partition mode (standard XMI export), the type
     * unconditionally gets resolved.
     */
    private void writeHref( EndStorageLink link, MoinReference reference, double order ) {

        String elementName = null;
        if ( isWritingPartition( ) ) {
            Association assoc = (Association) link.getMetaObject( );
            int endNumberOfOtherEnd = link.getEndNumberOfOtherEnd( );
            AssociationEnd otherEnd = jmiHelper.getAssociationEnds( session, assoc ).get( endNumberOfOtherEnd );
            elementName = qualifiedName( mmCache.getType( session, (TypedElementInternal) otherEnd ) );
        } else {

            ModelElementInternal type = (ModelElementInternal) reference.getType( session );
            if ( type != null ) {
                elementName = qualifiedName( type );
            } else {
                // We encountered a dangling link. Write it just like in
                // partition mode.
                Association assoc = (Association) link.getMetaObject( );
                int endNumberOfOtherEnd = link.getEndNumberOfOtherEnd( );
                AssociationEnd otherEnd = jmiHelper.getAssociationEnds( session, assoc ).get( endNumberOfOtherEnd );
                elementName = qualifiedName( mmCache.getType( session, (TypedElementInternal) otherEnd ) );
            }

        }
        xmlHelper.startElement( elementName );
        String href;
        XmiReferenceProvider referenceProvider = writer.getReferenceProvider( );
        try {
            if ( referenceProvider != null ) {
                // If an external XmiReferenceProvider is set, ask it for the
                // location part and the ID part, and
                // concatenate them using the delimiter character depending on
                // the XMI version.
                href = referenceProvider.getResourceLocation( reference.getMri( session ) );
                new URI( href ); // test URI for correct syntax
                href += getHrefDelimiter( ) + referenceProvider.getIdentifier( reference.getMri( session ) );
            } else {
                // If no external XmiReferenceProvider is set, always use a MOIN
                // internal href format.
                href = getHrefForCrossPartitionLink( reference );
            }
        } catch ( Exception ex ) {
            throw new XmiWriteException( XMI.HREFWRITEFAILED, ex );
        }
        xmlHelper.addAttribute( XmiConstants.XMI_HREF, href, false /* replaceSpecialChars */);
        if ( order != NO_ORDERING ) {
            xmlHelper.addAttribute( XmiConstants.ORDERING_ATTRIBUTE, String.valueOf( order ), false /* replaceSpecialChars */);
        }
        xmlHelper.endElement( elementName );
    }

    /**
     * Returns the value of the <code>href</code> attribute for the
     * cross-partition link to the given {@link MoinReference}.
     */
    private String getHrefForCrossPartitionLink( MoinReference reference ) {

        try {
            if ( isWritingPartition( ) ) {
                DataAreaDescriptor ownDataArea = partitionToWrite.getPri( ).getDataAreaDescriptor( );
                boolean equal = false;
                LRI lri = reference.getLri( );
                if ( lri != null ) {
                    DataAreaDescriptor otherDataArea = lri.getDataAreaDescriptor( );
                    equal = ownDataArea.equals( otherDataArea );
                } else {
                    // We have a dangling link. The following code is hacky: to
                    // determine whether the reference points
                    // to some model element within the same data area, we parse
                    // the LRI string. We cannot go the
                    // correct way because reference.getPri() resulted in the
                    // ElementNotFoundException.
                    String lriString = reference.toString( );
                    String dataAreaString = lriString.substring( 0, lriString.lastIndexOf( ':' ) + 1 );
                    equal = ownDataArea.toString( ).equals( dataAreaString );
                }

                if ( equal ) {
                    return "local:" + reference.getMofId( ); //$NON-NLS-1$
                } else {
                    return reference.getLri( ).toString( );
                }
            } else {
                return reference.getPri( session ).toString( ) + getHrefDelimiter( ) + reference.getMofId( );
            }
        } catch ( Exception ex ) {
            throw new XmiWriteException( XMI.RESOLVECROSSPARITIONLINKFAILED, ex );
        }
    }

    /**
     * Writes the XML preamble and the <code>&lt;XMI&gt;</code> root element to
     * the stream.
     */
    private void writePreamble( ) {

        xmlHelper.write( "<?xml version=\"1.0\" encoding=\"" + writer.getEncoding( ) + "\"?>" ); //$NON-NLS-1$//$NON-NLS-2$
        xmlHelper.writeln( );
        xmlHelper.startElement( XmiConstants.XMI_ROOT );
        xmlHelper.addAttribute( XmiConstants.XMI_VERSION_ATT, getXmiVersion( ), false /* replaceSpecialChars */);
        writeNamespaceDeclarations( );
        if ( writer.getUseTimestamp( ) ) {
            xmlHelper.addAttribute( XmiConstants.XMI_TIMESTAMP, new Date( ).toString( ), false /* replaceSpecialChars */);
        }
    }

    /**
     * Writes the <code>&lt;XMI.header&gt;</code> element to the stream. If a
     * header provider is registered, it is used. Otherwise, a default header
     * will be written.
     * <p>
     * TODO implement header provider case
     */
    private void writeHeader( ) {

        xmlHelper.startElement( XmiConstants.XMI_HEADER );
        xmlHelper.startElement( XmiConstants.XMI_DOCUMENTATION );
        xmlHelper.startElement( XmiConstants.XMI_EXPORTER );
        xmlHelper.characters( XmiConstants.SAP_EXPORTER );
        xmlHelper.endElement( XmiConstants.XMI_EXPORTER );
        xmlHelper.startElement( XmiConstants.XMI_EXPORTER_VERSION );
        xmlHelper.characters( EXPORTER_VERSION );
        xmlHelper.endElement( XmiConstants.XMI_EXPORTER_VERSION );
        xmlHelper.endElement( XmiConstants.XMI_DOCUMENTATION );
        for ( String containerName : metamodelToplevelPackages ) {
            xmlHelper.startElement( XmiConstants.XMI_METAMODEL );
            xmlHelper.addAttribute( XmiConstants.XMI_NAME_ATT, containerName, false /* replaceSpecialChars */);
            xmlHelper.addAttribute( XmiConstants.XMI_VERSION_ATT, "", false /* replaceSpecialChars */); //$NON-NLS-1$
            // TODO Add metamodel version info to XMI header?
            xmlHelper.endElement( XmiConstants.XMI_METAMODEL );
        }
        xmlHelper.endElement( XmiConstants.XMI_HEADER );
    }

    /**
     * Adds the namespace declarations to the <code>&lt;XMI&gt;</code> element.
     * The set of actually required namespaces must have already been computed
     * by calls to {@link #findXmlNamespaces(RefObject, Set)}, and stored in the
     * {@link #namespaces} map.
     */
    private void writeNamespaceDeclarations( ) {

        xmlHelper.addAttribute( XmiConstants.XMLNS + XmiConstants.NS_SEPARATOR + XmiConstants.SAP_NAMESPACE_PREFIX, XmiConstants.SAP_NAMESPACE_URI, false /* replaceSpecialChars */);
        // The same namespace prefix might be assigned to multiple packages.
        Set<String> uniqueSortedPrefixes = new TreeSet<String>( namespaces.values( ) );
        for ( String nsPrefix : uniqueSortedPrefixes ) {
            xmlHelper.addAttribute( XmiConstants.XMLNS + XmiConstants.NS_SEPARATOR + nsPrefix, XmiConstants.TAGID_XMI_NAMESPACE + XmiConstants.DOT_SEPARATOR + nsPrefix, false /* replaceSpecialChars */);
        }
    }

    /**
     * Recursively iterates over the given package and all of its nested and
     * clustered packages, and for each package collects all instances of all
     * contained classes and all links of all contained associations.
     * Furthermore, if serialization using namespace prefixes is desired (see
     * {@link com.sap.tc.moin.repository.xmi.XmiWriter#getUseNamespaces()}),
     * each package is checked for the existence of a
     * <em>org.omg.xmi.namespace</em> tag.
     * <p>
     * TODO Implement.
     * 
     * @param instances the result collection of model elements
     * @param visitedPackages the set of already visited packages
     */
    @SuppressWarnings( { "unchecked" } )
    private void findInstancesAndLinksAndNamespaces( RefPackage pkg, Collection<RefObject> instances, Set<RefPackage> visitedPackages ) {

        // if (visitedPackages.contains(pkg)) {
        // return;
        // }
        // if (writer.getUseNamespaces()) {
        // checkMofPackageForXmiNamespace((MofPackage) pkg.refMetaObject());
        // }
        // // Iterate over all classes of the current package, and add all
        // // instances of each class to the result collection.
        // for (Iterator it = pkg.refAllClasses().iterator(); it.hasNext();) {
        // RefClass classProxy = (RefClass) it.next();
        // instances.addAll(classProxy.refAllOfClass());
        // }
        // for (Iterator it = pkg.refAllAssociations().iterator();
        // it.hasNext();) {
        // RefAssociation associationProxy = (RefAssociation) it.next();
        // Collection links = associationProxy.refAllLinks();
        // if (links != null && !links.isEmpty()) {
        // // The problem: XMI requires all model elements
        // // to be nested according to their composition hierarchy. This
        // // essentially means that we need to investigate all composite
        // // associations and links thereof, and re-order the previously
        // // collected model elements stored in the "instances" collection
        // // (at least in a way that all components follow their
        // // composite).
        // // for (Iterator linksIt = links.iterator(); linksIt.hasNext();)
        // // {
        // // RefAssociationLink link = (RefAssociationLink) linksIt
        // // .next();
        // // }
        // }
        // }
        // // Mark the package as visited.
        // visitedPackages.add(pkg);
        // // Recursively descend for all nested and clustered packages.
        // for (Iterator it = pkg.refAllPackages().iterator(); it.hasNext();) {
        // findInstancesAndLinksAndNamespaces((RefPackage) it.next(), instances,
        // visitedPackages);
        // }
    }

    /**
     * Writes a document-internal reference to an instance, using the
     * <code>xmi.idref</code> attribute.
     */
    private void writeInstanceRef( RefObject refObj, double order ) {

        ModelElementInternal modelElement = (ModelElementInternal) refObj.refMetaObject( );
        if ( modelElement == null ) {
            throw new NullPointerException( XMI.MOIN_XMI_1010.format( new Object[] { refObj } ) );
        }
        String name = qualifiedName( modelElement );
        xmlHelper.startElement( name );
        MRI mri = null;
        try {
            mri = ( (CorePartitionable) refObj ).get___Mri( );
        } catch ( Exception ex ) {
            throw new XmiWriteException( XMI.MRIFAILURE, ex );
        }
        xmlHelper.addAttribute( XmiConstants.XMI_IDREF, getXmiId( mri ), !isWritingPartition( ) );
        if ( order != NO_ORDERING ) {
            xmlHelper.addAttribute( XmiConstants.ORDERING_ATTRIBUTE, String.valueOf( order ), false /* replaceSpecialChars */);
        }
        xmlHelper.endElement( name );
    }

    /**
     * Returns the XMI-ID from the given MRI. If an external
     * XmiReferenceProvider was set, it is asked. Otherwise, it defaults to the
     * MOF-ID.
     */
    private String getXmiId( MRI mriOfRefObject ) {

        XmiReferenceProvider referenceProvider = writer.getReferenceProvider( );
        if ( referenceProvider != null ) {
            // An external XmiReferenceProvider is set. Ask it to provide the
            // XMI ID.
            try {
                return referenceProvider.getIdentifier( mriOfRefObject );
            } catch ( Exception ex ) {
                throw new XmiWriteException( XMI.XMIIDNOTFOUND, ex );
            }
        } else {
            return mriOfRefObject.getMofId( );
        }
    }

    /**
     * Serializes an attribute's value of Primitive or Enumeration type as a
     * normal XML attribute.
     */
    private void writeValueInAttr( TypedElementInternal attr, Object value ) {

        String asText = value.toString( );
        ClassifierInternal type = mmCache.getType( session, attr );
        if ( type instanceof EnumerationTypeInternal ) {
            // Check for an enumeration label prefix that needs to be removed.
            String prefix = mmCache.getEnumerationTypeUnPrefix( session, (EnumerationTypeInternal) type );
            // Note: prefix is always != null (but can be the empty String)
            asText = asText.substring( prefix.length( ) );
        }
        xmlHelper.addAttribute( attr.getName( ), asText, false /* replaceSpecialChars */);
    }

    /**
     * Serializes an attribute's value of Primitive type in a CDATA section.
     */
    private void writeValueInAttrAsCData( TypedElementInternal attr, Object value ) {

        if ( attr == null || value == null ) {
            return;
        }
        String name = qualifiedName( attr );
        if ( value instanceof String ) {
            xmlHelper.startElement( name );
            xmlHelper.write( "><![CDATA[" + value + "]]>" ); //$NON-NLS-1$ //$NON-NLS-2$
            xmlHelper.setHasCharacters( true );
            xmlHelper.endElement( name );
        } else if ( value instanceof Collection ) {
            Collection col = (Collection) value;
            for ( Iterator it = col.iterator( ); it.hasNext( ); ) {
                xmlHelper.startElement( name );
                xmlHelper.write( "><![CDATA[" + it.next( ).toString( ) + "]]>" ); //$NON-NLS-1$ //$NON-NLS-2$
                xmlHelper.setHasCharacters( true );
                xmlHelper.endElement( name );
            }
        } else {
            xmlHelper.startElement( name );
            xmlHelper.write( "><![CDATA[" + value.toString( ) + "]]>" ); //$NON-NLS-1$ //$NON-NLS-2$
            xmlHelper.setHasCharacters( true );
            xmlHelper.endElement( name );
        }
    }

    /**
     * Serializes an attribute's value(s) into the content of the surrounding
     * element. This method is callable both for instance-level and
     * classifier-level attributes.
     * <p>
     * In case of a multi-valued attribute, the given value is expected to be a
     * collection.
     */
    @SuppressWarnings( { "unchecked" } )
    private void writeValueInContent( AttributeInternal attr, Object value ) throws IllegalLinkToTransientPartitionException {

        if ( value == null ) {
            // No value is set => nothing to serialize.
            return;
        }
        // Determine the collection of values (possibly containing one entry
        // only).
        Collection values;
        if ( isMultiValued( attr ) ) {
            values = (Collection) value;
        } else {
            values = new ArrayList( );
            values.add( value );
        }
        Classifier type = jmiHelper.getNonAliasType( session, (TypedElement) attr );
        String elementName = qualifiedName( attr );
        if ( type instanceof StructureType ) {
            xmlHelper.startElement( elementName );
            for ( Iterator it = values.iterator( ); it.hasNext( ); ) {
                // For a StructureType, the values are expected to be instances
                // of RefStruct.
                writeStructureType( (StructureTypeInternal) type, (RefStruct) it.next( ) );
            }
            xmlHelper.endElement( elementName );
        } else if ( type instanceof PrimitiveType ) {
            // PrimitiveType values are serialized in the content of the
            // surrounding element (as opposed to normal XML attributes), if and
            // only if they are multi-valued and contain more than one value.
            for ( Iterator it = values.iterator( ); it.hasNext( ); ) {
                Object obj = it.next( );
                xmlHelper.startElement( elementName );
                xmlHelper.characters( obj.toString( ) );
                xmlHelper.endElement( elementName );
            }
        } else if ( type instanceof EnumerationTypeInternal ) {
            // EnumerationType values are serialized in the content of the
            // surrounding element (as opposed to normal XML attributes), if and
            // only if they are multi-valued and contain more than one value.
            for ( Iterator it = values.iterator( ); it.hasNext( ); ) {
                xmlHelper.startElement( elementName );
                // Optional enumeration label prefixes have to be removed before
                // the label is serialized as a String.
                String prefix = mmCache.getEnumerationTypeUnPrefix( session, (EnumerationTypeInternal) type );
                String label = it.next( ).toString( ).substring( prefix.length( ) );
                xmlHelper.addAttribute( XmiConstants.XMI_VALUE, label, false /* replaceSpecialChars */);
                xmlHelper.endElement( elementName );
            }
        } else {
            throw new JmiException( XMI.MOIN_XMI_1013, QualifiedName.toDotSeparatedString( type.getQualifiedName( ) ) );
        }
    }

    /**
     * Serializes a StructureType.
     */
    private void writeStructureType( StructureTypeInternal type, RefStruct value ) throws IllegalLinkToTransientPartitionException {

        List<StructureFieldInternal> fields = mmCache.getStructureFields( session, type );
        List<StructureFieldInternal> fieldsInContent = new ArrayList<StructureFieldInternal>( );
        xmlHelper.startElement( qualifiedName( type ) );
        for ( StructureFieldInternal field : fields ) {
            Classifier fieldType = jmiHelper.getNonAliasType( session, (TypedElement) field );
            if ( fieldType instanceof PrimitiveType || fieldType instanceof EnumerationType ) {
                Object fieldValue = value.refGetValue( ( (ModelElement) field ).getName( ) );
                xmlHelper.addAttribute( field.getName( ), fieldValue.toString( ), true /* replaceSpecialChars */);
            } else {
                fieldsInContent.add( field );
            }
        }
        for ( StructureFieldInternal field : fieldsInContent ) {
            Classifier fieldType = jmiHelper.getNonAliasType( session, (TypedElement) field );
            Object fieldValue = value.refGetValue( ( (ModelElement) field ).getName( ) );
            xmlHelper.startElement( qualifiedName( field ) );
            if ( fieldType instanceof MofClass ) {
                MoinReference otherRef = getMoinReferenceForInternalUse( (CorePartitionable) fieldValue );
                // StructureFields do not have aggregation semantics. Therefore
                // write an xmi.idref or a href
                // attribute.
                writeLink( null /* link */, otherRef, false /* isComposite */, NO_ORDERING /* order */);
            } else if ( fieldType instanceof StructureType ) {
                writeStructureType( (StructureTypeInternal) fieldType, (RefStruct) fieldValue );
            }
            xmlHelper.endElement( qualifiedName( field ) );
        }
        xmlHelper.endElement( qualifiedName( type ) );
    }

    // /**
    // * Serializes a CollectionType.
    // */
    // private void writeCollectionType(CollectionType collType, Collection values)
    // throws IllegalLinkToTransientPartitionException {
    // String collTypeName = qualifiedName(collType);
    // xmlHelper.startElement(collTypeName);
    // Classifier type = mmCache.getType(collType);
    // String typeName = qualifiedName(type);
    // if (type instanceof MofClass) {
    // for (Iterator it = values.iterator(); it.hasNext();) {
    // RefObject refObj = (RefObject) it.next();
    // MoinReference otherRef = getMoinReferenceForInternalUse((CorePartitionable)
    // refObj);
    // // CollectionType does not have aggregation semantics. Therefore
    // // write an non-composite link.
    // writeLink(null /* link */, otherRef, false /* isComposite */, NO_ORDERING /*
    // order */);
    // }
    // } else if (type instanceof StructureType) {
    // for (Iterator it = values.iterator(); it.hasNext();) {
    // xmlHelper.startElement(typeName);
    // writeStructureType((StructureType) type, (RefStruct) it.next());
    // xmlHelper.endElement(typeName);
    // }
    // } else if (type instanceof CollectionType) {
    // for (Iterator it = values.iterator(); it.hasNext();) {
    // writeCollectionType((CollectionType) type, (Collection) it.next());
    // }
    // } else if (type instanceof PrimitiveType) {
    // for (Iterator it = values.iterator(); it.hasNext();) {
    // xmlHelper.startElement(typeName);
    // xmlHelper.characters(it.next().toString());
    // xmlHelper.endElement(typeName);
    // }
    // }
    // xmlHelper.endElement(collTypeName);
    // }

    /**
     * Returns a {@link MoinReference} to the given instance of
     * {@link CorePartitionable}.
     */
    private MoinReference getMoinReferenceForInternalUse( CorePartitionable partitionable ) {

        CoreSession requestor = session;
        return partitionable.get___Workspace( ).getWorkspaceSet( ).getReferenceManager( ).getMriReference( partitionable, requestor.getWorkspace( ) );
    }

    /**
     * Recursively serializes the values of all classifier-level attributes of
     * classes contained in the given package and all of its nested and
     * clustered packages.
     */
    private void writeStaticAttributes( RefPackage pkg, Set<RefPackage> visitedPackages ) throws IllegalLinkToTransientPartitionException {

        if ( visitedPackages.contains( pkg ) ) {
            return;
        }
        for ( Iterator it = pkg.refAllClasses( ).iterator( ); it.hasNext( ); ) {
            RefClass classProxy = (RefClass) it.next( );
            for ( AttributeInternal attr : mmCache.getClassAttributes( session, (MofClassInternal) classProxy.refMetaObject( ) ) ) {
                if ( jmiHelper.getNonAliasType( session, (TypedElement) attr ) instanceof MofClassInternal ) {
                    writeObjectValuedAttribute( (CorePartitionable) classProxy, attr );
                } else {
                    writeValueInContent( attr, classProxy.refGetValue( attr ) );
                }
            }
        }
        visitedPackages.add( pkg );
        // Recursively descend for all nested and clustered packages.
        for ( Iterator it = pkg.refAllPackages( ).iterator( ); it.hasNext( ); ) {
            writeStaticAttributes( (RefPackage) it.next( ), visitedPackages );
        }
    }

    /**
     * Returns the fully qualified name of a model element. If a matching
     * namespace prefix is found in the {@link #namespaces} map, it is used.
     */
    private String qualifiedName( ModelElementInternal element ) {

        if ( element == null ) {
            return null;
        }
        String result = qualifiedNames.get( element );
        if ( result == null ) {
            String fqName = jmiHelper.getQualifiedName( session, (ModelElement) element );
            int index = fqName.lastIndexOf( '.' );
            String pName = fqName.substring( 0, index );
            String sName = fqName.substring( index + 1, fqName.length( ) );
            if ( !( element instanceof MofClass ) ) {
                index = pName.lastIndexOf( '.' );
                if ( index != -1 ) {
                    pName = pName.substring( 0, index );
                    sName = fqName.substring( index + 1, fqName.length( ) );
                }
            }
            // If a namespace prefix for the package exists, use it.
            String namespace = namespaces.get( pName );
            if ( namespace != null ) {
                result = namespace + ":" + sName; //$NON-NLS-1$
            } else {
                result = fqName;
            }
            qualifiedNames.put( element, result );
        }
        return result;
    }

    /**
     * Returns whether the given StructuralFeature is multi-valued or not.
     */
    private boolean isMultiValued( StructuralFeatureInternal feature ) {

        return mmCache.isMultiValued( feature );
    }

    /**
     * Given a link and a MOF reference, this method returns the MOIN reference
     * at the other end of the link.
     */
    private MoinReference getOtherLinkEnd( EndStorageLink link, ReferenceInternal reference ) {

        return link.getEnd( mmCache.getAssociationEndNumber( session, mmCache.getReferencedEnd( session, reference ) ) );
    }

    /**
     * Sanity check for the OutputStream
     */
    private void checkOutputStream( OutputStream os ) {

        if ( os == null ) {
            throw new MoinIllegalArgumentException( XMI.MOIN_XMI_1001 );
        }
    }

    /**
     * Sanity check for the Collection
     */
    private void checkCollection( Collection objects ) {

        if ( objects == null ) {
            throw new MoinIllegalArgumentException( XMI.MOIN_XMI_1005 );
        }
        for ( Iterator it = objects.iterator( ); it.hasNext( ); ) {
            Object obj = it.next( );
            if ( !( obj instanceof RefObject ) ) {
                throw new MoinIllegalArgumentException( XMI.MOIN_XMI_1009, obj );
            }
        }
    }

    /**
     * Sanity check for the package extent
     */
    private void checkExtent( RefPackage extent ) {

        if ( extent == null ) {
            throw new MoinIllegalNullArgumentException( "extent" ); //$NON-NLS-1$
        }
    }

    /**
     * Sanity check for the model partition
     */
    private void checkModelPartition( CoreModelPartition partition ) {

        if ( partition == null ) {
            throw new MoinIllegalNullArgumentException( "ModelPartition" ); //$NON-NLS-1$
        }
        if ( partition.getPri( ) == null ) {
            throw new MoinIllegalArgumentException( XMI.MOIN_XMI_1025 );
        }
        if ( partition.getWorkspace( ) == null ) {
            throw new MoinIllegalArgumentException( XMI.MOIN_XMI_1003, partition );
        }
    }

    /**
     * Returns whether we are currently in partition writing mode or not.
     */
    private boolean isWritingPartition( ) {

        return ( partitionToWrite != null );
    }

    /**
     * Returns whether there are still RefObject instances to write or not.
     */
    private boolean hasInstancesToWrite( ) {

        return ( instancesToWrite != null && !instancesToWrite.isEmpty( ) );
    }

    /**
     * Returns whether there are still RefObject instances to write or not,
     * which are values of classifier-level attributes.
     */
    private boolean hasInstancesToWriteAsStaticAttributes( ) {

        return ( instancesToWriteAsStaticAttribute != null && !instancesToWriteAsStaticAttribute.isEmpty( ) );
    }

    /**
     * Returns whether there are still links for which a reference exists in the
     * metamodel to write or not.
     */
    private boolean hasLinksWithReferenceToWrite( ) {

        return ( linksWithReferences != null && !linksWithReferences.isEmpty( ) );
    }

    /**
     * Returns whether there are still links for which a reference exists in the
     * metamodel and which can be serialized as XML attributes.
     */
    private boolean hasLinksToBeSerializedAsXmlAttributesToWrite( ) {

        return ( linksToBeSerializedAsXmlAttributes != null && !linksToBeSerializedAsXmlAttributes.isEmpty( ) );
    }

    /**
     * Returns whether there are still toplevel links to write or not.
     */
    private boolean hasToplevelLinksToWrite( ) {

        return ( linksWithoutReferences != null && !linksWithoutReferences.isEmpty( ) );
    }

    /**
     * Returns whether there are still SAP specific links to write or not.
     */
    private boolean hasSAPSpecificLinksToWrite( ) {

        return ( linksToBeStoredAsSAPExtension != null && !linksToBeStoredAsSAPExtension.isEmpty( ) );
    }

    /**
     * Returns whether we have some content at all. If not, the
     * <code>&lt;XMI.content&gt;</code> element should not be written to the
     * stream.
     */
    private boolean hasContentToWrite( ) {

        return hasInstancesToWrite( ) || hasInstancesToWriteAsStaticAttributes( ) || hasLinksToBeSerializedAsXmlAttributesToWrite( ) || hasLinksWithReferenceToWrite( ) || hasToplevelLinksToWrite( );
    }
}

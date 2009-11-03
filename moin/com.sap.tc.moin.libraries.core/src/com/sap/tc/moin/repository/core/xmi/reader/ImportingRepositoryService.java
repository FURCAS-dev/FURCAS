package com.sap.tc.moin.repository.core.xmi.reader;

import static com.sap.tc.moin.repository.shared.util.MoinSystemPropertyKeys.MOIN_IMPORT_OCL_CONSTRAINTS;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.Feature;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.model.Tag;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.AttributeInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ModelElementInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.MofClassInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.MofPackageInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.NamespaceInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.TagInternal;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.omg.ocl.attaching.OclConstraint;
import org.omg.ocl.attaching.__impl.OclConstraintInternal;
import org.omg.ocl.expressions.OclExpression;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.PartitionEditingNotPossibleException;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.MultiValuedAttributesList;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.WorkspaceSet;
import com.sap.tc.moin.repository.core.jmi.reflect.RefClassImpl;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.ocl.service.impl.OclServiceImpl;
import com.sap.tc.moin.repository.core.xmi.reader.parser.ParserResult;
import com.sap.tc.moin.repository.core.xmi.util.XmiHrefUtil;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.messages.core.XMI;
import com.sap.tc.moin.repository.ocl.exceptions.ParsingException;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.shared.util.QualifiedName;
import com.sap.tc.moin.repository.shared.util.StringUtils;
import com.sap.tc.moin.repository.spi.facility.SpiClientSpec;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;
import com.sap.tc.moin.repository.spi.facility.SpiLifecycleManagement;
import com.sap.tc.moin.repository.transactions.microtransactionables.LinkAddElementMicroTransactionable;
import com.sap.tc.moin.repository.xmi.DefaultImportService;
import com.sap.tc.moin.repository.xmi.ImportService;
import com.sap.tc.moin.repository.xmi.XmiElement;

/**
 * This implementation of the RepositoryService interface is used when XMI
 * documents are <em>imported</em> into the repository, as opposed to being
 * <em>loaded</em> (for the load scenario, see
 * {@link com.sap.tc.moin.repository.core.xmi.reader.LoadingRepositoryService}).
 * The important difference is that in the import scenario, model elements and
 * links are <b>created</b> using the corresponding class proxies and
 * association proxies, i.e. using normal JMI calls. As a consequence, normal
 * constraint verification takes place and change events are fired, both of
 * which are not the case in the load scenario.
 * <p>
 * Furthermore, this implementation provides functionality for performing
 * repetitive imports of metamodels and models, with the help of the currently
 * registered
 * {@link com.sap.tc.moin.repository.xmi.XmiReader#getImportService()
 * ImportService}.
 * <p>
 * Note that the {@link #rollbackChanges() rollback} in the case of an error
 * during the repository update performs a
 * {@link com.sap.tc.moin.repository.Connection#revert()} on the connection.
 * Thus, the import should always be run on an exclusive connection to prevent
 * loss of other model changes.
 */
public class ImportingRepositoryService implements RepositoryService {

    // logging
    private static MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_PARTITIONS, ImportingRepositoryService.class );

    private static final String QUALIFIED_NAME_MODEL_CONSTRAINS = "Model.Constrains"; //$NON-NLS-1$

    private static final String QUALIFIED_NAME_MODEL_ATTACHESTO = "Model.AttachesTo"; //$NON-NLS-1$

    private static final String QUALIFIED_NAME_MODEL_CONSTRAINT = "Model.Constraint"; //$NON-NLS-1$

    private static final String QUALIFIED_NAME_MODEL_CONTAINS = "Model.Contains"; //$NON-NLS-1$

    private static final String QUALIFIED_NAME_MODEL_ATTRIBUTE = "Model.Attribute"; //$NON-NLS-1$

    private static final String CONSTRAINT_LANGUAGE = "language"; //$NON-NLS-1$

    private static final String CONSTRAINT_LANGUAGE_OCL = "OCL"; //$NON-NLS-1$

    private static final String CONSTRAINT_LANGUAGE_OCLINIT = "OCLInit"; //$NON-NLS-1$

    private static final String OCL_QNAME_SEPARATOR = "::"; //$NON-NLS-1$

    private boolean isMofMode = false;

    private boolean importOclConstraints = true;

    /**
     * The workspace that the XmiReader is operating on.
     */
    private Workspace workspace;

    /**
     * The TypeHelper instance needed for example to retrieve class proxies or
     * association proxies.
     */
    private TypeHelper typeHelper;

    /**
     * The currently registered {@link ImportService}. It controls the complete
     * import flow.
     */
    private ImportService importService;

    /**
     * Maps the URI of each XMI document to an instance of {@link MappingInfo}.
     */
    private Map<String /* uri */, MappingInfo> mappingInfos;

    /**
     * Contains all model elements for which a correspondence was found in the
     * XMI document(s). This map is required for computing the difference
     * between the model elements of an existing partition and the model
     * elements found in the related XMI document, in order to determine the
     * collection of model elements that have to be deleted.
     */
    private Map<String /* uri */, Set<RefObject>> modelElementsWithXmiCounterpart;

    /**
     * Maps each {@link XmiElement} to the corresponding created/loaded/modified
     * RefObject.
     */
    private Map<XmiElement, RefObject> allInstances;

    /**
     * Contains for all InstanceInfo instances representing OCL constraints the
     * set of constrained model elements.
     */
    private Map<InstanceInfo, List<ModelElement>> oclConstraints;

    /**
     * The tags which correspond to body expressions
     */
    private final Set<Tag> bodyExpressions = new HashSet<Tag>( );

    /**
     * The tags which correspond to violation message expressions
     */
    private final Set<InstanceInfo> violationMessages = new HashSet<InstanceInfo>( );

    /**
     * The generated OCL constraints per link
     */
    private Map<InstanceInfo, OclConstraint> createdOclConstraints = new HashMap<InstanceInfo, OclConstraint>( );

    /**
     * The link infos where at least one end points to a constraint
     * <p>
     * These links are treated in a special way after creation of the OCL
     * constraints
     */
    private Set<LinkInfo> constraintLinks = new HashSet<LinkInfo>( );

    private int numLinks = 0;

    private CoreConnection connection;

    /**
     * Constructs a new {@link ImportingRepositoryService} instance.
     * 
     * @param connection
     * @param workspace
     * @param typeHelper
     * @param importService
     */
    public ImportingRepositoryService( CoreConnection connection, Workspace workspace, TypeHelper typeHelper, ImportService importService ) {

        this.connection = connection;
        this.workspace = workspace;
        this.typeHelper = typeHelper;
        this.importService = importService;
        this.allInstances = new LinkedHashMap<XmiElement, RefObject>( );
        this.modelElementsWithXmiCounterpart = new HashMap<String, Set<RefObject>>( );
        this.mappingInfos = new HashMap<String, MappingInfo>( );
        this.oclConstraints = new LinkedHashMap<InstanceInfo, List<ModelElement>>( );
        if ( importService instanceof DefaultImportService ) {
            this.isMofMode = ( (DefaultImportService) importService ).isMofMode( );
        }
        this.importOclConstraints = "true".equalsIgnoreCase( System.getProperty( MOIN_IMPORT_OCL_CONSTRAINTS, "true" ) ); //$NON-NLS-1$ //$NON-NLS-2$
    }

    /**
     * Perform all necessary updates based on what is contained in the given
     * {@link ParserResult}. The collection of composition roots found in the
     * XMI documents is returned.
     */
    public Collection<RefObject> updateRepository( ParserResult parserResult ) {

        // For each parsed XMI document that has a partition mapping, initialize
        // a MappingInfo instance.
        initializeMappingInfos( parserResult );
        // patch the parser result
        patchParserResult( parserResult );
        // Initialize the collection of composition roots. It will be returned
        // to the caller.
        Collection<RefObject> compositionRoots = new LinkedHashSet<RefObject>( );
        // Process all model elements from the ParserResult. This can
        // technically result in creation of new model
        // elements, or in loading / modification of existing model elements.
        // Note that instances of Model.Constraint
        // with language="OCL" are treated specially: they are converted to
        // instances of OCL.Attaching.OclConstraint.
        for ( InstanceInfo instanceInfo : parserResult.getModelElements( ) ) {
            if ( isOclConstraint( instanceInfo ) ) {
                // OCL constraints are handled later (see below). Do not create
                // a JMI object for them now.
                this.oclConstraints.put( instanceInfo, new ArrayList<ModelElement>( ) );
                // } else if (isViolationExpressionTag(instanceInfo)) {
                // this.violationMessages.add(instanceInfo);
            } else {
                RefObject refObj = handleInstance( instanceInfo );
                if ( instanceInfo.getParentElement( ) == null ) {
                    compositionRoots.add( refObj );
                }
                if ( isBodyExpressionTag( instanceInfo ) ) {
                    this.bodyExpressions.add( (Tag) refObj );
                }
            }
        }
        // Delete all model elements from the mapped model partitions which
        // existed on the previous import, but do not
        // exist any more in the current XMI documents.
        for ( MappingInfo mappingInfo : this.mappingInfos.values( ) ) {
            if ( mappingInfo.isSource( ) ) {
                // Compute the difference between the original collection of
                // model elements contained in the mapped
                // partition, and all loaded or created model elements. The
                // remaining model elements must be deleted
                // from the model partition, as they no longer exist in the
                // corresponding XMI document.
                Collection<RefObject> modelElements = mappingInfo.getModelElements( );
                modelElements.removeAll( this.modelElementsWithXmiCounterpart.get( mappingInfo.getUri( ) ) );
                for ( RefObject refObj : modelElements ) {
                    RefObjectImpl refObjInteral = (RefObjectImpl) refObj;
                    if ( refObjInteral.is___Alive( ) ) {
                        // The composite parent of 'refObj' might have been deleted earlier in this loop, so 'refObj' might not be alive any more.
                        refObjInteral.refDelete( connection );
                    }
                }
            }
        }
        // Process all links from the ParserResult.
        handleLinks( parserResult.getLinks( ) );
        // Set all static attributes from the ParserResult. Note that static
        // attribute values can only be contained in
        // serialized package extents. Whether and how in detail MOIN supports
        // static attributes is still unclear, so
        // the following codig might become obsolete.
        for ( AttributeInternal attribute : parserResult.getStaticAttributes( ).keySet( ) ) {
            setStaticAttributeValue( attribute, parserResult.getStaticAttributes( ).get( attribute ) );
        }
        // Now all model elements and links are in place for parsing and
        // attaching the OCL constraints.
        if ( !this.oclConstraints.isEmpty( ) || !this.bodyExpressions.isEmpty( ) || !this.violationMessages.isEmpty( ) ) {
            handleOclConstraints( );
        }

        // Finally, persist all mapping tables for "isSource=true" XMI
        // documents. This is only done if the ImportService
        // provides an OutputStream.
        for ( MappingInfo mappingInfo : this.mappingInfos.values( ) ) {
            if ( mappingInfo.isSource( ) ) {
                mappingInfo.storeMappingTable( );
            }
        }
        return compositionRoots;
    }

    private boolean isBodyExpressionTag( InstanceInfo instanceInfo ) {

        if ( this.isMofMode || !this.importOclConstraints ) {
            return false;
        }
        if ( this.mappingInfos.get( instanceInfo.getUri( ) ).isSource( ) ) {
            String qualifiedNameOfType = QualifiedName.toDotSeparatedString( ( (MofClassInternal) instanceInfo.getType( ) ).getQualifiedName( connection ) );
            if ( qualifiedNameOfType.equals( "Model.Tag" ) ) { //$NON-NLS-1$
                String tagId = (String) instanceInfo.getAttributeValuesByName( ).get( "tagId" ); //$NON-NLS-1$
                if ( tagId.equals( "org.omg.sap2mof.OperationCodeOcl" ) ) { //$NON-NLS-1$
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns whether the given InstanceInfo instance represents an instance of
     * Model.Constraint with language = "OCL".
     */
    private boolean isOclConstraint( InstanceInfo instanceInfo ) {

        // TODO system parameter
        if ( this.isMofMode || !this.importOclConstraints ) {
            return false;
        }
        if ( this.mappingInfos.get( instanceInfo.getUri( ) ).isSource( ) ) {
            String qualifiedNameOfType = QualifiedName.toDotSeparatedString( ( (MofClassInternal) instanceInfo.getType( ) ).getQualifiedName( connection ) );
            if ( qualifiedNameOfType.equals( QUALIFIED_NAME_MODEL_CONSTRAINT ) ) {
                String language = (String) instanceInfo.getAttributeValuesByName( ).get( CONSTRAINT_LANGUAGE );
                return language.equals( CONSTRAINT_LANGUAGE_OCL ) || language.equals( CONSTRAINT_LANGUAGE_OCLINIT );
            }
        }
        return false;
    }

    /**
     * Processes all OCL constraints from the {@link #oclConstraints} set and
     * calls the OCL parser to render the abstract syntax tree.
     */
    @SuppressWarnings( "unchecked" )
    private void handleOclConstraints( ) {

        // Initialize the two maps required by the OCL parser for type lookups.
        /**
         * Contains all model elements except for those representing OCL
         * constraints, keyed by their name. Since names do not have to be
         * unique across the whole metamodel, lists are used to store all model
         * elements with the same name.
         */
        int hardFailures = 0;
        List<String[]> errorMessages = new ArrayList<String[]>( );

        Map<String, List<ModelElement>> modelElementsByName = new HashMap<String, List<ModelElement>>( );
        /**
         * Contains all model elements except for those representing OCL
         * constraints, keyed by their qualified name in the OCL expression
         * notation, using '::' as delimiter (example: "Model::Package").
         */
        Map<String, ModelElement> modelElementsByOclQualifiedName = new HashMap<String, ModelElement>( );
        for ( RefObject refObj : this.allInstances.values( ) ) {
            if ( refObj == null ) {
                // TODO why?
                continue;
            }
            ModelElementInternal modelElement = (ModelElementInternal) refObj;
            String name = modelElement.getName( );
            List<ModelElement> elements = modelElementsByName.get( name );
            if ( elements == null ) {
                elements = new ArrayList<ModelElement>( );
                modelElementsByName.put( name, elements );
            }
            elements.add( (ModelElement) modelElement );
            StringBuilder oclQualifiedName = new StringBuilder( );
            for ( Iterator<String> it = modelElement.getQualifiedName( connection ).iterator( ); it.hasNext( ); ) {
                oclQualifiedName.append( it.next( ) );
                if ( it.hasNext( ) ) {
                    oclQualifiedName.append( OCL_QNAME_SEPARATOR );
                }
            }
            modelElementsByOclQualifiedName.put( oclQualifiedName.toString( ), (ModelElement) modelElement );
        }
        // Now let the OCL parser do the rest.
        // first we collect all the OclHelper stuff, as this must be parsed
        // before the
        // invariants (user defined operations and such)

        Set<InstanceInfo> failedConstraints = new HashSet<InstanceInfo>( );
        Map<Classifier, Set<Feature>> ocldefinedFeatures = new HashMap<Classifier, Set<Feature>>( );

        for ( Tag bodyExpressionTag : this.bodyExpressions ) {
            try {
                this.handleBodyExpression( bodyExpressionTag, modelElementsByName, modelElementsByOclQualifiedName, ocldefinedFeatures );

            } catch ( IllegalStateException e ) {
                hardFailures++;
                String expression = bodyExpressionTag.getValues( ).get( 0 );
                ParsingException pe = null;
                if (e.getCause() instanceof ParsingException) {
                    pe = (ParsingException) e.getCause();
                } else if (e.getCause() instanceof OclManagerException && e.getCause().getCause() instanceof ParsingException) {
                    pe = (ParsingException) e.getCause().getCause();
                }
                if ( pe != null) {
                    String message = "Parsing Exception while parsing bodyExpresion \'" + expression + "\'"; //$NON-NLS-1$//$NON-NLS-2$
                    String report = pe.getReport( ).toString( );
                    logger.trace( pe, MoinSeverity.ERROR, message, new Object[0] );
                    logger.trace( MoinSeverity.ERROR, report );
                    errorMessages.add( new String[] { "Body expression: " + expression, report } ); //$NON-NLS-1$
                } else {
                    String message = "Exception while parsing bodyExpresion \'" + expression + "\'"; //$NON-NLS-1$//$NON-NLS-2$
                    Throwable cause;
                    if ( e.getCause( ) != null ) {
                        cause = e.getCause( );
                    } else {
                        cause = e;
                    }
                    logger.trace( cause, MoinSeverity.ERROR, message, new Object[0] );
                    errorMessages.add( new String[] { "Body expression: " + expression, "Exception: " + e.getCause( ).getMessage( ) } ); //$NON-NLS-1$ //$NON-NLS-2$
                }
            }
        }

        for ( InstanceInfo oclConstraint : this.oclConstraints.keySet( ) ) {

            try {
                this.handleOclConstraint( oclConstraint, modelElementsByName, modelElementsByOclQualifiedName, ocldefinedFeatures );
            } catch ( IllegalStateException e ) {
                failedConstraints.add( oclConstraint );
            }
        }

        // second round

        for ( InstanceInfo oclConstraint : failedConstraints ) {
            try {
                this.handleOclConstraint( oclConstraint, modelElementsByName, modelElementsByOclQualifiedName, ocldefinedFeatures );
            } catch ( IllegalStateException e ) {
                hardFailures++;
                String constraint = (String) oclConstraint.getAttributeValuesByName( ).get( "name" ); //$NON-NLS-1$
                String expression = (String) oclConstraint.getAttributeValuesByName( ).get( "expression" ); //$NON-NLS-1$
                ParsingException pe = null;
                if (e.getCause() instanceof ParsingException) {
                    pe = (ParsingException) e.getCause();
                } else if (e.getCause() instanceof OclManagerException && e.getCause().getCause() instanceof ParsingException) {
                    pe = (ParsingException) e.getCause().getCause();
                }
                if ( pe != null) {
                    String message = "Parsing Exception while parsing constraint \'" + constraint + "\'"; //$NON-NLS-1$//$NON-NLS-2$
                    String report = pe.getReport( ).toString( );
                    logger.trace( pe, MoinSeverity.ERROR, message, new Object[0] );
                    logger.trace( MoinSeverity.ERROR, report );
                    errorMessages.add( new String[] { "Constraint " + constraint + ": " + expression, report } ); //$NON-NLS-1$ //$NON-NLS-2$
                } else {
                    String message = "Exception while parsing constraint \'" + constraint + "\'"; //$NON-NLS-1$//$NON-NLS-2$
                    Throwable cause;
                    if ( e.getCause( ) != null ) {
                        cause = e.getCause( );
                    } else {
                        cause = e;
                    }
                    logger.trace( cause, MoinSeverity.ERROR, message, new Object[0] );
                    errorMessages.add( new String[] { "Constraint " + constraint + ": " + expression, "Exception: " + e.getCause( ).getMessage( ) } ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                }
            }
        }

        // TODO the constrains link is not evalauted right now (probably because
        // the tag is not there yet)
        // establish the links (constrains and attachesTo)
        if ( !this.constraintLinks.isEmpty( ) ) {
            for ( LinkInfo link : this.constraintLinks ) {
                this.createLink( link, false );
            }
        }

        // parse and add the violation message expressions

        for ( RefObject obj : this.allInstances.values( ) ) {
            if ( obj instanceof TagInternal ) {
                TagInternal tag = (TagInternal) obj;
                if ( tag.getTagId( ).equals( "org.omg.sap2mof.violationMessageExpression" ) ) { //$NON-NLS-1$
                    JmiList elements = (JmiList) tag.getElements( connection );
                    Iterator elementsIterator = elements.iterator( connection );
                    for ( ; elementsIterator.hasNext( ); ) {
                        Object element = elementsIterator.next( );
                        if ( this.createdOclConstraints.containsValue( element ) ) {
                            OclConstraintInternal oc = (OclConstraintInternal) element;
                            // Rose supports only one tag value, so we use "//"
                            // as line sep
                            String tagValue = tag.getValues( connection ).iterator( ).next( );

                            String[] expressions = StringUtils.split( tagValue, "//" ); //$NON-NLS-1$

                            for ( int i = 0; i < expressions.length; i++ ) {
                                String expression = expressions[i];
                                NamespaceInternal container = (NamespaceInternal) ( (RefObjectImpl) oc ).refImmediateComposite( connection.getSession( ) );
                                ModelPartition targetPartition = null;
                                // get the target package
                                while ( targetPartition == null ) {
                                    RefFeatured parent = ( (RefObjectImpl) container ).refImmediateComposite( connection.getSession( ) );

                                    if ( parent == null ) {
                                        break;
                                    }
                                    if ( parent instanceof MofPackageInternal ) {
                                        targetPartition = ( (Partitionable) parent ).get___Partition( );
                                        break;
                                    }
                                    if ( parent instanceof RefObjectImpl ) {
                                        parent = ( (RefObjectImpl) parent ).refImmediateComposite( connection.getSession( ) );
                                    }
                                }
                                // TODO we should rather have the default context
                                RefObjectImpl context = (RefObjectImpl) ( (JmiList) oc.getConstrainedElements( connection ) ).iterator( connection ).next( );
                                try {
                                    OclExpression expr = OclServiceImpl.getInstance( ).parseViolationMessageExpression( connection, expression, context, modelElementsByName, modelElementsByOclQualifiedName, targetPartition );
                                    ( (JmiList) oc.getViolationMessageExpression( connection ) ).add( connection, expr );
                                } catch ( ParsingException e ) {
                                    hardFailures++;
                                    String message = "Parsing Exception while parsing violation message expression \'" + expression + "\'"; //$NON-NLS-1$//$NON-NLS-2$
                                    String report = e.getReport( ).toString( );
                                    logger.trace( e.getCause( ), MoinSeverity.ERROR, message, new Object[0] );
                                    logger.trace( MoinSeverity.ERROR, report );
                                    errorMessages.add( new String[] { "ViolationMessageExpression: " + expression, report } ); //$NON-NLS-1$

                                } catch ( OclManagerException e ) {
                                    hardFailures++;
                                    String message = "OclManager Exception while parsing violation message expression \'" + expression + "\'"; //$NON-NLS-1$//$NON-NLS-2$
                                    logger.trace( e, MoinSeverity.ERROR, message, new Object[0] );
                                    errorMessages.add( new String[] { "ViolationMessageExpression: " + expression, "Exception: " + e.getMessage( ) } ); //$NON-NLS-1$ //$NON-NLS-2$

                                }
                            }
                        }
                    }
                }
            }
        }

        if ( hardFailures > 0 ) {
            StringBuilder message = new StringBuilder( 100 );
            message.append( "" + hardFailures + " OCL constraints or Operation body expressions or ViolationMessageExpressions could not be parsed\n" ); //$NON-NLS-1$//$NON-NLS-2$
            int index = 1;

            for ( String[] errorStrings : errorMessages ) {
                message.append( "Error " + index + ": " ); //$NON-NLS-1$ //$NON-NLS-2$
                message.append( errorStrings[0] );
                message.append( " Problem: " );//$NON-NLS-1$
                message.append( errorStrings[1] );
                message.append( '\n' );
            }
            throw new IllegalStateException( message.toString( ) );
        }
    }

    private void handleBodyExpression( Tag bodyExpressionTag, Map<String, List<ModelElement>> modelElementsByName, Map<String, ModelElement> modelElementsByOclQualifiedName, Map<Classifier, Set<Feature>> ocldefinedFeatures ) throws IllegalStateException {

        try {
            OclServiceImpl.getInstance( ).parseBodyExpression( connection, bodyExpressionTag, modelElementsByName, modelElementsByOclQualifiedName, ocldefinedFeatures );
        } catch ( OclManagerException e ) {
            throw new IllegalStateException( e );
        }
    }

    @SuppressWarnings( "unchecked" )
    private void handleOclConstraint( InstanceInfo oclConstraint, Map<String, List<ModelElement>> modelElementsByName, Map<String, ModelElement> modelElementsByOclQualifiedName, Map<Classifier, Set<Feature>> ocldefinedFeatures ) throws IllegalStateException {

        Collection<ModelElement> constrainedElements = new ArrayList<ModelElement>( );

        for ( LinkInfo link : this.constraintLinks ) {
            String dotsepname = QualifiedName.toDotSeparatedString( link.getAssociation( ).getQualifiedName( connection ) );
            if ( !QUALIFIED_NAME_MODEL_CONSTRAINS.equals( dotsepname ) ) {
                continue;
            }
            if ( link.getFirstEnd( ) == oclConstraint ) {
                ModelElement modelElement = (ModelElement) this.allInstances.get( link.getSecondEnd( ) );
                if ( modelElement != null ) {
                    constrainedElements.add( modelElement );
                }
            }
        }

        Namespace container = (Namespace) this.allInstances.get( oclConstraint.getParentElement( ) );

        if ( constrainedElements.isEmpty( ) ) {
            // TODO log this? remove it?
            constrainedElements.add( container );
        }
        ModelPartition targetPartition = null;
        MofPackageInternal constraintPackage = null;
        RefFeatured parent = container;
        // get the target package
        while ( parent != null ) {

            if ( parent instanceof MofPackage ) {
                if ( constraintPackage == null ) {
                    constraintPackage = (MofPackageInternal) parent;
                }
                targetPartition = ( (Partitionable) parent ).get___Partition( );
                break;
            }
            if ( parent instanceof RefObject ) {
                parent = ( (RefObjectImpl) parent ).refImmediateComposite( connection.getSession( ) );
            }
        }

        if ( targetPartition == null ) {
            throw new MoinIllegalStateException( XMI.COULDNOTGETTARGETPARTITIONFOROCL );
        }

        OclConstraint constraint;

        try {
            constraint = OclServiceImpl.getInstance( ).parseExpressionAndAttachSyntaxTree( connection, oclConstraint, constraintPackage, constrainedElements, modelElementsByName, modelElementsByOclQualifiedName, targetPartition, ocldefinedFeatures, container );
        } catch ( OclManagerException e ) {
            throw new IllegalStateException( e );
        }

        // Store the InstanceInfo -> RefObject mapping in the allInstances map
        // (needed for link creation later on).
        this.allInstances.put( oclConstraint, constraint );
        ( (JmiList) ( (NamespaceInternal) container ).getContents( connection ) ).add( connection, constraint );
        this.createdOclConstraints.put( oclConstraint, constraint );
    }

    /**
     * This method converts classes that are tagged as structures into
     * structures and their attributes into structure fields.
     */
    private void patchParserResult( ParserResult parserResult ) {

        Set<InstanceInfo> classesConverted = new HashSet<InstanceInfo>( );
        Map<AssociationInternal, Set<LinkInfo>> parsedLinks = parserResult.getLinks( );
        // search for classes that are tagged as structures and convert them into structures
        for ( Entry<AssociationInternal, Set<LinkInfo>> linkEntry : parsedLinks.entrySet( ) ) {
            AssociationInternal association = linkEntry.getKey( );
            if ( QualifiedName.toDotSeparatedString( association.getQualifiedName( connection ) ).equals( QUALIFIED_NAME_MODEL_ATTACHESTO ) ) {
                for ( LinkInfo linkInfo : linkEntry.getValue( ) ) {
                    String tagId = (String) ( (InstanceInfo) linkInfo.getSecondEnd( ) ).getAttributeValuesByName( ).get( "tagId" ); //$NON-NLS-1$
                    if ( tagId.equals( "org.omg.sap2mof.isStructureType" ) ) { //$NON-NLS-1$
                        InstanceInfo classToConvert = (InstanceInfo) linkInfo.getFirstEnd( );
                        if ( classToConvert.getType( ).equals( connection.getClass( MofClass.CLASS_DESCRIPTOR ).refMetaObject( ) ) ) {
                            // make sure that we only convert classes that are tagged as structure
                            classToConvert.getAttributeValuesByName( ).remove( "isSingleton" ); //$NON-NLS-1$
                            classToConvert.getAttributeValues( ).remove( 6 );
                            classToConvert.setType( (MofClassInternal) connection.getClass( StructureType.CLASS_DESCRIPTOR ).refMetaObject( ) );
                            classesConverted.add( classToConvert );
                        }
                    }
                }
            }
        }
        // search for the attributes of the before converted classes and convert them into structure fields
        for ( Entry<AssociationInternal, Set<LinkInfo>> linkEntry : parsedLinks.entrySet( ) ) {
            AssociationInternal association = linkEntry.getKey( );
            if ( QualifiedName.toDotSeparatedString( association.getQualifiedName( connection ) ).equals( QUALIFIED_NAME_MODEL_CONTAINS ) ) {
                for ( LinkInfo linkInfo : linkEntry.getValue( ) ) {
                    if ( classesConverted.contains( linkInfo.getFirstEnd( ) ) ) {
                        InstanceInfo containedElement = (InstanceInfo) linkInfo.getSecondEnd( );
                        if ( QualifiedName.toDotSeparatedString( ( (MofClassInternal) containedElement.getType( ) ).getQualifiedName( connection ) ).equals( QUALIFIED_NAME_MODEL_ATTRIBUTE ) ) {
                            InstanceInfo attributeToConvert = containedElement;
                            attributeToConvert.getAttributeValuesByName( ).remove( "isDerived" ); //$NON-NLS-1$
                            attributeToConvert.getAttributeValuesByName( ).remove( "isChangeable" ); //$NON-NLS-1$
                            attributeToConvert.getAttributeValuesByName( ).remove( "multiplicity" ); //$NON-NLS-1$
                            attributeToConvert.getAttributeValuesByName( ).remove( "visibility" ); //$NON-NLS-1$
                            attributeToConvert.getAttributeValuesByName( ).remove( "scope" ); //$NON-NLS-1$
                            attributeToConvert.getAttributeValues( ).remove( 6 ); // remove in reverse order
                            attributeToConvert.getAttributeValues( ).remove( 5 );
                            attributeToConvert.getAttributeValues( ).remove( 4 );
                            attributeToConvert.getAttributeValues( ).remove( 3 );
                            attributeToConvert.getAttributeValues( ).remove( 2 );
                            attributeToConvert.setType( (MofClassInternal) connection.getClass( StructureField.CLASS_DESCRIPTOR ).refMetaObject( ) );
                        }
                    }
                }
            }
        }
    }

    /**
     * Performs a rollback of all repository modifications made by this
     * RepositoryService instance since its construction. To enable this,
     * concrete implementations need to keep track of all their modifications.
     */
    public void rollbackChanges( ) {

        // Reverts *all* changes of the current connection.
        if ( connection != null ) {
            connection.revert( );
        }
    }

    /**
     * Returns the currently registered {@link ImportService}.
     */
    private ImportService getImportService( ) {

        return this.importService;
    }

    /**
     * Instantiates and populates instances of {@link MappingInfo} for each XMI
     * document found in the {@link ParserResult}. The currently registered
     * {@link ImportService} is queried for all relevant mapping information.
     */
    private void initializeMappingInfos( ParserResult parserResult ) {

        // Create a MappingInfo instance for each XMI document that provides a
        // partition mapping.
        for ( String uri : parserResult.getParsedDocuments( ) ) {
            if ( this.importService.getMappedPartition( uri ) != null ) {
                this.mappingInfos.put( uri, new MappingInfo( this.workspace, uri, this.importService, connection ) );
                // Also initialize an entry in the
                // modelElementsWithXmiCounterpart map.
                this.modelElementsWithXmiCounterpart.put( uri, new LinkedHashSet<RefObject>( ) );
            }
        }
        // For each model element from the ParserResult, ask the ImportService
        // for the mapping id and store this info
        // inside the MappingInfo instance.
        for ( InstanceInfo instanceInfo : parserResult.getModelElements( ) ) {
            String uri = instanceInfo.getUri( );
            MappingInfo mappingInfo = getMappingInfo( uri );
            if ( mappingInfo != null ) {
                mappingInfo.addMappingId( instanceInfo, this.importService.getMappingId( uri, instanceInfo ) );
            }
        }
    }

    /**
     * Takes the given InstanceInfo and returns the corresponding model element,
     * which is either created, loaded or merged (actually, it is not a merge
     * but an "overwrite keeping the MOF-ID").
     */
    private RefObject handleInstance( InstanceInfo instanceInfo ) {

        RefObject result = null;
        // Get the MappingInfo instance of the element's XMI document.
        String uri = instanceInfo.getUri( );
        MappingInfo mappingInfo = getMappingInfo( uri );
        if ( mappingInfo == null ) {
            // No partition mapping was provided to the XmiReader. Therefore/ simply create a new model element; 
            // it will go into the connection's transient partition.
            result = createModelElement( instanceInfo, null /* mappingInfo */);
        } else {
            // We have a partition mapping.
            if ( !mappingInfo.isSource( ) ) {
                // The mapped partition is "passive", and must already have been loaded successfully in the
                // corresponding MappingInfo constructor. Provided that the XMI document is not outdated, 
                // the mapped model element must exist in the partition (otherwise: error!).
                result = mappingInfo.getMappedModelElement( instanceInfo );
                if ( result != null ) {
                    this.modelElementsWithXmiCounterpart.get( uri ).add( result );
                } else {
                    // 'result == null' can be the case for instances of Model.Constraint, because the
                    // getMappedModelElement() method call above checks the types of the matching elements. Since
                    // Model.Constraint instances get converted to instances of OCL.Attaching.OclConstraint,
                    // this type check will always fail (provided that this conversion was performed successfully).
                    // Because this is not an error situation, and because we need to return something to satisfy the 
                    // algorithm, we return the OCL.Attaching.OclConstraint instance that was created from the 
                    // Model.Constraint instance during the previous import, and that has the same qualified name.
                    //
                    // For all instances except for Model.Constraint, however, we need to throw an exception, since 
                    // this indicates a real inconsistency (most likely outdated XMI files).
                    if ( QualifiedName.toDotSeparatedString( ( (MofClassInternal) instanceInfo.getType( ) ).getQualifiedName( connection ) ).equals( QUALIFIED_NAME_MODEL_CONSTRAINT ) ) {
                        result = mappingInfo.getMappedOclConstraint( instanceInfo );
                    } else {
                        throw new RepositoryUpdateException( XMI.MOIN_XMI_1063, new Object[] { mappingInfo.getPri( ), mappingInfo.getMappingId( instanceInfo ), uri } );
                    }
                }
            } else {
                // The mapped partition is "active". Possible actions are to create a new model element, or to 
                // overwrite an existing model element from the mapped partition, keeping its MOF-ID.
                result = mappingInfo.getMappedModelElement( instanceInfo );
                if ( result == null ) {
                    result = createModelElement( instanceInfo, mappingInfo );
                } else {
                    updateModelElement( instanceInfo, (RefObjectImpl) result );
                    this.modelElementsWithXmiCounterpart.get( uri ).add( result );
                }
            }
        }
        // Store the InstanceInfo -> RefObject mapping in the allInstances map (needed for link creation later on).
        this.allInstances.put( instanceInfo, result );
        return result;
    }

    /**
     * Creates a new model element. If this method is called, it is guaranteed
     * that the model element does not exist yet.
     */
    private RefObject createModelElement( InstanceInfo instanceInfo, MappingInfo mappingInfo ) {

        RefObject result = null;
        result = createInstance( (MofClassInternal) instanceInfo.getType( ), instanceInfo.getAttributeValuesByName( ), mappingInfo );
        if ( mappingInfo != null ) {
            // Finally, write a new mapping table entry for the freshly created model element.
            mappingInfo.addToMappingTable( instanceInfo, result );
        }
        return result;
    }

    /**
     * Returns the {@link MappingInfo} instance for the XMI document with the
     * given URI.
     */
    private MappingInfo getMappingInfo( String uri ) {

        return this.mappingInfos.get( uri );
    }

    /**
     * Creates a new model element using its class proxy.
     * 
     * @param mappingInfo
     */
    private RefObject createInstance( MofClassInternal mofClass, Map<String, Object> attributeValuesByName, MappingInfo mappingInfo ) {

        // First, check the list of attribute values for instances of InstanceInfo (happens in case of object-valued
        // attributes), and replace them with the (already created) RefObject from the allInstances map.
        for ( Entry<String, Object> attributeValueByName : attributeValuesByName.entrySet( ) ) {
            Object attributeValue = attributeValueByName.getValue( );
            attributeValueByName.setValue( resolveInstanceInfo( attributeValue ) );
        }
        RefClassImpl refClass = (RefClassImpl) this.typeHelper.getProxy( mofClass );
        RefObjectImpl refObj = null;
        try {
            if ( mappingInfo != null ) {
                refObj = (RefObjectImpl) refClass.refCreateInstanceInPartition( connection, null, mappingInfo.getPartition( ) );
            } else {
                refObj = (RefObjectImpl) refClass.refCreateInstance( connection, null );
            }
            for ( Entry<String, Object> attributeValueByName : attributeValuesByName.entrySet( ) ) {
                String attributeName = attributeValueByName.getKey( );
                Object attributeValue = attributeValueByName.getValue( );
                if ( attributeValue instanceof Collection ) {
                    // multi-valued attribute
                    Collection<Object> oldValue = (Collection<Object>) refObj.refGetValue( connection, attributeName );
                    if ( oldValue instanceof JmiList ) {
                        // object-valued attribute
                        ( (JmiList<Object>) oldValue ).clear( connection );
                        ( (JmiList<Object>) oldValue ).addAll( connection, (Collection<Object>) attributeValue );
                    } else if ( oldValue instanceof MultiValuedAttributesList ) {
                        // primitive-valued attribute
                        ( (MultiValuedAttributesList<Object>) oldValue ).clear( connection );
                        ( (MultiValuedAttributesList<Object>) oldValue ).addAll( connection, (Collection<Object>) attributeValue );
                    } else {
                        // should not happen, attribute type is either object-valued of primitive-valued
                    }
                } else {
                    // single-valued attribute
                    refObj.refSetValue( connection, attributeName, attributeValue );
                }
            }
        } catch ( Exception ex ) {
            throw new RepositoryUpdateException( XMI.MOIN_XMI_1060, ex );
        }
        return refObj;
    }

    /**
     * Resolves an attribute value of type {@link InstanceInfo} or
     * <code>List&lt;InstanceInfo&gt;</code> into a RefObject or a list of
     * RefObject instances.
     */
    private Object resolveInstanceInfo( Object value ) {

        if ( value instanceof InstanceInfo ) {
            return this.allInstances.get( value );
        } else if ( value instanceof List ) {
            List<Object> newValue = new ArrayList<Object>( );
            for ( Iterator valueIt = ( (List) value ).iterator( ); valueIt.hasNext( ); ) {
                Object listValue = valueIt.next( );
                newValue.add( resolveInstanceInfo( listValue ) );
            }
            return newValue;
        } else {
            return value;
        }
    }

    /**
     * This method first deletes all links of all loaded (i.e. previously
     * existing) source partitions (i.e. partitions whose corresponding XMI
     * document has <code>isSource==true</code>). Afterwards, all links found in
     * the XMI document(s) are created.
     */
    private void handleLinks( Map<AssociationInternal, Set<LinkInfo>> linksFromXmi ) {

        Set<CoreModelPartition> loadedSourcePartitions = new HashSet<CoreModelPartition>( );
        for ( MappingInfo mappingInfo : this.mappingInfos.values( ) ) {
            if ( mappingInfo.isSource( ) && !mappingInfo.isPartitionCreated( ) ) {
                loadedSourcePartitions.add( mappingInfo.getPartition( ) );
            }
        }

        for ( CoreModelPartition partition : loadedSourcePartitions ) {
            partition.getWorkspace( ).getMemoryLinkManager( ).evictLinksStoredInPartition( partition );
        }

        for ( Entry<AssociationInternal, Set<LinkInfo>> entry : linksFromXmi.entrySet( ) ) {
            // insertionIndex per Assocation
            AssociationInternal association = entry.getKey( );
            String dotsepname = QualifiedName.toDotSeparatedString( association.getQualifiedName( connection ) );
            if ( dotsepname.equals( QUALIFIED_NAME_MODEL_CONSTRAINS ) || dotsepname.equals( QUALIFIED_NAME_MODEL_ATTACHESTO ) ) {
                handleLinksOfConstrainsAssociation( entry.getValue( ) );
            } else {
                for ( LinkInfo link : entry.getValue( ) ) {
                    createLink( link, true );
                }
            }
        }
    }

    private void handleLinksOfConstrainsAssociation( Set<LinkInfo> constrainsLinks ) {

        // insertionIndex per Assocation
        for ( LinkInfo linkInfo : constrainsLinks ) {
            InstanceInfo first = (InstanceInfo) linkInfo.getFirstEnd( );
            InstanceInfo second = (InstanceInfo) linkInfo.getSecondEnd( );
            if ( !this.oclConstraints.containsKey( first ) && !this.oclConstraints.containsKey( second ) ) {
                createLink( linkInfo, true );
            } else {
                if ( this.oclConstraints.containsKey( first ) ) {
                    this.constraintLinks.add( linkInfo );
                    // ModelElement constrainedElement = (ModelElement)
                    // allInstances.get(second);
                    // if (constrainedElement != null) {
                    // oclConstraints.get(first).add(constrainedElement);
                    // } else {
                    // throw new RepositoryUpdateException(XMI.MOIN_XMI_1022,
                    // new Object[] {
                    // first.getAttributeValuesByName().get("name"),
                    // second.getAttributeValuesByName().get("name") });
                    // }
                }
            }
        }
    }

    /**
     * Creates an {@link LRI} from the given <code>href</code> value.
     */
    private LRI getLri( String href ) {

        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, "ImportingRepositoryService.getLri(): href " + href ); //$NON-NLS-1$
        }

        LRI lri = null;
        try {
            String id = XmiHrefUtil.getIdPart( href, false /* partitionMode */);
            String hrefPartition = XmiHrefUtil.getLocationPart( href );

            // TODO temporary solution until we get the new reference targets
            // hrefPartition =
            // MoinImpl.getMoinInstance().addDataArea(hrefPartition);
            PRI pri = connection.getSession( ).getMoin( ).createPri( hrefPartition );
            lri = pri.createMri( id ).getLri( );
        } catch ( Exception ex ) {
            throw new XmiParseException( XMI.LRIRESOLVEFAILED, ex );
        } finally {
            if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                logger.trace( MoinSeverity.DEBUG, "ImportingRepositoryService.getLri(): LRI " + lri ); //$NON-NLS-1$
            }
        }
        return lri;
    }

    /**
     * Creates a link from the given {@link LinkInfo} instance.
     */
    private void createLink( LinkInfo linkInfo, boolean collectOclConstraintLinks ) {

        CorePartitionable ends[] = new CorePartitionable[2];

        try {
            InstanceInfo first = (InstanceInfo) linkInfo.getFirstEnd( );
            InstanceInfo second = (InstanceInfo) linkInfo.getSecondEnd( );
            // either side is an OCL Constraint and we want to collect these
            // links
            boolean linkToOrFromOclConstraint = false;
            linkToOrFromOclConstraint = this.oclConstraints.containsKey( first ) || this.oclConstraints.containsKey( second );

            if ( linkToOrFromOclConstraint && collectOclConstraintLinks ) {
                this.constraintLinks.add( linkInfo );
                return;
            }

            if ( !collectOclConstraintLinks && this.oclConstraints.containsKey( first ) && this.createdOclConstraints.containsKey( first ) ) {
                ends[0] = (CorePartitionable) this.createdOclConstraints.get( linkInfo.getFirstEnd( ) );
            } else if ( !this.allInstances.containsKey( first ) && first.getMofId( ) != null ) {
                LRI lri = getLri( first.getMofId( ) );
                ends[0] = this.workspace.getWorkspaceSet( ).resolveLri( connection.getSession( ), lri );
            } else {
                ends[0] = ( (CorePartitionable) this.allInstances.get( linkInfo.getFirstEnd( ) ) );
            }

            if ( !collectOclConstraintLinks && this.oclConstraints.containsKey( second ) && this.createdOclConstraints.containsKey( second ) ) {
                ends[1] = (CorePartitionable) this.createdOclConstraints.get( linkInfo.getSecondEnd( ) );
            } else if ( !this.allInstances.containsKey( second ) && second.getMofId( ) != null ) {
                LRI lri = getLri( second.getMofId( ) );
                ends[1] = this.workspace.getWorkspaceSet( ).resolveLri( connection.getSession( ), lri );
            } else {
                ends[1] = ( (CorePartitionable) this.allInstances.get( linkInfo.getSecondEnd( ) ) );
            }
            if ( ends[0] == null ) {
                logger.trace( MoinSeverity.ERROR, "Link could not be created because end0 is null" ); //$NON-NLS-1$
                return;
            }
            if ( ends[1] == null ) {
                logger.trace( MoinSeverity.ERROR, "Link could not be created because end1 is null" ); //$NON-NLS-1$
                return;
            }
            // TODO trace ends being null?
            if ( getImportService( ).isSource( first.getUri( ) ) || getImportService( ).isSource( second.getUri( ) ) ) {
                WorkspaceSet workspaceSet = this.workspace.getWorkspaceSet( );
                LinkAddElementMicroTransactionable mtx = workspaceSet.getMoin( ).getMicroTransactionableFactory( ).createLinkAddElementMicroTransactionable( connection, (Association) linkInfo.getAssociation( ), (RefObject) ends[0], ends[1] );
                connection.getSession( ).getTransactionManager( ).runInMicroTransaction( mtx );
                this.numLinks++;
            } else {
                // trace this: link skipped?
            }

        } catch ( Exception ex ) {
            throw new RepositoryUpdateException( XMI.MOIN_XMI_1054, new Object[] { QualifiedName.toDotSeparatedString( linkInfo.getAssociation( ).getQualifiedName( connection ) ), ends[0], ends[1] }, ex );
        }

    }

    /**
     * Updates the attribute values of the given RefObject with the values found
     * in the given InstanceInfo. Note that no check is performed whether an
     * attribute value has actually changed.
     */
    @SuppressWarnings( "unchecked" )
    private void updateModelElement( InstanceInfo instanceInfo, RefObjectImpl refObj ) {

        Map<String, Object> attrs = instanceInfo.getAttributeValuesByName( );
        for ( Entry<String, Object> entry : attrs.entrySet( ) ) {
            Object value = entry.getValue( );
            if ( value instanceof Collection ) {
                // Passing a collection to refSetValue() is not allowed. We have
                // to retrieve the
                // attribute's collection and add the entries manually.
                Collection values = (Collection) refObj.refGetValue( connection, entry.getKey( ) );
                assert values != null : "refGetValue() on a multi-valued attribute unexpectedly returned 'null'"; //$NON-NLS-1$
                if ( values instanceof MultiValuedAttributesList ) {
                    ( (MultiValuedAttributesList) values ).clear( connection );
                    ( (MultiValuedAttributesList) values ).addAll( connection, (Collection) entry.getValue( ) );
                } else {
                    values.clear( );
                    values.addAll( (Collection) entry.getValue( ) );
                }
            } else {
                refObj.refSetValue( connection, entry.getKey( ), entry.getValue( ) );
            }
        }
    }

    /**
     * Sets the value of a classifier-level attribute.
     */
    private void setStaticAttributeValue( AttributeInternal attr, Object value ) {

        RefClass proxy = (RefClass) this.typeHelper.getProxy( (MofClassInternal) attr.refImmediateComposite( ) );
        proxy.refSetValue( attr, value );
    }

    /**
     * Inner class encapsulating all mapping-relevant information about one XMI
     * document.
     */
    private static final class MappingInfo {

        /**
         * The URI of the XMI document related to this MappingInfo instance.
         */
        private final String uri;

        /**
         * The currently registered {@link ImportService}.
         */
        private final ImportService importService;

        /**
         * The PRI of the mapped model partition.
         */
        private final PRI pri;

        /**
         * Whether this XMI document is "active" or "passive" for this import.
         */
        private boolean isSource;

        /**
         * Maps each {@link XmiElement} found in the XMI document(s) to some ID,
         * which has to be provided by the ImportService and needs to be unique
         * among all XmiElements and stable across imports.
         */
        private final Map<XmiElement, String /* mappingId */> mappingIds = new HashMap<XmiElement, String>( );

        private Properties mappingTable;

        private CoreModelPartition partition;

        /**
         * Whether the mapped partition was created in the
         * {@link #MappingInfo(Workspace, String, ImportService) constructor} or
         * not.
         */
        private boolean isPartitionCreated;

        /**
         * Contains all model elements of the mapped partition, keyed by the ID
         * provided by the {@link ImportService} via
         * {@link ImportService#getMappingId(RefObject)}.
         */
        private Map<String /* mappingId */, RefObject> modelElements;

        private CoreConnection connection;

        /**
         * @param workspace
         * @param uri
         * @param importService
         */
        public MappingInfo( Workspace workspace, String uri, ImportService importService, CoreConnection connection ) {

            this.uri = uri;
            this.importService = importService;
            this.pri = importService.getMappedPartition( uri );
            this.isSource = importService.isSource( uri );
            this.connection = connection;
            if ( this.pri != null ) {
                this.modelElements = new LinkedHashMap<String, RefObject>( );
                this.isPartitionCreated = false;
                if ( !this.isSource ) {
                    // The mapped partition is "passive" (i.e. non-modifiable) and has to exist in the repository as a 
                    // prerequisite => try to load it.
                    if ( !loadAndIndexModelPartition( workspace ) ) {
                        throw new RepositoryUpdateException( XMI.MOIN_XMI_1057, new Object[] { this.pri } );
                    }
                } else {
                    // The mapped partition is "active". If it already exists (because of a previous import), load it 
                    // and make sure it is writable. Otherwise create it.
                    if ( !loadAndIndexModelPartition( workspace ) ) {
                        // The partition does not exist, i.e. this is the initial import. Create the model partition.
                        try {
                            this.partition = workspace.getPartitionFactory( ).createModelPartition( connection, this.pri );
                        } catch ( Exception ex ) {
                            throw new RepositoryUpdateException( XMI.MOIN_XMI_1055, new Object[] { this.pri }, ex );
                        }
                        this.isPartitionCreated = true;
                    } else {
                        // The partition was loaded successfully from the persistence. Now make sure it is writable.
                        SpiLifecycleManagement lifeCycleManagement = ( (SpiFacility) ( connection.getSession( ).getMoin( ).getFacilityById( this.pri.getDataAreaDescriptor( ).getFacilityId( ) ) ) ).getLifecycleManagement( );
                        SpiClientSpec clientSpec = (SpiClientSpec) connection.getSession( ).getCompoundClientSpec( ).getClientSpec( this.pri.getDataAreaDescriptor( ) );

                        try {
                            lifeCycleManagement.ensureEditingAllowed( getPri( ), clientSpec );
                        } catch ( PartitionEditingNotPossibleException e ) {
                            throw new RepositoryUpdateException( XMI.MOIN_XMI_1056, new Object[] { this.pri }, e );
                        }
                    }
                }
                // Ask the ImportService for an InputStream to a mapping
                // table. Note that a mapping table is not required, so 'null'
                // is a valid return value. If a non-null value is returned,
                // load the mapping table.
                InputStream mappingTableIn = importService.createInputStreamForMappingTable( uri );
                if ( mappingTableIn != null ) {
                    loadMappingTable( mappingTableIn );
                }
            }
        }

        /**
         * @return the pri
         */
        public PRI getPri( ) {

            return this.pri;
        }

        /**
         * @return the uri
         */
        public String getUri( ) {

            return this.uri;
        }

        /**
         * @return isSource
         */
        public boolean isSource( ) {

            return this.isSource;
        }

        /**
         * @return isPartitionCreated
         */
        public boolean isPartitionCreated( ) {

            return this.isPartitionCreated;
        }

        /**
         * @return the partition
         */
        public CoreModelPartition getPartition( ) {

            return this.partition;
        }

        /**
         * Add the mapping id
         * 
         * @param element
         * @param id
         */
        public void addMappingId( XmiElement element, String id ) {

            this.mappingIds.put( element, id );
        }

        /**
         * Get the mapping id
         * 
         * @param element
         * @return the id
         */
        public String getMappingId( XmiElement element ) {

            return this.mappingIds.get( element );
        }

        /**
         * Tries to load the mapping table from the given InputStream.
         */
        private void loadMappingTable( InputStream streamForMappingTable ) {

            try {
                if ( !this.isPartitionCreated ) {
                    // The partition was loaded and an InputStream was
                    // provided => load the mapping table.
                    this.mappingTable = new Properties( );
                    this.mappingTable.load( streamForMappingTable );
                } else {
                    // The partition was created and an InputStream was
                    // provided => inconsistency, ignore the stream and
                    // directly close it again.
                    this.mappingTable = null;
                    streamForMappingTable.close( );
                }
            } catch ( IOException ex ) {
                throw new RepositoryUpdateException( XMI.MOIN_XMI_1059, new Object[] { this.pri }, ex );
            }
        }

        /**
         * Adds a new entry to the mapping table, mapping the given XmiElement
         * to the given RefObject. This is only done if a mapping table exists.
         * 
         * @param xmiElement
         * @param result
         */
        public void addToMappingTable( XmiElement xmiElement, RefObject result ) {

            if ( this.mappingTable != null ) {
                this.mappingTable.put( this.mappingIds.get( xmiElement ), this.importService.getMappingId( result ) );
            }
        }

        /**
         * Stores the mapping table. This is only done if a non-empty mapping
         * table exists, and the {@link ImportService} provides a non-null
         * OutputStream.
         */
        public void storeMappingTable( ) {

            if ( this.mappingTable != null && !this.mappingTable.isEmpty( ) ) {
                OutputStream stream = this.importService.createOutputStreamForMappingTable( this.uri );
                if ( stream != null ) {
                    try {
                        this.mappingTable.store( stream, null /* comments */);
                        stream.close( );
                    } catch ( IOException ex ) {
                        throw new RepositoryUpdateException( XMI.MOIN_XMI_1058, new Object[] { this.pri }, ex );
                    }
                }
            }
        }

        /**
         * Tries to find the model element inside the mapped partition that
         * corresponds to the given XMI element.
         * 
         * @param element
         * @return the object
         */
        public RefObject getMappedModelElement( InstanceInfo element ) {

            String idOfXmiElement = this.mappingIds.get( element );
            String idOfModelElement = idOfXmiElement;
            if ( this.mappingTable != null ) {
                idOfModelElement = (String) this.mappingTable.get( idOfXmiElement );
            }
            // Lookup the corresponding model element from the partition and check its type.
            RefObject result = this.modelElements.get( idOfModelElement );
            if ( result != null ) {
                if ( result.refMetaObject( ).refMofId( ).equals( element.getType( ).refMofId( ) ) ) {
                    // compare the MOF ID of the meta objects
                    return result;
                }
            }
            return null;
        }

        /**
         * Returns for the given Model.Constraint-InstanceInfo the corresponding
         * OclConstraint from a previous import.
         */
        public RefObject getMappedOclConstraint( InstanceInfo element ) {

            String idOfModelElement = this.mappingIds.get( element );
            // Lookup the corresponding model element from the partition and check its type.
            return this.modelElements.get( idOfModelElement );
        }

        /**
         * Returns the collection of model elements in the mapped
         * {@link #partition}.
         * 
         * @return the model elements
         */
        public Collection<RefObject> getModelElements( ) {

            return this.modelElements.values( );
        }

        /**
         * Tries to load the model partition with the MRI {@link #pri} into the
         * given workspace, and, if loading was successful, caches the
         * partition's model elements and links. Returns whether the loading was
         * successful or not.
         */
        private boolean loadAndIndexModelPartition( Workspace workspace ) {

            try {
                this.partition = workspace.getWorkspaceSet( ).resolvePri( connection.getSession( ), this.pri );
                // check if partition has been found, if not return false ...
                if ( this.partition == null ) {
                    return false;
                }
                // ... otherwise index all model elements in the partition.
                if ( this.isSource ) {
                    // Create private copy for all source partitions.
                    this.partition = connection.getSession( ).createPrivateCopyOfPartition( partition.getPri( ) );
                }
                for ( Partitionable partitionable : this.partition.getElements( ) ) {
                    RefObject refObj = (RefObject) partitionable;
                    this.modelElements.put( this.importService.getMappingId( refObj ), refObj );
                }
            } catch ( Exception ex ) {
                // Wrap all other exceptions in a RepositoryUpdateException.
                throw new RepositoryUpdateException( XMI.MOIN_XMI_1057, new Object[] { this.pri }, ex );
            }
            return true;
        }
    }
}

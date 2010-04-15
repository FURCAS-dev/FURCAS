package com.sap.tc.moin.ocl.utils.jmi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.Map.Entry;

import org.omg.ocl.__impl.OclPackageImpl;
import org.omg.ocl.attaching.OclConstraint;
import org.omg.ocl.attaching.OperationBodyDefinition;
import org.omg.ocl.attaching.PostconditionConstraint;
import org.omg.ocl.attaching.PreconditionConstraint;
import org.omg.ocl.attaching.__impl.AttachingPackageImpl;
import org.omg.ocl.attaching.__impl.OclConstraintImpl;
import org.omg.ocl.attaching.__impl.OperationBodyDefinitionImpl;
import org.omg.ocl.expressions.AssociationEndCallExp;
import org.omg.ocl.expressions.AttributeCallExp;
import org.omg.ocl.expressions.BooleanLiteralExp;
import org.omg.ocl.expressions.CollectionItem;
import org.omg.ocl.expressions.CollectionKindEnum;
import org.omg.ocl.expressions.CollectionLiteralExp;
import org.omg.ocl.expressions.CollectionLiteralPart;
import org.omg.ocl.expressions.CollectionRange;
import org.omg.ocl.expressions.EnumLiteralExp;
import org.omg.ocl.expressions.IfExp;
import org.omg.ocl.expressions.IntegerLiteralExp;
import org.omg.ocl.expressions.IterateExp;
import org.omg.ocl.expressions.IteratorExp;
import org.omg.ocl.expressions.LetExp;
import org.omg.ocl.expressions.OclExpression;
import org.omg.ocl.expressions.OperationCallExp;
import org.omg.ocl.expressions.RealLiteralExp;
import org.omg.ocl.expressions.StringLiteralExp;
import org.omg.ocl.expressions.TupleLiteralExp;
import org.omg.ocl.expressions.TypeExp;
import org.omg.ocl.expressions.VariableDeclaration;
import org.omg.ocl.expressions.VariableExp;
import org.omg.ocl.expressions.__impl.AssociationEndCallExpImpl;
import org.omg.ocl.expressions.__impl.AttributeCallExpImpl;
import org.omg.ocl.expressions.__impl.BooleanLiteralExpImpl;
import org.omg.ocl.expressions.__impl.CollectionItemImpl;
import org.omg.ocl.expressions.__impl.CollectionLiteralExpImpl;
import org.omg.ocl.expressions.__impl.CollectionRangeImpl;
import org.omg.ocl.expressions.__impl.EnumLiteralExpImpl;
import org.omg.ocl.expressions.__impl.ExpressionsPackageImpl;
import org.omg.ocl.expressions.__impl.IfExpImpl;
import org.omg.ocl.expressions.__impl.IntegerLiteralExpImpl;
import org.omg.ocl.expressions.__impl.IterateExpImpl;
import org.omg.ocl.expressions.__impl.IteratorExpImpl;
import org.omg.ocl.expressions.__impl.LetExpImpl;
import org.omg.ocl.expressions.__impl.LetExpInternal;
import org.omg.ocl.expressions.__impl.OclExpressionInternal;
import org.omg.ocl.expressions.__impl.OperationCallExpImpl;
import org.omg.ocl.expressions.__impl.RealLiteralExpImpl;
import org.omg.ocl.expressions.__impl.StringLiteralExpImpl;
import org.omg.ocl.expressions.__impl.TupleLiteralExpImpl;
import org.omg.ocl.expressions.__impl.TypeExpImpl;
import org.omg.ocl.expressions.__impl.VariableDeclarationImpl;
import org.omg.ocl.expressions.__impl.VariableDeclarationInternal;
import org.omg.ocl.expressions.__impl.VariableExpImpl;
import org.omg.ocl.stdlibrary.StdLibraryPackage;
import org.omg.ocl.types.BagType;
import org.omg.ocl.types.CollectionType;
import org.omg.ocl.types.OrderedSetType;
import org.omg.ocl.types.SequenceType;
import org.omg.ocl.types.SetType;
import org.omg.ocl.types.TupleType;
import org.omg.ocl.types.__impl.BagTypeImpl;
import org.omg.ocl.types.__impl.CollectionTypeInternal;
import org.omg.ocl.types.__impl.OrderedSetTypeImpl;
import org.omg.ocl.types.__impl.SequenceTypeImpl;
import org.omg.ocl.types.__impl.SetTypeImpl;
import org.omg.ocl.types.__impl.TupleTypeImpl;
import org.omg.ocl.types.__impl.TypesPackageImpl;

import com.sap.tc.moin.MoinPackage;
import com.sap.tc.moin.__impl.MoinPackageImpl;
import com.sap.tc.moin.ocl.parser.gen.OclLexerGen;
import com.sap.tc.moin.ocl.parser.gen.OclParserGen;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.JmiInstantiator;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.MemoryLinkManager;
import com.sap.tc.moin.repository.core.MultiValuedAttributesList;
import com.sap.tc.moin.repository.core.jmi.extension.RefFeaturedExtension;
import com.sap.tc.moin.repository.core.jmi.reflect.PartitionableImpl;
import com.sap.tc.moin.repository.core.jmi.reflect.RefClassImpl;
import com.sap.tc.moin.repository.core.ocl.editorutils.OclEditorServiceImpl;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.Contains;
import com.sap.tc.moin.repository.mmi.model.DirectionKind;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.EvaluationKind;
import com.sap.tc.moin.repository.mmi.model.Import;
import com.sap.tc.moin.repository.mmi.model.IsOfType;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.Parameter;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.model.ScopeKindEnum;
import com.sap.tc.moin.repository.mmi.model.Tag;
import com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum;
import com.sap.tc.moin.repository.mmi.model.__impl.AttributeImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.ModelElementInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ModelPackageInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.MofClassInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.MofPackageImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.MofPackageInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.OperationImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.ParameterImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.TagImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.TagInternal;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.shared.util.ProcessReportImpl;
import com.sap.tc.moin.repository.shared.util.Utilities;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;
import com.sap.tc.moin.repository.spi.core.SpiPartitionable;

/**
 * This class provides OCL's primitive types and the most basic JMI creation
 * methods.
 */
public abstract class OclHelper {

    private static interface QualifiedNameFinder {
	/**
	 * Searches for the {@link com.sap.tc.moin.repository.mmi.model.ModelElement} with the given qualified name, recursively
	 * descending from the given outermost package.
	 * 
	 * @param qualifiedNameToSearch
	 *            The qualified name for which the {@link RefPackage package extent} should be found.
	 * @param outermostPackage
	 *            The {@link RefPackage} from which to start the search.
	 * @return The {@link com.sap.tc.moin.repository.mmi.model.ModelElement} matching the given qualified name.
	 * @author d027299
	 */
	public ModelElement findElementByQualifiedName(List<String> qualifiedNameToSearch, RefPackage outermostPackage);
    }
    
    private static class CoreQualifiedNameFinderImpl implements QualifiedNameFinder {
	private SpiJmiHelper jmiHelper;
	private Session session;
	public CoreQualifiedNameFinderImpl(SpiJmiHelper jmiHelper, Session session) {
	    this.jmiHelper = jmiHelper;
	}
	@Override
	public ModelElement findElementByQualifiedName(List<String> qualifiedNameToSearch, RefPackage outermostPackage) {
	    return jmiHelper.findElementByQualifiedName(session, qualifiedNameToSearch, outermostPackage);
	}
    }
    
    private static class QualifiedNameFinderImpl implements QualifiedNameFinder {
	private JmiHelper jmiHelper;
	public QualifiedNameFinderImpl(JmiHelper jmiHelper) {
	    this.jmiHelper = jmiHelper;
	}
	@Override
	public ModelElement findElementByQualifiedName(List<String> qualifiedNameToSearch, RefPackage outermostPackage) {
	    return jmiHelper.findElementByQualifiedName(qualifiedNameToSearch, outermostPackage);
	}
    }
    
    /*
     * class variables for the primitive types they are initialized by
     * initMofPrimitiveTypes
     */

    private static final String SIMPLECHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890_"; //$NON-NLS-1$

    private final Classifier realType;

    private final Classifier stringType;

    private final Classifier booleanType;

    private final Classifier integerType;

    private final Classifier doubleType;

    private final Classifier longType;

    private Classifier oclAny;

    private Classifier oclType;

    private Classifier oclVoid;

    private Classifier oclInvalid;

    private final MoinPackageImpl mofPackage;

    protected final OclPackageImpl oclp;

    protected final ExpressionsPackageImpl expressionsPkg;

    protected final TypesPackageImpl typesPkg;

    private final StdLibraryPackage stdLibpck;

    private final ModelPackageInternal mof;

    private final Map<String, Map<String, Operation>> stdLibraryOps = new HashMap<String, Map<String, Operation>>( );

    final boolean mmImportMode;

    private final CoreModelPartition targetPartition;

    private MofPackageImpl generatedPackage;

    private final Map<String, VariableDeclaration> thisPartitionsVariables = new HashMap<String, VariableDeclaration>( );

    protected final CoreConnection connection;

    private final JmiInstantiator myInstantiator;

    private final MemoryLinkManager myLinkManager;

    private Association oclExpressionType;

    private Association referredOperationAssoc;

    private Association referredVariable;

    private Association sourceExpression;

    private Association operationArgs;

    /**
     * The constructor
     * 
     * @param actConeection {@link CoreConnection}
     * @param theMof the MOF package
     * @param theImportMode meta model import mode
     * @param theTargetPartition the target partition, or null
     * @throws OclManagerException if the OCL types can not be found
     */
    public OclHelper( CoreConnection actConeection, MoinPackage theMof, boolean theImportMode, ModelPartition theTargetPartition ) throws OclManagerException {

        this.connection = actConeection;
        this.mofPackage = (MoinPackageImpl) theMof;
        this.mof = (ModelPackageInternal) this.mofPackage.getModel( this.connection );
        this.oclp = (OclPackageImpl) this.mofPackage.getOcl( this.connection );
        this.expressionsPkg = (ExpressionsPackageImpl) this.oclp.getExpressions( this.connection );
        this.typesPkg = (TypesPackageImpl) this.oclp.getTypes( this.connection );
        this.stdLibpck = this.oclp.getStdLibrary( this.connection );

        this.mmImportMode = theImportMode;
        if ( this.mmImportMode ) {
            this.targetPartition = (CoreModelPartition) theTargetPartition;
        } else {
            this.targetPartition = (CoreModelPartition) ( (Partitionable) this.connection.getPackage( ModelPackage.PACKAGE_DESCRIPTOR ) ).get___Partition( );
        }
        this.myInstantiator = this.connection.getSession( ).getWorkspaceSet( ).getMoin( ).getMetamodelWorkspace( ).getJmiInstantiator( );
        this.myLinkManager = this.connection.getSession( ).getWorkspaceSet( ).getMoin( ).getMetamodelWorkspace( ).getMemoryLinkManager( );

        // set up the primitive types
        MofPackageImpl ptprp = (MofPackageImpl) this.mofPackage.getPrimitiveTypes( this.connection ).refMetaObject( );

        MofPackageImpl stdlibp = (MofPackageImpl) this.stdLibpck.refMetaObject( );

        try {
            this.integerType = (PrimitiveType) ptprp.lookupElementExtended( this.connection, OclConstants.T_INTEGER );
            this.realType = (PrimitiveType) ptprp.lookupElementExtended( this.connection, OclConstants.T_FLOAT );
            this.stringType = (PrimitiveType) ptprp.lookupElementExtended( this.connection, OclConstants.T_STRING );
            this.booleanType = (PrimitiveType) ptprp.lookupElementExtended( this.connection, OclConstants.T_BOOLEAN );
            this.longType = (PrimitiveType) ptprp.lookupElementExtended( this.connection, OclConstants.T_LONG );
            this.doubleType = (PrimitiveType) ptprp.lookupElementExtended( this.connection, OclConstants.T_DOUBLE );
            this.oclAny = (Classifier) stdlibp.lookupElementExtended( this.connection, OclConstants.T_OCLANYSTDLIB );
            this.oclType = (Classifier) stdlibp.lookupElementExtended( this.connection, OclConstants.T_OCLTYPESTDLIB );
            this.oclVoid = (Classifier) stdlibp.lookupElementExtended( this.connection, OclConstants.T_OCLVOIDSTDLIB );
            this.oclInvalid = (Classifier) stdlibp.lookupElementExtended( this.connection, OclConstants.T_OCLINVALIDSTDLIB );
        } catch ( Exception e ) {
            throw new OclManagerException( e, OclUtilExceptions.EXCEPTIONINITOCLHELPER );
        }
    }

    /**
     * @return Returns the booleanType.
     */
    public Classifier getBoolClass( ) {

        return this.booleanType;
    }

    /**
     * @return Returns the integerType.
     */
    public Classifier getIntClass( ) {

        return this.integerType;
    }

    /**
     * @return Returns the realType.
     */
    public Classifier getFloatClass( ) {

        return this.realType;
    }

    /**
     * @return the doubleType.
     */
    public Classifier getDoubleClass( ) {

        return this.doubleType;
    }

    /**
     * @return the longType.
     */
    public Classifier getLongClass( ) {

        return this.longType;
    }

    /**
     * @return Returns the stringType.
     */
    public Classifier getStringClass( ) {

        return this.stringType;
    }

    /**
     * Search for the innermost type (i.e. the element type which is not a
     * CollectionType) of a Collection type.
     * 
     * @param type
     * @return returns the innermost type if <tt>type</tt> is a CollectionType
     * else it returns <tt>type</tt>.
     */
    Classifier innermostType( Classifier type ) {

        if ( type instanceof CollectionType ) {
            return this.innermostType( ( (CollectionTypeInternal) type ).getElementType( this.connection ) );
        }
        return type;
    }

    /**
     * Creates a plain AssociationCallExp
     * 
     * @return the expression
     */
    AssociationEndCallExp createAssociationCallExp( OclExpression source, AssociationEnd assocEnd, Classifier typeOfAssociationEnd ) throws OclSemanticException {

        /*
         * -- sanity check on the arguments
         */
        assertArgNotNull( source, JmiCreatorMessages.JMICREATOR_0201 );
        assertArgNotNull( assocEnd, JmiCreatorMessages.JMICREATOR_0202 );

        Association referredEnd = this.expressionsPkg.getAReferredAssociationEndAssociationEndCallExp( this.connection ).refMetaObject( );
        Association navigationSource = this.expressionsPkg.getANavigationSourceNavigationCallExp( this.connection ).refMetaObject( );

        RefClassImpl classProxy = (RefClassImpl) this.expressionsPkg.getAssociationEndCallExp( this.connection );
        AssociationEndCallExpImpl asecex;
        if ( this.mmImportMode ) {
            asecex = (AssociationEndCallExpImpl) this.connection.createElementInPartition( AssociationEndCallExp.class, null );
            asecex.setName( this.connection, assocEnd.getName( ) );
            asecex.setSource( this.connection, source );
            asecex.setReferredAssociationEnd( this.connection, assocEnd );
            asecex.setNavigationSource( this.connection, assocEnd );
            asecex.setType( this.connection, typeOfAssociationEnd );
            this.addToPartition( asecex );
        } else {
            Map<String, Object> values = new HashMap<String, Object>( );
            values.put( OclConstants.F_NAME, assocEnd.getName( ) );
            asecex = (AssociationEndCallExpImpl) this.createRefObject( classProxy, values );
            this.setType( asecex, typeOfAssociationEnd );
            this.setSource( asecex, source );
            this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) assocEnd, (SpiPartitionable) asecex, referredEnd );
            this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) assocEnd, (SpiPartitionable) asecex, navigationSource );
        }
        return asecex;
    }

    private RefObject createRefObject( RefClass classProxy ) {

        MofClass mc = classProxy.refMetaObject( );
        RefPackage immediatePackage = null;
        String mofId = this.connection.getSession( ).getWorkspace( ).createMofId( this.targetPartition );
        return this.myInstantiator.createRefObject( this.connection, mofId, immediatePackage, mc, classProxy, this.targetPartition );
    }

    private RefFeatured createRefObject( RefClass classProxy, Map<String, Object> values ) {

        MofClass mc = classProxy.refMetaObject( );
        RefPackage immediatePackage = null;
        String mofId = this.connection.getSession( ).getWorkspace( ).createMofId( this.targetPartition );
        RefFeaturedExtension result = (RefFeaturedExtension) this.myInstantiator.createRefObject( this.connection, mofId, immediatePackage, mc, classProxy, this.targetPartition );
        for ( Entry<String, Object> entry : values.entrySet( ) ) {
            result.set___Value( this.connection.getSession( ), entry.getKey( ), entry.getValue( ) );
        }
        return result;
    }

    protected void addToPartition( Partitionable element ) {

        if ( this.targetPartition != null ) {
            ( (PartitionableImpl) element ).assign___Partition( this.connection, this.targetPartition );
        }
    }

    /**
     * Creates a plain AttributeCallExp object
     * 
     * @return the expression
     */
    AttributeCallExp createAttributeCallExp( String name, OclExpression source, Attribute referredAttribute, Classifier type ) {

        RefClassImpl classProxy = (RefClassImpl) this.expressionsPkg.getAttributeCallExp( this.connection );
        Association attrAssoc = this.expressionsPkg.getAReferredAttributeAttributeCallExp( this.connection ).refMetaObject( );
        AttributeCallExpImpl expression;
        if ( this.mmImportMode ) {
            expression = (AttributeCallExpImpl) classProxy.refCreateInstance( this.connection, null );
            expression.setName( this.connection, name );
            expression.setSource( this.connection, source );
            expression.setReferredAttribute( this.connection, referredAttribute );
            expression.setType( this.connection, type );
            this.addToPartition( expression );
        } else {
            Map<String, Object> values = new HashMap<String, Object>( );
            values.put( OclConstants.F_NAME, name );
            expression = (AttributeCallExpImpl) this.createRefObject( classProxy, values );
            this.setType( expression, type );
            this.setSource( expression, source );
            this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) referredAttribute, (SpiPartitionable) expression, attrAssoc );
        }
        return expression;
    }

    /**
     * Creates a BoolenLiteralExp
     * 
     * @param lit the Boolean literal (parsed with Boolean.valueOf())
     * @return the BooleanLiteralExp
     * @see Boolean#valueOf(String)
     * @see MoinJmiCreator#createBooleanLiteralExp(String)
     */
    public BooleanLiteralExp createBooleanLiteralExp( String lit ) {

        RefClassImpl classProxy = (RefClassImpl) this.expressionsPkg.getBooleanLiteralExp( this.connection );

        BooleanLiteralExpImpl expression;
        if ( this.mmImportMode ) {
            expression = (BooleanLiteralExpImpl) classProxy.refCreateInstance( this.connection, null );
            expression.setName( this.connection, "BooleanLitFor" + lit ); //$NON-NLS-1$
            expression.setBooleanSymbol( this.connection, Boolean.valueOf( lit ).booleanValue( ) );
            expression.setType( this.connection, this.getBoolClass( ) );
            this.addToPartition( expression );
        } else {
            Map<String, Object> values = new HashMap<String, Object>( );
            values.put( OclConstants.F_NAME, "BooleanLitFor" + lit ); //$NON-NLS-1$
            values.put( "booleanSymbol", Boolean.valueOf( lit ) ); //$NON-NLS-1$
            expression = (BooleanLiteralExpImpl) createRefObject( classProxy, values );
            this.setType( expression, this.getBoolClass( ) );
        }

        return expression;
    }

    /**
     * Creates a <code>CollectionItem</code>
     * 
     * @return a plain CollectionItem object
     */
    CollectionItem createCollectionItem( OclExpression itemExpr, Classifier type ) {

        RefClassImpl classProxy = (RefClassImpl) this.expressionsPkg.getCollectionItem( this.connection );
        Association typeAssoc = this.expressionsPkg.getATypeCollectionLiteralPart( this.connection ).refMetaObject( );
        Association itemAssoc = this.expressionsPkg.getAItemCollectionItem( this.connection ).refMetaObject( );

        CollectionItemImpl item;
        if ( this.mmImportMode ) {
            item = (CollectionItemImpl) classProxy.refCreateInstance( this.connection, null );
            item.setItem( this.connection, itemExpr );
            item.setType( this.connection, type );
            this.addToPartition( item );
        } else {
            item = (CollectionItemImpl) createRefObject( classProxy );
            this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) type, (SpiPartitionable) item, typeAssoc );
            this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) itemExpr, (SpiPartitionable) item, itemAssoc );
        }
        return item;
    }

    /**
     * Creates a <code>CollectionLiteralExp</code>
     * 
     * @return a plain CollectionLiteralExp object
     */
    CollectionLiteralExp createCollectionLiteralExpInternal( CollectionType colType, List<CollectionLiteralPart> collectionParts ) throws OclSemanticException {

        RefClassImpl classProxy = (RefClassImpl) this.expressionsPkg.getCollectionLiteralExp( this.connection );
        Association partsAssoc = this.expressionsPkg.getAPartsCollectionLiteralExp( this.connection ).refMetaObject( );

        CollectionKindEnum collKind;
        if ( colType instanceof SetType ) {
            collKind = CollectionKindEnum.SET;
        } else if ( colType instanceof BagType ) {
            collKind = CollectionKindEnum.BAG;
        } else if ( colType instanceof SequenceType ) {
            collKind = CollectionKindEnum.SEQUENCE;
        } else if ( colType instanceof OrderedSetType ) {
            collKind = CollectionKindEnum.ORDERED_SET;
        } else {
            throw new OclSemanticException( OclUtilExceptions.CANNOTDETERMINECOLLECTIONKIND );
        }

        CollectionLiteralExpImpl expression;
        if ( this.mmImportMode ) {
            expression = (CollectionLiteralExpImpl) classProxy.refCreateInstance( this.connection, null );
            expression.setName( this.connection, "CollectionLitFor" + colType.getName( ) ); //$NON-NLS-1$
            expression.setType( this.connection, colType );
            expression.setKind( this.connection, collKind );
            JmiList<CollectionLiteralPart> parts = (JmiList<CollectionLiteralPart>) expression.getParts( this.connection );
            parts.addAll( this.connection, collectionParts );
            this.addToPartition( expression );
        } else {
            Map<String, Object> values = new HashMap<String, Object>( );
            values.put( OclConstants.F_NAME, "CollectionLitFor" + colType.getName( ) ); //$NON-NLS-1$
            values.put( "kind", collKind ); //$NON-NLS-1$
            expression = (CollectionLiteralExpImpl) createRefObject( classProxy, values );
            this.setType( expression, colType );
            for ( CollectionLiteralPart part : collectionParts ) {
                this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) part, (SpiPartitionable) expression, partsAssoc );
            }
        }
        return expression;
    }

    /**
     * Creates a <code>CollectionRange</code>
     * 
     * @return a plain CollectionRange object
     */
    CollectionRange createCollectionRangeInternal( OclExpression first, OclExpression last, Classifier rangeType ) {

        RefClassImpl classProxy = (RefClassImpl) this.expressionsPkg.getCollectionRange( this.connection );

        Association typeAssoc = this.expressionsPkg.getATypeCollectionLiteralPart( this.connection ).refMetaObject( );
        Association firstAssoc = this.expressionsPkg.getAFirstCollectionRange( this.connection ).refMetaObject( );
        Association lastAssoc = this.expressionsPkg.getALastCollectionRange( this.connection ).refMetaObject( );

        CollectionRangeImpl range;
        if ( this.mmImportMode ) {
            range = (CollectionRangeImpl) classProxy.refCreateInstance( this.connection, null );
            range.setFirst( this.connection, first );
            range.setLast( this.connection, last );
            // TODO rangeType must conform to Integer
            range.setType( this.connection, rangeType );
            this.addToPartition( range );
        } else {
            range = (CollectionRangeImpl) createRefObject( classProxy );
            this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) rangeType, (SpiPartitionable) range, typeAssoc );
            this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) first, (SpiPartitionable) range, firstAssoc );
            this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) last, (SpiPartitionable) range, lastAssoc );
        }
        return range;
    }

    /**
     * Creates a EnumLiteralExp and sets <code>referredEnum</code> to
     * <code>enumType</code>,<code>literal</code> to <code>enumLiteral</code>
     * and <code>type</code> to <code>enumType</code>.
     * 
     * @param enumType the <code>EnumerationType</code>
     * @param enumLiteral the literal of the Enumeration
     * @return a EnumLiteralExp with type set to <code>enumType</code> and
     * literal set to <code>enumLiteral</code>
     * @throws OclSemanticException if enumType == null or enumLiteral == null
     * or empty
     */
    public EnumLiteralExp createEnumLiteralExp( EnumerationType enumType, String enumLiteral ) throws OclSemanticException {

        /*
         * -- sanity checks
         */
        assertArgNotNull( enumType, JmiCreatorMessages.JMICREATOR_0218 );
        assertStringNotEmpty( enumLiteral, JmiCreatorMessages.JMICREATOR_0219 );

        RefClassImpl classProxy = (RefClassImpl) this.expressionsPkg.getEnumLiteralExp( this.connection );
        Association refEnum = this.expressionsPkg.getAReferredEnumEnumLiteralExp( this.connection ).refMetaObject( );

        EnumLiteralExpImpl litExp;
        if ( this.mmImportMode ) {
            litExp = (EnumLiteralExpImpl) classProxy.refCreateInstance( this.connection, null );
            litExp.setName( this.connection, "EnumLitExpFor" + enumType.getName( ) ); //$NON-NLS-1$
            litExp.setLiteral( this.connection, enumLiteral );
            litExp.setReferredEnum( this.connection, enumType );
            litExp.setType( this.connection, enumType );
            this.addToPartition( litExp );
        } else {
            Map<String, Object> values = new HashMap<String, Object>( );
            values.put( OclConstants.F_NAME, "EnumLitExpFor" + enumType.getName( ) ); //$NON-NLS-1$
            values.put( "literal", enumLiteral ); //$NON-NLS-1$
            litExp = (EnumLiteralExpImpl) this.createRefObject( classProxy, values );
            this.setType( litExp, enumType );
            this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) enumType, (SpiPartitionable) litExp, refEnum );
        }

        return litExp;
    }

    /**
     * creates a new IfExp object
     * 
     * @return the expression
     */
    IfExp createIfExp( String name, OclExpression condExp, OclExpression thenExp, OclExpression elseExp, Classifier type ) {

        RefClassImpl classProxy = (RefClassImpl) this.expressionsPkg.getIfExp( this.connection );
        Association conditionAssoc = this.expressionsPkg.getAConditionIfExp( this.connection ).refMetaObject( );
        Association thenAssoc = this.expressionsPkg.getAThenExpressionIfExp( this.connection ).refMetaObject( );
        Association elseAssoc = this.expressionsPkg.getAElseExpressionIfExp( this.connection ).refMetaObject( );

        IfExpImpl expression;
        if ( this.mmImportMode ) {
            expression = (IfExpImpl) classProxy.refCreateInstance( this.connection, null );
            expression.setName( this.connection, name );
            expression.setCondition( this.connection, condExp );
            expression.setThenExpression( this.connection, thenExp );
            expression.setElseExpression( this.connection, elseExp );
            expression.setType( this.connection, type );
            this.addToPartition( expression );
        } else {
            Map<String, Object> values = new HashMap<String, Object>( );
            values.put( OclConstants.F_NAME, name );
            expression = (IfExpImpl) createRefObject( classProxy, values );
            this.setType( expression, type );
            this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) condExp, (SpiPartitionable) expression, conditionAssoc );
            this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) thenExp, (SpiPartitionable) expression, thenAssoc );
            this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) elseExp, (SpiPartitionable) expression, elseAssoc );
        }
        return expression;
    }

    /**
     * creates a new IntegerLiteralExp object
     * 
     * @return a plain IntegerLiteralExp
     */
    IntegerLiteralExp createIntegerLiteralExp( String name, Integer symbol ) {

        RefClassImpl classProxy = (RefClassImpl) this.expressionsPkg.getIntegerLiteralExp( this.connection );

        IntegerLiteralExpImpl expression;
        if ( this.mmImportMode ) {
            expression = (IntegerLiteralExpImpl) classProxy.refCreateInstance( this.connection, null );
            expression.setName( this.connection, name );
            expression.setIntegerSymbol( this.connection, symbol.intValue( ) );
            expression.setType( this.connection, this.getIntClass( ) );
            this.addToPartition( expression );
        } else {
            Map<String, Object> values = new HashMap<String, Object>( );
            values.put( OclConstants.F_NAME, name );
            values.put( "integerSymbol", symbol ); //$NON-NLS-1$
            expression = (IntegerLiteralExpImpl) this.createRefObject( classProxy, values );
            this.setType( expression, this.getIntClass( ) );
        }
        return expression;
    }

    /**
     * creates a new IterateExp. For more convenient methods to create
     * IterateExp have a look at
     * <code>com.sap.rcbne.ocl20.parser.impl.env.IteratorCreator</code>.
     * 
     * @return a plain IterateExp object
     */
    IterateExp createIterateExp( String name, Classifier type, OclExpression source, VariableDeclaration result, OclExpression body, VariableDeclaration firstIter, VariableDeclaration secondIter ) {

        RefClassImpl classProxy = (RefClassImpl) this.expressionsPkg.getIterateExp( this.connection );

        Association baseExpr = this.expressionsPkg.getABaseExpResult( this.connection ).refMetaObject( );
        Association bodyAss = this.expressionsPkg.getALoopExpBody( this.connection ).refMetaObject( );
        Association iteratorAssoc = this.expressionsPkg.getALoopExprIterators( this.connection ).refMetaObject( );

        IterateExpImpl expression;
        if ( this.mmImportMode ) {
            expression = (IterateExpImpl) classProxy.refCreateInstance( this.connection, null );
            expression.setName( this.connection, name );
            expression.setType( this.connection, type );
            expression.setSource( this.connection, source );
            expression.setResult( this.connection, result );
            expression.setBody( this.connection, body );
            JmiList<VariableDeclaration> iterators = (JmiList<VariableDeclaration>) expression.getIterators( this.connection );
            iterators.add( this.connection, firstIter );
            if ( secondIter != null ) {
                iterators.add( this.connection, secondIter );
            }
            this.addToPartition( expression );
        } else {
            Map<String, Object> values = new HashMap<String, Object>( );
            values.put( OclConstants.F_NAME, name );
            expression = (IterateExpImpl) this.createRefObject( classProxy, values );
            this.setType( expression, type );
            this.setSource( expression, source );
            this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) expression, (SpiPartitionable) result, baseExpr );
            this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) expression, (SpiPartitionable) body, bodyAss );
            this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) expression, (SpiPartitionable) firstIter, iteratorAssoc );
            if ( secondIter != null ) {
                this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) expression, (SpiPartitionable) secondIter, iteratorAssoc );
            }
        }
        return expression;
    }

    /**
     * Creates a <code>PostconditionConstraint</code> object.
     * 
     * @return the <code>PostconditionConstraint</code> object
     */
    private PostconditionConstraint createPostconditionConstraint( ) {

        PostconditionConstraint constraint = ( (AttachingPackageImpl) this.oclp.getAttaching( this.connection ) ).getPostconditionConstraint( this.connection );
        return constraint;
    }

    /**
     * Creates a <code>PreconditionConstraint</code> object.
     * 
     * @return the <code>PreconditionConstraint</code> object
     */
    private PreconditionConstraint createPreconditionConstraint( ) {

        return ( (AttachingPackageImpl) this.oclp.getAttaching( this.connection ) ).getPreconditionConstraint( this.connection );
    }

    /**
     * creates a new RealLiteralExp object
     * 
     * @return a plain RealLiteralExp object
     */
    RealLiteralExp createRealLiteralExp( String name, Double symbol ) {

        RefClassImpl classProxy = (RefClassImpl) this.expressionsPkg.getRealLiteralExp( this.connection );

        RealLiteralExpImpl expression;
        if ( this.mmImportMode ) {
            expression = (RealLiteralExpImpl) classProxy.refCreateInstance( this.connection, null );
            expression.setName( this.connection, name );
            expression.setRealSymbol( this.connection, symbol.doubleValue( ) );
            expression.setType( this.connection, this.getDoubleClass( ) );
            this.addToPartition( expression );
        } else {
            Map<String, Object> values = new HashMap<String, Object>( );
            values.put( OclConstants.F_NAME, name );
            values.put( "realSymbol", symbol ); //$NON-NLS-1$
            expression = (RealLiteralExpImpl) this.createRefObject( classProxy, values );
            this.setType( expression, this.getDoubleClass( ) );
        }
        return expression;
    }

    /**
     * Creates a <code>StringLiteralExp</code>.
     * 
     * @param literal the string literal
     * @return <code>StringLiteralExp</code> with its stringSymbol set to
     * <code>lit</code>
     * @throws OclSemanticException if lit == null
     */
    public StringLiteralExp createStringLiteralExp( String literal ) throws OclSemanticException {

        assertArgNotNull( literal, JmiCreatorMessages.JMICREATOR_0240 );

        RefClassImpl classProxy = (RefClassImpl) this.expressionsPkg.getStringLiteralExp( this.connection );

        StringBuilder sb = new StringBuilder( 10 );
        int index = 0;
        while ( sb.length( ) < 10 && index < literal.length( ) ) {
            char c = literal.charAt( index );
            if ( SIMPLECHARS.indexOf( c ) > -1 ) {
                sb.append( c );
            }
            index++;
        }

        StringLiteralExpImpl expression;
        if ( this.mmImportMode ) {
            expression = (StringLiteralExpImpl) classProxy.refCreateInstance( this.connection, null );
            expression.setName( this.connection, "StringLiteralExpFor" + sb.toString( ) ); //$NON-NLS-1$
            expression.setStringSymbol( this.connection, literal );
            expression.setType( this.connection, this.getStringClass( ) );
            this.addToPartition( expression );
        } else {
            Map<String, Object> values = new HashMap<String, Object>( );
            values.put( OclConstants.F_NAME, "StringLiteralExpFor" + sb.toString( ) ); //$NON-NLS-1$
            values.put( "stringSymbol", literal ); //$NON-NLS-1$
            expression = (StringLiteralExpImpl) this.createRefObject( classProxy, values );
            this.setType( expression, this.getStringClass( ) );
        }
        return expression;
    }

    /**
     * Creates a TupleLiteralExp
     * 
     * @return a TupleLiteralExp
     */
    TupleLiteralExp createTupleLiteralExpInternal( TupleType type, List<VariableDeclaration> varDecls ) {

        RefClassImpl classProxy = (RefClassImpl) this.expressionsPkg.getTupleLiteralExp( this.connection );
        Association tupleAssoc = this.expressionsPkg.getATuplePartTupleLiteralExp( this.connection ).refMetaObject( );

        TupleLiteralExpImpl expression;
        if ( this.mmImportMode ) {
            expression = (TupleLiteralExpImpl) classProxy.refCreateInstance( this.connection, null );
            expression.setName( this.connection, "ExpForTupleType" + type.getName( ) ); //$NON-NLS-1$
            expression.setType( this.connection, type );
            this.addToPartition( expression );
            ( (JmiList<VariableDeclaration>) expression.getTuplePart( this.connection ) ).addAll( this.connection, varDecls );
        } else {
            Map<String, Object> values = new HashMap<String, Object>( );
            values.put( OclConstants.F_NAME, "ExpForTupleType" + type.getName( ) ); //$NON-NLS-1$
            expression = (TupleLiteralExpImpl) this.createRefObject( classProxy, values );
            this.setType( expression, type );
            for ( VariableDeclaration dec : varDecls ) {
                this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) dec, (SpiPartitionable) expression, tupleAssoc );
            }
        }

        return expression;
    }

    /**
     * Creates a <code>TupleType</code>.
     * 
     * @return a plain <code>TupleType</code> object
     */
    TupleType createTupleTypeInternal( List<Attribute> tupleParts, String name ) throws OclSemanticException {

        MofPackageInternal mp;
        try {
            mp = (MofPackageInternal) this.getOrCreatePackageForGeneratedObjects( true );
        } catch ( OclManagerException e ) {
            throw new OclSemanticException( e );
        }

        RefClassImpl classProxy = (RefClassImpl) this.typesPkg.getTupleType( this.connection );
        Association containsAssoc = this.connection.getAssociation( Contains.ASSOCIATION_DESCRIPTOR ).refMetaObject( );
        TupleTypeImpl expression;
        if ( this.mmImportMode ) {
            expression = (TupleTypeImpl) classProxy.refCreateInstance( this.connection, null );
            expression.setName( this.connection, name );
            expression.setAnnotation( this.connection, OclConstants.EMPTY );
            expression.setVisibility( this.connection, VisibilityKindEnum.PUBLIC_VIS );
            expression.setLeaf( this.connection, true );
            expression.setRoot( this.connection, true );
            ( (JmiList<ModelElement>) expression.getContents( this.connection ) ).addAll( this.connection, tupleParts );
            this.addToPartition( expression );
            JmiList<ModelElement> contents = (JmiList<ModelElement>) mp.getContents( this.connection );
            contents.add( this.connection, expression );

        } else {
            Map<String, Object> values = new HashMap<String, Object>( );
            values.put( OclConstants.F_NAME, name );
            values.put( OclConstants.F_ANNOTATION, OclConstants.EMPTY );
            values.put( OclConstants.F_VISIBILITY, VisibilityKindEnum.PUBLIC_VIS );
            values.put( "isLeaf", Boolean.TRUE ); //$NON-NLS-1$
            values.put( "isRoot", Boolean.TRUE ); //$NON-NLS-1$
            expression = (TupleTypeImpl) this.createRefObject( classProxy, values );
            for ( Attribute att : tupleParts ) {
                this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) expression, (SpiPartitionable) att, containsAssoc );
            }
            this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) mp, (SpiPartitionable) expression, containsAssoc );
        }

        return expression;
    }

    /**
     * Creates a new TypeExp.
     * 
     * @return a TypeExp
     */
    TypeExp createTypeExp( String name, Classifier refType ) {

        Classifier type = this.getOclTypeClass( );
        RefClassImpl classProxy = (RefClassImpl) this.expressionsPkg.getTypeExp( this.connection );
        Association refTypeAssoc = this.expressionsPkg.getAReferredTypeTypeExp( this.connection ).refMetaObject( );

        TypeExpImpl expression;
        if ( this.mmImportMode ) {
            expression = (TypeExpImpl) classProxy.refCreateInstance( this.connection, null );
            expression.setName( this.connection, name );
            expression.setReferredType( this.connection, refType );
            expression.setType( this.connection, type );
            this.addToPartition( expression );
        } else {
            Map<String, Object> values = new HashMap<String, Object>( );
            values.put( OclConstants.F_NAME, name );
            expression = (TypeExpImpl) this.createRefObject( classProxy, values );
            this.setType( expression, type );
            this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) refType, (SpiPartitionable) expression, refTypeAssoc );
        }
        return expression;
    }

    /**
     * creates a new variableDeclaration object
     * 
     * @return a plain VariableDeclaratin object
     */
    protected VariableDeclaration createVariableDeclarationInternal( String varName, Classifier type, OclExpression initExpression ) {

        String actName = varName;
        /*
         * in the case of "self", we add the type name because we want to be
         * able to find it later on in the partition for re-use
         */

        if ( OclConstants.VAR_SELF.equals( varName ) ) {
            actName = OclConstants.VAR_SELF + OclConstants.BRACKETLEFT + type.getName( ) + OclConstants.BRACKETRIGHT;
        }
        // check if we have created it before in the partition
        VariableDeclaration result = this.getVariableDeclarationFromPartition( actName, type );
        if ( result != null ) {
            return result;
        }

        RefClassImpl classProxy = (RefClassImpl) this.expressionsPkg.getVariableDeclaration( this.connection );
        Association initExpr = this.expressionsPkg.getAInitExpressionInitializedVariable( this.connection ).refMetaObject( );
        Association typeExp = this.expressionsPkg.getATypeVariableDeclaration( this.connection ).refMetaObject( );

        VariableDeclarationImpl vdec;
        if ( this.mmImportMode ) {
            vdec = (VariableDeclarationImpl) classProxy.refCreateInstance( this.connection, null );
            vdec.setName( this.connection, actName );
            vdec.setVarName( this.connection, varName );
            vdec.setInitExpression( this.connection, initExpression );
            vdec.setType( this.connection, type );
            this.addToPartition( vdec );
        } else {
            Map<String, Object> values = new HashMap<String, Object>( );
            values.put( OclConstants.F_NAME, actName );
            values.put( "varName", varName ); //$NON-NLS-1$
            vdec = (VariableDeclarationImpl) this.createRefObject( classProxy, values );
            if ( initExpression != null ) {
                this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) initExpression, (SpiPartitionable) vdec, initExpr );
            }
            this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) type, (SpiPartitionable) vdec, typeExp );
        }

        if ( actName.startsWith( "self(" ) || "OclUndefined".equals( actName ) || OclConstants.VAR_NULL.equals( actName ) || OclConstants.VAR_INVALID.equals( actName ) ) { //$NON-NLS-1$//$NON-NLS-2$
            this.thisPartitionsVariables.put( actName, vdec );
        }

        return vdec;
    }

    /**
     * creates a new VariableExp object
     * 
     * @return a plain VariableExp object
     */
    VariableExp createVariableExp( VariableDeclaration varDecl, Classifier type ) {

        RefClassImpl classProxy = (RefClassImpl) this.expressionsPkg.getVariableExp( this.connection );
        if ( this.referredVariable == null ) {
            this.referredVariable = this.expressionsPkg.getAReferredVariableVariableExp( this.connection ).refMetaObject( );
        }

        VariableExpImpl expression;
        if ( this.mmImportMode ) {
            expression = (VariableExpImpl) classProxy.refCreateInstance( this.connection, null );
            this.addToPartition( expression );
            expression.setName( this.connection, varDecl.getName( ) );
            expression.setType( this.connection, type );
            expression.setReferredVariable( this.connection, varDecl );
        } else {
            Map<String, Object> values = new HashMap<String, Object>( );
            values.put( OclConstants.F_NAME, varDecl.getName( ) );
            expression = (VariableExpImpl) this.createRefObject( classProxy, values );
            this.setType( expression, type );
            this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) varDecl, (SpiPartitionable) expression, this.referredVariable );
        }

        return expression;
    }

    /**
     * creates a new IteratorExp. For more convenient methods to create
     * IteratorExp have a look at
     * <code>com.sap.rcbne.ocl20.parser.impl.env.IteratorCreator</code>.
     * 
     * @return a plain IteratorExp object
     */
    IteratorExp createIteratorExpInternal( String name, OclExpression source, VariableDeclaration iterator, VariableDeclaration iter2, OclExpression body, Classifier type ) {

        RefClassImpl classProxy = (RefClassImpl) this.expressionsPkg.getIteratorExp( this.connection );

        Association bodyAssoc = this.expressionsPkg.getALoopExpBody( this.connection ).refMetaObject( );
        Association iteratorAssoc = this.expressionsPkg.getALoopExprIterators( this.connection ).refMetaObject( );

        IteratorExpImpl expression;
        if ( this.mmImportMode ) {
            expression = (IteratorExpImpl) classProxy.refCreateInstance( this.connection, null );
            expression.setName( this.connection, name );
            expression.setSource( this.connection, source );
            expression.setType( this.connection, type );
            expression.setBody( this.connection, body );
            ( (JmiList<VariableDeclaration>) expression.getIterators( this.connection ) ).add( this.connection, iterator );
            if ( iter2 != null ) {
                ( (JmiList<VariableDeclaration>) expression.getIterators( this.connection ) ).add( this.connection, iter2 );
            }
            this.addToPartition( expression );
        } else {
            Map<String, Object> values = new HashMap<String, Object>( );
            values.put( OclConstants.F_NAME, name );
            expression = (IteratorExpImpl) this.createRefObject( classProxy, values );
            this.setType( expression, type );
            this.setSource( expression, source );
            this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) expression, (SpiPartitionable) body, bodyAssoc );
            this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) expression, (SpiPartitionable) iterator, iteratorAssoc );
            if ( iter2 != null ) {
                this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) expression, (SpiPartitionable) iter2, iteratorAssoc );
            }
        }

        return expression;
    }

    BagType createBagTypeInternal( Classifier type ) {

        String name = "Bag(" + ( (ModelElementInternal) type ).getQualifiedName( this.connection ) + ")"; //$NON-NLS-1$//$NON-NLS-2$
        Classifier cls = this.getCollectionTypeFromPartition( name, type );
        if ( cls != null ) {
            return (BagType) cls;
        }
        RefClassImpl classProxy = (RefClassImpl) this.typesPkg.getBagType( this.connection );
        Association elementTypeAssoc = this.typesPkg.getACollectionTypesElementType( this.connection ).refMetaObject( );

        BagTypeImpl expression;
        if ( this.mmImportMode ) {
            expression = (BagTypeImpl) ( (RefClassImpl) this.typesPkg.getBagType( this.connection ) ).refCreateInstance( this.connection, null );
            expression.setName( this.connection, name );
            expression.setAnnotation( this.connection, OclConstants.EMPTY );
            expression.setElementType( this.connection, type );
            expression.setVisibility( this.connection, VisibilityKindEnum.PUBLIC_VIS );
            expression.setLeaf( this.connection, true );
            expression.setRoot( this.connection, true );
            this.addToPartition( expression );
        } else {
            Map<String, Object> values = new HashMap<String, Object>( );
            values.put( OclConstants.F_NAME, name );
            values.put( OclConstants.F_ANNOTATION, OclConstants.EMPTY );
            values.put( OclConstants.F_VISIBILITY, VisibilityKindEnum.PUBLIC_VIS );
            values.put( "isLeaf", Boolean.TRUE ); //$NON-NLS-1$
            values.put( "isRoot", Boolean.TRUE ); //$NON-NLS-1$
            expression = (BagTypeImpl) createRefObject( classProxy, values );
            this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) expression, (SpiPartitionable) type, elementTypeAssoc );
        }

        return expression;
    }

    SetType createSetTypeInternal( Classifier type ) {

        String name = "Set(" + ( (ModelElementInternal) type ).getQualifiedName( this.connection ) + ")"; //$NON-NLS-1$//$NON-NLS-2$
        Classifier cls = this.getCollectionTypeFromPartition( name, type );
        if ( cls != null ) {
            return (SetType) cls;
        }
        RefClassImpl classProxy = (RefClassImpl) this.typesPkg.getSetType( this.connection );
        Association elementTypeAssoc = this.typesPkg.getACollectionTypesElementType( this.connection ).refMetaObject( );

        SetTypeImpl expression;
        if ( this.mmImportMode ) {
            expression = (SetTypeImpl) classProxy.refCreateInstance( this.connection, null );
            expression.setName( this.connection, name );
            expression.setAnnotation( this.connection, OclConstants.EMPTY );
            expression.setElementType( this.connection, type );
            expression.setVisibility( this.connection, VisibilityKindEnum.PUBLIC_VIS );
            expression.setRoot( this.connection, true );
            expression.setLeaf( this.connection, true );
            this.addToPartition( expression );
        } else {
            Map<String, Object> values = new HashMap<String, Object>( );
            values.put( OclConstants.F_NAME, name );
            values.put( OclConstants.F_ANNOTATION, OclConstants.EMPTY );
            values.put( OclConstants.F_VISIBILITY, VisibilityKindEnum.PUBLIC_VIS );
            values.put( "isLeaf", Boolean.TRUE ); //$NON-NLS-1$
            values.put( "isRoot", Boolean.TRUE ); //$NON-NLS-1$
            expression = (SetTypeImpl) this.createRefObject( classProxy, values );
            this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) expression, (SpiPartitionable) type, elementTypeAssoc );
        }

        return expression;
    }

    SequenceType createSequenceTypeInternal( Classifier type ) {

        String name = "Sequence(" + ( (ModelElementInternal) type ).getQualifiedName( this.connection ) + ")"; //$NON-NLS-1$//$NON-NLS-2$
        Classifier cls = this.getCollectionTypeFromPartition( name, type );
        if ( cls != null ) {
            return (SequenceType) cls;
        }
        RefClassImpl classProxy = (RefClassImpl) this.typesPkg.getSequenceType( this.connection );
        Association elementTypeAssoc = this.typesPkg.getACollectionTypesElementType( this.connection ).refMetaObject( );

        SequenceTypeImpl expression;
        if ( this.mmImportMode ) {
            expression = (SequenceTypeImpl) classProxy.refCreateInstance( this.connection, null );
            expression.setName( this.connection, name );
            expression.setAnnotation( this.connection, OclConstants.EMPTY );
            expression.setVisibility( this.connection, VisibilityKindEnum.PUBLIC_VIS );
            expression.setElementType( this.connection, type );
            expression.setLeaf( this.connection, true );
            expression.setRoot( this.connection, true );
            this.addToPartition( expression );
        } else {
            Map<String, Object> values = new HashMap<String, Object>( );
            values.put( OclConstants.F_NAME, name );
            values.put( OclConstants.F_ANNOTATION, OclConstants.EMPTY );
            values.put( OclConstants.F_VISIBILITY, VisibilityKindEnum.PUBLIC_VIS );
            values.put( "isLeaf", Boolean.TRUE ); //$NON-NLS-1$
            values.put( "isRoot", Boolean.TRUE ); //$NON-NLS-1$
            expression = (SequenceTypeImpl) this.createRefObject( classProxy, values );
            this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) expression, (SpiPartitionable) type, elementTypeAssoc );
        }

        return expression;
    }

    OrderedSetType createOrderedSetTypeInternal( Classifier type ) {

        String name = "OrderedSet(" + ( (ModelElementInternal) type ).getQualifiedName( this.connection ) + ")"; //$NON-NLS-1$//$NON-NLS-2$
        Classifier cls = this.getCollectionTypeFromPartition( name, type );
        if ( cls != null ) {
            return (OrderedSetType) cls;
        }
        RefClassImpl classProxy = (RefClassImpl) this.typesPkg.getOrderedSetType( this.connection );
        Association elementType = this.typesPkg.getACollectionTypesElementType( ).refMetaObject( );

        OrderedSetTypeImpl expression;
        if ( this.mmImportMode ) {
            expression = (OrderedSetTypeImpl) classProxy.refCreateInstance( this.connection, null );
            expression.setRoot( this.connection, true );
            expression.setLeaf( this.connection, true );
            expression.setName( this.connection, name );
            expression.setAnnotation( this.connection, OclConstants.EMPTY );
            expression.setVisibility( this.connection, VisibilityKindEnum.PUBLIC_VIS );
            expression.setElementType( this.connection, type );
            this.addToPartition( expression );
        } else {
            Map<String, Object> values = new HashMap<String, Object>( );
            values.put( OclConstants.F_NAME, name );
            values.put( OclConstants.F_ANNOTATION, OclConstants.EMPTY );
            values.put( OclConstants.F_VISIBILITY, VisibilityKindEnum.PUBLIC_VIS );
            values.put( "isLeaf", Boolean.TRUE ); //$NON-NLS-1$
            values.put( "isRoot", Boolean.TRUE ); //$NON-NLS-1$
            expression = (OrderedSetTypeImpl) this.createRefObject( classProxy, values );
            this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) expression, (SpiPartitionable) type, elementType );
        }

        return expression;
    }

    /**
     * Creates a new LetExp object
     * 
     * @param name the name
     * @param varDecl the variable declaration for which to create the LetExp
     * @param in the in expression
     * @param type the type
     * @return the LetExp
     */
    public LetExp createLetExp( String name, VariableDeclaration varDecl, OclExpression in, Classifier type ) {

        RefClassImpl classProxy = (RefClassImpl) this.expressionsPkg.getLetExp( this.connection );
        Association variableAssoc = this.expressionsPkg.getAVariableLetExp( this.connection ).refMetaObject( );
        Association inAssoc = this.expressionsPkg.getAInLetExp( this.connection ).refMetaObject( );

        LetExpImpl expression;
        if ( this.mmImportMode ) {
            expression = (LetExpImpl) classProxy.refCreateInstance( this.connection, null );
            expression.setName( this.connection, name );
            expression.setVariable( this.connection, varDecl );
            if ( in != null ) {
                expression.setIn( this.connection, in );
            }
            expression.setType( this.connection, type );
            this.addToPartition( expression );
        } else {
            Map<String, Object> values = new HashMap<String, Object>( );
            values.put( OclConstants.F_NAME, name );
            expression = (LetExpImpl) this.createRefObject( classProxy, values );
            this.setType( expression, type );
            this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) varDecl, (SpiPartitionable) expression, variableAssoc );
            if ( in != null ) {
                this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) in, (SpiPartitionable) expression, inAssoc );
            }
        }

        return expression;
    }

    /**
     * @param name constraint name
     * @param annotation annotation
     * @param expression OCL Expression
     * @param evaluationPolicy evaluation policy
     * @return the new constraint
     */
    public OclConstraint createOclConstraint( String name, String annotation, String expression, EvaluationKind evaluationPolicy ) {

        RefClassImpl classProxy = (RefClassImpl) this.connection.getClass( OclConstraint.CLASS_DESCRIPTOR );
        OclConstraintImpl constraint;
        if ( this.mmImportMode ) {
            constraint = (OclConstraintImpl) classProxy.refCreateInstance( this.connection, null );
            constraint.setName( this.connection, name );
            constraint.setAnnotation( this.connection, annotation );
            constraint.setExpression( this.connection, expression );
            constraint.setLanguage( this.connection, "OCL" ); //$NON-NLS-1$
            constraint.setEvaluationPolicy( this.connection, evaluationPolicy );
            this.addToPartition( constraint );
        } else {
            Map<String, Object> values = new HashMap<String, Object>( );
            values.put( OclConstants.F_NAME, name );
            values.put( "expression", expression ); //$NON-NLS-1$
            values.put( "language", "OCL" ); //$NON-NLS-1$ //$NON-NLS-2$
            values.put( "evaluationPolicy", evaluationPolicy ); //$NON-NLS-1$
            constraint = (OclConstraintImpl) this.createRefObject( classProxy, values );
        }
        return constraint;
    }

    /**
     * Creates a new OperationCallExp object
     * 
     * @param type the type of the expression
     * @return a plain OperationCallExp
     */
    OperationCallExp createOperationCallExp( OclExpression source, Operation referredOperation, Classifier type, List<OclExpression> arguments ) {

        RefClassImpl classProxy = (RefClassImpl) this.expressionsPkg.getOperationCallExp( this.connection );
        String name = "OpCallFor" + referredOperation.getName( ); //$NON-NLS-1$

        if ( this.referredOperationAssoc == null ) {
            this.referredOperationAssoc = this.expressionsPkg.getAReferredOperationOperationCallExp( this.connection ).refMetaObject( );
        }

        if ( this.operationArgs == null ) {
            this.operationArgs = this.expressionsPkg.getAParentOperationArguments( this.connection ).refMetaObject( );
        }

        OperationCallExpImpl expression;
        if ( this.mmImportMode ) {
            expression = (OperationCallExpImpl) classProxy.refCreateInstance( this.connection, null );
            expression.setName( this.connection, name );
            expression.setSource( this.connection, source );
            expression.setReferredOperation( this.connection, referredOperation );
            expression.setType( this.connection, type );
            JmiList<OclExpression> args = (JmiList<OclExpression>) expression.getArguments( this.connection );
            args.addAll( this.connection, arguments );
            this.addToPartition( expression );
        } else {
            Map<String, Object> values = new HashMap<String, Object>( );
            values.put( OclConstants.F_NAME, name );
            expression = (OperationCallExpImpl) this.createRefObject( classProxy, values );

            this.setType( expression, type );
            this.setSource( expression, source );

            this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) referredOperation, (SpiPartitionable) expression, this.referredOperationAssoc );

            for ( OclExpression arg : arguments ) {

                this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) expression, (SpiPartitionable) arg, this.operationArgs );
            }
        }

        return expression;
    }

    /**
     * @return the class
     */
    public Classifier getAnyClass( ) {

        return this.oclAny;
    }

    /**
     * @return Returns the oclTypeType.
     */
    public Classifier getOclTypeClass( ) {

        return this.oclType;
    }

    /**
     * @return the "invalid" class
     * @see MoinJmiCreator#getOclInvalidClass()
     */
    public Classifier getOclInvalidClass( ) {

        return this.oclInvalid;
    }

    /**
     * @see MoinJmiCreator#getOclVoidClass()
     * @return the null classifier
     */
    public Classifier getOclVoidClass( ) {

        return this.oclVoid;
    }

    // private Classifier getClassifierFromPartition(String name, RefClass rcls) {
    //
    // try {
    // MofPackageImpl theGeneratedPackage = (MofPackageImpl)
    // this.getOrCreatePackageForGeneratedObjects();
    // JmiList contents = (JmiList)
    // theGeneratedPackage.getContents(this.connection);
    // for (int i = 0, n = contents.size(this.connection); i < n; i++) {
    // Object content = contents.get(this.connection, i);
    // if (content instanceof Classifier) {
    // Classifier vdc = (Classifier) content;
    // if (name.equals(vdc.getName()) && rcls.equals(vdc.refClass())) {
    // return vdc;
    // }
    // }
    // }
    // } catch (IllegalStateException e) {
    // // $JL-EXC$ handled below
    // }
    //
    // if (this.targetPartition != null) {
    // Collection<Partitionable> elements = this.targetPartition.getElements();
    // for (Partitionable element : elements) {
    // if (element instanceof Classifier) {
    // Classifier cls = (Classifier) element;
    // if (name.equals(cls.getName()) && rcls.equals(cls.refClass()))
    // return cls;
    // }
    // }
    //
    // }
    // return null;
    // }

    private CollectionType getCollectionTypeFromPartition( String name, Classifier type ) {

        if ( this.targetPartition != null ) {
            try {
                MofPackageImpl genPkg = (MofPackageImpl) this.getOrCreatePackageForGeneratedObjects( true );
                JmiList<ModelElement> contents = (JmiList<ModelElement>) genPkg.getContents( this.connection );
                for ( int i = 0, n = contents.size( this.connection.getSession( ) ); i < n; i++ ) {
                    Object content = contents.get( this.connection.getSession( ), i );
                    if ( content instanceof CollectionType ) {
                        CollectionType vdc = (CollectionType) content;
                        if ( name.equals( vdc.getName( ) ) && type.equals( ( (CollectionTypeInternal) vdc ).getElementType( this.connection ) ) ) {
                            return vdc;
                        }
                    }
                }
            } catch ( OclManagerException e ) {
                // $JL-EXC$ handled below
            }

            Collection<Partitionable> elements = this.targetPartition.getElements( );
            for ( Partitionable element : elements ) {
                if ( element instanceof CollectionType ) {
                    CollectionType vdc = (CollectionType) element;
                    if ( name.equals( vdc.getName( ) ) && type.equals( ( (CollectionTypeInternal) vdc ).getElementType( this.connection ) ) ) {
                        return vdc;
                    }
                }
            }
        }
        return null;
    }

    private VariableDeclaration getVariableDeclarationFromPartition( String name, Classifier type ) {

        if ( this.targetPartition != null ) {
            if ( this.thisPartitionsVariables.isEmpty( ) ) {
                Collection<Partitionable> contents = this.targetPartition.getElements( );
                for ( Partitionable element : contents ) {
                    if ( element instanceof VariableDeclaration ) {
                        VariableDeclaration vd = (VariableDeclaration) element;

                        String vdName = vd.getName( );

                        if ( vdName.startsWith( "self(" ) || "OclUndefined".equals( vdName ) || OclConstants.VAR_NULL.equals( vdName ) || OclConstants.VAR_INVALID.equals( vdName ) ) { //$NON-NLS-1$//$NON-NLS-2$
                            this.thisPartitionsVariables.put( vdName, vd );
                        }
                    }
                }
            }

            if ( name.startsWith( "self(" ) || "OclUndefined".equals( name ) || OclConstants.VAR_NULL.equals( name ) || OclConstants.VAR_INVALID.equals( name ) ) { //$NON-NLS-1$//$NON-NLS-2$
                if ( this.thisPartitionsVariables.containsKey( name ) ) {
                    VariableDeclarationImpl vd = (VariableDeclarationImpl) this.thisPartitionsVariables.get( name );
                    if ( type.equals( vd.getType( this.connection ) ) ) {
                        return vd;
                    }
                }

            }
        }
        return null;
    }

    /**
     * Creates a Parameter for MOF Operations
     * 
     * @return the parameter
     */
    Parameter createParameter( String name, Classifier type, DirectionKind direction, boolean multiple, boolean ordered, boolean unique ) {

        RefClassImpl classProxy = (RefClassImpl) this.mof.getParameter( this.connection );
        Association typeAssoc = this.connection.getAssociation( IsOfType.ASSOCIATION_DESCRIPTOR ).refMetaObject( );
        ParameterImpl result;

        MultiplicityType mt;
        if ( multiple ) {
            mt = this.connection.getCoreJmiHelper( ).createMultiplicityType( this.connection, 0, -1, ordered, unique );
        } else {
            mt = this.connection.getCoreJmiHelper( ).createMultiplicityType( this.connection, 0, 1, ordered, unique );
        }

        if ( this.mmImportMode ) {
            result = (ParameterImpl) classProxy.refCreateInstance( this.connection, null );
            result.setName( this.connection, name );
            result.setAnnotation( this.connection, OclConstants.EMPTY );
            result.setType( this.connection, type );
            result.setDirection( this.connection, direction );
            result.setMultiplicity( this.connection, mt );
            this.addToPartition( result );
        } else {
            Map<String, Object> values = new HashMap<String, Object>( );
            values.put( OclConstants.F_NAME, name );
            values.put( OclConstants.F_ANNOTATION, OclConstants.EMPTY );
            values.put( "direction", direction ); //$NON-NLS-1$
            values.put( "multiplicity", mt ); //$NON-NLS-1$
            result = (ParameterImpl) this.createRefObject( classProxy, values );
            this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) type, (SpiPartitionable) result, typeAssoc );
        }

        return result;
    }

    /**
     * Creates a plain Operation
     * 
     * @return a plain Operation
     */
    OperationImpl createOperationInternal( String name, String annotation, boolean asQuery, List<Parameter> parameters, Parameter returnParameter ) {

        RefClassImpl classProxy = (RefClassImpl) this.mof.getOperation( this.connection );
        Association containsAssoc = this.connection.getAssociation( Contains.ASSOCIATION_DESCRIPTOR ).refMetaObject( );

        OperationImpl o;
        if ( this.mmImportMode ) {
            o = (OperationImpl) classProxy.refCreateInstance( this.connection, null );
            o.setName( this.connection, name );
            o.setAnnotation( this.connection, annotation );
            o.setScope( this.connection, ScopeKindEnum.INSTANCE_LEVEL );
            o.setVisibility( this.connection, VisibilityKindEnum.PUBLIC_VIS );
            o.setQuery( this.connection, asQuery );
            JmiList<ModelElement> content = (JmiList<ModelElement>) o.getContents( this.connection );
            for ( int i = 0; i < parameters.size( ); i++ ) {
                Parameter par = parameters.get( i );
                if ( par.equals( returnParameter ) ) {
                    continue;
                }
                content.add( this.connection, par );
            }
            content.add( this.connection, returnParameter );
            this.addToPartition( o );
        } else {
            Map<String, Object> values = new HashMap<String, Object>( );
            values.put( OclConstants.F_NAME, name );
            values.put( OclConstants.F_ANNOTATION, annotation );
            values.put( "scope", ScopeKindEnum.INSTANCE_LEVEL ); //$NON-NLS-1$
            values.put( OclConstants.F_VISIBILITY, VisibilityKindEnum.PUBLIC_VIS );
            values.put( "isQuery", Boolean.valueOf( asQuery ) ); //$NON-NLS-1$
            o = (OperationImpl) this.createRefObject( classProxy, values );
            for ( int i = 0; i < parameters.size( ); i++ ) {
                Parameter par = parameters.get( i );
                if ( par.equals( returnParameter ) ) {
                    continue;
                }
                this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) o, (SpiPartitionable) par, containsAssoc );
            }
            this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) o, (SpiPartitionable) returnParameter, containsAssoc );
        }

        return o;
    }

    /**
     * Adds the expression representing the body to the helper operation
     * 
     * @param bodyExpression the body expression
     * @param o the helper operation
     */
    public void addBodyToHelper( OclExpression bodyExpression, Operation o ) {

        if ( this.mmImportMode ) {
            OperationBodyDefinitionImpl assoc = (OperationBodyDefinitionImpl) ( (AttachingPackageImpl) this.oclp.getAttaching( this.connection ) ).getOperationBodyDefinition( this.connection );
            assoc.add( this.connection, bodyExpression, o );
        } else {
            Association bodyAssoc = this.connection.getAssociation( OperationBodyDefinition.ASSOCIATION_DESCRIPTOR ).refMetaObject( );
            this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) bodyExpression, (SpiPartitionable) o, bodyAssoc );
        }
    }

    /**
     * @param varDec {@link VariableDeclaration}
     * @param newType {@link Classifier}
     */
    public void changeType( VariableDeclaration varDec, Classifier newType ) {

        if ( this.mmImportMode ) {
            ( (VariableDeclarationInternal) varDec ).setType( this.connection, newType );
        } else {
            Association typeExpAssoc = this.expressionsPkg.getATypeVariableDeclaration( this.connection ).refMetaObject( );
            this.myLinkManager.replaceLogicalLinkMultiplicityOne( this.connection, (CorePartitionable) newType, (CorePartitionable) varDec, typeExpAssoc );
        }
    }

    /**
     * @param let {@link LetExp}
     * @param in {@link OclExpression}
     */
    public void changeIn( LetExp let, OclExpression in ) {

        if ( this.mmImportMode ) {
            ( (LetExpInternal) let ).setIn( this.connection, in );
        } else {
            Association inAssoc = this.expressionsPkg.getAInLetExp( this.connection ).refMetaObject( );
            if ( in != null ) {
                this.myLinkManager.replaceLogicalLinkMultiplicityOne( this.connection, (CorePartitionable) in, (CorePartitionable) let, inAssoc );
            }
        }
    }

    /**
     * @param expression {@link OclExpression}
     * @param newType {@link Classifier}
     */
    public void changeType( OclExpression expression, Classifier newType ) {

        if ( this.mmImportMode ) {
            ( (OclExpressionInternal) expression ).setType( this.connection, newType );
        } else {
            Association typeExp = this.expressionsPkg.getATypeOclExpression( this.connection ).refMetaObject( );
            this.myLinkManager.replaceLogicalLinkMultiplicityOne( this.connection, (CorePartitionable) newType, (CorePartitionable) expression, typeExp );
        }
    }

    Attribute createAttributeInternal( String name, Classifier type ) {

        RefClassImpl classProxy = (RefClassImpl) this.mof.getAttribute( this.connection );
        Association typeAssoc = this.connection.getAssociation( IsOfType.ASSOCIATION_DESCRIPTOR ).refMetaObject( );
        AttributeImpl attribute;
        if ( this.mmImportMode ) {
            attribute = (AttributeImpl) classProxy.refCreateInstance( this.connection, null );
            attribute.setName( this.connection, name );
            attribute.setAnnotation( this.connection, OclConstants.EMPTY );
            attribute.setScope( this.connection, ScopeKindEnum.INSTANCE_LEVEL );
            attribute.setVisibility( this.connection, VisibilityKindEnum.PUBLIC_VIS );
            attribute.setMultiplicity( this.connection, this.connection.getCoreJmiHelper( ).createMultiplicityType( this.connection, 0, -1, false, false ) );
            attribute.setChangeable( this.connection, true );
            attribute.setDerived( this.connection, false );
            attribute.setType( this.connection, type );
            this.addToPartition( attribute );
        } else {
            Map<String, Object> values = new HashMap<String, Object>( );
            values.put( OclConstants.F_NAME, name );
            values.put( OclConstants.F_ANNOTATION, OclConstants.EMPTY );
            values.put( "scope", ScopeKindEnum.INSTANCE_LEVEL ); //$NON-NLS-1$
            values.put( OclConstants.F_VISIBILITY, VisibilityKindEnum.PUBLIC_VIS );
            values.put( "multiplicity", this.connection.getCoreJmiHelper( ).createMultiplicityType( this.connection, 0, -1, false, false ) ); //$NON-NLS-1$
            values.put( "isChangeable", Boolean.TRUE ); //$NON-NLS-1$
            values.put( "isDerived", Boolean.FALSE ); //$NON-NLS-1$
            attribute = (AttributeImpl) this.createRefObject( classProxy, values );
            this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) type, (SpiPartitionable) attribute, typeAssoc );
        }
        return attribute;
    }

    /**
     * Convenience routine for checking validity of method arguments.
     * Essentially checks (as the name hopefully applies) whether the argument
     * is NOT equal to some other reference object.
     * 
     * @param arg the argument to be checked
     * @param other the reference object against which equality is checked
     * @param errMsg the error message (id) used in OclSemanticException
     * @throws OclSemanticException if arg is equal to the reference object with
     * the error message identified by errMsg
     */
    void assertArgEquals( Object arg, Object other, MoinLocalizedString errMsg ) throws OclSemanticException {

        if ( arg == null || !arg.equals( other ) ) {
            throw new OclSemanticException( errMsg );
        }
    }

    /**
     * Convenience routine for checking validity of method arguments.
     * Essentially checks (as the name hopefully applies) whether the argument
     * is an instance of a class.
     * 
     * @param instance the instance to be checked
     * @param clazz the reference class against which the instance is checked
     * @param errMsg the error message (id) used in OclSemanticException
     * @throws OclSemanticException if instance is not an instance of the
     * reference class with the error message identified by errMsg
     */
    @SuppressWarnings( "unchecked" )
    // the clazz parameter should be unchecked
    void assertIsInstanceOf( Object instance, Class clazz, MoinLocalizedString errMsg ) throws OclSemanticException {

        if ( !clazz.isInstance( instance ) ) {
            throw new OclSemanticException( errMsg );
        }
    }

    /**
     * Convenience routine for checking validity of method arguments.
     * Essentially checks (as the name hopefully applies) whether the argument
     * is equal to some other reference object.
     * 
     * @param arg the argument to be checked
     * @param other the reference object against which equality is checked
     * @param errMsg the error message (id) used in OclSemanticException
     * @throws OclSemanticException if arg is not equal to the reference object
     * with the error message identified by errMsg
     */
    void assertArgNotEquals( Object arg, Object other, MoinLocalizedString errMsg ) throws OclSemanticException {

        if ( arg == null || arg.equals( other ) ) {
            throw new OclSemanticException( errMsg );
        }
    }

    /**
     * Convenience routine for checking validity of method arguments.
     * Essentially checks (as the name hopefully applies) whether the string
     * argument is not <code>empty</code>.
     * 
     * @param s the string to be checked
     * @param errMsg the error message (id) used in OclSemanticException
     * @throws OclSemanticException if s is empty with the error message
     * identified by errMsg
     */
    void assertStringNotEmpty( String s, MoinLocalizedString errMsg ) throws OclSemanticException {

        if ( s == null || OclConstants.EMPTY.equals( s ) ) {
            throw new OclSemanticException( errMsg );
        }
    }

    /**
     * Convenience routine for checking validity of method arguments.
     * Essentially checks (as the name hopefully applies) whether the argument
     * is not <code>null</code>.
     * 
     * @param arg the argument to be checked
     * @param errMsg the error message (id) used in OclSemanticException
     * @throws OclSemanticException if arg is <code>null</code> with the error
     * message identified by errMsg
     */
    void assertArgNotNull( Object arg, MoinLocalizedString errMsg ) throws OclSemanticException {

        if ( arg == null ) {
            throw new OclSemanticException( errMsg );
        }
    }

    /**
     * {@link MoinJmiCreator}
     * 
     * @param typeName type name
     * @param operationName operatio name
     * @return the standard library operation
     * @throws OclSemanticException Exception
     */
    public Operation getStdLibraryOperation( String typeName, String operationName ) throws OclSemanticException {

        Operation op;
        Map<String, Operation> mapping = this.stdLibraryOps.get( typeName );
        if ( mapping == null ) {
            MofPackageImpl mp = (MofPackageImpl) this.stdLibpck.refMetaObject( );
            JmiList<ModelElement> contents = (JmiList<ModelElement>) mp.getContents( this.connection );
            MofClassInternal cls = null;
            for ( int i = 0, n = contents.size( this.connection.getSession( ) ); i < n; i++ ) {
                Object contentObject = contents.get( this.connection.getSession( ), i );
                if ( contentObject instanceof MofClass ) {
                    cls = (MofClassInternal) contentObject;
                    if ( typeName.equals( cls.getName( ) ) ) {
                        break;
                    }
                    cls = null;
                }
            }
            if ( cls == null ) {
                throw new OclSemanticException( JmiCreatorMessages.JMICREATOR_0301, typeName );
            }
            mapping = new HashMap<String, Operation>( );
            this.stdLibraryOps.put( typeName, mapping );
            JmiList<ModelElement> features = (JmiList<ModelElement>) cls.getContents( this.connection );
            for ( int i = 0, n = features.size( this.connection.getSession( ) ); i < n; i++ ) {
                Object feature = features.get( this.connection.getSession( ), i );
                if ( feature instanceof Operation ) {
                    Operation testop = (Operation) feature;
                    mapping.put( testop.getName( ), testop );
                }
            }
            op = mapping.get( operationName );
        } else {
            op = mapping.get( operationName );
        }
        if ( op == null ) {
            throw new OclSemanticException( JmiCreatorMessages.JMICREATOR_0300, operationName, typeName );
        }
        return op;
    }

    /**
     * Metamodels are enriched with the parsed constraints; the generated JMI
     * objects are added to a generated package
     * 
     * @param createIfNotFound <code>true</code> if it should be created
     * @return the generated package
     * @throws OclManagerException Exception
     * @throws IllegalStateException Exception
     */
    public MofPackage getOrCreatePackageForGeneratedObjects( boolean createIfNotFound ) throws OclManagerException {

        if ( this.generatedPackage == null ) {

            StringBuilder sb = new StringBuilder( );
            sb.append( OclConstants.OCLGENERATED );
            sb.append( '_' );

            StringBuilder hashable = new StringBuilder( );
            hashable.append( this.targetPartition.getPri( ).getContainerName( ) );
            hashable.append( '_' );
            hashable.append( this.targetPartition.getPri( ).getPartitionName( ) );

            Utilities utils = Utilities.getUtilities( );
            byte[] hash = utils.calculateSHA1HashUtf8( hashable.toString( ) );
            String hashed = utils.byteArrayToString( hash ).substring( 2 );

            sb.append( hashed );
            String packageName = sb.toString( );

            for ( Object element : this.targetPartition.getElements( ) ) {
                if ( element instanceof MofPackage && ( (MofPackage) element ).getName( ).equals( packageName ) ) {
                    this.generatedPackage = (MofPackageImpl) element;
                }
            }

            if ( this.generatedPackage == null && createIfNotFound ) {

                if ( this.mmImportMode ) {
                    this.generatedPackage = (MofPackageImpl) ( (RefClassImpl) this.mof.getMofPackage( this.connection ) ).refCreateInstance( this.connection, null );
                    this.generatedPackage.setName( this.connection, packageName );
                    this.generatedPackage.setAnnotation( this.connection, "This holds the OCL generated stuff for partition " + hashable.toString( ) ); //$NON-NLS-1$
                    this.generatedPackage.setRoot( this.connection, true );
                    this.generatedPackage.setLeaf( this.connection, true );
                    this.generatedPackage.setAbstract( this.connection, false );
                    this.generatedPackage.setVisibility( this.connection, VisibilityKindEnum.PUBLIC_VIS );
                    ( (PartitionableImpl) this.generatedPackage ).assign___Partition( this.connection, this.targetPartition );
                } else {
                    RefClassImpl proxy = (RefClassImpl) this.mof.getMofPackage( this.connection );
                    Map<String, Object> values = new HashMap<String, Object>( );
                    values.put( OclConstants.F_NAME, packageName );
                    values.put( OclConstants.F_ANNOTATION, "This holds the OCL generated stuff for partition " + hashable.toString( ) ); //$NON-NLS-1$
                    values.put( "isRoot", Boolean.TRUE ); //$NON-NLS-1$
                    values.put( "isLeaf", Boolean.TRUE ); //$NON-NLS-1$
                    values.put( "isAbstract", Boolean.FALSE ); //$NON-NLS-1$
                    values.put( OclConstants.F_VISIBILITY, VisibilityKindEnum.PUBLIC_VIS );

                    this.generatedPackage = (MofPackageImpl) this.createRefObject( proxy, values );
                }

                Vector<String> values = new Vector<String>( );
                values.add( "com.sap.tc.moin.ocl.gen" ); //$NON-NLS-1$

                this.createTag( "packagePrefix", "", "javax.jmi.packagePrefix", values ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

            }

            if ( this.generatedPackage == null && createIfNotFound ) {
                throw new OclManagerException( OclUtilExceptions.FAILEDTOCREATEPACKAGEFORGENOBJECT );
            }
        }
        return this.generatedPackage;
    }

    private void createTag( String name, String annotation, String id, List<String> values ) {

        if ( this.mmImportMode ) {
            TagImpl tag = (TagImpl) ( (RefClassImpl) this.mof.getTag( this.connection ) ).refCreateInstance( this.connection, null );
            tag.setName( this.connection, name );
            tag.setAnnotation( this.connection, annotation );
            tag.setTagId( this.connection, id );
            ( (MultiValuedAttributesList<String>) ( (TagInternal) tag ).getValues( this.connection ) ).addAll( this.connection, values );
            ( (JmiList<ModelElement>) tag.getElements( this.connection ) ).add( this.connection, this.generatedPackage );
            tag.setContainer( this.connection, this.generatedPackage );
        } else {
            RefClassImpl classProxy = (RefClassImpl) this.mof.getTag( this.connection );
            Association containsAssoc = this.mof.getContains( this.connection ).refMetaObject( );
            Association attachesToAssoc = this.mof.getAttachesTo( this.connection ).refMetaObject( );
            Map<String, Object> refValues = new HashMap<String, Object>( );
            refValues.put( "name", name ); //$NON-NLS-1$
            refValues.put( OclConstants.F_ANNOTATION, annotation );
            refValues.put( "tagId", id ); //$NON-NLS-1$
            refValues.put( "values", values ); //$NON-NLS-1$
            Tag tag = (Tag) this.createRefObject( classProxy, refValues );
            this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) this.generatedPackage, (SpiPartitionable) tag, attachesToAssoc );
            this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) this.generatedPackage, (SpiPartitionable) tag, containsAssoc );

        }

    }

    private void setType( OclExpression expression, Classifier type ) {

        if ( this.oclExpressionType == null ) {
            this.oclExpressionType = this.expressionsPkg.getATypeOclExpression( this.connection ).refMetaObject( );
        }
        this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) type, (SpiPartitionable) expression, this.oclExpressionType );
    }

    private void setSource( OclExpression expression, OclExpression source ) {

        if ( this.sourceExpression == null ) {
            this.sourceExpression = this.expressionsPkg.getAAppliedPropertySource( this.connection ).refMetaObject( );
        }
        this.myLinkManager.loadLink( this.connection.getSession( ), (SpiPartitionable) expression, (SpiPartitionable) source, this.sourceExpression );
    }

    public static List<String> getPath(String oclClassName) {
	ProcessReportImpl report = new ProcessReportImpl(1);
	OclLexerGen oclLexer = new OclLexerGen(oclClassName.toCharArray(), "OCL", report, 4); //$NON-NLS-1$
	// create the parser
	OclParserGen oclParser = new OclParserGen(oclLexer, report);
	oclLexer.lexer(oclParser);
	return OclEditorServiceImpl.getPath(oclParser, 1);
    }

    /**
     * This auxiliary method extends the qualified name with a provided package
     */
    public static List<String> qualifiedName(List<String> pathName, RefPackage pkg ) {
        if ( pathName == null || pkg == null ) {
            return null;
        }
        MofPackage metaObj = pkg.refMetaObject( );
        int pathLen = pathName.size( );
        List<String> pkgName = metaObj.getQualifiedName();
        int pkgLen = pkgName.size( );
        String pkgLastPart = pkgName.get( pkgLen - 1 );
        List<String> qName = new ArrayList<String>( );
        qName.addAll( pkgName );
        int match;
        for ( match = 0; match < pathLen; match++ ) {
            String s = pathName.get( match );
            if ( pkgLastPart.equals( s ) ) {
                break;
            }
        }
        if ( match == pathLen ) {
            qName.addAll( pathName );
        } else {
            qName.addAll( pathName.subList( match + 1, pathLen ) );
        }
        return qName;
    }

    public static ModelElement findModelElementRecursive(CoreConnection connection, List<String> pathName, RefPackage searchPackage) {
	CoreQualifiedNameFinderImpl finder = new CoreQualifiedNameFinderImpl(connection.getCoreJmiHelper(), connection.getSession());
	return findModelElementRecursive(finder, pathName, searchPackage);
    }
    
    public static ModelElement findModelElementRecursive(Connection connection, List<String> pathName, RefPackage searchPackage) {
	QualifiedNameFinderImpl finder = new QualifiedNameFinderImpl(connection.getJmiHelper());
	return findModelElementRecursive(finder, pathName, searchPackage);

    }
    
    private static ModelElement findModelElementRecursive(QualifiedNameFinder finder,
	    List<String> pathName, RefPackage searchPackage) {
	// first redefine the path name
        List<String> fullPathName = qualifiedName(pathName, searchPackage);
        // go and get it
        ModelElement me = finder.findElementByQualifiedName(fullPathName, searchPackage.refOutermostPackage( ) );
        if ( me instanceof Import ) {
            // we do not allow import objects to be returned
            return null;
        }
        if ( me != null ) {
            return me;
        }
        Collection<RefPackage> refAllPackages = searchPackage.refAllPackages();
        for ( RefPackage childPackage : refAllPackages ) {
            me = findModelElementRecursive(finder, pathName, childPackage);
            if ( me != null ) {
                break;
            }
        }
        return me;
    }

    /**
     * Looks up a ModelElement by its qualified name.
     * 
     * @param pathName the qualified name (may be fully qualified)
     * @return the ModelElement identified by the fully qualified name
     * <tt>pathName</tt>
     */
    public static ModelElement lookupModelElementByPathName(Connection connection,
	    List<String> pathName, Collection<RefPackage> packagesForLookup) {
	ModelElement me = null;
	for (Iterator<RefPackage> i=packagesForLookup.iterator(); i.hasNext() && me==null; ) {
	    me = findModelElementRecursive(connection, pathName, i.next());
	}
        return me;
    }
}

package com.sap.tc.moin.ocl.utils.jmi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.DirectionKindEnum;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;
import com.sap.tc.moin.repository.mmi.model.NameNotFoundException;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.Parameter;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.model.ScopeKindEnum;
import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.AttributeImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.AttributeInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.MofPackageImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.MofPackageInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.NamespaceInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.OperationImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.OperationInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ParameterImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.ParameterInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.StructureFieldImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.StructureTypeInternal;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import org.omg.ocl.OclPackage;
import org.omg.ocl.expressions.AssociationEndCallExp;
import org.omg.ocl.expressions.AttributeCallExp;
import org.omg.ocl.expressions.CollectionItem;
import org.omg.ocl.expressions.CollectionLiteralExp;
import org.omg.ocl.expressions.CollectionLiteralPart;
import org.omg.ocl.expressions.CollectionRange;
import org.omg.ocl.expressions.IfExp;
import org.omg.ocl.expressions.IntegerLiteralExp;
import org.omg.ocl.expressions.IterateExp;
import org.omg.ocl.expressions.IteratorExp;
import org.omg.ocl.expressions.LetExp;
import org.omg.ocl.expressions.OclExpression;
import org.omg.ocl.expressions.OperationCallExp;
import org.omg.ocl.expressions.RealLiteralExp;
import org.omg.ocl.expressions.TupleLiteralExp;
import org.omg.ocl.expressions.TypeExp;
import org.omg.ocl.expressions.VariableDeclaration;
import org.omg.ocl.expressions.VariableExp;
import org.omg.ocl.expressions.__impl.AssociationEndCallExpInternal;
import org.omg.ocl.expressions.__impl.AttributeCallExpImpl;
import org.omg.ocl.expressions.__impl.IteratorExpImpl;
import org.omg.ocl.expressions.__impl.OclExpressionInternal;
import org.omg.ocl.expressions.__impl.TypeExpImpl;
import org.omg.ocl.expressions.__impl.TypeExpInternal;
import org.omg.ocl.expressions.__impl.VariableDeclarationImpl;
import org.omg.ocl.expressions.__impl.VariableDeclarationInternal;
import org.omg.ocl.types.BagType;
import org.omg.ocl.types.CollectionType;
import org.omg.ocl.types.OrderedSetType;
import org.omg.ocl.types.SequenceType;
import org.omg.ocl.types.SetType;
import org.omg.ocl.types.TupleType;
import org.omg.ocl.types.__impl.CollectionTypeInternal;
import org.omg.ocl.types.__impl.TupleTypeImpl;

import com.sap.tc.moin.MoinPackage;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.repository.InvalidResourceIdentifierException;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.jmi.util.MoinMetamodelCode;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.mmi.descriptors.PackageDescriptor;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;

/**
 * This class is used by the OCL components to create JMI objects.
 * <p>
 * It should be the only way to obtain instances of JMI-classes. When creating
 * new instances some basic sanity checks are done, however, more time-consuming
 * checks (like type conformity and whether operations, attribute access or
 * navigation is applicable to the type at hand) are left to the user.
 */
public class JmiCreator extends OclHelper implements MoinJmiCreator {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_CORE_OCL_PARSER, JmiCreator.class );

    /**
     * We want to avoid navigations in the meta model when creating collections.
     * Thus, we cache which collection types have been created for which
     * classifier. Since there are only 4 different collection types, we use an
     * array of hash maps and index them via the type of the collection.
     */
    private static final int COLLECTION_TYPE_SET = 0;

    private static final int COLLECTION_TYPE_BAG = 1;

    private static final int COLLECTION_TYPE_SEQUENCE = 2;

    private static final int COLLECTION_TYPE_ORDERED_SET = 3;

    private final Map<Classifier, CollectionType> collectionBagCache = new HashMap<Classifier, CollectionType>( );

    private final Map<Classifier, CollectionType> collectionSetCache = new HashMap<Classifier, CollectionType>( );

    private final Map<Classifier, CollectionType> collectionSequenceCache = new HashMap<Classifier, CollectionType>( );

    private final Map<Classifier, CollectionType> collectionOrderedSetCache = new HashMap<Classifier, CollectionType>( );

    private final Namespace oclStdLibPkg;

    /**
     * Creates a new JMICreator
     * <p>
     * The created objects will be stored in the MetamodelWorkspace in the
     * ExtentPartition
     * 
     * @param actConnection the current connection
     * @throws OclManagerException for example, some packages are not found
     */
    public JmiCreator( CoreConnection actConnection ) throws OclManagerException {

        this( actConnection, false, null );
    }

    /**
     * Creates a new JMICreator
     * 
     * @param actConnection the current connection
     * @param theImportMode indicates that we are in meta model import mode
     * @param targetPartition the partition for storing the JMI objects
     * @throws OclManagerException for example, some packages are not found
     */
    public JmiCreator( CoreConnection actConnection, boolean theImportMode, ModelPartition targetPartition ) throws OclManagerException {

        super( actConnection, actConnection.getPackage( MoinPackage.PACKAGE_DESCRIPTOR ), theImportMode, targetPartition );
        MofPackageImpl oclMofPkg = (MofPackageImpl) this.getPackage( OclPackage.PACKAGE_DESCRIPTOR ).refMetaObject( );
        try {
            this.oclStdLibPkg = (MofPackage) oclMofPkg.lookupElement( this.connection, OclConstants.P_STDLIBRARY );
        } catch ( NameNotFoundException e1 ) {
            LOGGER.logAndTrace( e1, MoinSeverity.ERROR, JmiCreatorMessages.JMICREATOR_0302 );
            throw new OclManagerException( e1, JmiCreatorMessages.JMICREATOR_0302 );
        } catch ( JmiException e1 ) {
            LOGGER.logAndTrace( e1, MoinSeverity.ERROR, JmiCreatorMessages.JMICREATOR_0302 );
            throw new OclManagerException( e1, JmiCreatorMessages.JMICREATOR_0302 );
        }
    }

    public CoreConnection getConnection( ) {

        return this.connection;
    }

    public CoreSession getSession( ) {

        return this.connection.getSession( );
    }

    /**
     * Creates a <code>@pre</code> operation with source <code>source</code>
     * 
     * @param source the source of the <code>@pre</code> operation.
     * @return a <code>@pre</code> operation
     * @throws OclSemanticException if source == null, source.getType() == null
     * @pre is not allowed after source.
     */
    public OclExpression createAtPre( OclExpression source ) throws OclSemanticException {

        /*
         * -- sanity check on the arguments
         */
        assertArgNotNull( source, JmiCreatorMessages.JMICREATOR_0203 );
        Classifier type = ( (OclExpressionInternal) source ).getType( this.connection );
        assertArgNotNull( type, JmiCreatorMessages.JMICREATOR_0204 );

        // // @pre only allowed after attributes, associationends, and
        // operations.
        // if (!(source instanceof AttributeCallExp
        // || source instanceof AssociationEndCallExp || source instanceof
        // OperationCallExp)) {
        // throw new OclSemanticException(JmiCreatorMessages.JMICREATOR_0205
        // , new String[]{source.getClass().getName()});
        // }
        List<Parameter> emptyParList = Collections.emptyList( );
        Parameter returnPar = createParameter( OclConstants.PAR_RETURN, type, DirectionKindEnum.RETURN_DIR, false, false, false );
        // TODO null right now as owner
        Operation atPreOp = createHelperOperation( null, OclConstants.OP_ATRPRE, emptyParList, returnPar );
        OperationCallExp withAtPre = createOperationCallExp( atPreOp, source );
        return withAtPre;
    }

    /**
     * Creates an Attribute with name <code>name</code> and type
     * <code>type</code>.
     * 
     * @param name the name of the attribute
     * @param type the type of the attribute
     * @return an Attribute object with its name and type set.
     * @throws OclSemanticException if name == null or empty or type == null
     */
    public Attribute createAttribute( String name, Classifier type ) throws OclSemanticException {

        /*
         * -- sanity check on the arguments
         */
        assertStringNotEmpty( name, JmiCreatorMessages.JMICREATOR_0206 );
        assertArgNotNull( type, JmiCreatorMessages.JMICREATOR_0207 );
        Attribute a = this.createAttributeInternal( name, type );
        return a;
    }

    /**
     * Creates an <code>AttributeCallExp</code>.
     * 
     * @param source the source of the <code>AttributeCallExp</code>
     * @param attribute the <code>Attribute</code> to refer to. If the type of
     * the <code>Attribute</code> is a <code>StructureField</code> it will be
     * converted into a <code>TupleType</code>.
     * @return an <code>AttributeCallExp</code> object
     * @throws OclSemanticException
     */
    private AttributeCallExp createAttributeCallExp( OclExpression source, Attribute attribute ) throws OclSemanticException {

        /*
         * For static attributes, source can be null, thus we don't check that
         * here; in fact, MOIN does not support static attributes, though.
         */
        if ( attribute.getScope( ) == ScopeKindEnum.CLASSIFIER_LEVEL ) {
            assertArgNotNull( source, JmiCreatorMessages.JMICREATOR_0208 );
        }
        assertArgNotNull( attribute, JmiCreatorMessages.JMICREATOR_0209 );
        Classifier type = ( (AttributeInternal) attribute ).getType( this.connection );
        assertArgNotNull( type, JmiCreatorMessages.JMICREATOR_0210 );

        Classifier expType;
        if ( type instanceof StructureType ) {
            expType = convertStructureTypeToTupleType( (StructureType) type );
        } else {
            expType = type;
        }

        AttributeCallExpImpl exp = (AttributeCallExpImpl) this.createAttributeCallExp( "AttCallFor" + attribute.getName( ), source, attribute, expType ); //$NON-NLS-1$

        return exp;
    }

    private CollectionType createCollectionType( Classifier elementType, int collectionType ) {

        switch ( collectionType ) {
            case COLLECTION_TYPE_BAG:
                BagType bt = (BagType) this.collectionBagCache.get( elementType );
                if ( bt == null ) {
                    bt = (BagType) this.getCollectionTypeFromType( collectionType, elementType );
                    this.collectionBagCache.put( elementType, bt );
                }
                if ( bt == null ) {
                    bt = this.createBagTypeInternal( elementType );
                    this.collectionBagCache.put( elementType, bt );
                }
                return bt;
            case COLLECTION_TYPE_SET:
                SetType st = (SetType) this.collectionSetCache.get( elementType );
                if ( st == null ) {
                    st = (SetType) this.getCollectionTypeFromType( collectionType, elementType );
                    this.collectionSetCache.put( elementType, st );
                }
                if ( st == null ) {
                    st = this.createSetTypeInternal( elementType );

                    this.collectionSetCache.put( elementType, st );
                }
                return st;

            case COLLECTION_TYPE_SEQUENCE:
                SequenceType seqt = (SequenceType) this.collectionSequenceCache.get( elementType );
                if ( seqt == null ) {
                    seqt = (SequenceType) this.getCollectionTypeFromType( collectionType, elementType );
                    this.collectionSequenceCache.put( elementType, seqt );
                }
                if ( seqt == null ) {
                    seqt = this.createSequenceTypeInternal( elementType );
                    this.collectionSequenceCache.put( elementType, seqt );
                }
                return seqt;

            case COLLECTION_TYPE_ORDERED_SET:
                OrderedSetType ost = (OrderedSetType) this.collectionOrderedSetCache.get( elementType );
                if ( ost == null ) {
                    ost = (OrderedSetType) this.getCollectionTypeFromType( collectionType, elementType );
                    this.collectionOrderedSetCache.put( elementType, ost );
                }
                if ( ost == null ) {
                    ost = createOrderedSetTypeInternal( elementType );
                    this.collectionOrderedSetCache.put( elementType, ost );
                }
                return ost;

            default:
                return null;
        }
    }

    /**
     * Creates or looks up a <code>BagType</code> of <code>elementType</code>.
     * It uses a hash to lookup used BagTypes by this JMICreator. If no suitable
     * BagType can be found it tries to find one already stored in MMR. If none
     * can be found a new <code>BagType(elementType)</code> will be created.
     * 
     * @param elementType the element type of the Bag
     * @return a <code>BagType</code> with <code>elementType</code> set to
     * <code>elementType</code>
     */
    public BagType createBagType( Classifier elementType ) {

        return (BagType) createCollectionType( elementType, COLLECTION_TYPE_BAG );
    }

    /**
     * Creates a CollectionItem
     * 
     * @param itemExp the expression
     * @return a CollectionItem object
     * @throws OclSemanticException if itemExp == null or itemExp.getType() ==
     * null
     */
    public CollectionItem createCollectionItem( OclExpression itemExp ) throws OclSemanticException {

        /*
         * -- sanity checks
         */
        assertArgNotNull( itemExp, JmiCreatorMessages.JMICREATOR_0211 );
        Classifier itemType = ( (OclExpressionInternal) itemExp ).getType( this.connection );
        assertArgNotNull( itemType, JmiCreatorMessages.JMICREATOR_0212 );

        return this.createCollectionItem( itemExp, itemType );

    }

    /**
     * Creates a <code>CollectionLiteralExp</code>.
     * 
     * @param colType the type of the collection
     * @param collectionParts a List of <code>CollectionLiteralParts</code>
     * @return a <code>CollectionLiteralExp</code> object
     * @throws OclSemanticException if colType == null or other elements than
     * CollectionLiteralParts are in collectionParts
     */
    public CollectionLiteralExp createCollectionLiteralExp( CollectionType colType, List<CollectionLiteralPart> collectionParts ) throws OclSemanticException {

        /*
         * -- sanity checks
         */
        assertArgNotNull( colType, JmiCreatorMessages.JMICREATOR_0213 );
        assertArgNotNull( collectionParts, JmiCreatorMessages.JMICREATOR_0214 );

        return this.createCollectionLiteralExpInternal( colType, collectionParts );

    }

    /**
     * Creates a <code>CollectionRange</code>.
     * 
     * @param first the <code>OclExpression</code> representing the start of the
     * range
     * @param last the <code>OclExpression</code> representing the end of the
     * range
     * @param rangeType the type of the range
     * @return a <code>CollectionRange</code> object
     * @throws OclSemanticException if first == null or last == null
     */
    public CollectionRange createCollectionRange( OclExpression first, OclExpression last, Classifier rangeType ) throws OclSemanticException {

        /*
         * -- sanity checks
         */
        assertArgNotNull( first, JmiCreatorMessages.JMICREATOR_0216 );
        assertArgNotNull( last, JmiCreatorMessages.JMICREATOR_0217 );

        return this.createCollectionRangeInternal( first, last, rangeType );

    }

    /**
     * creates a new IfExp object and sets the following attributes:
     * <code>condition</code>,<code>thenExpression</code>,
     * <code>elseExpression</code> and <code>type</code>.
     * 
     * @param type the type of the if expression
     * @param elseExp the else expression
     * @param thenExp the then expression
     * @param condExp the condition. Must be of type boolean
     * @return an if expression with the before mentioned attributes set.
     * @throws OclSemanticException if the condition expression is not of type
     * boolean
     */
    public IfExp createIfExp( OclExpression condExp, OclExpression thenExp, OclExpression elseExp, Classifier type ) throws OclSemanticException {

        /*
         * -- sanity checks
         */
        assertArgNotNull( condExp, JmiCreatorMessages.JMICREATOR_0220 );
        assertArgNotNull( thenExp, JmiCreatorMessages.JMICREATOR_0221 );
        assertArgNotNull( elseExp, JmiCreatorMessages.JMICREATOR_0222 );
        assertArgNotNull( type, JmiCreatorMessages.JMICREATOR_0223 );
        assertArgEquals( ( (OclExpressionInternal) condExp ).getType( this.connection ), this.getBoolClass( ), JmiCreatorMessages.JMICREATOR_0224 );

        return this.createIfExp( "IfExpFor" + type.getName( ), condExp, thenExp, elseExp, type ); //$NON-NLS-1$
    }

    /**
     * Creates a <code>IntegerLiteralExp</code>.
     * 
     * @param lit the String representation of the integer number e.g. "42".
     * <code>Integer.parseInt(lit)</code> must not fail!.
     * @return a <code>IntegerLiteralExp</code> with its integerLiteral set to
     * <code>lit</code>
     * @throws OclSemanticException if <code>Integer.parseInt(lit)</code> fails.
     */
    public IntegerLiteralExp createIntegerLiteralExp( String lit ) throws OclSemanticException {

        Integer value;
        try {
            value = Integer.valueOf( lit );
        } catch ( NumberFormatException e ) {
            throw new OclSemanticException( JmiCreatorMessages.JMICREATOR_0225 );
        }
        return this.createIntegerLiteralExp( "IntegerLitFor" + lit, value ); //$NON-NLS-1$
    }

    /**
     * Creates a new LetExp with its mendatory attributes
     * 
     * @param in the in expression
     * @param varDecl the variable declaration
     * @return a <code>LetExp</code> with in set to <code>in</code> and variable
     * set to <code>varDecl</code>
     * @throws OclSemanticException if in == null, varDecl == null or
     * varDecl.getInit() == null
     */
    public LetExp createLetExp( OclExpression in, VariableDeclaration varDecl ) throws OclSemanticException {

        /*
         * -- sanity checks
         */
        assertArgNotNull( in, JmiCreatorMessages.JMICREATOR_0226 );
        assertArgNotNull( varDecl, JmiCreatorMessages.JMICREATOR_0227 );
        assertArgNotNull( ( (VariableDeclarationInternal) varDecl ).getInitExpression( this.connection ), JmiCreatorMessages.JMICREATOR_0228 );
        Classifier type = ( (OclExpressionInternal) in ).getType( this.connection );
        assertArgNotNull( type, JmiCreatorMessages.JMICREATOR_0229 );

        return this.createLetExp( "LetExpFor" + varDecl.getName( ), varDecl, in, type ); //$NON-NLS-1$

    }

    public LetExp createLetExp( VariableDeclaration varDecl ) {

        return this.createLetExp( "LetExpFor" + varDecl.getName( ), varDecl, null, ( (VariableDeclarationInternal) varDecl ).getType( this.connection ) ); //$NON-NLS-1$
    }

    /**
     * Creates an <code>OperationCallExp</code>
     * 
     * @param op the referred <code>Operation</code>
     * @param source the source of the <code>OperationCallExp</code>
     * @return a <code>OperationCallExp</code> refering to operation
     * <code>op</code> and source <code>source</code>
     * @throws OclSemanticException if op == null, source == null or op does not
     * have a return type
     */
    public OperationCallExp createOperationCallExp( Operation op, OclExpression source ) throws OclSemanticException {

        /*
         * -- sanity checks
         */
        assertArgNotNull( op, JmiCreatorMessages.JMICREATOR_0233 );
        Classifier returnType = getReturnType( source, op, null, null );
        assertArgNotEquals( returnType, this.getOclInvalidClass( ), JmiCreatorMessages.JMICREATOR_0235 );

        /*
         * source can be null if operation is static
         */
        if ( op.getScope( ) == ScopeKindEnum.CLASSIFIER_LEVEL ) {
            assertArgNotNull( source, JmiCreatorMessages.JMICREATOR_0234 );
        }
        return this.createOperationCallExp( source, op, returnType, new ArrayList<OclExpression>( ) );
    }

    /**
     * Creates an <code>OperationCallExp</code>.
     * 
     * @param op the MOF Operation
     * @param source source expression
     * @param arguments operation arguments
     * @return an <code>OperationCallExp</code> object
     * @throws OclSemanticException upon a sementic error
     */
    public OperationCallExp createOperationCallExp( Operation op, OclExpression source, List<OclExpression> arguments ) throws OclSemanticException {

        /*
         * -- sanity checks
         */
        assertArgNotNull( op, JmiCreatorMessages.JMICREATOR_0233 );
        assertArgNotNull( arguments, JmiCreatorMessages.JMICREATOR_0236 );
        for ( Iterator<OclExpression> i = arguments.iterator( ); i.hasNext( ); ) {
            OclExpression exp = i.next( );
            assertArgNotNull( ( (OclExpressionInternal) exp ).getType( this.connection ), JmiCreatorMessages.JMICREATOR_0238 );
        }
        // TODO refactor this chaos
        OperationCallExp exp = null;
        if ( arguments.size( ) == 2 ) {
            Classifier returnType = getReturnType( source, op, arguments.get( 0 ), arguments.get( 1 ) );
            exp = this.createOperationCallExp( source, op, returnType, arguments );
        } else if ( arguments.size( ) == 1 ) {
            exp = this.createOperationCallExp( op, source, arguments.get( 0 ) );
        } else if ( arguments.size( ) == 0 ) {
            exp = this.createOperationCallExp( op, source );
        } else {
            Classifier returnType = getReturnType( op );
            exp = this.createOperationCallExp( source, op, returnType, arguments );
        }

        return exp;

    }

    /**
     * Creates an <code>OperationCallExp</code>
     * 
     * @param op the referred <code>Operation</code>
     * @param source the source of the <code>OperationCallExp</code>
     * @param arg1 the <code>OclExpression</code> representing the first
     * argument
     * @return a <code>OperationCallExp</code> referring to operation
     * <code>op</code> and source <code>source</code> with argument
     * <code>arg1</code>
     * @throws OclSemanticException upon a semantic error
     */
    public OperationCallExp createOperationCallExp( Operation op, OclExpression source, OclExpression arg1 ) throws OclSemanticException {

        /*
         * -- sanity checks
         */
        assertArgNotNull( op, JmiCreatorMessages.JMICREATOR_0233 );
        assertArgNotNull( arg1, JmiCreatorMessages.JMICREATOR_0238 );

        Classifier returnType = getReturnType( source, op, arg1, null );
        List<OclExpression> args = new ArrayList<OclExpression>( );
        args.add( arg1 );
        return this.createOperationCallExp( source, op, returnType, args );

    }

    /**
     * Creates or looks up a <code>OrderedSetType</code> of
     * <code>elementType</code>. It uses a hash to lookup used
     * <code>OrderedSetType</code> by this JMICreator. If no suiteable
     * <code>OrderedSetType</code> can be found it tries to find one already
     * stored in MMR. If none can be found a new
     * <code>OrderedSetType(elementType)</code> will be created.
     * 
     * @param elementType the element type of the OrderedSetType
     * @return a <code>OrderedSetType</code> with <code>elementType</code> set
     * to <code>elementType</code>
     */
    public OrderedSetType createOrderedSetType( Classifier elementType ) {

        return (OrderedSetType) createCollectionType( elementType, COLLECTION_TYPE_ORDERED_SET );
    }

    /**
     * Creates a OCL type of a parameter. MOF uses <code>MultiplicityType</code>
     * to specify whether an parameter is in fact a Collection. This method
     * returns the type of the parameter which can be a subClass of
     * <code>CollectionType</code> or another <code>Classifier</code>.
     * 
     * @param par the parameter which type has to be determined
     * @return a subclass of <code>CollectionType</code> or another
     * <code>Classifier</code>
     */
    private Classifier createParameterType( Parameter par ) {

        if ( par == null ) {
            return this.getOclInvalidClass( );
        }

        MultiplicityType mt = par.getMultiplicity( );
        Classifier elemType = ( (ParameterInternal) par ).getType( this.connection );

        if ( mt == null ) {
            return elemType;
        }

        /*
         * Got the return parameter, now let's see whether op returns a single
         * value or some sort of collection. For single value, upper
         * multiplicity should be 1.
         */
        if ( mt.getUpper( ) == 1 ) {
            return elemType;
        }

        if ( mt.isOrdered( ) ) {
            if ( mt.isUnique( ) ) {
                /*
                 * ordered && unique --> ordered set
                 */
                return createOrderedSetType( elemType );
            }
            /*
             * ordered && !unique --> sequence
             */
            return createSequenceType( elemType );
        }
        if ( mt.isUnique( ) ) {
            /*
             * !ordered & unique --> set
             */
            return createSetType( elemType );
        }
        /*
         * !ordered && !unique --> bag
         */
        return createBagType( elemType );
    }

    /**
     * Creates a <code>RealLiteralExp</code>.
     * 
     * @param lit the String representation of the real number e.g. "3.14".
     * <code>Double.parseDouble(lit)</code> must not fail!.
     * @return a RealLiteralExp with its RealSymbol set to <code>lit</code>
     * @throws OclSemanticException if <code>Double.parseDouble(lit)</code>
     * fails.
     */
    public RealLiteralExp createRealLiteralExp( String lit ) throws OclSemanticException {

        Double value;
        /*
         * -- sanity check
         */
        try {
            value = Double.valueOf( lit );
        } catch ( NumberFormatException e ) {
            throw new OclSemanticException( JmiCreatorMessages.JMICREATOR_0239 );
        }

        return this.createRealLiteralExp( "RealLitFor" + lit, value ); //$NON-NLS-1$
    }

    /**
     * Creates or looks up a <code>SequenceType</code> of
     * <code>elementType</code>. It uses a hash to lookup used
     * <code>SequenceType</code> by this JMICreator. If no suiteable
     * <code>SequenceType</code> can be found it tries to find one already
     * stored in MMR. If none can be found a new
     * <code>SequenceType(elementType)</code> will be created.
     * 
     * @param elementType the element type of the SequenceType
     * @return a <code>SequenceType</code> with <code>elementType</code> set to
     * <code>elementType</code>
     */
    public SequenceType createSequenceType( Classifier elementType ) {

        return (SequenceType) createCollectionType( elementType, COLLECTION_TYPE_SEQUENCE );
    }

    /**
     * Creates or looks up a <code>SetType</code> of <code>elementType</code>.
     * It uses a hash to lookup used <code>SetType</code> by this JMICreator. If
     * no suitable <code>SetType</code> can be found it tries to find one
     * already stored in MMR. If none can be found a new
     * <code>SetType(elementType)</code> will be created.
     * 
     * @param elementType the element type of the SetType
     * @return a <code>SetType</code> with <code>elementType</code> set to
     * <code>elementType</code>
     */
    public SetType createSetType( Classifier elementType ) {

        return (SetType) createCollectionType( elementType, COLLECTION_TYPE_SET );
    }

    /**
     * Creates a TupleLiteralExp.
     * 
     * @param tupleParts a <code>List</code> of TupleParts
     * @param name the name
     * @return a TupleLiteralExp.
     * @throws OclSemanticException upon a semantic error
     */
    public TupleLiteralExp createTupleLiteralExp( List<VariableDeclaration> tupleParts, String name ) throws OclSemanticException {

        /*
         * -- sanity checks
         */
        assertArgNotNull( tupleParts, JmiCreatorMessages.JMICREATOR_0241 );
        /*
         * -- check for unique names
         */
        checkVariableDeclarations( tupleParts, false, JmiCreatorMessages.JMICREATOR_0243 );
        return createTupleLiteralExpInternal( createTupleType( tupleParts, name ), tupleParts );

    }

    /**
     * Creates a <code>TupleType</code>.
     * 
     * @param varDecls the List of <code>VariableDeclarations</code>
     * representing the TupleParts. Each <code>VariableDeclaration</code> will
     * be turned into an <code>Attribute</code> which will be added to the
     * contents of <code>TupleType</code>
     * @param tupleName the name
     * @return a <code>TupleType</code> object
     * @throws OclSemanticException if varDecl == null or names of tuple parts
     * are not unique
     */
    public TupleType createTupleType( List<VariableDeclaration> varDecls, String tupleName ) throws OclSemanticException {

        /*
         * -- sanity checks
         */
        assertArgNotNull( varDecls, JmiCreatorMessages.JMICREATOR_0241 );

        /*
         * -- check for unique names
         */
        List<Attribute> tupleParts = checkVariableDeclarations( varDecls, true, JmiCreatorMessages.JMICREATOR_0243 );
        /*
         * -- everything safe, build tuple type
         */
        return this.createTupleTypeInternal( tupleParts, tupleName );
    }

    /**
     * Creates a new <code>TypeExp</code> and sets the attribute
     * <code>referredType</code>. Sets the type of <code>TypeExp</code> to
     * <code>MOF Classifier</code>.
     * 
     * @param refType the referredType
     * @return a new <code>TypeExp</code>
     * @throws OclSemanticException if refType == null
     */
    public TypeExp createTypeExp( Classifier refType ) throws OclSemanticException {

        /*
         * -- sanity check
         */
        assertArgNotNull( refType, JmiCreatorMessages.JMICREATOR_0244 );

        return this.createTypeExp( "TypeExpFor" + refType.getName( ), refType ); //$NON-NLS-1$

    }

    /**
     * creates a new VariableDeclaration object and sets the following
     * attributes: <code>varName</code>,<code>type</code>,
     * <code>initExpression</code>
     * 
     * @param varName the name of the variable
     * @param type the type of the variable
     * @param initExp the init expression
     * @return a VariableDeclaration with
     * @throws OclSemanticException if varName == null or type == null
     */
    public VariableDeclaration createVariableDeclaration( String varName, Classifier type, OclExpression initExp ) throws OclSemanticException {

        /*
         * -- sanity checks
         */
        assertArgNotNull( varName, JmiCreatorMessages.JMICREATOR_0245 );
        assertArgNotNull( type, JmiCreatorMessages.JMICREATOR_0246 );

        /*
         * If type is a StructureType, we need to convert it to a TupleType,
         * otherwise we eon't be able to access the structure fields via Jmi.
         */
        Classifier actType = type;
        if ( actType instanceof StructureType ) {
            actType = convertStructureTypeToTupleType( (StructureType) type );
        }

        return this.createVariableDeclarationInternal( varName, actType, initExp );

    }

    /**
     * Creates a <code>VariableExp</code>
     * 
     * @param varDecl the <code>VariableDeclaration</code> to which this
     * <code>VariableExp</code> refers to.
     * @return a <code>VariableExp</code>
     * @throws OclSemanticException if varDecl == null or varDecl.getType() ==
     * null.
     */
    public VariableExp createVariableExp( VariableDeclaration varDecl ) throws OclSemanticException {

        /*
         * -- sanity checks
         */
        assertArgNotNull( varDecl, JmiCreatorMessages.JMICREATOR_0247 );
        Classifier type = ( (VariableDeclarationImpl) varDecl ).getType( this.connection );
        assertArgNotNull( type, JmiCreatorMessages.JMICREATOR_0248 );
        return this.createVariableExp( varDecl, type );

    }

    /**
     * Determines the type of the <code>AssociationEnd</code>. The Type of the
     * <code>AssociationEnd</code> is determined by <code>multiplicity</code>.
     * If the type of <code>AssociationEnd</code> is a
     * <code>StructureField</code> it is turned into a <code>TupleType</code>.
     * 
     * @param assocEnd the <code>AssociationEnd</code>
     * @return a subclass of <code>CollectionType</code> or another
     * <code>Classifier</code>
     * @throws OclSemanticException assocEnd == null or assocEnd.getType() ==
     * null
     */
    private Classifier getTypeOfAssociation( AssociationEnd assocEnd ) throws OclSemanticException {

        /*
         * -- sanity checks
         */
        assertArgNotNull( assocEnd, JmiCreatorMessages.JMICREATOR_0249 );
        Classifier assocType = ( (AssociationEndImpl) assocEnd ).getType( this.connection );
        assertArgNotNull( assocType, JmiCreatorMessages.JMICREATOR_0250 );

        // if the type of the AssociationEnd is a StructureField
        // we have to turn it into a TupleType
        if ( assocType instanceof StructureType ) {
            assocType = convertStructureTypeToTupleType( (StructureType) assocType );
        }

        if ( assocEnd.getMultiplicity( ).getUpper( ) == 1 ) {
            return assocType;
        }
        if ( assocEnd.getMultiplicity( ).isOrdered( ) == true && assocEnd.getMultiplicity( ).isUnique( ) == true ) {
            return this.createOrderedSetType( assocType );
        } else if ( assocEnd.getMultiplicity( ).isOrdered( ) == false && assocEnd.getMultiplicity( ).isUnique( ) == true ) {
            return this.createSetType( assocType );
        } else if ( assocEnd.getMultiplicity( ).isOrdered( ) == true && assocEnd.getMultiplicity( ).isUnique( ) == false ) {
            return this.createSequenceType( assocType );
        } else {
            // if (assEnd.getMultiplicity().isOrdered() == false &&
            // assEnd.getMultiplicity().isUnique() == false) {
            return this.createBagType( assocType );
        }
    }

    /**
     * Creates a any-iterator
     * 
     * @param source the source of the iterator expression
     * @param iter1 the first iterator
     * @param iter2 the second iterator
     * @param body the body of the iterate expression
     * @return a complete IterateExp representing the any-iterator
     * @throws OclSemanticException if <code>iter2 != null</code> or if
     * <code>body.getType()</code> is not of type <code>Boolean</code> if
     * <code>source</code> is not of type <code>CollectionType</code> or if
     * <code>iter1</code> is initialized if type of <code>iter1</code> does not
     * conform to <code>elementType</code> of source collection.
     */

    private IteratorExp createAny( OclExpression source, VariableDeclaration iter1, VariableDeclaration iter2, OclExpression body ) throws OclSemanticException {

        /*
         * -- sanity checks
         */
        assertIteratorIsNull( iter2, "any" ); //$NON-NLS-1$
        assertArgNotNull( source, JmiCreatorMessages.JMICREATOR_0102 );
        assertIteratorBody( body, "any", this.getBoolClass( ).getName( ) ); //$NON-NLS-1$

        return createBasicIterator( "any", ( (CollectionTypeInternal) ( (OclExpressionInternal) source ).getType( this.connection ) ).getElementType( this.connection ), source, iter1, iter2, body ); //$NON-NLS-1$
    }

    /**
     * Sets up a basic iterator.
     * 
     * @param source the source of this IteratorExp
     * @param iter1 The first iteartor variable. If null, an iterator will be
     * defined. If the type of the iterator is invalid the type is set to the
     * element type of source.
     * @param iter2 Will be ignored if null. If not null and type is invalid the
     * type is set to the element type of source.
     * @param body The body of the IteratorExp.
     * @return a complete IterateExp except for name and type.
     * @throws OclSemanticException
     */
    private IteratorExp createBasicIterator( String name, Classifier type, OclExpression source, VariableDeclaration iter1, VariableDeclaration iter2, OclExpression body ) throws OclSemanticException {

        Classifier sourceType;
        /*
         * -- sanity checks
         */
        assertArgNotNull( source, JmiCreatorMessages.JMICREATOR_0102 );
        sourceType = ( (OclExpressionInternal) source ).getType( this.connection );
        assertIsInstanceOf( sourceType, CollectionType.class, JmiCreatorMessages.JMICREATOR_0102 );
        CollectionType colType = (CollectionType) sourceType;
        Classifier elementType = ( (CollectionTypeInternal) colType ).getElementType( this.connection );
        VariableDeclaration actiter1 = checkIterator( iter1, elementType, true, true );
        VariableDeclaration actiter2 = checkIterator( iter2, elementType, true, false );

        Classifier actType;
        if ( type != null ) {
            actType = type;
        } else {
            actType = sourceType;
        }

        return createIteratorExpInternal( name, source, actiter1, actiter2, body, actType );

    }

    /**
     * Creates a collect-iterator
     * 
     * @param source the source of the iterator expression
     * @param iter1 the first iterator
     * @param iter2 the second iterator
     * @param body the body of the iterate expression
     * @return a complete IterateExp representing the collect-iterator
     * @throws OclSemanticException if <code>iter2 != null</code> or if
     * <code>source</code> is not of type <code>CollectionType</code> or if
     * <code>iter1</code> is initialized if type of <code>iter1</code> does not
     * conform to <code>elementType</code> of source collection.
     */
    private IteratorExp createCollect( OclExpression source, VariableDeclaration iter1, VariableDeclaration iter2, OclExpression body ) throws OclSemanticException {

        /*
         * -- sanity check
         */
        assertIteratorIsNull( iter2, "collect" ); //$NON-NLS-1$
        assertArgNotNull( source, JmiCreatorMessages.JMICREATOR_0102 );

        if ( ( (OclExpressionInternal) source ).getType( this.connection ) instanceof SequenceType ) {
            return createBasicIterator( "collect", createSequenceType( innermostType( ( (OclExpressionInternal) body ).getType( this.connection ) ) ), source, iter1, iter2, body ); //$NON-NLS-1$
        }
        return createBasicIterator( "collect", createBagType( innermostType( ( (OclExpressionInternal) body ).getType( this.connection ) ) ), source, iter1, iter2, body ); //$NON-NLS-1$
    }

    /**
     * Creates a collectNested-iterator
     * 
     * @param source the source of the iterator expression
     * @param iter1 the first iterator
     * @param iter2 the second iterator
     * @param body the body of the iterate expression
     * @return a complete IterateExp representing the collectNested-iterator
     * @throws OclSemanticException if <code>iter2 != null</code> or if
     * <code>source</code> is not of type <code>CollectionType</code> or if
     * <code>iter1</code> is initialized if type of <code>iter1</code> does not
     * conform to <code>elementType</code> of source collection.
     */
    private IteratorExp createCollectNested( OclExpression source, VariableDeclaration iter1, VariableDeclaration iter2, OclExpression body ) throws OclSemanticException {

        /*
         * -- sanity check
         */
        assertIteratorIsNull( iter2, "collectNested" ); //$NON-NLS-1$
        assertArgNotNull( source, JmiCreatorMessages.JMICREATOR_0102 );

        // return type is the type of the source
        if ( ( (OclExpressionInternal) source ).getType( this.connection ) instanceof SequenceType ) {
            return createBasicIterator( "collectNested", createSequenceType( ( (OclExpressionInternal) body ).getType( this.connection ) ), source, iter1, iter2, body ); //$NON-NLS-1$
        }
        return createBasicIterator( "collectNested", createBagType( ( (OclExpressionInternal) body ).getType( this.connection ) ), source, iter1, iter2, body ); //$NON-NLS-1$
    }

    /**
     * Creates a exists-iterator
     * 
     * @param source the source of the iterator expression
     * @param iter1 the first iterator
     * @param iter2 the second iterator
     * @param body the body of the iterate expression
     * @return a complete IterateExp representing the exists-iterator
     * @throws OclSemanticException if <code>source</code> is not of type
     * <code>CollectionType</code> or if <code>iter1</code> is initialized if
     * type of <code>iter1</code> or <code>iter2</code> does not conform to
     * <code>elementType</code> of source collection.
     */
    private IteratorExp createExists( OclExpression source, VariableDeclaration iter1, VariableDeclaration iter2, OclExpression body ) throws OclSemanticException {

        /*
         * -- sanity checks
         */
        assertIteratorBody( body, "exists", this.getBoolClass( ).getName( ) ); //$NON-NLS-1$

        return createBasicIterator( "exists", getBoolClass( ), source, iter1, iter2, body ); //$NON-NLS-1$
    }

    /**
     * Creates a forAll-iterator
     * 
     * @param source the source of the iterator expression
     * @param iter1 the first iterator
     * @param iter2 the second iterator
     * @param body the body of the iterate expression
     * @return a complete IterateExp representing the forAll-iterator
     * @throws OclSemanticException if <code>source</code> is not of type
     * <code>CollectionType</code> or if <code>iter1</code> is initialized if
     * type of <code>iter1</code> or <code>iter2</code> does not conform to
     * <code>elementType</code> of source collection.
     */
    private IteratorExp createForAll( OclExpression source, VariableDeclaration iter1, VariableDeclaration iter2, OclExpression body ) throws OclSemanticException {

        /*
         * -- sanity checks
         */
        assertIteratorBody( body, "forAll", this.getBoolClass( ).getName( ) ); //$NON-NLS-1$

        return createBasicIterator( "forAll", getBoolClass( ), source, iter1, iter2, body ); //$NON-NLS-1$
    }

    /**
     * @see MoinJmiCreator#createHelperOperation(RefObject, String, List,
     * Parameter)
     */
    public Operation createHelperOperation( RefObject owner, String name, List<Parameter> parameters, Parameter resultParameter ) {

        OperationImpl o = this.createOperationInternal( name, "OclHelper", true, parameters, resultParameter ); //$NON-NLS-1$

        // this.mofPackage.getOcl().getAttaching().getOperationBodyDefinition().add(bodyExpression,
        // o);
        // if (!this.targetPartitionIsTransient()) {
        // // in the case of transient, we would change the operation's
        // // partition
        // if (owner != null && owner instanceof Namespace) {
        // ((Namespace) owner).getContents().add(o);
        // }
        // }
        return o;
    }

    /**
     * Creates a isUnique-iterator
     * 
     * @param source the source of the iterator expression
     * @param iter1 the first iterator
     * @param iter2 the second iterator
     * @param body the body of the iterate expression
     * @return a complete IterateExp representing the isUnique-iterator
     * @throws OclSemanticException if <code>source</code> is not of type
     * <code>CollectionType</code> or if <code>iter1</code> is initialized if
     * type of <code>iter1</code> does not conform to <code>elementType</code>
     * of source collection.
     */
    private IteratorExp createIsUnique( OclExpression source, VariableDeclaration iter1, VariableDeclaration iter2, OclExpression body ) throws OclSemanticException {

        /*
         * -- sanity checks
         */
        assertIteratorIsNull( iter2, "isUnique" ); //$NON-NLS-1$

        return createBasicIterator( "isUnique", getBoolClass( ), source, iter1, iter2, body ); //$NON-NLS-1$
    }

    /**
     * Creates a IterateExp
     * 
     * @param source the source of the iterate expression
     * @param firstIterator the iterator
     * @param accu the accumulator. Must be initialized.
     * @param secondIterator the second iterator
     * @param body the body of the iterate expression
     * @return a complete IterateExp
     * @throws OclSemanticException if <code>accu == null</code> or if
     * <code>accu</code> is not initialized if <code>body</code> is not of type
     * <code>Boolean</code> if <code>source</code> is not of type
     * <code>CollectionType</code> or if <code>iter</code> is initialized if
     * type of <code>iter1</code> does not conform to <code>elementType</code>
     * of source collection.
     */
    public IterateExp createIterate( OclExpression source, VariableDeclaration firstIterator, VariableDeclaration secondIterator, VariableDeclaration accu, OclExpression body ) throws OclSemanticException {

        /*
         * -- sanity checks
         */
        assertArgNotNull( source, JmiCreatorMessages.JMICREATOR_0109 );
        assertArgNotNull( accu, JmiCreatorMessages.JMICREATOR_0108 );
        Classifier sourceType = ( (OclExpressionInternal) source ).getType( this.connection );
        assertIsInstanceOf( sourceType, CollectionType.class, JmiCreatorMessages.JMICREATOR_0109 );
        CollectionType colType = (CollectionType) sourceType;
        VariableDeclaration iter1 = checkIterator( firstIterator, colType, false, true );
        VariableDeclaration iter2 = checkIterator( secondIterator, colType, false, false );
        /*
         * -- accumulator must be initialized!
         */
        if ( ( (VariableDeclarationInternal) accu ).getInitExpression( this.connection ) == null ) {
            throw new OclSemanticException( JmiCreatorMessages.JMICREATOR_0103, accu.getVarName( ) );
        }

        return createIterateExp( "iterate", ( (VariableDeclarationInternal) accu ).getType( this.connection ), source, accu, body, iter1, iter2 ); //$NON-NLS-1$

    }

    /**
     * Creates a one-iterator
     * 
     * @param source the source of the iterator expression
     * @param iter1 the first iterator
     * @param iter2 the second iterator
     * @param body the body of the iterate expression
     * @return a complete IterateExp representing the one-iterator
     * @throws OclSemanticException if <code>iter2 != null</code> or if
     * <code>body</code> is not of type <code>Boolean</code> if
     * <code>source</code> is not of type <code>CollectionType</code> or if
     * <code>iter1</code> is initialized if type of <code>iter1</code> does not
     * conform to <code>elementType</code> of source collection.
     */
    private IteratorExp createOne( OclExpression source, VariableDeclaration iter1, VariableDeclaration iter2, OclExpression body ) throws OclSemanticException {

        /*
         * -- sanity check
         */
        assertIteratorIsNull( iter2, "one" ); //$NON-NLS-1$
        assertIteratorBody( body, "one", getBoolClass( ).getName( ) ); //$NON-NLS-1$

        return createBasicIterator( "one", getBoolClass( ), source, iter1, iter2, body ); //$NON-NLS-1$
    }

    /**
     * Creates a reject-iterator
     * 
     * @param source the source of the iterator expression
     * @param iter1 the first iterator
     * @param iter2 the second iterator
     * @param body the body of the iterate expression
     * @return a complete IterateExp representing the reject-iterator
     * @throws OclSemanticException if <code>source</code> is not of type
     * <code>CollectionType</code> or if <code>body</code> is not of type
     * <code>Boolean</code> if <code>iter1</code> is initialized if type of
     * <code>iter1</code> does not conform to <code>elementType</code> of source
     * collection.
     */
    private IteratorExp createReject( OclExpression source, VariableDeclaration iter1, VariableDeclaration iter2, OclExpression body ) throws OclSemanticException {

        /*
         * -- sanity check
         */
        assertIteratorIsNull( iter2, "reject" ); //$NON-NLS-1$
        assertIteratorBody( body, "reject", getBoolClass( ).getName( ) ); //$NON-NLS-1$

        /* -- iterator will be typed by source -- */
        return createBasicIterator( "reject", null, source, iter1, iter2, body ); //$NON-NLS-1$
    }

    /**
     * Creates a select-iterator
     * 
     * @param source the source of the iterator expression
     * @param iter1 the first iterator
     * @param iter2 the second iterator
     * @param body the body of the iterate expression
     * @return a complete IterateExp representing the select-Iterator
     * @throws OclSemanticException if <code>iter2 != null</code> or if
     * <code>source</code> is not of type <code>CollectionType</code> or if
     * <code>iter1</code> is initialized if type of <code>iter1</code> does not
     * conform to <code>elementType</code> of source collection.
     */
    private IteratorExp createSelect( OclExpression source, VariableDeclaration iter1, VariableDeclaration iter2, OclExpression body ) throws OclSemanticException {

        /*
         * -- sanity check
         */
        assertIteratorIsNull( iter2, "select" ); //$NON-NLS-1$
        assertIteratorBody( body, "select", getBoolClass( ).getName( ) ); //$NON-NLS-1$

        /* -- iterator will be typed by source -- */
        return createBasicIterator( "select", null, source, iter1, iter2, body ); //$NON-NLS-1$
    }

/**
     * Creates a sortedBy-iterator
     * 
     * @param source the source of the iterator expression
     * @param iter1 the first iterator
     * @param iter2 the second iterator
     * @param body the body of the iterate expression
     * @return a complete IterateExp representing the sortedBy-Iterator
     * @throws OclSemanticException if no '<' is defined on the type of the
     * body or if <code>iter2 != null</code> or if <code>source</code> is
     * not of type <code>CollectionType</code> or if <code>iter1</code> is
     * initialized if type of <code>iter1</code> does not conform to
     * <code>elementType</code> of source collection.
     */
    private IteratorExp createSortedBy( OclExpression source, VariableDeclaration iter1, VariableDeclaration iter2, OclExpression body ) throws OclSemanticException {

        /*
         * -- sanity check
         */
        assertArgNotNull( source, JmiCreatorMessages.JMICREATOR_0109 );
        assertIteratorIsNull( iter2, "sortedBy" ); //$NON-NLS-1$

        Classifier sourceType = ( (OclExpressionInternal) source ).getType( this.connection );
        Classifier elementType = ( (CollectionTypeInternal) sourceType ).getElementType( this.connection );
        if ( sourceType instanceof OrderedSetType ) {
            return createBasicIterator( "sortedBy", createOrderedSetType( elementType ), source, iter1, iter2, body ); //$NON-NLS-1$
        } else if ( sourceType instanceof SetType ) {
            return createBasicIterator( "sortedBy", createOrderedSetType( elementType ), source, iter1, iter2, body ); //$NON-NLS-1$
        } else {
            return createBasicIterator( "sortedBy", createSequenceType( elementType ), source, iter1, iter2, body ); //$NON-NLS-1$
        }
    }

    /**
     * Takes a List of names (i.e. the fully qualified name) and returns a
     * String where each element in <code>pathName</code> is separated by a
     * double colon '::'. E.g. 'myPackage::anotherPackage::Class'
     * 
     * @param pathName
     * @return the path name represented by the List <code>pathName</code>
     */
    private String toPathName( List<String> pathName ) {

        StringBuilder s = new StringBuilder( );
        if ( pathName.size( ) > 0 ) {
            if ( pathName.get( 0 ) != null ) {
                s.append( pathName.get( 0 ) );
            }
            for ( int i = 1; i < pathName.size( ); i++ ) {
                if ( pathName.get( 0 ) != null ) {
                    s.append( OclConstants.PATHSEP );
                    s.append( pathName.get( i ) );
                }
            }
        }
        return s.toString( );
    }

    /**
     * Creates a Parameter for MOF Operations
     * 
     * @param type the type
     * @param paramName the parameter name
     * @return a Parameter with name <code>paramName</code> and type
     * <code>type</code>
     */
    public Parameter createInParameter( String paramName, Classifier type ) {

        return this.createParameter( paramName, type, DirectionKindEnum.IN_DIR, false, false, false );
    }

    /**
     * Creates a new out parameter. Automatically sets <code>direction</code> to
     * <code>OUT_DIR</code>.
     * 
     * @param paramName the name of the parameter
     * @param type tje type of the parameter
     * @return a new out parameter.
     */
    public Parameter createReturnParameter( String paramName, Classifier type ) {

        return this.createParameter( paramName, type, DirectionKindEnum.RETURN_DIR, false, false, false );
    }

    /**
     * Creates an <code>AssociationCallExp</code>
     * 
     * @param source the source of the <code>AssociatonCallExp</code>
     * @param assocEnd the <code>AssociationEnd</code> to refer to
     * @param withAtPre whether assocEnd is marked with atPre
     * @return an <code>AssociationCallExp</code>
     * @throws OclSemanticException
     */
    private AssociationEndCallExp createAssociationCallExp( OclExpression source, AssociationEnd assocEnd, boolean withAtPre ) throws OclSemanticException {

        if ( withAtPre ) {
            // include @pre operation
            return createAssociationCallExp( createAtPre( source ), assocEnd, getTypeOfAssociation( assocEnd ) );
        }
        return createAssociationCallExp( source, assocEnd, getTypeOfAssociation( assocEnd ) );
    }

    /**
     * Creates an <code>AssociationCallExp</code> and includes a collect
     * operation if necessary.
     * 
     * @param source the source of the <code>AssociatonCallExp</code>
     * @param assocEnd the <code>AssociationEnd</code> to refer to
     * @param withAtPre whether assocEnd is marked with atPre
     * @return an <code>AssociationCallExp</code> or a <code>IteratorExp</code>
     * representing a collect if necessary.
     * @throws OclSemanticException upon a semantic error
     */
    public OclExpression createAssociationCallExpExt( OclExpression source, AssociationEnd assocEnd, boolean withAtPre ) throws OclSemanticException {

        Classifier sourceType = ( (OclExpressionInternal) source ).getType( this.connection );
        if ( sourceType instanceof CollectionTypeInternal ) {
            // this is a shorthand for source->collect(name)
            // we have to create the collect operation
            CollectionTypeInternal colType = (CollectionTypeInternal) sourceType;
            // define iterator
            VariableDeclaration iterator = this.createVariableDeclaration( OclConstants.EMPTY, colType.getElementType( this.connection ), null );
            VariableExp varExp = this.createVariableExp( iterator );
            AssociationEndCallExp assocEndCall;
            assocEndCall = this.createAssociationCallExp( varExp, assocEnd, withAtPre );
            // create a collect operation with the
            // AssociationEndCall as the body
            Classifier type;
            if ( sourceType instanceof SequenceType ) {
                type = this.createSequenceType( innermostType( ( (AssociationEndCallExpInternal) assocEndCall ).getType( this.connection ) ) );
            } else {
                type = this.createBagType( innermostType( ( (AssociationEndCallExpInternal) assocEndCall ).getType( this.connection ) ) );
            }

            IteratorExpImpl collect = (IteratorExpImpl) this.createIteratorExpInternal( "collect", source, iterator, null, assocEndCall, type ); //$NON-NLS-1$

            return collect;
        }
        return this.createAssociationCallExp( source, assocEnd, withAtPre );
    }

    /**
     * Creates an <code>AssociationCallExp</code> and includes a collect
     * operation if necessary.
     * 
     * @param source the source of the <code>AssociatonCallExp</code>
     * @param assocEnd the <code>AssociationEnd</code> to refer to
     * @return <code>AssociationCallExp</code> with source <code>source</code>
     * and association end <code>assocEnd</code> and surrounded by a collect
     * operation if necessary.
     * @throws OclSemanticException if source == null or assocEnd == null
     */
    //    private OclExpression createAssociationCallExpExt(OclExpression source, AssociationEnd assocEnd)
    //        throws OclSemanticException {
    //
    //        /*
    //         * -- sanity check on the arguments
    //         */
    //        assertArgNotNull(source, JmiCreatorMessages.JMICREATOR_0201);
    //        assertArgNotNull(assocEnd, JmiCreatorMessages.JMICREATOR_0202);
    //
    //        Classifier sourceType = MoinMetamodelCode.getTypeOfOclExpression(connection, source);
    //        if (sourceType instanceof CollectionType) {
    //            // this is a shorthand for source->collect(name)
    //            // we have to create the collect operation
    //            CollectionType colType = (CollectionType) sourceType;
    //            // define iterator
    //            VariableDeclaration iterator = this.createVariableDeclaration("", MoinMetamodelCode
    //                .getElementTypeOfCollectionType(connection, colType), null);
    //            VariableExp varExp = this.createVariableExp(iterator);
    //            AssociationEndCallExp assocEndCall;
    //            assocEndCall = this.createAssociationCallExp(varExp, assocEnd);
    //            // create a collect operation with the
    //            // AssociationEndCall as the body
    //            IteratorExpImpl collect = (IteratorExpImpl) this.createIteratorExp("collect", source, iterator);
    //            collect.setBody(connection, assocEndCall);
    //            if (sourceType instanceof SequenceType) {
    //                collect.setType(connection, this.createSequenceType(innermostType(assocEndCall.getType())));
    //            } else {
    //                collect.setType(connection, this.createBagType(innermostType(assocEndCall.getType())));
    //            }
    //            return collect;
    //        }
    //        return this.createAssociationCallExp(source, assocEnd);
    //    }
    /**
     * Creates an <code>AttributeCallExp</code> and includes a collect operation
     * if necessary.
     * 
     * @param source the source of the <code>AttributeCallExp</code>
     * @param attribute the <code>Attribute</code> to refer to. If the type of
     * the <code>Attribute</code> is a <code>StructureField</code> it will be
     * converted into a <code>TupleType</code>.
     * @param withAtPre whether this attribute is prefixed with
     * <code>@pre</code>
     * @return an <code>AttributeCallExp</code>.
     * @throws OclSemanticException upon a semantic error
     */
    public OclExpression createAttributeCallExpExt( OclExpression source, Attribute attribute, boolean withAtPre ) throws OclSemanticException {

        Classifier sourceType = ( (OclExpressionInternal) source ).getType( this.connection );
        if ( sourceType instanceof CollectionType ) {
            // this is a shorthand for source->collect(name)
            // we have to create the collect operation
            CollectionType colType = (CollectionType) sourceType;
            // define iterator
            VariableDeclaration iterator = this.createVariableDeclaration( OclConstants.EMPTY, ( (CollectionTypeInternal) colType ).getElementType( this.connection ), null );
            VariableExp varExp = this.createVariableExp( iterator );
            AttributeCallExp attrCall;
            attrCall = this.createAttributeCallExp( varExp, attribute, withAtPre );
            // create a collect operation with the
            // AttributeCallExp as the body
            Classifier type;
            if ( sourceType instanceof SequenceType ) {
                type = this.createSequenceType( innermostType( ( (OclExpressionInternal) attrCall ).getType( this.connection ) ) );
            } else {
                type = this.createBagType( innermostType( ( (OclExpressionInternal) attrCall ).getType( this.connection ) ) );
            }

            return this.createIteratorExpInternal( "collect", source, iterator, null, attrCall, type ); //$NON-NLS-1$

        }
        return this.createAttributeCallExp( source, attribute, withAtPre );
    }

    /**
     * Creates an <code>AttributeCallExp</code>.
     * 
     * @param source the source of the <code>AttributeCallExp</code>
     * @param attribute the <code>Attribute</code> to refer to. If the type of
     * the <code>Attribute</code> is a <code>StructureField</code> it will be
     * converted into a <code>TupleType</code>.
     * @param withAtPre whether this attribute is prefixed with
     * <code>@pre</code>
     * @return an <code>AttributeCallExp</code>.
     * @throws OclSemanticException upon a semantic error
     */
    public AttributeCallExp createAttributeCallExp( OclExpression source, Attribute attribute, boolean withAtPre ) throws OclSemanticException {

        if ( withAtPre ) {
            // include @pre operation
            return createAttributeCallExp( createAtPre( source ), attribute );
        }
        return createAttributeCallExp( source, attribute );
    }

    /**
     * Determines the return type of an operation. If, for some reason, none
     * could be found oclUndefined is returned. If the operation has in/out or
     * out parameters a Tuple is returned with tuple parts matching the names of
     * parameters. The return parameter is named "result" in the tuple.
     * 
     * @param source the source expression
     * @param operation the operation
     * @param arg1 first parameter
     * @param arg2 second parameter
     * @return the return type of the operation or oclUndefined
     * @throws OclSemanticException upon a semantic error
     */
    public Classifier getReturnType( OclExpression source, Operation operation, OclExpression arg1, OclExpression arg2 ) throws OclSemanticException {

        Classifier returnType = this.getOclInvalidClass( );
        // defer creation of TupleType until we know that we need it
        // the Map contains name/type pairs in order to avoid unnecessary
        // creation of Attributes
        Map<String, Classifier> tupleParts = new HashMap<String, Classifier>( );

        boolean hasOutParameters = false;
        if ( operation != null ) {
            JmiList<ModelElement> contents = (JmiList<ModelElement>) ( (NamespaceInternal) operation ).getContents( this.connection );
            for ( int i = 0, n = contents.size( this.connection.getSession( ) ); i < n; i++ ) {
                Object o = contents.get( this.connection.getSession( ), i );
                if ( o instanceof Parameter ) {
                    Parameter p = (Parameter) o;
                    if ( p.getDirection( ) == DirectionKindEnum.OUT_DIR || p.getDirection( ) == DirectionKindEnum.INOUT_DIR ) {
                        // in/out parameter
                        // build a t
                        Classifier type = getOclTypeOf( p );
                        tupleParts.put( p.getName( ), type );
                        hasOutParameters = true;
                    } else if ( p.getDirection( ) == DirectionKindEnum.RETURN_DIR ) {
                        // a return parameter
                        returnType = getOclTypeOf( p );
                        // add the result to the tuple, just in case...
                        Classifier type = getOclTypeOf( p );
                        tupleParts.put( "result", type ); //$NON-NLS-1$
                    }
                }
            }
        }
        if ( operation != null && isStdLibOperation( operation ) ) {
            Classifier sourceType = ( (OclExpressionInternal) source ).getType( this.connection );
            // if operation is a standard library operation we have some work to
            // do
            // The problem is that due to the modeling limitation of MOF
            // no generic types can be defined. So, they are defined with very
            // general types. We now have to determine the actual type
            // to be able to type the OCL AST porperly.
            if ( OclConstants.OP_OCLASTYPE.equals( operation.getName( ) ) ) {
                // the return type referred to by the first argument
                if ( arg1 instanceof TypeExpInternal ) {
                    returnType = ( (TypeExpInternal) arg1 ).getReferredType( this.connection );
                }
            } else if ( OclConstants.OP_ALLINSTANCES.equals( operation.getName( ) ) ) {
                // the return type is a Set with the element type of the
                // operations source
                if ( source instanceof TypeExp ) {
                    returnType = this.createSetType( ( (TypeExpImpl) source ).getReferredType( this.connection ) );
                }
                /*
                 * Collection type operations
                 */
            } else if ( OclConstants.OP_SUM.equals( operation.getName( ) ) ) {
                if ( sourceType instanceof CollectionType ) {
                    return ( (CollectionTypeInternal) sourceType ).getElementType( this.connection );
                }

            } else if ( OclConstants.OP_PRODUCT.equals( operation.getName( ) ) ) {
                // the return type is a set of tuples
                // the tuples contain two fields: 'first', 'second'
                // the type of first is the element type of the
                // source collection, the type of second is the
                // element type of the argument
                Classifier sourceElmType;
                Classifier argElmType;
                Classifier arg1Type = ( (OclExpressionInternal) arg1 ).getType( this.connection );

                if ( sourceType instanceof CollectionType && arg1Type instanceof CollectionType ) {
                    sourceElmType = ( (CollectionTypeInternal) sourceType ).getElementType( this.connection );
                    argElmType = ( (CollectionTypeInternal) arg1Type ).getElementType( this.connection );
                    VariableDeclarationImpl first = (VariableDeclarationImpl) this.createVariableDeclaration( "first", sourceElmType, null ); //$NON-NLS-1$
                    VariableDeclarationImpl second = (VariableDeclarationImpl) this.createVariableDeclaration( "second", argElmType, null ); //$NON-NLS-1$
                    List<VariableDeclaration> tupleElms = new ArrayList<VariableDeclaration>( );
                    tupleElms.add( first );
                    tupleElms.add( second );
                    String name = "ProductOf" + first.getType( this.connection ).getName( ) + second.getType( this.connection ).getName( ); //$NON-NLS-1$
                    TupleType tt = this.createTupleType( tupleElms, name );
                    returnType = this.createSetType( tt );
                }

            } else if ( OclConstants.OP_ASSET.equals( operation.getName( ) ) ) {
                // converts any collection type or single element into a set
                if ( sourceType instanceof CollectionType ) {
                    Classifier sourceElmType;
                    sourceElmType = ( (CollectionTypeInternal) sourceType ).getElementType( this.connection );
                    returnType = this.createSetType( sourceElmType );
                } else {
                    returnType = this.createSetType( sourceType );
                }

            } else if ( OclConstants.OP_ASBAG.equals( operation.getName( ) ) ) {
                // converts any collection into a bag
                if ( sourceType instanceof CollectionType ) {
                    Classifier sourceElmType;
                    sourceElmType = ( (CollectionTypeInternal) sourceType ).getElementType( this.connection );
                    returnType = this.createBagType( sourceElmType );
                }
            } else if ( OclConstants.OP_ASORDEREDSET.equals( operation.getName( ) ) ) {
                // converts any collection into an ordered set
                if ( sourceType instanceof CollectionType ) {
                    Classifier sourceElmType;
                    sourceElmType = ( (CollectionTypeInternal) sourceType ).getElementType( this.connection );
                    returnType = this.createOrderedSetType( sourceElmType );
                }
            } else if ( OclConstants.OP_ASSEQUENCE.equals( operation.getName( ) ) ) {
                // converts any collection into a bag
                if ( sourceType instanceof CollectionType ) {
                    Classifier sourceElmType;
                    sourceElmType = ( (CollectionTypeInternal) sourceType ).getElementType( this.connection );
                    returnType = this.createSequenceType( sourceElmType );
                }
                /*
                 * SetType operation
                 */
            } else if ( OclConstants.OP_UNION.equals( operation.getName( ) ) ) {

                if ( sourceType instanceof SetType && ( (OclExpressionInternal) arg1 ).getType( this.connection ) instanceof SetType ) {
                    return sourceType;

                } else if ( sourceType instanceof SetType && ( (OclExpressionInternal) arg1 ).getType( this.connection ) instanceof BagType ) {
                    return this.createBagType( sourceType );

                } else if ( sourceType instanceof BagType ) {
                    return this.createBagType( sourceType );

                } else if ( sourceType instanceof SequenceType ) {
                    return this.createSequenceType( sourceType );

                }
            } else if ( OclConstants.OP_INTERSECTION.equals( operation.getName( ) ) ) {
                // intersection defined on SetType
                if ( sourceType instanceof SetType ) {
                    return sourceType;

                    // intersection defined on BagType
                } else if ( sourceType instanceof BagType ) {
                    Classifier arg1Type = ( (OclExpressionInternal) arg1 ).getType( this.connection );
                    if ( arg1Type instanceof SetType || arg1Type instanceof BagType ) {
                        return arg1Type;
                    }
                }
            } else if ( OclConstants.OP_N.equals( operation.getName( ) ) ) {
                if ( sourceType instanceof SetType && ( (OclExpressionInternal) arg1 ).getType( this.connection ) instanceof SetType ) {
                    return sourceType;
                }
            } else if ( OclConstants.OP_INCLUDING.equals( operation.getName( ) ) ) {
                if ( sourceType instanceof SetType || sourceType instanceof BagType || sourceType instanceof SequenceType ) {
                    return sourceType;
                }

            } else if ( OclConstants.OP_EXCLUDING.equals( operation.getName( ) ) ) {
                if ( sourceType instanceof SetType || sourceType instanceof BagType || sourceType instanceof SequenceType ) {
                    return sourceType;
                }
            } else if ( OclConstants.OP_SYMMDIF.equals( operation.getName( ) ) ) {
                if ( sourceType instanceof SetType ) {
                    return sourceType;
                }
            } else if ( OclConstants.OP_FLATTEN.equals( operation.getName( ) ) ) {
                if ( sourceType instanceof SetType ) {
                    return this.createSetType( strip( sourceType ) );
                } else if ( sourceType instanceof BagType ) {
                    return this.createBagType( strip( sourceType ) );
                } else if ( sourceType instanceof SequenceType ) {
                    return this.createSequenceType( strip( sourceType ) );
                }
                /*
                 * Ordered Set
                 */
            } else if ( OclConstants.OP_APPEND.equals( operation.getName( ) ) ) {
                if ( sourceType instanceof OrderedSetType || sourceType instanceof SequenceType ) {
                    return sourceType;
                }
            } else if ( OclConstants.OP_PREPEND.equals( operation.getName( ) ) ) {
                if ( sourceType instanceof OrderedSetType || sourceType instanceof SequenceType ) {
                    return sourceType;
                }
            } else if ( OclConstants.OP_INSERTAT.equals( operation.getName( ) ) ) {
                if ( sourceType instanceof OrderedSetType || sourceType instanceof SequenceType ) {
                    return sourceType;
                }
            } else if ( OclConstants.OP_SUBORDEREDSET.equals( operation.getName( ) ) ) {
                if ( sourceType instanceof OrderedSetType ) {
                    return sourceType;
                }
            } else if ( OclConstants.OP_AT.equals( operation.getName( ) ) ) {
                if ( sourceType instanceof OrderedSetType || sourceType instanceof SequenceType ) {
                    return ( (CollectionTypeInternal) sourceType ).getElementType( this.connection );
                }

            } else if ( OclConstants.OP_FIRST.equals( operation.getName( ) ) ) {
                if ( sourceType instanceof OrderedSetType || sourceType instanceof SequenceType ) {
                    return ( (CollectionTypeInternal) sourceType ).getElementType( this.connection );
                }
            } else if ( OclConstants.OP_LAST.equals( operation.getName( ) ) ) {
                if ( sourceType instanceof OrderedSetType || sourceType instanceof SequenceType ) {
                    return ( (CollectionTypeInternal) sourceType ).getElementType( this.connection );
                }
            } else if ( OclConstants.OP_SUBSEQUENCE.equals( operation.getName( ) ) ) {
                if ( sourceType instanceof SequenceType ) {
                    return sourceType;
                }
            }
        }
        return returnType;
    }

    /**
     * Checks whether a operation is a standard library operation
     * 
     * @param operation
     * @return true if operation is a standard library operation
     */
    private boolean isStdLibOperation( Operation operation ) {

        RefFeatured parent = ( (RefObjectImpl) operation ).refImmediateComposite( this.getSession( ) );
        if ( parent != null && parent instanceof RefObject ) {
            RefFeatured grandparent = ( (RefObjectImpl) parent ).refImmediateComposite( this.getSession( ) );
            if ( grandparent != null && grandparent == this.oclStdLibPkg ) {
                return true;
            }
        }

        return false;
    }

    /**
     * determines the innermost type.
     * 
     * @param type the type to strip.
     * @return the innermost type i.e. a non-CollectionType
     */
    protected final Classifier strip( Classifier type ) {

        if ( type instanceof CollectionType ) {
            return strip( ( (CollectionTypeInternal) type ).getElementType( this.connection ) );
        }
        return type;
    }

    /**
     * Determines the return type of an operation. If, for some reason, none
     * could be found oclUndefined is returned. If the operation has in/out or
     * out parameters a Tuple is returned with tuple parts matching the names of
     * parameters. The return parameter is named "result" in the tuple.
     * 
     * @param operation the operation
     * @return the return type of the operation or oclUndefined.
     * @throws OclSemanticException upon a semenatic error
     */
    public Classifier getReturnType( Operation operation ) throws OclSemanticException {

        Classifier returnType = this.getOclInvalidClass( );
        // defer creation of TupleType until we know that we need it
        // the Map contains name/type pairs in order to avoid unnecessary
        // creation of Attributes
        Map<String, Classifier> tupleParts = new HashMap<String, Classifier>( );

        boolean hasOutParameters = false;
        if ( operation != null ) {
            for ( Iterator<ModelElement> i = ( (JmiList<ModelElement>) ( (OperationInternal) operation ).getContents( this.getConnection( ) ) ).iteratorReadOnly( this.getConnection( ).getSession( ) ); i.hasNext( ); ) {
                Object o = i.next( );
                if ( o instanceof Parameter ) {
                    Parameter p = (Parameter) o;
                    if ( p.getDirection( ) == DirectionKindEnum.OUT_DIR || p.getDirection( ) == DirectionKindEnum.INOUT_DIR ) {
                        // in/out parameter
                        // build a t
                        Classifier type = getOclTypeOf( p );
                        tupleParts.put( p.getName( ), type );
                        hasOutParameters = true;
                    } else if ( p.getDirection( ) == DirectionKindEnum.RETURN_DIR ) {
                        // a return parameter
                        returnType = getOclTypeOf( p );
                        // add the result to the tuple, just in case...
                        Classifier type = getOclTypeOf( p );
                        tupleParts.put( "result", type ); //$NON-NLS-1$
                    }
                }
            }
        }

        if ( operation != null && hasOutParameters ) {
            // the operation has in/out or out parameters
            // return the tuple
            List<Attribute> tupleAttributes = new ArrayList<Attribute>( );
            for ( Entry<String, Classifier> tuplePartsEntry : tupleParts.entrySet( ) ) {
                tupleAttributes.add( createAttribute( tuplePartsEntry.getKey( ), tuplePartsEntry.getValue( ) ) );
            }
            return this.createTupleTypeInternal( tupleAttributes, "ReturnOf" + operation.getName( ) ); //$NON-NLS-1$
        }
        // the operation has only single return value and no in/out
        // parameters
        return returnType;
    }

    /**
     * Returns the proper OCL type for a parameter In MOF multiplicity is used
     * to model CollectionTypes. If multiplicity > 1 it is turned into a
     * CollectionType
     * 
     * @param p the parameter
     * @return a Classifier representig the proper OCL type in respect to the
     * multiplicity
     * @throws OclSemanticException
     */
    private Classifier getOclTypeOf( Parameter p ) throws OclSemanticException {

        return createOclType( p.getMultiplicity( ), ( (ParameterImpl) p ).getType( this.connection ) );
    }

    /**
     * Returns the proper OCL type for a feature (e.g Attribute, Reference) In
     * MOF multiplicity is used to model CollectionTypes. If multiplicity > 1 it
     * is turned into a CollectionType
     * 
     * @param f the feature
     * @return a Classifier representig the proper OCL type in respect to the
     * multiplicity
     * @throws OclSemanticException
     */
    // private Classifier getOclTypeOf(StructuralFeature f) throws
    // OclSemanticException {
    // return createOclType(f.getMultiplicity(), f.getType());
    // }
    /**
     * Returns the proper OCL type for a feature (e.g Attribute, Reference) In
     * MOF multiplicity is used to model CollectionTypes. If multiplicity > 1 it
     * is turned into a CollectionType
     * 
     * @param end the feature
     * @return a Classifier representig the proper OCL type in respect to the
     * multiplicity
     * @throws OclSemanticException
     */
    // private Classifier getOclTypeOf(AssociationEnd end) throws
    // OclSemanticException {
    // return createOclType(end.getMultiplicity(), end.getType());
    // }
    /**
     * Creates a OCL complient type for a type an a multiplicity. MOF uses
     * <code>MultiplicityType</code> to specify whether an parameter, attribute,
     * ... is in fact a Collection. This method returns a proper COL type in
     * respect of the multiplicity which can be a subClass of
     * <code>CollectionType</code> or another <code>Classifer</code>. It also
     * converts Mof StructureTypes to TupleTypes
     * 
     * @param mt the multiplicity
     * @param type the type
     * @return a subclass of <code>CollectionType</code> or another
     * <code>Classifer</code>
     * @throws OclSemanticException
     */
    private Classifier createOclType( MultiplicityType mt, Classifier type ) throws OclSemanticException {

        // if the type of the AssociationEnd is a StructureField
        // we have to turn it into a TupleType
        Classifier result;

        if ( type instanceof StructureType ) {
            result = convertStructureTypeToTupleType( (StructureType) type );
        } else {
            result = type;
        }
        if ( mt == null ) {
            return result;
        }

        /*
         * Got the return parameter, now let's see whether op returns a single
         * value or some sort of collection. For single value, upper
         * multiplicity should be 1.
         */
        if ( mt.getUpper( ) == 1 ) {
            return result;
        }

        if ( mt.isOrdered( ) ) {
            if ( mt.isUnique( ) ) {
                /*
                 * ordered && unique --> ordered set
                 */
                return createOrderedSetType( result );
            }
            /*
             * ordered && !unique --> sequence
             */
            return createSequenceType( result );
        }
        if ( mt.isUnique( ) ) {
            /*
             * !ordered & unique --> set
             */
            return createSetType( result );
        }
        /*
         * !ordered && !unique --> bag
         */
        return createBagType( result );
    }

    /**
     * Creates a <code>TupleType</code> representing a
     * <code>StructureType</code>. Each <code>StructureField</code> is turned
     * into a <code>Attribute</code> and added to <code>TupleType</code>'s
     * <code>contents</code>.
     * 
     * @param struct the <code>StructureType</code> to turn into a
     * <code>TupleType</code>.
     * @return a <code>TupleType</code>
     * @throws OclSemanticException
     */
    protected TupleType convertStructureTypeToTupleType( StructureType struct ) throws OclSemanticException {

        TupleType tuple = null;

        MofPackageInternal mp;
        try {
            mp = (MofPackageInternal) this.getOrCreatePackageForGeneratedObjects( false );
        } catch ( OclManagerException e1 ) {
            throw new OclSemanticException( e1 );
        }
        if ( mp != null ) {
            try {
                ModelElement elm = mp.lookupElement( this.connection, "TupleOfStruct" + struct.getName( ) ); //$NON-NLS-1$
                if ( elm instanceof TupleType ) {
                    tuple = (TupleType) elm;
                }
            } catch ( JmiException e ) {
                // $JL-EXC$ ignore and create it
            } catch ( NameNotFoundException e ) {
                // $JL-EXC$ ignore and create it
            }
        }

        JmiList<ModelElement> contents = (JmiList<ModelElement>) ( (NamespaceInternal) struct ).getContents( this.connection );

        if ( tuple == null && this.mmImportMode ) {
            for ( int i = 0, n = contents.size( this.connection.getSession( ) ); i < n; i++ ) {
                ModelElement me = contents.get( this.connection.getSession( ), i );
                if ( me.getName( ).equals( "TupleOfStruct" + struct.getName( ) ) ) { //$NON-NLS-1$
                    tuple = (TupleType) me;
                }
            }
        }

        if ( tuple == null ) {
            List<Attribute> tupleParts = new ArrayList<Attribute>( );
            for ( int i = 0, n = contents.size( this.connection.getSession( ) ); i < n; i++ ) {
                Object o = contents.get( this.connection.getSession( ), i );
                if ( o instanceof StructureField ) {
                    StructureFieldImpl field = (StructureFieldImpl) o;
                    // the attribute names must be the same for being able to look them up
                    Attribute a = this.createAttribute( field.getName( ), field.getType( this.connection ) );
                    tupleParts.add( a );
                }
            }

            // add the inherited fields if any
            List<GeneralizableElement> supertypes = ( (StructureTypeInternal) struct ).allSupertypes( this.connection );
            for ( GeneralizableElement supertype : supertypes ) {
                if ( supertype instanceof StructureType ) {
                    JmiList<ModelElement> stcontents = (JmiList<ModelElement>) ( (NamespaceInternal) supertype ).getContents( this.connection );
                    for ( int i = 0, n = stcontents.size( this.connection.getSession( ) ); i < n; i++ ) {
                        Object o = stcontents.get( this.connection.getSession( ), i );
                        if ( o instanceof StructureField ) {
                            StructureFieldImpl field = (StructureFieldImpl) o;
                            // the attribute names must be the same for being able to look them up
                            Attribute a = this.createAttribute( field.getName( ), field.getType( this.connection ) );
                            tupleParts.add( a );
                        }
                    }
                }
            }
            tuple = this.createTupleTypeInternal( tupleParts, "TupleOfStruct" + struct.getName( ) ); //$NON-NLS-1$

        }
        return tuple;
    }

    /**
     * Creates an IterateExp
     * 
     * @param opName the name of the iterate operation
     * @param source the source of the iterate operation
     * @param iter1 the first iterator variable
     * @param iter2 the second iterator variable
     * @param accu the accumulator variable
     * @param body the body of the iterate operation
     * @return an IterateExp
     * @throws OclSemanticException if <code>opName</code> does not identify a
     * valid iterate operation or <code>iter</code> has been initialized,
     * <code>accu</code> has not been initialized, or types don't match.
     */
    public IterateExp createIterateExp( String opName, OclExpression source, VariableDeclaration iter1, VariableDeclaration iter2, VariableDeclaration accu, OclExpression body ) throws OclSemanticException {

        String actOpName = opName.trim( );
        // well, we do not look it up, but create it here.
        if ( !actOpName.equals( OclConstants.OP_ITERATE ) ) {
            throw new OclSemanticException( JmiCreatorMessages.JMICREATOR_0110, actOpName );
        }
        return createIterate( source, iter1, iter2, accu, body );
    }

    /**
     * Creates an IteratorExp defined by <code>opName</code>.
     * 
     * @param opName the name of the operation {any, one, collect,
     * collectNested, ...}
     * @param source the source of this iterator
     * @param iter1 the first iterator
     * @param iter2 the second iterator can be null
     * @param body the arguments for the iterator must be exactly one
     * @return the IteratorExp
     * @throws OclSemanticException anything is wrong with the supplied
     * information an OclSemanticException will be thrown.
     */
    public IteratorExp createIteratorExp( String opName, OclExpression source, VariableDeclaration iter1, VariableDeclaration iter2, OclExpression body ) throws OclSemanticException {

        String actOpName = opName.trim( );
        // do some checks first ...
        // source must be a collection
        // if (!(source.getType() instanceof CollectionType)) {
        // throw new OclSemanticException(
        // ITERATOREXP_MUST_HAVE_A_COLLECTIONTYPE_AS_SOURCE_);
        // }
        // dispatch to the different create methods...
        if ( actOpName.equals( OclConstants.OP_ANY ) ) {
            return createAny( source, iter1, iter2, body );

        } else if ( actOpName.equals( OclConstants.OP_COLLECT ) ) {
            return createCollect( source, iter1, iter2, body );

        } else if ( actOpName.equals( OclConstants.OP_COLLECTNESTED ) ) {
            return createCollectNested( source, iter1, iter2, body );

        } else if ( actOpName.equals( OclConstants.OP_EXISTS ) ) {
            return createExists( source, iter1, iter2, body );

        } else if ( actOpName.equals( OclConstants.OP_FORALL ) ) {
            return createForAll( source, iter1, iter2, body );

        } else if ( actOpName.equals( OclConstants.OP_ISUNIQUE ) ) {
            return createIsUnique( source, iter1, iter2, body );

        } else if ( actOpName.equals( OclConstants.OP_ONE ) ) {
            return createOne( source, iter1, iter2, body );

        } else if ( actOpName.equals( OclConstants.OP_REJECT ) ) {
            return createReject( source, iter1, iter2, body );

        } else if ( actOpName.equals( OclConstants.OP_SELECT ) ) {
            return createSelect( source, iter1, iter2, body );

        } else if ( actOpName.equals( OclConstants.OP_SORTEDBY ) ) {
            return createSortedBy( source, iter1, iter2, body );

        } else {
            // the name is not recognized.
            throw new OclSemanticException( JmiCreatorMessages.JMICREATOR_0110, actOpName );
            // opName));
        }

    }

    /**
     * Convenience routine for checking validity of method arguments.
     * Essentially checks (as the name hopefully applies) whether the body
     * expression of an iterate is valid, i.e. not <code>null</code> and
     * conforms to a certain type.
     * 
     * @param body the body expression to be checked
     * @param name the name of the iterator
     * @param bodyType the assumed type name of the body expression
     * @throws OclSemanticException if the body expression is <code>null</code>
     * or the type of the body expression does not match the one provided in the
     * argument
     */
    private void assertIteratorBody( OclExpression body, String name, String bodyType ) throws OclSemanticException {

        if ( body == null || !( (OclExpressionInternal) body ).getType( this.connection ).getName( ).equals( bodyType ) ) {
            throw new OclSemanticException( JmiCreatorMessages.JMICREATOR_0104, name, bodyType, body == null ? "null" : ( (OclExpressionInternal) body ).getType( this.connection ).getName( ) ); //$NON-NLS-1$
        }
    }

    /**
     * Convenience routine for checking validity of method arguments.
     * Essentially checks (as the name hopefully applies) whether the iterator
     * expression is <code>null</code>. Since we want to use a different error
     * message for reporting a problem, we use this method and not
     * <code>assertArgNotNull</code>.
     * 
     * @param iter the iterator expression
     * @param name the name of the iterator
     * @throws OclSemanticException if that iterator is not <code>null</code>
     */
    private void assertIteratorIsNull( Object iter, String name ) throws OclSemanticException {

        if ( iter != null ) {
            throw new OclSemanticException( JmiCreatorMessages.JMICREATOR_0101, name );
        }
    }

    /**
     * Checks whether a variable declaration list is correct, i.e. all elements
     * in the list are of type VariableDeclaration and all names are unique. If
     * it is ok, the variableDeclaration is converted to a List of Attributes.
     * 
     * @param varDecls the list of variable declarations to be checked
     * @param errMsg the error message we use if a variable name is used twice
     * @throws OclSemanticException if one of the elements is not a variable
     * declaration or if a variable name is used twice.
     */
    private List<Attribute> checkVariableDeclarations( List<VariableDeclaration> varDecls, boolean convertToAttributes, MoinLocalizedString errMsg ) throws OclSemanticException {

        Set<String> vars = new HashSet<String>( );
        List<Attribute> result = new ArrayList<Attribute>( );

        for ( Iterator<VariableDeclaration> i = varDecls.iterator( ); i.hasNext( ); ) {
            VariableDeclaration var = i.next( );
            if ( vars.contains( var.getVarName( ) ) ) {
                // there is already a tuple part with that name
                throw new OclSemanticException( errMsg );
            }
            vars.add( var.getVarName( ) );
            if ( convertToAttributes ) {
                result.add( this.createAttribute( var.getVarName( ), ( (VariableDeclarationInternal) var ).getType( this.connection ) ) );
            }
        }
        vars.clear( );
        return result;
    }

    /**
     * Checks an iterator declaration. Which checks are actually performed
     * depends on the parameters <code>checkType</code> and <code>create</code>.
     * 
     * @param iter the iterator declaration that has to be checked
     * @param elementType the supposed element type of the collection, in which
     * the iterator is defined/used
     * @param checkType flags whether the actual type of the iterator should be
     * checked against the supposed element type
     * @param create flags whether the iterator declaration should be created if
     * empty
     * @return the modified iterator declaration.
     * @throws OclSemanticException if iterator declaration has an init
     * expression or (in case of type matching) types do not match
     */
    private VariableDeclaration checkIterator( VariableDeclaration iter, Classifier elementType, boolean checkType, boolean create ) throws OclSemanticException {

        /*
         * -- if iterator is undefined and we don't have to create one, --
         * simply return without any checking
         */
        if ( !create && iter == null ) {
            return null;
        }

        VariableDeclarationInternal newIter = null;

        /*
         * -- if iterator has not yet been defined, define a new one
         */
        if ( iter == null ) {
            newIter = (VariableDeclarationImpl) createVariableDeclaration( OclConstants.EMPTY, elementType, null );
        } else {
            newIter = (VariableDeclarationImpl) iter;
        }

        /*
         * -- iterators must not have an init expression -- if so, delete
         * iterator variable if it has been created -- within this method
         */
        if ( newIter.getInitExpression( this.connection ) != null ) {
            String iterName = newIter.getVarName( );
            if ( newIter != iter ) {
                ( (RefObjectImpl) newIter ).refDelete( this.connection );
            }
            throw new OclSemanticException( JmiCreatorMessages.JMICREATOR_0111, iterName );
        }

        /*
         * -- if type of iterator is implicitly given, set it to -- collection's
         * element type
         */
        if ( newIter.getType( this.connection ).equals( this.getOclInvalidClass( ) ) ) {
            newIter.setType( this.connection, elementType );
        }

        /*
         * -- types of iterator and collection elements must conform -- TODO: Do
         * we really mean equal or is typesConform sufficient?
         */
        if ( checkType && !newIter.getType( this.connection ).equals( elementType ) ) {
            Classifier newIterType = newIter.getType( this.connection );
            Object[] args = new String[] { newIter.getVarName( ), toPathName( MoinMetamodelCode.getQualifiedName( this.connection, newIterType, (RefObjectImpl) newIterType ) ), toPathName( MoinMetamodelCode.getQualifiedName( this.connection, elementType, (RefObjectImpl) elementType ) ) };

            if ( newIter != iter ) {
                ( (RefObjectImpl) newIter ).refDelete( this.connection );
            }
            throw new OclSemanticException( JmiCreatorMessages.JMICREATOR_0107, args );
        }
        return (VariableDeclaration) newIter;
    }

    public RefPackage findPackage( String[] pkgName ) {

        return this.connection.getPackage( null, pkgName );
    }

    public <T extends RefPackage> T getPackage( PackageDescriptor<T> packageDescriptor ) {

        return this.connection.getPackage( packageDescriptor );
    }

    /**
     * @see MoinJmiCreator#getOclInvalidVariable()
     */
    public VariableDeclaration getOclInvalidVariable( ) throws OclSemanticException {

        return this.createVariableDeclaration( OclConstants.VAR_INVALID, this.getOclInvalidClass( ), null );
    }

    /**
     * @see MoinJmiCreator#getOclNullVariable()
     */
    public VariableDeclaration getOclNullVariable( ) throws OclSemanticException {

        return this.createVariableDeclaration( OclConstants.VAR_NULL, this.getOclVoidClass( ), null );
    }

    private CollectionType getCollectionTypeFromType( int type, Classifier elementType ) {

        String name = this.getCollectionTypeName( type, elementType );

        JmiList<ModelElement> contents = (JmiList<ModelElement>) ( (NamespaceInternal) elementType ).getContents( this.connection );
        for ( int i = 0, n = contents.size( this.connection.getSession( ) ); i < n; i++ ) {
            ModelElement me = contents.get( this.connection.getSession( ), i );
            if ( me.getName( ).equals( name ) ) {
                return (CollectionType) me;
            }
        }

        // TODO this is probably VERY bad in terms of performance; we need to
        // improve this
        Collection<EndStorageLink> links;
        try {
            links = (Collection) this.connection.getNullPartition( ).getLinks( );
        } catch ( InvalidResourceIdentifierException e1 ) {
            return null;
        }
        if ( links != null ) {
            for ( Iterator<EndStorageLink> linkit = links.iterator( ); linkit.hasNext( ); ) {
                EndStorageLink nextLink = linkit.next( );

                try {
                    if ( ( (Association) nextLink.getMetaObject( ) ).getName( ).equals( "A_collectionTypes_elementType" ) ) { //$NON-NLS-1$
                        if ( nextLink.getEnd( 0 ).getMofId( ).equals( elementType.refMofId( ) ) ) {
                            CollectionType ctype = (CollectionType) nextLink.getEnd( 1 ).get( this.connection.getSession( ) );
                            if ( ctype.getName( ).equals( name ) ) {
                                return ctype;
                            }
                        } else if ( nextLink.getEnd( 1 ).getMofId( ).equals( elementType.refMofId( ) ) ) {
                            CollectionType ctype = (CollectionType) nextLink.getEnd( 0 ).get( this.connection.getSession( ) );
                            if ( ctype.getName( ).equals( name ) ) {
                                return ctype;
                            }
                        }
                    }
                } catch ( ClassCastException ce ) {
                    continue;
                } catch ( InvalidResourceIdentifierException e ) {
                    continue;
                }
            }
        }

        return null;
    }

    private String getCollectionTypeName( int collectionType, Classifier elementType ) {

        switch ( collectionType ) {
            case COLLECTION_TYPE_BAG:
                return "Bag(" + elementType.getName( ) + ")"; //$NON-NLS-1$ //$NON-NLS-2$
            case COLLECTION_TYPE_SET:
                return "Set(" + elementType.getName( ) + ")"; //$NON-NLS-1$ //$NON-NLS-2$
            case COLLECTION_TYPE_SEQUENCE:
                return "Sequence(" + elementType.getName( ) + ")"; //$NON-NLS-1$ //$NON-NLS-2$
            case COLLECTION_TYPE_ORDERED_SET:
                return "OrderedSet(" + elementType.getName( ) + ")"; //$NON-NLS-1$ //$NON-NLS-2$
            default:
                return null;
        }
    }

    /**
     * Checks whether type1 conforms to type2. <tt>type1</tt> conforms to
     * <tt>type2</tt> if -<tt>type1</tt> is a simple type and <tt>type2</tt> is
     * <tt>OclAny</tt>-<tt>type1</tt> are equal <tt>type2</tt>-<tt>type1</tt> is
     * subtype of <tt>type2</tt>- if <tt>type1</tt> and <tt>type2</tt> are
     * collections - the collection types have to be equal and the element types
     * must conform. - OrderedSet conforms to Set if the element types conform -
     * if <tt>type1</tt> and <tt>type2</tt> are tuples tuple parts of
     * <tt>type1</tt> must conform to tuple parts of <tt>type2</tt> if they have
     * the same name.
     * 
     * @param type1
     * @param type2
     * @return true if type1 conforms to type2
     */
    private boolean typesConform( Classifier firstType, Classifier secondType ) {

        // deal with alias types
        // this was requested by Thomas Goldschmidt
        Classifier type1 = this.getNonAliasType( firstType );
        Classifier type2 = this.getNonAliasType( secondType );
        // oclUndefined conforms to everything
        if ( type1.equals( this.getOclInvalidClass( ) ) ) {
            return true;
        }

        if ( "Any".equals( type2.getName( ) ) ) { //$NON-NLS-1$
            return true;
        }

        // check the trivial cases first
        if ( type1.equals( type2 ) ) {
            return true;
        }
        // any type conforms to OclAny except for Collections and Tuples.
        if ( !( type1 instanceof CollectionType ) && !( type1 instanceof TupleType ) && type2.equals( this.getAnyClass( ) ) ) {
            return true;
        }
        // since OclAny is not defined in the model it can happen that there are
        // several OclAnys around. we just check for the name
        // any type conforms to OclAny except for Collections and Tuples.
        if ( !( type1 instanceof CollectionType ) && !( type1 instanceof TupleType ) && type2.getName( ).equals( OclConstants.T_OCLANY ) ) {
            return true;
        }

        // check build-in types
        if ( type1 instanceof PrimitiveType && type2 instanceof PrimitiveType ) {
            // Real is called Float in MOF we check for both names
            if ( type2.equals( getFloatClass( ) ) && type1.equals( getIntClass( ) ) ) {
                return true;
            }
        }
        // check supertypes
        List<GeneralizableElement> allSupertypes = MoinMetamodelCode.allSupertypes( this.connection, type1, (RefObjectImpl) type1 );
        if ( allSupertypes.contains( type2 ) ) {
            return true;
        }

        // check collectiontypes
        if ( type1 instanceof CollectionType && type2 instanceof CollectionType ) {
            CollectionType colType1 = (CollectionType) type1;
            CollectionType colType2 = (CollectionType) type2;
            Classifier elmType1 = ( (CollectionTypeInternal) colType1 ).getElementType( this.connection );
            Classifier elmType2 = ( (CollectionTypeInternal) colType2 ).getElementType( this.connection );
            if ( colType1 instanceof BagType && type2 instanceof BagType ) {
                return typesConform( elmType1, elmType2 );
            } else if ( colType1 instanceof SetType && colType2 instanceof SetType ) {
                return typesConform( elmType1, elmType2 );
            } else if ( colType1 instanceof SequenceType && colType2 instanceof SequenceType ) {
                return typesConform( elmType1, elmType2 );
            } else if ( colType1 instanceof OrderedSetType && colType2 instanceof OrderedSetType ) {
                return typesConform( elmType1, elmType2 );
            } else if ( colType1 instanceof OrderedSetType && colType2 instanceof SetType ) {
                // ordered set conforms to set
                return typesConform( elmType1, elmType2 );
            }
        }

        // check tuple types
        if ( type1 instanceof TupleType && type2 instanceof TupleType ) {
            return tupleConformity( (TupleType) type1, (TupleType) type2 );
        }

        return false;
    }

    private Classifier getNonAliasType( Classifier type ) {

        return this.connection.getCoreJmiHelper( ).getNonAliasType( this.connection.getSession( ), type );
    }

    /**
     * Checks to tuples for conformity. Tuples conform if they have the same
     * amount of elements. For each element in type1 there must be an element in
     * type2 with the same name. If the names match the type of the tuple
     * element of type1 must conform to the type of the tuple element of type2
     * 
     * @param type1
     * @param type2
     * @return true if <tt>type1</tt> conforms to <tt>type2</tt>
     */
    private boolean tupleConformity( TupleType type1, TupleType type2 ) {

        // tuples conform if they have the same amount of attributes
        // and the types of each attriubtes conform to each other
        Hashtable<String, Attribute> type2AttrHash = new Hashtable<String, Attribute>( );

        JmiList<ModelElement> contents1 = (JmiList<ModelElement>) ( (TupleTypeImpl) type1 ).getContents( this.connection );
        JmiList<ModelElement> contents2 = (JmiList<ModelElement>) ( (TupleTypeImpl) type2 ).getContents( this.connection );

        if ( contents1.size( this.connection.getSession( ) ) != contents2.size( this.connection.getSession( ) ) ) {
            // if types have different amount of attributes
            // they cannot conform to each other
            return false;
        }
        // put the attributes of type2 in a hash so we can access them
        // conveniently
        // lookupElement() does not work porperly it returns null even though
        // there is an element with the supplied name
        for ( int i = 0, n = contents2.size( this.connection.getSession( ) ); i < n; i++ ) {
            Object o = contents2.get( this.connection.getSession( ), i );
            if ( o instanceof Attribute ) {
                Attribute a = (Attribute) o;
                type2AttrHash.put( a.getName( ), a );
            }
        }
        // go through all attributes of type1
        for ( int i = 0, n = contents1.size( this.connection.getSession( ) ); i < n; i++ ) {
            Object o = contents1.get( this.connection.getSession( ), i );
            if ( o instanceof Attribute ) {
                AttributeImpl a1 = (AttributeImpl) o;
                AttributeImpl a2 = (AttributeImpl) type2AttrHash.get( a1.getName( ) );
                if ( a2 == null ) {
                    // type2 does not have an attribute that corresponds to a1
                    return false;
                }
                // type of a1 has to conform to type of attribute a2
                if ( !this.typesConform( a1.getType( this.connection ), a2.getType( this.connection ) ) ) {
                    return false;
                }
            } else {
                return false;
            }
        }
        // the tuples do conform
        return true;
    }
}

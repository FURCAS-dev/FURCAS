package com.sap.tc.moin.ocl.parser.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.Constant;
import com.sap.tc.moin.repository.mmi.model.DirectionKindEnum;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;
import com.sap.tc.moin.repository.mmi.model.NameNotFoundException;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.Parameter;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.model.TypedElement;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.AttributeInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ClassifierInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ConstantInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ModelElementInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.NamespaceInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.OperationInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ParameterInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ReferenceInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.StructuralFeatureInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.StructureFieldInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.TypedElementInternal;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.omg.ocl.expressions.BooleanLiteralExp;
import org.omg.ocl.expressions.CollectionLiteralExp;
import org.omg.ocl.expressions.CollectionLiteralPart;
import org.omg.ocl.expressions.IfExp;
import org.omg.ocl.expressions.IntegerLiteralExp;
import org.omg.ocl.expressions.IterateExp;
import org.omg.ocl.expressions.IteratorExp;
import org.omg.ocl.expressions.OclExpression;
import org.omg.ocl.expressions.OperationCallExp;
import org.omg.ocl.expressions.RealLiteralExp;
import org.omg.ocl.expressions.StringLiteralExp;
import org.omg.ocl.expressions.TypeExp;
import org.omg.ocl.expressions.VariableExp;
import org.omg.ocl.expressions.__impl.CollectionLiteralPartInternal;
import org.omg.ocl.expressions.__impl.LetExpImpl;
import org.omg.ocl.expressions.__impl.OclExpressionInternal;
import org.omg.ocl.expressions.__impl.TypeExpInternal;
import org.omg.ocl.expressions.__impl.VariableDeclarationImpl;
import org.omg.ocl.expressions.__impl.VariableDeclarationInternal;
import org.omg.ocl.types.CollectionType;
import org.omg.ocl.types.__impl.CollectionTypeInternal;

import com.sap.tc.moin.ocl.parser.IOCLEnvironment;
import com.sap.tc.moin.ocl.parser.IOCLLookupTables;
import com.sap.tc.moin.ocl.parser.IOCLTypeChecker;
import com.sap.tc.moin.ocl.parser.gen.oclAst.*;
import com.sap.tc.moin.ocl.parser.impl.errors.FatalParsingException;
import com.sap.tc.moin.ocl.parser.impl.localization.OclParserMessages;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.ocl.utils.impl.OclStatementImpl;
import com.sap.tc.moin.ocl.utils.jmi.MoinJmiCreator;
import com.sap.tc.moin.ocl.utils.jmi.OclSemanticException;
import com.sap.tc.moin.repository.ProcessError;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.jmi.util.MoinMetamodelCode;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * 
 */
public class OclAstBuilder extends AbstractOclAstVisitor {

    /**
     * Marks an OclStatement as <tt>EXPRESSION</tt>
     * 
     * @see com.sap.tc.moin.ocl.utils.OclStatement#EXPRESSION
     */
    private static final int EXPRESSION = OclStatement.EXPRESSION;

    /**
     * Marks an OclStatement as <tt>INVARIANT</tt>
     * 
     * @see com.sap.tc.moin.ocl.utils.OclStatement#INVARIANT
     */
    private static final int INVARIANT = OclStatement.INVARIANT;

    /**
     * Marks an OclStatement as <tt>OPERATION_BODY</tt>
     * 
     * @see com.sap.tc.moin.ocl.utils.OclStatement#OPERATION_BODY
     */
    private static final int OPERATION_BODY = OclStatement.OPERATION_BODY;

    /**
     * Marks an OclStatement as <tt>POST_CONDITION</tt>
     * 
     * @see com.sap.tc.moin.ocl.utils.OclStatement#POST_CONDITION
     */
    protected static final int POST_CONDITION = OclStatement.POST_CONDITION;

    /**
     * Marks an OclStatement as <tt>PRE_CONDITION</tt>
     * 
     * @see com.sap.tc.moin.ocl.utils.OclStatement#PRE_CONDITION
     */
    private static final int PRE_CONDITION = OclStatement.PRE_CONDITION;

    /**
     * Marks an OclStatement as <tt>INIT_EXPRESSION</tt>
     * 
     * @see com.sap.tc.moin.ocl.utils.OclStatement#INIT_EXPRESSION
     */
    private static final int INIT_EXPRESSION = OclStatement.INIT_EXPRESSION;

    /**
     * Marks an OclStatement as <tt>DERIVATION</tt>
     * 
     * @see com.sap.tc.moin.ocl.utils.OclStatement#DERIVATION
     */
    private static final int DERIVATION = OclStatement.DERIVATION;

    /**
     * Marks an OclStatement as <tt>DEFINITION</tt>
     * 
     * @see com.sap.tc.moin.ocl.utils.OclStatement#DEFINITION
     */
    private static final int DEFINITION = OclStatement.DEFINITION;

    /**
     * initial value for <tt>stereotype</tt>
     */
    private static final int UNKNOWN = 1000;

    private static final int P_PRE_POST_OR_BODY_DECL = 2;

    /**
     * the stereotype of the current OclStatement
     */
    protected int stereotype = UNKNOWN;

    protected static final List<Classifier> CLASSIFIER_EMPTY_LIST = Collections.emptyList( );

    /*
     * for convenient reasons we keep the primitive types around
     */

    protected Classifier boolType;

    protected Classifier floatType;

    protected Classifier longType;

    protected Classifier doubleType;

    protected Classifier stringType;

    protected Classifier integerType;

    protected final MoinJmiCreator jmiCreator;

    protected final IOCLEnvironment env;

    protected final IOCLTypeChecker oclTypeChecker;

    protected final IOCLLookupTables oclLookupTables;

    // for keeping the result
    private Set<OclStatement> statements = new HashSet<OclStatement>( );

    /**
     * Creates a new Transformation
     * 
     * @param actEnv the Environment
     * @param actTypeChecker the checker
     * @param actLookupTables the lookup tables
     */
    public OclAstBuilder( IOCLEnvironment actEnv, IOCLTypeChecker actTypeChecker, IOCLLookupTables actLookupTables ) {

        super( );

        this.env = actEnv;
        this.oclTypeChecker = actTypeChecker;
        this.oclLookupTables = actLookupTables;

        this.report = actEnv.getReport( );

        this.jmiCreator = actEnv.getJmiCreator( );

        this.floatType = this.jmiCreator.getFloatClass( );
        this.longType = this.jmiCreator.getLongClass( );
        this.doubleType = this.jmiCreator.getDoubleClass( );
        this.boolType = this.jmiCreator.getBoolClass( );
        this.integerType = this.jmiCreator.getIntClass( );
        this.stringType = this.jmiCreator.getStringClass( );
    }

    /**
     * @return the statements
     */
    public Set<OclStatement> getStatements( ) {

        return this.statements;
    }

    protected void reportFatalOCLError( MoinLocalizedBaseException e, Node n ) {

        ProcessError error = (ProcessError) super.reportFatalError( e, n );
        throw new FatalParsingException( e, error );
    }

    /*
     * Auxiliary methods
     */

    /**
     * Constructs an attribute call on a source
     */
    private OclExpression explicitAttrCall( OclExpression source, Attribute attribute, boolean withAtPre, Node n ) {

        OclExpression attrCall = null;
        try {
            attrCall = this.jmiCreator.createAttributeCallExpExt( source, attribute, withAtPre );
            this.setUpProperty( n, attrCall );
        } catch ( OclSemanticException e ) {
            this.reportInternalError( e, n );
        }
        return attrCall;
    }

    /**
     * Constructs an association navigation call on a source
     */
    private OclExpression explicitNavCall( OclExpression source, AssociationEnd end, boolean withAtPre, Node n ) {

        OclExpression navCall = null;
        try {
            navCall = this.jmiCreator.createAssociationCallExpExt( source, end, withAtPre );
            this.setUpProperty( n, navCall );
        } catch ( OclSemanticException e ) {
            this.reportInternalError( e, n );
        }
        return navCall;
    }

    /**
     * Handles the at pre property
     */
    protected boolean handleWithAtPre( TimeExpressionOpt te, Node n ) {

        boolean withAtPre = ( te != null );
        if ( withAtPre && this.stereotype != POST_CONDITION ) {
            this.reportError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0302 ), te );
        }
        if ( withAtPre ) {
            this.makeUpProperty( n, OclConstants.N_WITHAPRE );
        }
        return withAtPre;
    }

    private OclExpression explicitNavOrAttrCall( OclExpression source, List<String> pathName, TimeExpressionOpt te, AssociationQualifier aq, Node n ) {

        // obtain the name of the path which cannot be qualified
        String name = this.getNamePart( pathName, 0, n, new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0002, new Object[] { StringHelper.toPathName( pathName ) } ) );

        // handle the time expression
        boolean withAtPre = this.handleWithAtPre( te, n );

        OclExpression result = this.explicitNavOrAttrCall( source, name, withAtPre, aq, n, true );

        if ( withAtPre ) {
            this.setDownProperty( n, result );
            te.accept( this );
            result = (OclExpression) this.getUpProperty( n );
        }

        return result;
    }

    /**
     * Handles attribute or navigation call expressions. If not fatal, null is
     * returned on error and the expression on non-error
     */
    private OclExpression explicitNavOrAttrCall( OclExpression source, String name, boolean withAtPre, AssociationQualifier aq, Node n, boolean fatal ) {

        OclExpression result = null;

        List<String> assocQualName = null;
        if ( aq != null ) {
            aq.accept( this );
            assocQualName = (List<String>) this.getUpProperty( aq );
        }

        ModelElement f = null;
        Classifier sourceType = ( (OclExpressionInternal) source ).getType( this.jmiCreator.getConnection( ) );

        try {
            if ( assocQualName == null ) {
                // this is a normal AttributeCall or AssociationEndCall
                f = this.oclLookupTables.lookupOptFeature( sourceType, name );
            } else {
                // this is a fully qualified AssociationEndCallExp.
                f = this.env.lookupOptExplicitQualifiedAssociationEnd( sourceType, name, assocQualName, this.oclTypeChecker );
            }

            if ( f != null ) {
                // something is found, we check the type
                result = this.producePropertyCall( source, sourceType, name, f, withAtPre, n, fatal );
            }
        } catch ( OclSemanticException e ) {
            // something went wrong that has to be reported
            this.reportFatalOCLError( e, n );
        } catch ( JmiException e ) {
            // $JL-EXC$ this is a bug
            //this.reportInternalError( new MoinBaseException( e ), n );
        }

        if ( f == null ) {
            // this is not an Attribute or an AssociationEnd report an error if
            // fatal!
            this.noPropertyFound( name, sourceType, n, fatal );
        }

        return result;
    }

    /**
     * We call this when no property was found on the navigations
     */
    protected void noPropertyFound( String name, Classifier sourceType, Node n, boolean fatal ) {

        if ( fatal ) {
            OclSemanticException ex = new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0701, new Object[] { name, StringHelper.toPathName( ( (ModelElementInternal) sourceType ).getQualifiedName( this.jmiCreator.getConnection( ) ) ) } );
            this.reportFatalOCLError( ex, n );
        }
    }

    /**
     * Depending on the type of the found model element, we produce the
     * appropriate expression. If none of the right type can be found, we return
     * null or if fatal==true, an exception
     */
    protected OclExpression producePropertyCall( OclExpression source, Classifier sourceType, String name, ModelElement f, boolean withAtPre, Node n, boolean fatal ) {

        OclExpression result = null;

        // check if we have a feature, attribute or navigation call
        if ( f instanceof Attribute ) {
            result = this.explicitAttrCall( source, (Attribute) f, withAtPre, n );
        } else if ( f instanceof AssociationEnd ) {
            result = this.explicitNavCall( source, (AssociationEnd) f, withAtPre, n );
        } else if ( f instanceof Reference ) {
            result = this.explicitNavCall( source, ( (Reference) f ).getReferencedEnd( ), withAtPre, n );
        } else if ( fatal ) {
            // this is not an Attribute, Reference, or an AssociationEnd
            OclSemanticException ex = new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0730, new Object[] { name, StringHelper.toPathName( ( (ModelElementInternal) sourceType ).getQualifiedName( this.jmiCreator.getConnection( ) ) ) } );
            this.reportFatalOCLError( ex, n );
        }

        return result;
    }

    /**
     * If <code>pathName</code> identifies a variable or an implicit feature,
     * the corresponding OclExpression is returned, <code>null</code> otherwise
     */
    protected OclExpression varOrImplFeature( String name, TimeExpressionOpt te, AssociationQualifier aq, Variable n ) {

        OclExpression result = null;

        // handle the time expression
        boolean withAtPre = this.handleWithAtPre( te, n );

        List<String> qualAssocName = null;
        if ( aq != null ) {
            aq.accept( this );
            qualAssocName = (List<String>) this.getUpProperty( aq );
        }

        try {
            // lets check whether it is a variable
            org.omg.ocl.expressions.VariableDeclaration var = this.env.lookupVarByName( name );

            Attribute attribute = this.env.lookupImplicitAttribute( name );
            org.omg.ocl.expressions.VariableDeclaration attrVar = ( attribute != null ? this.env.findImplicitSourceForAttr( attribute.getName( ) ) : null );

            AssociationEnd assEnd = null;
            org.omg.ocl.expressions.VariableDeclaration assVar = null;
            if ( aq == null ) {
                // no extra association qualification
                assEnd = this.env.lookupImplicitAssociationEnd( name );
                assVar = ( assEnd != null ? this.env.findImplicitSourceForAssociation( assEnd.getName( ) ) : null );
            } else {
                // with extra association qualification
                assEnd = this.env.lookupImplicitQualifiedAssociationEnd( name, qualAssocName );
                assVar = ( assEnd != null ? this.env.findImplicitSourceForQualifiedAssociationEnd( assEnd, this.oclTypeChecker ) : null );
            }

            if ( var != null ) {
                // the variable exists
                result = this.jmiCreator.createVariableExp( var );

                /*
                 * check whether there is an attribute or an association end
                 * with the same name. If so, we opt for the variable, since
                 * attributes or association ends can be accessed explicitly.
                 * However, we issue a warning.
                 */
                if ( attrVar != null ) {
                    String alternativeAccess = attrVar.getVarName( ) + OclConstants.DOT + var.getVarName( );

                    String varDeclDescription = name + ": " + StringHelper.toPathName( ( (ClassifierInternal) ( (VariableDeclarationInternal) var ).getType( this.jmiCreator.getConnection( ) ) ).getQualifiedName( this.jmiCreator.getConnection( ) ) ); //$NON-NLS-1$
                    this.reportWarning( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0101, new Object[] { name, varDeclDescription, alternativeAccess } ), n );
                }

                if ( assVar != null ) {
                    String alternativeAccess = assVar.getVarName( ) + OclConstants.DOT + var.getVarName( );

                    String varDeclDescription = name + ": " + StringHelper.toPathName( ( (ClassifierInternal) ( (VariableDeclarationInternal) var ).getType( this.jmiCreator.getConnection( ) ) ).getQualifiedName( this.jmiCreator.getConnection( ) ) ); //$NON-NLS-1$
                    this.reportWarning( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0101, new Object[] { name, varDeclDescription, alternativeAccess } ), n );
                }

                // no assoc qualifier allowed
                if ( aq != null ) {
                    this.reportError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_1020 ), n );
                }

            } else {
                // could be an implicit attribute or navigation call exp.

                if ( attribute != null && assEnd != null ) {
                    // check for ambiguity
                    this.reportError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0100, name ), n );

                } else if ( attribute != null ) {
                    if ( attrVar != null ) {
                        // we have an attribute
                        var = attrVar;
                    } else {
                        this.reportError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_1013, attribute.getName( ) ), n );
                    }
                } else if ( assEnd != null ) {
                    if ( assVar != null ) {
                        // we have an assoc end
                        var = assVar;
                    } else {
                        this.reportError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_1011, assEnd.getName( ) ), n );
                    }
                }

                if ( var != null ) {
                    // create the variable
                    OclExpression source = this.jmiCreator.createVariableExp( var );
                    result = this.explicitNavOrAttrCall( source, name, withAtPre, aq, n, false );
                }
            }
        } catch ( OclSemanticException e ) {
            this.reportInternalError( e, n );
        }

        if ( withAtPre && result != null ) {
            this.setDownProperty( n, result );
            n.gettimeExpressionOpt( ).accept( this );
            result = (OclExpression) this.getUpProperty( n );
        }

        return result;
    }

    /**
     * Returns the proper part of a qualified name. Used in places where we need
     * just one piece from the full qualified name. Up to now, this is either
     * the first or the last piece. If we can't get that piece report an error.
     * If the qualified name is empty, we consider this a fatal error.
     * 
     * @param qName the qualified name to be checked
     * @param idx the part of the name that should be returned. <code>-1</code>
     * indicate that we want the last part
     * @param node the current parser node used for error reporting
     * @return the part of tha name indexed by <code>idx</code>
     */
    protected String getNamePart( List<String> qName, int idx, Node node, OclSemanticException exn ) {

        int size = qName.size( );
        String result = null;

        if ( size == 1 ) {
            result = qName.get( 0 );
        } else if ( size > 1 ) {
            // suggestive error correction, i.e. take the first or some other
            // depending on the context
            result = ( idx < 0 ) ? (String) qName.get( size - 1 ) : (String) qName.get( ( idx >= size ) ? 0 : idx );
            this.reportError( exn, node );
        }
        return result;
    }

    /**
     * Handles an implicit operation call, i.e. one that operates implicitly on
     * a source
     */
    protected void implicitOperationCall( OperationCall n ) {

        TimeExpressionOpt te = n.gettimeExpressionOpt( );
        IpathName pn = n.getpathName( );
        Iarguments origArgs = n.getarguments( );

        pn.accept( this );
        origArgs.accept( this );

        List<String> pathName = (List<String>) this.getUpProperty( (Node) pn );

        // obtain the name of the path which cannot be qualified
        String name = this.getNamePart( pathName, -1, (Node) pn, new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0003, new Object[] { StringHelper.toPathName( pathName ) } ) );

        List<OclExpression> args = (List<OclExpression>) this.getUpProperty( (Node) origArgs );
        List<Classifier> argTypes = this.getTypesForArgs( args );

        this.handleImplicitCallExpression( name, argTypes, args, te, n );
    }

    /**
     * An implicit call expression in OCL is always an operation call
     */
    protected void handleImplicitCallExpression( String name, List<Classifier> argTypes, List<OclExpression> args, TimeExpressionOpt te, OperationCall n ) {

        // we have to find the source for the implicit operation
        org.omg.ocl.expressions.VariableDeclaration var = this.env.findOptImplicitSourceForOp( name, argTypes, this.oclLookupTables, this.oclTypeChecker );

        if ( var == null ) {
            OclSemanticException exn = new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_1016, new Object[] { n.toString( ) } );
            this.reportFatalOCLError( exn, n );
        }

        OclExpression source = null;
        try {
            source = this.jmiCreator.createVariableExp( var );
        } catch ( OclSemanticException e1 ) {
            this.reportInternalError( e1, n );
        }

        this.handleOperationCall( source, ( (OclExpressionInternal) source ).getType( this.jmiCreator.getConnection( ) ), name, argTypes, args, te, n, n.getarguments( ) );
    }

    /**
     * Handles an explicit operation call, i.e. the operation is directly called
     * on a source (can only be a MOF operation)
     */
    protected void explicitOperationCall( OclExpression source, OperationCall n ) {

        TimeExpressionOpt te = n.gettimeExpressionOpt( );
        IpathName pn = n.getpathName( );
        Iarguments origArgs = n.getarguments( );

        pn.accept( this );
        origArgs.accept( this );

        List<OclExpression> args = (List<OclExpression>) this.getUpProperty( (Node) origArgs );
        List<String> pathName = (List<String>) this.getUpProperty( (Node) pn );

        // obtain the name of the path which cannot be qualified
        String opName = this.getNamePart( pathName, -1, (Node) pn, new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0003, new Object[] { StringHelper.toPathName( pathName ) } ) );

        // and the argument types
        List<Classifier> argTypes = this.getTypesForArgs( args );

        this.handleOperationCall( source, ( (OclExpressionInternal) source ).getType( this.jmiCreator.getConnection( ) ), opName, argTypes, args, te, n, n.getarguments( ) );
    }

    /**
     * Handles an operation call where the source is explicit and known.
     */
    protected void handleOperationCall( OclExpression originalSource, Classifier originalSourceType, String name, List<Classifier> argTypes, List<OclExpression> args, TimeExpressionOpt te, Node n, Iarguments nArgs ) {

        // some built-in types require special treatment

        if ( name.equals( OclConstants.OP_OCLISNEW ) && this.stereotype != POST_CONDITION ) {
            this.reportFatalOCLError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0303 ), n );

        } else if ( name.equals( OclConstants.OP_OCLASTYPE ) && args.size( ) == 1 && args.get( 0 ) instanceof TypeExp ) {
            // in case of oclAsType, the referred type need to be conform to the
            // type or the other way around
            Classifier referredType = ( (TypeExpInternal) args.get( 0 ) ).getReferredType( this.jmiCreator.getConnection( ) );
            if ( !( this.checkTypesConform( originalSourceType, referredType ) || this.checkTypesConform( referredType, originalSourceType ) ) ) {
                this.reportError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0717, new Object[] {
                    StringHelper.toPathName( ( (ModelElementInternal) referredType ).getQualifiedName( this.jmiCreator.getConnection( ) ) ),
                    StringHelper.toPathName( ( (ModelElementInternal) originalSourceType ).getQualifiedName( this.jmiCreator.getConnection( ) ) ) } ), (Node) nArgs );
            }
        }

        boolean withAtPre = this.handleWithAtPre( te, n );

        Operation op = this.lookupOperation( name, originalSourceType, argTypes, n );
        OclExpression exp = null;
        try {
            exp = this.jmiCreator.createOperationCallExp( op, originalSource, args );

            if ( withAtPre ) {
                this.setDownProperty( n, exp );
                te.accept( this );
                exp = (OclExpression) this.getUpProperty( n );
            }

        } catch ( OclSemanticException e ) {
            this.reportInternalError( e, n );
        }

        this.setUpProperty( n, exp );
    }

    /**
     * Returns a list of Types for a list of OclExressions
     */
    private List<Classifier> getTypesForArgs( List<OclExpression> args ) {

        List<Classifier> argTypes = new ArrayList<Classifier>( );
        for ( OclExpression e : args ) {
            argTypes.add( ( (OclExpressionInternal) e ).getType( this.jmiCreator.getConnection( ) ) );
        }
        return argTypes;
    }

    /**
     * Constructs the infix operator based on the two arguments and the
     * operation name
     */
    protected void infixOperation( String opName, IoclExpression child1, IoclExpression child2, Node n ) {

        // visit children
        child1.accept( this );
        child2.accept( this );

        // get children's results
        OclExpression source = (OclExpression) this.getUpProperty( (Node) child1 );
        OclExpression arg = (OclExpression) this.getUpProperty( (Node) child2 );

        OclExpression exp = null;
        // special handling for concatenation possible with strings
        if ( opName.equals( OclConstants.A_PLUS ) ) {
            exp = this.manageSpecialStringconcatenation( source, arg, (Node) child1 );
        } else {
            // get the operation
            Operation op = this.lookupOperation( opName, ( (OclExpressionInternal) source ).getType( this.jmiCreator.getConnection( ) ), ( (OclExpressionInternal) arg ).getType( this.jmiCreator.getConnection( ) ), (Node) child1 );
            try {
                exp = this.jmiCreator.createOperationCallExp( op, source, arg );
            } catch ( OclSemanticException e ) {
                this.reportInternalError( e, n );
            }
        }

        // pass the result up the tree
        this.setUpProperty( n, exp );
    }

    /**
     * handling of built-in operations
     */
    private void handleBuiltInOperation( String opName, TimeExpressionOpt te, Iarguments argsCS, IoperationCall n ) {

        argsCS.accept( this );

        if ( this.stereotype != POST_CONDITION && opName.equals( OclConstants.OP_OCLISNEW ) ) {
            this.reportFatalOCLError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0303 ), (Node) n );
        }

        // arguments
        List<OclExpression> args = (List<OclExpression>) this.getUpProperty( (Node) argsCS );
        // and the argument types
        List<Classifier> argTypes = this.getTypesForArgs( args );

        /*
         * we have to distinguish between implicit (e.g. "op()") and explicit
         * (e.g. self.op()) calls
         */
        OclExpression source = ( this.hasDownProperty( (Node) n, DEFAULTPROPERTY ) ? (OclExpression) this.getDownProperty( (Node) n ) : null );
        if ( source == null ) {
            // we have to find the source for the implicit operation
            org.omg.ocl.expressions.VariableDeclaration var = null;
            try {
                var = this.env.findImplicitSourceForOp( opName, argTypes, this.oclLookupTables, this.oclTypeChecker );
            } catch ( OclSemanticException e2 ) {
                this.reportFatalOCLError( e2, (Node) n );
            }

            try {
                source = this.jmiCreator.createVariableExp( var );
            } catch ( OclSemanticException e1 ) {
                this.reportInternalError( e1, (Node) n );
            }
        }

        this.handleOperationCall( source, ( (OclExpressionInternal) source ).getType( this.jmiCreator.getConnection( ) ), opName, argTypes, args, te, (Node) n, argsCS );
    }

    private void handleSpecialInfixOperation( String opName, TimeExpressionOpt te, Iarguments argsCS, Node n ) {

        argsCS.accept( this );

        // arguments
        List<OclExpression> args = (List<OclExpression>) this.getUpProperty( (Node) argsCS );

        if ( args.size( ) != 2 ) {
            // we can only have exactly two arguments for these infix operations
            this.reportFatalOCLError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0403, new Object[] { opName } ), n );
        }

        OclExpression source = args.get( 0 );
        OclExpression arg = args.get( 1 );

        // handle the time expression
        boolean withAtPre = this.handleWithAtPre( te, n );

        OclExpression exp = null;

        // special handling for concatenation possible with strings
        if ( opName.equals( OclConstants.A_PLUS ) ) {
            exp = this.manageSpecialStringconcatenation( source, arg, n );
        } else {
            // get the operation
            Operation op = this.lookupOperation( opName, ( (OclExpressionInternal) source ).getType( this.jmiCreator.getConnection( ) ), ( (OclExpressionInternal) arg ).getType( this.jmiCreator.getConnection( ) ), n );

            try {
                exp = this.jmiCreator.createOperationCallExp( op, source, arg );
            } catch ( OclSemanticException e ) {
                this.reportInternalError( e, n );
            }
        }

        if ( withAtPre ) {
            this.setDownProperty( n, exp );
            te.accept( this );
            exp = (OclExpression) this.getUpProperty( n );
        }

        // pass the result up the tree
        this.setUpProperty( n, exp );
    }

    /**
     * Inserts toString if required!
     */
    protected OclExpression manageSpecialStringconcatenation( OclExpression source, OclExpression arg, Node n ) {

        // we have to do implicit conversions if one of the arguments is an
        // string type
        Classifier sourceType = ( (OclExpressionInternal) source ).getType( this.jmiCreator.getConnection( ) );
        Classifier argType = ( (OclExpressionInternal) arg ).getType( this.jmiCreator.getConnection( ) );

        boolean stringConcat = false;

        if ( this.stringType.equals( sourceType ) && !( argType instanceof org.omg.ocl.types.CollectionType ) && !this.stringType.equals( argType ) ) {
            // convert the argument with a toString()
            Operation toString = this.oclLookupTables.lookupOperation( sourceType, OclConstants.OP_TOSTRING, CLASSIFIER_EMPTY_LIST, this.oclTypeChecker );
            try {
                arg = this.jmiCreator.createOperationCallExp( toString, arg );
                argType = this.stringType;
                stringConcat = true;
            } catch ( OclSemanticException e ) {
                this.reportInternalError( e, n );
            }
        } else if ( this.stringType.equals( argType ) && !( sourceType instanceof org.omg.ocl.types.CollectionType ) && !this.stringType.equals( sourceType ) ) {
            Operation toString = this.oclLookupTables.lookupOperation( sourceType, OclConstants.OP_TOSTRING, CLASSIFIER_EMPTY_LIST, this.oclTypeChecker );
            try {
                source = this.jmiCreator.createOperationCallExp( toString, source );
                sourceType = this.stringType;
                stringConcat = true;
            } catch ( OclSemanticException e ) {
                this.reportInternalError( e, n );
            }
        } else if ( this.stringType.equals( argType ) && this.stringType.equals( sourceType ) ) {
            stringConcat = true;
        }

        // construct resulting operation
        Operation op = null;
        if ( stringConcat ) {
            // get the operation
            op = this.lookupOperation( OclConstants.OP_CONCAT, sourceType, argType, n );
        } else {
            // get the operation
            op = this.lookupOperation( OclConstants.A_PLUS, sourceType, argType, n );
        }

        // resulting expression
        OclExpression exp = null;
        try {
            exp = this.jmiCreator.createOperationCallExp( op, source, arg );
        } catch ( OclSemanticException e ) {
            this.reportInternalError( e, n );
        }

        return exp;
    }

    /**
     * handles unary operations
     * 
     * @param opName het name of the operation
     * @param node the node representing the unary expression
     * @param arg the node representing the argument of the unary operation
     */
    private void unaryOperation( String opName, IoclExpression arg, Node node ) {

        // visit children
        arg.accept( this );
        // get children's results
        OclExpression source = (OclExpression) this.getUpProperty( (Node) arg );
        // get the operation
        Operation op = this.lookupOperation( opName, ( (OclExpressionInternal) source ).getType( this.jmiCreator.getConnection( ) ), CLASSIFIER_EMPTY_LIST, node );
        try {
            OperationCallExp opCall = this.jmiCreator.createOperationCallExp( op, source );
            // pass the result up the tree
            this.setUpProperty( node, opCall );
        } catch ( OclSemanticException e ) {
            this.reportInternalError( e, node );
        }
    }

    /**
     * A wrapper method for
     * {@link com.sap.tc.moin.ocl.parser.impl.env.Environment#lookupClassifierByPathName(List)}
     * .
     */
    protected Classifier lookupClassifierByPathName( String containerName, List<String> pathName, MoinLocalizedString msg, Node n ) {

        // the container name is currently not used (need to extend environment
        // model)
        Classifier c = this.env.lookupClassifierByPathName( pathName );

        if ( c == null ) {
            this.reportFatalOCLError( new OclSemanticException( msg, new Object[] { StringHelper.toPathName( pathName ) } ), n );
        }
        return c;
    }

    /**
     * A wrapper method for
     * {@link com.sap.tc.moin.ocl.parser.impl.env.Environment#lookupOperation(Classifier, String, List)}
     */
    protected Operation lookupOperation( String name, Classifier type, List<Classifier> argTypes, Node n ) {

        // the list of messages, a warning in position 0 and an error in
        // position 1
        OclSemanticException[] messages = new OclSemanticException[2];
        Operation op = this.oclLookupTables.lookupOperation( type, name, argTypes, this.oclTypeChecker, messages );

        // first check if we actually found an operation
        if ( op == null ) {
            // we did not find an operation, see if we have a better error
            // message
            if ( messages[1] != null ) {
                this.reportFatalOCLError( messages[1], n );
            } else {
                this.reportFatalOCLError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0402, new Object[] { name, StringHelper.toString( type ), StringHelper.toString( argTypes ) } ), n );
            }
        }

        // we have an operation, deal with warnings

        // provided during lookup
        if ( messages[0] != null ) {
            this.reportWarning( messages[0], n );
        }

        // test whether op is side-effect free
        if ( !op.isQuery( ) ) {
            this.reportWarning( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_1017, new Object[] { name, StringHelper.toString( argTypes ) } ), n );
        }
        return op;
    }

    /**
     * Convenient version for looking up operations with one argument
     */
    protected Operation lookupOperation( String opName, Classifier pType, Classifier argType1, Node n ) {

        List<Classifier> args = new ArrayList<Classifier>( );
        args.add( argType1 );
        return this.lookupOperation( opName, pType, args, n );
    }

    /**
     * Handles iterator operations
     * 
     * @param opName the name of the iterator operation
     * @param n the node representing the whole iterator operation
     * @param iterContents the node representing the iterator variables and the
     * body
     */
    private void iterator( String opName, IiteratorExp n, IiterContents iterContents ) {

        // get the source on which the iteration runs
        OclExpression source = (OclExpression) this.getDownProperty( (Node) n );
        OclExpression exp = null;
        if ( iterContents instanceof IteratorOneVarDecl ) {
            // an iterator with one iterator variable
            exp = this.oneVarIterator( source, opName, (IteratorOneVarDecl) iterContents, (Node) n );
        } else if ( iterContents instanceof IteratorTwoVarDecl ) {
            // an iterator with two iterator variables
            exp = this.twoVarIterator( source, opName, (IteratorTwoVarDecl) iterContents, (Node) n );
        } else {
            // an iterator with no/an implicit iterator variable
            exp = this.implVarIterator( source, opName, iterContents, (Node) n );
        }
        this.setUpProperty( (Node) n, exp );
    }

    /**
     * handles an iterator operation with an implicit iterator variable and
     * returns the corresponding OclExpression
     * 
     * @param source the source of the iterator
     * @param opName the name of the iterator operation
     * @param iterContents the body of the iterator
     * @return OclExpression representing the iteator operation
     */
    protected OclExpression implVarIterator( OclExpression source, String opName, IiterContents iterContents, Node n ) {

        CoreConnection conn = this.jmiCreator.getConnection( );
        Classifier elmType = ( (CollectionTypeInternal) ( (OclExpressionInternal) source ).getType( conn ) ).getElementType( conn );
        org.omg.ocl.expressions.VariableDeclaration var = null;
        try {
            var = this.defineVariable( OclConstants.EMPTY, elmType, null, true, true );
        } catch ( OclSemanticException e ) {
            this.reportInternalError( e, (Node) iterContents );
        }
        iterContents.accept( this );

        OclExpression body = (OclExpression) this.getUpProperty( (Node) iterContents );
        OclExpression exp = null;
        try {
            exp = this.jmiCreator.createIteratorExp( opName, source, var, null, body );
        } catch ( OclSemanticException e ) {
            this.reportFatalError( e, n );
        }

        this.env.leaveVariableScope( );

        return exp;
    }

    /**
     * Deals with an iterator with one iterator variable
     * 
     * @param source the source of the iterator operation
     * @param opName the name of the iterator operation
     * @param iterContents the body of the iterator
     * @return the finish IteratorExp
     * @throws OclSemanticException
     */
    protected OclExpression oneVarIterator( OclExpression source, String opName, IteratorOneVarDecl iterContents, Node n ) {

        // evaluate the iterContents
        this.setDownProperty( iterContents, source );
        iterContents.accept( this );

        // has exactly one variable declaration
        org.omg.ocl.expressions.VariableDeclaration iter1 = (org.omg.ocl.expressions.VariableDeclaration) this.getUpProperty( iterContents.getvariableDeclaration( ) );

        // obtain the body
        OclExpression body = (OclExpression) this.getUpProperty( (Node) iterContents.getoclExpression( ) );

        IteratorExp exp = null;
        try {
            exp = this.jmiCreator.createIteratorExp( opName, source, iter1, null, body );
        } catch ( OclSemanticException e ) {
            this.reportInternalError( e, n );
        }
        return exp;
    }

    /**
     * Deals with an iterator with 2 iterator variables
     * 
     * @param source the source of the iterator operation
     * @param opName the name of the iterator operation
     * @param iterContents the body of the iterator
     * @return the finish IteratorExp
     * @throws OclSemanticException
     */
    protected OclExpression twoVarIterator( OclExpression source, String opName, IteratorTwoVarDecl iterContents, Node n ) {

        org.omg.ocl.expressions.VariableDeclaration iter1 = null;
        org.omg.ocl.expressions.VariableDeclaration iter2 = null;

        this.setDownProperty( iterContents, source );

        // evaluate contents
        iterContents.accept( this );

        iter1 = (org.omg.ocl.expressions.VariableDeclaration) this.getUpProperty( iterContents.getvariableDeclaration( ) );
        iter2 = (org.omg.ocl.expressions.VariableDeclaration) this.getUpProperty( iterContents.getvariableDeclaration3( ) );
        OclExpression body = (OclExpression) this.getUpProperty( (Node) iterContents.getoclExpression( ) );

        IteratorExp exp = null;

        try {
            exp = this.jmiCreator.createIteratorExp( opName, source, iter1, iter2, body );
        } catch ( OclSemanticException e ) {
            this.reportError( e, n );
        }
        return exp;
    }

    /**
     * If the iterator variable is not typed properly because no type
     * information was supplied, it is assigned the proper type.
     * 
     * @param source the source of the iterator expression
     * @param iter the iterator variable to be typed
     */
    protected void typeIteratorVar( OclExpression source, org.omg.ocl.expressions.VariableDeclaration iter, Node n ) {

        CoreConnection conn = this.jmiCreator.getConnection( );
        CollectionTypeInternal sourceType = (CollectionTypeInternal) ( (OclExpressionInternal) source ).getType( conn );
        Classifier elmType = sourceType.getElementType( conn );
        VariableDeclarationImpl iterImpl = (VariableDeclarationImpl) iter;
        Classifier iterType = iterImpl.getType( conn );
        if ( iterType.equals( this.jmiCreator.getOclInvalidClass( ) ) ) {
            this.jmiCreator.changeType( iterImpl, elmType );
        } else {
            // check if the source's element type is conform to the vardecl type
            if ( !this.checkTypesConform( elmType, iterType ) ) {
                this.reportError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0607, new Object[] {
                    iter.getName( ),
                    StringHelper.toPathName( MoinMetamodelCode.getQualifiedName( conn, (ModelElement) iterType, (RefObjectImpl) iterType ) ),
                    StringHelper.toPathName( ( (ModelElementInternal) elmType ).getQualifiedName( this.jmiCreator.getConnection( ) ) ) } ), n );
            }
        }
    }

    /**
     * Introduces a new variable in a (possibly) new scope
     */
    protected org.omg.ocl.expressions.VariableDeclaration defineVariable( String name, Classifier type, OclExpression initExp, boolean declare, boolean enterNewScope ) throws OclSemanticException {

        org.omg.ocl.expressions.VariableDeclaration var = this.jmiCreator.createVariableDeclaration( name, type, initExp );
        if ( enterNewScope ) {
            this.env.enterNewVariableScope( );
        }
        if ( declare ) {
            this.env.declareVariable( var );
        }

        return var;
    }

    /**
     * defines the self variable
     */
    private org.omg.ocl.expressions.VariableDeclaration defineSelfVariable( Classifier type, Node n ) {

        try {
            return this.defineVariable( OclConstants.VAR_SELF, type, null, true, true );
        } catch ( OclSemanticException e ) {
            this.reportInternalError( e, n );
            return null;
        }
    }

    /**
     * Wrapper method for
     * {@link com.sap.tc.moin.ocl.parser.impl.env.Environment#typesConform(Classifier, Classifier)}
     * . We do handle one special case within here which is not covered in the
     * corresponding environment method: Type conformity for
     * <code>StructureType</code> elements. Since we have to convert them to
     * <code>TupleType</code> so that we can access the fields via JMI, we might
     * end up in a situation that we compare a <code>StructureType</code> with a
     * <code>TupleType</code> here. Example from the MOF model constraints:
     * <code>context MultiplicityType inv: 
     *  let mt:MultiplicityType = self in mt.lower >= 0 and mt.upper <> Model::Unbounded
     * </code> Here, <code>self</code> would have been converted to
     * <code>TupleType</code>, but <code>mt</code> not (yet).
     * 
     * @param type1 the first model element type
     * @param type2 the second model element type
     * @return <code>true</code> if both types are conform, <code>false</code>
     * otherwise
     */
    protected boolean checkTypesConform( Classifier type1, Classifier type2 ) {

        boolean conform = type1 == null || type2 == null;
        /*
         * Special case: One of the two types is a StructureType; then it
         * conforms to a TupleType with the same name. Later, that StructureType
         * should then be converted to a TupleType, too.
         */
        if ( !conform && ( ( type1 instanceof StructureType && type2 instanceof org.omg.ocl.types.TupleType ) || ( type1 instanceof TupleType && type2 instanceof StructureType ) ) ) {
            conform = type1.getName( ).equals( type2.getName( ) );
        }

        /*
         * Do the ordinary type cheking via environment
         */
        if ( !conform ) {
            conform = this.oclTypeChecker.typesConform( type1, type2 );
        }
        return conform;
    }

    protected void handleVariableAssignment( WithTypeExpression withType, IoclExpression exp, String name, Node n ) {

        // get the initial expression
        exp.accept( this );
        OclExpression initExp = (OclExpression) this.getUpProperty( (Node) exp );
        // get its type
        Classifier typeOfExp = ( (OclExpressionInternal) initExp ).getType( this.jmiCreator.getConnection( ) );

        Classifier explicitType = null;
        if ( withType != null ) {
            withType.accept( this );

            Object o = this.getUpProperty( withType );

            if ( o instanceof Classifier ) {
                explicitType = (Classifier) o;
            } else if ( o instanceof List ) {
                List<String> pathName = (List<String>) o;

                // we perhaps have a container name
                String containerName = null;
                if ( this.hasUpProperty( withType, OclConstants.N_CONTAINERNAME ) ) {
                    containerName = (String) this.getUpProperty( withType, OclConstants.N_CONTAINERNAME );
                }

                explicitType = this.lookupClassifierByPathName( containerName, pathName, OclParserMessages.MOIN_OCL_PARSER_0710, n );
            } else {
                this.reportInternalError( withType, OclParserMessages.EXPLICITASSIGNMENTRESULT );
            }

            // the type of the expression has to conform the (optional) explicit
            // type
            if ( !this.checkTypesConform( typeOfExp, explicitType ) ) {
                this.reportError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0712, new Object[] {
                    StringHelper.toPathName( ( (ModelElementInternal) typeOfExp ).getQualifiedName( this.jmiCreator.getConnection( ) ) ),
                    StringHelper.toPathName( ( (ModelElementInternal) explicitType ).getQualifiedName( this.jmiCreator.getConnection( ) ) ) } ), n );
                explicitType = this.jmiCreator.getOclInvalidClass( );
            }
        } else {
            explicitType = typeOfExp;
        }

        // build the assignment
        org.omg.ocl.expressions.VariableDeclaration var = null;
        try {
            var = this.jmiCreator.createVariableDeclaration( name, explicitType, initExp );
        } catch ( OclSemanticException e ) {
            this.reportInternalError( e, n );
        }
        this.setUpProperty( n, var );
    }

    protected void handleVariableDeclaration( WithTypeExpression withType, String name, Node n ) {

        Classifier type = null;
        if ( withType != null ) {
            withType.accept( this );

            Object o = this.getUpProperty( withType );

            if ( o instanceof Classifier ) {
                type = (Classifier) o;
            } else if ( o instanceof List ) {
                List<String> pathName = (List<String>) o;

                // we perhaps have a container name
                String containerName = null;
                if ( this.hasUpProperty( withType, OclConstants.N_CONTAINERNAME ) ) {
                    containerName = (String) this.getUpProperty( withType, OclConstants.N_CONTAINERNAME );
                }

                type = this.lookupClassifierByPathName( containerName, pathName, OclParserMessages.MOIN_OCL_PARSER_0710, n );
            } else {
                this.reportInternalError( withType, OclParserMessages.EXPLICITASSIGNMENTRESULT );
            }
        } else {
            type = this.jmiCreator.getOclInvalidClass( );
        }

        org.omg.ocl.expressions.VariableDeclaration var = null;
        try {
            var = this.jmiCreator.createVariableDeclaration( name, type, null );
        } catch ( OclSemanticException e ) {
            this.reportInternalError( e, n );
        }
        this.setUpProperty( n, var );
    }

    /**
     * Checks whether tuple variables are correct, i.e. whether they are
     * initialized correctly and whether their names are unique.
     */
    private boolean checkTupleVariables( List<org.omg.ocl.expressions.VariableDeclaration> varDecls, boolean mustBeInitialized, Node n ) {

        boolean result = true;

        Set<String> varNames = new HashSet<String>( );
        // we check for initialization and unique names
        for ( Iterator<org.omg.ocl.expressions.VariableDeclaration> i = varDecls.iterator( ); i.hasNext( ); ) {
            VariableDeclarationInternal var = (VariableDeclarationInternal) i.next( );
            if ( mustBeInitialized ) {
                if ( var.getInitExpression( this.jmiCreator.getConnection( ) ) == null ) {
                    this.reportInternalError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0707, new Object[] { var.getVarName( ) } ), n );
                    result = false;
                }
            } else {
                if ( var.getInitExpression( this.jmiCreator.getConnection( ) ) != null ) {
                    this.reportInternalError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0708, new Object[] { var.getVarName( ) } ), n );
                    result = false;
                }
            }
            if ( varNames.contains( var.getVarName( ) ) ) {
                this.reportError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0709 ), n );
                result = false;
            }
            varNames.add( var.getVarName( ) );
        }

        return result;
    }

    /**
     * Concenience method to create a new
     * {@link com.sap.tc.moin.ocl.utils.OclStatement} instance.
     * 
     * @param name the name of that statement
     * @param expr the OCL expression associated with that statement
     * @param stereotype the stereotype of that statement
     * @return a new OCL statement instance
     */
    private OclStatement createStatement( String name, OclExpression expr, int kind ) {

        return this.createStatement( name, expr, null, kind );
    }

    /**
     * Convenience method to create a new
     * {@link com.sap.tc.moin.ocl.utils.OclStatement} instance.
     * 
     * @param name the name of that statement
     * @param expr the OCL expression associated with that statement
     * @param context the context associated with that statement
     * @param stereotype the stereotype of that statement
     * @return a new OCL statement instance
     */
    private OclStatement createStatement( String name, OclExpression expr, RefObject context, int kind ) {

        return new OclStatementImpl( ( context != null ) ? context : this.env.getContext( ), expr, kind, ( name != null ) ? name : OclConstants.EMPTY );
    }

    /**
     * Retrieves the context (meta class) of a class and asserts that the
     * context meta class is actually an instance of a reference (meta) class.
     * 
     * @param clazz the class for which we want to retrieve the context (meta)
     * class
     * @param refClass the reference (meta) class against which the context
     * (meta) class is checked
     * @param errMsg the error message to be printed if retrieval fails
     * @return the context (meta) class associated with the class
     */
    protected RefObject getContextAs( Class clazz, Class refClass, MoinLocalizedString errMsg, Node n ) {

        RefObject context = this.env.getContext( );
        if ( context == null ) {
            this.reportFatalOCLError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0505 ), n );
        }

        if ( !clazz.isInstance( context ) ) {
            context = context.refMetaObject( );
        }
        if ( !refClass.isInstance( context ) ) {
            this.reportFatalOCLError( new OclSemanticException( errMsg ), n );
        }
        return context;
    }

    /**
     * Again, retrieves the context (meta class) of a class and asserts that the
     * class is actually an instance of either one of the reference (meta)
     * classes.
     * 
     * @param clazz the class for which we want to retrieve the context (meta)
     * class
     * @param refClass1 the first reference (meta) class against which the
     * context (meta) class is checked
     * @param refClass2 the second reference (meta) class against which the
     * context (meta) class is checked
     * @param errMsg the error message to be printed if retrieval fails
     * @param tok the current parser token used in error reporting
     * @return the context (meta) class associated with the class
     */
    private RefObject getContextAs( Class clazz, Class refClass1, Class refClass2, MoinLocalizedString errMsg, Node n ) {

        RefObject context = this.env.getContext( );
        if ( !( clazz.isInstance( context ) ) ) {
            context = context.refMetaObject( );
        }
        if ( !refClass2.isInstance( context ) && !refClass1.isInstance( context ) ) {
            this.reportFatalOCLError( new OclSemanticException( errMsg ), n );
        }
        return context;
    }

    protected void handleIterate( org.omg.ocl.expressions.VariableDeclaration var, OclExpression source, VariableAssignment assignment, IoclExpression oclExp, Node n ) {

        assignment.accept( this );

        org.omg.ocl.expressions.VariableDeclaration accu = (org.omg.ocl.expressions.VariableDeclaration) this.getUpProperty( assignment );

        try {
            this.env.declareVariable( accu );
        } catch ( OclSemanticException e1 ) {
            this.reportInternalError( e1, n );
        }

        oclExp.accept( this );

        OclExpression body = (OclExpression) this.getUpProperty( (Node) oclExp );

        // verify if the assignment's type is conform to that of the body
        if ( !this.checkTypesConform( ( (VariableDeclarationInternal) accu ).getType( this.jmiCreator.getConnection( ) ), ( (OclExpressionInternal) body ).getType( this.jmiCreator.getConnection( ) ) ) ) {
            this.reportError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0606, new Object[] {
                accu.getName( ),
                StringHelper.toPathName( ( (ClassifierInternal) ( (VariableDeclarationInternal) accu ).getType( this.jmiCreator.getConnection( ) ) ).getQualifiedName( this.jmiCreator.getConnection( ) ) ),
                StringHelper.toPathName( ( (ClassifierInternal) ( (OclExpressionInternal) body ).getType( this.jmiCreator.getConnection( ) ) ).getQualifiedName( this.jmiCreator.getConnection( ) ) ) } ), n );
        }

        IterateExp iterate = null;
        try {
            iterate = this.jmiCreator.createIterate( source, var, null, accu, body );
        } catch ( OclSemanticException e ) {
            this.reportInternalError( e, n );
        }

        this.setUpProperty( n, iterate );
    }

    private void handleRange( OclExpression exp1, OclExpression exp2, Node n ) {

        Classifier c = this.oclTypeChecker.commonSuperType( ( (OclExpressionInternal) exp1 ).getType( this.jmiCreator.getConnection( ) ), ( (OclExpressionInternal) exp2 ).getType( this.jmiCreator.getConnection( ) ) );

        if ( c.equals( this.jmiCreator.getOclInvalidClass( ) ) ) {
            // no common supertype found. report error
            this.reportError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0704, new Object[] {
                StringHelper.toString( ( (OclExpressionInternal) exp1 ).getType( this.jmiCreator.getConnection( ) ) ),
                StringHelper.toString( ( (OclExpressionInternal) exp2 ).getType( this.jmiCreator.getConnection( ) ) ) } ), n );
        }

        if ( this.checkTypesConform( c, this.integerType ) || this.checkTypesConform( c, this.longType ) ) {
            org.omg.ocl.expressions.CollectionRange range;
            try {
                range = this.jmiCreator.createCollectionRange( exp1, exp2, c );
                this.setUpProperty( n, range );

            } catch ( OclSemanticException e ) {
                this.reportInternalError( e, n );
            }
        } else {
            this.reportError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0705 ), n );
        }
    }

    static final class OperationSignature {

        String opName;

        List<String> classifierName;

        List<Parameter> parameters;
    }

    /**
     * Defines the parameters of an operation as variables in the current
     * variable scope. The names of the variables are defined by
     * <code>Parameter</code>s of operation <code>op</code>. If
     * <code>parameterNames</code> is not <tt>null</tt>, the names of the
     * parameters of the actual operation have to match the names provided by
     * <code>parameterNames</code> This is used for operation contexts
     * 
     * @param op the operation
     * @param parameterNames a list of <code>Parameter</code> which represent
     * the names of the parameters given in the text. Can be <tt>null</tt>.
     */
    private void defineParameterAsVariables( Operation op, List<String> parameterNames, List<Classifier> parameterTypes, Node n ) {

        // go through all parameters of the operation
        int parNameIndex = 0;
        for ( Iterator<ModelElement> i = ( (JmiList<ModelElement>) ( (OperationInternal) op ).getContents( this.jmiCreator.getConnection( ) ) ).iteratorReadOnly( this.jmiCreator.getConnection( ).getSession( ) ); i.hasNext( ); ) {
            ModelElement content = i.next();
            if (content instanceof Parameter) {
		Parameter par = (Parameter) content;
		// only care about input parameter
		if (par.getDirection() == DirectionKindEnum.IN_DIR) {
		    // this is the model-based parameter name
		    String parName = par.getName();
		    if (parameterNames != null) {
			// if another parameter name is given in the textual
			// representation
			// it has to match the parameter name from the model
			String userDefinedParName = parameterNames.get(parNameIndex);
			if (!parName.equals(userDefinedParName)) {
			    this.reportError(new OclSemanticException(OclParserMessages.MOIN_OCL_PARSER_0800, new Object[] {
				    userDefinedParName, parName }), n);
			}
		    }
		    // 

		    // create a variable declaration for the parameter
		    try {
			this.defineVariable(parName, parameterTypes.get(parNameIndex), null, true, false);
		    } catch (OclSemanticException e) {
			this.reportInternalError(e, n);
		    }

		    parNameIndex++;
		}
	    }
        }
    }

    private void handleInitialContext( Node n ) {

        // the context has to be a classifier
        Classifier context = (Classifier) this.getContextAs( Classifier.class, Classifier.class, OclParserMessages.MOIN_OCL_PARSER_1000, n );

        // the context is supplied externally - we have to define self
        this.defineSelfVariable( context, n );
    }

    /*
     * VISITORS
     */

    @Override
    public void unimplementedVisitor( String s ) {

//        InternalException ex = new InternalException( this.INTERNALMESSAGE, OclParserMessages.NOVISITORIMPLEMENTED, s );
//        ProcessError error = new ProcessErrorImpl( ex );
//        this.report.reportFatalError( error );
//        throw new FatalParsingException( ex, error );
    }

    @Override
    public void visit( NodeToken n ) {

        super.visit( n );
    }

    @Override
    /*
     * <b> <li>argumentN ::= argumentN , oclExpression </b>
     */
    public void visit( Arguments n ) {

        n.getargumentN( ).accept( this );
        n.getoclExpression( ).accept( this );

        Object o = this.getUpProperty( (Node) n.getargumentN( ) );
        OclExpression arg = (OclExpression) this.getUpProperty( (Node) n.getoclExpression( ) );
        List<OclExpression> args = new ArrayList<OclExpression>( );
        if ( o instanceof List ) {
            args = (List<OclExpression>) o;
        } else if ( o instanceof OclExpression ) {
            args.add( (OclExpression) o );
        } else {
            this.reportInternalError( n, OclParserMessages.UNEXPECTEDPROPERTYVISITARGUMENTS );
        }
        args.add( arg );
        this.setUpProperty( n, args );
    }

    @Override
    /*
     * <b> <li>arguments ::= ( ) </b>
     */
    public void visit( NoArguments n ) {

        List<OclExpression> args = new ArrayList<OclExpression>( 0 );
        this.setUpProperty( n, args );
    }

    @Override
    /*
     * <b> <li>arguments ::= ( argumentN ) </b>
     */
    public void visit( MultipleArguments n ) {

        n.getargumentN( ).accept( this );
        Object o = this.getUpProperty( (Node) n.getargumentN( ) );
        if ( o instanceof List ) {
            this.setUpProperty( n, o );
        } else if ( o instanceof OclExpression ) {
            // if we only had one argument, we have to wrap it
            List<OclExpression> args = new ArrayList<OclExpression>( 1 );
            args.add( (OclExpression) o );
            this.setUpProperty( n, args );
        } else {
            this.reportInternalError( (Node) n.getargumentN( ), OclParserMessages.MULTIARGNOTLISTOREXPR );
        }
    }

    @Override
    /*
     * <b> <li>associationQualifier ::= [ pathName ] </b>
     */
    public void visit( AssociationQualifier n ) {

        n.getpathName( ).accept( this );
        this.setUpProperty( n, this.getUpProperty( (Node) n.getpathName( ) ) );
    }

    @Override
    /*
     * <b> <li>attrOrAssocContext ::= context sPathName withTypeExpression
     * initOrDerValueN </b>
     */
    public void visit( AttrOrAssocContextDecl n ) {

        // get pathname
        n.getsPathName( ).accept( this );
        List<String> pn = (List<String>) this.getUpProperty( (Node) n.getsPathName( ) );

        List<String> ownerQName = pn.subList( 0, pn.size( ) - 1 );
        String featureName = pn.get( pn.size( ) - 1 );

        // evaluate the specified type
        Classifier specifiedType = null;

        n.getwithTypeExpression( ).accept( this );
        Object o = this.getUpProperty( n.getwithTypeExpression( ) );

        if ( o instanceof Classifier ) {
            specifiedType = (Classifier) o;
        } else if ( o instanceof List ) {
            List<String> pathName = (List<String>) o;

            // we perhaps have a container name
            String containerName = null;
            if ( this.hasUpProperty( n.getwithTypeExpression( ), OclConstants.N_CONTAINERNAME ) ) {
                containerName = (String) this.getUpProperty( n.getwithTypeExpression( ), OclConstants.N_CONTAINERNAME );
            }

            specifiedType = this.lookupClassifierByPathName( containerName, pathName, OclParserMessages.MOIN_OCL_PARSER_0710, n );
        } else {
            this.reportInternalError( n.getwithTypeExpression( ), OclParserMessages.EXPLICITASSIGNMENTRESULT );
        }

        // lookup owner and lookup feature
        try {
            Classifier owner = this.lookupClassifierByPathName( null, ownerQName, OclParserMessages.MOIN_OCL_PARSER_0710, (Node) n.getsPathName( ) );
            ModelElement me = null;
            try {
                me = this.oclLookupTables.lookupFeature( owner, featureName );
            } catch ( OclSemanticException e ) {
                this.reportFatalOCLError( e, (Node) n.getsPathName( ) );
            }
            Classifier actualType = null;
            // check what the feature really is
            if ( me instanceof Attribute ) {
                actualType = ( (AttributeInternal) me ).getType( this.jmiCreator.getConnection( ) );
                // test whether the specified type conforms to the attribute's
                // type
            } else if ( me instanceof AssociationEnd ) {
                actualType = ( (AssociationEndInternal) me ).getType( this.jmiCreator.getConnection( ) );
            } else if ( me instanceof Reference ) {
                actualType = ( (AssociationEndInternal) ( (ReferenceInternal) me ).getReferencedEnd( this.jmiCreator.getConnection( ) ) ).getType( this.jmiCreator.getConnection( ) );
            } else if ( me instanceof StructureField ) {
                actualType = ( (StructureFieldInternal) me ).getType( this.jmiCreator.getConnection( ) );
            } else {
                OclSemanticException e = new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0203, featureName, owner.getName( ) );
                this.reportFatalOCLError( e, (Node) n.getsPathName( ) );
            }

            if ( !this.checkTypesConform( specifiedType, actualType ) ) {
                this.reportError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0711, StringHelper.toPathName( ( (ModelElementInternal) specifiedType ).getQualifiedName( this.jmiCreator.getConnection( ) ) ), StringHelper.toPathName( ( (ModelElementInternal) actualType )
                    .getQualifiedName( this.jmiCreator.getConnection( ) ) ) ), n.getwithTypeExpression( ) );
            }

            this.defineSelfVariable( owner, n );
            this.env.setContext( me );

            // continue
            n.getinitOrDerValueN( ).accept( this );
            this.env.leaveVariableScope( );
        } catch ( OclSemanticException e ) {
            this.reportInternalError( e, n );
        }
    }

    @Override
    /*
     * attrOrNavCall $AttrOrNavCall ::= pathName timeExpressionOpt
     * associationQualifierOpt
     */
    public void visit( AttrOrNavCall n ) {

        OclExpression source = (OclExpression) this.getDownProperty( n );
        n.getpathName( ).accept( this );
        List<String> pathName = (List<String>) this.getUpProperty( (Node) n.getpathName( ) );

        // we perhaps have a container name
        String containerName = null;
        if ( this.hasUpProperty( (Node) n.getpathName( ), OclConstants.N_CONTAINERNAME ) ) {
            containerName = (String) this.getUpProperty( (Node) n.getpathName( ), OclConstants.N_CONTAINERNAME );
            // TODO consider the container name
        }

        OclExpression exp = this.explicitNavOrAttrCall( source, pathName, n.gettimeExpressionOpt( ), n.getassociationQualifierOpt( ), n );
        this.setUpProperty( n, exp );
    }

    @Override
    /*
     * <b> <li>collectionKind ::= Bag </b>
     */
    public void visit( BagKind n ) {

        this.setUpProperty( n, OclConstants.N_BAG );
    }

    @Override
    public void visit( BooleanLiteralFalse n ) {

        try {
            BooleanLiteralExp boolLit = this.jmiCreator.createBooleanLiteralExp( OclConstants.FALSE );
            this.setUpProperty( n, boolLit );
        } catch ( OclSemanticException e ) {
            this.reportInternalError( e, n );
        }
    }

    @Override
    /*
     * <b> <li>booleanLiteral ::= false </b>
     */
    public void visit( BooleanLiteralTrue n ) {

        try {
            BooleanLiteralExp boolLit = this.jmiCreator.createBooleanLiteralExp( OclConstants.TRUE );
            this.setUpProperty( n, boolLit );
        } catch ( OclSemanticException e ) {
            this.reportInternalError( e, n );
        }
    }

    @Override
    /*
     * <b> <li>operationCall ::= allInstances timeExpressionOpt arguments </b>
     */
    public void visit( CallAllInstances n ) {

        this.handleBuiltInOperation( OclConstants.OP_ALLINSTANCES, n.gettimeExpressionOpt( ), n.getarguments( ), n );
    }

    @Override
    /*
     * <b> <li>operationCall ::= and timeExpressionOpt arguments </b>
     */
    public void visit( CallAnd n ) {

        this.handleSpecialInfixOperation( OclConstants.OP_AND, n.gettimeExpressionOpt( ), n.getarguments( ), n );
    }

    @Override
    /*
     * <b> <li>operationCall ::= / timeExpressionOpt arguments </b>
     */
    public void visit( CallDivide n ) {

        this.handleSpecialInfixOperation( OclConstants.A_DIV, n.gettimeExpressionOpt( ), n.getarguments( ), n );
    }

    @Override
    /*
     * <b> <li>operationCall ::= = timeExpressionOpt arguments </b>
     */
    public void visit( CallEqual n ) {

        this.handleSpecialInfixOperation( OclConstants.A_EQ, n.gettimeExpressionOpt( ), n.getarguments( ), n );
    }

    @Override
    /*
     * <b> <li>operationCall ::= > timeExpressionOpt arguments </b>
     */
    public void visit( CallGreater n ) {

        this.handleSpecialInfixOperation( OclConstants.A_GT, n.gettimeExpressionOpt( ), n.getarguments( ), n );
    }

    @Override
    /*
     * <b> <li>operationCall ::= >= timeExpressionOpt arguments </b>
     */
    public void visit( CallGreaterEqual n ) {

        this.handleSpecialInfixOperation( OclConstants.A_GTEQ, n.gettimeExpressionOpt( ), n.getarguments( ), n );
    }

    @Override
    /*
     * <b> <li>operationCall ::= < timeExpressionOpt arguments </b>
     */
    public void visit( CallLess n ) {

        this.handleSpecialInfixOperation( OclConstants.A_LT, n.gettimeExpressionOpt( ), n.getarguments( ), n );
    }

    @Override
    /*
     * <b> <li>operationCall ::= <= timeExpressionOpt arguments </b>
     */
    public void visit( CallLessEqual n ) {

        this.handleSpecialInfixOperation( OclConstants.A_LTEQ, n.gettimeExpressionOpt( ), n.getarguments( ), n );
    }

    @Override
    /*
     * <b> <li>operationCall ::= timeExpressionOpt arguments </b>
     */
    public void visit( CallMult n ) {

        this.handleSpecialInfixOperation( OclConstants.A_MULT, n.gettimeExpressionOpt( ), n.getarguments( ), n );
    }

    @Override
    /*
     * <b> <li>operationCall ::= <> timeExpressionOpt arguments </b>
     */
    public void visit( CallNotEqual n ) {

        this.handleSpecialInfixOperation( OclConstants.A_NEQ, n.gettimeExpressionOpt( ), n.getarguments( ), n );
    }

    @Override
    /*
     * <b> <li>operationCall ::= oclAsType timeExpressionOpt arguments </b>
     */
    public void visit( CallOclAsType n ) {

        this.handleBuiltInOperation( OclConstants.OP_OCLASTYPE, n.gettimeExpressionOpt( ), n.getarguments( ), n );
    }

    @Override
    /*
     * <b> <li>operationCall ::= oclIsInvalid timeExpressionOpt arguments </b>
     */
    public void visit( CallOclIsInvalid n ) {

        this.handleBuiltInOperation( OclConstants.OP_OCLISINVALID, n.gettimeExpressionOpt( ), n.getarguments( ), n );
    }

    @Override
    /*
     * <b> <li>operationCall ::= oclIsKindOf timeExpressionOpt arguments </b>
     */
    public void visit( CallOclIsKindOf n ) {

        this.handleBuiltInOperation( OclConstants.OP_OCLISKINDOF, n.gettimeExpressionOpt( ), n.getarguments( ), n );
    }

    // @Override
    // /**
    // * <b>
    // * <li>operationCall ::= oclIsNew timeExpressionOpt arguments </b>
    // */
    // public void visit(CallOclIsNew n) {
    // handleBuiltInOperation("oclIsNew", n.gettimeExpressionOpt(),
    // n.getarguments(), n);
    // }

    @Override
    /*
     * <b> <li>operationCall ::= oclIsTypeOf timeExpressionOpt arguments </b>
     */
    public void visit( CallOclIsTypeOf n ) {

        this.handleBuiltInOperation( OclConstants.OP_OCLISTYPEOF, n.gettimeExpressionOpt( ), n.getarguments( ), n );
    }

    @Override
    /*
     * <b> <li>operationCall ::= oclIsUndefined timeExpressionOpt arguments </b>
     */
    public void visit( CallOclIsUndefined n ) {

        this.handleBuiltInOperation( OclConstants.OP_OCLISUNDEFINED, n.gettimeExpressionOpt( ), n.getarguments( ), n );
    }

    @Override
    /*
     * <b> <li>operationCall ::= or timeExpressionOpt arguments </b>
     */
    public void visit( CallOr n ) {

        this.handleSpecialInfixOperation( OclConstants.OP_OR, n.gettimeExpressionOpt( ), n.getarguments( ), n );
    }

    @Override
    /*
     * <b> <li>operationCall ::= + timeExpressionOpt arguments </b>
     */
    public void visit( CallPlus n ) {

        this.handleSpecialInfixOperation( OclConstants.A_PLUS, n.gettimeExpressionOpt( ), n.getarguments( ), n );
    }

    @Override
    /*
     * <b> <li>operationCall ::= xor timeExpressionOpt arguments </b>
     */
    public void visit( CallXor n ) {

        this.handleSpecialInfixOperation( OclConstants.OP_XOR, n.gettimeExpressionOpt( ), n.getarguments( ), n );
    }

    @Override
    /*
     * <b> <li>Rule 70: classifierContextDecl ::= context sPathName invOrDefN
     * </b>
     */
    public void visit( ClassifierContextDecl n ) {

        n.getsPathName( ).accept( this );

        List<String> pathName = (List<String>) this.getUpProperty( (Node) n.getsPathName( ) );
        Classifier context = this.lookupClassifierByPathName( null, pathName, OclParserMessages.MOIN_OCL_PARSER_0501, n );
        try {
            this.env.setContext( context );
        } catch ( OclSemanticException e ) {
            this.reportInternalError( e, n );
        }

        n.getinvOrDefN( ).accept( this );
    }

    @Override
    /*
     * <b> <li>collectionKind ::= Collection </b>
     */
    public void visit( CollectionKind n ) {

        this.setUpProperty( n, OclConstants.N_COLLECTION );
    }

    @Override
    /*
     * <b> <li>collectionLiteral ::= collectionKind { collectionLiteralPartM }
     * </b>
     */
    public void visit( CollectionLiteral n ) {

        n.getcollectionKind( ).accept( this );
        Object o = null;
        if ( n.getcollectionLiteralPartM( ) != null ) {
            n.getcollectionLiteralPartM( ).accept( this );
            o = this.getUpProperty( (Node) n.getcollectionLiteralPartM( ) );
        }

        String kind = (String) this.getUpProperty( (Node) n.getcollectionKind( ) );

        /*
         * CollectionLiteralPartM can be many things ..
         */
        List<CollectionLiteralPart> parts = new ArrayList<CollectionLiteralPart>( );
        if ( o instanceof List ) {
            parts = (List<CollectionLiteralPart>) o;
        } else if ( o instanceof CollectionLiteralPart ) {
            parts.add( (CollectionLiteralPart) o );
        } else if ( o instanceof OclExpression ) {
            CollectionLiteralPart clp;
            try {
                clp = this.jmiCreator.createCollectionItem( (OclExpression) o );
                parts.add( clp );
            } catch ( OclSemanticException e ) {
                this.reportInternalError( e, n );
            }
        }

        // determine the element type of the collection
        Classifier type = this.jmiCreator.getOclVoidClass( );
        // Classifier type = this.jmiCreator.getOclInvalidClass();

        for ( CollectionLiteralPart p : parts ) {
            type = this.oclTypeChecker.commonSuperType( type, ( (CollectionLiteralPartInternal) p ).getType( this.jmiCreator.getConnection( ) ) );
        }

        org.omg.ocl.types.CollectionType ct = null;
        if ( OclConstants.COLLKINDBAG.equals( kind ) ) {
            ct = this.jmiCreator.createBagType( type );
        } else if ( OclConstants.COLLKINDSET.equals( kind ) ) {
            ct = this.jmiCreator.createSetType( type );
        } else if ( OclConstants.COLLKINDSEQUENCE.equals( kind ) ) {
            ct = this.jmiCreator.createSequenceType( type );
        } else if ( OclConstants.COLLKINDORDEREDSET.equals( kind ) ) {
            ct = this.jmiCreator.createOrderedSetType( type );
        } else {
            this.reportFatalOCLError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0713, new Object[] { kind } ), n );
        }
        try {
            CollectionLiteralExp cl = this.jmiCreator.createCollectionLiteralExp( ct, parts );
            this.setUpProperty( n, cl );
        } catch ( OclSemanticException e ) {
            this.reportInternalError( e, n );
        }
    }

    @Override
    /*
     * <b> <li>collectionLiteralPartN ::= collectionLiteralPartN ,
     * collectionLiteralPart </b>
     */
    public void visit( CollectionLiteralParts n ) {

        n.getcollectionLiteralPartN( ).accept( this );
        n.getcollectionLiteralPart( ).accept( this );
        Object o1 = this.getUpProperty( (Node) n.getcollectionLiteralPartN( ) );
        Object o2 = this.getUpProperty( (Node) n.getcollectionLiteralPart( ) );
        List<CollectionLiteralPart> parts = null;
        if ( o1 instanceof List ) {
            parts = (List<CollectionLiteralPart>) o1;
        } else if ( o1 instanceof CollectionLiteralPart ) {
            parts = new ArrayList<CollectionLiteralPart>( );
            parts.add( (CollectionLiteralPart) o1 );
        } else if ( o1 instanceof OclExpression ) {
            parts = new ArrayList<CollectionLiteralPart>( );
            CollectionLiteralPart clp = null;
            try {
                clp = this.jmiCreator.createCollectionItem( (OclExpression) o1 );
            } catch ( OclSemanticException e ) {
                this.reportInternalError( e, n );
            }
            parts.add( clp );
        }
        if ( o2 instanceof CollectionLiteralPart ) {
            parts.add( (CollectionLiteralPart) o2 );
        } else if ( o2 instanceof OclExpression ) {
            CollectionLiteralPart clp = null;
            try {
                clp = this.jmiCreator.createCollectionItem( (OclExpression) o2 );
            } catch ( OclSemanticException e ) {
                this.reportInternalError( e, n );
            }
            parts.add( clp );
        }

        this.setUpProperty( n, parts );
    }

    @Override
    /*
     * <b> <li>propertyInvocation ::= -> propertyCall </b>
     */
    public void visit( CollectionPropertyInvocation n ) {

        OclExpression source = (OclExpression) this.getDownProperty( n );
        Classifier sourceType = ( (OclExpressionInternal) source ).getType( this.jmiCreator.getConnection( ) );
        if ( sourceType instanceof org.omg.ocl.types.CollectionType ) {
            this.setDownProperty( (Node) n.getpropertyCall( ), source );
        } else {
            // if we don't have a collection type, we make a set out of it
            Operation asSet = this.oclLookupTables.lookupOperation( sourceType, OclConstants.OP_ASSET, CLASSIFIER_EMPTY_LIST, this.oclTypeChecker );
            if ( asSet == null ) {
                this.reportInternalError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0402, new Object[] { OclConstants.OP_ASSET, StringHelper.toString( sourceType ), StringHelper.toString( CLASSIFIER_EMPTY_LIST ) } ), n );
            }
            OperationCallExp asSetCall = null;
            try {
                asSetCall = this.jmiCreator.createOperationCallExp( asSet, source );
            } catch ( OclSemanticException e ) {
                this.reportInternalError( e, n );
            }
            this.setDownProperty( (Node) n.getpropertyCall( ), asSetCall );
        }

        n.getpropertyCall( ).accept( this );

        // verify if atpre was used
        if ( this.hasUpProperty( n, OclConstants.N_WITHAPRE ) ) {
            // with at pre cannot be used with an arrow property invocation
            this.reportError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0301 ), n );
        }

        this.setUpProperty( n, this.getUpProperty( (Node) n.getpropertyCall( ) ) );
    }

    /**
     * <b> <li>collectionLiteralPart ::= oclExpression collectionRangeOpt </b>
     */
    @Override
    public void visit( CollectionLiteralExpression n ) {

        n.getoclExpression( ).accept( this );

        // obtain the expression
        OclExpression exp = (OclExpression) this.getUpProperty( (Node) n.getoclExpression( ) );

        if ( n.getcollectionRangeOpt( ) != null ) {
            // we are dealing with a range
            this.setDownProperty( n.getcollectionRangeOpt( ), exp );
            n.getcollectionRangeOpt( ).accept( this );
            this.setUpProperty( n, this.getUpProperty( n.getcollectionRangeOpt( ) ) );
        } else {

            // otherwise, just propagate upwards
            this.setUpProperty( n, exp );
        }
    }

    @Override
    /*
     * <b> <li>collectionRangeOpt ::= .. oclExpression </b>
     */
    public void visit( CollectionRange n ) {

        // obtain start expression
        OclExpression exp1 = (OclExpression) this.getDownProperty( n );

        n.getoclExpression( ).accept( this );

        OclExpression exp2 = (OclExpression) this.getUpProperty( (Node) n.getoclExpression( ) );
        this.handleRange( exp1, exp2, n );
    }

    @Override
    public void visit( CollectionLiteralIntegerRange n ) {

        n.getintegerLiteralRange( ).accept( this );

        // obtain the integer literal as an expression
        OclExpression exp1 = (IntegerLiteralExp) this.getUpProperty( n.getintegerLiteralRange( ) );

        // check if we have a minus
        if ( n.getminusOpt( ) != null ) {
            // get the operation
            Operation op = this.lookupOperation( OclConstants.A_MINUS, ( (OclExpressionInternal) exp1 ).getType( this.jmiCreator.getConnection( ) ), CLASSIFIER_EMPTY_LIST, n.getminusOpt( ) );
            try {
                exp1 = this.jmiCreator.createOperationCallExp( op, exp1 );
            } catch ( OclSemanticException e ) {
                this.reportInternalError( e, n );
            }
        }

        n.getoclExpression( ).accept( this );

        OclExpression exp2 = (OclExpression) this.getUpProperty( (Node) n.getoclExpression( ) );
        this.handleRange( exp1, exp2, n );
    }

    @Override
    public void visit( Minus n ) {

        // don't do anything. We just need to know if it exists
    }

    /**
     * <b> <li>integerLiteralRange ::= INTEGER_RANGE_START </b>
     */
    @Override
    public void visit( IntegerLiteralRange n ) {

        String token = n.getIToken( ).toString( );
        // take of the ..
        String integerToken = token.substring( 0, token.length( ) - 2 );

        try {
            IntegerLiteralExp intLit = this.jmiCreator.createIntegerLiteralExp( integerToken );
            this.setUpProperty( n, intLit );
        } catch ( OclSemanticException e ) {
            this.reportInternalError( e, n );
        }
    }

    @Override
    /*
     * <b> <li>collectionType ::= collectionKind ( typePathName ) </b>
     */
    public void visit( com.sap.tc.moin.ocl.parser.gen.oclAst.CollectionType n ) {

        n.getcollectionKind( ).accept( this );
        n.gettypePathName( ).accept( this );

        String kind = (String) this.getUpProperty( (Node) n.getcollectionKind( ) );

        Object o = this.getUpProperty( (Node) n.gettypePathName( ) );
        Classifier type = null;
        if ( o instanceof Classifier ) {
            type = (Classifier) o;
        } else if ( o instanceof List ) {
            List<String> pathName = (List<String>) o;

            // we perhaps have a container name
            String containerName = null;
            if ( this.hasUpProperty( (Node) n.gettypePathName( ), OclConstants.N_CONTAINERNAME ) ) {
                containerName = (String) this.getUpProperty( (Node) n.gettypePathName( ), OclConstants.N_CONTAINERNAME );
            }

            type = this.lookupClassifierByPathName( containerName, pathName, OclParserMessages.MOIN_OCL_PARSER_0710, n );
        } else {
            this.reportInternalError( n, OclParserMessages.TYPEPATHNAMEUNEXPECTEDPROPERTY );
        }

        org.omg.ocl.types.CollectionType ct = null;
        if ( OclConstants.COLLKINDBAG.equals( kind ) ) {
            ct = this.jmiCreator.createBagType( type );
        } else if ( OclConstants.COLLKINDSET.equals( kind ) ) {
            ct = this.jmiCreator.createSetType( type );
        } else if ( OclConstants.COLLKINDSEQUENCE.equals( kind ) ) {
            ct = this.jmiCreator.createSequenceType( type );
        } else if ( OclConstants.COLLKINDORDEREDSET.equals( kind ) ) {
            ct = this.jmiCreator.createOrderedSetType( type );
        } else {
            this.reportFatalOCLError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0713, new Object[] { kind } ), (Node) n.getcollectionKind( ) );
        }
        this.setUpProperty( n, ct );
    }

    @Override
    /*
     * <b> <li> oclFile ::= contextBody </b>
     */
    public void visit( ContextBodyOclFile n ) {

        this.handleInitialContext( n );

        // evaluate whatever that implies
        n.getcontextBody( ).accept( this );

        this.env.leaveVariableScope( );
    }

    @Override
    /*
     * <b> <li> oclFile ::= oclExpression </b>
     */
    public void visit( OclFileOclExpression n ) {

        this.handleInitialContext( n );

        this.stereotype = EXPRESSION;
        n.getoclExpression( ).accept( this );

        this.env.leaveVariableScope( );

        OclExpression exp = (OclExpression) this.getUpProperty( (Node) n.getoclExpression( ) );

        OclStatement stmt = this.createStatement( OclConstants.EMPTY, exp, null, this.stereotype );
        this.statements.add( stmt );
    }

    @Override
    /*
     * <b> <li>contextDeclarationN ::= contextDeclarationN contextDeclaration
     * </b>
     */
    public void visit( ContextDeclarations n ) {

        // simply work over all different declarations
        n.getcontextDeclarationN( ).accept( this );
        n.getcontextDeclaration( ).accept( this );
    }

    @Override
    /*
     * <b> <li>multiplicativeExpression ::= multiplicativeExpression /
     * unaryExpression </b>
     */
    public void visit( DivideMultiplicativeExpression n ) {

        this.infixOperation( OclConstants.A_DIV, n.getmultiplicativeExpression( ), n.getunaryExpression( ), n );
    }

    @Override
    /*
     * <b> <li>relationalExpression ::= relationalExpression =
     * compareableExpression </b>
     */
    public void visit( EqualRelationalExpression n ) {

        this.infixOperation( OclConstants.A_EQ, n.getrelationalExpression( ), n.getcompareableExpression( ), n );
    }

    @Override
    /*
     * <b> <li>relationalExpression ::= relationalExpression >=
     * compareableExpression </b>
     */
    public void visit( GreaterEqualRelationalExpression n ) {

        this.infixOperation( OclConstants.A_GTEQ, n.getrelationalExpression( ), n.getcompareableExpression( ), n );
    }

    @Override
    /*
     * <b> <li>relationalExpression ::= relationalExpression >
     * compareableExpression </b>
     */
    public void visit( GreaterRelationalExpression n ) {

        this.infixOperation( OclConstants.A_GT, n.getrelationalExpression( ), n.getcompareableExpression( ), n );
    }

    @Override
    /*
     * <b> <li>identifier ::= IDENTIFIER </b>
     */
    public void visit( Ident n ) {

        String identifier = n.getIToken( ).toString( );
        identifier = this.processIdentifier( identifier );

        this.setUpProperty( n, identifier );
    }

    @Override
    /*
     * <b> <li>ifExpression ::= if oclExpression then oclExpression else
     * oclExpression endif </b>
     */
    public void visit( IfExpression n ) {

        n.getoclExpression( ).accept( this );

        OclExpression condExp = (OclExpression) this.getUpProperty( (Node) n.getoclExpression( ) );
        if ( !this.checkTypesConform( ( (OclExpressionInternal) condExp ).getType( this.jmiCreator.getConnection( ) ), this.boolType ) ) {
            this.reportFatalOCLError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0702 ), (Node) n.getoclExpression( ) );
        }

        n.getoclExpression4( ).accept( this );
        n.getoclExpression6( ).accept( this );
        OclExpression thenExp = (OclExpression) this.getUpProperty( (Node) n.getoclExpression4( ) );
        OclExpression elseExp = (OclExpression) this.getUpProperty( (Node) n.getoclExpression6( ) );

        Classifier type = this.oclTypeChecker.commonSuperType( ( (OclExpressionInternal) thenExp ).getType( this.jmiCreator.getConnection( ) ), ( (OclExpressionInternal) elseExp ).getType( this.jmiCreator.getConnection( ) ) );
        if ( type.equals( this.jmiCreator.getOclInvalidClass( ) ) ) {
            // no common supertype found. report error
            this.reportError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0703, new Object[] {
                StringHelper.toString( ( (OclExpressionInternal) thenExp ).getType( this.jmiCreator.getConnection( ) ) ),
                StringHelper.toString( ( (OclExpressionInternal) elseExp ).getType( this.jmiCreator.getConnection( ) ) ) } ), n );
        }

        try {
            IfExp ifExp = this.jmiCreator.createIfExp( condExp, thenExp, elseExp, type );
            this.setUpProperty( n, ifExp );
        } catch ( OclSemanticException e ) {
            this.reportInternalError( e, n );
        }
    }

    @Override
    /*
     * <b> <li>initOrDerValueN ::= initOrDerValueN initOrDerValue </b>
     */
    public void visit( InitOrDerValueN n ) {

        // we have a list of init or derive statements, which we simply process
        // one after each other
        n.getinitOrDerValueN( ).accept( this );
        n.getinitOrDerValue( ).accept( this );
    }

    @Override
    /*
     * <b> <li>initOrDerValue ::= init : oclExpression </b>
     */
    public void visit( InitValue n ) {

        // get the context in which the init expression works -> it has to be an
        // attribute or reference
        TypedElement context = (TypedElement) this.getContextAs( TypedElement.class, Attribute.class, StructureField.class, OclParserMessages.MOIN_OCL_PARSER_1019, n );

        // obtain the feature type
        Classifier featureType = ( (TypedElementInternal) context ).getType( this.jmiCreator.getConnection( ) );

        // define self
        this.defineSelfVariable( (Classifier) ( (ModelElementInternal) context ).getContainer( this.jmiCreator.getConnection( ) ), n );

        // check expression
        n.getoclExpression( ).accept( this );

        this.env.leaveVariableScope( );

        OclExpression exp = (OclExpression) this.getUpProperty( (Node) n.getoclExpression( ) );

        // the type of the expression must conform to the feature type
        if ( !( this.checkTypesConform( ( (OclExpressionInternal) exp ).getType( this.jmiCreator.getConnection( ) ), featureType ) ) ) {
            this.reportError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0720, new Object[] {
                StringHelper.toPathName( ( (ModelElementInternal) ( (OclExpressionInternal) exp ).getType( this.jmiCreator.getConnection( ) ) ).getQualifiedName( this.jmiCreator.getConnection( ) ) ),
                StringHelper.toPathName( ( (ModelElementInternal) featureType ).getQualifiedName( this.jmiCreator.getConnection( ) ) ) } ), n );
        }

        // construct an OclStatement and add it to the list of statements
        this.statements.add( this.createStatement( null, exp, context, INIT_EXPRESSION ) );
    }

    @Override
    /*
     * <b> <li>initOrDerValue ::= derive : oclExpression </b>
     */
    public void visit( DeriveValue n ) {

        // get the context in which the derive expression works -> it has to be
        // an attribute or reference
        StructuralFeature context = (StructuralFeature) this.getContextAs( StructuralFeature.class, Reference.class, Attribute.class, OclParserMessages.MOIN_OCL_PARSER_0512, n );

        // obtain the feature type
        Classifier featureType = ( (StructuralFeatureInternal) context ).getType( this.jmiCreator.getConnection( ) );

        // define self
        this.defineSelfVariable( (Classifier) ( (StructuralFeatureInternal) context ).getContainer( this.jmiCreator.getConnection( ) ), n );

        n.getoclExpression( ).accept( this );

        this.env.leaveVariableScope( );

        OclExpression exp = (OclExpression) this.getUpProperty( (Node) n.getoclExpression( ) );

        // The old check expected a boolean value, which is wierd as the spec
        // says that it can be anything
        // reportError(new
        // OclSemanticException(OclParserMessages.MOIN_OCL_PARSER_0719), n);
        if ( !( this.checkTypesConform( ( (OclExpressionInternal) exp ).getType( this.jmiCreator.getConnection( ) ), featureType ) ) ) {
            this.reportError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0720, new Object[] {
                StringHelper.toPathName( ( (ModelElementInternal) ( (OclExpressionInternal) exp ).getType( this.jmiCreator.getConnection( ) ) ).getQualifiedName( this.jmiCreator.getConnection( ) ) ),
                StringHelper.toPathName( ( (ModelElementInternal) featureType ).getQualifiedName( this.jmiCreator.getConnection( ) ) ) } ), n );
        }

        // construct an OclStatement and add it to the list of statements
        this.statements.add( this.createStatement( null, exp, DERIVATION ) );
    }

    @Override
    /*
     * <b> <li>integerLiteral ::= INTEGER_LITERAL </b>
     */
    public void visit( IntegerLiteral n ) {

        try {
            IntegerLiteralExp intLit = this.jmiCreator.createIntegerLiteralExp( n.getIToken( ).toString( ) );
            this.setUpProperty( n, intLit );
        } catch ( OclSemanticException e ) {
            this.reportInternalError( e, n );
        }
    }

    @Override
    /*
     * <b> <li>invalidLiteral ::= invalid </b>
     */
    public void visit( InvalidLiteral n ) {

        try {
            VariableExp exp = this.jmiCreator.createVariableExp( this.jmiCreator.getOclInvalidVariable( ) );
            this.setUpProperty( n, exp );
            // reportWarning(new
            // OclSemanticException(OclParserMessages.MOIN_OCL_PARSER_1022,
            // new Object[] { "OclInvalid literal" }), n);
        } catch ( OclSemanticException e ) {
            this.reportInternalError( e, n );
        }
    }

    @Override
    /*
     * <b> <li>invOrDef ::= def identifierOpt : defExpression </b>
     */
    public void visit( DefDeclaration n ) {

        String defName = OclConstants.EMPTY;
        // the name is optional
        if ( n.getidentifierOpt( ) != null ) {
            n.getidentifierOpt( ).accept( this );
            defName = (String) this.getUpProperty( n.getidentifierOpt( ) );
        }

        this.setDownProperty( (Node) n.getdefExpression( ), defName );

        Classifier context = (Classifier) this.getContextAs( Classifier.class, Classifier.class, OclParserMessages.MOIN_OCL_PARSER_1000, n );

        this.defineSelfVariable( context, n );
        this.stereotype = DEFINITION;

        // process the definition
        n.getdefExpression( ).accept( this );

        OclExpression exp = null;
        Object o = this.getUpProperty( (Node) n.getdefExpression( ) );

        // we have to deal with different kind of definitions
        if ( o instanceof org.omg.ocl.expressions.VariableDeclaration ) {

            this.reportFatalOCLError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_1022, "feature definition declaration" ), n ); //$NON-NLS-1$

            /*
             * ------------------------------------------------------------------
             * ---------------------
             */
            /*
             * This is currently not supported as it is unclear where the
             * variables has to be hosted
             */
            /*
             * ------------------------------------------------------------------
             * ---------------------
             */

            // the definition was handled as an attribute declaration
            org.omg.ocl.expressions.VariableDeclaration varDecl = (org.omg.ocl.expressions.VariableDeclaration) o;
            String attrName = varDecl.getName( );
            Classifier attrType = ( (VariableDeclarationInternal) varDecl ).getType( this.jmiCreator.getConnection( ) );

            // check that we do not define an already defined attribute
            ModelElement me = null;
            try {
                me = this.oclLookupTables.lookupOptFeature( context, attrName );
            } catch ( OclSemanticException e ) {
                this.reportInternalError( e, n );
            }

            if ( me != null ) {
                if ( me instanceof Attribute || me instanceof Reference ) {
                    // error name clash!
                    OclSemanticException e = new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0510, new Object[] { attrName } );
                    this.reportFatalOCLError( e, (Node) n.getdefExpression( ) );
                } else {
                    // we don't care about AssociationEnds
                }
            }

            // create the attribute
            Attribute newAttr;
            try {
                newAttr = this.jmiCreator.createAttribute( attrName, attrType );
            } catch ( OclSemanticException e1 ) {
                this.reportInternalError( e1, n );
                return;
            }
            newAttr.setAnnotation( OclConstants.OCLDEFINITION );

            // something has to happen -> the attribute definition should be
            // visible as a feature of the Context

            exp = varDecl.getInitExpression( );

            // set the definition
            OclStatement stmt = this.createStatement( defName, exp, context, this.stereotype );
            this.statements.add( stmt );

        } else if ( o instanceof OclStatement ) {

            /*
             * ------------------------------------------------------------------
             * ------------------------------
             */
            /*
             * This is currently only supported for MOF as it is unclear where
             * the operation has to be hosted
             */
            /*
             * ------------------------------------------------------------------
             * ------------------------------
             */

            this.reportWarning( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_1022, "operation definition declaration" ), (Node) n.getdefExpression( ) ); //$NON-NLS-1$

            this.statements.add( (OclStatement) o );
        }
    }

    @Override
    /*
     * <b> <li>defExpression ::= operation = oclExpression </b>
     */
    public void visit( OperationDefExpression n ) {

        boolean attachBody = false;
        String defName = (String) this.getDownProperty( n );

        // get the defined operation signature
        n.getoperation( ).accept( this );
        OperationSignature opSig = (OperationSignature) this.getUpProperty( n.getoperation( ) );

        // verify that the operation is fully qualified
        if ( opSig.classifierName != null && opSig.classifierName.size( ) > 0 ) {
            this.reportError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_1024, new Object[] { StringHelper.toPathName( opSig.classifierName ) } ), n.getoperation( ) );
        }
        String opName = opSig.opName;

        // get the context
        Classifier owner = (Classifier) this.getContextAs( Classifier.class, Classifier.class, OclParserMessages.MOIN_OCL_PARSER_1000, n );

        ModelElement me;
        try {
            me = MoinMetamodelCode.lookupElement( this.jmiCreator.getConnection( ), (Namespace) owner, (RefObjectImpl) owner, opName );
        } catch ( NameNotFoundException e1 ) {
            // the context does not know an operation of this name (which is
            // good)
            me = null;
        }

        // if we did find an element with this name in the context, it should
        // not be an operation
        if ( me != null && me instanceof Operation ) {
            // there is already another operation with that name
            this.reportFatalOCLError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0511, new Object[] { opName } ), n.getoperation( ) );
        }

        // define parameters as variables
        this.env.enterNewVariableScope( );
        Parameter resultPar = null;
        List<Parameter> parameters = opSig.parameters;
        for ( Parameter par : parameters ) {
            if ( par.getDirection( ) == DirectionKindEnum.IN_DIR ) {
                try {
                    // we define a variable direclty
                    this.defineVariable( par.getName( ), ( (ParameterInternal) par ).getType( this.jmiCreator.getConnection( ) ), null, true, false );
                } catch ( OclSemanticException e ) {
                    this.reportInternalError( e, n.getoperation( ) );
                }
            } else if ( par.getDirection( ) == DirectionKindEnum.RETURN_DIR ) {
                resultPar = par;
            }
        }

        if ( resultPar == null ) {
            this.reportFatalOCLError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_1018, opName ), n.getoperation( ) );
        }

        // create the operation
        Operation newOp = null;
        try {
            RefObject context = this.env.getContext( );
            if ( MoinMetamodelCode.getQualifiedName( this.jmiCreator.getConnection( ), (ModelElement) context, (RefObjectImpl) context ).get( 0 ).equals( OclConstants.P_MODEL ) ) {
                if ( this.env.getContext( ) instanceof Namespace ) {
                    CoreSession session = this.jmiCreator.getConnection( ).getSession( );
                    JmiList<ModelElement> contents = (JmiList<ModelElement>) ( (NamespaceInternal) context ).getContents( this.jmiCreator.getConnection( ) );
                    for ( int i = 0, j = contents.size( session ); i < j; i++ ) {
                        Object child = contents.get( session, i );
                        if ( child instanceof Operation ) {
                            Operation op = (Operation) child;
                            if ( op.getName( ).equals( opName ) ) {
                                newOp = op;
                            }
                        }
                    }
                }
            }
            if ( newOp == null ) {
                attachBody = true;
                newOp = this.jmiCreator.createHelperOperation( this.env.getContext( ), opName, parameters, resultPar );
            }
        } catch ( OclSemanticException e ) {
            this.reportInternalError( e, n.getoperation( ) );
        }

        // for the time being we use a hack:
        this.oclLookupTables.defineUserDefOperation( owner, newOp );

        n.getoclExpression( ).accept( this );

        OclExpression exp = (OclExpression) this.getUpProperty( (Node) n.getoclExpression( ) );
        if ( attachBody ) {
            this.jmiCreator.addBodyToHelper( exp, newOp );
        }

        this.env.leaveVariableScope( );

        // get the result type and check whether the type of the expression
        // conforms to it
        if ( !( this.checkTypesConform( ( (OclExpressionInternal) exp ).getType( this.jmiCreator.getConnection( ) ), ( (ParameterInternal) resultPar ).getType( this.jmiCreator.getConnection( ) ) ) ) ) {
            this.reportError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0711, new Object[] {
                StringHelper.toPathName( ( (ModelElementInternal) ( (OclExpressionInternal) exp ).getType( this.jmiCreator.getConnection( ) ) ).getQualifiedName( this.jmiCreator.getConnection( ) ) ),
                StringHelper.toPathName( ( (ModelElementInternal) ( (ParameterInternal) resultPar ).getType( this.jmiCreator.getConnection( ) ) ).getQualifiedName( this.jmiCreator.getConnection( ) ) ) } ), (Node) n.getoclExpression( ) );
        }

        // set the definition
        OclStatement stmt = this.createStatement( defName, exp, newOp, this.stereotype );

        this.setUpProperty( n, stmt );
    }

    @Override
    /*
     * <b> <li>operationContextDecl ::= context operation prePostOrBodyDeclN
     * </b>
     */
    public void visit( OperationContextDecl n ) {

        // get the defined operation signature
        n.getoperation( ).accept( this );
        OperationSignature opSig = (OperationSignature) this.getUpProperty( n.getoperation( ) );

        // verify that the operation is fully qualified
        if ( opSig.classifierName == null || opSig.classifierName.size( ) == 0 ) {
            this.reportFatalOCLError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_1023, new Object[] { opSig.opName } ), n.getoperation( ) );
        }

        // because the operation is taken from the model, we have to obtain the
        // true types
        List<Classifier> paramTypes = new ArrayList<Classifier>( );
        List<String> paramNames = new ArrayList<String>( );
        Classifier resultType = null;
        for ( Iterator<Parameter> i = opSig.parameters.iterator( ); i.hasNext( ); ) {
            Parameter par = i.next( );
            // we are only interested in the in-parameters
            if ( par.getDirection( ) == DirectionKindEnum.IN_DIR ) {
                // collect the type
                Classifier parameterType = ( (ParameterInternal) par ).getType( this.jmiCreator.getConnection( ) );
                String paramName = par.getName( );
                // if the parameter was taken from the model, we need to analyze
                // the multiplicity
                if ( par.getMultiplicity( ) != null && !( ( (ParameterInternal) par ).getType( this.jmiCreator.getConnection( ) ) instanceof CollectionType ) ) {
                    MultiplicityType mt = par.getMultiplicity( );
                    if ( /* mt.getLower() != 1 || */mt.getUpper( ) != 1 ) {
                        if ( mt.isOrdered( ) ) {
                            if ( mt.isUnique( ) ) {
                                // ordered unique -> ordered set
                                parameterType = this.jmiCreator.createOrderedSetType( parameterType );
                            } else {
                                // ordered nonunique -> sequence
                                parameterType = this.jmiCreator.createSequenceType( parameterType );
                            }
                        } else {
                            if ( mt.isUnique( ) ) {
                                // unordered unique -> set
                                parameterType = this.jmiCreator.createSetType( parameterType );
                            } else {
                                // unordered nonunique -> Bag
                                parameterType = this.jmiCreator.createBagType( parameterType );
                            }
                        }
                    }
                }
                paramTypes.add( parameterType );
                paramNames.add( paramName );
            } else if ( par.getDirection( ) == DirectionKindEnum.RETURN_DIR ) {
                // remember the return type
                resultType = ( (ParameterInternal) par ).getType( this.jmiCreator.getConnection( ) );
                // if the parameter was taken from the model, we need to analyze
                // the multiplicity
                if ( par.getMultiplicity( ) != null && !( ( (ParameterInternal) par ).getType( this.jmiCreator.getConnection( ) ) instanceof CollectionType ) ) {
                    MultiplicityType mt = par.getMultiplicity( );
                    if ( /* mt.getLower() != 1 || */mt.getUpper( ) != 1 ) {
                        if ( mt.isOrdered( ) ) {
                            if ( mt.isUnique( ) ) {
                                // ordered unique -> ordered set
                                resultType = this.jmiCreator.createOrderedSetType( resultType );
                            } else {
                                // ordered nonunique -> ordered set
                                resultType = this.jmiCreator.createSequenceType( resultType );
                            }
                        } else {
                            if ( mt.isUnique( ) ) {
                                // unordered uniqe -> set
                                resultType = this.jmiCreator.createSetType( resultType );
                            } else {
                                // unorderd nonunique -> Bag
                                resultType = this.jmiCreator.createBagType( resultType );
                            }
                        }
                    }
                }
            }
        }

        try {
            // get the classifier to which the operation belongs to
            Classifier owner = this.lookupClassifierByPathName( null, opSig.classifierName, OclParserMessages.MOIN_OCL_PARSER_0710, n.getoperation( ) );

            // lookup the operation
            Operation op = this.lookupOperation( opSig.opName, owner, paramTypes, n.getoperation( ) );

            // define its parameters as variables
            this.defineParameterAsVariables( op, paramNames, paramTypes, n.getoperation( ) );

            // self is bound to the classifier
            this.defineSelfVariable( owner, n.getoperation( ) );

            // the context is the operation
            this.env.setContext( op );

            this.stereotype = P_PRE_POST_OR_BODY_DECL;
            n.getprePostOrBodyDeclN( ).accept( this );

            this.env.leaveVariableScope( );

        } catch ( OclSemanticException e ) {
            this.reportInternalError( e, n );
        }
    }

    @Override
    /*
     * <b> <li>operation ::= sPathName ( variableDeclarationWithTypeM )
     * withTypeExpression </b>
     */
    public void visit( OperationDecl n ) {

        // deal with path name
        n.getsPathName( ).accept( this );
        List<String> opPathName = (List<String>) this.getUpProperty( (Node) n.getsPathName( ) );
        List<String> classifierName = opPathName.subList( 0, opPathName.size( ) - 1 );
        String opName = opPathName.get( opPathName.size( ) - 1 );

        // deal with the parameters
        List<Parameter> parameters = new ArrayList<Parameter>( );

        List<org.omg.ocl.expressions.VariableDeclaration> varDecls = new ArrayList<org.omg.ocl.expressions.VariableDeclaration>( );

        if ( n.getvariableDeclarationWithTypeM( ) != null ) {
            n.getvariableDeclarationWithTypeM( ).accept( this );

            Object o = this.getUpProperty( (Node) n.getvariableDeclarationWithTypeM( ) );
            if ( o instanceof List ) {
                varDecls = (List<org.omg.ocl.expressions.VariableDeclaration>) o;
            } else if ( o instanceof org.omg.ocl.expressions.VariableDeclaration ) {
                varDecls.add( (org.omg.ocl.expressions.VariableDeclaration) o );
            } else {
                this.reportInternalError( (Node) n.getvariableDeclarationWithTypeM( ), OclParserMessages.VARDECEXPECTED );
            }

            for ( org.omg.ocl.expressions.VariableDeclaration declaration : varDecls ) {
                Parameter par = this.env.lookupInParameter( classifierName, opName, declaration.getName( ), ( (VariableDeclarationInternal) declaration ).getType( this.jmiCreator.getConnection( ) ) );

                if ( par == null ) {
                    par = this.jmiCreator.createInParameter( declaration.getName( ), ( (VariableDeclarationInternal) declaration ).getType( this.jmiCreator.getConnection( ) ) );
                } else {
                    Classifier parType = this.oclTypeChecker.createOclType( par.getMultiplicity( ), ( (ParameterInternal) par ).getType( this.jmiCreator.getConnection( ) ) );
                    // verify that the actual type is conform to the declared
                    // one
                    if ( !( this.checkTypesConform( parType, ( (VariableDeclarationInternal) declaration ).getType( this.jmiCreator.getConnection( ) ) ) ) ) {
                        this.reportError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0711, new Object[] {
                            StringHelper.toPathName( ( (ModelElementInternal) parType ).getQualifiedName( this.jmiCreator.getConnection( ) ) ),
                            StringHelper.toPathName( ( (ModelElementInternal) ( (VariableDeclarationInternal) declaration ).getType( this.jmiCreator.getConnection( ) ) ).getQualifiedName( this.jmiCreator.getConnection( ) ) ) } ), n.getwithTypeExpression( ) );
                    } else if ( !( this.checkTypesConform( ( (VariableDeclarationInternal) declaration ).getType( this.jmiCreator.getConnection( ) ), parType ) ) ) {
                        this.reportError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0711, new Object[] {
                            StringHelper.toPathName( ( (ModelElementInternal) ( (VariableDeclarationInternal) declaration ).getType( this.jmiCreator.getConnection( ) ) ).getQualifiedName( this.jmiCreator.getConnection( ) ) ),
                            StringHelper.toPathName( ( (ModelElementInternal) parType ).getQualifiedName( this.jmiCreator.getConnection( ) ) ) } ), n.getwithTypeExpression( ) );
                    }
                }
                parameters.add( par );
            }
        }

        // deal with the return type
        n.getwithTypeExpression( ).accept( this );

        Classifier declaredReturnType = null;

        Object o1 = this.getUpProperty( n.getwithTypeExpression( ) );

        if ( o1 instanceof Classifier ) {
            declaredReturnType = (Classifier) o1;
        } else if ( o1 instanceof List ) {
            List<String> pathName = (List<String>) o1;

            // we perhaps have a container name
            String containerName = null;
            if ( this.hasUpProperty( n.getwithTypeExpression( ), OclConstants.N_CONTAINERNAME ) ) {
                containerName = (String) this.getUpProperty( n.getwithTypeExpression( ), OclConstants.N_CONTAINERNAME );
            }
            declaredReturnType = this.lookupClassifierByPathName( containerName, pathName, OclParserMessages.MOIN_OCL_PARSER_0710, n );
        } else {
            this.reportInternalError( n.getwithTypeExpression( ), OclParserMessages.RETURNTYPERESULT );
        }

        Parameter result = this.env.lookupReturnParameter( classifierName, opName );
        if ( result == null ) {
            result = this.jmiCreator.createReturnParameter( OclConstants.PAR_RESULT, declaredReturnType );
        } else {
            Classifier resultType = this.oclTypeChecker.createOclType( result.getMultiplicity( ), ( (ParameterInternal) result ).getType( this.jmiCreator.getConnection( ) ) );
            if ( !( this.checkTypesConform( resultType, declaredReturnType ) ) ) {
                this.reportError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0711, StringHelper.toPathName( ( (ModelElementInternal) resultType ).getQualifiedName( this.jmiCreator.getConnection( ) ) ), StringHelper.toPathName( ( (ModelElementInternal) declaredReturnType )
                    .getQualifiedName( this.jmiCreator.getConnection( ) ) ) ), n.getwithTypeExpression( ) );
            } else if ( !( this.checkTypesConform( declaredReturnType, resultType ) ) ) {
                this.reportError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0711, StringHelper.toPathName( ( (ModelElementInternal) declaredReturnType ).getQualifiedName( this.jmiCreator.getConnection( ) ) ), StringHelper.toPathName( ( (ModelElementInternal) resultType )
                    .getQualifiedName( this.jmiCreator.getConnection( ) ) ) ), n.getwithTypeExpression( ) );
            }
        }

        parameters.add( result );

        OperationSignature opSig = new OperationSignature( );
        opSig.classifierName = classifierName;
        opSig.opName = opName;
        opSig.parameters = parameters;

        this.setUpProperty( n, opSig );
    }

    @Override
    /*
     * <b> <li>prePostOrBodyDecl ::= body identifierOpt : oclExpression </b>
     */
    public void visit( BodyDecl n ) {

        String bodyName = OclConstants.EMPTY;
        // the name is optional
        if ( n.getidentifierOpt( ) != null ) {
            n.getidentifierOpt( ).accept( this );
            bodyName = (String) this.getUpProperty( n.getidentifierOpt( ) );
        }

        // context has to be an operation
        Operation op = (Operation) this.getContextAs( Operation.class, Operation.class, OclParserMessages.MOIN_OCL_PARSER_0514, n );

        Classifier resultType = this.oclTypeChecker.getReturnType( op );

        // setup context variable
        this.defineSelfVariable( (Classifier) ( (ModelElementInternal) op ).getContainer( this.jmiCreator.getConnection( ) ), n );

        this.stereotype = OPERATION_BODY;
        n.getoclExpression( ).accept( this );
        this.env.leaveVariableScope( );

        OclExpression exp = (OclExpression) this.getUpProperty( (Node) n.getoclExpression( ) );

        // check whether expr conforms to the result type of the operation
        if ( !( this.checkTypesConform( ( (OclExpressionInternal) exp ).getType( this.jmiCreator.getConnection( ) ), resultType ) ) ) {
            this.reportError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0718, new Object[] {
                StringHelper.toPathName( ( (ModelElementInternal) ( (OclExpressionInternal) exp ).getType( this.jmiCreator.getConnection( ) ) ).getQualifiedName( this.jmiCreator.getConnection( ) ) ),
                StringHelper.toPathName( ( (ModelElementInternal) resultType ).getQualifiedName( this.jmiCreator.getConnection( ) ) ) } ), (Node) n.getoclExpression( ) );
        }

        // build new OclStatement and add the statement to the list of
        // statements
        this.statements.add( this.createStatement( bodyName, exp, this.stereotype ) );
    }

    @Override
    /*
     * <b> <li>prePostOrBodyDecl ::= pre identifierOpt : oclExpression </b>
     */
    public void visit( PreConditionDecl n ) {

        String preName = OclConstants.EMPTY;
        // the name is optional
        if ( n.getidentifierOpt( ) != null ) {
            n.getidentifierOpt( ).accept( this );
            preName = (String) this.getUpProperty( n.getidentifierOpt( ) );
        }

        // the context is an operation
        Operation op = (Operation) this.getContextAs( Operation.class, Operation.class, OclParserMessages.MOIN_OCL_PARSER_0514, n );

        this.defineSelfVariable( (Classifier) ( ( (OperationInternal) op ).getContainer( this.jmiCreator.getConnection( ) ) ), n );

        this.stereotype = PRE_CONDITION;
        n.getoclExpression( ).accept( this );
        OclExpression exp = (OclExpression) this.getUpProperty( (Node) n.getoclExpression( ) );

        this.env.leaveVariableScope( );

        // check whether expr conforms to the result type of the operation
        if ( !( this.checkTypesConform( ( (OclExpressionInternal) exp ).getType( this.jmiCreator.getConnection( ) ), this.boolType ) ) ) {
            this.reportError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0502 ), (Node) n.getoclExpression( ) );
        }

        // build new OclStatement and add the statement to the list of
        // statements
        this.statements.add( this.createStatement( preName, exp, this.stereotype ) );
    }

    @Override
    /*
     * <b> <li>prePostOrBodyDecl ::= post identifierOpt : oclExpression </b>
     */
    public void visit( PostConditionDecl n ) {

        String postName = OclConstants.EMPTY;
        // the name is optional
        if ( n.getidentifierOpt( ) != null ) {
            n.getidentifierOpt( ).accept( this );
            postName = (String) this.getUpProperty( n.getidentifierOpt( ) );
        }

        // the context is an operation
        Operation op = (Operation) this.getContextAs( Operation.class, Operation.class, OclParserMessages.MOIN_OCL_PARSER_0514, n );

        // set up context variables, i.e. self and result
        this.defineSelfVariable( (Classifier) ( ( (OperationInternal) op ).getContainer( this.jmiCreator.getConnection( ) ) ), n );
        try {
            this.defineVariable( OclConstants.VAR_RESULT, this.oclTypeChecker.getReturnType( op ), null, true, false );
        } catch ( OclSemanticException e ) {
            this.reportInternalError( e, n );
        }

        this.stereotype = POST_CONDITION;
        n.getoclExpression( ).accept( this );
        OclExpression exp = (OclExpression) this.getUpProperty( (Node) n.getoclExpression( ) );

        this.env.leaveVariableScope( );

        // check whether expr conforms to the result type of the operation
        if ( !( this.checkTypesConform( ( (OclExpressionInternal) exp ).getType( this.jmiCreator.getConnection( ) ), this.boolType ) ) ) {
            this.reportError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0502 ), (Node) n.getoclExpression( ) );
        }

        // build new OclStatement and add the statement to the list of
        // statements
        this.statements.add( this.createStatement( postName, exp, this.stereotype ) );
    }

    @Override
    /*
     * <b> <li>invOrDef ::= inv identifierOpt : oclExpression </b>
     */
    public void visit( InvDeclaration n ) {

        String invName = OclConstants.EMPTY;
        // the name is optional
        if ( n.getidentifierOpt( ) != null ) {
            n.getidentifierOpt( ).accept( this );
            invName = (String) this.getUpProperty( n.getidentifierOpt( ) );
        }

        Classifier context = (Classifier) this.getContextAs( Classifier.class, Classifier.class, OclParserMessages.MOIN_OCL_PARSER_1000, n );

        this.defineSelfVariable( context, n );

        this.stereotype = INVARIANT;
        n.getoclExpression( ).accept( this );
        this.env.leaveVariableScope( );

        OclExpression exp = (OclExpression) this.getUpProperty( (Node) n.getoclExpression( ) );

        // check whether expr conforms to the result type of the operation
        if ( !( this.checkTypesConform( ( (OclExpressionInternal) exp ).getType( this.jmiCreator.getConnection( ) ), this.boolType ) ) ) {
            this.reportError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0502 ), (Node) n.getoclExpression( ) );
        }

        OclStatement stmt = this.createStatement( invName, exp, context, this.stereotype );
        this.statements.add( stmt );
    }

    @Override
    /*
     * <b> <li>invOrDef ::= exp identifierOpt : oclExpression </b>
     */
    public void visit( ExpDeclaration n ) {

        String expName = OclConstants.EMPTY;
        // the name is optional
        if ( n.getidentifierOpt( ) != null ) {
            n.getidentifierOpt( ).accept( this );
            expName = (String) this.getUpProperty( n.getidentifierOpt( ) );
        }

        Classifier context = (Classifier) this.getContextAs( Classifier.class, Classifier.class, OclParserMessages.MOIN_OCL_PARSER_1000, n );

        this.defineSelfVariable( context, n );
        this.stereotype = EXPRESSION;
        n.getoclExpression( ).accept( this );
        this.env.leaveVariableScope( );

        OclExpression exp = (OclExpression) this.getUpProperty( (Node) n.getoclExpression( ) );

        OclStatement stmt = this.createStatement( expName, exp, context, this.stereotype );
        this.statements.add( stmt );
    }

    @Override
    /*
     * <b> <li>invOrDefN ::= invOrDefN invOrDef </b>
     */
    public void visit( InvOrDefs n ) {

        // simply process over different invariants or definitions
        n.getinvOrDefN( ).accept( this );
        n.getinvOrDef( ).accept( this );
    }

    @Override
    /*
     * <b> <li>iterateExp ::= iterate ( variableAssignment | oclExpression )
     * </b>
     */
    public void visit( IterateVarDecl n ) {

        // deal with the non-existing declaration
        OclExpression source = (OclExpression) this.getDownProperty( n );
        CoreConnection conn = this.jmiCreator.getConnection( );
        Classifier elmType = ( (CollectionTypeInternal) ( (OclExpressionInternal) source ).getType( conn ) ).getElementType( conn );
        this.env.enterNewVariableScope( );

        try {
            this.defineVariable( OclConstants.EMPTY, elmType, null, false, false );
        } catch ( OclSemanticException e ) {
            this.reportInternalError( e, n );
        }

        this.handleIterate( null, source, n.getvariableAssignment( ), n.getoclExpression( ), n );
        this.env.leaveVariableScope( );
    }

    @Override
    /*
     * <b> <li>iterateExp ::= iterate ( variableDeclaration ; variableAssignment
     * | oclExpression ) </b>
     */
    public void visit( IterateVarDeclAndAcc n ) {

        // deal with variable declaration
        OclExpression source = (OclExpression) this.getDownProperty( n );

        VariableDeclaration varDecl = n.getvariableDeclaration( );
        varDecl.accept( this );

        org.omg.ocl.expressions.VariableDeclaration iter = (org.omg.ocl.expressions.VariableDeclaration) this.getUpProperty( varDecl );
        this.typeIteratorVar( source, iter, n );

        this.env.enterNewVariableScope( );

        try {
            this.env.declareVariable( iter );
        } catch ( OclSemanticException e1 ) {
            this.reportInternalError( e1, n );
        }
        this.handleIterate( iter, source, n.getvariableAssignment( ), n.getoclExpression( ), n );
        this.env.leaveVariableScope( );
    }

    @Override
    /*
     * <b> <li>iteratorExp ::= any ( iterContents ) </b>
     */
    public void visit( IteratorAny n ) {

        this.iterator( OclConstants.OP_ANY, n, n.getiterContents( ) );
    }

    @Override
    /*
     * <b> <li>iteratorExp ::= collect ( iterContents ) </b>
     */
    public void visit( IteratorCollect n ) {

        this.iterator( OclConstants.OP_COLLECT, n, n.getiterContents( ) );
    }

    @Override
    /*
     * <b> <li>iteratorExp ::= collectNested ( iterContents ) </b>
     */
    public void visit( IteratorCollectNested n ) {

        this.iterator( OclConstants.OP_COLLECTNESTED, n, n.getiterContents( ) );
    }

    @Override
    /*
     * <b> <li>iteratorExp ::= exists ( iterContents ) </b>
     */
    public void visit( IteratorExists n ) {

        this.iterator( OclConstants.OP_EXISTS, n, n.getiterContents( ) );
    }

    @Override
    /*
     * <b> <li>iteratorExp ::= forAll ( iterContents ) </b>
     */
    public void visit( IteratorForAll n ) {

        this.iterator( OclConstants.OP_FORALL, n, n.getiterContents( ) );
    }

    @Override
    /*
     * <b> <li>iteratorExp ::= isUnique ( iterContents ) </b>
     */
    public void visit( IteratorIsUnique n ) {

        this.iterator( OclConstants.OP_ISUNIQUE, n, n.getiterContents( ) );
    }

    @Override
    /*
     * <b> <li>iteratorExp ::= one ( iterContents ) </b>
     */
    public void visit( IteratorOne n ) {

        this.iterator( OclConstants.OP_ONE, n, n.getiterContents( ) );
    }

    @Override
    /*
     * <b> <li>iterContents ::= variableDeclaration | oclExpression </b>
     */
    public void visit( IteratorOneVarDecl n ) {

        OclExpression source = (OclExpression) this.getDownProperty( n );

        // do the one declaration
        n.getvariableDeclaration( ).accept( this );
        org.omg.ocl.expressions.VariableDeclaration varDecl = (org.omg.ocl.expressions.VariableDeclaration) this.getUpProperty( n.getvariableDeclaration( ) );

        // type and check the iterator variable
        this.typeIteratorVar( source, varDecl, n.getvariableDeclaration( ) );

        this.env.enterNewVariableScope( );
        try {
            this.env.declareVariable( varDecl );
        } catch ( OclSemanticException e ) {
            this.reportInternalError( e, n );
        }

        n.getoclExpression( ).accept( this );
        this.setUpProperty( n.getvariableDeclaration( ), varDecl );
        this.env.leaveVariableScope( );
    }

    @Override
    /*
     * <b> <li>iteratorExp ::= reject ( iterContents ) </b>
     */
    public void visit( IteratorReject n ) {

        this.iterator( OclConstants.OP_REJECT, n, n.getiterContents( ) );
    }

    @Override
    /*
     * <b> <li>iteratorExp ::= select ( iterContents ) </b>
     */
    public void visit( IteratorSelect n ) {

        this.iterator( OclConstants.OP_SELECT, n, n.getiterContents( ) );
    }

    @Override
    /*
     * <b> <li>iteratorExp ::= sortedBy ( iterContents ) </b>
     */
    public void visit( IteratorSortedBy n ) {

        this.iterator( OclConstants.OP_SORTEDBY, n, n.getiterContents( ) );
    }

    @Override
    /*
     * <b> <li>iterContents ::= variableDeclaration , variableDeclaration |
     * oclExpression </b>
     */
    public void visit( IteratorTwoVarDecl n ) {

        n.getvariableDeclaration( ).accept( this );
        n.getvariableDeclaration3( ).accept( this );

        OclExpression source = (OclExpression) this.getDownProperty( n );

        org.omg.ocl.expressions.VariableDeclaration varDecl1 = (org.omg.ocl.expressions.VariableDeclaration) this.getUpProperty( n.getvariableDeclaration( ) );
        org.omg.ocl.expressions.VariableDeclaration varDecl2 = (org.omg.ocl.expressions.VariableDeclaration) this.getUpProperty( n.getvariableDeclaration3( ) );

        this.typeIteratorVar( source, varDecl1, n.getvariableDeclaration( ) );
        this.typeIteratorVar( source, varDecl2, n.getvariableDeclaration3( ) );

        this.env.enterNewVariableScope( );
        try {
            this.env.declareVariable( varDecl1 );
            this.env.declareVariable( varDecl2 );
        } catch ( OclSemanticException e ) {
            this.reportInternalError( e, n );
        }

        n.getoclExpression( ).accept( this );

        this.setUpProperty( n.getvariableDeclaration( ), varDecl1 );
        this.setUpProperty( n.getvariableDeclaration3( ), varDecl2 );

        this.env.leaveVariableScope( );
    }

    @Override
    /*
     * <b> <li>relationalExpression ::= relationalExpression <=
     * compareableExpression </b>
     */
    public void visit( LessEqualRelationalExpression n ) {

        this.infixOperation( OclConstants.A_LTEQ, n.getrelationalExpression( ), n.getcompareableExpression( ), n );
    }

    @Override
    /*
     * <b> <li>relationalExpression ::= relationalExpression <
     * compareableExpression </b>
     */
    public void visit( LessRelationalExpression n ) {

        this.infixOperation( OclConstants.A_LT, n.getrelationalExpression( ), n.getcompareableExpression( ), n );
    }

    @Override
    /*
     * <b> <li>letExpression ::= letExpression ::= let variableAssignmentN in
     * oclExpression </b>
     */
    public void visit( LetExpression n ) {

        IvariableAssignmentN varAss = n.getvariableAssignmentN( );
        varAss.accept( this );

        this.env.enterNewVariableScope( );
        Object o = this.getUpProperty( (Node) varAss );
        LetExpImpl firstLet = null;
        LetExpImpl lastLet = null;
        if ( o instanceof List ) {
            // multiple variable declarations
            List<org.omg.ocl.expressions.VariableDeclaration> varDecls = (List<org.omg.ocl.expressions.VariableDeclaration>) o;
            /*
             * this is a bit tricky: we have a list of variable delcarations and
             * have to construct a nested-list-like structure of let
             * expressions. Therefore, we hold on to the first let because it
             * will be passed up the tree. We also hold on to the last let
             * because the expression will be added to it once all variables are
             * declared.
             */
            for ( org.omg.ocl.expressions.VariableDeclaration var : varDecls ) {
                try {
                    this.env.declareVariable( var );
                } catch ( OclSemanticException e ) {
                    // Notice that comma-separated let declarations do not allow
                    // a redefinition of another let
                    // write nested let-expressions if this is desired behaviour
                    this.reportError( e, (Node) varAss );
                }
            }

            // now that all variables are declared, visit the expression
            n.getoclExpression( ).accept( this );
            OclExpression inExp = (OclExpression) this.getUpProperty( (Node) n.getoclExpression( ) );

            // build the let expression
            for ( org.omg.ocl.expressions.VariableDeclaration var : varDecls ) {
                LetExpImpl let;
                try {
                    let = (LetExpImpl) this.jmiCreator.createLetExp( var );
                } catch ( OclSemanticException e ) {
                    this.reportError( e, (Node) varAss );
                    return;
                }
                let.setType( this.jmiCreator.getConnection( ), ( (OclExpressionInternal) inExp ).getType( this.jmiCreator.getConnection( ) ) );
                if ( firstLet == null ) {
                    firstLet = let;
                    lastLet = let;
                } else {
                    lastLet.setIn( this.jmiCreator.getConnection( ), let );
                    lastLet.setType( this.jmiCreator.getConnection( ), let.getType( this.jmiCreator.getConnection( ) ) );
                    lastLet = let;
                }
            }
            lastLet.setIn( this.jmiCreator.getConnection( ), inExp );
            lastLet.setType( this.jmiCreator.getConnection( ), ( (OclExpressionInternal) inExp ).getType( this.jmiCreator.getConnection( ) ) );

        } else if ( o instanceof org.omg.ocl.expressions.VariableDeclaration ) {
            // only one variable declaration
            org.omg.ocl.expressions.VariableDeclaration var = (org.omg.ocl.expressions.VariableDeclaration) o;
            try {
                this.env.declareVariable( var );
            } catch ( OclSemanticException e ) {
                // observe that an error cannot occur here as the current scope
                // is empty
                this.reportInternalError( e, n );
            }
            // now that all variables are declared, visit the in expression
            n.getoclExpression( ).accept( this );
            OclExpression inExp = (OclExpression) this.getUpProperty( (Node) n.getoclExpression( ) );
            try {
                firstLet = (LetExpImpl) this.jmiCreator.createLetExp( var );
            } catch ( OclSemanticException e ) {
                this.reportError( e, (Node) varAss );
                return;
            }
            lastLet = firstLet;
            this.jmiCreator.changeIn( lastLet, inExp );
            Classifier newType = ( (OclExpressionInternal) inExp ).getType( this.jmiCreator.getConnection( ) );
            this.jmiCreator.changeType( lastLet, newType );
        } else {
            this.reportInternalError( n, OclParserMessages.VARASSIGNMENTRETURNVARDECS );
        }

        this.env.leaveVariableScope( );
        this.setUpProperty( n, firstLet );
    }

    @Override
    /*
     * <b> <li>logicalExpression ::= logicalExpression implies booleanExpression
     * </b>
     */
    public void visit( LogicalExpression n ) {

        this.infixOperation( OclConstants.OP_IMPLIES, n.getlogicalExpression( ), n.getbooleanExpression( ), n );
    }

    @Override
    /*
     * <b> <li>propertyInvocation ::= -> loopExp </b>
     */
    public void visit( LoopPropertyInvocation n ) {

        // get source
        OclExpression source = (OclExpression) this.getDownProperty( n );
        Classifier sourceType = ( (OclExpressionInternal) source ).getType( this.jmiCreator.getConnection( ) );

        // verify that the source is of collection type
        if ( !( sourceType instanceof org.omg.ocl.types.CollectionType ) ) {

            // if we don't have a collection type, we make a set out of it
            Operation asSet = this.oclLookupTables.lookupOperation( sourceType, OclConstants.OP_ASSET, CLASSIFIER_EMPTY_LIST, this.oclTypeChecker );
            if ( asSet == null ) {
                this.reportInternalError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0402, new Object[] { OclConstants.OP_ASSET, StringHelper.toString( sourceType ), StringHelper.toString( CLASSIFIER_EMPTY_LIST ) } ), n );
            }
            OperationCallExp asSetCall = null;
            try {
                asSetCall = this.jmiCreator.createOperationCallExp( asSet, source );
            } catch ( OclSemanticException e ) {
                this.reportInternalError( e, n );
            }
            // move it further down
            this.setDownProperty( (Node) n.getloopExp( ), asSetCall );

        } else {
            // move it further down
            this.setDownProperty( (Node) n.getloopExp( ), source );
        }

        n.getloopExp( ).accept( this );
        // pass on property upwards
        this.setUpProperty( n, this.getUpProperty( (Node) n.getloopExp( ) ) );
    }

    @Override
    /*
     * <b> <li>additiveExpression ::= additiveExpression -
     * multiplicativeExpression </b>
     */
    public void visit( MinusAdditiveExpression n ) {

        this.infixOperation( OclConstants.A_MINUS, n.getadditiveExpression( ), n.getmultiplicativeExpression( ), n );
    }

    @Override
    /*
     * <b> <li>unaryExpression ::= - unaryExpression </b>
     */
    public void visit( MinusUnaryExpression n ) {

        this.unaryOperation( OclConstants.A_MINUS, n.getunaryExpression( ), n );
    }

    @Override
    /*
     * <b> <li>multiplicativeExpression ::= multiplicativeExpression
     * unaryExpression </b>
     */
    public void visit( MultMultiplicativeExpression n ) {

        this.infixOperation( OclConstants.A_MULT, n.getmultiplicativeExpression( ), n.getunaryExpression( ), n );
    }

    @Override
    /*
     * <b> <li>relationalExpression ::= relationalExpression <>
     * compareableExpression </b>
     */
    public void visit( NotEqualRelationalExpression n ) {

        this.infixOperation( OclConstants.A_NEQ, n.getrelationalExpression( ), n.getcompareableExpression( ), n );
    }

    @Override
    /*
     * <b> <li>unaryExpression ::= not unaryExpression </b>
     */
    public void visit( NotUnaryExpression n ) {

        this.unaryOperation( OclConstants.OP_NOT, n.getunaryExpression( ), n );
    }

    @Override
    /*
     * <b> <li>nullLiteral ::= null </b>
     */
    public void visit( NullLiteral n ) {

        try {
            VariableExp exp = this.jmiCreator.createVariableExp( this.jmiCreator.getOclNullVariable( ) );
            this.setUpProperty( n, exp );
        } catch ( OclSemanticException e ) {
            this.reportInternalError( e, n );
        }
    }

    @Override
    /*
     * <b> <li>propertyInvocation ::= . propertyCall </b>
     */
    public void visit( ObjectPropertyInvocation n ) {

        // get the source expression
        OclExpression source = (OclExpression) this.getDownProperty( n );

        // check if we have a collection type
        Classifier sourceType = ( (OclExpressionInternal) source ).getType( this.jmiCreator.getConnection( ) );
        if ( sourceType instanceof org.omg.ocl.types.CollectionType ) {
            try {
                // this is an operation call on the element type of the
                // collection
                // we need to insert an implicit collect operation
                Classifier elemType = ( (CollectionTypeInternal) sourceType ).getElementType( this.jmiCreator.getConnection( ) );
                // the implicit iterator variable
                org.omg.ocl.expressions.VariableDeclaration iterDecl = this.defineVariable( OclConstants.EMPTY, elemType, null, false, false );
                OclExpression newSource = this.jmiCreator.createVariableExp( iterDecl );

                // set the new source and accept the actual call
                this.setDownProperty( (Node) n.getpropertyCall( ), newSource );
                n.getpropertyCall( ).accept( this );

                // construct the result expression
                OclExpression body = (OclExpression) ( this.getUpProperty( (Node) n.getpropertyCall( ) ) );

                OclExpression collectExp = this.jmiCreator.createIteratorExp( OclConstants.OP_COLLECT, source, iterDecl, null, body );
                // pass on the result
                this.setUpProperty( n, collectExp );
            } catch ( OclSemanticException e ) {
                this.reportInternalError( e, n );
            }
        } else {
            this.setDownProperty( (Node) n.getpropertyCall( ), source );
            n.getpropertyCall( ).accept( this );
            // pass on the property
            this.setUpProperty( n, this.getUpProperty( (Node) n.getpropertyCall( ) ) );
        }
    }

    @Override
    /*
     * <b> <li>operationCall ::= sPathName timeExpressionOpt arguments</b>
     */
    public void visit( OperationCall n ) {

        /*
         * we have to distinguish between implicit (e.g. "op()") and explicit
         * (e.g. self.op()) calls
         */
        if ( this.hasDownProperty( n, DEFAULTPROPERTY ) ) {
            OclExpression source = (OclExpression) this.getDownProperty( n );
            this.explicitOperationCall( source, n );
            return;
        }
        // in all other cases, we assume an implicit operation call
        this.implicitOperationCall( n );
    }

    @Override
    /*
     * <b> <li>booleanExpression ::= booleanExpression or relationalExpression
     * </b>
     */
    public void visit( OrBooleanExpression n ) {

        this.infixOperation( OclConstants.OP_OR, n.getbooleanExpression( ), n.getrelationalExpression( ), n );
    }

    @Override
    /*
     * <b> <li>booleanExpression ::= booleanExpression and relationalExpression
     * </b>
     */
    public void visit( AndBooleanExpression n ) {

        this.infixOperation( OclConstants.OP_AND, n.getbooleanExpression( ), n.getrelationalExpression( ), n );
    }

    @Override
    /*
     * <b> <li>booleanExpression ::= booleanExpression xor relationalExpression
     * </b>
     */
    public void visit( XorBooleanExpression n ) {

        this.infixOperation( OclConstants.OP_XOR, n.getbooleanExpression( ), n.getrelationalExpression( ), n );
    }

    @Override
    /*
     * <b> <li>collectionKind ::= OrderedSet </b>
     */
    public void visit( OrderedSetKind n ) {

        this.setUpProperty( n, OclConstants.N_ORDEREDSET );
    }

    @Override
    /*
     * <b> <li>packageDeclaration ::= package sPathName contextDeclarationM
     * endpackage</b>
     */
    public void visit( PackageDeclaration n ) {

        // get the path name
        n.getsPathName( ).accept( this );
        List<String> pathName = (List<String>) this.getUpProperty( (Node) n.getsPathName( ) );

        // set package
        try {
            this.env.setPackage( pathName );
        } catch ( OclSemanticException e ) {
            this.reportFatalOCLError( e, (Node) n.getsPathName( ) );
        }

        if ( n.getcontextDeclarationM( ) != null ) {
            n.getcontextDeclarationM( ).accept( this );
        }
    }

    @Override
    /*
     * <b> <li>packageDeclarationN ::= packageDeclarationN packageDeclaration
     * </b>
     */
    public void visit( PackageDeclarations n ) {

        n.getpackageDeclarationN( ).accept( this );
        n.getpackageDeclaration( ).accept( this );
    }

    @Override
    /*
     * <b> <li>primaryExpression ::= ( oclExpression ) </b>
     */
    public void visit( ParenthesizedPrimaryExpression n ) {

        n.getoclExpression( ).accept( this );
        // simply pass the property further
        this.setUpProperty( n, this.getUpProperty( (Node) n.getoclExpression( ) ) );
    }

    @Override
    /*
     * <b> <li>additiveExpression ::= additiveExpression +
     * multiplicativeExpression </b>
     */
    public void visit( PlusAdditiveExpression n ) {

        this.infixOperation( OclConstants.A_PLUS, n.getadditiveExpression( ), n.getmultiplicativeExpression( ), n );
    }

    @Override
    /*
     * <b> <li>postfixExpression ::= postfixExpression propertyInvocation </b>
     */
    public void visit( PostfixExpression n ) {

        n.getpostfixExpression( ).accept( this );
        // the postfix expression becomes the source for the invocation
        this.setDownProperty( (Node) n.getpropertyInvocation( ), this.getUpProperty( (Node) n.getpostfixExpression( ) ) );
        n.getpropertyInvocation( ).accept( this );
        // pass on the property of the invocation upwards
        this.setUpProperty( n, this.getUpProperty( (Node) n.getpropertyInvocation( ) ) );
    }

    @Override
    /*
     * <b> <li>prePostOrBodyDeclN ::= prePostOrBodyDeclN prePostOrBodyDecl </b>
     */
    public void visit( PrePostOrBodyDecls n ) {

        n.getprePostOrBodyDeclN( ).accept( this );
        n.getprePostOrBodyDecl( ).accept( this );
    }

    @Override
    /*
     * <b> <li>primitiveType ::= Boolean </b>
     */
    public void visit( PrimTypeBoolean n ) {

        this.setUpProperty( n, this.boolType );
    }

    @Override
    /*
     * <b> <li>primitiveType ::= Integer </b>
     */
    public void visit( PrimTypeInteger n ) {

        this.setUpProperty( n, this.integerType );
    }

    @Override
    /*
     * <b> <li>primitiveType ::= Double </b>
     */
    public void visit( PrimTypeDouble n ) {

        this.setUpProperty( n, this.doubleType );
    }

    @Override
    /*
     * <b> <li>primitiveType ::= Float </b>
     */
    public void visit( PrimTypeFloat n ) {

        this.setUpProperty( n, this.floatType );
    }

    @Override
    /*
     * <b> <li>primitiveType ::= OclInvalid </b>
     */
    public void visit( PrimTypeOclInvalid n ) {

        this.setUpProperty( n, this.jmiCreator.getOclInvalidClass( ) );
    }

    @Override
    /*
     * <b> <li>primitiveType ::= OclAny </b>
     */
    public void visit( PrimTypeOclAny n ) {

        this.setUpProperty( n, this.jmiCreator.getAnyClass( ) );
    }

    @Override
    /*
     * <b> <li>primitiveType ::= OclVoid </b>
     */
    public void visit( PrimTypeOclVoid n ) {

        this.setUpProperty( n, this.jmiCreator.getOclVoidClass( ) );
    }

    @Override
    /*
     * <b> <li>Rule 35: primitiveType ::= Real </b>
     */
    public void visit( PrimTypeReal n ) {

        this.setUpProperty( n, this.floatType );
    }

    @Override
    /*
     * <b> <li>primitiveType ::= String </b>
     */
    public void visit( PrimTypeString n ) {

        this.setUpProperty( n, this.stringType );
    }

    @Override
    /*
     * <b> <li>realLiteral ::= REAL_LITERAL </b>
     */
    public void visit( RealLiteral n ) {

        try {
            RealLiteralExp realLit = this.jmiCreator.createRealLiteralExp( n.getIToken( ).toString( ) );
            this.setUpProperty( n, realLit );
        } catch ( OclSemanticException e ) {
            this.reportInternalError( e, n );
        }
    }

    @Override
    /*
     * <b> <li>varPathName ::= self </b>
     */
    public void visit( Self n ) {

        try {
            org.omg.ocl.expressions.VariableDeclaration self = this.env.lookupVarByName( OclConstants.VAR_SELF );
            VariableExp selfExp = null;
            selfExp = this.jmiCreator.createVariableExp( self );
            this.setUpProperty( n, selfExp );
        } catch ( OclSemanticException e ) {
            this.reportInternalError( e, n );
        }
    }

    @Override
    /*
     * <b> <li>Rule 43: collectionKind ::= Sequence </b>
     */
    public void visit( SequenceKind n ) {

        this.setUpProperty( n, OclConstants.N_SEQUENCE );
    }

    @Override
    /*
     * <b> <li>collectionKind ::= Set </b>
     */
    public void visit( SetKind n ) {

        this.setUpProperty( n, OclConstants.N_SET );
    }

    @Override
    /*
     * <b> <li>stringLiteral ::= STRING_LITERAL </b>
     */
    public void visit( StringLiteral n ) {

        try {
            String literal = n.getIToken( ).toString( );
            // escape the string literal
            literal = this.processString( literal );
            StringLiteralExp stringLit = this.jmiCreator.createStringLiteralExp( literal );
            this.setUpProperty( n, stringLit );
        } catch ( OclSemanticException e ) {
            this.reportInternalError( e, n );
        }
    }

    @Override
    /*
     * <b> <li>timeExpression ::= ATPRE </b>
     */
    public void visit( TimeExpressionOpt n ) {

        try {
            OclExpression exp = (OclExpression) this.getDownProperty( n );
            OclExpression expWithPre = this.jmiCreator.createAtPre( exp );
            this.setUpProperty( n, expWithPre );
        } catch ( OclSemanticException e ) {
            this.reportInternalError( e, n );
        }
    }

    @Override
    /*
     * <b> <li>tupleLiteral ::= Tuple { variableAssignmentM } </b>
     */
    public void visit( TupleLiteral n ) {

        List<org.omg.ocl.expressions.VariableDeclaration> varDecls = new ArrayList<org.omg.ocl.expressions.VariableDeclaration>( );

        if ( n.getvariableAssignmentM( ) != null ) {
            n.getvariableAssignmentM( ).accept( this );
            Object o = this.getUpProperty( (Node) n.getvariableAssignmentM( ) );
            if ( o instanceof List ) {
                varDecls = (List<org.omg.ocl.expressions.VariableDeclaration>) o;
            } else if ( o instanceof org.omg.ocl.expressions.VariableDeclaration ) {
                varDecls.add( (org.omg.ocl.expressions.VariableDeclaration) o );
            } else {
                this.reportInternalError( n, OclParserMessages.UNEXPECTEDNODEINTUPLE );
            }
        }
        OclExpression exp = null;
        try {
            String name = "TupleLitAt" + n.getLeftIToken( ).getLine( ) + "_" + n.getLeftIToken( ).getColumn( ); //$NON-NLS-1$//$NON-NLS-2$
            if ( this.checkTupleVariables( varDecls, true, n ) ) {
                exp = this.jmiCreator.createTupleLiteralExp( varDecls, name );
            } else {
                exp = this.jmiCreator.createTupleLiteralExp( new ArrayList<org.omg.ocl.expressions.VariableDeclaration>( 0 ), name );
            }
            this.setUpProperty( n, exp );

        } catch ( OclSemanticException e ) {
            this.reportInternalError( e, n );
        }
    }

    @Override
    /*
     * <b> <li>tupleType ::= Tuple ( variableDeclarationWithTypeM ) </b>
     */
    public void visit( TupleType n ) {

        List<org.omg.ocl.expressions.VariableDeclaration> varDecls = new ArrayList<org.omg.ocl.expressions.VariableDeclaration>( );

        if ( n.getvariableDeclarationWithTypeM( ) != null ) {
            n.getvariableDeclarationWithTypeM( ).accept( this );
            Object o = this.getUpProperty( (Node) n.getvariableDeclarationWithTypeM( ) );
            if ( o instanceof List ) {
                varDecls = (List<org.omg.ocl.expressions.VariableDeclaration>) o;
            } else if ( o instanceof org.omg.ocl.expressions.VariableDeclaration ) {
                varDecls.add( (org.omg.ocl.expressions.VariableDeclaration) o );
            } else {
                this.reportInternalError( n, OclParserMessages.UNEXPECTEDNODEINTUPLE );
            }
        }

        Classifier tupleType = null;
        try {
            String name = "TupleAt" + n.getLeftIToken( ).getLine( ) + "_" + n.getLeftIToken( ).getColumn( ); //$NON-NLS-1$ //$NON-NLS-2$
            if ( this.checkTupleVariables( varDecls, false, n ) ) {
                tupleType = this.jmiCreator.createTupleType( varDecls, name );
            } else {
                tupleType = this.jmiCreator.createTupleType( new ArrayList<org.omg.ocl.expressions.VariableDeclaration>( 0 ), name );
            }
            this.setUpProperty( n, tupleType );

        } catch ( OclSemanticException e ) {
            this.reportInternalError( e, n );
        }
    }

    @Override
    /*
     * <b> <li>varPathName ::= typeLiteral </b>
     */
    public void visit( TypeLiteral n ) {

        n.gettypeLiteral( ).accept( this );

        Object o = this.getUpProperty( (Node) n.gettypeLiteral( ) );

        if ( o instanceof Classifier ) {
            // make a type expression and pass on
            try {
                TypeExp typeExp = this.jmiCreator.createTypeExp( (Classifier) o );
                this.setUpProperty( n, typeExp );
            } catch ( OclSemanticException e ) {
                this.reportInternalError( e, n );
            }
        } else {
            this.reportInternalError( n, OclParserMessages.TYPELISTMUSTBECLASSIFIER );
        }
    }

    @Override
    /*
     * <b> <li>varPathName ::= sPathName timeExpressionOpt
     * associationQualifierOpt</b>
     */
    public void visit( Variable n ) {

        // here is some guesswork necessary, as we dont exactly what we've found
        // 1) could be a type literal, then the type was already looked up. we
        // just have to create the type exp
        // 2) could be a "normal" variable
        // 3) could be an access to an implicit feature, i.e. attribute or
        // association end
        // 4) could be a globally defined constant
        // 5) could be an enumeration literal

        n.getpathName( ).accept( this );
        List<String> pathName = null;

        OclExpression exp = null;

        Object o = this.getUpProperty( (Node) n.getpathName( ) );
        if ( o instanceof List ) {
            // ok, we've got a pathname, now we have to guess...
            pathName = (List<String>) o;
        } else {
            // impossible
            this.reportInternalError( n, OclParserMessages.VARPATHNAMEMUSTBELIST );
        }

        // we perhaps have a container name
        String containerName = null;
        if ( this.hasUpProperty( (Node) n.getpathName( ), OclConstants.N_CONTAINERNAME ) ) {
            containerName = (String) this.getUpProperty( (Node) n.getpathName( ), OclConstants.N_CONTAINERNAME );
        }

        if ( pathName.size( ) == 1 ) {
            // could be a variable or an implicit access to a feature
            exp = this.varOrImplFeature( pathName.get( 0 ), n.gettimeExpressionOpt( ), n.getassociationQualifierOpt( ), n );
            if ( exp != null ) {
                this.setUpProperty( n, exp );
                return;
            }
        }

        // From here, both time expr and assoc qualifier have to be null no
        // assoc qualifier allowed
        if ( n.getassociationQualifierOpt( ) != null ) {
            this.reportError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_1020 ), n );
        }

        if ( n.gettimeExpressionOpt( ) != null ) {
            this.reportError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_1021 ), n );
        }

        // It could be a type
        Classifier c = this.env.lookupClassifierByPathName( pathName );
        if ( c != null ) {
            if ( c instanceof EnumerationType ) {
                EnumerationType enumType = (EnumerationType) c;
                String enumLiteral = pathName.get( pathName.size( ) - 1 );
                if ( enumType.getLabels( ).contains( enumLiteral ) ) {
                    // the enumeration has a literal with the specified name
                    // create the EnumLiteralExp.
                    try {
                        exp = this.jmiCreator.createEnumLiteralExp( enumType, enumLiteral );
                        this.setUpProperty( n, exp );
                    } catch ( OclSemanticException e ) {
                        this.reportInternalError( e, n );
                    }
                    return;
                }
                // this enumeration does not have the specified enumeration
                // literal
                this.reportFatalOCLError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0103, new Object[] { StringHelper.toPathName( pathName.subList( 0, pathName.size( ) - 1 ) ), enumLiteral } ), n );
                return;

            }
            try {
                exp = this.jmiCreator.createTypeExp( c );
                this.setUpProperty( n, exp );
            } catch ( OclSemanticException e ) {
                this.reportInternalError( e, n );
            }

            return;
        }

        // maybe it is a constant
        Constant cs = this.env.lookupConstantByPathName( pathName );
        if ( cs != null ) {

            try {
                String typeName = ( (ConstantInternal) cs ).getType( this.jmiCreator.getConnection( ) ).getName( );

                if ( !( ( (ConstantInternal) cs ).getType( this.jmiCreator.getConnection( ) ) instanceof PrimitiveType ) ) {
                    throw new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0715, StringHelper.toPathName( pathName ), StringHelper.toString( ( (ConstantInternal) cs ).getType( this.jmiCreator.getConnection( ) ) ) );
                }

                if ( typeName.equals( OclConstants.T_STRING ) ) {
                    exp = this.jmiCreator.createStringLiteralExp( cs.getValue( ) );
                } else if ( typeName.equals( OclConstants.T_BOOLEAN ) ) {
                    exp = this.jmiCreator.createBooleanLiteralExp( cs.getValue( ) );
                } else if ( typeName.equals( OclConstants.T_INTEGER ) || typeName.equals( OclConstants.T_LONG ) ) {
                    exp = this.jmiCreator.createIntegerLiteralExp( cs.getValue( ) );
                } else if ( typeName.equals( OclConstants.T_REAL ) || typeName.equals( OclConstants.T_FLOAT ) || typeName.equals( OclConstants.T_DOUBLE ) ) {
                    exp = this.jmiCreator.createRealLiteralExp( cs.getValue( ) );
                } else {
                    this.reportInternalError( n, OclParserMessages.UNEXPECTEDPRIMTYPEFORCONST );
                }
                this.setUpProperty( n, exp );
                return;
            } catch ( OclSemanticException e ) {
                this.reportInternalError( e, n );
            }
        }

        // It could be an enumeration. For an enumeration, we have to drop the
        // label bit of the path
        if ( pathName.size( ) >= 2 ) {
            ModelElement me = this.env.lookupModelElementByPathName( pathName.subList( 0, pathName.size( ) - 1 ) );
            if ( me != null && me instanceof EnumerationType ) {

                EnumerationType enumType = (EnumerationType) me;
                String enumLiteral = pathName.get( pathName.size( ) - 1 );
                if ( enumType.getLabels( ).contains( enumLiteral ) ) {
                    // the enumeration has a literal with the specified name
                    // create the EnumLiteralExp.
                    try {
                        exp = this.jmiCreator.createEnumLiteralExp( enumType, enumLiteral );
                        this.setUpProperty( n, exp );
                    } catch ( OclSemanticException e ) {
                        this.reportInternalError( e, n );
                    }
                    return;
                }
                // this enumeration does not have the specified enumeration
                // literal
                this.reportFatalOCLError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0103, new Object[] { StringHelper.toPathName( pathName.subList( 0, pathName.size( ) - 1 ) ), enumLiteral } ), n );
                return;
            }
        }

        // nothing worked :-(
        this.noIdentifierFound( pathName, n );
    }

    protected void noIdentifierFound( List<String> pathName, Node n ) {

        this.reportFatalOCLError( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_1025, new Object[] { StringHelper.toPathName( pathName ) } ), n );
    }

    @Override
    /*
     * <b> <li>variableDeclaration ::= identifier withTypeExpressionOpt </b>
     */
    public void visit( VariableDeclaration n ) {

        WithTypeExpression withType = n.getwithTypeExpressionOpt( );
        String name = n.getLeftIToken( ).toString( );
        this.handleVariableDeclaration( withType, name, n );
    }

    @Override
    /*
     * <b> <li>variableAssignment ::= identifier withTypeExpressionOpt =
     * oclExpression </b>
     */
    public void visit( VariableAssignment n ) {

        WithTypeExpression withType = n.getwithTypeExpressionOpt( );
        IoclExpression exp = n.getoclExpression( );
        String name = n.getLeftIToken( ).toString( );
        this.handleVariableAssignment( withType, exp, name, n );
    }

    @Override
    /*
     * <b> <li>variableAssignmentWithType ::= identifier withTypeExpression =
     * oclExpression </b>
     */
    public void visit( VariableAssignmentWithType n ) {

        WithTypeExpression withType = n.getwithTypeExpression( );
        IoclExpression exp = n.getoclExpression( );
        String name = n.getLeftIToken( ).toString( );
        this.handleVariableAssignment( withType, exp, name, n );
    }

    @Override
    /*
     * <b> <li>variableDeclarationWithType ::= identifier withTypeExpression
     * </b>
     */
    public void visit( VariableDeclarationWithType n ) {

        WithTypeExpression withType = n.getwithTypeExpression( );
        String name = n.getLeftIToken( ).toString( );
        this.handleVariableDeclaration( withType, name, n );
    }

    @Override
    /*
     * <b> <li>variableAssignmentN ::= variableAssignment , variableAssignmentN
     * </b>
     */
    public void visit( VariableAssignmentN n ) {

        n.getvariableAssignment( ).accept( this );
        org.omg.ocl.expressions.VariableDeclaration var = (org.omg.ocl.expressions.VariableDeclaration) this.getUpProperty( n.getvariableAssignment( ) );

        n.getvariableAssignmentN( ).accept( this );

        List<org.omg.ocl.expressions.VariableDeclaration> vars = null;
        Object o = this.getUpProperty( (Node) n.getvariableAssignmentN( ) );
        if ( o instanceof List ) {
            vars = (List<org.omg.ocl.expressions.VariableDeclaration>) o;
        } else if ( o instanceof org.omg.ocl.expressions.VariableDeclaration ) {
            vars = new ArrayList<org.omg.ocl.expressions.VariableDeclaration>( );
            vars.add( (org.omg.ocl.expressions.VariableDeclaration) o );
        } else {
            this.reportInternalError( n, OclParserMessages.VARASSIGNMENTRETURNVARDECS );
        }

        // insert the first found
        vars.add( 0, var );

        this.setUpProperty( n, vars );
    }

    @Override
    /*
     * <b> <li>variableDeclarationWithTypeN ::= variableDeclarationWithType ,
     * variableDeclarationWithTypeN </b>
     */
    public void visit( VariableDeclarationWithTypeN n ) {

        n.getvariableDeclarationWithType( ).accept( this );
        org.omg.ocl.expressions.VariableDeclaration var = (org.omg.ocl.expressions.VariableDeclaration) this.getUpProperty( n.getvariableDeclarationWithType( ) );

        n.getvariableDeclarationWithTypeN( ).accept( this );

        List<org.omg.ocl.expressions.VariableDeclaration> vars = null;
        Object o = this.getUpProperty( (Node) n.getvariableDeclarationWithTypeN( ) );
        if ( o instanceof List ) {
            vars = (List<org.omg.ocl.expressions.VariableDeclaration>) o;
        } else if ( o instanceof org.omg.ocl.expressions.VariableDeclaration ) {
            vars = new ArrayList<org.omg.ocl.expressions.VariableDeclaration>( );
            vars.add( (org.omg.ocl.expressions.VariableDeclaration) o );
        } else {
            this.reportInternalError( n, OclParserMessages.VARASSIGNMENTRETURNVARDECS );
        }

        // insert the first found
        vars.add( 0, var );

        this.setUpProperty( n, vars );
    }

    @Override
    /*
     * <b> <li>withTypeExpression ::= : typePathName </b>
     */
    public void visit( WithTypeExpression n ) {

        n.gettypePathName( ).accept( this );
        // just pass the property upwards
        this.setUpProperty( n, this.getUpProperty( (Node) n.gettypePathName( ) ) );

        // we perhaps have a container name, which we propagate upwards
        if ( this.hasUpProperty( (Node) n.gettypePathName( ), OclConstants.N_CONTAINERNAME ) ) {
            this.setUpProperty( n, OclConstants.N_CONTAINERNAME, this.getUpProperty( (Node) n.gettypePathName( ), OclConstants.N_CONTAINERNAME ) );
        }
    }

    @Override
    /*
     * <b> <li>identifierWithOptContainerPrefix ::= identifier # sPathName </b>
     */
    public void visit( ContainerNamePrefix n ) {

        this.reportWarning( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_1022, "container qualification" ), n ); //$NON-NLS-1$
        this.setUpProperty( n, OclConstants.N_CONTAINERNAME, n.getidentifier( ).toString( ) );

        n.getsPathName( ).accept( this );
        // just pass the property upwards
        this.setUpProperty( n, this.getUpProperty( (Node) n.getsPathName( ) ) );
    }

    @Override
    /*
     * <b> <li>sPathName ::= identifier :: sPathName </b>
     */
    public void visit( PathNames n ) {

        n.getsPathName( ).accept( this );
        List<String> pathName = (List<String>) this.getUpProperty( (Node) n.getsPathName( ) );

        n.getidentifier( ).accept( this );
        String ident = (String) this.getUpProperty( n.getidentifier( ) );

        pathName.add( 0, ident );
        this.setUpProperty( n, pathName );
    }

    @Override
    /*
     * <b> <li>Rule 8: sPathName ::= identifier </b>
     */
    public void visit( PathNameIdent n ) {

        List<String> pathName = new ArrayList<String>( 1 );
        n.getidentifier( ).accept( this );
        pathName.add( (String) this.getUpProperty( n.getidentifier( ) ) );
        this.setUpProperty( n, pathName );
    }
}

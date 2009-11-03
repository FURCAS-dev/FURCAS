package com.sap.tc.moin.repository.core.ocl.editorutils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.Constant;
import com.sap.tc.moin.repository.mmi.model.DirectionKind;
import com.sap.tc.moin.repository.mmi.model.DirectionKindEnum;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;
import com.sap.tc.moin.repository.mmi.model.NameNotFoundException;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.Parameter;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.AttributeInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ClassifierInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.EnumerationTypeInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.GeneralizableElementInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ModelElementInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.MofClassImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.MofClassInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.MofPackageImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.MofPackageInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.OperationInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ParameterInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ReferenceInternal;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import lpg.lpgjavaruntime.IToken;

import org.omg.ocl.attaching.OclConstraint;
import org.omg.ocl.attaching.__impl.OclConstraintInternal;
import org.omg.ocl.expressions.VariableDeclaration;
import org.omg.ocl.expressions.__impl.VariableDeclarationInternal;
import org.omg.ocl.stdlibrary.StdLibraryPackage;
import org.omg.ocl.types.BagType;
import org.omg.ocl.types.CollectionType;
import org.omg.ocl.types.OrderedSetType;
import org.omg.ocl.types.SequenceType;
import org.omg.ocl.types.SetType;
import org.omg.ocl.types.__impl.CollectionTypeInternal;
import org.omg.ocl.types.__impl.TupleTypeImpl;

import com.sap.tc.moin.friends.ocl.editor.IOclProposal;
import com.sap.tc.moin.friends.ocl.editor.IncrementalProcessReport;
import com.sap.tc.moin.friends.ocl.editor.RegionWrappedMRI;
import com.sap.tc.moin.ocl.parser.IOCLTypeChecker;
import com.sap.tc.moin.ocl.parser.gen.OclLexerGen;
import com.sap.tc.moin.ocl.parser.gen.OclParserGen;
import com.sap.tc.moin.ocl.parser.gen.OclParserGensym;
import com.sap.tc.moin.ocl.parser.gen.oclAst.IoclExpression;
import com.sap.tc.moin.ocl.parser.gen.oclAst.IvariableAssignmentN;
import com.sap.tc.moin.ocl.parser.gen.oclAst.LetExpression;
import com.sap.tc.moin.ocl.parser.gen.oclAst.Node;
import com.sap.tc.moin.ocl.parser.gen.oclAst.OclFileOclExpression;
import com.sap.tc.moin.ocl.parser.gen.oclAst.VariableAssignment;
import com.sap.tc.moin.ocl.parser.gen.oclAst.VariableAssignmentN;
import com.sap.tc.moin.ocl.parser.impl.StringHelper;
import com.sap.tc.moin.ocl.parser.impl.env.OCLEnvironment;
import com.sap.tc.moin.ocl.parser.impl.env.OCLTypeChecker;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.ocl.utils.jmi.JmiCreator;
import com.sap.tc.moin.ocl.utils.jmi.MoinJmiCreator;
import com.sap.tc.moin.ocl.utils.jmi.OclSemanticException;
import com.sap.tc.moin.ocl.utils.localization.OclServiceExceptions;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.ProcessError;
import com.sap.tc.moin.repository.ProcessReport;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CoreOclEditorService;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.jmi.util.MoinMetamodelCode;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.shared.util.ProcessReportImpl;


/**
 * The Editor Service implementation
 */
public class OclEditorServiceImpl implements CoreOclEditorService {


    private static final String OPERATIONBRACKETS = "( )"; //$NON-NLS-1$

    private static final String PROPSALPACKAGESEP = " - "; //$NON-NLS-1$

    private static final String PROPOSALTYPESEP = " : "; //$NON-NLS-1$

    /** we can't store an empty String in an .info file */
    private static final MoinLocalizedString PATTERN = new MoinLocalizedString( ) {

        public String format( Object... args ) {

            return OclConstants.EMPTY;
        }

        public String getLocalizedMessage( Locale locale ) {

            return OclConstants.EMPTY;
        }
    };

    private final static MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_CORE_OCL_PARSER, OclEditorServiceImpl.class );

    private static final int[] BOUNDARY = {
        OclParserGensym.TK_COLON,
        OclParserGensym.TK_COMMA,
        OclParserGensym.TK_SEMICOLON,
        OclParserGensym.TK_BAR,
        OclParserGensym.TK_in,
        OclParserGensym.TK_let,
        OclParserGensym.TK_and,
        OclParserGensym.TK_or,
        OclParserGensym.TK_xor,
        OclParserGensym.TK_implies,
        OclParserGensym.TK_endif,
        OclParserGensym.TK_then,
        OclParserGensym.TK_else,
        OclParserGensym.TK_if,
        OclParserGensym.TK_EQUAL,
        OclParserGensym.TK_NOT_EQUAL,
        OclParserGensym.TK_GREATER,
        OclParserGensym.TK_GREATER_EQUAL,
        OclParserGensym.TK_LESS,
        OclParserGensym.TK_LESS_EQUAL,
        OclParserGensym.TK_PLUS,
        OclParserGensym.TK_MINUS,
        OclParserGensym.TK_MULTIPLY,
        OclParserGensym.TK_DIVIDE,
        OclParserGensym.TK_INTEGER_RANGE_START,
        OclParserGensym.TK_DOTDOT,
        OclParserGensym.TK_context,
        OclParserGensym.TK_package };

    Map<String, List<ModelElement>> modelElementsByName = new HashMap<String, List<ModelElement>>( );

    Map<String, ModelElement> modelElementsByOclQualifiedName = new HashMap<String, ModelElement>( );

    private static final String BACKGROUNPARTITIONKEY = "OclEditorBackgroundPartition"; //$NON-NLS-1$

    private CoreModelPartition backgroundPartition;

    private TypeVisitor transformation;

    private boolean behindWs;

    private Formatter formatter;

    private boolean skippedToken;

    private int skippedOffset;

    private final static int HIGHPRIO = 2;

    private final static int MIDPRIO = 5;

    private final static int LOWPRIO = 8;

    private IncrementalEditorOclParser incrParser;

    private static enum PATHCONTEXT {
        CONTEXT, PACKAGE, TYPE, OCL
    }

    private static enum COMMACONTEXT {
        VARASSIGN, VARDECL, OCLEXPR, ERROR
    }

    private static final String[] COLLTYPES = { OclConstants.T_SET, OclConstants.T_ORDEREDSET, OclConstants.T_SEQUENCE, OclConstants.T_BAG };


    /**
     */
    public OclEditorServiceImpl( ) {

        // nothing
    }

    public ProcessReport parseOclConstraints( CoreConnection connection, Set<CoreModelPartition> partitions, OclConstraint oclConstraintImpl, String constraint ) throws OclManagerException {

        try {

            MofPackageImpl mofPackage = getMofPackage( (OclConstraintInternal) oclConstraintImpl, connection );

            this.backgroundPartition = connection.getOrCreateTransientPartition( BACKGROUNPARTITIONKEY );

            JmiCreator jmiCreator = new JmiCreator( connection, true, this.backgroundPartition );

            EditorOclParser parser = new EditorOclParser( jmiCreator );

            refreshModelElements( connection, partitions );

            long startTime = System.nanoTime( );
            try {
                return parser.parseString( constraint, mofPackage, this.modelElementsByName, this.modelElementsByOclQualifiedName, null );
            } finally {
                if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                    long estimatedTime = System.nanoTime( ) - startTime;
                    LOGGER.trace( MoinSeverity.DEBUG, OclEditorServiceTraces.OVERALLPARSETIME, Long.valueOf( estimatedTime ) );
                }
            }

//            return parser.getReport( );

        } finally {
            this.backgroundPartition.deleteElements( connection );
        }

    }

    public List<IOclProposal> computeErrorFix( CoreConnection connection, Set<CoreModelPartition> partitions, OclConstraint oclConstraintImpl, String constraint, int errorOffset, int errorLength ) throws OclManagerException {

        ProcessReport report = parseOclConstraints( connection, partitions, oclConstraintImpl, constraint );
        for ( ProcessError error : report.getErrors( ) ) {
            int offset = error.getStartPosition( );
            int length = error.getEndPosition( ) - offset + 1;
            if ( offset == errorOffset && length == errorLength ) {
                if ( error instanceof FixableProcessErrorImpl ) {
                    FixableProcessErrorImpl fixError = (FixableProcessErrorImpl) error;
                    return Arrays.asList( fixError.getFixes( ) );
                }
            }
        }
        return new ArrayList<IOclProposal>( 0 );

    }



    public IncrementalProcessReport parseOclConstraints( CoreConnection connection, Set<CoreModelPartition> partitions, OclConstraint oclConstraintImpl, String constraint, int offset, int length, boolean isRemove ) throws OclManagerException {

        try {

            MofPackageImpl mofPackage = getMofPackage( (OclConstraintInternal) oclConstraintImpl, connection );

            this.backgroundPartition = connection.getOrCreateTransientPartition( BACKGROUNPARTITIONKEY );

            JmiCreator jmiCreator = new JmiCreator( connection, true, this.backgroundPartition );

            if ( this.incrParser == null ) {
                this.incrParser = new IncrementalEditorOclParser( jmiCreator );
            } else {
                this.incrParser.setJmiCreator( jmiCreator );
            }

            refreshModelElements( connection, partitions );

            long startTime = System.nanoTime( );
            try {
                this.incrParser.parseString( constraint, mofPackage, this.modelElementsByName, this.modelElementsByOclQualifiedName, null, offset, length, isRemove );
                if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                    long estimatedTime = System.nanoTime( ) - startTime;
                    LOGGER.trace( MoinSeverity.DEBUG, OclEditorServiceTraces.FIRSTPARSETIME, Long.valueOf( estimatedTime ) );
                }
                return new IncrementalProcessReport( this.incrParser.getReport( ), this.incrParser.getOffset( ), this.incrParser.getLength( ) );

            } catch ( RuntimeException e ) {
                e.printStackTrace( );
                return new IncrementalProcessReport( this.incrParser.getReport( ), this.incrParser.getOffset( ), this.incrParser.getLength( ) );
            } finally {
                if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                    long estimatedTime = System.nanoTime( ) - startTime;
                    LOGGER.trace( MoinSeverity.DEBUG, OclEditorServiceTraces.OVERALLPARSETIME, Long.valueOf( estimatedTime ) );
                }
            }

        } finally {
            this.backgroundPartition.deleteElements( connection );
        }

    }

    public List<IOclProposal> computeProposals( CoreConnection connection, Set<CoreModelPartition> partitions, OclConstraint oclConstraintImpl, String constraint, int offset ) throws OclManagerException {

        long startTime = System.nanoTime( );

        this.behindWs = false;

        this.skippedToken = false;

        refreshModelElements( connection, partitions );

        this.backgroundPartition = connection.getOrCreateTransientPartition( BACKGROUNPARTITIONKEY );

        ArrayList<IOclProposal> result = new ArrayList<IOclProposal>( );

        JmiCreator jmiCreator = new JmiCreator( connection, true, this.backgroundPartition );

        ProcessReportImpl report = new ProcessReportImpl( 1 );

        OCLTypeChecker checker = new OCLTypeChecker( jmiCreator );

        // create the lexer
        OclLexerGen oclLexer = new OclLexerGen( constraint.substring( 0, offset ).toCharArray( ), "OCL", report, 4 ); //$NON-NLS-1$
        // create the parser
        OclParserGen oclParser = new OclParserGen( oclLexer, report );

        oclLexer.lexer( oclParser );

        IToken lastToken = getLastToken( oclParser, offset, false );
        int newOffset = 0;
        if ( lastToken == null ) {
            if ( this.skippedToken ) {
                lastToken = getLastToken( oclParser, this.skippedOffset, true );
                newOffset = this.skippedOffset;
            } else {
                lastToken = getLastToken( oclParser, offset, true );
                newOffset = offset;
            }
        } else {
            if ( lastToken.getKind( ) != OclParserGensym.TK_EOF_TOKEN ) {
                newOffset = lastToken.getEndOffset( ) + 1;
            }
        }

        String prefix = constraint.substring( newOffset, offset ).trim( );

        /*
         * This implementation only looks for the MofPackage the constraint is
         * in.
         */
        // MofPackage mofPck = getMofPackage( oclConstraintImpl, connection );
        /*
         * This implementation looks in which package declaration the Proposal
         * is wanted. If there is no package declaration the MOFPackage the
         * constraints is in, will be used
         */
        MofPackageImpl mofPck = getMofPackage( constraint, offset );
        if ( mofPck == null ) {
            mofPck = getMofPackage( (OclConstraintInternal) oclConstraintImpl, connection );
        }

        ServiceOCLEnvironment env = new ServiceOCLEnvironment( report, jmiCreator, null, mofPck, new HashSet<RefPackage>( 0 ), this.modelElementsByName, this.modelElementsByOclQualifiedName );

        this.transformation = new TypeVisitor( env );


        if ( lastToken != null ) {
            ClassifierInternal type = null;
            IToken prev = null;

            switch_case: switch ( lastToken.getKind( ) ) {
                case OclParserGensym.TK_DOT:
                    if ( !setContext( env, constraint, newOffset ) ) {
                        break;
                    }
                    type = getOCLExpressionType( env, lastToken.getStartOffset( ), constraint );
                    result.addAll( computePropertyCallProposals( type, env, checker, offset, newOffset, lastToken.getKind( ), OclEditorServiceImpl.HIGHPRIO ) );
                    break;
                case OclParserGensym.TK_ARROW:
                    if ( !setContext( env, constraint, newOffset ) ) {
                        break;
                    }
                    type = getOCLExpressionType( env, lastToken.getStartOffset( ), constraint );
                    result.addAll( computePropertyCallProposals( type, env, checker, offset, newOffset, lastToken.getKind( ), OclEditorServiceImpl.HIGHPRIO ) );
                    result.addAll( addIteratorExpressions( env, type, offset, newOffset ) );
                    break;
                case OclParserGensym.TK_COLONCOLON:
                    result.addAll( computePathProposals( env, checker, constraint, offset, newOffset, OclEditorServiceImpl.HIGHPRIO ) );
                    break;
                case OclParserGensym.TK_LPAREN:
                    prev = oclParser.getIToken( lastToken.getTokenIndex( ) - 1 );
                    if ( prev != null ) {
                        if ( isIteratorExpToken( prev ) ) {
//                            if ( !setContext( env, constraint, newOffset ) ) {
//                                break;
//                            }
                            if ( !hasRightBar( constraint, lastToken.getTokenIndex( ) ) ) {
                                result.addAll( addDefaultProposals( env, mofPck, constraint, offset, newOffset ) );
                                if ( isIterateExpToken( prev ) ) {
                                    result.add( addIterateContentPattern( offset, newOffset, 1 ) );
                                } else {
                                    result.add( addOneVarIterTypePattern( offset, newOffset, 1 ) );
                                    result.add( addOneVarIterPattern( offset, newOffset, 1 ) );
                                    if ( isTwoVarIteratorExpToken( prev ) ) {
                                        result.add( addTwoVarIterTypePattern( offset, newOffset, 1 ) );
                                        result.add( addTwoVarIterPattern( offset, newOffset, 1 ) );
                                    }
                                }
                            } else {
                                if ( isIterateExpToken( prev ) ) {
                                    // right now, no proposals for left-hand side of iterate-expression 
                                } else {
                                    result.add( addVarDeclPattern( offset, newOffset, 3 ) );
                                }
                            }
                            break;
                        } else if ( isCollectionLiteralSymbol( prev ) ) {
                            result.addAll( computeTypeProposals( env, mofPck, offset, newOffset ) );//getRootPackageProposals(env, offset, newOffset));
                            break;
                        } else if ( prev.getKind( ) == OclParserGensym.TK_Tuple ) {
                            result.add( addVarDeclPattern( offset, newOffset, OclEditorServiceImpl.MIDPRIO ) );
                            break;
                        }
                    }
                    result.addAll( addDefaultProposals( env, mofPck, constraint, offset, newOffset ) );
                    break;
                case OclParserGensym.TK_LBRACE:
                    prev = oclParser.getIToken( lastToken.getTokenIndex( ) - 1 );
                    if ( prev != null ) {
                        if ( isCollectionLiteralSymbol( prev ) ) {
//                            result.addAll( computeTypeProposals( env, mofPack, offset, newOffset ) );
                        } else if ( prev.getKind( ) == OclParserGensym.TK_Tuple ) {
                            result.add( addVarAssignPattern( offset, newOffset, OclEditorServiceImpl.MIDPRIO ) );
                        }
                    }
                    break;
                case OclParserGensym.TK_context:
                    if ( this.behindWs ) {
                        /*
                         * use this if more than one package declaration should
                         * be allowed
                         */
//                        result.addAll( addRootPackageProposals( env, offset, newOffset ) );
                        result.add( computeProposalForElement( connection, getMofPackage( (OclConstraintInternal) oclConstraintImpl, connection ), offset, newOffset, checker, OclParserGensym.TK_COLONCOLON, OclEditorServiceImpl.MIDPRIO ) );
                        result.addAll( addMofPackProposals( connection, env, mofPck, offset, newOffset, OclEditorServiceImpl.LOWPRIO ) );
                    }
                    break;
                case OclParserGensym.TK_package:
                    if ( this.behindWs ) {
                        /*
                         * use this if more than one package declaration should
                         * be allowed
                         */
//                        result.addAll( addRootPackageProposals( env, offset, newOffset ) );
                        result.add( computeProposalForElement( connection, getMofPackage( (OclConstraintInternal) oclConstraintImpl, connection ), offset, newOffset, checker, OclParserGensym.TK_COLONCOLON, OclEditorServiceImpl.MIDPRIO ) );
                    }
                    break;

                case OclParserGensym.TK_let:
                    if ( this.behindWs ) {
                        result.add( addVarAssignPattern( offset, newOffset, OclEditorServiceImpl.MIDPRIO ) );
                    } else {
                        result.add( addLetPattern( offset, newOffset, OclEditorServiceImpl.MIDPRIO ) );
                    }
                    break;

                case OclParserGensym.TK_COMMA:
                    switch ( getCommaContext( constraint, lastToken.getTokenIndex( ) ) ) {
                        case VARDECL:
                            result.add( addVarDeclPattern( offset, newOffset, OclEditorServiceImpl.MIDPRIO ) );
                            break;

                        case VARASSIGN:
                            result.add( addVarAssignPattern( offset, newOffset, OclEditorServiceImpl.MIDPRIO ) );
                            break;

                        case OCLEXPR:
                            result.addAll( addDefaultProposals( env, mofPck, constraint, offset, newOffset ) );
                            break;

                        default:
                            break;
                    }
                    break;
                case OclParserGensym.TK_EOF_TOKEN:

                    if ( constraint.substring( 0, offset ).matches( "(\\s|\\r|\\n)*" ) ) { //$NON-NLS-1$
                        result.add( addContextDeclPattern( offset, newOffset, OclEditorServiceImpl.MIDPRIO ) );
                        result.add( addPackageDeclPattern( offset, newOffset, OclEditorServiceImpl.MIDPRIO ) );
                    }
                    break;

                case OclParserGensym.TK_endpackage:
                    result.add( addPackageDeclPattern( offset, newOffset, OclEditorServiceImpl.MIDPRIO ) );

                    break;

                case OclParserGensym.TK_COLON:
                    prev = oclParser.getIToken( lastToken.getTokenIndex( ) - 1 );
                    if ( prev != null && !isDeclToken( prev ) ) {
                        //show all rootPackages
                        result.addAll( computeTypeProposals( env, mofPck, offset, newOffset ) );
                        break;
                    }
                    result.addAll( addDefaultProposals( env, mofPck, constraint, offset, newOffset ) );
                    break;

                default:
                    //check if this is the end of a package declaration (package Identifier::Identifier)
                    if ( lastToken.getKind( ) == OclParserGensym.TK_IDENTIFIER ) {
                        boolean colonExpected = true;
                        prev = oclParser.getIToken( lastToken.getTokenIndex( ) );
                        while ( true ) {
                            prev = oclParser.getIToken( prev.getTokenIndex( ) - 1 );
                            if ( colonExpected ) {
                                if ( prev.getKind( ) == OclParserGensym.TK_package ) {
                                    result.add( addContextDeclPattern( offset, newOffset, OclEditorServiceImpl.MIDPRIO ) );
                                    break switch_case;
                                } else if ( prev.getKind( ) == OclParserGensym.TK_COLONCOLON ) {
                                    colonExpected = false;
                                } else {
                                    break;
                                }
                            } else {
                                if ( prev.getKind( ) == OclParserGensym.TK_IDENTIFIER ) {
                                    colonExpected = true;
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                    result.addAll( addDefaultProposals( env, mofPck, constraint, offset, newOffset ) );
                    break;
            }
        }

        this.backgroundPartition.deleteElements( connection );

        result = filter( prefix, result );
        Collections.sort( result );

        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            long estimatedTime = System.nanoTime( ) - startTime;
            LOGGER.trace( MoinSeverity.DEBUG, OclEditorServiceTraces.COMPUTEPROPOSALTIME, Long.valueOf( estimatedTime ) );
        }
        return result;
    }

    private COMMACONTEXT getCommaContext( String constraint, int tokenIndex ) {

        ProcessReportImpl report = new ProcessReportImpl( 1 );

        // create the lexer
        OclLexerGen oclLexer = new OclLexerGen( constraint.toCharArray( ), "OCL", report, 4 ); //$NON-NLS-1$

        // create the parser
        OclParserGen oclParser = new OclParserGen( oclLexer, report );

        oclLexer.lexer( oclParser );

        List<IToken> tokens = oclParser.getTokens( );

        ListIterator<IToken> it = tokens.listIterator( tokenIndex );

        int[] balance = { 0 };
        int[] ifBalance = { 0 };
        int[] letBalance = { 0 };

        IToken token;

        for ( int i = 0; it.hasPrevious( ) && i < 100; i++ ) {
            token = it.previous( );
            boolean allowThenElse = true;

            while ( updateLetBalance( letBalance, token ) > 0 && it.hasPrevious( ) ) {
                token = it.previous( );
            }

            while ( ( updateBalance( balance, token ) ) > 0 && it.hasPrevious( ) ) {
                token = it.previous( );
            }

            while ( ( updateIfBalance( ifBalance, token, allowThenElse ) ) > 0 && it.hasPrevious( ) ) {
                token = it.previous( );
                allowThenElse = false;
            }

            if ( balance[0] < 0 ) {
                if ( it.hasPrevious( ) ) {
                    IToken tmp = it.previous( );
                    if ( tmp.getKind( ) == OclParserGensym.TK_Tuple ) {
                        switch ( token.getKind( ) ) {
                            case OclParserGensym.TK_LPAREN:
                                return COMMACONTEXT.VARDECL;

                            case OclParserGensym.TK_LBRACE:
                                return COMMACONTEXT.VARASSIGN;

                            default:
                                break;
                        }
                    } else if ( isCollectionLiteralSymbol( tmp ) ) {
                        if ( token.getKind( ) == OclParserGensym.TK_LBRACE ) {
                            return COMMACONTEXT.OCLEXPR;
                        }
                        return COMMACONTEXT.ERROR;
                    } else {
                        return COMMACONTEXT.ERROR;
                    }
                }
            }
            if ( letBalance[0] < 0 ) {
                return COMMACONTEXT.VARASSIGN;
            }
        }
        return COMMACONTEXT.ERROR;
    }

    private boolean hasRightBar( String constraint, int tokenIndex ) {

        ProcessReportImpl report = new ProcessReportImpl( 1 );

        // create the lexer
        OclLexerGen oclLexer = new OclLexerGen( constraint.toCharArray( ), "OCL", report, 4 ); //$NON-NLS-1$

        // create the parser
        OclParserGen oclParser = new OclParserGen( oclLexer, report );

        oclLexer.lexer( oclParser );

        List<IToken> tokens = oclParser.getTokens( );

//        IToken lastToken = getLastToken( oclParser, offset, false );
//        if ( lastToken == null ) {
//            int ws;
//            if ( skippedToken ) {
//                ws = getTrailingWS( constraint.substring( 0, skippedOffset ) );
//                lastToken = getLastToken( oclParser, skippedOffset - ws, true );
//            } else {
//                ws = getTrailingWS( constraint.substring( 0, offset ) );
//                lastToken = getLastToken( oclParser, offset - ws, true );
//            }
//        }
        ListIterator<IToken> it = tokens.listIterator( tokenIndex );

        int[] balance = { 0 };

        IToken token;

        for ( int i = 0; it.hasNext( ) && i < 100; i++ ) {
            token = it.next( );
            if ( token.getKind( ) == OclParserGensym.TK_BAR ) {
                return true;
            }
            if ( updateBalance( balance, token ) > 0 ) {
                return false;
            }
        }
        return false;
    }

    private Collection<? extends IOclProposal> addVariablePoposals( ServiceOCLEnvironment env, int offset, int newOffset, String constraint, int prio ) {

        List<IOclProposal> result = new ArrayList<IOclProposal>( 0 );
        try {
            getRealEnv( env, constraint.substring( 0, newOffset ) );
        } catch ( OclSemanticException e ) {
            // $JL-EXC$ TODO trace this
        }
        boolean first = true;
        for ( VariableDeclarationInternal variableDeclaration : env.getVariables( ) ) {
            if ( first && variableDeclaration.getVarName( ).equals( OclConstants.EMPTY ) ) {
                result.addAll( computePropertyCallProposals( (ClassifierInternal) variableDeclaration.getType( env.getJmiCreator( ).getConnection( ) ), env, new OCLTypeChecker( env.getJmiCreator( ) ), offset, newOffset, OclParserGensym.TK_DOT, prio ) );
            } else {
                result.add( new OCLProposalImpl( MoinReplacementStrings.VARNAMEANDTYPE, new Object[] { variableDeclaration.getVarName( ), variableDeclaration.getType( env.getJmiCreator( ).getConnection( ) ).getName( ) }, variableDeclaration.getVarName( ), null, newOffset, offset - newOffset,
                                                 IOclProposal.TYPE.VARIABLE, prio ) );
            }
        }
        return result;
    }


    private Collection<? extends IOclProposal> computeTypeProposals( ServiceOCLEnvironment env, MofPackageImpl mofPck, int offset, int newOffset ) {

        CoreConnection connection = env.getJmiCreator( ).getConnection( );
        List<IOclProposal> result = new ArrayList<IOclProposal>( 0 );
        result.addAll( addRootPackageProposals( env, offset, newOffset, OclEditorServiceImpl.LOWPRIO ) );
        result.addAll( addPrimTypeProposals( connection, env, offset, newOffset, OclEditorServiceImpl.MIDPRIO ) );
        result.addAll( addMofPackProposals( connection, env, mofPck, offset, newOffset, OclEditorServiceImpl.HIGHPRIO ) );
        result.addAll( addCollectionTypeProposals( offset, newOffset, OclEditorServiceImpl.MIDPRIO ) );
        result.add( addTupleTypePattern( offset, newOffset, OclEditorServiceImpl.MIDPRIO ) );

        return result;
    }

    private Collection<? extends IOclProposal> addMofPackProposals( CoreConnection connection, ServiceOCLEnvironment env, MofPackageImpl mofPck, int offset, int newOffset, int prio ) {

        List<IOclProposal> result = new ArrayList<IOclProposal>( 0 );

        JmiList<ModelElement> list = (JmiList<ModelElement>) mofPck.getContents( env.getJmiCreator( ).getConnection( ) );

        //add attributes, references and operations
        for ( Iterator<ModelElement> iterator = list.iteratorReadOnly( env.getJmiCreator( ).getConnection( ).getSession( ) ); iterator.hasNext( ); ) {
            ModelElementInternal mE = (ModelElementInternal) iterator.next( );
            if ( !( mE instanceof Association ) ) {
                result.add( computeProposalForElement( connection, mE, offset, newOffset, new OCLTypeChecker( env.getJmiCreator( ) ), OclParserGensym.TK_COLONCOLON, prio ) );
            }
        }
        return result;
    }

    private Collection<? extends IOclProposal> addPrimTypeProposals( CoreConnection connection, ServiceOCLEnvironment env, int offset, int newOffset, int prio ) {

        List<IOclProposal> result = new ArrayList<IOclProposal>( 0 );
        List<ClassifierInternal> primtypes = new ArrayList<ClassifierInternal>( 5 );
        MoinJmiCreator jc = env.getJmiCreator( );
        primtypes.add( (ClassifierInternal) jc.getAnyClass( ) );
        primtypes.add( (ClassifierInternal) jc.getBoolClass( ) );
        primtypes.add( (ClassifierInternal) jc.getDoubleClass( ) );
        primtypes.add( (ClassifierInternal) jc.getFloatClass( ) );
        primtypes.add( (ClassifierInternal) jc.getIntClass( ) );
        primtypes.add( (ClassifierInternal) jc.getLongClass( ) );
        primtypes.add( (ClassifierInternal) jc.getOclInvalidClass( ) );
        primtypes.add( (ClassifierInternal) jc.getStringClass( ) );

        for ( ClassifierInternal classifier : primtypes ) {
            result.add( computeProposalForElement( connection, classifier, offset, newOffset, new OCLTypeChecker( jc ), OclParserGensym.TK_COLONCOLON, prio ) );
        }
        return result;
    }

    private Collection<? extends IOclProposal> addCollectionTypeProposals( int offset, int newOffset, int prio ) {

        List<IOclProposal> result = new ArrayList<IOclProposal>( 4 );
        List<String> params = new ArrayList<String>( 1 );
        params.add( "Type" ); //$NON-NLS-1$
        List<String> delimiters = new ArrayList<String>( 0 );

        for ( String string : COLLTYPES ) {
            String r = string + "()"; //$NON-NLS-1$
            result.add( new OCLProposalImpl( string, r, MoinReplacementStrings.ADDCOLLECTIONTYPE, newOffset, offset - newOffset, IOclProposal.TYPE.COLLECTIONTYPE, prio, params, delimiters ) );
        }
        return result;
    }

    private Collection<? extends IOclProposal> addCollectionDeclProposals( int offset, int newOffset, int prio ) {

        List<IOclProposal> result = new ArrayList<IOclProposal>( 4 );
        for ( String string : COLLTYPES ) {
            String r = string + "{}"; //$NON-NLS-1$
            result.add( new OCLProposalImpl( string, r, MoinReplacementStrings.ADDCOLLECTIONDECL, newOffset, offset - newOffset, IOclProposal.TYPE.COLLECTIONTYPE, prio, null, null ) );
        }
        return result;
    }

    private IOclProposal addContextDeclPattern( int offset, int newOffset, int prio ) {

        return new OCLProposalImpl( PATTERN, OCLProposalImpl.REP_CONTEXT, newOffset, offset - newOffset, IOclProposal.TYPE.PATTERN, prio );
    }

    private IOclProposal addPackageDeclPattern( int offset, int newOffset, int prio ) {

        return new OCLProposalImpl( PATTERN, OCLProposalImpl.REP_PACKAGE, newOffset, offset - newOffset, IOclProposal.TYPE.PATTERN, prio );
    }

    private IOclProposal addTupleTypePattern( int offset, int newOffset, int prio ) {

        return new OCLProposalImpl( PATTERN, OCLProposalImpl.REP_TUPLE, newOffset, offset - newOffset, IOclProposal.TYPE.PATTERN, prio );
    }

    private IOclProposal addTupleDeclPattern( int offset, int newOffset, int prio ) {

        return new OCLProposalImpl( PATTERN, OCLProposalImpl.REP_TUPLE, newOffset, offset - newOffset, IOclProposal.TYPE.PATTERN, prio );
    }

    private IOclProposal addVarAssignPattern( int offset, int newOffset, int prio ) {

        return new OCLProposalImpl( PATTERN, OCLProposalImpl.REP_VARASSIGN, newOffset, offset - newOffset, IOclProposal.TYPE.PATTERN, prio );
    }

    private IOclProposal addVarDeclPattern( int offset, int newOffset, int prio ) {

        return new OCLProposalImpl( PATTERN, OCLProposalImpl.REP_VARDECL, newOffset, offset - newOffset, IOclProposal.TYPE.PATTERN, prio );
    }

    private IOclProposal addLetPattern( int offset, int newOffset, int prio ) {

        return new OCLProposalImpl( PATTERN, OCLProposalImpl.REP_LET, newOffset, offset - newOffset, IOclProposal.TYPE.PATTERN, prio );
    }

    private IOclProposal addIfPattern( int offset, int newOffset, int prio ) {

        return new OCLProposalImpl( PATTERN, OCLProposalImpl.REP_IF, newOffset, offset - newOffset, IOclProposal.TYPE.PATTERN, prio );
    }

    private IOclProposal addOneVarIterTypePattern( int offset, int newOffset, int prio ) {

        return new OCLProposalImpl( PATTERN, OCLProposalImpl.REP_ONEVARTYPEITER, newOffset, offset - newOffset, IOclProposal.TYPE.PATTERN, prio );
    }

    private IOclProposal addOneVarIterPattern( int offset, int newOffset, int prio ) {

        return new OCLProposalImpl( PATTERN, OCLProposalImpl.REP_ONEVARITER, newOffset, offset - newOffset, IOclProposal.TYPE.PATTERN, prio );
    }

    private IOclProposal addTwoVarIterTypePattern( int offset, int newOffset, int prio ) {

        return new OCLProposalImpl( PATTERN, OCLProposalImpl.REP_TWOVARTYPEITER, newOffset, offset - newOffset, IOclProposal.TYPE.PATTERN, prio );
    }

    private IOclProposal addTwoVarIterPattern( int offset, int newOffset, int prio ) {

        return new OCLProposalImpl( PATTERN, OCLProposalImpl.REP_TWOVARITER, newOffset, offset - newOffset, IOclProposal.TYPE.PATTERN, prio );
    }

    private IOclProposal addIterateContentPattern( int offset, int newOffset, int prio ) {

        return new OCLProposalImpl( PATTERN, OCLProposalImpl.REP_ITERATECONTENT, newOffset, offset - newOffset, IOclProposal.TYPE.PATTERN, prio );
    }

    private Collection<? extends IOclProposal> addDefaultProposals( ServiceOCLEnvironment env, MofPackageImpl mofPck, String constraint, int offset, int newOffset ) {

        CoreConnection connection = env.getJmiCreator( ).getConnection( );
        List<IOclProposal> result = new ArrayList<IOclProposal>( 0 );
        if ( setContext( env, constraint, newOffset ) ) {
            result.addAll( addVariablePoposals( env, offset, newOffset, constraint, OclEditorServiceImpl.HIGHPRIO ) );
            result.add( addIfPattern( offset, newOffset, OclEditorServiceImpl.MIDPRIO ) );
            result.add( addLetPattern( offset, newOffset, OclEditorServiceImpl.MIDPRIO ) );
        }
        result.addAll( addCollectionDeclProposals( offset, newOffset, 7 ) );
        result.add( addTupleDeclPattern( offset, newOffset, 7 ) );
        result.addAll( addRootPackageProposals( env, offset, newOffset, OclEditorServiceImpl.LOWPRIO ) );
        result.addAll( addMofPackProposals( connection, env, mofPck, offset, newOffset, 7 ) );

        return result;
    }

    private Collection<? extends IOclProposal> addRootPackageProposals( ServiceOCLEnvironment env, int offset, int newOffset, int prio ) {

        CoreConnection connection = env.getJmiCreator( ).getConnection( );
        List<IOclProposal> result = new ArrayList<IOclProposal>( 0 );
        Set<String> keys = OclEditorServiceImpl.this.modelElementsByOclQualifiedName.keySet( );
        for ( String string : keys ) {
            if ( string.contains( OclConstants.PATHSEP ) ) {
                continue;
            }
            ModelElementInternal me = (ModelElementInternal) OclEditorServiceImpl.this.modelElementsByOclQualifiedName.get( string );
            if ( me instanceof MofPackageImpl && !me.getName( ).startsWith( OclConstants.OCLGENERATED ) ) {
                result.add( computeProposalForElement( connection, me, offset, newOffset, new OCLTypeChecker( env.getJmiCreator( ) ), OclParserGensym.TK_COLONCOLON, prio ) );
            }
        }
        return result;
    }

    private Collection<? extends IOclProposal> computePathProposals( OCLEnvironment env, OCLTypeChecker checker, String constraint, int offset, int newOffset, int prio ) {

        CoreConnection connection = env.getJmiCreator( ).getConnection( );
        ArrayList<IOclProposal> result = new ArrayList<IOclProposal>( );

        int start = 0;
        int end = newOffset - 2;

        String newTxt = constraint.substring( start, end );
        List<String> pathName = new java.util.ArrayList<String>( );

        // look backwards past the path name to see whether there is an
        //   "oclIsInState(" before it
        ProcessReportImpl report = new ProcessReportImpl( 1 );

        OclLexerGen lexer = new OclLexerGen( newTxt.toCharArray( ), "OCL", report, 4 ); //$NON-NLS-1$

        // create the parser
        OclParserGen parser = new OclParserGen( lexer, report );

        lexer.lexer( parser );

        List<IToken> tokens = parser.getTokens( );

        ListIterator<IToken> iter = tokens.listIterator( tokens.size( ) );

        PATHCONTEXT pathContext = null;

        boolean identifierExpected = true;

        String testPathName = OclConstants.EMPTY;

        while ( iter.hasPrevious( ) ) {
            IToken prev = iter.previous( );

            if ( prev.getKind( ) == OclParserGensym.TK_EOF_TOKEN ) {
                continue;
            }

            if ( prev.getKind( ) == OclParserGensym.TK_IDENTIFIER ) {

                if ( identifierExpected ) {
                    testPathName = parser.getTokenText( prev.getTokenIndex( ) ) + testPathName;
                    pathName.add( 0, parser.getTokenText( prev.getTokenIndex( ) ) );
                    identifierExpected = false;
                } else {
                    return result;
                }
            } else if ( prev.getKind( ) == OclParserGensym.TK_COLONCOLON ) {
                if ( !identifierExpected ) {
                    testPathName = OclConstants.PATHSEP + testPathName;
                    identifierExpected = true;
                } else {
                    return result;
                }

            } else {
                if ( !identifierExpected ) {
                    if ( isPathBoundaryToken( prev ) ) {
                        if ( prev.getKind( ) == OclParserGensym.TK_COLON ) {
                            if ( iter.hasPrevious( ) && isDeclToken( iter.previous( ) ) ) {
                                pathContext = PATHCONTEXT.OCL;
                            } else {
                                pathContext = PATHCONTEXT.TYPE;
                            }
                        } else if ( prev.getKind( ) == OclParserGensym.TK_context ) {
                            pathContext = PATHCONTEXT.CONTEXT;
                        } else if ( prev.getKind( ) == OclParserGensym.TK_package ) {
                            pathContext = PATHCONTEXT.PACKAGE;
                        } else {
                            pathContext = PATHCONTEXT.OCL;
                        }
                        break;

                    }
                    return result;
                }
                return result;
            }
        }

        List<ModelElementInternal> elements = new ArrayList<ModelElementInternal>( );

        ModelElementInternal me = (ModelElementInternal) env.lookupModelElementByPathName( pathName );
//        if ( me == null )
//            me = modelElementsByOclQualifiedName.get( testPathName );
        if ( me instanceof MofPackage ) {

            JmiList<ModelElement> list = (JmiList<ModelElement>) ( (MofPackageInternal) me ).getContents( env.getJmiCreator( ).getConnection( ) );

            //add attributes, references and operations

            Iterator<ModelElement> iterator = list.iteratorReadOnly( env.getJmiCreator( ).getConnection( ).getSession( ) );
            while ( iterator.hasNext( ) ) {
                ModelElementInternal contentMe = (ModelElementInternal) iterator.next( );
                if ( contentMe instanceof MofPackage ) {
                    elements.add( contentMe );
                }
                //TODO: sind hier auch Associations erlaubt?
                else if ( contentMe instanceof Classifier && pathContext != PATHCONTEXT.PACKAGE ) {
                    elements.add( contentMe );
                }
            }
        } else if ( me instanceof MofClass && pathContext != PATHCONTEXT.PACKAGE ) {
            if ( pathContext == PATHCONTEXT.CONTEXT ) {
                result.addAll( computePropertyCallProposals( (MofClassImpl) me, env, checker, offset, newOffset, OclParserGensym.TK_COLONCOLON, prio ) );
            }

            JmiList<ModelElement> list = (JmiList<ModelElement>) ( (MofClassInternal) me ).getContents( env.getJmiCreator( ).getConnection( ) );

            //add attributes, references and operations

            Iterator<ModelElement> iterator = list.iteratorReadOnly( env.getJmiCreator( ).getConnection( ).getSession( ) );

            while ( iterator.hasNext( ) ) {
                ModelElement contentMe = iterator.next( );
                if ( contentMe instanceof EnumerationType ) {
                    elements.add( (ModelElementInternal) contentMe );
                } else if ( contentMe instanceof StructureType ) {
                    elements.add( (ModelElementInternal) contentMe );
                } else if ( contentMe instanceof Constant && pathContext == PATHCONTEXT.OCL ) {
                    elements.add( (ModelElementInternal) contentMe );
                }
            }
        } else if ( me instanceof EnumerationType && pathContext == PATHCONTEXT.OCL ) {
            return computePropertyCallProposals( (EnumerationTypeInternal) me, env, checker, offset, newOffset, OclParserGensym.TK_COLONCOLON, prio );
        }

        for ( ModelElementInternal modelElement : elements ) {
            result.add( computeProposalForElement( connection, modelElement, offset, newOffset, checker, OclParserGensym.TK_COLONCOLON, prio ) );
        }

        return result;

    }

    private IOclProposal computeProposalForElement( CoreConnection connection, ModelElementInternal element, int offset, int newOffset, IOCLTypeChecker checker, int tokenKind, int prio ) {

        MoinLocalizedString proposal;
        Object[] parameters;
        String replacement;
        IOclProposal.TYPE type;

        String additionalInfo = computeAdditionalInformation( connection, element, checker, false );

        if ( element instanceof Attribute ) {
            Attribute attr = (Attribute) element;
            MultiplicityType multi = attr.getMultiplicity( );
            proposal = MoinReplacementStrings.ELEMENTPROPOSAL;
            parameters = new Object[] { attr.getName( ), checker.createOclType( multi, ( (AttributeInternal) attr ).getType( connection ) ).getName( ), StringHelper.toPathName( ( (ModelElementInternal) ( (AttributeInternal) attr ).getContainer( connection ) ).getQualifiedName( connection ) ) };
            if ( tokenKind == OclParserGensym.TK_COLONCOLON ) {
                replacement = attr.getName( ) + PROPOSALTYPESEP + getOclReadableType( connection, (ClassifierInternal) checker.createOclType( multi, ( (AttributeInternal) attr ).getType( connection ) ) );
            } else {
                replacement = attr.getName( );
            }
            type = IOclProposal.TYPE.ATTRIBUTE;
        } else if ( element instanceof Reference ) {
            ReferenceInternal ref = (ReferenceInternal) element;
            MultiplicityType multi = ref.getMultiplicity( );
            proposal = MoinReplacementStrings.ELEMENTPROPOSAL;
            parameters = new Object[] { ref.getName( ), checker.createOclType( multi, ref.getType( connection ) ).getName( ), StringHelper.toPathName( ( (ModelElementInternal) ref.getContainer( connection ) ).getQualifiedName( connection ) ) };
            replacement = ref.getName( );
            type = IOclProposal.TYPE.REFERENCE;
        } else if ( element instanceof AssociationEnd ) {
            AssociationEndInternal assoEnd = (AssociationEndInternal) element;
            MultiplicityType multi = assoEnd.getMultiplicity( );
            proposal = MoinReplacementStrings.ELEMENTPROPOSAL;
            parameters = new Object[] { assoEnd.getName( ), checker.createOclType( multi, assoEnd.getType( connection ) ).getName( ), StringHelper.toPathName( ( (ModelElementInternal) assoEnd.getContainer( connection ) ).getQualifiedName( connection ) ) };
            replacement = assoEnd.getName( );
            type = IOclProposal.TYPE.ASSOCIATIONEND;
        } else if ( element instanceof Operation ) {
            OperationInternal op = (OperationInternal) element;
            if ( op.isQuery( ) ) {
                return computeOperationProposal( connection, op, checker, offset, newOffset, tokenKind, prio );
            }
            return null;
        } else if ( element instanceof MofPackage ) {
            MofPackage pck = (MofPackage) element;
            proposal = MoinReplacementStrings.ELEMENTPROPOSALSIMPLE;
            parameters = new Object[] { pck.getName( ) };
            replacement = pck.getName( );
            type = IOclProposal.TYPE.PACKAGE;

        } else if ( element instanceof Constant ) {
            Constant cnst = (Constant) element;
            proposal = MoinReplacementStrings.ELEMENTPROPOSALSIMPLE;
            parameters = new Object[] { cnst.getName( ) };
            replacement = cnst.getName( );
            type = IOclProposal.TYPE.CONSTANT;

        } else if ( element instanceof Classifier ) {
            Classifier classifier = (Classifier) element;
            proposal = MoinReplacementStrings.ELEMENTPROPOSALSIMPLE;
            parameters = new Object[] { classifier.getName( ) };
            replacement = classifier.getName( );
            if ( classifier.getName( ).endsWith( OclConstants.STDLIBSUBTRING ) ) {
                type = IOclProposal.TYPE.OCL;
                String correctedReplacement = classifier.getName( ).replace( OclConstants.STDLIBSUBTRING, OclConstants.EMPTY );
                parameters = new Object[] { correctedReplacement };
                replacement = replacement.replace( OclConstants.STDLIBSUBTRING, OclConstants.EMPTY );
            } else if ( element instanceof MofClass ) {
                type = IOclProposal.TYPE.CLASS;
            } else if ( element instanceof Association ) {
                type = IOclProposal.TYPE.ASSOCIATION;
            } else if ( element instanceof EnumerationType ) {
                type = IOclProposal.TYPE.ENUMTYPE;
            } else if ( element instanceof StructureType ) {
                type = IOclProposal.TYPE.STRUCTURETYPE;
            } else if ( element instanceof PrimitiveType ) {
                type = IOclProposal.TYPE.PRIMITIVETYPE;
            } else {
                type = IOclProposal.TYPE.UNDEFINED;
            }

        } else {
            return null;
        }

        return new OCLProposalImpl( proposal, parameters, replacement, additionalInfo, newOffset, offset - newOffset, type, prio );

    }

    private MofPackageImpl getMofPackage( OclConstraintInternal ocl, CoreConnection connection ) {

        RefFeatured parent = ( (RefObjectImpl) ocl ).refImmediateComposite( connection.getSession( ) );
        while ( parent != null ) {
            if ( parent instanceof MofPackage ) {
                return (MofPackageImpl) parent;
            }
            if ( parent instanceof RefObject ) {
                parent = ( (RefObjectImpl) parent ).refImmediateComposite( connection.getSession( ) );
            } else {
                parent = null;
            }
        }
        return null;
    }

    private List<String> getContextPath( String constraint, int offset ) {
        int index = constraint.lastIndexOf( "context", offset ); //$NON-NLS-1$
        if ( index < 0 ) {
            return null;
        }
        ProcessReportImpl report = new ProcessReportImpl( 1 );
        OclLexerGen oclLexer = new OclLexerGen( constraint.toCharArray( ), "OCL", report, 4 ); //$NON-NLS-1$
        // create the parser
        OclParserGen oclParser = new OclParserGen( oclLexer, report );
        oclLexer.lexer( oclParser );
        IToken contextToken = oclParser.getTokenAtCharacter( index );
        if ( contextToken.getKind( ) != OclParserGensym.TK_context ) {
            return null;
        }
        List<String> pathName = getPath(oclParser, contextToken.getTokenIndex( ) + 1);
        return pathName;
    }

    public static List<String> getPath(OclParserGen oclParser, int index) {
	List<String> pathName = new ArrayList<String>( );
        int currentIndex = index;
        boolean pathDot = true;
        while ( true ) {
            IToken path = oclParser.getIToken( currentIndex );

            if ( pathDot ) {
                if ( path.getKind( ) == OclParserGensym.TK_IDENTIFIER ) {
                    pathName.add( path.toString( ) );
                    pathDot = false;
                } else {
                    break;
                }

            } else {
                if ( path.getKind( ) == OclParserGensym.TK_COLONCOLON ) {
                    pathDot = true;
                } else {
                    break;
                }
            }
            currentIndex++;
        }
	return pathName;
    }

    private void refreshModelElements( CoreConnection connection, Set<CoreModelPartition> partitions ) {

        this.modelElementsByName.clear( );
        this.modelElementsByOclQualifiedName.clear( );

        StringBuilder qname = new StringBuilder( );

        for ( CoreModelPartition partition : partitions ) {
            for ( Partitionable p : partition.getElements( ) ) {
                if ( p instanceof ModelElement ) {
                    ModelElement me = (ModelElement) p;
                    String name = me.getName( );
                    qname.setLength( 0 );
                    List<String> qnamelist = MoinMetamodelCode.getQualifiedName( connection, me, (RefObjectImpl) me );
                    try {
                        if ( qnamelist.get( 0 ).startsWith( OclConstants.OCLGENERATED ) ) {
                            continue;
                        }
                    } catch ( RuntimeException e ) {
                        // $JL-EXC$ ignore here
                    }
                    for ( Iterator<String> it = qnamelist.iterator( ); it.hasNext( ); ) {
                        qname.append( it.next( ) );
                        if ( it.hasNext( ) ) {
                            qname.append( OclConstants.PATHSEP );
                        }
                    }
                    List<ModelElement> elements = this.modelElementsByName.get( name );
                    if ( elements == null ) {
                        elements = new ArrayList<ModelElement>( );
                        this.modelElementsByName.put( name, elements );
                    }
                    elements.add( me );
                    this.modelElementsByOclQualifiedName.put( qname.toString( ), me );

                }
            }
        }
    }

    private IToken getLastToken( OclParserGen oclParser, int actOffset, boolean prevNull ) {

        int offset = actOffset;
        IToken lastToken = oclParser.getTokenAtCharacter( offset - 1 );

        if ( lastToken == null ) {
            if ( prevNull ) {
                IToken tmp = oclParser.getIToken( 1 );
                if ( tmp.getEndOffset( ) < offset ) {
                    while ( lastToken == null && offset > 1 ) {
                        offset--;
                        lastToken = oclParser.getTokenAtCharacter( offset - 1 );
                    }
                }

                if ( lastToken == null ) {
                    return null;
                }
            } else {
                this.behindWs = true;
                return null;
            }
        }


        if ( !isSimpleSymbol( lastToken ) && !prevNull ) {
            IToken prev = oclParser.getTokenAtCharacter( lastToken.getStartOffset( ) - 1 );
            if ( prev == null ) {
                this.behindWs = true;
                this.skippedToken = true;
                this.skippedOffset = lastToken.getStartOffset( );
                return null;
            } else if ( prev.getKind( ) == OclParserGensym.TK_DOT || prev.getKind( ) == OclParserGensym.TK_ARROW || prev.getKind( ) == OclParserGensym.TK_COLONCOLON ) {
//                behindWs=true;
                return prev;
            } else if ( lastToken.getKind( ) == OclParserGensym.TK_IDENTIFIER ) {
//                behindWs=true;
                return prev;
            } else {
                return lastToken;
            }
        }
//        behindWs=true;
        return lastToken;

//        IToken lastToken = oclParser.getTokenAtCharacter( offset - 1 );
//
//        if(lastToken == null)
//            return null;
//        if(!isSimpleSymbol( lastToken )&&!prevNull){           
//            IToken prev = oclParser.getTokenAt( lastToken.getTokenIndex( )-1 );
//            if(prev.getKind()==OclParserGensym.TK_DOT||prev.getKind()==OclParserGensym.TK_ARROW||prev.getKind()==OclParserGensym.TK_COLONCOLON){
//                behindWs=true;
//                return prev;
//            }
//            else if(lastToken.getKind( )==OclParserGensym.TK_IDENTIFIER){
//                behindWs=true;
//                return prev;
//            }
//            else
//                return lastToken;
//        }
//        behindWs=true;
//        return lastToken;

    }


    private ArrayList<IOclProposal> filter( String start, List<IOclProposal> proposals ) {

        ArrayList<IOclProposal> result = new ArrayList<IOclProposal>( 0 );
        for ( IOclProposal oclProposal : proposals ) {
            if ( oclProposal != null ) {
                String replacement = oclProposal.getReplacement( );
                if ( replacement.length( ) >= start.length( ) && replacement.substring( 0, start.length( ) ).compareToIgnoreCase( start ) == 0 ) {
                    result.add( oclProposal );
                }
            }
        }
        return result;
    }

    @SuppressWarnings( "boxing" )
    private MofPackageImpl getMofPackage( String constraint, int pos ) {

        List<Integer> positions;
        int position = -1;
        try {
            positions = findOccurences( constraint, new int[] { OclParserGensym.TK_package }, -1 );
            for ( int i = 0; i < positions.size( ); i++ ) {
                if ( positions.get( i ) > pos ) {
                    if ( i == 0 ) {
                        return null;
                    }
                    position = positions.get( i - 1 );
                } else if ( i == positions.size( ) - 1 ) {
                    position = positions.get( i );
                }
            }
            if ( position == -1 ) {
                return null;
            }
        } catch ( RuntimeException e ) {
            return null;
        }

        ProcessReportImpl report = new ProcessReportImpl( 1 );

        OclLexerGen oclLexer = new OclLexerGen( constraint.toCharArray( ), "OCL", report, 4 ); //$NON-NLS-1$

        // create the parser
        OclParserGen oclParser = new OclParserGen( oclLexer, report );

        oclLexer.lexer( oclParser );

        IToken contextToken = oclParser.getTokenAtCharacter( position );

        List<String> pathName = getPath(oclParser, contextToken.getTokenIndex() + 1);
        String packageName = StringHelper.toPathName( pathName );
        ModelElement me = this.modelElementsByOclQualifiedName.get( packageName );
        if ( me instanceof MofPackage ) {
            return (MofPackageImpl) me;
        }
        return null;
    }

    private List<Integer> findOccurences( String string, int[] tokenKinds, int maxOccurences ) throws IllegalStateException {

        List<Integer> result = new ArrayList<Integer>( );
        OclLexerGen lexer = new OclLexerGen( string.toCharArray( ), "OCL", new ProcessReportImpl( ), 4 ); //$NON-NLS-1$
        OclParserGen parser = new OclParserGen( lexer );
        lexer.lexer( parser );
        List<IToken> tokens = parser.getTokens( );
        for ( IToken token : tokens ) {
            int kind = token.getKind( );
            for ( int i : tokenKinds ) {
                if ( kind == i ) {
                    if ( maxOccurences >= 0 && result.size( ) == maxOccurences ) {
                        throw new IllegalStateException( );
                    }
                    result.add( Integer.valueOf( token.getStartOffset( ) ) );
                    break;
                }

            }
        }
        return result;

    }

    private String getDirectionKindString( DirectionKind kind ) {

        if ( kind != null ) {
            if ( kind.equals( DirectionKindEnum.IN_DIR ) ) {
                return "in"; //$NON-NLS-1$
            } else if ( kind.equals( DirectionKindEnum.OUT_DIR ) ) {
                return "out"; //$NON-NLS-1$
            } else if ( kind.equals( DirectionKindEnum.INOUT_DIR ) ) {
                return "inout"; //$NON-NLS-1$
            } else if ( kind.equals( DirectionKindEnum.RETURN_DIR ) ) {
                return "return"; //$NON-NLS-1$
            }
        }
        return "unknownDirection"; //$NON-NLS-1$
    }

    private Collection<? extends IOclProposal> computePropertyCallProposals( ClassifierInternal type, OCLEnvironment env, OCLTypeChecker checker, int offset, int newOffset, int tokenKind, int prio ) {

        CoreConnection connection = env.getJmiCreator( ).getConnection( );

        ArrayList<IOclProposal> result = new ArrayList<IOclProposal>( );

        if ( type == null ) {
            return result;
        }

        List<ModelElementInternal> elements = new ArrayList<ModelElementInternal>( );

        ClassifierInternal classifier = type;

        StdLibraryPackage stdLibpck = env.getJmiCreator( ).getConnection( ).getPackage( StdLibraryPackage.PACKAGE_DESCRIPTOR );

        if ( tokenKind == OclParserGensym.TK_DOT ) {
            if ( classifier instanceof CollectionTypeInternal ) {
                CollectionTypeInternal cT = (CollectionTypeInternal) classifier;
                classifier = getInnerType( connection, cT );
            }
        } else if ( tokenKind == OclParserGensym.TK_ARROW ) {
            if ( !( classifier instanceof CollectionType ) ) {
                classifier = (ClassifierInternal) env.getJmiCreator( ).createSetType( (Classifier) classifier );
            }
        }

        List<ClassifierInternal> classifiers = new ArrayList<ClassifierInternal>( 0 );

        boolean oclAny = tokenKind == OclParserGensym.TK_DOT;

        if ( classifier instanceof EnumerationType ) {
            if ( tokenKind == OclParserGensym.TK_COLONCOLON ) {
                EnumerationTypeInternal enumType = (EnumerationTypeInternal) classifier;
                String proposal = PROPSALPACKAGESEP + enumType.getName( );
                List<String> labels = enumType.getLabels( connection );
                for ( String string : labels ) {
                    result.add( new OCLProposalImpl( string + proposal, string, MoinReplacementStrings.ADDENUMLABEL, newOffset, offset - newOffset, IOclProposal.TYPE.ENUMLABEL, prio, null, null ) );
                }
            }
            return result;
        }

        if ( classifier instanceof CollectionType || classifier instanceof PrimitiveType ) {
            try {
                MofPackageImpl mp = (MofPackageImpl) stdLibpck.refMetaObject( );
                String name = classifier.getName( ).split( "\\(|Lit" )[0]; //$NON-NLS-1$
                ModelElementInternal me;
                if ( classifier instanceof CollectionType ) {
                    me = (ModelElementInternal) mp.lookupElement( name + "TypeStdLib" ); //$NON-NLS-1$
                    classifiers.add( (ClassifierInternal) stdLibpck.getCollectionTypeStdLib( ).refMetaObject( ) );
                } else {
                    me = (ModelElementInternal) mp.lookupElement( name + "StdLib" ); //$NON-NLS-1$
                }

                if ( me instanceof Classifier ) {
                    classifiers.add( (ClassifierInternal) me );
                } else {
                    return result;
                }

                if ( name.equals( OclConstants.T_OCLANY ) ) {
                    oclAny = false;
                }
            } catch ( JmiException e ) {
                return result;
            } catch ( NameNotFoundException e ) {
                return result;
            }
        } else if ( classifier.getName( ).contains( OclConstants.STDLIBSUBTRING ) ) {
            classifiers.add( (ClassifierInternal) stdLibpck.getOclTypeStdLib( ).refMetaObject( ) );
        } else if ( tokenKind == OclParserGensym.TK_COLONCOLON ) {
            classifiers.add( classifier );
        } else {
            classifiers.add( classifier );
            List<GeneralizableElement> supertypes = ( (GeneralizableElementInternal) classifier ).allSupertypes( env.getJmiCreator( ).getConnection( ) );
            for ( GeneralizableElement gE : supertypes ) {
                if ( gE instanceof Classifier ) {
                    classifiers.add( (ClassifierInternal) gE );
                }
            }
        }
        if ( oclAny ) {
            classifiers.add( (ClassifierInternal) stdLibpck.getOclAnyStdLib( ).refMetaObject( ) );
        }

        for ( ClassifierInternal currentClassifier : classifiers ) {

            boolean isStdType = currentClassifier.getName( ).contains( OclConstants.STDLIBSUBTRING );

            JmiList<ModelElement> list = (JmiList<ModelElement>) currentClassifier.getContents( env.getJmiCreator( ).getConnection( ) );

            //add attributes, references and operations
            for ( Iterator<ModelElement> iterator = list.iteratorReadOnly( env.getJmiCreator( ).getConnection( ).getSession( ) ); iterator.hasNext( ); ) {
                ModelElementInternal modelElement = (ModelElementInternal) iterator.next( );

                if ( modelElement instanceof Operation ) {
                    if ( isStdType && modelElement.getName( ).contains( OclConstants.STDLIBSUBTRING ) ) {
                        continue;
                    }
                    elements.add( modelElement );
                } else if ( !( isStdType ) && modelElement instanceof Attribute ) {
                    elements.add( modelElement );
                } else if ( !( isStdType || tokenKind == OclParserGensym.TK_COLONCOLON ) && modelElement instanceof Reference ) {
                    elements.add( modelElement );
                } else if ( !( isStdType || tokenKind == OclParserGensym.TK_COLONCOLON ) && currentClassifier instanceof Association && modelElement instanceof AssociationEnd ) {
                    elements.add( modelElement );
                }
            }

            //add association ends
            if ( !( isStdType || tokenKind == OclParserGensym.TK_COLONCOLON ) ) {
                Set<AssociationEnd> assoEnds = env.getJmiCreator( ).getConnection( ).getCoreJmiHelper( ).getAssociationEnds( env.getJmiCreator( ).getConnection( ).getSession( ), (Classifier) currentClassifier, false );
                for ( AssociationEnd associationEnd : assoEnds ) {
                    elements.add( (AssociationEndInternal) ( (AssociationEndInternal) associationEnd ).otherEnd( env.getJmiCreator( ).getConnection( ) ) );
                }
            }
        }

        for ( ModelElementInternal modelElement : elements ) {
            result.add( computeProposalForElement( connection, modelElement, offset, newOffset, checker, tokenKind, prio ) );
        }

        return result;
    }

    private ClassifierInternal getOCLExpressionType( ServiceOCLEnvironment env, int index, String txt ) {

        return getOCLExpressionType( env, index, txt, BOUNDARY );
    }

    private ClassifierInternal getOCLExpressionType( ServiceOCLEnvironment env, int index, String txt, int[] boundaryKind ) {

        int start = 0;
        int end = index;

        String newTxt = txt.substring( start, end );

        ProcessReportImpl report = new ProcessReportImpl( 1 );

        OclLexerGen lexer = new OclLexerGen( newTxt.toCharArray( ), "OCL", report, 4 ); //$NON-NLS-1$

        // create the parser
        OclParserGen parser = new OclParserGen( lexer, report );

        lexer.lexer( parser );

        List<IToken> tokens = parser.getTokens( );

        ListIterator<IToken> it = tokens.listIterator( tokens.size( ) );

        int[] balance = { 0 };

        IToken token; // possible start token of a complete sub-expression
        IToken bdry; // peek back one more looking for a boundary token

        for ( int i = 0; it.hasPrevious( ) && i < 100; i++ ) {
            token = it.previous( );

            // as long as we have an unmatched right paren/bracket/brace, there
            //   is no point in trying to parse anything.  Even if the previous
            //   token were the matching left, the pair cannot be parsed in
            //   isolation
            while ( ( updateBalance( balance, token ) ) > 0 && it.hasPrevious( ) ) {
                token = it.previous( );
            }

            boolean tryParse = true;

//            if ( isBoundaryToken( token ) ) {
            if ( hasTokenKind( token, boundaryKind ) ) {
                // can't proceed any farther left looking for a sub-expression
                //   to parse
                break;
            }

            // if we're at the beginning of input, try to parse
            if ( it.hasPrevious( ) ) {
                // otherwise, see whether we are at a syntactic boundary
                bdry = it.previous( );

                int oldBalance = balance[0];

                // can't go farther left than a mismatched left paren/bracket/brace
//                if ( isBoundaryToken( bdry ) || ( updateBalance( balance, bdry ) < 0 ) ) {
                if ( hasTokenKind( bdry, boundaryKind ) || ( updateBalance( balance, bdry ) < 0 ) ) {
                    tryParse = true;
                } else {
                    tryParse = false;
                    it.next( ); // push this non-boundary token back

                    // restore the balance if it changed
                    balance[0] = oldBalance;
                }
            }

            if ( tryParse ) {
                start = token.getStartOffset( );
                newTxt = OclConstants.EMPTY;
//                for ( int j = 0; j < start; j++ ) {
//                    newTxt += " ";
//                }
                newTxt += txt.substring( start, end );

                String envTxt = txt.substring( 0, start );

                lexer = new OclLexerGen( newTxt.toCharArray( ), "OCL", report, 4 ); //$NON-NLS-1$
                parser = new OclParserGen( lexer, report );

                lexer.lexer( parser );

                Node ast = parser.parser( 100 );



//              // set the defined features in the newly built environment
//              if ( oclDefinedFeatures != null ) {
//              for ( Map.Entry<Classifier, Set<Feature>> oclDefinedFeature : oclDefinedFeatures.entrySet( ) ) {
//              for ( Feature feature : oclDefinedFeature.getValue( ) ) {
//              if ( feature instanceof Operation ) {
//              oclLookupTables.defineUserDefOperation( oclDefinedFeature.getKey( ), (Operation) feature );
//              }
//              }
//              }
//              }

                // obtain a semantic analyser

                if ( ast != null ) {
                    try {
                        try {
                            getRealEnv( env, envTxt/* , searchedVar */);
                        } catch ( RuntimeException e ) {
                            // $JL-EXC$ TODO trace this
                        } catch ( OclSemanticException e ) {
                            // $JL-EXC$ TODO trace this
                        }
                        this.transformation.clearReport( );
                        if ( this.transformation instanceof AnnotationMRIVisitor ) {
                            ( (AnnotationMRIVisitor) this.transformation ).setShift( start );
                        }
                        ast.accept( this.transformation );

                        return (ClassifierInternal) this.transformation.getType( );

                    } catch ( RuntimeException e ) {
                        return null;
                    } finally {
                        if ( env.getReport( ) instanceof AllConsumingProcessReport ) {
                            ( (AllConsumingProcessReport) env.getReport( ) ).shiftMessagesByOffset( start );

                        }
                    }
                }
                it.next( );
            }
        }
        return null;
    }

    private void getRealEnv( ServiceOCLEnvironment env, String envTxt ) throws OclSemanticException {

        ProcessReportImpl report = new ProcessReportImpl( 1 );
        OclLexerGen lexer = new OclLexerGen( envTxt.toCharArray( ), "OCL", report, 4 ); //$NON-NLS-1$
        OclParserGen parser = new OclParserGen( lexer, report );

        lexer.lexer( parser );

        List<IToken> tokens = parser.getTokens( );

        ListIterator<IToken> it = tokens.listIterator( tokens.size( ) );

        int[] balance = { 0 };
        int[] ifBalance = { 0 };

        IToken token;
        IToken bdry;

//        int oldStackSize = env.getStackSize( );

        for ( int i = 0; it.hasPrevious( ) && i < 100; i++ ) {
            token = it.previous( );
            boolean allowThenElse = true;

            //new
            if ( isDeclToken( token ) ) {
//                mostLeftOffset=0;
                return;
            }
            //end new

            // as long as we have an unmatched right paren/bracket/brace, there
            // can't be any new environment variables  
            int oldBalance = balance[0];
            while ( ( updateBalance( balance, token ) ) > 0 && it.hasPrevious( ) ) {
                token = it.previous( );
            }
            balance[0] = oldBalance;


            while ( ( updateIfBalance( ifBalance, token, allowThenElse ) ) > 0 && it.hasPrevious( ) ) {
                token = it.previous( );
                allowThenElse = false;
            }

            if ( token.getKind( ) == OclParserGensym.TK_DOTDOT ) {
                while ( token.getKind( ) != OclParserGensym.TK_LBRACE && it.hasPrevious( ) && updateBalance( balance, token ) == 0 ) {
                    token = it.previous( );
                }
            }

            if ( it.hasPrevious( ) ) {

                bdry = it.previous( );

                oldBalance = balance[0];

                if ( updateBalance( balance, bdry ) < 0 ) {
                    if ( it.hasPrevious( ) ) {
                        IToken tmp = it.previous( );
                        if ( isIteratorExpToken( tmp ) ) {
                            if ( it.hasPrevious( ) ) {
                                tmp = it.previous( );
                                if ( tmp.getKind( ) == OclParserGensym.TK_ARROW ) {
                                    ClassifierInternal classifier = getOCLExpressionType( env, tmp.getStartOffset( ), envTxt );
//                                    if(varFound( env, searchedVar )){
//                                        return;
//                                    }
//                                    else{
//                                        if(mostLeftOffset>0)
//                                            getRealEnv( env, envTxt.substring( 0, mostLeftOffset )/*, searchedVar*/ );
//                                    }
                                    while ( classifier instanceof CollectionType ) {
                                        CollectionTypeInternal cT = (CollectionTypeInternal) classifier;
                                        classifier = (ClassifierInternal) cT.getElementType( env.getJmiCreator( ).getConnection( ) );
                                    }

                                    org.omg.ocl.expressions.VariableDeclaration var = env.getJmiCreator( ).createVariableDeclaration( OclConstants.EMPTY, (Classifier) classifier, null );
                                    env.enterNewVariableScope( );
                                    env.declareVariable( var );
                                    return;
                                }
                                throw new OclSemanticException( OclServiceExceptions.ARROWEXPECTED );
                            }
                        }
                        it.next( );
                    }
                    it.next( );
                    balance[0] = oldBalance;
                } else if ( isBarToken( bdry ) ) {
                    int end = bdry.getStartOffset( );
                    while ( it.hasPrevious( ) && ( updateBalance( balance, bdry ) >= 0 ) ) {
                        bdry = it.previous( );
                    }
                    int start = bdry.getEndOffset( ) + 1;
                    String varDecl = envTxt.substring( start, end );

                    String opname = null;

                    if ( it.hasPrevious( ) ) {
                        IToken tmp = it.previous( );
                        if ( isIteratorExpToken( tmp ) ) {
                            opname = tmp.toString( );
                            if ( it.hasPrevious( ) ) {
                                tmp = it.previous( );
                                if ( tmp.getKind( ) == OclParserGensym.TK_ARROW ) {
                                    bdry = tmp;
                                } else {
                                    throw new OclSemanticException( OclServiceExceptions.ARROWEXPECTED );
                                }
                            }
                        } else {
                            throw new OclSemanticException( OclServiceExceptions.ITERATOREXPEXPECTED );
                        }
                    }

//                  int numberOfVars = env.getVariables( ).size( );

                    ClassifierInternal classifier = getOCLExpressionType( env, bdry.getStartOffset( ), envTxt );
//                    Classifier realClassifier = null;
                    if ( classifier == null ) {
                        return;
                    }

                    while ( classifier instanceof CollectionType ) {
                        CollectionTypeInternal cT = (CollectionTypeInternal) classifier;
                        classifier = (ClassifierInternal) cT.getElementType( env.getJmiCreator( ).getConnection( ) );
                    }
                    String cQN = OclConstants.EMPTY;
                    boolean first = true;
                    if ( classifier instanceof PrimitiveType ) {
                        cQN = classifier.getName( );
                    } else {
                        List<String> qn;
                        if ( classifier instanceof TupleTypeImpl || classifier.getName( ).endsWith( OclConstants.STDLIBSUBTRING ) ) {
//                          realClassifier=classifier;
//                          classifier = ((Classifier) env.getContext( ));
//                          qn = classifier.getQualifiedName( );
                            qn = ( (ModelElementInternal) ( (VariableDeclarationInternal) env.lookupVarByName( OclConstants.VAR_SELF ) ).getType( env.getJmiCreator( ).getConnection( ) ) ).getQualifiedName( env.getJmiCreator( ).getConnection( ) );
                        } else {
                            qn = ( (ModelElementInternal) classifier ).getQualifiedName( env.getJmiCreator( ).getConnection( ) );
                        }

                        for ( String n : qn ) {
                            if ( !first ) {
                                cQN += OclConstants.PATHSEP;

                            }
                            first = false;
                            cQN += n;
                        }
                    }
                    String iterExpr = cQN + ".allInstances()->" + opname + OclConstants.BRACKETLEFT + varDecl + "|true)"; //$NON-NLS-1$//$NON-NLS-2$
                    lexer = new OclLexerGen( iterExpr.toCharArray( ), "OCL", report, 4 ); //$NON-NLS-1$
                    parser = new OclParserGen( lexer, report );

                    lexer.lexer( parser );

                    Node ast = parser.parser( 100 );

                    if ( ast instanceof OclFileOclExpression ) {

                        Set<VariableDeclarationInternal> vars = null;

//                        if(classifier instanceof TupleTypeImpl){
//                            OclFileOclExpression oFOE = (OclFileOclExpression) ast;                          
//                            IoclExpression oE = oFOE.getoclExpression( );
//                            if ( oE instanceof PostfixExpression ) {
//                                PostfixExpression pE = (PostfixExpression) oE;
//                                ast=pE;
//                                IpropertyInvocation pI = pE.getpropertyInvocation( );
//                                if ( pI instanceof LoopPropertyInvocation ) {
//                                    LoopPropertyInvocation lpi = (LoopPropertyInvocation) pI;
//                                    ast=lpi;
//                                    IloopExp le = lpi.getloopExp( );
//                                    if ( le instanceof IiteratorExp ) {
//                                        IiteratorExp iterExp = (IiteratorExp) le;
//                                        iterExp.getIterators( );
//                                        
//                                    }
//                                    if ( le instanceof IteratorForAll ) {
//                                        IteratorForAll ifa = (IteratorForAll) le;
//                                        IiterContents ic = ifa.getiterContents( );                                    
//                                        if ( ic instanceof IteratorOneVarDecl ) {                                        
//                                            IteratorOneVarDecl ovd = (IteratorOneVarDecl) ic;
//                                            com.sap.tc.moin.ocl.parser.gen.oclAst.VariableDeclaration vd = ovd.getvariableDeclaration( );
//                                            String nameOne = vd.getidentifier( ).getIToken( ).toString( );
//                                            vars.add( env.getJmiCreator().createVariableDeclaration( nameOne, classifier, null ));
//                                        }
//                                        else if ( ic instanceof IteratorTwoVarDecl ) {                                        
//                                            IteratorTwoVarDecl tvd = (IteratorTwoVarDecl) ic;
//                                            com.sap.tc.moin.ocl.parser.gen.oclAst.VariableDeclaration vd = tvd.getvariableDeclaration( );
//                                            String nameOne = vd.getidentifier( ).getIToken( ).toString( );
//                                            vd = tvd.getvariableDeclaration3( );
//                                            String nameTwo = vd.getidentifier( ).getIToken( ).toString( );                                           
//                                            vars.add(env.getJmiCreator().createVariableDeclaration( nameOne, classifier, null ));                                            
//                                            vars.add(env.getJmiCreator().createVariableDeclaration( nameTwo, classifier, null ));
//                                           
//    
//                                        }
//                                    }
//                                }
//                            }
//                        }else{
                        ast.accept( this.transformation );
                        vars = this.transformation.getVariables( );

//                        }
                        if ( vars != null ) {
                            org.omg.ocl.expressions.VariableDeclaration[] varArray = vars.toArray( new org.omg.ocl.expressions.VariableDeclaration[vars.size( )] );
                            env.enterNewVariableScope( );
                            for ( VariableDeclaration variableDeclaration : varArray ) {
                                if ( classifier instanceof TupleTypeImpl || classifier.getName( ).endsWith( OclConstants.STDLIBSUBTRING ) ) {
                                    variableDeclaration.setType( (Classifier) classifier );
                                }
                                env.declareVariable( variableDeclaration );
                            }
                        }
                        return;
//                        if(varFound( env, searchedVar )){
//                            return;
//                        }
//                        else if(mostLeftOffset>0){
//                            List<ServiceOCLVariableScope> addedScopes = env.splitScopesFromStack( oldStackSize );
//                            getRealEnv( env, envTxt.substring( 0, mostLeftOffset )/*, searchedVar*/ );
//                            env.addServiceScopes( addedScopes );
//                        }
                    }
//                  Iterator<org.omg.ocl.expressions.VariableDeclaration > iter = visitor.getVariables( ).iterator( );
//                  ArrayList<org.omg.ocl.expressions.VariableDeclaration >vDs = new ArrayList<VariableDeclaration>(vars.size( ));
//                  env.enterNewVariableScope( );
//                  while (iter.hasNext( )){
//                  org.omg.ocl.expressions.VariableDeclaration var = iter.next();
//                  env.declareVariable( var );                            
//                  }



                } else if ( bdry.getKind( ) == OclParserGensym.TK_in ) {
                    int[] letBalance = { 0 };
                    int end = bdry.getEndOffset( ) + 1;
                    while ( updateLetBalance( letBalance, bdry ) > 0 && it.hasPrevious( ) ) {
                        bdry = it.previous( );
                    }
                    int start = bdry.getStartOffset( );
                    String letExpr = envTxt.substring( start, end ) + OclConstants.SPACE + OclConstants.TRUE;
//                  getOCLExpressionType( env, bdry.getStartOffset( ), envTxt );
//                  if(!varFound( env, searchedVar ))
                    try {
                        getRealEnv( env, envTxt.substring( 0, start )/*
                                                                      * ,
                                                                      * searchedVar
                                                                      */);
                    } catch ( RuntimeException e ) {
                        // $JL-EXC$ TODO trace this
                    } catch ( OclSemanticException e ) {
                        // $JL-EXC$ TODO trace this
                    }

//                    if(varFound( env, searchedVar )){
//                        return;
//                    }

                    lexer = new OclLexerGen( letExpr.toCharArray( ), "OCL", report, 4 ); //$NON-NLS-1$
                    parser = new OclParserGen( lexer, report );

                    lexer.lexer( parser );

                    Node ast = parser.parser( 100 );
                    if ( ast instanceof OclFileOclExpression ) {

//                        TypeVisitor visitor = new TypeVisitor(env);
//                      ast.accept( visitor );
////                    Set<org.omg.ocl.expressions.VariableDeclaration> vars = visitor.getVariables( );
//                      env.enterNewVariableScope( );
//                      Iterator<org.omg.ocl.expressions.VariableDeclaration > iter = visitor.getVariables( ).iterator( );
//                      while (iter.hasNext( )){
//                      org.omg.ocl.expressions.VariableDeclaration var = iter.next();
//                      env.declareVariable( var );                            
//                      }
//                      return;

                        OclFileOclExpression ofoe = (OclFileOclExpression) ast;
                        IoclExpression oE = ofoe.getoclExpression( );
                        if ( oE instanceof LetExpression ) {
                            TypeVisitor visitor = new TypeVisitor( env );
                            LetExpression le = (LetExpression) oE;
                            List<VariableDeclarationInternal> vDecls = new ArrayList<VariableDeclarationInternal>( 1 );
                            List<VariableAssignment> varAssignments = new ArrayList<VariableAssignment>( 1 );

                            IvariableAssignmentN ivan = le.getvariableAssignmentN( );
                            while ( ivan instanceof VariableAssignmentN ) {
                                VariableAssignmentN van = (VariableAssignmentN) ivan;
                                varAssignments.add( van.getvariableAssignment( ) );
                                ivan = van.getvariableAssignmentN( );
                            }
                            varAssignments.add( (VariableAssignment) ivan );
                            for ( VariableAssignment variableAssignment : varAssignments ) {
                                visitor.clear( );

                                try {
                                    variableAssignment.accept( visitor );
                                    vDecls.addAll( visitor.getVariables( ) );
                                } catch ( RuntimeException e ) {
                                    // $JL-EXC$ ignore here
                                }


                            }
                            env.enterNewVariableScope( );
                            for ( VariableDeclarationInternal variableDeclaration : vDecls ) {
                                env.declareVariable( (VariableDeclaration) variableDeclaration );
                            }
                            return;
                        }
                    }
                } else {

                    it.next( ); // push this non-boundary token back

                    // restore the balance if it changed
                    balance[0] = oldBalance;
                }

            }
        }
    }

    private String getOclReadableType( CoreConnection connection, ClassifierInternal type ) {

        if ( type instanceof CollectionType ) {
            CollectionType ctype = (CollectionType) type;
            String inner = getOclReadableType( connection, (ClassifierInternal) ( (CollectionTypeInternal) ctype ).getElementType( connection ) );
            String outer = OclConstants.EMPTY;
            if ( type instanceof SetType ) {
                outer = OclConstants.T_SET;
            }
            if ( type instanceof OrderedSetType ) {
                outer = OclConstants.T_ORDEREDSET;
            }
            if ( type instanceof BagType ) {
                outer = OclConstants.T_BAG;
            }
            if ( type instanceof SequenceType ) {
                outer = OclConstants.T_SEQUENCE;
            }
            return outer + OclConstants.BRACKETLEFT + OclConstants.SPACE + inner + OclConstants.SPACE + OclConstants.BRACKETRIGHT;
        }
        if ( this.modelElementsByName.get( type.getName( ) ) != null && this.modelElementsByName.get( type.getName( ) ).size( ) > 1 ) {
            return StringHelper.toPathName( ( (ModelElementInternal) type ).getQualifiedName( connection ) );
        }
        return type.getName( );
    }

    private boolean isBarToken( IToken token ) {

        switch ( token.getKind( ) ) {
            case OclParserGensym.TK_BAR:
                return true;
            default:
                return false;
        }
    }

    private boolean isIterateExpToken( IToken token ) {

        switch ( token.getKind( ) ) {
            case OclParserGensym.TK_iterate:
                return true;
            default:
                return false;
        }
    }

    private boolean isTwoVarIteratorExpToken( IToken token ) {

        switch ( token.getKind( ) ) {
            case OclParserGensym.TK_exists:
            case OclParserGensym.TK_forAll:
                return true;
            default:
                return false;
        }
    }

    private boolean isIteratorExpToken( IToken token ) {

        switch ( token.getKind( ) ) {
            case OclParserGensym.TK_iterate:
            case OclParserGensym.TK_exists:
            case OclParserGensym.TK_forAll:
            case OclParserGensym.TK_isUnique:
            case OclParserGensym.TK_any:
            case OclParserGensym.TK_one:
            case OclParserGensym.TK_collect:
            case OclParserGensym.TK_select:
            case OclParserGensym.TK_reject:
            case OclParserGensym.TK_collectNested:
            case OclParserGensym.TK_sortedBy:
                return true;
            default:
                return false;
        }
    }

    private int updateBalance( int[] balance, IToken token ) {

        switch ( token.getKind( ) ) {
            case OclParserGensym.TK_LPAREN:
            case OclParserGensym.TK_LBRACKET:
            case OclParserGensym.TK_LBRACE:
                balance[0]--;
                break;
            case OclParserGensym.TK_RPAREN:
            case OclParserGensym.TK_RBRACKET:
            case OclParserGensym.TK_RBRACE:
                balance[0]++;
                break;
        }

        return balance[0];
    }

    private int updateLetBalance( int[] balance, IToken token ) {

        switch ( token.getKind( ) ) {
            case OclParserGensym.TK_let:
                balance[0]--;
                break;
            case OclParserGensym.TK_in:
                balance[0]++;
                break;
        }
        return balance[0];
    }

    private int updateIfBalance( int[] balance, IToken token, boolean considerThenElse ) {

        switch ( token.getKind( ) ) {
            case OclParserGensym.TK_if:
                balance[0]--;
                break;
            case OclParserGensym.TK_then:
            case OclParserGensym.TK_else:
                if ( considerThenElse ) {
                    balance[0]++;
                }
                break;
            case OclParserGensym.TK_endif:
                balance[0]++;
                break;
        }
        return balance[0];
    }

    /**
     * A token marking a boundary to the right of which the right-most
     * sub-expression (which we are to complete) must lie, barring parentheses,
     * brackets, or braces. These boundary tokens include all infix operations
     * and other tokens such as ':', ';', ',', 'let', 'in', 'if', 'then',
     * 'else', 'endif'. This boundary token and anything to the left cannot be
     * considered as part of the expression that we are completing.
     * 
     * @param token a token
     * @return whether it is a boundary token
     */
    private boolean isBoundaryToken( IToken token ) {

        switch ( token.getKind( ) ) {
            case OclParserGensym.TK_COLON:
            case OclParserGensym.TK_COMMA:
            case OclParserGensym.TK_SEMICOLON:
            case OclParserGensym.TK_BAR:
            case OclParserGensym.TK_in:
            case OclParserGensym.TK_let:
            case OclParserGensym.TK_and:
            case OclParserGensym.TK_or:
            case OclParserGensym.TK_xor:
            case OclParserGensym.TK_implies:
            case OclParserGensym.TK_endif:
            case OclParserGensym.TK_then:
            case OclParserGensym.TK_else:
            case OclParserGensym.TK_if:
            case OclParserGensym.TK_EQUAL:
            case OclParserGensym.TK_NOT_EQUAL:
            case OclParserGensym.TK_GREATER:
            case OclParserGensym.TK_GREATER_EQUAL:
            case OclParserGensym.TK_LESS:
            case OclParserGensym.TK_LESS_EQUAL:
            case OclParserGensym.TK_PLUS:
            case OclParserGensym.TK_MINUS:
            case OclParserGensym.TK_MULTIPLY:
            case OclParserGensym.TK_DIVIDE:
            case OclParserGensym.TK_INTEGER_RANGE_START:
            case OclParserGensym.TK_DOTDOT:
            case OclParserGensym.TK_context:
                return true;
            default:
                return false;
        }
    }

    private boolean hasTokenKind( IToken token, int[] kinds ) {

        int tokenKind = token.getKind( );
        for ( int kind : kinds ) {
            if ( kind == tokenKind ) {
                return true;
            }
        }
        return false;
    }

    private boolean isPathBoundaryToken( IToken token ) {

        boolean result = isBoundaryToken( token );
        if ( result == false ) {
            switch ( token.getKind( ) ) {
                case OclParserGensym.TK_LPAREN:
                    return true;
                default:
                    return false;
            }
        }
        return result;

    }

    private boolean isDeclToken( IToken token ) {

        switch ( token.getKind( ) ) {
            case OclParserGensym.TK_inv:
            case OclParserGensym.TK_def:
            case OclParserGensym.TK_init:
            case OclParserGensym.TK_body:
            case OclParserGensym.TK_pre:
            case OclParserGensym.TK_post:
            case OclParserGensym.TK_derive:
                return true;
            default:
                return false;
        }
    }

    private IOclProposal computeOperationProposal( CoreConnection connection, OperationInternal op, IOCLTypeChecker checker, int offset, int newOffset, int tokenKind, int prio ) {

        List<String> params = new ArrayList<String>( 0 );

        JmiList<ModelElement> opElems = (JmiList<ModelElement>) op.getContents( connection );
        List<String> directionParamStrings = new ArrayList<String>( 0 );
        List<String> paramStrings = new ArrayList<String>( 0 );
        String resultType = null;
        String oclResultType = null;
        for ( Iterator<ModelElement> iterator = opElems.iteratorReadOnly( connection.getSession( ) ); iterator.hasNext( ); ) {
            ModelElement modelElement = iterator.next( );
            if ( modelElement instanceof Parameter ) {
                Parameter param = (Parameter) modelElement;
                if ( param.getDirection( ).equals( DirectionKindEnum.RETURN_DIR ) ) {
                    MultiplicityType multi = param.getMultiplicity( );
                    ClassifierInternal cl = (ClassifierInternal) checker.createOclType( multi, ( (ParameterInternal) param ).getType( connection ) );
                    resultType = cl.getName( );
                    oclResultType = getOclReadableType( connection, cl );
                } else {
                    MultiplicityType multi = param.getMultiplicity( );
                    if ( param.getDirection( ).equals( DirectionKindEnum.IN_DIR ) || param.getDirection( ).equals( DirectionKindEnum.INOUT_DIR ) ) {
                        String paramString;
                        ClassifierInternal cl = (ClassifierInternal) checker.createOclType( multi, ( (ParameterInternal) param ).getType( connection ) );
                        if ( tokenKind != OclParserGensym.TK_COLONCOLON ) {
                            params.add( param.getName( ) );
                            paramString = param.getName( ) + PROPOSALTYPESEP + cl.getName( );
                        } else {
                            paramString = param.getName( ) + PROPOSALTYPESEP + getOclReadableType( connection, cl );
                        }
                        paramStrings.add( paramString );
                        directionParamStrings.add( getDirectionKindString( param.getDirection( ) ) + OclConstants.SPACE + paramString );
                    }
                }
            }
        }



        String directionParamString = OclConstants.SPACE;

        boolean start = true;
        for ( String string : directionParamStrings ) {
            if ( !start ) {
                directionParamString += ", "; //$NON-NLS-1$
            } else {
                start = false;
            }
            directionParamString += string + OclConstants.SPACE;

        }
        String paramString = OclConstants.SPACE;
        start = true;
        for ( String string : paramStrings ) {
            if ( !start ) {
                paramString += ", "; //$NON-NLS-1$
            } else {
                start = false;
            }
            paramString += string + OclConstants.SPACE;

        }

        String replacement;

        if ( tokenKind == OclParserGensym.TK_COLONCOLON ) {
            if ( oclResultType != null ) {
                replacement = op.getName( ) + OclConstants.BRACKETLEFT + paramString + OclConstants.BRACKETRIGHT + PROPOSALTYPESEP + oclResultType;
            } else {
                replacement = op.getName( ) + OclConstants.BRACKETLEFT + paramString + OclConstants.BRACKETRIGHT + PROPOSALTYPESEP + OclConstants.T_OCLVOID;
            }
        } else {
            replacement = op.getName( ) + OPERATIONBRACKETS;
        }

        Object[] proposalPars;
        if ( resultType != null ) {
            proposalPars = new Object[] { op.getName( ) + OclConstants.BRACKETLEFT + directionParamString + OclConstants.BRACKETRIGHT, resultType, StringHelper.toPathName( ( (ModelElementInternal) op.getContainer( connection ) ).getQualifiedName( connection ) ) };
        } else {
            proposalPars = new Object[] { op.getName( ) + OclConstants.BRACKETLEFT + directionParamString + OclConstants.BRACKETRIGHT, OclConstants.T_OCLVOID, StringHelper.toPathName( ( (ModelElementInternal) op.getContainer( connection ) ).getQualifiedName( connection ) ) };
        }

        List<String> delimiters = new ArrayList<String>( 0 );


        for ( int i = 1; i < params.size( ); i++ ) {
            delimiters.add( "," ); //$NON-NLS-1$
        }

        String additionalInfo = computeAdditionalInformation( connection, op, checker, false );
        if ( op.getAnnotation( ).equals( OclConstants.EMPTY ) ) {
            additionalInfo = OclConstants.EMPTY;
        }

        return new OCLProposalImpl( MoinReplacementStrings.ELEMENTPROPOSAL, proposalPars, replacement, additionalInfo, newOffset, offset - newOffset, IOclProposal.TYPE.OPERATION, prio, params, delimiters );

    }

    @SuppressWarnings( "nls" )
    String computeAdditionalInformation( CoreConnection connection, ModelElementInternal me, IOCLTypeChecker checker, boolean prependMEInformation ) {

        String result = me.getAnnotation( );
        if ( me instanceof Operation ) {

            Operation op = (Operation) me;
            String returns = "<dt><b>Returns:</b></dt>";
            String parameters = "<dt><b>Parameters:</b></dt>";
            for ( Iterator<ModelElement> iterator = ( (JmiList<ModelElement>) ( (OperationInternal) op ).getContents( connection ) ).iteratorReadOnly( connection.getSession( ) ); iterator.hasNext( ); ) {
                ModelElement modelElement = iterator.next( );

                if ( modelElement instanceof Parameter ) {
                    Parameter param = (Parameter) modelElement;
                    if ( param.getDirection( ) == DirectionKindEnum.RETURN_DIR ) {
                        if ( !param.getAnnotation( ).equals( OclConstants.EMPTY ) ) {
                            returns += "<dd>" + param.getAnnotation( ) + "</dd>";
                        }
                    } else {
                        parameters += "<dd><b>" + param.getName( ) + "</b> " + param.getAnnotation( ) + "</dd>";
                    }


                }
            }
            if ( parameters.equals( "<dt><b>Parameters:</b></dt>" ) ) {
                parameters = OclConstants.EMPTY;
            }
            if ( returns.equals( "<dt><b>Returns:</b></dt>" ) ) {
                returns = OclConstants.EMPTY;
            }
            result += "<br><dl>" + parameters + returns + "</dl>";
        }
        if ( prependMEInformation ) {
            String prepend;
            if ( me instanceof GeneralizableElement ) {
                prepend = StringHelper.toPathName( me.getQualifiedName( connection ) );
            } else {
                prepend = computeProposalForElement( connection, me, 0, 0, checker, OclParserGensym.TK_DOT, MIDPRIO ).getProposalString( Locale.ENGLISH );
            }
            result = "<b>" + prepend + "</b><br><br>" + result;
        }
        return result;
    }

    private boolean setContext( OCLEnvironment env, String constraint, int offset ) {

        List<String> pathName = getContextPath( constraint, offset );

        if ( pathName == null ) {
            return false;
        }

        Classifier context = env.lookupClassifierByPathName( pathName );
        ModelElement me = context;

        List<VariableDeclaration> additionalVars = new ArrayList<VariableDeclaration>( 0 );
        if ( context == null ) {
            context = env.lookupClassifierByPathName( pathName.subList( 0, pathName.size( ) - 1 ) );
            if ( context != null ) {
                try {
                    me = context.lookupElement( pathName.get( pathName.size( ) - 1 ) );
                } catch ( JmiException e ) {
                    return false;
                } catch ( NameNotFoundException e ) {
                    return false;
                }
                if ( me instanceof Operation ) {
                    Operation op = (Operation) me;
                    OCLTypeChecker checker = new OCLTypeChecker( env.getJmiCreator( ) );

                    JmiList<ModelElement> list = (JmiList<ModelElement>) ( (OperationInternal) op ).getContents( env.getJmiCreator( ).getConnection( ) );

                    //add attributes, references and operations

                    Iterator<ModelElement> iterator = list.iteratorReadOnly( env.getJmiCreator( ).getConnection( ).getSession( ) );

                    while ( iterator.hasNext( ) ) {
                        ModelElement modelElement = iterator.next( );
                        if ( modelElement instanceof Parameter ) {
                            Parameter param = (Parameter) modelElement;

                            try {
                                if ( param.getDirection( ) == DirectionKindEnum.RETURN_DIR ) {
                                    additionalVars.add( env.getJmiCreator( ).createVariableDeclaration( OclConstants.VAR_RESULT, checker.createOclType( param.getMultiplicity( ), param.getType( ) ), null ) );
                                } else {
                                    additionalVars.add( env.getJmiCreator( ).createVariableDeclaration( param.getName( ), checker.createOclType( param.getMultiplicity( ), param.getType( ) ), null ) );
                                }
                            } catch ( OclSemanticException e ) {
                                // TODO Auto-generated catch block
                                e.printStackTrace( );
                            } catch ( JmiException e ) {
                                // TODO Auto-generated catch block
                                e.printStackTrace( );
                            }
                        }
                    }
                }
            }
        }
        try {
            env.setContext( me );
            env.enterNewVariableScope( );
            env.declareVariable( env.getJmiCreator( ).createVariableDeclaration( OclConstants.VAR_SELF, context, null ) );
            for ( VariableDeclaration variableDeclaration : additionalVars ) {
                env.declareVariable( variableDeclaration );
            }
        } catch ( OclSemanticException e ) {
            return false;
        }
        return true;
    }

    @SuppressWarnings( "nls" )
    private List<IOclProposal> addIteratorExpressions( OCLEnvironment env, ClassifierInternal type, int offset, int newOffset ) {

        List<IOclProposal> result = new ArrayList<IOclProposal>( 0 );

        List<String> params = new ArrayList<String>( 1 );
        params.add( OclConstants.EMPTY );
        List<String> delimiters = new ArrayList<String>( 0 );

        ClassifierInternal classifier = type;
        if ( classifier == null ) {
            return result;
        }

        if ( !( classifier instanceof CollectionType ) ) {
            classifier = (ClassifierInternal) env.getJmiCreator( ).createSetType( (Classifier) classifier );
        }
        if ( classifier instanceof CollectionType ) {
            CollectionTypeInternal cT = (CollectionTypeInternal) classifier;
            ClassifierInternal innerType = getInnerType( env.getJmiCreator( ).getConnection( ), cT );
            String proposal = classifier.getName( );
            String replacement = classifier.getName( );

            String iteratorBody = "( iterator | body )"; //$NON-NLS-1$

            //create exists
            replacement = "exists( )";
            proposal = "exists" + iteratorBody + PROPOSALTYPESEP + OclConstants.T_BOOLEAN + PROPSALPACKAGESEP + OclConstants.T_COLLECTION;
            result.add( new OCLProposalImpl( proposal, replacement, MoinAnnotationMessages.EXISTS, newOffset, offset - newOffset, IOclProposal.TYPE.OPERATION, params, delimiters ) );

            //create forAll
            replacement = "forAll( )";
            proposal = "forAll" + iteratorBody + PROPOSALTYPESEP + OclConstants.T_BOOLEAN + PROPSALPACKAGESEP + OclConstants.T_COLLECTION;
            result.add( new OCLProposalImpl( proposal, replacement, MoinAnnotationMessages.FORALL, newOffset, offset - newOffset, IOclProposal.TYPE.OPERATION, params, delimiters ) );

            //create isUnique
            replacement = "isUnique( )";
            proposal = "isUnique" + iteratorBody + PROPOSALTYPESEP + OclConstants.T_BOOLEAN + PROPSALPACKAGESEP + OclConstants.T_COLLECTION;
            result.add( new OCLProposalImpl( proposal, replacement, MoinAnnotationMessages.ISUNIQUE, newOffset, offset - newOffset, IOclProposal.TYPE.OPERATION, params, delimiters ) );

            //create any
            replacement = "any( )";
            proposal = "any" + iteratorBody + PROPOSALTYPESEP + innerType.getName( ) + PROPSALPACKAGESEP + OclConstants.T_COLLECTION;
            result.add( new OCLProposalImpl( proposal, replacement, MoinAnnotationMessages.ANY, newOffset, offset - newOffset, IOclProposal.TYPE.OPERATION, params, delimiters ) );

            //create one
            replacement = "one( )";
            proposal = "one" + iteratorBody + PROPOSALTYPESEP + OclConstants.T_BOOLEAN + PROPSALPACKAGESEP + OclConstants.T_COLLECTION;
            result.add( new OCLProposalImpl( proposal, replacement, MoinAnnotationMessages.ONE, newOffset, offset - newOffset, IOclProposal.TYPE.OPERATION, params, delimiters ) );

            //create iterate
            replacement = "iterate( )";
            proposal = "iterate" + "( iterator ; acc | body )" + PROPOSALTYPESEP + "acc.type" + PROPSALPACKAGESEP + OclConstants.T_COLLECTION;
            result.add( new OCLProposalImpl( proposal, replacement, MoinAnnotationMessages.ITERATE, newOffset, offset - newOffset, IOclProposal.TYPE.OPERATION, params, delimiters ) );

            if ( classifier instanceof SetType ) {

                //create collect
                replacement = "collect( )";
                proposal = "collect" + iteratorBody + PROPOSALTYPESEP + "Bag(body.type)" + PROPSALPACKAGESEP + OclConstants.T_COLLECTION;
                result.add( new OCLProposalImpl( proposal, replacement, MoinAnnotationMessages.COLLECT, newOffset, offset - newOffset, IOclProposal.TYPE.OPERATION, params, delimiters ) );

                //create select
                replacement = "select( )";
                proposal = "select" + iteratorBody + PROPOSALTYPESEP + cT.getName( ) + PROPSALPACKAGESEP + OclConstants.T_SET;
                result.add( new OCLProposalImpl( proposal, replacement, MoinAnnotationMessages.SELECT_SET, newOffset, offset - newOffset, IOclProposal.TYPE.OPERATION, params, delimiters ) );

                //create reject
                replacement = "reject( )";
                proposal = "reject" + iteratorBody + PROPOSALTYPESEP + cT.getName( ) + PROPSALPACKAGESEP + OclConstants.T_SET;
                result.add( new OCLProposalImpl( proposal, replacement, MoinAnnotationMessages.REJECT_SET, newOffset, offset - newOffset, IOclProposal.TYPE.OPERATION, params, delimiters ) );

                //create collectNested
                replacement = "collectNested( )";
                proposal = "collectNested" + iteratorBody + PROPOSALTYPESEP + "Bag(body.type)" + PROPSALPACKAGESEP + OclConstants.T_SET;
                result.add( new OCLProposalImpl( proposal, replacement, MoinAnnotationMessages.COLLECTNESTED_SET, newOffset, offset - newOffset, IOclProposal.TYPE.OPERATION, params, delimiters ) );

                //create sortedBy
                replacement = "sortedBy( )";
                String resultType = env.getJmiCreator( ).createOrderedSetType( (Classifier) innerType ).getName( );
                proposal = "sortedBy" + iteratorBody + PROPOSALTYPESEP + resultType + PROPSALPACKAGESEP + OclConstants.T_SET;
                result.add( new OCLProposalImpl( proposal, replacement, MoinAnnotationMessages.SORTEDBY_SET, newOffset, offset - newOffset, IOclProposal.TYPE.OPERATION, params, delimiters ) );

            } else if ( classifier instanceof BagType ) {

                //create collect
                replacement = "collect( )";
                proposal = "collect" + iteratorBody + PROPOSALTYPESEP + "Bag(body.type)" + PROPSALPACKAGESEP + OclConstants.T_COLLECTION;
                result.add( new OCLProposalImpl( proposal, replacement, MoinAnnotationMessages.COLLECT, newOffset, offset - newOffset, IOclProposal.TYPE.OPERATION, params, delimiters ) );

                //create select
                replacement = "select( )";
                proposal = "select" + iteratorBody + PROPOSALTYPESEP + cT.getName( ) + PROPSALPACKAGESEP + OclConstants.T_BAG;
                result.add( new OCLProposalImpl( proposal, replacement, MoinAnnotationMessages.SELECT_BAG, newOffset, offset - newOffset, IOclProposal.TYPE.OPERATION, params, delimiters ) );

                //create reject
                replacement = "reject( )";
                proposal = "reject" + iteratorBody + PROPOSALTYPESEP + cT.getName( ) + PROPSALPACKAGESEP + OclConstants.T_BAG;
                result.add( new OCLProposalImpl( proposal, replacement, MoinAnnotationMessages.REJECT_BAG, newOffset, offset - newOffset, IOclProposal.TYPE.OPERATION, params, delimiters ) );

                //create collectNested
                replacement = "collectNested( )";
                proposal = "collectNested" + iteratorBody + PROPOSALTYPESEP + "Bag(body.type)" + PROPSALPACKAGESEP + OclConstants.T_BAG;
                result.add( new OCLProposalImpl( proposal, replacement, MoinAnnotationMessages.COLLECTNESTED_BAG, newOffset, offset - newOffset, IOclProposal.TYPE.OPERATION, params, delimiters ) );

                //create sortedBy
                replacement = "sortedBy( )";
                String resultType = env.getJmiCreator( ).createSequenceType( (Classifier) innerType ).getName( );
                proposal = "sortedBy" + iteratorBody + PROPOSALTYPESEP + resultType + PROPSALPACKAGESEP + OclConstants.T_BAG;
                result.add( new OCLProposalImpl( proposal, replacement, MoinAnnotationMessages.SORTEDBY_BAG, newOffset, offset - newOffset, IOclProposal.TYPE.OPERATION, params, delimiters ) );

            } else if ( classifier instanceof SequenceType ) {

                //create collect
                replacement = "collect( )";
                proposal = "collect" + iteratorBody + PROPOSALTYPESEP + "Sequence(body.type)" + PROPSALPACKAGESEP + OclConstants.T_COLLECTION;
                result.add( new OCLProposalImpl( proposal, replacement, MoinAnnotationMessages.COLLECT, newOffset, offset - newOffset, IOclProposal.TYPE.OPERATION, params, delimiters ) );

                //create select
                replacement = "select( )";
                proposal = "select" + iteratorBody + PROPOSALTYPESEP + cT.getName( ) + PROPSALPACKAGESEP + OclConstants.T_SEQUENCE;
                result.add( new OCLProposalImpl( proposal, replacement, MoinAnnotationMessages.SELECT_SEQUENCE, newOffset, offset - newOffset, IOclProposal.TYPE.OPERATION, params, delimiters ) );

                //create reject
                replacement = "reject( )";
                proposal = "reject" + iteratorBody + PROPOSALTYPESEP + cT.getName( ) + PROPSALPACKAGESEP + OclConstants.T_SEQUENCE;
                result.add( new OCLProposalImpl( proposal, replacement, MoinAnnotationMessages.REJECT_SEQUENCE, newOffset, offset - newOffset, IOclProposal.TYPE.OPERATION, params, delimiters ) );

                //create collectNested
                replacement = "collectNested( )";
                proposal = "collectNested" + iteratorBody + PROPOSALTYPESEP + "Sequence(body.type)" + PROPSALPACKAGESEP + OclConstants.T_SEQUENCE;
                result.add( new OCLProposalImpl( proposal, replacement, MoinAnnotationMessages.COLLECTNESTED_SEQUENCE, newOffset, offset - newOffset, IOclProposal.TYPE.OPERATION, params, delimiters ) );

                //create sortedBy
                replacement = "sortedBy( )";
                proposal = "sortedBy" + iteratorBody + PROPOSALTYPESEP + cT.getName( ) + PROPSALPACKAGESEP + OclConstants.T_SEQUENCE;
                result.add( new OCLProposalImpl( proposal, replacement, MoinAnnotationMessages.SORTEDBY_SEQUENCE, newOffset, offset - newOffset, IOclProposal.TYPE.OPERATION, params, delimiters ) );

            } else if ( classifier instanceof OrderedSetType ) {

                //create collect
                replacement = "collect( )";
                proposal = "collect" + iteratorBody + PROPOSALTYPESEP + "Bag(body.type)" + PROPSALPACKAGESEP + OclConstants.T_COLLECTION;
                result.add( new OCLProposalImpl( proposal, replacement, MoinAnnotationMessages.COLLECT, newOffset, offset - newOffset, IOclProposal.TYPE.OPERATION, params, delimiters ) );

                //create select
                replacement = "select( )";
                proposal = "select" + iteratorBody + PROPOSALTYPESEP + cT.getName( ) + PROPSALPACKAGESEP + OclConstants.T_ORDEREDSET;
                result.add( new OCLProposalImpl( proposal, replacement, MoinAnnotationMessages.SELECT_ORDEREDSET, newOffset, offset - newOffset, IOclProposal.TYPE.OPERATION, params, delimiters ) );

                //create reject
                replacement = "reject( )";
                proposal = "reject" + iteratorBody + PROPOSALTYPESEP + cT.getName( ) + PROPSALPACKAGESEP + OclConstants.T_ORDEREDSET;
                result.add( new OCLProposalImpl( proposal, replacement, MoinAnnotationMessages.REJECT_BAG, newOffset, offset - newOffset, IOclProposal.TYPE.OPERATION, params, delimiters ) );

                //create collectNested
                replacement = "collectNested( )";
                proposal = "collectNested" + iteratorBody + PROPOSALTYPESEP + "Bag(body.type)" + PROPSALPACKAGESEP + OclConstants.T_ORDEREDSET;
                result.add( new OCLProposalImpl( proposal, replacement, MoinAnnotationMessages.COLLECTNESTED_BAG, newOffset, offset - newOffset, IOclProposal.TYPE.OPERATION, params, delimiters ) );

                //create sortedBy
                replacement = "sortedBy( )";
                proposal = "sortedBy" + iteratorBody + PROPOSALTYPESEP + cT.getName( ) + PROPSALPACKAGESEP + OclConstants.T_ORDEREDSET;
                result.add( new OCLProposalImpl( proposal, replacement, MoinAnnotationMessages.SORTEDBY_BAG, newOffset, offset - newOffset, IOclProposal.TYPE.OPERATION, params, delimiters ) );

            }

        }
        return result;
    }

    private ClassifierInternal getInnerType( CoreConnection connection, CollectionTypeInternal collectionType ) {

        ClassifierInternal type = collectionType;
        while ( type instanceof CollectionTypeInternal ) {
            CollectionTypeInternal cT = (CollectionTypeInternal) type;
            type = (ClassifierInternal) cT.getElementType( connection );
        }
        return type;
    }

    private boolean isSimpleSymbol( IToken token ) {

        switch ( token.getKind( ) ) {
            case OclParserGensym.TK_ARROW:
            case OclParserGensym.TK_DOT:
            case OclParserGensym.TK_LPAREN:
            case OclParserGensym.TK_LBRACKET:
            case OclParserGensym.TK_LBRACE:
            case OclParserGensym.TK_RPAREN:
            case OclParserGensym.TK_RBRACKET:
            case OclParserGensym.TK_RBRACE:
            case OclParserGensym.TK_COLON:
            case OclParserGensym.TK_COMMA:
            case OclParserGensym.TK_SEMICOLON:
            case OclParserGensym.TK_BAR:
            case OclParserGensym.TK_EQUAL:
            case OclParserGensym.TK_NOT_EQUAL:
            case OclParserGensym.TK_GREATER:
            case OclParserGensym.TK_GREATER_EQUAL:
            case OclParserGensym.TK_LESS:
            case OclParserGensym.TK_LESS_EQUAL:
            case OclParserGensym.TK_PLUS:
            case OclParserGensym.TK_MINUS:
            case OclParserGensym.TK_MULTIPLY:
            case OclParserGensym.TK_DIVIDE:
            case OclParserGensym.TK_INTEGER_RANGE_START:
            case OclParserGensym.TK_DOTDOT:
            case OclParserGensym.TK_EXCLAMATION:
            case OclParserGensym.TK_SHARP:
            case OclParserGensym.TK_ATPRE:
                return true;
            default:
                return false;
        }
    }

    private boolean isCollectionLiteralSymbol( IToken token ) {

        switch ( token.getKind( ) ) {
            case OclParserGensym.TK_Set:
            case OclParserGensym.TK_Sequence:
            case OclParserGensym.TK_Bag:
            case OclParserGensym.TK_OrderedSet:

                return true;
            default:
                return false;
        }
    }

    public String format( String constraint ) {

        if ( this.formatter == null ) {
            this.formatter = new Formatter( );
        }
        return this.formatter.format( constraint );
    }

    public String getInformationAtOffset( CoreConnection connection, Set<CoreModelPartition> partitions, OclConstraint oclConstraintImpl, String constraint, int offset, Locale locale ) {

        if ( acceptTransformationatOffset( connection, partitions, (OclConstraintInternal) oclConstraintImpl, constraint, offset ) ) {
            return ( (AnnotationMRIVisitor) this.transformation ).getAnnotation( offset, locale );
        }
        return null;

    }

    public RegionWrappedMRI getMRIAtOffset( CoreConnection connection, Set<CoreModelPartition> partitions, OclConstraint oclConstraintImpl, String constraint, int offset ) {


        if ( acceptTransformationatOffset( connection, partitions, (OclConstraintInternal) oclConstraintImpl, constraint, offset ) ) {
            return ( (AnnotationMRIVisitor) this.transformation ).getRegionWrappedMRI( offset );
        }

        return null;
    }

    private boolean acceptTransformationatOffset( CoreConnection connection, Set<CoreModelPartition> partitions, OclConstraintInternal oclConstraintImpl, String constraint, int offset ) {

        try {
            this.backgroundPartition = connection.getOrCreateTransientPartition( BACKGROUNPARTITIONKEY );

            JmiCreator jmiCreator;
            try {
                jmiCreator = new JmiCreator( connection, true, this.backgroundPartition );
            } catch ( OclManagerException e ) {
                return false;
            }

            ProcessReportImpl report = new ProcessReportImpl( 1 );

            // create the lexer
            OclLexerGen oclLexer = new OclLexerGen( constraint.toCharArray( ), "OCL", report, 4 ); //$NON-NLS-1$

            // create the parser
            OclParserGen oclParser = new OclParserGen( oclLexer, report );

            oclLexer.lexer( oclParser );

            IToken token = oclParser.getTokenAtCharacter( offset );
            if ( token == null ) {
                return false;
            }
            refreshModelElements( connection, partitions );

            /*
             * This implementation only looks for the MofPackage the constraint
             * is in.
             */
            // MofPackage mofPck = getMofPackage( oclConstraintImpl, connection);
            /*
             * This implementation looks in which package declaration the
             * Proposal is wanted. If there is no package declaration the
             * MOFPackage the constraints is in, will be used
             */
            MofPackageImpl mofPck = getMofPackage( constraint, offset );
            if ( mofPck == null ) {
                mofPck = getMofPackage( oclConstraintImpl, connection );
            }

            ServiceOCLEnvironment env = new ServiceOCLEnvironment( report, jmiCreator, null, mofPck, new HashSet<RefPackage>( 0 ), this.modelElementsByName, this.modelElementsByOclQualifiedName );

            setContext( env, constraint, offset );

            int[] balance = { 0 };
            if ( token.getTokenIndex( ) > 1 ) {
                ListIterator<IToken> tokens = oclParser.getTokens( ).listIterator( token.getTokenIndex( ) + 1 );

                if ( tokens.hasNext( ) && updateBalance( balance, tokens.next( ) ) < 0 ) {
                    tokens.previous( );
                    balance[0] = 0;
                    do {
                        token = tokens.next( );
                    } while ( tokens.hasNext( ) && updateBalance( balance, token ) < 0 );

                }

                int newOffset = token.getEndOffset( ) + 1;

                this.transformation = new AnnotationMRIVisitor( this, env );

                getOCLExpressionType( env, newOffset, constraint );
                return true;
            }
            return false;
        } finally {
            this.backgroundPartition.deleteElements( connection );
        }
    }
}

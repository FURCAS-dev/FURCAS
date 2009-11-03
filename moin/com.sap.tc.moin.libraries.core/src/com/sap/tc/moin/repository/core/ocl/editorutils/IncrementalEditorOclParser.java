package com.sap.tc.moin.repository.core.ocl.editorutils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.Feature;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.NameNotFoundException;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.__impl.MofPackageImpl;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import lpg.lpgjavaruntime.IToken;

import com.sap.tc.moin.ocl.parser.gen.OclLexerGen;
import com.sap.tc.moin.ocl.parser.gen.OclParserGen;
import com.sap.tc.moin.ocl.parser.gen.OclParserGensym;
import com.sap.tc.moin.ocl.parser.gen.oclAst.Node;
import com.sap.tc.moin.ocl.parser.impl.StringHelper;
import com.sap.tc.moin.ocl.parser.impl.env.OCLEnvironment;
import com.sap.tc.moin.ocl.parser.impl.env.OCLLookupTables;
import com.sap.tc.moin.ocl.parser.impl.env.OCLTypeChecker;
import com.sap.tc.moin.ocl.parser.impl.errors.FatalParsingException;
import com.sap.tc.moin.ocl.parser.impl.localization.OclParserMessages;
import com.sap.tc.moin.ocl.utils.jmi.MoinJmiCreator;
import com.sap.tc.moin.ocl.utils.jmi.OclSemanticException;
import com.sap.tc.moin.repository.ProcessError;
import com.sap.tc.moin.repository.ProcessReport;
import com.sap.tc.moin.repository.ProcessWarning;
import com.sap.tc.moin.repository.exception.MoinBaseRuntimeException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.shared.util.ProcessErrorImpl;
import com.sap.tc.moin.repository.shared.util.ProcessReportImpl;
import com.sap.tc.moin.repository.shared.util.ProcessWarningImpl;

/**
 * The Incremental OCL Parser
 */
public class IncrementalEditorOclParser {

    // trace setup
    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_CORE_OCL, EditorOclParser.class );

    /**
     * This sets the failure tolerance of the parser
     */
    private static final int ERROR_COUNT = 100;

    /**
     * The Eclipse TAB size is 4
     */
    private final static int ECLIPSE_TAB_VALUE = 4;

    /**
     * We need a JMI Creator
     */
    private MoinJmiCreator jmiCreator;

    /**
     * And a process report
     */
    private ProcessReport report;

    private static final int PACKAGEPRIO = 1;

    private static final int CONTEXTPRIO = 2;

    private static final int EXPRESSIONPRIO = 3;

    private int offset;

    private int length;

    private String oldText;

    private int prio;

    private Integer afterContextEnd;

    /**
     * Constructs a new OclParser instance
     * 
     * @param actCreator needed to create the syntax tree
     */
    public IncrementalEditorOclParser( MoinJmiCreator actCreator ) {

        this.jmiCreator = actCreator;
    }

    /**
     * @param actCreator needed to create the syntax tree
     */
    public void setJmiCreator( MoinJmiCreator actCreator ) {

        this.jmiCreator = actCreator;
    }

    private ProcessReport parseInternal( String inString, RefObject context, MofPackage contextPackage, RefPackage[] types, Map<String, List<ModelElement>> modelElementsByName, Map<String, ModelElement> modelElementsByOclQualifiedName, Map<Classifier, Set<Feature>> oclDefinedFeatures ) {

        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, OclParserMessages.STARTPARSEEXPR, inString );
        }

        long timeStamp = System.currentTimeMillis( );

        // create the lexer
        OclLexerGen oclLexer = new OclLexerGen( inString.toCharArray( ), "OCL", this.report, ECLIPSE_TAB_VALUE ); //$NON-NLS-1$

        // create the parser
        OclParserGen oclParser = new OclParserGen( oclLexer, this.report );

        // do the actual parsing
        Node ast;
//        OclAstBuilder transformation;        
        try {
//            EditorParsingVisitor transformation;
            // lex the input stream
            oclLexer.lexer( oclParser );

            // parse the token stream and create the ast.
            ast = oclParser.parser( ERROR_COUNT );

            // we cannot start the semantic analysis if we still have parse errors
            if ( this.report.getProcessStatus( ) == ProcessReport.FAILED || this.report.getProcessStatus( ) == ProcessReport.FATAL ) {
                syntacticErrorAnalysis2( oclParser, context, contextPackage, types, modelElementsByName, modelElementsByOclQualifiedName, oclDefinedFeatures );
//                throw new ParsingException( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0900 ), this.report );
                return this.report;
            }

            if ( ast == null ) {
                this.report.reportError( new ProcessErrorImpl( new OclSemanticException( OclParserMessages.NOINPUT ) ) );
                return this.report;
            }
            analyzeAst( ast, context, contextPackage, types, modelElementsByName, modelElementsByOclQualifiedName, oclDefinedFeatures );

        } catch ( FatalParsingException e ) {
            return this.report;
        } catch ( MoinBaseRuntimeException e ) {
            return this.report;
        }

        long parseTime = System.currentTimeMillis( ) - timeStamp;

        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, OclParserMessages.PARSEDURATION, Long.valueOf( parseTime ) );
        }

        return this.report;
    }

    /**
     * @return the offset
     */
    public int getOffset( ) {

        return this.offset;
    }

    /**
     * @return the length
     */
    public int getLength( ) {

        return this.length;
    }

    /**
     * @return the report
     */
    public ProcessReport getReport( ) {

        return this.report;
    }

    /**
     * @param oclExpression expression
     * @param contextPackage package
     * @param modelElementsByName index
     * @param modelElementsByOclQualifiedName qualified index
     * @param oclDefinedFeatures features
     * @param actOffset offset
     * @param actLength length
     * @param isRemove to be removed
     * @return the report
     */
    public ProcessReport parseString( String oclExpression, MofPackageImpl contextPackage, Map<String, List<ModelElement>> modelElementsByName, Map<String, ModelElement> modelElementsByOclQualifiedName, Map<Classifier, Set<Feature>> oclDefinedFeatures, int actOffset, int actLength, boolean isRemove ) {

        return this.parseIncremental( oclExpression, null, contextPackage, null, modelElementsByName, modelElementsByOclQualifiedName, oclDefinedFeatures, actOffset, actLength, isRemove );
    }


    private ProcessReport parseIncremental( String constraint, RefObject context, MofPackage contextPackage, RefPackage[] types, Map<String, List<ModelElement>> modelElementsByName, Map<String, ModelElement> modelElementsByOclQualifiedName, Map<Classifier, Set<Feature>> oclDefinedFeatures,
        int actOffset, int actLength, boolean isRemove ) {

        this.report = new AllConsumingProcessReport( ERROR_COUNT );
        this.offset = actOffset;
        this.length = actLength;

        String toInvestigate;
        if ( isRemove ) {
            if ( this.oldText == null ) {
                throw new IllegalStateException( "Constraint has not been parsed before" ); //$NON-NLS-1$
            }
            toInvestigate = this.oldText;
        } else
            toInvestigate = constraint;

        int inputEnd = actOffset + actLength;
        String change;
        if ( inputEnd > constraint.length( ) ) {
            change = toInvestigate.substring( actOffset );
            inputEnd = constraint.length( ) - 1;
        } else
            change = toInvestigate.substring( actOffset, inputEnd );

        if ( change.matches( "(\\s|\\r|\\n)+" ) || change.length( ) == 0 ) { //$NON-NLS-1$
            if ( actOffset == 0 || inputEnd == toInvestigate.length( ) || Character.isWhitespace( toInvestigate.charAt( actOffset - 1 ) ) || Character.isWhitespace( toInvestigate.charAt( inputEnd ) ) ) {
                this.oldText = constraint;
                return this.report;
            }

        }
        if ( actOffset == 0 && actLength == constraint.length( ) ) {
            parseInternal( constraint, context, contextPackage, types, modelElementsByName, modelElementsByOclQualifiedName, oclDefinedFeatures );
            this.oldText = constraint;
            return this.report;
        }

        int startOffset = getWordStart( toInvestigate, actOffset );
        int endOffset = getWordEnd( toInvestigate, inputEnd );
        OclLexerGen lexer = new OclLexerGen( toInvestigate.toCharArray( ), "OCL", new ProcessReportImpl( ), 4 ); //$NON-NLS-1$
        OclParserGen parser = new OclParserGen( lexer );
        lexer.lexer( parser );
        int start = Math.abs( parser.getTokenIndexAtCharacter( startOffset + 1 ) );
        int end = Math.abs( parser.getTokenIndexAtCharacter( endOffset ) );

        //Are there any important tokens in the new or deleted Text??
        boolean isStartToken = false;
        this.prio = Integer.MAX_VALUE;
        List<IToken> tokens = new ArrayList<IToken>( );
        if ( this.length > 0 ) {
            for ( int i = start; i <= end && this.prio > 1; i++ ) {
                IToken token = parser.getIToken( i );
                int kind = token.getKind( );
                int newPrio;
                switch ( kind ) {
                    case OclParserGensym.TK_package:
                    case OclParserGensym.TK_endpackage:
                        newPrio = PACKAGEPRIO;
                        break;

                    case OclParserGensym.TK_context:
                        newPrio = CONTEXTPRIO;
//                        newPrio = PACKAGEPRIO;
                        break;

                    case OclParserGensym.TK_init:
                    case OclParserGensym.TK_derive:
                    case OclParserGensym.TK_inv:
                    case OclParserGensym.TK_def:
                    case OclParserGensym.TK_exp:
                    case OclParserGensym.TK_pre:
                    case OclParserGensym.TK_post:
                    case OclParserGensym.TK_body:
                        newPrio = CONTEXTPRIO;
                        break;

                    default:
                        newPrio = Integer.MAX_VALUE;
                }
                if ( this.prio > newPrio ) {
                    tokens.clear( );
                    this.prio = newPrio;
                }
                if ( this.prio == newPrio && this.prio < Integer.MAX_VALUE ) {
                    tokens.add( token );
                }

            }
        }
        if ( isRemove ) {
            tokens.clear( );
            isStartToken = false;
            lexer = new OclLexerGen( constraint.toCharArray( ), "OCL", new ProcessReportImpl( ), 4 ); //$NON-NLS-1$
            parser = new OclParserGen( lexer );
            lexer.lexer( parser );
            startOffset = getWordStart( toInvestigate, actOffset );
            endOffset = getWordEnd( toInvestigate, actOffset + actLength );
            start = Math.abs( parser.getTokenIndexAtCharacter( startOffset + 1 ) );
            end = Math.abs( parser.getTokenIndexAtCharacter( endOffset ) );
        }

        IToken startToken = null;

        //find the previous token with minimum this prio and set the new startOffset
        for ( int i = start - 1; i > 0; i-- ) {
            int kind = parser.getIToken( i ).getKind( );
            int newPrio;
            switch ( kind ) {
                case OclParserGensym.TK_package:
                    newPrio = PACKAGEPRIO;
                    break;

                case OclParserGensym.TK_context:
                    newPrio = CONTEXTPRIO;
                    break;

                case OclParserGensym.TK_init:
                case OclParserGensym.TK_derive:
                case OclParserGensym.TK_inv:
                case OclParserGensym.TK_def:
                case OclParserGensym.TK_exp:
                case OclParserGensym.TK_pre:
                case OclParserGensym.TK_post:
                case OclParserGensym.TK_body:
                    newPrio = EXPRESSIONPRIO;
                    break;

                default:
                    newPrio = Integer.MAX_VALUE;
            }
            if ( newPrio <= this.prio && newPrio != Integer.MAX_VALUE ) {
                this.prio = newPrio;
                startToken = parser.getIToken( i );
                break;
            }
        }

        endOffset = constraint.length( );
        if ( startToken != null ) {
            startOffset = startToken.getStartOffset( );
            start = startToken.getTokenIndex( );
            //find the next token with minimum this prio and set the new endOffset

            int numberOfTokens = parser.getTokens( ).size( );

            for ( int i = end + 1; i < numberOfTokens; i++ ) {
                int kind = parser.getIToken( i ).getKind( );
                int newPrio = this.prio;
                switch ( kind ) {
                    case OclParserGensym.TK_package:
                        newPrio = PACKAGEPRIO;
                        break;
                    case OclParserGensym.TK_endpackage:
                        if ( this.prio > PACKAGEPRIO ) {
                            newPrio = PACKAGEPRIO;
                        }
                        break;

                    case OclParserGensym.TK_context:
                        newPrio = CONTEXTPRIO;
                        break;

                    case OclParserGensym.TK_init:
                    case OclParserGensym.TK_derive:
                    case OclParserGensym.TK_inv:
                    case OclParserGensym.TK_def:
                    case OclParserGensym.TK_exp:
                    case OclParserGensym.TK_pre:
                    case OclParserGensym.TK_post:
                    case OclParserGensym.TK_body:
                        newPrio = EXPRESSIONPRIO;
                        break;

                    default:
                        newPrio = Integer.MAX_VALUE;
                }
                if ( newPrio <= this.prio ) {
                    endOffset = parser.getIToken( i ).getStartOffset( );
                    break;
                }
            }
        } else
            startOffset = 0;
        this.offset = startOffset;
        this.length = endOffset - startOffset;
        MofPackage mofPck = null;
        RefObject realContext = null;
        if ( this.prio >= CONTEXTPRIO ) {
            try {
                mofPck = getMofPackage( parser, start - 1, modelElementsByName, modelElementsByOclQualifiedName );
            } catch ( OclSemanticException e ) {
                this.oldText = constraint;
                return parseInternal( constraint, null, contextPackage, types, modelElementsByName, modelElementsByOclQualifiedName, oclDefinedFeatures );
            }
            if ( mofPck == null )
                mofPck = contextPackage;
        }
        if ( this.prio == EXPRESSIONPRIO ) {
            try {
                realContext = getContext( parser, start - 1, mofPck, types, modelElementsByName, modelElementsByOclQualifiedName );
            } catch ( OclSemanticException e ) {
                this.oldText = constraint;
                return parseInternal( constraint, null, mofPck, types, modelElementsByName, modelElementsByOclQualifiedName, oclDefinedFeatures );
            }
            if ( realContext == null ) {
                if ( context != null ) {
                    realContext = context;
                } else {
                    this.oldText = constraint;
                    return parseInternal( constraint, null, mofPck, types, modelElementsByName, modelElementsByOclQualifiedName, oclDefinedFeatures );
                }
            }
            if ( !isStartToken && startToken != null )
                tokens.add( 0, startToken );
            if ( tokens.size( ) > 1 ) {
                ProcessReport result = new AllConsumingProcessReport( ERROR_COUNT );
                for ( int i = 0; i < tokens.size( ); i++ ) {
                    int partStart = tokens.get( i ).getStartOffset( );
                    int partEnd;
                    if ( i < tokens.size( ) - 1 )
                        partEnd = tokens.get( i + 1 ).getStartOffset( );
                    else
                        partEnd = endOffset;

                    parseInternal( constraint.substring( partStart, partEnd ), realContext, mofPck, types, modelElementsByName, modelElementsByOclQualifiedName, oclDefinedFeatures );
                    if ( this.report instanceof AllConsumingProcessReport ) {
                        ( (AllConsumingProcessReport) this.report ).shiftMessagesByOffset( partStart );
                    }
                    if ( !this.report.getErrors( ).isEmpty( ) ) {
                        result.failProcess( );
                        result.getErrors( ).addAll( this.report.getErrors( ) );
                    }
                    if ( !this.report.getWarnings( ).isEmpty( ) ) {
                        result.getWarnings( ).addAll( this.report.getWarnings( ) );
                    }
                    this.report = new AllConsumingProcessReport( ERROR_COUNT );
                }
                this.oldText = constraint;
                this.report = result;
                return result;
            }
        }
        ProcessReport result = parseInternal( constraint.substring( startOffset, endOffset ), realContext, mofPck, types, modelElementsByName, modelElementsByOclQualifiedName, oclDefinedFeatures );
        if ( result instanceof AllConsumingProcessReport ) {
            ( (AllConsumingProcessReport) result ).shiftMessagesByOffset( startOffset );
        }
        this.oldText = constraint;
        this.report = result;
        return this.report;

    }

    private int getWordStart( String string, int startOffset ) {

        int index = startOffset - 1;
        while ( index > 0 ) {
            if ( Character.isWhitespace( string.charAt( index ) ) )
                break;
            index--;
        }
        index++;
        if ( index == startOffset ) {
            while ( index < string.length( ) ) {
                if ( !Character.isWhitespace( string.charAt( index ) ) )
                    break;
                index++;
            }
        }
        return index;
    }

    private int getWordEnd( String string, int startOffset ) {

        int index = startOffset;
        while ( index < string.length( ) ) {
            if ( Character.isWhitespace( string.charAt( index ) ) )
                break;
            index++;
        }
        if ( index == startOffset ) {
            index--;
            while ( index > 0 ) {
                if ( !Character.isWhitespace( string.charAt( index ) ) )
                    break;
                index--;
            }
            index++;
        }
        return index;
    }

    /**
     * If <code>constraint</code> contains one package declaration, the declared
     * package is returned, otherwise <code>null</code>.
     * 
     * @param parser parser
     * @param startIndex start index
     * @param modelElementsByName index
     * @param modelElementsByOclQualifiedName qualified index
     * @return the package
     * @throws OclSemanticException internal
     */
    public MofPackage getMofPackage( OclParserGen parser, int startIndex, Map<String, List<ModelElement>> modelElementsByName, Map<String, ModelElement> modelElementsByOclQualifiedName ) throws OclSemanticException {

        IToken packageToken = findLastTokenWithMinPriority( parser, startIndex, PACKAGEPRIO );
        if ( packageToken == null ) {
            return null;
        }
        List<String> pathName = new ArrayList<String>( );
        int currentIndex = parser.getTokens( ).indexOf( packageToken ) + 1;//packageToken.getTokenIndex( ) + 1;
        boolean pathCC = true;
        while ( true ) {
            IToken path = parser.getIToken( currentIndex );

            if ( pathCC ) {
                if ( path.getKind( ) == OclParserGensym.TK_IDENTIFIER ) {
                    pathName.add( path.toString( ) );
                    pathCC = false;
                } else
                    break;

            } else {
                if ( path.getKind( ) == OclParserGensym.TK_COLONCOLON )
                    pathCC = true;
                else
                    break;
            }
            currentIndex++;
        }
        String packageName = StringHelper.toPathName( pathName );
        ModelElement me = modelElementsByOclQualifiedName.get( packageName );
        if ( me instanceof MofPackage ) {
            return (MofPackage) me;
        }
        throw new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0507, new Object[] { packageName } );
    }

    /**
     * If <code>constraint</code> contains one package declaration, the declared
     * package is returned, otherwise <code>null</code>.
     * 
     * @param parser parser
     * @param startIndex start index
     * @param mofPck package
     * @param types types
     * @param modelElementsByName index
     * @param modelElementsByOclQualifiedName qualified index
     * @return the context
     * @throws OclSemanticException internal
     */
    public RefObject getContext( OclParserGen parser, int startIndex, MofPackage mofPck, RefPackage[] types, Map<String, List<ModelElement>> modelElementsByName, Map<String, ModelElement> modelElementsByOclQualifiedName ) throws OclSemanticException {

        this.afterContextEnd = null;
        IToken contextToken = findLastTokenWithMinPriority( parser, startIndex, CONTEXTPRIO );
        if ( contextToken == null ) {
            return null;
        }
        List<String> pathName = new ArrayList<String>( );
        int currentIndex = parser.getTokens( ).indexOf( contextToken ) + 1;//contextToken.getTokenIndex( ) + 1;
        boolean pathDot = true;
        while ( true ) {
            IToken path = parser.getIToken( currentIndex );

            if ( pathDot ) {
                if ( path.getKind( ) == OclParserGensym.TK_IDENTIFIER ) {
                    pathName.add( path.toString( ) );
                    pathDot = false;
                } else
                    break;

            } else {
                if ( path.getKind( ) == OclParserGensym.TK_COLONCOLON )
                    pathDot = true;
                else
                    break;
            }
            currentIndex++;
        }
        Set<RefPackage> typePackages = new HashSet<RefPackage>( );
        if ( types != null ) {
            for ( int i = 0; i < types.length; i++ ) {
                if ( types[i] != null ) {
                    RefPackage actRefPackage = types[i];
                    typePackages.add( actRefPackage );
                }
            }
        }
        OCLEnvironment env = new OCLEnvironment( new ProcessReportImpl( ), this.jmiCreator, null, mofPck, typePackages, modelElementsByName, modelElementsByOclQualifiedName );
        Classifier context = env.lookupClassifierByPathName( pathName );
        ModelElement me = context;

        if ( context == null ) {
            context = env.lookupClassifierByPathName( pathName.subList( 0, pathName.size( ) - 1 ) );
            if ( context != null ) {
                try {
                    me = context.lookupElement( pathName.get( pathName.size( ) - 1 ) );
                } catch ( JmiException e ) {
                    // $JL-EXC$
                } catch ( NameNotFoundException e ) {
                    // $JL-EXC$
                }
            }
        }

        if ( me != null ) {
            this.afterContextEnd = Integer.valueOf( currentIndex );
            return me;
        }
        throw new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0501, new Object[] { StringHelper.toPathName( pathName ) } );
//        return null;
    }

    private IToken findLastTokenWithMinPriority( OclParserGen parser, int startIndex, int minPrio ) {

        //find the previous token with minimum this prio and set the new startOffset
        for ( int i = startIndex; i > 0; i-- ) {
            IToken token = parser.getIToken( i );
            int kind = token.getKind( );
            int newPrio;
            switch ( kind ) {
                case OclParserGensym.TK_package:
                    newPrio = PACKAGEPRIO;
                    break;

                case OclParserGensym.TK_context:
                    newPrio = CONTEXTPRIO;
                    break;

                case OclParserGensym.TK_init:
                case OclParserGensym.TK_derive:
                case OclParserGensym.TK_inv:
                case OclParserGensym.TK_def:
                case OclParserGensym.TK_exp:
                case OclParserGensym.TK_pre:
                case OclParserGensym.TK_post:
                case OclParserGensym.TK_body:
                    newPrio = EXPRESSIONPRIO;
                    break;

                default:
                    newPrio = Integer.MAX_VALUE;
            }
            if ( newPrio <= minPrio ) {
                return token;
            }
        }
        return null;
    }

    private void syntacticErrorAnalysis2( OclParserGen parser, RefObject context, MofPackage contextPackage, RefPackage[] types, Map<String, List<ModelElement>> modelElementsByName, Map<String, ModelElement> modelElementsByOclQualifiedName, Map<Classifier, Set<Feature>> oclDefinedFeatures ) {

        if ( this.prio != EXPRESSIONPRIO ) {
//            List<IToken> packages = new ArrayList<IToken>( );
//            List<IToken> contexts = new ArrayList<IToken>( );
//            List<IToken> expressions = new ArrayList<IToken>( );
            List<IToken> keyTokens = new ArrayList<IToken>( );

            for ( int i = 0; i < parser.getTokens( ).size( ); i++ ) {

                IToken token = parser.getIToken( i );
                int kind = token.getKind( );
                switch ( kind ) {
                    case OclParserGensym.TK_package:
                    case OclParserGensym.TK_endpackage:
                    case OclParserGensym.TK_context:
                    case OclParserGensym.TK_init:
                    case OclParserGensym.TK_derive:
                    case OclParserGensym.TK_inv:
                    case OclParserGensym.TK_def:
                    case OclParserGensym.TK_exp:
                    case OclParserGensym.TK_pre:
                    case OclParserGensym.TK_post:
                    case OclParserGensym.TK_body:
                    case OclParserGensym.TK_EOF_TOKEN:
                        keyTokens.add( token );
//                        expressions.add( token );
                        break;

                    default:
                        break;
                }
            }
            List<ProcessError> errors = new ArrayList<ProcessError>( this.report.getErrors( ) );
            Collections.sort( errors, new MessageComparator( ) );

            //List<List<IToken>> expr = new ArrayList<List<IToken>>( errors.size( ) );


            MofPackage curPackage = contextPackage;
            RefObject curContext = context;
            for ( int i = 0; i < keyTokens.size( ); i++ ) {
                IToken token = keyTokens.get( i );

                switch ( token.getKind( ) ) {

                    case OclParserGensym.TK_package:

                        //get the MofPackage of this packageDeclaration
                        try {
                            curPackage = getMofPackage( parser, token.getTokenIndex( ), modelElementsByName, modelElementsByOclQualifiedName );
                        } catch ( OclSemanticException e ) {
                            // The MofPackage could not be retrieved. A deeper analysis is useless. So the packageDeclaration is deleted and a ProcessError is added, which states, that the package is not known.

                            IToken packageStartToken = token;

                            IToken packageEndToken = null;

                            do {
                                i++;
                                if ( i < keyTokens.size( ) ) {
                                    token = keyTokens.get( i );
                                } else {
                                    packageEndToken = parser.getIToken( parser.getTokens( ).size( ) - 1 );
                                    break;
                                }
                            } while ( token.getKind( ) != OclParserGensym.TK_package && token.getKind( ) != OclParserGensym.TK_endpackage && token.getKind( ) != OclParserGensym.TK_EOF_TOKEN );

                            if ( packageEndToken == null ) {
                                packageEndToken = parser.getIToken( parser.getTokens( ).indexOf( token ) - 1 );
                            }
                            if ( token.getKind( ) != OclParserGensym.TK_endpackage ) {
                                i--;
                            }
                            this.report.reportFatalError( new ProcessErrorImpl( e, packageStartToken.getLine( ), packageStartToken.getColumn( ), packageEndToken.getEndLine( ), packageEndToken.getEndColumn( ), packageStartToken.getStartOffset( ), packageEndToken.getEndOffset( ) ) );

                            break;
                        }

                        break;

                    case OclParserGensym.TK_context:
                        //get the RefObject of this packageDeclaration
                        try {
                            curContext = getContext( parser, parser.getTokens( ).indexOf( token ), curPackage, types, modelElementsByName, modelElementsByOclQualifiedName );
                        } catch ( OclSemanticException e ) {
                            // The RefObject could not be retrieved. A deeper analysis is useless. So the contextDeclaration is deleted and a ProcessError is added, which states, that the context is not known.
//                              
                            IToken contextStartToken = token;//                              
                            IToken contextEndToken = null;//                              
                            do {
                                i++;
                                if ( i < keyTokens.size( ) ) {
                                    token = keyTokens.get( i );
                                } else {
                                    contextEndToken = parser.getIToken( parser.getTokens( ).size( ) - 1 );
                                    break;
                                }
                            } while ( token.getKind( ) != OclParserGensym.TK_context && token.getKind( ) != OclParserGensym.TK_package && token.getKind( ) != OclParserGensym.TK_endpackage && token.getKind( ) != OclParserGensym.TK_EOF_TOKEN );
//                               
                            i--;
                            if ( contextEndToken == null ) {
                                contextEndToken = parser.getIToken( parser.getTokens( ).indexOf( token ) - 1 );
                            }
                            this.report.reportFatalError( new ProcessErrorImpl( e, contextStartToken.getLine( ), contextStartToken.getColumn( ), contextEndToken.getEndLine( ), contextEndToken.getEndColumn( ), contextStartToken.getStartOffset( ), contextEndToken.getEndOffset( ) ) );
//                                for ( int k = parser.getTokens( ).indexOf( contextStartToken ); k <= parser.getTokens( ).indexOf( contextEndToken ); ) {
//                                    parser.getTokens( ).remove( k );
//                                }
//                            while ( errorPos < errors.size( ) && token.getStartOffset( ) >= errors.get( errorPos ).getStartPosition( ) ) {
//                                errorPos++;
//                            }
                            break;
//                              }
                        }

                        break;

                    case OclParserGensym.TK_init:
                    case OclParserGensym.TK_derive:
                    case OclParserGensym.TK_inv:
                    case OclParserGensym.TK_def:
                    case OclParserGensym.TK_exp:
                    case OclParserGensym.TK_pre:
                    case OclParserGensym.TK_post:
                    case OclParserGensym.TK_body:

                        IToken exprEndToken = null;//                              

                        i++;
                        if ( i < keyTokens.size( ) ) {
                            exprEndToken = keyTokens.get( i );
                        }
                        i--;
                        if ( exprEndToken == null ) {
                            return;
                        }
//                       
                        int start = parser.getTokens( ).indexOf( token );//prev.getTokenIndex( ); 
                        int end = parser.getTokens( ).indexOf( exprEndToken );//token.getTokenIndex( );
                        List<IToken> curExpr = new ArrayList<IToken>( end - start );
                        for ( int j = start; j < end; j++ ) {
//                            curExpr.add( (IToken) parser.getTokens( ).get( j ) );
                            curExpr.add( parser.getIToken( j ) );
                        }

                        List<IToken> oldParserTokens = (List<IToken>) parser.getTokens( ).clone( );
                        parser.getTokens( ).clear( );
                        parser.getTokens( ).add( oldParserTokens.get( 0 ) );
                        parser.getTokens( ).addAll( curExpr );
                        parser.getTokens( ).add( oldParserTokens.get( oldParserTokens.size( ) - 1 ) );
                        parser.getTokens( ).trimToSize( );
                        parser.setStreamLength( );
//                          parser.setStreamLength( curExpr.get( curExpr.size( ) - 1 ).getTokenIndex( ) );
                        int oldPrio = this.prio;
                        this.prio = EXPRESSIONPRIO;
//                        ProcessReport oldReport = this.report;
                        List<ProcessError> oldErrors = new ArrayList<ProcessError>( this.report.getErrors( ) );
                        List<ProcessWarning> oldWarnings = new ArrayList<ProcessWarning>( this.report.getWarnings( ) );
                        this.report.getErrors( ).clear( );
                        this.report.getWarnings( ).clear( );
                        List<ProcessError> relevantErrors = new ArrayList<ProcessError>( );
                        for ( ProcessError processError : errors ) {
                            if ( token.getStartOffset( ) <= processError.getStartPosition( ) && exprEndToken.getStartOffset( ) >= processError.getStartPosition( ) ) {
                                relevantErrors.add( processError );
                            }
                        }

                        this.report.getErrors( ).addAll( relevantErrors );

                        syntacticErrorAnalysis2( parser, curContext, curPackage, types, modelElementsByName, modelElementsByOclQualifiedName, oclDefinedFeatures );


//                        relevantErrors.clear( );
//                        for ( ProcessError processError2 : this.report.getErrors( ) ) {
//                            if ( processError2.getRootCause( ).getClass( ) == MoinBaseException.class )
//                                relevantErrors.add( processError2 );
//                        }
                        this.report.getErrors( ).removeAll( relevantErrors );
                        this.report.getErrors( ).addAll( oldErrors );
                        this.report.getWarnings( ).addAll( oldWarnings );

                        this.prio = oldPrio;
                        parser.getTokens( ).clear( );
                        parser.getTokens( ).addAll( oldParserTokens );
                        parser.setStreamLength( oldParserTokens.get( oldParserTokens.size( ) - 1 ).getTokenIndex( ) );

                        break;

                    default:
                        break;
                }
            }
        } else {

            Collections.sort( this.report.getErrors( ), new MessageComparator( ) );
            List<ProcessError> errors = new ArrayList<ProcessError>( this.report.getErrors( ) );
            List<ProcessWarning> warnings = new ArrayList<ProcessWarning>( this.report.getWarnings( ) );
            for ( int i = 0; i < 4; i++ ) {

                List<ProcessError> curErrors = new ArrayList<ProcessError>( this.report.getErrors( ) );
                this.report.getErrors( ).clear( );

                int tokenIndex = 1;
                if ( curErrors.size( ) > 0 ) {

                    for ( ProcessError processError : curErrors ) {
//                      IToken startToken = parser.getTokenAtCharacter( processError.getEndPosition( ) );
                        while ( tokenIndex < parser.getTokens( ).size( ) - 1 && ( (IToken) parser.getTokens( ).get( tokenIndex ) ).getEndOffset( ) < processError.getStartPosition( ) ) {
                            tokenIndex++;
                        }
                        int start = tokenIndex;
                        while ( tokenIndex < parser.getTokens( ).size( ) && ( (IToken) parser.getTokens( ).get( tokenIndex ) ).getStartOffset( ) <= processError.getEndPosition( ) ) {
                            tokenIndex++;
                        }
                        int end = tokenIndex;
                        for ( int j = start; start < end; end-- ) {
                            parser.getTokens( ).remove( j );
                        }
                    }
                }

                parser.setStreamLength( );
                Node ast = parser.parser( ERROR_COUNT );
                if ( ast != null ) {

                    try {
                        analyzeAst( ast, context, contextPackage, types, modelElementsByName, modelElementsByOclQualifiedName, oclDefinedFeatures );
                    } catch ( FatalParsingException e ) {
                        // $JL-EXC$ ignore here
                    } catch ( MoinBaseRuntimeException e ) {
                        // $JL-EXC$ ignore here
                    }
                    break;
                }

            }
            this.report.getErrors( ).addAll( errors );
            this.report.getWarnings( ).addAll( warnings );
        }
    }

    private void analyzeAst( Node ast, RefObject context, MofPackage contextPackage, RefPackage[] types, Map<String, List<ModelElement>> modelElementsByName, Map<String, ModelElement> modelElementsByOclQualifiedName, Map<Classifier, Set<Feature>> oclDefinedFeatures )
        throws FatalParsingException, MoinBaseRuntimeException {

        // handle the provision of packages
        EditorParsingVisitor transformation;

        Set<RefPackage> typePackages = new HashSet<RefPackage>( );
        if ( types != null ) {
            for ( int i = 0; i < types.length; i++ ) {
                if ( types[i] == null ) {
                    // null: warning
                    this.report.reportWarning( new ProcessWarningImpl( new Exception( ).getStackTrace( ), OclParserMessages.MOIN_OCL_PARSER_1001 ) );
                } else {
                    RefPackage actRefPackage = types[i];

                    if ( !typePackages.add( actRefPackage ) ) {
                        // duplicate: warning
                        this.getReport( ).reportWarning( new ProcessWarningImpl( new Exception( ).getStackTrace( ), OclParserMessages.MOIN_OCL_PARSER_1002, types[i] ) );
                    }
                }
            }
        }

        // get an OCL type checker
        OCLTypeChecker oclTypeChecker = new OCLTypeChecker( this.jmiCreator );

        // get an OCL lookup table service
        OCLLookupTables oclLookupTables = new OCLLookupTables( this.jmiCreator );

        // get the environment
        OCLEnvironment env = new OCLEnvironment( this.report, this.jmiCreator, context, contextPackage, typePackages, modelElementsByName, modelElementsByOclQualifiedName );

        // set the defined features in the newly built environment
        if ( oclDefinedFeatures != null ) {
            for ( Map.Entry<Classifier, Set<Feature>> oclDefinedFeature : oclDefinedFeatures.entrySet( ) ) {
                for ( Feature feature : oclDefinedFeature.getValue( ) ) {
                    if ( feature instanceof Operation ) {
                        oclLookupTables.defineUserDefOperation( oclDefinedFeature.getKey( ), (Operation) feature );
                    }
                }
            }
        }

        // obtain a semantic analyser
        transformation = new EditorParsingVisitor( env, oclTypeChecker, oclLookupTables );
        ast.accept( transformation );
    }
}
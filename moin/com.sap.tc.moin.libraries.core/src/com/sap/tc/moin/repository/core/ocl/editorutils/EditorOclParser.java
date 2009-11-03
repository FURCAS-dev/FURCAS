package com.sap.tc.moin.repository.core.ocl.editorutils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.Feature;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.__impl.MofPackageImpl;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import lpg.lpgjavaruntime.IToken;

import com.sap.tc.moin.friends.ocl.editor.IOclProposal;
import com.sap.tc.moin.ocl.parser.gen.OclLexerGen;
import com.sap.tc.moin.ocl.parser.gen.OclParserGen;
import com.sap.tc.moin.ocl.parser.gen.OclParserGensym;
import com.sap.tc.moin.ocl.parser.gen.oclAst.Node;
import com.sap.tc.moin.ocl.parser.impl.env.OCLEnvironment;
import com.sap.tc.moin.ocl.parser.impl.env.OCLLookupTables;
import com.sap.tc.moin.ocl.parser.impl.env.OCLTypeChecker;
import com.sap.tc.moin.ocl.parser.impl.errors.FatalParsingException;
import com.sap.tc.moin.ocl.parser.impl.localization.OclParserMessages;
import com.sap.tc.moin.ocl.utils.OclConstants;
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
import com.sap.tc.moin.repository.shared.util.ProcessWarningImpl;
import com.sap.tc.moin.repository.shared.util.parsers.LPGMessages;

/**
 * The OCL Editor Parser
 */
public class EditorOclParser {

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
    private final MoinJmiCreator jmiCreator;

    /**
     * And a process report
     */
    private final AllConsumingProcessReport report = new AllConsumingProcessReport( ERROR_COUNT );

    /**
     * Constructs a new OclParser instance
     * 
     * @param actJmiCreator needed to create the syntax tree
     */
    public EditorOclParser( MoinJmiCreator actJmiCreator ) {

        this.jmiCreator = actJmiCreator;
    }

    /**
     * @param oclExpression expression
     * @param contextPackage context package
     * @param modelElementsByName index
     * @param modelElementsByOclQualifiedName qualified index
     * @param oclDefinedFeatures features
     * @return the report
     */
    public AllConsumingProcessReport parseString( String oclExpression, MofPackageImpl contextPackage, Map<String, List<ModelElement>> modelElementsByName, Map<String, ModelElement> modelElementsByOclQualifiedName, Map<Classifier, Set<Feature>> oclDefinedFeatures ) {

        return this.parseInternal( oclExpression, null, contextPackage, null, modelElementsByName, modelElementsByOclQualifiedName, oclDefinedFeatures );
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
                        this.report.reportWarning( new ProcessWarningImpl( new Exception( ).getStackTrace( ), OclParserMessages.MOIN_OCL_PARSER_1002, types[i] ) );
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

        // obtain a semantic analyzer
        transformation = new EditorParsingVisitor( env, oclTypeChecker, oclLookupTables );
        // do the semantic analysis
        ast.accept( transformation );

    }

    private void syntacticErrorAnalysis( String constraint, RefObject context, MofPackage contextPackage, RefPackage[] types, Map<String, List<ModelElement>> modelElementsByName, Map<String, ModelElement> modelElementsByOclQualifiedName, Map<Classifier, Set<Feature>> oclDefinedFeatures ) {

        Collections.sort( this.report.getErrors( ), new MessageComparator( ) );
        boolean semanticAnalysis = false;
        StringBuffer con = new StringBuffer( constraint );
        SortedMap<Integer, Integer> poslength = new TreeMap<Integer, Integer>( );
        List<ProcessError> errors = new ArrayList<ProcessError>( this.report.getErrors( ) );
        List<ProcessWarning> warnings = new ArrayList<ProcessWarning>( this.report.getWarnings( ) );
        int maxTry = this.report.getErrors( ).size( );
        for ( int i = 0; i < maxTry + 2; i++ ) {

            List<ProcessError> curErrors = new ArrayList<ProcessError>( this.report.getErrors( ) );
            this.report.getErrors( ).clear( );

            if ( curErrors.size( ) > 0 ) {

                for ( ProcessError processError : curErrors ) {
                    // IToken startToken = parser.getTokenAtCharacter(
                    // processError.getEndPosition( ) );
                    String mes = processError.getMessage( );
                    String delMes = LPGMessages.LPG_DELETION_CODE.format( ).split( "\\{0\\}" )[1]; //$NON-NLS-1$
                    String insAfterMes = LPGMessages.LPG_INSERTION_CODE.format( ).split( "\\{0\\}" )[1]; //$NON-NLS-1$
                    String insBeforeMes = LPGMessages.LPG_BEFORE_CODE.format( ).split( "\\{0\\}" )[1]; //$NON-NLS-1$
                    String invalidMes = LPGMessages.LPG_INVALID_TOKEN_CODE.format( ).split( "\\{0\\}:" )[1]; //$NON-NLS-1$
                    String substMes = LPGMessages.LPG_SUBSTITUTION_SECONDARY_CODE.format( ).split( "\\{0\\}" )[1]; //$NON-NLS-1$
                    String mergeMes = LPGMessages.LPG_MERGE_CODE.format( ).split( "\\{0\\}" )[1]; //$NON-NLS-1$

                    if ( mes.endsWith( delMes ) ) {
                        int start = processError.getStartPosition( );
                        if ( start < 0 ) {
                            continue;
                        }
                        int end = processError.getEndPosition( ) + 1;
                        int length = end - start;
                        String replace = OclConstants.EMPTY;
                        while ( length > 0 ) {
                            replace += OclConstants.SPACE;
                            length--;
                        }
                        con.replace( start, end, replace );
                        maxTry--;

                    } else if ( mes.endsWith( insAfterMes ) ) {
                        String[] split = mes.split( "\"" ); //$NON-NLS-1$
                        String miss = split[1];

                        int end = processError.getEndPosition( ) + 1;
                        con.insert( end, OclConstants.SPACE + miss + OclConstants.SPACE );
                        poslength.put( Integer.valueOf( end + 1 ), Integer.valueOf( miss.length( ) + 2 ) );
                        break;

                    } else if ( mes.endsWith( insBeforeMes ) ) {
                        String[] split = mes.split( "\"" ); //$NON-NLS-1$
                        String miss = split[1];
                        int start = processError.getStartPosition( );

                        con.insert( start, OclConstants.SPACE + miss + OclConstants.SPACE );
                        poslength.put( Integer.valueOf( start + 1 ), Integer.valueOf( miss.length( ) + 2 ) );
                        break;

                    } else if ( mes.endsWith( invalidMes ) || mes.endsWith( substMes ) || mes.endsWith( mergeMes ) ) {

                        String[] split = mes.split( "\"" ); //$NON-NLS-1$
                        String miss = split[1];
                        int start = processError.getStartPosition( );
                        int end = processError.getEndPosition( ) + 1;
                        con.replace( start, end, miss );
                        poslength.put( Integer.valueOf( start ), Integer.valueOf( miss.length( ) - ( ( end ) - ( start ) ) ) );
                        break;
                    }

                }

            }
//            ProcessReport helpR = new ProcessReportImpl();
            OclLexerGen helpL = new OclLexerGen( con.toString( ).toCharArray( ), "OCL", this.report, 4 ); //$NON-NLS-1$
            OclParserGen helpP = new OclParserGen( helpL, this.report );
            helpL.lexer( helpP );
//            parser.setStreamLength( );
//            Node ast = parser.parser( ERROR_COUNT );
            Node ast = helpP.parser( ERROR_COUNT );
            if ( ast != null ) {
                semanticAnalysis = true;
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
        Set<Integer> keys = poslength.keySet( );
        List<ProcessError> errorsToDelete = new ArrayList<ProcessError>( );
        List<ProcessWarning> warningsToDelete = new ArrayList<ProcessWarning>( );
        List<ProcessError> curErrors = new ArrayList<ProcessError>( this.report.getErrors( ) );
        Hashtable<Integer, Integer> warningChanges = new Hashtable<Integer, Integer>( );
        Hashtable<Integer, Integer> errorChanges = new Hashtable<Integer, Integer>( );
        List<ProcessWarning> curWarnings = new ArrayList<ProcessWarning>( this.report.getWarnings( ) );
        for ( Integer theInteger : keys ) {
            int integer = theInteger.intValue( );
            for ( int i = 0; i < curWarnings.size( ); i++ ) {
                ProcessWarning processWarning = curWarnings.get( i );
                if ( processWarning.getStartPosition( ) == integer ) {
                    warningsToDelete.add( processWarning );
                } else if ( processWarning.getStartPosition( ) > integer ) {
                    warningChanges.put( Integer.valueOf( i ), poslength.get( theInteger ) );
                    break;
                }
            }
            for ( int i = 0; i < curErrors.size( ); i++ ) {
                ProcessError processError = curErrors.get( i );
                if ( processError.getStartPosition( ) == integer ) {
                    errorsToDelete.add( processError );
                } else if ( processError.getStartPosition( ) > integer ) {
                    errorChanges.put( Integer.valueOf( i ), poslength.get( theInteger ) );
                    break;
                }
            }
        }
        for ( Integer theInteger : warningChanges.keySet( ) ) {
            int integer = theInteger.intValue( );
            int change = warningChanges.get( theInteger ).intValue( );
            for ( int i = integer; i < curWarnings.size( ); i++ ) {

                ProcessWarning processWarning = curWarnings.get( i );
                processWarning.setStartPosition( processWarning.getStartPosition( ) - change );
                processWarning.setEndPosition( processWarning.getEndPosition( ) - change );
            }
        }
        for ( Integer theInteger : errorChanges.keySet( ) ) {
            int integer = theInteger.intValue( );
            int change = errorChanges.get( theInteger ).intValue( );
            for ( int i = integer; i < curErrors.size( ); i++ ) {

                ProcessError processError = curErrors.get( i );
                processError.setStartPosition( processError.getStartPosition( ) - change );
                processError.setEndPosition( processError.getEndPosition( ) - change );
            }
        }
        curErrors.removeAll( errorsToDelete );
        curWarnings.removeAll( warningsToDelete );
        this.report.getErrors( ).clear( );
        this.report.getWarnings( ).clear( );
        if ( semanticAnalysis ) {
            this.report.getErrors( ).addAll( curErrors );
            this.report.getWarnings( ).addAll( curWarnings );
        }
        this.report.getErrors( ).addAll( errors );
        this.report.getWarnings( ).addAll( warnings );

    }

    private AllConsumingProcessReport parseInternal( String inString, RefObject context, MofPackage contextPackage, RefPackage[] types, Map<String, List<ModelElement>> modelElementsByName, Map<String, ModelElement> modelElementsByOclQualifiedName, Map<Classifier, Set<Feature>> oclDefinedFeatures ) {

        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, OclParserMessages.STARTPARSEERRORTOLERANT, inString );
        }

        long timeStamp = System.currentTimeMillis( );

        // create the lexer
        OclLexerGen oclLexer = new OclLexerGen( inString.toCharArray( ), "OCL", this.report, ECLIPSE_TAB_VALUE ); //$NON-NLS-1$

        // create the parser
        OclParserGen oclParser = new OclParserGen( oclLexer, this.report );

        // do the actual parsing
        Node ast;
        // OclAstBuilder transformation;
        try {
            // EditorParsingVisitor transformation;
            // lex the input stream
            oclLexer.lexer( oclParser );

            // analyze if there are more than one package declarations and
            // report an error
            try {
                this.findOccurences( oclParser, new int[] { OclParserGensym.TK_package }, 1 );
            } catch ( IllegalStateException e1 ) {
                this.report.reportError( new ProcessErrorImpl( new OclSemanticException( OclParserMessages.ONLYONEINVPERCONSTRAINT ) ) );
            }

            // analyze if there are more than one context declarations and
            // report an error
//            try {
//                EditorUtilHelp.findOccurences( oclParser, new int[] { OclParserGensym.TK_context }, 1 );
//            } catch ( IllegalStateException e1 ) {
//                this.report.reportError( new MoinBaseException( "Currently MOIN only supports one inv per constraint. Due to this reason, there might only be one context declaration." ) );
//            }

            // parse the token stream and create the ast.
            ast = oclParser.parser( ERROR_COUNT );

            // we cannot start the semantic analysis if we still have parse
            // errors
            if ( this.report.getProcessStatus( ) == ProcessReport.FAILED || this.report.getProcessStatus( ) == ProcessReport.FATAL ) {
                syntacticErrorAnalysis( inString, context, contextPackage, types, modelElementsByName, modelElementsByOclQualifiedName, oclDefinedFeatures );
                convertToFixableError( inString );
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

//         OclSemanticException exn = new OclSemanticException(
//         OclParserMessages.MOIN_OCL_PARSER_0900, e );
//            this.report.reportFatalError( new ProcessErrorImpl( exn ) );
//            throw new ParsingException( exn, this.report );
//         }
//        if ( this.report.getProcessStatus( ) == ProcessReport.FAILED ) {
//         throw new ParsingException( new OclSemanticException(
//         OclParserMessages.MOIN_OCL_PARSER_0900 ), this.report );
//        }
//
//        if ( this.report.getProcessStatus( ) == ProcessReport.FATAL ) {
//            throw new MoinBaseRuntimeException( "(INTERNAL): Unexpected point reached after parsing!" );
//        }
//
//        if ( this.report.getProcessStatus( ) == ProcessReport.INITIAL ) {
//            this.report.reportCompletion( );
//        }

        long parseTime = System.currentTimeMillis( ) - timeStamp;

        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, OclParserMessages.PARSEDURATION, Long.valueOf( parseTime ) );
        }

        return this.report;
    }

    private void convertToFixableError( String constraint ) {

        List<ProcessError> errors = new ArrayList<ProcessError>( this.report.getErrors( ) );

        String delMes = LPGMessages.LPG_DELETION_CODE.format( ).split( "\\{0\\}" )[1]; //$NON-NLS-1$
        String insAfterMes = LPGMessages.LPG_INSERTION_CODE.format( ).split( "\\{0\\}" )[1]; //$NON-NLS-1$
        String insBeforeMes = LPGMessages.LPG_BEFORE_CODE.format( ).split( "\\{0\\}" )[1]; //$NON-NLS-1$
        String invalidMes = LPGMessages.LPG_INVALID_TOKEN_CODE.format( ).split( "\\{0\\}:" )[1]; //$NON-NLS-1$
        String substMes = LPGMessages.LPG_SUBSTITUTION_SECONDARY_CODE.format( ).split( "\\{0\\}" )[1]; //$NON-NLS-1$
        String mergeMes = LPGMessages.LPG_MERGE_CODE.format( ).split( "\\{0\\}" )[1]; //$NON-NLS-1$

        for ( ProcessError processError : errors ) {
            // IToken startToken = parser.getTokenAtCharacter(
            // processError.getEndPosition( ) );
            String mes = processError.getMessage( );
            IOclProposal fix = null;
            if ( mes.endsWith( delMes ) ) {
                int start = processError.getStartPosition( );
                if ( start < 0 ) {
                    continue;
                }

                int end = processError.getEndPosition( ) + 1;
                int length = end - start;
                String miss = constraint.substring( start, end );
                String replace = OclConstants.EMPTY;
                while ( length > 0 ) {
                    replace += OclConstants.SPACE;
                    length--;

                    fix = new OCLProposalImpl( MoinReplacementStrings.DELETETOKEN, new Object[] { miss }, OclConstants.EMPTY, null, start, end - start, IOclProposal.TYPE.DELETE, OCLProposalImpl.STANDARDPRIORITY );
                }



            } else if ( mes.endsWith( insAfterMes ) ) {
                String[] split = mes.split( "\"" ); //$NON-NLS-1$
                String miss = split[1];

                int end = processError.getEndPosition( ) + 1;
                fix = new OCLProposalImpl( MoinReplacementStrings.INSERTTOKEN, new Object[] { miss }, OclConstants.SPACE + miss + OclConstants.SPACE, null, end, 0, IOclProposal.TYPE.INSERT, OCLProposalImpl.STANDARDPRIORITY );



            } else if ( mes.endsWith( insBeforeMes ) ) {
                String[] split = mes.split( "\"" ); //$NON-NLS-1$
                String miss = split[1];
                int start = processError.getStartPosition( );

                fix = new OCLProposalImpl( MoinReplacementStrings.INSERTTOKENBEFORE, new Object[] { miss }, OclConstants.SPACE + miss + OclConstants.SPACE, null, start, 0, IOclProposal.TYPE.INSERT, OCLProposalImpl.STANDARDPRIORITY );


            } else if ( mes.endsWith( invalidMes ) || mes.endsWith( substMes ) || mes.endsWith( mergeMes ) ) {

                String[] split = mes.split( "\"" ); //$NON-NLS-1$
                String miss = split[1];
                int start = processError.getStartPosition( );
                int end = processError.getEndPosition( ) + 1;
                String toReplace = constraint.substring( start, end );
                fix = new OCLProposalImpl( MoinReplacementStrings.REPLACETOKEN, new Object[] { toReplace, miss }, miss, null, start, end - start, IOclProposal.TYPE.REPLACE, OCLProposalImpl.STANDARDPRIORITY );

            }
            if ( fix != null ) {
                this.report.getErrors( ).remove( processError );
                this.report.getErrors( ).add( new FixableProcessErrorImpl( processError, new IOclProposal[] { fix } ) );
            }

        }

    }

    private List<Integer> findOccurences( OclParserGen parser, int[] tokenKinds, int maxOccurences ) throws IllegalStateException {

        List<Integer> result = new ArrayList<Integer>( );
        List<IToken> tokens = parser.getTokens( );
        for ( IToken token : tokens ) {
            int kind = token.getKind( );
            for ( int i : tokenKinds ) {
                if ( kind == i ) {
                    if ( maxOccurences >= 0 && result.size( ) == maxOccurences ) {
                        throw new IllegalStateException( );
                    }
                    // token.getStartOffset() if we need the offset
                    result.add( Integer.valueOf( parser.getTokens( ).indexOf( token ) ) );
                    break;
                }

            }
        }
        return result;
    }

}

package com.sap.tc.moin.ocl.parser;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.Feature;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.ocl.parser.gen.OclLexerGen;
import com.sap.tc.moin.ocl.parser.gen.OclParserGen;
import com.sap.tc.moin.ocl.parser.gen.oclAst.Node;
import com.sap.tc.moin.ocl.parser.impl.OclAstBuilder;
import com.sap.tc.moin.ocl.parser.impl.env.OCLEnvironment;
import com.sap.tc.moin.ocl.parser.impl.env.OCLLookupTables;
import com.sap.tc.moin.ocl.parser.impl.env.OCLTypeChecker;
import com.sap.tc.moin.ocl.parser.impl.errors.FatalParsingException;
import com.sap.tc.moin.ocl.parser.impl.localization.OclParserMessages;
import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.ocl.utils.jmi.MoinJmiCreator;
import com.sap.tc.moin.ocl.utils.jmi.OclSemanticException;
import com.sap.tc.moin.repository.ProcessReport;
import com.sap.tc.moin.repository.ocl.exceptions.ParsingException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.shared.util.ProcessErrorImpl;
import com.sap.tc.moin.repository.shared.util.ProcessReportImpl;
import com.sap.tc.moin.repository.shared.util.ProcessWarningImpl;

/**
 * The OCL Parser
 */
public class OclParserLPG implements IOclParser {

    // trace setup
    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_CORE_OCL_PARSER, OclParserLPG.class );

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
    private ProcessReport report;

    /**
     * @param jmiCreator the {@link MoinJmiCreator}
     * @return a new instance
     */
    static public IOclParser create( MoinJmiCreator jmiCreator ) {

        return new OclParserLPG( jmiCreator );
    }

    /**
     * Constructs a new OclParser instance
     * 
     * @param actJmiCreator needed to create the syntax tree
     */
    private OclParserLPG( MoinJmiCreator actJmiCreator ) {

        this.jmiCreator = actJmiCreator;
    }

    private Set<OclStatement> parseInternal( String inString, RefObject context, MofPackage contextPackage, RefPackage[] types, Map<String, List<ModelElement>> modelElementsByName, Map<String, ModelElement> modelElementsByOclQualifiedName, Map<Classifier, Set<Feature>> oclDefinedFeatures )
        throws ParsingException {

        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, OclParserMessages.STARTPARSEEXPR, inString );
        }

        long timeStamp = System.currentTimeMillis( );

        // we remove and install a new report on *each* parse
        this.report = new ProcessReportImpl( ERROR_COUNT );

        // create the lexer
        OclLexerGen oclLexer = new OclLexerGen( inString.toCharArray( ), "OCL", this.report, ECLIPSE_TAB_VALUE ); //$NON-NLS-1$

        // create the parser
        OclParserGen oclParser = new OclParserGen( oclLexer, this.report );

        // do the actual parsing
        Node ast;
        OclAstBuilder transformation;
        try {

            // lex the input stream
            oclLexer.lexer( oclParser );

            // parse the token stream and create the ast.
            ast = oclParser.parser( ERROR_COUNT );

            // we cannot start the semantic analysis if we still have parse errors
            if ( this.report.getProcessStatus( ) == ProcessReport.FAILED || this.report.getProcessStatus( ) == ProcessReport.FATAL ) {
                throw new ParsingException( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0900 ), this.report );
            }

            if ( ast == null ) {

                OclSemanticException exn = new OclSemanticException( OclParserMessages.NOINPUT );
                this.report.reportFatalError( new ProcessErrorImpl( exn ) );
                throw new ParsingException( exn, this.report );

            }

            // handle the provision of packages
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

            // obtain a semantic analyzer
            transformation = new OclAstBuilder( env, oclTypeChecker, oclLookupTables );

            // do the semantic analysis
            ast.accept( transformation );

            if ( this.report.getProcessStatus( ) == ProcessReport.FAILED || this.report.getProcessStatus( ) == ProcessReport.FATAL ) {
                throw new ParsingException( new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0900 ), this.report );
            }

            if ( this.report.getProcessStatus( ) == ProcessReport.INITIAL ) {
                this.report.reportCompletion( );
            }

            return transformation.getStatements( );


        } catch ( FatalParsingException e ) {
            OclSemanticException exn = new OclSemanticException( e, OclParserMessages.MOIN_OCL_PARSER_0900 );
            this.report.reportFatalError( new ProcessErrorImpl( exn ) );
            throw new ParsingException( exn, this.report );
        } finally {

            Long parseTime = Long.valueOf( System.currentTimeMillis( ) - timeStamp );

            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                LOGGER.trace( MoinSeverity.DEBUG, OclParserMessages.PARSEDURATION, parseTime );
            }
        }


    }

    public ProcessReport getReport( ) {

        return this.report;
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.ocl.parser.IOclParser#parseString(java.lang.String,
     * com.sap.tc.moin.repository.mmi.reflect.RefObject, com.sap.tc.moin.repository.mmi.reflect.RefPackage[])
     */
    public Set<OclStatement> parseString( String ocl, RefObject context, RefPackage[] types ) throws ParsingException {

        return this.parseInternal( ocl, context, null, types, null, null, null );
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.ocl.parser.IOclParser#parseString(java.lang.String,
     * com.sap.tc.moin.repository.mmi.reflect.RefObject, com.sap.tc.moin.repository.mmi.reflect.RefPackage[],
     * java.util.Map)
     */
    public Set<OclStatement> parseString( String ocl, RefObject context, RefPackage[] types, Map<Classifier, Set<Feature>> oclDefinedFeatures ) throws ParsingException {

        return this.parseInternal( ocl, context, null, types, null, null, oclDefinedFeatures );
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.ocl.parser.IOclParser#parseString(java.lang.String,
     * com.sap.tc.moin.repository.mmi.reflect.RefObject, java.util.Map, java.util.Map, java.util.Map)
     */
    public Set<OclStatement> parseString( String oclExpression, Map<String, List<ModelElement>> modelElementsByName, Map<String, ModelElement> modelElementsByOclQualifiedName, Map<Classifier, Set<Feature>> oclDefinedFeatures ) throws ParsingException {

        return this.parseInternal( oclExpression, null, null, null, modelElementsByName, modelElementsByOclQualifiedName, oclDefinedFeatures );
    }

    public Set<OclStatement> parseString( String oclExpression, Operation op, Map<String, List<ModelElement>> modelElementsByName, Map<String, ModelElement> modelElementsByOclQualifiedName, Map<Classifier, Set<Feature>> oclDefinedFeatures ) throws ParsingException {

        return this.parseInternal( oclExpression, op, null, null, modelElementsByName, modelElementsByOclQualifiedName, oclDefinedFeatures );
    }

    public Set<OclStatement> parseString( String oclExpression, MofPackage contextPackage, Map<String, List<ModelElement>> modelElementsByName, Map<String, ModelElement> modelElementsByOclQualifiedName, Map<Classifier, Set<Feature>> oclDefinedFeatures ) throws ParsingException {

        return this.parseInternal( oclExpression, null, contextPackage, null, modelElementsByName, modelElementsByOclQualifiedName, oclDefinedFeatures );
    }

    public Set<OclStatement> parseString( String oclExpression, RefObject context, Map<String, List<ModelElement>> modelElementsByName, Map<String, ModelElement> modelElementsByOclQualifiedName, Map<Classifier, Set<Feature>> oclDefinedFeatures ) throws ParsingException {

        return this.parseInternal( oclExpression, context, null, null, modelElementsByName, modelElementsByOclQualifiedName, oclDefinedFeatures );
    }
}

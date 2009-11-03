package com.sap.tc.moin.repository.core.query.moinql.parser;

import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.ProcessReport;
import com.sap.tc.moin.repository.core.query.messages.FQLTraceMessages;
import com.sap.tc.moin.repository.core.query.messages.MQLApiMessages;
import com.sap.tc.moin.repository.core.query.messages.MQLBugMessages;
import com.sap.tc.moin.repository.core.query.moinql.parser.gen.MqlLexerGen;
import com.sap.tc.moin.repository.core.query.moinql.parser.gen.MqlParserGen;
import com.sap.tc.moin.repository.core.query.moinql.parser.gen.mqlAst.Node;
import com.sap.tc.moin.repository.core.query.moinql.parser.impl.MqlAstBuilder;
import com.sap.tc.moin.repository.core.query.moinql.shared.MQLBugException;
import com.sap.tc.moin.repository.core.query.moinql.shared.MQLUsageException;
import com.sap.tc.moin.repository.mql.MQLFormatException;
import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.mql.MQLQuery;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.shared.util.ProcessErrorImpl;
import com.sap.tc.moin.repository.shared.util.ProcessReportImpl;

/**
 * @author D045917
 */
public class MqlParser {

    // trace setup
    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_QUERY_MQL, MqlParser.class );

    /**
     * This sets the failure tolerance of the parser
     */
    private int ERROR_COUNT = 100;

    /**
     * The Eclipse TAB size is 4
     */
    private final static int ECLIPSE_TAB_VALUE = 4;

    /**
     * We need the moin instance
     */
    private Moin moin;

    /**
     * And a process report
     */
    private ProcessReport report;

    public MqlParser( int errorCount, Moin _moin ) {

        this.ERROR_COUNT = errorCount;
        this.moin = _moin;
    }

    public ProcessReport getReport( ) {

        return this.report;
    }

    public MQLQuery parse( String query, MQLProcessor mqlProcessor ) throws MQLFormatException {

        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, FQLTraceMessages.MQL_PARSER_PARSES, "\n", query ); //$NON-NLS-1$
        }

        long timeStamp = System.currentTimeMillis( );

        // we remove and install a new report on *each* parse
        this.report = new ProcessReportImpl( this.ERROR_COUNT );

        // create the lexer
        MqlLexerGen mqlLexer = new MqlLexerGen( query.toCharArray( ), "MQL", this.report, ECLIPSE_TAB_VALUE ); //$NON-NLS-1$

        // create the parser
        MqlParserGen mqlParser = new MqlParserGen( mqlLexer, this.report );

        // do the actual parsing
        ////////////////////////

        // (1) LEXING the input stream
        mqlLexer.lexer( mqlParser );

        // (2) PARSING the token stream and create the ast.
        Node ast = mqlParser.parser( this.ERROR_COUNT );

        // we cannot start the semantic analysis if we still have parse errors
        if ( this.report.getProcessStatus( ) == ProcessReport.FAILED ) {
            this.report.setProcessStatus( ProcessReport.FATAL );
            throw new MQLFormatException( this.report );
        }

        if ( this.report.getProcessStatus( ) == ProcessReport.FATAL ) {
            throw new MQLBugException( MQLBugMessages.PARSE_POINT_UNEXPECTED );
        }

        if ( ast == null ) {
            // no query provided
            this.report.reportFatalError( new ProcessErrorImpl( new MQLUsageException( MQLApiMessages.EMPTY_QUERY ) ) );
            throw new MQLFormatException( this.report );
        }

        // (3) SEMANTIC ANALYSIS

        // obtain a semantic analyser
        MqlAstBuilder mqlAstBuilder = new MqlAstBuilder( this.report, this.moin, mqlProcessor );

        // do the semantic analysis
        ast.accept( mqlAstBuilder );

        if ( this.report.getProcessStatus( ) == ProcessReport.FAILED ) {
            this.report.setProcessStatus( ProcessReport.FATAL );
            throw new MQLFormatException( this.report );
        }

        if ( this.report.getProcessStatus( ) == ProcessReport.FATAL ) {
            throw new MQLBugException( MQLBugMessages.PARSE_POINT_UNEXPECTED );
        }

        if ( this.report.getProcessStatus( ) == ProcessReport.INITIAL ) {
            this.report.reportCompletion( );
        }

        long parseTime = System.currentTimeMillis( ) - timeStamp;

        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, FQLTraceMessages.MQL_PARSE_TIME, parseTime );
        }

        return mqlAstBuilder.getMQLQuery( );
    }
}

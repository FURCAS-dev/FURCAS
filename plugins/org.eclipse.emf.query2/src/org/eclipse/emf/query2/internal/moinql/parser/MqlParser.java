/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query2.internal.moinql.parser;

import org.eclipse.emf.query2.Query;
import org.eclipse.emf.query2.QueryFormatException;
import org.eclipse.emf.query2.QueryProcessor;
import org.eclipse.emf.query2.internal.logger.LogSeverity;
import org.eclipse.emf.query2.internal.logger.LoggerFactory;
import org.eclipse.emf.query2.internal.logger.QueryLogger;
import org.eclipse.emf.query2.internal.messages.ApiMessages;
import org.eclipse.emf.query2.internal.messages.BugMessages;
import org.eclipse.emf.query2.internal.messages.FQLTraceMessages;
import org.eclipse.emf.query2.internal.moinql.parser.gen.MqlLexerGen;
import org.eclipse.emf.query2.internal.moinql.parser.gen.MqlParserGen;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.Node;
import org.eclipse.emf.query2.internal.moinql.parser.impl.MqlAstBuilder;
import org.eclipse.emf.query2.internal.shared.BugException;
import org.eclipse.emf.query2.internal.shared.EmfHelper;
import org.eclipse.emf.query2.internal.shared.UsageException;
import org.eclipse.emf.query2.report.ProcessErrorImpl;
import org.eclipse.emf.query2.report.ProcessReport;
import org.eclipse.emf.query2.report.ProcessReportImpl;

/**
 * @author D045917
 */
public class MqlParser {

	// trace setup
	private static final QueryLogger LOGGER = LoggerFactory.getLogger(MqlParser.class);

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
	private EmfHelper moin;

	/**
	 * And a process report
	 */
	private ProcessReport report;

	public MqlParser(int errorCount, EmfHelper _moin) {

		this.ERROR_COUNT = errorCount;
		this.moin = _moin;
	}

	public ProcessReport getReport() {

		return this.report;
	}

	public Query parse(String query, QueryProcessor mqlProcessor) throws QueryFormatException {

		if (LOGGER.isTraced(LogSeverity.DEBUG)) {
			LOGGER.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PARSER_PARSES, "\n", query); //$NON-NLS-1$
		}

		long timeStamp = System.currentTimeMillis();

		// we remove and install a new report on *each* parse
		this.report = new ProcessReportImpl(this.ERROR_COUNT);

		// create the lexer
		MqlLexerGen mqlLexer = new MqlLexerGen(query.toCharArray(), "MQL", this.report, ECLIPSE_TAB_VALUE); //$NON-NLS-1$

		// create the parser
		MqlParserGen mqlParser = new MqlParserGen(mqlLexer, this.report);

		// do the actual parsing
		////////////////////////

		// (1) LEXING the input stream
		mqlLexer.lexer(mqlParser);

		// (2) PARSING the token stream and create the ast.
		Node ast = mqlParser.parser(this.ERROR_COUNT);

		// we cannot start the semantic analysis if we still have parse errors
		if (this.report.getProcessStatus() == ProcessReport.FAILED) {
			this.report.setProcessStatus(ProcessReport.FATAL);
			throw new QueryFormatException(this.report);
		}

		if (this.report.getProcessStatus() == ProcessReport.FATAL) {
			throw new BugException(BugMessages.PARSE_POINT_UNEXPECTED);
		}

		if (ast == null) {
			// no query provided
			this.report.reportFatalError(new ProcessErrorImpl(new UsageException(ApiMessages.EMPTY_QUERY)));
			throw new QueryFormatException(this.report);
		}

		// (3) SEMANTIC ANALYSIS

		// obtain a semantic analyser
		MqlAstBuilder mqlAstBuilder = new MqlAstBuilder(this.report, this.moin, mqlProcessor);

		// do the semantic analysis
		ast.accept(mqlAstBuilder);

		if (this.report.getProcessStatus() == ProcessReport.FAILED) {
			this.report.setProcessStatus(ProcessReport.FATAL);
			throw new QueryFormatException(this.report);
		}

		if (this.report.getProcessStatus() == ProcessReport.FATAL) {
			throw new BugException(BugMessages.PARSE_POINT_UNEXPECTED);
		}

		if (this.report.getProcessStatus() == ProcessReport.INITIAL) {
			this.report.reportCompletion();
		}

		long parseTime = System.currentTimeMillis() - timeStamp;

		if (LOGGER.isTraced(LogSeverity.DEBUG)) {
			LOGGER.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PARSE_TIME, parseTime);
		}

		return mqlAstBuilder.getMQLQuery();
	}
}

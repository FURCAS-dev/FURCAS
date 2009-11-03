/*******************************************************************************
 * Copyright (c) 2008 ikv++ technologies ag and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     ikv++ technologies ag - initial API and implementation
 *******************************************************************************/

package de.ikv.medini.qvt.syntax.parser;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.Reader;

import java_cup.runtime.ComplexSymbolFactory;

import org.oslo.ocl20.syntax.ast.qvt.TopLevelAS;

import uk.ac.kent.cs.kmf.util.ILog;

public class QvtParserImpl implements QvtParser {

	public java_cup.runtime.lr_parser createParser(Reader reader, ILog log) {
		// --- Create a lexer and a parser ---
		ComplexSymbolFactory symbolFactory = new ComplexSymbolFactory();
		Yylex yylex = new Yylex(reader, symbolFactory);
		yylex.setLog(log);
		Yyparse yyparser = new YyparseWithSourceTracking(yylex, symbolFactory);
		yyparser.setLog(log);
		yyparser.setFactory(new ASTBuilder(log));
		return yyparser;
	}

	/** Parse the 'reader' and return the syntax tree 'root' */
	public TopLevelAS parse(Reader reader, ILog log, boolean debug) {
		java_cup.runtime.lr_parser yyparser = this.createParser(reader, log);

		// --- Store the no of errors ---
		int errNo = log.getErrors();
		int warnNo = log.getWarnings();

		// --- Parse input ---
		TopLevelAS root = null;
		java_cup.runtime.Symbol rootSymbol = null;
		try {
			if (debug) {
				rootSymbol = yyparser.debug_parse();
			} else {
				rootSymbol = yyparser.parse();
			}
		} catch (Exception e) {
			rootSymbol = null;
			ByteArrayOutputStream tmp = new ByteArrayOutputStream();
			e.printStackTrace(new PrintStream(tmp));
			log.reportError("Parse error" + e + "\n" + new String(tmp.toByteArray()));
		} finally {
		}

		// --- Set hasErrors flag
		this.hasErrors = log.getErrors() > errNo && !log.tooManyViolations();
		this.hasWarnings = log.getWarnings() > warnNo && !log.tooManyViolations();

		// --- Return result ---
		if (rootSymbol != null && rootSymbol.value instanceof TopLevelAS) {
			root = (TopLevelAS) rootSymbol.value;
		}
		return root;
	}

	/** Check if the parser encountered an error */
	protected boolean hasErrors;

	public boolean hasErrors() {
		return this.hasErrors;
	}

	/** Check if the parser encountered a warning */
	protected boolean hasWarnings;

	public boolean hasWarnings() {
		return this.hasWarnings;
	}
}

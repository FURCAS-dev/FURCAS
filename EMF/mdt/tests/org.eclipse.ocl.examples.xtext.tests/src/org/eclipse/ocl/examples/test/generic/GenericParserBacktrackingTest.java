/**
 * <copyright>
 * 
 * Copyright (c) 2009,2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *   E.D.Willink - Bug 298634
 *
 * </copyright>
 *
 * $Id: GenericParserBacktrackingTest.java,v 1.3 2011/02/19 12:03:51 ewillink Exp $
 */

package org.eclipse.ocl.examples.test.generic;

import org.eclipse.ocl.examples.pivot.tests.PivotTestSuite;


/**
 * Tests for error reports from the backtracking parser.
 */
@SuppressWarnings("nls")
public abstract class GenericParserBacktrackingTest
extends PivotTestSuite {

/*	private final class MyProblemHandler extends AbstractProblemHandler
	{
		protected final String source;
		protected final String failure;
		private int errors = 0;
		
		private MyProblemHandler(AbstractParser parser, String source, String failure) {
			super(parser);
			this.source = source;
			this.failure = failure;
		}
		
		public int getErrors() {
			return errors;
		}

		@Override
		public void handleProblem(Severity problemSeverity, Phase processingPhase, String problemMessage,
				String processingContext, int startOffset, int endOffset) {
			if (!failure.equals(problemMessage))
				fail("Unexpected failure '" + problemMessage + "' in '" + source + "'");
			if (errors > 1)
				fail("Repeated failure '" + problemMessage + "' in '" + source + "'");
			errors++;
		}
	} */

	public void test_reservedKeywordAsIdentifier() {
		checkDocumentWithParseFailure(
			"package ecore context EClass inv: package endpackage",
			"\"<simpleName>\" expected instead of \"package\"");
    }

	public void test_reservedKeywordAsPropertyName() {
		checkDocumentWithParseFailure(
			"package ecore context EClass inv: self.endif endpackage",
			"\"<simpleName>\" expected instead of \"endif\"");
    }

	public void test_reservedKeywordAsOperationName() {
		checkDocumentWithParseFailure(
			"package ecore context EClass inv: self.else() endpackage",
			"\"<simpleName>\" expected instead of \"else\"");
    }

	public void test_reservedKeywordAsPathNamePrefix() {
		checkDocumentWithParseFailure(
			"package ecore context if::xx inv: true endpackage",
			"\"<simpleName>\" expected instead of \"if\"");
    }

	public void test_reservedKeywordAsPathNameMidfix() {
		checkDocumentWithParseFailure(
			"package ecore context xx::if::yy inv: true endpackage",
			"\"<simpleName>\" expected instead of \"if\"");
    }

	public void test_reservedKeywordAsPathNameSuffix() {
		checkDocumentWithParseFailure(
			"package ecore context xx::if inv: true endpackage",
			"\"<simpleName>\" expected instead of \"if\"");
    }

	public void test_punctuationAsOperationName() {
		checkDocumentWithParseFailure(
			"package ecore context EClass inv: self. .. () endpackage",
			"\"<simpleName>\" expected instead of \"..\"");
    }

	public void test_missingEndPackage() {
		checkDocumentWithParseFailure(
			"package ecore context EClass inv: true",
			"\"endpackage\" expected after \"true\"");
    }

	public void test_ifMissingCondition() {
		checkDocumentWithParseFailure(
			"package ecore context EClass inv: if then else false endif endpackage",
			"\"then <expr> else <expr>\" expected instead of \"endif\"");
    }

	public void test_ifMissingThen() {
		checkDocumentWithParseFailure(
			"package ecore context EClass inv: if true true else false endif endpackage",
			"\"then <expr> else <expr> endif\" expected instead of \"true else false endif\"");
    }

	public void test_ifMissingThenExpression() {
		checkDocumentWithParseFailure(
			"package ecore context EClass inv: if true then else false endif endpackage",
			"\"<simpleName>\" expected after \"then\"");
    }

	public void test_ifMissingElse() {
		checkDocumentWithParseFailure(
			"package ecore context EClass inv: if true then true false endif endpackage",
			"\"else <expr> endif\" expected instead of \"false endif\"");
    }

	public void test_ifMissingElseExpression() {
		checkDocumentWithParseFailure(
			"package ecore context EClass inv: if true then true else endif endpackage",
			"\"<simpleName>\" expected after \"else\"");
    }

	public void test_ifMissingEndif() {
		checkDocumentWithParseFailure(
			"package ecore context EClass inv: if true then true else false endpackage",
			"\"endif\" expected after \"false\"");
    }

	private void checkDocumentWithParseFailure(String oclText, String failure) {
		throw new UnsupportedOperationException(getClass().getName() + ".checkDocumentWithParseFailure");
/*		Environment environment = ocl.getEnvironment();
		AbstractBasicEnvironment abstractBasicEnvironment = (AbstractBasicEnvironment)environment;
		OCLBacktrackingLexer lexer = new OCLBacktrackingLexer(environment, oclText.toCharArray());
		OCLBacktrackingParser parser = new OCLBacktrackingParser(lexer);
		parser.setDefaultRepairCount(-1);
		MyProblemHandler problemHandler = new MyProblemHandler(parser, oclText, failure);
		abstractBasicEnvironment.setProblemHandler(problemHandler);
		try {
			lexer.lexer(parser.getIPrsStream());
			CSTNode cst = parser.parser();
			if (problemHandler.getErrors() != 1)
				fail("Expected failure '" + failure + "' not found in '" + oclText + "'");
			assertNotNull(cst);
        } catch (Exception e) {
            assertEquals(failure, e.getLocalizedMessage());
        } */
	}
}

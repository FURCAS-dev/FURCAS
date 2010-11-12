/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: AbstractEssentialOCLFormatter.java,v 1.1 2010/05/23 10:27:33 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.formatting;

import org.eclipse.ocl.examples.xtext.base.formatting.AbstractBaseFormatter;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.CollectionLiteralExpCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.CollectionTypeCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.IfExpCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.LetExpCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.NavigatingExpCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.NavigationExpCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.PathNameExpCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.PreExpCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.RoundBracketExpCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.SquareBracketExpCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.SubNavigationExpCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.TupleLiteralExpCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.TupleTypeCSElements;
import org.eclipse.xtext.formatting.impl.FormattingConfig;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#formatting
 * on how and when to use it 
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
public abstract class AbstractEssentialOCLFormatter extends AbstractBaseFormatter
{
	protected void configureCollectionLiteralExpCS(FormattingConfig c, CollectionLiteralExpCSElements a) {
		c.setNoSpace().around(a.getLeftCurlyBracketKeyword_1_1());
		c.setNoSpace().before(a.getCommaKeyword_1_2_1_0());
		c.setNoSpace().before(a.getRightCurlyBracketKeyword_1_3());
		c.setIndentation(a.getLeftCurlyBracketKeyword_1_1(), a.getRightCurlyBracketKeyword_1_3());
	}

	protected void configureCollectionTypeCS(FormattingConfig c, CollectionTypeCSElements a) {
		c.setNoSpace().around(a.getLeftParenthesisKeyword_1_0());
		c.setNoSpace().before(a.getRightParenthesisKeyword_1_2());
	}

	protected void configureIfExpCS(FormattingConfig c, IfExpCSElements a) {
		c.setLinewrap().after(a.getConditionAssignment_1());
		c.setLinewrap().after(a.getThenExpressionAssignment_3());
		c.setLinewrap().after(a.getElseExpressionAssignment_5());
		c.setIndentation(a.getIfKeyword_0(), a.getEndifKeyword_6());
	}

	protected void configureLetExpCS(FormattingConfig c, LetExpCSElements a) {
		c.setIndentation(a.getLetKeyword_0(), a.getInKeyword_3());
		c.setLinewrap().before(a.getLetKeyword_0());
		c.setLinewrap().before(a.getInKeyword_3());
		c.setLinewrap().after(a.getInAssignment_4());
	}

	protected void configureNavigatingExpCS(FormattingConfig c, NavigatingExpCSElements a) {
		c.setNoSpace().around(a.getOpFullStopKeyword_1_1_0_0());
		c.setNoSpace().around(a.getOpHyphenMinusGreaterThanSignKeyword_1_1_0_1());
	}

	protected void configureNavigationExpCS(FormattingConfig c, NavigationExpCSElements a) {
		c.setNoSpace().around(a.getOpFullStopKeyword_1_1_0_0());
		c.setNoSpace().around(a.getOpHyphenMinusGreaterThanSignKeyword_1_1_0_1());
	}

	protected void configurePathNameExpCS(FormattingConfig c, PathNameExpCSElements a) {
		c.setNoSpace().around(a.getColonColonKeyword_1());
	}

	protected void configurePreExpCS(FormattingConfig c, PreExpCSElements a) {
		c.setNoSpace().after(a.getCommercialAtKeyword_1());
	}

	protected void configureRoundBracketExpCS(FormattingConfig c, RoundBracketExpCSElements a) {
		c.setNoSpace().around(a.getLeftParenthesisKeyword_2());
		c.setNoSpace().before(a.getCommaKeyword_3_1_0_0());
		c.setNoSpace().before(a.getSemicolonKeyword_3_1_1_0());
		c.setNoSpace().before(a.getCommaKeyword_4_1_0());
		c.setNoSpace().after(a.getCommercialAtKeyword_1_0());
		c.setNoSpace().before(a.getRightParenthesisKeyword_5());
		c.setIndentation(a.getLeftParenthesisKeyword_2(), a.getRightParenthesisKeyword_5());
	}

	protected void configureSquareBracketExpCS(FormattingConfig c, SquareBracketExpCSElements a) {
		c.setNoSpace().around(a.getLeftSquareBracketKeyword_1());
		c.setNoSpace().before(a.getCommaKeyword_3_0());
		c.setNoSpace().before(a.getRightSquareBracketKeyword_4());
		c.setNoSpace().after(a.getCommercialAtKeyword_5_0());
		c.setIndentation(a.getLeftSquareBracketKeyword_1(), a.getRightSquareBracketKeyword_4());
	}

	protected void configureSubNavigationExpCS(FormattingConfig c, SubNavigationExpCSElements a) {
		c.setNoSpace().after(a.getLeftParenthesisKeyword_9_0());
		c.setNoSpace().before(a.getRightParenthesisKeyword_9_3());
		c.setIndentation(a.getLeftParenthesisKeyword_9_0(), a.getRightParenthesisKeyword_9_3());
	}

	protected void configureTupleLiteralExpCS(FormattingConfig c, TupleLiteralExpCSElements a) {
		c.setNoSpace().around(a.getLeftCurlyBracketKeyword_2_0());
		c.setNoSpace().before(a.getCommaKeyword_2_2_0());
		c.setNoSpace().before(a.getRightCurlyBracketKeyword_2_3());
		c.setIndentation(a.getLeftCurlyBracketKeyword_2_0(), a.getRightCurlyBracketKeyword_2_3());
	}

	protected void configureTupleTypeCS(FormattingConfig c, TupleTypeCSElements a) {
		c.setNoSpace().around(a.getLeftParenthesisKeyword_1());
		c.setNoSpace().before(a.getCommaKeyword_2_1_0());
		c.setNoSpace().before(a.getRightParenthesisKeyword_3());
		c.setIndentation(a.getLeftParenthesisKeyword_1(), a.getRightParenthesisKeyword_3());
	}
}

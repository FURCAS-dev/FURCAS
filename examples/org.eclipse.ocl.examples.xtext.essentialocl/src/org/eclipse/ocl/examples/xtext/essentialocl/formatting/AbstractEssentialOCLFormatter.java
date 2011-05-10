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
 * $Id: AbstractEssentialOCLFormatter.java,v 1.4 2011/05/07 16:39:53 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.formatting;

import org.eclipse.ocl.examples.xtext.base.formatting.AbstractBaseFormatter;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.CollectionLiteralExpCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.CollectionTypeCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.IfExpCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.IndexExpCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.LetExpCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.NameExpCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.NavigatingCommaArgCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.NavigatingExpCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.NavigatingSemiArgCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.NavigationOperatorCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.NestedExpCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.TupleLiteralExpCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.TupleTypeCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLGrammarAccess.TypeNameExpCSElements;
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
		c.setNoSpace().around(a.getLeftCurlyBracketKeyword_1());
		c.setNoSpace().before(a.getCommaKeyword_2_1_0());
		c.setNoSpace().before(a.getRightCurlyBracketKeyword_3());
		c.setIndentation(a.getLeftCurlyBracketKeyword_1(), a.getRightCurlyBracketKeyword_3());
	}

	protected void configureCollectionTypeCS(FormattingConfig c, CollectionTypeCSElements a) {
		c.setNoSpace().around(a.getLeftParenthesisKeyword_1_0_0());
		c.setNoSpace().around(a.getLessThanSignKeyword_1_1_0());
		c.setNoSpace().before(a.getRightParenthesisKeyword_1_0_2());
		c.setNoSpace().before(a.getGreaterThanSignKeyword_1_1_2());
	}

	protected void configureIfExpCS(FormattingConfig c, IfExpCSElements a) {
		c.setLinewrap().after(a.getConditionAssignment_1());
		c.setLinewrap().after(a.getThenExpressionAssignment_3());
		c.setLinewrap().after(a.getElseExpressionAssignment_5());
		c.setIndentation(a.getIfKeyword_0(), a.getEndifKeyword_6());
	}

	protected void configureIndexExpCS(FormattingConfig c, IndexExpCSElements a) {
		c.setNoSpace().around(a.getLeftSquareBracketKeyword_1_1());
		c.setNoSpace().after(a.getCommaKeyword_1_3_0());
		c.setNoSpace().before(a.getRightSquareBracketKeyword_1_4());
		c.setNoSpace().around(a.getLeftSquareBracketKeyword_1_5_0());
		c.setNoSpace().after(a.getCommaKeyword_1_5_2_0());
		c.setNoSpace().before(a.getRightSquareBracketKeyword_1_5_3());
	}

	protected void configureLetExpCS(FormattingConfig c, LetExpCSElements a) {
		c.setIndentation(a.getLetKeyword_0(), a.getInKeyword_3());
		c.setLinewrap().before(a.getLetKeyword_0());
		c.setLinewrap().before(a.getInKeyword_3());
		c.setLinewrap().after(a.getInAssignment_4());
	}

	protected void configureNameExpCS(FormattingConfig c, NameExpCSElements a) {
		c.setNoSpace().around(a.getColonColonKeyword_0_0_1());
		c.setNoSpace().around(a.getColonColonKeyword_0_0_2_1());
	}

	protected void configureNavigatingCommaArgCS(FormattingConfig c, NavigatingCommaArgCSElements a) {
		c.setNoSpace().before(a.getPrefixCommaKeyword_0_0());
	}

	protected void configureNavigatingExpCS(FormattingConfig c, NavigatingExpCSElements a) {
		c.setNoSpace().around(a.getLeftParenthesisKeyword_1_1());
		c.setNoSpace().before(a.getRightParenthesisKeyword_1_3());
	}

	protected void configureNavigatingSemiArgCS(FormattingConfig c, NavigatingSemiArgCSElements a) {
		c.setNoSpace().before(a.getPrefixSemicolonKeyword_0_0());
	}

	protected void configureNavigationOperatorCS(FormattingConfig c, NavigationOperatorCSElements a) {
		c.setNoSpace().around(a.getNameAssignment());
	}

//	protected void configureNavigationExpCS(FormattingConfig c, NavigationExpCSElements a) {
//		c.setNoSpace().around(a.getOpFullStopKeyword_1_1_0_0());
//		c.setNoSpace().around(a.getOpHyphenMinusGreaterThanSignKeyword_1_1_0_1());
//	}

	protected void configureNestedExpCS(FormattingConfig c, NestedExpCSElements a) {
		c.setNoSpace().after(a.getLeftParenthesisKeyword_0());
		c.setNoSpace().before(a.getRightParenthesisKeyword_2());
	}

//	protected void configurePathNameExpCS(FormattingConfig c, PathNameExpCSElements a) {
//		c.setNoSpace().around(a.getColonColonKeyword_1());
//	}

//	protected void configurePreExpCS(FormattingConfig c, PreExpCSElements a) {
//		c.setNoSpace().after(a.getCommercialAtKeyword_1());
//	}

/*	protected void configureRoundBracketExpCS(FormattingConfig c, RoundBracketExpCSElements a) {
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
	} */

	protected void configureTupleLiteralExpCS(FormattingConfig c, TupleLiteralExpCSElements a) {
		c.setNoSpace().around(a.getLeftCurlyBracketKeyword_1());
		c.setNoSpace().before(a.getCommaKeyword_3_0());
		c.setNoSpace().before(a.getRightCurlyBracketKeyword_4());
		c.setIndentation(a.getLeftCurlyBracketKeyword_1(), a.getRightCurlyBracketKeyword_4());
	}

	protected void configureTupleTypeCS(FormattingConfig c, TupleTypeCSElements a) {
		c.setNoSpace().around(a.getLeftParenthesisKeyword_1_0_0());
		c.setNoSpace().around(a.getLessThanSignKeyword_1_1_0());
		c.setNoSpace().before(a.getCommaKeyword_1_0_1_1_0());
		c.setNoSpace().before(a.getCommaKeyword_1_1_1_1_0());
		c.setNoSpace().before(a.getRightParenthesisKeyword_1_0_2());
		c.setNoSpace().before(a.getGreaterThanSignKeyword_1_1_2());
		c.setIndentation(a.getLeftParenthesisKeyword_1_0_0(), a.getRightParenthesisKeyword_1_0_2());
		c.setIndentation(a.getLessThanSignKeyword_1_1_0(), a.getGreaterThanSignKeyword_1_1_2());
	}

	protected void configureTypeNameExpCS(FormattingConfig c, TypeNameExpCSElements a) {
		c.setNoSpace().around(a.getColonColonKeyword_0_0_1());
		c.setNoSpace().around(a.getColonColonKeyword_0_0_2_1());
	}
}

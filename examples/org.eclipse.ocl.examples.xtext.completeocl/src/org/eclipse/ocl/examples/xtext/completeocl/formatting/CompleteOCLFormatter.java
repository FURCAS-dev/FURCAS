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
 * $Id: CompleteOCLFormatter.java,v 1.5 2011/02/08 17:53:06 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.formatting;

import org.eclipse.ocl.examples.xtext.completeocl.services.CompleteOCLGrammarAccess;
import org.eclipse.ocl.examples.xtext.completeocl.services.CompleteOCLGrammarAccess.BodyCSElements;
import org.eclipse.ocl.examples.xtext.completeocl.services.CompleteOCLGrammarAccess.ClassifierContextDeclCSElements;
import org.eclipse.ocl.examples.xtext.completeocl.services.CompleteOCLGrammarAccess.DefCSElements;
import org.eclipse.ocl.examples.xtext.completeocl.services.CompleteOCLGrammarAccess.DerCSElements;
import org.eclipse.ocl.examples.xtext.completeocl.services.CompleteOCLGrammarAccess.ImportCSElements;
import org.eclipse.ocl.examples.xtext.completeocl.services.CompleteOCLGrammarAccess.InitCSElements;
import org.eclipse.ocl.examples.xtext.completeocl.services.CompleteOCLGrammarAccess.InvCSElements;
import org.eclipse.ocl.examples.xtext.completeocl.services.CompleteOCLGrammarAccess.OperationContextDeclCSElements;
import org.eclipse.ocl.examples.xtext.completeocl.services.CompleteOCLGrammarAccess.PackageDeclarationCSElements;
import org.eclipse.ocl.examples.xtext.completeocl.services.CompleteOCLGrammarAccess.PostCSElements;
import org.eclipse.ocl.examples.xtext.completeocl.services.CompleteOCLGrammarAccess.PreCSElements;
import org.eclipse.ocl.examples.xtext.completeocl.services.CompleteOCLGrammarAccess.PropertyContextDeclCSElements;
import org.eclipse.ocl.examples.xtext.essentialocl.formatting.AbstractEssentialOCLFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#formatting
 * on how and when to use it 
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
public class CompleteOCLFormatter extends AbstractEssentialOCLFormatter {
	
	@Override
	protected void configureFormatting(FormattingConfig c) {

	    c.setAutoLinewrap(120);

		CompleteOCLGrammarAccess f = (CompleteOCLGrammarAccess) getGrammarAccess();
	    
		configureCollectionLiteralExpCS(c, f.getCollectionLiteralExpCSAccess());
		configureCollectionTypeCS(c, f.getCollectionTypeCSAccess());
		configureIfExpCS(c, f.getIfExpCSAccess());
		configureLetExpCS(c, f.getLetExpCSAccess());
//	    configureNavigationExpCS(c, f.getNavigationExpCSAccess());
	    configureNavigatingExpCS(c, f.getNavigatingExpCSAccess());
//		configurePathNameExpCS(c, f.getPathNameExpCSAccess());
//		configurePreExpCS(c, f.getPreExpCSAccess());
//	    configureRoundBracketExpCS(c, f.getRoundBracketExpCSAccess());
//	    configureSquareBracketExpCS(c, f.getSquareBracketExpCSAccess());
//		configureSubNavigationExpCS(c, f.getSubNavigationExpCSAccess());
	    configureTupleLiteralExpCS(c, f.getTupleLiteralExpCSAccess());
	    configureTupleTypeCS(c, f.getTupleTypeCSAccess());

	    {
			BodyCSElements a = f.getBodyCSAccess();
		    c.setLinewrap(2).before(a.getBodyKeyword_0());
			setNoSpaceLineWrap(c, a.getColonKeyword_2());
		    c.setIndentation(a.getOwnedExpressionAssignment_3(), a.getOwnedExpressionAssignment_3());
		    c.setLinewrap(2).after(a.getOwnedExpressionAssignment_3());
	    }
	    {
			ClassifierContextDeclCSElements a = f.getClassifierContextDeclCSAccess();
		    c.setLinewrap(2).before(a.getContextKeyword_0());
		    c.setNoSpace().around(a.getColonColonKeyword_2_1());
		    c.setLinewrap(2).after(a.getClassifierAssignment_3());
	    }
	    {
			DefCSElements a = f.getDefCSAccess();
		    c.setLinewrap(2).before(a.getStereotypeDefKeyword_1_0());
		    c.setNoSpace().before(a.getColonKeyword_3());
		    c.setNoSpace().around(a.getLeftParenthesisKeyword_5_0());
		    c.setNoSpace().before(a.getCommaKeyword_5_1_1_0());
		    c.setNoSpace().before(a.getRightParenthesisKeyword_5_2());
			setNoSpaceLineWrap(c, a.getColonKeyword_6());
//		    c.setIndentation(a.getExpressionAssignment_9(), a.getExpressionAssignment_9());
		    c.setLinewrap(2).after(a.getOwnedExpressionAssignment_9());
	    }
	    {
			DerCSElements a = f.getDerCSAccess();
//		    c.setLinewrap(2).before(a.getDeriveKeyword_0());
			setNoSpaceLineWrap(c, a.getColonKeyword_1());
//		    c.setIndentation(a.getExpressionAssignment_2(), a.getExpressionAssignment_2());
		    c.setLinewrap(2).after(a.getOwnedExpressionAssignment_2());
	    }
	    {
			ImportCSElements a = f.getImportCSAccess();
		    c.setLinewrap().after(a.getNamespaceAssignment_2());
	    }
	    {
			InitCSElements a = f.getInitCSAccess();
//		    c.setLinewrap(2).before(a.getInitKeyword_0());
			setNoSpaceLineWrap(c, a.getColonKeyword_1());
//		    c.setIndentation(a.getExpressionAssignment_2(), a.getExpressionAssignment_2());
		    c.setLinewrap(2).after(a.getOwnedExpressionAssignment_2());
	    }
	    {
			InvCSElements a = f.getInvCSAccess();
//		    c.setLinewrap(2).before(a.getInvKeyword_0());
			setNoSpaceLineWrap(c, a.getColonKeyword_2());
//		    c.setIndentation(a.getExpressionAssignment_3(), a.getExpressionAssignment_3());
		    c.setLinewrap(2).after(a.getOwnedExpressionAssignment_3());
	    }
	    {
			OperationContextDeclCSElements a = f.getOperationContextDeclCSAccess();
		    c.setLinewrap(2).before(a.getContextKeyword_0());
		    c.setNoSpace().around(a.getColonColonKeyword_1_1());
			c.setNoSpace().around(a.getLeftParenthesisKeyword_3());
			c.setNoSpace().before(a.getCommaKeyword_4_1_0());
			c.setNoSpace().before(a.getRightParenthesisKeyword_5());
		    c.setLinewrap(2).after(a.getOwnedTypeAssignment_7());
		    c.setIndentation(a.getLeftParenthesisKeyword_3(), a.getRightParenthesisKeyword_5());
	    }
	    {
	    	PackageDeclarationCSElements a = f.getPackageDeclarationCSAccess();
		    c.setLinewrap(2).before(a.getPackageKeyword_0());
		    c.setNoSpace().around(a.getColonColonKeyword_1_1());
		    c.setLinewrap(2).after(a.getPackageAssignment_2());
		    c.setLinewrap(2).before(a.getEndpackageKeyword_4());
		    c.setLinewrap(2).after(a.getEndpackageKeyword_4());
	    }
	    {
			PostCSElements a = f.getPostCSAccess();
//		    c.setLinewrap(2).before(a.getPostKeyword_0());
			setNoSpaceLineWrap(c, a.getColonKeyword_2());
//		    c.setIndentation(a.getColonKeyword_2(), a.getExpressionAssignment_3());
		    c.setLinewrap(2).after(a.getOwnedExpressionAssignment_3());
	    }
	    {
			PreCSElements a = f.getPreCSAccess();
//		    c.setLinewrap(2).before(a.getPreKeyword_0());
			setNoSpaceLineWrap(c, a.getColonKeyword_2());
//		    c.setIndentation(a.getColonKeyword_2(), a.getExpressionAssignment_3());
		    c.setLinewrap(2).after(a.getOwnedExpressionAssignment_3());
	    }
	    {
	    	PropertyContextDeclCSElements a = f.getPropertyContextDeclCSAccess();
		    c.setLinewrap(2).before(a.getContextKeyword_0());
		    c.setNoSpace().around(a.getColonColonKeyword_1_1());
		    c.setLinewrap(2).after(a.getOwnedTypeAssignment_4());
	    }
	    {	// comments
	    	c.setNoLinewrap().before(f.getSL_COMMENTRule());
	    }
	}

//	protected void configureNavigatingExpCS(FormattingConfig c, NavigatingExpCSElements a) {
//	    c.setNoSpace().around(a.getOpFullStopKeyword_1_0_1_0_0());
//	    c.setNoSpace().around(a.getOpHyphenMinusGreaterThanSignKeyword_1_0_1_0_1());
//	}

//	protected void configureNavigationExpCS(FormattingConfig c, NavigationExpCSElements a) {
//	    c.setNoSpace().around(a.getOpFullStopKeyword_1_0_1_0_0());
//	    c.setNoSpace().around(a.getOpHyphenMinusGreaterThanSignKeyword_1_0_1_0_1());
//	}
}

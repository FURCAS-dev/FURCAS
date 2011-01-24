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
 * $Id: OCLinEcoreFormatter.java,v 1.6 2011/01/24 22:28:40 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.formatting;

import org.eclipse.ocl.examples.xtext.essentialocl.formatting.AbstractEssentialOCLFormatter;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.AnnotationCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.AttributeCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.BodyConstraintCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.ClassCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.DataTypeCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.DerivedConstraintCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.DocumentationCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.EnumerationCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.EnumerationLiteralCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.ImportCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.InitialConstraintCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.InvariantConstraintCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.OperationCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.ParameterCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.PostconditionConstraintCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.PreconditionConstraintCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.QualifiedTypeRefCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.ReferenceCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.TemplateSignatureCSElements;
import org.eclipse.xtext.formatting.impl.FormattingConfig;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#formatting
 * on how and when to use it 
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
public class OCLinEcoreFormatter extends AbstractEssentialOCLFormatter {
	
	@Override
	protected void configureFormatting(FormattingConfig c) {

	    c.setAutoLinewrap(120);

	    OCLinEcoreGrammarAccess f = getGrammarAccess();
	    
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

	    c.setLinewrap(1).after(f.getRootPackageCSAccess().getNameAssignment_0_1());

	    c.setLinewrap(2).between(f.getImportCSRule(), f.getPackageCSRule());
	    c.setLinewrap(2).between(f.getClassCSRule(), f.getClassCSRule());
	    c.setLinewrap(2).between(f.getClassCSRule(), f.getDataTypeCSRule());
	    c.setLinewrap(2).between(f.getClassCSRule(), f.getEnumerationCSRule());
	    c.setLinewrap(2).between(f.getDataTypeCSRule(), f.getClassCSRule());
	    c.setLinewrap(2).between(f.getDataTypeCSRule(), f.getDataTypeCSRule());
	    c.setLinewrap(2).between(f.getDataTypeCSRule(), f.getEnumerationCSRule());
	    c.setLinewrap(2).between(f.getEnumerationCSRule(), f.getClassCSRule());
	    c.setLinewrap(2).between(f.getEnumerationCSRule(), f.getDataTypeCSRule());
	    c.setLinewrap(2).between(f.getEnumerationCSRule(), f.getEnumerationCSRule());

	    {	// AnnotationCS
			AnnotationCSElements a = f.getAnnotationCSAccess();
			setBraces(c, a.getLeftParenthesisKeyword_2_0(), a.getRightParenthesisKeyword_2_3());
//			setNoSpaceLineWrap(c, a.getLeftParenthesisKeyword_2_0());
			setNoSpaceLineWrap(c, a.getCommaKeyword_2_2_0());
//			c.setNoSpace().before(a.getRightParenthesisKeyword_2_3());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_3_1());
			setBraces(c, a.getLeftCurlyBracketKeyword_3_0_0(), a.getRightCurlyBracketKeyword_3_0_2());
//		    c.setIndentation(a.getLeftParenthesisKeyword_2_0(), a.getRightParenthesisKeyword_2_3());
	    }		
	    {	// AttributeCS
			AttributeCSElements a = f.getAttributeCSAccess();
			c.setNoSpace().around(a.getLeftSquareBracketKeyword_3_2_0());	
			c.setNoSpace().around(a.getFullStopFullStopKeyword_3_2_1_0_1_0());
			c.setNoSpace().before(a.getRightSquareBracketKeyword_3_2_2());	
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_5_0(), a.getRightCurlyBracketKeyword_5_2());
			c.setNoSpace().around(a.getCommaKeyword_5_1_1());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_6_1());
			setBraces(c, a.getLeftCurlyBracketKeyword_6_0_0(), a.getRightCurlyBracketKeyword_6_0_2());
		    c.setIndentation(a.getLeftSquareBracketKeyword_3_2_0(), a.getRightSquareBracketKeyword_3_2_2());
	    }
	    {
	    	BodyConstraintCSElements a = f.getBodyConstraintCSAccess();
	    	c.setNoSpace().before(a.getColonKeyword_2());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_4());
	    }
	    {
			ClassCSElements a = f.getClassCSAccess();
			c.setNoSpace().around(a.getCommaKeyword_4_2_0());
				c.setNoSpace().between(a.getLeftCurlyBracketKeyword_6_0(), a.getRightCurlyBracketKeyword_6_2());
			setBraces(c, a.getLeftCurlyBracketKeyword_7_0_0(), a.getRightCurlyBracketKeyword_7_0_2());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_7_1());
	    }
	    {
			DataTypeCSElements a = f.getDataTypeCSAccess();
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_4_0(), a.getRightCurlyBracketKeyword_4_2());
			setBraces(c, a.getLeftCurlyBracketKeyword_5_0_0(), a.getRightCurlyBracketKeyword_5_0_2());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_5_1());
	    }
	    {
	    	DerivedConstraintCSElements a = f.getDerivedConstraintCSAccess();
			c.setNoSpace().before(a.getColonKeyword_1());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_3());
	    }
	    {
	    	DocumentationCSElements a = f.getDocumentationCSAccess();
			c.setNoSpace().around(a.getLeftParenthesisKeyword_3_0());	
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_4());
			c.setNoSpace().before(a.getRightParenthesisKeyword_3_3());	
		    c.setIndentation(a.getLeftParenthesisKeyword_3_0(), a.getRightParenthesisKeyword_3_3());
	    }
	    {
			EnumerationCSElements a = f.getEnumerationCSAccess();
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_4_0(), a.getRightCurlyBracketKeyword_4_2());
//			setBraces(c, a.getLeftCurlyBracketKeyword_4_0(), a.getRightCurlyBracketKeyword_4_2());
			setBraces(c, a.getLeftCurlyBracketKeyword_5_0_0(), a.getRightCurlyBracketKeyword_5_0_2());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_5_1());
	    }
	    {
	    	EnumerationLiteralCSElements a = f.getEnumerationLiteralCSAccess();
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_2_1());
	    }
	    {
	    	ImportCSElements a = f.getImportCSAccess();
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_3());
	    }
	    {
	    	InitialConstraintCSElements a = f.getInitialConstraintCSAccess();
			c.setNoSpace().before(a.getColonKeyword_1());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_3());
	    }
	    {
			InvariantConstraintCSElements a = f.getInvariantConstraintCSAccess();
			c.setNoSpace().before(a.getColonKeyword_2());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_4());
	    }
	    {
			OperationCSElements a = f.getOperationCSAccess();
			c.setNoSpace().around(a.getLeftParenthesisKeyword_4());	
			c.setNoSpace().before(a.getCommaKeyword_5_1_0());
			c.setNoSpace().before(a.getRightParenthesisKeyword_6());	
			c.setNoSpace().around(a.getLeftSquareBracketKeyword_7_2_0());	
			c.setNoSpace().around(a.getFullStopFullStopKeyword_7_2_1_0_1_0());
			c.setNoSpace().before(a.getRightSquareBracketKeyword_7_2_2());	
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_9_0(), a.getRightCurlyBracketKeyword_9_2());
			c.setNoSpace().around(a.getCommaKeyword_9_1_1());
			setBraces(c, a.getLeftCurlyBracketKeyword_10_0_0(), a.getRightCurlyBracketKeyword_10_0_2());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_10_1());
		    c.setIndentation(a.getLeftParenthesisKeyword_4(), a.getRightParenthesisKeyword_6());
	    }
	    {
	    	setBraces(c, f.getPackageCSAccess().getLeftCurlyBracketKeyword_3_0_0(), f.getPackageCSAccess().getRightCurlyBracketKeyword_3_0_2());
	    }
	    {
	    	PostconditionConstraintCSElements a = f.getPostconditionConstraintCSAccess();
			c.setNoSpace().before(a.getColonKeyword_2());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_4());
	    }
	    {
	    	PreconditionConstraintCSElements a = f.getPreconditionConstraintCSAccess();
			c.setNoSpace().before(a.getColonKeyword_2());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_4());
	    }
	    {
			ReferenceCSElements a = f.getReferenceCSAccess();
			c.setNoSpace().around(a.getNumberSignKeyword_3_0());
			c.setNoSpace().around(a.getLeftSquareBracketKeyword_4_2_0());	
			c.setNoSpace().around(a.getFullStopFullStopKeyword_4_2_1_0_1_0());
			c.setNoSpace().before(a.getRightSquareBracketKeyword_4_2_2());	
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_6_0(), a.getRightCurlyBracketKeyword_6_2());
			c.setNoSpace().around(a.getCommaKeyword_6_1_1());
			setBraces(c, a.getLeftCurlyBracketKeyword_7_0_0(), a.getRightCurlyBracketKeyword_7_0_2());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_7_1());
		    c.setIndentation(a.getLeftSquareBracketKeyword_4_2_0(), a.getRightSquareBracketKeyword_4_2_2());
	    }
	    {
			ParameterCSElements a = f.getParameterCSAccess();
			c.setNoSpace().around(a.getLeftSquareBracketKeyword_1_2_0());	
			c.setNoSpace().around(a.getFullStopFullStopKeyword_1_2_1_0_1_0());
			c.setNoSpace().before(a.getRightSquareBracketKeyword_1_2_2());	
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_2_0(), a.getRightCurlyBracketKeyword_2_2());
			c.setNoSpace().around(a.getCommaKeyword_2_1_1());
			setBraces(c, a.getLeftCurlyBracketKeyword_3_0(), a.getRightCurlyBracketKeyword_3_2());
		    c.setIndentation(a.getLeftSquareBracketKeyword_1_2_0(), a.getRightSquareBracketKeyword_1_2_2());
	    }
	    {
	    	QualifiedTypeRefCSElements a = f.getQualifiedTypeRefCSAccess();
		    c.setNoSpace().around(a.getColonColonKeyword_2());
	    }
	    {
			TemplateSignatureCSElements a = f.getTemplateSignatureCSAccess();
			c.setNoSpace().around(a.getLessThanSignKeyword_0());	
			c.setNoSpace().before(a.getCommaKeyword_2_0());
			c.setNoSpace().before(a.getGreaterThanSignKeyword_3());	
		    c.setIndentation(a.getLessThanSignKeyword_0(), a.getGreaterThanSignKeyword_3());
	    }
	    {	// comments
	    	c.setNoLinewrap().before(f.getSL_COMMENTRule());
	    }
	}

	@Override
	public OCLinEcoreGrammarAccess getGrammarAccess() {
		return (OCLinEcoreGrammarAccess) super.getGrammarAccess();
	}
}

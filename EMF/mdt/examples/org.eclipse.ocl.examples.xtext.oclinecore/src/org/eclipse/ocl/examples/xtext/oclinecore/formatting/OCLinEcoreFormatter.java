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
 * $Id: OCLinEcoreFormatter.java,v 1.4 2010/05/23 10:27:35 ewillink Exp $
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
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.EnumCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.EnumLiteralCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.ImportCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.InitialConstraintCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.InvariantConstraintCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.OperationCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.ParameterCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.PostconditionConstraintCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.PreconditionConstraintCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.QualifiedTypeRefCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.ReferenceCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.TypedTypeRefCSElements;
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
	    configureNavigationExpCS(c, f.getNavigationExpCSAccess());
	    configureNavigatingExpCS(c, f.getNavigatingExpCSAccess());
		configurePathNameExpCS(c, f.getPathNameExpCSAccess());
		configurePreExpCS(c, f.getPreExpCSAccess());
	    configureRoundBracketExpCS(c, f.getRoundBracketExpCSAccess());
	    configureSquareBracketExpCS(c, f.getSquareBracketExpCSAccess());
		configureSubNavigationExpCS(c, f.getSubNavigationExpCSAccess());
	    configureTupleLiteralExpCS(c, f.getTupleLiteralExpCSAccess());
	    configureTupleTypeCS(c, f.getTupleTypeCSAccess());

	    c.setLinewrap(2).between(f.getImportCSRule(), f.getPackageCSRule());
	    c.setLinewrap(2).between(f.getClassCSRule(), f.getClassCSRule());
	    c.setLinewrap(2).between(f.getClassCSRule(), f.getDataTypeCSRule());
	    c.setLinewrap(2).between(f.getClassCSRule(), f.getEnumCSRule());
	    c.setLinewrap(2).between(f.getDataTypeCSRule(), f.getClassCSRule());
	    c.setLinewrap(2).between(f.getDataTypeCSRule(), f.getDataTypeCSRule());
	    c.setLinewrap(2).between(f.getDataTypeCSRule(), f.getEnumCSRule());
	    c.setLinewrap(2).between(f.getEnumCSRule(), f.getClassCSRule());
	    c.setLinewrap(2).between(f.getEnumCSRule(), f.getDataTypeCSRule());
	    c.setLinewrap(2).between(f.getEnumCSRule(), f.getEnumCSRule());

	    {	// AnnotationCS
			AnnotationCSElements a = f.getAnnotationCSAccess();
			c.setNoSpace().around(a.getLeftParenthesisKeyword_2_0());
			c.setNoSpace().before(a.getCommaKeyword_2_2_0());
			c.setNoSpace().before(a.getRightParenthesisKeyword_2_3());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_3_1());
			setBraces(c, a.getLeftCurlyBracketKeyword_3_0_0(), a.getRightCurlyBracketKeyword_3_0_2());
		    c.setIndentation(a.getLeftParenthesisKeyword_2_0(), a.getRightParenthesisKeyword_2_3());
	    }		
	    {	// AttributeCS
			AttributeCSElements a = f.getAttributeCSAccess();
			c.setNoSpace().around(a.getLeftSquareBracketKeyword_4_2_0());	
			c.setNoSpace().around(a.getFullStopFullStopKeyword_4_2_1_0_1_0());
			c.setNoSpace().before(a.getRightSquareBracketKeyword_4_2_2());	
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_6_0(), a.getRightCurlyBracketKeyword_6_3());
			c.setNoSpace().around(a.getCommaKeyword_6_2_0());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_7_1());
			setBraces(c, a.getLeftCurlyBracketKeyword_7_0_0(), a.getRightCurlyBracketKeyword_7_0_2());
		    c.setIndentation(a.getLeftSquareBracketKeyword_4_2_0(), a.getRightSquareBracketKeyword_4_2_2());
	    }
	    {
	    	BodyConstraintCSElements a = f.getBodyConstraintCSAccess();
	    	c.setNoSpace().before(a.getColonKeyword_2());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_4());
	    }
	    {
			ClassCSElements a = f.getClassCSAccess();
			c.setNoSpace().around(a.getLessThanSignKeyword_2_0());	
			c.setNoSpace().before(a.getCommaKeyword_3_2_0());
			c.setNoSpace().before(a.getGreaterThanSignKeyword_2_3());	
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_5_0(), a.getRightCurlyBracketKeyword_5_3());
			c.setNoSpace().around(a.getCommaKeyword_5_2_0());
			setBraces(c, a.getLeftCurlyBracketKeyword_6_0_0(), a.getRightCurlyBracketKeyword_6_0_2());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_6_1());
		    c.setIndentation(a.getLessThanSignKeyword_2_0(), a.getGreaterThanSignKeyword_2_3());
	    }
	    {
			DataTypeCSElements a = f.getDataTypeCSAccess();
			c.setNoSpace().around(a.getLessThanSignKeyword_2_0());	
			c.setNoSpace().before(a.getCommaKeyword_2_2_0());
			c.setNoSpace().before(a.getGreaterThanSignKeyword_2_3());	
			setBraces(c, a.getLeftCurlyBracketKeyword_5_0_0(), a.getRightCurlyBracketKeyword_5_0_2());
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_4_0(), a.getRightCurlyBracketKeyword_4_2());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_5_1());
		    c.setIndentation(a.getLessThanSignKeyword_2_0(), a.getGreaterThanSignKeyword_2_3());
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
			EnumCSElements a = f.getEnumCSAccess();
			c.setNoSpace().around(a.getLessThanSignKeyword_2_0());	
			c.setNoSpace().before(a.getCommaKeyword_2_2_0());
			c.setNoSpace().before(a.getGreaterThanSignKeyword_2_3());	
			setBraces(c, a.getLeftCurlyBracketKeyword_4_0_0(), a.getRightCurlyBracketKeyword_4_0_2());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_4_1());
		    c.setIndentation(a.getLessThanSignKeyword_2_0(), a.getGreaterThanSignKeyword_2_3());
	    }
	    {
	    	EnumLiteralCSElements a = f.getEnumLiteralCSAccess();
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
			c.setNoSpace().around(a.getGreaterThanSignKeyword_4_3());	
			c.setNoSpace().before(a.getCommaKeyword_4_2_0());
			c.setNoSpace().before(a.getGreaterThanSignKeyword_4_3());	
			c.setNoSpace().around(a.getLeftParenthesisKeyword_5());	
			c.setNoSpace().before(a.getCommaKeyword_6_1_0());
			c.setNoSpace().before(a.getRightParenthesisKeyword_7());	
			c.setNoSpace().around(a.getLeftSquareBracketKeyword_8_2_0());	
			c.setNoSpace().around(a.getFullStopFullStopKeyword_8_2_1_0_1_0());
			c.setNoSpace().before(a.getRightSquareBracketKeyword_8_2_2());	
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_10_0(), a.getRightCurlyBracketKeyword_10_3());
			c.setNoSpace().around(a.getCommaKeyword_10_2_0());
			setBraces(c, a.getLeftCurlyBracketKeyword_11_0_0(), a.getRightCurlyBracketKeyword_11_0_2());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_11_1());
		    c.setIndentation(a.getLeftParenthesisKeyword_5(), a.getRightParenthesisKeyword_7());
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
			c.setNoSpace().around(a.getNumberSignKeyword_4_0());
			c.setNoSpace().around(a.getLeftSquareBracketKeyword_5_2_0());	
			c.setNoSpace().around(a.getFullStopFullStopKeyword_5_2_1_0_1_0());
			c.setNoSpace().before(a.getRightSquareBracketKeyword_5_2_2());	
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_7_0(), a.getRightCurlyBracketKeyword_7_3());
			c.setNoSpace().around(a.getCommaKeyword_7_2_0());
			setBraces(c, a.getLeftCurlyBracketKeyword_8_0_0(), a.getRightCurlyBracketKeyword_8_0_2());
			setNoSpaceLineWrap(c, a.getSemicolonKeyword_8_1());
		    c.setIndentation(a.getLeftSquareBracketKeyword_5_2_0(), a.getRightSquareBracketKeyword_5_2_2());
	    }
	    {
			ParameterCSElements a = f.getParameterCSAccess();
			c.setNoSpace().around(a.getLeftSquareBracketKeyword_1_2_0());	
			c.setNoSpace().around(a.getFullStopFullStopKeyword_1_2_1_0_1_0());
			c.setNoSpace().before(a.getRightSquareBracketKeyword_1_2_2());	
			c.setNoSpace().between(a.getLeftCurlyBracketKeyword_2_0(), a.getRightCurlyBracketKeyword_2_3());
			c.setNoSpace().around(a.getCommaKeyword_2_2_0());
			setBraces(c, a.getLeftCurlyBracketKeyword_3_0(), a.getRightCurlyBracketKeyword_3_2());
		    c.setIndentation(a.getLeftSquareBracketKeyword_1_2_0(), a.getRightSquareBracketKeyword_1_2_2());
	    }
	    {
	    	QualifiedTypeRefCSElements a = f.getQualifiedTypeRefCSAccess();
		    c.setNoSpace().around(a.getColonColonKeyword_2());
	    }
	    {
			TypedTypeRefCSElements a = f.getTypedTypeRefCSAccess();
			c.setNoSpace().around(a.getLessThanSignKeyword_1_0());	
			c.setNoSpace().before(a.getGreaterThanSignKeyword_1_3());	
			c.setNoSpace().around(a.getCommaKeyword_1_2_0());
		    c.setIndentation(a.getLessThanSignKeyword_1_0(), a.getGreaterThanSignKeyword_1_3());
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

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
 * $Id: OCLinEcoreFormatter.java,v 1.1 2010/04/13 06:44:12 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.formatting;

import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#formatting
 * on how and when to use it 
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
public class OCLinEcoreFormatter extends AbstractDeclarativeFormatter {
	
	@Override
	protected void configureFormatting(FormattingConfig c) {
		OCLinEcoreGrammarAccess f = (OCLinEcoreGrammarAccess) getGrammarAccess();

	    c.setAutoLinewrap(120);

//	    c.setLinewrap().between(f.getEDataTypeCSRule(), f.getEClassCSRule());

	    // AnnotationCS
	    c.setLinewrap().before(f.getAnnotationCSAccess().getCommercialAtKeyword_0());
	    c.setNoSpace().after(f.getAnnotationCSAccess().getCommercialAtKeyword_0());
		setParentheses(c, f.getAnnotationCSAccess().getLeftParenthesisKeyword_2_0(), f.getAnnotationCSAccess().getRightParenthesisKeyword_2_3());
		setComma(c, f.getAnnotationCSAccess().getCommaKeyword_2_2_0());
	    c.setLinewrap().after(f.getAnnotationCSAccess().getRightParenthesisKeyword_2_3());
		
	    // AttributeCS
		setSquareBrackets(c, f.getAttributeCSAccess().getLeftSquareBracketKeyword_4_2_0(), f.getAttributeCSAccess().getRightSquareBracketKeyword_4_2_2());	
		setSemiColon(c, f.getAttributeCSAccess().getSemicolonKeyword_6_1());
		setBraces(c, f.getAttributeCSAccess().getLeftCurlyBracketKeyword_6_0_0(), f.getAttributeCSAccess().getRightCurlyBracketKeyword_6_0_2());

	    // ClassCS
		setSquareBrackets(c, f.getClassCSAccess().getLessThanSignKeyword_4_0(), f.getClassCSAccess().getGreaterThanSignKeyword_4_3());	
		setComma(c, f.getClassCSAccess().getCommaKeyword_4_2_0());
		setBraces(c, f.getClassCSAccess().getLeftCurlyBracketKeyword_7_0_0(), f.getClassCSAccess().getRightCurlyBracketKeyword_7_0_2());
		setSemiColon(c, f.getClassCSAccess().getSemicolonKeyword_7_1());

	    // BodyConstraintCS
		setSemiColon(c, f.getBodyConstraintCSAccess().getSemicolonKeyword_4());

	    // DataTypeCS
		setSquareBrackets(c, f.getDataTypeCSAccess().getLessThanSignKeyword_4_0(), f.getDataTypeCSAccess().getGreaterThanSignKeyword_4_3());	
		setComma(c, f.getDataTypeCSAccess().getCommaKeyword_4_2_0());
		setBraces(c, f.getDataTypeCSAccess().getLeftCurlyBracketKeyword_6_0_0(), f.getDataTypeCSAccess().getRightCurlyBracketKeyword_6_0_2());
		setSemiColon(c, f.getDataTypeCSAccess().getSemicolonKeyword_6_1());

	    // DerivedConstraintCS
		setSemiColon(c, f.getDerivedConstraintCSAccess().getSemicolonKeyword_3());

	    // EClassifierCSRef
		setNoSpacePunctuation(c, f.getEClassifierCSRefAccess().getColonColonKeyword_1());

	    // EnumCS
		setSquareBrackets(c, f.getEnumCSAccess().getLessThanSignKeyword_3_0(), f.getEnumCSAccess().getGreaterThanSignKeyword_3_3());	
		setComma(c, f.getEnumCSAccess().getCommaKeyword_3_2_0());
		setBraces(c, f.getEnumCSAccess().getLeftCurlyBracketKeyword_5_0_0(), f.getEnumCSAccess().getRightCurlyBracketKeyword_5_0_2());
		setSemiColon(c, f.getEnumCSAccess().getSemicolonKeyword_5_1());

	    // EnumLiteralCS
		setSemiColon(c, f.getEnumLiteralCSAccess().getSemicolonKeyword_3());

	    // ImportCS
		setSemiColon(c, f.getImportCSAccess().getSemicolonKeyword_3());

	    // InitialConstraintCS
		setSemiColon(c, f.getInitialConstraintCSAccess().getSemicolonKeyword_3());

	    // InvariantConstraintCS
		setSemiColon(c, f.getInvariantConstraintCSAccess().getSemicolonKeyword_4());
		
	    // OperationCS
		setSquareBrackets(c, f.getOperationCSAccess().getLessThanSignKeyword_4_0(), f.getOperationCSAccess().getGreaterThanSignKeyword_4_3());	
		setComma(c, f.getOperationCSAccess().getCommaKeyword_4_2_0());
		setParentheses(c, f.getOperationCSAccess().getLeftParenthesisKeyword_5(), f.getOperationCSAccess().getRightParenthesisKeyword_7());	
		setComma(c, f.getOperationCSAccess().getCommaKeyword_6_1_0());
		setSquareBrackets(c, f.getOperationCSAccess().getLeftSquareBracketKeyword_8_2_0(), f.getOperationCSAccess().getRightSquareBracketKeyword_8_2_2());	
		setBraces(c, f.getOperationCSAccess().getLeftCurlyBracketKeyword_9_0_0(), f.getOperationCSAccess().getRightCurlyBracketKeyword_9_0_2());
		setSemiColon(c, f.getOperationCSAccess().getSemicolonKeyword_9_1());

	    // PackageCS
		setBraces(c, f.getPackageCSAccess().getLeftCurlyBracketKeyword_3(), f.getPackageCSAccess().getRightCurlyBracketKeyword_5());

	    // PostconditionConstraintCS
		setSemiColon(c, f.getPostconditionConstraintCSAccess().getSemicolonKeyword_4());

	    // PreconditionConstraintCS
		setSemiColon(c, f.getPreconditionConstraintCSAccess().getSemicolonKeyword_4());
		
	    // ReferenceCS
		setSquareBrackets(c, f.getReferenceCSAccess().getLeftSquareBracketKeyword_5_2_0(), f.getReferenceCSAccess().getRightSquareBracketKeyword_5_2_2());	
		setNoSpacePunctuation(c, f.getReferenceCSAccess().getNumberSignKeyword_4_0());
		setBraces(c, f.getReferenceCSAccess().getLeftCurlyBracketKeyword_7_0_0(), f.getReferenceCSAccess().getRightCurlyBracketKeyword_7_0_2());
		setSemiColon(c, f.getReferenceCSAccess().getSemicolonKeyword_7_1());
		
	    // ParameterCS
		setSquareBrackets(c, f.getParameterCSAccess().getLeftSquareBracketKeyword_3_2_0(), f.getParameterCSAccess().getRightSquareBracketKeyword_3_2_2());	
		
	    // TypedTypeRefCS
		setSquareBrackets(c, f.getTypedTypeRefCSAccess().getLessThanSignKeyword_1_0(), f.getTypedTypeRefCSAccess().getGreaterThanSignKeyword_1_3());	
		setNoSpacePunctuation(c, f.getTypedTypeRefCSAccess().getCommaKeyword_1_2_0());
	    
	    // comments
	    c.setNoLinewrap().before(f.getSL_COMMENTRule());
	}

	public void setBraces(FormattingConfig c, Keyword leftBrace, Keyword rightBrace) {
		c.setIndentation(leftBrace, rightBrace);
	    c.setLinewrap().before(leftBrace);
	    c.setLinewrap().after(leftBrace);
	    c.setLinewrap().before(rightBrace);
	    c.setLinewrap().after(rightBrace);
	}

	public void setComma(FormattingConfig c, Keyword comma) {
		c.setNoSpace().before(comma);
	}

	public void setNoSpacePunctuation(FormattingConfig c, Keyword keyword) {
		c.setNoSpace().before(keyword);
		c.setNoSpace().after(keyword);
	}

	public void setParentheses(FormattingConfig c, Keyword leftParenthesis, Keyword rightParenthesis) {
		c.setNoSpace().before(leftParenthesis);
	    c.setNoSpace().after(leftParenthesis);
		c.setNoSpace().before(rightParenthesis);
	}

	public void setSemiColon(FormattingConfig c, Keyword semicolon) {
		c.setNoSpace().before(semicolon);
	    c.setLinewrap().after(semicolon);
	}

	public void setSquareBrackets(FormattingConfig c, Keyword leftSquareBracket, Keyword rightSquareBracket) {
		c.setNoSpace().before(leftSquareBracket);
	    c.setNoSpace().after(leftSquareBracket);
		c.setNoSpace().before(rightSquareBracket);
	}
}

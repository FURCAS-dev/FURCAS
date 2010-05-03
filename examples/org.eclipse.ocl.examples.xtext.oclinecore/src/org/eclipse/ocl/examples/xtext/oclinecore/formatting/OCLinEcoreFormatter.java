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
 * $Id: OCLinEcoreFormatter.java,v 1.3 2010/05/03 05:44:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.formatting;

import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.AnnotationCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.AttributeCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.ClassCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.DataTypeCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.DocumentationCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.EnumCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.InvariantConstraintCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.OperationCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.ParameterCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.ReferenceCSElements;
import org.eclipse.ocl.examples.xtext.oclinecore.services.OCLinEcoreGrammarAccess.TypedTypeRefCSElements;
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
		OCLinEcoreGrammarAccess f = getGrammarAccess();

	    c.setAutoLinewrap(120);

//	    c.setLinewrap().between(f.getEDataTypeCSRule(), f.getEClassCSRule());

	    {	// AnnotationCS
			AnnotationCSElements a = f.getAnnotationCSAccess();
			setParentheses(c, a.getLeftParenthesisKeyword_2_0(), a.getRightParenthesisKeyword_2_3());
			setComma(c, a.getCommaKeyword_2_2_0());
			setSemiColon(c, a.getSemicolonKeyword_3_1());
			setBraces(c, a.getLeftCurlyBracketKeyword_3_0_0(), a.getRightCurlyBracketKeyword_3_0_2());
	    }		
	    {	// AttributeCS
			AttributeCSElements a = f.getAttributeCSAccess();
			setSquareBrackets(c, a.getLeftSquareBracketKeyword_4_2_0(), a.getRightSquareBracketKeyword_4_2_2());	
			setNoSpacePunctuation(c, a.getFullStopFullStopKeyword_4_2_1_0_1_0());
			setNoInternalSpacePunctuation(c, a.getLeftCurlyBracketKeyword_6_0(), a.getRightCurlyBracketKeyword_6_3());
			setNoSpacePunctuation(c, a.getCommaKeyword_6_2_0());
			setSemiColon(c, a.getSemicolonKeyword_7_1());
			setBraces(c, a.getLeftCurlyBracketKeyword_7_0_0(), a.getRightCurlyBracketKeyword_7_0_2());
	    }
	    {	// ClassCS
			ClassCSElements a = f.getClassCSAccess();
			setSquareBrackets(c, a.getLessThanSignKeyword_2_0(), a.getGreaterThanSignKeyword_2_3());	
			setComma(c, a.getCommaKeyword_3_2_0());
			setNoInternalSpacePunctuation(c, a.getLeftCurlyBracketKeyword_5_0(), a.getRightCurlyBracketKeyword_5_3());
			setNoSpacePunctuation(c, a.getCommaKeyword_5_2_0());
			setBraces(c, a.getLeftCurlyBracketKeyword_6_0_0(), a.getRightCurlyBracketKeyword_6_0_2());
			setSemiColon(c, a.getSemicolonKeyword_6_1());
	    }
	    {	// BodyConstraintCS
	    	setSemiColon(c, f.getBodyConstraintCSAccess().getSemicolonKeyword_4());
	    }
	    {	// DataTypeCS
			DataTypeCSElements a = f.getDataTypeCSAccess();
			setSquareBrackets(c, a.getLessThanSignKeyword_2_0(), a.getGreaterThanSignKeyword_2_3());	
			setComma(c, a.getCommaKeyword_2_2_0());
			setBraces(c, a.getLeftCurlyBracketKeyword_5_0_0(), a.getRightCurlyBracketKeyword_5_0_2());
			setNoInternalSpacePunctuation(c, a.getLeftCurlyBracketKeyword_4_0(), a.getRightCurlyBracketKeyword_4_2());
			setSemiColon(c, a.getSemicolonKeyword_5_1());
	    }
	    {	// DerivedConstraintCS
	    	setSemiColon(c, f.getDerivedConstraintCSAccess().getSemicolonKeyword_3());
	    }
	    {	// DocumentationCS
	    	DocumentationCSElements a = f.getDocumentationCSAccess();
			setParentheses(c, a.getLeftParenthesisKeyword_3_0(), a.getRightParenthesisKeyword_3_3());	
			setSemiColon(c, a.getSemicolonKeyword_4());
	    }
	    {	// EnumCS
			EnumCSElements a = f.getEnumCSAccess();
			setSquareBrackets(c, a.getLessThanSignKeyword_2_0(), a.getGreaterThanSignKeyword_2_3());	
			setComma(c, a.getCommaKeyword_2_2_0());
			setBraces(c, a.getLeftCurlyBracketKeyword_4_0_0(), a.getRightCurlyBracketKeyword_4_0_2());
			setSemiColon(c, a.getSemicolonKeyword_4_1());
	    }
	    {	// EnumLiteralCS
	    	setSemiColon(c, f.getEnumLiteralCSAccess().getSemicolonKeyword_2_1());
	    }
	    {	// ImportCS
	    	setSemiColon(c, f.getImportCSAccess().getSemicolonKeyword_3());
	    }
	    {	// InitialConstraintCS
	    	setSemiColon(c, f.getInitialConstraintCSAccess().getSemicolonKeyword_3());
	    }
	    {	// InvariantConstraintCS
			InvariantConstraintCSElements a = f.getInvariantConstraintCSAccess();
			c.setNoSpace().before(a.getColonKeyword_2());
			setSemiColon(c, a.getSemicolonKeyword_4());
	    }
	    {	// OperationCS
			OperationCSElements a = f.getOperationCSAccess();
			setSquareBrackets(c, a.getLessThanSignKeyword_4_0(), a.getGreaterThanSignKeyword_4_3());	
			setComma(c, a.getCommaKeyword_4_2_0());
			setParentheses(c, a.getLeftParenthesisKeyword_5(), a.getRightParenthesisKeyword_7());	
			setComma(c, a.getCommaKeyword_6_1_0());
			setSquareBrackets(c, a.getLeftSquareBracketKeyword_8_2_0(), a.getRightSquareBracketKeyword_8_2_2());	
			setNoSpacePunctuation(c, a.getFullStopFullStopKeyword_8_2_1_0_1_0());
			setNoInternalSpacePunctuation(c, a.getLeftCurlyBracketKeyword_10_0(), a.getRightCurlyBracketKeyword_10_3());
			setNoSpacePunctuation(c, a.getCommaKeyword_10_2_0());
			setBraces(c, a.getLeftCurlyBracketKeyword_11_0_0(), a.getRightCurlyBracketKeyword_11_0_2());
			setSemiColon(c, a.getSemicolonKeyword_11_1());
	    }
	    {	// PackageCS
	    	setBraces(c, f.getPackageCSAccess().getLeftCurlyBracketKeyword_3_0_0(), f.getPackageCSAccess().getRightCurlyBracketKeyword_3_0_2());
	    }
//	    {	// PathNameCS
//	    	setNoSpacePunctuation(c, f.getPathNameCSAccess().getColonColonKeyword_1());
//	    }
	    {	// PostconditionConstraintCS
	    	setSemiColon(c, f.getPostconditionConstraintCSAccess().getSemicolonKeyword_4());
	    }
	    {	// PreconditionConstraintCS
	    	setSemiColon(c, f.getPreconditionConstraintCSAccess().getSemicolonKeyword_4());
	    }
	    {	// ReferenceCS
			ReferenceCSElements a = f.getReferenceCSAccess();
			setSquareBrackets(c, a.getLeftSquareBracketKeyword_5_2_0(), a.getRightSquareBracketKeyword_5_2_2());	
			setNoSpacePunctuation(c, a.getFullStopFullStopKeyword_5_2_1_0_1_0());
			setNoSpacePunctuation(c, a.getNumberSignKeyword_4_0());
			setNoInternalSpacePunctuation(c, a.getLeftCurlyBracketKeyword_7_0(), a.getRightCurlyBracketKeyword_7_3());
			setNoSpacePunctuation(c, a.getCommaKeyword_7_2_0());
			setBraces(c, a.getLeftCurlyBracketKeyword_8_0_0(), a.getRightCurlyBracketKeyword_8_0_2());
			setSemiColon(c, a.getSemicolonKeyword_8_1());
	    }
	    {	// ParameterCS
			ParameterCSElements a = f.getParameterCSAccess();
			setSquareBrackets(c, a.getLeftSquareBracketKeyword_1_2_0(), a.getRightSquareBracketKeyword_1_2_2());	
			setNoSpacePunctuation(c, a.getFullStopFullStopKeyword_1_2_1_0_1_0());
			setNoInternalSpacePunctuation(c, a.getLeftCurlyBracketKeyword_2_0(), a.getRightCurlyBracketKeyword_2_3());
			setNoSpacePunctuation(c, a.getCommaKeyword_2_2_0());
			setBraces(c, a.getLeftCurlyBracketKeyword_3_0(), a.getRightCurlyBracketKeyword_3_2());
	    }
	    {	// TypedTypeRefCS
			TypedTypeRefCSElements a = f.getTypedTypeRefCSAccess();
			setSquareBrackets(c, a.getLessThanSignKeyword_1_0(), a.getGreaterThanSignKeyword_1_3());	
			setNoSpacePunctuation(c, a.getCommaKeyword_1_2_0());
	    }
	    {	// comments
	    	c.setNoLinewrap().before(f.getSL_COMMENTRule());
	    }
	}

	@Override
	public OCLinEcoreGrammarAccess getGrammarAccess() {
		return (OCLinEcoreGrammarAccess) super.getGrammarAccess();
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

	public void setNoInternalSpacePunctuation(FormattingConfig c, Keyword left, Keyword right) {
		c.setNoSpace().after(left);
		c.setNoSpace().before(right);
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

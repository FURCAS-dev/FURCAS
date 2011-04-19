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
 * $Id: EssentialOCLValueConverterService.java,v 1.10 2011/03/14 17:06:12 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.services;

import static org.eclipse.xtext.EcoreUtil2.getAllContentsOfType;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Set;

import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.utilities.ElementUtil;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractDeclarativeValueConverterService;
import org.eclipse.xtext.conversion.impl.AbstractNullSafeConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

import com.google.common.collect.ImmutableSet;

public class EssentialOCLValueConverterService extends AbstractDeclarativeValueConverterService
{

	@ValueConverter(rule = "DOUBLE_QUOTED_STRING")
	public IValueConverter<String> DOUBLE_QUOTED_STRING() {
		return new AbstractNullSafeConverter<String>() {
			@Override
			protected String internalToValue(String string, INode node) {
				try {
					return PivotUtil.convertFromOCLString(string.substring(1, string.length() - 1));
				} catch(IllegalArgumentException e) {
					throw new ValueConverterException(e.getMessage(), node, e);
				}
			}

			@Override
			protected String internalToString(String value) {
				return '"' + PivotUtil.convertToOCLString(value) + '"';
			}
		};
	}

//	private static Set<String> getKeywords(Grammar grammar, String containedString) {
//		Set<String> results = new HashSet<String>();
//		gatherKeywords(results, grammar, containedString);
//		return results;
//	}

	protected static void gatherKeywords(Set<String> results, Grammar grammar, String containedString) {
		for (Grammar usedGrammar : grammar.getUsedGrammars()) {
			gatherKeywords(results, usedGrammar, containedString);
		}
		for (AbstractRule rule : grammar.getRules()) {
			String ruleName = rule.getName();
			if (ruleName.contains(containedString)) {
				for (Keyword keyword : getAllContentsOfType(rule, Keyword.class)) {
					results.add(keyword.getValue());
				}
			}
		}
	}

	@ValueConverter(rule = "ESCAPED_ID")
	public IValueConverter<String> ESCAPED_ID() {
		return new AbstractNullSafeConverter<String>()
		{			
			@Override
			protected String internalToValue(String string, INode node) {
				int length = string.length();
				if (string.startsWith("_'") && (length >= 3) && string.endsWith("'")) {
					return string.substring(2, length-1);
				}
				else if (string.startsWith("'") && (length >= 2) && string.endsWith("'")) {
					return string.substring(1, length-1);
				}
				else if (string.startsWith("\"") && (length >= 2) && string.endsWith("\"")) {
					return string.substring(1, length-1);
				}
				else {
					return string;
				}
			}

			@Override
			protected String internalToString(String value) {	// Never called
				return value;
			}
		};
	}

	@ValueConverter(rule = "ID")
	public IValueConverter<String> ID() {
		return new AbstractNullSafeConverter<String>()
		{			
			private Set<String> allKeywords = ImmutableSet.copyOf(GrammarUtil.getAllKeywords(getGrammar()));
//			private Set<String> unrestrictedKeywords = ImmutableSet.copyOf(getKeywords(getGrammar(), "Unrestricted"));

			@Override
			protected String internalToValue(String string, INode node) {
				int length = string.length();
				if (string.startsWith("_'") && (length >= 3) && string.endsWith("'")) {
					return string.substring(2, length-1);
				}
				else if (string.startsWith("'") && (length >= 2) && string.endsWith("'")) {
					return string.substring(1, length-1);
				}
				else if (string.startsWith("\"") && (length >= 2) && string.endsWith("\"")) {
					return string.substring(1, length-1);
				}
				else {
					return string;
				}
			}

			@Override
			protected String internalToString(String value) {
				if (allKeywords.contains(value) || !ElementUtil.isValidIdentifier(value)) {
					return "_'" + value + "'";
				}
				return value;
			}
		};
	}

	@ValueConverter(rule = "Identifier")
	public IValueConverter<String> Identifier() {
		return ID();		// FIXME Why is this needed (testImportsSerialize fails without it)
	}

	@ValueConverter(rule = "ML_SINGLE_QUOTED_STRING")
	public IValueConverter<String> ML_SINGLE_QUOTED_STRING() {
		return new AbstractNullSafeConverter<String>() {
			@Override
			protected String internalToValue(String string, INode node) {
				try {
					return PivotUtil.convertFromOCLString(string.substring(2, string.length() - 2));
				} catch(IllegalArgumentException e) {
					throw new ValueConverterException(e.getMessage(), node, e);
				}
			}

			@Override
			protected String internalToString(String value) {
				return "'" + PivotUtil.convertToOCLString(value) + "'";
			}
		};
	}
	
	@ValueConverter(rule = "Name")
	public IValueConverter<String> Name() {
		return ID();		// testOCLstdlib demonstrates that this is used (3/3/2011)
	}

	@ValueConverter(rule = "NUMBER_LITERAL")
	public IValueConverter<Number> NUMBER_LITERAL() {
		return new IValueConverter<Number>() {
			
			public Number toValue(String string, INode node) {
				if (Strings.isEmpty(string))
					throw new ValueConverterException("Couldn't convert empty string to number", node, null);
				try {
					if (string.contains(".") || string.contains("e") || string.contains("e")) {
						return new BigDecimal(string);
					}
					else {
						return new BigInteger(string);
					}
				} catch (NumberFormatException e) {
					throw new ValueConverterException("Couldn't convert '"+string+"' to number", node, e);
				}
			}

			public String toString(Number value) {
				return value.toString();
			}
		};
	}

	@ValueConverter(rule = "SIMPLE_ID")
	public IValueConverter<String> SIMPLE_ID() {
		return new AbstractNullSafeConverter<String>()
		{			
//			private Set<String> allKeywords = ImmutableSet.copyOf(GrammarUtil.getAllKeywords(getGrammar()));
//			private Set<String> unrestrictedKeywords = ImmutableSet.copyOf(getKeywords(getGrammar(), "Unrestricted"));

			@Override
			protected String internalToValue(String string, INode node) {
				return string;
			}

			@Override
			protected String internalToString(String value) {		// Never called
//				if (allKeywords.contains(value) || !ElementUtil.isValidIdentifier(value)) {
//					return "_'" + value + "'";
//				}
				return value;
			}
		};
	}

	@ValueConverter(rule = "SINGLE_QUOTED_STRING")
	public IValueConverter<String> SINGLE_QUOTED_STRING() {
		return new AbstractNullSafeConverter<String>() {
			@Override
			protected String internalToValue(String string, INode node) {
				try {
					return PivotUtil.convertFromOCLString(string.substring(1, string.length() - 1));
				} catch(IllegalArgumentException e) {
					throw new ValueConverterException(e.getMessage(), node, e);
				}
			}

			@Override
			protected String internalToString(String value) {
				return "'" + PivotUtil.convertToOCLString(value) + "'";
			}
		};
	}
	
	@ValueConverter(rule = "StringLiteral")
	public IValueConverter<String> StringLiteral() {
		return SINGLE_QUOTED_STRING();		// testCollectionAt demonstrates that this is used (3/3/2011)
	}
}

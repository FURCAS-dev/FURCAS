/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * $Id: EssentialOCLValueConverterService.java,v 1.12 2011/05/07 16:39:54 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.services;

import static org.eclipse.xtext.EcoreUtil2.eAllContentsAsList;
import static org.eclipse.xtext.EcoreUtil2.typeSelect;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.utilities.ElementUtil;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractDeclarativeValueConverterService;
import org.eclipse.xtext.conversion.impl.AbstractNullSafeConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

public class EssentialOCLValueConverterService extends AbstractDeclarativeValueConverterService
{
	//
	//	The seemingly redundant Identifier as well as ID converersc are needed. During serialization
	//	the exact rule-specific converter is used.
	//
	protected static abstract class AbstractIDConverter extends AbstractNullSafeConverter<String>
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
	}

	protected static class DoubleQuotedStringConverter extends AbstractNullSafeConverter<String>
	{
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
	}

	protected static class EscapedIDConverter extends AbstractIDConverter
	{
		@Override
		protected String internalToString(String value) {	// Never called
			return value;
		}
	}

	protected static class IDConverter extends AbstractIDConverter
	{
		private final Set<String> allKeywords;

		public IDConverter(Grammar grammar) {
			allKeywords = GrammarUtil.getAllKeywords(grammar);
		}

		@Override
		protected String internalToString(String value) {
			if (allKeywords.contains(value) || !ElementUtil.isValidIdentifier(value)) {
				return "_'" + value + "'";
			}
			return value;
		}
	}

	protected static class MultiLineSingleQuotedStringConverter extends AbstractNullSafeConverter<String>
	{
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
	}

	protected static class NameConverter extends AbstractIDConverter
	{
		private final Set<String> nameKeywords;

		protected static Set<String> computeKeywords(Grammar grammar) {
			Set<String> keywords = new HashSet<String>(GrammarUtil.getAllKeywords(grammar));
			keywords.removeAll(getAllKeywords(grammar, "UnrestrictedName"));
			keywords.removeAll(getAllKeywords(grammar, "EssentialOCLReservedKeyword"));
			keywords.removeAll(getAllKeywords(grammar, "RestrictedKeywords"));
			keywords.removeAll(getAllKeywords(grammar, "CollectionTypeIdentifier"));
			keywords.removeAll(getAllKeywords(grammar, "PrimitiveTypeIdentifier"));
			return keywords;
		}

		public NameConverter(Grammar grammar) {
			nameKeywords = computeKeywords(grammar);
		}
		
		@Override
		protected String internalToString(String value) {
			if (nameKeywords.contains(value) || !ElementUtil.isValidIdentifier(value)) {
				return "_'" + value + "'";
			}
			return value;
		}
	}

	protected static class NumberConverter implements IValueConverter<Number>
	{	
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
	}

	protected static class SimpleIDConverter extends AbstractNullSafeConverter<String>
	{
		@Override
		protected String internalToValue(String string, INode node) {
			return string;
		}

		@Override
		protected String internalToString(String value) {		// Never called
			return value;
		}
	}
	
	protected static class SingleQuotedStringConverter extends AbstractNullSafeConverter<String>
	{		
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
	}

	protected static class UnrestrictedNameConverter extends AbstractIDConverter
	{
		private final Set<String> unrestrictedKeywords;

		protected static Set<String> computeUnrestrictedKeywords(Grammar grammar) {
			Set<String> keywords = new HashSet<String>(GrammarUtil.getAllKeywords(grammar));
			keywords.removeAll(getAllKeywords(grammar, "UnrestrictedName"));
			return keywords;
		}

		public UnrestrictedNameConverter(Grammar grammar) {
			unrestrictedKeywords = computeUnrestrictedKeywords(grammar);
		}
		
		@Override
		protected String internalToString(String value) {
			if (unrestrictedKeywords.contains(value) || !ElementUtil.isValidIdentifier(value)) {
				return "_'" + value + "'";
			}
			return value;
		}
	}

	public static Set<String> getAllKeywords(Grammar g, String name) {
		Set<String> kws = new HashSet<String>();
		List<ParserRule> rules = GrammarUtil.allParserRules(g);
		for (ParserRule parserRule : rules) {
			if (parserRule.getName().equals(name)) {
				List<Keyword> list = typeSelect(eAllContentsAsList(parserRule), Keyword.class);
				for (Keyword keyword : list) {
					kws.add(keyword.getValue());
				}
			}
		}
		return kws;
	}

	private static DoubleQuotedStringConverter doubleQuotedStringConverter = null;
	private static EscapedIDConverter escapedIDConverter = null;
	private IDConverter idConverter = null; 				// not static - grammar-dependent
	private static MultiLineSingleQuotedStringConverter multiLineSingleQuotedStringConverter = null;
	private NameConverter nameConverter = null; 				// not static - grammar-dependent
	private static NumberConverter numberConverter = null;
	private static SimpleIDConverter simpleIDConverter = null;
	private static SingleQuotedStringConverter singleQuotedStringConverter = null;
	private UnrestrictedNameConverter unrestrictedNameConverter = null; 				// not static - grammar-dependent

	@ValueConverter(rule = "DOUBLE_QUOTED_STRING")
	public IValueConverter<String> DOUBLE_QUOTED_STRING() {
		if (doubleQuotedStringConverter == null) {
			doubleQuotedStringConverter = new DoubleQuotedStringConverter();
		}
		return doubleQuotedStringConverter;
	}

	@ValueConverter(rule = "ESCAPED_ID")
	public IValueConverter<String> ESCAPED_ID() {
		if (escapedIDConverter == null) {
			escapedIDConverter = new EscapedIDConverter();
		}
		return escapedIDConverter;
	}

	@ValueConverter(rule = "ID")
	public IValueConverter<String> ID() {
		if (idConverter == null) {
			idConverter = new IDConverter(getGrammar());
		}
		return idConverter;
	}

	@ValueConverter(rule = "Identifier")
	public IValueConverter<String> Identifier() {
		return ID();
	}

	@ValueConverter(rule = "ML_SINGLE_QUOTED_STRING")
	public IValueConverter<String> ML_SINGLE_QUOTED_STRING() {
		if (multiLineSingleQuotedStringConverter == null) {
			multiLineSingleQuotedStringConverter = new MultiLineSingleQuotedStringConverter();
		}
		return multiLineSingleQuotedStringConverter;
	}
	
	@ValueConverter(rule = "Name")
	public IValueConverter<String> Name() {
//		return ID();
		if (nameConverter == null) {
			nameConverter = new NameConverter(getGrammar());
		}
		return nameConverter;
	}

	@ValueConverter(rule = "NUMBER_LITERAL")
	public IValueConverter<Number> NUMBER_LITERAL() {
		if (numberConverter == null) {
			numberConverter = new NumberConverter();
		}
		return numberConverter;
	}

	@ValueConverter(rule = "SIMPLE_ID")
	public IValueConverter<String> SIMPLE_ID() {
		if (simpleIDConverter == null) {
			simpleIDConverter = new SimpleIDConverter();
		}
		return simpleIDConverter;
	}

	@ValueConverter(rule = "SINGLE_QUOTED_STRING")
	public IValueConverter<String> SINGLE_QUOTED_STRING() {
		if (singleQuotedStringConverter == null) {
			singleQuotedStringConverter = new SingleQuotedStringConverter();
		}
		return singleQuotedStringConverter;
	}
	
	@ValueConverter(rule = "StringLiteral")
	public IValueConverter<String> StringLiteral() {
		return SINGLE_QUOTED_STRING();
	}

	@ValueConverter(rule = "UnrestrictedName")
	public IValueConverter<String> UnrestrictedName() {
		if (unrestrictedNameConverter == null) {
			unrestrictedNameConverter = new UnrestrictedNameConverter(getGrammar());
		}
		return unrestrictedNameConverter;
	}
}

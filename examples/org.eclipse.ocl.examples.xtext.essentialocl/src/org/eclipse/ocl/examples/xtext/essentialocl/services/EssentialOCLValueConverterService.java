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
 * $Id: EssentialOCLValueConverterService.java,v 1.1 2010/04/13 06:32:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.services;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Set;

import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractDeclarativeValueConverterService;
import org.eclipse.xtext.conversion.impl.AbstractNullSafeConverter;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.util.Strings;

import com.google.common.collect.ImmutableSet;

public class EssentialOCLValueConverterService extends AbstractDeclarativeValueConverterService {

	@ValueConverter(rule = "ID")
	public IValueConverter<String> ID() {
		return new AbstractNullSafeConverter<String>() {
			
			private Set<String> allKeywords = ImmutableSet.copyOf(GrammarUtil.getAllKeywords(getGrammar()));
			
			@Override
			protected String internalToValue(String string, AbstractNode node) {
				int length = string.length();
				return string.startsWith("_'") && (length >= 3) && string.endsWith("'") ? string.substring(2, length-1) : string;
			}

			@Override
			protected String internalToString(String value) {
				if (allKeywords.contains(value)) {
					return "_'" + value + "'";
				}
				return value;
			}
		};
	}

	@ValueConverter(rule = "STRING_LITERAL")
	public IValueConverter<String> STRING_LITERAL() {
		return new AbstractNullSafeConverter<String>() {
			@Override
			protected String internalToValue(String string, AbstractNode node) {
				try {
					return Strings.convertFromJavaString(string.substring(1, string.length() - 1), false);
				} catch(IllegalArgumentException e) {
					throw new ValueConverterException(e.getMessage(), node, e);
				}
			}

			@Override
			protected String internalToString(String value) {
				return "'" + Strings.convertToJavaString(value, false) + "'";
			}
		};
	}

	@ValueConverter(rule = "INTEGER_LITERAL")
	public IValueConverter<BigInteger> INTEGER_LITERAL() {
		return new IValueConverter<BigInteger>() {
			
			public BigInteger toValue(String string, AbstractNode node) {
				if (Strings.isEmpty(string))
					throw new ValueConverterException("Couldn't convert empty string to integer", node, null);
				try {
					return new BigInteger(string);
				} catch (NumberFormatException e) {
					throw new ValueConverterException("Couldn't convert '"+string+"' to integer", node, e);
				}
			}

			public String toString(BigInteger value) {
				return value.toString();
			}

		};
	}

	@ValueConverter(rule = "REAL_LITERAL")
	public IValueConverter<BigDecimal> REAL_LITERAL() {
		return new IValueConverter<BigDecimal>() {
			
			public BigDecimal toValue(String string, AbstractNode node) {
				if (Strings.isEmpty(string))
					throw new ValueConverterException("Couldn't convert empty string to real", node, null);
				try {
					return new BigDecimal(string);
				} catch (NumberFormatException e) {
					throw new ValueConverterException("Couldn't convert '"+string+"' to real", node, e);
				}
			}

			public String toString(BigDecimal value) {
				return value.toString();
			}

		};
	}

}

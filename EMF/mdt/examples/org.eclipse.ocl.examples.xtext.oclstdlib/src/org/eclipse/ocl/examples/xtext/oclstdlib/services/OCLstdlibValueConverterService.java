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
 * $Id: OCLstdlibValueConverterService.java,v 1.5 2010/08/17 18:53:32 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclstdlib.services;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Set;

import org.eclipse.ocl.examples.xtext.base.util.ElementUtil;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractDeclarativeValueConverterService;
import org.eclipse.xtext.conversion.impl.AbstractNullSafeConverter;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.util.Strings;

import com.google.common.collect.ImmutableSet;

public class OCLstdlibValueConverterService extends AbstractDeclarativeValueConverterService
{
	@ValueConverter(rule = "DOUBLE_QUOTED_STRING")
	public IValueConverter<String> DOUBLE_QUOTED_STRING() {
		return new AbstractNullSafeConverter<String>() {
			@Override
			protected String internalToValue(String string, AbstractNode node) {
				try {
					return Strings.convertFromJavaString(string.substring(1, string.length() - 1), true);
				} catch(IllegalArgumentException e) {
					throw new ValueConverterException(e.getMessage(), node, e);
				}
			}

			@Override
			protected String internalToString(String value) {
				return '"' + Strings.convertToJavaString(value, true) + '"';
			}
		};
	}

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
				if (allKeywords.contains(value) || !ElementUtil.isValidIdentifier(value)) {
					return "_'" + value + "'";
				}
				return value;
			}
		};
	}

	@ValueConverter(rule = "NUMBER_LITERAL")
	public IValueConverter<Number> NUMBER_LITERAL() {
		return new IValueConverter<Number>() {
			
			public Number toValue(String string, AbstractNode node) {
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

	@ValueConverter(rule = "SINGLE_QUOTED_STRING")
	public IValueConverter<String> SINGLE_QUOTED_STRING() {
		return new AbstractNullSafeConverter<String>() {
			@Override
			protected String internalToValue(String string, AbstractNode node) {
				try {
					return Strings.convertFromJavaString(string.substring(1, string.length() - 1), true);
				} catch(IllegalArgumentException e) {
					throw new ValueConverterException(e.getMessage(), node, e);
				}
			}

			@Override
			protected String internalToString(String value) {
				return "'" + Strings.convertToJavaString(value, true) + "'";
			}
		};
	}
}

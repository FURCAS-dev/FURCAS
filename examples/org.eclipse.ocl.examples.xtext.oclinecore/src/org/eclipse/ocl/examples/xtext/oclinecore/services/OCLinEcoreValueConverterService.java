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
 * $Id: OCLinEcoreValueConverterService.java,v 1.6 2011/05/05 17:53:16 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.services;

import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLValueConverterService;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractNullSafeConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

public class OCLinEcoreValueConverterService extends EssentialOCLValueConverterService
{
	protected static class IntegerConverter extends AbstractNullSafeConverter<Integer>
	{
		@Override
		public Integer internalToValue(String string, INode node) {
			if (Strings.isEmpty(string))
				throw new ValueConverterException("Couldn't convert empty string to integer", node, null);
			try {
				return Integer.valueOf(string);
			} catch (NumberFormatException e) {
				throw new ValueConverterException("Couldn't convert '"+string+"' to integer", node, e);
			}
		}

		@Override
		public String internalToString(Integer value) {
			return value.toString();
		}
	}
	
	protected static class UpperConverter extends AbstractNullSafeConverter<Integer>
	{	
		@Override
		public Integer internalToValue(String string, INode node) {
			if (Strings.isEmpty(string))
				throw new ValueConverterException("Couldn't convert empty string to integer", node, null);
			try {
				if ("*".equals(string)) {
					return Integer.valueOf(-1);
				}
				return Integer.valueOf(string);
			} catch (NumberFormatException e) {
				throw new ValueConverterException("Couldn't convert '"+string+"' to integer", node, e);
			}
		}
		
		@Override
		public String internalToString(Integer value) {
			return value >= 0 ? value.toString() : "*";
		}
	}

	protected static class UnquotedStringConverter extends AbstractNullSafeConverter<String>
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
			return value; //PivotUtil.convertToOCLString(value.replace('\r', '\n'));
		}
	}

	private static IntegerConverter integerConverter = null;
	private static UnquotedStringConverter unquotedStringConverter = null;
	private static UpperConverter upperConverter = null;

	@ValueConverter(rule = "LOWER")
	public IValueConverter<Integer> LOWER() {
		if (integerConverter == null) {
			integerConverter = new IntegerConverter();
		}
		return integerConverter;
	}

	@ValueConverter(rule = "UNQUOTED_STRING")
	public IValueConverter<String> UNQUOTED_STRING() {
		if (unquotedStringConverter == null) {
			unquotedStringConverter = new UnquotedStringConverter();
		}
		return unquotedStringConverter;
	}
	
	@ValueConverter(rule = "UPPER")
	public IValueConverter<Integer> UPPER() {
		if (upperConverter == null) {
			upperConverter = new UpperConverter();
		}
		return upperConverter;
	}
}

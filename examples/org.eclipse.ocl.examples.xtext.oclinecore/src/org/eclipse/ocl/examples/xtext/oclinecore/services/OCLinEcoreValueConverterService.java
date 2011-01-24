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
 * $Id: OCLinEcoreValueConverterService.java,v 1.3 2011/01/24 21:43:57 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.services;

import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLValueConverterService;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractNullSafeConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

public class OCLinEcoreValueConverterService extends EssentialOCLValueConverterService
{
	@ValueConverter(rule = "LOWER")
	public IValueConverter<Integer> LOWER() {
		return new AbstractNullSafeConverter<Integer>() {
			
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

		};
	}

	@ValueConverter(rule = "UNQUOTED_STRING")
	public IValueConverter<String> UNQUOTED_STRING() {
		return new AbstractNullSafeConverter<String>() {
			@Override
			protected String internalToValue(String string, INode node) {
				try {
					return Strings.convertFromJavaString(string.substring(1, string.length() - 1), false);
				} catch(IllegalArgumentException e) {
					throw new ValueConverterException(e.getMessage(), node, e);
				}
			}

			@Override
			protected String internalToString(String value) {
				return value; //Strings.convertToJavaString(value.replace('\r', '\n'), false);
			}
		};
	}
	
	@ValueConverter(rule = "UnrestrictedName")
	public IValueConverter<String> UnrestrictedName() {
		return ID();
	}
	
	@ValueConverter(rule = "UPPER")
	public IValueConverter<Integer> UPPER() {
		return new AbstractNullSafeConverter<Integer>() {
			
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

		};
	}
}

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
 * $Id: PivotConstants.java,v 1.6 2011/02/15 10:38:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.utilities;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;

public interface PivotConstants
{
	static final int MONIKER_OVERFLOW_LIMIT = 1024;
	static final String ANNOTATION_QUOTE = "'"; //$NON-NLS-1$
	static final String BINDINGS_PREFIX = "/"; //$NON-NLS-1$ // FIXME Rename
	static final String ITERATOR_SEPARATOR = ";"; //$NON-NLS-1$
	static final String ACCUMULATOR_SEPARATOR = "|"; //$NON-NLS-1$
	static final String NULL_MARKER = "<<null-element>>"; //$NON-NLS-1$
	static final String OVERFLOW_MARKER = "##"; //$NON-NLS-1$
	static final String MONIKER_PART_SEPARATOR = "@"; //$NON-NLS-1$
	static final String MONIKER_SCOPE_SEPARATOR = "!"; //"::"; //$NON-NLS-1$
	static final String MONIKER_OPERATOR_SEPARATOR = "~"; //$NON-NLS-1$
	static final String PARAMETER_PREFIX = "("; //$NON-NLS-1$
	static final String PARAMETER_SEPARATOR = ","; //$NON-NLS-1$
	static final String PARAMETER_SUFFIX = ")"; //$NON-NLS-1$
	static final String PRECEDENCE_PREFIX = "~"; //$NON-NLS-1$
	static final String TEMPLATE_BINDING_PREFIX = "["; //$NON-NLS-1$
	static final String TEMPLATE_BINDING_SEPARATOR = ","; //$NON-NLS-1$
	static final String TEMPLATE_BINDING_SUFFIX = "]"; //$NON-NLS-1$
	static final String TEMPLATE_PARAMETER_PREFIX = "?"; //$NON-NLS-1$
	static final String TEMPLATE_SIGNATURE_PREFIX = "{"; //$NON-NLS-1$
	static final String TEMPLATE_SIGNATURE_SEPARATOR = ","; //$NON-NLS-1$
	static final String TEMPLATE_SIGNATURE_SUFFIX = "}"; //$NON-NLS-1$
	static final String TUPLE_SIGNATURE_PREFIX = "{"; //$NON-NLS-1$
	static final String TUPLE_SIGNATURE_PART_SEPARATOR = ","; //$NON-NLS-1$
	static final String TUPLE_SIGNATURE_TYPE_SEPARATOR = ":"; //$NON-NLS-1$
	static final String TUPLE_SIGNATURE_SUFFIX = "}"; //$NON-NLS-1$
	static final String WILDCARD_INDICATOR = "?"; //$NON-NLS-1$

	static final String COLLECTION_NAVIGATION_OPERATOR = "->";
	static final String OBJECT_NAVIGATION_OPERATOR = ".";
	static final String GREATER_THAN_OPERATOR = ">";
	static final String GREATER_THAN_OR_EQUAL_OPERATOR = ">=";
	static final String LESS_THAN_OPERATOR = "<";
	static final String LESS_THAN_OR_EQUAL_OPERATOR = "<=";
	
	static final String MONIKER_IF_EXP = "if";
	static final String MONIKER_INVALID_LITERAL_EXP = "invalid";
	static final String MONIKER_LET_EXP = "let";
	static final String MONIKER_NULL_LITERAL_EXP = "null";
	static final String MONIKER_ROOT_EXP = "root";
	static final String MONIKER_STRING_LITERAL_EXP = "string";
	static final String MONIKER_TUPLE_LITERAL_EXP = "tuple";
	static final String MONIKER_UNLIMITED_NATURAL_LITERAL_EXP = "*";

	static final String MONIKER_EXP_CHILD_PREFIX = "x";
	
	static final String ORPHANAGE_NAME = "orphanage";
	static final String ORPHANAGE_PREFIX = "orphanage";
	static final String ORPHANAGE_URI = "http://www.eclipse.org/ocl/3.1.0/orphanage";

	static final String WILDCARD_NAME = "wildcard";
	
	static final String OCL_LANGUAGE = "OCL";
	static final String OCL_SELF_NAME = "OclSelf";
	
	public static Map<EStructuralFeature,String> roleNames = new HashMap<EStructuralFeature,String>();
}

/******************************************************************************
 * Copyright (c) 2002, 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.emf.ocl.helper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * An enumeration of OCL syntax completion {@linkplain Choice choice} types.
 *
 * @see Choice
 * @see IOclHelper#getSyntaxHelp(String)
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ChoiceType
	extends AbstractEnumerator {

	/**
	 * The next ordinal to use when initializing this enumerated type.
	 */
	private static int nextOrdinal = 0;

	/** Indicates a semantically uncategorized completion choice. */
	public static final ChoiceType UNCATEGORIZED = new ChoiceType(
		"UNCATEGORIZED"); //$NON-NLS-1$

	/** Indicates a structural feature (e.g., attribute) completion choice. */
	public static final ChoiceType STRUCTURAL_FEATURE = new ChoiceType(
		"STRUCTURAL_FEATURE"); //$NON-NLS-1$

	/** Indicates a behavioral feature (e.g., operation) completion choice. */
	public static final ChoiceType BEHAVIORAL_FEATURE = new ChoiceType(
		"BEHAVIORAL_FEATURE"); //$NON-NLS-1$

	/** Indicates an enumeration literal completion choice. */
	public static final ChoiceType ENUMERATION_LITERAL = new ChoiceType(
		"ENUMERATION_LITERAL"); //$NON-NLS-1$

	/** Indicates a variable name completion choice. */
	public static final ChoiceType VARIABLE = new ChoiceType(
		"VARIABLE"); //$NON-NLS-1$

	/**
	 * The list of values for this enumerated type.
	 */
	private static final List VALUES = 
		Collections.unmodifiableList(Arrays.asList(
			new ChoiceType[] {
				UNCATEGORIZED,
				STRUCTURAL_FEATURE, BEHAVIORAL_FEATURE,
				ENUMERATION_LITERAL,
				VARIABLE}));

	/**
	 * Constructs a new OclHelper type with the specified name.
	 * 
	 * @param name The name of the new OclHelper type
	 */
	private ChoiceType(String name) {
		super(nextOrdinal++, name);
	}

	/**
	 * Retrieves the list of values of this enumerated type.
	 * 
	 * @return The list of values of this enumerated type.
	 */
	public static List getValues() {
		return VALUES;
	}

}
/**
 * <copyright>
 *
 * Copyright (c) 2005, 2006 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.ocl.helper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * An enumeration of OCL constraint types, primarily for determining the
 * appropriate choices for syntax completion.
 *
 * @see IOCLHelper#getSyntaxHelp(ConstraintType, String)
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ConstraintType
	extends AbstractEnumerator {

	static final int INVARIANT_VALUE = 0;
	static final int PRECONDITION_VALUE = 1;
	static final int BODYCONDITION_VALUE = 2;
	static final int POSTCONDITION_VALUE = 3;
	
	/** Indicates a semantically uncategorized completion choice. */
	public static final ConstraintType INVARIANT = new ConstraintType(
		INVARIANT_VALUE, "invariant"); //$NON-NLS-1$
	
	/** Indicates a structural feature (e.g., attribute) completion choice. */
	public static final ConstraintType PRECONDITION = new ConstraintType(
			PRECONDITION_VALUE, "precondition"); //$NON-NLS-1$

	/** Indicates an enumeration literal completion choice. */
	public static final ConstraintType BODYCONDITION = new ConstraintType(
			BODYCONDITION_VALUE, "bodycondition"); //$NON-NLS-1$

	/** Indicates a behavioral feature (e.g., operation) completion choice. */
	public static final ConstraintType POSTCONDITION = new ConstraintType(
			POSTCONDITION_VALUE, "postcondition"); //$NON-NLS-1$

	/**
	 * The list of values for this enumerated type.
	 */
	private static final List VALUES = 
		Collections.unmodifiableList(Arrays.asList(
			new ConstraintType[] {
				INVARIANT,
				PRECONDITION,
				BODYCONDITION,
				POSTCONDITION}));

	/**
	 * Constructs a new OCLHelper type with the specified name.
	 * 
	 * @param ordinal the ordinal number
	 * @param name The name of the new OCLHelper type
	 */
	private ConstraintType(int ordinal, String name) {
		super(ordinal, name);
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
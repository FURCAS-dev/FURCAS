/**
 * <copyright>
 *
 * Copyright (c) 2002-2006 IBM Corporation and others.
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


/**
 * Representation of a particular OCL expression syntax completion suggestion.
 * These suggestions are obtained from an {@link IOCLHelper} for a particular
 * fragment of an OCL expression.
 * <p>
 * <b>Note</b> that this class is not intended to be extended nor instantiated
 * by clients.
 * </p>
 * 
 * @see IOCLHelper#getSyntaxHelp(String)
 * 
 * @author Yasser Lulu 
 */
public class Choice {

	private String name;

	private String description;

	private ChoiceType kind;

	/**
	 * Initializes me with all of my fields.
	 * 
	 * @param name my name, suitable for display in a UI list
	 * @param description my description, suitable for display in a UI tool tip
	 *     or pop-up help window
	 * @param kind the kind of choice that I am
	 */
	Choice(String name, String description, ChoiceType kind) {
		this.name = name;
		this.description = description;
		this.kind = kind;
	}

	/**
	 * Obtains my name, suitable for display in a UI list.
	 * 
	 * @return my name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Obtains my description, suitable for display in a UI tool tip or pop-up
	 * help window.
	 * 
	 * @return my description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Queries the kind of syntax completion suggestion that I am.
	 * 
	 * @return my type
	 */
	public ChoiceType getKind() {
		return kind;
	}

	public int hashCode() {
		return (getName() == null) ? 0 : getName().hashCode();
	}
	
	public boolean equals(Object obj) {
		boolean result = obj instanceof Choice;
		
		if (result) {
			Choice other = (Choice) obj;
			
			result = getKind() == other.getKind()
				&& safeEquals(getName(), other.getName());
		}
		
		return result;
	}
	
	/**
	 * Null-safe equality test.
	 * 
	 * @param a an object (may be <code>null</code>)
	 * @param b another object (may be <code>null</code>)
	 * @return
	 */
	private boolean safeEquals(Object a, Object b) {
		return (a == null && b == null) || ((a != null) && a.equals(b));
	}
	
	public String toString() {
		StringBuffer result = new StringBuffer();
		
		result.append("Choice["); //$NON-NLS-1$
		result.append(getKind().getName());
		result.append(", "); //$NON-NLS-1$
		result.append(getName());
		result.append(", "); //$NON-NLS-1$
		result.append(getDescription());
		result.append(']');
		
		return result.toString();
	}
}
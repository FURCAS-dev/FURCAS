/**
 * <copyright>
 *
 * Copyright (c) 2006, 2007 IBM Corporation and others.
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
 * $Id: Choice.java,v 1.1 2007/01/25 18:24:38 cdamus Exp $
 */
package org.eclipse.ocl.helper;

/**
 * Description of a syntax completion choice.  A choice is characterized by a
 * kind (indicating the type of model construct that it represents), a name,
 * and a description (which is useful for constructing text for a content-assist
 * window).  The choice also can provide the actual model element that it
 * represents, in case the client knows how to interpret it.
 * <p>
 * <b>Note</b> that this interface is not intended to be implemented
 * by clients.
 * </p>
 * 
 * @author Christian W. Damus (cdamus)
 */
public interface Choice {

	/**
	 * Queries the kind of syntax completion suggestion that I am.
	 * 
	 * @return my type
	 */
	ChoiceKind getKind();

	/**
	 * Obtains my name, suitable for display in a UI list.
	 * 
	 * @return my name
	 */
	String getName();

	/**
	 * Obtains my description, suitable for display in a UI tool tip or pop-up
	 * help window.
	 * 
	 * @return my description
	 */
	String getDescription();

	/**
	 * Obtains the model element (property, operation, type, etc.) that is
	 * the choice in question.
	 * 
	 * @return the element that I represent
	 */
	Object getElement();
}
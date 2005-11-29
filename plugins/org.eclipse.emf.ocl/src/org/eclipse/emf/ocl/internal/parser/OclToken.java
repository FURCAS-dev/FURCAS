/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
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


package org.eclipse.emf.ocl.internal.parser;

import antlr.CommonToken;


/**
 * Specialization of the basic ANTLR token implementation, that tracks
 * position from the beginning of the string of the token, in addition to
 * the row/column location.
 *
 * @author Christian W. Damus (cdamus)
 */
public class OclToken
	extends CommonToken {

	private int startPosition = -1;
	
	/**
	 * Initializes me
	 */
	public OclToken() {
		super();
	}

	/**
	 * Initializes me with my type and my value.
	 * 
	 * @param type my type
	 * @param text my value
	 */
	public OclToken(int type, String text) {
		super(type, text);
	}

	/**
	 * Initializes me with my value.
	 * 
	 * @param text my value
	 */
	public OclToken(String text) {
		super(text);
	}

	/**
	 * Obtains my start position, as a character index from the beginning of
	 * the input.
	 * 
	 * @return my start position
	 */
	public int getStartPosition() {
		return startPosition;
	}
	
	/**
	 * Sets my start position, as a character index from the beginning of
	 * the input.
	 * 
	 * @param position my start position
	 */
	public void setStartPosition(int position) {
		startPosition = position;
	}
	
	/**
	 * Obtains my end position, as a character index from the beginning of
	 * the input.  The end position is exclusive:  it is the position of the
	 * next character after me.
	 * 
	 * @return my end position
	 */
	public int getEndPosition() {
		return getStartPosition() + getText().length();
	}
}

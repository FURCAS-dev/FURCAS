/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: LookupException.java,v 1.2 2007/10/12 18:18:16 cdamus Exp $
 */

package org.eclipse.ocl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Exception indicating a semantic error in looking up a definition, typically
 * resulting from an ambiguity.
 */
public class LookupException
	extends SemanticException {

    private final List<?> matches;
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -2420776905241571992L;

	/**
     * Initializes me with a user-friendly message describing the nature of
     * the lookup failure.
     * 
     * @param msg the exception message
     */
	public LookupException(String msg) {
		super(msg);
		
		matches = Collections.emptyList();
	}

	/**
     * Initializes me with a user-friendly message describing the nature of
     * the lookup failure.
     * 
     * @param msg the exception message
     * @param matches the objects found by the lookup
     */
	public LookupException(String msg, List<?> matches) {
		super(msg);
		
		this.matches = matches;
	}
	
    /**
     * Initializes me with a user-friendly message describing the nature of
     * the lookup failure and at least two objects that were ambiguous matches.
     * 
     * @param msg the exception message
     * @param firstMatch the first object found by the look-up
     * @param secondMatch the second object found by the look-up
     * @param otherMatches any further objects found by the look-up
     */
	public LookupException(String msg, Object firstMatch, Object secondMatch, Object... otherMatches) {
	    super(msg);
	    
	    List<Object> objectMatches = new ArrayList<Object>(2);
	    objectMatches.add(firstMatch);
	    objectMatches.add(secondMatch);	    
	    for (Object next : otherMatches) {
	    	objectMatches.add(next);
	    }
	    matches = objectMatches;
	}
	
	/**
	 * Obtains the list of ambiguous matches, if the problem was one of
	 * ambiguity, in the order in which they were found.
	 * 
	 * @return the ambiguous matches, or an empty list if the look-up problem
	 *    was not a matter of ambiguity
	 */
	public List<?> getAmbiguousMatches() {
	    return matches;
	}
}

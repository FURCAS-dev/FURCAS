/**
 * <copyright>
 *
 * Copyright (c) 2007 IBM Corporation and others.
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
 * $Id: InvalidLookupException.java,v 1.2 2007/12/03 13:27:29 cdamus Exp $
 */

package org.eclipse.ocl;

import java.util.Collections;



/**
 * A specialized {@link LookupException} denoting specifically that the
 * problem is a single result that is invalid or otherwise unexpected.
 * 
 * @see #getInvalidMatch()
 * 
 * @author Christian W. Damus (cdamus)
 * @since 1.2
 */
public class InvalidLookupException
    extends LookupException {

    private static final long serialVersionUID = 7340315513672976055L;

    private final Object match;
    
    /**
     * Initializes me with a user-friendly message describing the nature of
     * the lookup that resulted in an unexpected match.
     * 
     * @param msg the exception message
     * @param match the invalid object found by the lookup
     */
    public InvalidLookupException(String msg, Object match) {
        super(msg, Collections.singletonList(match));
        this.match = match;
    }
    
    /**
     * Obtains the invalid result of the look-up, or <code>null</code> if the
     * look-up found no matches or multiple ambiguous matches.
     * 
     * @return the invalid look-up result, or <code>null</code> if the look-up
     *    problem was not a matter of finding an invalid result
     * 
     * @see #getAmbiguousMatches()
     */
    public Object getInvalidMatch() {
        return match;
    }

}

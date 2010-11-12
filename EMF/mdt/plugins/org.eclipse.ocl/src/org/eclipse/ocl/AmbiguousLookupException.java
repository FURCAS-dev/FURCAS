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
 * $Id: AmbiguousLookupException.java,v 1.1 2007/12/03 13:19:51 cdamus Exp $
 */

package org.eclipse.ocl;

import java.util.List;


/**
 * A specialized {@link LookupException} denoting specifically that the
 * problem is multiple ambiguous results.
 * 
 * @see LookupException#getAmbiguousMatches()
 * 
 * @author Christian W. Damus (cdamus)
 * @since 1.2
 */
public class AmbiguousLookupException
    extends LookupException {

    private static final long serialVersionUID = 7340315513672976055L;

    /**
     * Initializes me with a user-friendly message describing the nature of
     * the lookup that resulted in multiple ambiguous matches.
     * 
     * @param msg the exception message
     * @param matches the objects found by the lookup
     */
    public AmbiguousLookupException(String msg, List<?> matches) {
        super(msg, matches);
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
    public AmbiguousLookupException(String msg, Object firstMatch,
            Object secondMatch, Object... otherMatches) {
        super(msg, firstMatch, secondMatch, otherMatches);
    }

}

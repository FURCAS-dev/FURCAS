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
 * $Id: OCLWhitespaceDetector.java,v 1.1 2007/04/30 12:39:31 cdamus Exp $
 */

package org.eclipse.emf.ocl.examples.interpreter.console.text;

import org.eclipse.jface.text.rules.IWhitespaceDetector;


/**
 * Detector for whitespace in OCL text.
 * 
 * @author Christian W. Damus (cdamus)
 */
class OCLWhitespaceDetector
    implements IWhitespaceDetector {

    public boolean isWhitespace(char c) {
        switch (c) {
            case ' ':
            case '\t':
            case '\n':
            case '\r':
                return true;
            default:
                return false;
        }
    }

}

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
 * $Id: OCLKeywordRule.java,v 1.1 2007/04/30 12:39:31 cdamus Exp $
 */

package org.eclipse.emf.ocl.examples.interpreter.console.text;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.swt.SWT;


/**
 * Rule to match OCL keywords and pseudo-keywords (that aren't actually
 * reserved by the specification).
 * 
 * @author Christian W. Damus (cdamus)
 */
class OCLKeywordRule
    extends WordRule {

    private static final String[] KEYWORDS = {
        "package", //$NON-NLS-1$
        "endpackage", //$NON-NLS-1$
        "context", //$NON-NLS-1$
        "inv", //$NON-NLS-1$
        "pre", //$NON-NLS-1$
        "post", //$NON-NLS-1$
        "body", //$NON-NLS-1$
        "derive", //$NON-NLS-1$
        "init", //$NON-NLS-1$
        "def", //$NON-NLS-1$
        
        "@pre", //$NON-NLS-1$
        
        "self", //$NON-NLS-1$
        "result", //$NON-NLS-1$
        
        "true", //$NON-NLS-1$
        "false", //$NON-NLS-1$
        "null", //$NON-NLS-1$
        "OclInvalid", //$NON-NLS-1$
        
        "and", //$NON-NLS-1$
        "or", //$NON-NLS-1$
        "xor", //$NON-NLS-1$
        "implies", //$NON-NLS-1$
        "not", //$NON-NLS-1$
        
        "let", //$NON-NLS-1$
        "in", //$NON-NLS-1$
        "if", //$NON-NLS-1$
        "then", //$NON-NLS-1$
        "else", //$NON-NLS-1$
        "endif", //$NON-NLS-1$
        
        "attr", //$NON-NLS-1$
        "oper", //$NON-NLS-1$
    };
    
    OCLKeywordRule() {
        super(new OCLKeywordDetector());
        
        IToken token = new Token(
            new TextAttribute(null, null, SWT.BOLD));
        
        for (String word : KEYWORDS) {
            addWord(word, token);
        }
    }
    
    private static class OCLKeywordDetector
        implements IWordDetector {
    
        public boolean isWordPart(char c) {
            return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
        }
    
        public boolean isWordStart(char c) {
            return c == '@' || isWordPart(c);
        }
    }
}

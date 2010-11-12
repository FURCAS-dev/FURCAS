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
 * $Id: OCLScanner.java,v 1.1 2007/04/30 12:39:31 cdamus Exp $
 */

package org.eclipse.emf.ocl.examples.interpreter.console.text;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.NumberRule;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;


/**
 * Syntax-highlighting scanner for OCL expressions.
 * 
 * @author Christian W. Damus (cdamus)
 */
class OCLScanner
    extends RuleBasedScanner {

    OCLScanner(ColorManager manager) {
        super();
        
        IToken literal = new Token(
            new TextAttribute(manager.getColor(ColorManager.LITERAL)));

        IRule[] rules = new IRule[7];

        // Add rule for strings
        rules[0] = new SingleLineRule("'", "'", literal); //$NON-NLS-1$ //$NON-NLS-2$

        // Keyword (and pseudo-keyword) rule
        rules[1] = new OCLKeywordRule();
        
        // Collection and Tuple Literal rules
        rules[2] = new OCLCollectionTupleRule(manager, false);
        rules[3] = new OCLCollectionTupleRule(manager, true);

        // identifier rule
        rules[4] = new OCLIdentifierRule();
        
        // Add a rule for numbers
        rules[5] = new NumberRule(literal);
        
        // Add generic whitespace rule
        rules[6] = new WhitespaceRule(new OCLWhitespaceDetector());
        
        setRules(rules);
    }
}

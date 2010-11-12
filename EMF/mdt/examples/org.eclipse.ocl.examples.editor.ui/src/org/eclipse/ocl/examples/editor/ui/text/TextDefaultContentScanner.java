/*******************************************************************************
 * Copyright (c) 2007,2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.editor.ui.text;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.ocl.examples.editor.ui.text.TextColorManager;
import org.eclipse.ocl.examples.editor.ui.text.TextWhitespaceDetector;

/**
 * Defines a scanner to process the residual NiceXSL partition.
 */
@Deprecated // Use UniversalTextEditor
public class TextDefaultContentScanner extends RuleBasedScanner {
    public TextDefaultContentScanner(TextColorManager colorManager) {
    	List<IRule> rules = new ArrayList<IRule>();
        rules.add(new SingleLineRule("\"", "\"",
            colorManager.getDoubleQuotedStringToken()));
        rules.add(new SingleLineRule("'", "'",
            colorManager.getSingleQuotedStringToken()));
		rules.add(new EndOfLineRule("\"", 					// Nice idea
			colorManager.getUnterminatedStringToken()));	//  doesn't work
		rules.add(new EndOfLineRule("\'", 					// Nice idea
			colorManager.getUnterminatedStringToken()));	//  doesn't work
		rules.add(new EndOfLineRule("--",
			colorManager.getSingleLineCommentToken()));
		rules.add(new EndOfLineRule("//",
			colorManager.getSingleLineCommentToken()));
     	// Add generic whitespace rule.
    	rules.add(new WhitespaceRule(new TextWhitespaceDetector()));
    	IRule[] result = new IRule[rules.size()];
    	rules.toArray(result);
    	setRules(result);
    }
}

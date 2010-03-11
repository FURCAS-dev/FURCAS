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

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;

/**
 * Defines the scanner that provides the top level partitioing of a document
 * into its contributory content, comment regions.
 */
@Deprecated // Use UniversalTextEditor
public class TextPartitionScanner extends RuleBasedPartitionScanner {
//	public final static String MULTI_LINE_COMMENT = "__multi_line_comment";
    private final static String[] configuredContentTypes =
        new String[] {
//            MULTI_LINE_COMMENT,
            IDocument.DEFAULT_CONTENT_TYPE };

	public TextPartitionScanner() {
		List<IPredicateRule> rules = new ArrayList<IPredicateRule>();
//		IToken multiLineComment = new Token(MULTI_LINE_COMMENT);
//		rules.add(new MultiLineRule("<!--", "-->", multiLineComment));
		IPredicateRule[] result = new IPredicateRule[rules.size()];
		rules.toArray(result);
		setPredicateRules(result);
	}
    
    public static String[] getConfiguredContentTypes() {
        return configuredContentTypes;
    }
}


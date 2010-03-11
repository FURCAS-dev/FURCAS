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

import org.eclipse.jface.text.rules.RuleBasedScanner;

/**
 * Defines a scanner to process an XML_SINGLE_LINE_COMMENT partition
 * starting with --.
 */
@Deprecated // Use UniversalTextEditor
public class TextSingleLineCommentScanner extends RuleBasedScanner {

    public TextSingleLineCommentScanner(TextColorManager manager) {}

}

/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: CompleteOCLUiModule.java,v 1.3 2010/05/29 15:30:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.ui;

import org.eclipse.ocl.examples.xtext.essentialocl.ui.syntaxcoloring.EssentialOCLHighlightingConfiguration;
import org.eclipse.ocl.examples.xtext.essentialocl.ui.syntaxcoloring.EssentialOCLSemanticHighlightingCalculator;
import org.eclipse.ocl.examples.xtext.oclstdlib.ui.model.BaseDocument;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;

/**
 * Use this class to register components to be used within the IDE.
 */
public class CompleteOCLUiModule extends AbstractCompleteOCLUiModule
{
	public CompleteOCLUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	public Class<? extends XtextDocument> bindXtextDocument() {
		return BaseDocument.class;
	}

	public Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
		return EssentialOCLSemanticHighlightingCalculator.class;
	}

	public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
		return EssentialOCLHighlightingConfiguration.class;
	}
}

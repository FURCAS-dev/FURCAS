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
 * $Id: EssentialOCLUiModule.java,v 1.2 2010/05/24 19:36:33 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.ui;

import org.eclipse.ocl.examples.xtext.essentialocl.ui.syntaxcoloring.EssentialOCLHighlightingConfiguration;
import org.eclipse.ocl.examples.xtext.essentialocl.ui.syntaxcoloring.EssentialOCLSemanticHighlightingCalculator;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;

/**
 * Use this class to register components to be used within the IDE.
 */
public class EssentialOCLUiModule extends org.eclipse.ocl.examples.xtext.essentialocl.ui.AbstractEssentialOCLUiModule {
	public EssentialOCLUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	public Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
		return EssentialOCLSemanticHighlightingCalculator.class;
	}

	public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
		return EssentialOCLHighlightingConfiguration.class;
	}
}

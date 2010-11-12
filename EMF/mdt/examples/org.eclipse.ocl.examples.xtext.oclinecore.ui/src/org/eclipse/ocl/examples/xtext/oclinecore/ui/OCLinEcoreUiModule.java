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
 * $Id: OCLinEcoreUiModule.java,v 1.6 2010/08/17 20:50:24 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.ui;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.ocl.examples.xtext.essentialocl.ui.syntaxcoloring.EssentialOCLHighlightingConfiguration;
import org.eclipse.ocl.examples.xtext.essentialocl.ui.syntaxcoloring.EssentialOCLSemanticHighlightingCalculator;
import org.eclipse.ocl.examples.xtext.oclinecore.ui.internal.OCLinEcoreActivator;
import org.eclipse.ocl.examples.xtext.oclinecore.ui.model.OCLinEcoreDocument;
import org.eclipse.ocl.examples.xtext.oclinecore.ui.model.OCLinEcoreDocumentProvider;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.model.IResourceForEditorInputFactory;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentProvider;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;

/**
 * Use this class to register components to be used within the IDE.
 */
public class OCLinEcoreUiModule extends org.eclipse.ocl.examples.xtext.oclinecore.ui.AbstractOCLinEcoreUiModule
{
	private static EMFPlugin.InternalHelper helper = new EMFPlugin.InternalHelper(OCLinEcoreActivator.getInstance());

	/**
	 * Return the optionally translated value of a plugin.properties key.
	 */
	public static String getString(String key, boolean translate) {
		return helper.getString(key, translate);
	}

	/**
	 * Return the optionally translated value of a plugin.properties key with substitutions.
	 */
	public static String getString(String key, Object [] substitutions, boolean translate) {
		return helper.getString(key, substitutions, translate);
	}

	public OCLinEcoreUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	public Class<? extends XtextDocument> bindXtextDocument() {
		return OCLinEcoreDocument.class;
	}

	public Class<? extends XtextDocumentProvider> bindXtextDocumentProvider() {
		return OCLinEcoreDocumentProvider.class;
	}

	public Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
		return EssentialOCLSemanticHighlightingCalculator.class;
	}

	public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
		return EssentialOCLHighlightingConfiguration.class;
	}

	@Override
	public Class<? extends IResourceForEditorInputFactory> bindIResourceForEditorInputFactory() {
		return OCLinEcoreResourceForEditorInputFactory.class;
	}
}

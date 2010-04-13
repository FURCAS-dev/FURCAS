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
 * $Id: OCLinEcoreUiModule.java,v 1.1 2010/04/13 06:41:28 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.ui;

import org.eclipse.ocl.examples.xtext.oclinecore.ui.model.OCLinEcoreDocument;
import org.eclipse.ocl.examples.xtext.oclinecore.ui.model.OCLinEcoreDocumentProvider;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.model.IResourceForEditorInputFactory;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentProvider;

/**
 * Use this class to register components to be used within the IDE.
 */
public class OCLinEcoreUiModule extends org.eclipse.ocl.examples.xtext.oclinecore.ui.AbstractOCLinEcoreUiModule
{
	public OCLinEcoreUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	public Class<? extends XtextDocument> bindXtextDocument() {
		return OCLinEcoreDocument.class;
	}

	public Class<? extends XtextDocumentProvider> bindXtextDocumentProvider() {
		return OCLinEcoreDocumentProvider.class;
	}

	public Class<? extends IResourceForEditorInputFactory> bindIResourceForEditorInputFactory() {
		return OCLinEcoreResourceForEditorInputFactory.class;
	}
}

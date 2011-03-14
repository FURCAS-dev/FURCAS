/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: XtextConsoleUiModule.java,v 1.1 2011/03/11 15:26:21 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.console;

import org.eclipse.ocl.examples.xtext.essentialocl.ui.EssentialOCLUiModule;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.model.edit.IssueModificationContext;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

/**
 * Use this class to register components to be used within the IDE.
 */
public class XtextConsoleUiModule extends EssentialOCLUiModule
{
	public XtextConsoleUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	public Class<? extends IssueModificationContext> bindIssueModificationContext() {
		return XtextConsoleIssueModificationContext.class;
	}

	@Override
	public Class<? extends IResourceSetProvider> bindIResourceSetProvider() {
		return XtextConsoleResourceSetProvider.class;
	}
}

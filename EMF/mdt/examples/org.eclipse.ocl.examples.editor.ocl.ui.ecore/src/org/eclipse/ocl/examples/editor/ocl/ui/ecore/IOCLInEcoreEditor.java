/**
 * <copyright>
 *
 * Copyright (c) 2010 Eclipse Modeling Project and others.
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
 * $Id: IOCLInEcoreEditor.java,v 1.2 2010/03/13 13:16:49 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ocl.ui.ecore;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.widgets.Display;

public interface IOCLInEcoreEditor
{
	EditingDomainActionBarContributor getActionBarContributor();

	OCLInEcoreParseController getParseController();
	
	ResourceSet getResourceSet();

	AdapterFactory getAdapterFactory();

	void createContextMenuFor(StructuredViewer contentOutlineViewer);

	Display getDisplay();
}

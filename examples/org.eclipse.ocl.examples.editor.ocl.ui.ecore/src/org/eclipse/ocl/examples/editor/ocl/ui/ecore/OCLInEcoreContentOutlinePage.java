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
 * $Id: OCLInEcoreContentOutlinePage.java,v 1.2 2010/03/13 13:16:49 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ocl.ui.ecore;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;

public class OCLInEcoreContentOutlinePage extends ContentOutlinePage
{
	protected final IOCLInEcoreEditor editor;

	/**
	 * This is the content outline page's viewer. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected TreeViewer contentOutlineViewer;

	/**
	 * This is a kludge... <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected IStatusLineManager contentOutlineStatusLineManager;
	
	public OCLInEcoreContentOutlinePage(IOCLInEcoreEditor editor) {
		this.editor = editor;		
	}
	
	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		contentOutlineViewer = getTreeViewer();
		contentOutlineViewer.addSelectionChangedListener(this);

		// Set up the tree viewer.
		//
		contentOutlineViewer
				.setContentProvider(new AdapterFactoryContentProvider(
						editor.getAdapterFactory()));
		contentOutlineViewer
				.setLabelProvider(new AdapterFactoryLabelProvider(
						editor.getAdapterFactory()));
		contentOutlineViewer.setInput(editor.getResourceSet());

		// Make sure our popups work.
		//
		editor.createContextMenuFor(contentOutlineViewer);

		EList<Resource> resources = editor.getResourceSet().getResources();
		if (!resources.isEmpty()) {
			// Select the root object in the view.
			//
			contentOutlineViewer
					.setSelection(new StructuredSelection(resources.get(0)), true);
		}
	}

	@Override
	public void makeContributions(IMenuManager menuManager,
			IToolBarManager toolBarManager,
			IStatusLineManager statusLineManager) {
		super.makeContributions(menuManager, toolBarManager,
				statusLineManager);
		contentOutlineStatusLineManager = statusLineManager;
	}

	@Override
	public void setActionBars(IActionBars actionBars) {
		super.setActionBars(actionBars);
		editor.getActionBarContributor().shareGlobalActions(this,
				actionBars);
	}

	public Viewer getContentOutlineViewer() {
		return contentOutlineViewer;
	}

	public IStatusLineManager getContentOutlineStatusLineManager() {
		return contentOutlineStatusLineManager;
	}
}
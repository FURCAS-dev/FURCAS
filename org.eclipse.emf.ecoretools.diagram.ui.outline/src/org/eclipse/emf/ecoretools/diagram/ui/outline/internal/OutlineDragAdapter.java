/***********************************************************************
 * Copyright (c) 2007 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 * 
 * $Id: OutlineDragAdapter.java,v 1.1 2008/05/26 12:26:56 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.ui.outline.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IWrapperItemProvider;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.ui.part.PluginTransfer;

/**
 * This Adapter listens to dragging operations and fill or clean the clipboard
 * with filtered datas. <br>
 * creation : 6 dec. 2004
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma </a>
 */
public class OutlineDragAdapter extends DragSourceAdapter {

	private ISelectionProvider selectionProvider;

	/**
	 * Constructs a new drag adapter.
	 * 
	 * @param provider
	 *            the object that provide the selected object
	 */
	public OutlineDragAdapter(ISelectionProvider provider) {
		selectionProvider = provider;
	}

	/**
	 * Return the available Transfer
	 * 
	 * @return Transfer[]
	 */
	public Transfer[] getSupportedDragTransfers() {
		Set<Transfer> supportedTypes = new LinkedHashSet<Transfer>();
		supportedTypes.add(PluginTransfer.getInstance());
		supportedTypes.add(LocalSelectionTransfer.getTransfer());

		Transfer[] transfers = supportedTypes.toArray(new Transfer[supportedTypes.size()]);
		return transfers;
	}

	/**
	 * Erase data from the clipboard object
	 * 
	 * @see org.eclipse.swt.dnd.DragSourceListener#dragFinished(org.eclipse.swt.dnd.DragSourceEvent)
	 */
	public void dragFinished(DragSourceEvent event) {
		LocalSelectionTransfer.getTransfer().setSelection(null);
	}

	/**
	 * @see org.eclipse.swt.dnd.DragSourceAdapter#dragSetData(org.eclipse.swt.dnd.DragSourceEvent)
	 */
	public void dragSetData(DragSourceEvent event) {
		ISelection selection = LocalSelectionTransfer.getTransfer().getSelection();

		if (LocalSelectionTransfer.getTransfer().isSupportedType(event.dataType)) {
			event.data = selection;

		} else if (PluginTransfer.getInstance().isSupportedType(event.dataType)) {
			// TODO Check this
			// event.data = NavigatorPluginDropAction
			// .createTransferData(contentService);
		} else {
			event.doit = false;
		}
	}

	/**
	 * Put selection on the clipboard object
	 * 
	 * @see org.eclipse.swt.dnd.DragSourceListener#dragStart(org.eclipse.swt.dnd.DragSourceEvent)
	 */
	public void dragStart(DragSourceEvent event) {
		try {
			// TODO What is this 1GEUS9V workaround exactly ? Removing the
			// following check would solve the problem of initializing the focus
			// to the navigator while it is not activated by default

			// Workaround for 1GEUS9V
			// DragSource dragSource = (DragSource) event.widget;
			// Control control = dragSource.getControl();
			// if (control == control.getDisplay().getFocusControl()) {
			ISelection selection = getSelection();
			if (!selection.isEmpty()) {
				LocalSelectionTransfer.getTransfer().setSelection(selection);
				event.doit = true;
			} else {
				event.doit = false;
			}
			// } else {
			// event.doit = false;
			// }
		} catch (RuntimeException e) {
			// TODO log exception
			// NavigatorPlugin.logError(0, e.getMessage(), e);
		}
	}

	/**
	 * Compute the outline selection : filter on selection, only model elements
	 * (displayed as GraphNode) can be dragged.
	 * 
	 * @return the list of selected model elements
	 */
	protected IStructuredSelection getSelection() {
		IStructuredSelection selection = (IStructuredSelection) selectionProvider.getSelection();
		List<Object> transferData = new ArrayList<Object>();
		Iterator<?> it = selection.iterator();
		while (it.hasNext()) {
			Object sel = it.next();

			// Ignore diagram objects
			if ((sel instanceof IWrapperItemProvider || sel instanceof FeatureMap.Entry || sel instanceof EObject) && !(sel instanceof View)) {
				transferData.add(AdapterFactoryEditingDomain.unwrap(sel));
			}
		}
		return new StructuredSelection(transferData);
	}

}

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
 * $Id: AbstractSectionLabelProvider.java,v 1.1 2008/05/26 12:25:13 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.tabbedproperties.providers;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.graphics.Image;

/**
 * An abstract labelProvider that is associated with the PropertyContributor of
 * a TabbedPropertiesView.
 * 
 * Creation 2 oct. 06
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public abstract class AbstractSectionLabelProvider extends LabelProvider {

	/**
	 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
	 */
	public Image getImage(Object element) {
		if (element == null || element.equals(StructuredSelection.EMPTY)) {
			return null;
		}
		Object selection = element;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (areDifferentTypes(structuredSelection)) {
				return null;
			}
			selection = structuredSelection.getFirstElement();
		}
		selection = AdapterFactoryEditingDomain.unwrap(selection);
		if (selection instanceof EObject || selection instanceof Resource) {
			return getAdapterFactoryLabelProvider().getImage(selection);
		}
		return null;
	}

	/**
	 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
	 */
	public String getText(Object element) {
		if (element == null || element.equals(StructuredSelection.EMPTY)) {
			return null;
		}
		Object selection = element;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (areDifferentTypes(structuredSelection)) {
				return structuredSelection.size() + " items selected";//$NON-NLS-1$
			}
			selection = structuredSelection.getFirstElement();
		}
		selection = AdapterFactoryEditingDomain.unwrap(selection);
		if (selection instanceof EObject) {
			return getAdapterFactoryLabelProvider().getText(selection);
		}

		return null;
	}

	/**
	 * Determine there are objects in the structured selection of different
	 * types.
	 * 
	 * @param structuredSelection
	 *            the structured selection.
	 * @return true if there are objects of different types in the selection.
	 */
	private boolean areDifferentTypes(IStructuredSelection structuredSelection) {
		if (structuredSelection.size() == 1) {
			return false;
		}
		Iterator<?> iter = structuredSelection.iterator();
		Object element = iter.next();
		while (iter.hasNext()) {
			if (iter.next().getClass() != element.getClass()) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Construct a new label provider factory if it is not null
	 * 
	 * @return the AdapterFactoryLabelProvider
	 */
	protected abstract ILabelProvider getAdapterFactoryLabelProvider();

}

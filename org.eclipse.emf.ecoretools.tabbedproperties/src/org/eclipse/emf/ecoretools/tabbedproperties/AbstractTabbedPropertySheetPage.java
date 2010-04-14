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
 * $Id: AbstractTabbedPropertySheetPage.java,v 1.1 2008/05/26 12:25:14 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.tabbedproperties;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * The property sheet page to implement to provide the tabbed UI.
 * 
 * Creation 4 august 06 Last Modified 17 august 06
 * 
 * @author <a href="alfredo@anyware-tech.com">Jose Alfredo SERRANO</a> *
 */
public class AbstractTabbedPropertySheetPage extends TabbedPropertySheetPage {

	/**
	 * This is the adapter factory used for providing views of the model.
	 */
	private AdapterFactory adapterFactory;

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage#TabbedPropertySheetPage(ITabbedPropertySheetPageContributor)
	 */
	public AbstractTabbedPropertySheetPage(ITabbedPropertySheetPageContributor tabbedPropertySheetPageContributor) {
		super(tabbedPropertySheetPageContributor);
	}

	/**
	 * This method creates a list of factories used by the editor. <br>
	 * 
	 * Resource, Ecore, GenModel, and Reflective adapter factories are added
	 * here
	 * 
	 * @return the factories' list
	 */
	public static List<? extends AdapterFactory> getPrincipalAdapterFactories() {
		List<AdapterFactory> factories = new ArrayList<AdapterFactory>();
		factories.add(new ResourceItemProviderAdapterFactory());
		factories.add(new EcoreItemProviderAdapterFactory());

		// REV Remove the Reflective adapter, this causes bad issues in labels
		// displayed
		// in the advanced tab when the corresponding factory is not added to
		// the list
		// factories.add(new ReflectiveItemProviderAdapterFactory());

		return factories;
	}

	/**
	 * This method creates the ComposedAdapterFactory that groups all the
	 * factories used by the editor. <br>
	 * <br>
	 * 
	 * @return the multi-factory
	 */
	protected ComposedAdapterFactory createAdapterFactory() {
		// Create an adapter factory that yields item providers.
		return new ComposedAdapterFactory(getAdapterFactories());
	}

	/**
	 * Get the EMF AdapterFactory from a workbench part.
	 * 
	 * @return the EMF AdapterFactory from a workbench part.
	 */
	public AdapterFactory getAdapterFactory() {
		if (adapterFactory == null) {
			adapterFactory = createAdapterFactory();
		}

		return adapterFactory;
	}

	/**
	 * @see org.eclipse.ui.ISelectionListener#selectionChanged(org.eclipse.ui.IWorkbenchPart,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		ISelection newSel = selection;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection ssel = (IStructuredSelection) selection;
			List<Object> selectedObjects = new ArrayList<Object>();
			for (Object element : ssel.toList()) {
				Object unwrapObj = AdapterFactoryEditingDomain.unwrap(element);
				selectedObjects.add(unwrapObj);
			}
			newSel = new StructuredSelection(selectedObjects);
		}

		super.selectionChanged(part, newSel);
	}

	/**
	 * <b>This method could be overridden to add specific factories before
	 * those. </b> <br>
	 * 
	 * @return List a list where contents are of type AdapterFactory
	 */
	protected List<? extends AdapterFactory> getAdapterFactories() {
		return getPrincipalAdapterFactories();
	}
}

/***********************************************************************
 * Copyright (c) 2007, 2008 INRIA and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    INRIA - initial API and implementation
 *
 * $Id: RegisteredPackageView.java,v 1.3 2008/05/12 21:53:04 lbigearde Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.registration.view;

import java.util.Iterator;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecoretools.registration.EMFRegistryHelper;
import org.eclipse.emf.ecoretools.registration.Messages;
import org.eclipse.emf.ecoretools.registration.internal.NsURIComparator;
import org.eclipse.emf.ecoretools.registration.internal.RegisteredPackageComparator;
import org.eclipse.emf.ecoretools.registration.popup.actions.CopyNSURIAction;
import org.eclipse.emf.ecoretools.registration.popup.actions.EcoreUnregisterPackageAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.ViewPart;

/**
 * View that displays the EMF registry and allows to unregister the EPackage
 * that have been manually registered by the user
 * 
 */
public class RegisteredPackageView extends ViewPart {

	/**
	 * Internal TreeViewer
	 */
	private TreeViewer viewer;

	// internal actions
	private EcoreUnregisterPackageAction unregisterPackageAction;

	private CopyNSURIAction copyNSURIAction;

	Clipboard clipboard;

	/**
	 * View ID
	 */
	public static final String ID = "org.eclipse.emf.ecoretools.registration.viewregisteredpackages"; //$NON-NLS-1$

	/**
	 * constructor
	 */
	public RegisteredPackageView() {
		super();
		setContentDescription(Messages.RegisteredPackageView_RegisteredPackages);
	}

	/**
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createPartControl(Composite parent) {

		Display display = PlatformUI.getWorkbench().getDisplay();
		clipboard = new Clipboard(display);

		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new RegisteredPackagesContentProvider());
		viewer.setLabelProvider(new RegisteredPackagesLabelProvider());
		viewer.setComparator(new NsURIComparator(RegisteredPackageComparator.ASCENDING_ORDER));

		createActions();
		createContextMenu();

		createColumns(viewer);
		viewer.setColumnProperties(new String[] { Messages.RegisteredPackageView_RegisteredURI, Messages.RegisteredPackageView_PackageName, Messages.RegisteredPackageView_Origin });

		viewer.getTree().setHeaderVisible(true);
		viewer.getTree().setLinesVisible(false);

		viewer.setInput(getViewSite());

		// connect action keys
		// enable ctrl + C copy action
		IActionBars bars = getViewSite().getActionBars();
		bars.setGlobalActionHandler(ActionFactory.COPY.getId(), this.copyNSURIAction);

	}

	/**
	 * used by createPartControl Creates the columns in the view
	 * 
	 * @param treeViewer
	 */
	private void createColumns(TreeViewer treeViewer) {
		TreeColumn column1 = new TreeColumn(treeViewer.getTree(), SWT.LEFT);
		column1.setText(Messages.RegisteredPackageView_RegisteredURI);
		column1.setWidth(300);
		column1.setResizable(true);
		column1.addSelectionListener(new PackageNsURIColumnSelectionListener(treeViewer));

		TreeColumn column2 = new TreeColumn(treeViewer.getTree(), SWT.LEFT);
		column2.setText(Messages.RegisteredPackageView_PackageName);
		column2.setWidth(120);
		column2.setResizable(true);
		column2.addSelectionListener(new PackageNameColumnSelectionListener(treeViewer));

		TreeColumn column3 = new TreeColumn(treeViewer.getTree(), SWT.LEFT);
		column3.setText(Messages.RegisteredPackageView_Origin);
		column3.setWidth(350);
		column3.setResizable(true);
	}

	/**
	 * used by createPartControl Create the actions
	 * 
	 */
	private void createActions() {
		IWorkbench workbench = PlatformUI.getWorkbench();
		ISharedImages platformImages = workbench.getSharedImages();
		unregisterPackageAction = new EcoreUnregisterPackageAction(this, Messages.RegisteredPackageView_Unregister);
		unregisterPackageAction.setImageDescriptor(platformImages.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
		unregisterPackageAction.setDisabledImageDescriptor(platformImages.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE_DISABLED));
		unregisterPackageAction.setToolTipText(Messages.RegisteredPackageView_UnregisterSelectedPackages);
		copyNSURIAction = new CopyNSURIAction(this, clipboard, Messages.RegisteredPackageView_CopyNsURI);
		copyNSURIAction.setImageDescriptor(platformImages.getImageDescriptor(ISharedImages.IMG_TOOL_COPY));
		copyNSURIAction.setToolTipText(Messages.RegisteredPackageView_CopyNsURI_tooltip);
	}

	/**
	 * used by createPartControl Create the contextMenu
	 * 
	 */
	private void createContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu"); //$NON-NLS-1$
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {

			public void menuAboutToShow(IMenuManager m) {
				RegisteredPackageView.this.fillContextMenu(m);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	/**
	 * used to create the context menu it is able to filter the actions
	 * corresponding to the selection ...
	 * 
	 * @param menuMgr
	 */
	private void fillContextMenu(IMenuManager menuMgr) {
		// filter only dynamically registered packages
		unregisterPackageAction.setEnabled(isSelectionDynamicallyRegistered((IStructuredSelection) viewer.getSelection()));
		menuMgr.add(unregisterPackageAction);
		menuMgr.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
		menuMgr.add(copyNSURIAction);
		menuMgr.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	/**
	 * get the selection
	 * 
	 * @return a table of the URI selected
	 */
	public EPackage[] getSelectedPackages() {
		IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
		EPackage[] items = new EPackage[selection.size()];
		Iterator<?> iter = selection.iterator();
		int index = 0;
		while (iter.hasNext()) {
			items[index++] = (EPackage) iter.next();
		}
		return items;
	}

	/**
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		// nothing to do

	}

	/**
	 * rebuild the view, also refresh its content from the ContentProvider
	 * 
	 */
	public void refresh() {
		viewer.refresh();
	}

	/**
	 * Checks if the selection is dynamically registered or not
	 * 
	 * @param selection
	 * @return true whether the selection is dynamically registered
	 */
	private boolean isSelectionDynamicallyRegistered(IStructuredSelection selection) {
		boolean result = true;

		if (selection.isEmpty()) {
			return false;
		}

		Iterator<?> iter = selection.iterator();
		while (iter.hasNext()) {
			EPackage p = (EPackage) iter.next();
			if (!EMFRegistryHelper.isDynamicallyRegistered(p.getNsURI())) {
				return false;
			}
		}
		return result;
	}
}

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
 * $Id: DiagramFilterActionMenu.java,v 1.4 2008/04/28 09:55:15 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.filters.internal.actions;

import org.eclipse.emf.ecoretools.filters.internal.FilterPlugin;
import org.eclipse.emf.ecoretools.filters.internal.Messages;
import org.eclipse.emf.ecoretools.filters.internal.extension.FilteredDiagramTypeExtensionManager;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

/**
 * 
 * TODO Describe the class here <br>
 * creation : 5 oct. 07
 * 
 * @author <a href="mailto:gilles.cannenterre@anyware-tech.com">Gilles
 *         Cannenterre</a>
 */
public class DiagramFilterActionMenu extends Action implements ISelectionChangedListener {

	private class MenuCreator implements IMenuCreator {

		/**
		 * @see org.eclipse.jface.action.IMenuCreator#dispose()
		 */
		public void dispose() {
			if (menu != null) {
				menu.dispose();
				menu = null;
			}
		}

		/**
		 * @see org.eclipse.jface.action.IMenuCreator#getMenu(org.eclipse.swt.widgets.Control)
		 */
		public Menu getMenu(Control parent) {
			if (menu != null) {
				menu.dispose();
			}
			menu = new Menu(parent);
			initialize();
			return menu;
		}

		/**
		 * @see org.eclipse.jface.action.IMenuCreator#getMenu(org.eclipse.swt.widgets.Menu)
		 */
		public Menu getMenu(Menu parent) {
			return null;
		}

		private void initialize() {
			// ActionContributionItem configure = new ActionContributionItem(
			// new ConfigureFilterDiagramAction());
			// configure.fill(menu, -1);
			//
			// ActionContributionItem apply = new ActionContributionItem(
			// new ApplyFilterDiagramAction());
			// apply.fill(menu, 1);

			ActionContributionItem hideSelectionAction = new ActionContributionItem(new HideSelectionAction());
			hideSelectionAction.fill(menu, -1);

			ActionContributionItem hideTypeAction = new ActionContributionItem(new HideTypeAction());
			hideTypeAction.fill(menu, 1);

			ActionContributionItem hideSemanticAction = new ActionContributionItem(new HideSemanticAction());
			hideSemanticAction.fill(menu, 2);

			ActionContributionItem showHiddenPartAction = new ActionContributionItem(new ShowHiddenPartAction());
			showHiddenPartAction.fill(menu, 3);

			new MenuItem(menu, SWT.SEPARATOR, 4);

			ActionContributionItem hideInheritanceTypeAction = new ActionContributionItem(new HideInheritanceTypeAction());
			hideInheritanceTypeAction.fill(menu, 5);

			ActionContributionItem hideReferenceTypeAction = new ActionContributionItem(new HideReferenceTypeAction());
			hideReferenceTypeAction.fill(menu, 6);
		}
	}

	public static String ID = "diagramFilterActionMenu"; //$NON-NLS-1$

	private Menu menu;

	protected IGraphicalEditPart host;

	public DiagramFilterActionMenu() {
		super("", AS_DROP_DOWN_MENU); //$NON-NLS-1$
		setId(ID);
		setText(Messages.DiagramFilterActionMenu_FilterElements);
		setToolTipText(Messages.DiagramFilterActionMenu_FilterElements_tooltip);
		setImageDescriptor(FilterPlugin.getImageDescriptor("icons/etool16/filter_edit.gif")); //$NON-NLS-1$
		setMenuCreator(new MenuCreator()); // set menu creator for sub menus
	}

	private Diagram getCurrentDiagram() {
		IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (false == editorPart instanceof DiagramEditor) {
			return null;
		}
		host = ((DiagramEditor) editorPart).getDiagramEditPart();
		if (false == host instanceof IGraphicalEditPart) {
			return null;
		}
		View view = (View) host.getModel();

		Diagram diagram = view.getDiagram();

		return diagram;
	}

	@Override
	public boolean isHandled() {
		Diagram diagram = getCurrentDiagram();
		if (diagram == null) {
			return false;
		}

		return (FilteredDiagramTypeExtensionManager.getInstance().getFilteredDiagramTypeExtension(diagram.getType()) != null);
	}

	@Override
	public void run() {
		// do something for top menu
	}

	/**
	 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
	 */
	public void selectionChanged(SelectionChangedEvent event) {
	}

}

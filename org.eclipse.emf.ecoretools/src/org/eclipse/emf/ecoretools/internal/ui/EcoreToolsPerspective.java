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
 * $Id: EcoreToolsPerspective.java,v 1.5 2008/04/28 15:49:07 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.internal.ui;

import org.eclipse.emf.ecoretools.internal.views.EClassHierarchyView;
import org.eclipse.emf.ecoretools.internal.views.EReferencesView;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.IViewLayout;
import org.eclipse.ui.navigator.resources.ProjectExplorer;

/**
 * This class defines the Ecore Tools perspective. Default views are :
 * <ul>
 * <li>Project Explorer</li>
 * <li>Outline</li>
 * <li>Properties</li>
 * <li>Problems</li>
 * <li>EClass Hierarchy</li>
 * <li>EClass Reference</li>
 * </ul>
 * 
 * @author <a href="jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class EcoreToolsPerspective implements IPerspectiveFactory {

	/**
	 * @see org.eclipse.ui.IPerspectiveFactory#createInitialLayout(org.eclipse.ui.IPageLayout)
	 */
	public void createInitialLayout(IPageLayout layout) {
		// Editors are placed for free.
		String editorArea = layout.getEditorArea();

		// Top Left
		layout.addView(ProjectExplorer.VIEW_ID, IPageLayout.LEFT, (float) 0.25, editorArea);
		IViewLayout explorer = layout.getViewLayout(ProjectExplorer.VIEW_ID);
		explorer.setCloseable(false);

		// Bottom Left
		layout.addView(IPageLayout.ID_OUTLINE, IPageLayout.BOTTOM, (float) 0.50, ProjectExplorer.VIEW_ID);
		IViewLayout outline = layout.getViewLayout(IPageLayout.ID_OUTLINE);
		outline.setCloseable(false);

		// Bottom
		IFolderLayout bottom = layout.createFolder("bottom", IPageLayout.BOTTOM, (float) 0.70, editorArea); //$NON-NLS-1$
		bottom.addView(IPageLayout.ID_PROP_SHEET);
		bottom.addView(IPageLayout.ID_PROBLEM_VIEW);
		IViewLayout properties = layout.getViewLayout(IPageLayout.ID_PROP_SHEET);
		properties.setCloseable(false);

		// Bottom Right
		IFolderLayout right = layout.createFolder("bottomRight", IPageLayout.RIGHT, (float) 0.60, "bottom"); //$NON-NLS-1$ //$NON-NLS-2$
		right.addView(EClassHierarchyView.VIEW_ID);
		right.addView(EReferencesView.VIEW_ID);
	}

}

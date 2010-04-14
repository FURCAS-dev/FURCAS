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
 * $Id: PackageNameColumnSelectionListener.java,v 1.3 2008/05/12 21:51:57 lbigearde Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.registration.view;

import org.eclipse.emf.ecoretools.registration.internal.PackageNameComparator;
import org.eclipse.emf.ecoretools.registration.internal.RegisteredPackageComparator;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

/**
 * Listener for the selection in the Package name column
 */
public class PackageNameColumnSelectionListener implements SelectionListener {

	private TreeViewer viewer = null;

	/**
	 * Constructor
	 * 
	 * @param viewer
	 */
	public PackageNameColumnSelectionListener(TreeViewer viewer) {
		this.viewer = viewer;
	}

	/**
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetSelected(SelectionEvent e) {
		ViewerComparator newComparator = null;
		ViewerComparator comparator = viewer.getComparator();

		if (comparator instanceof PackageNameComparator) {
			if (((PackageNameComparator) comparator).getOrder() == RegisteredPackageComparator.ASCENDING_ORDER)
				newComparator = new PackageNameComparator(RegisteredPackageComparator.DESCENDING_ORDER);
			else if (((PackageNameComparator) comparator).getOrder() == RegisteredPackageComparator.DESCENDING_ORDER)
				newComparator = new PackageNameComparator(RegisteredPackageComparator.ASCENDING_ORDER);
		} else
			newComparator = new PackageNameComparator(RegisteredPackageComparator.ASCENDING_ORDER);

		if (newComparator != null)
			viewer.setComparator(newComparator);
	}

	/**
	 * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetDefaultSelected(SelectionEvent e) {
		// nothing to do

	}

}

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
 * $Id: PackageNsURIColumnSelectionListener.java,v 1.3 2008/05/12 21:52:15 lbigearde Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.registration.view;

import org.eclipse.emf.ecoretools.registration.internal.NsURIComparator;
import org.eclipse.emf.ecoretools.registration.internal.RegisteredPackageComparator;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

/**
 * Listener for the selection in the Package NsURI column
 */
public class PackageNsURIColumnSelectionListener implements SelectionListener {

	private TreeViewer viewer = null;

	/**
	 * Constructor
	 * 
	 * @param treeViewer 
	 */
	public PackageNsURIColumnSelectionListener(TreeViewer treeViewer) {
		this.viewer = treeViewer;
	}

	/**
	 * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetDefaultSelected(SelectionEvent e) {
		// Do nothing
	}

	/**
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetSelected(SelectionEvent e) {
		ViewerComparator newComparator = null;
		ViewerComparator comparator = viewer.getComparator();

		if (comparator instanceof NsURIComparator) {
			if (((NsURIComparator) comparator).getOrder() == RegisteredPackageComparator.ASCENDING_ORDER)
				newComparator = new NsURIComparator(RegisteredPackageComparator.DESCENDING_ORDER);
			else if (((NsURIComparator) comparator).getOrder() == RegisteredPackageComparator.DESCENDING_ORDER)
				newComparator = new NsURIComparator(RegisteredPackageComparator.ASCENDING_ORDER);
		} else
			newComparator = new NsURIComparator(RegisteredPackageComparator.ASCENDING_ORDER);

		if (newComparator != null)
			viewer.setComparator(newComparator);
	}

}

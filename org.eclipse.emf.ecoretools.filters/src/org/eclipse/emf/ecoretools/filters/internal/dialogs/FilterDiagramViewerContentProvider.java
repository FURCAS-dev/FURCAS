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
 * $Id: FilterDiagramViewerContentProvider.java,v 1.2 2008/04/28 09:55:15 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.filters.internal.dialogs;

import java.util.Collections;
import java.util.Map;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * 
 * TODO Describe the class here <br>
 * creation : 14 nov. 07
 * 
 * @author <a href="mailto:gilles.cannenterre@anyware-tech.com">Gilles
 *         Cannenterre</a>
 */
public class FilterDiagramViewerContentProvider implements ITreeContentProvider {

	public void dispose() {
	}

	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof Map) {
			return ((Map<?, ?>) parentElement).keySet().toArray();
		}

		return Collections.EMPTY_LIST.toArray();
	}

	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	public Object getParent(Object element) {
		return null;
	}

	public boolean hasChildren(Object element) {
		if (element instanceof Map) {
			return !((Map<?, ?>) element).keySet().isEmpty();
		}
		return false;
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}
}
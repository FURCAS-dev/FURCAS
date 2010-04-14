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
 * $Id: FilterDiagramViewerLabelProvider.java,v 1.2 2008/04/28 09:55:15 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.filters.internal.dialogs;

import org.eclipse.emf.ecoretools.filters.internal.utils.DiagramFilterUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * 
 * TODO Describe the class here <br>
 * creation : 14 nov. 07
 * 
 * @author <a href="mailto:gilles.cannenterre@anyware-tech.com">Gilles
 *         Cannenterre</a>
 */
public class FilterDiagramViewerLabelProvider extends LabelProvider {

	private Diagram diagram;

	public FilterDiagramViewerLabelProvider(Diagram diagram) {
		this.diagram = diagram;
	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof String) {
			return DiagramFilterUtil.getDiagramElementImage(diagram, (String) element);
		}
		return null;
	}

	@Override
	public String getText(Object element) {
		if (element instanceof String) {
			return DiagramFilterUtil.getDiagramElementName(diagram, (String) element);
		}
		return null;
	}
}

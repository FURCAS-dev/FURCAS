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
 * $Id: FilteredDiagramTypeExtension.java,v 1.2 2008/04/28 09:55:15 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.filters.internal.extension;

import org.eclipse.emf.ecoretools.filters.diagramfilters.IDiagramFilter;

/**
 * 
 * TODO Describe the class here <br>
 * creation : 4 oct. 07
 * 
 * @author <a href="mailto:gilles.cannenterre@anyware-tech.com">Gilles
 *         Cannenterre</a>
 */
public class FilteredDiagramTypeExtension {

	private String modelId;

	private IDiagramFilter diagramFilter;

	public FilteredDiagramTypeExtension(String modelId) {
		this.modelId = modelId;
	}

	public IDiagramFilter getDiagramFilter() {
		return diagramFilter;
	}

	public String getModelId() {
		return modelId;
	}

	public void setDiagramFilter(IDiagramFilter diagramFilter) {
		this.diagramFilter = diagramFilter;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}
}

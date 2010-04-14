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
 * $Id: IDiagramFilter.java,v 1.2 2008/04/28 09:55:15 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.filters.diagramfilters;

import java.util.List;
import java.util.Map;

/**
 * 
 * TODO Describe the class here <br>
 * creation : 4 oct. 07
 * 
 * @author <a href="mailto:gilles.cannenterre@anyware-tech.com">Gilles
 *         Cannenterre</a>
 */
public interface IDiagramFilter {

	/**
	 * Fetch the list containing all the filtered types
	 * 
	 * @return list
	 */
	public List<String> getCurrentFilteredTypeConfiguration();

	/**
	 * Associates in a map filtered type and names
	 * 
	 * @return map
	 */
	public Map<String, String> getFilteredTypeDescription();

	/**
	 * Persist the list containing all the filtered types
	 * 
	 * @return list
	 */
	public void setCurrentFilteredTypeConfiguration(List<String> filteredTypes);

}

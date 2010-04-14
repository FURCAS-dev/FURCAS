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
 * $Id: DiagramFilterUtil.java,v 1.3 2008/04/28 09:55:15 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.filters.internal.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecoretools.filters.diagramfilters.IDiagramFilter;
import org.eclipse.emf.ecoretools.filters.internal.FilterPlugin;
import org.eclipse.emf.ecoretools.filters.internal.extension.FilteredDiagramTypeExtension;
import org.eclipse.emf.ecoretools.filters.internal.extension.FilteredDiagramTypeExtensionManager;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Image;

/**
 * 
 * TODO Describe the class here <br>
 * creation : 4 oct. 07
 * 
 * @author <a href="mailto:gilles.cannenterre@anyware-tech.com">Gilles
 *         Cannenterre</a>
 */
public class DiagramFilterUtil {

	/**
	 * 
	 */
	public static String DIAGRAM_FILTER_STRING_DELIMITER = ";"; //$NON-NLS-1$

	/**
	 * 
	 * @param diagram
	 * @return
	 */
	public static List<String> getAllPossibleFilteredType(Diagram diagram) {
		if (diagram == null) {
			return Collections.emptyList();
		}
		FilteredDiagramTypeExtension filteredDiagramTypeExtension = FilteredDiagramTypeExtensionManager.getInstance().getFilteredDiagramTypeExtension(diagram.getType());
		if (filteredDiagramTypeExtension == null) {
			return Collections.emptyList();
		}
		IDiagramFilter diagramFilter = filteredDiagramTypeExtension.getDiagramFilter();
		if (diagramFilter == null) {
			return Collections.emptyList();
		}

		List<String> keyEntries = new ArrayList<String>();
		for (String key : diagramFilter.getFilteredTypeDescription().keySet()) {
			StringTokenizer stringTokenizer = new StringTokenizer(key, DIAGRAM_FILTER_STRING_DELIMITER);

			while (stringTokenizer.hasMoreTokens()) {
				keyEntries.add(stringTokenizer.nextToken());
			}
		}
		return keyEntries;
	}

	/**
	 * 
	 * @param diagram
	 * @return
	 */
	public static List<String> getCurrentFilteredTypeConfiguration(Diagram diagram) {
		if (diagram == null) {
			return Collections.emptyList();
		}
		FilteredDiagramTypeExtension filteredDiagramTypeExtension = FilteredDiagramTypeExtensionManager.getInstance().getFilteredDiagramTypeExtension(diagram.getType());
		if (filteredDiagramTypeExtension == null) {
			return Collections.emptyList();
		}
		IDiagramFilter diagramFilter = filteredDiagramTypeExtension.getDiagramFilter();
		if (diagramFilter == null) {
			return Collections.emptyList();
		}

		return diagramFilter.getCurrentFilteredTypeConfiguration();
	}

	/**
	 * 
	 * @param diagram
	 * @param element
	 * @return
	 */
	public static Image getDiagramElementImage(Diagram diagram, String element) {

		return FilterPlugin.getInstance().getImage("obj16/diagramelement_obj.gif"); //$NON-NLS-1$
	}

	/**
	 * 
	 * @param diagram
	 * @param element
	 * @return
	 */
	public static String getDiagramElementName(Diagram diagram, String element) {
		if (false == getDiagramFilteredTypeDescription(diagram).isEmpty()) {
			return getDiagramFilteredTypeDescription(diagram).get(element);
		}
		return "???"; //$NON-NLS-1$
	}

	/**
	 * 
	 * @param diagram
	 * @return
	 */
	public static Map<String, String> getDiagramFilteredTypeDescription(Diagram diagram) {
		if (diagram == null) {
			return Collections.emptyMap();
		}
		FilteredDiagramTypeExtension filteredDiagramTypeExtension = FilteredDiagramTypeExtensionManager.getInstance().getFilteredDiagramTypeExtension(diagram.getType());
		if (filteredDiagramTypeExtension == null) {
			return Collections.emptyMap();
		}
		IDiagramFilter diagramFilter = filteredDiagramTypeExtension.getDiagramFilter();
		if (diagramFilter == null) {
			return Collections.emptyMap();
		}

		return diagramFilter.getFilteredTypeDescription();
	}

	/**
	 * 
	 * @param diagramToFilter
	 * @return
	 */
	public static boolean isDiagramFiltered(Diagram diagramToFilter) {
		List<String> allTypes = getAllPossibleFilteredType(diagramToFilter);
		for (TreeIterator<EObject> it = diagramToFilter.eAllContents(); it.hasNext();) {
			EObject currentDiagramElement = it.next();
			if (false == currentDiagramElement instanceof View) {
				continue;
			}
			// if visibility of filtered type is false
			if (false == isFilteredType((View) currentDiagramElement, allTypes)) {
				continue;
			}
			if (false == ((View) currentDiagramElement).isVisible()) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Returns true if view is in list types to filter
	 * 
	 * @param view
	 * @param typesToFilter
	 * @return true if in list
	 */
	public static boolean isFilteredType(View view, List<String> typesToFilter) {
		return typesToFilter.contains(view.getType());
	}

	/**
	 * 
	 * @param key
	 * @param savedConfiguration
	 * @return
	 */
	public static boolean isInKey(String key, List<String> savedConfiguration) {
		List<String> keyEntries = new ArrayList<String>();

		StringTokenizer stringTokenizer = new StringTokenizer(key, DIAGRAM_FILTER_STRING_DELIMITER);
		while (stringTokenizer.hasMoreTokens()) {
			keyEntries.add(stringTokenizer.nextToken());
		}

		for (String innerKey : keyEntries) {
			if (savedConfiguration.contains(innerKey)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param diagram
	 * @param result
	 */
	public static void setCurrentFilteredTypeConfiguration(Diagram diagram, List<String> result) {
		if (diagram == null) {
			return;
		}
		FilteredDiagramTypeExtension autosarFilteredDiagramTypeExtension = FilteredDiagramTypeExtensionManager.getInstance().getFilteredDiagramTypeExtension(diagram.getType());
		if (autosarFilteredDiagramTypeExtension == null) {
			return;
		}
		IDiagramFilter diagramFilter = autosarFilteredDiagramTypeExtension.getDiagramFilter();
		if (diagramFilter == null) {
			return;
		}

		diagramFilter.setCurrentFilteredTypeConfiguration(result);
	}

	/**
	 * 
	 */
	public static boolean isFilteredSemantic(View view, List<EObject> typesToFilter) {
		if (view == null) {
			return false;
		}
		return typesToFilter.contains(view.getElement());
	}

}

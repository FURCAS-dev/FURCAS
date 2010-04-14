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
 * $Id: AbstractDiagramFilter.java,v 1.2 2008/04/28 09:55:15 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.filters.diagramfilters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

import org.eclipse.emf.ecoretools.filters.internal.utils.DiagramFilterUtil;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * 
 * TODO Describe the class here <br>
 * creation : 4 oct. 07
 * 
 * @author <a href="mailto:gilles.cannenterre@anyware-tech.com">Gilles
 *         Cannenterre</a>
 */
public abstract class AbstractDiagramFilter implements IDiagramFilter {

	/**
	 * 
	 */
	private static String DIAGRAM_FILTER_PREFERENCE_STORE_KEY = "DiagramFilterPreferenceStoreKey"; //$NON-NLS-1$

	private Map<String, String> filteredType = new TreeMap<String, String>();

	public AbstractDiagramFilter() {
		initializeMap();
	}

	/**
	 * 
	 */
	public List<String> getCurrentFilteredTypeConfiguration() {
		return readFilteredTypes(getPreferenceStore());
	}

	/**
	 * 
	 */
	public Map<String, String> getFilteredTypeDescription() {
		return getFilteredTypeMap();
	}

	/**
	 * 
	 * @return
	 */
	public Map<String, String> getFilteredTypeMap() {
		return filteredType;
	}

	abstract public Collection<IElementType> getIElementTypes();

	/**
	 * 
	 * @return
	 */
	abstract public IPreferenceStore getPreferenceStore();

	/**
	 * 
	 */
	protected void initializeMap() {
		for (Object object : getIElementTypes()) {
			if (false == object instanceof IElementType) {
				continue;
			}
			IElementType elementType = (IElementType) object;
			String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
			if (elementTypeHint == null || elementTypeHint.length() < 1) {
				continue;
			}
			String nameValue = elementType.getDisplayName() + " - " + elementTypeHint; //$NON-NLS-1$

			filteredType.put(elementTypeHint, nameValue);
		}
	}

	/**
	 * 
	 * @param store
	 * @return
	 */
	protected List<String> readFilteredTypes(IPreferenceStore store) {
		String storedValue = store.getString(DIAGRAM_FILTER_PREFERENCE_STORE_KEY);
		if (storedValue == null) {
			return Collections.emptyList();
		}
		List<String> result = new ArrayList<String>();
		StringTokenizer stringTokenizer = new StringTokenizer(storedValue, DiagramFilterUtil.DIAGRAM_FILTER_STRING_DELIMITER);
		while (stringTokenizer.hasMoreTokens()) {
			result.add(stringTokenizer.nextToken());
		}
		return result;
	}

	/**
	 * 
	 */
	public void setCurrentFilteredTypeConfiguration(List<String> filteredTypes) {
		writeFilteredTypes(filteredTypes, getPreferenceStore());
	}

	/**
	 * 
	 * @param filteredTypes
	 * @param store
	 */
	protected void writeFilteredTypes(List<String> filteredTypes, IPreferenceStore store) {
		String storedValue = ""; //$NON-NLS-1$
		for (String currentType : filteredTypes) {
			storedValue = storedValue + DiagramFilterUtil.DIAGRAM_FILTER_STRING_DELIMITER + currentType;
		}
		store.setValue(DIAGRAM_FILTER_PREFERENCE_STORE_KEY, storedValue);
	}

}

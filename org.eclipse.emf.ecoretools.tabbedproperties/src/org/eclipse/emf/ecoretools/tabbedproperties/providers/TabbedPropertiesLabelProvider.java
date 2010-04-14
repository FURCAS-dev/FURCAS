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
 * $Id: TabbedPropertiesLabelProvider.java,v 1.1 2008/05/26 12:25:13 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.tabbedproperties.providers;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

/**
 * A Label Provider that formats the provided String text The text will be
 * displayed like:
 * 
 * <code>FEATURENAME : CLASSNAME - MODELNAME</code>
 * 
 * @author alfredo
 * 
 */
public class TabbedPropertiesLabelProvider extends AdapterFactoryLabelProvider {

	/**
	 * Constructor
	 * 
	 * @param adapterFactory
	 */
	public TabbedPropertiesLabelProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This method overrides the AdapterFactoryLabelProvider getText method in
	 * order to obtain the desired label values. The returned string will have
	 * the StructuralFeature with a description of its EcoreClass and its model.
	 * 
	 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider#getText(Object)
	 */
	public String getText(Object object) {
		String resultText = null;
		if (object instanceof String) {
			// When the given object is a string we return it
			resultText = (String) object;
		}

		// This is the case of references between EcoreItems.
		// When no resultText applies for this EObject
		// we adapt try to adapt it with the EcoreItemProviderAdapterFactory.
		if (resultText == null) {
			resultText = super.getText(object);
		}
		return resultText;
	}
}
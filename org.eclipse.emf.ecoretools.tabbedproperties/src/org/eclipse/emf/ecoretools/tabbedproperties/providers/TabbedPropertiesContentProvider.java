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
 * $Id: TabbedPropertiesContentProvider.java,v 1.1 2008/05/26 12:25:13 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.tabbedproperties.providers;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecoretools.tabbedproperties.utils.ObjectAdapter;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.ui.views.properties.IPropertySource;

/**
 * Creation 19 sept. 06
 * 
 * @author alfredo
 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider
 */
public class TabbedPropertiesContentProvider extends AdapterFactoryContentProvider {

	/**
	 * This constructs an instance that wraps this factory.
	 * 
	 * @param adapterFactory
	 */
	public TabbedPropertiesContentProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#getPropertySource(java.lang.Object)
	 */
	public IPropertySource getPropertySource(Object object) {
		EObject eObject = ObjectAdapter.adaptObject(object);
		if (eObject != null) {
			return super.getPropertySource(eObject);
		}
		return super.getPropertySource(object);
	}
}

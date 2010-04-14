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
 * $Id: TabbedPropertiesTypeMapper.java,v 1.2 2008/04/28 08:41:33 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.sheet;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.views.properties.tabbed.AbstractTypeMapper;

/**
 * An implementation of AbstractTypeMapper. This class matches the type of
 * selected objects inside the workbench part with the input type attributes
 * defined in the PropertySection extensions. We can either match objects from a
 * tree editor or elements based on Eclipse GEF like EditParts.
 * 
 * Creation 19 sept. 06
 * 
 * @author Alfredo Serrano
 * 
 */
public class TabbedPropertiesTypeMapper extends AbstractTypeMapper {

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractTypeMapper#mapType(java.lang.Object)
	 */
	@Override
	public Class<?> mapType(Object object) {

		EObject eObject = ObjectAdapter.adaptObject(object);
		if (eObject != null) {
			return eObject.getClass();
		}
		return super.mapType(object);
	}
}

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
 * $Id: ModelElementComparer.java,v 1.1 2008/05/26 12:26:56 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.ui.outline.internal;

import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.viewers.IElementComparer;

/**
 * A Comparer of the EMF model objects. Model objects are first unwrapped.
 * 
 * Creation : 31 janv. 2006
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class ModelElementComparer implements IElementComparer {

	/**
	 * @see org.eclipse.jface.viewers.IElementComparer#equals(java.lang.Object,
	 *      java.lang.Object)
	 */
	public boolean equals(Object a, Object b) {
		return AdapterFactoryEditingDomain.unwrap(a).equals(AdapterFactoryEditingDomain.unwrap(b));
	}

	/**
	 * @see org.eclipse.jface.viewers.IElementComparer#hashCode(java.lang.Object)
	 */
	public int hashCode(Object element) {
		return element.hashCode();
	}

}

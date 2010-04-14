/***********************************************************************
 * Copyright (c) 2008 Anyware Technologies and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 * 
 * $Id: IMarkerReader.java,v 1.1 2008/05/26 12:26:55 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.ui.outline.decorator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;

/**
 * An interface used to define
 */
public interface IMarkerReader {

	/**
	 * Used to retrieve the MarkerType
	 * 
	 * @return String the markerType
	 */
	String getMarkerType();

	/**
	 * Get an IStatus from the markers associated with the given EObject
	 * 
	 * @param object
	 *            the EObject
	 * @return a MultiStatus composed by the list of status from markers
	 */
	IStatus getStatus(EObject object);

}

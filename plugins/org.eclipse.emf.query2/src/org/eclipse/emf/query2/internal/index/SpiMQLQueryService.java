/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query2.internal.index;

/**
 * Each facility has to implement at least one MQL facility service.
 * <p>
 * This interface (more precisely on of its subinterfaces) <i>is</i> intended to
 * be implemented by service providers.
 * 
 * @see SpiCoreQueryService
 * @author D045917
 */
@Deprecated
public interface SpiMQLQueryService {

	/**
	 * Returns the facility id, e.g. "PF".
	 * 
	 * @return The id of the facility.
	 * @deprecated
	 */
	@Deprecated
	public String getFacilityId();
}

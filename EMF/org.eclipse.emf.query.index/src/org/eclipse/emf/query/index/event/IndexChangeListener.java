/*******************************************************************************
 * Copyright (c) 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query.index.event;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * @author Martin Strenge, SAP AG
 * @author Bernd Kolb, SAP AG
 */
public interface IndexChangeListener {

	void indexChanged(IndexChangeEvent event);
}
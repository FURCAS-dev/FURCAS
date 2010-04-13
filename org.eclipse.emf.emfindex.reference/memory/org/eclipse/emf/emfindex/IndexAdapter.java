/*******************************************************************************
s * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex;

import org.eclipse.emf.common.notify.Notification;

/**
 * Used to store additional data to optimize specific queries. It is registered to
 * a content adapter of the index's resource set to be able to update its data on
 * changes.
 * 
 * @author koehnlein
 */
public interface IndexAdapter {

	/**
	 * Clears all state associated with this adapter.
	 */
	void clear();
	
	void notifyChanged(Notification notification);

}

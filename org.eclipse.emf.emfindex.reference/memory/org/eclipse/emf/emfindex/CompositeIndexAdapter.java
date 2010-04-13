/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;

import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class CompositeIndexAdapter extends EContentAdapter {

	private List<IndexAdapter> indexAdapters;

	private boolean isActive;

	@Inject
	private Logger logger;
	
	public CompositeIndexAdapter() {
		indexAdapters = new ArrayList<IndexAdapter>();
		isActive = true;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		if (isActive) {
			for (IndexAdapter cachedScope : indexAdapters) {
				cachedScope.notifyChanged(notification);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public <T extends IndexAdapter> T indexAdapter(Class<T> adapterClass) {
		for (IndexAdapter registeredAdapters : indexAdapters) {
			if (registeredAdapters.getClass().equals(adapterClass))
				return (T) registeredAdapters;
		}
		try {
			T newIndexAdapter = adapterClass.newInstance();
			indexAdapters.add(newIndexAdapter);
			return newIndexAdapter;
		} catch (Exception e) {
			logger.logError("Error instantiating IndexAdapter" , e);
			return null;
		}
	}
	
	public void clear() {
		for (IndexAdapter indexCache : indexAdapters) {
			indexCache.clear();
		}
	}
	
}
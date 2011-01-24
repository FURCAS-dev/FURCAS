/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: AliasAdapter.java,v 1.2 2011/01/24 20:42:33 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.utilities;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * An AliasAdapter extends a Resource to provide a set of aliases for elements,
 * typically packages, contained within that Resource. Use of an alias as the moniker
 * for a package simplifies the moniker and avoids prefix variation for monikers
 * computed for alternate domains.
 */
public class AliasAdapter extends AdapterImpl
{
	private static final Logger logger = Logger.getLogger(AliasAdapter.class);

	public static interface Creator
	{
		Map<EObject, String> computeAliasMap(Resource resource);
		void refreshAliases(Resource resource);
		void refreshAliases(Collection<? extends Resource> resources);
		String getAlias(EObject eObject);
		EObject getAliasTarget(EObject eObject);
	}

	public static abstract class AbstractCreator implements Creator
	{
		public Map<EObject, String> computeAliasMap(Resource resource) {
			Map<EObject, String> aliasMap = null;
			for (TreeIterator<EObject> tit = resource.getAllContents(); tit.hasNext(); ) { // FIXME just packages
				EObject eObject = tit.next();
				String newAlias = getAlias(eObject);
				if (newAlias != null) {
					if (aliasMap == null) {
						aliasMap = new HashMap<EObject, String>();
					}
					EObject target = getAliasTarget(eObject);
					String oldAlias = aliasMap.get(target);
					if (oldAlias == null) {
						aliasMap.put(target, newAlias);
					}
					else {
						logger.warn("Conflicting aliases '" + newAlias + "' and '" + oldAlias + "'");
					}
				}
			}
			return aliasMap;
		}

		public EObject getAliasTarget(EObject eObject) {
			return eObject;
		}
		
		public void refreshAliases(Resource resource) {
			Map<EObject, String> aliasMap = computeAliasMap(resource);
			if (aliasMap != null) {
				AliasAdapter adapter = getAdapter(resource);
				adapter.refreshMap(aliasMap);
			}		
		}
		
		public void refreshAliases(Collection<? extends Resource> resources) {
			for (Resource resource : resources) {
				refreshAliases(resource);
			}
		}
	}

	public static AliasAdapter findAdapter(Resource resource) {
		if (resource == null) {
			return null;
		}
		return PivotUtil.getAdapter(AliasAdapter.class, resource);
	}

	public static AliasAdapter getAdapter(Resource resource) {
		if (resource == null) {
			return null;
		}
		List<Adapter> eAdapters = resource.eAdapters();
		AliasAdapter adapter = PivotUtil.getAdapter(AliasAdapter.class, eAdapters);
		if (adapter == null) {
			adapter = new AliasAdapter();
			eAdapters.add(adapter);
		}
		return adapter;
	}

	public static String getAlias(EObject eElement) {
		String alias = null;
		AliasAdapter adapter = AliasAdapter.findAdapter(eElement.eResource());
		if (adapter != null) {
			alias = adapter.getAliasMap().get(eElement);
		}
		return alias;
	}

	private Map<EObject, String> aliasMap = new HashMap<EObject, String>();

//	public String getAlias(EObject eObject) {
//		return aliasMap.get(eObject);
//	}

	public Map<EObject, String> getAliasMap() {
		return aliasMap;
	}
	
	@Override
	public boolean isAdapterForType(Object type) {
		return type == AliasAdapter.class;
	}

//	public String putAlias(EObject eObject, String alias) {
//		assert eObject.eResource() == target;
//		return aliasMap.put(eObject, alias);
//	}
	
	public void refreshMap(Map<EObject, String> map) {
		aliasMap = map;
	}
}
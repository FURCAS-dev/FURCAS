/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
 * $Id: AliasAnalysis.java,v 1.2 2011/01/24 21:00:30 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.pivot2cs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.util.Pivotable;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

/**
 * An AliasAnalysis is dynamically created to support the serialization
 * of cross-references following a Pivot to CS conversion. It ensures the
 * resource-wide uniqueness of aliases for package names.
 */
public class AliasAnalysis extends AdapterImpl
{
	public static void dispose(Resource resource) {
		if (resource != null) {
			List<Adapter> eAdapters = resource.eAdapters();
			AliasAnalysis adapter = PivotUtil.getAdapter(AliasAnalysis.class, eAdapters);
			if (adapter != null) {
				adapter.dispose();
			}
		}
	}

	public static AliasAnalysis getAdapter(Resource resource) {
//		Resource resource = eObject.eResource();
		if (resource == null) {
			return null;
		}
		List<Adapter> eAdapters = resource.eAdapters();
		AliasAnalysis adapter = PivotUtil.getAdapter(AliasAnalysis.class, eAdapters);
		if (adapter == null) {
			adapter = new AliasAnalysis(resource);
			adapter.computePackages();
			adapter.computeAliases();
		}
		return adapter;
	}

	/**
	 * Mapping of all named elements from the name to the name usage,
	 * which is non-null for a uniquely named element, or
	 * null for a shared name.
	 */
	private Map<String, EObject> allNames = new HashMap<String, EObject>();
	private Set<org.eclipse.ocl.examples.pivot.Package> localPackages = new HashSet<org.eclipse.ocl.examples.pivot.Package>();
	private Set<org.eclipse.ocl.examples.pivot.Package> otherPackages = new HashSet<org.eclipse.ocl.examples.pivot.Package>();
	private Map<org.eclipse.ocl.examples.pivot.Package, String> allAliases = new HashMap<org.eclipse.ocl.examples.pivot.Package, String>();

	public AliasAnalysis(Resource resource) {
		resource.eAdapters().add(this);
	}

	private void computeAliases() {
		for (org.eclipse.ocl.examples.pivot.Package localPackage : localPackages) {
			if ((localPackage.getNsPrefix() != null) || (localPackage.getNestingPackage() == null)) {
				String alias = computeAlias(localPackage);
				allAliases.put(localPackage, alias);
			}
		}
		for (org.eclipse.ocl.examples.pivot.Package otherPackage : otherPackages) {
			if ((otherPackage.getNsPrefix() != null) || (otherPackage.getNestingPackage() == null)) {
				String alias = computeAlias(otherPackage);
				allAliases.put(otherPackage, alias);
			}
		}
	}

	private void addName(String name, EObject eObject) {
		if (name != null) {
			if (!allNames.containsKey(name)) {
				allNames.put(name, eObject);
			}
			else if (allNames.get(name) != eObject) {
				allNames.put(name, null);
			}
		}
	}

	private String computeAlias(org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		String nsPrefix = pivotPackage.getNsPrefix();
		String aliasBase = nsPrefix != null ? nsPrefix : pivotPackage.getName();		// FIXME NsPrefix
		int index = 0;
		String alias = aliasBase;
		while (allNames.containsKey(alias) && (allNames.get(alias) != pivotPackage)) {
			alias = aliasBase + "_" + index++;
		}
		addName(alias, pivotPackage);
		return alias;
	}

	private void computePackages() {
		for (TreeIterator<EObject> tit = ((Resource)target).getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof Pivotable) {
				eObject = ((Pivotable)eObject).getPivot();
			}
			if (eObject instanceof NamedElement) {
				addName(((NamedElement)eObject).getName(), eObject);
				if (eObject instanceof org.eclipse.ocl.examples.pivot.Package) {
					addName(((org.eclipse.ocl.examples.pivot.Package)eObject).getNsPrefix(), eObject);
				}
				if (eObject instanceof org.eclipse.ocl.examples.pivot.Package) {
					org.eclipse.ocl.examples.pivot.Package pivotPackage = (org.eclipse.ocl.examples.pivot.Package)eObject;
					localPackages.add(pivotPackage);
				}
				else {
					for (EObject eContainer = eObject; eContainer != null; eContainer = eContainer.eContainer()) {
						if (eContainer instanceof org.eclipse.ocl.examples.pivot.Package) {
							otherPackages.add((org.eclipse.ocl.examples.pivot.Package)eContainer);
							break;
						}
						if (eContainer instanceof TemplateableElement) {
							eContainer = PivotUtil.getUnspecializedTemplateableElement((TemplateableElement)eContainer);
						}
					}
				}
			}
		}
		otherPackages.removeAll(localPackages);
	}
	
	public void dispose() {
		target.eAdapters().remove(this);
	}

	public String getAlias(EObject eObject) {
		if (eObject instanceof Pivotable) {
			eObject = ((Pivotable)eObject).getPivot();
		}
		if (eObject instanceof org.eclipse.ocl.examples.pivot.Package) {
			return allAliases.get(eObject);
		}
		else {
			return null;
		}
	}
	
	@Override
	public boolean isAdapterForType(Object type) {
		return type == AliasAnalysis.class;
	}
}
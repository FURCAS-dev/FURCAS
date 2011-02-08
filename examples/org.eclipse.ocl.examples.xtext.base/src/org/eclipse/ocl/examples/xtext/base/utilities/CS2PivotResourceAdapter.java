/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * $Id: CS2PivotResourceAdapter.java,v 1.3 2011/02/08 17:43:58 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.utilities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.pivot.utilities.TypeManagerResourceAdapter;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2Pivot;
import org.eclipse.ocl.examples.xtext.base.scope.RootCSScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeCSAdapter;
import org.eclipse.ocl.lpg.ProblemHandler;

/**
 * A CS2PivotResourceAdapter enhances the Resource for a Concrete Syntax model
 * to support synchronization with a Pivot model representation.
 */
public class CS2PivotResourceAdapter extends TypeManagerResourceAdapter
{		
	public static CS2PivotResourceAdapter findAdapter(BaseCSResource csResource) {
		if (csResource == null) {
			return null;
		}
		TypeManagerResourceAdapter adapter = PivotUtil.getAdapter(TypeManagerResourceAdapter.class, csResource);
		if (adapter == null) {
			return null;
		}
		if (adapter instanceof CS2PivotResourceAdapter) {
			return (CS2PivotResourceAdapter) adapter;
		}
		List<Adapter> eAdapters = csResource.eAdapters();
		eAdapters.remove(adapter);
		CS2PivotResourceAdapter derivedAdapter = new CS2PivotResourceAdapter(csResource, adapter.getTypeManager());
		eAdapters.add(derivedAdapter);
		return derivedAdapter;
	}
	
	public static CS2PivotResourceAdapter getAdapter(BaseCSResource csResource, TypeManager typeManager) {
		List<Adapter> eAdapters = csResource.eAdapters();
		CS2PivotResourceAdapter adapter = findAdapter(csResource);
		if (adapter == null) {
			if (typeManager == null) {
				typeManager = csResource.createTypeManager();
			}
			adapter = new CS2PivotResourceAdapter(csResource, typeManager);
			eAdapters.add(adapter);
		}
		return adapter;
	}
	
	protected final ProblemHandler problemHandler;
	private final CS2Pivot converter;
	
	public CS2PivotResourceAdapter(BaseCSResource csResource, TypeManager typeManager) {
		super(csResource, typeManager);
		this.problemHandler = csResource.getProblemHandler();
		Map<Resource, Resource> cs2pivotResourceMap = computeCS2PivotResourceMap(
			csResource, typeManager);
		converter = csResource.createCS2Pivot(cs2pivotResourceMap, typeManager);
	}

	public Map<Resource, Resource> computeCS2PivotResourceMap(Resource csResource, TypeManager typeManager) {
		ResourceSet pivotResourceSet = typeManager.getTarget();
		Map<Resource,Resource> cs2pivotResourceMap = new HashMap<Resource,Resource>();
	//	ResourceSet csResourceSet = csResource.getResourceSet();
	//	if (csResourceSet != null) {
//		for (Resource acsResource : csResourceSet.getResources()) {
			Resource acsResource = csResource;
				URI uri = acsResource.getURI();
				List<EObject> contents = acsResource.getContents();
	//			if (!"java".equals(uri.scheme())) { //$NON-NLS-1$
				if ((contents.size() > 0) && (contents.get(0) instanceof ModelElementCS)) { //$NON-NLS-1$
					URI pivotURI = uri.appendFileExtension("pivot");
					Resource pivotResource = pivotResourceSet.getResource(pivotURI, false);
					if (pivotResource == null) {
						pivotResource = pivotResourceSet.createResource(pivotURI);
					}
					cs2pivotResourceMap.put(acsResource, pivotResource);
				}
	//		}
	//	}
		return cs2pivotResourceMap;
	}
	
	public CS2Pivot getConverter() {
		return converter;
	}

	public long getModificationCount() {
		List<EObject> contents = resource.getContents();
		if (!contents.isEmpty()) {
			ElementCS csElement = (ElementCS) contents.get(0);
			ScopeCSAdapter scopeAdapter = ElementUtil.getScopeCSAdapter(csElement);
			if (scopeAdapter != null) {
				RootCSScopeAdapter documentScopeAdapter = scopeAdapter.getRootScopeAdapter();
				if (documentScopeAdapter != null) {
					return documentScopeAdapter.getModificationCount();
				}
			}
		}
		return -1;
	}

	public Resource getPivotResource(Resource csResource) {
		return converter.getPivotResource(csResource);
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return super.isAdapterForType(type) || (type == CS2PivotResourceAdapter.class);
	}	
	
	public void refreshPivotMappings() {
		CSAliasCreator.refreshPackageAliases(resource);
		converter.update(problemHandler);
	}
}
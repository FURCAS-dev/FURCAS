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
 * $Id: OCLinEcoreCS2Pivot.java,v 1.4 2011/05/20 15:27:12 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.cs2pivot;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2Pivot;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeCSAdapter;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2PivotResourceAdapter;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot.EssentialOCLCS2Pivot;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage;
import org.eclipse.ocl.examples.xtext.oclinecore.utilities.OCLinEcoreCSResource;

public class OCLinEcoreCS2Pivot extends EssentialOCLCS2Pivot 
{	
	private static final class Factory implements CS2Pivot.Factory, TypeManager.Factory
	{
		private Factory() {
			EssentialOCLCS2Pivot.FACTORY.getClass();
			CS2Pivot.addFactory(this);
			TypeManager.addFactory(this);
		}

		public boolean canHandle(Resource resource) {
			return resource instanceof OCLinEcoreCSResource;
		}

		public void configure(ResourceSet resourceSet) {}

		public OCLinEcoreLeft2RightVisitor createLeft2RightVisitor(CS2PivotConversion converter) {
			return new OCLinEcoreLeft2RightVisitor(converter);
		}

		public OCLinEcorePostOrderVisitor createPostOrderVisitor(CS2PivotConversion converter) {
			return new OCLinEcorePostOrderVisitor(converter);
		}

		public OCLinEcorePreOrderVisitor createPreOrderVisitor(CS2PivotConversion converter) {
			return new OCLinEcorePreOrderVisitor(converter);
		}

		public BaseCSVisitor<ScopeCSAdapter, TypeManager> createScopeVisitor(TypeManager typeManager) {
			return new OCLinEcoreScopeVisitor(typeManager);
		}

		public EPackage getEPackage() {
			return OCLinEcoreCSTPackage.eINSTANCE;
		}

		public Element importFromResource(TypeManager typeManager, Resource resource, String uriFragment) {
			CS2PivotResourceAdapter adapter = CS2PivotResourceAdapter.getAdapter((OCLinEcoreCSResource)resource, typeManager);
			Resource pivotResource = adapter.getPivotResource(resource);
			if (pivotResource == null) {
				return null;
			}
			List<EObject> contents = pivotResource.getContents();
			if (contents.size() <= 0) {
				return null;
			}
			if (uriFragment == null) {
				return (Element) contents.get(0);
			}
			else {
				throw new UnsupportedOperationException();	// FIXME
			}
		}
	}

	public static CS2Pivot.Factory FACTORY = new Factory();
		
	public OCLinEcoreCS2Pivot(Map<? extends Resource, ? extends Resource> cs2pivotResourceMap, TypeManager typeManager) {
		super(cs2pivotResourceMap, typeManager);
	}
}

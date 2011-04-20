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
 * $Id: OCLstdlibLinkingService.java,v 1.9 2011/04/20 19:03:01 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclstdlib.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.examples.pivot.util.Pivotable;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.utilities.TypeManagerResourceAdapter;
import org.eclipse.ocl.examples.pivot.utilities.TypeManagerResourceSetAdapter;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.cs.ImportScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLLinkingService;
import org.eclipse.xtext.nodemodel.INode;

public class OCLstdlibLinkingService extends EssentialOCLLinkingService
{
	@Override
	protected List<EObject> getLinkedImport(ModelElementCS context, INode node) {
		ScopeAdapter scopeAdapter = ElementUtil.getScopeCSAdapter(context);
		String text = getText(node);
		if ((scopeAdapter instanceof ImportScopeAdapter) && (text != null)) {
			BaseCSResource csResource = (BaseCSResource) context.eResource();
			URI uri = URI.createURI(text);
			uri = csResource.resolve(uri);
			ImportScopeAdapter importScopeAdapter = (ImportScopeAdapter)scopeAdapter;
			URI oldURI = importScopeAdapter.getURI();
			List<EObject> importedElements = new ArrayList<EObject>();
			if (uri.equals(oldURI)) {
				importedElements.add(importScopeAdapter.getImportedElement());
			}
			else {
				TypeManagerResourceAdapter adapter = TypeManagerResourceAdapter.getAdapter(csResource, null);
				TypeManager typeManager = adapter.getTypeManager();
				ResourceSet csResourceSet = csResource.getResourceSet();
				TypeManagerResourceSetAdapter.getAdapter(csResourceSet, typeManager);
				BaseCSResource importedResource = (BaseCSResource)csResourceSet.getResource(uri, true);
				List<EObject> contents = importedResource.getContents();
				if (contents.size() > 0) {
					for (EObject content : contents) {
						if (content instanceof Pivotable) {
							importedElements.add(((Pivotable)content).getPivot());
						}
					}
				}
			}
			return importedElements;
		}
		return Collections.emptyList();
	}
}

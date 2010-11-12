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
 * $Id: OCLinEcoreLinkingService.java,v 1.7 2010/05/16 19:22:58 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.services;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.ImportScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.util.ElementUtil;
import org.eclipse.ocl.examples.xtext.oclinecore.resource.Ecore2OCLinEcore;
import org.eclipse.ocl.examples.xtext.oclstdlib.services.OCLstdlibLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.parsetree.AbstractNode;

public class OCLinEcoreLinkingService extends OCLstdlibLinkingService
{
	private static final Logger log = Logger.getLogger(OCLinEcoreLinkingService.class);
	
	@Override
	public List<EObject> getLinkedObjects(EObject context, EReference ref, AbstractNode node) throws IllegalNodeException {
		if ((ref == BaseCSTPackage.Literals.IMPORT_CS__NAMESPACE) && (context instanceof ImportCS)) {
			return getLinkedImport(context, node);
		}
		return super.getLinkedObjects(context, ref, node);
	}

	private List<EObject> getLinkedImport(EObject context, AbstractNode node) {
		ScopeAdapter scopeAdapter = ElementUtil.getScopeAdapter(context);
		String text = getText(node);
		if ((scopeAdapter instanceof ImportScopeAdapter) && (text != null)) {
			Resource eResource = context.eResource();
			URI uri = URI.createURI(text);
			uri = uri.resolve(eResource.getURI());
			ImportScopeAdapter importScopeAdapter = (ImportScopeAdapter)scopeAdapter;
			URI oldURI = importScopeAdapter.getURI();
			EObject importedElement;				
			if (uri.equals(oldURI)) {
				importedElement = importScopeAdapter.getImportedElement();
			}
			else {
				ResourceSet resourceSet = eResource.getResourceSet();
				importedElement = loadResource(uri, ((ImportCS)context).getName(), resourceSet);				
				importScopeAdapter.setImportedElement(uri, importedElement);
			}
			if (importedElement != null) {
				return Collections.<EObject>singletonList(importedElement);
			}
		}
		return Collections.emptyList();
	}

	private ElementCS loadResource(URI uri, String alias, ResourceSet resourceSet) {
//		if (EPackage.Registry.INSTANCE.containsKey(resourceOrNsURI))
//			return EPackage.Registry.INSTANCE.getEPackage(resourceOrNsURI);
		try {
			Resource resource = resourceSet.getResource(uri.trimFragment(), true);
			if (resource != null) {
				String fragment = uri.fragment();
				if (fragment == null) {
					return Ecore2OCLinEcore.importFromEcore(resourceSet, alias, resource);				
				}
				else {
					EObject eObject = resource.getEObject(fragment);			
					if (eObject instanceof ElementCS) {
						return (ElementCS) eObject;
					}
					return Ecore2OCLinEcore.importFromEcore(resourceSet, alias, eObject);
				}
			}
			log.trace("Cannot load package with URI '" + uri + "'");
			return null;
		} catch(RuntimeException ex) {
			log.trace("Cannot load package with URI '" + uri + "'", ex);
			return null;
		}
	}
}

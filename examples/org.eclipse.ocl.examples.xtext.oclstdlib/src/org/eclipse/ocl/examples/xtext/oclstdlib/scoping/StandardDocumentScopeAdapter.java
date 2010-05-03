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
 * $Id: StandardDocumentScopeAdapter.java,v 1.1 2010/05/03 05:29:40 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclstdlib.scoping;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.DocumentCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamespaceCS;
import org.eclipse.ocl.examples.xtext.base.scope.AbstractDocumentScopeAdapter;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibClassCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibDocumentCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibPackageCS;

public abstract class StandardDocumentScopeAdapter<T extends DocumentCS> extends AbstractDocumentScopeAdapter<T>
{
	public static final String OCLSTDLIB_URI = "platform:/plugin/org.eclipse.ocl.examples.xtext.essentialocl/model/oclstdlib.oclstdlib";
	protected Map<String, LibPackageCS> libraryNameMap = new HashMap<String, LibPackageCS>();
	protected Map<String, LibClassCS> libraryTypeMap = new HashMap<String, LibClassCS>();

	public StandardDocumentScopeAdapter(T csElement) {
		super(csElement);
	}

	@Override
	public StandardDocumentScopeAdapter<?> getDocumentScopeAdapter() {
		return this;
	}
	
	public LibClassCS getLibType(String name) {
		if (libraryNameMap.isEmpty()) {
			URI uri = URI.createURI(OCLSTDLIB_URI);
			importLibrary(getTarget().eResource().getResourceSet(), "ocl", uri);
		}
		return libraryTypeMap.get(name);
	}

	protected List<EObject> importLibrary(ResourceSet resourceSet, String alias, URI uri) {
//		if (EPackage.Registry.INSTANCE.containsKey(resourceOrNsURI))
//		return EPackage.Registry.INSTANCE.getEPackage(resourceOrNsURI);
		try {
			NamespaceCS csElement;
			if (uri.fragment() == null) {
				Resource resource = resourceSet.getResource(uri, true);
				csElement = (LibDocumentCS) resource.getContents().get(0);
			}
			else {
				csElement = (LibPackageCS) resourceSet.getEObject(uri, true);
			}
			if (csElement instanceof LibDocumentCS) {
				LibDocumentCS csDocument = (LibDocumentCS) csElement;
				EList<LibPackageCS> csPackages = csDocument.getPackages();
				if (!csPackages.isEmpty()) {
					if (alias == null) {
						alias = "";
					}
					LibPackageCS csPackage = csPackages.get(0);
					libraryNameMap.put(alias, csPackage);
					for (ClassifierCS csClassifier : csPackage.getClassifiers()) {
						libraryTypeMap.put(csClassifier.getName(), (LibClassCS) csClassifier);
					}
					csElement = csPackage;
				}
			}
			return Collections.<EObject>singletonList(csElement);
		} catch(RuntimeException ex) {
			getLogger().trace("Cannot load library with URI '" + uri + "'", ex);
		}
		return Collections.emptyList();
	}
}

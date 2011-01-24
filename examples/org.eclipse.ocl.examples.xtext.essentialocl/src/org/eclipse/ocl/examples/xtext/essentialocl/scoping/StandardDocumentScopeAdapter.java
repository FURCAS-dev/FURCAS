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
 * $Id: StandardDocumentScopeAdapter.java,v 1.2 2011/01/24 21:31:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.examples.pivot.MonikeredElement;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.baseCST.RootPackageCS;
import org.eclipse.ocl.examples.xtext.base.scope.AbstractRootCSScopeAdapter;

public abstract class StandardDocumentScopeAdapter<CS extends RootPackageCS, P extends MonikeredElement> extends AbstractRootCSScopeAdapter<CS, P>
{
//	public static final String OCLSTDLIB_URI = "platform:/plugin/org.eclipse.ocl.examples.xtext.essentialocl/model/oclstdlib.oclstdlib";
	private static final Logger log = Logger.getLogger(StandardDocumentScopeAdapter.class);

//	protected Map<String, org.eclipse.ocl.examples.pivot.Package> libraryNameMap = new HashMap<String, org.eclipse.ocl.examples.pivot.Package>();
//	protected Map<String, Type> libraryTypeMap = new HashMap<String, Type>();

	public StandardDocumentScopeAdapter(TypeManager typeManager, CS csElement, Class<P> pivotClass) {
		super(typeManager, csElement, pivotClass);
	}

	@Override
	public StandardDocumentScopeAdapter<?,?> getRootScopeAdapter() {
		return this;
	}
	
/*	@Override
	public Type getLibType(String name) {
		if (libraryNameMap.isEmpty()) {
			URI uri = URI.createURI(OCLSTDLIB_URI);
			importLibrary(getTarget().eResource().getResourceSet(), "ocl", uri);
		}
		return libraryTypeMap.get(name);
	} */

	protected List<EObject> importLibrary(ResourceSet resourceSet, String alias, URI uri) {
//		if (EPackage.Registry.INSTANCE.containsKey(resourceOrNsURI))
//		return EPackage.Registry.INSTANCE.getEPackage(resourceOrNsURI);
		try {
			Namespace csElement;
			if (uri.fragment() == null) {
				Resource resource = resourceSet.getResource(uri, true);
				csElement = (org.eclipse.ocl.examples.pivot.Package) resource.getContents().get(0);
			}
			else {
				csElement = (org.eclipse.ocl.examples.pivot.Package) resourceSet.getEObject(uri, true);
			}
			if (csElement instanceof org.eclipse.ocl.examples.pivot.Package) {
				org.eclipse.ocl.examples.pivot.Package csDocument = (org.eclipse.ocl.examples.pivot.Package) csElement;
				List<org.eclipse.ocl.examples.pivot.Package> csPackages = csDocument.getNestedPackages();
				if (!csPackages.isEmpty()) {
					if (alias == null) {
						alias = "";
					}
					org.eclipse.ocl.examples.pivot.Package csPackage = csPackages.get(0);
//	FIXME				libraryNameMap.put(alias, csPackage);
//					for (Type csClassifier : csPackage.getOwnedTypes()) {
//						libraryTypeMap.put(csClassifier.getName(), csClassifier);
//					}
					csElement = csPackage;
				}
			}
			return Collections.<EObject>singletonList(csElement);
		} catch(RuntimeException ex) {
			log.error("Cannot load library with URI '" + uri + "'", ex);
		}
		return Collections.emptyList();
	}

/*	@Override
	public Type getLibraryType(String collectionTypeName, Type elementTypeCS) {
		ScopeAdapter elementScopeAdapter = getScopeAdapter(elementTypeCS);
		if (elementScopeAdapter == null) {
			return null;
		}
		String elementSignature = elementScopeAdapter.getSignature();
		String netSignature = collectionTypeName + "(" + elementSignature + ")";		
		Type specializedClassifier = getLibType(netSignature);
/ *		if (specializedClassifier == null) {
			LibClassifierCS collectionClassifier = getLibType(collectionTypeName);
			LibBoundClassCS parameterizedClassifier = OCLstdlibCSTFactory.eINSTANCE.createLibBoundClassCS();
			parameterizedClassifier.setName(netSignature);
			parameterizedClassifier.setBinds((LibClassCS) collectionClassifier);
			TypeBindingCS binding = BaseCSTFactory.eINSTANCE.createTypeBindingCS();
			binding.setTypeParameter(ElementUtil.getTemplateParameters(collectionClassifier).iterator().next());
			binding.setTypeArgument(elementTypeCS);
			List<TypeBindingCS> newBindings = Collections.singletonList(binding);
			TypeBindingsCS bindings = parameterizedClassifier.getBindings();
			TypeBindingsCS nestedBindings = BaseCSTFactory.eINSTANCE.createTypeBindingsCS();
			nestedBindings.setBoundDocument(getBoundDocument());
			nestedBindings.getBindings().addAll(newBindings);
			if (bindings != null) { 
				bindings.getNested().add(nestedBindings);
			}
			parameterizedClassifier.setBindings(nestedBindings);
			libraryTypeMap.put(netSignature, parameterizedClassifier);
			specializedClassifier = parameterizedClassifier;
		} * /
		return specializedClassifier;
	} */
}


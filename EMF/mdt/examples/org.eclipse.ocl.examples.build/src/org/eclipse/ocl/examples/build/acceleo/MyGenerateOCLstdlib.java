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
 * $Id: MyGenerateOCLstdlib.java,v 1.1 2011/02/15 10:36:50 ewillink Exp $
 */
package org.eclipse.ocl.examples.build.acceleo;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.examples.pivot.PivotPackage;

public class MyGenerateOCLstdlib extends GenerateOCLstdlib
{	// Must be in same package as mtl file until Bug 336109 fixed
	// This entire class is a workaround for Bug 336119
	public MyGenerateOCLstdlib(EObject model, File targetFolder,
			List<? extends Object> arguments) throws IOException {
		super(model, targetFolder, arguments);
		ResourceSetImpl resourceSet = (ResourceSetImpl) module.eResource().getResourceSet();
		Map<URI, Resource> uriResourceMap = resourceSet.getURIResourceMap();
		if (uriResourceMap == null) {
			uriResourceMap = new HashMap<URI, Resource>();
			resourceSet.setURIResourceMap(uriResourceMap);
		}
		uriResourceMap.put(URI.createURI(EcorePackage.eNS_URI), EcorePackage.eINSTANCE.eResource()); // Workaround Bug 336119
		uriResourceMap.put(URI.createURI(PivotPackage.eNS_URI), PivotPackage.eINSTANCE.eResource()); // Workaround Bug 336119
		uriResourceMap.put(URI.createURI("/org.eclipse.ocl.examples.pivot/model/pivot.ecore"), PivotPackage.eINSTANCE.eResource()); // Workaround Bug 336119
/*	    for (ModuleElement moduleElement : module.getOwnedModuleElement()) {
	    	if (moduleElement instanceof Template) {
	    		for (Variable parameter : ((Template)moduleElement).getParameter()) {
	    			EObject eObject = parameter.getType();
	    			if (eObject.eIsProxy()) {
		    			eObject = parameter.getType();
	    			}
	    		}
	    	}
	    } */
	    for (TreeIterator<EObject> tit = module.eResource().getAllContents(); tit.hasNext(); ) {
	    	EObject eObject = tit.next();
			if (eObject.eIsProxy()) {
    			EObject eObject2 = EcoreUtil.resolve(eObject, resourceSet);
    			if (eObject2.eIsProxy()) {
    				System.out.println("Unresolvable proxy '" + ((InternalEObject) eObject2).eProxyURI());
    			}
    			else {
    				System.out.println("Resolved proxy '" + ((InternalEObject) eObject).eProxyURI());
    			}
			}
/*			if (eObject instanceof ETypedElement) {
				EClassifier eType = ((ETypedElement) eObject).getEType();
				if ((eType != null) && eType.eIsProxy()) {
	    			EObject eType2 = EcoreUtil.resolve(eType, resourceSet);
	    			if (eType2.eIsProxy()) {
	    				System.out.println("Unresolvable proxy '" + ((InternalEObject) eType2).eProxyURI());
	    			}
	    			else {
	    				System.out.println("Resolved proxy '" + ((InternalEObject) eType).eProxyURI());
	    			}
				}
			} */
	    }
	}
}
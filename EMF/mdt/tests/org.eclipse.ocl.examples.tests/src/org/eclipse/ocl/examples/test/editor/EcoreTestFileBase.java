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
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: EcoreTestFileBase.java,v 1.2 2010/04/25 06:50:09 ewillink Exp $
 */
package org.eclipse.ocl.examples.test.editor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.examples.common.utils.ClassUtils;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.part.FileEditorInput;

public class EcoreTestFileBase implements EcoreTestFile
{
	private final IFile file;
	private final URI uri;
	private final Resource resource;
	private FileEditorInput fileEditorInput = null;
	
	public EcoreTestFileBase(IFile file) {
		this.file = file;
		uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		ResourceSet resourceSet = new ResourceSetImpl();
		resource = resourceSet.createResource(uri);
	}

	public EClass createEClass(EPackage ePackage, String name) {
		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName(name);
		if (ePackage != null) {
			ePackage.getEClassifiers().add(eClass);
		}
		return eClass;
	}

	public EPackage createEPackage(EPackage parentPackage, String name) {
		EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		ePackage.setName(name);
		if (parentPackage == null) {
			resource.getContents().add(ePackage);
		}
		else {
			parentPackage.getESubpackages().add(ePackage);
		}
		return ePackage;
	}

	public IFileEditorInput getEditorInput() throws IOException {
		if (fileEditorInput == null) {
			resource.save(null);
			fileEditorInput = new FileEditorInput(file);
		}
		return fileEditorInput;
	}

	public EClass getEClass(ResourceSet resourceSet, EClass initClass) {
		EPackage ePackage = getEPackage(resourceSet, initClass.getEPackage());
		return (EClass) ePackage.getEClassifier(initClass.getName());
	}

	public EPackage getEPackage(ResourceSet resourceSet, EPackage initPackage) {
		Resource resource = getResource(resourceSet, initPackage.eResource());
		String name = initPackage.getName();
		for (EObject eObject : resource.getContents()) {
			if (eObject instanceof EPackage) {
				EPackage ePackage = (EPackage) eObject;
				if (ClassUtils.equals(ePackage.getName(), name)) {
					return ePackage;
				}
			}
		}
		return null;
	}

	public Collection<EPackage> getEPackages() {
		List<EPackage> ePackages = new ArrayList<EPackage>();
		for (EObject eObject : resource.getContents()) {
			if (eObject instanceof EPackage) {
				ePackages.add((EPackage) eObject);
			}
		}
		return ePackages;
	}

	public IFile getFile() {
		return file;
	}

	public Resource getResource(ResourceSet resourceSet, Resource initResource) {
		URI uri2 = initResource.getURI();
		return resourceSet.getResource(uri2, false);
	}

	public String getURI() {
		return uri.toString();
	}

	public ResourceSet reload() {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResource(uri, true);
		return resourceSet;
	}
}
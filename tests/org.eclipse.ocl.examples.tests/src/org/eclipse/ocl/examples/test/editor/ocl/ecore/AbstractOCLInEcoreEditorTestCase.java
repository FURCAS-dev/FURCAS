/**
 * <copyright>
 * 
 * Copyright (c) 2010 Eclipse Modeling Project and others.
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
 * $Id: AbstractOCLInEcoreEditorTestCase.java,v 1.1 2010/03/13 13:17:23 ewillink Exp $
 */
package org.eclipse.ocl.examples.test.editor.ocl.ecore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.ecore.delegate.InvocationBehavior;
import org.eclipse.ocl.ecore.delegate.OCLDelegateDomain;
import org.eclipse.ocl.ecore.delegate.SettingBehavior;
import org.eclipse.ocl.ecore.delegate.ValidationBehavior;
import org.eclipse.ocl.examples.common.utils.ClassUtils;
import org.eclipse.ocl.examples.editor.ocl.ui.ecore.OCLInEcoreCreationFactory;
import org.eclipse.ocl.examples.editor.ui.ICreationFactory;
import org.eclipse.ocl.examples.test.editor.AbstractEditorTestCase;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.part.FileEditorInput;

public abstract class AbstractOCLInEcoreEditorTestCase extends AbstractEditorTestCase
{
	protected static class EcoreTestFile
	{
		private final IFile file;
		private final URI uri;
		private final Resource resource;
		private FileEditorInput fileEditorInput = null;
		
		public EcoreTestFile(IFile file) {
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

		public EPackage createEPackageWithDelegates(EPackage parentPackage, String name) {
			EPackage ePackage = createEPackage(parentPackage, name);
		    EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		    eAnnotation.setSource(EcorePackage.eNS_URI);
		    EMap<String, String> details = eAnnotation.getDetails();
			details.put(InvocationBehavior.NAME, OCLDelegateDomain.OCL_DELEGATE_URI);
			details.put(SettingBehavior.NAME, OCLDelegateDomain.OCL_DELEGATE_URI);
			details.put(ValidationBehavior.NAME, OCLDelegateDomain.OCL_DELEGATE_URI);
		    ePackage.getEAnnotations().add(eAnnotation);
			return ePackage;
		}

		public void createInvariant(EClass eClass, String name, String expression) {
		    EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		    eAnnotation.setSource(OCLDelegateDomain.OCL_DELEGATE_URI);
		    eAnnotation.getDetails().put(name, expression);
		    eClass.getEAnnotations().add(eAnnotation);
		    Set<String> constraints = new HashSet<String>(EcoreUtil.getConstraints(eClass));
		    constraints.add(name);
		    EcoreUtil.setConstraints(eClass, new ArrayList<String>(constraints));
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

		public IFile getFile() {
			return file;
		}

		public Resource getResource(ResourceSet resourceSet, Resource initResource) {
			return resourceSet.getResource(initResource.getURI(), false);
		}

		public ResourceSet reload() {
			ResourceSet resourceSet = new ResourceSetImpl();
			resourceSet.getResource(uri, true);
			return resourceSet;
		}
	}
	
/*	protected IFile createEmptyEcoreFile() throws IOException {
		IFile file = project.getFile(getName() + " .ecore");
		URI testURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(testURI);
		resource.save(null);
		return file;
	} */

	@Override
	protected ICreationFactory getCreationFactory() {
		return OCLInEcoreCreationFactory.INSTANCE;
	}

	@Override
	protected String getEditorId() {
		return OCLInEcoreCreationFactory.EDITOR_ID;
	}
}

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
 * $Id: ModelRegistryTestFile.java,v 1.2 2010/04/25 06:50:09 ewillink Exp $
 */
package org.eclipse.ocl.examples.test.editor;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.examples.modelregistry.ModelRegistration;
import org.eclipse.ocl.examples.modelregistry.ModelRegistry;
import org.eclipse.ocl.examples.modelregistry.ModelRegistryFactory;
import org.eclipse.ocl.examples.modelregistry.ModelRegistrySettings;
import org.eclipse.ocl.examples.modelregistry.environment.ProjectHandle;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.part.FileEditorInput;

public class ModelRegistryTestFile
{
	private final IFile file;
	private final URI uri;
	private final Resource resource;
	private FileEditorInput fileEditorInput = null;
	private ModelRegistrySettings settings;
	private ModelRegistry registry;
	
	public ModelRegistryTestFile(IFile modelFile) {
		this.file = modelFile.getProject().getFile(new Path(ProjectHandle.DEFAULT_MODEL_REGISTRY_PATH));
		uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		ResourceSet resourceSet = new ResourceSetImpl();
		resource = resourceSet.createResource(uri);
		settings = ModelRegistryFactory.eINSTANCE.createModelRegistrySettings();
//		settings.setName("settings");
		resource.getContents().add(settings);
		registry = ModelRegistryFactory.eINSTANCE.createModelRegistry();
		registry.setName(modelFile.getProjectRelativePath().toString());
		settings.getResource().add(registry);
	}

	public ModelRegistration createRegistration(String kind, String name, String uri) {
		ModelRegistration registration = ModelRegistryFactory.eINSTANCE.createModelRegistration();
		registration.setKind(kind);
		registration.setAccessor(name);
		registration.setUri(uri);
		registry.getEntry().add(registration);
		return registration;
	}

	public IFileEditorInput getEditorInput() throws IOException {
		if (fileEditorInput == null) {
			resource.save(null);
			fileEditorInput = new FileEditorInput(file);
		}
		return fileEditorInput;
	}

	public IFile getFile() {
		return file;
	}
}
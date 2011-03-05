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
 * $Id: EssentialOCLCSResource.java,v 1.9 2011/03/05 05:57:43 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.utilities;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.examples.modelregistry.eclipse.ModelResourceResolver;
import org.eclipse.ocl.examples.modelregistry.environment.ModelResolver;
import org.eclipse.ocl.examples.modelregistry.environment.ProjectHandle;
import org.eclipse.ocl.examples.modelregistry.standalone.JavaProjectHandle;
import org.eclipse.ocl.examples.modelregistry.standalone.ModelFileResolver;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationContext;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironment;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.utilities.TypeManagerResourceSetAdapter;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2Pivot;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot.EssentialOCLCS2Pivot;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;

public class EssentialOCLCSResource extends LazyLinkingResource
	implements BaseCSResource, EvaluationContext
{	
	private static final Logger logger = Logger.getLogger(EssentialOCLCSResource.class);

	private PivotEnvironment environment = null;
	private NamedElement specificationContext = null;
	private ModelResolver modelResolver = null;
	
	public EssentialOCLCSResource() {
		super();
	}

	public CS2Pivot createCS2Pivot(
			Map<? extends Resource, ? extends Resource> cs2pivotResourceMap,
			TypeManager typeManager) {
		return new EssentialOCLCS2Pivot(cs2pivotResourceMap, typeManager);
	}

	public TypeManager createTypeManager() {
		ResourceSet resourceSet = getResourceSet();
		TypeManagerResourceSetAdapter resourceSetAdapter = TypeManagerResourceSetAdapter.findAdapter(resourceSet);
		if (resourceSetAdapter != null) {
			return resourceSetAdapter.getTypeManager();
		}
		else {
			return new TypeManager();
		}
	}

	public PivotEnvironment getEnvironment() {
		return environment;
	}

	public ModelResolver getModelResolver() {
		return modelResolver;
	}
	
	public NamedElement getSpecificationContext() {
		return specificationContext;
	}

	public URI resolve(URI uri) {
		try {
			ModelResolver resolver = useModelResolver();
			if (resolver != null) {
				java.net.URI javaURI = new java.net.URI(uri.toString());
				URI resolvedURI = resolver.getURI(javaURI);
				if (resolvedURI != null) {
					uri = resolvedURI;
				}
			}
		} catch (Exception e) {
			logger.warn("Failed to resolve '" + uri + "'", e);
		}
		return uri.resolve(getURI());
	}

	public void setContext(NamedElement pivotContext, Map<String, Type> pivotParameters) {
		this.specificationContext = pivotContext;		
	}

	public void setEnvironment(PivotEnvironment environment) {
		this.environment = environment;
	}

	public void setModelResolver(ModelResolver modelResolver) {
		this.modelResolver = modelResolver;
	}

//	public void setSpecificationContext(NamedElement specificationContext) {
//		this.specificationContext = specificationContext;
//	}

	public ModelResolver useModelResolver() throws IOException {
		if (modelResolver == null) {
			URI uri = getURI();
			if (uri.isPlatformResource()) {
				String path = uri.toPlatformString(true);
				IResource workspaceResource = ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(path));
				modelResolver = new ModelResourceResolver(workspaceResource);
			}
			else if (uri.isPlatformPlugin()) {
				return null;
			}
			else {
				String fileName = uri.toFileString();
				File file = new File(fileName);
				FilenameFilter filter = new FilenameFilter()
				{
					public boolean accept(File dir, String name) {
						if (name.equals(ProjectHandle.DEFAULT_MODEL_REGISTRY_NAME)) {
							return true;
						}
						if (name.equals(".settings")) {
							return true;
						}
						return false;
					}
				};
				File projectFolder = null;
				File registryFile = null;
				for (File folder = file.getParentFile(); folder != null; folder = folder.getParentFile()) {
					File[] listFiles = folder.listFiles(filter);
					if ((listFiles != null) && (listFiles.length > 0)) {
						projectFolder = folder;
						registryFile = listFiles[0];
						break;
					}
				}
				String registryPath = null;
				if ((registryFile != null) && registryFile.isDirectory()) {
					File[] listFiles = registryFile.listFiles(filter);
					if ((listFiles != null) && (listFiles.length > 0)) {
						registryPath = ".settings/" + ProjectHandle.DEFAULT_MODEL_REGISTRY_NAME;
					}
				}
				else {
					registryPath = ProjectHandle.DEFAULT_MODEL_REGISTRY_NAME;
				}
				if (registryPath != null) {
					JavaProjectHandle project = new JavaProjectHandle(projectFolder, registryPath);
					modelResolver = new ModelFileResolver(project, file);
				}
			}
		}
		return modelResolver;
	}
}

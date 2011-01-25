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
 * $Id: OclMetaModelCodeGenerator.java,v 1.2 2011/01/24 20:54:27 ewillink Exp $
 */
package org.eclipse.ocl.examples.build.utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.ocl.examples.build.acceleo.GenerateOclMetaModel;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlib;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.pivot.utilities.TypeManagerResourceAdapter;
import org.eclipse.ocl.examples.xtext.oclstdlib.OCLstdlibStandaloneSetup;

/**
 * Generates the javaFolder/'javaPackageName'/javaClassName.java file providing
 * a static Java-creation of the libraryFile OCL standard library definition.
 */
public class OclMetaModelCodeGenerator extends AbstractWorkflowComponent
{
	private Logger log = Logger.getLogger(getClass());	
	private ResourceSet resourceSet = null;	
//	protected String uri;
	protected String javaClassName;
	protected String javaFolder;
	protected String javaPackageName;
	protected String libraryFile;

	public void checkConfiguration(Issues issues) {
//		if (uri == null) {
//			issues.addError(this, "uri not specified.");
//		}
		if (javaClassName == null) {
			issues.addError(this, "javaClassName not specified.");
		}
		if (javaPackageName == null) {
			issues.addError(this, "javaPackageName not specified.");
		}
		if (libraryFile == null) {
			issues.addError(this, "libraryFile not specified.");
		}
	}

	public ResourceSet getResourceSet() {
		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();
		}
		OCLstdlibStandaloneSetup.doSetup();
		return resourceSet;
	}

	public void invokeInternal(WorkflowContext ctx, ProgressMonitor arg1, Issues issues) {
		URI fileURI = URI.createPlatformResourceURI(libraryFile, true);
		String rootPath = StandaloneSetup.getPlatformRootPath();
		OCLstdlib.install();
		File folder = new File(rootPath + javaFolder + '/' + javaPackageName.replace('.', '/'));
		log.info("Loading Pivot Model '" + fileURI);
		try {
			ResourceSet resourceSet = getResourceSet();
			Resource ecoreResource = resourceSet.getResource(fileURI, true);
			TypeManagerResourceAdapter adapter = TypeManagerResourceAdapter.getAdapter(ecoreResource, null);
			String ecoreErrorsString = PivotUtil.getResourceErrorsString(ecoreResource, "Loading " + fileURI);
			if (ecoreErrorsString != null) {
				issues.addError(this, ecoreErrorsString, null, null, null);
				return;
			}
			TypeManager typeManager = adapter.getTypeManager();
			Ecore2Pivot ecore2Pivot = Ecore2Pivot.getAdapter(ecoreResource, typeManager);
			org.eclipse.ocl.examples.pivot.Package pivotRoot = ecore2Pivot.getPivotRoot();
			Package pivotPackage = pivotRoot.getNestedPackages().get(0);
			Resource pivotResource = pivotRoot.eResource();
			String pivotErrorsString = PivotUtil.getResourceErrorsString(pivotResource, "Converting " + fileURI);
			if (pivotErrorsString != null) {
				issues.addError(this, pivotErrorsString, null, null, null);
				return;
			}
			List<Object> arguments = new ArrayList<Object>();
			arguments.add(javaPackageName);
			arguments.add(javaClassName);
			arguments.add(libraryFile);
			arguments.add(pivotPackage.getNsURI());
//			PivotSaver saver = new PivotSaver(pivotResource);
//			org.eclipse.ocl.examples.pivot.Package orphanage = saver.localizeSpecializations();
//			if (orphanage != null) {
//				((org.eclipse.ocl.examples.pivot.Package)pivotModel).getNestedPackages().add(orphanage);
//			}
			GenerateOclMetaModel acceleo = new GenerateOclMetaModel(pivotPackage, folder, arguments);
			log.info("Generating to ' " + folder + "'");
			acceleo.generate(null);
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		} catch (IOException e) {
			issues.addError(this, "libraryFile not specified.", null, e, null);
			e.printStackTrace();
		}
	}

	public void setJavaClassName(String javaClassName) {
		this.javaClassName = javaClassName;
	}

	public void setJavaFolder(String javaFolder) {
		this.javaFolder = javaFolder;
	}

	public void setJavaPackageName(String javaPackageName) {
		this.javaPackageName = javaPackageName;
	}

	public void setLibraryFile(String libraryFile) {
		this.libraryFile = libraryFile;
	}
	
	public void setResourceSet(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}
	
//	public void setUri(String uri) {
//		this.uri = uri;
//	}
}

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
 * $Id: XtextVisitorCodeGenerator.java,v 1.3 2011/02/02 18:51:35 ewillink Exp $
 */
package org.eclipse.ocl.examples.build.utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.ocl.examples.build.acceleo.GenerateXtextVisitors;
import org.eclipse.ocl.examples.build.acceleo.MyGenerateXtextVisitors;
import org.eclipse.ocl.examples.xtext.oclstdlib.OCLstdlibStandaloneSetup;

/**
 * Generates the javaFolder/'javaPackageName'/visitorClassName.java file providing
 * a static Java-creation of the libraryFile OCL standard library definition.
 */
public class XtextVisitorCodeGenerator extends AbstractWorkflowComponent
{
	private Logger log = Logger.getLogger(getClass());	
	private ResourceSet resourceSet = null;	
	protected String visitorBaseClassName;
	protected String visitorBasePackageName;
	protected String visitorClassName;
	protected String javaFolder;
	protected String javaPackageName;
	protected String modelPackageName;
	protected String ecoreFile;

	public void checkConfiguration(Issues issues) {
		if (visitorBaseClassName == null) {
			issues.addError(this, "visitorBaseClassName not specified.");
		}
		if (visitorClassName == null) {
			issues.addError(this, "visitorClassName not specified.");
		}
		if (javaPackageName == null) {
			issues.addError(this, "javaPackageName not specified.");
		}
		if (modelPackageName == null) {
			issues.addError(this, "modelPackageName not specified.");
		}
		if (ecoreFile == null) {
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
		URI fileURI = URI.createPlatformResourceURI(ecoreFile, true);
		String rootPath = StandaloneSetup.getPlatformRootPath();
		File folder = new File(rootPath + javaFolder + '/' + javaPackageName.replace('.', '/') + "/util");
		log.info("Loading Ecore Model '" + fileURI);
		try {
			ResourceSet resourceSet = getResourceSet();
			Resource ecoreResource = resourceSet.getResource(fileURI, true);
			List<Object> arguments = new ArrayList<Object>();
			arguments.add(javaPackageName);
			arguments.add(modelPackageName);
			arguments.add(visitorClassName);
			arguments.add(visitorBasePackageName);
			arguments.add(visitorBaseClassName);
			arguments.add(ecoreFile);
			EObject ecoreModel = ecoreResource.getContents().get(0);
			GenerateXtextVisitors acceleo = new MyGenerateXtextVisitors(ecoreModel, folder, arguments);
			log.info("Generating to ' " + folder + "'");
			EMF2MWEMonitorAdapter monitor = new EMF2MWEMonitorAdapter(arg1);
			acceleo.generate(monitor);
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		} catch (IOException e) {
			issues.addError(this, "ecore File not specified.", null, e, null);
			e.printStackTrace();
		}
	}

	public void setVisitorBaseClassName(String visitorBaseClassName) {
		this.visitorBaseClassName = visitorBaseClassName;
	}

	public void setVisitorBasePackageName(String visitorBasePackageName) {
		this.visitorBasePackageName = visitorBasePackageName;
	}

	public void setVisitorClassName(String visitorClassName) {
		this.visitorClassName = visitorClassName;
	}

	public void setJavaFolder(String javaFolder) {
		this.javaFolder = javaFolder;
	}

	public void setJavaPackageName(String javaPackageName) {
		this.javaPackageName = javaPackageName;
	}

	public void setModelPackageName(String modelPackageName) {
		this.modelPackageName = modelPackageName;
	}

	public void setEcoreFile(String ecoreFile) {
		this.ecoreFile = ecoreFile;
	}
	
	public void setResourceSet(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}
}

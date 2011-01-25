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
 * $Id: GenerateModel.java,v 1.2 2011/01/24 20:54:27 ewillink Exp $
 */
package org.eclipse.ocl.examples.build.utilities;


import org.apache.log4j.Logger;
import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.codegen.ecore.genmodel.GenJDKLevel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.codegen.ecore.genmodel.util.GenModelUtil;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.mwe.core.ConfigurationException;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

/**
 * Performs a Generate Model on the designated <tt>genmodel</tt> genModel.
 */
public class GenerateModel extends AbstractWorkflowComponent {
	private Logger log = Logger.getLogger(getClass());
	private ResourceSet resourceSet = null; // Optional ResourceSet to re-use
	protected String genModel; 				// URI of the genmodel
	protected boolean showProgress = false; // Set true to show genmodel new tasks

	public void checkConfiguration(Issues issues) {
		if (genModel == null) {
			issues.addError(this, "uri not specified.");
		}
	}

	public String getGenModel() {
		return genModel;
	}

	public ResourceSet getResourceSet() {
		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();
		}
		return resourceSet;
	}

	public void invokeInternal(WorkflowContext ctx, ProgressMonitor arg1,
			Issues arg2) {
		URI fileURI = URI.createPlatformResourceURI(genModel, true);
		log.info("Generating model '" + fileURI + "'");
		try {
			ResourceSet resourceSet = getResourceSet();
			Resource resource = resourceSet.getResource(fileURI, true);
			// EcoreUtil.resolveAll(resourceSet); -- genModel can fail if
			// proxies resolved here
			// problem arises if genmodel has an obsolete feature for a feature
			// moved up the inheritance hierarchy
			// since the proxy seems to be successfully resolved giving a double
			// feature
			ResourceUtils.checkResourceSet(resourceSet);
			EObject eObject = resource.getContents().get(0);
			if (!(eObject instanceof GenModel)) {
				throw new ConfigurationException("No GenModel found in '"
						+ resource.getURI() + "'");
			}
			GenModel genModel = (GenModel) eObject;
			genModel.reconcile();
			ResourceUtils.checkResourceSet(resourceSet);
			// genModel.setCanGenerate(true);
			// validate();

			
			
			genModel.setValidateModel(true); // The more checks the better
//			genModel.setCodeFormatting(true); // Normalize layout
			genModel.setForceOverwrite(false); // Don't overwrite read-only
												// files
			genModel.setCanGenerate(true);
			// genModel.setFacadeHelperClass(null); // Non-null gives JDT
			// default NPEs
			genModel.setFacadeHelperClass(StandaloneASTFacadeHelper.class.getName()); // Bug 308069
			// genModel.setValidateModel(true);
			genModel.setBundleManifest(false); // New manifests should be
												// generated manually
			genModel.setUpdateClasspath(false); // New class-paths should be
												// generated manually
			genModel.setComplianceLevel(GenJDKLevel.JDK50_LITERAL);
			// genModel.setRootExtendsClass("org.eclipse.emf.ecore.impl.MinimalEObjectImpl$Container");
			Diagnostic diagnostic = genModel.diagnose();
			if (diagnostic.getSeverity() != Diagnostic.OK) {
				log.info(diagnostic);
			}

			/*
			 * JavaModelManager.getJavaModelManager().initializePreferences();
			 * new
			 * JavaCorePreferenceInitializer().initializeDefaultPreferences();
			 * 
			 * GenJDKLevel genSDKcomplianceLevel =
			 * genModel.getComplianceLevel(); String complianceLevel =
			 * JavaCore.VERSION_1_5; switch (genSDKcomplianceLevel) { case
			 * JDK60_LITERAL: complianceLevel = JavaCore.VERSION_1_6; case
			 * JDK14_LITERAL: complianceLevel = JavaCore.VERSION_1_4; default:
			 * complianceLevel = JavaCore.VERSION_1_5; } // Hashtable<?,?>
			 * defaultOptions = JavaCore.getDefaultOptions(); //
			 * JavaCore.setComplianceOptions(complianceLevel, defaultOptions);
			 * // JavaCore.setOptions(defaultOptions);
			 */

//			Generator generator = new Generator();
//			generator.setInput(genModel);
			Generator generator = GenModelUtil.createGenerator(genModel);
			Monitor monitor = showProgress ? new LoggerMonitor(log)
					: new BasicMonitor();
			diagnostic = generator.generate(genModel,
					GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE, monitor);
			if (diagnostic.getSeverity() != Diagnostic.OK)
				log.info(diagnostic);
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public boolean isShowProgress() {
		return showProgress;
	}

	public void setGenModel(String genModel) {
		this.genModel = genModel;
	}

	public void setResourceSet(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}

	public void setShowProgress(boolean showProgress) {
		this.showProgress = showProgress;
	}
}

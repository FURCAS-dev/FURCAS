/**
 * <copyright>
 * 
 * Copyright (c) 2007,2010 Eclipse Modeling Project and others.
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
 * $Id: OCLCreationFactory.java,v 1.4 2010/03/22 01:20:22 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ocl.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.ocl.examples.editor.ocl.ui.imp.OCLParseController;
import org.eclipse.ocl.examples.editor.ocl.ui.imp.OCLSourcePositionLocator;
import org.eclipse.ocl.examples.editor.ocl.ui.imp.OCLTreeModelBuilder;
import org.eclipse.ocl.examples.editor.ui.builder.CommonNature;
import org.eclipse.ocl.examples.editor.ui.common.AbstractCreationFactory;
import org.eclipse.ocl.examples.editor.ui.imp.CommonTreeModelBuilder;
import org.eclipse.ocl.examples.modelregistry.environment.FileHandle;
import org.eclipse.ocl.examples.parser.environment.ICSTRootEnvironment;
import org.eclipse.ocl.examples.parser.ocl.environment.OCLFileEnvironment;
import org.eclipse.ocl.examples.parser.ocl.unparser.OCLUnparser;
import org.eclipse.ocl.lpg.ProblemHandler;

public class OCLCreationFactory extends AbstractCreationFactory
{
	public static OCLCreationFactory INSTANCE = new OCLCreationFactory();
	public static final String BUILDER_ID = "org.eclipse.ocl.editor.ocl.ui.OCLBuilder"; //$NON-NLS-1$
	public static final String EDITOR_ID = "org.eclipse.ocl.editor.ocl.ui.OCLEditor"; //$NON-NLS-1$
	public static final String NATURE_ID = "org.eclipse.ocl.editor.ocl.ui.OCLNature"; //$NON-NLS-1$
	public static final String PROBLEM_MARKER_ID = "org.eclipse.ocl.editor.ocl.ui.oclProblem"; //$NON-NLS-1$

	protected OCLCreationFactory() {}
	
	public OCLFileEnvironment createFileEnvironment(FileHandle fileHandle, ResourceSet resourceSet, URI astURI) {
		XMIResource astResource = (XMIResource) resourceSet.createResource(astURI, org.eclipse.ocl.ecore.EcorePackage.eCONTENT_TYPE);
		astResource.getURI();		// FIXME Debugging: create the NPE now rather than much later
		return new OCLFileEnvironment(fileHandle, resourceSet, astResource);
	}
	
	public CommonNature createNature() {
		return new OCLNature();
	}
	
	public OCLParseController createParseController() {
		return new OCLParseController();
	}

	public ProblemHandler createProblemHandler(IFile file) {
		return new OCLMarkerProblemHandler(file);
	}

	public OCLSourcePositionLocator createSourcePositionLocator(ICSTRootEnvironment<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> environment) {
		return new OCLSourcePositionLocator(environment);
	}

	@Override
	public CommonTreeModelBuilder createTreeModelBuilder(boolean showAST) {
		return new OCLTreeModelBuilder(showAST);
	}

	public OCLUnparser createUnparser(Resource resource) {
		return new OCLUnparser(resource);
	}

	public String getBuilderId() { return BUILDER_ID; }
	public String getEMOFExtension() { return "emofocl"; } //$NON-NLS-1$
	public String[] getEMOFExtensions() { return new String[] { "emofocl" }; } //$NON-NLS-1$
	public String getEcoreExtension() { return "ecoreocl"; } //$NON-NLS-1$
	public String[] getEcoreExtensions() { return new String[] { "ecoreocl" }; } //$NON-NLS-1$
	public String getEditorName() { return "OCL"; } //$NON-NLS-1$
	public String getNatureId() { return NATURE_ID; }
	public OCLPlugin getPlugin() { return OCLPlugin.getInstance(); }
	public String getProblemMarkerId() { return PROBLEM_MARKER_ID; }
	public String getTextExtension() { return "ocl"; } //$NON-NLS-1$
	public String[] getTextExtensions() { return new String[] { "ocl" }; } //$NON-NLS-1$

	public String getXMLExtension() {
		return getEcoreExtension();
	}
}

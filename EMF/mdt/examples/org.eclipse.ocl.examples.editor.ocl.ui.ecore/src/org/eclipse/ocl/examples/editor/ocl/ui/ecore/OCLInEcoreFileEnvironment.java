/**
 * <copyright>
 *
 * Copyright (c) 2010 Eclipse Modeling Project and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: OCLInEcoreFileEnvironment.java,v 1.2 2010/03/13 13:16:49 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ocl.ui.ecore;

import lpg.runtime.Monitor;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.ocl.examples.modelregistry.environment.FileHandle;
import org.eclipse.ocl.examples.parser.ocl.OCLFileAnalyzer;
import org.eclipse.ocl.examples.parser.ocl.environment.OCLFileEnvironment;

/**
 * An OCLInEcoreFileEnvironment ensures that an OCLInEcoreFileAnalyzer
 * is used so that successful anlayses propagte back to the Ecore resource.
 */
public class OCLInEcoreFileEnvironment extends OCLFileEnvironment
{
	public OCLInEcoreFileEnvironment(FileHandle file, ResourceSet resourceSet, XMIResource astResource) {
		super(file, resourceSet, astResource);
	}

	@Override
	public OCLFileAnalyzer createAnalyzer(Monitor monitor) {
		return new OCLInEcoreFileAnalyzer(this, monitor);
	}
}

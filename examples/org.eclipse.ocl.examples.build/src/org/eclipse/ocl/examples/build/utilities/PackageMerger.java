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
 * $Id: PackageMerger.java,v 1.2 2011/01/24 20:54:27 ewillink Exp $
 */
package org.eclipse.ocl.examples.build.utilities;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.WorkflowComponentWithModelSlot;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Performs a UML package merge on the top level package of a designated <tt>modelSlot</tt>.
 */
public class PackageMerger extends WorkflowComponentWithModelSlot
{	
	private Logger log = Logger.getLogger(getClass());	

	public void invokeInternal(WorkflowContext ctx, ProgressMonitor arg1, Issues arg2) {
		Resource resource = (Resource) ctx.get(getModelSlot());
		log.info("Package merging '" + resource.getURI() + "'");
		org.eclipse.uml2.uml.Package package_ = (org.eclipse.uml2.uml.Package) resource.getContents().get(0);
		Map<String, String> options = new HashMap<String, String>();
		UMLUtil.merge(package_, options, null, null);
		EcoreUtil.resolveAll(resource);
		ResourceUtils.checkResourceSet(resource.getResourceSet());
	}
}

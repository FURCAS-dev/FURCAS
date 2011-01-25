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
 * $Id: ResourceUtils.java,v 1.2 2011/01/24 20:54:27 ewillink Exp $
 */
package org.eclipse.ocl.examples.build.utilities;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.mwe.core.ConfigurationException;

public class ResourceUtils
{
	private static Logger log = Logger.getLogger(ResourceUtils.class);	

	/**
	 * Checks all resources in a resource set for any errors or warnings.
	 * @param resourceSet
	 * @throws ConfigurationException if any error present
	 */
	public static void checkResourceSet(ResourceSet resourceSet) throws ConfigurationException {
		int errorCount = 0;
		for (Resource aResource : resourceSet.getResources()) {
			List<Diagnostic> errors = aResource.getErrors();
			if (errors.size() > 0) {
				for (Diagnostic error : errors) {
					log.error(error + " for '" + aResource.getURI() + "'");
					errorCount++;
				}
			}
			List<Diagnostic> warnings = aResource.getWarnings();
			if (warnings.size() > 0) {
				for (Diagnostic warning : warnings) {
					log.warn(warning + " for '" + aResource.getURI() + "'");
				}
			}
		}
		if (errorCount > 0) {
			throw new ConfigurationException("Errors in ResourceSet");
		}
	}
}

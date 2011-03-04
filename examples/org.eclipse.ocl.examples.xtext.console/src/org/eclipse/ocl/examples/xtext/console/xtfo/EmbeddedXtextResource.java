/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 ProxiAD and Others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Cedric Vidal (ProxiAD) - initial API and implementation
 *    E.D.Willink - integration of XTFO code uder CQ 4866
 *
 * </copyright>
 *
 * $Id: EmbeddedXtextResource.java,v 1.1 2011/03/04 22:18:25 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.console.xtfo;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.xtext.essentialocl.utilities.EssentialOCLCSResource;

public class EmbeddedXtextResource extends EssentialOCLCSResource {

	private Resource parentResource = null;

	public Resource getParentResource() {
		return parentResource;
	}

	public void setParentResource(Resource parentResource) {
		this.parentResource = parentResource;
	}

	public EmbeddedXtextResource() {
		super();
	}

}

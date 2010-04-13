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
 * $Id: OCLinEcoreDocument.java,v 1.1 2010/04/13 06:47:03 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.ui.model;

import java.io.IOException;
import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DocumentCS;
import org.eclipse.ocl.examples.xtext.oclinecore.resource.OCLinEcore2Ecore;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.XtextDocument;

public class OCLinEcoreDocument extends XtextDocument
{
	protected XtextResource resource2;
	
	public void saveAsEcore() throws IOException {
//		URI ecoreURI = resource2.getURI().appendFileExtension("ecore");
		URI ecoreURI = URI.createFileURI("C:/Temp/temp.ecore");
		Resource ecoreResource = new EcoreResourceFactoryImpl().createResource(ecoreURI);
		OCLinEcore2Ecore copier = new OCLinEcore2Ecore();
		DocumentCS document = (DocumentCS) resource2.getContents().get(0);
		Collection<? extends EObject> ecoreContents = copier.convertAll(document.getPackages());
		ecoreResource.getContents().addAll(ecoreContents);
		ecoreResource.save(null);
	}

	@Override
	public void setInput(XtextResource resource) {
		this.resource2 = resource;
		super.setInput(resource);
	}
}

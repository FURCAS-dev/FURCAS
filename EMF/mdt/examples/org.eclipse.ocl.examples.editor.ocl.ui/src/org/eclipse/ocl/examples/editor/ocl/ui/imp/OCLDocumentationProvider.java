/**
 * <copyright>
 * 
 * Copyright (c) 2008,2010 Eclipse Modeling Project and others.
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
 * $Id: OCLDocumentationProvider.java,v 1.1 2010/03/11 14:52:54 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ocl.ui.imp;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.examples.common.utils.EcoreUtils;
import org.eclipse.ocl.examples.editor.ui.imp.CommonDocumentationProvider;

public class OCLDocumentationProvider extends CommonDocumentationProvider
{
	@Override
	protected String getASTDocumentation(Object node) {
		if (node instanceof Constraint)
			return "<" + ((Constraint)node).getStereotype() + "> " + EcoreUtils.simpleNameFor(((EObject)node).eClass()) + " : " + EcoreUtils.qualifiedNameFor(node);
		return super.getASTDocumentation(node);
	}
}

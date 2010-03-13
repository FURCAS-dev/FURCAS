/**
 * <copyright>
 * 
 * Copyright (c) 2010 Eclipse Modeling Project and others.
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
 * $Id: AbstractOCLInEcoreEditorTestCase.java,v 1.2 2010/03/13 18:11:25 ewillink Exp $
 */
package org.eclipse.ocl.examples.test.editor.ocl.ecore;


import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.ecore.delegate.OCLDelegateDomain;
import org.eclipse.ocl.examples.editor.ocl.ui.ecore.OCLInEcoreCreationFactory;
import org.eclipse.ocl.examples.editor.ui.ICreationFactory;
import org.eclipse.ocl.examples.test.editor.AbstractEditorTestCase;

public abstract class AbstractOCLInEcoreEditorTestCase extends AbstractEditorTestCase
{	
	protected void checkConstraint(String when, EClass eClass, String which, String what) {
		String expression = EcoreUtil.getAnnotation(eClass, OCLDelegateDomain.OCL_DELEGATE_URI, which);
		assertEquals(when, what, expression);
	}
	
	protected void checkConstraints(String when, EClass eClass, String... whiches) {
		List<String> constraints = EcoreUtil.getConstraints(eClass);		
		assertEquals(when + " - constraint count", whiches.length, constraints.size());
		for (String which : whiches) {
			checkPresent(when, constraints, which);
		}
	}

	@Override
	protected ICreationFactory getCreationFactory() {
		return OCLInEcoreCreationFactory.INSTANCE;
	}

	@Override
	protected String getEditorId() {
		return OCLInEcoreCreationFactory.EDITOR_ID;
	}
}

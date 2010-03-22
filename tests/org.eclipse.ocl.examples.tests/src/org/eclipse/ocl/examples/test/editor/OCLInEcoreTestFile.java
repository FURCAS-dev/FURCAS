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
 * $Id: OCLInEcoreTestFile.java,v 1.2 2010/03/22 01:27:22 ewillink Exp $
 */
package org.eclipse.ocl.examples.test.editor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.ecore.delegate.InvocationBehavior;
import org.eclipse.ocl.ecore.delegate.OCLDelegateDomain;
import org.eclipse.ocl.ecore.delegate.SettingBehavior;
import org.eclipse.ocl.ecore.delegate.ValidationBehavior;

public class OCLInEcoreTestFile extends EcoreTestFileBase implements OCLTestFile
{
	public class InvariantChecker
	{
		private final EClass eClass;
		
		public InvariantChecker(EClass eClass) {
			this.eClass = eClass;
		}
		
		public void checkConstraint(String when, String which, String what) {
			String expression = EcoreUtil.getAnnotation(eClass, OCLDelegateDomain.OCL_DELEGATE_URI, which);
			TestCase.assertEquals(when, what, expression);
		}
		
		public void checkConstraints(String when, String... whiches) {
			List<String> constraints = EcoreUtil.getConstraints(eClass);		
			TestCase.assertEquals(when + " - constraint count", whiches.length, constraints.size());
			for (String which : whiches) {
				AbstractEditorTestCase.checkPresent(when, constraints, which);
			}
		}
	}

	public OCLInEcoreTestFile(IFile file) {
		super(file);
	}

	@Override
	public EPackage createEPackage(EPackage parentPackage, String name) {
		EPackage ePackage = super.createEPackage(parentPackage, name);
	    EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
	    eAnnotation.setSource(EcorePackage.eNS_URI);
	    EMap<String, String> details = eAnnotation.getDetails();
		details.put(InvocationBehavior.NAME, OCLDelegateDomain.OCL_DELEGATE_URI);
		details.put(SettingBehavior.NAME, OCLDelegateDomain.OCL_DELEGATE_URI);
		details.put(ValidationBehavior.NAME, OCLDelegateDomain.OCL_DELEGATE_URI);
	    ePackage.getEAnnotations().add(eAnnotation);
		return ePackage;
	}

	public void createInvariant(EClass eClass, String name, String expression) {
	    EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
	    eAnnotation.setSource(OCLDelegateDomain.OCL_DELEGATE_URI);
	    eAnnotation.getDetails().put(name, expression);
	    eClass.getEAnnotations().add(eAnnotation);
	    Set<String> constraints = new HashSet<String>(EcoreUtil.getConstraints(eClass));
	    constraints.add(name);
	    EcoreUtil.setConstraints(eClass, new ArrayList<String>(constraints));
	}

	public InvariantChecker createInvariantChecker(EClass eClass) {
		return new InvariantChecker(eClass);
	}
}
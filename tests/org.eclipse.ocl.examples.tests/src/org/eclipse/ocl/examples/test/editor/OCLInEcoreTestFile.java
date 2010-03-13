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
 * $Id: OCLInEcoreTestFile.java,v 1.1 2010/03/13 18:11:25 ewillink Exp $
 */
package org.eclipse.ocl.examples.test.editor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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

public class OCLInEcoreTestFile extends EcoreTestFile
{
	public OCLInEcoreTestFile(IFile file) {
		super(file);
	}

	public EPackage createEPackageWithDelegates(EPackage parentPackage, String name) {
		EPackage ePackage = createEPackage(parentPackage, name);
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
}
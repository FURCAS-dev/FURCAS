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
 * $Id: OCLDelegateActivator.java,v 1.2 2011/01/24 20:54:27 ewillink Exp $
 */
package org.eclipse.ocl.examples.build.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.WorkflowComponentWithModelSlot;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.ocl.ecore.delegate.InvocationBehavior;
import org.eclipse.ocl.ecore.delegate.OCLDelegateDomain;
import org.eclipse.ocl.ecore.delegate.SettingBehavior;
import org.eclipse.ocl.ecore.delegate.ValidationBehavior;

/**
 * Alphabeticizes a designated <tt>modelSlot</tt> so that primitive types
 * appear before enumerations before classes before associations, each
 * in alphabetical order.
 */
public class OCLDelegateActivator extends WorkflowComponentWithModelSlot
{
	private Logger log = Logger.getLogger(getClass());	

	public void invokeInternal(WorkflowContext ctx, ProgressMonitor arg1, Issues arg2) {
		Resource resource = (Resource) ctx.get(getModelSlot());
		log.info("Activating OCL Delegates in '" + resource.getURI() + "'");
		Map<EClass, List<EAnnotation>> eAnnotations = gatherConstraintAnnotations(resource);
		Set<EPackage> ePackages = new HashSet<EPackage>();
		for (EClass eClass : eAnnotations.keySet()) {
			EPackage ePackage = eClass.getEPackage();
			if (!ePackages.contains(ePackage)) {
				ePackages.add(ePackage);
			    EAnnotation packageAnnotation = ePackage.getEAnnotation(EcorePackage.eNS_URI);
			    if (packageAnnotation == null) {
			    	packageAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			    	packageAnnotation.setSource(EcorePackage.eNS_URI);
			    	ePackage.getEAnnotations().add(packageAnnotation);
			    }
			    EMap<String, String> details = packageAnnotation.getDetails();
				details.put(InvocationBehavior.NAME, OCLDelegateDomain.OCL_DELEGATE_URI);
			    details.put(SettingBehavior.NAME, OCLDelegateDomain.OCL_DELEGATE_URI);
			    details.put(ValidationBehavior.NAME, OCLDelegateDomain.OCL_DELEGATE_URI);
			}
		}
	}

	public Map<EClass, List<EAnnotation>> gatherConstraintAnnotations(Resource resource) {
		Map<EClass, List<EAnnotation>> eAnnotations = new HashMap<EClass, List<EAnnotation>>();
		for (Iterator<EObject> it = resource.getAllContents(); it.hasNext(); ) {
			EObject eObject = it.next();
			EObject eContainer = eObject.eContainer();
			if ((eObject instanceof EAnnotation) && (eContainer instanceof EOperation)) {
				EAnnotation eAnnotation = (EAnnotation) eObject;
				EOperation eOperation = (EOperation) eContainer;
				if (EcoreUtil.isInvariant(eOperation) &&
					"http://www.eclipse.org/emf/2002/GenModel".equals(eAnnotation.getSource())) {
					EClass eClass = eOperation.getEContainingClass();
					List<EAnnotation> list = eAnnotations.get(eClass);
					if (list == null) {
						list = new ArrayList<EAnnotation>();
						eAnnotations.put(eClass, list);
					}
					list.add(eAnnotation);
				}
			}
		}
		return eAnnotations;
	}
}

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
 * $Id: VisitableAcceptGenerator.java,v 1.2 2011/01/24 20:54:27 ewillink Exp $
 */
package org.eclipse.ocl.examples.build.utilities;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.WorkflowComponentWithModelSlot;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

/**
 * Alphabeticizes a designated <tt>modelSlot</tt> so that primitive types
 * appear before enumerations before classes before associations, each
 * in alphabetical order.
 */
public class VisitableAcceptGenerator extends WorkflowComponentWithModelSlot
{
	private Logger log = Logger.getLogger(getClass());	

	public void invokeInternal(WorkflowContext ctx, ProgressMonitor arg1, Issues arg2) {
		Resource resource = (Resource) ctx.get(getModelSlot());
		log.info("Inserting Visitable.accept in '" + resource.getURI() + "'");
		EClassifier visitorClass = findClassifier(resource.getContents(), "Visitor");
		if (visitorClass != null) {
			processPackages(resource.getContents(), visitorClass);
		}
		else {
			log.error("No Visitor class found in '" + resource.getURI() + "'");
		}
	}

	protected EClassifier findClassifier(List<? extends EObject> eContents, String string) {
		for (EObject eContent : eContents) {
			if (eContent instanceof EPackage) {
				EPackage ePackage = (EPackage) eContent;
				for (EClassifier eClassifier : ePackage.getEClassifiers()) {
					if (string.equals(eClassifier.getName())) {
						return eClassifier;
					}
				}
				EClassifier eClassifier = findClassifier(ePackage.getESubpackages(), string);
				if (eClassifier != null) {
					return eClassifier;
				}
			}
		}
		return null;
	}

	protected void processPackages(List<? extends EObject> eContents, EClassifier visitorClass) {
		for (EObject eContent : eContents) {
			if (eContent instanceof EPackage) {
				EPackage ePackage = (EPackage) eContent;
				for (EClassifier eClassifier : ePackage.getEClassifiers()) {
					if (eClassifier instanceof EClass) {
						EClass eClass = (EClass) eClassifier;
						if (!eClass.isAbstract() && !eClass.isInterface()) {
							processClass(eClass, visitorClass);
						}
					}
				}
				processPackages(ePackage.getESubpackages(), visitorClass);
			}
		}
	}

	protected void processClass(EClass eClass, EClassifier visitorClass) {
		EOperation eOperation = EcoreFactory.eINSTANCE.createEOperation();
		eOperation.setName("accept");
		ETypeParameter eTypeParameter1 = EcoreFactory.eINSTANCE.createETypeParameter();
		eTypeParameter1.setName("R");
		eOperation.getETypeParameters().add(eTypeParameter1);
		ETypeParameter eTypeParameter2 = EcoreFactory.eINSTANCE.createETypeParameter();
		eTypeParameter2.setName("C");
		eOperation.getETypeParameters().add(eTypeParameter2);
		EGenericType eGenericReturnType = EcoreFactory.eINSTANCE.createEGenericType();
		eGenericReturnType.setETypeParameter(eTypeParameter1);
		eOperation.setEGenericType(eGenericReturnType);
		EParameter eParameter = EcoreFactory.eINSTANCE.createEParameter();
		eParameter.setName("v");
		EGenericType eGenericParameterType = EcoreFactory.eINSTANCE.createEGenericType();
		eGenericParameterType.setEClassifier(visitorClass);
		EGenericType eGenericArgument1 = EcoreFactory.eINSTANCE.createEGenericType();
		eGenericArgument1.setETypeParameter(eTypeParameter1);
		eGenericParameterType.getETypeArguments().add(eGenericArgument1);
		EGenericType eGenericArgument2 = EcoreFactory.eINSTANCE.createEGenericType();
		eGenericArgument2.setETypeParameter(eTypeParameter2);
		eGenericParameterType.getETypeArguments().add(eGenericArgument2);
		eParameter.setEGenericType(eGenericParameterType);
		eOperation.getEParameters().add(eParameter);
		EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		eAnnotation.setSource("http://www.eclipse.org/emf/2002/GenModel");		// FIXME find constant
		eAnnotation.getDetails().put("body", "return v.visit" + eClass.getName() + "(this);");
		eOperation.getEAnnotations().add(eAnnotation);
		eClass.getEOperations().add(eOperation);	
	}
}

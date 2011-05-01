/**
 * <copyright>
 * 
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   C.Damus, K.Hussey, E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 *
 * $Id: PivotInstaller.java,v 1.3 2011/04/25 09:49:15 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.delegate;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.ecore.Pivot2Ecore;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;

public class PivotInstaller
{

	public static void installDelegates(TypeManager typeManager, org.eclipse.ocl.examples.pivot.Package pivotPackage) {
		boolean hasDelegates = false;
		for (Type aType : typeManager.getLocalClasses(pivotPackage)) {
			if (installDelegates(typeManager, aType)) {
				hasDelegates = true;
			}
		}
		org.eclipse.ocl.examples.pivot.Package primaryPackage = typeManager.getPrimaryPackage(pivotPackage);
		EObject eTarget = primaryPackage.getETarget();
		if ((eTarget instanceof EPackage) && hasDelegates) {
			Pivot2Ecore.installDelegates((EPackage) eTarget);
		}
		for (org.eclipse.ocl.examples.pivot.Package nestedPackage : typeManager.getLocalPackages(pivotPackage)) {
			installDelegates(typeManager, nestedPackage);
		}
	}

	private static boolean installDelegates(TypeManager typeManager, Type pivotType) {
		boolean hasDelegates = false;
//		CompleteType completeType = typeManager.getCompleteType(pivotType);
//		Type modelType = completeType.getModel();
//		if (modelType instanceof org.eclipse.ocl.examples.pivot.Class) {
//			org.eclipse.ocl.examples.pivot.Class modelClass = (org.eclipse.ocl.examples.pivot.Class)modelType;
			for (Operation anOperation : typeManager.getLocalOperations(pivotType, null)) {
				if (installDelegates(typeManager, anOperation)) {
					hasDelegates = true;
				}
			}
			for (Property aProperty : typeManager.getLocalProperties(pivotType, null)) {
				if (installDelegates(typeManager, aProperty)) {
					hasDelegates = true;
				}
			}
//		}
		org.eclipse.ocl.examples.pivot.Class primaryClass = typeManager.getPrimaryClass(pivotType);
		EObject eTarget = primaryClass.getETarget();
		if (eTarget instanceof EClassifier) {
			EClassifier eClassifier = (EClassifier)eTarget;
			for (Constraint constraint : typeManager.getLocalConstraints(pivotType)) {
				if (Pivot2Ecore.installDelegate(eClassifier, constraint)) {
					hasDelegates = true;
				}
			}
			if (hasDelegates) {
				Pivot2Ecore.installDelegates(typeManager, eClassifier, pivotType);
			}
		}
		return hasDelegates;
	}

	private static boolean installDelegates(TypeManager typeManager, Property aProperty) {
		// TODO Auto-generated method stub
		return false;
	}

	private static boolean installDelegates(TypeManager typeManager,
			Operation anOperation) {
		// TODO Auto-generated method stub
		return false;
	}

/*	public static void prepareDelegates(TypeManager typeManager, Package pivotPackage) {
		for (Type aType : typeManager.getLocalTypes(pivotPackage)) {
			prepareDelegates(typeManager, aType);
		}
		for (org.eclipse.ocl.examples.pivot.Package nestedPackage : typeManager.getLocalPackages(pivotPackage)) {
			prepareDelegates(typeManager, nestedPackage);
		}
	}

	private static void prepareDelegates(TypeManager typeManager, Type pivotType) {
		for (Operation anOperation : typeManager.getLocalOperations(pivotType)) {
			prepareDelegates(typeManager, anOperation);
		}
		for (Property aProperty : typeManager.getLocalProperties(pivotType)) {
			prepareDelegates(typeManager, aProperty);
		}
	}

	private static void prepareDelegates(TypeManager typeManager, Property pivotProperty) {
		typeManager.useCompleteEnvironmentManager().getCompleteProperty(pivotProperty);
	}

	private static void prepareDelegates(TypeManager typeManager, Operation pivotOperation) {
		typeManager.useCompleteEnvironmentManager().getCompleteOperation(pivotOperation);
	} */
}

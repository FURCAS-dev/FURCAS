/******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/


package org.eclipse.emf.ocl.parser;

import java.util.Iterator;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;



/**
 * Environment factory for the Ecore metamodel.
 *
 * @author Christian W. Damus (cdamus)
 */
public class EcoreEnvironmentFactory
	extends AbstractEnvironmentFactory {
	
	private static EClassifier JAVA_OBJECT_DATATYPE =
		EcorePackage.eINSTANCE.getEJavaObject();
	
	/**
	 * Initializes me.
	 */
	protected EcoreEnvironmentFactory() {
		super();
	}
	
	protected EClassifier asEClassifier(Object context) {
		EClassifier result = null;
		
		if (context instanceof EClassifier) {
			// easy case
			result = (EClassifier) context;
		} else if (context instanceof EObject) {
			result = ((EObject) context).eClass();
		} else {
			// maybe it's an instance of an Ecore data type?
			for (Iterator iter = EcorePackage.eINSTANCE.getEClassifiers().iterator();
					(result == null) && iter.hasNext();) {
				EClassifier next = (EClassifier) iter.next();
				
				if ((next != JAVA_OBJECT_DATATYPE) && (next.isInstance(context))) {
					result = next;
				}
			}
			
			if (result == null) {
				// it's just some weirdo Java object that we don't understand
				result = JAVA_OBJECT_DATATYPE;
			}
		}
		
		return result;
	}
	
	protected EOperation asEOperation(Object operation) {
		if (!(operation instanceof EOperation)) {
			throw new IllegalArgumentException(
				"Not a valid Ecore operation: " + operation); //$NON-NLS-1$
		}
		
		return (EOperation) operation;
	}

	/**
	 * Creates an environment for OCL constraints in the context of the
	 * specified <code>classifier</code>.
	 * 
	 * @param classifier the context classifier
	 * @return the OCL environment
	 */
	protected Environment createEnvironment(EPackage packageContext) {
		return new EcoreEnvironment(packageContext);
	}

	public Environment createEnvironment(Environment parent) {
		if (parent.getClass() != EcoreEnvironment.class) {
			throw new IllegalArgumentException(
				"Parent environment must be an Ecore environment: " + parent); //$NON-NLS-1$
		}
		
		return new EcoreEnvironment(parent);
	}
}

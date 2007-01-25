/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */

package org.eclipse.emf.ocl.parser;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;



/**
 * Environment factory for the Ecore metamodel.
 *
 * @deprecated Use the {@link org.eclipse.ocl.ecore.EcoreEnvironmentFactory} class,
 * instead.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class EcoreEnvironmentFactory
	extends AbstractEnvironmentFactory {
	
	private EPackage.Registry registry;

	/**
	 * Initializes me.
	 */
	protected EcoreEnvironmentFactory() {
		this(EPackage.Registry.INSTANCE);
	}
	
	/**
	 * Initializes me with an <code>EPackage.Registry</code>
	 */
	public EcoreEnvironmentFactory(EPackage.Registry reg) {
		super();
		this.registry = reg;
	}

	public Environment createPackageContext(List pathname) {
		EPackage defaultPackage = EcoreEnvironment.findPackage(pathname, registry);
		if (defaultPackage != null) {
			EcoreEnvironment result = new EcoreEnvironment(defaultPackage, registry);
			result.setFactory(this);
			return result;
		}
		return null;
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
				
				if ((next != EcorePackage.Literals.EJAVA_OBJECT) && (next.isInstance(context))) {
					result = next;
				}
			}
			
			if (result == null) {
				// it's just some weirdo Java object that we don't understand
				result = EcorePackage.Literals.EJAVA_OBJECT;
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

	protected EStructuralFeature asEStructuralFeature(Object property) {
		if (!(property instanceof EStructuralFeature)) {
			throw new IllegalArgumentException(
				"Not a valid Ecore property: " + property); //$NON-NLS-1$
		}
		
		return (EStructuralFeature) property;
	}
	
	/**
	 * Creates an environment for OCL constraints in the context of the
	 * specified <code>classifier</code>.
	 * 
	 * @param classifier the context classifier
	 * @return the OCL environment
	 */
	protected Environment createEnvironment(EPackage packageContext) {
		EcoreEnvironment result = new EcoreEnvironment(packageContext, registry);
		result.setFactory(this);
		return result;
	}

	public Environment createEnvironment(Environment parent) {
		if (!(parent instanceof EcoreEnvironment)) {
			throw new IllegalArgumentException(
				"Parent environment must be an Ecore environment: " + parent); //$NON-NLS-1$
		}
		
		EcoreEnvironment result = new EcoreEnvironment(parent);
		result.setFactory(this);
		return result;
	}
}

/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *   
 * </copyright>
 *
 * $Id: OCLSyntaxHelper.java,v 1.18 2010/01/22 18:38:12 asanchez Exp $
 */
package org.eclipse.ocl.ecore;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.EnvironmentFactory;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;

/**
 * A factory for creating OCL parser {@link EcoreEnvironment}s.  Clients of the OCL
 * parser that wish to use OCL with their metamodels can provide the parser
 * a factory that creates the suitable environments.  The environment provides
 * mappings from the client's metamodel to the UML concepts required by the
 * parser (corresponding to the generic type parameters, below).  Many of these
 * mappings are optional (e.g., state machines, signals, and association
 * classes aren't supported by all metamodels).
 * <p>
 * @noimplement This interface is <b>not</b> intended to be implemented to be implemented
 * "directly" by providers of metamodel bindings.
 * It is highly recommended to extend the {@link EcoreEnvironmentFactory}
 * class, instead.
 * </p><p>
 * @since 3.1
 */
public interface EcoreEnvironmentFactoryInterface extends EnvironmentFactory<
	EPackage, EClassifier, EOperation, EStructuralFeature,
	EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction,
	Constraint, EClass, EObject>
{
	/**
	 * Gets an object to assist in locating the opposite end of meta-model
	 * references that are not directly represented by EOpposite.
	 * <p>
	 * See DefaultOppositeEndFinder for an implementation that uses EAnnotations.
	 * 
	 * @return the OppositeEndFinder
	 */
	OppositeEndFinder getOppositeEndFinder();
}
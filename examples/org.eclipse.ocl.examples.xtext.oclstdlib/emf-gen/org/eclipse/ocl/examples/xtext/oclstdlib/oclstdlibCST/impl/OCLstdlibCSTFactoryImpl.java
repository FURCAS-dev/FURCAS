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
 * $Id: OCLstdlibCSTFactoryImpl.java,v 1.3 2011/01/24 22:28:26 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.*;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibAccumulatorCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibConstraintCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibIterationCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibIteratorCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibOperationCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibPropertyCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibRootPackageCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.OCLstdlibCSTFactory;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.OCLstdlibCSTPackage;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.PrecedenceCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OCLstdlibCSTFactoryImpl
		extends EFactoryImpl
		implements OCLstdlibCSTFactory {

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OCLstdlibCSTFactory init() {
		try
		{
			OCLstdlibCSTFactory theOCLstdlibCSTFactory = (OCLstdlibCSTFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/ocl/3.1.0/OCLstdlibCST"); 
			if (theOCLstdlibCSTFactory != null)
			{
				return theOCLstdlibCSTFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OCLstdlibCSTFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLstdlibCSTFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID())
		{
			case OCLstdlibCSTPackage.LIB_ACCUMULATOR_CS: return createLibAccumulatorCS();
			case OCLstdlibCSTPackage.LIB_CLASS_CS: return createLibClassCS();
			case OCLstdlibCSTPackage.LIB_CONSTRAINT_CS: return createLibConstraintCS();
			case OCLstdlibCSTPackage.LIB_ITERATION_CS: return createLibIterationCS();
			case OCLstdlibCSTPackage.LIB_ITERATOR_CS: return createLibIteratorCS();
			case OCLstdlibCSTPackage.LIB_OPERATION_CS: return createLibOperationCS();
			case OCLstdlibCSTPackage.LIB_PROPERTY_CS: return createLibPropertyCS();
			case OCLstdlibCSTPackage.LIB_ROOT_PACKAGE_CS: return createLibRootPackageCS();
			case OCLstdlibCSTPackage.PRECEDENCE_CS: return createPrecedenceCS();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibAccumulatorCS createLibAccumulatorCS() {
		LibAccumulatorCSImpl libAccumulatorCS = new LibAccumulatorCSImpl();
		return libAccumulatorCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibClassCS createLibClassCS()
	{
		LibClassCSImpl libClassCS = new LibClassCSImpl();
		return libClassCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibConstraintCS createLibConstraintCS() {
		LibConstraintCSImpl libConstraintCS = new LibConstraintCSImpl();
		return libConstraintCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibIterationCS createLibIterationCS() {
		LibIterationCSImpl libIterationCS = new LibIterationCSImpl();
		return libIterationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibIteratorCS createLibIteratorCS() {
		LibIteratorCSImpl libIteratorCS = new LibIteratorCSImpl();
		return libIteratorCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibOperationCS createLibOperationCS() {
		LibOperationCSImpl libOperationCS = new LibOperationCSImpl();
		return libOperationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibPropertyCS createLibPropertyCS() {
		LibPropertyCSImpl libPropertyCS = new LibPropertyCSImpl();
		return libPropertyCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibRootPackageCS createLibRootPackageCS() {
		LibRootPackageCSImpl libRootPackageCS = new LibRootPackageCSImpl();
		return libRootPackageCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrecedenceCS createPrecedenceCS() {
		PrecedenceCSImpl precedenceCS = new PrecedenceCSImpl();
		return precedenceCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLstdlibCSTPackage getOCLstdlibCSTPackage() {
		return (OCLstdlibCSTPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OCLstdlibCSTPackage getPackage() {
		return OCLstdlibCSTPackage.eINSTANCE;
	}

} //OCLstdlibCSTFactoryImpl

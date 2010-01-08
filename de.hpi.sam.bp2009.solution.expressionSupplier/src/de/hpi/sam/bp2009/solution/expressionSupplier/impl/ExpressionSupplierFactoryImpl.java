/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.expressionSupplier.impl;

import de.hpi.sam.bp2009.solution.expressionSupplier.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExpressionSupplierFactoryImpl extends EFactoryImpl implements ExpressionSupplierFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExpressionSupplierFactory init() {
		try {
			ExpressionSupplierFactory theExpressionSupplierFactory = (ExpressionSupplierFactory)EPackage.Registry.INSTANCE.getEFactory("http://de.hpi.sam.bp2009.solution.expressionSupplier"); 
			if (theExpressionSupplierFactory != null) {
				return theExpressionSupplierFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ExpressionSupplierFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionSupplierFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ExpressionSupplierPackage.EXPRESSION_SUPPLIER: return createExpressionSupplier();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionSupplier createExpressionSupplier() {
		ExpressionSupplierImpl expressionSupplier = new ExpressionSupplierImpl();
		return expressionSupplier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionSupplierPackage getExpressionSupplierPackage() {
		return (ExpressionSupplierPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ExpressionSupplierPackage getPackage() {
		return ExpressionSupplierPackage.eINSTANCE;
	}

} //ExpressionSupplierFactoryImpl

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.loopOperator.impl;

import de.hpi.sam.bp2009.benchframework.loopOperator.*;

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
public class LoopOperatorFactoryImpl extends EFactoryImpl implements LoopOperatorFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LoopOperatorFactory init() {
		try {
			LoopOperatorFactory theLoopOperatorFactory = (LoopOperatorFactory)EPackage.Registry.INSTANCE.getEFactory("http://de.hpi.sam.bp2009.benchframework.loopOperator"); 
			if (theLoopOperatorFactory != null) {
				return theLoopOperatorFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new LoopOperatorFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoopOperatorFactoryImpl() {
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
			case LoopOperatorPackage.LOOP_OPERATOR_START: return createLoopOperatorStart();
			case LoopOperatorPackage.LOOP_OPERATOR_END: return createLoopOperatorEnd();
			case LoopOperatorPackage.LOOP_OPERATOR_OPTION_OBJECT: return createLoopOperatorOptionObject();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoopOperatorStart createLoopOperatorStart() {
		LoopOperatorStartImpl loopOperatorStart = new LoopOperatorStartImpl();
		return loopOperatorStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoopOperatorEnd createLoopOperatorEnd() {
		LoopOperatorEndImpl loopOperatorEnd = new LoopOperatorEndImpl();
		return loopOperatorEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoopOperatorOptionObject createLoopOperatorOptionObject() {
		LoopOperatorOptionObjectImpl loopOperatorOptionObject = new LoopOperatorOptionObjectImpl();
		return loopOperatorOptionObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoopOperatorPackage getLoopOperatorPackage() {
		return (LoopOperatorPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static LoopOperatorPackage getPackage() {
		return LoopOperatorPackage.eINSTANCE;
	}

} //LoopOperatorFactoryImpl

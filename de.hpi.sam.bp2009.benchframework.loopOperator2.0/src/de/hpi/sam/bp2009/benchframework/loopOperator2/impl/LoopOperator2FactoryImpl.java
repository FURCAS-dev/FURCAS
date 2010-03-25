/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.loopOperator2.impl;

import de.hpi.sam.bp2009.benchframework.loopOperator2.*;

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
public class LoopOperator2FactoryImpl extends EFactoryImpl implements LoopOperator2Factory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LoopOperator2Factory init() {
		try {
			LoopOperator2Factory theLoopOperator2Factory = (LoopOperator2Factory)EPackage.Registry.INSTANCE.getEFactory("http://de.hpi.sam.bp2009.benchframework.loopOperator2"); 
			if (theLoopOperator2Factory != null) {
				return theLoopOperator2Factory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new LoopOperator2FactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoopOperator2FactoryImpl() {
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
			case LoopOperator2Package.START_LOOP: return createStartLoop();
			case LoopOperator2Package.END_LOOP: return createEndLoop();
			case LoopOperator2Package.LOOP_OPTION: return createLoopOption();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartLoop createStartLoop() {
		StartLoopImpl startLoop = new StartLoopImpl();
		return startLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndLoop createEndLoop() {
		EndLoopImpl endLoop = new EndLoopImpl();
		return endLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoopOption createLoopOption() {
		LoopOptionImpl loopOption = new LoopOptionImpl();
		return loopOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoopOperator2Package getLoopOperator2Package() {
		return (LoopOperator2Package)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static LoopOperator2Package getPackage() {
		return LoopOperator2Package.eINSTANCE;
	}

} //LoopOperator2FactoryImpl

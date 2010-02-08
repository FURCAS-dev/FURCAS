/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.impl;

import de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.*;

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
public class ModifiedOclOptimizerFactoryImpl extends EFactoryImpl implements ModifiedOclOptimizerFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ModifiedOclOptimizerFactory init() {
		try {
			ModifiedOclOptimizerFactory theModifiedOclOptimizerFactory = (ModifiedOclOptimizerFactory)EPackage.Registry.INSTANCE.getEFactory("http://de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer"); 
			if (theModifiedOclOptimizerFactory != null) {
				return theModifiedOclOptimizerFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ModifiedOclOptimizerFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifiedOclOptimizerFactoryImpl() {
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
			case ModifiedOclOptimizerPackage.MODIFIED_OCL_OPTIMIZER: return createModifiedOclOptimizer();
			case ModifiedOclOptimizerPackage.EMBED_MODIFIED_OCL_OPT_OPERATOR: return createEmbedModifiedOclOptOperator();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifiedOclOptimizer createModifiedOclOptimizer() {
		ModifiedOclOptimizerImpl modifiedOclOptimizer = new ModifiedOclOptimizerImpl();
		return modifiedOclOptimizer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmbedModifiedOclOptOperator createEmbedModifiedOclOptOperator() {
		EmbedModifiedOclOptOperatorImpl embedModifiedOclOptOperator = new EmbedModifiedOclOptOperatorImpl();
		return embedModifiedOclOptOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifiedOclOptimizerPackage getModifiedOclOptimizerPackage() {
		return (ModifiedOclOptimizerPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ModifiedOclOptimizerPackage getPackage() {
		return ModifiedOclOptimizerPackage.eINSTANCE;
	}

} //ModifiedOclOptimizerFactoryImpl

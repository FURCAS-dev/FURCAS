/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.query.ocl.conditions.AbstractOCLCondition;

import de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.ModifiedOclOptimizer;
import de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.ModifiedOclOptimizerPackage;
import de.hpi.sam.bp2009.solution.oclEvaluator.impl.OCLEvaluatorImpl;
/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Modified Ocl Optimizer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ModifiedOclOptimizerImpl extends OCLEvaluatorImpl implements ModifiedOclOptimizer {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModifiedOclOptimizerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModifiedOclOptimizerPackage.Literals.MODIFIED_OCL_OPTIMIZER;
	}
	
	@Override
	public Object evaluate(AbstractOCLCondition queryobject, EObject context) {
		return super.evaluate(queryobject, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void sendBenchmarkNotification(Object communicationPartner, boolean incoming) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

} //ModifiedOclOptimizerImpl

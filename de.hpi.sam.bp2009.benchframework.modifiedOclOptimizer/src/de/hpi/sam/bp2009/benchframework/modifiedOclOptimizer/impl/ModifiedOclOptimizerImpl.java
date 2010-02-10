/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.impl;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.ModifiedOclOptimizer;
import de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.ModifiedOclOptimizerPackage;
import de.hpi.sam.bp2009.solution.oclEvaluator.Interpreter;
import de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery;
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
	public Object passToInterpreter(Interpreter interpreter,
			OclQuery queryobject) {
		sendBenchmarkNotification(interpreter, false);
		Object result = super.passToInterpreter(interpreter, queryobject);
		sendBenchmarkNotification(interpreter, true);
		return result;
	}
	
	@Override
	public Object evaluate(OclQuery queryobject) {
		sendBenchmarkNotification(null, true);
		Object result = super.evaluate(queryobject);
		sendBenchmarkNotification(null, false);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void sendBenchmarkNotification(Object communicationPartner, boolean incoming) {
		ENotificationImpl n;
		if (incoming)
			n = new ENotificationImpl(this, 1, null, null, communicationPartner);
		else
			n = new ENotificationImpl(this, 0, null, null, communicationPartner);

		for (Adapter a : eAdapters){
			a.notifyChanged(n);
		}
	}

} //ModifiedOclOptimizerImpl

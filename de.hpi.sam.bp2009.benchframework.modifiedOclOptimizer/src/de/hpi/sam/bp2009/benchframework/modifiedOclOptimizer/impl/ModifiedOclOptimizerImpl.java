/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.impl;

import java.util.UUID;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.ModifiedOclOptimizer;
import de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.ModifiedOclOptimizerNotifyLiterals;
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
		UUID id = UUID.randomUUID();
		eNotify(new ENotificationImpl(this,ModifiedOclOptimizerNotifyLiterals.SEND_QUERY_TO_INTERPRETER_VALUE, Notification.NO_FEATURE_ID, id, null));
		Object result = super.passToInterpreter(interpreter, queryobject);
		eNotify(new ENotificationImpl(this,ModifiedOclOptimizerNotifyLiterals.GET_RESULT_FROM_INTERPRETER_VALUE, Notification.NO_FEATURE_ID, id, null));
		return result;
	}
	
	@Override
	public Object evaluate(OclQuery queryobject) {
		UUID id = UUID.randomUUID();
		eNotify(new ENotificationImpl(this,ModifiedOclOptimizerNotifyLiterals.START_EVALUATION_VALUE, Notification.NO_FEATURE_ID, id, null));
		Object result = super.evaluate(queryobject);
		eNotify(new ENotificationImpl(this,ModifiedOclOptimizerNotifyLiterals.END_EVALUATION_VALUE, Notification.NO_FEATURE_ID, id, null));
		return result;
	}

} //ModifiedOclOptimizerImpl

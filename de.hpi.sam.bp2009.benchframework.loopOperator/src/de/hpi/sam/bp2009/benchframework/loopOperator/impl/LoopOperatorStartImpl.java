/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.loopOperator.impl;

import org.eclipse.emf.ecore.EClass;

import de.hpi.sam.bp2009.benchframework.BenchframeworkFactory;
import de.hpi.sam.bp2009.benchframework.EndOperator;
import de.hpi.sam.bp2009.benchframework.Status;
import de.hpi.sam.bp2009.benchframework.impl.StartOperatorImpl;
import de.hpi.sam.bp2009.benchframework.loopOperator.LoopOperatorFactory;
import de.hpi.sam.bp2009.benchframework.loopOperator.LoopOperatorPackage;
import de.hpi.sam.bp2009.benchframework.loopOperator.LoopOperatorStart;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Start</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class LoopOperatorStartImpl extends StartOperatorImpl implements LoopOperatorStart {
	private static final String NAME = "Loop Operator Startpoint";

	private static final String DESCRIPTION = "Defines the start of a loop.";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public LoopOperatorStartImpl() {
		super();
		setName(NAME);
		setDescription(DESCRIPTION);
		setOption(LoopOperatorFactory.eINSTANCE.createLoopOperatorOptionObject());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LoopOperatorPackage.Literals.LOOP_OPERATOR_START;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void execute() {
		//nothing to do here...
		setResult(BenchframeworkFactory.eINSTANCE.createResultObject());
		getResult().setStatus(Status.SUCCESSFUL);
	}

	@Override
	public EndOperator createEndOperator() {
		return LoopOperatorFactory.eINSTANCE.createLoopOperatorEnd();
	}

} //LoopOperatorStartImpl

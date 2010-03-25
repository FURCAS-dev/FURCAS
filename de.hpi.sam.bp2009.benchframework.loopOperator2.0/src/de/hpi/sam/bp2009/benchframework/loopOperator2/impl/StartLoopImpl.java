/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.loopOperator2.impl;

import de.hpi.sam.bp2009.benchframework.BenchframeworkFactory;
import de.hpi.sam.bp2009.benchframework.EndOperator;
import de.hpi.sam.bp2009.benchframework.Status;
import de.hpi.sam.bp2009.benchframework.impl.StartOperatorImpl;

import de.hpi.sam.bp2009.benchframework.loopOperator2.LoopOperator2Factory;
import de.hpi.sam.bp2009.benchframework.loopOperator2.LoopOperator2Package;
import de.hpi.sam.bp2009.benchframework.loopOperator2.StartLoop;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Start Loop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class StartLoopImpl extends StartOperatorImpl implements StartLoop {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartLoopImpl() {
		super();
		setName("Loop2.0");
		setDescription("Repeats all Operator between Start and End");
		setOption(LoopOperator2Factory.eINSTANCE.createLoopOption());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LoopOperator2Package.Literals.START_LOOP;
	}

	@Override
	public EndOperator createEndOperator() {
		return LoopOperator2Factory.eINSTANCE.createEndLoop();
	}

	@Override
	public void execute() {
		setResult(BenchframeworkFactory.eINSTANCE.createResultObject());
		getResult().setStatus(Status.SUCCESSFUL);
		getResult().setMessage("Signaled Loop Start at Position: " + getTestRun().getOperators().indexOf(this));
		
	}

} //StartLoopImpl

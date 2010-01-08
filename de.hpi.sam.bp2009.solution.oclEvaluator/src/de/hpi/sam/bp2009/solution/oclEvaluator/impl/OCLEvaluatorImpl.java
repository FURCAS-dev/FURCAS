/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.oclEvaluator.impl;

import java.util.ArrayList;

import de.hpi.sam.bp2009.solution.oclEvaluator.OCLEvaluator;
import de.hpi.sam.bp2009.solution.oclEvaluator.OclEvaluatorPackage;
import de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.query.ocl.conditions.AbstractOCLCondition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>OCL Evaluator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class OCLEvaluatorImpl extends EObjectImpl implements OCLEvaluator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OCLEvaluatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OclEvaluatorPackage.Literals.OCL_EVALUATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Object evaluate(AbstractOCLCondition queryobject, EObject context) {
		return queryobject.evaluate(context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public EList<Object> evaluate(EList<OclQuery> queries) {
		System.out.println("Eval Working");
		EList<Object> result= new BasicEList<Object>();
		for(OclQuery query: queries){
			result.add(this.evaluate(query.getCondition(), query.getContext()));
		}
		return result;
	}

} //OCLEvaluatorImpl

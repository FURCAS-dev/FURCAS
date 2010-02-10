/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.oclEvaluator.impl;

import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.Query;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.helper.OCLHelper;

import de.hpi.sam.bp2009.solution.oclEvaluator.Interpreter;
import de.hpi.sam.bp2009.solution.oclEvaluator.OCLEvaluator;
import de.hpi.sam.bp2009.solution.oclEvaluator.OclEvaluatorPackage;
import de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery;

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
	 * @generated NOT
	 */
	public Object evaluate(OclQuery queryobject) {

		return passToInterpreter(Interpreter.OCL, queryobject);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Object> evaluate(EList<OclQuery> queries) {
		System.out.println("Eval Working");
		EList<Object> result= new BasicEList<Object>();
		for(OclQuery query: queries){
			query.setResult(this.evaluate(query));
			result.add(query.getResult());
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object passToInterpreter(Interpreter interpreter, OclQuery queryobject) {
		if(interpreter==Interpreter.OCL){
			// create an OCL instance for Ecore
			OCL<?, EClassifier, ?, ?, ?, ?, ?, ?, ?, Constraint, EClass, EObject> ocl;
			ocl = OCL.newInstance(EcoreEnvironmentFactory.INSTANCE);

			// create an OCL helper object
			OCLHelper<EClassifier, ?, ?, Constraint> helper = ocl.createOCLHelper();
//TODO check cast from list to set
			ocl.setExtentMap((Map<EClass, ? extends Set<? extends EObject>>) queryobject.getExtentMap());
			// use the query expression parsed before to create a Query
			Query<EClassifier, EClass, EObject> eval = ocl.createQuery(queryobject.getExpression());
			if(queryobject.getContext()==null)
				return eval.evaluate();
			else
				return eval.evaluate(queryobject.getContext());

		}
		return true;
	}

} //OCLEvaluatorImpl

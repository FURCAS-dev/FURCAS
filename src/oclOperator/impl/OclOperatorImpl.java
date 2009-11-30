/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package oclOperator.impl;

import de.hpi.sam.bp2009.benchframework.impl.OperatorImpl;

import oclOperator.OclOperator;
import oclOperator.OclOperatorPackage;
import oclOperator.OclOptionObject;
import oclOperator.OclUtil;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ocl Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class OclOperatorImpl extends OperatorImpl implements OclOperator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OclOperatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OclOperatorPackage.Literals.OCL_OPERATOR;
	}

	public void execute(Resource resource, Object option) {
		if (option instanceof OclOptionObject){
			executeQueries(resource, (OclOptionObject) option);
		}
	}
	
	public void executeQueries(Resource resource, OclOptionObject option) {
		for(String con: option.oclConstraints){
			OclUtil ocl = new OclUtilImpl();
			ocl.executeQueryOn(con, resource);
		}
		
	}

} //OclOperatorImpl

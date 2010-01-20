/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.oclOperator.impl;

import de.hpi.sam.bp2009.benchframework.OptionObject;
import de.hpi.sam.bp2009.benchframework.impl.OperatorImpl;

import de.hpi.sam.bp2009.benchframework.oclOperator.OclOperator;
import de.hpi.sam.bp2009.benchframework.oclOperator.OclOperatorPackage;
import de.hpi.sam.bp2009.benchframework.oclOperator.OclOptionObject;
import de.hpi.sam.bp2009.benchframework.oclOperator.OclUtil;

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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 */
	
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

	@Override
	public void execute(Resource resource, OptionObject options) {
		// TODO Auto-generated method stub
		
	}

} //OclOperatorImpl

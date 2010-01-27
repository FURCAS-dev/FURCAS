/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.oclOperator.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.ResourceSet;

import de.hpi.sam.bp2009.benchframework.impl.OperatorImpl;
import de.hpi.sam.bp2009.benchframework.oclOperator.OclOperator;
import de.hpi.sam.bp2009.benchframework.oclOperator.OclOperatorFactory;
import de.hpi.sam.bp2009.benchframework.oclOperator.OclOperatorPackage;
import de.hpi.sam.bp2009.benchframework.oclOperator.OclOptionObject;
import de.hpi.sam.bp2009.benchframework.oclOperator.OclUtil;

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
	 * @generated NOT
	 */
	public OclOperatorImpl() {
		super();
		setOption(OclOperatorFactory.eINSTANCE.createOclOptionObject());
		this.setName("OCLOperator");
		this.setDescription("Evaluates a specific ocl expression");
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
	
	public void execute() {
		if (option instanceof OclOptionObject){
			executeQueries(this.getTestRun().getModel(), (OclOptionObject) option);
		}
	}
	
	public void executeQueries(ResourceSet resource, OclOptionObject option) {
		for(String con: option.getConstraints()){
			OclUtil ocl = OclOperatorFactory.eINSTANCE.createOclUtil();
			ocl.executeQueryOn(con, resource);
		}
		
	}

} //OclOperatorImpl

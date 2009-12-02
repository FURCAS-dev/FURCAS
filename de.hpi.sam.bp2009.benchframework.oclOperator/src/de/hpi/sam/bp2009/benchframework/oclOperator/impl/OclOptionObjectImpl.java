/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.oclOperator.impl;

import org.eclipse.emf.ecore.EClass;

import de.hpi.sam.bp2009.benchframework.impl.OptionObjectImpl;
import de.hpi.sam.bp2009.benchframework.oclOperator.OclOperatorPackage;
import de.hpi.sam.bp2009.benchframework.oclOperator.OclOptionObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ocl Option Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class OclOptionObjectImpl extends OptionObjectImpl implements OclOptionObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 */
	public OclOptionObjectImpl() {
		
	}

	public static OptionObjectImpl defaultValue(){
		OclOptionObjectImpl def = new OclOptionObjectImpl();
		//TODO weiterreichen der Eingabe der Constraints an die Gui
		OclOptionObject.oclConstraints.add("context Class0: self.attribute0 < 10");
		return def;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OclOperatorPackage.Literals.OCL_OPTION_OBJECT;
	}

} //OclOptionObjectImpl

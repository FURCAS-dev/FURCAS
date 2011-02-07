/**
 * <copyright>
 * </copyright>
 *
 * $Id: DummyImpl.java,v 1.1 2011/02/07 16:47:39 auhl Exp $
 */
package behavioral.rules.impl;

import behavioral.rules.Dummy;
import behavioral.rules.RulesPackage;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dummy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class DummyImpl extends EObjectImpl implements Dummy {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected DummyImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return RulesPackage.Literals.DUMMY;
    }

} //DummyImpl

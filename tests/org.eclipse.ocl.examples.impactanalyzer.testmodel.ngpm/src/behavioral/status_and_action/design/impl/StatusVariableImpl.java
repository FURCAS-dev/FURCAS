/**
 * <copyright>
 * </copyright>
 *
 * $Id: StatusVariableImpl.java,v 1.1 2011/02/07 17:17:57 auhl Exp $
 */
package behavioral.status_and_action.design.impl;

import behavioral.status_and_action.design.DesignPackage;
import behavioral.status_and_action.design.StatusVariable;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Status Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class StatusVariableImpl extends AbstractStatusVariableImpl implements StatusVariable {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected StatusVariableImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return DesignPackage.Literals.STATUS_VARIABLE;
    }

} //StatusVariableImpl

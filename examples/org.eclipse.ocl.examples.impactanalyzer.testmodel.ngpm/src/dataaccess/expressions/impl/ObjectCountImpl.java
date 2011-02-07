/**
 * <copyright>
 * </copyright>
 *
 * $Id: ObjectCountImpl.java,v 1.1 2011/02/07 16:53:51 auhl Exp $
 */
package dataaccess.expressions.impl;

import dataaccess.expressions.ExpressionsPackage;
import dataaccess.expressions.ObjectCount;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Count</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ObjectCountImpl extends ObjectBasedExpressionImpl implements ObjectCount {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ObjectCountImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExpressionsPackage.Literals.OBJECT_COUNT;
    }

} //ObjectCountImpl

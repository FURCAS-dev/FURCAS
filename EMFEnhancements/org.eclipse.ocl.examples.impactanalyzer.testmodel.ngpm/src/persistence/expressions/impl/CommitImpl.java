/**
 * <copyright>
 * </copyright>
 *
 * $Id: CommitImpl.java,v 1.2 2011/03/05 21:52:05 auhl Exp $
 */
package persistence.expressions.impl;

import dataaccess.expressions.impl.ExpressionImpl;

import org.eclipse.emf.ecore.EClass;

import persistence.expressions.Commit;
import persistence.expressions.ExpressionsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Commit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class CommitImpl extends ExpressionImpl implements Commit {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CommitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.COMMIT;
	}

} //CommitImpl

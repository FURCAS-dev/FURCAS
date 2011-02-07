/**
 * <copyright>
 * </copyright>
 *
 * $Id: AnonymousFunctionExprImpl.java,v 1.1 2011/02/07 16:53:51 auhl Exp $
 */
package dataaccess.expressions.fp.impl;

import data.classes.FunctionSignatureImplementation;

import dataaccess.expressions.fp.AnonymousFunctionExpr;
import dataaccess.expressions.fp.FpPackage;

import dataaccess.expressions.impl.ExpressionImpl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Anonymous Function Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class AnonymousFunctionExprImpl extends ExpressionImpl implements AnonymousFunctionExpr {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected AnonymousFunctionExprImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return FpPackage.Literals.ANONYMOUS_FUNCTION_EXPR;
    }

	/**
     * The cached invocation delegate for the '{@link #getImplementation() <em>Get Implementation</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getImplementation()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate GET_IMPLEMENTATION__EINVOCATION_DELEGATE = ((EOperation.Internal)FpPackage.Literals.ANONYMOUS_FUNCTION_EXPR.getEOperations().get(0)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public FunctionSignatureImplementation getImplementation() {
        try {
            return (FunctionSignatureImplementation)GET_IMPLEMENTATION__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

} //AnonymousFunctionExprImpl

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.expressions.fp.impl;

import dataaccess.expressions.fp.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FpFactoryImpl extends EFactoryImpl implements FpFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static FpFactory init() {
        try {
            FpFactory theFpFactory = (FpFactory)EPackage.Registry.INSTANCE.getEFactory("http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/dataaccess/expressions/fp.ecore"); 
            if (theFpFactory != null) {
                return theFpFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new FpFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public FpFactoryImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case FpPackage.ANONYMOUS_FUNCTION_EXPR: return createAnonymousFunctionExpr();
            case FpPackage.FUNCTION_FROM_METHOD_EXPR: return createFunctionFromMethodExpr();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AnonymousFunctionExpr createAnonymousFunctionExpr() {
        AnonymousFunctionExprImpl anonymousFunctionExpr = new AnonymousFunctionExprImpl();
        return anonymousFunctionExpr;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public FunctionFromMethodExpr createFunctionFromMethodExpr() {
        FunctionFromMethodExprImpl functionFromMethodExpr = new FunctionFromMethodExprImpl();
        return functionFromMethodExpr;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public FpPackage getFpPackage() {
        return (FpPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static FpPackage getPackage() {
        return FpPackage.eINSTANCE;
    }

} //FpFactoryImpl

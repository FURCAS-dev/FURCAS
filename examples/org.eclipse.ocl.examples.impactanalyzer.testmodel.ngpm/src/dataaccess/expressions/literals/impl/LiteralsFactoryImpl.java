/**
 * <copyright>
 * </copyright>
 *
 * $Id: LiteralsFactoryImpl.java,v 1.1 2011/02/07 16:53:51 auhl Exp $
 */
package dataaccess.expressions.literals.impl;

import dataaccess.expressions.literals.*;

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
public class LiteralsFactoryImpl extends EFactoryImpl implements LiteralsFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static LiteralsFactory init() {
        try {
            LiteralsFactory theLiteralsFactory = (LiteralsFactory)EPackage.Registry.INSTANCE.getEFactory("http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/dataaccess/expressions/literals.ecore"); 
            if (theLiteralsFactory != null) {
                return theLiteralsFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new LiteralsFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public LiteralsFactoryImpl() {
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
            case LiteralsPackage.LITERAL: return createLiteral();
            case LiteralsPackage.BINARY_LITERAL: return createBinaryLiteral();
            case LiteralsPackage.STRING_LITERAL: return createStringLiteral();
            case LiteralsPackage.NUMBER_LITERAL: return createNumberLiteral();
            case LiteralsPackage.TIME_POINT_LITERAL: return createTimePointLiteral();
            case LiteralsPackage.BOOLEAN_LITERAL: return createBooleanLiteral();
            case LiteralsPackage.OBJECT_LITERAL: return createObjectLiteral();
            case LiteralsPackage.VALUE_INIT: return createValueInit();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Literal createLiteral() {
        LiteralImpl literal = new LiteralImpl();
        return literal;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public BinaryLiteral createBinaryLiteral() {
        BinaryLiteralImpl binaryLiteral = new BinaryLiteralImpl();
        return binaryLiteral;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public StringLiteral createStringLiteral() {
        StringLiteralImpl stringLiteral = new StringLiteralImpl();
        return stringLiteral;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NumberLiteral createNumberLiteral() {
        NumberLiteralImpl numberLiteral = new NumberLiteralImpl();
        return numberLiteral;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TimePointLiteral createTimePointLiteral() {
        TimePointLiteralImpl timePointLiteral = new TimePointLiteralImpl();
        return timePointLiteral;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public BooleanLiteral createBooleanLiteral() {
        BooleanLiteralImpl booleanLiteral = new BooleanLiteralImpl();
        return booleanLiteral;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ObjectLiteral createObjectLiteral() {
        ObjectLiteralImpl objectLiteral = new ObjectLiteralImpl();
        return objectLiteral;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ValueInit createValueInit() {
        ValueInitImpl valueInit = new ValueInitImpl();
        return valueInit;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public LiteralsPackage getLiteralsPackage() {
        return (LiteralsPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static LiteralsPackage getPackage() {
        return LiteralsPackage.eINSTANCE;
    }

} //LiteralsFactoryImpl

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.expressions.impl;

import dataaccess.expressions.*;

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
public class ExpressionsFactoryImpl extends EFactoryImpl implements ExpressionsFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static ExpressionsFactory init() {
        try {
            ExpressionsFactory theExpressionsFactory = (ExpressionsFactory)EPackage.Registry.INSTANCE.getEFactory("http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/dataaccess/expressions.ecore"); 
            if (theExpressionsFactory != null) {
                return theExpressionsFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new ExpressionsFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ExpressionsFactoryImpl() {
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
            case ExpressionsPackage.VARIABLE_EXPRESSION: return createVariableExpression();
            case ExpressionsPackage.METHOD_CALL_EXPRESSION: return createMethodCallExpression();
            case ExpressionsPackage.OBJECT_CREATION_EXPRESSION: return createObjectCreationExpression();
            case ExpressionsPackage.FUNCTION_CALL_EXPRESSION: return createFunctionCallExpression();
            case ExpressionsPackage.THIS: return createThis();
            case ExpressionsPackage.EQUALS: return createEquals();
            case ExpressionsPackage.ASSOCIATION_END_NAVIGATION_EXPRESSION: return createAssociationEndNavigationExpression();
            case ExpressionsPackage.OBJECT_COUNT: return createObjectCount();
            case ExpressionsPackage.REPLACE: return createReplace();
            case ExpressionsPackage.NAVIGATION_STEP: return createNavigationStep();
            case ExpressionsPackage.HEAD: return createHead();
            case ExpressionsPackage.TAIL: return createTail();
            case ExpressionsPackage.AS_LIST: return createAsList();
            case ExpressionsPackage.TERNARY: return createTernary();
            case ExpressionsPackage.CONTENT_EQUALS: return createContentEquals();
            case ExpressionsPackage.MAP: return createMap();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public VariableExpression createVariableExpression() {
        VariableExpressionImpl variableExpression = new VariableExpressionImpl();
        return variableExpression;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public MethodCallExpression createMethodCallExpression() {
        MethodCallExpressionImpl methodCallExpression = new MethodCallExpressionImpl();
        return methodCallExpression;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ObjectCreationExpression createObjectCreationExpression() {
        ObjectCreationExpressionImpl objectCreationExpression = new ObjectCreationExpressionImpl();
        return objectCreationExpression;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public FunctionCallExpression createFunctionCallExpression() {
        FunctionCallExpressionImpl functionCallExpression = new FunctionCallExpressionImpl();
        return functionCallExpression;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public This createThis() {
        ThisImpl this_ = new ThisImpl();
        return this_;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Equals createEquals() {
        EqualsImpl equals = new EqualsImpl();
        return equals;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AssociationEndNavigationExpression createAssociationEndNavigationExpression() {
        AssociationEndNavigationExpressionImpl associationEndNavigationExpression = new AssociationEndNavigationExpressionImpl();
        return associationEndNavigationExpression;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ObjectCount createObjectCount() {
        ObjectCountImpl objectCount = new ObjectCountImpl();
        return objectCount;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Replace createReplace() {
        ReplaceImpl replace = new ReplaceImpl();
        return replace;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NavigationStep createNavigationStep() {
        NavigationStepImpl navigationStep = new NavigationStepImpl();
        return navigationStep;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Head createHead() {
        HeadImpl head = new HeadImpl();
        return head;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Tail createTail() {
        TailImpl tail = new TailImpl();
        return tail;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AsList createAsList() {
        AsListImpl asList = new AsListImpl();
        return asList;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Ternary createTernary() {
        TernaryImpl ternary = new TernaryImpl();
        return ternary;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ContentEquals createContentEquals() {
        ContentEqualsImpl contentEquals = new ContentEqualsImpl();
        return contentEquals;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Map createMap() {
        MapImpl map = new MapImpl();
        return map;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ExpressionsPackage getExpressionsPackage() {
        return (ExpressionsPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static ExpressionsPackage getPackage() {
        return ExpressionsPackage.eINSTANCE;
    }

} //ExpressionsFactoryImpl

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.emf.ocl.oclwithhiddenopposites.expressions.util;

import com.sap.emf.ocl.oclwithhiddenopposites.expressions.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.ETypedElement;

import org.eclipse.ocl.expressions.CallExp;
import org.eclipse.ocl.expressions.FeatureCallExp;
import org.eclipse.ocl.expressions.NavigationCallExp;
import org.eclipse.ocl.expressions.OCLExpression;

import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.ocl.utilities.CallingASTNode;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.Visitable;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.sap.emf.ocl.oclwithhiddenopposites.expressions.ExpressionsPackage
 * @generated
 */
public class ExpressionsAdapterFactory extends AdapterFactoryImpl {
	/**
         * The cached model package.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	protected static ExpressionsPackage modelPackage;

	/**
         * Creates an instance of the adapter factory.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public ExpressionsAdapterFactory() {
                if (modelPackage == null) {
                        modelPackage = ExpressionsPackage.eINSTANCE;
                }
        }

	/**
         * Returns whether this factory is applicable for the type of the object.
         * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
         * @return whether this factory is applicable for the type of the object.
         * @generated
         */
	@Override
	public boolean isFactoryForType(Object object) {
                if (object == modelPackage) {
                        return true;
                }
                if (object instanceof EObject) {
                        return ((EObject)object).eClass().getEPackage() == modelPackage;
                }
                return false;
        }

	/**
         * The switch that delegates to the <code>createXXX</code> methods.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	protected ExpressionsSwitch<Adapter> modelSwitch =
		new ExpressionsSwitch<Adapter>() {
                        @Override
                        public Adapter caseOppositePropertyCallExp(OppositePropertyCallExp object) {
                                return createOppositePropertyCallExpAdapter();
                        }
                        @Override
                        public Adapter caseEModelElement(EModelElement object) {
                                return createEModelElementAdapter();
                        }
                        @Override
                        public Adapter caseENamedElement(ENamedElement object) {
                                return createENamedElementAdapter();
                        }
                        @Override
                        public Adapter caseETypedElement(ETypedElement object) {
                                return createETypedElementAdapter();
                        }
                        @Override
                        public <C> Adapter caseTypedElement(TypedElement<C> object) {
                                return createTypedElementAdapter();
                        }
                        @Override
                        public Adapter caseVisitable(Visitable object) {
                                return createVisitableAdapter();
                        }
                        @Override
                        public Adapter caseASTNode(ASTNode object) {
                                return createASTNodeAdapter();
                        }
                        @Override
                        public <C> Adapter caseOCLExpression(OCLExpression<C> object) {
                                return createOCLExpressionAdapter();
                        }
                        @Override
                        public Adapter caseEcore_OCLExpression(org.eclipse.ocl.ecore.OCLExpression object) {
                                return createEcore_OCLExpressionAdapter();
                        }
                        @Override
                        public Adapter caseCallingASTNode(CallingASTNode object) {
                                return createCallingASTNodeAdapter();
                        }
                        @Override
                        public <C> Adapter caseCallExp(CallExp<C> object) {
                                return createCallExpAdapter();
                        }
                        @Override
                        public Adapter caseEcore_CallExp(org.eclipse.ocl.ecore.CallExp object) {
                                return createEcore_CallExpAdapter();
                        }
                        @Override
                        public <C> Adapter caseFeatureCallExp(FeatureCallExp<C> object) {
                                return createFeatureCallExpAdapter();
                        }
                        @Override
                        public Adapter caseEcore_FeatureCallExp(org.eclipse.ocl.ecore.FeatureCallExp object) {
                                return createEcore_FeatureCallExpAdapter();
                        }
                        @Override
                        public <C, P> Adapter caseNavigationCallExp(NavigationCallExp<C, P> object) {
                                return createNavigationCallExpAdapter();
                        }
                        @Override
                        public Adapter caseEcore_NavigationCallExp(org.eclipse.ocl.ecore.NavigationCallExp object) {
                                return createEcore_NavigationCallExpAdapter();
                        }
                        @Override
                        public Adapter defaultCase(EObject object) {
                                return createEObjectAdapter();
                        }
                };

	/**
         * Creates an adapter for the <code>target</code>.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @param target the object to adapt.
         * @return the adapter for the <code>target</code>.
         * @generated
         */
	@Override
	public Adapter createAdapter(Notifier target) {
                return modelSwitch.doSwitch((EObject)target);
        }


	/**
         * Creates a new adapter for an object of class '{@link com.sap.emf.ocl.oclwithhiddenopposites.expressions.OppositePropertyCallExp <em>Opposite Property Call Exp</em>}'.
         * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
         * @return the new adapter.
         * @see com.sap.emf.ocl.oclwithhiddenopposites.expressions.OppositePropertyCallExp
         * @generated
         */
	public Adapter createOppositePropertyCallExpAdapter() {
                return null;
        }

	/**
         * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecore.EModelElement <em>EModel Element</em>}'.
         * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
         * @return the new adapter.
         * @see org.eclipse.emf.ecore.EModelElement
         * @generated
         */
	public Adapter createEModelElementAdapter() {
                return null;
        }

	/**
         * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecore.ENamedElement <em>ENamed Element</em>}'.
         * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
         * @return the new adapter.
         * @see org.eclipse.emf.ecore.ENamedElement
         * @generated
         */
	public Adapter createENamedElementAdapter() {
                return null;
        }

	/**
         * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecore.ETypedElement <em>ETyped Element</em>}'.
         * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
         * @return the new adapter.
         * @see org.eclipse.emf.ecore.ETypedElement
         * @generated
         */
	public Adapter createETypedElementAdapter() {
                return null;
        }

	/**
         * Creates a new adapter for an object of class '{@link org.eclipse.ocl.utilities.TypedElement <em>Typed Element</em>}'.
         * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
         * @return the new adapter.
         * @see org.eclipse.ocl.utilities.TypedElement
         * @generated
         */
	public Adapter createTypedElementAdapter() {
                return null;
        }

	/**
         * Creates a new adapter for an object of class '{@link org.eclipse.ocl.utilities.Visitable <em>Visitable</em>}'.
         * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
         * @return the new adapter.
         * @see org.eclipse.ocl.utilities.Visitable
         * @generated
         */
	public Adapter createVisitableAdapter() {
                return null;
        }

	/**
         * Creates a new adapter for an object of class '{@link org.eclipse.ocl.utilities.ASTNode <em>AST Node</em>}'.
         * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
         * @return the new adapter.
         * @see org.eclipse.ocl.utilities.ASTNode
         * @generated
         */
	public Adapter createASTNodeAdapter() {
                return null;
        }

	/**
         * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.OCLExpression <em>OCL Expression</em>}'.
         * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
         * @return the new adapter.
         * @see org.eclipse.ocl.expressions.OCLExpression
         * @generated
         */
	public Adapter createOCLExpressionAdapter() {
                return null;
        }

	/**
         * Creates a new adapter for an object of class '{@link org.eclipse.ocl.ecore.OCLExpression <em>OCL Expression</em>}'.
         * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
         * @return the new adapter.
         * @see org.eclipse.ocl.ecore.OCLExpression
         * @generated
         */
	public Adapter createEcore_OCLExpressionAdapter() {
                return null;
        }

	/**
         * Creates a new adapter for an object of class '{@link org.eclipse.ocl.utilities.CallingASTNode <em>Calling AST Node</em>}'.
         * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
         * @return the new adapter.
         * @see org.eclipse.ocl.utilities.CallingASTNode
         * @generated
         */
	public Adapter createCallingASTNodeAdapter() {
                return null;
        }

	/**
         * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.CallExp <em>Call Exp</em>}'.
         * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
         * @return the new adapter.
         * @see org.eclipse.ocl.expressions.CallExp
         * @generated
         */
	public Adapter createCallExpAdapter() {
                return null;
        }

	/**
         * Creates a new adapter for an object of class '{@link org.eclipse.ocl.ecore.CallExp <em>Call Exp</em>}'.
         * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
         * @return the new adapter.
         * @see org.eclipse.ocl.ecore.CallExp
         * @generated
         */
	public Adapter createEcore_CallExpAdapter() {
                return null;
        }

	/**
         * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.FeatureCallExp <em>Feature Call Exp</em>}'.
         * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
         * @return the new adapter.
         * @see org.eclipse.ocl.expressions.FeatureCallExp
         * @generated
         */
	public Adapter createFeatureCallExpAdapter() {
                return null;
        }

	/**
         * Creates a new adapter for an object of class '{@link org.eclipse.ocl.ecore.FeatureCallExp <em>Feature Call Exp</em>}'.
         * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
         * @return the new adapter.
         * @see org.eclipse.ocl.ecore.FeatureCallExp
         * @generated
         */
	public Adapter createEcore_FeatureCallExpAdapter() {
                return null;
        }

	/**
         * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.NavigationCallExp <em>Navigation Call Exp</em>}'.
         * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
         * @return the new adapter.
         * @see org.eclipse.ocl.expressions.NavigationCallExp
         * @generated
         */
	public Adapter createNavigationCallExpAdapter() {
                return null;
        }

	/**
         * Creates a new adapter for an object of class '{@link org.eclipse.ocl.ecore.NavigationCallExp <em>Navigation Call Exp</em>}'.
         * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
         * @return the new adapter.
         * @see org.eclipse.ocl.ecore.NavigationCallExp
         * @generated
         */
	public Adapter createEcore_NavigationCallExpAdapter() {
                return null;
        }

	/**
         * Creates a new adapter for the default case.
         * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
         * @return the new adapter.
         * @generated
         */
	public Adapter createEObjectAdapter() {
                return null;
        }

} //ExpressionsAdapterFactory

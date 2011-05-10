/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.oclinversion.util;

import com.sap.furcas.oclinversion.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.ETypedElement;

import org.eclipse.ocl.expressions.BooleanLiteralExp;
import org.eclipse.ocl.expressions.EnumLiteralExp;
import org.eclipse.ocl.expressions.IntegerLiteralExp;
import org.eclipse.ocl.expressions.LiteralExp;
import org.eclipse.ocl.expressions.NumericLiteralExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.PrimitiveLiteralExp;
import org.eclipse.ocl.expressions.RealLiteralExp;
import org.eclipse.ocl.expressions.StringLiteralExp;

import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.Visitable;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.sap.furcas.oclinversion.OclinversionPackage
 * @generated
 */
public class OclinversionAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static OclinversionPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OclinversionAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = OclinversionPackage.eINSTANCE;
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
    protected OclinversionSwitch<Adapter> modelSwitch =
        new OclinversionSwitch<Adapter>() {
            @Override
            public Adapter caseQMarkLiteralExp(QMarkLiteralExp object) {
                return createQMarkLiteralExpAdapter();
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
            public <C> Adapter caseLiteralExp(LiteralExp<C> object) {
                return createLiteralExpAdapter();
            }
            @Override
            public Adapter caseEcore_LiteralExp(org.eclipse.ocl.ecore.LiteralExp object) {
                return createEcore_LiteralExpAdapter();
            }
            @Override
            public <C> Adapter casePrimitiveLiteralExp(PrimitiveLiteralExp<C> object) {
                return createPrimitiveLiteralExpAdapter();
            }
            @Override
            public Adapter caseEcore_PrimitiveLiteralExp(org.eclipse.ocl.ecore.PrimitiveLiteralExp object) {
                return createEcore_PrimitiveLiteralExpAdapter();
            }
            @Override
            public <C> Adapter caseBooleanLiteralExp(BooleanLiteralExp<C> object) {
                return createBooleanLiteralExpAdapter();
            }
            @Override
            public Adapter caseEcore_BooleanLiteralExp(org.eclipse.ocl.ecore.BooleanLiteralExp object) {
                return createEcore_BooleanLiteralExpAdapter();
            }
            @Override
            public <C, EL> Adapter caseEnumLiteralExp(EnumLiteralExp<C, EL> object) {
                return createEnumLiteralExpAdapter();
            }
            @Override
            public Adapter caseEcore_EnumLiteralExp(org.eclipse.ocl.ecore.EnumLiteralExp object) {
                return createEcore_EnumLiteralExpAdapter();
            }
            @Override
            public <C> Adapter caseNumericLiteralExp(NumericLiteralExp<C> object) {
                return createNumericLiteralExpAdapter();
            }
            @Override
            public Adapter caseEcore_NumericLiteralExp(org.eclipse.ocl.ecore.NumericLiteralExp object) {
                return createEcore_NumericLiteralExpAdapter();
            }
            @Override
            public <C> Adapter caseIntegerLiteralExp(IntegerLiteralExp<C> object) {
                return createIntegerLiteralExpAdapter();
            }
            @Override
            public Adapter caseEcore_IntegerLiteralExp(org.eclipse.ocl.ecore.IntegerLiteralExp object) {
                return createEcore_IntegerLiteralExpAdapter();
            }
            @Override
            public <C> Adapter caseRealLiteralExp(RealLiteralExp<C> object) {
                return createRealLiteralExpAdapter();
            }
            @Override
            public Adapter caseEcore_RealLiteralExp(org.eclipse.ocl.ecore.RealLiteralExp object) {
                return createEcore_RealLiteralExpAdapter();
            }
            @Override
            public <C> Adapter caseStringLiteralExp(StringLiteralExp<C> object) {
                return createStringLiteralExpAdapter();
            }
            @Override
            public Adapter caseEcore_StringLiteralExp(org.eclipse.ocl.ecore.StringLiteralExp object) {
                return createEcore_StringLiteralExpAdapter();
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
     * Creates a new adapter for an object of class '{@link com.sap.furcas.oclinversion.QMarkLiteralExp <em>QMark Literal Exp</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.sap.furcas.oclinversion.QMarkLiteralExp
     * @generated
     */
    public Adapter createQMarkLiteralExpAdapter() {
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
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.LiteralExp <em>Literal Exp</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.LiteralExp
     * @generated
     */
    public Adapter createLiteralExpAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.ecore.LiteralExp <em>Literal Exp</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.ecore.LiteralExp
     * @generated
     */
    public Adapter createEcore_LiteralExpAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.PrimitiveLiteralExp <em>Primitive Literal Exp</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.PrimitiveLiteralExp
     * @generated
     */
    public Adapter createPrimitiveLiteralExpAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.ecore.PrimitiveLiteralExp <em>Primitive Literal Exp</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.ecore.PrimitiveLiteralExp
     * @generated
     */
    public Adapter createEcore_PrimitiveLiteralExpAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.BooleanLiteralExp <em>Boolean Literal Exp</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.BooleanLiteralExp
     * @generated
     */
    public Adapter createBooleanLiteralExpAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.ecore.BooleanLiteralExp <em>Boolean Literal Exp</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.ecore.BooleanLiteralExp
     * @generated
     */
    public Adapter createEcore_BooleanLiteralExpAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.EnumLiteralExp <em>Enum Literal Exp</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.EnumLiteralExp
     * @generated
     */
    public Adapter createEnumLiteralExpAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.ecore.EnumLiteralExp <em>Enum Literal Exp</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.ecore.EnumLiteralExp
     * @generated
     */
    public Adapter createEcore_EnumLiteralExpAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.NumericLiteralExp <em>Numeric Literal Exp</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.NumericLiteralExp
     * @generated
     */
    public Adapter createNumericLiteralExpAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.ecore.NumericLiteralExp <em>Numeric Literal Exp</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.ecore.NumericLiteralExp
     * @generated
     */
    public Adapter createEcore_NumericLiteralExpAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.IntegerLiteralExp <em>Integer Literal Exp</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.IntegerLiteralExp
     * @generated
     */
    public Adapter createIntegerLiteralExpAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.ecore.IntegerLiteralExp <em>Integer Literal Exp</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.ecore.IntegerLiteralExp
     * @generated
     */
    public Adapter createEcore_IntegerLiteralExpAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.RealLiteralExp <em>Real Literal Exp</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.RealLiteralExp
     * @generated
     */
    public Adapter createRealLiteralExpAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.ecore.RealLiteralExp <em>Real Literal Exp</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.ecore.RealLiteralExp
     * @generated
     */
    public Adapter createEcore_RealLiteralExpAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.expressions.StringLiteralExp <em>String Literal Exp</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.expressions.StringLiteralExp
     * @generated
     */
    public Adapter createStringLiteralExpAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.ecore.StringLiteralExp <em>String Literal Exp</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.ecore.StringLiteralExp
     * @generated
     */
    public Adapter createEcore_StringLiteralExpAdapter() {
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

} //OclinversionAdapterFactory

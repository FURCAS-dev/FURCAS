/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   IBM - Initial API and implementation
 * 
 * </copyright>
 *
 * $Id: UMLAdapterFactory.java,v 1.2 2007/02/14 13:42:07 cdamus Exp $
 */
package org.eclipse.ocl.uml.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.ocl.uml.*;

import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.ocl.utilities.TypedASTNode;
import org.eclipse.ocl.utilities.Visitable;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.ParameterableElement;
import org.eclipse.uml2.uml.RedefinableElement;
import org.eclipse.uml2.uml.TemplateableElement;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.TypedElement;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.uml.UMLPackage
 * @generated
 */
public class UMLAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static UMLPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UMLAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = UMLPackage.eINSTANCE;
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
     * The switch the delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected UMLSwitch<Adapter> modelSwitch =
        new UMLSwitch<Adapter>() {
            @Override
            public Adapter caseAnyType(AnyType object) {
                return createAnyTypeAdapter();
            }
            @Override
            public Adapter caseVoidType(VoidType object) {
                return createVoidTypeAdapter();
            }
            @Override
            public Adapter caseInvalidType(InvalidType object) {
                return createInvalidTypeAdapter();
            }
            @Override
            public Adapter caseElementType(ElementType object) {
                return createElementTypeAdapter();
            }
            @Override
            public Adapter caseTypeType(TypeType object) {
                return createTypeTypeAdapter();
            }
            @Override
            public Adapter caseMessageType(MessageType object) {
                return createMessageTypeAdapter();
            }
            @Override
            public Adapter casePrimitiveType(PrimitiveType object) {
                return createPrimitiveTypeAdapter();
            }
            @Override
            public Adapter caseCollectionType(CollectionType object) {
                return createCollectionTypeAdapter();
            }
            @Override
            public Adapter caseTupleType(TupleType object) {
                return createTupleTypeAdapter();
            }
            @Override
            public Adapter caseBagType(BagType object) {
                return createBagTypeAdapter();
            }
            @Override
            public Adapter caseSetType(SetType object) {
                return createSetTypeAdapter();
            }
            @Override
            public Adapter caseOrderedSetType(OrderedSetType object) {
                return createOrderedSetTypeAdapter();
            }
            @Override
            public Adapter caseSequenceType(SequenceType object) {
                return createSequenceTypeAdapter();
            }
            @Override
            public Adapter caseExpressionInOCL(ExpressionInOCL object) {
                return createExpressionInOCLAdapter();
            }
            @Override
            public Adapter caseEModelElement(EModelElement object) {
                return createEModelElementAdapter();
            }
            @Override
            public Adapter caseElement(Element object) {
                return createElementAdapter();
            }
            @Override
            public Adapter caseNamedElement(NamedElement object) {
                return createNamedElementAdapter();
            }
            @Override
            public Adapter caseNamespace(Namespace object) {
                return createNamespaceAdapter();
            }
            @Override
            public Adapter caseRedefinableElement(RedefinableElement object) {
                return createRedefinableElementAdapter();
            }
            @Override
            public Adapter caseParameterableElement(ParameterableElement object) {
                return createParameterableElementAdapter();
            }
            @Override
            public Adapter casePackageableElement(PackageableElement object) {
                return createPackageableElementAdapter();
            }
            @Override
            public Adapter caseType(Type object) {
                return createTypeAdapter();
            }
            @Override
            public Adapter caseTemplateableElement(TemplateableElement object) {
                return createTemplateableElementAdapter();
            }
            @Override
            public Adapter caseClassifier(Classifier object) {
                return createClassifierAdapter();
            }
            @Override
            public <O> Adapter casePredefinedType(PredefinedType<O> object) {
                return createPredefinedTypeAdapter();
            }
            @Override
            public <O> Adapter caseAnyType_1(org.eclipse.ocl.types.AnyType<O> object) {
                return createAnyType_1Adapter();
            }
            @Override
            public <O> Adapter caseVoidType_1(org.eclipse.ocl.types.VoidType<O> object) {
                return createVoidType_1Adapter();
            }
            @Override
            public <O> Adapter caseInvalidType_1(org.eclipse.ocl.types.InvalidType<O> object) {
                return createInvalidType_1Adapter();
            }
            @Override
            public Adapter caseElementType_1(org.eclipse.ocl.types.ElementType object) {
                return createElementType_1Adapter();
            }
            @Override
            public <C, O> Adapter caseTypeType_1(org.eclipse.ocl.types.TypeType<C, O> object) {
                return createTypeType_1Adapter();
            }
            @Override
            public <C, O, P> Adapter caseMessageType_1(org.eclipse.ocl.types.MessageType<C, O, P> object) {
                return createMessageType_1Adapter();
            }
            @Override
            public Adapter caseDataType(DataType object) {
                return createDataTypeAdapter();
            }
            @Override
            public Adapter casePrimitiveType_1(org.eclipse.uml2.uml.PrimitiveType object) {
                return createPrimitiveType_1Adapter();
            }
            @Override
            public <O> Adapter casePrimitiveType_2(org.eclipse.ocl.types.PrimitiveType<O> object) {
                return createPrimitiveType_2Adapter();
            }
            @Override
            public Adapter caseASTNode(ASTNode object) {
                return createASTNodeAdapter();
            }
            @Override
            public Adapter caseTypedASTNode(TypedASTNode object) {
                return createTypedASTNodeAdapter();
            }
            @Override
            public <C, O> Adapter caseCollectionType_1(org.eclipse.ocl.types.CollectionType<C, O> object) {
                return createCollectionType_1Adapter();
            }
            @Override
            public <O, P> Adapter caseTupleType_1(org.eclipse.ocl.types.TupleType<O, P> object) {
                return createTupleType_1Adapter();
            }
            @Override
            public <C, O> Adapter caseBagType_1(org.eclipse.ocl.types.BagType<C, O> object) {
                return createBagType_1Adapter();
            }
            @Override
            public <C, O> Adapter caseSetType_1(org.eclipse.ocl.types.SetType<C, O> object) {
                return createSetType_1Adapter();
            }
            @Override
            public <C, O> Adapter caseOrderedSetType_1(org.eclipse.ocl.types.OrderedSetType<C, O> object) {
                return createOrderedSetType_1Adapter();
            }
            @Override
            public <C, O> Adapter caseSequenceType_1(org.eclipse.ocl.types.SequenceType<C, O> object) {
                return createSequenceType_1Adapter();
            }
            @Override
            public Adapter caseTypedElement(TypedElement object) {
                return createTypedElementAdapter();
            }
            @Override
            public Adapter caseValueSpecification(ValueSpecification object) {
                return createValueSpecificationAdapter();
            }
            @Override
            public Adapter caseOpaqueExpression(OpaqueExpression object) {
                return createOpaqueExpressionAdapter();
            }
            @Override
            public Adapter caseVisitable(Visitable object) {
                return createVisitableAdapter();
            }
            @Override
            public <C, PM> Adapter caseExpressionInOCL_1(org.eclipse.ocl.utilities.ExpressionInOCL<C, PM> object) {
                return createExpressionInOCL_1Adapter();
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
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.AnyType <em>Any Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.uml.AnyType
     * @generated
     */
    public Adapter createAnyTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.VoidType <em>Void Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.uml.VoidType
     * @generated
     */
    public Adapter createVoidTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.InvalidType <em>Invalid Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.uml.InvalidType
     * @generated
     */
    public Adapter createInvalidTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.ElementType <em>Element Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.uml.ElementType
     * @generated
     */
    public Adapter createElementTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.TypeType <em>Type Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.uml.TypeType
     * @generated
     */
    public Adapter createTypeTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.MessageType <em>Message Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.uml.MessageType
     * @generated
     */
    public Adapter createMessageTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.PrimitiveType <em>Primitive Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.uml.PrimitiveType
     * @generated
     */
    public Adapter createPrimitiveTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.CollectionType <em>Collection Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.uml.CollectionType
     * @generated
     */
    public Adapter createCollectionTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.TupleType <em>Tuple Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.uml.TupleType
     * @generated
     */
    public Adapter createTupleTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.BagType <em>Bag Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.uml.BagType
     * @generated
     */
    public Adapter createBagTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.SetType <em>Set Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.uml.SetType
     * @generated
     */
    public Adapter createSetTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.OrderedSetType <em>Ordered Set Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.uml.OrderedSetType
     * @generated
     */
    public Adapter createOrderedSetTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.SequenceType <em>Sequence Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.uml.SequenceType
     * @generated
     */
    public Adapter createSequenceTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.uml.ExpressionInOCL <em>Expression In OCL</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.uml.ExpressionInOCL
     * @generated
     */
    public Adapter createExpressionInOCLAdapter() {
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
     * Creates a new adapter for an object of class '{@link org.eclipse.uml2.uml.Element <em>Element</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.uml2.uml.Element
     * @generated
     */
    public Adapter createElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.uml2.uml.NamedElement <em>Named Element</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.uml2.uml.NamedElement
     * @generated
     */
    public Adapter createNamedElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.uml2.uml.Namespace <em>Namespace</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.uml2.uml.Namespace
     * @generated
     */
    public Adapter createNamespaceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.uml2.uml.RedefinableElement <em>Redefinable Element</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.uml2.uml.RedefinableElement
     * @generated
     */
    public Adapter createRedefinableElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.uml2.uml.ParameterableElement <em>Parameterable Element</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.uml2.uml.ParameterableElement
     * @generated
     */
    public Adapter createParameterableElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.uml2.uml.PackageableElement <em>Packageable Element</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.uml2.uml.PackageableElement
     * @generated
     */
    public Adapter createPackageableElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.uml2.uml.Type <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.uml2.uml.Type
     * @generated
     */
    public Adapter createTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.uml2.uml.TemplateableElement <em>Templateable Element</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.uml2.uml.TemplateableElement
     * @generated
     */
    public Adapter createTemplateableElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.uml2.uml.Classifier <em>Classifier</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.uml2.uml.Classifier
     * @generated
     */
    public Adapter createClassifierAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.utilities.PredefinedType <em>Predefined Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.utilities.PredefinedType
     * @generated
     */
    public Adapter createPredefinedTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.types.AnyType <em>Any Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.types.AnyType
     * @generated
     */
    public Adapter createAnyType_1Adapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.types.VoidType <em>Void Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.types.VoidType
     * @generated
     */
    public Adapter createVoidType_1Adapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.types.InvalidType <em>Invalid Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.types.InvalidType
     * @generated
     */
    public Adapter createInvalidType_1Adapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.types.ElementType <em>Element Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.types.ElementType
     * @generated
     */
    public Adapter createElementType_1Adapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.types.TypeType <em>Type Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.types.TypeType
     * @generated
     */
    public Adapter createTypeType_1Adapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.types.MessageType <em>Message Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.types.MessageType
     * @generated
     */
    public Adapter createMessageType_1Adapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.uml2.uml.DataType <em>Data Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.uml2.uml.DataType
     * @generated
     */
    public Adapter createDataTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.uml2.uml.PrimitiveType <em>Primitive Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.uml2.uml.PrimitiveType
     * @generated
     */
    public Adapter createPrimitiveType_1Adapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.types.PrimitiveType <em>Primitive Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.types.PrimitiveType
     * @generated
     */
    public Adapter createPrimitiveType_2Adapter() {
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
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.utilities.TypedASTNode <em>Typed AST Node</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.utilities.TypedASTNode
     * @generated
     */
    public Adapter createTypedASTNodeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.types.CollectionType <em>Collection Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.types.CollectionType
     * @generated
     */
    public Adapter createCollectionType_1Adapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.types.TupleType <em>Tuple Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.types.TupleType
     * @generated
     */
    public Adapter createTupleType_1Adapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.types.BagType <em>Bag Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.types.BagType
     * @generated
     */
    public Adapter createBagType_1Adapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.types.SetType <em>Set Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.types.SetType
     * @generated
     */
    public Adapter createSetType_1Adapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.types.OrderedSetType <em>Ordered Set Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.types.OrderedSetType
     * @generated
     */
    public Adapter createOrderedSetType_1Adapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.types.SequenceType <em>Sequence Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.types.SequenceType
     * @generated
     */
    public Adapter createSequenceType_1Adapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.uml2.uml.TypedElement <em>Typed Element</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.uml2.uml.TypedElement
     * @generated
     */
    public Adapter createTypedElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.uml2.uml.ValueSpecification <em>Value Specification</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.uml2.uml.ValueSpecification
     * @generated
     */
    public Adapter createValueSpecificationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.uml2.uml.OpaqueExpression <em>Opaque Expression</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.uml2.uml.OpaqueExpression
     * @generated
     */
    public Adapter createOpaqueExpressionAdapter() {
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
     * Creates a new adapter for an object of class '{@link org.eclipse.ocl.utilities.ExpressionInOCL <em>Expression In OCL</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ocl.utilities.ExpressionInOCL
     * @generated
     */
    public Adapter createExpressionInOCL_1Adapter() {
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

} //UMLAdapterFactory

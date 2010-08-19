/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package integration.xsd.util;

import integration.xsd.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see integration.xsd.XsdPackage
 * @generated
 */
public class XsdAdapterFactory extends AdapterFactoryImpl {
	/**
     * The cached model package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static XsdPackage modelPackage;

	/**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public XsdAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = XsdPackage.eINSTANCE;
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
	protected XsdSwitch<Adapter> modelSwitch =
		new XsdSwitch<Adapter>() {
            @Override
            public Adapter caseSequence(Sequence object) {
                return createSequenceAdapter();
            }
            @Override
            public Adapter caseChoice(Choice object) {
                return createChoiceAdapter();
            }
            @Override
            public Adapter caseComplexType(ComplexType object) {
                return createComplexTypeAdapter();
            }
            @Override
            public Adapter caseElementDefinition(ElementDefinition object) {
                return createElementDefinitionAdapter();
            }
            @Override
            public Adapter caseNamedElement(NamedElement object) {
                return createNamedElementAdapter();
            }
            @Override
            public Adapter caseAbstractType(AbstractType object) {
                return createAbstractTypeAdapter();
            }
            @Override
            public Adapter caseContainable(Containable object) {
                return createContainableAdapter();
            }
            @Override
            public Adapter caseAttribute(Attribute object) {
                return createAttributeAdapter();
            }
            @Override
            public Adapter caseAny(Any object) {
                return createAnyAdapter();
            }
            @Override
            public Adapter caseRoot(Root object) {
                return createRootAdapter();
            }
            @Override
            public Adapter caseGroup(Group object) {
                return createGroupAdapter();
            }
            @Override
            public Adapter caseAnnotation(Annotation object) {
                return createAnnotationAdapter();
            }
            @Override
            public Adapter caseNotation(Notation object) {
                return createNotationAdapter();
            }
            @Override
            public Adapter caseSimpleType(SimpleType object) {
                return createSimpleTypeAdapter();
            }
            @Override
            public Adapter caseElementReference(ElementReference object) {
                return createElementReferenceAdapter();
            }
            @Override
            public Adapter caseAbstractContent(AbstractContent object) {
                return createAbstractContentAdapter();
            }
            @Override
            public Adapter caseSimpleContent(SimpleContent object) {
                return createSimpleContentAdapter();
            }
            @Override
            public Adapter caseComplexContent(ComplexContent object) {
                return createComplexContentAdapter();
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
     * Creates a new adapter for an object of class '{@link integration.xsd.Sequence <em>Sequence</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see integration.xsd.Sequence
     * @generated
     */
	public Adapter createSequenceAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link integration.xsd.Choice <em>Choice</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see integration.xsd.Choice
     * @generated
     */
	public Adapter createChoiceAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link integration.xsd.ComplexType <em>Complex Type</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see integration.xsd.ComplexType
     * @generated
     */
	public Adapter createComplexTypeAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link integration.xsd.ElementDefinition <em>Element Definition</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see integration.xsd.ElementDefinition
     * @generated
     */
	public Adapter createElementDefinitionAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link integration.xsd.NamedElement <em>Named Element</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see integration.xsd.NamedElement
     * @generated
     */
	public Adapter createNamedElementAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link integration.xsd.AbstractType <em>Abstract Type</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see integration.xsd.AbstractType
     * @generated
     */
	public Adapter createAbstractTypeAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link integration.xsd.Containable <em>Containable</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see integration.xsd.Containable
     * @generated
     */
	public Adapter createContainableAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link integration.xsd.Attribute <em>Attribute</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see integration.xsd.Attribute
     * @generated
     */
	public Adapter createAttributeAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link integration.xsd.Any <em>Any</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see integration.xsd.Any
     * @generated
     */
	public Adapter createAnyAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link integration.xsd.Root <em>Root</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see integration.xsd.Root
     * @generated
     */
	public Adapter createRootAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link integration.xsd.Group <em>Group</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see integration.xsd.Group
     * @generated
     */
	public Adapter createGroupAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link integration.xsd.Annotation <em>Annotation</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see integration.xsd.Annotation
     * @generated
     */
	public Adapter createAnnotationAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link integration.xsd.Notation <em>Notation</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see integration.xsd.Notation
     * @generated
     */
	public Adapter createNotationAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link integration.xsd.SimpleType <em>Simple Type</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see integration.xsd.SimpleType
     * @generated
     */
	public Adapter createSimpleTypeAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link integration.xsd.ElementReference <em>Element Reference</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see integration.xsd.ElementReference
     * @generated
     */
	public Adapter createElementReferenceAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link integration.xsd.AbstractContent <em>Abstract Content</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see integration.xsd.AbstractContent
     * @generated
     */
	public Adapter createAbstractContentAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link integration.xsd.SimpleContent <em>Simple Content</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see integration.xsd.SimpleContent
     * @generated
     */
	public Adapter createSimpleContentAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link integration.xsd.ComplexContent <em>Complex Content</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see integration.xsd.ComplexContent
     * @generated
     */
	public Adapter createComplexContentAdapter() {
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

} //XsdAdapterFactory

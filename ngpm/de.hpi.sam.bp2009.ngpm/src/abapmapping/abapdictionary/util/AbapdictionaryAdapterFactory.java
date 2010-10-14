/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package abapmapping.abapdictionary.util;

import abapmapping.abapdictionary.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see abapmapping.abapdictionary.AbapdictionaryPackage
 * @generated
 */
public class AbapdictionaryAdapterFactory extends AdapterFactoryImpl {
	/**
     * The cached model package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static AbapdictionaryPackage modelPackage;

	/**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AbapdictionaryAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = AbapdictionaryPackage.eINSTANCE;
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
	protected AbapdictionarySwitch<Adapter> modelSwitch =
		new AbapdictionarySwitch<Adapter>() {
            @Override
            public Adapter caseXsdType(XsdType object) {
                return createXsdTypeAdapter();
            }
            @Override
            public Adapter caseUnstructuredAbapType(UnstructuredAbapType object) {
                return createUnstructuredAbapTypeAdapter();
            }
            @Override
            public Adapter caseCodeValue(CodeValue object) {
                return createCodeValueAdapter();
            }
            @Override
            public Adapter caseCode(Code object) {
                return createCodeAdapter();
            }
            @Override
            public Adapter caseDataElement(DataElement object) {
                return createDataElementAdapter();
            }
            @Override
            public Adapter caseAbapType(AbapType object) {
                return createAbapTypeAdapter();
            }
            @Override
            public Adapter caseAbapStructureType(AbapStructureType object) {
                return createAbapStructureTypeAdapter();
            }
            @Override
            public Adapter caseAbapStructureField(AbapStructureField object) {
                return createAbapStructureFieldAdapter();
            }
            @Override
            public Adapter caseAbapPrimtiveType(AbapPrimtiveType object) {
                return createAbapPrimtiveTypeAdapter();
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
     * Creates a new adapter for an object of class '{@link abapmapping.abapdictionary.XsdType <em>Xsd Type</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see abapmapping.abapdictionary.XsdType
     * @generated
     */
	public Adapter createXsdTypeAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link abapmapping.abapdictionary.UnstructuredAbapType <em>Unstructured Abap Type</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see abapmapping.abapdictionary.UnstructuredAbapType
     * @generated
     */
	public Adapter createUnstructuredAbapTypeAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link abapmapping.abapdictionary.CodeValue <em>Code Value</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see abapmapping.abapdictionary.CodeValue
     * @generated
     */
	public Adapter createCodeValueAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link abapmapping.abapdictionary.Code <em>Code</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see abapmapping.abapdictionary.Code
     * @generated
     */
	public Adapter createCodeAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link abapmapping.abapdictionary.DataElement <em>Data Element</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see abapmapping.abapdictionary.DataElement
     * @generated
     */
	public Adapter createDataElementAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link abapmapping.abapdictionary.AbapType <em>Abap Type</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see abapmapping.abapdictionary.AbapType
     * @generated
     */
	public Adapter createAbapTypeAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link abapmapping.abapdictionary.AbapStructureType <em>Abap Structure Type</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see abapmapping.abapdictionary.AbapStructureType
     * @generated
     */
	public Adapter createAbapStructureTypeAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link abapmapping.abapdictionary.AbapStructureField <em>Abap Structure Field</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see abapmapping.abapdictionary.AbapStructureField
     * @generated
     */
	public Adapter createAbapStructureFieldAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link abapmapping.abapdictionary.AbapPrimtiveType <em>Abap Primtive Type</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see abapmapping.abapdictionary.AbapPrimtiveType
     * @generated
     */
	public Adapter createAbapPrimtiveTypeAdapter() {
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

} //AbapdictionaryAdapterFactory

/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbapmappingAdapterFactory.java,v 1.1 2011/02/07 17:17:58 auhl Exp $
 */
package abapmapping.util;

import abapmapping.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see abapmapping.AbapmappingPackage
 * @generated
 */
public class AbapmappingAdapterFactory extends AdapterFactoryImpl {
	/**
     * The cached model package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static AbapmappingPackage modelPackage;

	/**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AbapmappingAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = AbapmappingPackage.eINSTANCE;
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
	protected AbapmappingSwitch<Adapter> modelSwitch =
		new AbapmappingSwitch<Adapter>() {
            @Override
            public Adapter caseAbapClassImplementationAnnotation(AbapClassImplementationAnnotation object) {
                return createAbapClassImplementationAnnotationAdapter();
            }
            @Override
            public Adapter caseAbapAssociationImplementationAnnotation(AbapAssociationImplementationAnnotation object) {
                return createAbapAssociationImplementationAnnotationAdapter();
            }
            @Override
            public Adapter caseAbapAssociationEndImplementationAnnotation(AbapAssociationEndImplementationAnnotation object) {
                return createAbapAssociationEndImplementationAnnotationAdapter();
            }
            @Override
            public Adapter caseAbapSignatureImplementationAnnotation(AbapSignatureImplementationAnnotation object) {
                return createAbapSignatureImplementationAnnotationAdapter();
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
     * Creates a new adapter for an object of class '{@link abapmapping.AbapClassImplementationAnnotation <em>Abap Class Implementation Annotation</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see abapmapping.AbapClassImplementationAnnotation
     * @generated
     */
	public Adapter createAbapClassImplementationAnnotationAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link abapmapping.AbapAssociationImplementationAnnotation <em>Abap Association Implementation Annotation</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see abapmapping.AbapAssociationImplementationAnnotation
     * @generated
     */
	public Adapter createAbapAssociationImplementationAnnotationAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link abapmapping.AbapAssociationEndImplementationAnnotation <em>Abap Association End Implementation Annotation</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see abapmapping.AbapAssociationEndImplementationAnnotation
     * @generated
     */
	public Adapter createAbapAssociationEndImplementationAnnotationAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link abapmapping.AbapSignatureImplementationAnnotation <em>Abap Signature Implementation Annotation</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see abapmapping.AbapSignatureImplementationAnnotation
     * @generated
     */
	public Adapter createAbapSignatureImplementationAnnotationAdapter() {
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

} //AbapmappingAdapterFactory

/**
 * <copyright>
 * </copyright>
 *
 * $Id: EmfindexFactory.java,v 1.1 2009/09/30 13:04:50 jkohnlein Exp $
 */
package org.eclipse.emf.index.ecore.emfindex;

import org.eclipse.emf.ecore.EFactory;

import org.eclipse.emf.emfindex.ContainerDescriptor;
import org.eclipse.emf.emfindex.EObjectDescriptor;
import org.eclipse.emf.emfindex.EReferenceDescriptor;
import org.eclipse.emf.emfindex.ResourceDescriptor;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.index.ecore.emfindex.EmfindexPackage
 * @generated
 */
public interface EmfindexFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EmfindexFactory eINSTANCE = org.eclipse.emf.index.ecore.emfindex.impl.EmfindexFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Container Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Container Descriptor</em>'.
	 * @generated
	 */
	ContainerDescriptor createContainerDescriptor();

	/**
	 * Returns a new object of class '<em>Resource Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Descriptor</em>'.
	 * @generated
	 */
	ResourceDescriptor createResourceDescriptor();

	/**
	 * Returns a new object of class '<em>EObject Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EObject Descriptor</em>'.
	 * @generated
	 */
	EObjectDescriptor createEObjectDescriptor();

	/**
	 * Returns a new object of class '<em>EReference Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EReference Descriptor</em>'.
	 * @generated
	 */
	EReferenceDescriptor createEReferenceDescriptor();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EmfindexPackage getEmfindexPackage();

} //EmfindexFactory

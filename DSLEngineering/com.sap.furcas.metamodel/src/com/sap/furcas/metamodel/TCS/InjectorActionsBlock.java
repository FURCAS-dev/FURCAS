/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.TCS;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Injector Actions Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.TCS.InjectorActionsBlock#getPropertyInits <em>Property Inits</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.TCS.InjectorActionsBlock#getInjectorActions <em>Injector Actions</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getInjectorActionsBlock()
 * @model
 * @generated
 */
public interface InjectorActionsBlock extends SequenceElement {
	/**
	 * Returns the value of the '<em><b>Property Inits</b></em>' containment reference list.
	 * The list contents are of type {@link com.sap.furcas.metamodel.TCS.InjectorAction}.
	 * It is bidirectional and its opposite is '{@link com.sap.furcas.metamodel.TCS.InjectorAction#getInjectorActionsBlock <em>Injector Actions Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Inits</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Inits</em>' containment reference list.
	 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getInjectorActionsBlock_PropertyInits()
	 * @see com.sap.furcas.metamodel.TCS.InjectorAction#getInjectorActionsBlock
	 * @model opposite="injectorActionsBlock" containment="true"
	 * @generated
	 */
	EList<InjectorAction> getPropertyInits();

	/**
	 * Returns the value of the '<em><b>Injector Actions</b></em>' reference list.
	 * The list contents are of type {@link com.sap.furcas.metamodel.TCS.InjectorAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Injector Actions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Injector Actions</em>' reference list.
	 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getInjectorActionsBlock_InjectorActions()
	 * @model
	 * @generated
	 */
	EList<InjectorAction> getInjectorActions();

} // InjectorActionsBlock

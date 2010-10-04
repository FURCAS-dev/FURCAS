/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.TCS;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Injector Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.TCS.InjectorAction#getInjectorActionsBlock <em>Injector Actions Block</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getInjectorAction()
 * @model abstract="true"
 * @generated
 */
public interface InjectorAction extends EObject {
        /**
         * Returns the value of the '<em><b>Injector Actions Block</b></em>' container reference.
         * It is bidirectional and its opposite is '{@link com.sap.furcas.metamodel.TCS.InjectorActionsBlock#getPropertyInits <em>Property Inits</em>}'.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Injector Actions Block</em>' container reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Injector Actions Block</em>' container reference.
         * @see #setInjectorActionsBlock(InjectorActionsBlock)
         * @see com.sap.furcas.metamodel.TCS.TCSPackage#getInjectorAction_InjectorActionsBlock()
         * @see com.sap.furcas.metamodel.TCS.InjectorActionsBlock#getPropertyInits
         * @model opposite="propertyInits" transient="false"
         * @generated
         */
        InjectorActionsBlock getInjectorActionsBlock();

        /**
         * Sets the value of the '{@link com.sap.furcas.metamodel.TCS.InjectorAction#getInjectorActionsBlock <em>Injector Actions Block</em>}' container reference.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @param value the new value of the '<em>Injector Actions Block</em>' container reference.
         * @see #getInjectorActionsBlock()
         * @generated
         */
        void setInjectorActionsBlock(InjectorActionsBlock value);

} // InjectorAction

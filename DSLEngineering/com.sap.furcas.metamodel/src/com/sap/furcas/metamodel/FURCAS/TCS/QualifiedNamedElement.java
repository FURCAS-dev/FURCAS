/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Qualified Named Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.QualifiedNamedElement#getNames <em>Names</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.QualifiedNamedElement#getMetaReference <em>Meta Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getQualifiedNamedElement()
 * @model
 * @generated
 */
public interface QualifiedNamedElement extends LocatedElement {
        /**
	 * Returns the value of the '<em><b>Names</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Names</em>' attribute list isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
	 * @return the value of the '<em>Names</em>' attribute list.
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getQualifiedNamedElement_Names()
	 * @model required="true"
	 * @generated
	 */
        EList<String> getNames();

        /**
	 * Returns the value of the '<em><b>Meta Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Meta Reference</em>' reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Reference</em>' reference.
	 * @see #setMetaReference(EClass)
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getQualifiedNamedElement_MetaReference()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='furcasTemplates'"
	 * @generated
	 */
        EClass getMetaReference();

        /**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.QualifiedNamedElement#getMetaReference <em>Meta Reference</em>}' reference.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta Reference</em>' reference.
	 * @see #getMetaReference()
	 * @generated
	 */
        void setMetaReference(EClass value);

} // QualifiedNamedElement

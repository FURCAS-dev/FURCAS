/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.OCLExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Predicate Semantic</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.PredicateSemantic#getAs <em>As</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.PredicateSemantic#getWhen <em>When</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.PredicateSemantic#getMode <em>Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getPredicateSemantic()
 * @model
 * @generated
 */
public interface PredicateSemantic extends EObject {
        /**
	 * Returns the value of the '<em><b>As</b></em>' reference.
	 * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>As</em>' reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
	 * @return the value of the '<em>As</em>' reference.
	 * @see #setAs(Template)
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getPredicateSemantic_As()
	 * @model
	 * @generated
	 */
        Template getAs();

        /**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.PredicateSemantic#getAs <em>As</em>}' reference.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @param value the new value of the '<em>As</em>' reference.
	 * @see #getAs()
	 * @generated
	 */
        void setAs(Template value);

        /**
	 * Returns the value of the '<em><b>When</b></em>' reference.
	 * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>When</em>' reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
	 * @return the value of the '<em>When</em>' reference.
	 * @see #setWhen(OCLExpression)
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getPredicateSemantic_When()
	 * @model
	 * @generated
	 */
        OCLExpression getWhen();

        /**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.PredicateSemantic#getWhen <em>When</em>}' reference.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @param value the new value of the '<em>When</em>' reference.
	 * @see #getWhen()
	 * @generated
	 */
        void setWhen(OCLExpression value);

        /**
	 * Returns the value of the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Mode</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode</em>' attribute.
	 * @see #setMode(String)
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getPredicateSemantic_Mode()
	 * @model
	 * @generated
	 */
        String getMode();

        /**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.PredicateSemantic#getMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode</em>' attribute.
	 * @see #getMode()
	 * @generated
	 */
        void setMode(String value);

} // PredicateSemantic

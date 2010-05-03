/**
 * <copyright>
 * </copyright>
 *
 * $Id: SimpleClassifierRefCS.java,v 1.1 2010/05/03 05:24:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.baseCST;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Classifier Ref CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.SimpleClassifierRefCS#getClassifier <em>Classifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getSimpleClassifierRefCS()
 * @model
 * @generated
 */
public interface SimpleClassifierRefCS extends ClassifierRefCS {
	/**
	 * Returns the value of the '<em><b>Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classifier</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classifier</em>' reference.
	 * @see #setClassifier(ClassifierCS)
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getSimpleClassifierRefCS_Classifier()
	 * @model
	 * @generated
	 */
	ClassifierCS getClassifier();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.SimpleClassifierRefCS#getClassifier <em>Classifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Classifier</em>' reference.
	 * @see #getClassifier()
	 * @generated
	 */
	void setClassifier(ClassifierCS value);

} // SimpleClassifierRefCS

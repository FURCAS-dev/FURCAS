/**
 * <copyright>
 * </copyright>
 *
 * $Id: QualifiedClassifierRefCS.java,v 1.1 2010/05/03 05:24:58 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.baseCST;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Qualified Classifier Ref CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedClassifierRefCS#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedClassifierRefCS#getClassifier <em>Classifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getQualifiedClassifierRefCS()
 * @model
 * @generated
 */
public interface QualifiedClassifierRefCS extends ClassifierRefCS {
	/**
	 * Returns the value of the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Namespace</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Namespace</em>' reference.
	 * @see #setNamespace(NamespaceCS)
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getQualifiedClassifierRefCS_Namespace()
	 * @model
	 * @generated
	 */
	NamespaceCS getNamespace();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedClassifierRefCS#getNamespace <em>Namespace</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Namespace</em>' reference.
	 * @see #getNamespace()
	 * @generated
	 */
	void setNamespace(NamespaceCS value);

	/**
	 * Returns the value of the '<em><b>Classifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classifier</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classifier</em>' containment reference.
	 * @see #setClassifier(ClassifierRefCS)
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getQualifiedClassifierRefCS_Classifier()
	 * @model containment="true"
	 * @generated
	 */
	ClassifierRefCS getClassifier();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedClassifierRefCS#getClassifier <em>Classifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Classifier</em>' containment reference.
	 * @see #getClassifier()
	 * @generated
	 */
	void setClassifier(ClassifierRefCS value);

} // QualifiedClassifierRefCS

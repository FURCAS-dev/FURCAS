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
 * A representation of the model object '<em><b>Class Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.TCS.ClassTemplate#getTemplateSequence <em>Template Sequence</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.TCS.ClassTemplate#getModifiers <em>Modifiers</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.TCS.ClassTemplate#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.TCS.ClassTemplate#isIsDeep <em>Is Deep</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.TCS.ClassTemplate#getPrefixSequence <em>Prefix Sequence</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.TCS.ClassTemplate#isIsOperatored <em>Is Operatored</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.TCS.ClassTemplate#getOperatorList <em>Operator List</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.TCS.ClassTemplate#isIsMain <em>Is Main</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.TCS.ClassTemplate#isIsMulti <em>Is Multi</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.TCS.ClassTemplate#isIsNonPrimary <em>Is Non Primary</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.TCS.ClassTemplate#getMode <em>Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getClassTemplate()
 * @model
 * @generated
 */
public interface ClassTemplate extends ContextTemplate {
	/**
	 * Returns the value of the '<em><b>Template Sequence</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link com.sap.furcas.metamodel.TCS.Sequence#getTemplateContainer <em>Template Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template Sequence</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template Sequence</em>' containment reference.
	 * @see #setTemplateSequence(Sequence)
	 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getClassTemplate_TemplateSequence()
	 * @see com.sap.furcas.metamodel.TCS.Sequence#getTemplateContainer
	 * @model opposite="templateContainer" containment="true" required="true" ordered="false"
	 * @generated
	 */
	Sequence getTemplateSequence();

	/**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.TCS.ClassTemplate#getTemplateSequence <em>Template Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template Sequence</em>' containment reference.
	 * @see #getTemplateSequence()
	 * @generated
	 */
	void setTemplateSequence(Sequence value);

	/**
	 * Returns the value of the '<em><b>Modifiers</b></em>' attribute list.
	 * The list contents are of type {@link com.sap.furcas.metamodel.TCS.TemplateModifiers}.
	 * The literals are from the enumeration {@link com.sap.furcas.metamodel.TCS.TemplateModifiers}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modifiers</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modifiers</em>' attribute list.
	 * @see com.sap.furcas.metamodel.TCS.TemplateModifiers
	 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getClassTemplate_Modifiers()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	EList<TemplateModifiers> getModifiers();

	/**
	 * Returns the value of the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Abstract</em>' attribute.
	 * @see #setIsAbstract(boolean)
	 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getClassTemplate_IsAbstract()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsAbstract();

	/**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.TCS.ClassTemplate#isIsAbstract <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Abstract</em>' attribute.
	 * @see #isIsAbstract()
	 * @generated
	 */
	void setIsAbstract(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Deep</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Deep</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Deep</em>' attribute.
	 * @see #setIsDeep(boolean)
	 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getClassTemplate_IsDeep()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsDeep();

	/**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.TCS.ClassTemplate#isIsDeep <em>Is Deep</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Deep</em>' attribute.
	 * @see #isIsDeep()
	 * @generated
	 */
	void setIsDeep(boolean value);

	/**
	 * Returns the value of the '<em><b>Prefix Sequence</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link com.sap.furcas.metamodel.TCS.Sequence#getPrefixContainer <em>Prefix Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prefix Sequence</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prefix Sequence</em>' containment reference.
	 * @see #setPrefixSequence(Sequence)
	 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getClassTemplate_PrefixSequence()
	 * @see com.sap.furcas.metamodel.TCS.Sequence#getPrefixContainer
	 * @model opposite="prefixContainer" containment="true" required="true" ordered="false"
	 * @generated
	 */
	Sequence getPrefixSequence();

	/**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.TCS.ClassTemplate#getPrefixSequence <em>Prefix Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prefix Sequence</em>' containment reference.
	 * @see #getPrefixSequence()
	 * @generated
	 */
	void setPrefixSequence(Sequence value);

	/**
	 * Returns the value of the '<em><b>Is Operatored</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Operatored</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Operatored</em>' attribute.
	 * @see #setIsOperatored(boolean)
	 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getClassTemplate_IsOperatored()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsOperatored();

	/**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.TCS.ClassTemplate#isIsOperatored <em>Is Operatored</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Operatored</em>' attribute.
	 * @see #isIsOperatored()
	 * @generated
	 */
	void setIsOperatored(boolean value);

	/**
	 * Returns the value of the '<em><b>Operator List</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator List</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator List</em>' reference.
	 * @see #setOperatorList(OperatorList)
	 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getClassTemplate_OperatorList()
	 * @model ordered="false"
	 * @generated
	 */
	OperatorList getOperatorList();

	/**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.TCS.ClassTemplate#getOperatorList <em>Operator List</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator List</em>' reference.
	 * @see #getOperatorList()
	 * @generated
	 */
	void setOperatorList(OperatorList value);

	/**
	 * Returns the value of the '<em><b>Is Main</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Main</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Main</em>' attribute.
	 * @see #setIsMain(boolean)
	 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getClassTemplate_IsMain()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsMain();

	/**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.TCS.ClassTemplate#isIsMain <em>Is Main</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Main</em>' attribute.
	 * @see #isIsMain()
	 * @generated
	 */
	void setIsMain(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Multi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Multi</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Multi</em>' attribute.
	 * @see #setIsMulti(boolean)
	 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getClassTemplate_IsMulti()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsMulti();

	/**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.TCS.ClassTemplate#isIsMulti <em>Is Multi</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Multi</em>' attribute.
	 * @see #isIsMulti()
	 * @generated
	 */
	void setIsMulti(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Non Primary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Non Primary</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Non Primary</em>' attribute.
	 * @see #setIsNonPrimary(boolean)
	 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getClassTemplate_IsNonPrimary()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsNonPrimary();

	/**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.TCS.ClassTemplate#isIsNonPrimary <em>Is Non Primary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Non Primary</em>' attribute.
	 * @see #isIsNonPrimary()
	 * @generated
	 */
	void setIsNonPrimary(boolean value);

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
	 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getClassTemplate_Mode()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	String getMode();

	/**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.TCS.ClassTemplate#getMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode</em>' attribute.
	 * @see #getMode()
	 * @generated
	 */
	void setMode(String value);

} // ClassTemplate
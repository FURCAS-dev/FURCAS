/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query2.test.mm.textverticalization;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Translatable Text</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.textverticalization.TranslatableText#getMaxWidth <em>Max Width</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.textverticalization.TranslatableText#getOriginalText <em>Original Text</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.textverticalization.TranslatableText#getResType <em>Res Type</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.textverticalization.TranslatableText#isTranslate <em>Translate</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.textverticalization.TranslatableText#getTransUnitId <em>Trans Unit Id</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.textverticalization.TranslatableText#getResName <em>Res Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.textverticalization.TextverticalizationPackage#getTranslatableText()
 * @model annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/textverticalization[2.0.0]' metaObject='textverticalization.TranslatableTextFragment' metaObjectMofId='48D4188D58380873869111DD8E220019993BAD15' isStructureType='true'"
 * @generated
 */
public interface TranslatableText extends EObject {
	/**
	 * Returns the value of the '<em><b>Max Width</b></em>' attribute.
	 * The default value is <code>"255"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Width</em>' attribute.
	 * @see #setMaxWidth(int)
	 * @see org.eclipse.emf.query2.test.mm.textverticalization.TextverticalizationPackage#getTranslatableText_MaxWidth()
	 * @model default="255" required="true"
	 * @generated
	 */
	int getMaxWidth();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.textverticalization.TranslatableText#getMaxWidth <em>Max Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Width</em>' attribute.
	 * @see #getMaxWidth()
	 * @generated
	 */
	void setMaxWidth(int value);

	/**
	 * Returns the value of the '<em><b>Original Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Original Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Original Text</em>' attribute.
	 * @see #setOriginalText(String)
	 * @see org.eclipse.emf.query2.test.mm.textverticalization.TextverticalizationPackage#getTranslatableText_OriginalText()
	 * @model required="true"
	 * @generated
	 */
	String getOriginalText();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.textverticalization.TranslatableText#getOriginalText <em>Original Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Text</em>' attribute.
	 * @see #getOriginalText()
	 * @generated
	 */
	void setOriginalText(String value);

	/**
	 * Returns the value of the '<em><b>Res Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Res Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Res Type</em>' attribute.
	 * @see #setResType(String)
	 * @see org.eclipse.emf.query2.test.mm.textverticalization.TextverticalizationPackage#getTranslatableText_ResType()
	 * @model required="true"
	 * @generated
	 */
	String getResType();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.textverticalization.TranslatableText#getResType <em>Res Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Res Type</em>' attribute.
	 * @see #getResType()
	 * @generated
	 */
	void setResType(String value);

	/**
	 * Returns the value of the '<em><b>Translate</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Translate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Translate</em>' attribute.
	 * @see #setTranslate(boolean)
	 * @see org.eclipse.emf.query2.test.mm.textverticalization.TextverticalizationPackage#getTranslatableText_Translate()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isTranslate();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.textverticalization.TranslatableText#isTranslate <em>Translate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Translate</em>' attribute.
	 * @see #isTranslate()
	 * @generated
	 */
	void setTranslate(boolean value);

	/**
	 * Returns the value of the '<em><b>Trans Unit Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trans Unit Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trans Unit Id</em>' attribute.
	 * @see org.eclipse.emf.query2.test.mm.textverticalization.TextverticalizationPackage#getTranslatableText_TransUnitId()
	 * @model required="true" suppressedSetVisibility="true"
	 * @generated
	 */
	String getTransUnitId();

	/**
	 * Returns the value of the '<em><b>Res Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Res Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Res Name</em>' attribute.
	 * @see #setResName(String)
	 * @see org.eclipse.emf.query2.test.mm.textverticalization.TextverticalizationPackage#getTranslatableText_ResName()
	 * @model required="true"
	 * @generated
	 */
	String getResName();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.textverticalization.TranslatableText#getResName <em>Res Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Res Name</em>' attribute.
	 * @see #getResName()
	 * @generated
	 */
	void setResName(String value);

} // TranslatableText

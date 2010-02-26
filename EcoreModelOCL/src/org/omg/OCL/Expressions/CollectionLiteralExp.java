/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.omg.OCL.Expressions;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.omg.OCL.Expressions.CollectionLiteralExp#getKind <em>Kind</em>}</li>
 *   <li>{@link org.omg.OCL.Expressions.CollectionLiteralExp#getParts <em>Parts</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.omg.OCL.Expressions.ExpressionsPackage#getCollectionLiteralExp()
 * @model annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.Expressions.CollectionLiteralExp' metaObjectMofId='45ED2E29472815739F3249CA2042CD5D538A0E30' isStructureType='false'"
 * @generated
 */
public interface CollectionLiteralExp extends LiteralExp {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.omg.OCL.Expressions.CollectionKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.omg.OCL.Expressions.CollectionKind
	 * @see #setKind(CollectionKind)
	 * @see org.omg.OCL.Expressions.ExpressionsPackage#getCollectionLiteralExp_Kind()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	CollectionKind getKind();

	/**
	 * Sets the value of the '{@link org.omg.OCL.Expressions.CollectionLiteralExp#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.omg.OCL.Expressions.CollectionKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(CollectionKind value);

	/**
	 * Returns the value of the '<em><b>Parts</b></em>' reference list.
	 * The list contents are of type {@link org.omg.OCL.Expressions.CollectionLiteralPart}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parts</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parts</em>' reference list.
	 * @see org.omg.OCL.Expressions.ExpressionsPackage#getCollectionLiteralExp_Parts()
	 * @model annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.Expressions.A_parts_collectionLiteralExp' metaObjectMofId='45ED2E29D8D44430F78B40093A9FD47468E3F189' storedEnd='1' compositeEnd='-1' orderedEnd='0' exposedEndNumber='1'"
	 * @generated
	 */
	EList<CollectionLiteralPart> getParts();

} // CollectionLiteralExp

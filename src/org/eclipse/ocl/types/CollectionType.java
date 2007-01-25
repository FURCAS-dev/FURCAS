/**
 * <copyright>
 * </copyright>
 *
 * $Id: CollectionType.java,v 1.1 2007/01/25 18:24:36 cdamus Exp $
 */
package org.eclipse.ocl.types;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.ocl.utilities.TypedASTNode;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.types.CollectionType#getElementType <em>Element Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.types.CollectionType#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.types.TypesPackage#getCollectionType()
 * @model
 * @generated
 */
public interface CollectionType<C, O> extends PredefinedType<O>, TypedASTNode {
	String SINGLETON_NAME = "Collection"; //$NON-NLS-1$
    
	/**
     * Returns the value of the '<em><b>Element Type</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Element Type</em>' reference.
     * @see #setElementType(C)
     * @see org.eclipse.ocl.types.TypesPackage#getCollectionType_ElementType()
     * @model
     * @generated
     */
	C getElementType();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.types.CollectionType#getElementType <em>Element Type</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Element Type</em>' reference.
     * @see #getElementType()
     * @generated
     */
	void setElementType(C value);

	/**
     * Returns the value of the '<em><b>Kind</b></em>' attribute.
     * The literals are from the enumeration {@link org.eclipse.ocl.expressions.CollectionKind}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collection Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Kind</em>' attribute.
     * @see org.eclipse.ocl.expressions.CollectionKind
     * @see org.eclipse.ocl.types.TypesPackage#getCollectionType_Kind()
     * @model required="true" transient="true" changeable="false" volatile="true"
     * @generated
     */
	CollectionKind getKind();

	/**
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterators</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @model type="java.lang.Object"
     * @generated
     */
	EList<O> oclIterators();

} // CollectionType

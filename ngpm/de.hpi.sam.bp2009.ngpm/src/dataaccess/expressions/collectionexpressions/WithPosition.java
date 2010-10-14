/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.expressions.collectionexpressions;

import dataaccess.expressions.ExpressionWithArgument;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>With Position</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dataaccess.expressions.collectionexpressions.WithPosition#getAt <em>At</em>}</li>
 * </ul>
 * </p>
 *
 * @see dataaccess.expressions.collectionexpressions.CollectionexpressionsPackage#getWithPosition()
 * @model abstract="true"
 *        annotation="http://de.hpi.sam.bp2009.OCL SourceMustBeOrdered='self.argument.getType().ordered'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='SourceMustBeOrdered'"
 * @generated
 */
public interface WithPosition extends ExpressionWithArgument {
	/**
     * Returns the value of the '<em><b>At</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * a position in an object with upper multiplicity >1 and ordered=true.
     * <!-- end-model-doc -->
     * @return the value of the '<em>At</em>' attribute.
     * @see #setAt(int)
     * @see dataaccess.expressions.collectionexpressions.CollectionexpressionsPackage#getWithPosition_At()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	int getAt();

	/**
     * Sets the value of the '{@link dataaccess.expressions.collectionexpressions.WithPosition#getAt <em>At</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>At</em>' attribute.
     * @see #getAt()
     * @generated
     */
	void setAt(int value);

} // WithPosition

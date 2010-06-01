/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.actions;

import dataaccess.expressions.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Foreach</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * We may not need a Foreach statement if we use internal iterators in collections together with blocks. However, how would a collection class implement the internal iterator without a for statement? Could this work with a WhileLoop only?
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavioral.actions.Foreach#isParallel <em>Parallel</em>}</li>
 *   <li>{@link behavioral.actions.Foreach#getCollection <em>Collection</em>}</li>
 *   <li>{@link behavioral.actions.Foreach#getForVariable <em>For Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavioral.actions.ActionsPackage#getForeach()
 * @model annotation="http://de.hpi.sam.bp2009.OCL VariableOwnedByRightBlock='self.forVariable.owner = self.nestedBlocks->at(1)'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='VariableOwnedByRightBlock'"
 * @generated
 */
public interface Foreach extends SingleBlockStatement {
	/**
	 * Returns the value of the '<em><b>Parallel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parallel</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parallel</em>' attribute.
	 * @see #setParallel(boolean)
	 * @see behavioral.actions.ActionsPackage#getForeach_Parallel()
	 * @model
	 * @generated
	 */
	boolean isParallel();

	/**
	 * Sets the value of the '{@link behavioral.actions.Foreach#isParallel <em>Parallel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parallel</em>' attribute.
	 * @see #isParallel()
	 * @generated
	 */
	void setParallel(boolean value);

	/**
	 * Returns the value of the '<em><b>Collection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collection</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collection</em>' reference.
	 * @see #setCollection(Expression)
	 * @see behavioral.actions.ActionsPackage#getForeach_Collection()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName=''"
	 * @generated
	 */
	Expression getCollection();

	/**
	 * Sets the value of the '{@link behavioral.actions.Foreach#getCollection <em>Collection</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Collection</em>' reference.
	 * @see #getCollection()
	 * @generated
	 */
	void setCollection(Expression value);

	/**
	 * Returns the value of the '<em><b>For Variable</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link behavioral.actions.Iterator#getBoundToFor <em>Bound To For</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>For Variable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>For Variable</em>' containment reference.
	 * @see #setForVariable(Iterator)
	 * @see behavioral.actions.ActionsPackage#getForeach_ForVariable()
	 * @see behavioral.actions.Iterator#getBoundToFor
	 * @model opposite="boundToFor" containment="true" required="true"
	 * @generated
	 */
	Iterator getForVariable();

	/**
	 * Sets the value of the '{@link behavioral.actions.Foreach#getForVariable <em>For Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>For Variable</em>' containment reference.
	 * @see #getForVariable()
	 * @generated
	 */
	void setForVariable(Iterator value);

} // Foreach

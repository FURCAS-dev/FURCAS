/**
 * <copyright>
 * </copyright>
 *
 * $Id: All.java,v 1.1 2011/02/07 17:21:36 auhl Exp $
 */
package persistence.expressions;

import data.classes.SapClass;

import dataaccess.expressions.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>All</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link persistence.expressions.All#getSnapshot <em>Snapshot</em>}</li>
 *   <li>{@link persistence.expressions.All#getOfClass <em>Of Class</em>}</li>
 *   <li>{@link persistence.expressions.All#getSnapshotIdentifier <em>Snapshot Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see persistence.expressions.ExpressionsPackage#getAll()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL MustBeEntityClass='not self.ofClass.valueType' ExpressionMustBeSnapshotOrTimePoint='if self.snapshot = SnapshotSelection::SPECIFIED then\r\n    self.snapshotIdentifier.getType().upperMultiplicity = 1 and\r\n    self.snapshotIdentifier.getType().oclIsKindOf(data::classes::ClassTypeDefinition) and\r\n   Set{\'Snapshot\', \'TimePoint\'}->includes(self.snapshotIdentifier.getType().oclAsType(data::classes::ClassTypeDefinition).clazz.name)\r\n  else\r\n    true\r\n  endif'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='MustBeEntityClass ExpressionMustBeSnapshotOrTimePoint'"
 * @generated
 */
public interface All extends Expression {
	/**
     * Returns the value of the '<em><b>Snapshot</b></em>' attribute.
     * The literals are from the enumeration {@link persistence.expressions.SnapshotSelection}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * A selector for the snapshot to read. If DEFAULT, the entities will be read from the current session's default snapshot. If ALL is specified, all copies of instances in all snapshots is returned. If DATE, the lastSnapshotBeforeIsoTimestamp has to be set and all snapshots before that date are selected for which no successor exists that still lies before the timestamp specified. This means that the entity will be returned from all snapshots on concurrent branches that existed at the given point in time.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Snapshot</em>' attribute.
     * @see persistence.expressions.SnapshotSelection
     * @see #setSnapshot(SnapshotSelection)
     * @see persistence.expressions.ExpressionsPackage#getAll_Snapshot()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	SnapshotSelection getSnapshot();

	/**
     * Sets the value of the '{@link persistence.expressions.All#getSnapshot <em>Snapshot</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Snapshot</em>' attribute.
     * @see persistence.expressions.SnapshotSelection
     * @see #getSnapshot()
     * @generated
     */
	void setSnapshot(SnapshotSelection value);

	/**
     * Returns the value of the '<em><b>Of Class</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Of Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Of Class</em>' reference.
     * @see #setOfClass(SapClass)
     * @see persistence.expressions.ExpressionsPackage#getAll_OfClass()
     * @model required="true"
     * @generated
     */
	SapClass getOfClass();

	/**
     * Sets the value of the '{@link persistence.expressions.All#getOfClass <em>Of Class</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Of Class</em>' reference.
     * @see #getOfClass()
     * @generated
     */
	void setOfClass(SapClass value);

	/**
     * Returns the value of the '<em><b>Snapshot Identifier</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link dataaccess.expressions.Expression#getAll <em>All</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Snapshot Identifier</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Snapshot Identifier</em>' containment reference.
     * @see #setSnapshotIdentifier(Expression)
     * @see persistence.expressions.ExpressionsPackage#getAll_SnapshotIdentifier()
     * @see dataaccess.expressions.Expression#getAll
     * @model opposite="all" containment="true" resolveProxies="true"
     * @generated
     */
	Expression getSnapshotIdentifier();

	/**
     * Sets the value of the '{@link persistence.expressions.All#getSnapshotIdentifier <em>Snapshot Identifier</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Snapshot Identifier</em>' containment reference.
     * @see #getSnapshotIdentifier()
     * @generated
     */
	void setSnapshotIdentifier(Expression value);

} // All

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package persistence.expressions;

import dataaccess.expressions.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Commit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Returns the Snapshot produced
 * <!-- end-model-doc -->
 *
 *
 * @see persistence.expressions.ExpressionsPackage#getCommit()
 * @model annotation="http://de.hpi.sam.bp2009.OCL ReturnsSnapshot='self.getType().oclIsKindOf(ClassTypeDefinition) and\n  self.getType().oclAsType(ClassTypeDefinition).clazz.name = \'Snapshot\''"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ReturnsSnapshot'"
 * @generated
 */
public interface Commit extends Expression {
} // Commit

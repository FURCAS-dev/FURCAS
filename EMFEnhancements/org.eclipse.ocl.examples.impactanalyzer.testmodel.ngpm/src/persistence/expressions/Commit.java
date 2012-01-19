/**
 * <copyright>
 * </copyright>
 *
 * $Id: Commit.java,v 1.1 2011/02/07 17:21:36 auhl Exp $
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
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL ReturnsSnapshot='self.getType().oclIsKindOf(data::classes::ClassTypeDefinition) and\r\n  self.getType().oclAsType(data::classes::ClassTypeDefinition).clazz.name = \'Snapshot\''"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ReturnsSnapshot'"
 * @generated
 */
public interface Commit extends Expression {
} // Commit

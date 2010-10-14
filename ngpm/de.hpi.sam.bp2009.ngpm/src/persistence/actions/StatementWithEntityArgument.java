/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package persistence.actions;

import behavioral.actions.StatementWithArgument;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Statement With Entity Argument</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see persistence.actions.ActionsPackage#getStatementWithEntityArgument()
 * @model annotation="http://de.hpi.sam.bp2009.OCL CanStoreOnlyEntities='if self.argument.getType().oclIsKindOf(data::classes::ClassTypeDefinition) then\r\n    not self.argument.getType().oclAsType(data::classes::ClassTypeDefinition).clazz.valueType\r\n  else\r\n    false\r\n  endif'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='CanStoreOnlyEntities'"
 * @generated
 */
public interface StatementWithEntityArgument extends StatementWithArgument {
} // StatementWithEntityArgument

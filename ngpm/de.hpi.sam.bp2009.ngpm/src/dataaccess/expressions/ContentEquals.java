/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Content Equals</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Compares two entity objects by the content of those associations marked as equality relevant for the entity.
 * <!-- end-model-doc -->
 *
 *
 * @see dataaccess.expressions.ExpressionsPackage#getContentEquals()
 * @model annotation="http://de.hpi.sam.bp2009.OCL ContentEqualsOnlyForEntities='self.left.getType().getInnermost().oclIsKindOf(data::classes::ClassTypeDefinition) and\r\n  self.right.getType().getInnermost().oclIsKindOf(data::classes::ClassTypeDefinition) and\r\n  not self.left.getType().getInnermost().oclAsType(data::classes::ClassTypeDefinition).clazz.valueType and\r\n  not self.right.getType().getInnermost().oclAsType(data::classes::ClassTypeDefinition).clazz.valueType'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ContentEqualsOnlyForEntities'"
 * @generated
 */
public interface ContentEquals extends Equals {
} // ContentEquals

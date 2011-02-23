/**
 * <copyright>
 * </copyright>
 *
 * $Id: LinkTraversal.java,v 1.1 2011/02/07 17:18:46 auhl Exp $
 */
package data.classes;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Traversal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Navigates an association starting on the source object on which the implementation is invoked and navigating to the *end* specified.
 * <!-- end-model-doc -->
 *
 *
 * @see data.classes.ClassesPackage#getLinkTraversal()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL OutputTypeMatchEndType='self.implements_.input->isEmpty() and\r\n  self.implements_.output.oclIsKindOf(ClassTypeDefinition) and \r\n  self.implements_.output.oclAsType(ClassTypeDefinition).clazz = self.end.type.clazz' MustBeNavigable='self.end.navigable'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='OutputTypeMatchEndType MustBeNavigable'"
 * @generated
 */
public interface LinkTraversal extends AssociationEndSignatureImplementation {
} // LinkTraversal

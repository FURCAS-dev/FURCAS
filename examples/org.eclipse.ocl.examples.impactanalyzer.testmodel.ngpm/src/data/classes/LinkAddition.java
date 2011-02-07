/**
 * <copyright>
 * </copyright>
 *
 * $Id: LinkAddition.java,v 1.1 2011/02/07 16:49:09 auhl Exp $
 */
package data.classes;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Addition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Adds a link to the association of which *end* is one end, such that the object on which the implementation is invoked is on the other end, and the parameters passed to this implementation are in the role denoted by *end*.
 * <!-- end-model-doc -->
 *
 *
 * @see data.classes.ClassesPackage#getLinkAddition()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL AdditionInputTypeMatchEndType='self.implements_.output->isEmpty() and\r\n  self.implements_.input->size() = 1 and \r\n  self.implements_.input->at(1).getType().oclIsKindOf(ClassTypeDefinition) and \r\n  self.implements_.input->at(1).getType().oclAsType(ClassTypeDefinition).clazz = self.end.type.clazz'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='AdditionInputTypeMatchEndType'"
 * @generated
 */
public interface LinkAddition extends LinkManipulationAtPosition {
} // LinkAddition

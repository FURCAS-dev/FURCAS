/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.classes;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Removal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Removes all links from the object on which the implementation is invoked to those objects passed as parameters where the parameter objects are in the role denoted by *end*.
 * <!-- end-model-doc -->
 *
 *
 * @see data.classes.ClassesPackage#getLinkRemoval()
 * @model annotation="http://de.hpi.sam.bp2009.OCL RemovalTypeMatchEndType='self.implements_.output->isEmpty() and\r\n  self.implements_.input->size() = 1 and \r\n  self.implements_.input->at(1).getType().oclIsKindOf(ClassTypeDefinition) and \r\n  self.implements_.input->at(1).getType().oclAsType(ClassTypeDefinition).clazz = self.end.type.clazz'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='RemovalTypeMatchEndType'"
 * @generated
 */
public interface LinkRemoval extends LinkManipulationAtPosition {
} // LinkRemoval

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.actions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Add Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Adds a link to an association. As opposed to, e.g., MOF 1.4 semantics, if a link would violate an upper multiplicity of 1 by adding a second link to an object, the existing link will implicitly be replaced by this AddLink statement.
 * 
 * When *at* is unspecified for an ordered association, the link will be added at the "end."
 * <!-- end-model-doc -->
 *
 *
 * @see behavioral.actions.ActionsPackage#getAddLink()
 * @model
 * @generated
 */
public interface AddLink extends LinkManipulationStatement {
} // AddLink

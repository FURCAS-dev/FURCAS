/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.actions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Single Block Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Constrains the number of blocks that this statement can own to 1.
 * <!-- end-model-doc -->
 *
 *
 * @see behavioral.actions.ActionsPackage#getSingleBlockStatement()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL OwnsExactlyOneBlock='self.nestedBlocks->size() = 1'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='OwnsExactlyOneBlock'"
 * @generated
 */
public interface SingleBlockStatement extends StatementWithNestedBlocks {
} // SingleBlockStatement

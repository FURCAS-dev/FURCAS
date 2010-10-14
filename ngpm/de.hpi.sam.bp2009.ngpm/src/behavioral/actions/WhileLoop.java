/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.actions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>While Loop</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see behavioral.actions.ActionsPackage#getWhileLoop()
 * @model
 * @generated
 */
public interface WhileLoop extends ConditionalStatement, SingleBlockStatement {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model kind="operation" unique="false" required="true" ordered="false"
     *        annotation="http://de.hpi.sam.bp2009.OCL body='self.nestedBlocks->at(1)'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	Block getLoopBody();

} // WhileLoop

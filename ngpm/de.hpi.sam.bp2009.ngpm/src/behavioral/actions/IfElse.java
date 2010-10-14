/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.actions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Else</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see behavioral.actions.ActionsPackage#getIfElse()
 * @model
 * @generated
 */
public interface IfElse extends ConditionalStatement, StatementWithNestedBlocks {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model kind="operation" unique="false" required="true" ordered="false"
     *        annotation="http://de.hpi.sam.bp2009.OCL body='self.nestedBlocks->at(1)'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	Block getIfBlock();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model kind="operation" unique="false" required="true" ordered="false"
     *        annotation="http://de.hpi.sam.bp2009.OCL body='if self.nestedBlocks->size() > 1 then\n    self.nestedBlocks->at(2)\n  else\n    null\n  endif'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	Block getElseBlock();

} // IfElse

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.actions;

import data.classes.FunctionSignatureImplementation;
import data.classes.InScope;
import data.classes.NamedValue;
import data.classes.SapClass;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A block contains statements and provides a scope, e.g., for block-local variables. Such a scope can be used for mapping to and from an operation's signature. A block accepts a number of values for a set of variables and as such is parameterizable. Additional variables can be introduced in the block that will not be provided to the block by its surrounding context. Those are considered the block's "local variables."
 * 
 * A block can be executed like in SmallTalk, dynamically binding its arguments at runtime.
 * 
 * With this, an operation is only a very thin wrapper around a Block.
 * 
 * The parameters of a block are always defined by the signature that is implemented by the block.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavioral.actions.Block#getStatements <em>Statements</em>}</li>
 *   <li>{@link behavioral.actions.Block#getVariables <em>Variables</em>}</li>
 *   <li>{@link behavioral.actions.Block#getOwningStatement <em>Owning Statement</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavioral.actions.ActionsPackage#getBlock()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL DoesNotOwnIterators='self.variables->select(i|i.oclIsKindOf(Iterator))->isEmpty()' IsSideEffectFreeIfImplementsSideEffectFreeSignature='self.implements_->notEmpty() implies\r\n    (self.implements_.sideEffectFree implies self.isSideEffectFree())' DistinctNamedValueNames='self.variables->forAll( i, j | i <> j implies i.name <> j.name )'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='DoesNotOwnIterators IsSideEffectFreeIfImplementsSideEffectFreeSignature DistinctNamedValueNames'"
 * @generated
 */
public interface Block extends FunctionSignatureImplementation, InScope {
	/**
     * Returns the value of the '<em><b>Statements</b></em>' containment reference list.
     * The list contents are of type {@link behavioral.actions.Statement}.
     * It is bidirectional and its opposite is '{@link behavioral.actions.Statement#getBlock <em>Block</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Statements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Statements</em>' containment reference list.
     * @see behavioral.actions.ActionsPackage#getBlock_Statements()
     * @see behavioral.actions.Statement#getBlock
     * @model opposite="block" containment="true" resolveProxies="true"
     * @generated
     */
	EList<Statement> getStatements();

	/**
     * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
     * The list contents are of type {@link data.classes.NamedValue}.
     * It is bidirectional and its opposite is '{@link data.classes.NamedValue#getOwner <em>Owner</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Variables</em>' containment reference list.
     * @see behavioral.actions.ActionsPackage#getBlock_Variables()
     * @see data.classes.NamedValue#getOwner
     * @model opposite="owner" containment="true" resolveProxies="true"
     * @generated
     */
	EList<NamedValue> getVariables();

	/**
     * Returns the value of the '<em><b>Owning Statement</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link behavioral.actions.StatementWithNestedBlocks#getNestedBlocks <em>Nested Blocks</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Statement</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Owning Statement</em>' container reference.
     * @see #setOwningStatement(StatementWithNestedBlocks)
     * @see behavioral.actions.ActionsPackage#getBlock_OwningStatement()
     * @see behavioral.actions.StatementWithNestedBlocks#getNestedBlocks
     * @model opposite="nestedBlocks"
     * @generated
     */
	StatementWithNestedBlocks getOwningStatement();

	/**
     * Sets the value of the '{@link behavioral.actions.Block#getOwningStatement <em>Owning Statement</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Owning Statement</em>' container reference.
     * @see #getOwningStatement()
     * @generated
     */
	void setOwningStatement(StatementWithNestedBlocks value);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Walks up the owningStatement/nestedBlocks association to find owning statements and their owning blocks transitively until it arrives at a block that is not owned by a statement. That block is then returned. Usually, such a block would be the implementation of either a function or a method signature.
     * <!-- end-model-doc -->
     * @model kind="operation" unique="false" required="true" ordered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if self.owningStatement->notEmpty() then\n    self.owningStatement.block.getOutermostBlock()\n  else\n    self\n  endif'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	Block getOutermostBlock();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model unique="false" required="true" ordered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.statements->forAll(s|s.isSideEffectFreeForBlock(self))'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	boolean localIsSideEffectFree();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Determines all NamedValues that are in scope for all statements of this block. For example, in the block of a Foreach statement, the Foreach Iterator is in scope for all contained statements. If the block is nested in a statement (such as for an "if" statement), the NamedValues in scope for the containing statement are added as well. Additionally, if the block occurs as a signature implementation, the signature parameters are added. If this block occurs in an object-parameterized class, the formal object parameters are also added.
     * 
     * 
     * <!-- end-model-doc -->
     * @model kind="operation" ordered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.addNamedValuesWithNewNames(\n  -- Handle Foreach\n  let s:Set(data::classes::NamedValue)=Set{} in\n  s->union(if owningStatement.oclIsKindOf(Foreach) then\n    owningStatement.oclAsType(Foreach).forVariable->asSet()\n  else\n    Set{}\n  endif)->union(\n  -- add parameters for those blocks that are used as a signature implementation\n  functionSignature.input->asSet()\n  )->union(\n  implements_.input->asSet()\n  ),\n  -- then ascend the block composition hierarchy and add all NamedValues defined in parent blocks before the occurrence of the statement with the nested block\n  if owningStatement->notEmpty() then\n    owningStatement.getNamedValuesInScope()\n  else\n    -- add formal object parameters from owning class\n    let oc:data::classes::SapClass = self.getOwningClass() in\n    if oc->notEmpty() then\n      oc.formalObjectParameters->asSet()\n    else\n      Set{}\n    endif\n  endif)'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	EList<NamedValue> getNamedValuesInScope();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model kind="operation" unique="false" ordered="false"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='let outermost:Block = self.getOutermostBlock() in\n  let implementedSignature:data::classes::Signature = outermost.getImplementedSignature() in\n  if implementedSignature->notEmpty() then\n    implementedSignature.getOwningClass()\n  else\n    null\n  endif'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	SapClass getOwningClass();

} // Block

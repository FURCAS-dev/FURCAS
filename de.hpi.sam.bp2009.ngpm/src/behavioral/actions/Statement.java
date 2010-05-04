/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.actions;

import data.classes.InScope;
import data.classes.NamedValue;
import data.classes.SapClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavioral.actions.Statement#getBlock <em>Block</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavioral.actions.ActionsPackage#getStatement()
 * @model abstract="true"
 * @generated
 */
public interface Statement extends InScope
{
  /**
   * Returns the value of the '<em><b>Block</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link behavioral.actions.Block#getStatements <em>Statements</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Block</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Block</em>' container reference.
   * @see #setBlock(Block)
   * @see behavioral.actions.ActionsPackage#getStatement_Block()
   * @see behavioral.actions.Block#getStatements
   * @model opposite="statements" required="true"
   * @generated
   */
  Block getBlock();

  /**
   * Sets the value of the '{@link behavioral.actions.Statement#getBlock <em>Block</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Block</em>' container reference.
   * @see #getBlock()
   * @generated
   */
  void setBlock(Block value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://de.hpi.sam.bp2009.OCL body='self.block.getOutermostBlock()'"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
   * @generated
   */
  Block getOutermostBlock();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * A statement is said to be side effect free if it does not modify any variable declared outside the scope of the block owning the statement and if it does not modify any object's state and if it does not modify any association's link set.
   * 
   * TODO We need a more context-sensitive definition of sideEffectFree. While assigning to a local variable disallows statement reordering within the block, the block can still overall be side effect free such that its invocation may be reordered. There seem to be at least two notions of side effect freeness: one within the block in which it occurs (and variable assignment in this context counts as a side effect because it will disallow reordering), and another one regarding side effects observable outside the block; those are all modifications that can "escape" from the block, including changing the state of an object that is reachable outside the block (even if created in the block but then returned from the block), or changing the contents of a link container visible outside the block.
   * <!-- end-model-doc -->
   * @model kind="operation" dataType="primitivetypes.Boolean"
   *        annotation="http://de.hpi.sam.bp2009.OCL body='not self.oclIsKindOf(AddLink) and  not self.oclIsKindOf(RemoveLink) and  not self.oclIsKindOf(Assignment) and  (self.oclIsKindOf(IfElse) implies self.oclAsType(IfElse).condition.isSideEffectFree()) and  (self.oclIsKindOf(WhileLoop) implies self.oclAsType(WhileLoop).condition.isSideEffectFree()) and  (self.oclIsKindOf(ExpressionStatement) implies self.oclAsType(ExpressionStatement).expression.isSideEffectFree()) and  (self.oclIsKindOf(StatementWithArgument) implies (self.oclAsType(StatementWithArgument).argument->notEmpty() implies self.oclAsType(StatementWithArgument).argument.isSideEffectFree())) and  (self.oclIsKindOf(StatementWithNestedBlocks) implies self.oclAsType(StatementWithNestedBlocks).nestedBlocks->forAll(b|b.isSideEffectFree()))'"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
   * @generated
   */
  boolean isSideEffectFree();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Assignment statements to block-local variables do not imply a side effect w.r.t the block
   * <!-- end-model-doc -->
   * @model dataType="primitivetypes.Boolean"
   *        annotation="http://de.hpi.sam.bp2009.OCL body='not self.oclIsKindOf(AddLink) and  not self.oclIsKindOf(RemoveLink) and  (self.oclIsKindOf(Assignment) implies self.oclAsType(Assignment).assignTo.owner <> block) and  (self.oclIsKindOf(IfElse) implies self.oclAsType(IfElse).condition.isSideEffectFree()) and  (self.oclIsKindOf(WhileLoop) implies self.oclAsType(WhileLoop).condition.isSideEffectFree()) and  (self.oclIsKindOf(ExpressionStatement) implies self.oclAsType(ExpressionStatement).expression.isSideEffectFree()) and  (self.oclIsKindOf(StatementWithArgument) implies (self.oclAsType(StatementWithArgument).argument->notEmpty() implies self.oclAsType(StatementWithArgument).argument.isSideEffectFree())) and  (self.oclIsKindOf(StatementWithNestedBlocks) implies self.oclAsType(StatementWithNestedBlocks).nestedBlocks->forAll(b|b.isSideEffectFree()))'"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
   * @generated
   */
  boolean isSideEffectFreeForBlock(Block block);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://de.hpi.sam.bp2009.OCL body='-- collect all NamedValue declarations introduced by statements in this statement\'s owning block, prior to this statement.  let pos = self.block.statements->indexOf(self) in  if pos > 1 then    self.addNamedValuesWithNewNames(    if self.block.statements->at(-1+pos).oclIsKindOf(NamedValueDeclaration) then      self.block.statements->at(-1+pos).oclAsType(NamedValueDeclaration).namedValue->asSet()    else      Set{}    endif,    self.block.statements->at(-1+pos).getNamedValuesInScope())  else    -- first statement in block; consider block itself    self.block.getNamedValuesInScope()  endif'"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
   * @generated
   */
  NamedValue getNamedValuesInScope();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://de.hpi.sam.bp2009.OCL body='self.block.getOwningClass()'"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
   * @generated
   */
  SapClass getOwningClass();

} // Statement

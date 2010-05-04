/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.classes;

import behavioral.actions.Block;

import modelmanagement.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A value that can be used by name in the scope of a Block. Specializations are, e.g., Constant and Variable. Specializations may have different rules for initialization expressions.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link data.classes.NamedValue#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @see data.classes.ClassesPackage#getNamedValue()
 * @model abstract="true"
 * @generated
 */
public interface NamedValue extends NamedElement, TypedElement
{
  /**
   * Returns the value of the '<em><b>Owner</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link behavioral.actions.Block#getVariables <em>Variables</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owner</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owner</em>' container reference.
   * @see #setOwner(Block)
   * @see data.classes.ClassesPackage#getNamedValue_Owner()
   * @see behavioral.actions.Block#getVariables
   * @model opposite="variables"
   * @generated
   */
  Block getOwner();

  /**
   * Sets the value of the '{@link data.classes.NamedValue#getOwner <em>Owner</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Owner</em>' container reference.
   * @see #getOwner()
   * @generated
   */
  void setOwner(Block value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://de.hpi.sam.bp2009.OCL body='self.owner.getNamedValuesInScope()->union(    if self.oclIsKindOf(Parameter) then      self.oclAsType(Parameter).ownerSignature.getNamedValuesInScope()    else      if self.oclIsKindOf(Iterator) then        self.oclAsType(Iterator).boundToFor.getNamedValuesInScope()->asSet()->union(        self.oclAsType(Iterator).\"iterate\".getNamedValuesInScope()->asSet())      else        if self.oclIsKindOf(Constant) then          self.oclAsType(Constant).\"iterate\".getNamedValuesInScope()        else          Set{}    -- TODO further cases?        endif      endif    endif    )'"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
   * @generated
   */
  NamedValue getNamedValuesInScope();

} // NamedValue

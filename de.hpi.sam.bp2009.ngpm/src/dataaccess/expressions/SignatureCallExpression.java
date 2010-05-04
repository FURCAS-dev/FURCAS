/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.expressions;

import data.classes.Multiplicity;
import data.classes.Signature;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Signature Call Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dataaccess.expressions.SignatureCallExpression#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see dataaccess.expressions.ExpressionsPackage#getSignatureCallExpression()
 * @model abstract="true"
 *        annotation="http://de.hpi.sam.bp2009.OCL ParametersTypesMustMatchSignatureParametersTypes='let numberOfMandatoryParameters =\r\n    self.getSignature().input->select(p|p.defaultValue->isEmpty())->size()\r\n  in\r\n  self.parameters->size() >= numberOfMandatoryParameters and\r\n  self.parameters->size() <= self.getSignature().input->size() and\r\n  self.parameters->forAll(parameter |\r\n    parameter.getType().conformsTo(self.getSignature().input->at(self.parameters->indexOf(parameter)).getType()) )' CallTypeMustMatchSignatureOutput='if self.getSignature().output.oclIsUndefined() then\r\n        self.getType().oclIsUndefined()\r\n    else \r\n        if self.getMultiplicityOfCallTarget().isMany() and self.getSignature().output.isMany() then\r\n            let ntd = self.getType().oclAsType(NestedTypeDefinition) in\r\n                self.getType().oclIsKindOf(NestedTypeDefinition) and \r\n                ntd.unique = false and\r\n                ntd.ordered = self.getMultiplicityOfCallTarget().ordered and\r\n                ntd.lowerMultiplicity = self.getMultiplicityOfCallTarget().lowerMultiplicity and\r\n                ntd.upperMultiplicity = self.getMultiplicityOfCallTarget().upperMultiplicity and\r\n                self.getSignature().output.conformsTo(ntd.type)\r\n        else\r\n            let target = self.getMultiplicityOfCallTarget() in let output = self.getSignature().output in \r\n                ( output.isMany() implies self.getType().unique = output.unique ) and\r\n                ( ( output.isMany() or target.isMany() ) implies ( self.getType().ordered = (output.ordered or target.ordered) ) ) and\r\n                ( self.getType().lowerMultiplicity = (output.lowerMultiplicity * target.lowerMultiplicity)) and\r\n                ( self.getType().upperMultiplicity = (if output.isMany() or target.isMany() then \r\n                                                        -1 \r\n                                                    else \r\n                                                        output.upperMultiplicity * target.upperMultiplicity \r\n                                                    endif)) and\r\n                self.getType().conformsToIgnoringMultiplicity(output)\r\n        endif\r\n    endif'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ParametersTypesMustMatchSignatureParametersTypes CallTypeMustMatchSignatureOutput'"
 * @generated
 */
public interface SignatureCallExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
   * The list contents are of type {@link dataaccess.expressions.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameters</em>' containment reference list.
   * @see dataaccess.expressions.ExpressionsPackage#getSignatureCallExpression_Parameters()
   * @model containment="true"
   *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='usedAsArgumentInSignatureCall'"
   * @generated
   */
  EList<Expression> getParameters();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * For FunctionCallExpression, this retrieves the signature from the type of the calledBlock expression which is required to be a FunctionSignatureTypeDefinition. For MethodCallExpression, it obtains the signature by navigating to the methodSignature role.
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://de.hpi.sam.bp2009.OCL body='if self.oclIsKindOf(FunctionCallExpression) then    self.oclAsType(FunctionCallExpression).calledBlock.getType().getInnermost().oclAsType(FunctionSignatureTypeDefinition).signature  else    self.oclAsType(MethodCallExpression).methodSignature  endif'"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
   * @generated
   */
  Signature getSignature();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://de.hpi.sam.bp2009.OCL body='if self.oclIsKindOf(FunctionCallExpression) then      self.oclAsType(FunctionCallExpression).calledBlock.getType()  else      self.oclAsType(MethodCallExpression).object.getType()  endif'"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
   * @generated
   */
  Multiplicity getMultiplicityOfCallTarget();

} // SignatureCallExpression

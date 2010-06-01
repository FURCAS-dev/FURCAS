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
 *        annotation="http://de.hpi.sam.bp2009.OCL ParametersTypesMustMatchSignatureParametersTypes='let numberOfMandatoryParameters:Integer =\n    self.getSignature().input->select(p|p.defaultValue->isEmpty())->size()\n  in\n  self.parameters->size() >= numberOfMandatoryParameters and\n  self.parameters->size() <= self.getSignature().input->size() and\n  self.parameters->forAll(parameter |\n    parameter.getType().conformsTo(self.getSignature().input->at(self.parameters->indexOf(parameter)).getType()) )' CallTypeMustMatchSignatureOutput='if self.getSignature().output.oclIsUndefined() then\n        self.getType().oclIsUndefined()\n    else \n        if self.getMultiplicityOfCallTarget().isMany() and self.getSignature().output.isMany() then\n            let ntd:NestedTypeDefinition = self.getType().oclAsType(NestedTypeDefinition) in\n                self.getType().oclIsKindOf(NestedTypeDefinition) and \n                ntd.unique = false and\n                ntd.ordered = self.getMultiplicityOfCallTarget().ordered and\n                ntd.lowerMultiplicity = self.getMultiplicityOfCallTarget().lowerMultiplicity and\n                ntd.upperMultiplicity = self.getMultiplicityOfCallTarget().upperMultiplicity and\n                self.getSignature().output.conformsTo(ntd.type)\n        else\n            let target:Multiplicity = self.getMultiplicityOfCallTarget() in let output:TypeDefinition = self.getSignature().output in \n                ( output.isMany() implies self.getType().unique = output.unique ) and\n                ( ( output.isMany() or target.isMany() ) implies ( self.getType().ordered = (output.ordered or target.ordered) ) ) and\n                ( self.getType().lowerMultiplicity = (output.lowerMultiplicity * target.lowerMultiplicity)) and\n                ( self.getType().upperMultiplicity = (if output.isMany() or target.isMany() then \n                                                        -1 \n                                                    else \n                                                        output.upperMultiplicity * target.upperMultiplicity \n                                                    endif)) and\n                self.getType().conformsToIgnoringMultiplicity(output)\n        endif\n    endif'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ParametersTypesMustMatchSignatureParametersTypes CallTypeMustMatchSignatureOutput'"
 * @generated
 */
public interface SignatureCallExpression extends Expression {
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
	 *        annotation="http://de.hpi.sam.bp2009.OCL body='if self.oclIsKindOf(FunctionCallExpression) then\n    self.oclAsType(FunctionCallExpression).calledBlock.getType().getInnermost().oclAsType(FunctionSignatureTypeDefinition).signature\n  else\n    self.oclAsType(MethodCallExpression).methodSignature\n  endif'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
	 * @generated
	 */
	Signature getSignature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://de.hpi.sam.bp2009.OCL body='if self.oclIsKindOf(FunctionCallExpression) then\n      self.oclAsType(FunctionCallExpression).calledBlock.getType()\n  else\n      self.oclAsType(MethodCallExpression).object.getType()\n  endif'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
	 * @generated
	 */
	Multiplicity getMultiplicityOfCallTarget();

} // SignatureCallExpression

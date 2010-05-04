/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package runtime.primitivetypes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Number</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A number of arbitrary precision. It can be constrained later in qualifying types in order to match, e.g., typical integer precision, or decimals with two decimal digits. Number may also need to capture true fractions or even irrational numbers such as sqrt(2).
 * 
 * Operations on Number instances will be influenced by the precision of the instances involved. Rounding rules may additionally need to be specified.
 * <!-- end-model-doc -->
 *
 *
 * @see runtime.primitivetypes.PrimitivetypesPackage#getNumber()
 * @model
 * @generated
 */
public interface Number extends EObject
{
} // Number

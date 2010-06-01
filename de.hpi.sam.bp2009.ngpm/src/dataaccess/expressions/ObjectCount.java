/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Count</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Computes the Number 1 for single objects, and the number of objects in a multi-valued object otherwise.
 * 
 * Type inference in getType() can be done once TypeDefinition is a value type that can be constructed in OCL.
 * <!-- end-model-doc -->
 *
 *
 * @see dataaccess.expressions.ExpressionsPackage#getObjectCount()
 * @model annotation="http://de.hpi.sam.bp2009.OCL TypeIsNumber='self.getType().oclIsKindOf(ClassTypeDefinition) and\n  self.getType().oclAsType(ClassTypeDefinition).clazz.name = \'Number\'' MultiplicityIsOne='self.getType().upperMultiplicity = 1 and\n  self.getType().lowerMultiplicity = 1'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='TypeIsNumber MultiplicityIsOne'"
 * @generated
 */
public interface ObjectCount extends ObjectBasedExpression {
} // ObjectCount

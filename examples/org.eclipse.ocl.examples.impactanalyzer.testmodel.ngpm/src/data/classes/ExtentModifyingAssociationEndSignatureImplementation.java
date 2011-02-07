/**
 * <copyright>
 * </copyright>
 *
 * $Id: ExtentModifyingAssociationEndSignatureImplementation.java,v 1.1 2011/02/07 16:49:09 auhl Exp $
 */
package data.classes;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extent Modifying Association End Signature Implementation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Abstract base class for all association extent-manipulating signature implementations. Groups all constraints that apply to those.
 * <!-- end-model-doc -->
 *
 *
 * @see data.classes.ClassesPackage#getExtentModifyingAssociationEndSignatureImplementation()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL MustNotModifyExtentIfEqualityRelevantForValueClass='end.association.ends->forAll(ae:AssociationEnd |\r\n    ae.contributesToEquality implies not ae.type.clazz.valueType)' MustNotImplementSideEffectFreeOperation='not self.implements_.sideEffectFree'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='MustNotModifyExtentIfEqualityRelevantForValueClass MustNotImplementSideEffectFreeOperation'"
 * @generated
 */
public interface ExtentModifyingAssociationEndSignatureImplementation extends AssociationEndSignatureImplementation {
} // ExtentModifyingAssociationEndSignatureImplementation

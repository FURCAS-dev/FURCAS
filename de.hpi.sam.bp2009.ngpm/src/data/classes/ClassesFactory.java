/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.classes;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see data.classes.ClassesPackage
 * @generated
 */
public interface ClassesFactory extends EFactory {
	/**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	ClassesFactory eINSTANCE = data.classes.impl.ClassesFactoryImpl.init();

	/**
     * Returns a new object of class '<em>Association</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Association</em>'.
     * @generated
     */
	Association createAssociation();

	/**
     * Returns a new object of class '<em>Association End</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Association End</em>'.
     * @generated
     */
	AssociationEnd createAssociationEnd();

	/**
     * Returns a new object of class '<em>Sap Class</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Sap Class</em>'.
     * @generated
     */
	SapClass createSapClass();

	/**
     * Returns a new object of class '<em>Delegation</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Delegation</em>'.
     * @generated
     */
	Delegation createDelegation();

	/**
     * Returns a new object of class '<em>Context</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Context</em>'.
     * @generated
     */
	Context createContext();

	/**
     * Returns a new object of class '<em>Link Traversal</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Link Traversal</em>'.
     * @generated
     */
	LinkTraversal createLinkTraversal();

	/**
     * Returns a new object of class '<em>Link Addition</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Link Addition</em>'.
     * @generated
     */
	LinkAddition createLinkAddition();

	/**
     * Returns a new object of class '<em>Link Removal</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Link Removal</em>'.
     * @generated
     */
	LinkRemoval createLinkRemoval();

	/**
     * Returns a new object of class '<em>Class Type Definition</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Class Type Definition</em>'.
     * @generated
     */
	ClassTypeDefinition createClassTypeDefinition();

	/**
     * Returns a new object of class '<em>Nested Type Definition</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Nested Type Definition</em>'.
     * @generated
     */
	NestedTypeDefinition createNestedTypeDefinition();

	/**
     * Returns a new object of class '<em>Function Signature Type Definition</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Function Signature Type Definition</em>'.
     * @generated
     */
	FunctionSignatureTypeDefinition createFunctionSignatureTypeDefinition();

	/**
     * Returns a new object of class '<em>Method Signature</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Method Signature</em>'.
     * @generated
     */
	MethodSignature createMethodSignature();

	/**
     * Returns a new object of class '<em>Function Signature</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Function Signature</em>'.
     * @generated
     */
	FunctionSignature createFunctionSignature();

	/**
     * Returns a new object of class '<em>Link Setting</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Link Setting</em>'.
     * @generated
     */
	LinkSetting createLinkSetting();

	/**
     * Returns a new object of class '<em>Type Adapter</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Type Adapter</em>'.
     * @generated
     */
	TypeAdapter createTypeAdapter();

	/**
     * Returns a new object of class '<em>Parameter</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Parameter</em>'.
     * @generated
     */
	Parameter createParameter();

	/**
     * Returns a new object of class '<em>Platform Specific Implementation</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Platform Specific Implementation</em>'.
     * @generated
     */
	PlatformSpecificImplementation createPlatformSpecificImplementation();

	/**
     * Returns a new object of class '<em>Native Impl</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Native Impl</em>'.
     * @generated
     */
	NativeImpl createNativeImpl();

	/**
     * Returns a new object of class '<em>Signature Owner</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Signature Owner</em>'.
     * @generated
     */
	SignatureOwner createSignatureOwner();

	/**
     * Returns a new object of class '<em>Function Signature Implementation</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Function Signature Implementation</em>'.
     * @generated
     */
	FunctionSignatureImplementation createFunctionSignatureImplementation();

	/**
     * Returns a new object of class '<em>Actual Object Parameter</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Actual Object Parameter</em>'.
     * @generated
     */
	ActualObjectParameter createActualObjectParameter();

	/**
     * Returns a new object of class '<em>Converter Between Parametrizations</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Converter Between Parametrizations</em>'.
     * @generated
     */
	ConverterBetweenParametrizations createConverterBetweenParametrizations();

	/**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
	ClassesPackage getClassesPackage();

} //ClassesFactory

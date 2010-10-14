/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package integration.xsd;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see integration.xsd.XsdPackage
 * @generated
 */
public interface XsdFactory extends EFactory {
	/**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	XsdFactory eINSTANCE = integration.xsd.impl.XsdFactoryImpl.init();

	/**
     * Returns a new object of class '<em>Sequence</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Sequence</em>'.
     * @generated
     */
	Sequence createSequence();

	/**
     * Returns a new object of class '<em>Choice</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Choice</em>'.
     * @generated
     */
	Choice createChoice();

	/**
     * Returns a new object of class '<em>Complex Type</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Complex Type</em>'.
     * @generated
     */
	ComplexType createComplexType();

	/**
     * Returns a new object of class '<em>Element Definition</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Element Definition</em>'.
     * @generated
     */
	ElementDefinition createElementDefinition();

	/**
     * Returns a new object of class '<em>Attribute</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Attribute</em>'.
     * @generated
     */
	Attribute createAttribute();

	/**
     * Returns a new object of class '<em>Any</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Any</em>'.
     * @generated
     */
	Any createAny();

	/**
     * Returns a new object of class '<em>Group</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Group</em>'.
     * @generated
     */
	Group createGroup();

	/**
     * Returns a new object of class '<em>Annotation</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Annotation</em>'.
     * @generated
     */
	Annotation createAnnotation();

	/**
     * Returns a new object of class '<em>Notation</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Notation</em>'.
     * @generated
     */
	Notation createNotation();

	/**
     * Returns a new object of class '<em>Simple Type</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Simple Type</em>'.
     * @generated
     */
	SimpleType createSimpleType();

	/**
     * Returns a new object of class '<em>Element Reference</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Element Reference</em>'.
     * @generated
     */
	ElementReference createElementReference();

	/**
     * Returns a new object of class '<em>Simple Content</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Simple Content</em>'.
     * @generated
     */
	SimpleContent createSimpleContent();

	/**
     * Returns a new object of class '<em>Complex Content</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Complex Content</em>'.
     * @generated
     */
	ComplexContent createComplexContent();

	/**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
	XsdPackage getXsdPackage();

} //XsdFactory

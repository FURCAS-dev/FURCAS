/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.classes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Converter Between Parametrizations</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Specifies a method as converter method. This class is mostly used as a constraint container for such a construct.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link data.classes.ConverterBetweenParametrizations#getClazz <em>Clazz</em>}</li>
 *   <li>{@link data.classes.ConverterBetweenParametrizations#getConversionMethod <em>Conversion Method</em>}</li>
 * </ul>
 * </p>
 *
 * @see data.classes.ClassesPackage#getConverterBetweenParametrizations()
 * @model annotation="http://de.hpi.sam.bp2009.OCL MustHaveConcreteMethod='not self.conversionMethod.isAbstract()' FormalObjectParametersConformToMethodParameters='self.conversionMethod.input->size() = self.clazz.formalObjectParameters->size() and\r\n  Sequence{1..self.conversionMethod.input->size()}->forAll(i |\r\n    self.clazz.formalObjectParameters->at(i).conformsTo(self.conversionMethod.input->at(i)))'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='MustHaveConcreteMethod FormalObjectParametersConformToMethodParameters'"
 * @generated
 */
public interface ConverterBetweenParametrizations extends EObject {
	/**
     * Returns the value of the '<em><b>Clazz</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link data.classes.SapClass#getConverterBetweenParametrizations <em>Converter Between Parametrizations</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clazz</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Clazz</em>' container reference.
     * @see #setClazz(SapClass)
     * @see data.classes.ClassesPackage#getConverterBetweenParametrizations_Clazz()
     * @see data.classes.SapClass#getConverterBetweenParametrizations
     * @model opposite="converterBetweenParametrizations" required="true"
     * @generated
     */
	SapClass getClazz();

	/**
     * Sets the value of the '{@link data.classes.ConverterBetweenParametrizations#getClazz <em>Clazz</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Clazz</em>' container reference.
     * @see #getClazz()
     * @generated
     */
	void setClazz(SapClass value);

	/**
     * Returns the value of the '<em><b>Conversion Method</b></em>' reference.
     * It is bidirectional and its opposite is '{@link data.classes.MethodSignature#getConverter <em>Converter</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conversion Method</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Conversion Method</em>' reference.
     * @see #setConversionMethod(MethodSignature)
     * @see data.classes.ClassesPackage#getConverterBetweenParametrizations_ConversionMethod()
     * @see data.classes.MethodSignature#getConverter
     * @model opposite="converter" required="true"
     * @generated
     */
	MethodSignature getConversionMethod();

	/**
     * Sets the value of the '{@link data.classes.ConverterBetweenParametrizations#getConversionMethod <em>Conversion Method</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Conversion Method</em>' reference.
     * @see #getConversionMethod()
     * @generated
     */
	void setConversionMethod(MethodSignature value);

} // ConverterBetweenParametrizations

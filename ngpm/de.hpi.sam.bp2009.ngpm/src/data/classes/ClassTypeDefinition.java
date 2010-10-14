/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.classes;

import dataaccess.expressions.Expression;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Type Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link data.classes.ClassTypeDefinition#getClazz <em>Clazz</em>}</li>
 *   <li>{@link data.classes.ClassTypeDefinition#getAssociationEnd <em>Association End</em>}</li>
 *   <li>{@link data.classes.ClassTypeDefinition#getObjectParameters <em>Object Parameters</em>}</li>
 *   <li>{@link data.classes.ClassTypeDefinition#getOwnedObjectParameters <em>Owned Object Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see data.classes.ClassesPackage#getClassTypeDefinition()
 * @model annotation="http://de.hpi.sam.bp2009.OCL ActualObjectsParametersMatchSignature='let numberOfMandatoryParameters:Integer =\r\n    self.clazz.formalObjectParameters->select(p|p.defaultValue->isEmpty())->size()\r\n  in\r\n  self.objectParameters->size() >= numberOfMandatoryParameters and\r\n  self.objectParameters->size() <= self.clazz.formalObjectParameters->size() and\r\n  Sequence{1..self.objectParameters->size()}->forAll(i:Integer|\r\n    self.objectParameters->at(i).formalObjectParameter =\r\n    self.clazz.formalObjectParameters->at(i))'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ActualObjectsParametersMatchSignature'"
 * @generated
 */
public interface ClassTypeDefinition extends TypeDefinition {
	/**
     * Returns the value of the '<em><b>Clazz</b></em>' reference.
     * It is bidirectional and its opposite is '{@link data.classes.SapClass#getElementsOfType <em>Elements Of Type</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clazz</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Clazz</em>' reference.
     * @see #setClazz(SapClass)
     * @see data.classes.ClassesPackage#getClassTypeDefinition_Clazz()
     * @see data.classes.SapClass#getElementsOfType
     * @model opposite="elementsOfType" required="true"
     * @generated
     */
	SapClass getClazz();

	/**
     * Sets the value of the '{@link data.classes.ClassTypeDefinition#getClazz <em>Clazz</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Clazz</em>' reference.
     * @see #getClazz()
     * @generated
     */
	void setClazz(SapClass value);

	/**
     * Returns the value of the '<em><b>Association End</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link data.classes.AssociationEnd#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Association End</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Association End</em>' container reference.
     * @see #setAssociationEnd(AssociationEnd)
     * @see data.classes.ClassesPackage#getClassTypeDefinition_AssociationEnd()
     * @see data.classes.AssociationEnd#getType
     * @model opposite="type"
     * @generated
     */
	AssociationEnd getAssociationEnd();

	/**
     * Sets the value of the '{@link data.classes.ClassTypeDefinition#getAssociationEnd <em>Association End</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Association End</em>' container reference.
     * @see #getAssociationEnd()
     * @generated
     */
	void setAssociationEnd(AssociationEnd value);

	/**
     * Returns the value of the '<em><b>Object Parameters</b></em>' reference list.
     * The list contents are of type {@link data.classes.ActualObjectParameter}.
     * It is bidirectional and its opposite is '{@link data.classes.ActualObjectParameter#getClassTypeDefinitions <em>Class Type Definitions</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object Parameters</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Object Parameters</em>' reference list.
     * @see data.classes.ClassesPackage#getClassTypeDefinition_ObjectParameters()
     * @see data.classes.ActualObjectParameter#getClassTypeDefinitions
     * @model opposite="classTypeDefinitions"
     * @generated
     */
	EList<ActualObjectParameter> getObjectParameters();

	/**
     * Returns the value of the '<em><b>Owned Object Parameters</b></em>' containment reference list.
     * The list contents are of type {@link data.classes.ActualObjectParameter}.
     * It is bidirectional and its opposite is '{@link data.classes.ActualObjectParameter#getOwningClassTypeDefinition <em>Owning Class Type Definition</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Object Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Owned Object Parameters</em>' containment reference list.
     * @see data.classes.ClassesPackage#getClassTypeDefinition_OwnedObjectParameters()
     * @see data.classes.ActualObjectParameter#getOwningClassTypeDefinition
     * @model opposite="owningClassTypeDefinition" containment="true" resolveProxies="true"
     * @generated
     */
	EList<ActualObjectParameter> getOwnedObjectParameters();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model unique="false" required="true" ordered="false" ctdUnique="false" ctdRequired="true" ctdOrdered="false"
     *        annotation="http://de.hpi.sam.bp2009.OCL body='if self.effectiveObjectParameters()->size()  = ctd.effectiveObjectParameters()->size() then\n    self.clazz.converterBetweenParametrizations->notEmpty() or\n    Sequence{1..self.effectiveObjectParameters()->size()}->forAll(i |\n      self.effectiveObjectParameters()->at(i).evaluatesToEqualAs(ctd.effectiveObjectParameters()->at(i)))\n  else\n    false\n  endif'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	boolean objectParametersConformTo(ClassTypeDefinition ctd);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model unique="false"
     *        annotation="http://de.hpi.sam.bp2009.OCL body='self.objectParameters.value->flatten()->asSequence()->union(\n     Sequence{(self.objectParameters->size()+1)..(self.clazz.formalObjectParameters->size())}->collect(i | \n             self.clazz.formalObjectParameters->at(i).defaultValue->flatten()->asSequence()))->flatten()->asSequence()'"
     *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='body'"
     * @generated
     */
	EList<Expression> effectiveObjectParameters();

} // ClassTypeDefinition

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package usecase;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link usecase.UsecaseDiagram#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see usecase.UsecasePackage#getUsecaseDiagram()
 * @model
 * @generated
 */
public interface UsecaseDiagram extends EObject {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link usecase.Element}.
	 * It is bidirectional and its opposite is '{@link usecase.Element#getDiagram <em>Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see usecase.UsecasePackage#getUsecaseDiagram_Elements()
	 * @see usecase.Element#getDiagram
	 * @model opposite="diagram" containment="true"
	 * @generated
	 */
	EList<Element> getElements();

} // UsecaseDiagram

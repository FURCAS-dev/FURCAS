/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package vortrag;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link vortrag.Person#getAlter <em>Alter</em>}</li>
 *   <li>{@link vortrag.Person#getAutos <em>Autos</em>}</li>
 *   <li>{@link vortrag.Person#getKinder <em>Kinder</em>}</li>
 *   <li>{@link vortrag.Person#getEltern <em>Eltern</em>}</li>
 *   <li>{@link vortrag.Person#getContainer <em>Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see vortrag.VortragPackage#getPerson()
 * @model
 * @generated
 */
public interface Person extends EObject {
	/**
	 * Returns the value of the '<em><b>Alter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alter</em>' attribute.
	 * @see #setAlter(int)
	 * @see vortrag.VortragPackage#getPerson_Alter()
	 * @model
	 * @generated
	 */
	int getAlter();

	/**
	 * Sets the value of the '{@link vortrag.Person#getAlter <em>Alter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alter</em>' attribute.
	 * @see #getAlter()
	 * @generated
	 */
	void setAlter(int value);

	/**
	 * Returns the value of the '<em><b>Autos</b></em>' reference list.
	 * The list contents are of type {@link vortrag.Auto}.
	 * It is bidirectional and its opposite is '{@link vortrag.Auto#getBesitzer <em>Besitzer</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Autos</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Autos</em>' reference list.
	 * @see vortrag.VortragPackage#getPerson_Autos()
	 * @see vortrag.Auto#getBesitzer
	 * @model opposite="besitzer"
	 * @generated
	 */
	EList<Auto> getAutos();

	/**
	 * Returns the value of the '<em><b>Kinder</b></em>' reference list.
	 * The list contents are of type {@link vortrag.Person}.
	 * It is bidirectional and its opposite is '{@link vortrag.Person#getEltern <em>Eltern</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kinder</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kinder</em>' reference list.
	 * @see vortrag.VortragPackage#getPerson_Kinder()
	 * @see vortrag.Person#getEltern
	 * @model opposite="eltern"
	 * @generated
	 */
	EList<Person> getKinder();

	/**
	 * Returns the value of the '<em><b>Eltern</b></em>' reference list.
	 * The list contents are of type {@link vortrag.Person}.
	 * It is bidirectional and its opposite is '{@link vortrag.Person#getKinder <em>Kinder</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Eltern</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Eltern</em>' reference list.
	 * @see vortrag.VortragPackage#getPerson_Eltern()
	 * @see vortrag.Person#getKinder
	 * @model opposite="kinder" lower="2" upper="2"
	 * @generated
	 */
	EList<Person> getEltern();

	/**
	 * Returns the value of the '<em><b>Container</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link vortrag.Container#getPerson <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' container reference.
	 * @see #setContainer(Container)
	 * @see vortrag.VortragPackage#getPerson_Container()
	 * @see vortrag.Container#getPerson
	 * @model opposite="person" transient="false"
	 * @generated
	 */
	Container getContainer();

	/**
	 * Sets the value of the '{@link vortrag.Person#getContainer <em>Container</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' container reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(Container value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Person bekommtKind();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void hatGeburtstag();

} // Person

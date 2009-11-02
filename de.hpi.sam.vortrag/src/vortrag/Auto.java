/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package vortrag;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Auto</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link vortrag.Auto#getKennzeichen <em>Kennzeichen</em>}</li>
 *   <li>{@link vortrag.Auto#getMarke <em>Marke</em>}</li>
 *   <li>{@link vortrag.Auto#getErstzulassung <em>Erstzulassung</em>}</li>
 *   <li>{@link vortrag.Auto#getBaujahr <em>Baujahr</em>}</li>
 *   <li>{@link vortrag.Auto#getBesitzer <em>Besitzer</em>}</li>
 *   <li>{@link vortrag.Auto#getContainer <em>Container</em>}</li>
 *   <li>{@link vortrag.Auto#getEReference0 <em>EReference0</em>}</li>
 * </ul>
 * </p>
 *
 * @see vortrag.VortragPackage#getAuto()
 * @model
 * @generated
 */
public interface Auto extends EObject {
	/**
	 * Returns the value of the '<em><b>Kennzeichen</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kennzeichen</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kennzeichen</em>' attribute.
	 * @see #setKennzeichen(String)
	 * @see vortrag.VortragPackage#getAuto_Kennzeichen()
	 * @model
	 * @generated
	 */
	String getKennzeichen();

	/**
	 * Sets the value of the '{@link vortrag.Auto#getKennzeichen <em>Kennzeichen</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kennzeichen</em>' attribute.
	 * @see #getKennzeichen()
	 * @generated
	 */
	void setKennzeichen(String value);

	/**
	 * Returns the value of the '<em><b>Marke</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Marke</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Marke</em>' attribute.
	 * @see #setMarke(String)
	 * @see vortrag.VortragPackage#getAuto_Marke()
	 * @model
	 * @generated
	 */
	String getMarke();

	/**
	 * Sets the value of the '{@link vortrag.Auto#getMarke <em>Marke</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Marke</em>' attribute.
	 * @see #getMarke()
	 * @generated
	 */
	void setMarke(String value);

	/**
	 * Returns the value of the '<em><b>Erstzulassung</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Erstzulassung</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Erstzulassung</em>' attribute.
	 * @see #setErstzulassung(int)
	 * @see vortrag.VortragPackage#getAuto_Erstzulassung()
	 * @model
	 * @generated
	 */
	int getErstzulassung();

	/**
	 * Sets the value of the '{@link vortrag.Auto#getErstzulassung <em>Erstzulassung</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Erstzulassung</em>' attribute.
	 * @see #getErstzulassung()
	 * @generated
	 */
	void setErstzulassung(int value);

	/**
	 * Returns the value of the '<em><b>Baujahr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Baujahr</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Baujahr</em>' attribute.
	 * @see #setBaujahr(int)
	 * @see vortrag.VortragPackage#getAuto_Baujahr()
	 * @model
	 * @generated
	 */
	int getBaujahr();

	/**
	 * Sets the value of the '{@link vortrag.Auto#getBaujahr <em>Baujahr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Baujahr</em>' attribute.
	 * @see #getBaujahr()
	 * @generated
	 */
	void setBaujahr(int value);

	/**
	 * Returns the value of the '<em><b>Besitzer</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link vortrag.Person#getAutos <em>Autos</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Besitzer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Besitzer</em>' reference.
	 * @see #setBesitzer(Person)
	 * @see vortrag.VortragPackage#getAuto_Besitzer()
	 * @see vortrag.Person#getAutos
	 * @model opposite="autos" required="true"
	 * @generated
	 */
	Person getBesitzer();

	/**
	 * Sets the value of the '{@link vortrag.Auto#getBesitzer <em>Besitzer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Besitzer</em>' reference.
	 * @see #getBesitzer()
	 * @generated
	 */
	void setBesitzer(Person value);

	/**
	 * Returns the value of the '<em><b>Container</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link vortrag.Container#getAuto <em>Auto</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' container reference.
	 * @see #setContainer(Container)
	 * @see vortrag.VortragPackage#getAuto_Container()
	 * @see vortrag.Container#getAuto
	 * @model opposite="auto" transient="false"
	 * @generated
	 */
	Container getContainer();

	/**
	 * Sets the value of the '{@link vortrag.Auto#getContainer <em>Container</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' container reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(Container value);

	/**
	 * Returns the value of the '<em><b>EReference0</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EReference0</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EReference0</em>' reference.
	 * @see #setEReference0(Container)
	 * @see vortrag.VortragPackage#getAuto_EReference0()
	 * @model
	 * @generated
	 */
	Container getEReference0();

	/**
	 * Sets the value of the '{@link vortrag.Auto#getEReference0 <em>EReference0</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EReference0</em>' reference.
	 * @see #getEReference0()
	 * @generated
	 */
	void setEReference0(Container value);

} // Auto

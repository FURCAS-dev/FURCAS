/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package usecase;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Usecase</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link usecase.Usecase#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link usecase.Usecase#getExtend <em>Extend</em>}</li>
 *   <li>{@link usecase.Usecase#getInclude <em>Include</em>}</li>
 *   <li>{@link usecase.Usecase#getID <em>ID</em>}</li>
 * </ul>
 * </p>
 *
 * @see usecase.UsecasePackage#getUsecase()
 * @model
 * @generated
 */
public interface Usecase extends Element {
	/**
	 * Returns the value of the '<em><b>Incoming</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link usecase.Association#getUsecase <em>Usecase</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming</em>' reference.
	 * @see #setIncoming(Association)
	 * @see usecase.UsecasePackage#getUsecase_Incoming()
	 * @see usecase.Association#getUsecase
	 * @model opposite="usecase"
	 * @generated
	 */
	Association getIncoming();

	/**
	 * Sets the value of the '{@link usecase.Usecase#getIncoming <em>Incoming</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Incoming</em>' reference.
	 * @see #getIncoming()
	 * @generated
	 */
	void setIncoming(Association value);

	/**
	 * Returns the value of the '<em><b>Extend</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extend</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extend</em>' reference.
	 * @see #setExtend(Usecase)
	 * @see usecase.UsecasePackage#getUsecase_Extend()
	 * @model
	 * @generated
	 */
	Usecase getExtend();

	/**
	 * Sets the value of the '{@link usecase.Usecase#getExtend <em>Extend</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extend</em>' reference.
	 * @see #getExtend()
	 * @generated
	 */
	void setExtend(Usecase value);

	/**
	 * Returns the value of the '<em><b>Include</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Include</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Include</em>' reference.
	 * @see #setInclude(Usecase)
	 * @see usecase.UsecasePackage#getUsecase_Include()
	 * @model
	 * @generated
	 */
	Usecase getInclude();

	/**
	 * Sets the value of the '{@link usecase.Usecase#getInclude <em>Include</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Include</em>' reference.
	 * @see #getInclude()
	 * @generated
	 */
	void setInclude(Usecase value);

	/**
	 * Returns the value of the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ID</em>' attribute.
	 * @see #setID(int)
	 * @see usecase.UsecasePackage#getUsecase_ID()
	 * @model
	 * @generated
	 */
	int getID();

	/**
	 * Sets the value of the '{@link usecase.Usecase#getID <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ID</em>' attribute.
	 * @see #getID()
	 * @generated
	 */
	void setID(int value);

} // Usecase

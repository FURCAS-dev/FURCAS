/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package TCS;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Symbol</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link TCS.Symbol#getSpaces <em>Spaces</em>}</li>
 * </ul>
 * </p>
 *
 * @see TCS.TCSPackage#getSymbol()
 * @model
 * @generated
 */
public interface Symbol extends Literal {
	/**
	 * Returns the value of the '<em><b>Spaces</b></em>' attribute list.
	 * The list contents are of type {@link TCS.SpaceKind}.
	 * The literals are from the enumeration {@link TCS.SpaceKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Spaces</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Spaces</em>' attribute list.
	 * @see TCS.SpaceKind
	 * @see TCS.TCSPackage#getSymbol_Spaces()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	EList<SpaceKind> getSpaces();

} // Symbol

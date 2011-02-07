/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbapStructureType.java,v 1.1 2011/02/07 17:16:09 auhl Exp $
 */
package abapmapping.abapdictionary;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abap Structure Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link abapmapping.abapdictionary.AbapStructureType#getFields <em>Fields</em>}</li>
 * </ul>
 * </p>
 *
 * @see abapmapping.abapdictionary.AbapdictionaryPackage#getAbapStructureType()
 * @model
 * @generated
 */
public interface AbapStructureType extends AbapType {
	/**
     * Returns the value of the '<em><b>Fields</b></em>' reference list.
     * The list contents are of type {@link abapmapping.abapdictionary.AbapStructureField}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fields</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Fields</em>' reference list.
     * @see abapmapping.abapdictionary.AbapdictionaryPackage#getAbapStructureType_Fields()
     * @model
     * @generated
     */
	EList<AbapStructureField> getFields();

} // AbapStructureType

/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbapStructureTypeImpl.java,v 1.1 2011/02/07 17:16:09 auhl Exp $
 */
package abapmapping.abapdictionary.impl;

import abapmapping.abapdictionary.AbapStructureField;
import abapmapping.abapdictionary.AbapStructureType;
import abapmapping.abapdictionary.AbapdictionaryPackage;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abap Structure Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link abapmapping.abapdictionary.impl.AbapStructureTypeImpl#getFields <em>Fields</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AbapStructureTypeImpl extends AbapTypeImpl implements AbapStructureType {
	/**
     * The cached value of the '{@link #getFields() <em>Fields</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getFields()
     * @generated
     * @ordered
     */
	protected EList<AbapStructureField> fields;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected AbapStructureTypeImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return AbapdictionaryPackage.Literals.ABAP_STRUCTURE_TYPE;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<AbapStructureField> getFields() {
        if (fields == null) {
            fields = new EObjectResolvingEList<AbapStructureField>(AbapStructureField.class, this, AbapdictionaryPackage.ABAP_STRUCTURE_TYPE__FIELDS);
        }
        return fields;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case AbapdictionaryPackage.ABAP_STRUCTURE_TYPE__FIELDS:
                return getFields();
        }
        return super.eGet(featureID, resolve, coreType);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case AbapdictionaryPackage.ABAP_STRUCTURE_TYPE__FIELDS:
                getFields().clear();
                getFields().addAll((Collection<? extends AbapStructureField>)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public void eUnset(int featureID) {
        switch (featureID) {
            case AbapdictionaryPackage.ABAP_STRUCTURE_TYPE__FIELDS:
                getFields().clear();
                return;
        }
        super.eUnset(featureID);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public boolean eIsSet(int featureID) {
        switch (featureID) {
            case AbapdictionaryPackage.ABAP_STRUCTURE_TYPE__FIELDS:
                return fields != null && !fields.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //AbapStructureTypeImpl

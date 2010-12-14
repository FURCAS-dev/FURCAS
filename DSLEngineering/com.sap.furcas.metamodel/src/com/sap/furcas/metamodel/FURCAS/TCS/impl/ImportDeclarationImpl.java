/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.impl;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.ImportDeclaration;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Import Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ImportDeclarationImpl#getConcreteSyntax <em>Concrete Syntax</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ImportDeclarationImpl#isIsPartImport <em>Is Part Import</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ImportDeclarationImpl extends EObjectImpl implements ImportDeclaration {
    /**
	 * The cached value of the '{@link #getConcreteSyntax() <em>Concrete Syntax</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getConcreteSyntax()
	 * @generated
	 * @ordered
	 */
    protected ConcreteSyntax concreteSyntax;

    /**
	 * The default value of the '{@link #isIsPartImport() <em>Is Part Import</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #isIsPartImport()
	 * @generated
	 * @ordered
	 */
    protected static final boolean IS_PART_IMPORT_EDEFAULT = false;

    /**
	 * The cached value of the '{@link #isIsPartImport() <em>Is Part Import</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #isIsPartImport()
	 * @generated
	 * @ordered
	 */
    protected boolean isPartImport = IS_PART_IMPORT_EDEFAULT;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected ImportDeclarationImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return TCSPackage.Literals.IMPORT_DECLARATION;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public ConcreteSyntax getConcreteSyntax() {
		if (concreteSyntax != null && concreteSyntax.eIsProxy()) {
			InternalEObject oldConcreteSyntax = (InternalEObject)concreteSyntax;
			concreteSyntax = (ConcreteSyntax)eResolveProxy(oldConcreteSyntax);
			if (concreteSyntax != oldConcreteSyntax) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TCSPackage.IMPORT_DECLARATION__CONCRETE_SYNTAX, oldConcreteSyntax, concreteSyntax));
			}
		}
		return concreteSyntax;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public ConcreteSyntax basicGetConcreteSyntax() {
		return concreteSyntax;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setConcreteSyntax(ConcreteSyntax newConcreteSyntax) {
		ConcreteSyntax oldConcreteSyntax = concreteSyntax;
		concreteSyntax = newConcreteSyntax;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.IMPORT_DECLARATION__CONCRETE_SYNTAX, oldConcreteSyntax, concreteSyntax));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public boolean isIsPartImport() {
		return isPartImport;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setIsPartImport(boolean newIsPartImport) {
		boolean oldIsPartImport = isPartImport;
		isPartImport = newIsPartImport;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.IMPORT_DECLARATION__IS_PART_IMPORT, oldIsPartImport, isPartImport));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TCSPackage.IMPORT_DECLARATION__CONCRETE_SYNTAX:
				if (resolve) return getConcreteSyntax();
				return basicGetConcreteSyntax();
			case TCSPackage.IMPORT_DECLARATION__IS_PART_IMPORT:
				return isIsPartImport();
		}
		return super.eGet(featureID, resolve, coreType);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TCSPackage.IMPORT_DECLARATION__CONCRETE_SYNTAX:
				setConcreteSyntax((ConcreteSyntax)newValue);
				return;
			case TCSPackage.IMPORT_DECLARATION__IS_PART_IMPORT:
				setIsPartImport((Boolean)newValue);
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
			case TCSPackage.IMPORT_DECLARATION__CONCRETE_SYNTAX:
				setConcreteSyntax((ConcreteSyntax)null);
				return;
			case TCSPackage.IMPORT_DECLARATION__IS_PART_IMPORT:
				setIsPartImport(IS_PART_IMPORT_EDEFAULT);
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
			case TCSPackage.IMPORT_DECLARATION__CONCRETE_SYNTAX:
				return concreteSyntax != null;
			case TCSPackage.IMPORT_DECLARATION__IS_PART_IMPORT:
				return isPartImport != IS_PART_IMPORT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isPartImport: ");
		result.append(isPartImport);
		result.append(')');
		return result.toString();
	}

} //ImportDeclarationImpl

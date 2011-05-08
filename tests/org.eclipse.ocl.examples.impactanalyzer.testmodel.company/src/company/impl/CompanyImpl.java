/**
 * <copyright>
 * </copyright>
 *
 * $Id: CompanyImpl.java,v 1.3 2011/03/23 05:36:08 auhl Exp $
 */
package company.impl;

import company.Company;
import company.CompanyPackage;
import company.Division;

import company.Employee;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Company</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link company.impl.CompanyImpl#getDivision <em>Division</em>}</li>
 *   <li>{@link company.impl.CompanyImpl#getEotmDelta <em>Eotm Delta</em>}</li>
 *   <li>{@link company.impl.CompanyImpl#getDivisionDirector <em>Division Director</em>}</li>
 *   <li>{@link company.impl.CompanyImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompanyImpl extends EObjectImpl implements Company {
    /**
     * The cached value of the '{@link #getDivision() <em>Division</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDivision()
     * @generated
     * @ordered
     */
    protected Division division;

    /**
     * The cached setting delegate for the '{@link #getEotmDelta() <em>Eotm Delta</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEotmDelta()
     * @generated
     * @ordered
     */
    protected EStructuralFeature.Internal.SettingDelegate EOTM_DELTA__ESETTING_DELEGATE = ((EStructuralFeature.Internal)CompanyPackage.Literals.COMPANY__EOTM_DELTA).getSettingDelegate();

    /**
     * The cached setting delegate for the '{@link #getDivisionDirector() <em>Division Director</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getDivisionDirector()
     * @generated
     * @ordered
     */
	protected EStructuralFeature.Internal.SettingDelegate DIVISION_DIRECTOR__ESETTING_DELEGATE = ((EStructuralFeature.Internal)CompanyPackage.Literals.COMPANY__DIVISION_DIRECTOR).getSettingDelegate();

				/**
     * The cached setting delegate for the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
	protected EStructuralFeature.Internal.SettingDelegate NAME__ESETTING_DELEGATE = ((EStructuralFeature.Internal)CompanyPackage.Literals.COMPANY__NAME).getSettingDelegate();

				/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CompanyImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CompanyPackage.Literals.COMPANY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Division getDivision() {
        if (division != null && division.eIsProxy()) {
            InternalEObject oldDivision = (InternalEObject)division;
            division = (Division)eResolveProxy(oldDivision);
            if (division != oldDivision) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompanyPackage.COMPANY__DIVISION, oldDivision, division));
            }
        }
        return division;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Division basicGetDivision() {
        return division;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDivision(Division newDivision, NotificationChain msgs) {
        Division oldDivision = division;
        division = newDivision;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CompanyPackage.COMPANY__DIVISION, oldDivision, newDivision);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDivision(Division newDivision) {
        if (newDivision != division) {
            NotificationChain msgs = null;
            if (division != null)
                msgs = ((InternalEObject)division).eInverseRemove(this, CompanyPackage.DIVISION__COMPANY, Division.class, msgs);
            if (newDivision != null)
                msgs = ((InternalEObject)newDivision).eInverseAdd(this, CompanyPackage.DIVISION__COMPANY, Division.class, msgs);
            msgs = basicSetDivision(newDivision, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CompanyPackage.COMPANY__DIVISION, newDivision, newDivision));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getEotmDelta() {
        return (Integer)EOTM_DELTA__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Employee getDivisionDirector() {
        return (Employee)DIVISION_DIRECTOR__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Employee basicGetDivisionDirector() {
        return (Employee)DIVISION_DIRECTOR__ESETTING_DELEGATE.dynamicGet(this, null, 0, false, false);
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isSetDivisionDirector() {
        return DIVISION_DIRECTOR__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getName() {
        return (String)NAME__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
    }

				/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case CompanyPackage.COMPANY__DIVISION:
                if (division != null)
                    msgs = ((InternalEObject)division).eInverseRemove(this, CompanyPackage.DIVISION__COMPANY, Division.class, msgs);
                return basicSetDivision((Division)otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case CompanyPackage.COMPANY__DIVISION:
                return basicSetDivision(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case CompanyPackage.COMPANY__DIVISION:
                if (resolve) return getDivision();
                return basicGetDivision();
            case CompanyPackage.COMPANY__EOTM_DELTA:
                return getEotmDelta();
            case CompanyPackage.COMPANY__DIVISION_DIRECTOR:
                if (resolve) return getDivisionDirector();
                return basicGetDivisionDirector();
            case CompanyPackage.COMPANY__NAME:
                return getName();
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
            case CompanyPackage.COMPANY__DIVISION:
                setDivision((Division)newValue);
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
            case CompanyPackage.COMPANY__DIVISION:
                setDivision((Division)null);
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
            case CompanyPackage.COMPANY__DIVISION:
                return division != null;
            case CompanyPackage.COMPANY__EOTM_DELTA:
                return EOTM_DELTA__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
            case CompanyPackage.COMPANY__DIVISION_DIRECTOR:
                return isSetDivisionDirector();
            case CompanyPackage.COMPANY__NAME:
                return NAME__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
        }
        return super.eIsSet(featureID);
    }

} //CompanyImpl

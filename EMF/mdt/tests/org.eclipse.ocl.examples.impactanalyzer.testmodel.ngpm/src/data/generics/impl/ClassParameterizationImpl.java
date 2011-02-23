/**
 * <copyright>
 * </copyright>
 *
 * $Id: ClassParameterizationImpl.java,v 1.1 2011/02/07 17:18:46 auhl Exp $
 */
package data.generics.impl;

import data.classes.ClassesPackage;
import data.classes.SapClass;

import data.generics.ClassParameterization;
import data.generics.FormalTypeParameter;
import data.generics.GenericsPackage;

import java.util.Collection;

import modelmanagement.ModelmanagementPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Parameterization</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link data.generics.impl.ClassParameterizationImpl#getFormalTypeParameters <em>Formal Type Parameters</em>}</li>
 *   <li>{@link data.generics.impl.ClassParameterizationImpl#getOwningClassDefinition <em>Owning Class Definition</em>}</li>
 *   <li>{@link data.generics.impl.ClassParameterizationImpl#getPackage_ <em>Package </em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassParameterizationImpl extends EObjectImpl implements ClassParameterization {
	/**
     * The cached value of the '{@link #getFormalTypeParameters() <em>Formal Type Parameters</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getFormalTypeParameters()
     * @generated
     * @ordered
     */
	protected EList<FormalTypeParameter> formalTypeParameters;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ClassParameterizationImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return GenericsPackage.Literals.CLASS_PARAMETERIZATION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<FormalTypeParameter> getFormalTypeParameters() {
        if (formalTypeParameters == null) {
            formalTypeParameters = new EObjectContainmentWithInverseEList.Resolving<FormalTypeParameter>(FormalTypeParameter.class, this, GenericsPackage.CLASS_PARAMETERIZATION__FORMAL_TYPE_PARAMETERS, GenericsPackage.FORMAL_TYPE_PARAMETER__PARAMETER_OF);
        }
        return formalTypeParameters;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SapClass getOwningClassDefinition() {
        if (eContainerFeatureID() != GenericsPackage.CLASS_PARAMETERIZATION__OWNING_CLASS_DEFINITION) return null;
        return (SapClass)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SapClass basicGetOwningClassDefinition() {
        if (eContainerFeatureID() != GenericsPackage.CLASS_PARAMETERIZATION__OWNING_CLASS_DEFINITION) return null;
        return (SapClass)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetOwningClassDefinition(SapClass newOwningClassDefinition, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newOwningClassDefinition, GenericsPackage.CLASS_PARAMETERIZATION__OWNING_CLASS_DEFINITION, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setOwningClassDefinition(SapClass newOwningClassDefinition) {
        if (newOwningClassDefinition != eInternalContainer() || (eContainerFeatureID() != GenericsPackage.CLASS_PARAMETERIZATION__OWNING_CLASS_DEFINITION && newOwningClassDefinition != null)) {
            if (EcoreUtil.isAncestor(this, newOwningClassDefinition))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newOwningClassDefinition != null)
                msgs = ((InternalEObject)newOwningClassDefinition).eInverseAdd(this, ClassesPackage.SAP_CLASS__PARAMETERIZATION, SapClass.class, msgs);
            msgs = basicSetOwningClassDefinition(newOwningClassDefinition, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, GenericsPackage.CLASS_PARAMETERIZATION__OWNING_CLASS_DEFINITION, newOwningClassDefinition, newOwningClassDefinition));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public modelmanagement.Package getPackage_() {
        if (eContainerFeatureID() != GenericsPackage.CLASS_PARAMETERIZATION__PACKAGE_) return null;
        return (modelmanagement.Package)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public modelmanagement.Package basicGetPackage_() {
        if (eContainerFeatureID() != GenericsPackage.CLASS_PARAMETERIZATION__PACKAGE_) return null;
        return (modelmanagement.Package)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetPackage_(modelmanagement.Package newPackage_, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newPackage_, GenericsPackage.CLASS_PARAMETERIZATION__PACKAGE_, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setPackage_(modelmanagement.Package newPackage_) {
        if (newPackage_ != eInternalContainer() || (eContainerFeatureID() != GenericsPackage.CLASS_PARAMETERIZATION__PACKAGE_ && newPackage_ != null)) {
            if (EcoreUtil.isAncestor(this, newPackage_))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newPackage_ != null)
                msgs = ((InternalEObject)newPackage_).eInverseAdd(this, ModelmanagementPackage.PACKAGE__PARAMETERIZED_CLASSES, modelmanagement.Package.class, msgs);
            msgs = basicSetPackage_(newPackage_, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, GenericsPackage.CLASS_PARAMETERIZATION__PACKAGE_, newPackage_, newPackage_));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case GenericsPackage.CLASS_PARAMETERIZATION__FORMAL_TYPE_PARAMETERS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getFormalTypeParameters()).basicAdd(otherEnd, msgs);
            case GenericsPackage.CLASS_PARAMETERIZATION__OWNING_CLASS_DEFINITION:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetOwningClassDefinition((SapClass)otherEnd, msgs);
            case GenericsPackage.CLASS_PARAMETERIZATION__PACKAGE_:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetPackage_((modelmanagement.Package)otherEnd, msgs);
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
            case GenericsPackage.CLASS_PARAMETERIZATION__FORMAL_TYPE_PARAMETERS:
                return ((InternalEList<?>)getFormalTypeParameters()).basicRemove(otherEnd, msgs);
            case GenericsPackage.CLASS_PARAMETERIZATION__OWNING_CLASS_DEFINITION:
                return basicSetOwningClassDefinition(null, msgs);
            case GenericsPackage.CLASS_PARAMETERIZATION__PACKAGE_:
                return basicSetPackage_(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
            case GenericsPackage.CLASS_PARAMETERIZATION__OWNING_CLASS_DEFINITION:
                return eInternalContainer().eInverseRemove(this, ClassesPackage.SAP_CLASS__PARAMETERIZATION, SapClass.class, msgs);
            case GenericsPackage.CLASS_PARAMETERIZATION__PACKAGE_:
                return eInternalContainer().eInverseRemove(this, ModelmanagementPackage.PACKAGE__PARAMETERIZED_CLASSES, modelmanagement.Package.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case GenericsPackage.CLASS_PARAMETERIZATION__FORMAL_TYPE_PARAMETERS:
                return getFormalTypeParameters();
            case GenericsPackage.CLASS_PARAMETERIZATION__OWNING_CLASS_DEFINITION:
                if (resolve) return getOwningClassDefinition();
                return basicGetOwningClassDefinition();
            case GenericsPackage.CLASS_PARAMETERIZATION__PACKAGE_:
                if (resolve) return getPackage_();
                return basicGetPackage_();
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
            case GenericsPackage.CLASS_PARAMETERIZATION__FORMAL_TYPE_PARAMETERS:
                getFormalTypeParameters().clear();
                getFormalTypeParameters().addAll((Collection<? extends FormalTypeParameter>)newValue);
                return;
            case GenericsPackage.CLASS_PARAMETERIZATION__OWNING_CLASS_DEFINITION:
                setOwningClassDefinition((SapClass)newValue);
                return;
            case GenericsPackage.CLASS_PARAMETERIZATION__PACKAGE_:
                setPackage_((modelmanagement.Package)newValue);
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
            case GenericsPackage.CLASS_PARAMETERIZATION__FORMAL_TYPE_PARAMETERS:
                getFormalTypeParameters().clear();
                return;
            case GenericsPackage.CLASS_PARAMETERIZATION__OWNING_CLASS_DEFINITION:
                setOwningClassDefinition((SapClass)null);
                return;
            case GenericsPackage.CLASS_PARAMETERIZATION__PACKAGE_:
                setPackage_((modelmanagement.Package)null);
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
            case GenericsPackage.CLASS_PARAMETERIZATION__FORMAL_TYPE_PARAMETERS:
                return formalTypeParameters != null && !formalTypeParameters.isEmpty();
            case GenericsPackage.CLASS_PARAMETERIZATION__OWNING_CLASS_DEFINITION:
                return basicGetOwningClassDefinition() != null;
            case GenericsPackage.CLASS_PARAMETERIZATION__PACKAGE_:
                return basicGetPackage_() != null;
        }
        return super.eIsSet(featureID);
    }

} //ClassParameterizationImpl

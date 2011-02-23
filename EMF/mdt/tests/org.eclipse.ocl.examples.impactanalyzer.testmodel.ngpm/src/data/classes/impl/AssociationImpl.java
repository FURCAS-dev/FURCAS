/**
 * <copyright>
 * </copyright>
 *
 * $Id: AssociationImpl.java,v 1.1 2011/02/07 17:16:10 auhl Exp $
 */
package data.classes.impl;

import abapmapping.AbapAssociationImplementationAnnotation;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassesPackage;

import data.timedependency.TimeDependency;
import data.timedependency.TimedependencyPackage;

import java.util.Collection;

import modelmanagement.ModelmanagementPackage;

import modelmanagement.impl.NamedElementImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Association</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link data.classes.impl.AssociationImpl#getEnds <em>Ends</em>}</li>
 *   <li>{@link data.classes.impl.AssociationImpl#getPackage_ <em>Package </em>}</li>
 *   <li>{@link data.classes.impl.AssociationImpl#getTimeDependency <em>Time Dependency</em>}</li>
 *   <li>{@link data.classes.impl.AssociationImpl#getAbapAnnotation <em>Abap Annotation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssociationImpl extends NamedElementImpl implements Association {
	/**
     * The cached value of the '{@link #getEnds() <em>Ends</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getEnds()
     * @generated
     * @ordered
     */
	protected EList<AssociationEnd> ends;

	/**
     * The cached value of the '{@link #getTimeDependency() <em>Time Dependency</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTimeDependency()
     * @generated
     * @ordered
     */
	protected TimeDependency timeDependency;

	/**
     * The cached value of the '{@link #getAbapAnnotation() <em>Abap Annotation</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getAbapAnnotation()
     * @generated
     * @ordered
     */
	protected AbapAssociationImplementationAnnotation abapAnnotation;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected AssociationImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ClassesPackage.Literals.ASSOCIATION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<AssociationEnd> getEnds() {
        if (ends == null) {
            ends = new EObjectContainmentWithInverseEList.Resolving<AssociationEnd>(AssociationEnd.class, this, ClassesPackage.ASSOCIATION__ENDS, ClassesPackage.ASSOCIATION_END__ASSOCIATION);
        }
        return ends;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public modelmanagement.Package getPackage_() {
        if (eContainerFeatureID() != ClassesPackage.ASSOCIATION__PACKAGE_) return null;
        return (modelmanagement.Package)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public modelmanagement.Package basicGetPackage_() {
        if (eContainerFeatureID() != ClassesPackage.ASSOCIATION__PACKAGE_) return null;
        return (modelmanagement.Package)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetPackage_(modelmanagement.Package newPackage_, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newPackage_, ClassesPackage.ASSOCIATION__PACKAGE_, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setPackage_(modelmanagement.Package newPackage_) {
        if (newPackage_ != eInternalContainer() || (eContainerFeatureID() != ClassesPackage.ASSOCIATION__PACKAGE_ && newPackage_ != null)) {
            if (EcoreUtil.isAncestor(this, newPackage_))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newPackage_ != null)
                msgs = ((InternalEObject)newPackage_).eInverseAdd(this, ModelmanagementPackage.PACKAGE__ASSOCIATIONS, modelmanagement.Package.class, msgs);
            msgs = basicSetPackage_(newPackage_, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.ASSOCIATION__PACKAGE_, newPackage_, newPackage_));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TimeDependency getTimeDependency() {
        if (timeDependency != null && timeDependency.eIsProxy()) {
            InternalEObject oldTimeDependency = (InternalEObject)timeDependency;
            timeDependency = (TimeDependency)eResolveProxy(oldTimeDependency);
            if (timeDependency != oldTimeDependency) {
                InternalEObject newTimeDependency = (InternalEObject)timeDependency;
                NotificationChain msgs =  oldTimeDependency.eInverseRemove(this, TimedependencyPackage.TIME_DEPENDENCY__ASSOCIATION, TimeDependency.class, null);
                if (newTimeDependency.eInternalContainer() == null) {
                    msgs =  newTimeDependency.eInverseAdd(this, TimedependencyPackage.TIME_DEPENDENCY__ASSOCIATION, TimeDependency.class, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassesPackage.ASSOCIATION__TIME_DEPENDENCY, oldTimeDependency, timeDependency));
            }
        }
        return timeDependency;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TimeDependency basicGetTimeDependency() {
        return timeDependency;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetTimeDependency(TimeDependency newTimeDependency, NotificationChain msgs) {
        TimeDependency oldTimeDependency = timeDependency;
        timeDependency = newTimeDependency;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassesPackage.ASSOCIATION__TIME_DEPENDENCY, oldTimeDependency, newTimeDependency);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTimeDependency(TimeDependency newTimeDependency) {
        if (newTimeDependency != timeDependency) {
            NotificationChain msgs = null;
            if (timeDependency != null)
                msgs = ((InternalEObject)timeDependency).eInverseRemove(this, TimedependencyPackage.TIME_DEPENDENCY__ASSOCIATION, TimeDependency.class, msgs);
            if (newTimeDependency != null)
                msgs = ((InternalEObject)newTimeDependency).eInverseAdd(this, TimedependencyPackage.TIME_DEPENDENCY__ASSOCIATION, TimeDependency.class, msgs);
            msgs = basicSetTimeDependency(newTimeDependency, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.ASSOCIATION__TIME_DEPENDENCY, newTimeDependency, newTimeDependency));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AbapAssociationImplementationAnnotation getAbapAnnotation() {
        if (abapAnnotation != null && abapAnnotation.eIsProxy()) {
            InternalEObject oldAbapAnnotation = (InternalEObject)abapAnnotation;
            abapAnnotation = (AbapAssociationImplementationAnnotation)eResolveProxy(oldAbapAnnotation);
            if (abapAnnotation != oldAbapAnnotation) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassesPackage.ASSOCIATION__ABAP_ANNOTATION, oldAbapAnnotation, abapAnnotation));
            }
        }
        return abapAnnotation;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AbapAssociationImplementationAnnotation basicGetAbapAnnotation() {
        return abapAnnotation;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setAbapAnnotation(AbapAssociationImplementationAnnotation newAbapAnnotation) {
        AbapAssociationImplementationAnnotation oldAbapAnnotation = abapAnnotation;
        abapAnnotation = newAbapAnnotation;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.ASSOCIATION__ABAP_ANNOTATION, oldAbapAnnotation, abapAnnotation));
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
            case ClassesPackage.ASSOCIATION__ENDS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getEnds()).basicAdd(otherEnd, msgs);
            case ClassesPackage.ASSOCIATION__PACKAGE_:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetPackage_((modelmanagement.Package)otherEnd, msgs);
            case ClassesPackage.ASSOCIATION__TIME_DEPENDENCY:
                if (timeDependency != null)
                    msgs = ((InternalEObject)timeDependency).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ClassesPackage.ASSOCIATION__TIME_DEPENDENCY, null, msgs);
                return basicSetTimeDependency((TimeDependency)otherEnd, msgs);
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
            case ClassesPackage.ASSOCIATION__ENDS:
                return ((InternalEList<?>)getEnds()).basicRemove(otherEnd, msgs);
            case ClassesPackage.ASSOCIATION__PACKAGE_:
                return basicSetPackage_(null, msgs);
            case ClassesPackage.ASSOCIATION__TIME_DEPENDENCY:
                return basicSetTimeDependency(null, msgs);
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
            case ClassesPackage.ASSOCIATION__PACKAGE_:
                return eInternalContainer().eInverseRemove(this, ModelmanagementPackage.PACKAGE__ASSOCIATIONS, modelmanagement.Package.class, msgs);
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
            case ClassesPackage.ASSOCIATION__ENDS:
                return getEnds();
            case ClassesPackage.ASSOCIATION__PACKAGE_:
                if (resolve) return getPackage_();
                return basicGetPackage_();
            case ClassesPackage.ASSOCIATION__TIME_DEPENDENCY:
                if (resolve) return getTimeDependency();
                return basicGetTimeDependency();
            case ClassesPackage.ASSOCIATION__ABAP_ANNOTATION:
                if (resolve) return getAbapAnnotation();
                return basicGetAbapAnnotation();
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
            case ClassesPackage.ASSOCIATION__ENDS:
                getEnds().clear();
                getEnds().addAll((Collection<? extends AssociationEnd>)newValue);
                return;
            case ClassesPackage.ASSOCIATION__PACKAGE_:
                setPackage_((modelmanagement.Package)newValue);
                return;
            case ClassesPackage.ASSOCIATION__TIME_DEPENDENCY:
                setTimeDependency((TimeDependency)newValue);
                return;
            case ClassesPackage.ASSOCIATION__ABAP_ANNOTATION:
                setAbapAnnotation((AbapAssociationImplementationAnnotation)newValue);
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
            case ClassesPackage.ASSOCIATION__ENDS:
                getEnds().clear();
                return;
            case ClassesPackage.ASSOCIATION__PACKAGE_:
                setPackage_((modelmanagement.Package)null);
                return;
            case ClassesPackage.ASSOCIATION__TIME_DEPENDENCY:
                setTimeDependency((TimeDependency)null);
                return;
            case ClassesPackage.ASSOCIATION__ABAP_ANNOTATION:
                setAbapAnnotation((AbapAssociationImplementationAnnotation)null);
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
            case ClassesPackage.ASSOCIATION__ENDS:
                return ends != null && !ends.isEmpty();
            case ClassesPackage.ASSOCIATION__PACKAGE_:
                return basicGetPackage_() != null;
            case ClassesPackage.ASSOCIATION__TIME_DEPENDENCY:
                return timeDependency != null;
            case ClassesPackage.ASSOCIATION__ABAP_ANNOTATION:
                return abapAnnotation != null;
        }
        return super.eIsSet(featureID);
    }

} //AssociationImpl

/**
 * <copyright>
 * </copyright>
 *
 * $Id: AssociationEndImpl.java,v 1.1 2011/02/07 17:16:10 auhl Exp $
 */
package data.classes.impl;

import abapmapping.AbapAssociationEndImplementationAnnotation;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.AssociationEndSignatureImplementation;
import data.classes.ClassTypeDefinition;
import data.classes.ClassesPackage;
import data.classes.Delegation;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import modelmanagement.impl.NamedElementImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Association End</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link data.classes.impl.AssociationEndImpl#isNavigable <em>Navigable</em>}</li>
 *   <li>{@link data.classes.impl.AssociationEndImpl#isComposite <em>Composite</em>}</li>
 *   <li>{@link data.classes.impl.AssociationEndImpl#isContributesToEquality <em>Contributes To Equality</em>}</li>
 *   <li>{@link data.classes.impl.AssociationEndImpl#getAssociation <em>Association</em>}</li>
 *   <li>{@link data.classes.impl.AssociationEndImpl#getDelegation <em>Delegation</em>}</li>
 *   <li>{@link data.classes.impl.AssociationEndImpl#getSignatureImplementations <em>Signature Implementations</em>}</li>
 *   <li>{@link data.classes.impl.AssociationEndImpl#getType <em>Type</em>}</li>
 *   <li>{@link data.classes.impl.AssociationEndImpl#getAbapAnnotation <em>Abap Annotation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssociationEndImpl extends NamedElementImpl implements AssociationEnd {
	/**
     * The default value of the '{@link #isNavigable() <em>Navigable</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isNavigable()
     * @generated
     * @ordered
     */
	protected static final boolean NAVIGABLE_EDEFAULT = false;

	/**
     * The cached value of the '{@link #isNavigable() <em>Navigable</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isNavigable()
     * @generated
     * @ordered
     */
	protected boolean navigable = NAVIGABLE_EDEFAULT;

	/**
     * The default value of the '{@link #isComposite() <em>Composite</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isComposite()
     * @generated
     * @ordered
     */
	protected static final boolean COMPOSITE_EDEFAULT = false;

	/**
     * The cached value of the '{@link #isComposite() <em>Composite</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isComposite()
     * @generated
     * @ordered
     */
	protected boolean composite = COMPOSITE_EDEFAULT;

	/**
     * The default value of the '{@link #isContributesToEquality() <em>Contributes To Equality</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isContributesToEquality()
     * @generated
     * @ordered
     */
	protected static final boolean CONTRIBUTES_TO_EQUALITY_EDEFAULT = false;

	/**
     * The cached value of the '{@link #isContributesToEquality() <em>Contributes To Equality</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isContributesToEquality()
     * @generated
     * @ordered
     */
	protected boolean contributesToEquality = CONTRIBUTES_TO_EQUALITY_EDEFAULT;

	/**
     * The cached value of the '{@link #getDelegation() <em>Delegation</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getDelegation()
     * @generated
     * @ordered
     */
	protected Delegation delegation;

	/**
     * The cached value of the '{@link #getSignatureImplementations() <em>Signature Implementations</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSignatureImplementations()
     * @generated
     * @ordered
     */
	protected EList<AssociationEndSignatureImplementation> signatureImplementations;

	/**
     * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
	protected ClassTypeDefinition type;

	/**
     * The cached value of the '{@link #getAbapAnnotation() <em>Abap Annotation</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getAbapAnnotation()
     * @generated
     * @ordered
     */
	protected AbapAssociationEndImplementationAnnotation abapAnnotation;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected AssociationEndImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ClassesPackage.Literals.ASSOCIATION_END;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isNavigable() {
        return navigable;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setNavigable(boolean newNavigable) {
        boolean oldNavigable = navigable;
        navigable = newNavigable;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.ASSOCIATION_END__NAVIGABLE, oldNavigable, navigable));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isComposite() {
        return composite;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setComposite(boolean newComposite) {
        boolean oldComposite = composite;
        composite = newComposite;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.ASSOCIATION_END__COMPOSITE, oldComposite, composite));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isContributesToEquality() {
        return contributesToEquality;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setContributesToEquality(boolean newContributesToEquality) {
        boolean oldContributesToEquality = contributesToEquality;
        contributesToEquality = newContributesToEquality;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.ASSOCIATION_END__CONTRIBUTES_TO_EQUALITY, oldContributesToEquality, contributesToEquality));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Association getAssociation() {
        if (eContainerFeatureID() != ClassesPackage.ASSOCIATION_END__ASSOCIATION) return null;
        return (Association)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Association basicGetAssociation() {
        if (eContainerFeatureID() != ClassesPackage.ASSOCIATION_END__ASSOCIATION) return null;
        return (Association)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetAssociation(Association newAssociation, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newAssociation, ClassesPackage.ASSOCIATION_END__ASSOCIATION, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setAssociation(Association newAssociation) {
        if (newAssociation != eInternalContainer() || (eContainerFeatureID() != ClassesPackage.ASSOCIATION_END__ASSOCIATION && newAssociation != null)) {
            if (EcoreUtil.isAncestor(this, newAssociation))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newAssociation != null)
                msgs = ((InternalEObject)newAssociation).eInverseAdd(this, ClassesPackage.ASSOCIATION__ENDS, Association.class, msgs);
            msgs = basicSetAssociation(newAssociation, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.ASSOCIATION_END__ASSOCIATION, newAssociation, newAssociation));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Delegation getDelegation() {
        if (delegation != null && delegation.eIsProxy()) {
            InternalEObject oldDelegation = (InternalEObject)delegation;
            delegation = (Delegation)eResolveProxy(oldDelegation);
            if (delegation != oldDelegation) {
                InternalEObject newDelegation = (InternalEObject)delegation;
                NotificationChain msgs =  oldDelegation.eInverseRemove(this, ClassesPackage.DELEGATION__FROM, Delegation.class, null);
                if (newDelegation.eInternalContainer() == null) {
                    msgs =  newDelegation.eInverseAdd(this, ClassesPackage.DELEGATION__FROM, Delegation.class, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassesPackage.ASSOCIATION_END__DELEGATION, oldDelegation, delegation));
            }
        }
        return delegation;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Delegation basicGetDelegation() {
        return delegation;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetDelegation(Delegation newDelegation, NotificationChain msgs) {
        Delegation oldDelegation = delegation;
        delegation = newDelegation;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassesPackage.ASSOCIATION_END__DELEGATION, oldDelegation, newDelegation);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setDelegation(Delegation newDelegation) {
        if (newDelegation != delegation) {
            NotificationChain msgs = null;
            if (delegation != null)
                msgs = ((InternalEObject)delegation).eInverseRemove(this, ClassesPackage.DELEGATION__FROM, Delegation.class, msgs);
            if (newDelegation != null)
                msgs = ((InternalEObject)newDelegation).eInverseAdd(this, ClassesPackage.DELEGATION__FROM, Delegation.class, msgs);
            msgs = basicSetDelegation(newDelegation, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.ASSOCIATION_END__DELEGATION, newDelegation, newDelegation));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<AssociationEndSignatureImplementation> getSignatureImplementations() {
        if (signatureImplementations == null) {
            signatureImplementations = new EObjectWithInverseResolvingEList<AssociationEndSignatureImplementation>(AssociationEndSignatureImplementation.class, this, ClassesPackage.ASSOCIATION_END__SIGNATURE_IMPLEMENTATIONS, ClassesPackage.ASSOCIATION_END_SIGNATURE_IMPLEMENTATION__END);
        }
        return signatureImplementations;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ClassTypeDefinition getType() {
        if (type != null && type.eIsProxy()) {
            InternalEObject oldType = (InternalEObject)type;
            type = (ClassTypeDefinition)eResolveProxy(oldType);
            if (type != oldType) {
                InternalEObject newType = (InternalEObject)type;
                NotificationChain msgs =  oldType.eInverseRemove(this, ClassesPackage.CLASS_TYPE_DEFINITION__ASSOCIATION_END, ClassTypeDefinition.class, null);
                if (newType.eInternalContainer() == null) {
                    msgs =  newType.eInverseAdd(this, ClassesPackage.CLASS_TYPE_DEFINITION__ASSOCIATION_END, ClassTypeDefinition.class, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassesPackage.ASSOCIATION_END__TYPE, oldType, type));
            }
        }
        return type;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ClassTypeDefinition basicGetType() {
        return type;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetType(ClassTypeDefinition newType, NotificationChain msgs) {
        ClassTypeDefinition oldType = type;
        type = newType;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassesPackage.ASSOCIATION_END__TYPE, oldType, newType);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setType(ClassTypeDefinition newType) {
        if (newType != type) {
            NotificationChain msgs = null;
            if (type != null)
                msgs = ((InternalEObject)type).eInverseRemove(this, ClassesPackage.CLASS_TYPE_DEFINITION__ASSOCIATION_END, ClassTypeDefinition.class, msgs);
            if (newType != null)
                msgs = ((InternalEObject)newType).eInverseAdd(this, ClassesPackage.CLASS_TYPE_DEFINITION__ASSOCIATION_END, ClassTypeDefinition.class, msgs);
            msgs = basicSetType(newType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.ASSOCIATION_END__TYPE, newType, newType));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AbapAssociationEndImplementationAnnotation getAbapAnnotation() {
        if (abapAnnotation != null && abapAnnotation.eIsProxy()) {
            InternalEObject oldAbapAnnotation = (InternalEObject)abapAnnotation;
            abapAnnotation = (AbapAssociationEndImplementationAnnotation)eResolveProxy(oldAbapAnnotation);
            if (abapAnnotation != oldAbapAnnotation) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassesPackage.ASSOCIATION_END__ABAP_ANNOTATION, oldAbapAnnotation, abapAnnotation));
            }
        }
        return abapAnnotation;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AbapAssociationEndImplementationAnnotation basicGetAbapAnnotation() {
        return abapAnnotation;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setAbapAnnotation(AbapAssociationEndImplementationAnnotation newAbapAnnotation) {
        AbapAssociationEndImplementationAnnotation oldAbapAnnotation = abapAnnotation;
        abapAnnotation = newAbapAnnotation;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.ASSOCIATION_END__ABAP_ANNOTATION, oldAbapAnnotation, abapAnnotation));
    }

	/**
     * The cached invocation delegate for the '{@link #otherEnd() <em>Other End</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #otherEnd()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate OTHER_END__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.ASSOCIATION_END.getEOperations().get(0)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AssociationEnd otherEnd() {
        try {
            return (AssociationEnd)OTHER_END__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
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
            case ClassesPackage.ASSOCIATION_END__ASSOCIATION:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetAssociation((Association)otherEnd, msgs);
            case ClassesPackage.ASSOCIATION_END__DELEGATION:
                if (delegation != null)
                    msgs = ((InternalEObject)delegation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ClassesPackage.ASSOCIATION_END__DELEGATION, null, msgs);
                return basicSetDelegation((Delegation)otherEnd, msgs);
            case ClassesPackage.ASSOCIATION_END__SIGNATURE_IMPLEMENTATIONS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getSignatureImplementations()).basicAdd(otherEnd, msgs);
            case ClassesPackage.ASSOCIATION_END__TYPE:
                if (type != null)
                    msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ClassesPackage.ASSOCIATION_END__TYPE, null, msgs);
                return basicSetType((ClassTypeDefinition)otherEnd, msgs);
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
            case ClassesPackage.ASSOCIATION_END__ASSOCIATION:
                return basicSetAssociation(null, msgs);
            case ClassesPackage.ASSOCIATION_END__DELEGATION:
                return basicSetDelegation(null, msgs);
            case ClassesPackage.ASSOCIATION_END__SIGNATURE_IMPLEMENTATIONS:
                return ((InternalEList<?>)getSignatureImplementations()).basicRemove(otherEnd, msgs);
            case ClassesPackage.ASSOCIATION_END__TYPE:
                return basicSetType(null, msgs);
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
            case ClassesPackage.ASSOCIATION_END__ASSOCIATION:
                return eInternalContainer().eInverseRemove(this, ClassesPackage.ASSOCIATION__ENDS, Association.class, msgs);
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
            case ClassesPackage.ASSOCIATION_END__NAVIGABLE:
                return isNavigable();
            case ClassesPackage.ASSOCIATION_END__COMPOSITE:
                return isComposite();
            case ClassesPackage.ASSOCIATION_END__CONTRIBUTES_TO_EQUALITY:
                return isContributesToEquality();
            case ClassesPackage.ASSOCIATION_END__ASSOCIATION:
                if (resolve) return getAssociation();
                return basicGetAssociation();
            case ClassesPackage.ASSOCIATION_END__DELEGATION:
                if (resolve) return getDelegation();
                return basicGetDelegation();
            case ClassesPackage.ASSOCIATION_END__SIGNATURE_IMPLEMENTATIONS:
                return getSignatureImplementations();
            case ClassesPackage.ASSOCIATION_END__TYPE:
                if (resolve) return getType();
                return basicGetType();
            case ClassesPackage.ASSOCIATION_END__ABAP_ANNOTATION:
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
            case ClassesPackage.ASSOCIATION_END__NAVIGABLE:
                setNavigable((Boolean)newValue);
                return;
            case ClassesPackage.ASSOCIATION_END__COMPOSITE:
                setComposite((Boolean)newValue);
                return;
            case ClassesPackage.ASSOCIATION_END__CONTRIBUTES_TO_EQUALITY:
                setContributesToEquality((Boolean)newValue);
                return;
            case ClassesPackage.ASSOCIATION_END__ASSOCIATION:
                setAssociation((Association)newValue);
                return;
            case ClassesPackage.ASSOCIATION_END__DELEGATION:
                setDelegation((Delegation)newValue);
                return;
            case ClassesPackage.ASSOCIATION_END__SIGNATURE_IMPLEMENTATIONS:
                getSignatureImplementations().clear();
                getSignatureImplementations().addAll((Collection<? extends AssociationEndSignatureImplementation>)newValue);
                return;
            case ClassesPackage.ASSOCIATION_END__TYPE:
                setType((ClassTypeDefinition)newValue);
                return;
            case ClassesPackage.ASSOCIATION_END__ABAP_ANNOTATION:
                setAbapAnnotation((AbapAssociationEndImplementationAnnotation)newValue);
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
            case ClassesPackage.ASSOCIATION_END__NAVIGABLE:
                setNavigable(NAVIGABLE_EDEFAULT);
                return;
            case ClassesPackage.ASSOCIATION_END__COMPOSITE:
                setComposite(COMPOSITE_EDEFAULT);
                return;
            case ClassesPackage.ASSOCIATION_END__CONTRIBUTES_TO_EQUALITY:
                setContributesToEquality(CONTRIBUTES_TO_EQUALITY_EDEFAULT);
                return;
            case ClassesPackage.ASSOCIATION_END__ASSOCIATION:
                setAssociation((Association)null);
                return;
            case ClassesPackage.ASSOCIATION_END__DELEGATION:
                setDelegation((Delegation)null);
                return;
            case ClassesPackage.ASSOCIATION_END__SIGNATURE_IMPLEMENTATIONS:
                getSignatureImplementations().clear();
                return;
            case ClassesPackage.ASSOCIATION_END__TYPE:
                setType((ClassTypeDefinition)null);
                return;
            case ClassesPackage.ASSOCIATION_END__ABAP_ANNOTATION:
                setAbapAnnotation((AbapAssociationEndImplementationAnnotation)null);
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
            case ClassesPackage.ASSOCIATION_END__NAVIGABLE:
                return navigable != NAVIGABLE_EDEFAULT;
            case ClassesPackage.ASSOCIATION_END__COMPOSITE:
                return composite != COMPOSITE_EDEFAULT;
            case ClassesPackage.ASSOCIATION_END__CONTRIBUTES_TO_EQUALITY:
                return contributesToEquality != CONTRIBUTES_TO_EQUALITY_EDEFAULT;
            case ClassesPackage.ASSOCIATION_END__ASSOCIATION:
                return basicGetAssociation() != null;
            case ClassesPackage.ASSOCIATION_END__DELEGATION:
                return delegation != null;
            case ClassesPackage.ASSOCIATION_END__SIGNATURE_IMPLEMENTATIONS:
                return signatureImplementations != null && !signatureImplementations.isEmpty();
            case ClassesPackage.ASSOCIATION_END__TYPE:
                return type != null;
            case ClassesPackage.ASSOCIATION_END__ABAP_ANNOTATION:
                return abapAnnotation != null;
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
        result.append(" (navigable: ");
        result.append(navigable);
        result.append(", composite: ");
        result.append(composite);
        result.append(", contributesToEquality: ");
        result.append(contributesToEquality);
        result.append(')');
        return result.toString();
    }

} //AssociationEndImpl

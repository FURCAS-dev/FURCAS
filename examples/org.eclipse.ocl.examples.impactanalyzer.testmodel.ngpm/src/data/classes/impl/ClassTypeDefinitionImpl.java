/**
 * <copyright>
 * </copyright>
 *
 * $Id: ClassTypeDefinitionImpl.java,v 1.1 2011/02/07 16:43:32 auhl Exp $
 */
package data.classes.impl;

import data.classes.ActualObjectParameter;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.ClassesPackage;
import data.classes.SapClass;

import dataaccess.expressions.Expression;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Type Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link data.classes.impl.ClassTypeDefinitionImpl#getClazz <em>Clazz</em>}</li>
 *   <li>{@link data.classes.impl.ClassTypeDefinitionImpl#getAssociationEnd <em>Association End</em>}</li>
 *   <li>{@link data.classes.impl.ClassTypeDefinitionImpl#getObjectParameters <em>Object Parameters</em>}</li>
 *   <li>{@link data.classes.impl.ClassTypeDefinitionImpl#getOwnedObjectParameters <em>Owned Object Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassTypeDefinitionImpl extends TypeDefinitionImpl implements ClassTypeDefinition {
	/**
     * The cached value of the '{@link #getClazz() <em>Clazz</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getClazz()
     * @generated
     * @ordered
     */
	protected SapClass clazz;

	/**
     * The cached value of the '{@link #getObjectParameters() <em>Object Parameters</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getObjectParameters()
     * @generated
     * @ordered
     */
	protected EList<ActualObjectParameter> objectParameters;

	/**
     * The cached value of the '{@link #getOwnedObjectParameters() <em>Owned Object Parameters</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getOwnedObjectParameters()
     * @generated
     * @ordered
     */
	protected EList<ActualObjectParameter> ownedObjectParameters;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ClassTypeDefinitionImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ClassesPackage.Literals.CLASS_TYPE_DEFINITION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SapClass getClazz() {
        if (clazz != null && clazz.eIsProxy()) {
            InternalEObject oldClazz = (InternalEObject)clazz;
            clazz = (SapClass)eResolveProxy(oldClazz);
            if (clazz != oldClazz) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassesPackage.CLASS_TYPE_DEFINITION__CLAZZ, oldClazz, clazz));
            }
        }
        return clazz;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SapClass basicGetClazz() {
        return clazz;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetClazz(SapClass newClazz, NotificationChain msgs) {
        SapClass oldClazz = clazz;
        clazz = newClazz;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassesPackage.CLASS_TYPE_DEFINITION__CLAZZ, oldClazz, newClazz);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setClazz(SapClass newClazz) {
        if (newClazz != clazz) {
            NotificationChain msgs = null;
            if (clazz != null)
                msgs = ((InternalEObject)clazz).eInverseRemove(this, ClassesPackage.SAP_CLASS__ELEMENTS_OF_TYPE, SapClass.class, msgs);
            if (newClazz != null)
                msgs = ((InternalEObject)newClazz).eInverseAdd(this, ClassesPackage.SAP_CLASS__ELEMENTS_OF_TYPE, SapClass.class, msgs);
            msgs = basicSetClazz(newClazz, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.CLASS_TYPE_DEFINITION__CLAZZ, newClazz, newClazz));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AssociationEnd getAssociationEnd() {
        if (eContainerFeatureID() != ClassesPackage.CLASS_TYPE_DEFINITION__ASSOCIATION_END) return null;
        return (AssociationEnd)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssociationEnd basicGetAssociationEnd() {
        if (eContainerFeatureID() != ClassesPackage.CLASS_TYPE_DEFINITION__ASSOCIATION_END) return null;
        return (AssociationEnd)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetAssociationEnd(AssociationEnd newAssociationEnd, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newAssociationEnd, ClassesPackage.CLASS_TYPE_DEFINITION__ASSOCIATION_END, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setAssociationEnd(AssociationEnd newAssociationEnd) {
        if (newAssociationEnd != eInternalContainer() || (eContainerFeatureID() != ClassesPackage.CLASS_TYPE_DEFINITION__ASSOCIATION_END && newAssociationEnd != null)) {
            if (EcoreUtil.isAncestor(this, newAssociationEnd))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newAssociationEnd != null)
                msgs = ((InternalEObject)newAssociationEnd).eInverseAdd(this, ClassesPackage.ASSOCIATION_END__TYPE, AssociationEnd.class, msgs);
            msgs = basicSetAssociationEnd(newAssociationEnd, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.CLASS_TYPE_DEFINITION__ASSOCIATION_END, newAssociationEnd, newAssociationEnd));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<ActualObjectParameter> getObjectParameters() {
        if (objectParameters == null) {
            objectParameters = new EObjectWithInverseResolvingEList.ManyInverse<ActualObjectParameter>(ActualObjectParameter.class, this, ClassesPackage.CLASS_TYPE_DEFINITION__OBJECT_PARAMETERS, ClassesPackage.ACTUAL_OBJECT_PARAMETER__CLASS_TYPE_DEFINITIONS);
        }
        return objectParameters;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<ActualObjectParameter> getOwnedObjectParameters() {
        if (ownedObjectParameters == null) {
            ownedObjectParameters = new EObjectContainmentWithInverseEList.Resolving<ActualObjectParameter>(ActualObjectParameter.class, this, ClassesPackage.CLASS_TYPE_DEFINITION__OWNED_OBJECT_PARAMETERS, ClassesPackage.ACTUAL_OBJECT_PARAMETER__OWNING_CLASS_TYPE_DEFINITION);
        }
        return ownedObjectParameters;
    }

	/**
     * The cached invocation delegate for the '{@link #objectParametersConformTo(data.classes.ClassTypeDefinition) <em>Object Parameters Conform To</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #objectParametersConformTo(data.classes.ClassTypeDefinition)
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate OBJECT_PARAMETERS_CONFORM_TO_CLASS_TYPE_DEFINITION__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.CLASS_TYPE_DEFINITION.getEOperations().get(0)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean objectParametersConformTo(ClassTypeDefinition ctd) {
        try {
            return (Boolean)OBJECT_PARAMETERS_CONFORM_TO_CLASS_TYPE_DEFINITION__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{ctd}));
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #effectiveObjectParameters() <em>Effective Object Parameters</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #effectiveObjectParameters()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate EFFECTIVE_OBJECT_PARAMETERS__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.CLASS_TYPE_DEFINITION.getEOperations().get(1)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<Expression> effectiveObjectParameters() {
        try {
            return (EList<Expression>)EFFECTIVE_OBJECT_PARAMETERS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
            case ClassesPackage.CLASS_TYPE_DEFINITION__CLAZZ:
                if (clazz != null)
                    msgs = ((InternalEObject)clazz).eInverseRemove(this, ClassesPackage.SAP_CLASS__ELEMENTS_OF_TYPE, SapClass.class, msgs);
                return basicSetClazz((SapClass)otherEnd, msgs);
            case ClassesPackage.CLASS_TYPE_DEFINITION__ASSOCIATION_END:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetAssociationEnd((AssociationEnd)otherEnd, msgs);
            case ClassesPackage.CLASS_TYPE_DEFINITION__OBJECT_PARAMETERS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getObjectParameters()).basicAdd(otherEnd, msgs);
            case ClassesPackage.CLASS_TYPE_DEFINITION__OWNED_OBJECT_PARAMETERS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedObjectParameters()).basicAdd(otherEnd, msgs);
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
            case ClassesPackage.CLASS_TYPE_DEFINITION__CLAZZ:
                return basicSetClazz(null, msgs);
            case ClassesPackage.CLASS_TYPE_DEFINITION__ASSOCIATION_END:
                return basicSetAssociationEnd(null, msgs);
            case ClassesPackage.CLASS_TYPE_DEFINITION__OBJECT_PARAMETERS:
                return ((InternalEList<?>)getObjectParameters()).basicRemove(otherEnd, msgs);
            case ClassesPackage.CLASS_TYPE_DEFINITION__OWNED_OBJECT_PARAMETERS:
                return ((InternalEList<?>)getOwnedObjectParameters()).basicRemove(otherEnd, msgs);
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
            case ClassesPackage.CLASS_TYPE_DEFINITION__ASSOCIATION_END:
                return eInternalContainer().eInverseRemove(this, ClassesPackage.ASSOCIATION_END__TYPE, AssociationEnd.class, msgs);
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
            case ClassesPackage.CLASS_TYPE_DEFINITION__CLAZZ:
                if (resolve) return getClazz();
                return basicGetClazz();
            case ClassesPackage.CLASS_TYPE_DEFINITION__ASSOCIATION_END:
                if (resolve) return getAssociationEnd();
                return basicGetAssociationEnd();
            case ClassesPackage.CLASS_TYPE_DEFINITION__OBJECT_PARAMETERS:
                return getObjectParameters();
            case ClassesPackage.CLASS_TYPE_DEFINITION__OWNED_OBJECT_PARAMETERS:
                return getOwnedObjectParameters();
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
            case ClassesPackage.CLASS_TYPE_DEFINITION__CLAZZ:
                setClazz((SapClass)newValue);
                return;
            case ClassesPackage.CLASS_TYPE_DEFINITION__ASSOCIATION_END:
                setAssociationEnd((AssociationEnd)newValue);
                return;
            case ClassesPackage.CLASS_TYPE_DEFINITION__OBJECT_PARAMETERS:
                getObjectParameters().clear();
                getObjectParameters().addAll((Collection<? extends ActualObjectParameter>)newValue);
                return;
            case ClassesPackage.CLASS_TYPE_DEFINITION__OWNED_OBJECT_PARAMETERS:
                getOwnedObjectParameters().clear();
                getOwnedObjectParameters().addAll((Collection<? extends ActualObjectParameter>)newValue);
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
            case ClassesPackage.CLASS_TYPE_DEFINITION__CLAZZ:
                setClazz((SapClass)null);
                return;
            case ClassesPackage.CLASS_TYPE_DEFINITION__ASSOCIATION_END:
                setAssociationEnd((AssociationEnd)null);
                return;
            case ClassesPackage.CLASS_TYPE_DEFINITION__OBJECT_PARAMETERS:
                getObjectParameters().clear();
                return;
            case ClassesPackage.CLASS_TYPE_DEFINITION__OWNED_OBJECT_PARAMETERS:
                getOwnedObjectParameters().clear();
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
            case ClassesPackage.CLASS_TYPE_DEFINITION__CLAZZ:
                return clazz != null;
            case ClassesPackage.CLASS_TYPE_DEFINITION__ASSOCIATION_END:
                return basicGetAssociationEnd() != null;
            case ClassesPackage.CLASS_TYPE_DEFINITION__OBJECT_PARAMETERS:
                return objectParameters != null && !objectParameters.isEmpty();
            case ClassesPackage.CLASS_TYPE_DEFINITION__OWNED_OBJECT_PARAMETERS:
                return ownedObjectParameters != null && !ownedObjectParameters.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //ClassTypeDefinitionImpl

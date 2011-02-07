/**
 * <copyright>
 * </copyright>
 *
 * $Id: PackageImpl.java,v 1.1 2011/02/07 16:57:59 auhl Exp $
 */
package modelmanagement.impl;

import configuration.businessconfiguration.experimental.ConfigurationEntity;

import data.classes.Association;
import data.classes.ClassesPackage;
import data.classes.SapClass;

import data.generics.ClassParameterization;
import data.generics.GenericsPackage;

import integration.binding.Binding;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import modelmanagement.ModelmanagementPackage;

import modelmanagement.PackageOwner;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link modelmanagement.impl.PackageImpl#getAssociations <em>Associations</em>}</li>
 *   <li>{@link modelmanagement.impl.PackageImpl#getClasses <em>Classes</em>}</li>
 *   <li>{@link modelmanagement.impl.PackageImpl#getParameterizedClasses <em>Parameterized Classes</em>}</li>
 *   <li>{@link modelmanagement.impl.PackageImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link modelmanagement.impl.PackageImpl#getConfigurability <em>Configurability</em>}</li>
 *   <li>{@link modelmanagement.impl.PackageImpl#getBindings <em>Bindings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PackageImpl extends PackageOwnerImpl implements modelmanagement.Package {
	/**
     * The cached value of the '{@link #getAssociations() <em>Associations</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getAssociations()
     * @generated
     * @ordered
     */
	protected EList<Association> associations;

	/**
     * The cached value of the '{@link #getClasses() <em>Classes</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getClasses()
     * @generated
     * @ordered
     */
	protected EList<SapClass> classes;

	/**
     * The cached value of the '{@link #getParameterizedClasses() <em>Parameterized Classes</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getParameterizedClasses()
     * @generated
     * @ordered
     */
	protected EList<ClassParameterization> parameterizedClasses;

	/**
     * The cached value of the '{@link #getConfigurability() <em>Configurability</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getConfigurability()
     * @generated
     * @ordered
     */
	protected EList<ConfigurationEntity> configurability;

	/**
     * The cached value of the '{@link #getBindings() <em>Bindings</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getBindings()
     * @generated
     * @ordered
     */
	protected EList<Binding> bindings;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PackageImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ModelmanagementPackage.Literals.PACKAGE;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<Association> getAssociations() {
        if (associations == null) {
            associations = new EObjectContainmentWithInverseEList.Resolving<Association>(Association.class, this, ModelmanagementPackage.PACKAGE__ASSOCIATIONS, ClassesPackage.ASSOCIATION__PACKAGE_);
        }
        return associations;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<SapClass> getClasses() {
        if (classes == null) {
            classes = new EObjectContainmentWithInverseEList.Resolving<SapClass>(SapClass.class, this, ModelmanagementPackage.PACKAGE__CLASSES, ClassesPackage.SAP_CLASS__PACKAGE_);
        }
        return classes;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<ClassParameterization> getParameterizedClasses() {
        if (parameterizedClasses == null) {
            parameterizedClasses = new EObjectContainmentWithInverseEList.Resolving<ClassParameterization>(ClassParameterization.class, this, ModelmanagementPackage.PACKAGE__PARAMETERIZED_CLASSES, GenericsPackage.CLASS_PARAMETERIZATION__PACKAGE_);
        }
        return parameterizedClasses;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PackageOwner getOwner() {
        if (eContainerFeatureID() != ModelmanagementPackage.PACKAGE__OWNER) return null;
        return (PackageOwner)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PackageOwner basicGetOwner() {
        if (eContainerFeatureID() != ModelmanagementPackage.PACKAGE__OWNER) return null;
        return (PackageOwner)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetOwner(PackageOwner newOwner, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newOwner, ModelmanagementPackage.PACKAGE__OWNER, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setOwner(PackageOwner newOwner) {
        if (newOwner != eInternalContainer() || (eContainerFeatureID() != ModelmanagementPackage.PACKAGE__OWNER && newOwner != null)) {
            if (EcoreUtil.isAncestor(this, newOwner))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newOwner != null)
                msgs = ((InternalEObject)newOwner).eInverseAdd(this, ModelmanagementPackage.PACKAGE_OWNER__OWNED_PACKAGES, PackageOwner.class, msgs);
            msgs = basicSetOwner(newOwner, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ModelmanagementPackage.PACKAGE__OWNER, newOwner, newOwner));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<ConfigurationEntity> getConfigurability() {
        if (configurability == null) {
            configurability = new EObjectContainmentEList.Resolving<ConfigurationEntity>(ConfigurationEntity.class, this, ModelmanagementPackage.PACKAGE__CONFIGURABILITY);
        }
        return configurability;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<Binding> getBindings() {
        if (bindings == null) {
            bindings = new EObjectContainmentEList.Resolving<Binding>(Binding.class, this, ModelmanagementPackage.PACKAGE__BINDINGS);
        }
        return bindings;
    }

	/**
     * The cached invocation delegate for the '{@link #hasOwnershipCycle(org.eclipse.emf.common.util.EList) <em>Has Ownership Cycle</em>}' operation.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @see #hasOwnershipCycle(org.eclipse.emf.common.util.EList)
     * @generated
     * @ordered
     */
  protected static final EOperation.Internal.InvocationDelegate HAS_OWNERSHIP_CYCLE_ELIST__EINVOCATION_DELEGATE = ((EOperation.Internal)ModelmanagementPackage.Literals.PACKAGE.getEOperations().get(0)).getInvocationDelegate();

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public boolean hasOwnershipCycle(EList<modelmanagement.Package> pks)
  {
        try {
            return (Boolean)HAS_OWNERSHIP_CYCLE_ELIST__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{pks}));
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
            case ModelmanagementPackage.PACKAGE__ASSOCIATIONS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getAssociations()).basicAdd(otherEnd, msgs);
            case ModelmanagementPackage.PACKAGE__CLASSES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getClasses()).basicAdd(otherEnd, msgs);
            case ModelmanagementPackage.PACKAGE__PARAMETERIZED_CLASSES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getParameterizedClasses()).basicAdd(otherEnd, msgs);
            case ModelmanagementPackage.PACKAGE__OWNER:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetOwner((PackageOwner)otherEnd, msgs);
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
            case ModelmanagementPackage.PACKAGE__ASSOCIATIONS:
                return ((InternalEList<?>)getAssociations()).basicRemove(otherEnd, msgs);
            case ModelmanagementPackage.PACKAGE__CLASSES:
                return ((InternalEList<?>)getClasses()).basicRemove(otherEnd, msgs);
            case ModelmanagementPackage.PACKAGE__PARAMETERIZED_CLASSES:
                return ((InternalEList<?>)getParameterizedClasses()).basicRemove(otherEnd, msgs);
            case ModelmanagementPackage.PACKAGE__OWNER:
                return basicSetOwner(null, msgs);
            case ModelmanagementPackage.PACKAGE__CONFIGURABILITY:
                return ((InternalEList<?>)getConfigurability()).basicRemove(otherEnd, msgs);
            case ModelmanagementPackage.PACKAGE__BINDINGS:
                return ((InternalEList<?>)getBindings()).basicRemove(otherEnd, msgs);
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
            case ModelmanagementPackage.PACKAGE__OWNER:
                return eInternalContainer().eInverseRemove(this, ModelmanagementPackage.PACKAGE_OWNER__OWNED_PACKAGES, PackageOwner.class, msgs);
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
            case ModelmanagementPackage.PACKAGE__ASSOCIATIONS:
                return getAssociations();
            case ModelmanagementPackage.PACKAGE__CLASSES:
                return getClasses();
            case ModelmanagementPackage.PACKAGE__PARAMETERIZED_CLASSES:
                return getParameterizedClasses();
            case ModelmanagementPackage.PACKAGE__OWNER:
                if (resolve) return getOwner();
                return basicGetOwner();
            case ModelmanagementPackage.PACKAGE__CONFIGURABILITY:
                return getConfigurability();
            case ModelmanagementPackage.PACKAGE__BINDINGS:
                return getBindings();
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
            case ModelmanagementPackage.PACKAGE__ASSOCIATIONS:
                getAssociations().clear();
                getAssociations().addAll((Collection<? extends Association>)newValue);
                return;
            case ModelmanagementPackage.PACKAGE__CLASSES:
                getClasses().clear();
                getClasses().addAll((Collection<? extends SapClass>)newValue);
                return;
            case ModelmanagementPackage.PACKAGE__PARAMETERIZED_CLASSES:
                getParameterizedClasses().clear();
                getParameterizedClasses().addAll((Collection<? extends ClassParameterization>)newValue);
                return;
            case ModelmanagementPackage.PACKAGE__OWNER:
                setOwner((PackageOwner)newValue);
                return;
            case ModelmanagementPackage.PACKAGE__CONFIGURABILITY:
                getConfigurability().clear();
                getConfigurability().addAll((Collection<? extends ConfigurationEntity>)newValue);
                return;
            case ModelmanagementPackage.PACKAGE__BINDINGS:
                getBindings().clear();
                getBindings().addAll((Collection<? extends Binding>)newValue);
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
            case ModelmanagementPackage.PACKAGE__ASSOCIATIONS:
                getAssociations().clear();
                return;
            case ModelmanagementPackage.PACKAGE__CLASSES:
                getClasses().clear();
                return;
            case ModelmanagementPackage.PACKAGE__PARAMETERIZED_CLASSES:
                getParameterizedClasses().clear();
                return;
            case ModelmanagementPackage.PACKAGE__OWNER:
                setOwner((PackageOwner)null);
                return;
            case ModelmanagementPackage.PACKAGE__CONFIGURABILITY:
                getConfigurability().clear();
                return;
            case ModelmanagementPackage.PACKAGE__BINDINGS:
                getBindings().clear();
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
            case ModelmanagementPackage.PACKAGE__ASSOCIATIONS:
                return associations != null && !associations.isEmpty();
            case ModelmanagementPackage.PACKAGE__CLASSES:
                return classes != null && !classes.isEmpty();
            case ModelmanagementPackage.PACKAGE__PARAMETERIZED_CLASSES:
                return parameterizedClasses != null && !parameterizedClasses.isEmpty();
            case ModelmanagementPackage.PACKAGE__OWNER:
                return basicGetOwner() != null;
            case ModelmanagementPackage.PACKAGE__CONFIGURABILITY:
                return configurability != null && !configurability.isEmpty();
            case ModelmanagementPackage.PACKAGE__BINDINGS:
                return bindings != null && !bindings.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //PackageImpl

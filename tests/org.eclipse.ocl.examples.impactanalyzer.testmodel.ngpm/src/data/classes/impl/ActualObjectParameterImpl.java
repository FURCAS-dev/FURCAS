/**
 * <copyright>
 * </copyright>
 *
 * $Id: ActualObjectParameterImpl.java,v 1.1 2011/02/07 17:16:10 auhl Exp $
 */
package data.classes.impl;

import data.classes.ActualObjectParameter;
import data.classes.ClassTypeDefinition;
import data.classes.ClassesPackage;
import data.classes.Parameter;

import dataaccess.expressions.Expression;

import dataaccess.expressions.ExpressionsPackage;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Actual Object Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link data.classes.impl.ActualObjectParameterImpl#getFormalObjectParameter <em>Formal Object Parameter</em>}</li>
 *   <li>{@link data.classes.impl.ActualObjectParameterImpl#getClassTypeDefinitions <em>Class Type Definitions</em>}</li>
 *   <li>{@link data.classes.impl.ActualObjectParameterImpl#getValue <em>Value</em>}</li>
 *   <li>{@link data.classes.impl.ActualObjectParameterImpl#getOwningClassTypeDefinition <em>Owning Class Type Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActualObjectParameterImpl extends EObjectImpl implements ActualObjectParameter {
	/**
     * The cached value of the '{@link #getFormalObjectParameter() <em>Formal Object Parameter</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getFormalObjectParameter()
     * @generated
     * @ordered
     */
	protected Parameter formalObjectParameter;

	/**
     * The cached value of the '{@link #getClassTypeDefinitions() <em>Class Type Definitions</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getClassTypeDefinitions()
     * @generated
     * @ordered
     */
	protected EList<ClassTypeDefinition> classTypeDefinitions;

	/**
     * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getValue()
     * @generated
     * @ordered
     */
	protected Expression value;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ActualObjectParameterImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ClassesPackage.Literals.ACTUAL_OBJECT_PARAMETER;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Parameter getFormalObjectParameter() {
        if (formalObjectParameter != null && formalObjectParameter.eIsProxy()) {
            InternalEObject oldFormalObjectParameter = (InternalEObject)formalObjectParameter;
            formalObjectParameter = (Parameter)eResolveProxy(oldFormalObjectParameter);
            if (formalObjectParameter != oldFormalObjectParameter) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassesPackage.ACTUAL_OBJECT_PARAMETER__FORMAL_OBJECT_PARAMETER, oldFormalObjectParameter, formalObjectParameter));
            }
        }
        return formalObjectParameter;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Parameter basicGetFormalObjectParameter() {
        return formalObjectParameter;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setFormalObjectParameter(Parameter newFormalObjectParameter) {
        Parameter oldFormalObjectParameter = formalObjectParameter;
        formalObjectParameter = newFormalObjectParameter;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.ACTUAL_OBJECT_PARAMETER__FORMAL_OBJECT_PARAMETER, oldFormalObjectParameter, formalObjectParameter));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<ClassTypeDefinition> getClassTypeDefinitions() {
        if (classTypeDefinitions == null) {
            classTypeDefinitions = new EObjectWithInverseResolvingEList.ManyInverse<ClassTypeDefinition>(ClassTypeDefinition.class, this, ClassesPackage.ACTUAL_OBJECT_PARAMETER__CLASS_TYPE_DEFINITIONS, ClassesPackage.CLASS_TYPE_DEFINITION__OBJECT_PARAMETERS);
        }
        return classTypeDefinitions;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Expression getValue() {
        if (value != null && value.eIsProxy()) {
            InternalEObject oldValue = (InternalEObject)value;
            value = (Expression)eResolveProxy(oldValue);
            if (value != oldValue) {
                InternalEObject newValue = (InternalEObject)value;
                NotificationChain msgs =  oldValue.eInverseRemove(this, ExpressionsPackage.EXPRESSION__ACTUAL_OBJECT_PARAMETER, Expression.class, null);
                if (newValue.eInternalContainer() == null) {
                    msgs =  newValue.eInverseAdd(this, ExpressionsPackage.EXPRESSION__ACTUAL_OBJECT_PARAMETER, Expression.class, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassesPackage.ACTUAL_OBJECT_PARAMETER__VALUE, oldValue, value));
            }
        }
        return value;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Expression basicGetValue() {
        return value;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetValue(Expression newValue, NotificationChain msgs) {
        Expression oldValue = value;
        value = newValue;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassesPackage.ACTUAL_OBJECT_PARAMETER__VALUE, oldValue, newValue);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setValue(Expression newValue) {
        if (newValue != value) {
            NotificationChain msgs = null;
            if (value != null)
                msgs = ((InternalEObject)value).eInverseRemove(this, ExpressionsPackage.EXPRESSION__ACTUAL_OBJECT_PARAMETER, Expression.class, msgs);
            if (newValue != null)
                msgs = ((InternalEObject)newValue).eInverseAdd(this, ExpressionsPackage.EXPRESSION__ACTUAL_OBJECT_PARAMETER, Expression.class, msgs);
            msgs = basicSetValue(newValue, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.ACTUAL_OBJECT_PARAMETER__VALUE, newValue, newValue));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ClassTypeDefinition getOwningClassTypeDefinition() {
        if (eContainerFeatureID() != ClassesPackage.ACTUAL_OBJECT_PARAMETER__OWNING_CLASS_TYPE_DEFINITION) return null;
        return (ClassTypeDefinition)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ClassTypeDefinition basicGetOwningClassTypeDefinition() {
        if (eContainerFeatureID() != ClassesPackage.ACTUAL_OBJECT_PARAMETER__OWNING_CLASS_TYPE_DEFINITION) return null;
        return (ClassTypeDefinition)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetOwningClassTypeDefinition(ClassTypeDefinition newOwningClassTypeDefinition, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newOwningClassTypeDefinition, ClassesPackage.ACTUAL_OBJECT_PARAMETER__OWNING_CLASS_TYPE_DEFINITION, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setOwningClassTypeDefinition(ClassTypeDefinition newOwningClassTypeDefinition) {
        if (newOwningClassTypeDefinition != eInternalContainer() || (eContainerFeatureID() != ClassesPackage.ACTUAL_OBJECT_PARAMETER__OWNING_CLASS_TYPE_DEFINITION && newOwningClassTypeDefinition != null)) {
            if (EcoreUtil.isAncestor(this, newOwningClassTypeDefinition))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newOwningClassTypeDefinition != null)
                msgs = ((InternalEObject)newOwningClassTypeDefinition).eInverseAdd(this, ClassesPackage.CLASS_TYPE_DEFINITION__OWNED_OBJECT_PARAMETERS, ClassTypeDefinition.class, msgs);
            msgs = basicSetOwningClassTypeDefinition(newOwningClassTypeDefinition, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.ACTUAL_OBJECT_PARAMETER__OWNING_CLASS_TYPE_DEFINITION, newOwningClassTypeDefinition, newOwningClassTypeDefinition));
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
            case ClassesPackage.ACTUAL_OBJECT_PARAMETER__CLASS_TYPE_DEFINITIONS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getClassTypeDefinitions()).basicAdd(otherEnd, msgs);
            case ClassesPackage.ACTUAL_OBJECT_PARAMETER__VALUE:
                if (value != null)
                    msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ClassesPackage.ACTUAL_OBJECT_PARAMETER__VALUE, null, msgs);
                return basicSetValue((Expression)otherEnd, msgs);
            case ClassesPackage.ACTUAL_OBJECT_PARAMETER__OWNING_CLASS_TYPE_DEFINITION:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetOwningClassTypeDefinition((ClassTypeDefinition)otherEnd, msgs);
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
            case ClassesPackage.ACTUAL_OBJECT_PARAMETER__CLASS_TYPE_DEFINITIONS:
                return ((InternalEList<?>)getClassTypeDefinitions()).basicRemove(otherEnd, msgs);
            case ClassesPackage.ACTUAL_OBJECT_PARAMETER__VALUE:
                return basicSetValue(null, msgs);
            case ClassesPackage.ACTUAL_OBJECT_PARAMETER__OWNING_CLASS_TYPE_DEFINITION:
                return basicSetOwningClassTypeDefinition(null, msgs);
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
            case ClassesPackage.ACTUAL_OBJECT_PARAMETER__OWNING_CLASS_TYPE_DEFINITION:
                return eInternalContainer().eInverseRemove(this, ClassesPackage.CLASS_TYPE_DEFINITION__OWNED_OBJECT_PARAMETERS, ClassTypeDefinition.class, msgs);
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
            case ClassesPackage.ACTUAL_OBJECT_PARAMETER__FORMAL_OBJECT_PARAMETER:
                if (resolve) return getFormalObjectParameter();
                return basicGetFormalObjectParameter();
            case ClassesPackage.ACTUAL_OBJECT_PARAMETER__CLASS_TYPE_DEFINITIONS:
                return getClassTypeDefinitions();
            case ClassesPackage.ACTUAL_OBJECT_PARAMETER__VALUE:
                if (resolve) return getValue();
                return basicGetValue();
            case ClassesPackage.ACTUAL_OBJECT_PARAMETER__OWNING_CLASS_TYPE_DEFINITION:
                if (resolve) return getOwningClassTypeDefinition();
                return basicGetOwningClassTypeDefinition();
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
            case ClassesPackage.ACTUAL_OBJECT_PARAMETER__FORMAL_OBJECT_PARAMETER:
                setFormalObjectParameter((Parameter)newValue);
                return;
            case ClassesPackage.ACTUAL_OBJECT_PARAMETER__CLASS_TYPE_DEFINITIONS:
                getClassTypeDefinitions().clear();
                getClassTypeDefinitions().addAll((Collection<? extends ClassTypeDefinition>)newValue);
                return;
            case ClassesPackage.ACTUAL_OBJECT_PARAMETER__VALUE:
                setValue((Expression)newValue);
                return;
            case ClassesPackage.ACTUAL_OBJECT_PARAMETER__OWNING_CLASS_TYPE_DEFINITION:
                setOwningClassTypeDefinition((ClassTypeDefinition)newValue);
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
            case ClassesPackage.ACTUAL_OBJECT_PARAMETER__FORMAL_OBJECT_PARAMETER:
                setFormalObjectParameter((Parameter)null);
                return;
            case ClassesPackage.ACTUAL_OBJECT_PARAMETER__CLASS_TYPE_DEFINITIONS:
                getClassTypeDefinitions().clear();
                return;
            case ClassesPackage.ACTUAL_OBJECT_PARAMETER__VALUE:
                setValue((Expression)null);
                return;
            case ClassesPackage.ACTUAL_OBJECT_PARAMETER__OWNING_CLASS_TYPE_DEFINITION:
                setOwningClassTypeDefinition((ClassTypeDefinition)null);
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
            case ClassesPackage.ACTUAL_OBJECT_PARAMETER__FORMAL_OBJECT_PARAMETER:
                return formalObjectParameter != null;
            case ClassesPackage.ACTUAL_OBJECT_PARAMETER__CLASS_TYPE_DEFINITIONS:
                return classTypeDefinitions != null && !classTypeDefinitions.isEmpty();
            case ClassesPackage.ACTUAL_OBJECT_PARAMETER__VALUE:
                return value != null;
            case ClassesPackage.ACTUAL_OBJECT_PARAMETER__OWNING_CLASS_TYPE_DEFINITION:
                return basicGetOwningClassTypeDefinition() != null;
        }
        return super.eIsSet(featureID);
    }

} //ActualObjectParameterImpl

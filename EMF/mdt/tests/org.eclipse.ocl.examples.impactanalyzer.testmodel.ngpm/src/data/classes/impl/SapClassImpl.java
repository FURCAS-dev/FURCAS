/**
 * <copyright>
 * </copyright>
 *
 * $Id: SapClassImpl.java,v 1.1 2011/02/07 17:16:10 auhl Exp $
 */
package data.classes.impl;

import abapmapping.AbapClassImplementationAnnotation;

import behavioral.events.EventProducer;
import behavioral.events.EventsPackage;
import behavioral.events.Subscription;

import behavioral.status_and_action.assembly.AssemblyPackage;
import behavioral.status_and_action.assembly.StatusSchema;

import behavioral.status_and_action_old.SAMAction;
import behavioral.status_and_action_old.SAMDerivator;
import behavioral.status_and_action_old.SAMStatusSchema;
import behavioral.status_and_action_old.SAMStatusVariable;
import behavioral.status_and_action_old.Status_and_action_oldPackage;

import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.ClassesPackage;
import data.classes.ConverterBetweenParametrizations;
import data.classes.MethodSignature;
import data.classes.Parameter;
import data.classes.SapClass;
import data.classes.Signature;
import data.classes.TypeAdapter;

import data.constraints.Constraint;
import data.constraints.ConstraintsPackage;

import data.generics.ClassParameterization;
import data.generics.GenericsPackage;

import data.timedependency.TimeDependency;
import data.timedependency.TimedependencyPackage;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import modelmanagement.ModelmanagementPackage;

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
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sap Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link data.classes.impl.SapClassImpl#getSubscriptions <em>Subscriptions</em>}</li>
 *   <li>{@link data.classes.impl.SapClassImpl#getNotificationSignatures <em>Notification Signatures</em>}</li>
 *   <li>{@link data.classes.impl.SapClassImpl#getSubscription <em>Subscription</em>}</li>
 *   <li>{@link data.classes.impl.SapClassImpl#getSamActions <em>Sam Actions</em>}</li>
 *   <li>{@link data.classes.impl.SapClassImpl#getSamStatusVariables <em>Sam Status Variables</em>}</li>
 *   <li>{@link data.classes.impl.SapClassImpl#getSamDerivators <em>Sam Derivators</em>}</li>
 *   <li>{@link data.classes.impl.SapClassImpl#getSamStatusSchema <em>Sam Status Schema</em>}</li>
 *   <li>{@link data.classes.impl.SapClassImpl#getBehaviouralModel <em>Behavioural Model</em>}</li>
 *   <li>{@link data.classes.impl.SapClassImpl#isValueType <em>Value Type</em>}</li>
 *   <li>{@link data.classes.impl.SapClassImpl#getSignaturesWithFault <em>Signatures With Fault</em>}</li>
 *   <li>{@link data.classes.impl.SapClassImpl#getElementsOfType <em>Elements Of Type</em>}</li>
 *   <li>{@link data.classes.impl.SapClassImpl#getPackage_ <em>Package </em>}</li>
 *   <li>{@link data.classes.impl.SapClassImpl#getAdaptedBy <em>Adapted By</em>}</li>
 *   <li>{@link data.classes.impl.SapClassImpl#getAdapters <em>Adapters</em>}</li>
 *   <li>{@link data.classes.impl.SapClassImpl#getFormalObjectParameters <em>Formal Object Parameters</em>}</li>
 *   <li>{@link data.classes.impl.SapClassImpl#getConverterBetweenParametrizations <em>Converter Between Parametrizations</em>}</li>
 *   <li>{@link data.classes.impl.SapClassImpl#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link data.classes.impl.SapClassImpl#getTimeDependency <em>Time Dependency</em>}</li>
 *   <li>{@link data.classes.impl.SapClassImpl#getParameterization <em>Parameterization</em>}</li>
 *   <li>{@link data.classes.impl.SapClassImpl#getAbapAnnotation <em>Abap Annotation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SapClassImpl extends SignatureOwnerImpl implements SapClass {
	/**
     * The cached value of the '{@link #getSubscriptions() <em>Subscriptions</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSubscriptions()
     * @generated
     * @ordered
     */
	protected EList<Subscription> subscriptions;

	/**
     * The cached value of the '{@link #getNotificationSignatures() <em>Notification Signatures</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getNotificationSignatures()
     * @generated
     * @ordered
     */
	protected EList<MethodSignature> notificationSignatures;

	/**
     * The cached value of the '{@link #getSubscription() <em>Subscription</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSubscription()
     * @generated
     * @ordered
     */
	protected EList<Subscription> subscription;

	/**
     * The cached value of the '{@link #getSamActions() <em>Sam Actions</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSamActions()
     * @generated
     * @ordered
     */
	protected EList<SAMAction> samActions;

	/**
     * The cached value of the '{@link #getSamStatusVariables() <em>Sam Status Variables</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSamStatusVariables()
     * @generated
     * @ordered
     */
	protected EList<SAMStatusVariable> samStatusVariables;

	/**
     * The cached value of the '{@link #getSamDerivators() <em>Sam Derivators</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSamDerivators()
     * @generated
     * @ordered
     */
	protected EList<SAMDerivator> samDerivators;

	/**
     * The cached value of the '{@link #getSamStatusSchema() <em>Sam Status Schema</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSamStatusSchema()
     * @generated
     * @ordered
     */
	protected EList<SAMStatusSchema> samStatusSchema;

	/**
     * The cached value of the '{@link #getBehaviouralModel() <em>Behavioural Model</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getBehaviouralModel()
     * @generated
     * @ordered
     */
	protected EList<StatusSchema> behaviouralModel;

	/**
     * The default value of the '{@link #isValueType() <em>Value Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isValueType()
     * @generated
     * @ordered
     */
	protected static final boolean VALUE_TYPE_EDEFAULT = false;

	/**
     * The cached value of the '{@link #isValueType() <em>Value Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isValueType()
     * @generated
     * @ordered
     */
	protected boolean valueType = VALUE_TYPE_EDEFAULT;

	/**
     * The cached value of the '{@link #getSignaturesWithFault() <em>Signatures With Fault</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSignaturesWithFault()
     * @generated
     * @ordered
     */
	protected EList<Signature> signaturesWithFault;

	/**
     * The cached value of the '{@link #getElementsOfType() <em>Elements Of Type</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getElementsOfType()
     * @generated
     * @ordered
     */
	protected EList<ClassTypeDefinition> elementsOfType;

	/**
     * The cached value of the '{@link #getAdaptedBy() <em>Adapted By</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getAdaptedBy()
     * @generated
     * @ordered
     */
	protected EList<TypeAdapter> adaptedBy;

	/**
     * The cached value of the '{@link #getAdapters() <em>Adapters</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getAdapters()
     * @generated
     * @ordered
     */
	protected EList<TypeAdapter> adapters;

	/**
     * The cached value of the '{@link #getFormalObjectParameters() <em>Formal Object Parameters</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getFormalObjectParameters()
     * @generated
     * @ordered
     */
	protected EList<Parameter> formalObjectParameters;

	/**
     * The cached value of the '{@link #getConverterBetweenParametrizations() <em>Converter Between Parametrizations</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getConverterBetweenParametrizations()
     * @generated
     * @ordered
     */
	protected ConverterBetweenParametrizations converterBetweenParametrizations;

	/**
     * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getConstraints()
     * @generated
     * @ordered
     */
	protected EList<Constraint> constraints;

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
     * The cached value of the '{@link #getParameterization() <em>Parameterization</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getParameterization()
     * @generated
     * @ordered
     */
	protected ClassParameterization parameterization;

	/**
     * The cached value of the '{@link #getAbapAnnotation() <em>Abap Annotation</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getAbapAnnotation()
     * @generated
     * @ordered
     */
	protected AbapClassImplementationAnnotation abapAnnotation;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected SapClassImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ClassesPackage.Literals.SAP_CLASS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<Subscription> getSubscriptions() {
        if (subscriptions == null) {
            subscriptions = new EObjectWithInverseResolvingEList<Subscription>(Subscription.class, this, ClassesPackage.SAP_CLASS__SUBSCRIPTIONS, EventsPackage.SUBSCRIPTION__PRODUCER);
        }
        return subscriptions;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<MethodSignature> getNotificationSignatures() {
        if (notificationSignatures == null) {
            notificationSignatures = new EObjectContainmentWithInverseEList.Resolving<MethodSignature>(MethodSignature.class, this, ClassesPackage.SAP_CLASS__NOTIFICATION_SIGNATURES, ClassesPackage.METHOD_SIGNATURE__PRODUCER);
        }
        return notificationSignatures;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<Subscription> getSubscription() {
        if (subscription == null) {
            subscription = new EObjectContainmentWithInverseEList.Resolving<Subscription>(Subscription.class, this, ClassesPackage.SAP_CLASS__SUBSCRIPTION, EventsPackage.SUBSCRIPTION__SUBSCRIBING_CLASS);
        }
        return subscription;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<SAMAction> getSamActions() {
        if (samActions == null) {
            samActions = new EObjectContainmentWithInverseEList.Resolving<SAMAction>(SAMAction.class, this, ClassesPackage.SAP_CLASS__SAM_ACTIONS, Status_and_action_oldPackage.SAM_ACTION__BUSINESS_OBJECT_NODE);
        }
        return samActions;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<SAMStatusVariable> getSamStatusVariables() {
        if (samStatusVariables == null) {
            samStatusVariables = new EObjectContainmentWithInverseEList.Resolving<SAMStatusVariable>(SAMStatusVariable.class, this, ClassesPackage.SAP_CLASS__SAM_STATUS_VARIABLES, Status_and_action_oldPackage.SAM_STATUS_VARIABLE__BUSINESS_OBJECT_NODE);
        }
        return samStatusVariables;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<SAMDerivator> getSamDerivators() {
        if (samDerivators == null) {
            samDerivators = new EObjectContainmentWithInverseEList.Resolving<SAMDerivator>(SAMDerivator.class, this, ClassesPackage.SAP_CLASS__SAM_DERIVATORS, Status_and_action_oldPackage.SAM_DERIVATOR__BUSINESS_OBJECT);
        }
        return samDerivators;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<SAMStatusSchema> getSamStatusSchema() {
        if (samStatusSchema == null) {
            samStatusSchema = new EObjectContainmentWithInverseEList.Resolving<SAMStatusSchema>(SAMStatusSchema.class, this, ClassesPackage.SAP_CLASS__SAM_STATUS_SCHEMA, Status_and_action_oldPackage.SAM_STATUS_SCHEMA__BUSINESS_OBJECT_NODE);
        }
        return samStatusSchema;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<StatusSchema> getBehaviouralModel() {
        if (behaviouralModel == null) {
            behaviouralModel = new EObjectWithInverseResolvingEList<StatusSchema>(StatusSchema.class, this, ClassesPackage.SAP_CLASS__BEHAVIOURAL_MODEL, AssemblyPackage.STATUS_SCHEMA__NODE);
        }
        return behaviouralModel;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isValueType() {
        return valueType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setValueType(boolean newValueType) {
        boolean oldValueType = valueType;
        valueType = newValueType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.SAP_CLASS__VALUE_TYPE, oldValueType, valueType));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<Signature> getSignaturesWithFault() {
        if (signaturesWithFault == null) {
            signaturesWithFault = new EObjectWithInverseResolvingEList<Signature>(Signature.class, this, ClassesPackage.SAP_CLASS__SIGNATURES_WITH_FAULT, ClassesPackage.SIGNATURE__FAULTS);
        }
        return signaturesWithFault;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<ClassTypeDefinition> getElementsOfType() {
        if (elementsOfType == null) {
            elementsOfType = new EObjectWithInverseResolvingEList<ClassTypeDefinition>(ClassTypeDefinition.class, this, ClassesPackage.SAP_CLASS__ELEMENTS_OF_TYPE, ClassesPackage.CLASS_TYPE_DEFINITION__CLAZZ);
        }
        return elementsOfType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public modelmanagement.Package getPackage_() {
        if (eContainerFeatureID() != ClassesPackage.SAP_CLASS__PACKAGE_) return null;
        return (modelmanagement.Package)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public modelmanagement.Package basicGetPackage_() {
        if (eContainerFeatureID() != ClassesPackage.SAP_CLASS__PACKAGE_) return null;
        return (modelmanagement.Package)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetPackage_(modelmanagement.Package newPackage_, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newPackage_, ClassesPackage.SAP_CLASS__PACKAGE_, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setPackage_(modelmanagement.Package newPackage_) {
        if (newPackage_ != eInternalContainer() || (eContainerFeatureID() != ClassesPackage.SAP_CLASS__PACKAGE_ && newPackage_ != null)) {
            if (EcoreUtil.isAncestor(this, newPackage_))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newPackage_ != null)
                msgs = ((InternalEObject)newPackage_).eInverseAdd(this, ModelmanagementPackage.PACKAGE__CLASSES, modelmanagement.Package.class, msgs);
            msgs = basicSetPackage_(newPackage_, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.SAP_CLASS__PACKAGE_, newPackage_, newPackage_));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<TypeAdapter> getAdaptedBy() {
        if (adaptedBy == null) {
            adaptedBy = new EObjectWithInverseResolvingEList<TypeAdapter>(TypeAdapter.class, this, ClassesPackage.SAP_CLASS__ADAPTED_BY, ClassesPackage.TYPE_ADAPTER__TO);
        }
        return adaptedBy;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<TypeAdapter> getAdapters() {
        if (adapters == null) {
            adapters = new EObjectContainmentWithInverseEList.Resolving<TypeAdapter>(TypeAdapter.class, this, ClassesPackage.SAP_CLASS__ADAPTERS, ClassesPackage.TYPE_ADAPTER__ADAPTED);
        }
        return adapters;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<Parameter> getFormalObjectParameters() {
        if (formalObjectParameters == null) {
            formalObjectParameters = new EObjectContainmentWithInverseEList.Resolving<Parameter>(Parameter.class, this, ClassesPackage.SAP_CLASS__FORMAL_OBJECT_PARAMETERS, ClassesPackage.PARAMETER__PARAMETER_OF_CLASS);
        }
        return formalObjectParameters;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ConverterBetweenParametrizations getConverterBetweenParametrizations() {
        if (converterBetweenParametrizations != null && converterBetweenParametrizations.eIsProxy()) {
            InternalEObject oldConverterBetweenParametrizations = (InternalEObject)converterBetweenParametrizations;
            converterBetweenParametrizations = (ConverterBetweenParametrizations)eResolveProxy(oldConverterBetweenParametrizations);
            if (converterBetweenParametrizations != oldConverterBetweenParametrizations) {
                InternalEObject newConverterBetweenParametrizations = (InternalEObject)converterBetweenParametrizations;
                NotificationChain msgs =  oldConverterBetweenParametrizations.eInverseRemove(this, ClassesPackage.CONVERTER_BETWEEN_PARAMETRIZATIONS__CLAZZ, ConverterBetweenParametrizations.class, null);
                if (newConverterBetweenParametrizations.eInternalContainer() == null) {
                    msgs =  newConverterBetweenParametrizations.eInverseAdd(this, ClassesPackage.CONVERTER_BETWEEN_PARAMETRIZATIONS__CLAZZ, ConverterBetweenParametrizations.class, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassesPackage.SAP_CLASS__CONVERTER_BETWEEN_PARAMETRIZATIONS, oldConverterBetweenParametrizations, converterBetweenParametrizations));
            }
        }
        return converterBetweenParametrizations;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ConverterBetweenParametrizations basicGetConverterBetweenParametrizations() {
        return converterBetweenParametrizations;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetConverterBetweenParametrizations(ConverterBetweenParametrizations newConverterBetweenParametrizations, NotificationChain msgs) {
        ConverterBetweenParametrizations oldConverterBetweenParametrizations = converterBetweenParametrizations;
        converterBetweenParametrizations = newConverterBetweenParametrizations;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassesPackage.SAP_CLASS__CONVERTER_BETWEEN_PARAMETRIZATIONS, oldConverterBetweenParametrizations, newConverterBetweenParametrizations);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setConverterBetweenParametrizations(ConverterBetweenParametrizations newConverterBetweenParametrizations) {
        if (newConverterBetweenParametrizations != converterBetweenParametrizations) {
            NotificationChain msgs = null;
            if (converterBetweenParametrizations != null)
                msgs = ((InternalEObject)converterBetweenParametrizations).eInverseRemove(this, ClassesPackage.CONVERTER_BETWEEN_PARAMETRIZATIONS__CLAZZ, ConverterBetweenParametrizations.class, msgs);
            if (newConverterBetweenParametrizations != null)
                msgs = ((InternalEObject)newConverterBetweenParametrizations).eInverseAdd(this, ClassesPackage.CONVERTER_BETWEEN_PARAMETRIZATIONS__CLAZZ, ConverterBetweenParametrizations.class, msgs);
            msgs = basicSetConverterBetweenParametrizations(newConverterBetweenParametrizations, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.SAP_CLASS__CONVERTER_BETWEEN_PARAMETRIZATIONS, newConverterBetweenParametrizations, newConverterBetweenParametrizations));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<Constraint> getConstraints() {
        if (constraints == null) {
            constraints = new EObjectContainmentWithInverseEList.Resolving<Constraint>(Constraint.class, this, ClassesPackage.SAP_CLASS__CONSTRAINTS, ConstraintsPackage.CONSTRAINT__CONSTRAINED_TYPE);
        }
        return constraints;
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
                NotificationChain msgs =  oldTimeDependency.eInverseRemove(this, TimedependencyPackage.TIME_DEPENDENCY__THE_CLASS, TimeDependency.class, null);
                if (newTimeDependency.eInternalContainer() == null) {
                    msgs =  newTimeDependency.eInverseAdd(this, TimedependencyPackage.TIME_DEPENDENCY__THE_CLASS, TimeDependency.class, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassesPackage.SAP_CLASS__TIME_DEPENDENCY, oldTimeDependency, timeDependency));
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
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassesPackage.SAP_CLASS__TIME_DEPENDENCY, oldTimeDependency, newTimeDependency);
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
                msgs = ((InternalEObject)timeDependency).eInverseRemove(this, TimedependencyPackage.TIME_DEPENDENCY__THE_CLASS, TimeDependency.class, msgs);
            if (newTimeDependency != null)
                msgs = ((InternalEObject)newTimeDependency).eInverseAdd(this, TimedependencyPackage.TIME_DEPENDENCY__THE_CLASS, TimeDependency.class, msgs);
            msgs = basicSetTimeDependency(newTimeDependency, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.SAP_CLASS__TIME_DEPENDENCY, newTimeDependency, newTimeDependency));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ClassParameterization getParameterization() {
        if (parameterization != null && parameterization.eIsProxy()) {
            InternalEObject oldParameterization = (InternalEObject)parameterization;
            parameterization = (ClassParameterization)eResolveProxy(oldParameterization);
            if (parameterization != oldParameterization) {
                InternalEObject newParameterization = (InternalEObject)parameterization;
                NotificationChain msgs =  oldParameterization.eInverseRemove(this, GenericsPackage.CLASS_PARAMETERIZATION__OWNING_CLASS_DEFINITION, ClassParameterization.class, null);
                if (newParameterization.eInternalContainer() == null) {
                    msgs =  newParameterization.eInverseAdd(this, GenericsPackage.CLASS_PARAMETERIZATION__OWNING_CLASS_DEFINITION, ClassParameterization.class, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassesPackage.SAP_CLASS__PARAMETERIZATION, oldParameterization, parameterization));
            }
        }
        return parameterization;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ClassParameterization basicGetParameterization() {
        return parameterization;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetParameterization(ClassParameterization newParameterization, NotificationChain msgs) {
        ClassParameterization oldParameterization = parameterization;
        parameterization = newParameterization;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassesPackage.SAP_CLASS__PARAMETERIZATION, oldParameterization, newParameterization);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setParameterization(ClassParameterization newParameterization) {
        if (newParameterization != parameterization) {
            NotificationChain msgs = null;
            if (parameterization != null)
                msgs = ((InternalEObject)parameterization).eInverseRemove(this, GenericsPackage.CLASS_PARAMETERIZATION__OWNING_CLASS_DEFINITION, ClassParameterization.class, msgs);
            if (newParameterization != null)
                msgs = ((InternalEObject)newParameterization).eInverseAdd(this, GenericsPackage.CLASS_PARAMETERIZATION__OWNING_CLASS_DEFINITION, ClassParameterization.class, msgs);
            msgs = basicSetParameterization(newParameterization, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.SAP_CLASS__PARAMETERIZATION, newParameterization, newParameterization));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AbapClassImplementationAnnotation getAbapAnnotation() {
        if (abapAnnotation != null && abapAnnotation.eIsProxy()) {
            InternalEObject oldAbapAnnotation = (InternalEObject)abapAnnotation;
            abapAnnotation = (AbapClassImplementationAnnotation)eResolveProxy(oldAbapAnnotation);
            if (abapAnnotation != oldAbapAnnotation) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassesPackage.SAP_CLASS__ABAP_ANNOTATION, oldAbapAnnotation, abapAnnotation));
            }
        }
        return abapAnnotation;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AbapClassImplementationAnnotation basicGetAbapAnnotation() {
        return abapAnnotation;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setAbapAnnotation(AbapClassImplementationAnnotation newAbapAnnotation) {
        AbapClassImplementationAnnotation oldAbapAnnotation = abapAnnotation;
        abapAnnotation = newAbapAnnotation;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.SAP_CLASS__ABAP_ANNOTATION, oldAbapAnnotation, abapAnnotation));
    }

	/**
     * The cached invocation delegate for the '{@link #isAbstract() <em>Is Abstract</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isAbstract()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate IS_ABSTRACT__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.SAP_CLASS.getEOperations().get(0)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isAbstract() {
        try {
            return (Boolean)IS_ABSTRACT__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #isParameterizedClassDefinition() <em>Is Parameterized Class Definition</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isParameterizedClassDefinition()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate IS_PARAMETERIZED_CLASS_DEFINITION__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.SAP_CLASS.getEOperations().get(1)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isParameterizedClassDefinition() {
        try {
            return (Boolean)IS_PARAMETERIZED_CLASS_DEFINITION__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #conformsTo(data.classes.SapClass) <em>Conforms To</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #conformsTo(data.classes.SapClass)
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate CONFORMS_TO_SAP_CLASS__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.SAP_CLASS.getEOperations().get(2)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean conformsTo(SapClass type) {
        try {
            return (Boolean)CONFORMS_TO_SAP_CLASS__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{type}));
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #allSignatures() <em>All Signatures</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #allSignatures()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate ALL_SIGNATURES__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.SAP_CLASS.getEOperations().get(3)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<MethodSignature> allSignatures() {
        try {
            return (EList<MethodSignature>)ALL_SIGNATURES__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #delegatesTo() <em>Delegates To</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #delegatesTo()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate DELEGATES_TO__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.SAP_CLASS.getEOperations().get(4)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<SapClass> delegatesTo() {
        try {
            return (EList<SapClass>)DELEGATES_TO__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #conformsToExcluding(data.classes.SapClass, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>Conforms To Excluding</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #conformsToExcluding(data.classes.SapClass, org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList)
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate CONFORMS_TO_EXCLUDING_SAP_CLASS_ELIST_ELIST__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.SAP_CLASS.getEOperations().get(5)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean conformsToExcluding(SapClass type, EList<SapClass> excludingConforming, EList<SapClass> excludingTo) {
        try {
            return (Boolean)CONFORMS_TO_EXCLUDING_SAP_CLASS_ELIST_ELIST__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(3, new Object[]{type, excludingConforming, excludingTo}));
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #signaturesWithDelegation() <em>Signatures With Delegation</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #signaturesWithDelegation()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate SIGNATURES_WITH_DELEGATION__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.SAP_CLASS.getEOperations().get(6)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<MethodSignature> signaturesWithDelegation() {
        try {
            return (EList<MethodSignature>)SIGNATURES_WITH_DELEGATION__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #delegatedSignatures() <em>Delegated Signatures</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #delegatedSignatures()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate DELEGATED_SIGNATURES__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.SAP_CLASS.getEOperations().get(7)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<MethodSignature> delegatedSignatures() {
        try {
            return (EList<MethodSignature>)DELEGATED_SIGNATURES__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #adaptedSignatures() <em>Adapted Signatures</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #adaptedSignatures()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate ADAPTED_SIGNATURES__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.SAP_CLASS.getEOperations().get(8)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<MethodSignature> adaptedSignatures() {
        try {
            return (EList<MethodSignature>)ADAPTED_SIGNATURES__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #adaptedSignaturesExcluding(org.eclipse.emf.common.util.EList) <em>Adapted Signatures Excluding</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #adaptedSignaturesExcluding(org.eclipse.emf.common.util.EList)
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate ADAPTED_SIGNATURES_EXCLUDING_ELIST__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.SAP_CLASS.getEOperations().get(9)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<MethodSignature> adaptedSignaturesExcluding(EList<SapClass> excluding) {
        try {
            return (EList<MethodSignature>)ADAPTED_SIGNATURES_EXCLUDING_ELIST__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{excluding}));
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #allSignaturesExcluding(org.eclipse.emf.common.util.EList) <em>All Signatures Excluding</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #allSignaturesExcluding(org.eclipse.emf.common.util.EList)
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate ALL_SIGNATURES_EXCLUDING_ELIST__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.SAP_CLASS.getEOperations().get(10)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<MethodSignature> allSignaturesExcluding(EList<SapClass> excluding) {
        try {
            return (EList<MethodSignature>)ALL_SIGNATURES_EXCLUDING_ELIST__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{excluding}));
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #signaturesWithDelegationExcluding(org.eclipse.emf.common.util.EList) <em>Signatures With Delegation Excluding</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #signaturesWithDelegationExcluding(org.eclipse.emf.common.util.EList)
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate SIGNATURES_WITH_DELEGATION_EXCLUDING_ELIST__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.SAP_CLASS.getEOperations().get(11)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<MethodSignature> signaturesWithDelegationExcluding(EList<SapClass> excluding) {
        try {
            return (EList<MethodSignature>)SIGNATURES_WITH_DELEGATION_EXCLUDING_ELIST__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{excluding}));
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #delegatedSignaturesExcluding(org.eclipse.emf.common.util.EList) <em>Delegated Signatures Excluding</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #delegatedSignaturesExcluding(org.eclipse.emf.common.util.EList)
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate DELEGATED_SIGNATURES_EXCLUDING_ELIST__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.SAP_CLASS.getEOperations().get(12)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<MethodSignature> delegatedSignaturesExcluding(EList<SapClass> excluding) {
        try {
            return (EList<MethodSignature>)DELEGATED_SIGNATURES_EXCLUDING_ELIST__EINVOCATION_DELEGATE.dynamicInvoke(this, new BasicEList.UnmodifiableEList<Object>(1, new Object[]{excluding}));
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #getConformingClasses() <em>Get Conforming Classes</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getConformingClasses()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate GET_CONFORMING_CLASSES__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.SAP_CLASS.getEOperations().get(13)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<SapClass> getConformingClasses() {
        try {
            return (EList<SapClass>)GET_CONFORMING_CLASSES__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #getAssociationEnds() <em>Get Association Ends</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getAssociationEnds()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate GET_ASSOCIATION_ENDS__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.SAP_CLASS.getEOperations().get(14)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<AssociationEnd> getAssociationEnds() {
        try {
            return (EList<AssociationEnd>)GET_ASSOCIATION_ENDS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #getEqualityRelevantAssociationEnds() <em>Get Equality Relevant Association Ends</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getEqualityRelevantAssociationEnds()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate GET_EQUALITY_RELEVANT_ASSOCIATION_ENDS__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.SAP_CLASS.getEOperations().get(15)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<AssociationEnd> getEqualityRelevantAssociationEnds() {
        try {
            return (EList<AssociationEnd>)GET_EQUALITY_RELEVANT_ASSOCIATION_ENDS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #getConformsToClasses() <em>Get Conforms To Classes</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getConformsToClasses()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate GET_CONFORMS_TO_CLASSES__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.SAP_CLASS.getEOperations().get(16)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<SapClass> getConformsToClasses() {
        try {
            return (EList<SapClass>)GET_CONFORMS_TO_CLASSES__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #getConformsToAssociationEnds() <em>Get Conforms To Association Ends</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getConformsToAssociationEnds()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate GET_CONFORMS_TO_ASSOCIATION_ENDS__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.SAP_CLASS.getEOperations().get(17)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<AssociationEnd> getConformsToAssociationEnds() {
        try {
            return (EList<AssociationEnd>)GET_CONFORMS_TO_ASSOCIATION_ENDS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #getConformsToCompositeParentAssociationEnds() <em>Get Conforms To Composite Parent Association Ends</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getConformsToCompositeParentAssociationEnds()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate GET_CONFORMS_TO_COMPOSITE_PARENT_ASSOCIATION_ENDS__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.SAP_CLASS.getEOperations().get(18)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<AssociationEnd> getConformsToCompositeParentAssociationEnds() {
        try {
            return (EList<AssociationEnd>)GET_CONFORMS_TO_COMPOSITE_PARENT_ASSOCIATION_ENDS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * The cached invocation delegate for the '{@link #getConformsToCompositeChildAssociationEnds() <em>Get Conforms To Composite Child Association Ends</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getConformsToCompositeChildAssociationEnds()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate GET_CONFORMS_TO_COMPOSITE_CHILD_ASSOCIATION_ENDS__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.SAP_CLASS.getEOperations().get(19)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<AssociationEnd> getConformsToCompositeChildAssociationEnds() {
        try {
            return (EList<AssociationEnd>)GET_CONFORMS_TO_COMPOSITE_CHILD_ASSOCIATION_ENDS__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
            case ClassesPackage.SAP_CLASS__SUBSCRIPTIONS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubscriptions()).basicAdd(otherEnd, msgs);
            case ClassesPackage.SAP_CLASS__NOTIFICATION_SIGNATURES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getNotificationSignatures()).basicAdd(otherEnd, msgs);
            case ClassesPackage.SAP_CLASS__SUBSCRIPTION:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubscription()).basicAdd(otherEnd, msgs);
            case ClassesPackage.SAP_CLASS__SAM_ACTIONS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getSamActions()).basicAdd(otherEnd, msgs);
            case ClassesPackage.SAP_CLASS__SAM_STATUS_VARIABLES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getSamStatusVariables()).basicAdd(otherEnd, msgs);
            case ClassesPackage.SAP_CLASS__SAM_DERIVATORS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getSamDerivators()).basicAdd(otherEnd, msgs);
            case ClassesPackage.SAP_CLASS__SAM_STATUS_SCHEMA:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getSamStatusSchema()).basicAdd(otherEnd, msgs);
            case ClassesPackage.SAP_CLASS__BEHAVIOURAL_MODEL:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getBehaviouralModel()).basicAdd(otherEnd, msgs);
            case ClassesPackage.SAP_CLASS__SIGNATURES_WITH_FAULT:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getSignaturesWithFault()).basicAdd(otherEnd, msgs);
            case ClassesPackage.SAP_CLASS__ELEMENTS_OF_TYPE:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getElementsOfType()).basicAdd(otherEnd, msgs);
            case ClassesPackage.SAP_CLASS__PACKAGE_:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetPackage_((modelmanagement.Package)otherEnd, msgs);
            case ClassesPackage.SAP_CLASS__ADAPTED_BY:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getAdaptedBy()).basicAdd(otherEnd, msgs);
            case ClassesPackage.SAP_CLASS__ADAPTERS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getAdapters()).basicAdd(otherEnd, msgs);
            case ClassesPackage.SAP_CLASS__FORMAL_OBJECT_PARAMETERS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getFormalObjectParameters()).basicAdd(otherEnd, msgs);
            case ClassesPackage.SAP_CLASS__CONVERTER_BETWEEN_PARAMETRIZATIONS:
                if (converterBetweenParametrizations != null)
                    msgs = ((InternalEObject)converterBetweenParametrizations).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ClassesPackage.SAP_CLASS__CONVERTER_BETWEEN_PARAMETRIZATIONS, null, msgs);
                return basicSetConverterBetweenParametrizations((ConverterBetweenParametrizations)otherEnd, msgs);
            case ClassesPackage.SAP_CLASS__CONSTRAINTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getConstraints()).basicAdd(otherEnd, msgs);
            case ClassesPackage.SAP_CLASS__TIME_DEPENDENCY:
                if (timeDependency != null)
                    msgs = ((InternalEObject)timeDependency).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ClassesPackage.SAP_CLASS__TIME_DEPENDENCY, null, msgs);
                return basicSetTimeDependency((TimeDependency)otherEnd, msgs);
            case ClassesPackage.SAP_CLASS__PARAMETERIZATION:
                if (parameterization != null)
                    msgs = ((InternalEObject)parameterization).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ClassesPackage.SAP_CLASS__PARAMETERIZATION, null, msgs);
                return basicSetParameterization((ClassParameterization)otherEnd, msgs);
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
            case ClassesPackage.SAP_CLASS__SUBSCRIPTIONS:
                return ((InternalEList<?>)getSubscriptions()).basicRemove(otherEnd, msgs);
            case ClassesPackage.SAP_CLASS__NOTIFICATION_SIGNATURES:
                return ((InternalEList<?>)getNotificationSignatures()).basicRemove(otherEnd, msgs);
            case ClassesPackage.SAP_CLASS__SUBSCRIPTION:
                return ((InternalEList<?>)getSubscription()).basicRemove(otherEnd, msgs);
            case ClassesPackage.SAP_CLASS__SAM_ACTIONS:
                return ((InternalEList<?>)getSamActions()).basicRemove(otherEnd, msgs);
            case ClassesPackage.SAP_CLASS__SAM_STATUS_VARIABLES:
                return ((InternalEList<?>)getSamStatusVariables()).basicRemove(otherEnd, msgs);
            case ClassesPackage.SAP_CLASS__SAM_DERIVATORS:
                return ((InternalEList<?>)getSamDerivators()).basicRemove(otherEnd, msgs);
            case ClassesPackage.SAP_CLASS__SAM_STATUS_SCHEMA:
                return ((InternalEList<?>)getSamStatusSchema()).basicRemove(otherEnd, msgs);
            case ClassesPackage.SAP_CLASS__BEHAVIOURAL_MODEL:
                return ((InternalEList<?>)getBehaviouralModel()).basicRemove(otherEnd, msgs);
            case ClassesPackage.SAP_CLASS__SIGNATURES_WITH_FAULT:
                return ((InternalEList<?>)getSignaturesWithFault()).basicRemove(otherEnd, msgs);
            case ClassesPackage.SAP_CLASS__ELEMENTS_OF_TYPE:
                return ((InternalEList<?>)getElementsOfType()).basicRemove(otherEnd, msgs);
            case ClassesPackage.SAP_CLASS__PACKAGE_:
                return basicSetPackage_(null, msgs);
            case ClassesPackage.SAP_CLASS__ADAPTED_BY:
                return ((InternalEList<?>)getAdaptedBy()).basicRemove(otherEnd, msgs);
            case ClassesPackage.SAP_CLASS__ADAPTERS:
                return ((InternalEList<?>)getAdapters()).basicRemove(otherEnd, msgs);
            case ClassesPackage.SAP_CLASS__FORMAL_OBJECT_PARAMETERS:
                return ((InternalEList<?>)getFormalObjectParameters()).basicRemove(otherEnd, msgs);
            case ClassesPackage.SAP_CLASS__CONVERTER_BETWEEN_PARAMETRIZATIONS:
                return basicSetConverterBetweenParametrizations(null, msgs);
            case ClassesPackage.SAP_CLASS__CONSTRAINTS:
                return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
            case ClassesPackage.SAP_CLASS__TIME_DEPENDENCY:
                return basicSetTimeDependency(null, msgs);
            case ClassesPackage.SAP_CLASS__PARAMETERIZATION:
                return basicSetParameterization(null, msgs);
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
            case ClassesPackage.SAP_CLASS__PACKAGE_:
                return eInternalContainer().eInverseRemove(this, ModelmanagementPackage.PACKAGE__CLASSES, modelmanagement.Package.class, msgs);
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
            case ClassesPackage.SAP_CLASS__SUBSCRIPTIONS:
                return getSubscriptions();
            case ClassesPackage.SAP_CLASS__NOTIFICATION_SIGNATURES:
                return getNotificationSignatures();
            case ClassesPackage.SAP_CLASS__SUBSCRIPTION:
                return getSubscription();
            case ClassesPackage.SAP_CLASS__SAM_ACTIONS:
                return getSamActions();
            case ClassesPackage.SAP_CLASS__SAM_STATUS_VARIABLES:
                return getSamStatusVariables();
            case ClassesPackage.SAP_CLASS__SAM_DERIVATORS:
                return getSamDerivators();
            case ClassesPackage.SAP_CLASS__SAM_STATUS_SCHEMA:
                return getSamStatusSchema();
            case ClassesPackage.SAP_CLASS__BEHAVIOURAL_MODEL:
                return getBehaviouralModel();
            case ClassesPackage.SAP_CLASS__VALUE_TYPE:
                return isValueType();
            case ClassesPackage.SAP_CLASS__SIGNATURES_WITH_FAULT:
                return getSignaturesWithFault();
            case ClassesPackage.SAP_CLASS__ELEMENTS_OF_TYPE:
                return getElementsOfType();
            case ClassesPackage.SAP_CLASS__PACKAGE_:
                if (resolve) return getPackage_();
                return basicGetPackage_();
            case ClassesPackage.SAP_CLASS__ADAPTED_BY:
                return getAdaptedBy();
            case ClassesPackage.SAP_CLASS__ADAPTERS:
                return getAdapters();
            case ClassesPackage.SAP_CLASS__FORMAL_OBJECT_PARAMETERS:
                return getFormalObjectParameters();
            case ClassesPackage.SAP_CLASS__CONVERTER_BETWEEN_PARAMETRIZATIONS:
                if (resolve) return getConverterBetweenParametrizations();
                return basicGetConverterBetweenParametrizations();
            case ClassesPackage.SAP_CLASS__CONSTRAINTS:
                return getConstraints();
            case ClassesPackage.SAP_CLASS__TIME_DEPENDENCY:
                if (resolve) return getTimeDependency();
                return basicGetTimeDependency();
            case ClassesPackage.SAP_CLASS__PARAMETERIZATION:
                if (resolve) return getParameterization();
                return basicGetParameterization();
            case ClassesPackage.SAP_CLASS__ABAP_ANNOTATION:
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
            case ClassesPackage.SAP_CLASS__SUBSCRIPTIONS:
                getSubscriptions().clear();
                getSubscriptions().addAll((Collection<? extends Subscription>)newValue);
                return;
            case ClassesPackage.SAP_CLASS__NOTIFICATION_SIGNATURES:
                getNotificationSignatures().clear();
                getNotificationSignatures().addAll((Collection<? extends MethodSignature>)newValue);
                return;
            case ClassesPackage.SAP_CLASS__SUBSCRIPTION:
                getSubscription().clear();
                getSubscription().addAll((Collection<? extends Subscription>)newValue);
                return;
            case ClassesPackage.SAP_CLASS__SAM_ACTIONS:
                getSamActions().clear();
                getSamActions().addAll((Collection<? extends SAMAction>)newValue);
                return;
            case ClassesPackage.SAP_CLASS__SAM_STATUS_VARIABLES:
                getSamStatusVariables().clear();
                getSamStatusVariables().addAll((Collection<? extends SAMStatusVariable>)newValue);
                return;
            case ClassesPackage.SAP_CLASS__SAM_DERIVATORS:
                getSamDerivators().clear();
                getSamDerivators().addAll((Collection<? extends SAMDerivator>)newValue);
                return;
            case ClassesPackage.SAP_CLASS__SAM_STATUS_SCHEMA:
                getSamStatusSchema().clear();
                getSamStatusSchema().addAll((Collection<? extends SAMStatusSchema>)newValue);
                return;
            case ClassesPackage.SAP_CLASS__BEHAVIOURAL_MODEL:
                getBehaviouralModel().clear();
                getBehaviouralModel().addAll((Collection<? extends StatusSchema>)newValue);
                return;
            case ClassesPackage.SAP_CLASS__VALUE_TYPE:
                setValueType((Boolean)newValue);
                return;
            case ClassesPackage.SAP_CLASS__SIGNATURES_WITH_FAULT:
                getSignaturesWithFault().clear();
                getSignaturesWithFault().addAll((Collection<? extends Signature>)newValue);
                return;
            case ClassesPackage.SAP_CLASS__ELEMENTS_OF_TYPE:
                getElementsOfType().clear();
                getElementsOfType().addAll((Collection<? extends ClassTypeDefinition>)newValue);
                return;
            case ClassesPackage.SAP_CLASS__PACKAGE_:
                setPackage_((modelmanagement.Package)newValue);
                return;
            case ClassesPackage.SAP_CLASS__ADAPTED_BY:
                getAdaptedBy().clear();
                getAdaptedBy().addAll((Collection<? extends TypeAdapter>)newValue);
                return;
            case ClassesPackage.SAP_CLASS__ADAPTERS:
                getAdapters().clear();
                getAdapters().addAll((Collection<? extends TypeAdapter>)newValue);
                return;
            case ClassesPackage.SAP_CLASS__FORMAL_OBJECT_PARAMETERS:
                getFormalObjectParameters().clear();
                getFormalObjectParameters().addAll((Collection<? extends Parameter>)newValue);
                return;
            case ClassesPackage.SAP_CLASS__CONVERTER_BETWEEN_PARAMETRIZATIONS:
                setConverterBetweenParametrizations((ConverterBetweenParametrizations)newValue);
                return;
            case ClassesPackage.SAP_CLASS__CONSTRAINTS:
                getConstraints().clear();
                getConstraints().addAll((Collection<? extends Constraint>)newValue);
                return;
            case ClassesPackage.SAP_CLASS__TIME_DEPENDENCY:
                setTimeDependency((TimeDependency)newValue);
                return;
            case ClassesPackage.SAP_CLASS__PARAMETERIZATION:
                setParameterization((ClassParameterization)newValue);
                return;
            case ClassesPackage.SAP_CLASS__ABAP_ANNOTATION:
                setAbapAnnotation((AbapClassImplementationAnnotation)newValue);
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
            case ClassesPackage.SAP_CLASS__SUBSCRIPTIONS:
                getSubscriptions().clear();
                return;
            case ClassesPackage.SAP_CLASS__NOTIFICATION_SIGNATURES:
                getNotificationSignatures().clear();
                return;
            case ClassesPackage.SAP_CLASS__SUBSCRIPTION:
                getSubscription().clear();
                return;
            case ClassesPackage.SAP_CLASS__SAM_ACTIONS:
                getSamActions().clear();
                return;
            case ClassesPackage.SAP_CLASS__SAM_STATUS_VARIABLES:
                getSamStatusVariables().clear();
                return;
            case ClassesPackage.SAP_CLASS__SAM_DERIVATORS:
                getSamDerivators().clear();
                return;
            case ClassesPackage.SAP_CLASS__SAM_STATUS_SCHEMA:
                getSamStatusSchema().clear();
                return;
            case ClassesPackage.SAP_CLASS__BEHAVIOURAL_MODEL:
                getBehaviouralModel().clear();
                return;
            case ClassesPackage.SAP_CLASS__VALUE_TYPE:
                setValueType(VALUE_TYPE_EDEFAULT);
                return;
            case ClassesPackage.SAP_CLASS__SIGNATURES_WITH_FAULT:
                getSignaturesWithFault().clear();
                return;
            case ClassesPackage.SAP_CLASS__ELEMENTS_OF_TYPE:
                getElementsOfType().clear();
                return;
            case ClassesPackage.SAP_CLASS__PACKAGE_:
                setPackage_((modelmanagement.Package)null);
                return;
            case ClassesPackage.SAP_CLASS__ADAPTED_BY:
                getAdaptedBy().clear();
                return;
            case ClassesPackage.SAP_CLASS__ADAPTERS:
                getAdapters().clear();
                return;
            case ClassesPackage.SAP_CLASS__FORMAL_OBJECT_PARAMETERS:
                getFormalObjectParameters().clear();
                return;
            case ClassesPackage.SAP_CLASS__CONVERTER_BETWEEN_PARAMETRIZATIONS:
                setConverterBetweenParametrizations((ConverterBetweenParametrizations)null);
                return;
            case ClassesPackage.SAP_CLASS__CONSTRAINTS:
                getConstraints().clear();
                return;
            case ClassesPackage.SAP_CLASS__TIME_DEPENDENCY:
                setTimeDependency((TimeDependency)null);
                return;
            case ClassesPackage.SAP_CLASS__PARAMETERIZATION:
                setParameterization((ClassParameterization)null);
                return;
            case ClassesPackage.SAP_CLASS__ABAP_ANNOTATION:
                setAbapAnnotation((AbapClassImplementationAnnotation)null);
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
            case ClassesPackage.SAP_CLASS__SUBSCRIPTIONS:
                return subscriptions != null && !subscriptions.isEmpty();
            case ClassesPackage.SAP_CLASS__NOTIFICATION_SIGNATURES:
                return notificationSignatures != null && !notificationSignatures.isEmpty();
            case ClassesPackage.SAP_CLASS__SUBSCRIPTION:
                return subscription != null && !subscription.isEmpty();
            case ClassesPackage.SAP_CLASS__SAM_ACTIONS:
                return samActions != null && !samActions.isEmpty();
            case ClassesPackage.SAP_CLASS__SAM_STATUS_VARIABLES:
                return samStatusVariables != null && !samStatusVariables.isEmpty();
            case ClassesPackage.SAP_CLASS__SAM_DERIVATORS:
                return samDerivators != null && !samDerivators.isEmpty();
            case ClassesPackage.SAP_CLASS__SAM_STATUS_SCHEMA:
                return samStatusSchema != null && !samStatusSchema.isEmpty();
            case ClassesPackage.SAP_CLASS__BEHAVIOURAL_MODEL:
                return behaviouralModel != null && !behaviouralModel.isEmpty();
            case ClassesPackage.SAP_CLASS__VALUE_TYPE:
                return valueType != VALUE_TYPE_EDEFAULT;
            case ClassesPackage.SAP_CLASS__SIGNATURES_WITH_FAULT:
                return signaturesWithFault != null && !signaturesWithFault.isEmpty();
            case ClassesPackage.SAP_CLASS__ELEMENTS_OF_TYPE:
                return elementsOfType != null && !elementsOfType.isEmpty();
            case ClassesPackage.SAP_CLASS__PACKAGE_:
                return basicGetPackage_() != null;
            case ClassesPackage.SAP_CLASS__ADAPTED_BY:
                return adaptedBy != null && !adaptedBy.isEmpty();
            case ClassesPackage.SAP_CLASS__ADAPTERS:
                return adapters != null && !adapters.isEmpty();
            case ClassesPackage.SAP_CLASS__FORMAL_OBJECT_PARAMETERS:
                return formalObjectParameters != null && !formalObjectParameters.isEmpty();
            case ClassesPackage.SAP_CLASS__CONVERTER_BETWEEN_PARAMETRIZATIONS:
                return converterBetweenParametrizations != null;
            case ClassesPackage.SAP_CLASS__CONSTRAINTS:
                return constraints != null && !constraints.isEmpty();
            case ClassesPackage.SAP_CLASS__TIME_DEPENDENCY:
                return timeDependency != null;
            case ClassesPackage.SAP_CLASS__PARAMETERIZATION:
                return parameterization != null;
            case ClassesPackage.SAP_CLASS__ABAP_ANNOTATION:
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
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
        if (baseClass == EventProducer.class) {
            switch (derivedFeatureID) {
                case ClassesPackage.SAP_CLASS__SUBSCRIPTIONS: return EventsPackage.EVENT_PRODUCER__SUBSCRIPTIONS;
                case ClassesPackage.SAP_CLASS__NOTIFICATION_SIGNATURES: return EventsPackage.EVENT_PRODUCER__NOTIFICATION_SIGNATURES;
                default: return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
        if (baseClass == EventProducer.class) {
            switch (baseFeatureID) {
                case EventsPackage.EVENT_PRODUCER__SUBSCRIPTIONS: return ClassesPackage.SAP_CLASS__SUBSCRIPTIONS;
                case EventsPackage.EVENT_PRODUCER__NOTIFICATION_SIGNATURES: return ClassesPackage.SAP_CLASS__NOTIFICATION_SIGNATURES;
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
        result.append(" (valueType: ");
        result.append(valueType);
        result.append(')');
        return result.toString();
    }

} //SapClassImpl

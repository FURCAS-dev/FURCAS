/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.impl;

import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorList;
import com.sap.furcas.metamodel.FURCAS.TCS.Sequence;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;
import com.sap.furcas.metamodel.FURCAS.TCS.TemplateModifiers;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ClassTemplateImpl#getTemplateSequence <em>Template Sequence</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ClassTemplateImpl#getModifiers <em>Modifiers</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ClassTemplateImpl#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ClassTemplateImpl#isIsDeep <em>Is Deep</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ClassTemplateImpl#getPrefixSequence <em>Prefix Sequence</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ClassTemplateImpl#isIsOperatored <em>Is Operatored</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ClassTemplateImpl#getOperatorList <em>Operator List</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ClassTemplateImpl#isIsMain <em>Is Main</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ClassTemplateImpl#isIsMulti <em>Is Multi</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ClassTemplateImpl#isIsNonPrimary <em>Is Non Primary</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ClassTemplateImpl#getMode <em>Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassTemplateImpl extends ContextTemplateImpl implements ClassTemplate {
        /**
	 * The cached value of the '{@link #getTemplateSequence() <em>Template Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getTemplateSequence()
	 * @generated
	 * @ordered
	 */
        protected Sequence templateSequence;

        /**
	 * The cached value of the '{@link #getModifiers() <em>Modifiers</em>}' attribute list.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getModifiers()
	 * @generated
	 * @ordered
	 */
        protected EList<TemplateModifiers> modifiers;

        /**
	 * The default value of the '{@link #isIsAbstract() <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #isIsAbstract()
	 * @generated
	 * @ordered
	 */
        protected static final boolean IS_ABSTRACT_EDEFAULT = false;

        /**
	 * The cached value of the '{@link #isIsAbstract() <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #isIsAbstract()
	 * @generated
	 * @ordered
	 */
        protected boolean isAbstract = IS_ABSTRACT_EDEFAULT;

        /**
	 * The default value of the '{@link #isIsDeep() <em>Is Deep</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #isIsDeep()
	 * @generated
	 * @ordered
	 */
        protected static final boolean IS_DEEP_EDEFAULT = false;

        /**
	 * The cached value of the '{@link #isIsDeep() <em>Is Deep</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #isIsDeep()
	 * @generated
	 * @ordered
	 */
        protected boolean isDeep = IS_DEEP_EDEFAULT;

        /**
	 * The cached value of the '{@link #getPrefixSequence() <em>Prefix Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getPrefixSequence()
	 * @generated
	 * @ordered
	 */
        protected Sequence prefixSequence;

        /**
	 * The default value of the '{@link #isIsOperatored() <em>Is Operatored</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #isIsOperatored()
	 * @generated
	 * @ordered
	 */
        protected static final boolean IS_OPERATORED_EDEFAULT = false;

        /**
	 * The cached value of the '{@link #isIsOperatored() <em>Is Operatored</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #isIsOperatored()
	 * @generated
	 * @ordered
	 */
        protected boolean isOperatored = IS_OPERATORED_EDEFAULT;

        /**
	 * The cached value of the '{@link #getOperatorList() <em>Operator List</em>}' reference.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getOperatorList()
	 * @generated
	 * @ordered
	 */
        protected OperatorList operatorList;

        /**
	 * The default value of the '{@link #isIsMain() <em>Is Main</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #isIsMain()
	 * @generated
	 * @ordered
	 */
        protected static final boolean IS_MAIN_EDEFAULT = false;

        /**
	 * The cached value of the '{@link #isIsMain() <em>Is Main</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #isIsMain()
	 * @generated
	 * @ordered
	 */
        protected boolean isMain = IS_MAIN_EDEFAULT;

        /**
	 * The default value of the '{@link #isIsMulti() <em>Is Multi</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #isIsMulti()
	 * @generated
	 * @ordered
	 */
        protected static final boolean IS_MULTI_EDEFAULT = false;

        /**
	 * The cached value of the '{@link #isIsMulti() <em>Is Multi</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #isIsMulti()
	 * @generated
	 * @ordered
	 */
        protected boolean isMulti = IS_MULTI_EDEFAULT;

        /**
	 * The default value of the '{@link #isIsNonPrimary() <em>Is Non Primary</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #isIsNonPrimary()
	 * @generated
	 * @ordered
	 */
        protected static final boolean IS_NON_PRIMARY_EDEFAULT = false;

        /**
	 * The cached value of the '{@link #isIsNonPrimary() <em>Is Non Primary</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #isIsNonPrimary()
	 * @generated
	 * @ordered
	 */
        protected boolean isNonPrimary = IS_NON_PRIMARY_EDEFAULT;

        /**
	 * The default value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
        protected static final String MODE_EDEFAULT = null;

        /**
	 * The cached value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
        protected String mode = MODE_EDEFAULT;

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        protected ClassTemplateImpl() {
		super();
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        protected EClass eStaticClass() {
		return TCSPackage.Literals.CLASS_TEMPLATE;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public Sequence getTemplateSequence() {
		return templateSequence;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public NotificationChain basicSetTemplateSequence(Sequence newTemplateSequence, NotificationChain msgs) {
		Sequence oldTemplateSequence = templateSequence;
		templateSequence = newTemplateSequence;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TCSPackage.CLASS_TEMPLATE__TEMPLATE_SEQUENCE, oldTemplateSequence, newTemplateSequence);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setTemplateSequence(Sequence newTemplateSequence) {
		if (newTemplateSequence != templateSequence) {
			NotificationChain msgs = null;
			if (templateSequence != null)
				msgs = ((InternalEObject)templateSequence).eInverseRemove(this, TCSPackage.SEQUENCE__TEMPLATE_CONTAINER, Sequence.class, msgs);
			if (newTemplateSequence != null)
				msgs = ((InternalEObject)newTemplateSequence).eInverseAdd(this, TCSPackage.SEQUENCE__TEMPLATE_CONTAINER, Sequence.class, msgs);
			msgs = basicSetTemplateSequence(newTemplateSequence, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.CLASS_TEMPLATE__TEMPLATE_SEQUENCE, newTemplateSequence, newTemplateSequence));
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public EList<TemplateModifiers> getModifiers() {
		if (modifiers == null) {
			modifiers = new EDataTypeEList<TemplateModifiers>(TemplateModifiers.class, this, TCSPackage.CLASS_TEMPLATE__MODIFIERS);
		}
		return modifiers;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public boolean isIsAbstract() {
		return isAbstract;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setIsAbstract(boolean newIsAbstract) {
		boolean oldIsAbstract = isAbstract;
		isAbstract = newIsAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.CLASS_TEMPLATE__IS_ABSTRACT, oldIsAbstract, isAbstract));
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public boolean isIsDeep() {
		return isDeep;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setIsDeep(boolean newIsDeep) {
		boolean oldIsDeep = isDeep;
		isDeep = newIsDeep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.CLASS_TEMPLATE__IS_DEEP, oldIsDeep, isDeep));
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public Sequence getPrefixSequence() {
		return prefixSequence;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public NotificationChain basicSetPrefixSequence(Sequence newPrefixSequence, NotificationChain msgs) {
		Sequence oldPrefixSequence = prefixSequence;
		prefixSequence = newPrefixSequence;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TCSPackage.CLASS_TEMPLATE__PREFIX_SEQUENCE, oldPrefixSequence, newPrefixSequence);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setPrefixSequence(Sequence newPrefixSequence) {
		if (newPrefixSequence != prefixSequence) {
			NotificationChain msgs = null;
			if (prefixSequence != null)
				msgs = ((InternalEObject)prefixSequence).eInverseRemove(this, TCSPackage.SEQUENCE__PREFIX_CONTAINER, Sequence.class, msgs);
			if (newPrefixSequence != null)
				msgs = ((InternalEObject)newPrefixSequence).eInverseAdd(this, TCSPackage.SEQUENCE__PREFIX_CONTAINER, Sequence.class, msgs);
			msgs = basicSetPrefixSequence(newPrefixSequence, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.CLASS_TEMPLATE__PREFIX_SEQUENCE, newPrefixSequence, newPrefixSequence));
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public boolean isIsOperatored() {
		return isOperatored;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setIsOperatored(boolean newIsOperatored) {
		boolean oldIsOperatored = isOperatored;
		isOperatored = newIsOperatored;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.CLASS_TEMPLATE__IS_OPERATORED, oldIsOperatored, isOperatored));
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public OperatorList getOperatorList() {
		if (operatorList != null && operatorList.eIsProxy()) {
			InternalEObject oldOperatorList = (InternalEObject)operatorList;
			operatorList = (OperatorList)eResolveProxy(oldOperatorList);
			if (operatorList != oldOperatorList) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TCSPackage.CLASS_TEMPLATE__OPERATOR_LIST, oldOperatorList, operatorList));
			}
		}
		return operatorList;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public OperatorList basicGetOperatorList() {
		return operatorList;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setOperatorList(OperatorList newOperatorList) {
		OperatorList oldOperatorList = operatorList;
		operatorList = newOperatorList;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.CLASS_TEMPLATE__OPERATOR_LIST, oldOperatorList, operatorList));
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public boolean isIsMain() {
		return isMain;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setIsMain(boolean newIsMain) {
		boolean oldIsMain = isMain;
		isMain = newIsMain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.CLASS_TEMPLATE__IS_MAIN, oldIsMain, isMain));
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public boolean isIsMulti() {
		return isMulti;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setIsMulti(boolean newIsMulti) {
		boolean oldIsMulti = isMulti;
		isMulti = newIsMulti;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.CLASS_TEMPLATE__IS_MULTI, oldIsMulti, isMulti));
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public boolean isIsNonPrimary() {
		return isNonPrimary;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setIsNonPrimary(boolean newIsNonPrimary) {
		boolean oldIsNonPrimary = isNonPrimary;
		isNonPrimary = newIsNonPrimary;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.CLASS_TEMPLATE__IS_NON_PRIMARY, oldIsNonPrimary, isNonPrimary));
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public String getMode() {
		return mode;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setMode(String newMode) {
		String oldMode = mode;
		mode = newMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.CLASS_TEMPLATE__MODE, oldMode, mode));
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        @Override
        public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TCSPackage.CLASS_TEMPLATE__TEMPLATE_SEQUENCE:
				if (templateSequence != null)
					msgs = ((InternalEObject)templateSequence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TCSPackage.CLASS_TEMPLATE__TEMPLATE_SEQUENCE, null, msgs);
				return basicSetTemplateSequence((Sequence)otherEnd, msgs);
			case TCSPackage.CLASS_TEMPLATE__PREFIX_SEQUENCE:
				if (prefixSequence != null)
					msgs = ((InternalEObject)prefixSequence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TCSPackage.CLASS_TEMPLATE__PREFIX_SEQUENCE, null, msgs);
				return basicSetPrefixSequence((Sequence)otherEnd, msgs);
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
			case TCSPackage.CLASS_TEMPLATE__TEMPLATE_SEQUENCE:
				return basicSetTemplateSequence(null, msgs);
			case TCSPackage.CLASS_TEMPLATE__PREFIX_SEQUENCE:
				return basicSetPrefixSequence(null, msgs);
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
			case TCSPackage.CLASS_TEMPLATE__TEMPLATE_SEQUENCE:
				return getTemplateSequence();
			case TCSPackage.CLASS_TEMPLATE__MODIFIERS:
				return getModifiers();
			case TCSPackage.CLASS_TEMPLATE__IS_ABSTRACT:
				return isIsAbstract();
			case TCSPackage.CLASS_TEMPLATE__IS_DEEP:
				return isIsDeep();
			case TCSPackage.CLASS_TEMPLATE__PREFIX_SEQUENCE:
				return getPrefixSequence();
			case TCSPackage.CLASS_TEMPLATE__IS_OPERATORED:
				return isIsOperatored();
			case TCSPackage.CLASS_TEMPLATE__OPERATOR_LIST:
				if (resolve) return getOperatorList();
				return basicGetOperatorList();
			case TCSPackage.CLASS_TEMPLATE__IS_MAIN:
				return isIsMain();
			case TCSPackage.CLASS_TEMPLATE__IS_MULTI:
				return isIsMulti();
			case TCSPackage.CLASS_TEMPLATE__IS_NON_PRIMARY:
				return isIsNonPrimary();
			case TCSPackage.CLASS_TEMPLATE__MODE:
				return getMode();
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
			case TCSPackage.CLASS_TEMPLATE__TEMPLATE_SEQUENCE:
				setTemplateSequence((Sequence)newValue);
				return;
			case TCSPackage.CLASS_TEMPLATE__MODIFIERS:
				getModifiers().clear();
				getModifiers().addAll((Collection<? extends TemplateModifiers>)newValue);
				return;
			case TCSPackage.CLASS_TEMPLATE__IS_ABSTRACT:
				setIsAbstract((Boolean)newValue);
				return;
			case TCSPackage.CLASS_TEMPLATE__IS_DEEP:
				setIsDeep((Boolean)newValue);
				return;
			case TCSPackage.CLASS_TEMPLATE__PREFIX_SEQUENCE:
				setPrefixSequence((Sequence)newValue);
				return;
			case TCSPackage.CLASS_TEMPLATE__IS_OPERATORED:
				setIsOperatored((Boolean)newValue);
				return;
			case TCSPackage.CLASS_TEMPLATE__OPERATOR_LIST:
				setOperatorList((OperatorList)newValue);
				return;
			case TCSPackage.CLASS_TEMPLATE__IS_MAIN:
				setIsMain((Boolean)newValue);
				return;
			case TCSPackage.CLASS_TEMPLATE__IS_MULTI:
				setIsMulti((Boolean)newValue);
				return;
			case TCSPackage.CLASS_TEMPLATE__IS_NON_PRIMARY:
				setIsNonPrimary((Boolean)newValue);
				return;
			case TCSPackage.CLASS_TEMPLATE__MODE:
				setMode((String)newValue);
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
			case TCSPackage.CLASS_TEMPLATE__TEMPLATE_SEQUENCE:
				setTemplateSequence((Sequence)null);
				return;
			case TCSPackage.CLASS_TEMPLATE__MODIFIERS:
				getModifiers().clear();
				return;
			case TCSPackage.CLASS_TEMPLATE__IS_ABSTRACT:
				setIsAbstract(IS_ABSTRACT_EDEFAULT);
				return;
			case TCSPackage.CLASS_TEMPLATE__IS_DEEP:
				setIsDeep(IS_DEEP_EDEFAULT);
				return;
			case TCSPackage.CLASS_TEMPLATE__PREFIX_SEQUENCE:
				setPrefixSequence((Sequence)null);
				return;
			case TCSPackage.CLASS_TEMPLATE__IS_OPERATORED:
				setIsOperatored(IS_OPERATORED_EDEFAULT);
				return;
			case TCSPackage.CLASS_TEMPLATE__OPERATOR_LIST:
				setOperatorList((OperatorList)null);
				return;
			case TCSPackage.CLASS_TEMPLATE__IS_MAIN:
				setIsMain(IS_MAIN_EDEFAULT);
				return;
			case TCSPackage.CLASS_TEMPLATE__IS_MULTI:
				setIsMulti(IS_MULTI_EDEFAULT);
				return;
			case TCSPackage.CLASS_TEMPLATE__IS_NON_PRIMARY:
				setIsNonPrimary(IS_NON_PRIMARY_EDEFAULT);
				return;
			case TCSPackage.CLASS_TEMPLATE__MODE:
				setMode(MODE_EDEFAULT);
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
			case TCSPackage.CLASS_TEMPLATE__TEMPLATE_SEQUENCE:
				return templateSequence != null;
			case TCSPackage.CLASS_TEMPLATE__MODIFIERS:
				return modifiers != null && !modifiers.isEmpty();
			case TCSPackage.CLASS_TEMPLATE__IS_ABSTRACT:
				return isAbstract != IS_ABSTRACT_EDEFAULT;
			case TCSPackage.CLASS_TEMPLATE__IS_DEEP:
				return isDeep != IS_DEEP_EDEFAULT;
			case TCSPackage.CLASS_TEMPLATE__PREFIX_SEQUENCE:
				return prefixSequence != null;
			case TCSPackage.CLASS_TEMPLATE__IS_OPERATORED:
				return isOperatored != IS_OPERATORED_EDEFAULT;
			case TCSPackage.CLASS_TEMPLATE__OPERATOR_LIST:
				return operatorList != null;
			case TCSPackage.CLASS_TEMPLATE__IS_MAIN:
				return isMain != IS_MAIN_EDEFAULT;
			case TCSPackage.CLASS_TEMPLATE__IS_MULTI:
				return isMulti != IS_MULTI_EDEFAULT;
			case TCSPackage.CLASS_TEMPLATE__IS_NON_PRIMARY:
				return isNonPrimary != IS_NON_PRIMARY_EDEFAULT;
			case TCSPackage.CLASS_TEMPLATE__MODE:
				return MODE_EDEFAULT == null ? mode != null : !MODE_EDEFAULT.equals(mode);
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
		result.append(" (modifiers: ");
		result.append(modifiers);
		result.append(", isAbstract: ");
		result.append(isAbstract);
		result.append(", isDeep: ");
		result.append(isDeep);
		result.append(", isOperatored: ");
		result.append(isOperatored);
		result.append(", isMain: ");
		result.append(isMain);
		result.append(", isMulti: ");
		result.append(isMulti);
		result.append(", isNonPrimary: ");
		result.append(isNonPrimary);
		result.append(", mode: ");
		result.append(mode);
		result.append(')');
		return result.toString();
	}

} //ClassTemplateImpl

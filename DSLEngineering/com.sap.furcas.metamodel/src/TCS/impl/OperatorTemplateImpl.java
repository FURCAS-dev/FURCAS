/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package TCS.impl;

import TCS.Operator;
import TCS.OperatorTemplate;
import TCS.Sequence;
import TCS.TCSPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operator Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link TCS.impl.OperatorTemplateImpl#getOperators <em>Operators</em>}</li>
 *   <li>{@link TCS.impl.OperatorTemplateImpl#getSource <em>Source</em>}</li>
 *   <li>{@link TCS.impl.OperatorTemplateImpl#getStoreOpTo <em>Store Op To</em>}</li>
 *   <li>{@link TCS.impl.OperatorTemplateImpl#getStoreRightTo <em>Store Right To</em>}</li>
 *   <li>{@link TCS.impl.OperatorTemplateImpl#getOtSequence <em>Ot Sequence</em>}</li>
 *   <li>{@link TCS.impl.OperatorTemplateImpl#isIsContext <em>Is Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperatorTemplateImpl extends TemplateImpl implements OperatorTemplate {
	/**
	 * The cached value of the '{@link #getOperators() <em>Operators</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperators()
	 * @generated
	 * @ordered
	 */
	protected EList<Operator> operators;

	/**
	 * The default value of the '{@link #getSource() <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected String source = SOURCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStoreOpTo() <em>Store Op To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStoreOpTo()
	 * @generated
	 * @ordered
	 */
	protected static final String STORE_OP_TO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStoreOpTo() <em>Store Op To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStoreOpTo()
	 * @generated
	 * @ordered
	 */
	protected String storeOpTo = STORE_OP_TO_EDEFAULT;

	/**
	 * The default value of the '{@link #getStoreRightTo() <em>Store Right To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStoreRightTo()
	 * @generated
	 * @ordered
	 */
	protected static final String STORE_RIGHT_TO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStoreRightTo() <em>Store Right To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStoreRightTo()
	 * @generated
	 * @ordered
	 */
	protected String storeRightTo = STORE_RIGHT_TO_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOtSequence() <em>Ot Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOtSequence()
	 * @generated
	 * @ordered
	 */
	protected Sequence otSequence;

	/**
	 * The default value of the '{@link #isIsContext() <em>Is Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsContext()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_CONTEXT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsContext() <em>Is Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsContext()
	 * @generated
	 * @ordered
	 */
	protected boolean isContext = IS_CONTEXT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperatorTemplateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TCSPackage.Literals.OPERATOR_TEMPLATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Operator> getOperators() {
		if (operators == null) {
			operators = new EObjectWithInverseResolvingEList.ManyInverse<Operator>(Operator.class, this, TCSPackage.OPERATOR_TEMPLATE__OPERATORS, TCSPackage.OPERATOR__TEMPLATES);
		}
		return operators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(String newSource) {
		String oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.OPERATOR_TEMPLATE__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStoreOpTo() {
		return storeOpTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStoreOpTo(String newStoreOpTo) {
		String oldStoreOpTo = storeOpTo;
		storeOpTo = newStoreOpTo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.OPERATOR_TEMPLATE__STORE_OP_TO, oldStoreOpTo, storeOpTo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStoreRightTo() {
		return storeRightTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStoreRightTo(String newStoreRightTo) {
		String oldStoreRightTo = storeRightTo;
		storeRightTo = newStoreRightTo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.OPERATOR_TEMPLATE__STORE_RIGHT_TO, oldStoreRightTo, storeRightTo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sequence getOtSequence() {
		return otSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOtSequence(Sequence newOtSequence, NotificationChain msgs) {
		Sequence oldOtSequence = otSequence;
		otSequence = newOtSequence;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TCSPackage.OPERATOR_TEMPLATE__OT_SEQUENCE, oldOtSequence, newOtSequence);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOtSequence(Sequence newOtSequence) {
		if (newOtSequence != otSequence) {
			NotificationChain msgs = null;
			if (otSequence != null)
				msgs = ((InternalEObject)otSequence).eInverseRemove(this, TCSPackage.SEQUENCE__OT_CONTAINER, Sequence.class, msgs);
			if (newOtSequence != null)
				msgs = ((InternalEObject)newOtSequence).eInverseAdd(this, TCSPackage.SEQUENCE__OT_CONTAINER, Sequence.class, msgs);
			msgs = basicSetOtSequence(newOtSequence, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.OPERATOR_TEMPLATE__OT_SEQUENCE, newOtSequence, newOtSequence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsContext() {
		return isContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsContext(boolean newIsContext) {
		boolean oldIsContext = isContext;
		isContext = newIsContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.OPERATOR_TEMPLATE__IS_CONTEXT, oldIsContext, isContext));
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
			case TCSPackage.OPERATOR_TEMPLATE__OPERATORS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOperators()).basicAdd(otherEnd, msgs);
			case TCSPackage.OPERATOR_TEMPLATE__OT_SEQUENCE:
				if (otSequence != null)
					msgs = ((InternalEObject)otSequence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TCSPackage.OPERATOR_TEMPLATE__OT_SEQUENCE, null, msgs);
				return basicSetOtSequence((Sequence)otherEnd, msgs);
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
			case TCSPackage.OPERATOR_TEMPLATE__OPERATORS:
				return ((InternalEList<?>)getOperators()).basicRemove(otherEnd, msgs);
			case TCSPackage.OPERATOR_TEMPLATE__OT_SEQUENCE:
				return basicSetOtSequence(null, msgs);
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
			case TCSPackage.OPERATOR_TEMPLATE__OPERATORS:
				return getOperators();
			case TCSPackage.OPERATOR_TEMPLATE__SOURCE:
				return getSource();
			case TCSPackage.OPERATOR_TEMPLATE__STORE_OP_TO:
				return getStoreOpTo();
			case TCSPackage.OPERATOR_TEMPLATE__STORE_RIGHT_TO:
				return getStoreRightTo();
			case TCSPackage.OPERATOR_TEMPLATE__OT_SEQUENCE:
				return getOtSequence();
			case TCSPackage.OPERATOR_TEMPLATE__IS_CONTEXT:
				return isIsContext();
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
			case TCSPackage.OPERATOR_TEMPLATE__OPERATORS:
				getOperators().clear();
				getOperators().addAll((Collection<? extends Operator>)newValue);
				return;
			case TCSPackage.OPERATOR_TEMPLATE__SOURCE:
				setSource((String)newValue);
				return;
			case TCSPackage.OPERATOR_TEMPLATE__STORE_OP_TO:
				setStoreOpTo((String)newValue);
				return;
			case TCSPackage.OPERATOR_TEMPLATE__STORE_RIGHT_TO:
				setStoreRightTo((String)newValue);
				return;
			case TCSPackage.OPERATOR_TEMPLATE__OT_SEQUENCE:
				setOtSequence((Sequence)newValue);
				return;
			case TCSPackage.OPERATOR_TEMPLATE__IS_CONTEXT:
				setIsContext((Boolean)newValue);
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
			case TCSPackage.OPERATOR_TEMPLATE__OPERATORS:
				getOperators().clear();
				return;
			case TCSPackage.OPERATOR_TEMPLATE__SOURCE:
				setSource(SOURCE_EDEFAULT);
				return;
			case TCSPackage.OPERATOR_TEMPLATE__STORE_OP_TO:
				setStoreOpTo(STORE_OP_TO_EDEFAULT);
				return;
			case TCSPackage.OPERATOR_TEMPLATE__STORE_RIGHT_TO:
				setStoreRightTo(STORE_RIGHT_TO_EDEFAULT);
				return;
			case TCSPackage.OPERATOR_TEMPLATE__OT_SEQUENCE:
				setOtSequence((Sequence)null);
				return;
			case TCSPackage.OPERATOR_TEMPLATE__IS_CONTEXT:
				setIsContext(IS_CONTEXT_EDEFAULT);
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
			case TCSPackage.OPERATOR_TEMPLATE__OPERATORS:
				return operators != null && !operators.isEmpty();
			case TCSPackage.OPERATOR_TEMPLATE__SOURCE:
				return SOURCE_EDEFAULT == null ? source != null : !SOURCE_EDEFAULT.equals(source);
			case TCSPackage.OPERATOR_TEMPLATE__STORE_OP_TO:
				return STORE_OP_TO_EDEFAULT == null ? storeOpTo != null : !STORE_OP_TO_EDEFAULT.equals(storeOpTo);
			case TCSPackage.OPERATOR_TEMPLATE__STORE_RIGHT_TO:
				return STORE_RIGHT_TO_EDEFAULT == null ? storeRightTo != null : !STORE_RIGHT_TO_EDEFAULT.equals(storeRightTo);
			case TCSPackage.OPERATOR_TEMPLATE__OT_SEQUENCE:
				return otSequence != null;
			case TCSPackage.OPERATOR_TEMPLATE__IS_CONTEXT:
				return isContext != IS_CONTEXT_EDEFAULT;
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
		result.append(" (source: ");
		result.append(source);
		result.append(", storeOpTo: ");
		result.append(storeOpTo);
		result.append(", storeRightTo: ");
		result.append(storeRightTo);
		result.append(", isContext: ");
		result.append(isContext);
		result.append(')');
		return result.toString();
	}

} //OperatorTemplateImpl
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;
import de.hpi.sam.bp2009.benchframework.EndOperator;
import de.hpi.sam.bp2009.benchframework.OptionObject;
import de.hpi.sam.bp2009.benchframework.ResultObject;
import de.hpi.sam.bp2009.benchframework.StartOperator;
import de.hpi.sam.bp2009.benchframework.TestRun;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Start Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.impl.StartOperatorImpl#getOption <em>Option</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.impl.StartOperatorImpl#getResult <em>Result</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.impl.StartOperatorImpl#getTestRun <em>Test Run</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.impl.StartOperatorImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.impl.StartOperatorImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.impl.StartOperatorImpl#getEndOperator <em>End Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class StartOperatorImpl extends EObjectImpl implements StartOperator {
	/**
	 * The cached value of the '{@link #getOption() <em>Option</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOption()
	 * @generated
	 * @ordered
	 */
	protected OptionObject option;

	/**
	 * The cached value of the '{@link #getResult() <em>Result</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResult()
	 * @generated
	 * @ordered
	 */
	protected ResultObject result;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEndOperator() <em>End Operator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndOperator()
	 * @generated
	 * @ordered
	 */
	protected EndOperator endOperator;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StartOperatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BenchframeworkPackage.Literals.START_OPERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OptionObject getOption() {
		return option;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOption(OptionObject newOption, NotificationChain msgs) {
		OptionObject oldOption = option;
		option = newOption;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BenchframeworkPackage.START_OPERATOR__OPTION, oldOption, newOption);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOption(OptionObject newOption) {
		if (newOption != option) {
			NotificationChain msgs = null;
			if (option != null)
				msgs = ((InternalEObject)option).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BenchframeworkPackage.START_OPERATOR__OPTION, null, msgs);
			if (newOption != null)
				msgs = ((InternalEObject)newOption).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BenchframeworkPackage.START_OPERATOR__OPTION, null, msgs);
			msgs = basicSetOption(newOption, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BenchframeworkPackage.START_OPERATOR__OPTION, newOption, newOption));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultObject getResult() {
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResult(ResultObject newResult, NotificationChain msgs) {
		ResultObject oldResult = result;
		result = newResult;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BenchframeworkPackage.START_OPERATOR__RESULT, oldResult, newResult);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResult(ResultObject newResult) {
		if (newResult != result) {
			NotificationChain msgs = null;
			if (result != null)
				msgs = ((InternalEObject)result).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BenchframeworkPackage.START_OPERATOR__RESULT, null, msgs);
			if (newResult != null)
				msgs = ((InternalEObject)newResult).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BenchframeworkPackage.START_OPERATOR__RESULT, null, msgs);
			msgs = basicSetResult(newResult, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BenchframeworkPackage.START_OPERATOR__RESULT, newResult, newResult));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestRun getTestRun() {
		if (eContainerFeatureID() != BenchframeworkPackage.START_OPERATOR__TEST_RUN) return null;
		return (TestRun)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public NotificationChain basicSetTestRun(TestRun newTestRun, NotificationChain msgs) {
		/*
		 * Start and EndOperator always in the same Testrun
		 */
		if(getEndOperator()!=null)
			getEndOperator().setTestRun(newTestRun);
		msgs = eBasicSetContainer((InternalEObject)newTestRun, BenchframeworkPackage.START_OPERATOR__TEST_RUN, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTestRun(TestRun newTestRun) {
		if (newTestRun != eInternalContainer() || (eContainerFeatureID() != BenchframeworkPackage.START_OPERATOR__TEST_RUN && newTestRun != null)) {
			if (EcoreUtil.isAncestor(this, newTestRun))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTestRun != null)
				msgs = ((InternalEObject)newTestRun).eInverseAdd(this, BenchframeworkPackage.TEST_RUN__OPERATORS, TestRun.class, msgs);
			msgs = basicSetTestRun(newTestRun, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BenchframeworkPackage.START_OPERATOR__TEST_RUN, newTestRun, newTestRun));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BenchframeworkPackage.START_OPERATOR__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BenchframeworkPackage.START_OPERATOR__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndOperator getEndOperator() {
		if (endOperator != null && endOperator.eIsProxy()) {
			InternalEObject oldEndOperator = (InternalEObject)endOperator;
			endOperator = (EndOperator)eResolveProxy(oldEndOperator);
			if (endOperator != oldEndOperator) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BenchframeworkPackage.START_OPERATOR__END_OPERATOR, oldEndOperator, endOperator));
			}
		}
		return endOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndOperator basicGetEndOperator() {
		return endOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public NotificationChain basicSetEndOperator(EndOperator newEndOperator, NotificationChain msgs) {
		EndOperator oldEndOperator = endOperator;
		endOperator = newEndOperator;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BenchframeworkPackage.START_OPERATOR__END_OPERATOR, oldEndOperator, newEndOperator);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		/*
		 * Remove the old Operator from the Testrun and move the new in my TestRun
		 */
		if(oldEndOperator!=null)
			oldEndOperator.setTestRun(null);
		if(newEndOperator!=null)
			newEndOperator.setTestRun(getTestRun());
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndOperator(EndOperator newEndOperator) {
		if (newEndOperator != endOperator) {
			NotificationChain msgs = null;
			if (endOperator != null)
				msgs = ((InternalEObject)endOperator).eInverseRemove(this, BenchframeworkPackage.END_OPERATOR__START_OPERATOR, EndOperator.class, msgs);
			if (newEndOperator != null)
				msgs = ((InternalEObject)newEndOperator).eInverseAdd(this, BenchframeworkPackage.END_OPERATOR__START_OPERATOR, EndOperator.class, msgs);
			msgs = basicSetEndOperator(newEndOperator, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BenchframeworkPackage.START_OPERATOR__END_OPERATOR, newEndOperator, newEndOperator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract EndOperator createEndOperator();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract void execute();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BenchframeworkPackage.START_OPERATOR__TEST_RUN:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTestRun((TestRun)otherEnd, msgs);
			case BenchframeworkPackage.START_OPERATOR__END_OPERATOR:
				if (endOperator != null)
					msgs = ((InternalEObject)endOperator).eInverseRemove(this, BenchframeworkPackage.END_OPERATOR__START_OPERATOR, EndOperator.class, msgs);
				return basicSetEndOperator((EndOperator)otherEnd, msgs);
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
			case BenchframeworkPackage.START_OPERATOR__OPTION:
				return basicSetOption(null, msgs);
			case BenchframeworkPackage.START_OPERATOR__RESULT:
				return basicSetResult(null, msgs);
			case BenchframeworkPackage.START_OPERATOR__TEST_RUN:
				return basicSetTestRun(null, msgs);
			case BenchframeworkPackage.START_OPERATOR__END_OPERATOR:
				return basicSetEndOperator(null, msgs);
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
			case BenchframeworkPackage.START_OPERATOR__TEST_RUN:
				return eInternalContainer().eInverseRemove(this, BenchframeworkPackage.TEST_RUN__OPERATORS, TestRun.class, msgs);
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
			case BenchframeworkPackage.START_OPERATOR__OPTION:
				return getOption();
			case BenchframeworkPackage.START_OPERATOR__RESULT:
				return getResult();
			case BenchframeworkPackage.START_OPERATOR__TEST_RUN:
				return getTestRun();
			case BenchframeworkPackage.START_OPERATOR__NAME:
				return getName();
			case BenchframeworkPackage.START_OPERATOR__DESCRIPTION:
				return getDescription();
			case BenchframeworkPackage.START_OPERATOR__END_OPERATOR:
				if (resolve) return getEndOperator();
				return basicGetEndOperator();
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
			case BenchframeworkPackage.START_OPERATOR__OPTION:
				setOption((OptionObject)newValue);
				return;
			case BenchframeworkPackage.START_OPERATOR__RESULT:
				setResult((ResultObject)newValue);
				return;
			case BenchframeworkPackage.START_OPERATOR__TEST_RUN:
				setTestRun((TestRun)newValue);
				return;
			case BenchframeworkPackage.START_OPERATOR__NAME:
				setName((String)newValue);
				return;
			case BenchframeworkPackage.START_OPERATOR__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case BenchframeworkPackage.START_OPERATOR__END_OPERATOR:
				setEndOperator((EndOperator)newValue);
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
			case BenchframeworkPackage.START_OPERATOR__OPTION:
				setOption((OptionObject)null);
				return;
			case BenchframeworkPackage.START_OPERATOR__RESULT:
				setResult((ResultObject)null);
				return;
			case BenchframeworkPackage.START_OPERATOR__TEST_RUN:
				setTestRun((TestRun)null);
				return;
			case BenchframeworkPackage.START_OPERATOR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case BenchframeworkPackage.START_OPERATOR__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case BenchframeworkPackage.START_OPERATOR__END_OPERATOR:
				setEndOperator((EndOperator)null);
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
			case BenchframeworkPackage.START_OPERATOR__OPTION:
				return option != null;
			case BenchframeworkPackage.START_OPERATOR__RESULT:
				return result != null;
			case BenchframeworkPackage.START_OPERATOR__TEST_RUN:
				return getTestRun() != null;
			case BenchframeworkPackage.START_OPERATOR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case BenchframeworkPackage.START_OPERATOR__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case BenchframeworkPackage.START_OPERATOR__END_OPERATOR:
				return endOperator != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //StartOperatorImpl

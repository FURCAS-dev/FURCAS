/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import de.hpi.sam.bp2009.benchframework.BenchframeworkFactory;
import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;
import de.hpi.sam.bp2009.benchframework.OptionObject;
import de.hpi.sam.bp2009.benchframework.ResultObject;
import de.hpi.sam.bp2009.benchframework.Status;
import de.hpi.sam.bp2009.benchframework.TestRun;
import de.hpi.sam.bp2009.benchframework.modifiedEventManager.EmbedModifiedEMOperator;
import de.hpi.sam.bp2009.benchframework.modifiedEventManager.ModifiedEventManagerFactory;
import de.hpi.sam.bp2009.benchframework.modifiedEventManager.ModifiedEventManagerPackage;
import de.hpi.sam.bp2009.solution.eventManager.EventManager;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Embed Modified EM Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl.EmbedModifiedEMOperatorImpl#getOption <em>Option</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl.EmbedModifiedEMOperatorImpl#getResult <em>Result</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl.EmbedModifiedEMOperatorImpl#getTestRun <em>Test Run</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl.EmbedModifiedEMOperatorImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl.EmbedModifiedEMOperatorImpl#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EmbedModifiedEMOperatorImpl extends EObjectImpl implements EmbedModifiedEMOperator {
	
	private static final String NAME = "Event Manager";
	private static final String DESCRIPTION = "The Event Manager handles incoming EMF events and maps them to internal events";
	
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EmbedModifiedEMOperatorImpl() {
		super();
		this.setName(NAME);
		this.setDescription(DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModifiedEventManagerPackage.Literals.EMBED_MODIFIED_EM_OPERATOR;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModifiedEventManagerPackage.EMBED_MODIFIED_EM_OPERATOR__OPTION, oldOption, newOption);
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
				msgs = ((InternalEObject)option).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModifiedEventManagerPackage.EMBED_MODIFIED_EM_OPERATOR__OPTION, null, msgs);
			if (newOption != null)
				msgs = ((InternalEObject)newOption).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModifiedEventManagerPackage.EMBED_MODIFIED_EM_OPERATOR__OPTION, null, msgs);
			msgs = basicSetOption(newOption, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifiedEventManagerPackage.EMBED_MODIFIED_EM_OPERATOR__OPTION, newOption, newOption));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModifiedEventManagerPackage.EMBED_MODIFIED_EM_OPERATOR__RESULT, oldResult, newResult);
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
				msgs = ((InternalEObject)result).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModifiedEventManagerPackage.EMBED_MODIFIED_EM_OPERATOR__RESULT, null, msgs);
			if (newResult != null)
				msgs = ((InternalEObject)newResult).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModifiedEventManagerPackage.EMBED_MODIFIED_EM_OPERATOR__RESULT, null, msgs);
			msgs = basicSetResult(newResult, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifiedEventManagerPackage.EMBED_MODIFIED_EM_OPERATOR__RESULT, newResult, newResult));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestRun getTestRun() {
		if (eContainerFeatureID() != ModifiedEventManagerPackage.EMBED_MODIFIED_EM_OPERATOR__TEST_RUN) return null;
		return (TestRun)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTestRun(TestRun newTestRun, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTestRun, ModifiedEventManagerPackage.EMBED_MODIFIED_EM_OPERATOR__TEST_RUN, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTestRun(TestRun newTestRun) {
		if (newTestRun != eInternalContainer() || (eContainerFeatureID() != ModifiedEventManagerPackage.EMBED_MODIFIED_EM_OPERATOR__TEST_RUN && newTestRun != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModifiedEventManagerPackage.EMBED_MODIFIED_EM_OPERATOR__TEST_RUN, newTestRun, newTestRun));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModifiedEventManagerPackage.EMBED_MODIFIED_EM_OPERATOR__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModifiedEventManagerPackage.EMBED_MODIFIED_EM_OPERATOR__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void execute() {
		getTestRun().setInstanceForClass(EventManager.class, ModifiedEventManagerFactory.eINSTANCE.createModifiedEventManager());
		setResult(BenchframeworkFactory.eINSTANCE.createResultObject());
		getResult().setStatus(Status.SUCCESSFUL);
		getResult().setMessage("Attached EM to TestRun");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModifiedEventManagerPackage.EMBED_MODIFIED_EM_OPERATOR__TEST_RUN:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTestRun((TestRun)otherEnd, msgs);
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
			case ModifiedEventManagerPackage.EMBED_MODIFIED_EM_OPERATOR__OPTION:
				return basicSetOption(null, msgs);
			case ModifiedEventManagerPackage.EMBED_MODIFIED_EM_OPERATOR__RESULT:
				return basicSetResult(null, msgs);
			case ModifiedEventManagerPackage.EMBED_MODIFIED_EM_OPERATOR__TEST_RUN:
				return basicSetTestRun(null, msgs);
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
			case ModifiedEventManagerPackage.EMBED_MODIFIED_EM_OPERATOR__TEST_RUN:
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
			case ModifiedEventManagerPackage.EMBED_MODIFIED_EM_OPERATOR__OPTION:
				return getOption();
			case ModifiedEventManagerPackage.EMBED_MODIFIED_EM_OPERATOR__RESULT:
				return getResult();
			case ModifiedEventManagerPackage.EMBED_MODIFIED_EM_OPERATOR__TEST_RUN:
				return getTestRun();
			case ModifiedEventManagerPackage.EMBED_MODIFIED_EM_OPERATOR__NAME:
				return getName();
			case ModifiedEventManagerPackage.EMBED_MODIFIED_EM_OPERATOR__DESCRIPTION:
				return getDescription();
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
			case ModifiedEventManagerPackage.EMBED_MODIFIED_EM_OPERATOR__OPTION:
				setOption((OptionObject)newValue);
				return;
			case ModifiedEventManagerPackage.EMBED_MODIFIED_EM_OPERATOR__RESULT:
				setResult((ResultObject)newValue);
				return;
			case ModifiedEventManagerPackage.EMBED_MODIFIED_EM_OPERATOR__TEST_RUN:
				setTestRun((TestRun)newValue);
				return;
			case ModifiedEventManagerPackage.EMBED_MODIFIED_EM_OPERATOR__NAME:
				setName((String)newValue);
				return;
			case ModifiedEventManagerPackage.EMBED_MODIFIED_EM_OPERATOR__DESCRIPTION:
				setDescription((String)newValue);
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
			case ModifiedEventManagerPackage.EMBED_MODIFIED_EM_OPERATOR__OPTION:
				setOption((OptionObject)null);
				return;
			case ModifiedEventManagerPackage.EMBED_MODIFIED_EM_OPERATOR__RESULT:
				setResult((ResultObject)null);
				return;
			case ModifiedEventManagerPackage.EMBED_MODIFIED_EM_OPERATOR__TEST_RUN:
				setTestRun((TestRun)null);
				return;
			case ModifiedEventManagerPackage.EMBED_MODIFIED_EM_OPERATOR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModifiedEventManagerPackage.EMBED_MODIFIED_EM_OPERATOR__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
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
			case ModifiedEventManagerPackage.EMBED_MODIFIED_EM_OPERATOR__OPTION:
				return option != null;
			case ModifiedEventManagerPackage.EMBED_MODIFIED_EM_OPERATOR__RESULT:
				return result != null;
			case ModifiedEventManagerPackage.EMBED_MODIFIED_EM_OPERATOR__TEST_RUN:
				return getTestRun() != null;
			case ModifiedEventManagerPackage.EMBED_MODIFIED_EM_OPERATOR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModifiedEventManagerPackage.EMBED_MODIFIED_EM_OPERATOR__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
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

} //EmbedModifiedEMOperatorImpl

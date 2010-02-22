/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.oclOperator.impl;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.query.statements.IQueryResult;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.expressions.OCLExpression;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;
import de.hpi.sam.bp2009.benchframework.OptionObject;
import de.hpi.sam.bp2009.benchframework.ResultObject;
import de.hpi.sam.bp2009.benchframework.Status;
import de.hpi.sam.bp2009.benchframework.TestRun;
import de.hpi.sam.bp2009.benchframework.oclOperator.OclOperator;
import de.hpi.sam.bp2009.benchframework.oclOperator.OclOperatorFactory;
import de.hpi.sam.bp2009.benchframework.oclOperator.OclOperatorPackage;
import de.hpi.sam.bp2009.benchframework.oclOperator.OclOptionObject;
import de.hpi.sam.bp2009.benchframework.oclOperator.OclResult;
import de.hpi.sam.bp2009.benchframework.oclOperator.OclUtil;
import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;
import de.hpi.sam.bp2009.solution.oclEvaluator.OclEvaluatorFactory;
import de.hpi.sam.bp2009.solution.oclEvaluator.OclQuery;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ocl Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclOperatorImpl#getOption <em>Option</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclOperatorImpl#getResult <em>Result</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclOperatorImpl#getTestRun <em>Test Run</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclOperatorImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclOperatorImpl#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OclOperatorImpl extends EObjectImpl implements OclOperator {
	
	private static final String NAME = "OCLOperator";
	private static final String DESCRIPTION = "Evaluates a specific ocl expression";

	/**
	 * The cached value of the '{@link #getOption() <em>Option</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOption()
	 * @generated
	 * @ordered
	 */
	protected OptionObject option;
	/**
	 * The cached value of the '{@link #getResult() <em>Result</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResult()
	 * @generated
	 * @ordered
	 */
	protected ResultObject result;
	/**
	 * The cached value of the '{@link #getTestRun() <em>Test Run</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestRun()
	 * @generated
	 * @ordered
	 */
	protected TestRun testRun;
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
	public OclOperatorImpl() {
		super();
		setOption(OclOperatorFactory.eINSTANCE.createOclOptionObject());
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
		return OclOperatorPackage.Literals.OCL_OPERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OptionObject getOption() {
		if (option != null && option.eIsProxy()) {
			InternalEObject oldOption = (InternalEObject)option;
			option = (OptionObject)eResolveProxy(oldOption);
			if (option != oldOption) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OclOperatorPackage.OCL_OPERATOR__OPTION, oldOption, option));
			}
		}
		return option;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OptionObject basicGetOption() {
		return option;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOption(OptionObject newOption) {
		OptionObject oldOption = option;
		option = newOption;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OclOperatorPackage.OCL_OPERATOR__OPTION, oldOption, option));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultObject getResult() {
		if (result != null && result.eIsProxy()) {
			InternalEObject oldResult = (InternalEObject)result;
			result = (ResultObject)eResolveProxy(oldResult);
			if (result != oldResult) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OclOperatorPackage.OCL_OPERATOR__RESULT, oldResult, result));
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultObject basicGetResult() {
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResult(ResultObject newResult) {
		ResultObject oldResult = result;
		result = newResult;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OclOperatorPackage.OCL_OPERATOR__RESULT, oldResult, result));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestRun getTestRun() {
		if (testRun != null && testRun.eIsProxy()) {
			InternalEObject oldTestRun = (InternalEObject)testRun;
			testRun = (TestRun)eResolveProxy(oldTestRun);
			if (testRun != oldTestRun) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OclOperatorPackage.OCL_OPERATOR__TEST_RUN, oldTestRun, testRun));
			}
		}
		return testRun;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestRun basicGetTestRun() {
		return testRun;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTestRun(TestRun newTestRun, NotificationChain msgs) {
		TestRun oldTestRun = testRun;
		testRun = newTestRun;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OclOperatorPackage.OCL_OPERATOR__TEST_RUN, oldTestRun, newTestRun);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTestRun(TestRun newTestRun) {
		if (newTestRun != testRun) {
			NotificationChain msgs = null;
			if (testRun != null)
				msgs = ((InternalEObject)testRun).eInverseRemove(this, BenchframeworkPackage.TEST_RUN__OPERATORS, TestRun.class, msgs);
			if (newTestRun != null)
				msgs = ((InternalEObject)newTestRun).eInverseAdd(this, BenchframeworkPackage.TEST_RUN__OPERATORS, TestRun.class, msgs);
			msgs = basicSetTestRun(newTestRun, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OclOperatorPackage.OCL_OPERATOR__TEST_RUN, newTestRun, newTestRun));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OclOperatorPackage.OCL_OPERATOR__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OclOperatorPackage.OCL_OPERATOR__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 */
	
	public void execute() {
		setResult(OclOperatorFactory.eINSTANCE.createOclResult());
		if (option instanceof OclOptionObject){
			if(((OclOptionObject) option).isUseImpactAnalyzer())
				registerQueriesIA(this.getTestRun().getModel(), (OclOptionObject) option);
			else
				executeQueries(this.getTestRun().getModel(), (OclOptionObject) option);
			getResult().setStatus(Status.SUCCESSFULL);
		}else
			getResult().setStatus(Status.FAILED);
			getResult().setMessage("Invalid OptionObject");
		

	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OclOperatorPackage.OCL_OPERATOR__TEST_RUN:
				if (testRun != null)
					msgs = ((InternalEObject)testRun).eInverseRemove(this, BenchframeworkPackage.TEST_RUN__OPERATORS, TestRun.class, msgs);
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
			case OclOperatorPackage.OCL_OPERATOR__TEST_RUN:
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OclOperatorPackage.OCL_OPERATOR__OPTION:
				if (resolve) return getOption();
				return basicGetOption();
			case OclOperatorPackage.OCL_OPERATOR__RESULT:
				if (resolve) return getResult();
				return basicGetResult();
			case OclOperatorPackage.OCL_OPERATOR__TEST_RUN:
				if (resolve) return getTestRun();
				return basicGetTestRun();
			case OclOperatorPackage.OCL_OPERATOR__NAME:
				return getName();
			case OclOperatorPackage.OCL_OPERATOR__DESCRIPTION:
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
			case OclOperatorPackage.OCL_OPERATOR__OPTION:
				setOption((OptionObject)newValue);
				return;
			case OclOperatorPackage.OCL_OPERATOR__RESULT:
				setResult((ResultObject)newValue);
				return;
			case OclOperatorPackage.OCL_OPERATOR__TEST_RUN:
				setTestRun((TestRun)newValue);
				return;
			case OclOperatorPackage.OCL_OPERATOR__NAME:
				setName((String)newValue);
				return;
			case OclOperatorPackage.OCL_OPERATOR__DESCRIPTION:
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
			case OclOperatorPackage.OCL_OPERATOR__OPTION:
				setOption((OptionObject)null);
				return;
			case OclOperatorPackage.OCL_OPERATOR__RESULT:
				setResult((ResultObject)null);
				return;
			case OclOperatorPackage.OCL_OPERATOR__TEST_RUN:
				setTestRun((TestRun)null);
				return;
			case OclOperatorPackage.OCL_OPERATOR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case OclOperatorPackage.OCL_OPERATOR__DESCRIPTION:
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
			case OclOperatorPackage.OCL_OPERATOR__OPTION:
				return option != null;
			case OclOperatorPackage.OCL_OPERATOR__RESULT:
				return result != null;
			case OclOperatorPackage.OCL_OPERATOR__TEST_RUN:
				return testRun != null;
			case OclOperatorPackage.OCL_OPERATOR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case OclOperatorPackage.OCL_OPERATOR__DESCRIPTION:
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

	public void executeQueries(ResourceSet resource, OclOptionObject option) {
		OclUtil ocl = OclOperatorFactory.eINSTANCE.createOclUtil();
		for(String con: option.getConstraints()){
			IQueryResult r = ocl.executeQueryOn(con, resource);
			if(getResult() instanceof OclResult)
				((OclResult)getResult()).getQueriesToResults().put(con, r);
		}
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public void registerQueriesIA(ResourceSet resource, OclOptionObject option) {
		OclUtil ocl = OclOperatorFactory.eINSTANCE.createOclUtil();
		EList<OclQuery> list= new BasicEList<OclQuery>();
		for(String con: option.getConstraints()){
			OCLExpression<EClassifier> expr=null;
			try {
				 expr= (OCLExpression<EClassifier>) ocl.getOCLExpression(con, resource);
			} catch (ParserException e) {
				throw new IllegalArgumentException("Invalid Query, parsing failed " +e.getMessage(), e);
			}
			OclQuery q= OclEvaluatorFactory.eINSTANCE.createOclQuery();
			q.setExpression(expr);
			list.add(q);
		}
		final ImpactAnalyzer ia = getTestRun().getInstanceForClass(de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer.class);
		final EventManager em = getTestRun().getInstanceForClass(de.hpi.sam.bp2009.solution.eventManager.EventManager.class);

		if(ia== null)
			throw new IllegalArgumentException("Invalid Testrun, no Impact Analyzer defined");
		else if(em == null)
			throw new IllegalArgumentException("Invalid Testrun, no Event Manager defined");
		else{
			for (OclQuery item: list){
				EventFilter filter = ia.createFilterForQuery(item);
				em.subscribe(resource, filter, new Adapter() {
				
				@Override
				public void setTarget(Notifier newTarget) {
				}
				
				@Override
				public void notifyChanged(Notification notification) {
					//TODO: call ia to getContext Object
					System.out.println(getName() +" gets Notfied");
				}
				
				@Override
				public boolean isAdapterForType(Object type) {
					return false;
				}
				
				@Override
				public Notifier getTarget() {
					return ia;
				}});
			}
		}
	}

} //OclOperatorImpl

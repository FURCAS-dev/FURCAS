/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.randomGenerator.impl;

import java.util.ArrayList;
import java.util.Random;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.ExtendedMetaData;

import de.hpi.sam.bp2009.benchframework.BenchframeworkFactory;
import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;
import de.hpi.sam.bp2009.benchframework.OptionObject;
import de.hpi.sam.bp2009.benchframework.ResultObject;
import de.hpi.sam.bp2009.benchframework.Status;
import de.hpi.sam.bp2009.benchframework.TestRun;
import de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGenerator;
import de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorFactory;
import de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorOptionObject;
import de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Random Generator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.randomGenerator.impl.RandomGeneratorImpl#getOption <em>Option</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.randomGenerator.impl.RandomGeneratorImpl#getResult <em>Result</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.randomGenerator.impl.RandomGeneratorImpl#getTestRun <em>Test Run</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.randomGenerator.impl.RandomGeneratorImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.randomGenerator.impl.RandomGeneratorImpl#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RandomGeneratorImpl extends EObjectImpl implements RandomGenerator {
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
	private ArrayList<EClass> metaClasses;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public RandomGeneratorImpl() {
		super();
		this.setOption(RandomGeneratorFactory.eINSTANCE.createRandomGeneratorOptionObject());
		this.setName("Random Generator");
		this.setDescription("Instantiates a random instance of the model and adds all needed references to it.");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RandomGeneratorPackage.Literals.RANDOM_GENERATOR;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RandomGeneratorPackage.RANDOM_GENERATOR__OPTION, oldOption, option));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RandomGeneratorPackage.RANDOM_GENERATOR__OPTION, oldOption, option));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RandomGeneratorPackage.RANDOM_GENERATOR__RESULT, oldResult, result));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RandomGeneratorPackage.RANDOM_GENERATOR__RESULT, oldResult, result));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RandomGeneratorPackage.RANDOM_GENERATOR__TEST_RUN, oldTestRun, testRun));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RandomGeneratorPackage.RANDOM_GENERATOR__TEST_RUN, oldTestRun, newTestRun);
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
			eNotify(new ENotificationImpl(this, Notification.SET, RandomGeneratorPackage.RANDOM_GENERATOR__TEST_RUN, newTestRun, newTestRun));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RandomGeneratorPackage.RANDOM_GENERATOR__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RandomGeneratorPackage.RANDOM_GENERATOR__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * The strategy to generate the model instance is to choose a class of the meta model at random and generate the minimum number of required referenced/containing classes.
	 * Therefore not all classes of the meta model have to be in the generated instance if they're referenced with a lower bound of 0. 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void execute() {
		ResourceSetImpl resultRS = new ResourceSetImpl();
		Resource result = resultRS.createResource(URI.createURI("http://de.hpi.sam.bp2009.benchframework.randomGenerator/generatedInstance1"));
		RandomGeneratorOptionObject options = (RandomGeneratorOptionObject) getOption();
		EPackage metaModel = options.getMetaModel();
		resultRS.getPackageRegistry().put(metaModel.getNsURI(), metaModel);
		metaClasses = new ArrayList<EClass>();
		
		//get all classes in the meta model
		for(EClassifier cls:metaModel.getEClassifiers()){
			if (cls instanceof EClass ){
				EClass c = (EClass) cls;
				if(c.isAbstract())
					continue;
				metaClasses.add(c);
			}
		}

		//instantiate the meta model
		instantiate(metaClasses.get(new Random().nextInt(metaClasses.size())), result);
		this.getTestRun().setModel(resultRS);
		setResult(BenchframeworkFactory.eINSTANCE.createResultObject());
		getResult().setStatus(Status.SUCCESSFUL);
		getResult().setMessage("Generated "+result.toString());
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RandomGeneratorPackage.RANDOM_GENERATOR__TEST_RUN:
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
			case RandomGeneratorPackage.RANDOM_GENERATOR__TEST_RUN:
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
			case RandomGeneratorPackage.RANDOM_GENERATOR__OPTION:
				if (resolve) return getOption();
				return basicGetOption();
			case RandomGeneratorPackage.RANDOM_GENERATOR__RESULT:
				if (resolve) return getResult();
				return basicGetResult();
			case RandomGeneratorPackage.RANDOM_GENERATOR__TEST_RUN:
				if (resolve) return getTestRun();
				return basicGetTestRun();
			case RandomGeneratorPackage.RANDOM_GENERATOR__NAME:
				return getName();
			case RandomGeneratorPackage.RANDOM_GENERATOR__DESCRIPTION:
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
			case RandomGeneratorPackage.RANDOM_GENERATOR__OPTION:
				setOption((OptionObject)newValue);
				return;
			case RandomGeneratorPackage.RANDOM_GENERATOR__RESULT:
				setResult((ResultObject)newValue);
				return;
			case RandomGeneratorPackage.RANDOM_GENERATOR__TEST_RUN:
				setTestRun((TestRun)newValue);
				return;
			case RandomGeneratorPackage.RANDOM_GENERATOR__NAME:
				setName((String)newValue);
				return;
			case RandomGeneratorPackage.RANDOM_GENERATOR__DESCRIPTION:
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
			case RandomGeneratorPackage.RANDOM_GENERATOR__OPTION:
				setOption((OptionObject)null);
				return;
			case RandomGeneratorPackage.RANDOM_GENERATOR__RESULT:
				setResult((ResultObject)null);
				return;
			case RandomGeneratorPackage.RANDOM_GENERATOR__TEST_RUN:
				setTestRun((TestRun)null);
				return;
			case RandomGeneratorPackage.RANDOM_GENERATOR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RandomGeneratorPackage.RANDOM_GENERATOR__DESCRIPTION:
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
			case RandomGeneratorPackage.RANDOM_GENERATOR__OPTION:
				return option != null;
			case RandomGeneratorPackage.RANDOM_GENERATOR__RESULT:
				return result != null;
			case RandomGeneratorPackage.RANDOM_GENERATOR__TEST_RUN:
				return testRun != null;
			case RandomGeneratorPackage.RANDOM_GENERATOR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RandomGeneratorPackage.RANDOM_GENERATOR__DESCRIPTION:
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

	/**Create an instance of the given meta class and add it to the resource
	 * @param cls the meta class to instantiate
	 * @param res the resource to instantiate the meta class in
	 * @return the instance of the meta class
	 */
	private EObject instantiate(EClass cls, Resource res){
		if(cls.isAbstract())
			return instantiate(getImplementationForAbstractClass(cls), res);
		EObject current = cls.getEPackage().getEFactoryInstance().create(cls);
		res.getContents().add(current);

		//get all references of the meta class and link the instance accordingly
		for (EReference ref:cls.getEAllReferences()){
			if( ExtendedMetaData.INSTANCE.getAffiliation(cls, ref)==null)
				//this position should never been reached
				continue;			
			//link to already existing classes
			int lowerBound = ref.getLowerBound();
			for (EObject resContent:res.getContents()){
				if (resContent instanceof EClass && (EClass)resContent.eClass() == ref.getEReferenceType()){
					if (lowerBound == 0){
						break;
					}
					cls.eSet(ref, resContent);
					lowerBound--;
				}
			}

			//create remaining needed classes and link them
			for (int i = 0; i < lowerBound; i++){
				EObject nextCls = instantiate(ref.getEReferenceType(), res);
				//the value of a reference can only be an instance of EReference
				if (!(nextCls instanceof EReference)) break;				
				cls.eSet(ref, nextCls);
			}
		}
		return current;
	}

	private EClass getImplementationForAbstractClass(EClass abstractCls) {
		if(!abstractCls.isAbstract())
			return abstractCls;
		
		for(EClass cls:metaClasses){
			if(cls.getESuperTypes().contains(abstractCls)){
				return getImplementationForAbstractClass(cls);
			}
				
		}
		return null;
	}

} //RandomGeneratorImpl

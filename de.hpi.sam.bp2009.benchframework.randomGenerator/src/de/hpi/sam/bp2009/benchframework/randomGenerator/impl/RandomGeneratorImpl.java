/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.randomGenerator.impl;

import java.util.ArrayList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
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
	private static final String RANDOM_GENERATOR_DESCRIPTION = "Instantiates a random instance of the model and adds all needed references to it.";
	private static final String RANDOM_GENERATOR_NAME = "Random Model Instanciator";
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
		this.setName(RANDOM_GENERATOR_NAME);
		this.setDescription(RANDOM_GENERATOR_DESCRIPTION);
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
		RandomGeneratorOptionObject options = (RandomGeneratorOptionObject) getOption();
		//make sure to start at index 0 even if executed multiple times
		options.setNumberListIndex(0);
		ResourceSetImpl resultRS = new ResourceSetImpl();
		Resource result = resultRS.createResource(URI.createURI("http://de.hpi.sam.bp2009.benchframework.randomGenerator/generatedInstance1"));
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
		instantiate(metaClasses.get(options.getNextInt(metaClasses.size())), result);
		this.getTestRun().setModel(resultRS);
		setResult(BenchframeworkFactory.eINSTANCE.createResultObject());
		getResult().setStatus(Status.SUCCESSFUL);
		getResult().setMessage("Generated "+result.toString());
		//reset the numberListIndex in case the generator is executed multiple times
		
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

	/**
	 * Create an instance of the given meta class and add it to the resource
	 * @param metaCls The meta class to instantiate
	 * @param res The resource to instantiate the meta class in
	 * @return The instance of the meta class
	 */
	private EObject instantiate(EClass metaCls, Resource res){
		//don't try to instantiate abstract classes, find all non abstract subclasses and instantiate one of them instead
		if(metaCls.isAbstract()) {	
			ArrayList<? extends EClass> clsList = getImplementationForAbstractClass(metaCls, metaClasses);
			int i = ((RandomGeneratorOptionObject)getOption()).getNextInt(clsList.size());
			return instantiate(clsList.get(i), res);
		}

		//create an instance of the metaClass, add it to the resource and set needed references
		EObject newInstance = metaCls.getEPackage().getEFactoryInstance().create(metaCls);
		res.getContents().add(newInstance);
		linkInstance(res, newInstance);
		return newInstance;
	}

	/**
	 * Link all references of the given instance to the minimum required number of targets
	 * @param res The resource of the instance to link
	 * @param newInstance The instance to link
	 */
	private void linkInstance(Resource res, EObject newInstance) {
		EClass metaCls = newInstance.eClass();
		//get all references of the meta class and link the instance accordingly
		for (EReference ref:metaCls.getEAllReferences()){
			if( ExtendedMetaData.INSTANCE.getAffiliation(metaCls, ref)==null)
				//this position should never been reached
				continue;

			//link to already existing classes
			linkToExistingInstances(res, ref, newInstance);
			//create remaining needed classes and link them
			linkToNewInstances(res, newInstance, ref);
		}
	}

	/**
	 * Link the given instance to existing classes that match the reference type
	 * @param res The resource of the instance to link
	 * @param ref The reference of newInstance to set
	 * @param newInstance The instance to link
	 */
	private void linkToExistingInstances(Resource res, EReference ref, EObject newInstance) {
		int lowerBound = getLowerBoundDelta(ref, newInstance);
		//since setting a containment reference will change the resContent, we need to copy it to an extra list
		EList<EObject> resContents = new BasicEList<EObject>();
		TreeIterator<EObject> it = res.getAllContents();
		while (it.hasNext())
			resContents.add(it.next());

		//iterate over all contents of the resource and try to set the reference to each class with the correct type
		//if setting reference is not possible, just try next one	
		for (EObject resContent:resContents){
			if (lowerBound > 0 && ref.getEReferenceType().isSuperTypeOf(resContent.eClass())){				
				if (!tryToSetReference(ref, newInstance, resContent))
					break;
				lowerBound = getLowerBoundDelta(ref, newInstance);
			}
		}
	}

	/**Link the given instance to newly created classes
	 * @param res The resource of the instance to link
	 * @param newInstance The instance to link
	 * @param ref The reference of newInstance to set
	 */
	private void linkToNewInstances(Resource res, EObject newInstance, EReference ref) {
		int lowerBound = getLowerBoundDelta(ref, newInstance);
		while (lowerBound > 0){
			EObject newCls = instantiate(ref.getEReferenceType(), res);			
			if (!tryToSetReference(ref, newInstance, newCls))
				break;
			lowerBound = getLowerBoundDelta(ref, newInstance);
		}
	}

	/**
	 * Calculates how many classes are missing to reach the lower bound of a given reference of a given class
	 * @param ref The reference to check
	 * @param newInstance The instance to check
	 * @return The number of classes that are missing to reach the lower bound
	 */
	@SuppressWarnings("unchecked")
	private int getLowerBoundDelta(EReference ref, EObject newInstance) {
		int lowerBound = ref.getLowerBound();
		if (ref.isMany())
			lowerBound -= ((BasicEList<EObject>)newInstance.eGet(ref)).size();
		else if (newInstance.eGet(ref) != null)
			lowerBound -= 1;
		return lowerBound;
	}

	/**
	 * Try to set the the given reference of the given instance to the given target. Returns true if successful, false if not.
	 * The method is unsuccessful if the given reference is already set or would exceed its upper bound(in case of to-many references)
	 * @param ref The reference of newInstance to set 
	 * @param newInstance The instance to link
	 * @param target The target to link
	 * @return true if setting the reference was successful, false if it was not
	 */
	@SuppressWarnings("unchecked")
	private boolean tryToSetReference(EReference ref, EObject newInstance, EObject target){
		EReference oppRef = ref.getEOpposite();

		//(reference is "to-one") ^ (reference is unset)
		boolean toOneAndSettable = !ref.isMany() && (newInstance.eGet(ref) == null || newInstance.eGet(ref) == target);
		//(reference is "to-many") ^ ((reference upper bound is *) v (adding target would not exceed upper bound))
		boolean toManyAndSpaceLeft = ref.isMany() && (ref.getUpperBound() == -1 ||
				ref.getUpperBound() > ((BasicEList<EObject>)newInstance.eGet(ref)).size());
		//(reference has opposite) -> ((opposite is "to-many") ^ ((opposite upper bound is *) v (adding target would not exceed upper bound)))
		//A -> B = !A v B 
		boolean oppositeToManyAndSpaceLeft = oppRef == null || (oppRef.isMany() && (oppRef.getUpperBound() == -1 ||
				oppRef.getUpperBound() > ((BasicEList<EObject>)target.eGet(oppRef)).size()));
		//(reference has opposite) -> ((opposite is "to one") ^ (opposite is unset))
		//A -> B = !A v B 
		boolean oppositeToOneAndSettable = oppRef == null || (!oppRef.isMany() && (target.eGet(oppRef) == null || target.eGet(oppRef) == newInstance));

		if (toManyAndSpaceLeft && (oppositeToManyAndSpaceLeft || oppositeToOneAndSettable)) {
			((BasicEList<EObject>)newInstance.eGet(ref)).add(target);
		} else if (toOneAndSettable && (oppositeToManyAndSpaceLeft || oppositeToOneAndSettable)) {
			newInstance.eSet(ref, target);
		} else 
			return false;
		return true;
	}

	/**
	 * Return all non abstract subclasses of a given class from a given set of classes. 
	 * If the given class is non abstract, it will be returned.
	 * @param abstractCls The class of which to return the non abstract subclasses 
	 * @param metaclassPool The pool of classes to search for non abstract subclasses
	 * @return a Collection of non abstract subclasses of the given class
	 */
	private ArrayList<? extends EClass> getImplementationForAbstractClass(EClass abstractCls, ArrayList<EClass> metaclassPool) {
		ArrayList<EClass> implementations = new ArrayList<EClass>();
		for(EClass cls:metaclassPool){
			if(cls.getEAllSuperTypes().contains(abstractCls)){
				implementations.add(cls);
			}
		}
		return implementations;
	}

} //RandomGeneratorImpl

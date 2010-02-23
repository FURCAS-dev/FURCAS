/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.randomModelModifier.impl;

import de.hpi.sam.bp2009.benchframework.BenchframeworkFactory;
import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;
import de.hpi.sam.bp2009.benchframework.OptionObject;
import de.hpi.sam.bp2009.benchframework.ResultObject;
import de.hpi.sam.bp2009.benchframework.Status;

import java.util.Random;

import de.hpi.sam.bp2009.benchframework.TestRun;
import de.hpi.sam.bp2009.randomModelModifier.RandomModelModifier;
import de.hpi.sam.bp2009.randomModelModifier.RandomModelModifierFactory;
import de.hpi.sam.bp2009.randomModelModifier.RandomModelModifierOptionObject;
import de.hpi.sam.bp2009.randomModelModifier.RandomModelModifierPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import de.hpi.sam.bp2009.randomModelModifier.Task;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Random Model Modifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.randomModelModifier.impl.RandomModelModifierImpl#getOption <em>Option</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.randomModelModifier.impl.RandomModelModifierImpl#getResult <em>Result</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.randomModelModifier.impl.RandomModelModifierImpl#getTestRun <em>Test Run</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.randomModelModifier.impl.RandomModelModifierImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.randomModelModifier.impl.RandomModelModifierImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.randomModelModifier.impl.RandomModelModifierImpl#getRandomNumberGenerator <em>Random Number Generator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RandomModelModifierImpl extends EObjectImpl implements RandomModelModifier {
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
	 * The default value of the '{@link #getRandomNumberGenerator() <em>Random Number Generator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRandomNumberGenerator()
	 * @generated
	 * @ordered
	 */
	protected static final Random RANDOM_NUMBER_GENERATOR_EDEFAULT = null;
	private static final String SUCCESS_MESSAGE = "Successfully changed Model.";
	private static final String FAILED_MESSAGE = "Failed to change Model!";
	/**
	 * The cached value of the '{@link #getRandomNumberGenerator() <em>Random Number Generator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRandomNumberGenerator()
	 * @generated
	 * @ordered
	 */
	protected Random randomNumberGenerator = RANDOM_NUMBER_GENERATOR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public RandomModelModifierImpl() {
		super();
		setOption(RandomModelModifierFactory.eINSTANCE.createRandomModelModifierOptionObject());
		setName("Random Model Modifier");
		setDescription("randomly add/remove classes, references or modify attributes in the model");
		setRandomNumberGenerator(new Random());
		setResult(BenchframeworkFactory.eINSTANCE.createResultObject());
	}
	
	@Override
	public void execute() {
		Task task = ((RandomModelModifierOptionObject)getOption()).getTask();
		Integer times = ((RandomModelModifierOptionObject)getOption()).getTimes();
		//collect all instance objects from all resources
		BasicEList<EObject> classList = new BasicEList<EObject>();
		for (Resource r: getTestRun().getModel().getResources()){
			classList.addAll(r.getContents());
		}
		
		for (int i = 0; i < times; i++){
			switch (task){
			case CLASS_CREATE:
				getResult().setStatus(createRandomClass(classList) ? Status.SUCCESSFUL : Status.FAILED);
				break;
			case CLASS_DELETE:
				getResult().setStatus(deleteRandomClass(classList) ? Status.SUCCESSFUL : Status.FAILED);
				break;
			case REFERENCE_CREATE:
				getResult().setStatus(createRandomReference(classList) ? Status.SUCCESSFUL : Status.FAILED);
				break;
			case REFERENCE_DELETE:
				getResult().setStatus(deleteRandomReference(classList) ? Status.SUCCESSFUL : Status.FAILED);
				break;
			case MODIFY_ATTRIBUTE:
				getResult().setStatus(modifyRandomAttribute(classList) ? Status.SUCCESSFUL : Status.FAILED);
				break;		
			}
		}
		if (getResult().getStatus() == Status.SUCCESSFUL){
			getResult().setMessage(SUCCESS_MESSAGE);
		} else {
			getResult().setMessage(FAILED_MESSAGE);
		}
		
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__TEST_RUN:
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
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__TEST_RUN:
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
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__OPTION:
				if (resolve) return getOption();
				return basicGetOption();
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__RESULT:
				if (resolve) return getResult();
				return basicGetResult();
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__TEST_RUN:
				if (resolve) return getTestRun();
				return basicGetTestRun();
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__NAME:
				return getName();
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__DESCRIPTION:
				return getDescription();
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__RANDOM_NUMBER_GENERATOR:
				return getRandomNumberGenerator();
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
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__OPTION:
				setOption((OptionObject)newValue);
				return;
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__RESULT:
				setResult((ResultObject)newValue);
				return;
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__TEST_RUN:
				setTestRun((TestRun)newValue);
				return;
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__NAME:
				setName((String)newValue);
				return;
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__RANDOM_NUMBER_GENERATOR:
				setRandomNumberGenerator((Random)newValue);
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
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__OPTION:
				setOption((OptionObject)null);
				return;
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__RESULT:
				setResult((ResultObject)null);
				return;
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__TEST_RUN:
				setTestRun((TestRun)null);
				return;
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__RANDOM_NUMBER_GENERATOR:
				setRandomNumberGenerator(RANDOM_NUMBER_GENERATOR_EDEFAULT);
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
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__OPTION:
				return option != null;
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__RESULT:
				return result != null;
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__TEST_RUN:
				return testRun != null;
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__RANDOM_NUMBER_GENERATOR:
				return RANDOM_NUMBER_GENERATOR_EDEFAULT == null ? randomNumberGenerator != null : !RANDOM_NUMBER_GENERATOR_EDEFAULT.equals(randomNumberGenerator);
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
		result.append(", RandomNumberGenerator: ");
		result.append(randomNumberGenerator);
		result.append(')');
		return result.toString();
	}

	/**
	 * Modify a random attribute from a random class.
	 * Basically the value of the chosen attribute will change to default if it's actual value is not the default one.
	 * If it is the default value, it will be unset.
	 * In case there are no classes with attributes in the given list, nothing will happen
	 * @param classList a List of classes to choose a random class from
	 */
	private boolean modifyRandomAttribute(BasicEList<EObject> classList) {
		int index = getRandomNumberGenerator().nextInt(classList.size());
		EObject cls = classList.get(index);
		int attrSize = cls.eClass().getEAllAttributes().size();
		if (attrSize > 0){
			
			EList<EAttribute> attrList = cls.eClass().getEAllAttributes();
			//would be set later on, because attribute size > 0
			EAttribute attr = null;
			//try to find a attribute to change
			while (!(attrList.isEmpty())){
				int number = getRandomNumberGenerator().nextInt(attrList.size());
				attr = attrList.get(number);
				//if the attribute is not changeable, remove it from attribute list and try an other one
				if (!attr.isChangeable()){
					attrList.remove(number);
					continue;
				}
				//valid attribute found
				//if the attribute has the default value, we unset it
				//if it's not the default, we set it to the default
				//this always changes the attribute and might as well invalidate some OCL Conditions
				if (cls.eGet(attr) == attr.getDefaultValue())
					cls.eUnset(attr);
				else
					cls.eSet(attr, attr.getDefaultValue());
				return true;
				
			}
		}
		classList.remove(index);
		if (!classList.isEmpty())
			return modifyRandomAttribute(classList);
		else
			return false;		
	}

	

	/**
	 * Remove a random reference of a random class. If the random class has no references, try it with another class.
	 * In case there are no classes with references in the given list, nothing will happen.
	 * @param classList a List of classes to choose a random class from
	 */
	@SuppressWarnings("unchecked")
	private boolean deleteRandomReference(BasicEList<EObject> classList) {
		int index = getRandomNumberGenerator().nextInt(classList.size());
		EObject cls = classList.get(index);
		int refCount = cls.eClass().getEAllReferences().size();
		if (refCount > 0){
			//a reference was found, remove one referenced class
			EList<EReference> refList = cls.eClass().getEAllReferences();
			EReference ref = null;
			Object obj = null;
			while  (!(refList.isEmpty())){
				int number = getRandomNumberGenerator().nextInt(refList.size());
				ref = refList.get(number);
				obj = cls.eGet(ref);
				//the chosen reference can't be removed, try an other one
				if (!ref.isChangeable() || null == obj || ( obj instanceof EList<?> && ((EList<Object>)obj).isEmpty() )){
					refList.remove(number);
					continue;
				}
				else {
					if (ref.isMany()){
						//remove one referenced class
						//casting to EList should be safe because we have a to-many reference at this point
						EList<EObject> list = (EList<EObject>)obj;
						list.remove(getRandomNumberGenerator().nextInt(list.size()));
					}else{
						//unset the whole reference
						cls.eUnset(ref);
					}
					return true;
				}
					
			}
		}
		//if no changeable reference was found, try the next class
		classList.remove(index);
		if (!classList.isEmpty())
			return deleteRandomReference(classList);
		else
			return false;
	}

	/**
	 * Creates a random reference of a random class. It the random class has no references, try it with another class.
	 * In case there are no classes with references in the given list, nothing will happen.
	 * @param classList
	 */
	@SuppressWarnings("unchecked")
	private boolean createRandomReference(BasicEList<EObject> classList) {
		//FIXME java.lang.IllegalArgumentException: n must be positive on testing
		int index = getRandomNumberGenerator().nextInt(classList.size());
		EObject cls = classList.get(index);
		int refCount = cls.eClass().getEAllReferences().size();
		if (refCount > 0){
			//a reference was found, set it to a valid class
			EList<EReference> refList = cls.eClass().getEAllReferences();
			EReference ref = null;
			while (!(refList.isEmpty())){
				int number = getRandomNumberGenerator().nextInt(refList.size());
				ref = refList.get(number);
				//if the reference is not changeable, try an other one of the refList
				if (!ref.isChangeable()){
					refList.remove(number);
					continue;
				}
				EClass targetType = ref.getEReferenceType();
				EObject target = getRandomClassOfType(targetType, classList);
				int size = 0;
				if (ref.isMany()){
					//get the size of a to-many reference (eGet always returns an EList if it's a to-many reference)
					size = ((EList<EObject>)cls.eGet(ref)).size();
				}else if (cls.eGet(ref) != null) {
					//check if the to-one reference is set
					size = 1;
				}
				if (target != null && size < ref.getUpperBound()){
					//check if there's a target and if it can be added without exceeding the upper bound of the reference
					ref.eContents().add(target);
					return true;
				}
				//the reference couldn't be added to the current class, try an other class
				break;
			}
		}
		classList.remove(cls);
		if (!classList.isEmpty())
			return createRandomReference(classList);
		
		return false;
	}

	/**
	 * Delete a random class and remove it from classList
	 * @param classList the list to remove a class from
	 */
	private boolean deleteRandomClass(BasicEList<EObject> classList) {
		EObject cls = classList.get(getRandomNumberGenerator().nextInt(classList.size()));
		EcoreUtil.delete(cls);
		return classList.remove(cls);
	}

	/**
	 * Create a random class and add it to classList
	 * @param classList the list to add the new class to
	 */
	private boolean createRandomClass(BasicEList<EObject> classList) {
		//no need to check if class can be created because we take one that has already been created and make another instance
		EObject cls = classList.get(getRandomNumberGenerator().nextInt(classList.size()));
		EObject newCls = cls.eClass().getEPackage().getEFactoryInstance().create(cls.eClass());
		EcoreUtil.getRootContainer(cls).eContents().add(newCls);
		return classList.add(newCls);
	}
	
	/**
	 * Select a random class of the given type.
	 * If there is no class of the given type in the list, it returns null.
	 * @param type the type to choose
	 * @param classList the list to choose a class from
	 * @return EObject of the given class
	 */
	private EObject getRandomClassOfType(EClass type, BasicEList<EObject> classList) {
		BasicEList<EObject> validClasses = new BasicEList<EObject>();
		for (EObject cls : classList ){
			if (cls.eClass() == type){
				validClasses.add(cls);
			}
		}
		if (validClasses.size() > 0){
			return validClasses.get(getRandomNumberGenerator().nextInt(validClasses.size()));
		}else{
			return null;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RandomModelModifierPackage.Literals.RANDOM_MODEL_MODIFIER;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__OPTION, oldOption, option));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__OPTION, oldOption, option));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__RESULT, oldResult, result));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__RESULT, oldResult, result));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__TEST_RUN, oldTestRun, testRun));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__TEST_RUN, oldTestRun, newTestRun);
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
			eNotify(new ENotificationImpl(this, Notification.SET, RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__TEST_RUN, newTestRun, newTestRun));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Random getRandomNumberGenerator() {
		return randomNumberGenerator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRandomNumberGenerator(Random newRandomNumberGenerator) {
		Random oldRandomNumberGenerator = randomNumberGenerator;
		randomNumberGenerator = newRandomNumberGenerator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__RANDOM_NUMBER_GENERATOR, oldRandomNumberGenerator, randomNumberGenerator));
	}

} //RandomModelModifierImpl

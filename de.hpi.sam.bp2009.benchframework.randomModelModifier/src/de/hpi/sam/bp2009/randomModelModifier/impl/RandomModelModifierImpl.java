/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.randomModelModifier.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.hpi.sam.bp2009.benchframework.BenchframeworkFactory;
import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;
import de.hpi.sam.bp2009.benchframework.OptionObject;
import de.hpi.sam.bp2009.benchframework.ResultObject;
import de.hpi.sam.bp2009.benchframework.Status;
import de.hpi.sam.bp2009.benchframework.TestRun;
import de.hpi.sam.bp2009.randomModelModifier.RandomModelModifier;
import de.hpi.sam.bp2009.randomModelModifier.RandomModelModifierFactory;
import de.hpi.sam.bp2009.randomModelModifier.RandomModelModifierOptionObject;
import de.hpi.sam.bp2009.randomModelModifier.RandomModelModifierPackage;
import de.hpi.sam.bp2009.randomModelModifier.Task;

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
 * </ul>
 * </p>
 *
 * @generated
 */
public class RandomModelModifierImpl extends EObjectImpl implements RandomModelModifier {
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

	private static final String SUCCESS_MESSAGE = "Successfully changed Model.";
	@SuppressWarnings("unused")
	private static final String FAILED_MESSAGE = "Failed to change Model!";
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
		setResult(BenchframeworkFactory.eINSTANCE.createResultObject());
	}

	@Override
	public void execute() {
		RandomModelModifierOptionObject options = (RandomModelModifierOptionObject)getOption();
		//make sure to start at index 0 even if executed multiple times
		options.setNumberListIndex(0);
		Task task = options.getTask();
		Integer times = options.getTimes();
		//collect all instance objects from all resources
		BasicEList<EObject> classList = new BasicEList<EObject>();
		for (Resource r: getTestRun().getModel().getResources()){
			TreeIterator<EObject> it = r.getAllContents();
			while(it.hasNext()){
				classList.add(it.next());
			}
		}
		for (int i = 0; i < times; i++){
			if (classList.isEmpty()){
				getResult().setMessage("Executed successfully for " + i + " loops.");
				break;
			}
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
		} else if (getResult().getStatus() == Status.FAILED) {
			//getResult().setMessage(FAILED_MESSAGE);
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
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__OPTION:
				return basicSetOption(null, msgs);
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__RESULT:
				return basicSetResult(null, msgs);
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
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__TEST_RUN:
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
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__OPTION:
				return getOption();
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__RESULT:
				return getResult();
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__TEST_RUN:
				return getTestRun();
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__NAME:
				return getName();
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__DESCRIPTION:
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
				return getTestRun() != null;
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__DESCRIPTION:
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
	 * Modify a random attribute from a random class.
	 * Basically the value of the chosen attribute will change to default if it's actual value is not the default one.
	 * If it is the default value, it will be unset.
	 * In case there are no classes with attributes in the given list, nothing will happen
	 * @param classList a List of classes to choose a random class from
	 */
	private boolean modifyRandomAttribute(BasicEList<EObject> classList) {
		int index = ((RandomModelModifierOptionObject)getOption()).getNextInt(classList.size());
		EObject cls = classList.get(index);
		EList<EAttribute> frozenAttrList = cls.eClass().getEAllAttributes();

		if (!frozenAttrList.isEmpty()){
			//frozenAttrList is unmodifiable, so we copy it to another list
			BasicEList<EAttribute> attrList = new BasicEList<EAttribute>();
			for (EAttribute attr : frozenAttrList)
				attrList.add(attr);
			//try to find a attribute to change
			while (!(attrList.isEmpty())){
				int attrIndex = ((RandomModelModifierOptionObject)getOption()).getNextInt(attrList.size());
				EAttribute attr = attrList.get(attrIndex);
				//if the attribute is not changeable, remove it from attribute list and try an other one
				if (!attr.isChangeable()){
					attrList.remove(attrIndex);
					continue;
				}
				//valid attribute found
				//if it's the default, we try to change it to a random value if we know the type or leave it as it is if we don't
				//if it's not the default, we set it to the default
				//this changes the attribute and might as well invalidate some OCL Conditions
				if (cls.eGet(attr) == attr.getDefaultValue()){
					String attrType = EcoreUtil.toJavaInstanceTypeName(attr.getEGenericType());
					//TODO: add more special cases for known types like float, etc.
					if (attrType.equals("int") || attrType.equals("Integer")){
						cls.eSet(attr, ((RandomModelModifierOptionObject)getOption()).getNextInt(Integer.MAX_VALUE));
					} else if (attrType.equals("java.lang.String")){
						cls.eSet(attr, Integer.toString(((RandomModelModifierOptionObject)getOption()).getNextInt()));
					}
				}else
					cls.eUnset(attr);
				return true;
			}
		}
		//in case we couldn't find an attribute to change, remove the class from the class list and
		//call the method recursively if there are classes left in the list
		classList.remove(index);
		if (!classList.isEmpty())
			return modifyRandomAttribute(classList);
		return false;		
	}

	/**
	 * Remove a random reference of a random class. If the random class has no references, try it with another class.
	 * In case there are no classes with references in the given list, nothing will happen.
	 * @param classList a List of classes to choose a random class from
	 */
	@SuppressWarnings("unchecked")
	private boolean deleteRandomReference(BasicEList<EObject> classList) {
		int index = ((RandomModelModifierOptionObject)getOption()).getNextInt(classList.size());
		EObject cls = classList.get(index);
		EList<EReference> frozenRefList = cls.eClass().getEAllReferences();
		if (!frozenRefList.isEmpty()){
			//frozenRefList is unmodifiable -> copy it to another list
			BasicEList<EReference> refList = new BasicEList<EReference>();		
			for (EReference ref: frozenRefList)
				refList.add(ref);
			//a reference was found, remove one referenced class
			while  (!(refList.isEmpty())){
				int refIndex = ((RandomModelModifierOptionObject)getOption()).getNextInt(refList.size());
				EReference ref = refList.get(refIndex);
				Object obj = cls.eGet(ref);
				//the chosen reference can't be removed, try an other one
				if (!ref.isChangeable() || null == obj || ( obj instanceof EList<?> && ((EList<Object>)obj).isEmpty() )){
					refList.remove(refIndex);
					continue;
				}else{
					if (ref.isMany()){
						//remove one referenced class
						//casting to EList should be safe because we have a to-many reference at this point
						EList<EObject> list = (EList<EObject>)obj;
						list.remove(((RandomModelModifierOptionObject)getOption()).getNextInt(list.size()));
					}else
						//unset the whole reference
						cls.eUnset(ref);
					return true;
				}
			}
		}
		//if no changeable reference was found, try the next class
		classList.remove(index);
		if (!classList.isEmpty())
			return deleteRandomReference(classList);
		return false;
	}

	/**
	 * Creates a random reference of a random class. It the random class has no references, try it with another class.
	 * In case there are no classes with references in the given list, nothing will happen.
	 * @param classList
	 */
	@SuppressWarnings("unchecked")
	private boolean createRandomReference(BasicEList<EObject> classList) {
		int index = ((RandomModelModifierOptionObject)getOption()).getNextInt(classList.size());
		EObject cls = classList.get(index);
		EList<EReference> frozenRefList = cls.eClass().getEAllReferences();
		if (!frozenRefList.isEmpty()){
			//frozenRefList is unmodifiable
			BasicEList<EReference> refList = new BasicEList<EReference>();
			for (EReference ref : frozenRefList)
				refList.add(ref);
			//a reference was found, set it to a valid class
			while (!(refList.isEmpty())){
				int refIndex = ((RandomModelModifierOptionObject)getOption()).getNextInt(refList.size());
				EReference ref = refList.get(refIndex);
				//if the reference is not changeable, try an other one of the refList
				if (!ref.isChangeable()){
					refList.remove(refIndex);
					continue;
				}
				EClass targetType = ref.getEReferenceType();
				EObject target = getRandomClassOfType(targetType, classList);
				int size = 0;
				if (ref.isMany()){
					//get the size of a to-many reference (eGet always returns an EList if it's a to-many reference)
					size = ((EList<EObject>)cls.eGet(ref)).size();
				}else if (cls.eGet(ref) != null)
					//check if the to-one reference is set
					size = 1;
				if (target != null && size < ref.getUpperBound()){
					//check if there's a target and if it can be added without exceeding the upper bound of the reference
					cls.eSet(ref, target);
					return true;
				}
				break;
			}
		}
		//the reference couldn't be added to the current class, try an other class
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
		EObject cls = classList.get(((RandomModelModifierOptionObject)getOption()).getNextInt(classList.size()));
		EcoreUtil.delete(cls);
		return classList.remove(cls);
	}

	/**
	 * Create a random class and add it to classList
	 * @param classList the list to add the new class to
	 */
	private boolean createRandomClass(BasicEList<EObject> classList) {
		//no need to check if class can be created because we take one that has already been created and make another instance
		EObject cls = classList.get(((RandomModelModifierOptionObject)getOption()).getNextInt(classList.size()));
		EObject newCls = cls.eClass().getEPackage().getEFactoryInstance().create(cls.eClass());
		cls.eResource().getContents().add(newCls);
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
			if (cls.eClass() == type || cls.eClass().getEAllSuperTypes().contains(type))
				validClasses.add(cls);
		}
		if (validClasses.size() > 0)
			return validClasses.get(((RandomModelModifierOptionObject)getOption()).getNextInt(validClasses.size()));
		return null;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__OPTION, oldOption, newOption);
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
				msgs = ((InternalEObject)option).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__OPTION, null, msgs);
			if (newOption != null)
				msgs = ((InternalEObject)newOption).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__OPTION, null, msgs);
			msgs = basicSetOption(newOption, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__OPTION, newOption, newOption));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__RESULT, oldResult, newResult);
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
				msgs = ((InternalEObject)result).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__RESULT, null, msgs);
			if (newResult != null)
				msgs = ((InternalEObject)newResult).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__RESULT, null, msgs);
			msgs = basicSetResult(newResult, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__RESULT, newResult, newResult));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestRun getTestRun() {
		if (eContainerFeatureID() != RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__TEST_RUN) return null;
		return (TestRun)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTestRun(TestRun newTestRun, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTestRun, RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__TEST_RUN, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTestRun(TestRun newTestRun) {
		if (newTestRun != eInternalContainer() || (eContainerFeatureID() != RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__TEST_RUN && newTestRun != null)) {
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

} //RandomModelModifierImpl

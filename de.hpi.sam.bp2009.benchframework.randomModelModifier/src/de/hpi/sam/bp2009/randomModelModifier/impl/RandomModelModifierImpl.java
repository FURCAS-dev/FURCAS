/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.randomModelModifier.impl;

import java.util.HashMap;
import java.util.Random;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.modelversioning.ecoremutator.EcoreMutator;
import org.modelversioning.ecoremutator.mutations.SeededModelProvider;
import org.modelversioning.ecoremutator.mutations.impl.AddObjectMutation;
import org.modelversioning.ecoremutator.mutations.impl.DeleteObjectMutation;
import org.modelversioning.ecoremutator.mutations.impl.UnsetFeatureMutation;
import org.modelversioning.ecoremutator.mutations.impl.UpdateFeatureMutation;

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

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Random Model Modifier</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.hpi.sam.bp2009.randomModelModifier.impl.RandomModelModifierImpl#getOption <em>Option</em>}</li>
 * <li>{@link de.hpi.sam.bp2009.randomModelModifier.impl.RandomModelModifierImpl#getResult <em>Result</em>}</li>
 * <li>{@link de.hpi.sam.bp2009.randomModelModifier.impl.RandomModelModifierImpl#getTestRun <em>Test Run</em>}</li>
 * <li>{@link de.hpi.sam.bp2009.randomModelModifier.impl.RandomModelModifierImpl#getName <em>Name</em>}</li>
 * <li>{@link de.hpi.sam.bp2009.randomModelModifier.impl.RandomModelModifierImpl#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class RandomModelModifierImpl extends EObjectImpl implements RandomModelModifier {
    /**
     * The cached value of the '{@link #getOption() <em>Option</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getOption()
     * @generated
     * @ordered
     */
    protected OptionObject option;
    /**
     * The cached value of the '{@link #getResult() <em>Result</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getResult()
     * @generated
     * @ordered
     */
    protected ResultObject result;
    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = "";
    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;
    /**
     * The default value of the '{@link #getDescription() <em>Description</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected static final String DESCRIPTION_EDEFAULT = null;
    /**
     * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected String description = DESCRIPTION_EDEFAULT;
    private SeededModelProvider modelProvider;
    private EcoreMutator mutator;

    private static final String SUCCESS_MESSAGE = "Successfully changed Model.";
    @SuppressWarnings("unused")
    private static final String FAILED_MESSAGE = "Failed to change Model!";

    private static final long providerseed = 12345;
    private static final long mutatorseed = 1234;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public RandomModelModifierImpl() {
        super();
        RandomModelModifierOptionObject optionObject = RandomModelModifierFactory.eINSTANCE
                .createRandomModelModifierOptionObject();
        optionObject.setNumberGenerator(new Random(mutatorseed));
        setOption(optionObject);
        setName("Random Model Modifier");
        setDescription("randomly add/remove classes, references or modify attributes in the model");
        setResult(BenchframeworkFactory.eINSTANCE.createResultObject());
    }

    @Override
    public void execute() {
        modelProvider = new SeededModelProvider(providerseed);
        Resource modelResource = getTestRun().getModel().getResources().get(0);
        modelProvider.setModelResource(modelResource);
        EPackage metaModelPackage = modelResource.getAllContents().next().eClass().getEPackage();
        modelProvider.setMetaModelPackages(metaModelPackage);
        mutator = new EcoreMutator(mutatorseed);

        if (getTestRun().getModel() == null)
            throw new IllegalStateException("Random Model Modifier needs a Model in the Testrun");

        Integer times = ((RandomModelModifierOptionObject) getOption()).getTimes();

        switch (((RandomModelModifierOptionObject) getOption()).getTask()) {
        case CLASS_CREATE:
            getResult().setStatus(createRandomClass(times) ? Status.SUCCESSFUL : Status.FAILED);
            break;
        case CLASS_DELETE:
            getResult().setStatus(deleteRandomClass(times) ? Status.SUCCESSFUL : Status.FAILED);
            break;
        case REFERENCE_CREATE:
            getResult().setStatus(createRandomReference(times) ? Status.SUCCESSFUL : Status.FAILED);
            break;
        case REFERENCE_DELETE:
            getResult().setStatus(deleteRandomReference(times) ? Status.SUCCESSFUL : Status.FAILED);
            break;
        case MODIFY_ATTRIBUTE:
            getResult().setStatus(modifyRandomAttribute(times) ? Status.SUCCESSFUL : Status.FAILED);
            break;
        }

        if (getResult().getStatus() == Status.SUCCESSFUL) {
            getResult().setMessage(SUCCESS_MESSAGE);
        } else if (getResult().getStatus() == Status.FAILED) {
            // getResult().setMessage(FAILED_MESSAGE);
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__TEST_RUN:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetTestRun((TestRun) otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__OPTION:
            setOption((OptionObject) newValue);
            return;
        case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__RESULT:
            setResult((ResultObject) newValue);
            return;
        case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__TEST_RUN:
            setTestRun((TestRun) newValue);
            return;
        case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__NAME:
            setName((String) newValue);
            return;
        case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__DESCRIPTION:
            setDescription((String) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
        case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__OPTION:
            setOption((OptionObject) null);
            return;
        case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__RESULT:
            setResult((ResultObject) null);
            return;
        case RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__TEST_RUN:
            setTestRun((TestRun) null);
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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy())
            return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (name: ");
        result.append(name);
        result.append(", description: ");
        result.append(description);
        result.append(')');
        return result.toString();
    }

    /**
     * Modify a random attribute from a random class. Basically the value of the chosen attribute will change to default if it's
     * actual value is not the default one. If it is the default value, it will be unset. In case there are no classes with
     * attributes in the given list, nothing will happen
     */
    private boolean modifyRandomAttribute(int times) {

        HashMap<Object, Object> options = new HashMap<Object, Object>();
        options.put("maxTries", times * 3);
        UpdateFeatureMutation m = new UpdateFeatureMutation(EAttribute.class);
        mutator.addMutation(m);
        mutator.mutate(modelProvider, times, options);
        mutator.removeMutation(m);
        return true;
    }

    /**
     * Remove a random reference of a random class. If the random class has no references, try it with another class. In case
     * there are no classes with references in the given list, nothing will happen.
     */
    private boolean deleteRandomReference(int times) {
        HashMap<Object, Object> options = new HashMap<Object, Object>();
        options.put("maxTries", times * 3);
        UnsetFeatureMutation m = new UnsetFeatureMutation(EReference.class);
        mutator.addMutation(m);
        mutator.mutate(modelProvider, times, options);
        mutator.removeMutation(m);
        return true;
    }

    /**
     * Creates a random reference of a random class. It the random class has no references, try it with another class. In case
     * there are no classes with references in the given list, nothing will happen.
     */
    private boolean createRandomReference(int times) {
        HashMap<Object, Object> options = new HashMap<Object, Object>();
        options.put("maxTries", times * 3);
        UpdateFeatureMutation m = new UpdateFeatureMutation(EReference.class);
        mutator.addMutation(m);
        mutator.mutate(modelProvider, times, options);
        mutator.removeMutation(m);
        return true;
    }

    /**
     * Delete a random class and remove it from classList
     */
    private boolean deleteRandomClass(int times) {
        HashMap<Object, Object> options = new HashMap<Object, Object>();
        options.put("maxTries", times * 3);
        int size = modelProvider.getModelSize();
        DeleteObjectMutation m = new DeleteObjectMutation();
        mutator.addMutation(m);
        mutator.mutate(modelProvider, times, options);
        mutator.removeMutation(m);

        return size - 1 == modelProvider.getModelSize();
    }

    /**
     * Create a random class and add it to classList
     */
    private boolean createRandomClass(int times) {
        HashMap<Object, Object> options = new HashMap<Object, Object>();
        options.put("maxTries", times * 3);
        int size = modelProvider.getModelSize();
        AddObjectMutation m = new AddObjectMutation();
        mutator.addMutation(m);
        mutator.mutate(modelProvider, times, options);
        mutator.removeMutation(m);

        return size + 1 == modelProvider.getModelSize();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RandomModelModifierPackage.Literals.RANDOM_MODEL_MODIFIER;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public OptionObject getOption() {
        return option;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetOption(OptionObject newOption, NotificationChain msgs) {
        OptionObject oldOption = option;
        option = newOption;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__OPTION, oldOption, newOption);
            if (msgs == null)
                msgs = notification;
            else
                msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setOption(OptionObject newOption) {
        if (newOption != option) {
            NotificationChain msgs = null;
            if (option != null)
                msgs = ((InternalEObject) option).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__OPTION, null, msgs);
            if (newOption != null)
                msgs = ((InternalEObject) newOption).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
                        - RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__OPTION, null, msgs);
            msgs = basicSetOption(newOption, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__OPTION,
                    newOption, newOption));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ResultObject getResult() {
        return result;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetResult(ResultObject newResult, NotificationChain msgs) {
        ResultObject oldResult = result;
        result = newResult;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__RESULT, oldResult, newResult);
            if (msgs == null)
                msgs = notification;
            else
                msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setResult(ResultObject newResult) {
        if (newResult != result) {
            NotificationChain msgs = null;
            if (result != null)
                msgs = ((InternalEObject) result).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__RESULT, null, msgs);
            if (newResult != null)
                msgs = ((InternalEObject) newResult).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
                        - RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__RESULT, null, msgs);
            msgs = basicSetResult(newResult, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__RESULT,
                    newResult, newResult));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public TestRun getTestRun() {
        if (eContainerFeatureID() != RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__TEST_RUN)
            return null;
        return (TestRun) eContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetTestRun(TestRun newTestRun, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newTestRun, RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__TEST_RUN, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setTestRun(TestRun newTestRun) {
        if (newTestRun != eInternalContainer()
                || (eContainerFeatureID() != RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__TEST_RUN && newTestRun != null)) {
            if (EcoreUtil.isAncestor(this, newTestRun))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newTestRun != null)
                msgs = ((InternalEObject) newTestRun).eInverseAdd(this, BenchframeworkPackage.TEST_RUN__OPERATORS, TestRun.class,
                        msgs);
            msgs = basicSetTestRun(newTestRun, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__TEST_RUN,
                    newTestRun, newTestRun));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__NAME,
                    oldName, name));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getDescription() {
        return description;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setDescription(String newDescription) {
        String oldDescription = description;
        description = newDescription;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RandomModelModifierPackage.RANDOM_MODEL_MODIFIER__DESCRIPTION,
                    oldDescription, description));
    }

} // RandomModelModifierImpl

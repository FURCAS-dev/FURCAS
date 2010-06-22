/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.randomGenerator.impl;

import java.util.HashMap;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.modelversioning.ecoremutator.EcoreMutator;
import org.modelversioning.ecoremutator.IModelProvider;
import org.modelversioning.ecoremutator.mutations.Mutation;
import org.modelversioning.ecoremutator.mutations.SeededModelProvider;
import org.modelversioning.ecoremutator.mutations.impl.AddObjectMutation;
import org.modelversioning.ecoremutator.mutations.impl.UpdateFeatureMutation;

import de.hpi.sam.bp2009.benchframework.BenchframeworkFactory;
import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;
import de.hpi.sam.bp2009.benchframework.OptionObject;
import de.hpi.sam.bp2009.benchframework.RandomNumberOptionObject;
import de.hpi.sam.bp2009.benchframework.ResultObject;
import de.hpi.sam.bp2009.benchframework.Status;
import de.hpi.sam.bp2009.benchframework.TestRun;
import de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGenerator;
import de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorFactory;
import de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorOptionObject;
import de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Random Generator</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.hpi.sam.bp2009.benchframework.randomGenerator.impl.RandomGeneratorImpl#getOption <em>Option</em>}</li>
 * <li>{@link de.hpi.sam.bp2009.benchframework.randomGenerator.impl.RandomGeneratorImpl#getResult <em>Result</em>}</li>
 * <li>{@link de.hpi.sam.bp2009.benchframework.randomGenerator.impl.RandomGeneratorImpl#getTestRun <em>Test Run</em>}</li>
 * <li>{@link de.hpi.sam.bp2009.benchframework.randomGenerator.impl.RandomGeneratorImpl#getName <em>Name</em>}</li>
 * <li>{@link de.hpi.sam.bp2009.benchframework.randomGenerator.impl.RandomGeneratorImpl#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class RandomGeneratorImpl extends EObjectImpl implements RandomGenerator {
    private static final String RANDOM_GENERATOR_DESCRIPTION = "Instantiates a random instance of the model and adds all needed references to it.";
    private static final String RANDOM_GENERATOR_NAME = "Random Model Instanciator";
    private long providerseed = 1234567;
    private long mutatorseed = 7654321;
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

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public RandomGeneratorImpl() {
        super();
        this.setOption(RandomGeneratorFactory.eINSTANCE.createRandomGeneratorOptionObject());
        this.setName(RANDOM_GENERATOR_NAME);
        this.setDescription(RANDOM_GENERATOR_DESCRIPTION);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RandomGeneratorPackage.Literals.RANDOM_GENERATOR;
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
                    RandomGeneratorPackage.RANDOM_GENERATOR__OPTION, oldOption, newOption);
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
                        - RandomGeneratorPackage.RANDOM_GENERATOR__OPTION, null, msgs);
            if (newOption != null)
                msgs = ((InternalEObject) newOption).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
                        - RandomGeneratorPackage.RANDOM_GENERATOR__OPTION, null, msgs);
            msgs = basicSetOption(newOption, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RandomGeneratorPackage.RANDOM_GENERATOR__OPTION, newOption,
                    newOption));
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
                    RandomGeneratorPackage.RANDOM_GENERATOR__RESULT, oldResult, newResult);
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
                        - RandomGeneratorPackage.RANDOM_GENERATOR__RESULT, null, msgs);
            if (newResult != null)
                msgs = ((InternalEObject) newResult).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
                        - RandomGeneratorPackage.RANDOM_GENERATOR__RESULT, null, msgs);
            msgs = basicSetResult(newResult, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RandomGeneratorPackage.RANDOM_GENERATOR__RESULT, newResult,
                    newResult));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public TestRun getTestRun() {
        if (eContainerFeatureID() != RandomGeneratorPackage.RANDOM_GENERATOR__TEST_RUN)
            return null;
        return (TestRun) eContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetTestRun(TestRun newTestRun, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newTestRun, RandomGeneratorPackage.RANDOM_GENERATOR__TEST_RUN, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setTestRun(TestRun newTestRun) {
        if (newTestRun != eInternalContainer()
                || (eContainerFeatureID() != RandomGeneratorPackage.RANDOM_GENERATOR__TEST_RUN && newTestRun != null)) {
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
            eNotify(new ENotificationImpl(this, Notification.SET, RandomGeneratorPackage.RANDOM_GENERATOR__TEST_RUN, newTestRun,
                    newTestRun));
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
            eNotify(new ENotificationImpl(this, Notification.SET, RandomGeneratorPackage.RANDOM_GENERATOR__NAME, oldName, name));
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
            eNotify(new ENotificationImpl(this, Notification.SET, RandomGeneratorPackage.RANDOM_GENERATOR__DESCRIPTION,
                    oldDescription, description));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public void generateRandomModel(Integer number, Resource resource, EPackage metaModel) {
        IModelProvider modelProvider = new SeededModelProvider(providerseed);
        modelProvider.setMetaModelPackages(metaModel);
        modelProvider.setModelResource(resource);
        EcoreMutator mutator = new EcoreMutator(mutatorseed);
        Mutation m1 = new AddObjectMutation();
        mutator.addMutation(m1);
        mutator.mutate(modelProvider, ((RandomNumberOptionObject) getOption()).getNextInt(5000));
        mutator.removeMutation(m1);
        Mutation m2 = new UpdateFeatureMutation(EStructuralFeature.class);
        HashMap<Object, Object> options = new HashMap<Object, Object>();
        options.put("maxTries", 10000);
        mutator.addMutation(m2);
        mutator.mutate(modelProvider, ((RandomNumberOptionObject) getOption()).getNextInt(5000), options);
        mutator.removeMutation(m2);
    }

    /**
     * <!-- begin-user-doc --> The strategy to generate the model instance is to choose a class of the meta model at random and
     * generate the minimum number of required referenced/containing classes. Therefore not all classes of the meta model have to
     * be in the generated instance if they're referenced with a lower bound of 0. <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public void execute() {
        RandomGeneratorOptionObject options = (RandomGeneratorOptionObject) getOption();
        if (options.getInstanceLoaded()) {
            // a model instance has already been loaded
            this.getTestRun().setModel(options.getModelInstance());
            setResult(BenchframeworkFactory.eINSTANCE.createResultObject());
            getResult().setStatus(Status.SUCCESSFUL);
            getResult().setMessage("Loaded " + result.toString());
        } else {
            // make sure to start at index 0 even if executed multiple times
            options.setNumberListIndex(0);
            EPackage metaModel = options.getMetaModel();

            ResourceSetImpl resultRS = new ResourceSetImpl();
            Resource result = resultRS.createResource(URI
                    .createURI("http://de.hpi.sam.bp2009.benchframework.randomGenerator/generatedInstance1"));
            resultRS.getPackageRegistry().put(metaModel.getNsURI(), metaModel);
            generateRandomModel(null, result, metaModel);
            this.getTestRun().setModel(resultRS);
            setResult(BenchframeworkFactory.eINSTANCE.createResultObject());
            getResult().setStatus(Status.SUCCESSFUL);
            getResult().setMessage("Generated " + result.toString());
            // reset the numberListIndex in case the generator is executed multiple times
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
        case RandomGeneratorPackage.RANDOM_GENERATOR__TEST_RUN:
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
        case RandomGeneratorPackage.RANDOM_GENERATOR__OPTION:
            return basicSetOption(null, msgs);
        case RandomGeneratorPackage.RANDOM_GENERATOR__RESULT:
            return basicSetResult(null, msgs);
        case RandomGeneratorPackage.RANDOM_GENERATOR__TEST_RUN:
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
        case RandomGeneratorPackage.RANDOM_GENERATOR__TEST_RUN:
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
        case RandomGeneratorPackage.RANDOM_GENERATOR__OPTION:
            return getOption();
        case RandomGeneratorPackage.RANDOM_GENERATOR__RESULT:
            return getResult();
        case RandomGeneratorPackage.RANDOM_GENERATOR__TEST_RUN:
            return getTestRun();
        case RandomGeneratorPackage.RANDOM_GENERATOR__NAME:
            return getName();
        case RandomGeneratorPackage.RANDOM_GENERATOR__DESCRIPTION:
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
        case RandomGeneratorPackage.RANDOM_GENERATOR__OPTION:
            setOption((OptionObject) newValue);
            return;
        case RandomGeneratorPackage.RANDOM_GENERATOR__RESULT:
            setResult((ResultObject) newValue);
            return;
        case RandomGeneratorPackage.RANDOM_GENERATOR__TEST_RUN:
            setTestRun((TestRun) newValue);
            return;
        case RandomGeneratorPackage.RANDOM_GENERATOR__NAME:
            setName((String) newValue);
            return;
        case RandomGeneratorPackage.RANDOM_GENERATOR__DESCRIPTION:
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
        case RandomGeneratorPackage.RANDOM_GENERATOR__OPTION:
            setOption((OptionObject) null);
            return;
        case RandomGeneratorPackage.RANDOM_GENERATOR__RESULT:
            setResult((ResultObject) null);
            return;
        case RandomGeneratorPackage.RANDOM_GENERATOR__TEST_RUN:
            setTestRun((TestRun) null);
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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
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
            return getTestRun() != null;
        case RandomGeneratorPackage.RANDOM_GENERATOR__NAME:
            return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
        case RandomGeneratorPackage.RANDOM_GENERATOR__DESCRIPTION:
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
} // RandomGeneratorImpl

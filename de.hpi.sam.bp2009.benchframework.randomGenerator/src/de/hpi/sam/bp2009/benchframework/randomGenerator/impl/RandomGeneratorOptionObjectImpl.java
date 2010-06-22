/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.randomGenerator.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;

import de.hpi.sam.bp2009.benchframework.impl.RandomNumberOptionObjectImpl;
import de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorOptionObject;
import de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Option Object</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.hpi.sam.bp2009.benchframework.randomGenerator.impl.RandomGeneratorOptionObjectImpl#getMetaModel <em>Meta Model
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class RandomGeneratorOptionObjectImpl extends RandomNumberOptionObjectImpl implements RandomGeneratorOptionObject {
    /**
     * The cached value of the '{@link #getMetaModel() <em>Meta Model</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getMetaModel()
     * @generated
     * @ordered
     */
    protected EPackage metaModel;

    protected boolean instanceLoaded;
    
    protected ResourceSet modelInstance;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public RandomGeneratorOptionObjectImpl() {
        super();
        setWizardPage(new RandomGeneratorWizardPage("Random Generator", this));
        setMetaModel(defaultModel());
        setInstanceLoaded(false);
    }

    public ResourceSet getModelInstance() {
        return modelInstance;
    }

    public void setModelInstance(ResourceSet modelInstance) {
        this.modelInstance = modelInstance;
    }
    
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RandomGeneratorPackage.Literals.RANDOM_GENERATOR_OPTION_OBJECT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EPackage getMetaModel() {
        return metaModel;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetMetaModel(EPackage newMetaModel, NotificationChain msgs) {
        EPackage oldMetaModel = metaModel;
        metaModel = newMetaModel;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    RandomGeneratorPackage.RANDOM_GENERATOR_OPTION_OBJECT__META_MODEL, oldMetaModel, newMetaModel);
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
    public void setMetaModel(EPackage newMetaModel) {
        if (newMetaModel != metaModel) {
            NotificationChain msgs = null;
            if (metaModel != null)
                msgs = ((InternalEObject) metaModel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - RandomGeneratorPackage.RANDOM_GENERATOR_OPTION_OBJECT__META_MODEL, null, msgs);
            if (newMetaModel != null)
                msgs = ((InternalEObject) newMetaModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
                        - RandomGeneratorPackage.RANDOM_GENERATOR_OPTION_OBJECT__META_MODEL, null, msgs);
            msgs = basicSetMetaModel(newMetaModel, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    RandomGeneratorPackage.RANDOM_GENERATOR_OPTION_OBJECT__META_MODEL, newMetaModel, newMetaModel));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case RandomGeneratorPackage.RANDOM_GENERATOR_OPTION_OBJECT__META_MODEL:
            return basicSetMetaModel(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case RandomGeneratorPackage.RANDOM_GENERATOR_OPTION_OBJECT__META_MODEL:
            return getMetaModel();
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
        case RandomGeneratorPackage.RANDOM_GENERATOR_OPTION_OBJECT__META_MODEL:
            setMetaModel((EPackage) newValue);
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
        case RandomGeneratorPackage.RANDOM_GENERATOR_OPTION_OBJECT__META_MODEL:
            setMetaModel((EPackage) null);
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
        case RandomGeneratorPackage.RANDOM_GENERATOR_OPTION_OBJECT__META_MODEL:
            return metaModel != null;
        }
        return super.eIsSet(featureID);
    }

    public static EPackage defaultModel() {

        // get the instance of EcoreFactory
        EcoreFactory ecoreFactory = EcoreFactory.eINSTANCE;

        // classes
        EClass petriNetClass = ecoreFactory.createEClass();
        petriNetClass.setName("PetriNet");

        EClass elementClass = ecoreFactory.createEClass();
        elementClass.setName("Element");
        elementClass.setAbstract(true);

        EClass arcClass = ecoreFactory.createEClass();
        arcClass.setName("Arc");
        arcClass.getESuperTypes().add(elementClass);

        EClass nodeClass = ecoreFactory.createEClass();
        nodeClass.setName("Node");
        nodeClass.setAbstract(true);
        nodeClass.getESuperTypes().add(elementClass);

        EClass placeClass = ecoreFactory.createEClass();
        placeClass.setName("Place");
        placeClass.getESuperTypes().add(nodeClass);

        EClass transitionClass = ecoreFactory.createEClass();
        transitionClass.setName("Transition");
        transitionClass.getESuperTypes().add(nodeClass);

        // package
        EPackage petriNetEPackage = ecoreFactory.createEPackage();
        petriNetEPackage.setName("petriNet");
        petriNetEPackage.setNsPrefix("petriNet");
        petriNetEPackage.setNsURI("http://petriNet/1.1");

        EcorePackage ecorePackage = EcorePackage.eINSTANCE;

        // attributes
        EAttribute placeTokens = ecoreFactory.createEAttribute();
        placeTokens.setName("noTokens");
        placeTokens.setEType(ecorePackage.getEInt());

        // references
        EReference elementsRef = ecoreFactory.createEReference();
        elementsRef.setName("elements");
        elementsRef.setContainment(true);
        elementsRef.setEType(elementClass);
        elementsRef.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY);
        elementsRef.setLowerBound(10);

        EReference diagramRef = ecoreFactory.createEReference();
        diagramRef.setName("diagram");
        diagramRef.setEType(petriNetClass);
        diagramRef.setUpperBound(1);
        diagramRef.setLowerBound(1);
        diagramRef.setEOpposite(elementsRef);
        elementsRef.setEOpposite(diagramRef);

        EReference incomingArcsRef = ecoreFactory.createEReference();
        incomingArcsRef.setName("incomingArcs");
        incomingArcsRef.setEType(nodeClass);
        incomingArcsRef.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY);
        incomingArcsRef.setLowerBound(0);

        EReference sourceRef = ecoreFactory.createEReference();
        sourceRef.setName("source");
        sourceRef.setEType(nodeClass);
        sourceRef.setUpperBound(1);
        sourceRef.setLowerBound(1);
        sourceRef.setEOpposite(incomingArcsRef);
        incomingArcsRef.setEOpposite(sourceRef);

        EReference outgoingArcsRef = ecoreFactory.createEReference();
        outgoingArcsRef.setName("outgoingArcs");
        outgoingArcsRef.setEType(nodeClass);
        outgoingArcsRef.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY);
        outgoingArcsRef.setLowerBound(0);

        EReference targetRef = ecoreFactory.createEReference();
        targetRef.setName("target");
        targetRef.setEType(nodeClass);
        targetRef.setUpperBound(1);
        targetRef.setLowerBound(1);
        targetRef.setEOpposite(outgoingArcsRef);
        outgoingArcsRef.setEOpposite(targetRef);

        // attach attributes and references to their classes
        placeClass.getEStructuralFeatures().add(placeTokens);

        elementClass.getEStructuralFeatures().add(diagramRef);
        petriNetClass.getEStructuralFeatures().add(elementsRef);
        nodeClass.getEStructuralFeatures().add(outgoingArcsRef);
        nodeClass.getEStructuralFeatures().add(incomingArcsRef);
        arcClass.getEStructuralFeatures().add(targetRef);
        arcClass.getEStructuralFeatures().add(sourceRef);

        petriNetEPackage.getEClassifiers().add(petriNetClass);
        petriNetEPackage.getEClassifiers().add(elementClass);
        petriNetEPackage.getEClassifiers().add(arcClass);
        petriNetEPackage.getEClassifiers().add(placeClass);
        petriNetEPackage.getEClassifiers().add(transitionClass);
        petriNetEPackage.getEClassifiers().add(nodeClass);

        return petriNetEPackage;
    }

    @Override
    public boolean getInstanceLoaded() {
        return instanceLoaded;
    }

    @Override
    public void setInstanceLoaded(boolean b) {
        instanceLoaded = b;  
    }

} // RandomGeneratorOptionObjectImpl

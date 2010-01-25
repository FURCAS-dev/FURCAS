/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.randomGenerator.impl;

import de.hpi.sam.bp2009.benchframework.impl.OptionObjectImpl;

import de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorOptionObject;
import de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorPackage;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Option Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.randomGenerator.impl.RandomGeneratorOptionObjectImpl#getMetaModel <em>Meta Model</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.randomGenerator.impl.RandomGeneratorOptionObjectImpl#getInstanceParameters <em>Instance Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RandomGeneratorOptionObjectImpl extends OptionObjectImpl implements RandomGeneratorOptionObject {
	/**
	 * The default value of the '{@link #getMetaModel() <em>Meta Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaModel()
	 * @generated
	 * @ordered
	 */
	protected static final ResourceSet META_MODEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMetaModel() <em>Meta Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaModel()
	 * @generated
	 * @ordered
	 */
	protected ResourceSet metaModel = META_MODEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInstanceParameters() <em>Instance Parameters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceParameters()
	 * @generated
	 * @ordered
	 */
	protected Map<String, Integer> instanceParameters;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RandomGeneratorOptionObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RandomGeneratorPackage.Literals.RANDOM_GENERATOR_OPTION_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceSet getMetaModel() {
		return metaModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetaModel(ResourceSet newMetaModel) {
		ResourceSet oldMetaModel = metaModel;
		metaModel = newMetaModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RandomGeneratorPackage.RANDOM_GENERATOR_OPTION_OBJECT__META_MODEL, oldMetaModel, metaModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<String, Integer> getInstanceParameters() {
		return instanceParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstanceParameters(Map<String, Integer> newInstanceParameters) {
		Map<String, Integer> oldInstanceParameters = instanceParameters;
		instanceParameters = newInstanceParameters;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RandomGeneratorPackage.RANDOM_GENERATOR_OPTION_OBJECT__INSTANCE_PARAMETERS, oldInstanceParameters, instanceParameters));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RandomGeneratorPackage.RANDOM_GENERATOR_OPTION_OBJECT__META_MODEL:
				return getMetaModel();
			case RandomGeneratorPackage.RANDOM_GENERATOR_OPTION_OBJECT__INSTANCE_PARAMETERS:
				return getInstanceParameters();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RandomGeneratorPackage.RANDOM_GENERATOR_OPTION_OBJECT__META_MODEL:
				setMetaModel((ResourceSet)newValue);
				return;
			case RandomGeneratorPackage.RANDOM_GENERATOR_OPTION_OBJECT__INSTANCE_PARAMETERS:
				setInstanceParameters((Map<String, Integer>)newValue);
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
			case RandomGeneratorPackage.RANDOM_GENERATOR_OPTION_OBJECT__META_MODEL:
				setMetaModel(META_MODEL_EDEFAULT);
				return;
			case RandomGeneratorPackage.RANDOM_GENERATOR_OPTION_OBJECT__INSTANCE_PARAMETERS:
				setInstanceParameters((Map<String, Integer>)null);
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
			case RandomGeneratorPackage.RANDOM_GENERATOR_OPTION_OBJECT__META_MODEL:
				return META_MODEL_EDEFAULT == null ? metaModel != null : !META_MODEL_EDEFAULT.equals(metaModel);
			case RandomGeneratorPackage.RANDOM_GENERATOR_OPTION_OBJECT__INSTANCE_PARAMETERS:
				return instanceParameters != null;
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
		result.append(" (metaModel: ");
		result.append(metaModel);
		result.append(", instanceParameters: ");
		result.append(instanceParameters);
		result.append(')');
		return result.toString();
	}
	
	private ResourceSet defaultModel(){
		ResourceSet result = new ResourceSetImpl();
		Resource resource = result.createResource(URI.createURI("http://de.hpi.sam.bp2009.benchframework.randomGenerator/defaultMetaModel"));
		
		//get the instance of EcoreFactory
		EcoreFactory ecoreFactory = EcoreFactory.eINSTANCE;
			
		//classes
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
		
		//package
		EPackage petriNetEPackage = ecoreFactory.createEPackage();
		petriNetEPackage.setName("petriNet");
		petriNetEPackage.setNsPrefix("petriNet");
		petriNetEPackage.setNsURI("http://petriNet/1.1");
		
		EcorePackage ecorePackage = EcorePackage.eINSTANCE;
		
		//attributes
		EAttribute placeTokens = ecoreFactory.createEAttribute();
		placeTokens.setName("nrTokens");
		placeTokens.setEType(ecorePackage.getEInt());

		//references
		EReference elementsRef = ecoreFactory.createEReference();
		elementsRef.setName("elements");
		elementsRef.setContainment(true);
		elementsRef.setEType(elementClass);
		elementsRef.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY);
		elementsRef.setLowerBound(0);
		
		EReference diagramRef = ecoreFactory.createEReference();
		diagramRef.setName("diagram");
		diagramRef.setEType(petriNetClass);
		diagramRef.setUpperBound(1);
		diagramRef.setLowerBound(0);
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
		outgoingArcsRef.setName("incomingArcs");
		outgoingArcsRef.setEType(nodeClass);
		outgoingArcsRef.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY);
		outgoingArcsRef.setLowerBound(0);
		
		EReference targetRef = ecoreFactory.createEReference();
		targetRef.setName("source");
		targetRef.setEType(nodeClass);
		targetRef.setUpperBound(1);
		targetRef.setLowerBound(1);
		targetRef.setEOpposite(outgoingArcsRef);
		outgoingArcsRef.setEOpposite(targetRef);

		//attach attributes and references to their classes
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
		
		resource.getContents().add(petriNetEPackage);
		
		return result;
	}

} //RandomGeneratorOptionObjectImpl

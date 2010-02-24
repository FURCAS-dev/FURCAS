/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.randomGenerator.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.jface.wizard.WizardPage;

import de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorOptionObject;
import de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Option Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.randomGenerator.impl.RandomGeneratorOptionObjectImpl#getWizardPage <em>Wizard Page</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.randomGenerator.impl.RandomGeneratorOptionObjectImpl#getMetaModel <em>Meta Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RandomGeneratorOptionObjectImpl extends EObjectImpl implements RandomGeneratorOptionObject {
	/**
	 * The default value of the '{@link #getWizardPage() <em>Wizard Page</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWizardPage()
	 * @generated
	 * @ordered
	 */
	protected static final WizardPage WIZARD_PAGE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getWizardPage() <em>Wizard Page</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWizardPage()
	 * @generated
	 * @ordered
	 */
	protected WizardPage wizardPage = WIZARD_PAGE_EDEFAULT;
	/**
	 * The cached value of the '{@link #getMetaModel() <em>Meta Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaModel()
	 * @generated
	 * @ordered
	 */
	protected EPackage metaModel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public RandomGeneratorOptionObjectImpl() {
		super();
		setWizardPage(new RandomGeneratorWizardPage("Random Generator", this));
		setMetaModel(defaultModel());
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
	public WizardPage getWizardPage() {
		return wizardPage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWizardPage(WizardPage newWizardPage) {
		WizardPage oldWizardPage = wizardPage;
		wizardPage = newWizardPage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RandomGeneratorPackage.RANDOM_GENERATOR_OPTION_OBJECT__WIZARD_PAGE, oldWizardPage, wizardPage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage getMetaModel() {
		if (metaModel != null && metaModel.eIsProxy()) {
			InternalEObject oldMetaModel = (InternalEObject)metaModel;
			metaModel = (EPackage)eResolveProxy(oldMetaModel);
			if (metaModel != oldMetaModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RandomGeneratorPackage.RANDOM_GENERATOR_OPTION_OBJECT__META_MODEL, oldMetaModel, metaModel));
			}
		}
		return metaModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage basicGetMetaModel() {
		return metaModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetaModel(EPackage newMetaModel) {
		EPackage oldMetaModel = metaModel;
		metaModel = newMetaModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RandomGeneratorPackage.RANDOM_GENERATOR_OPTION_OBJECT__META_MODEL, oldMetaModel, metaModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<String, Object> getOptionsAsMap() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOptionsAsMap(Map<String, Object> map) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RandomGeneratorPackage.RANDOM_GENERATOR_OPTION_OBJECT__WIZARD_PAGE:
				return getWizardPage();
			case RandomGeneratorPackage.RANDOM_GENERATOR_OPTION_OBJECT__META_MODEL:
				if (resolve) return getMetaModel();
				return basicGetMetaModel();
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
			case RandomGeneratorPackage.RANDOM_GENERATOR_OPTION_OBJECT__WIZARD_PAGE:
				setWizardPage((WizardPage)newValue);
				return;
			case RandomGeneratorPackage.RANDOM_GENERATOR_OPTION_OBJECT__META_MODEL:
				setMetaModel((EPackage)newValue);
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
			case RandomGeneratorPackage.RANDOM_GENERATOR_OPTION_OBJECT__WIZARD_PAGE:
				setWizardPage(WIZARD_PAGE_EDEFAULT);
				return;
			case RandomGeneratorPackage.RANDOM_GENERATOR_OPTION_OBJECT__META_MODEL:
				setMetaModel((EPackage)null);
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
			case RandomGeneratorPackage.RANDOM_GENERATOR_OPTION_OBJECT__WIZARD_PAGE:
				return WIZARD_PAGE_EDEFAULT == null ? wizardPage != null : !WIZARD_PAGE_EDEFAULT.equals(wizardPage);
			case RandomGeneratorPackage.RANDOM_GENERATOR_OPTION_OBJECT__META_MODEL:
				return metaModel != null;
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
		result.append(" (wizardPage: ");
		result.append(wizardPage);
		result.append(')');
		return result.toString();
	}

	public static EPackage defaultModel(){
		
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
		placeTokens.setName("noTokens");
		placeTokens.setEType(ecorePackage.getEInt());

		//references
		EReference elementsRef = ecoreFactory.createEReference();
		elementsRef.setName("elements");
		elementsRef.setContainment(true);
		elementsRef.setEType(elementClass);
		elementsRef.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY);
		elementsRef.setLowerBound(1);
		
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
		
		return petriNetEPackage;
	}

} //RandomGeneratorOptionObjectImpl

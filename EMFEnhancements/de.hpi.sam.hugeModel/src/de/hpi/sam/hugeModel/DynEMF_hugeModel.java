package de.hpi.sam.hugeModel;
import java.io.File;
import java.io.IOException;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;

//copyright für runtime measurement library: http://jetm.void.fm/license.html

import etm.core.configuration.BasicEtmConfigurator;
import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;
import etm.core.renderer.SimpleTextRenderer;


public class DynEMF_hugeModel {
	
	private static EtmMonitor monitor;
	private static final EtmMonitor etmMonitor = EtmManager.getEtmMonitor();
		 
	private static void setup() {
		BasicEtmConfigurator.configure();
		monitor = EtmManager.getEtmMonitor();
		monitor.start();
	}

	private static void tearDown() {
		monitor.stop();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		setup();
		
		boolean blowMetaModel = false;
		int blowFactor = 20000;
		
		EtmPoint point = etmMonitor.createPoint("DynEMF_hugeModel:main");

		if (blowMetaModel) {
			// out of memory error at about 73000
			createHugeMetaModel(blowFactor);
		} else {
			// out of memory error at about 111000
			createHugeModel(blowFactor);
			createHugeModel(blowFactor);
			createHugeModel(blowFactor);
			createHugeModel(blowFactor);
		}
		point.collect();
		
		etmMonitor.render(new SimpleTextRenderer());

		tearDown();
	}
	
	private static void createHugeMetaModel(int blowFactor) {
		
		EtmPoint point = etmMonitor.createPoint("DynEMF_hugeModel:createHugeMetaModel");
		
		// set up all the packages and factories
		EcoreFactory ecoreFactory = EcoreFactory.eINSTANCE;
		EcorePackage ecorePackage = EcorePackage.eINSTANCE;
		EPackage metaModelEPackage = ecoreFactory.createEPackage();
		
		EClass previousClass = null;
		System.out.println("Creating EClasses...");
		for (int i = 0; i < blowFactor; i++) {
			EClass anEClass = ecoreFactory.createEClass();
			anEClass.setName("Class" + i);
			
			EAttribute anEAttribute = ecoreFactory.createEAttribute();
			anEAttribute.setName("Attribute" + i);
			anEAttribute.setEType(ecorePackage.getEInt());
			
			anEClass.getEStructuralFeatures().add(anEAttribute);
			
			metaModelEPackage.getEClassifiers().add(anEClass);
			
			if (previousClass != null) {
				EReference anEReference = ecoreFactory.createEReference();
				anEReference.setName("Reference" + i);
				anEReference.setEType(anEClass);
				anEReference.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY);
				anEReference.setLowerBound(0);
				
				EReference anotherEReference = ecoreFactory.createEReference();
				anotherEReference.setName("Reference" + i);
				anotherEReference.setEType(previousClass);
				anotherEReference.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY);
				anotherEReference.setLowerBound(0);
				anotherEReference.setEOpposite(anEReference);
				anEReference.setEOpposite(anotherEReference);
				
				anEClass.getEStructuralFeatures().add(anotherEReference);
				previousClass.getEStructuralFeatures().add(anEReference);
			}
			previousClass = anEClass;
			if (i % 1000 == 0) {
				System.out.format("Created %d EClasses\n", i);
			}
		}
		point.collect();
	}
	
	/**
	 * 
	 * @param blowFactor
	 */
	public static Resource createHugeModel(int blowFactor) {
		
		EtmPoint point = etmMonitor.createPoint("DynEMF_hugeModel:createHugeModel");
		
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
		
		//build an instance of the model
		EFactory petriFactory = petriNetEPackage.getEFactoryInstance();
		EObject petrinet = petriFactory.create(petriNetClass);
		
		System.out.println("Creating Places...");
		
		//OutOfMemoryError bei etwa 111.000 Instanzen
		for(int i = 1; i <= blowFactor; i++) {
			EObject newPlace = petriFactory.create(placeClass);
			newPlace.eSet(placeTokens, 5);
			newPlace.eSet(diagramRef, petrinet);
	
			if (i % 1000 == 0) {
				System.out.format("Created %d instances of placeClass\n", i);
			}
		}
		
		System.out.println("Creating Transitions...");
		TreeIterator<EObject> it = petrinet.eAllContents();
		
		EObject place = null;
		if (it.hasNext())
			place = it.next();
		int j = 0;
		while (it.hasNext()) {
			EObject nextPlace = it.next();
			
			EObject transition = petriFactory.create(transitionClass);
			transition.eSet(diagramRef, petrinet);
			
			EObject arc1 = petriFactory.create(arcClass);
			arc1.eSet(diagramRef, petrinet);
			
			EObject arc2 = petriFactory.create(arcClass);
			arc2.eSet(diagramRef, petrinet);
			
			arc1.eSet(sourceRef, place);
			arc1.eSet(targetRef, transition);
			arc2.eSet(sourceRef, transition);
			arc2.eSet(targetRef, nextPlace);
			
			j++;
			if (j % 1000 == 0){
				System.out.format("Created and linked %d instances of transitionClass\n", j);
			}
			place = nextPlace;
		}
		
		// Create a resource set
		//
		ResourceSet resourceSet = new ResourceSetImpl();

		// Get the URI of the model file.
		
		File file=new File("model.xml");
		try {
			file.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		URI fileURI = URI.createPlatformResourceURI(file.getAbsolutePath(), true);

		// Create a resource for this file.
		
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xml", new XMLResourceFactoryImpl());
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(petriNetEPackage.getNsURI(), petriNetEPackage);



		Resource resource = resourceSet.createResource(fileURI);
		resource.getContents().add(petrinet);
//		try {
//			resource.save(Collections.EMPTY_MAP);
//		} catch (IOException e) {
//			System.err.println("Error during save!");
//			e.printStackTrace();
//		}
		point.collect();
		return resource;
		
	}
}

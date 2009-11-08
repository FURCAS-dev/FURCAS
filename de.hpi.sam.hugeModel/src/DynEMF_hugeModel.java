import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.*;


public class DynEMF_hugeModel {
	public static void main(String[] args) {
		createModel();

	}
	private static EPackage createModel() {
		
		//get the instances of EcoreFactory
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
		
		//save the starting time
		long start = System.currentTimeMillis();
		EFactory petriFactory = petriNetEPackage.getEFactoryInstance();
		EObject petrinet = petriFactory.create(petriNetClass);
		
		System.out.println("Creating Places...");
		
		//OutOfMemoryError bei etwa 111.000 Instanzen
		for(int i = 1; i <= 111000; i++) {
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
		//save ending time
		long stop = System.currentTimeMillis();
		long timedelta = stop - start;
		System.out.format("ExecutionTime: %d milliseconds", timedelta);

		return ecorePackage;
		
	}
}

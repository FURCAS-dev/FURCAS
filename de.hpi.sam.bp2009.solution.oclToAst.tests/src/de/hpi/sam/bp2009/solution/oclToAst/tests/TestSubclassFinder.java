package de.hpi.sam.bp2009.solution.oclToAst.tests;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import de.hpi.sam.bp2009.solution.oclToAst.EcoreHelper;
import de.hpi.sam.petriNet.PetriNet;
import de.hpi.sam.petriNet.PetriNetFactory;
import de.hpi.sam.petriNet.PetriNetPackage;
import de.hpi.sam.petriNet.Place;

public class TestSubclassFinder extends TestCase {
    public void testSubclassQuery() {
        EcoreHelper helper = EcoreHelper.getInstance();
        EClass testClass = PetriNetPackage.eINSTANCE.getElement();
        Collection<EClass> subclasses = helper.getAllSubclasses(testClass);
        assertEquals(4, subclasses.size());
        Set<String> foundNames = new HashSet<String>();
        Set<String> expectedNames = new HashSet<String>();
        expectedNames.addAll(Arrays.asList("Node", "Arc", "Transition", "Place"));
        for (EClass subclass : subclasses) {
            foundNames.add(subclass.getName());
        }
        assertEquals(expectedNames, foundNames);
    }

    public void testReverseReferenceTraverser() {
        EcoreHelper helper = EcoreHelper.getInstance();
        PetriNet petriNet = PetriNetFactory.eINSTANCE.createPetriNet();
        Place place = PetriNetFactory.eINSTANCE.createPlace();
        petriNet.getElements().add(place);
        ResourceSet rs = new ResourceSetImpl();
        Resource e = rs.createResource(URI.createURI("http://my.own.resource/something"));
        e.getContents().add(petriNet);
        Collection<EObject> result = helper.reverseNavigate(place, (EReference) petriNet.eClass().getEStructuralFeature(
                PetriNetPackage.PETRI_NET__ELEMENTS), helper.getQueryContext(rs), rs);
        assertEquals(petriNet, result.iterator().next());
    }
}

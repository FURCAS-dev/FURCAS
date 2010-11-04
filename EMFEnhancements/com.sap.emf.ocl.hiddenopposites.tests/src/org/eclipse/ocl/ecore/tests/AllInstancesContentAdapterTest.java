package org.eclipse.ocl.ecore.tests;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

import com.sap.emf.oppositeendfinder.AllInstancesContentAdapter;

public class AllInstancesContentAdapterTest
		extends AbstractTestSuite {

	public void test_evaluateSimpleAllInstancesAfterAdd() {
		AllInstancesContentAdapter aica = new AllInstancesContentAdapter();
		Resource res = new ResourceImpl();
		res.eAdapters().add(aica);
		EObject tree1 = fruitFactory.create(tree);
		res.getContents().add(tree1);
		EObject apple1 = fruitFactory.create(apple);
		res.getContents().add(apple1);
		EObject apple2 = fruitFactory.create(apple);
		res.getContents().add(apple2);

		assertEquals(1, aica.allInstances(tree).size());
		assertTrue(aica.allInstances(tree).contains(tree1));
		assertEquals(2, aica.allInstances(apple).size());
		assertTrue(aica.allInstances(apple).contains(apple1) && aica.allInstances(apple).contains(apple2));
		assertEquals(2, aica.allInstances(fruit).size());
		assertTrue(aica.allInstances(fruit).contains(apple1) && aica.allInstances(fruit).contains(apple2));
	}

	public void test_evaluateSimpleAllInstancesAfterAddingAdapterLater() {
		Resource res = new ResourceImpl();
		EObject tree1 = fruitFactory.create(tree);
		res.getContents().add(tree1);
		EObject apple1 = fruitFactory.create(apple);
		res.getContents().add(apple1);
		EObject apple2 = fruitFactory.create(apple);
		res.getContents().add(apple2);

		AllInstancesContentAdapter aica = new AllInstancesContentAdapter();
		res.eAdapters().add(aica);

		assertEquals(1, aica.allInstances(tree).size());
		assertTrue(aica.allInstances(tree).contains(tree1));
		assertEquals(2, aica.allInstances(apple).size());
		assertTrue(aica.allInstances(apple).contains(apple1) && aica.allInstances(apple).contains(apple2));
		assertEquals(2, aica.allInstances(fruit).size());
		assertTrue(aica.allInstances(fruit).contains(apple1) && aica.allInstances(fruit).contains(apple2));
	}

	public void test_evaluateSimpleAllInstancesAfterAddAndRemove() {
		AllInstancesContentAdapter aica = new AllInstancesContentAdapter();
		Resource res = new ResourceImpl();
		res.eAdapters().add(aica);
		EObject tree1 = fruitFactory.create(tree);
		res.getContents().add(tree1);
		EObject apple1 = fruitFactory.create(apple);
		res.getContents().add(apple1);
		EObject apple2 = fruitFactory.create(apple);
		res.getContents().add(apple2);

		// now remove one apple again
		res.getContents().remove(apple2);
		assertEquals(1, aica.allInstances(tree).size());
		assertTrue(aica.allInstances(tree).contains(tree1));
		assertEquals(1, aica.allInstances(apple).size());
		assertTrue(aica.allInstances(apple).contains(apple1));
		assertEquals(1, aica.allInstances(fruit).size());
		assertTrue(aica.allInstances(fruit).contains(apple1));
	}

}

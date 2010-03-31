package com.sap.mi.fwk.ui.test.unit.databinding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.set.WritableSet;

import com.sap.demo.mi.testmetamodel.databinding.AttributeEnumeration;
import com.sap.demo.mi.testmetamodel.databinding.AttributeEnumerationEnum;
import com.sap.demo.mi.testmetamodel.databinding.ObjectWithAttributes;
import com.sap.demo.mi.testmetamodel.databinding.TargetObject;
import com.sap.mi.fwk.ui.databinding.MoinObservables;
import com.sap.mi.fwk.ui.internal.databinding.observables.RefObjectObservableValue;

/**
 * Tests around MOIN {@link RefObjectObservableValue RefObjectObservableValues}.
 * 
 * @author d027044
 * 
 */
public class RefObjectObservableSetTest extends DatabindingTest {

	/**
	 * Tests around binding multi valued unique string attributes:
	 * <ul>
	 * <li>Initial data transfer
	 * <li>Target to Model
	 * <li>Model to Target
	 * <ul>
	 */
	public void testStringAttribute() {
		// Create the test RefObject
		ObjectWithAttributes refObject = createInstanceObjectWithAttributes();
		Collection<String> moinSet = refObject.getStringAttrMultiUnique();
		moinSet.add("one");
		moinSet.add("two");

		// Establish the binding for the multi valued string attribute
		IObservableSet target = new WritableSet(new ArrayList<String>(), String.class);
		IObservableSet model = MoinObservables.observeSet(refObject, ObjectWithAttributes.DESCRIPTORS.STRING_ATTR_MULTI_UNIQUE());
		getDbc().bindSet(target, model, null, null);

		// Check initial data flow
		// Wrap the MOIN collection into a set because MOIN needs a list
		// (! - why?) in order to be able to compare the contents against the
		// target set which is of course no set --> CSN 0004725799
		// ------------------------------------------------------------------
		// Copied from CSN reply (Christof Wildermuth)
		// The JMI specification states that to-n primitive Attributes are
		// mapped as "java.util.Collection". We decided to use a specialized
		// List in order to fullfil this specification and in order to guarantee
		// a stable order of the elements. Now the Java "Collection"
		// specification states the following:
		//		                                                                        
		// The general contract for the <tt>Object.equals</tt> method states
		// that equals must be symmetric (in other words, <tt>a.equals(b)</tt>
		// if and only if <tt>b.equals(a)</tt>). The contracts for
		// <tt>List.equals</tt> and <tt>Set.equals</tt> state that lists are
		// only equal to other lists and sets to other sets. Thus, a custom
		// <tt>equals</tt> method for a collection class that implements neither
		// the <tt>List</tt> nor <tt>Set</tt> interface must return
		// <tt>false</tt> when this collection is compared to any list or set.
		// (By the same logic, it is not possible to write a class that
		// correctly implements both the <tt>Set</tt> and <tt>List</tt>
		// interfaces.)
		//		                                                                        
		// So even if we'd decided to use a custom implementation that is
		// neither "List or Set", an equals comparison to a Set could NEVER
		// return true because this violates the "symmetric principle" of
		// "equals()".
		//		                                                                        
		// The problem is that the JMI spec explicitly wants a Collection and
		// not a List. If the API was a List, it would be clear for everybody
		// that the "List.equals()" contract is valid which explicitly states
		// that a List can only be equal to another List. Another problem is
		// that the JMI spec uses "List" at APIs in order to indicate
		// "orderedness" so we can't just change the generated API for
		// non-ordered, multivalued Attributes (as in your case) to List as this
		// might lead to the wrong conclusion that the modeled Attribute is
		// ordered.
		//		                                                                        
		// Hope this helps. If you have any further questions please contact us
		// again.

		assertEquals("Initial data flow failed", new HashSet<String>(moinSet), target);

		// Check data flow target to model does not happen (MOIN
		// RefObjectObservableSet is a unmodifiableSet)
		target.add("dummy");
		assertEquals("Change in target was propagated to model", 2, model.size());
		target.remove("dummy");

		// Check data flow model to target
		// 1. Add at end
		moinSet.add("three");
		assertEquals("Change in model was not propagated to target", getStringHashSet(moinSet), target);

		// 2. Remove object
		moinSet.remove("four");
		assertEquals("Remove in model was not propagated to target", getStringHashSet(moinSet), target);
		
		// 3. AddAll
		ArrayList<String> arrayList = new ArrayList<String>(2);
		arrayList.add("four");
		arrayList.add("five");
		moinSet.addAll(arrayList);
		assertEquals("AddAll in model was not propagated to target", getStringHashSet(moinSet), target);
		
		// 4. RemoveAll
		arrayList = new ArrayList<String>(2);
		arrayList.add("one");
		arrayList.add("two");
		moinSet.removeAll(arrayList);
		assertEquals("RemoveAll in model was not correctly propagated to target", getStringHashSet(moinSet), target);
		
		// 5. RetainAll
		arrayList = new ArrayList<String>(2);
		arrayList.add("four");
		arrayList.add("five");
		moinSet.retainAll(arrayList);
		assertEquals("RetainAll in model was not correctly propagated to target", getStringHashSet(moinSet), target);
		
		// 6. Clear
		moinSet.clear();
		assertEquals("List must have 0 entries", getStringHashSet(moinSet), target);
	}

	/**
	 * Tests around binding multi valued unique integer attributes:
	 * <ul>
	 * <li>Initial data transfer
	 * <li>Target to Model
	 * <li>Model to Target
	 * <li>Above including standard conversion
	 * <ul>
	 */
	public void testIntegerAttribute() {
		// Create the test RefObject
		ObjectWithAttributes refObject = createInstanceObjectWithAttributes();
		Collection<Integer> moinSet = refObject.getIntegerAttrMultiUnique();
		moinSet.add(1);
		moinSet.add(2);

		// Establish the binding for the multi valued integer attribute
		IObservableSet target = new WritableSet(new ArrayList<String>(), String.class);
		IObservableSet model = MoinObservables.observeSet(refObject, ObjectWithAttributes.DESCRIPTORS.INTEGER_ATTR_MULTI_UNIQUE());
		getDbc().bindSet(target, model, null, null);

		// Check initial data flow
		// Wrap the MOIN collection into a set because MOIN needs a list
		// (! - why?) in order to be able to compare the contents against the
		// target set which is of course no set --> CSN 0004725799
		assertEquals("Initial data flow failed", getStringHashSet(moinSet), target);

		// Check data flow target to model does not happen (MOIN
		// RefObjectObservableSet is a unmodifiableSet)
		target.add("0");
		assertEquals("Change in target was propagated to model", 2, model.size());
		target.remove("0");

		// Check data flow model to target
		// 1. Add at end
		moinSet.add(3);
		assertEquals("Change in model was not propagated to target", getStringHashSet(moinSet), target);
		
		// 2. Remove object
		moinSet.remove(4);
		assertEquals("Remove in model was not propagated to target", getStringHashSet(moinSet), target);
		
		// 3. AddAll
		ArrayList<Integer> arrayList = new ArrayList<Integer>(2);
		arrayList.add(4);
		arrayList.add(5);
		moinSet.addAll(arrayList);
		assertEquals("AddAll in model was not propagated to target", getStringHashSet(moinSet), target);
		
		// 4. RemoveAll
		arrayList = new ArrayList<Integer>(2);
		arrayList.add(1);
		arrayList.add(2);
		moinSet.removeAll(arrayList);
		assertEquals("RemoveAll in model was not correctly propagated to target", getStringHashSet(moinSet), target);
		
		// 5. RetainAll
		arrayList = new ArrayList<Integer>(2);
		arrayList.add(4);
		arrayList.add(5);
		moinSet.retainAll(arrayList);
		assertEquals("RetainAll in model was not correctly propagated to target", getStringHashSet(moinSet), target);
		
		// 6. Clear
		moinSet.clear();
		assertEquals("List must have 0 entries", getStringHashSet(moinSet), target);
	}

	/**
	 * Tests around binding multi valued unique enumeration attributes:
	 * <ul>
	 * <li>Initial data transfer
	 * <li>Target to Model
	 * <li>Model to Target
	 * <li>Above including standard conversion
	 * <ul>
	 */
	public void testEnumerationAttribute() {
		// Create the test RefObject
		ObjectWithAttributes refObject = createInstanceObjectWithAttributes();
		Collection<AttributeEnumeration> moinSet = refObject.getEnumerationAttrMultiUnique();
		moinSet.add(AttributeEnumerationEnum.ONE);
		moinSet.add(AttributeEnumerationEnum.TWO);

		// Establish the binding for the multi valued enumeration attribute
		IObservableSet target = new WritableSet(new ArrayList<String>(), String.class);
		IObservableSet model = MoinObservables.observeSet(refObject, ObjectWithAttributes.DESCRIPTORS.ENUMERATION_ATTR_MULTI_UNIQUE());
		getDbc().bindSet(target, model, null, null);

		// Check initial data flow
		// Wrap the MOIN collection into a set because MOIN needs a list
		// (! - why?) in order to be able to compare the contents against the
		// target set which is of course no set --> CSN 0004725799
		assertEquals("Initial data flow failed", getStringHashSet(moinSet), target);

		// Check data flow target to model does not happen (MOIN
		// RefObjectObservableSet is a unmodifiableSet)
		target.add("zero");
		assertEquals("Change in target was propagated to model", 2, model.size());
		target.remove("zero");

		// Check data flow model to target
		// 1. Add at end
		moinSet.add(AttributeEnumerationEnum.THREE);
		assertEquals("Change in model was not propagated to target", getStringHashSet(moinSet), target);

		// 2. Remove object
		moinSet.remove(AttributeEnumerationEnum.THREE);
		assertEquals("Remove in model was not propagated to target", getStringHashSet(moinSet), target);
		
		// 3. AddAll
		ArrayList<AttributeEnumeration> arrayList = new ArrayList<AttributeEnumeration>(2);
		arrayList.add(AttributeEnumerationEnum.FOUR);
		arrayList.add(AttributeEnumerationEnum.FIVE);
		moinSet.addAll(arrayList);
		assertEquals("AddAll in model was not propagated to target", getStringHashSet(moinSet), target);
		
		// 4. RemoveAll
		arrayList = new ArrayList<AttributeEnumeration>(2);
		arrayList.add(AttributeEnumerationEnum.ONE);
		arrayList.add(AttributeEnumerationEnum.TWO);
		moinSet.removeAll(arrayList);
		assertEquals("RemoveAll in model was not correctly propagated to target", getStringHashSet(moinSet), target);
		
		// 5. RetainAll
		arrayList = new ArrayList<AttributeEnumeration>(2);
		arrayList.add(AttributeEnumerationEnum.FOUR);
		arrayList.add(AttributeEnumerationEnum.FIVE);
		moinSet.retainAll(arrayList);
		assertEquals("RetainAll in model was not correctly propagated to target", getStringHashSet(moinSet), target);
		
		// 6. Clear
		moinSet.clear();
		assertEquals("List must have 0 entries", getStringHashSet(moinSet), target);
	}

	/**
	 * Tests around binding multi valued unique object attributes:
	 * <ul>
	 * <li>Initial data transfer
	 * <li>Target to Model
	 * <li>Model to Target
	 * <li>Deletion of object contained in list
	 * <ul>
	 */
	@SuppressWarnings("unchecked")
	public void testObjectAttribute() {
		// Create target object instances
		TargetObject targetObject0 = getConnection().createElement(TargetObject.class);
		targetObject0.setId("0");
		TargetObject targetObject1 = getConnection().createElement(TargetObject.class);
		targetObject1.setId("1");
		TargetObject targetObject2 = getConnection().createElement(TargetObject.class);
		targetObject2.setId("2");
		TargetObject targetObject3 = getConnection().createElement(TargetObject.class);
		targetObject3.setId("3");
		TargetObject targetObject4 = getConnection().createElement(TargetObject.class);
		targetObject4.setId("4");
		TargetObject targetObject5 = getConnection().createElement(TargetObject.class);
		targetObject5.setId("5");

		// Create the test RefObject
		ObjectWithAttributes refObject = createInstanceObjectWithAttributes();
		Collection<TargetObject> moinSet = refObject.getObjectAttrMultiUnique();
		moinSet.add(targetObject1);
		moinSet.add(targetObject2);

		// Establish the binding for the multi valued integer attribute
		IObservableSet target = new WritableSet(new ArrayList<TargetObject>(), TargetObject.class);
		IObservableSet model = MoinObservables.observeSet(refObject, ObjectWithAttributes.DESCRIPTORS.OBJECT_ATTR_MULTI_UNIQUE());
		getDbc().bindSet(target, model, null, null);

		// Check initial data flow
		assertEquals("Initial data flow failed", getTargetObjectIdHashSet(moinSet), getTargetObjectIdHashSet(target));

		// Check data flow target to model does not happen (MOIN
		// RefObjectObservableSet is a unmodifiableSet)
		target.add(targetObject0);
		assertEquals("Change in target was propagated to model", 2, model.size());
		target.remove(targetObject0);

		// Check data flow model to target
		// 1. Add at end
		moinSet.add(targetObject3);
		assertEquals("Change in model was not propagated to target", getTargetObjectIdHashSet(moinSet), getTargetObjectIdHashSet(target));
		
		// 2. Remove object
		moinSet.remove(targetObject3);
		assertEquals("Remove in model was not propagated to target", getTargetObjectIdHashSet(moinSet), getTargetObjectIdHashSet(target));
		
		// 3. AddAll
		ArrayList<TargetObject> arrayList = new ArrayList<TargetObject>(2);
		arrayList.add(targetObject0);
		arrayList.add(targetObject4);
		arrayList.add(targetObject5);
		moinSet.addAll(arrayList);
		assertEquals("AddAll in model was not propagated to target", getTargetObjectIdHashSet(moinSet), getTargetObjectIdHashSet(target));
		
		// 4. RemoveAll
		arrayList = new ArrayList<TargetObject>(2);
		arrayList.add(targetObject1);
		arrayList.add(targetObject2);
		moinSet.removeAll(arrayList);
		assertEquals("RemoveAll in model was not correctly propagated to target", getTargetObjectIdHashSet(moinSet),
				getTargetObjectIdHashSet(target));
		
		// 5. Delete contained element
		targetObject0.refDelete();
		assertFalse("Element must have been removed from MOIN set", getTargetObjectIdHashSet(moinSet).contains("0"));
		assertEquals("Delete object in model was not correctly propagated to target", getTargetObjectIdHashSet(moinSet),
				getTargetObjectIdHashSet(target));
		
		// 6. RetainAll
		arrayList = new ArrayList<TargetObject>(2);
		arrayList.add(targetObject4);
		arrayList.add(targetObject5);
		moinSet.retainAll(arrayList);
		assertEquals("RetainAll in model was not correctly propagated to target", getTargetObjectIdHashSet(moinSet),
				getTargetObjectIdHashSet(target));
		
		// 7. Clear
		moinSet.clear();
		assertEquals("List must have 0 entries", getTargetObjectIdHashSet(moinSet), getTargetObjectIdHashSet(target));
	}

	/**
	 * Tests around binding multi valued non-composite unique object references:
	 * <ul>
	 * <li>Initial data transfer
	 * <li>Target to Model
	 * <li>Model to Target
	 * <li>Deletion of object contained in list
	 * <ul>
	 */
	@SuppressWarnings("unchecked")
	public void testObjectReference() {
		// Create target object instances
		TargetObject targetObject0 = getConnection().createElement(TargetObject.class);
		targetObject0.setId("0");
		TargetObject targetObject1 = getConnection().createElement(TargetObject.class);
		targetObject1.setId("1");
		TargetObject targetObject2 = getConnection().createElement(TargetObject.class);
		targetObject2.setId("2");
		TargetObject targetObject3 = getConnection().createElement(TargetObject.class);
		targetObject3.setId("3");
		TargetObject targetObject4 = getConnection().createElement(TargetObject.class);
		targetObject4.setId("4");
		TargetObject targetObject5 = getConnection().createElement(TargetObject.class);
		targetObject5.setId("5");

		// Create the test RefObject
		ObjectWithAttributes refObject = createInstanceObjectWithAttributes();
		Collection<TargetObject> moinSet = refObject.getObjectRefMultiUnique();
		moinSet.add(targetObject1);
		moinSet.add(targetObject2);

		// Establish the binding for the multi valued integer attribute
		IObservableSet target = new WritableSet(new ArrayList<TargetObject>(), TargetObject.class);
		IObservableSet model = MoinObservables.observeSet(refObject, ObjectWithAttributes.DESCRIPTORS.OBJECT_REF_MULTI_UNIQUE());
		getDbc().bindSet(target, model, null, null);

		// Check initial data flow
		assertEquals("Initial data flow failed", getTargetObjectIdHashSet(moinSet), getTargetObjectIdHashSet(target));

		// Check data flow target to model does not happen (MOIN
		// RefObjectObservableSet is a unmodifiableSet)
		target.add(targetObject0);
		assertEquals("Change in target was propagated to model", 2, model.size());
		target.remove(targetObject0);

		// Check data flow model to target
		// 1. Add at end
		moinSet.add(targetObject3);
		assertEquals("Change in model was not propagated to target", getTargetObjectIdHashSet(moinSet), getTargetObjectIdHashSet(target));

		// 2. Remove object
		moinSet.remove(targetObject3);
		assertEquals("Remove in model was not propagated to target", getTargetObjectIdHashSet(moinSet), getTargetObjectIdHashSet(target));
		
		// 3. AddAll
		ArrayList<TargetObject> arrayList = new ArrayList<TargetObject>(2);
		arrayList.add(targetObject0);
		arrayList.add(targetObject4);
		arrayList.add(targetObject5);
		moinSet.addAll(arrayList);
		assertEquals("AddAll in model was not propagated to target", getTargetObjectIdHashSet(moinSet), getTargetObjectIdHashSet(target));
		
		// 4. RemoveAll
		arrayList = new ArrayList<TargetObject>(2);
		arrayList.add(targetObject1);
		arrayList.add(targetObject2);
		moinSet.removeAll(arrayList);
		assertEquals("RemoveAll in model was not correctly propagated to target", getTargetObjectIdHashSet(moinSet),
				getTargetObjectIdHashSet(target));
		
		// 5. Delete contained element
		targetObject0.refDelete();
		assertFalse("Element must have been removed from MOIN set", getTargetObjectIdHashSet(moinSet).contains("0"));
		assertEquals("Delete object in model was not correctly propagated to target", getTargetObjectIdHashSet(moinSet),
				getTargetObjectIdHashSet(target));
		
		// 6. RetainAll
		arrayList = new ArrayList<TargetObject>(2);
		arrayList.add(targetObject4);
		arrayList.add(targetObject5);
		moinSet.retainAll(arrayList);
		assertEquals("RetainAll in model was not correctly propagated to target", getTargetObjectIdHashSet(moinSet),
				getTargetObjectIdHashSet(target));
		
		// 7. Clear
		moinSet.clear();
		assertEquals("List must have 0 entries", getTargetObjectIdHashSet(moinSet), getTargetObjectIdHashSet(target));
	}

	/**
	 * Tests around binding multi valued composite unique object references:
	 * <ul>
	 * <li>Initial data transfer
	 * <li>Target to Model
	 * <li>Model to Target
	 * <li>Deletion of object contained in list
	 * <ul>
	 */
	@SuppressWarnings("unchecked")
	public void testObjectReferenceComposite() {
		// Create target object instances
		TargetObject targetObject0 = getConnection().createElement(TargetObject.class);
		targetObject0.setId("0");
		TargetObject targetObject1 = getConnection().createElement(TargetObject.class);
		targetObject1.setId("1");
		TargetObject targetObject2 = getConnection().createElement(TargetObject.class);
		targetObject2.setId("2");
		TargetObject targetObject3 = getConnection().createElement(TargetObject.class);
		targetObject3.setId("3");
		TargetObject targetObject4 = getConnection().createElement(TargetObject.class);
		targetObject4.setId("4");
		TargetObject targetObject5 = getConnection().createElement(TargetObject.class);
		targetObject5.setId("5");

		// Create the test RefObject
		ObjectWithAttributes refObject = createInstanceObjectWithAttributes();
		Collection<TargetObject> moinSet = refObject.getObjectRefCompMultiUnique();
		moinSet.add(targetObject1);
		moinSet.add(targetObject2);

		// Establish the binding for the multi valued integer attribute
		IObservableSet target = new WritableSet(new ArrayList<TargetObject>(), TargetObject.class);
		IObservableSet model = MoinObservables.observeSet(refObject, ObjectWithAttributes.DESCRIPTORS.OBJECT_REF_COMP_MULTI_UNIQUE());
		getDbc().bindSet(target, model, null, null);

		// Check initial data flow
		assertEquals("Initial data flow failed", getTargetObjectIdHashSet(moinSet), getTargetObjectIdHashSet(target));

		// Check data flow target to model does not happen (MOIN
		// RefObjectObservableSet is a unmodifiableSet)
		target.add(targetObject0);
		assertEquals("Change in target was propagated to model", 2, model.size());
		target.remove(targetObject0);

		// Check data flow model to target
		// 1. Add at end
		moinSet.add(targetObject3);
		assertEquals("Change in model was not propagated to target", getTargetObjectIdHashSet(moinSet), getTargetObjectIdHashSet(target));
		
		// 2. Remove object
		moinSet.remove(targetObject3);
		assertEquals("Remove in model was not propagated to target", getTargetObjectIdHashSet(moinSet), getTargetObjectIdHashSet(target));
		
		// 3. AddAll
		ArrayList<TargetObject> arrayList = new ArrayList<TargetObject>(2);
		arrayList.add(targetObject0);
		arrayList.add(targetObject4);
		arrayList.add(targetObject5);
		moinSet.addAll(arrayList);
		assertEquals("AddAll in model was not propagated to target", getTargetObjectIdHashSet(moinSet), getTargetObjectIdHashSet(target));
		
		// 4. RemoveAll
		arrayList = new ArrayList<TargetObject>(2);
		arrayList.add(targetObject1);
		arrayList.add(targetObject2);
		moinSet.removeAll(arrayList);
		assertEquals("RemoveAll in model was not correctly propagated to target", getTargetObjectIdHashSet(moinSet),
				getTargetObjectIdHashSet(target));
		
		// 5. Delete contained element
		targetObject0.refDelete();
		assertFalse("Element must have been removed from MOIN set", getTargetObjectIdHashSet(moinSet).contains("0"));
		assertEquals("Delete object in model was not correctly propagated to target", getTargetObjectIdHashSet(moinSet),
				getTargetObjectIdHashSet(target));
		
		// 6. RetainAll
		arrayList = new ArrayList<TargetObject>(2);
		arrayList.add(targetObject4);
		arrayList.add(targetObject5);
		moinSet.retainAll(arrayList);
		assertEquals("RetainAll in model was not correctly propagated to target", getTargetObjectIdHashSet(moinSet),
				getTargetObjectIdHashSet(target));
		
		// 7. Clear
		moinSet.clear();
		assertEquals("List must have 0 entries", getTargetObjectIdHashSet(moinSet), getTargetObjectIdHashSet(target));
	}

	/**
	 * Tests that not allowed set bindings do not work:
	 * <ul>
	 * <li>Non-unique attribute
	 * <li>Non-unique reference
	 * <li>Single-valued attribute
	 * <li>Single-Valued reference
	 * </ul>
	 */
	public void testNegative() {
		// Try to bind set against non-unique attribute
		ObjectWithAttributes refObject = createInstanceObjectWithAttributes();
		try {
			MoinObservables.observeSet(refObject, ObjectWithAttributes.DESCRIPTORS.STRING_ATTR_MULTI());
			fail("Binding a non-unique attribute to a set observable must not succeed");
		} catch (IllegalArgumentException e) {
			// Expected
		}

		// Non-unique multi-valued references are not allowed by MOIN

		// Try to bind set against single-valued attribute
		refObject = createInstanceObjectWithAttributes();
		try {
			MoinObservables.observeSet(refObject, ObjectWithAttributes.DESCRIPTORS.STRING_ATTR());
			fail("Binding a single-valued attribute to a set observable must not succeed");
		} catch (IllegalArgumentException e) {
			// Expected
		}

		// Try to bind set against single-valued reference
		refObject = createInstanceObjectWithAttributes();
		try {
			MoinObservables.observeSet(refObject, ObjectWithAttributes.DESCRIPTORS.OBJECT_REF());
			fail("Binding a single-valued reference to a set observable must not succeed");
		} catch (IllegalArgumentException e) {
			// Expected
		}
	}

	/**
	 * Further tests:
	 * <ul>
	 * <li>toString()
	 * </ul>
	 */
	public void testMisc() {
		ObjectWithAttributes refObject = createInstanceObjectWithAttributes();
		IObservableSet set = MoinObservables.observeSet(refObject, ObjectWithAttributes.DESCRIPTORS.STRING_ATTR_MULTI_UNIQUE());
		String string = set.toString();
		assertNotNull("toString() must not return null", string);

	}

	private HashSet<String> getStringHashSet(Collection<?> collection) {
		HashSet<String> strings = new HashSet<String>(collection.size());
		Iterator<?> it = collection.iterator();
		while (it.hasNext()) {
			Object object = (Object) it.next();
			strings.add(object.toString());
		}
		return strings;
	}

	private HashSet<String> getTargetObjectIdHashSet(Collection<TargetObject> collection) {
		HashSet<String> strings = new HashSet<String>(collection.size());
		Iterator<TargetObject> it = collection.iterator();
		while (it.hasNext()) {
			TargetObject object = it.next();
			strings.add(object.getId());
		}
		return strings;
	}
}
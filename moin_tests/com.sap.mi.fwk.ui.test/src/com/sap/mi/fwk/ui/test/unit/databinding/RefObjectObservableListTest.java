package com.sap.mi.fwk.ui.test.unit.databinding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;

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
public class RefObjectObservableListTest extends DatabindingTest {

	/**
	 * Tests around binding multi valued sorted string attributes:
	 * <ul>
	 * <li>Initial data transfer
	 * <li>Target to Model
	 * <li>Model to Target
	 * <ul>
	 */
	public void testStringAttribute() {
		// Create the test RefObject
		ObjectWithAttributes refObject = createInstanceObjectWithAttributes();
		List<String> moinList = refObject.getStringAttrMultiOrdered();
		moinList.add("one");
		moinList.add("two");

		// Establish the binding for the multi valued string attribute
		IObservableList target = new WritableList(new ArrayList<String>(), String.class);
		IObservableList model = MoinObservables.observeList(refObject, ObjectWithAttributes.DESCRIPTORS
				.STRING_ATTR_MULTI_ORDERED());
		getDbc().bindList(target, model, null, null);

		// Check initial data flow
		assertEquals("Initial data flow failed", moinList, target);

		// Check data flow target to model does not happen (MOIN
		// RefObjectObservableList is a unmodifiableList)
		target.add("dummy");
		assertEquals("Change in target was propagated to model", 2, model.size());
		target.remove("dummy");

		// Check data flow model to target
		// 1. Add at end
		moinList.add("three");
		assertEquals("Change in model was not propagated to target", moinList, target);

		// 2. Insert
		moinList.add(1, "four");
		assertEquals("Change in model was not propagated to target", moinList, target);

		// 3. Remove object
		moinList.remove("four");
		assertEquals("Remove in model was not propagated to target", moinList, target);

		// 4. Remove index
		moinList.remove(0);
		assertEquals("Remove in model was not propagated to target", moinList, target);

		// 5. AddAll
		ArrayList<String> arrayList = new ArrayList<String>(2);
		arrayList.add("four");
		arrayList.add("five");
		moinList.addAll(arrayList);
		assertEquals("AddAll in model was not propagated to target", moinList, target);

		// 6. AddAll index
		arrayList = new ArrayList<String>(2);
		arrayList.add("zero");
		arrayList.add("one");
		moinList.addAll(0, arrayList);
		assertEquals("AddAll(index) in model was not propagated to target", moinList, target);

		// 7. Set
		moinList.set(3, "threeChanged");
		assertEquals("Set in model was not propagated to target", moinList, target);

		// 8a. RemoveAll - single operations within same command group
		arrayList = new ArrayList<String>(2);
		arrayList.add("six");
		arrayList.add("seven");
		moinList.addAll(arrayList);
		// make sure elements have been added to moin list
		assertTrue("Element must have been added to MOIN list", moinList.contains("six"));
		assertTrue("Element must have been added to MOIN list", moinList.contains("seven"));
		getConnection().getCommandStack().openGroup("test");
		moinList.remove("six");
		moinList.remove("seven");
		// make sure elements have been deleted from moin list
		assertTrue("Element must not have been removed from MOIN list before command group is closed", target.contains("six"));
		assertTrue("Element must not have been removed from MOIN list before command group is closed", target.contains("seven"));
		getConnection().getCommandStack().closeGroup();
		assertEquals("Removing two elements within same command group was not correctly propagated to target", moinList, target);

		// 8b. RemoveAll
		arrayList = new ArrayList<String>(2);
		arrayList.add("six");
		arrayList.add("seven");
		moinList.addAll(arrayList);
		// make sure elements have been added to moin list
		assertTrue("Element have been added to MOIN list", moinList.contains("six"));
		assertTrue("Element have been added to MOIN list", moinList.contains("seven"));

		moinList.removeAll(arrayList);
		// make sure elements have been deleted from moin list
		assertFalse("Element must have been removed from MOIN list", moinList.contains("six"));
		assertFalse("Element must have been removed from MOIN list", moinList.contains("seven"));
		assertEquals("RemoveAll in model was not correctly propagated to target", moinList, target);

		// 9. RetainAll
		arrayList = new ArrayList<String>(2);
		arrayList.add("six");
		arrayList.add("seven");
		moinList.addAll(arrayList);
		// make sure elements have been added to moin list
		assertTrue("Element have been added to MOIN list", moinList.contains("six"));
		assertTrue("Element have been added to MOIN list", moinList.contains("seven"));

		moinList.retainAll(arrayList);
		// make sure elements have been deleted from moin list
		assertTrue("Element must not have been removed from MOIN list", moinList.contains("six"));
		assertTrue("Element must not have been removed from MOIN list", moinList.contains("seven"));
		assertEquals("RetainAll in model was not correctly propagated to target", moinList, target);

		// 10. Clear
		moinList.clear();
		assertTrue("MOIN list must be empty", moinList.size() == 0);
		assertEquals("List must have 0 entries", moinList, target);
	}

	/**
	 * Tests around binding multi valued sorted integer attributes:
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
		List<Integer> moinList = refObject.getIntegerAttrMultiOrdered();
		moinList.add(1);
		moinList.add(2);

		// Establish the binding for the multi valued integer attribute
		IObservableList target = new WritableList(new ArrayList<String>(), String.class);
		IObservableList model = MoinObservables.observeList(refObject, ObjectWithAttributes.DESCRIPTORS
				.INTEGER_ATTR_MULTI_ORDERED());
		getDbc().bindList(target, model, null, null);

		// Check initial data flow
		assertEquals("Initial data flow failed", getStringList(moinList), target);

		// Check data flow target to model does not happen (MOIN
		// RefObjectObservableList is a unmodifiableList)
		target.add("99");
		assertEquals("Change in target was propagated to model", 2, model.size());
		target.remove("99");

		// Check data flow model to target
		// 1. Add at end
		moinList.add(3);
		assertEquals("Change in model was not propagated to target", getStringList(moinList), target);

		// 2. Insert
		moinList.add(1, 4);
		assertEquals("Change in model was not propagated to target", getStringList(moinList), target);

		// 3. Remove object
		moinList.remove((Integer) 4);
		assertEquals("Remove in model was not propagated to target", getStringList(moinList), target);

		// 4. Remove index
		moinList.remove((int) 0);
		assertEquals("Remove in model was not propagated to target", getStringList(moinList), target);

		// 5. AddAll
		ArrayList<Integer> arrayList = new ArrayList<Integer>(2);
		arrayList.add(4);
		arrayList.add(5);
		moinList.addAll(arrayList);
		assertEquals("AddAll in model was not propagated to target", getStringList(moinList), target);

		// 6. AddAll index
		arrayList = new ArrayList<Integer>(2);
		arrayList.add(0);
		arrayList.add(1);
		moinList.addAll(0, arrayList);
		assertEquals("AddAll(index) in model was not propagated to target", getStringList(moinList), target);

		// 7. Set
		moinList.set(3, 31);
		assertEquals("Set in model was not propagated to target", getStringList(moinList), target);

		// 8a. RemoveAll - single operations within same command group
		arrayList = new ArrayList<Integer>(2);
		arrayList.add(6);
		arrayList.add(7);
		moinList.addAll(arrayList);
		// make sure elements have been added to moin list
		assertTrue("Element must have been added to MOIN list", moinList.contains(6));
		assertTrue("Element must have been added to MOIN list", moinList.contains(7));
		getConnection().getCommandStack().openGroup("test");
		moinList.remove((Integer) 6);
		moinList.remove((Integer) 7);
		// make sure elements have not been deleted from target list
		assertTrue("Element must not have been removed from target list before command group is closed", target.contains(((Integer) 6)
				.toString()));
		assertTrue("Element must not have been removed from target list before command group is closed", target.contains(((Integer) 7)
				.toString()));
		getConnection().getCommandStack().closeGroup();
		assertEquals("Removing two elements within same command group was not correctly propagated to target", getStringList(moinList),
				target);

		// 8b. RemoveAll
		arrayList = new ArrayList<Integer>(2);
		arrayList.add(6);
		arrayList.add(7);
		moinList.addAll(arrayList);
		// make sure elements have been added to moin list
		assertTrue("Element have been added to MOIN list", moinList.contains(6));
		assertTrue("Element have been added to MOIN list", moinList.contains(7));

		moinList.removeAll(arrayList);
		// make sure elements have been deleted from moin list
		assertFalse("Element must have been removed from MOIN list", moinList.contains(6));
		assertFalse("Element must have been removed from MOIN list", moinList.contains(7));
		assertEquals("RemoveAll in model was not correctly propagated to target", getStringList(moinList), target);

		// 9. RetainAll
		arrayList = new ArrayList<Integer>(2);
		arrayList.add(6);
		arrayList.add(7);
		moinList.addAll(arrayList);
		// make sure elements have been added to moin list
		assertTrue("Element have been added to MOIN list", moinList.contains(6));
		assertTrue("Element have been added to MOIN list", moinList.contains(7));

		moinList.retainAll(arrayList);
		// make sure elements have been deleted from moin list
		assertTrue("Element must not have been removed from MOIN list", moinList.contains(6));
		assertTrue("Element must not have been removed from MOIN list", moinList.contains(7));
		assertEquals("RetainAll in model was not correctly propagated to target", getStringList(moinList), target);

		// 10. Clear
		moinList.clear();
		assertTrue("MOIN list must be empty", moinList.size() == 0);
		assertEquals("List must have 0 entries", moinList, target);
	}

	/**
	 * Tests around binding multi valued sorted integer attributes:
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
		List<AttributeEnumeration> moinList = refObject.getEnumerationAttrMultiOrdered();
		moinList.add(AttributeEnumerationEnum.ONE);
		moinList.add(AttributeEnumerationEnum.TWO);

		// Establish the binding for the multi valued integer attribute
		IObservableList target = new WritableList(new ArrayList<String>(), String.class);
		IObservableList model = MoinObservables.observeList(refObject, ObjectWithAttributes.DESCRIPTORS
				.ENUMERATION_ATTR_MULTI_ORDERED());
		getDbc().bindList(target, model, null, null);

		// Check initial data flow
		assertEquals("Initial data flow failed", getStringList(moinList), target);

		// Check data flow target to model does not happen (MOIN
		// RefObjectObservableList is a unmodifiableList)
		target.add("zero");
		assertEquals("Change in target was propagated to model", 2, model.size());
		target.remove("zero");

		// Check data flow model to target
		// 1. Add at end
		moinList.add(AttributeEnumerationEnum.THREE);
		assertEquals("Change in model was not propagated to target", getStringList(moinList), target);

		// 2. Insert
		moinList.add(1, AttributeEnumerationEnum.FOUR);
		assertEquals("Change in model was not propagated to target", getStringList(moinList), target);

		// 3. Remove object
		moinList.remove(AttributeEnumerationEnum.FOUR);
		assertEquals("Remove in model was not propagated to target", getStringList(moinList), target);

		// 4. Remove index
		moinList.remove(0);
		assertEquals("Remove in model was not propagated to target", getStringList(moinList), target);

		// 5. AddAll
		ArrayList<AttributeEnumeration> arrayList = new ArrayList<AttributeEnumeration>(2);
		arrayList.add(AttributeEnumerationEnum.FOUR);
		arrayList.add(AttributeEnumerationEnum.FIVE);
		moinList.addAll(arrayList);
		assertEquals("AddAll in model was not propagated to target", getStringList(moinList), target);

		// 6. AddAll index
		arrayList = new ArrayList<AttributeEnumeration>(2);
		arrayList.add(AttributeEnumerationEnum.ZERO);
		arrayList.add(AttributeEnumerationEnum.ONE);
		moinList.addAll(0, arrayList);
		assertEquals("AddAll(index) in model was not propagated to target", getStringList(moinList), target);

		// 7. Set
		moinList.set(3, AttributeEnumerationEnum.ZERO);
		assertEquals("Set in model was not propagated to target", getStringList(moinList), target);
		moinList.set(3, AttributeEnumerationEnum.THREE);
		assertEquals("Reset in model was not propagated to target", getStringList(moinList), target);

		// 8a. RemoveAll - single operations within same command group
		arrayList = new ArrayList<AttributeEnumeration>(2);
		arrayList.add(AttributeEnumerationEnum.SIX);
		arrayList.add(AttributeEnumerationEnum.SEVEN);
		moinList.addAll(arrayList);
		// make sure elements have been added to moin list
		assertTrue("Element has been added to MOIN list", moinList.contains(AttributeEnumerationEnum.SIX));
		assertTrue("Element has been added to MOIN list", moinList.contains(AttributeEnumerationEnum.SEVEN));
		getConnection().getCommandStack().openGroup("test");
		moinList.remove(AttributeEnumerationEnum.SIX);
		moinList.remove(AttributeEnumerationEnum.SEVEN);
		// make sure elements have not been deleted from target list
		assertTrue("Element must not have been removed from target list before command group is closed", target
				.contains(AttributeEnumerationEnum.SIX.toString()));
		assertTrue("Element must not have been removed from target list before command group is closed", target
				.contains(AttributeEnumerationEnum.SEVEN.toString()));
		getConnection().getCommandStack().closeGroup();
		assertEquals("Removing two elements within same command group was not correctly propagated to target", getStringList(moinList),
				target);

		// 8b. RemoveAll
		arrayList = new ArrayList<AttributeEnumeration>(2);
		arrayList.add(AttributeEnumerationEnum.SIX);
		arrayList.add(AttributeEnumerationEnum.SEVEN);
		moinList.addAll(arrayList);
		// make sure elements have been added to moin list
		assertTrue("Element has been added to MOIN list", moinList.contains(AttributeEnumerationEnum.SIX));
		assertTrue("Element has been added to MOIN list", moinList.contains(AttributeEnumerationEnum.SEVEN));
		moinList.removeAll(arrayList);
		// make sure elements have been deleted from moin list
		assertFalse("Element must have been removed from MOIN list", moinList.contains(AttributeEnumerationEnum.SIX));
		assertFalse("Element must have been removed from MOIN list", moinList.contains(AttributeEnumerationEnum.SEVEN));
		assertEquals("RemoveAll in model was not correctly propagated to target", getStringList(moinList), target);

		// 9. RetainAll
		arrayList = new ArrayList<AttributeEnumeration>(2);
		arrayList.add(AttributeEnumerationEnum.SIX);
		arrayList.add(AttributeEnumerationEnum.SEVEN);
		moinList.addAll(arrayList);
		// make sure elements have been added to moin list
		assertTrue("Element has been added to MOIN list", moinList.contains(AttributeEnumerationEnum.SIX));
		assertTrue("Element has been added to MOIN list", moinList.contains(AttributeEnumerationEnum.SEVEN));

		moinList.retainAll(arrayList);
		// make sure elements have been deleted from moin list
		assertTrue("Element must not have been removed from MOIN list", moinList.contains(AttributeEnumerationEnum.SIX));
		assertTrue("Element must not have been removed from MOIN list", moinList.contains(AttributeEnumerationEnum.SEVEN));
		assertEquals("RetainAll in model was not correctly propagated to target", getStringList(moinList), target);

		// 10. Clear
		moinList.clear();
		assertTrue("MOIN list must be empty", moinList.size() == 0);
		assertEquals("List must have 0 entries", moinList, target);
	}

	/**
	 * Tests around binding multi valued sorted object attributes:
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
		TargetObject targetObject6 = getConnection().createElement(TargetObject.class);
		targetObject6.setId("6");
		TargetObject targetObject7 = getConnection().createElement(TargetObject.class);
		targetObject7.setId("7");

		// Create the test RefObject
		ObjectWithAttributes refObject = createInstanceObjectWithAttributes();
		List<TargetObject> moinList = refObject.getObjectAttrMultiOrdered();
		moinList.add(targetObject1);
		moinList.add(targetObject2);

		// Establish the binding for the multi valued integer attribute
		IObservableList target = new WritableList(new ArrayList<TargetObject>(), TargetObject.class);
		IObservableList model = MoinObservables.observeList(refObject, ObjectWithAttributes.DESCRIPTORS
				.OBJECT_ATTR_MULTI_ORDERED());
		getDbc().bindList(target, model, null, null);

		// Check initial data flow
		assertEquals("Initial data flow failed", getTargetObjectIdList(moinList), getTargetObjectIdList(target));

		// Check data flow target to model does not happen (MOIN
		// RefObjectObservableList is a unmodifiableList)
		target.add(targetObject0);
		assertEquals("Change in target was propagated to model", 2, model.size());
		target.remove(targetObject0);

		// Check data flow model to target
		// 1. Add at end
		moinList.add(targetObject3);
		assertEquals("Change in model was not propagated to target", getTargetObjectIdList(moinList), getTargetObjectIdList(target));

		// 2. Insert
		moinList.add(1, targetObject4);
		assertEquals("Change in model was not propagated to target", getTargetObjectIdList(moinList), getTargetObjectIdList(target));

		// 3. Remove object
		moinList.remove(targetObject4);
		assertEquals("Remove in model was not propagated to target", getTargetObjectIdList(moinList), getTargetObjectIdList(target));

		// 4. Remove index
		moinList.remove(0);
		assertEquals("Remove in model was not propagated to target", getTargetObjectIdList(moinList), getTargetObjectIdList(target));

		// 5. AddAll
		ArrayList<TargetObject> arrayList = new ArrayList<TargetObject>(2);
		arrayList.add(targetObject4);
		arrayList.add(targetObject5);
		moinList.addAll(arrayList);
		assertEquals("AddAll in model was not propagated to target", getTargetObjectIdList(moinList), getTargetObjectIdList(target));

		// 6. AddAll index
		arrayList = new ArrayList<TargetObject>(2);
		arrayList.add(targetObject0);
		arrayList.add(targetObject1);
		moinList.addAll(0, arrayList);
		assertEquals("AddAll(index) in model was not propagated to target", getTargetObjectIdList(moinList), getTargetObjectIdList(target));

		// 7. Set
		moinList.set(3, targetObject6);
		assertEquals("Set in model was not propagated to target", getTargetObjectIdList(moinList), getTargetObjectIdList(target));
		moinList.set(3, targetObject3);
		assertEquals("Reset in model was not propagated to target", getTargetObjectIdList(moinList), getTargetObjectIdList(target));

		// 8a. RemoveAll - single operations within same command group
		arrayList = new ArrayList<TargetObject>(2);
		arrayList.add(targetObject6);
		arrayList.add(targetObject7);
		moinList.addAll(arrayList);
		// make sure elements have been added to moin list
		assertTrue("Element has been added to MOIN list", moinList.contains(targetObject6));
		assertTrue("Element has been added to MOIN list", moinList.contains(targetObject7));
		getConnection().getCommandStack().openGroup("test");
		moinList.remove(targetObject6);
		moinList.remove(targetObject7);
		// make sure elements have not been deleted from target list
		assertTrue("Element must not have been removed from target list before command group is closed", target.contains(targetObject6));
		assertTrue("Element must not have been removed from target list before command group is closed", target.contains(targetObject7));
		getConnection().getCommandStack().closeGroup();
		assertEquals("Removing two elements within same command group was not correctly propagated to target",
				getTargetObjectIdList(moinList), getTargetObjectIdList(target));

		// 8b. RemoveAll
		arrayList = new ArrayList<TargetObject>(2);
		arrayList.add(targetObject6);
		arrayList.add(targetObject7);
		moinList.addAll(arrayList);
		// make sure elements have been added to moin list
		assertTrue("Element has been added to MOIN list", moinList.contains(targetObject6));
		assertTrue("Element has been added to MOIN list", moinList.contains(targetObject7));
		moinList.removeAll(arrayList);
		// make sure elements have been deleted from moin list
		assertFalse("Element must have been removed from MOIN list", moinList.contains(targetObject6));
		assertFalse("Element must have been removed from MOIN list", moinList.contains(targetObject7));
		assertEquals("RemoveAll in model was not correctly propagated to target", getTargetObjectIdList(moinList),
				getTargetObjectIdList(target));

		// 9. RetainAll
		arrayList = new ArrayList<TargetObject>(2);
		arrayList.add(targetObject6);
		arrayList.add(targetObject7);
		moinList.addAll(arrayList);
		// make sure elements have been added to moin list
		assertTrue("Element has been added to MOIN list", moinList.contains(targetObject6));
		assertTrue("Element has been added to MOIN list", moinList.contains(targetObject7));
		moinList.retainAll(arrayList);
		// make sure elements have been deleted from moin list
		assertTrue("Element must not have been removed from MOIN list", moinList.contains(targetObject6));
		assertTrue("Element must not have been removed from MOIN list", moinList.contains(targetObject7));
		assertEquals("RetainAll in model was not correctly propagated to target", getTargetObjectIdList(moinList),
				getTargetObjectIdList(target));

		// 10. Delete contained element
		targetObject6.refDelete();
		assertFalse("Element must have been removed from MOIN list", getTargetObjectIdList(moinList).contains("6"));
		assertEquals("Delete object in model was not correctly propagated to target", getTargetObjectIdList(moinList),
				getTargetObjectIdList(target));

		// 11. Clear
		moinList.clear();
		assertTrue("MOIN list must be empty", moinList.size() == 0);
		assertEquals("List must have 0 entries", getTargetObjectIdList(moinList), getTargetObjectIdList(target));
	}

	/**
	 * Tests around binding multi valued non-composite sorted and unique object
	 * references:
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
		TargetObject targetObject6 = getConnection().createElement(TargetObject.class);
		targetObject6.setId("6");
		TargetObject targetObject7 = getConnection().createElement(TargetObject.class);
		targetObject7.setId("7");

		// Create the test RefObject
		ObjectWithAttributes refObject = createInstanceObjectWithAttributes();
		List<TargetObject> moinList = refObject.getObjectRefMultiBoth();
		moinList.add(targetObject1);
		moinList.add(targetObject2);

		// Establish the binding for the multi valued integer attribute
		IObservableList target = new WritableList(new ArrayList<TargetObject>(), TargetObject.class);
		IObservableList model = MoinObservables.observeList(refObject, ObjectWithAttributes.DESCRIPTORS
				.OBJECT_REF_MULTI_BOTH());
		getDbc().bindList(target, model, null, null);

		// Check initial data flow
		assertEquals("Initial data flow failed", getTargetObjectIdList(moinList), getTargetObjectIdList(target));

		// Check data flow target to model does not happen (MOIN
		// RefObjectObservableList is a unmodifiableList)
		target.add(targetObject0);
		assertEquals("Change in target was propagated to model", 2, model.size());
		target.remove(targetObject0);

		// Check data flow model to target
		// 1. Add at end
		moinList.add(targetObject3);
		assertEquals("Change in model was not propagated to target", getTargetObjectIdList(moinList), getTargetObjectIdList(target));
		// 2. Insert
		moinList.add(1, targetObject4);
		assertEquals("Change in model was not propagated to target", getTargetObjectIdList(moinList), getTargetObjectIdList(target));
		// 3. Remove object
		moinList.remove(targetObject4);
		assertEquals("Remove in model was not propagated to target", getTargetObjectIdList(moinList), getTargetObjectIdList(target));
		// 4. Remove index
		moinList.remove(0);
		assertEquals("Remove in model was not propagated to target", getTargetObjectIdList(moinList), getTargetObjectIdList(target));
		// 5. AddAll
		ArrayList<TargetObject> arrayList = new ArrayList<TargetObject>(2);
		arrayList.add(targetObject4);
		arrayList.add(targetObject5);
		moinList.addAll(arrayList);
		assertEquals("AddAll in model was not propagated to target", getTargetObjectIdList(moinList), getTargetObjectIdList(target));
		// 6. AddAll index
		arrayList = new ArrayList<TargetObject>(2);
		arrayList.add(targetObject0);
		arrayList.add(targetObject1);
		moinList.addAll(0, arrayList);
		assertEquals("AddAll(index) in model was not propagated to target", getTargetObjectIdList(moinList), getTargetObjectIdList(target));
		// 7. Set
		moinList.set(3, targetObject6);
		assertEquals("Set in model was not propagated to target", getTargetObjectIdList(moinList), getTargetObjectIdList(target));
		moinList.set(3, targetObject3);
		assertEquals("Reset in model was not propagated to target", getTargetObjectIdList(moinList), getTargetObjectIdList(target));

		// 8a. RemoveAll - single operations within same command group
		arrayList = new ArrayList<TargetObject>(2);
		arrayList.add(targetObject6);
		arrayList.add(targetObject7);
		moinList.addAll(arrayList);
		// make sure elements have been added to moin list
		assertTrue("Element has been added to MOIN list", moinList.contains(targetObject6));
		assertTrue("Element has been added to MOIN list", moinList.contains(targetObject7));
		getConnection().getCommandStack().openGroup("test");
		moinList.remove(targetObject6);
		moinList.remove(targetObject7);
		// make sure elements have not been deleted from target list
		assertTrue("Element must not have been removed from target list before command group is closed", target.contains(targetObject6));
		assertTrue("Element must not have been removed from target list before command group is closed", target.contains(targetObject7));
		getConnection().getCommandStack().closeGroup();
		assertEquals("Removing two elements within same command group was not correctly propagated to target",
				getTargetObjectIdList(moinList), getTargetObjectIdList(target));

		// 8b. RemoveAll
		arrayList = new ArrayList<TargetObject>(2);
		arrayList.add(targetObject6);
		arrayList.add(targetObject7);
		moinList.addAll(arrayList);
		// make sure elements have been added to moin list
		assertTrue("Element has been added to MOIN list", moinList.contains(targetObject6));
		assertTrue("Element has been added to MOIN list", moinList.contains(targetObject7));
		moinList.removeAll(arrayList);
		// make sure elements have been deleted from moin list
		assertFalse("Element must have been removed from MOIN list", moinList.contains(targetObject6));
		assertFalse("Element must have been removed from MOIN list", moinList.contains(targetObject7));
		assertEquals("RemoveAll in model was not correctly propagated to target", getTargetObjectIdList(moinList),
				getTargetObjectIdList(target));

		// 9. RetainAll
		arrayList = new ArrayList<TargetObject>(2);
		arrayList.add(targetObject6);
		arrayList.add(targetObject7);
		moinList.addAll(arrayList);
		// make sure elements have been added to moin list
		assertTrue("Element has been added to MOIN list", moinList.contains(targetObject6));
		assertTrue("Element has been added to MOIN list", moinList.contains(targetObject7));
		moinList.retainAll(arrayList);
		// make sure elements have been deleted from moin list
		assertTrue("Element must not have been removed from MOIN list", moinList.contains(targetObject6));
		assertTrue("Element must not have been removed from MOIN list", moinList.contains(targetObject7));
		assertEquals("RetainAll in model was not correctly propagated to target", getTargetObjectIdList(moinList),
				getTargetObjectIdList(target));

		// 10. Delete contained element
		targetObject6.refDelete();
		assertFalse("Element must have been removed from MOIN list", getTargetObjectIdList(moinList).contains("6"));
		assertEquals("Delete object in model was not correctly propagated to target", getTargetObjectIdList(moinList),
				getTargetObjectIdList(target));

		// 11. Clear
		moinList.clear();
		assertTrue("MOIN list must be empty", moinList.size() == 0);
		assertEquals("List must have 0 entries", getTargetObjectIdList(moinList), getTargetObjectIdList(target));
	}

	/**
	 * Tests around binding multi valued composite sorted and unique object
	 * references:
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
		TargetObject targetObject6 = getConnection().createElement(TargetObject.class);
		targetObject6.setId("6");
		TargetObject targetObject7 = getConnection().createElement(TargetObject.class);
		targetObject7.setId("7");

		// Create the test RefObject
		ObjectWithAttributes refObject = createInstanceObjectWithAttributes();
		List<TargetObject> moinList = refObject.getObjectRefCompMultiBoth();
		moinList.add(targetObject1);
		moinList.add(targetObject2);

		// Establish the binding for the multi valued integer attribute
		IObservableList target = new WritableList(new ArrayList<TargetObject>(), TargetObject.class);
		IObservableList model = MoinObservables.observeList(refObject, ObjectWithAttributes.DESCRIPTORS
				.OBJECT_REF_COMP_MULTI_BOTH());
		getDbc().bindList(target, model, null, null);

		// Check initial data flow
		assertEquals("Initial data flow failed", getTargetObjectIdList(moinList), getTargetObjectIdList(target));

		// Check data flow target to model does not happen (MOIN
		// RefObjectObservableList is a unmodifiableList)
		target.add(targetObject0);
		assertEquals("Change in target was propagated to model", 2, model.size());
		target.remove(targetObject0);

		// Check data flow model to target
		// 1. Add at end
		moinList.add(targetObject3);
		assertEquals("Change in model was not propagated to target", getTargetObjectIdList(moinList), getTargetObjectIdList(target));
		// 2. Insert
		moinList.add(1, targetObject4);
		assertEquals("Change in model was not propagated to target", getTargetObjectIdList(moinList), getTargetObjectIdList(target));
		// 3. Remove object
		moinList.remove(targetObject4);
		assertEquals("Remove in model was not propagated to target", getTargetObjectIdList(moinList), getTargetObjectIdList(target));
		// 4. Remove index
		moinList.remove(0);
		assertEquals("Remove in model was not propagated to target", getTargetObjectIdList(moinList), getTargetObjectIdList(target));
		// 5. AddAll
		ArrayList<TargetObject> arrayList = new ArrayList<TargetObject>(2);
		arrayList.add(targetObject4);
		arrayList.add(targetObject5);
		moinList.addAll(arrayList);
		assertEquals("AddAll in model was not propagated to target", getTargetObjectIdList(moinList), getTargetObjectIdList(target));
		// 6. AddAll index
		arrayList = new ArrayList<TargetObject>(2);
		arrayList.add(targetObject0);
		arrayList.add(targetObject1);
		moinList.addAll(0, arrayList);
		assertEquals("AddAll(index) in model was not propagated to target", getTargetObjectIdList(moinList), getTargetObjectIdList(target));
		// 7. Set
		moinList.set(3, targetObject6);
		assertEquals("Set in model was not propagated to target", getTargetObjectIdList(moinList), getTargetObjectIdList(target));
		moinList.set(3, targetObject3);
		assertEquals("Reset in model was not propagated to target", getTargetObjectIdList(moinList), getTargetObjectIdList(target));

		// 8a. RemoveAll - single operations within same command group
		arrayList = new ArrayList<TargetObject>(2);
		arrayList.add(targetObject6);
		arrayList.add(targetObject7);
		moinList.addAll(arrayList);
		// make sure elements have been added to moin list
		assertTrue("Element has been added to MOIN list", moinList.contains(targetObject6));
		assertTrue("Element has been added to MOIN list", moinList.contains(targetObject7));
		getConnection().getCommandStack().openGroup("test");
		moinList.remove(targetObject6);
		moinList.remove(targetObject7);
		// make sure elements have not been deleted from target list
		assertTrue("Element must not have been removed from target list before command group is closed", target.contains(targetObject6));
		assertTrue("Element must not have been removed from target list before command group is closed", target.contains(targetObject7));
		getConnection().getCommandStack().closeGroup();
		assertEquals("Removing two elements within same command group was not correctly propagated to target",
				getTargetObjectIdList(moinList), getTargetObjectIdList(target));

		// 8b. RemoveAll
		arrayList = new ArrayList<TargetObject>(2);
		arrayList.add(targetObject6);
		arrayList.add(targetObject7);
		moinList.addAll(arrayList);
		// make sure elements have been added to moin list
		assertTrue("Element has been added to MOIN list", moinList.contains(targetObject6));
		assertTrue("Element has been added to MOIN list", moinList.contains(targetObject7));
		moinList.removeAll(arrayList);
		// make sure elements have been deleted from moin list
		assertFalse("Element must have been removed from MOIN list", moinList.contains(targetObject6));
		assertFalse("Element must have been removed from MOIN list", moinList.contains(targetObject7));
		assertEquals("RemoveAll in model was not correctly propagated to target", getTargetObjectIdList(moinList),
				getTargetObjectIdList(target));

		// 9. RetainAll
		arrayList = new ArrayList<TargetObject>(2);
		arrayList.add(targetObject6);
		arrayList.add(targetObject7);
		moinList.addAll(arrayList);
		// make sure elements have been added to moin list
		assertTrue("Element has been added to MOIN list", moinList.contains(targetObject6));
		assertTrue("Element has been added to MOIN list", moinList.contains(targetObject7));
		moinList.retainAll(arrayList);
		// make sure elements have been deleted from moin list
		assertTrue("Element must not have been removed from MOIN list", moinList.contains(targetObject6));
		assertTrue("Element must not have been removed from MOIN list", moinList.contains(targetObject7));
		assertEquals("RetainAll in model was not correctly propagated to target", getTargetObjectIdList(moinList),
				getTargetObjectIdList(target));

		// 10. Delete contained element
		targetObject6.refDelete();
		assertFalse("Element must have been removed from MOIN list", getTargetObjectIdList(moinList).contains("6"));
		assertEquals("Delete object in model was not correctly propagated to target", getTargetObjectIdList(moinList),
				getTargetObjectIdList(target));

		// 11. Clear
		moinList.clear();
		assertTrue("MOIN list must be empty", moinList.size() == 0);
		assertEquals("List must have 0 entries", getTargetObjectIdList(moinList), getTargetObjectIdList(target));
	}

	/**
	 * Tests that not allowed list bindings do not work:
	 * <ul>
	 * <li>Non-ordered attribute
	 * <li>Non-ordered reference
	 * <li>Single-valued attribute
	 * <li>Single-Valued reference
	 * </ul>
	 */
	public void testNegative() {
		// Try to bind list against non-ordered attribute
		ObjectWithAttributes refObject = createInstanceObjectWithAttributes();
		try {
			MoinObservables.observeList(refObject, ObjectWithAttributes.DESCRIPTORS.STRING_ATTR_MULTI());
			fail("Binding a non-ordered attribute to a list observable must not succeed");
		} catch (IllegalArgumentException e) {
			// Expected
		}

		// Try to bind list against non-ordered reference
		refObject = createInstanceObjectWithAttributes();
		try {
			MoinObservables.observeList(refObject, ObjectWithAttributes.DESCRIPTORS.OBJECT_REF_MULTI_UNIQUE());
			fail("Binding a non-ordered reference to a list observable must not succeed");
		} catch (IllegalArgumentException e) {
			// Expected
		}

		// Try to bind list against single-valued attribute
		refObject = createInstanceObjectWithAttributes();
		try {
			MoinObservables.observeList(refObject, ObjectWithAttributes.DESCRIPTORS.STRING_ATTR());
			fail("Binding a single-valued attribute to a list observable must not succeed");
		} catch (IllegalArgumentException e) {
			// Expected
		}

		// Try to bind list against single-valued reference
		refObject = createInstanceObjectWithAttributes();
		try {
			MoinObservables.observeList(refObject, ObjectWithAttributes.DESCRIPTORS.OBJECT_REF());
			fail("Binding a single-valued reference to a list observable must not succeed");
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
		IObservableList list = MoinObservables.observeList(refObject, ObjectWithAttributes.DESCRIPTORS
				.STRING_ATTR_MULTI_ORDERED());
		String string = list.toString();
		assertNotNull("toString() must not return null", string);
		list.dispose();
	}

	private List<String> getStringList(Collection<?> collection) {
		List<String> strings = new ArrayList<String>(collection.size());
		Iterator<?> it = collection.iterator();
		while (it.hasNext()) {
			Object object = (Object) it.next();
			strings.add(object.toString());
		}
		return strings;
	}

	private List<String> getTargetObjectIdList(List<TargetObject> list) {
		List<String> strings = new ArrayList<String>(list.size());
		for (int i = 0; i < list.size(); i++) {
			TargetObject object = list.get(i);
			strings.add(i, object.getId());
		}
		return strings;
	}

}

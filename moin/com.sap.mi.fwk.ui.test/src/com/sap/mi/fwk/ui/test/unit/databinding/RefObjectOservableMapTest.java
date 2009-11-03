package com.sap.mi.fwk.ui.test.unit.databinding;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.WritableSet;

import com.sap.demo.mi.testmetamodel.databinding.AttributeEnumerationEnum;
import com.sap.demo.mi.testmetamodel.databinding.ObjectWithAttributes;
import com.sap.demo.mi.testmetamodel.databinding.SecondTargetObject;
import com.sap.demo.mi.testmetamodel.databinding.TargetObject;
import com.sap.mi.fwk.ui.databinding.MoinObservables;

public class RefObjectOservableMapTest extends DatabindingTest {

	/**
	 * Tests around binding string attributes of referenced objects:
	 * <ul>
	 * <li>Initial data transfer
	 * <li>Target to Model
	 * <li>Model to Target
	 * <li>toString
	 * <ul>
	 */
	public void testStringAttribute() {
		// Create target object instances
		TargetObject targetObject1 = getConnection().createElement(TargetObject.class);
		targetObject1.setId("1");
		targetObject1.setStringAttr("value1");
		TargetObject targetObject2 = getConnection().createElement(TargetObject.class);
		targetObject2.setId("2");
		targetObject2.setStringAttr("value2");
		TargetObject targetObject3 = getConnection().createElement(TargetObject.class);
		targetObject3.setId("3");
		targetObject3.setStringAttr("value3");

		// Create the test RefObject
		ObjectWithAttributes refObject = createInstanceObjectWithAttributes();
		List<TargetObject> moinList = refObject.getObjectRefMultiBoth();
		moinList.add(targetObject1);
		moinList.add(targetObject2);
		moinList.add(targetObject3);

		// Establish the binding for the multi valued object reference and its
		// string attribute
		IObservableList target = new WritableList(new ArrayList<TargetObject>(), TargetObject.class);
		IObservableList model = MoinObservables.observeList(refObject, ObjectWithAttributes.DESCRIPTORS
				.OBJECT_REF_MULTI_BOTH());
		getDbc().bindList(target, model, null, null);
		IObservableMap map = MoinObservables.observeMap(new WritableSet(model, TargetObject.class), refObject,
				ObjectWithAttributes.DESCRIPTORS.OBJECT_REF_MULTI_BOTH(), TargetObject.DESCRIPTORS.STRING_ATTR());

		// Check initial data flow
		assertEquals("Initial data flow failed", "value1", map.get(targetObject1));
		assertEquals("Initial data flow failed", "value2", map.get(targetObject2));
		assertEquals("Initial data flow failed", "value3", map.get(targetObject3));

		// Check data flow target to model
		map.put(targetObject1, "changedValue1");
		assertEquals("Change in target was not propagated to model", "changedValue1", targetObject1.getStringAttr());

		// Check data flow model to target
		targetObject2.setStringAttr("changedValue2");
		assertEquals("Change in model was not propagated to target", "changedValue2", map.get(targetObject2));

		// toString
		String string = map.toString();
		assertNotNull("toString() must not return null", string);
	}

	/**
	 * Tests around binding integer attributes of referenced objects:
	 * <ul>
	 * <li>Initial data transfer
	 * <li>Target to Model
	 * <li>Model to Target
	 * <ul>
	 */
	public void testIntegerAttribute() {
		// Create target object instances
		TargetObject targetObject1 = getConnection().createElement(TargetObject.class);
		targetObject1.setId("1");
		targetObject1.setIntegerAttr(1);
		TargetObject targetObject2 = getConnection().createElement(TargetObject.class);
		targetObject2.setId("2");
		targetObject2.setIntegerAttr(2);
		TargetObject targetObject3 = getConnection().createElement(TargetObject.class);
		targetObject3.setId("3");
		targetObject3.setIntegerAttr(3);

		// Create the test RefObject
		ObjectWithAttributes refObject = createInstanceObjectWithAttributes();
		List<TargetObject> moinList = refObject.getObjectRefMultiBoth();
		moinList.add(targetObject1);
		moinList.add(targetObject2);
		moinList.add(targetObject3);

		// Establish the binding for the multi valued object reference and its
		// string attribute
		IObservableList target = new WritableList(new ArrayList<TargetObject>(), TargetObject.class);
		IObservableList model = MoinObservables.observeList(refObject, ObjectWithAttributes.DESCRIPTORS
				.OBJECT_REF_MULTI_BOTH());
		getDbc().bindList(target, model, null, null);
		IObservableMap map = MoinObservables.observeMap(new WritableSet(model, TargetObject.class), refObject,
				ObjectWithAttributes.DESCRIPTORS.OBJECT_REF_MULTI_BOTH(), TargetObject.DESCRIPTORS.INTEGER_ATTR());

		// Check initial data flow
		assertEquals("Initial data flow failed", 1, map.get(targetObject1));
		assertEquals("Initial data flow failed", 2, map.get(targetObject2));
		assertEquals("Initial data flow failed", 3, map.get(targetObject3));

		// Check data flow target to model
		map.put(targetObject1, 12);
		assertEquals("Change in target was not propagated to model", 12, targetObject1.getIntegerAttr());

		// Check data flow model to target
		targetObject2.setIntegerAttr(23);
		assertEquals("Change in model was not propagated to target", 23, map.get(targetObject2));
	}

	/**
	 * Tests around binding enumeration type attributes of referenced objects:
	 * <ul>
	 * <li>Initial data transfer
	 * <li>Target to Model
	 * <li>Model to Target
	 * <ul>
	 */
	public void testEnumerationAttribute() {
		// Create target object instances
		TargetObject targetObject1 = getConnection().createElement(TargetObject.class);
		targetObject1.setId("1");
		targetObject1.setEnumerationAttr(AttributeEnumerationEnum.ONE);
		TargetObject targetObject2 = getConnection().createElement(TargetObject.class);
		targetObject2.setId("2");
		targetObject2.setEnumerationAttr(AttributeEnumerationEnum.TWO);
		TargetObject targetObject3 = getConnection().createElement(TargetObject.class);
		targetObject3.setId("3");
		targetObject3.setEnumerationAttr(AttributeEnumerationEnum.THREE);

		// Create the test RefObject
		ObjectWithAttributes refObject = createInstanceObjectWithAttributes();
		List<TargetObject> moinList = refObject.getObjectRefMultiBoth();
		moinList.add(targetObject1);
		moinList.add(targetObject2);
		moinList.add(targetObject3);

		// Establish the binding for the multi valued object reference and its
		// enumeration attribute
		IObservableList target = new WritableList(new ArrayList<TargetObject>(), TargetObject.class);
		IObservableList model = MoinObservables.observeList(refObject, ObjectWithAttributes.DESCRIPTORS
				.OBJECT_REF_MULTI_BOTH());
		getDbc().bindList(target, model, null, null);
		IObservableMap map = MoinObservables.observeMap(new WritableSet(model, TargetObject.class), refObject,
				ObjectWithAttributes.DESCRIPTORS.OBJECT_REF_MULTI_BOTH(), TargetObject.DESCRIPTORS.ENUMERATION_ATTR());

		// Check initial data flow
		assertEquals("Initial data flow failed", AttributeEnumerationEnum.ONE, map.get(targetObject1));
		assertEquals("Initial data flow failed", AttributeEnumerationEnum.TWO, map.get(targetObject2));
		assertEquals("Initial data flow failed", AttributeEnumerationEnum.THREE, map.get(targetObject3));

		// Check data flow target to model
		map.put(targetObject1, AttributeEnumerationEnum.FOUR);
		assertEquals("Change in target was not propagated to model", AttributeEnumerationEnum.FOUR, targetObject1
				.getEnumerationAttr());

		// Check data flow model to target
		targetObject2.setEnumerationAttr(AttributeEnumerationEnum.FIVE);
		assertEquals("Change in model was not propagated to target", AttributeEnumerationEnum.FIVE, map
				.get(targetObject2));
	}

	/**
	 * Tests around binding boolean attributes of referenced objects:
	 * <ul>
	 * <li>Initial data transfer
	 * <li>Target to Model
	 * <li>Model to Target
	 * <ul>
	 */
	public void testBooleanAttribute() {
		// Create target object instances
		TargetObject targetObject1 = getConnection().createElement(TargetObject.class);
		targetObject1.setId("1");
		targetObject1.setBooleanAttr(true);
		TargetObject targetObject2 = getConnection().createElement(TargetObject.class);
		targetObject2.setId("2");
		targetObject2.setBooleanAttr(false);
		TargetObject targetObject3 = getConnection().createElement(TargetObject.class);
		targetObject3.setId("3");
		targetObject3.setBooleanAttr(true);

		// Create the test RefObject
		ObjectWithAttributes refObject = createInstanceObjectWithAttributes();
		List<TargetObject> moinList = refObject.getObjectRefMultiBoth();
		moinList.add(targetObject1);
		moinList.add(targetObject2);
		moinList.add(targetObject3);

		// Establish the binding for the multi valued object reference and its
		// boolean attribute
		IObservableList target = new WritableList(new ArrayList<TargetObject>(), TargetObject.class);
		IObservableList model = MoinObservables.observeList(refObject, ObjectWithAttributes.DESCRIPTORS
				.OBJECT_REF_MULTI_BOTH());
		getDbc().bindList(target, model, null, null);
		IObservableMap map = MoinObservables.observeMap(new WritableSet(model, TargetObject.class), refObject,
				ObjectWithAttributes.DESCRIPTORS.OBJECT_REF_MULTI_BOTH(), TargetObject.DESCRIPTORS.BOOLEAN_ATTR());

		// Check initial data flow
		assertEquals("Initial data flow failed", true, map.get(targetObject1));
		assertEquals("Initial data flow failed", false, map.get(targetObject2));
		assertEquals("Initial data flow failed", true, map.get(targetObject3));

		// Check data flow target to model
		map.put(targetObject1, false);
		assertEquals("Change in target was not propagated to model", false, targetObject1.isBooleanAttr());

		// Check data flow model to target
		targetObject2.setBooleanAttr(true);
		assertEquals("Change in model was not propagated to target", true, map.get(targetObject2));
	}

	/**
	 * Tests around binding double attributes of referenced objects:
	 * <ul>
	 * <li>Initial data transfer
	 * <li>Target to Model
	 * <li>Model to Target
	 * <ul>
	 */
	public void testDoubleAttribute() {
		// Create target object instances
		TargetObject targetObject1 = getConnection().createElement(TargetObject.class);
		targetObject1.setId("1");
		targetObject1.setDoubleAttr(1.2);
		TargetObject targetObject2 = getConnection().createElement(TargetObject.class);
		targetObject2.setId("2");
		targetObject2.setDoubleAttr(2.3);
		TargetObject targetObject3 = getConnection().createElement(TargetObject.class);
		targetObject3.setId("3");
		targetObject3.setDoubleAttr(3.4);

		// Create the test RefObject
		ObjectWithAttributes refObject = createInstanceObjectWithAttributes();
		List<TargetObject> moinList = refObject.getObjectRefMultiBoth();
		moinList.add(targetObject1);
		moinList.add(targetObject2);
		moinList.add(targetObject3);

		// Establish the binding for the multi valued object reference and its
		// double attribute
		IObservableList target = new WritableList(new ArrayList<TargetObject>(), TargetObject.class);
		IObservableList model = MoinObservables.observeList(refObject, ObjectWithAttributes.DESCRIPTORS
				.OBJECT_REF_MULTI_BOTH());
		getDbc().bindList(target, model, null, null);
		IObservableMap map = MoinObservables.observeMap(new WritableSet(model, TargetObject.class), refObject,
				ObjectWithAttributes.DESCRIPTORS.OBJECT_REF_MULTI_BOTH(), TargetObject.DESCRIPTORS.DOUBLE_ATTR());

		// Check initial data flow
		assertEquals("Initial data flow failed", 1.2, map.get(targetObject1));
		assertEquals("Initial data flow failed", 2.3, map.get(targetObject2));
		assertEquals("Initial data flow failed", 3.4, map.get(targetObject3));

		// Check data flow target to model
		map.put(targetObject1, 4.5);
		assertEquals("Change in target was not propagated to model", 4.5, targetObject1.getDoubleAttr());

		// Check data flow model to target
		targetObject2.setDoubleAttr(5.6);
		assertEquals("Change in model was not propagated to target", 5.6, map.get(targetObject2));
	}

	/**
	 * Tests around binding float attributes of referenced objects:
	 * <ul>
	 * <li>Initial data transfer
	 * <li>Target to Model
	 * <li>Model to Target
	 * <ul>
	 */
	public void testFloatAttribute() {
		// Create target object instances
		TargetObject targetObject1 = getConnection().createElement(TargetObject.class);
		targetObject1.setId("1");
		targetObject1.setFloatAttr(1.2f);
		TargetObject targetObject2 = getConnection().createElement(TargetObject.class);
		targetObject2.setId("2");
		targetObject2.setFloatAttr(2.3f);
		TargetObject targetObject3 = getConnection().createElement(TargetObject.class);
		targetObject3.setId("3");
		targetObject3.setFloatAttr(3.4f);

		// Create the test RefObject
		ObjectWithAttributes refObject = createInstanceObjectWithAttributes();
		List<TargetObject> moinList = refObject.getObjectRefMultiBoth();
		moinList.add(targetObject1);
		moinList.add(targetObject2);
		moinList.add(targetObject3);

		// Establish the binding for the multi valued object reference and its
		// float attribute
		IObservableList target = new WritableList(new ArrayList<TargetObject>(), TargetObject.class);
		IObservableList model = MoinObservables.observeList(refObject, ObjectWithAttributes.DESCRIPTORS
				.OBJECT_REF_MULTI_BOTH());
		getDbc().bindList(target, model, null, null);
		IObservableMap map = MoinObservables.observeMap(new WritableSet(model, TargetObject.class), refObject,
				ObjectWithAttributes.DESCRIPTORS.OBJECT_REF_MULTI_BOTH(), TargetObject.DESCRIPTORS.FLOAT_ATTR());

		// Check initial data flow
		assertEquals("Initial data flow failed", 1.2f, map.get(targetObject1));
		assertEquals("Initial data flow failed", 2.3f, map.get(targetObject2));
		assertEquals("Initial data flow failed", 3.4f, map.get(targetObject3));

		// Check data flow target to model
		map.put(targetObject1, 4.5f);
		assertEquals("Change in target was not propagated to model", 4.5f, targetObject1.getFloatAttr());

		// Check data flow model to target
		targetObject2.setFloatAttr(5.6f);
		assertEquals("Change in model was not propagated to target", 5.6f, map.get(targetObject2));
	}

	/**
	 * Tests around binding long attributes of referenced objects:
	 * <ul>
	 * <li>Initial data transfer
	 * <li>Target to Model
	 * <li>Model to Target
	 * <ul>
	 */
	public void testLongAttribute() {
		// Create target object instances
		TargetObject targetObject1 = getConnection().createElement(TargetObject.class);
		targetObject1.setId("1");
		targetObject1.setLongAttr(1l);
		TargetObject targetObject2 = getConnection().createElement(TargetObject.class);
		targetObject2.setId("2");
		targetObject2.setLongAttr(2l);
		TargetObject targetObject3 = getConnection().createElement(TargetObject.class);
		targetObject3.setId("3");
		targetObject3.setLongAttr(3l);

		// Create the test RefObject
		ObjectWithAttributes refObject = createInstanceObjectWithAttributes();
		List<TargetObject> moinList = refObject.getObjectRefMultiBoth();
		moinList.add(targetObject1);
		moinList.add(targetObject2);
		moinList.add(targetObject3);

		// Establish the binding for the multi valued object reference and its
		// float attribute
		IObservableList target = new WritableList(new ArrayList<TargetObject>(), TargetObject.class);
		IObservableList model = MoinObservables.observeList(refObject, ObjectWithAttributes.DESCRIPTORS
				.OBJECT_REF_MULTI_BOTH());
		getDbc().bindList(target, model, null, null);
		IObservableMap map = MoinObservables.observeMap(new WritableSet(model, TargetObject.class), refObject,
				ObjectWithAttributes.DESCRIPTORS.OBJECT_REF_MULTI_BOTH(), TargetObject.DESCRIPTORS.LONG_ATTR());

		// Check initial data flow
		assertEquals("Initial data flow failed", 1l, map.get(targetObject1));
		assertEquals("Initial data flow failed", 2l, map.get(targetObject2));
		assertEquals("Initial data flow failed", 3l, map.get(targetObject3));

		// Check data flow target to model
		map.put(targetObject1, 4l);
		assertEquals("Change in target was not propagated to model", 4l, targetObject1.getLongAttr());

		// Check data flow model to target
		targetObject2.setLongAttr(5l);
		assertEquals("Change in model was not propagated to target", 5l, map.get(targetObject2));
	}

	/**
	 * Tests around binding object attributes of referenced objects:
	 * <ul>
	 * <li>Initial data transfer
	 * <li>Target to Model
	 * <li>Model to Target
	 * <ul>
	 */
	public void testObjectAttribute() {
		// Create second target object instances
		SecondTargetObject secondTargetObject1 = getConnection().createElement(SecondTargetObject.class);
		secondTargetObject1.setId("1");
		SecondTargetObject secondTargetObject2 = getConnection().createElement(SecondTargetObject.class);
		secondTargetObject2.setId("2");
		SecondTargetObject secondTargetObject3 = getConnection().createElement(SecondTargetObject.class);
		secondTargetObject3.setId("3");
		SecondTargetObject secondTargetObject4 = getConnection().createElement(SecondTargetObject.class);
		secondTargetObject4.setId("4");
		SecondTargetObject secondTargetObject5 = getConnection().createElement(SecondTargetObject.class);
		secondTargetObject5.setId("5");

		// Create target object instances
		TargetObject targetObject1 = getConnection().createElement(TargetObject.class);
		targetObject1.setId("1");
		targetObject1.setObjectAttr(secondTargetObject1);
		TargetObject targetObject2 = getConnection().createElement(TargetObject.class);
		targetObject2.setId("2");
		targetObject2.setObjectAttr(secondTargetObject2);
		TargetObject targetObject3 = getConnection().createElement(TargetObject.class);
		targetObject3.setId("3");
		targetObject3.setObjectAttr(secondTargetObject3);

		// Create the test RefObject
		ObjectWithAttributes refObject = createInstanceObjectWithAttributes();
		List<TargetObject> moinList = refObject.getObjectRefMultiBoth();
		moinList.add(targetObject1);
		moinList.add(targetObject2);
		moinList.add(targetObject3);

		// Establish the binding for the multi valued object reference and its
		// float attribute
		IObservableList target = new WritableList(new ArrayList<TargetObject>(), TargetObject.class);
		IObservableList model = MoinObservables.observeList(refObject, ObjectWithAttributes.DESCRIPTORS
				.OBJECT_REF_MULTI_BOTH());
		getDbc().bindList(target, model, null, null);
		IObservableMap map = MoinObservables.observeMap(new WritableSet(model, TargetObject.class), refObject,
				ObjectWithAttributes.DESCRIPTORS.OBJECT_REF_MULTI_BOTH(), TargetObject.DESCRIPTORS.OBJECT_ATTR());

		// Check initial data flow
		assertEquals("Initial data flow failed", secondTargetObject1, map.get(targetObject1));
		assertEquals("Initial data flow failed", secondTargetObject2, map.get(targetObject2));
		assertEquals("Initial data flow failed", secondTargetObject3, map.get(targetObject3));

		// Check data flow target to model
		map.put(targetObject1, secondTargetObject4);
		assertEquals("Change in target was not propagated to model", secondTargetObject4, targetObject1.getObjectAttr());

		// Check data flow model to target
		targetObject2.setObjectAttr(secondTargetObject5);
		assertEquals("Change in model was not propagated to target", secondTargetObject5, map.get(targetObject2));

		// Delete referenced object
		secondTargetObject5.refDelete();
		assertEquals("Change in model was not propagated to target", null, map.get(targetObject2));
	}
}

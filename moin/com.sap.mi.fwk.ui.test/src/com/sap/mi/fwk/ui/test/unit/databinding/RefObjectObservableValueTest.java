package com.sap.mi.fwk.ui.test.unit.databinding;

import java.text.NumberFormat;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.databinding.AggregateValidationStatus;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.runtime.IStatus;

import com.sap.demo.mi.testmetamodel.databinding.AttributeEnumerationEnum;
import com.sap.demo.mi.testmetamodel.databinding.ObjectWithAttributes;
import com.sap.demo.mi.testmetamodel.databinding.TargetObject;
import com.sap.mi.fwk.ui.databinding.MoinObservables;
import com.sap.mi.fwk.ui.internal.databinding.observables.AbstractRefObjectObservableValue;
import com.sap.mi.fwk.ui.internal.databinding.observables.RefObjectObservableValue;

/**
 * Tests around MOIN {@link RefObjectObservableValue RefObjectObservableValues}.
 * 
 * @author d027044
 * 
 */
public class RefObjectObservableValueTest extends DatabindingTest {

	/**
	 * Tests around binding single valued string attributes:
	 * <ul>
	 * <li>Initial data transfer
	 * <li>Target to Model
	 * <li>Model to Target
	 * <ul>
	 */
	public void testStringAttribute() {
		// Create the test RefObject
		ObjectWithAttributes refObject = createInstanceObjectWithAttributes();
		refObject.setStringAttr("value");

		// Establish the binding for the single valued string attribute
		IObservableValue target = new WritableValue(null, String.class);
		IObservableValue model = MoinObservables
				.observeValue(refObject, ObjectWithAttributes.DESCRIPTORS.STRING_ATTR());
		getDbc().bindValue(target, model, null, null);

		// Check initial data flow
		assertEquals("Initial value was not transfered", "value", target.getValue());

		// Check data flow target to model
		target.setValue("changedValue");
		assertEquals("Change in target was not propagated to model", "changedValue", refObject.getStringAttr());

		// Check data flow model to target
		refObject.setStringAttr("changedValueAgain");
		assertEquals("Change in model was not propagated to target", "changedValueAgain", target.getValue());
	}

	/**
	 * Tests setting <code>null</code> as value for an attribute on a
	 * {@link RefObject} that already has the value <code>null</null>. 
	 * In this case the UpdateListener in the previous version of
	 * {@link AbstractRefObjectObservableValue} caused a {@link NullPointerException}.
	 */
	public void testIsNullAndSetNull() {
		// Create the test RefObject
		ObjectWithAttributes refObject = createInstanceObjectWithAttributes();
		refObject.setStringAttr(null);

		// Establish the binding for the single valued string attribute
		IObservableValue target = new WritableValue(null, String.class);
		IObservableValue model = MoinObservables
				.observeValue(refObject, ObjectWithAttributes.DESCRIPTORS.STRING_ATTR());
		getDbc().bindValue(target, model, null, null);

		// Check initial data flow
		assertEquals("Initial value was not transfered", null, target.getValue());

		// Test setting null again (CSN 1147141 2009 - caused NPE in the
		// UpdateListener in the AbstractRefObjectObservableValue)
		refObject.setStringAttr(null);
		assertEquals("Change in target was not propagated to model", null, target.getValue());
	}

	/**
	 * Tests around binding single valued integer attributes:
	 * <ul>
	 * <li>Initial data transfer
	 * <li>Target to Model
	 * <li>Model to Target
	 * <li>Above including standard conversion
	 * <li>Error handling in conversion from string to integer
	 * <ul>
	 */
	public void testIntegerAttribute() {
		// Create the test RefObject
		ObjectWithAttributes refObject = createInstanceObjectWithAttributes();
		refObject.setIntegerAttr(1);

		// Establish the binding for the single valued integer attribute
		IObservableValue target = new WritableValue(null, String.class);
		IObservableValue model = MoinObservables.observeValue(refObject, ObjectWithAttributes.DESCRIPTORS
				.INTEGER_ATTR());
		getDbc().bindValue(target, model, null, null);

		// Check initial data flow
		assertEquals("Initial value was not transfered", "1", target.getValue());

		// Check data flow target to model and conversion from string to integer
		target.setValue("2");
		assertEquals("Change in target was not propagated to model", 2, refObject.getIntegerAttr());

		// Check data flow model to target and conversion from integer to string
		refObject.setIntegerAttr(3);
		assertEquals("Change in model was not propagated to target", "3", target.getValue());

		// Test conversion failure from string to integer
		final boolean[] errorReported = new boolean[1];
		errorReported[0] = false;
		AggregateValidationStatus aggregateValidationStatus = new AggregateValidationStatus(getDbc()
				.getValidationStatusProviders(), AggregateValidationStatus.MAX_SEVERITY);
		aggregateValidationStatus.addValueChangeListener(new IValueChangeListener() {
			public void handleValueChange(ValueChangeEvent event) {
				IStatus status = (IStatus) event.diff.getNewValue();
				if (status != null && IStatus.ERROR == status.getSeverity()) {
					errorReported[0] = true;
				}
			}
		});
		target.setValue("a");
		assertEquals("Invalid change in target was propagated to model", 3, refObject.getIntegerAttr());
		assertTrue("No error was reported", errorReported[0]);
	}

	/**
	 * Tests around binding single valued enumeration type attributes:
	 * <ul>
	 * <li>Initial data transfer
	 * <li>Target to Model
	 * <li>Model to Target
	 * <li>Above including standard conversion
	 * <li>Error handling in conversion from string to integer
	 * <ul>
	 */
	public void testEnumerationAttribute() {
		// Create the test RefObject
		ObjectWithAttributes refObject = createInstanceObjectWithAttributes();
		refObject.setEnumerationAttr(AttributeEnumerationEnum.ZERO);

		// Establish the binding for the single valued enumeration attribute
		IObservableValue target = new WritableValue(null, String.class);
		IObservableValue model = MoinObservables.observeValue(refObject, ObjectWithAttributes.DESCRIPTORS
				.ENUMERATION_ATTR());
		getDbc().bindValue(target, model, null, null);

		// Check initial data flow
		assertEquals("Initial value was not transfered", "zero", target.getValue());

		// Test conversion from string to enumeration type
		target.setValue("one");
		assertEquals("Change in target was not propagated to model", AttributeEnumerationEnum.ONE, model.getValue());

		// Check data flow model to target and conversion from enumeration type
		// to string
		refObject.setEnumerationAttr(AttributeEnumerationEnum.ONE);
		assertEquals("Change in model was not propagated to target", "one", target.getValue());

		// Test conversion failure from string to integer
		final boolean[] errorReported = new boolean[1];
		errorReported[0] = false;
		AggregateValidationStatus aggregateValidationStatus = new AggregateValidationStatus(getDbc()
				.getValidationStatusProviders(), AggregateValidationStatus.MAX_SEVERITY);
		aggregateValidationStatus.addValueChangeListener(new IValueChangeListener() {
			public void handleValueChange(ValueChangeEvent event) {
				IStatus status = (IStatus) event.diff.getNewValue();
				if (status != null && IStatus.ERROR == status.getSeverity()) {
					errorReported[0] = true;
				}
			}
		});
		target.setValue("a");
		assertEquals("Invalid change in target was propagated to model", AttributeEnumerationEnum.ONE, refObject
				.getEnumerationAttr());
		assertTrue("No error was reported", errorReported[0]);
	}

	public void testUnmodifyableObservableEnumerationList() {
		// Create the test RefObject
		ObjectWithAttributes refObject = createInstanceObjectWithAttributes();
		refObject.setEnumerationAttr(AttributeEnumerationEnum.ZERO);

		// Establish the binding for the enumeration type attribute
		IObservableList list = MoinObservables.unmodifiableObservableEnumerationList(refObject,
				ObjectWithAttributes.DESCRIPTORS.ENUMERATION_ATTR());

		// Checks
		assertEquals("Enumeration list must have 8 entries", 8, list.size());
		assertEquals("First enumeration list entry wrong", AttributeEnumerationEnum.ZERO, list.get(0));
		assertEquals("Second enumeration list entry wrong", AttributeEnumerationEnum.ONE, list.get(1));
		assertEquals("Third enumeration list entry wrong", AttributeEnumerationEnum.TWO, list.get(2));
		assertEquals("Fourth enumeration list entry wrong", AttributeEnumerationEnum.THREE, list.get(3));
		assertEquals("Fifth enumeration list entry wrong", AttributeEnumerationEnum.FOUR, list.get(4));
		assertEquals("Sixth enumeration list entry wrong", AttributeEnumerationEnum.FIVE, list.get(5));
		assertEquals("Seventh enumeration list entry wrong", AttributeEnumerationEnum.SIX, list.get(6));
		assertEquals("Eigth enumeration list entry wrong", AttributeEnumerationEnum.SEVEN, list.get(7));

		// Establish the binding for a non enumeration type attribute and expect
		// error
		try {
			MoinObservables.unmodifiableObservableEnumerationList(refObject, ObjectWithAttributes.DESCRIPTORS
					.INTEGER_ATTR());
			fail("Exception expected: tried to bind enumeration list to non enumeration type attribute");
		} catch (IllegalArgumentException e) {
			// Ok
		}

	}

	/**
	 * Tests around binding single valued boolean attributes:
	 * <ul>
	 * <li>Initial data transfer
	 * <li>Target to Model
	 * <li>Model to Target
	 * <li>Above including standard conversion
	 * <li>Error handling in conversion from string to boolean
	 * <ul>
	 */
	public void testBooleanAttribute() {
		// Create the test RefObject
		ObjectWithAttributes refObject = createInstanceObjectWithAttributes();
		refObject.setBooleanAttr(false);

		// Establish the binding for the single valued boolean attribute
		IObservableValue target = new WritableValue(null, String.class);
		IObservableValue model = MoinObservables.observeValue(refObject, ObjectWithAttributes.DESCRIPTORS
				.BOOLEAN_ATTR());
		getDbc().bindValue(target, model, null, null);

		// Check initial data flow
		assertEquals("Initial value was not transfered", "false", target.getValue());

		// Check data flow target to model and conversion from string to boolean
		target.setValue("true");
		assertEquals("Change in target was not propagated to model", true, refObject.isBooleanAttr());

		// Check data flow model to target and conversion from boolean to string
		refObject.setBooleanAttr(false);
		assertEquals("Change in model was not propagated to target", "false", target.getValue());

		// Test conversion failure from string to boolean
		final boolean[] errorReported = new boolean[1];
		errorReported[0] = false;
		AggregateValidationStatus aggregateValidationStatus = new AggregateValidationStatus(getDbc()
				.getValidationStatusProviders(), AggregateValidationStatus.MAX_SEVERITY);
		aggregateValidationStatus.addValueChangeListener(new IValueChangeListener() {
			public void handleValueChange(ValueChangeEvent event) {
				IStatus status = (IStatus) event.diff.getNewValue();
				if (status != null && IStatus.ERROR == status.getSeverity()) {
					errorReported[0] = true;
				}
			}
		});
		target.setValue("a");
		assertEquals("Invalid change in target was propagated to model", false, refObject.isBooleanAttr());
		assertTrue("No error was reported", errorReported[0]);
	}

	/**
	 * Tests around binding single valued double attributes:
	 * <ul>
	 * <li>Initial data transfer
	 * <li>Target to Model
	 * <li>Model to Target
	 * <li>Above including standard conversion
	 * <li>Error handling in conversion from string to double
	 * <ul>
	 */
	public void testDoubleAttribute() {
		// Create the test RefObject
		ObjectWithAttributes refObject = createInstanceObjectWithAttributes();
		refObject.setDoubleAttr(1.2);

		// Establish the binding for the single valued double attribute
		IObservableValue target = new WritableValue(null, String.class);
		IObservableValue model = MoinObservables
				.observeValue(refObject, ObjectWithAttributes.DESCRIPTORS.DOUBLE_ATTR());
		getDbc().bindValue(target, model, null, null);

		// Check initial data flow
		assertEquals("Initial value was not transfered", NumberFormat.getInstance().format(1.2), target.getValue());

		// Check data flow target to model and conversion from string to double
		target.setValue(NumberFormat.getInstance().format(2.3));
		assertEquals("Change in target was not propagated to model", 2.3, refObject.getDoubleAttr());

		// Check data flow model to target and conversion from double to string
		refObject.setDoubleAttr(3.4);
		assertEquals("Change in model was not propagated to target", NumberFormat.getInstance().format(3.4), target
				.getValue());

		// Test conversion failure from string to integer
		final boolean[] errorReported = new boolean[1];
		errorReported[0] = false;
		AggregateValidationStatus aggregateValidationStatus = new AggregateValidationStatus(getDbc()
				.getValidationStatusProviders(), AggregateValidationStatus.MAX_SEVERITY);
		aggregateValidationStatus.addValueChangeListener(new IValueChangeListener() {
			public void handleValueChange(ValueChangeEvent event) {
				IStatus status = (IStatus) event.diff.getNewValue();
				if (status != null && IStatus.ERROR == status.getSeverity()) {
					errorReported[0] = true;
				}
			}
		});
		target.setValue("a");
		assertEquals("Invalid change in target was propagated to model", 3.4, refObject.getDoubleAttr());
		assertTrue("No error was reported", errorReported[0]);
	}

	/**
	 * Tests around binding single valued float attributes:
	 * <ul>
	 * <li>Initial data transfer
	 * <li>Target to Model
	 * <li>Model to Target
	 * <li>Above including standard conversion
	 * <li>Error handling in conversion from string to float
	 * <ul>
	 */
	public void testFloatAttribute() {
		// Create the test RefObject
		ObjectWithAttributes refObject = createInstanceObjectWithAttributes();
		refObject.setFloatAttr(1.2f);

		// Establish the binding for the single valued float attribute
		IObservableValue target = new WritableValue(null, String.class);
		IObservableValue model = MoinObservables.observeValue(refObject, ObjectWithAttributes.DESCRIPTORS.FLOAT_ATTR());
		getDbc().bindValue(target, model, null, null);

		// Check initial data flow
		assertEquals("Initial value was not transfered", NumberFormat.getInstance().format(1.2f), target.getValue());

		// Check data flow target to model and conversion from string to float
		target.setValue(NumberFormat.getInstance().format(2.3));
		assertEquals("Change in target was not propagated to model", 2.3f, refObject.getFloatAttr());

		// Check data flow model to target and conversion from float to string
		refObject.setFloatAttr(3.4f);
		assertEquals("Change in model was not propagated to target", NumberFormat.getInstance().format(3.4f), target
				.getValue());

		// Test conversion failure from string to float
		final boolean[] errorReported = new boolean[1];
		errorReported[0] = false;
		AggregateValidationStatus aggregateValidationStatus = new AggregateValidationStatus(getDbc()
				.getValidationStatusProviders(), AggregateValidationStatus.MAX_SEVERITY);
		aggregateValidationStatus.addValueChangeListener(new IValueChangeListener() {
			public void handleValueChange(ValueChangeEvent event) {
				IStatus status = (IStatus) event.diff.getNewValue();
				if (status != null && IStatus.ERROR == status.getSeverity()) {
					errorReported[0] = true;
				}
			}
		});
		target.setValue("a");
		assertEquals("Invalid change in target was propagated to model", 3.4f, refObject.getFloatAttr());
		assertTrue("No error was reported", errorReported[0]);
	}

	/**
	 * Tests around binding single valued long attributes:
	 * <ul>
	 * <li>Initial data transfer
	 * <li>Target to Model
	 * <li>Model to Target
	 * <li>Above including standard conversion
	 * <li>Error handling in conversion from string to long
	 * <ul>
	 */
	public void testLongAttribute() {
		// Create the test RefObject
		ObjectWithAttributes refObject = createInstanceObjectWithAttributes();
		refObject.setLongAttr(1l);

		// Establish the binding for the single valued long attribute
		IObservableValue target = new WritableValue(null, String.class);
		IObservableValue model = MoinObservables.observeValue(refObject, ObjectWithAttributes.DESCRIPTORS.LONG_ATTR());
		getDbc().bindValue(target, model, null, null);

		// Check initial data flow
		assertEquals("Initial value was not transfered", "1", target.getValue());

		// Check data flow target to model and conversion from string to long
		target.setValue("2");
		assertEquals("Change in target was not propagated to model", 2l, refObject.getLongAttr());

		// Check data flow model to target and conversion from integer to string
		refObject.setLongAttr(3);
		assertEquals("Change in model was not propagated to target", "3", target.getValue());

		// Test conversion failure from string to integer
		final boolean[] errorReported = new boolean[1];
		errorReported[0] = false;
		AggregateValidationStatus aggregateValidationStatus = new AggregateValidationStatus(getDbc()
				.getValidationStatusProviders(), AggregateValidationStatus.MAX_SEVERITY);
		aggregateValidationStatus.addValueChangeListener(new IValueChangeListener() {
			public void handleValueChange(ValueChangeEvent event) {
				IStatus status = (IStatus) event.diff.getNewValue();
				if (status != null && IStatus.ERROR == status.getSeverity()) {
					errorReported[0] = true;
				}
			}
		});
		target.setValue("a");
		assertEquals("Invalid change in target was propagated to model", 3, refObject.getLongAttr());
		assertTrue("No error was reported", errorReported[0]);
	}

	/**
	 * Tests around binding single valued object attributes:
	 * <ul>
	 * <li>Initial data transfer
	 * <li>Target to Model
	 * <li>Model to Target
	 * <ul>
	 */
	public void testObjectAttribute() {
		// Create the test RefObject and target objects
		ObjectWithAttributes refObject = createInstanceObjectWithAttributes();
		TargetObject targetObject1 = getConnection().createElement(TargetObject.class);
		targetObject1.setId("1");
		TargetObject targetObject2 = getConnection().createElement(TargetObject.class);
		targetObject2.setId("2");
		TargetObject targetObject3 = getConnection().createElement(TargetObject.class);
		targetObject3.setId("3");
		refObject.setObjectAttr(targetObject1);

		// Establish the binding for the single valued string attribute
		IObservableValue target = new WritableValue(null, TargetObject.class);
		IObservableValue model = MoinObservables
				.observeValue(refObject, ObjectWithAttributes.DESCRIPTORS.OBJECT_ATTR());
		getDbc().bindValue(target, model, null, null);

		// Check initial data flow
		assertEquals("Initial value was not transfered", targetObject1, target.getValue());

		// Check data flow target to model
		target.setValue(targetObject2);
		assertEquals("Change in target was not propagated to model", targetObject2, refObject.getObjectAttr());

		// Set target to null
		target.setValue(null);
		assertEquals("Change in target to null was not propagated to model", null, refObject.getObjectAttr());

		// Check data flow model to target
		refObject.setObjectAttr(targetObject3);
		assertEquals("Change in model was not propagated to target", targetObject3, target.getValue());

		// Set model to null
		refObject.setObjectAttr(null);
		assertEquals("Change in model to null was not propagated to target", null, target.getValue());

		// Check deletion of target object
		refObject.setObjectAttr(targetObject3);
		assertEquals("Change in model was not propagated to target", targetObject3, target.getValue());
		targetObject3.refDelete();
		assertEquals("Deletion of target object in model was not propagated to target", null, target.getValue());
	}

	/**
	 * Tests around binding single valued non-composite object refences:
	 * <ul>
	 * <li>Initial data transfer
	 * <li>Target to Model
	 * <li>Model to Target
	 * <ul>
	 */
	public void testObjectReference() {
		// Create the test RefObject and target objects
		ObjectWithAttributes refObject = createInstanceObjectWithAttributes();
		TargetObject targetObject1 = getConnection().createElement(TargetObject.class);
		targetObject1.setId("1");
		TargetObject targetObject2 = getConnection().createElement(TargetObject.class);
		targetObject2.setId("2");
		TargetObject targetObject3 = getConnection().createElement(TargetObject.class);
		targetObject3.setId("3");
		refObject.setObjectRef(targetObject1);

		// Establish the binding for the single valued string reference
		IObservableValue target = new WritableValue(null, TargetObject.class);
		IObservableValue model = MoinObservables.observeValue(refObject, ObjectWithAttributes.DESCRIPTORS.OBJECT_REF());
		getDbc().bindValue(target, model, null, null);

		// Check initial data flow
		assertEquals("Initial value was not transfered", targetObject1, target.getValue());

		// Check data flow target to model
		target.setValue(targetObject2);
		assertEquals("Change in target was not propagated to model", targetObject2, refObject.getObjectRef());

		// Set target to null
		target.setValue(null);
		assertEquals("Change in target to null was not propagated to model", null, refObject.getObjectRef());

		// Check data flow model to target
		refObject.setObjectRef(targetObject3);
		assertEquals("Change in model was not propagated to target", targetObject3, target.getValue());

		// Set model to null
		refObject.setObjectRef(null);
		assertEquals("Change in model to null was not propagated to target", null, target.getValue());

		// Check deletion of target object
		refObject.setObjectRef(targetObject3);
		assertEquals("Change in model was not propagated to target", targetObject3, target.getValue());
		targetObject3.refDelete();
		assertEquals("Deletion of target object in model was not propagated to target", null, target.getValue());
	}

	/**
	 * Tests around binding single valued composite object refences:
	 * <ul>
	 * <li>Initial data transfer
	 * <li>Target to Model
	 * <li>Model to Target
	 * <ul>
	 */
	public void testObjectReferenceComposite() {
		// Create the test RefObject and target objects
		ObjectWithAttributes refObject = createInstanceObjectWithAttributes();
		TargetObject targetObject1 = getConnection().createElement(TargetObject.class);
		targetObject1.setId("1");
		TargetObject targetObject2 = getConnection().createElement(TargetObject.class);
		targetObject2.setId("2");
		TargetObject targetObject3 = getConnection().createElement(TargetObject.class);
		targetObject3.setId("3");
		refObject.setObjectRefComp(targetObject1);

		// Establish the binding for the single valued string reference
		IObservableValue target = new WritableValue(null, TargetObject.class);
		IObservableValue model = MoinObservables.observeValue(refObject, ObjectWithAttributes.DESCRIPTORS
				.OBJECT_REF_COMP());
		getDbc().bindValue(target, model, null, null);

		// Check initial data flow
		assertEquals("Initial value was not transfered", targetObject1, target.getValue());

		// Check data flow target to model
		target.setValue(targetObject2);
		assertEquals("Change in target was not propagated to model", targetObject2, refObject.getObjectRefComp());

		// Set target to null
		target.setValue(null);
		assertEquals("Change in target to null was not propagated to model", null, refObject.getObjectRefComp());

		// Check data flow model to target
		refObject.setObjectRefComp(targetObject3);
		assertEquals("Change in model was not propagated to target", targetObject3, target.getValue());

		// Set model to null
		refObject.setObjectRefComp(null);
		assertEquals("Change in model to null was not propagated to target", null, target.getValue());

		// Check deletion of target object
		refObject.setObjectRefComp(targetObject3);
		assertEquals("Change in model was not propagated to target", targetObject3, target.getValue());
		targetObject3.refDelete();
		assertEquals("Deletion of target object in model was not propagated to target", null, target.getValue());
	}

	/**
	 * Further tests:
	 * <ul>
	 * <li>toString()
	 * </ul>
	 */
	public void testMisc() {
		ObjectWithAttributes refObject = createInstanceObjectWithAttributes();
		IObservableValue value = MoinObservables
				.observeValue(refObject, ObjectWithAttributes.DESCRIPTORS.STRING_ATTR());
		String string = value.toString();
		assertNotNull("toString() must not return null", string);

	}
}

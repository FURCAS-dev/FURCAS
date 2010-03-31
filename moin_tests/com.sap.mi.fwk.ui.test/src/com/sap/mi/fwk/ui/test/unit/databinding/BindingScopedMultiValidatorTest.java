package com.sap.mi.fwk.ui.test.unit.databinding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.databinding.AggregateValidationStatus;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.set.WritableSet;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.databinding.util.Policy;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;

import com.sap.demo.mi.testmetamodel.databinding.ObjectWithAttributes;
import com.sap.demo.mi.testmetamodel.databinding.TargetObject;
import com.sap.mi.fwk.ui.databinding.MoinObservables;
import com.sap.mi.fwk.ui.databinding.validation.BindingScopedMultiValidator;

public class BindingScopedMultiValidatorTest extends DatabindingTest {
	public void testValidator() {
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

		// Create the test RefObject
		ObjectWithAttributes refObject = createInstanceObjectWithAttributes();
		refObject.setStringAttr("value");
		refObject.setIntegerAttr(1);
		List<TargetObject> moinList = refObject.getObjectRefMultiBoth();
		moinList.add(targetObject1);
		moinList.add(targetObject2);
		Collection<TargetObject> moinSet = refObject.getObjectRefMultiUnique();
		moinSet.add(targetObject1);
		moinSet.add(targetObject2);

		// Establish the binding for the single valued string attribute
		IObservableValue targetString = new WritableValue(getDbc().getValidationRealm(), null, String.class);
		final IObservableValue modelString = MoinObservables.observeValue(getDbc().getValidationRealm(), refObject,
				ObjectWithAttributes.DESCRIPTORS.STRING_ATTR());
		getDbc().bindValue(targetString, modelString, null, null);

		// Establish the binding for the single valued integer attribute
		IObservableValue targetInteger = new WritableValue(getDbc().getValidationRealm(), null, String.class);
		IObservableValue modelInteger = MoinObservables.observeValue(getDbc().getValidationRealm(), refObject,
				ObjectWithAttributes.DESCRIPTORS.INTEGER_ATTR());
		getDbc().bindValue(targetInteger, modelInteger, null, null);

		// Establish the binding for the multi valued integer attribute
		IObservableList targetList = new WritableList(getDbc().getValidationRealm(), new ArrayList<TargetObject>(),
				TargetObject.class);
		IObservableList modelList = MoinObservables.observeList(getDbc().getValidationRealm(), refObject,
				ObjectWithAttributes.DESCRIPTORS.OBJECT_REF_MULTI_BOTH());
		getDbc().bindList(targetList, modelList, null, null);

		// Establish the binding for the multi valued integer attribute
		IObservableSet targetSet = new WritableSet(getDbc().getValidationRealm(), new ArrayList<TargetObject>(),
				TargetObject.class);
		IObservableSet modelSet = MoinObservables.observeSet(getDbc().getValidationRealm(), refObject,
				ObjectWithAttributes.DESCRIPTORS.OBJECT_REF_MULTI_UNIQUE());
		getDbc().bindSet(targetSet, modelSet, null, null);

		// Create validator
		final boolean[] validateCalled = { false };
		final IStatus statusOK = ValidationStatus.info("ok");
		final IStatus statusError = ValidationStatus.error("error");
		final IStatus statusTestDifferentSeverity = new Status(IStatus.INFO, Policy.JFACE_DATABINDING, 0, "ok", null);
		final IStatus statusTestDifferentCode = new Status(IStatus.OK, Policy.JFACE_DATABINDING, 1, "ok", null);
		final IStatus statusTestDifferentMessage = new Status(IStatus.OK, Policy.JFACE_DATABINDING, 0, "error", null);
		final IStatus statusTestDifferentPlugin = new Status(IStatus.OK, "plugin.id.foo", 0, "ok", null);
		final IStatus statusTestDifferentException = new Status(IStatus.OK, Policy.JFACE_DATABINDING, 0, "ok",
				new CoreException(statusOK));
		final IStatus statusTestDifferentChildStatus = new MultiStatus(statusOK.getPlugin(), statusOK.getCode(),
				new IStatus[] { statusError }, statusOK.getMessage(), statusOK.getException());

		BindingScopedMultiValidator validator = new BindingScopedMultiValidator(getDbc().getValidationRealm(), getDbc()
				.getBindings()) {
			@Override
			protected IStatus validate() {
				if ("changedValue".equals(modelString.getValue())) {
					validateCalled[0] = true;
					return ValidationStatus.info("validate() was called");
				} else if ("testDifferentSeverityPrepare".equals(modelString.getValue())) {
					return new Status(IStatus.OK, Policy.JFACE_DATABINDING, 0, "ok", null);
				} else if ("testDifferentSeverity".equals(modelString.getValue())) {
					return statusTestDifferentSeverity;
				} else if ("testDifferentCodePrepare".equals(modelString.getValue())) {
					return new Status(IStatus.OK, Policy.JFACE_DATABINDING, 0, "ok", null);
				} else if ("testDifferentCode".equals(modelString.getValue())) {
					return statusTestDifferentCode;
				} else if ("testDifferentMessagePrepare".equals(modelString.getValue())) {
					return new Status(IStatus.OK, Policy.JFACE_DATABINDING, 0, "ok", null);
				} else if ("testDifferentMessage".equals(modelString.getValue())) {
					return statusTestDifferentMessage;
				} else if ("testDifferentPluginPrepare".equals(modelString.getValue())) {
					return new Status(IStatus.OK, Policy.JFACE_DATABINDING, 0, "ok", null);
				} else if ("testDifferentPlugin".equals(modelString.getValue())) {
					return statusTestDifferentPlugin;
				} else if ("testDifferentExceptionPrepare".equals(modelString.getValue())) {
					return new Status(IStatus.OK, Policy.JFACE_DATABINDING, 0, "ok", new CoreException(statusOK));
				} else if ("testDifferentException".equals(modelString.getValue())) {
					return statusTestDifferentException;
				} else if ("testMultiStatusDifferentChildStatusPrepare".equals(modelString.getValue())) {
					return new MultiStatus(statusOK.getPlugin(), statusOK.getCode(), new IStatus[] { statusOK },
							statusOK.getMessage(), statusOK.getException());
				} else if ("testMultiStatusDifferentChildStatus".equals(modelString.getValue())) {
					return statusTestDifferentChildStatus;
				}
				return statusOK;
			}
		};
		getDbc().addValidationStatusProvider(validator);
		AggregateValidationStatus aggregateValidationStatus = new AggregateValidationStatus(getDbc()
				.getValidationRealm(), getDbc().getValidationStatusProviders(), AggregateValidationStatus.MAX_SEVERITY);
		final boolean[] handleValueChangeCalled = { false };
		aggregateValidationStatus.addValueChangeListener(new IValueChangeListener() {
			public void handleValueChange(ValueChangeEvent event) {
				handleValueChangeCalled[0] = true;
			}
		});

		// Check that validation has been triggered
		refObject.setStringAttr("changedValue");
		assertTrue("Validation was not triggered", validateCalled[0]);
		assertTrue("Value change was not triggered", handleValueChangeCalled[0]);

		// Check validation result
		assertEquals("Validation should return info status", ValidationStatus.INFO, ((IStatus) validator
				.getValidationStatus().getValue()).getSeverity());

		refObject.setStringAttr("testDifferentSeverityPrepare");
		refObject.setStringAttr("testDifferentSeverity");
		assertTrue("Validation should return different severity status",
				statusTestDifferentSeverity.getSeverity() == ((IStatus) validator.getValidationStatus().getValue())
						.getSeverity());
		refObject.setStringAttr("testDifferentCodePrepare");
		refObject.setStringAttr("testDifferentCode");
		assertTrue("Validation should return different code status",
				statusTestDifferentCode.getCode() == ((IStatus) validator.getValidationStatus().getValue()).getCode());
		refObject.setStringAttr("testDifferentMessagePrepare");
		refObject.setStringAttr("testDifferentMessage");
		assertTrue("Validation should return different message status", statusTestDifferentMessage.getMessage().equals(
				((IStatus) validator.getValidationStatus().getValue()).getMessage()));
		refObject.setStringAttr("testDifferentPluginPrepare");
		refObject.setStringAttr("testDifferentPlugin");
		assertTrue("Validation should return different plugin status", statusTestDifferentPlugin.getPlugin().equals(
				((IStatus) validator.getValidationStatus().getValue()).getPlugin()));
		refObject.setStringAttr("testDifferentExceptionPrepare");
		refObject.setStringAttr("testDifferentException");
		assertTrue("Validation should return different exception status", statusTestDifferentException.getException()
				.equals(((IStatus) validator.getValidationStatus().getValue()).getException()));
		refObject.setStringAttr("testMultiStatusDifferentChildStatusPrepare");
		refObject.setStringAttr("testMultiStatusDifferentChildStatus");
		assertTrue("Validation should return different multi status", statusTestDifferentChildStatus.getChildren()
				.equals(((IStatus) validator.getValidationStatus().getValue()).getChildren()));

		IObservableList observables = validator.getModels();
		assertEquals("There should be 0 model observables in the validator", 0, observables.size());
		observables = validator.getTargets();
		assertEquals("There should be 4 target observables in the validator", 4, observables.size());

		// Clean-up
		validator.dispose();
	}
}

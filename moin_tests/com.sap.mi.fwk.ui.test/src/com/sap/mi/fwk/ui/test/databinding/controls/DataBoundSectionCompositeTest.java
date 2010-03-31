package com.sap.mi.fwk.ui.test.databinding.controls;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.validation.MultiValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.sap.demo.mi.testmetamodel.databinding.ObjectWithAttributes;
import com.sap.demo.mi.testmetamodel.databinding.TargetObject;
import com.sap.ide.junit.extensions.ExtendedTestCase;
import com.sap.ide.junit.ui.lift.FactoryBuilder;
import com.sap.ide.junit.ui.lift.LFactory;
import com.sap.ide.junit.ui.lift.LRunnable;
import com.sap.ide.junit.ui.lift.LShell;
import com.sap.ide.junit.ui.lift.WidgetException;
import com.sap.ide.junit.utils.PDEUtil;
import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.ui.databinding.MoinDataBindingContext;
import com.sap.mi.fwk.ui.databinding.MoinObservables;
import com.sap.mi.fwk.ui.databinding.controls.DataBoundSectionComposite;
import com.sap.tc.moin.repository.Connection;

public class DataBoundSectionCompositeTest extends ExtendedTestCase {

	private LFactory abbotFactory;

	private LShell shell;

	public DataBoundSectionCompositeTest() {
		super();
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		PDEUtil.prepareWorkbench();
		this.abbotFactory = FactoryBuilder.newAbbotFactory();
		this.shell = this.abbotFactory.getShell(Display.getDefault());
	}

	public void testSectionComposite() {
		LRunnable<Void> runnable = new LRunnable<Void>() {
			public Void run() throws Exception {
				// error with 3.4. IDE - instantiate dialog in UI thread,
				// otherwise JFaceResources does not find the current display
				TestDialog dialog = new TestDialog();
				try {
					dialog.setBlockOnOpen(false);
					dialog.open();

					// Create RefObject
					Connection connection = ConnectionManager.getInstance().createTransientConnection();
					ObjectWithAttributes refObject = connection.createElement(ObjectWithAttributes.class);
					refObject.setStringAttr("value");
					refObject.setIntegerAttr(1);
					dialog.setInput(refObject);

					// Check that changes is the input field for string are
					// propagated to the model
					dialog.setStringFieldText("changedValue");
					assertEquals("Text field change was not propagated", "changedValue", refObject.getStringAttr());

					// Check that changes with errors is the input field for
					// string are propagated to the model and an error message
					// is set
					dialog.setStringFieldText("changed Value");
					assertEquals("Erroneous text field change was not propagated", "changed Value", refObject
							.getStringAttr());

					// Check that changes with warnings is the input field for
					// integer are propagated to the model and a warning message
					// is set
					dialog.setStringFieldText("changedValue");
					dialog.setIntegerFieldText("-1");
					assertEquals("Text field change with warnings was not propagated", -1, refObject.getIntegerAttr());

					// Check that invalid changes is the input field for
					// integer are not propagated to the model and an error
					// message is set
					dialog.setIntegerFieldText("a");
					assertEquals("Invalid text field change was propagated", -1, refObject.getIntegerAttr());

					// Refresh
					dialog.refresh();

					// Set empty input
					dialog.setInput(null);

					// Set wrong input and expect error
					TargetObject targetObject = connection.createElement(TargetObject.class);
					targetObject.setStringAttr("value");
					try {
						dialog.setInput(targetObject);
						fail("Setting a wrong object should fail");
					} catch (ClassCastException e) {
						// Expected
					}

					// Cleanup
					connection.revert();
				} finally {
					// Close dialog
					dialog.close();
				}
				return null;
			}
		};

		try {
			this.shell.asyncExec(runnable);
		} catch (WidgetException e) {
			fail(e);
		}
	}

	private class TestDialog extends Dialog {

		TestDataBoundSectionComposite sectionComposite = null;

		public TestDialog() {
			super(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
		}

		public void setInput(Object object) {
			this.sectionComposite.setInput(object);
		}

		public void setStringFieldText(String text) {
			this.sectionComposite.setStringFieldText(text);
		}

		public void setIntegerFieldText(String text) {
			this.sectionComposite.setIntegerFieldText(text);
		}

		public void refresh() {
			this.sectionComposite.forceRefresh();
		}

		@Override
		protected Control createDialogArea(Composite parent) {
			// Root composite
			Composite composite = (Composite) super.createDialogArea(parent);
			GridData gd = new GridData(GridData.FILL, GridData.FILL, true, true);
			composite.setLayoutData(gd);
			GridLayout layout = new GridLayout(1, true);
			composite.setLayout(layout);

			// Section inside root composite
			FormToolkit formToolkit = new FormToolkit(composite.getDisplay());
			Section section = formToolkit.createSection(composite, SWT.NONE);
			gd = new GridData(GridData.FILL, GridData.FILL, true, true);
			section.setLayoutData(gd);
			layout = new GridLayout(1, true);
			section.setLayout(layout);

			// SectionComposite to test
			this.sectionComposite = new TestDataBoundSectionComposite(section, formToolkit);
			this.sectionComposite.createClient();

			return composite;
		}
	}

	private class TestDataBoundSectionComposite extends DataBoundSectionComposite<ObjectWithAttributes> {

		private Text stringField = null;
		private Text integerField = null;

		public TestDataBoundSectionComposite(Section section, FormToolkit formToolkit) {
			super(section, formToolkit, "Test Title", "Test Description");
		}

		public void setStringFieldText(String text) {
			this.stringField.setText(text);
		}

		public void setIntegerFieldText(String text) {
			this.integerField.setText(text);
		}

		public void forceRefresh() {
			super.refresh(true);
		}

		@Override
		protected void createControls(Composite parent, FormToolkit toolkit) {
			GridLayout layout = new GridLayout(2, false);
			parent.setLayout(layout);
			parent.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

			// String attribute
			Label stringLabel = toolkit.createLabel(parent, "String");
			stringLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
			this.stringField = toolkit.createText(parent, "");
			this.stringField.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

			// Integer attribute
			Label integerLabel = toolkit.createLabel(parent, "Integer");
			integerLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
			this.integerField = toolkit.createText(parent, ""); //$NON-NLS-1$
			this.integerField.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		}

		@Override
		protected void createBindings(MoinDataBindingContext dbc, ObjectWithAttributes object) {
			// String attribute
			IObservableValue stringTarget = SWTObservables.observeText(this.stringField, SWT.Modify);
			IObservableValue stringModel = MoinObservables.observeValue(object, ObjectWithAttributes.DESCRIPTORS
					.STRING_ATTR());
			dbc.bindValue(stringTarget, stringModel, null, null);

			// Integer attribute
			IObservableValue integerTarget = SWTObservables.observeText(this.integerField, SWT.Modify);
			IObservableValue integerModel = MoinObservables.observeValue(object, ObjectWithAttributes.DESCRIPTORS
					.INTEGER_ATTR());
			dbc.bindValue(integerTarget, integerModel, null, null);

			// Create custom validator to check own rules of correctness
			MultiValidator validator = new TestValidator(stringModel, integerModel);
			dbc.addValidationStatusProvider(validator);
		}
	}

	private class TestValidator extends MultiValidator {

		private IObservableValue mString = null;
		private IObservableValue mInteger = null;

		public TestValidator(IObservableValue stringModel, IObservableValue integerModel) {
			super();
			mString = stringModel;
			mInteger = integerModel;
		}

		protected IStatus validate() {
			String str = (String) mString.getValue();
			if (str.indexOf(' ') != -1) {
				return ValidationStatus.error("String test error message");
			}

			int i = (Integer) mInteger.getValue();
			if (i < 0) {
				return ValidationStatus.warning("Integer test warning message");
			}

			return ValidationStatus.ok();
		}
	}
}

package com.sap.ide.moftool.editor.fwk;

import java.util.Map;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.sap.ide.moftool.editor.core.commands.MofService;
import com.sap.ide.moftool.editor.core.service.ModelElementService;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.ui.databinding.MoinDataBindingContext;
import com.sap.mi.fwk.ui.databinding.MoinObservables;
import com.sap.mi.fwk.ui.databinding.MoinUpdateValueStrategy;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.descriptors.AttributeDescriptor;
import com.sap.tc.moin.repository.mmi.descriptors.StructuralFeatureDescriptor;

public class MultiplicityTypeControl {

	private RefBaseObject mModelElement = null;
	private MultiplicityType mMultiplicityType = null;

	private Composite mControl = null;
	private CCombo mBoundsDropdown = null;
	private Button mOrderedButton = null;
	private Button mUniqueButton = null;

	private final BoundsValidator mBoundsValidator = new BoundsValidator();
	private boolean widgetEnabled = true;

	/**
	 * 
	 * @param parent
	 * @param formToolkit
	 * @param title
	 * @param style
	 */
	public MultiplicityTypeControl(Composite parent, FormToolkit formToolkit, String title) {
		super();

		int style = SWT.NONE;

		Label label = formToolkit.createLabel(parent, title);
		GridData data = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		label.setLayoutData(data);

		mControl = formToolkit.createComposite(parent, style);
		data = new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1);
		mControl.setLayoutData(data);
		mControl.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TREE_BORDER);
		formToolkit.paintBordersFor(mControl);
		formToolkit.adapt(mControl, false, false);
		GridLayout layout = new GridLayout(4, false);
		mControl.setLayout(layout);

		// Drop down box for bounds
		label = formToolkit.createLabel(mControl, LocalizationMessages.MultiplicityTypeControl_0_XFLD);
		mBoundsDropdown = new CCombo(mControl, style | SWT.DROP_DOWN);
		mBoundsDropdown.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
		mBoundsDropdown.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		mBoundsDropdown.setItems(new String[] { "0..1", "1..1", "0..*", "1..*" }); //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$
		data = new GridData(SWT.FILL, SWT.TOP, false, false);
		data.widthHint = 70;
		mBoundsDropdown.setLayoutData(data);

		// Button for ordered flag
		mOrderedButton = formToolkit.createButton(mControl, LocalizationMessages.MultiplicityTypeControl_1_XCKL, SWT.CHECK);
		data = new GridData(SWT.BEGINNING, SWT.TOP, false, false, 1, 1);
		data.horizontalIndent = 10;
		mOrderedButton.setLayoutData(data);

		// Button for unique flag
		mUniqueButton = formToolkit.createButton(mControl, LocalizationMessages.MultiplicityTypeControl_2_XCKL, SWT.CHECK);
		data = new GridData(SWT.BEGINNING, SWT.TOP, false, false, 1, 1);
		mUniqueButton.setLayoutData(data);

	}

	public void setInput(RefBaseObject modelElement,
			AttributeDescriptor<Attribute, ? extends RefObject, ? extends Object> attributeDescriptor, MoinDataBindingContext dbc) {

		// Clean up first and disable everything
		mMultiplicityType = null;
		// Disable ...
		mBoundsDropdown.setEnabled(false);
		mOrderedButton.setEnabled(false);
		mUniqueButton.setEnabled(false);
		// ... and clear fields
		mBoundsDropdown.setText(""); //$NON-NLS-1$
		mOrderedButton.setSelection(false);
		mUniqueButton.setSelection(false);

		// Get new model element and register
		mModelElement = modelElement;
		if (mModelElement != null) {
			// Enable all controls (could be disabled) if not read-only
			boolean isForeignElement = ModelElementService.isForeignObject(mModelElement);
			mBoundsDropdown.setEnabled(!isForeignElement && widgetEnabled);
			mOrderedButton.setEnabled(!isForeignElement && widgetEnabled);
			mUniqueButton.setEnabled(!isForeignElement && widgetEnabled);
			// TODO error handling!
			Connection connection = ModelAdapter.getInstance().getConnection(mModelElement);
			JmiHelper jmiHelper = connection.getJmiHelper();
			Attribute attribute = connection.getMetamodelElement(attributeDescriptor);
			Map<Attribute, Object> valueMap = jmiHelper.getAttributesWithValues((ModelElement) mModelElement, true);
			Object value = valueMap.get(attribute);

			if (value instanceof MultiplicityType) {
				mMultiplicityType = (MultiplicityType) value;

				// Init controls
				setBoundsDropdownText(mMultiplicityType);
				mOrderedButton.setSelection(mMultiplicityType.isOrdered());
				mUniqueButton.setSelection(mMultiplicityType.isUnique());
				if (mMultiplicityType.getUpper() == 0 || mMultiplicityType.getUpper() == 1) {
					mOrderedButton.setEnabled(false);
					mUniqueButton.setEnabled(false);
				}
			}
			registerBindings(attributeDescriptor, dbc);
		}
	}

	private void setBoundsDropdownText(MultiplicityType multiplicityType) {
		String upperString = null;
		if (multiplicityType != null && multiplicityType.getUpper() != -1) {
			upperString = (new Integer(multiplicityType.getUpper())).toString();
		} else {
			upperString = "*"; //$NON-NLS-1$
		}
		mBoundsDropdown.setText((new Integer(multiplicityType.getLower())).toString() + ".." + upperString); //$NON-NLS-1$
	}

	private MultiplicityType createNewMultiplicityType(int lower, int upper, boolean isOrdered, boolean isUnique) {

		// Create new multiplicity type from given values
		ModelPackage modelPackage = (ModelPackage) ModelAdapter.getInstance().getConnection(mModelElement).getPackage(null,
				new String[] { "Model" }); //$NON-NLS-1$
		mMultiplicityType = MofService.createMultiplicityType(modelPackage, lower, upper, isOrdered, isUnique);

		return mMultiplicityType;
	}

	public Control getControl() {
		return mControl;
	}

	private class BoundsValidator implements IValidator {
		public IStatus validate(Object object) {
			if (ModelElementService.isForeignObject(mModelElement)) {
				setBoundsDropdownText(mMultiplicityType);
				return Status.OK_STATUS;
			}

			// Start parsing
			String newText = mBoundsDropdown.getText();

			// Parse lower bound
			int lower = 0;
			try {
				String newLowerText = ""; //$NON-NLS-1$
				int index = newText.indexOf(".."); //$NON-NLS-1$
				if (index != -1) {
					newLowerText = newText.substring(0, index);
				}
				lower = Integer.parseInt(newLowerText);
			} catch (NumberFormatException nfe) {
				markErroneus(mBoundsDropdown);
				return new Status(IStatus.ERROR, "MofTool", "No lower bound found in '" + newText + "'", nfe); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			}

			// Parse upper bound
			int upper = 0;
			String newUpperText = ""; //$NON-NLS-1$
			int index = newText.indexOf(".."); //$NON-NLS-1$
			if (index != -1) {
				newUpperText = newText.substring(index + 2);
			}
			try {
				upper = Integer.parseInt(newUpperText);
			} catch (NumberFormatException nfe) {
				if (newUpperText.equals("*")) { //$NON-NLS-1$
					upper = -1;
				} else if (newUpperText.equals("n")) { //$NON-NLS-1$
					upper = -1;
					mBoundsDropdown.setText(lower + "..*"); //$NON-NLS-1$
				} else {
					markErroneus(mBoundsDropdown);
					return new Status(IStatus.ERROR, "MofTool", "No upper bound found in '" + newText + "'", nfe); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				}
			}

			// Perform checks

			// [C-54] Lower cannot be negative or unbounded
			if (lower < 0) {
				markErroneus(mBoundsDropdown);
				return new Status(IStatus.ERROR, "MofTool", "Lower cannot be negative or unbounded"); //$NON-NLS-1$ //$NON-NLS-2$
			}
			// [C-55] Lower cannot exceed upper
			if (lower > upper && upper != -1) {
				markErroneus(mBoundsDropdown);
				return new Status(IStatus.ERROR, "MofTool", "Lower cannot exceed upper"); //$NON-NLS-1$ //$NON-NLS-2$
			}
			if (upper < -1) {
				markErroneus(mBoundsDropdown);
				return new Status(IStatus.ERROR, "MofTool", "Upper must be greater than -1"); //$NON-NLS-1$ //$NON-NLS-2$
			}
			// [C56] The upper bound cannot be less than 1
			if (upper == 0) {
				markErroneus(mBoundsDropdown);
				return new Status(IStatus.ERROR, "MofTool", "The upper bound cannot be less than 1"); //$NON-NLS-1$ //$NON-NLS-2$
			}

			// Everything ok
			markNoError(mBoundsDropdown);
			return Status.OK_STATUS;
		}
	}

	private void markErroneus(Control control) {
		// control.setForeground(JFaceColors.getErrorText(Display.getCurrent()));
	}

	private void markNoError(Control control) {
		// control.setForeground(mTextForeground);
	}

	private void registerBindings(
			StructuralFeatureDescriptor<? extends StructuralFeature, ? extends RefObject, ? extends Object> mAttributeDescriptor,
			DataBindingContext dbc) {
		if (mModelElement == null)
			return;
		if (!((Partitionable) this.mModelElement).is___Alive())
			return;

		// Bounds
		IObservableValue v = SWTObservables.observeSelection(mBoundsDropdown);
		IObservableValue m = MoinObservables.observeValue((ModelElement) mModelElement, mAttributeDescriptor);
		IConverter toModelConverter = new IConverter() {
			public Object convert(Object fromObject) {

				if (fromObject instanceof String) {
					// Start parsing
					String newText = (String) fromObject;

					// Parse lower bound
					int lower = 0;
					try {
						String newLowerText = ""; //$NON-NLS-1$
						int index = newText.indexOf(".."); //$NON-NLS-1$
						if (index != -1) {
							newLowerText = newText.substring(0, index);
						}
						lower = Integer.parseInt(newLowerText);
					} catch (NumberFormatException nfe) {
						return null;
					}

					// Parse upper bound
					int upper = 0;
					String newUpperText = ""; //$NON-NLS-1$
					int index = newText.indexOf(".."); //$NON-NLS-1$
					if (index != -1) {
						newUpperText = newText.substring(index + 2);
					}
					try {
						upper = Integer.parseInt(newUpperText);
					} catch (NumberFormatException nfe) {
						if (newUpperText.equals("*")) { //$NON-NLS-1$
							upper = -1;
						} else if (newUpperText.equalsIgnoreCase("n")) { //$NON-NLS-1$
							upper = -1;
						} else {
							return null;
						}
					}

					if (mMultiplicityType != null && mMultiplicityType.getLower() != lower) {
						createNewMultiplicityType(lower, mMultiplicityType.getUpper(), mMultiplicityType.isOrdered(), mMultiplicityType
								.isUnique());
					}
					// TODO: use default values for new multiplicity type in
					// other case (necessary?)

					// Adapt ordered and unique flag to new values
					boolean ordered = mMultiplicityType.isOrdered();
					boolean unique = mMultiplicityType.isUnique();
					// [C-57] If a multiplicity type specifies bounds of [0..1]
					// or
					// [1..1], the isOrdered and isUnique values must be false
					if (upper == 1) {
						ordered = false;
						unique = false;
						mOrderedButton.setEnabled(false);
						mUniqueButton.setEnabled(false);
					} else {
						// [C-40] The "isUnique" flag in an AssociationEnd's
						// multiplicity must be true
						// (if the cardinality is to n
						unique = true;
						boolean isForeignObject = ModelElementService.isForeignObject(mModelElement);
						mOrderedButton.setEnabled(!isForeignObject && widgetEnabled);
						mUniqueButton.setEnabled(!isForeignObject && widgetEnabled);
					}
					// Everything ok -> set new value
					if (mMultiplicityType != null && mMultiplicityType.getUpper() != upper) {
						createNewMultiplicityType(mMultiplicityType.getLower(), upper, ordered, unique);
					}
				}

				return mMultiplicityType;
			}

			public Object getFromType() {
				return String.class;
			}

			public Object getToType() {
				return MultiplicityType.class;
			}

		};
		IConverter toUiConverter = new IConverter() {

			public Object convert(Object fromObject) {
				String result = ""; //$NON-NLS-1$

				if (fromObject instanceof MultiplicityType) {
					MultiplicityType type = (MultiplicityType) fromObject;
					int upper = type.getUpper();
					String upperString = null;
					if (upper == -1) {
						upperString = "*"; //$NON-NLS-1$
					} else {
						upperString = Integer.toString(upper);
					}
					result = type.getLower() + ".." + upperString; //$NON-NLS-1$
				}

				return result;
			}

			public Object getFromType() {
				return MultiplicityType.class;
			}

			public Object getToType() {
				return String.class;
			}

		};
		dbc.bindValue(v, m, new MoinUpdateValueStrategy().setConverter(toModelConverter).setAfterGetValidator(mBoundsValidator),
				new MoinUpdateValueStrategy().setConverter(toUiConverter));
		mBoundsDropdown.setEnabled(!ModelElementService.isForeignObject(mModelElement) && widgetEnabled);

		// Ordered
		v = SWTObservables.observeSelection(mOrderedButton);
		m = MoinObservables.observeValue((ModelElement) mModelElement, mAttributeDescriptor);
		toModelConverter = new IConverter() {
			public Object convert(Object fromObject) {
				if (mMultiplicityType != null) {
					return createNewMultiplicityType(mMultiplicityType.getLower(), mMultiplicityType.getUpper(), mOrderedButton
							.getSelection(), mMultiplicityType.isUnique());
				} else {
					// Create default multiplicity
					return createNewMultiplicityType(1, 1, false, false);
				}
			}

			public Object getFromType() {
				return Boolean.class;
			}

			public Object getToType() {
				return MultiplicityType.class;
			}

		};
		toUiConverter = new IConverter() {

			public Object convert(Object fromObject) {
				Boolean result = false;

				if (fromObject instanceof MultiplicityType) {
					MultiplicityType type = (MultiplicityType) fromObject;
					result = type.isOrdered();
				}

				return result;
			}

			public Object getFromType() {
				return MultiplicityType.class;
			}

			public Object getToType() {
				return Boolean.class;
			}

		};
		dbc.bindValue(v, m, new MoinUpdateValueStrategy().setConverter(toModelConverter), new MoinUpdateValueStrategy()
				.setConverter(toUiConverter));
		mOrderedButton.setEnabled(!ModelElementService.isForeignObject(mModelElement) && widgetEnabled);

		// Unique
		v = SWTObservables.observeSelection(mUniqueButton);
		m = MoinObservables.observeValue((ModelElement) mModelElement, mAttributeDescriptor);
		toModelConverter = new IConverter() {
			public Object convert(Object fromObject) {
				return createNewMultiplicityType(mMultiplicityType.getLower(), mMultiplicityType.getUpper(), mMultiplicityType.isOrdered(),
						mUniqueButton.getSelection());
			}

			public Object getFromType() {
				return Boolean.class;
			}

			public Object getToType() {
				return MultiplicityType.class;
			}

		};
		toUiConverter = new IConverter() {

			public Object convert(Object fromObject) {
				Boolean result = false;

				if (fromObject instanceof MultiplicityType) {
					MultiplicityType type = (MultiplicityType) fromObject;
					result = type.isUnique();
				}

				return result;
			}

			public Object getFromType() {
				return MultiplicityType.class;
			}

			public Object getToType() {
				return Boolean.class;
			}

		};
		dbc.bindValue(v, m, new MoinUpdateValueStrategy().setConverter(toModelConverter), new MoinUpdateValueStrategy()
				.setConverter(toUiConverter));
		mUniqueButton.setEnabled(!ModelElementService.isForeignObject(mModelElement) && widgetEnabled);
	}

	public void setEnabled(boolean editable) {
		widgetEnabled = editable;
		mBoundsDropdown.setEnabled(editable);
		mOrderedButton.setEnabled(editable);
		mUniqueButton.setEnabled(editable);

	}
}
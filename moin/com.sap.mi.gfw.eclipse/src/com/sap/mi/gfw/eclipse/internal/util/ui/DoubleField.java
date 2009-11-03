package com.sap.mi.gfw.eclipse.internal.util.ui;

import java.text.DecimalFormat;
import java.text.ParseException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

/**
 * A Text control allowing only non-negative decimal input. Writes its state to a DefaultPreferences object passed in the constructor.
 */
public class DoubleField extends Composite implements ModifyListener {

	public static final String decimalNumberFormat = "###0.00"; //$NON-NLS-1$
	public static final DecimalFormat decimalNumberFormatter = new DecimalFormat(decimalNumberFormat);

	private DefaultPreferences _preferences;
	private int _index;
	Text _text;
	private boolean _internalModify = false;
	private boolean _initialUpdate = true;

	/**
	 * Creates a new DoubleField.
	 */
	public DoubleField(Composite parent, int style, DefaultPreferences prefs, int index) {
		super(parent, style);
		_preferences = prefs;
		_index = index;
		FillLayout fill = new FillLayout();
		setLayout(fill);
		_text = new Text(this, SWT.SINGLE | SWT.BORDER);
		updateControl();

		_text.addModifyListener(this);
		_text.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				_text.selectAll();
			}

			@Override
			public void mouseUp(MouseEvent e) {
				// _text.selectAll();
			}
		});

		GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		gridData.widthHint = 50;
		// setLayoutData(gridData);
	}

	// ========================== public access ===============================

	@Override
	public void setEnabled(boolean en) {
		_text.setEnabled(en);
	}

	/**
	 * Updates control according to value in the DefaultPreferences. If it is the first update with an empty textfield, the preference value
	 * is set. If it is not the first time an empty text field occurs, nothing happens avoiding the confusing behaviour of updating to 0.00
	 * when the user deletes all characters for preparing new input.
	 */
	public void updateControl() {
		_internalModify = true;
		double newValue = _preferences.getDoublePreference(_index);
		try {
			if (_text.getText().length() != 0) {
				double oldValue = Double.valueOf(_text.getText()).doubleValue();
				if (newValue != oldValue)
					_text.setText(decimalNumberFormatter.format(newValue));
			} else {
				if (_initialUpdate) {
					_text.setText(decimalNumberFormatter.format(newValue));
				}
			}
		} catch (NumberFormatException e) {
			// $JL-EXC$
			_text.setText(decimalNumberFormatter.format(newValue));
		} finally {
			_internalModify = false;
		}
		_initialUpdate = false;
	}

	public Text getText() {
		return _text;
	}

	// ============================ eventing ==================================

	public void addModifyListener(ModifyListener listener) {
		_text.addModifyListener(listener);
	}

	public void modifyText(ModifyEvent e) {
		if (_internalModify)
			return;

		try {
			String text = _text.getText();
			double value;
			if (text.length() == 0) {
				value = decimalNumberFormatter.parse("0").doubleValue(); //$NON-NLS-1$
			} else {
				value = decimalNumberFormatter.parse(text).doubleValue();
			}
			_preferences.setDoublePreference(_index, value);
		} catch (ParseException x) {
			// $JL-EXC$ do nothing, reset after the conversion anyway
			updateControl();
		}
	}
}
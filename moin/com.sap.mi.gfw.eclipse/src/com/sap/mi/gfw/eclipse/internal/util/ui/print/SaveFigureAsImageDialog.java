package com.sap.mi.gfw.eclipse.internal.util.ui.print;

import java.util.Locale;

import org.eclipse.gef.GraphicalViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import com.sap.mi.gfw.eclipse.Messages;
import com.sap.mi.gfw.eclipse.internal.util.ui.DoubleFieldWithDropDown;
import com.sap.mi.gfw.util.T;

/**
 * This is a simple dialog to choose the image-format and the image-scale-factor for a save-as-image operation.
 */
public class SaveFigureAsImageDialog extends AbstractFigureSelectionDialog implements ModifyListener {

	public static final String[] IMAGE_FILE_EXTENSIONS = new String[] { "BMP", "GIF", "JPG", "RLE" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$

	public static final int[] IMAGE_FILE_TYPES = new int[] { SWT.IMAGE_BMP, SWT.IMAGE_GIF, SWT.IMAGE_JPEG, SWT.IMAGE_BMP_RLE };

	public static final String[] WIDTHS = new String[] { "320", "640", "800", "1024", "1280", "1600" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$

	public static final String[] HEIGHTS = new String[] { "200", "400", "600", "768", "1024", "1280" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$

	public static final double[] SCALE_FACTORS = new double[] { 0.5, 1.0, 2.0, 4.0 };

	// controls
	private Combo _formatCombo;

	private Combo _widthCombo;

	private Combo _heightCombo;

	private DoubleFieldWithDropDown _scaleFactorText;

	// selected values
	private int _formatIndex = 0;

	/**
	 * Creates a new SaveFigureAsImageDialog.
	 * 
	 * @param shell
	 *            The Shell of this dialog.
	 * @param graphicalViewer
	 *            The GraphicalViewer, which to save.
	 */
	public SaveFigureAsImageDialog(Shell shell, GraphicalViewer graphicalViewer) {
		super(shell, graphicalViewer);
	}

	// ======================= overwritten methods ============================

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		GridLayout layout = new GridLayout(2, false);
		composite.setLayout(layout);

		createChooseFigureGroup(composite);

		Group scaleGroup = createChooseScaleFactorGroup(composite);

		Label widthComboText = new Label(scaleGroup, SWT.NONE);
		widthComboText.setText(Messages.SaveFigureAsImageDialog_0_xfld);
		_widthCombo = new Combo(scaleGroup, SWT.DROP_DOWN);
		_widthCombo.setItems(WIDTHS);
		_widthCombo.addModifyListener(this);
		GridData data = new GridData(GridData.GRAB_HORIZONTAL | GridData.FILL_HORIZONTAL);
		_widthCombo.setLayoutData(data);

		Label heightComboText = new Label(scaleGroup, SWT.NONE);
		heightComboText.setText(Messages.SaveFigureAsImageDialog_1_xfld);
		_heightCombo = new Combo(scaleGroup, SWT.DROP_DOWN);
		_heightCombo.setItems(HEIGHTS);
		_heightCombo.addModifyListener(this);
		GridData data2 = new GridData(GridData.GRAB_HORIZONTAL | GridData.FILL_HORIZONTAL);
		_heightCombo.setLayoutData(data2);

		createFormatGroup(composite);

		updateControls();

		return composite;
	}

	// ======================== private helper methods ========================

	private void createFormatGroup(Composite composite) {
		Group formatGroup = new Group(composite, SWT.NONE);
		formatGroup.setLayout(new GridLayout(2, false));
		Label formatComboText = new Label(formatGroup, SWT.NONE);
		formatComboText.setText(Messages.SaveFigureAsImageDialog_2_xfld);
		GridData data4 = new GridData(GridData.HORIZONTAL_ALIGN_END);
		formatComboText.setLayoutData(data4);
		_formatCombo = new Combo(formatGroup, SWT.DROP_DOWN | SWT.READ_ONLY);
		_formatCombo.setItems(IMAGE_FILE_EXTENSIONS);
		_formatCombo.setText(IMAGE_FILE_EXTENSIONS[_formatIndex]);
		_formatCombo.addModifyListener(this);
		GridData data3 = new GridData(GridData.GRAB_HORIZONTAL | GridData.FILL_HORIZONTAL);
		_formatCombo.setLayoutData(data3);
	}

	private Group createChooseScaleFactorGroup(Composite composite) {
		Group scaleGroup = new Group(composite, SWT.NONE);
		scaleGroup.setText(Messages.SaveFigureAsImageDialog_3_xfld);
		GridData data = new GridData(GridData.GRAB_HORIZONTAL | GridData.FILL_HORIZONTAL);
		data.horizontalSpan = 1;
		data.verticalSpan = 2;
		scaleGroup.setLayoutData(data);
		GridLayout layout = new GridLayout(2, false);
		scaleGroup.setLayout(layout);

		Label scaleFactorText = new Label(scaleGroup, SWT.NONE);
		scaleFactorText.setText(Messages.SaveFigureAsImageDialog_4_xfld);
		_scaleFactorText = new DoubleFieldWithDropDown(scaleGroup, SWT.NONE, _preferences, DefaultPrintPreferences.SCALE_FACTOR,
				SCALE_FACTORS);
		data = new GridData(GridData.GRAB_HORIZONTAL | GridData.FILL_HORIZONTAL);
		_scaleFactorText.setLayoutData(data);
		_scaleFactorText.addModifyListener(this);

		return scaleGroup;
	}

	// =============================== eventing ===============================

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
	 */
	public void modifyText(ModifyEvent e) {
		if (_insideInternalModify) // avoid endless-loops
			return;

		// super.modifyText(e);

		if (e.getSource() == _formatCombo) {
			_formatIndex = _formatCombo.getSelectionIndex();
		} else if (e.getSource() == _widthCombo) {
			try {
				String text = _widthCombo.getText();
				if (text.length() == 0)
					text = "0"; //$NON-NLS-1$
				int width = Integer.parseInt(text);
				_preferences.setDoublePreference(DefaultPrintPreferences.SCALE_FACTOR, (double) width / (double) _figure.getBounds().width);
			} catch (NumberFormatException x) {
				// $JL-EXC$
				// do nothing, reset after the conversion anyway
				T.racer().error("illegal number format", x); //$NON-NLS-1$
			}
			updateControls();
		} else if (e.getSource() == _heightCombo) {
			try {
				String text = _heightCombo.getText();
				if (text.length() == 0)
					text = "0"; //$NON-NLS-1$
				int height = Integer.parseInt(text);
				_preferences.setDoublePreference(DefaultPrintPreferences.SCALE_FACTOR,
						((double) height / (double) _figure.getBounds().height));

			} catch (NumberFormatException x) {
				// $JL-EXC$
				// do nothing, reset after the conversion anyway
				T.racer().error("illegal number format", x); //$NON-NLS-1$
			}
			updateControls();

		} else
			updateControls();

	}

	@Override
	public void updateControls() {
		super.updateControls();

		_insideInternalModify = true;
		try {
			double scaleFactor = _preferences.getDoublePreference(DefaultPrintPreferences.SCALE_FACTOR);
			String newText = Long.toString(Math.round((scaleFactor * _figure.getBounds().width)));
			if (!newText.equals(_widthCombo.getText())) // don't update if
				// identical, otherwise
				// cursor will move to
				// the
				// first character
				_widthCombo.setText(newText);
			newText = Long.toString(Math.round((scaleFactor * _figure.getBounds().height)));
			if (!newText.equals(_heightCombo.getText())) // don't update if
				// identical,
				// otherwise cursor
				// will move to
				// the first character
				_heightCombo.setText(newText);

			_scaleFactorText.updateControl();
		} finally {
			_insideInternalModify = false;
		}
	}

	@Override
	protected void okPressed() {
		setScaledImage(getImageScaleFactor());
		super.okPressed();
	}

	// =========================== public access ==============================

	public final int getImageFormat() {
		return IMAGE_FILE_TYPES[_formatIndex];
	}

	public final String getFileExtensionForImageFormat() {
		return IMAGE_FILE_EXTENSIONS[_formatIndex].toLowerCase(Locale.ENGLISH);
	}

	public double getImageScaleFactor() {
		return _preferences.getDoublePreference(DefaultPrintPreferences.SCALE_FACTOR);
	}
}
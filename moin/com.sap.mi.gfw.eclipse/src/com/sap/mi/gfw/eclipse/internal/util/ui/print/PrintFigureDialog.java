package com.sap.mi.gfw.eclipse.internal.util.ui.print;

import java.text.DecimalFormat;
import java.text.MessageFormat;

import org.eclipse.draw2d.PrintFigureOperation;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.printing.PrintDialog;
import org.eclipse.swt.printing.Printer;
import org.eclipse.swt.printing.PrinterData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import com.sap.mi.gfw.eclipse.Messages;
import com.sap.mi.gfw.eclipse.internal.util.ui.DefaultPreferences;
import com.sap.mi.gfw.eclipse.internal.util.ui.DoubleField;
import com.sap.mi.gfw.eclipse.internal.util.ui.DoubleFieldWithDropDown;

/**
 * This is a dialog to choose positioning and scaling for a print operation.
 * 
 * @see PrintFigureScaleableOperation
 */
public class PrintFigureDialog extends AbstractFigureSelectionDialog implements ModifyListener, PaintListener {

	private static final String COLON = ":"; //$NON-NLS-1$

	private static final int BEST_FIT = 0;

	private static final int SCALE_XY = 1;

	private static final int SCALE_STRETCH = 3;

	private static final int CUSTOM_SIZE = 4;

	public static final String decimalNumberFormat = "###0.00"; //$NON-NLS-1$

	public static final DecimalFormat decimalNumberFormatter = new DecimalFormat(decimalNumberFormat);

	private static final int PREVIEW_SIZE = 200;

	public static final double[] SCALE_FACTORS = new double[] { 0.5, 1.0, 2.0, 4.0 };

	private static final double INCH_TO_CM_FACTOR = 2.54d;

	private static final int WARNING_IF_MOREPAGES_THAN = 5;

	// buttons for the buttonbar (additional to OK and CANCEL)
	private static final int BUTTON_CHANGE_PRINTERDATA_ID = IDialogConstants.CLIENT_ID + 1;

	// initial values
	private Printer _printer;

	private double _dpiScale;

	// controls
	private DoubleFieldWithDropDown _widthScaleText;

	private DoubleFieldWithDropDown _heightScaleText;

	private Button _pixelScaleButton;

	private Button _dpiScaleButton;

	private Canvas _preview;

	private Composite _previewGroup;

	private DoubleField _leftMarginText;

	private DoubleField _topMarginText;

	private Button _centerButton;

	private Button _customScalingButton;

	private Button _bestFitButton;

	private Button _customSizeButton;

	private DoubleField _customWidthText;

	private DoubleField _customHeightText;

	private Label _numberOfPagesInfo;

	private Button _cmButton;

	private Button _inchesButton;

	private Button _aspectRatioButton;

	// temporary values
	private double _currentScale;

	private double _aspectRatio;

	private boolean _center = false;

	private boolean _inches = true;

	private boolean _aspectRatioOn = true;

	private int _sizeMode = SCALE_XY;

	/**
	 * Creates a new PrintFigureDialog.
	 * 
	 * @param shell
	 *            The Shell of this dialog.
	 * @param graphicalViewer
	 *            The GraphicalViewer, which to print.
	 * @param printer
	 *            The printer, to which to print
	 */
	public PrintFigureDialog(Shell shell, GraphicalViewer graphicalViewer, Printer printer) {
		super(shell, graphicalViewer);

		// call to initialize _image
		setScaledImage(1.0);

		_printer = printer;
		_dpiScale = ((double) _printer.getDPI().x) / ((double) Display.getCurrent().getDPI().x);
		_currentScale = _dpiScale;
		_aspectRatio = (double) _image.getBounds().width / _image.getBounds().height;
	}

	// ===================== overwritten methods ==============================

	@Override
	protected Control createButtonBar(Composite parent) {
		Composite bar = new Composite(parent, SWT.NONE);
		GridLayout grid = new GridLayout(0, true);
		grid.marginWidth = 20;
		bar.setLayout(grid);
		bar.setLayoutData(new GridData(GridData.FILL));

		Button changePrinter = super.createButton(bar, BUTTON_CHANGE_PRINTERDATA_ID, Messages.PrintFigureDialog_0_xfld, false);
		changePrinter.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
		grid.numColumns++;
		new Label(bar, SWT.NONE);

		createButton(bar, IDialogConstants.OK_ID, Messages.PrintFigureDialog_1_xfld, false);
		createButton(bar, IDialogConstants.CANCEL_ID, Messages.PrintFigureDialog_2_xfld, false);

		return bar;
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText(Messages.PrintFigureDialog_3_xfld);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		GridLayout layout = new GridLayout(2, false);
		layout.horizontalSpacing = 10;
		composite.setLayout(layout);

		Group figure = createChooseFigureGroup(composite);
		((GridData) figure.getLayoutData()).verticalAlignment = GridData.VERTICAL_ALIGN_BEGINNING;

		_previewGroup = createPreviewGroup(composite);
		createChooseSizeGroup(composite);
		createPositionGroup(composite);
		createUnitGroup(composite);

		aspectRatioOnChanged();

		updateControls();
		return composite;
	}

	@Override
	public void updateControls() {
		super.updateControls();

		_insideInternalModify = true;
		try {
			_widthScaleText.updateControl();
			_heightScaleText.updateControl();
			_customWidthText.updateControl();
			_customHeightText.updateControl();
			_leftMarginText.setEnabled(!_center && _sizeMode != SCALE_STRETCH);
			_topMarginText.setEnabled(!_center && _sizeMode != SCALE_STRETCH);
			_widthScaleText.setEnabled(_sizeMode == SCALE_XY);
			_heightScaleText.setEnabled(_sizeMode == SCALE_XY);
			_customWidthText.setEnabled(_sizeMode == CUSTOM_SIZE);
			_customHeightText.setEnabled(_sizeMode == CUSTOM_SIZE);
			_inchesButton.setEnabled((_sizeMode == CUSTOM_SIZE || !_center) && _sizeMode != SCALE_STRETCH);
			_cmButton.setEnabled((_sizeMode == CUSTOM_SIZE || !_center) && _sizeMode != SCALE_STRETCH);
			_preview.redraw();

		} finally {
			_insideInternalModify = false;
		}
	}

	public void paintControl(PaintEvent e) {
		Rectangle printRegion = getPrintRegion();
		org.eclipse.swt.graphics.Rectangle previewRegion = _preview.getClientArea();
		Point size = getScaledImageSize(printRegion, previewRegion);
		Point margins = determineMargins(printRegion, previewRegion, size.x, size.y);
		e.gc.drawImage(_image, 0, 0, _image.getBounds().width, _image.getBounds().height, margins.x, margins.y, size.x, size.y);
		e.gc.drawRectangle(margins.x, margins.y, size.x - 1, size.y - 1);
		adjustPrinterValuesUsingPreview(margins.x, margins.y, size.x, size.y, printRegion, previewRegion);
	}

	// ====================== private helper methods ==========================

	private void createUnitGroup(Composite composite) {
		Group unitGroup = new Group(composite, SWT.NONE);
		unitGroup.setText(Messages.PrintFigureDialog_4_xfld);
		GridData data = new GridData(GridData.GRAB_HORIZONTAL | GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL);
		data.horizontalSpan = 1;
		unitGroup.setLayoutData(data);
		GridLayout layout = new GridLayout(1, false);
		unitGroup.setLayout(layout);

		_cmButton = new Button(unitGroup, SWT.RADIO);
		_cmButton.setText(Messages.PrintFigureDialog_5_xfld);
		GridData data3 = new GridData(GridData.GRAB_HORIZONTAL | GridData.FILL_HORIZONTAL);
		_cmButton.setLayoutData(data3);
		_cmButton.addSelectionListener(this);

		_inchesButton = new Button(unitGroup, SWT.RADIO);
		_inchesButton.setText(Messages.PrintFigureDialog_6_xfld);
		GridData data2 = new GridData(GridData.GRAB_HORIZONTAL | GridData.FILL_HORIZONTAL);
		_inchesButton.setLayoutData(data2);
		_inchesButton.addSelectionListener(this);

		Label info = new Label(unitGroup, SWT.NONE);
		info.setText(Messages.PrintFigureDialog_7_xfld);
		info.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));

		// set defaults
		_cmButton.setSelection(false);
		_inchesButton.setSelection(true);

	}

	private Composite createPreviewGroup(Composite composite) {
		Composite previewGroup = new Composite(composite, SWT.NONE);
		previewGroup.setLayout(new GridLayout(1, false));
		GridData grid = new GridData();
		grid.verticalSpan = 3;
		previewGroup.setLayoutData(grid);

		Label previewLabel = new Label(previewGroup, SWT.NONE);
		previewLabel.setText(Messages.PrintFigureDialog_8_xfld + COLON);
		previewLabel.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));

		_preview = new Canvas(previewGroup, SWT.BORDER);
		GridData previewGrid = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);
		previewGrid.widthHint = PREVIEW_SIZE;
		previewGrid.heightHint = (int) (PREVIEW_SIZE * ((double) _printer.getClientArea().height / _printer.getClientArea().width));
		previewGrid.verticalSpan = 1;
		_preview.setLayoutData(previewGrid);
		_preview.setBackground(_preview.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		_preview.addPaintListener(this);

		_numberOfPagesInfo = new Label(previewGroup, SWT.NONE);
		_numberOfPagesInfo.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING | GridData.HORIZONTAL_ALIGN_END));
		refreshOutputPagesInfo();

		return previewGroup;
	}

	private void refreshOutputPagesInfo() {
		String text = MessageFormat.format(Messages.PrintFigureDialog_9_xmsg, new Object[] { getNumberOfPages() });
		_numberOfPagesInfo.setText(text);
	}

	private Group createChooseSizeGroup(Composite composite) {
		Group scaleGroup = new Group(composite, SWT.NONE);
		scaleGroup.setText(Messages.PrintFigureDialog_11_xfld);
		GridLayout layout = new GridLayout(3, false);
		scaleGroup.setLayout(layout);
		GridData data = new GridData(GridData.GRAB_HORIZONTAL | GridData.FILL_HORIZONTAL | GridData.FILL);
		scaleGroup.setLayoutData(data);

		_bestFitButton = new Button(scaleGroup, SWT.RADIO);
		_bestFitButton.addSelectionListener(this);
		Label bestFitText = new Label(scaleGroup, SWT.NONE);
		bestFitText.setText(Messages.PrintFigureDialog_12_xfld);
		new Label(scaleGroup, SWT.NONE);

		_customScalingButton = new Button(scaleGroup, SWT.RADIO);
		_customScalingButton.addSelectionListener(this);
		_customScalingButton.setSelection(true);
		Label widthComboText = new Label(scaleGroup, SWT.NONE);
		widthComboText.setText(Messages.PrintFigureDialog_14_xfld + ":             " + Messages.PrintFigureDialog_16_xfld + ": "); //$NON-NLS-1$ //$NON-NLS-2$
		widthComboText.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));
		_widthScaleText = new DoubleFieldWithDropDown(scaleGroup, SWT.NONE, _preferences, DefaultPrintPreferences.SCALE_FACTOR_X,
				SCALE_FACTORS);
		_widthScaleText.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.FILL_HORIZONTAL));
		_widthScaleText.addModifyListener(this);

		new Label(scaleGroup, SWT.NONE);
		Label heightComboText = new Label(scaleGroup, SWT.NONE);
		heightComboText.setText(Messages.PrintFigureDialog_20_xfld + ": "); //$NON-NLS-1$
		heightComboText.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));
		_heightScaleText = new DoubleFieldWithDropDown(scaleGroup, SWT.NONE, _preferences, DefaultPrintPreferences.SCALE_FACTOR_Y,
				SCALE_FACTORS);
		_heightScaleText.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.FILL_HORIZONTAL));
		_heightScaleText.addModifyListener(this);

		_customSizeButton = new Button(scaleGroup, SWT.RADIO);
		_customSizeButton.addSelectionListener(this);

		Label customWidthText = new Label(scaleGroup, SWT.NONE);
		customWidthText.setText(Messages.PrintFigureDialog_23_xfld + ":      " + Messages.PrintFigureDialog_26_xfld + ": "); //$NON-NLS-1$ //$NON-NLS-2$
		customWidthText.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));
		_customWidthText = new DoubleField(scaleGroup, SWT.NONE, _preferences, DefaultPrintPreferences.WIDTH);
		_customWidthText.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.FILL_HORIZONTAL));
		_customWidthText.addModifyListener(this);

		new Label(scaleGroup, SWT.NONE);
		Label customHeightText = new Label(scaleGroup, SWT.NONE);
		customHeightText.setText(Messages.PrintFigureDialog_28_xfld + ": "); //$NON-NLS-1$
		customHeightText.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));
		_customHeightText = new DoubleField(scaleGroup, SWT.NONE, _preferences, DefaultPrintPreferences.HEIGHT);
		_customHeightText.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.FILL_HORIZONTAL));
		_customHeightText.addModifyListener(this);

		_aspectRatioButton = new Button(scaleGroup, SWT.CHECK);
		_aspectRatioButton.addSelectionListener(this);
		_aspectRatioButton.setSelection(_aspectRatioOn);
		Label aspectRatioLabel = new Label(scaleGroup, SWT.NONE);
		aspectRatioLabel.setText(Messages.PrintFigureDialog_17_xfld);
		aspectRatioLabel.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));

		return scaleGroup;
	}

	private Group createPositionGroup(Composite parent) {
		Group posGroup = new Group(parent, SWT.NONE);
		posGroup.setText(Messages.PrintFigureDialog_18_xfld);
		GridData data = new GridData(GridData.GRAB_HORIZONTAL | GridData.FILL_HORIZONTAL);
		data.horizontalSpan = 1;
		posGroup.setLayoutData(data);
		GridLayout layout = new GridLayout(2, false);
		posGroup.setLayout(layout);

		Label leftMargin = new Label(posGroup, SWT.NONE);
		leftMargin.setText(Messages.PrintFigureDialog_30_xfld + ": "); //$NON-NLS-1$
		_leftMarginText = new DoubleField(posGroup, SWT.NONE, _preferences, DefaultPrintPreferences.LEFT_MARGIN);
		GridData data2 = new GridData(GridData.GRAB_HORIZONTAL | GridData.FILL_HORIZONTAL);
		_leftMarginText.setLayoutData(data2);
		_leftMarginText.addModifyListener(this);

		Label topMargin = new Label(posGroup, SWT.NONE);
		topMargin.setText(Messages.PrintFigureDialog_32_xfld + ": "); //$NON-NLS-1$
		_topMarginText = new DoubleField(posGroup, SWT.NONE, _preferences, DefaultPrintPreferences.TOP_MARGIN);
		GridData data3 = new GridData(GridData.GRAB_HORIZONTAL | GridData.FILL_HORIZONTAL);
		_topMarginText.setLayoutData(data3);
		_topMarginText.addModifyListener(this);

		Label centerLabel = new Label(posGroup, SWT.NONE);
		centerLabel.setText(Messages.PrintFigureDialog_34_xfld + ": "); //$NON-NLS-1$
		_centerButton = new Button(posGroup, SWT.CHECK);
		_centerButton.addSelectionListener(this);
		return posGroup;
	}

	/**
	 * This method is currently not used, since "normal" user would not need it.
	 */
	// private Group createChooseScaleGroup(Composite composite) {
	// Group dpiGroup = new Group(composite, SWT.NONE);
	// dpiGroup.setText("Scale");
	// GridLayout layout = new GridLayout(1, false);
	// dpiGroup.setLayout(layout);
	// GridData data = new GridData(GridData.GRAB_HORIZONTAL |
	// GridData.FILL_BOTH);
	// dpiGroup.setLayoutData(data);
	//
	// _pixelScaleButton = new Button(dpiGroup, SWT.RADIO);
	// _pixelScaleButton.setText("1 monitor pixel == 1 paper dot");
	// _pixelScaleButton.addSelectionListener(this);
	// _pixelScaleButton.setLayoutData(new GridData(GridData.FILL_VERTICAL));
	//
	// _dpiScaleButton = new Button(dpiGroup, SWT.RADIO);
	// _dpiScaleButton.setText("1 monitor inch == 1 paper inch");
	// _dpiScaleButton.addSelectionListener(this);
	// _dpiScaleButton.setLayoutData(new GridData(GridData.FILL_VERTICAL));
	//
	// // set defaults
	// _pixelScaleButton.setSelection(false);
	// _dpiScaleButton.setSelection(true);
	// _currentScale = _dpiScale;
	//
	// return dpiGroup;
	// }
	// ============================= eventing =================================
	@Override
	public void buttonPressed(int buttonID) {
		super.buttonPressed(buttonID);

		if (buttonID == BUTTON_CHANGE_PRINTERDATA_ID) {
			PrintDialog printDialog = new PrintDialog(this.getShell(), SWT.NONE);
			PrinterData printData = printDialog.open();
			if (!_printer.getPrinterData().equals(printData)) {
				_printer = new Printer(printData);
				// refresh preview
				((GridData) (_preview.getLayoutData())).widthHint = PREVIEW_SIZE;
				((GridData) (_preview.getLayoutData())).heightHint = (int) (PREVIEW_SIZE * ((double) _printer.getClientArea().height / _printer
						.getClientArea().width));
				_previewGroup.layout();
			}
		}
	}

	public void modifyText(ModifyEvent e) {
		if (_insideInternalModify) // avoid endless-loops
			return;

		if (_aspectRatioOn) {
			if (e.getSource() == _customWidthText.getText()) {
				double width = _preferences.getDoublePreference(DefaultPrintPreferences.WIDTH);
				_preferences.setDoublePreference(DefaultPrintPreferences.HEIGHT, width / _aspectRatio);
			}

			if (e.getSource() == _customHeightText.getText()) {
				//
				double height = _preferences.getDoublePreference(DefaultPrintPreferences.HEIGHT);
				_preferences.setDoublePreference(DefaultPrintPreferences.WIDTH, height * _aspectRatio);
			}

			if (e.getSource() == _heightScaleText.getText()) {
				if (_aspectRatioOn)
					_preferences.setDoublePreference(DefaultPrintPreferences.SCALE_FACTOR_X, _preferences
							.getDoublePreference(DefaultPrintPreferences.SCALE_FACTOR_Y));
			}

			if (e.getSource() == _widthScaleText.getText())
				_preferences.setDoublePreference(DefaultPrintPreferences.SCALE_FACTOR_Y, _preferences
						.getDoublePreference(DefaultPrintPreferences.SCALE_FACTOR_X));
		}
		updateControls();
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		super.widgetSelected(e);

		if (_insideInternalModify) // avoid endless-loops
			return;

		if (e.getSource() == _pixelScaleButton || e.getSource() == _dpiScaleButton) {
			_currentScale = _pixelScaleButton.getSelection() ? 1.0 : _dpiScale;
			_preferences.setDoublePreference(DefaultPrintPreferences.CURRENT_SCALE, _currentScale);
		}

		if (e.getSource() == _centerButton) {
			_center = _centerButton.getSelection();
		}

		if (e.getSource() == _customScalingButton) {
			_sizeMode = SCALE_XY;
		}

		if (e.getSource() == _bestFitButton) {
			if (_aspectRatioOn)
				_sizeMode = BEST_FIT;
			else
				_sizeMode = SCALE_STRETCH;
		}

		if (e.getSource() == _customSizeButton) {
			_sizeMode = CUSTOM_SIZE;
		}

		if (e.getSource() == _cmButton || e.getSource() == _inchesButton) {
			_inches = _inchesButton.getSelection();
		}

		if (e.getSource() == _aspectRatioButton) {
			aspectRatioOnChanged();
		}

		updateControls();
	}

	/**
	 * Pops up a warning if more than <code>WARNING_IF_MOREPAGES_THAN</code> pages are tp be printed and sets the scaled image for later
	 * retrieval for high quality printing.
	 */
	@Override
	protected void okPressed() {
		int numOfPages = getNumberOfPages();
		boolean proceed = true;
		if (numOfPages > WARNING_IF_MOREPAGES_THAN) {
			String pagesText = MessageFormat.format(Messages.PrintFigureDialog_10_xmsg, new Object[] { numOfPages });
			proceed = MessageDialog.openQuestion(this.getShell(), Messages.PrintFigureDialog_22_xfld, pagesText + " \n" //$NON-NLS-1$
					+ Messages.PrintFigureDialog_25_xfld);
		}

		if (proceed) {
			setScaledImage(getMaximumOfXYImageScaleFactors());
			super.okPressed();
		}
	}

	// =========================== public access ==============================

	public double getPrinterScaleFactor() {
		return _preferences.getDoublePreference(DefaultPrintPreferences.SCALE_FACTOR) * _currentScale;
	}

	/**
	 * Returns the printer preferences as given through this dialog.
	 * 
	 * @return The printer preferences as given through this dialog.
	 */
	public DefaultPreferences getPreferences() {
		return _preferences;
	}

	public double getCurrentScale() {
		return _currentScale;
	}

	public Printer getPrinter() {
		return _printer;
	}

	// ========================= private helper methods =======================

	private Rectangle getPrintRegion() {
		// here any PrintOperation can be used, because the print-region is
		// only dependent on the printer, and not on the image to print
		PrintFigureOperation operation = new PrintFigureOperation(_printer, _figure);
		Rectangle printRegion = operation.getPrintRegion();
		return printRegion;
	}

	/**
	 * Returns a point containing the size of the image for the preview.
	 * 
	 * @return A point containing the size of the image for the preview.
	 */
	private Point getScaledImageSize(Rectangle printRegion, org.eclipse.swt.graphics.Rectangle previewRegion) {

		int imageWidth = (int) ((double) _figure.getBounds().width / (double) printRegion.width * previewRegion.width);
		int imageHeight = (int) ((double) _figure.getBounds().height / (double) printRegion.height * previewRegion.height);

		if (_sizeMode == SCALE_XY)
			return new Point((int) (imageWidth * getPrinterScaleFactorX()), (int) (imageHeight * getPrinterScaleFactorY()));

		if (_sizeMode == BEST_FIT) {
			// compute best fit scalefactor
			double widthRatio = imageWidth * _currentScale / previewRegion.width;
			double heightRatio = imageHeight * _currentScale / previewRegion.height;
			if (widthRatio > heightRatio)
				return new Point(previewRegion.width, (int) (1 / widthRatio * imageHeight * _currentScale));
			else
				return new Point((int) (1 / heightRatio * imageWidth * _currentScale), previewRegion.height);
		}

		if (_sizeMode == SCALE_STRETCH) {
			return new Point(previewRegion.width, previewRegion.height);
		}

		if (_sizeMode == CUSTOM_SIZE) {
			// determine inches represented by preview
			org.eclipse.swt.graphics.Point printerDPI = _printer.getDPI();
			double widthInInches = (double) printRegion.width / printerDPI.x;
			double heightInInches = (double) printRegion.height / printerDPI.y;
			double width = _preferences.getDoublePreference(DefaultPrintPreferences.WIDTH);
			double height = _preferences.getDoublePreference(DefaultPrintPreferences.HEIGHT);
			width = previewRegion.width * (width / widthInInches);
			height = previewRegion.height * (height / heightInInches);

			if (_inches)
				return new Point((int) width, (int) height);
			else
				return new Point((int) (width / INCH_TO_CM_FACTOR), (int) (height / INCH_TO_CM_FACTOR));
		}

		// shouldn't happen
		throw new IllegalArgumentException(Messages.PrintFigureDialog_38_xfld + _sizeMode);
	}

	private double getPrinterScaleFactorX() {
		return _preferences.getDoublePreference(DefaultPrintPreferences.SCALE_FACTOR_X) * _currentScale;
	}

	private double getPrinterScaleFactorY() {
		return _preferences.getDoublePreference(DefaultPrintPreferences.SCALE_FACTOR_Y) * _currentScale;
	}

	/**
	 * determines margins depending on {@link _sizeMode} and {@link _center}.
	 * 
	 * @return Point containing left and top margins as x and y values.
	 */
	private Point determineMargins(Rectangle printRegion, org.eclipse.swt.graphics.Rectangle previewRegion, int imageWidthScaled,
			int imageHeightScaled) {
		int leftMargin;
		int topMargin;
		if (!_center && _sizeMode != SCALE_STRETCH) {
			double leftMarginPreference = _preferences.getDoublePreference(DefaultPrintPreferences.LEFT_MARGIN);
			double topMarginPreference = _preferences.getDoublePreference(DefaultPrintPreferences.TOP_MARGIN);
			leftMargin = (int) (leftMarginPreference * printRegion.width / previewRegion.width);
			topMargin = (int) (topMarginPreference * printRegion.height / previewRegion.height);
			// check if numbers represent inches or cm
			if (!_inches) {
				leftMargin = (int) (leftMargin / INCH_TO_CM_FACTOR);
				topMargin = (int) (topMargin / INCH_TO_CM_FACTOR);
			}
			return new Point(leftMargin, topMargin);
		} else if (_center && _sizeMode != SCALE_STRETCH) {
			leftMargin = (int) ((double) (previewRegion.width - imageWidthScaled) / 2);
			if (leftMargin < 0)
				leftMargin = 0;
			topMargin = (int) ((double) (previewRegion.height - imageHeightScaled) / 2);
			if (topMargin < 0)
				topMargin = 0;
			return new Point(leftMargin, topMargin);
		} else {
			leftMargin = 0;
			topMargin = 0;
			return new Point(leftMargin, topMargin);
		}
	}

	/**
	 * Transforms preview values into printer values and stores them in the DefaultPreferences.
	 */
	private void adjustPrinterValuesUsingPreview(int leftMargin, int topMargin, int imageWidthScaled, int imageHeightScaled,
			Rectangle printRegion, org.eclipse.swt.graphics.Rectangle previewRegion) {
		// conversion
		double printerImageWidth = (double) imageWidthScaled * (double) printRegion.width / previewRegion.width;
		double printerImageHeight = (double) imageHeightScaled * (double) printRegion.height / previewRegion.height;
		double printerLeftMargin = (double) leftMargin * (double) printRegion.width / previewRegion.width;
		double printerTopMargin = (double) topMargin * (double) printRegion.height / previewRegion.height;
		// storing
		_preferences.setDoublePreference(DefaultPrintPreferences.PRINTER_IMAGE_WIDTH, printerImageWidth);
		_preferences.setDoublePreference(DefaultPrintPreferences.PRINTER_IMAGE_HEIGHT, printerImageHeight);
		_preferences.setDoublePreference(DefaultPrintPreferences.PRINTER_LEFT_MARGIN, printerLeftMargin);
		_preferences.setDoublePreference(DefaultPrintPreferences.PRINTER_TOP_MARGIN, printerTopMargin);
		// as the printer values get updated, the number of pages may change
		refreshOutputPagesInfo();
	}

	/**
	 * @return The number of pages which the current preferences would produce on the printer.
	 */
	private int getNumberOfPages() {
		// determine pages to print
		double width = _preferences.getDoublePreference(DefaultPrintPreferences.PRINTER_IMAGE_WIDTH);
		double height = _preferences.getDoublePreference(DefaultPrintPreferences.PRINTER_IMAGE_HEIGHT);
		double left = _preferences.getDoublePreference(DefaultPrintPreferences.PRINTER_LEFT_MARGIN);
		double top = _preferences.getDoublePreference(DefaultPrintPreferences.PRINTER_TOP_MARGIN);
		width += left;
		height += top;
		Rectangle clientSize = getPrintRegion();
		int numberOfPages = ((int) Math.ceil(width / clientSize.width) * ((int) Math.ceil(height / clientSize.height)));
		return numberOfPages;

	}

	/**
	 * @return maximum of scale factor for x- and y-axis as stored in <code>_preferences</code>.
	 */
	public double getMaximumOfXYImageScaleFactors() {
		double width = _preferences.getDoublePreference(DefaultPrintPreferences.PRINTER_IMAGE_WIDTH);
		double height = _preferences.getDoublePreference(DefaultPrintPreferences.PRINTER_IMAGE_HEIGHT);

		double widthScale = width / _figure.getBounds().width;
		double heightScale = height / _figure.getBounds().height;
		return (widthScale > heightScale) ? widthScale : heightScale;
	}

	/**
	 * Updates the values, depending on the state of the aspect-ratio-on button.
	 */
	private void aspectRatioOnChanged() {
		_aspectRatioOn = _aspectRatioButton.getSelection();
		if (_aspectRatioOn) { // even update if _sizeMode != CUSTOM_SIZE,
			// because it is always visible
			// update preferences
			double width = _preferences.getDoublePreference(DefaultPrintPreferences.WIDTH);
			_preferences.setDoublePreference(DefaultPrintPreferences.HEIGHT, width / _aspectRatio);
		}
		if (_aspectRatioOn && _sizeMode == SCALE_STRETCH)
			_sizeMode = BEST_FIT;
		if (!_aspectRatioOn && _sizeMode == BEST_FIT)
			_sizeMode = SCALE_STRETCH;
		if (_aspectRatioOn && _sizeMode == SCALE_XY)
			_preferences.setDoublePreference(DefaultPrintPreferences.SCALE_FACTOR_Y, _preferences
					.getDoublePreference(DefaultPrintPreferences.SCALE_FACTOR_X));
	}
}

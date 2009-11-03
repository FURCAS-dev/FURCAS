package com.sap.mi.tools.cockpit.editor.ui.dialog.legend;

import java.text.MessageFormat;
import java.util.Hashtable;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.sap.mi.tools.cockpit.editor.MOINBrowser;
import com.sap.mi.tools.cockpit.editor.Messages;

public class LegendDialog extends Dialog {

	String title;

	Image dImage = MOINBrowser.getDefault().getImage(MOINBrowser.SHOW_LEGEND_IMAGE);

	ILegendGroup[] legendGroups;

	ILegendElement[] legendElements;

	private Composite composite;

	// Minimum dialog width (in dialog units)
	private static final int MIN_DIALOG_WIDTH = 450;

	// Minimum dialog height (in dialog units)
	private static final int MIN_DIALOG_HEIGHT = 250;

	private static final String LEGEND_DIALOG_LOCATION = "_LegendDialogLocation"; //$NON-NLS-1$

	private static final String LEGEND_DIALOG_SIZE = "_LegendHistoryDialogSize"; //$NON-NLS-1$

	private static Hashtable<String, Point> storeTable;;

	/**
	 * Constructs LegendDialog that contains groups of legend elements.
	 * 
	 * @param parentShell
	 *            parent-shell of the dialog.
	 * @param dialogTitle
	 *            The dialog title.
	 * @param legendGroups
	 *            array of legend groups containing the legend elements and title of the group
	 */
	public LegendDialog(Shell parentShell, String dialogTitle, ILegendGroup[] legendGroups) {

		super(parentShell);
		setShellStyle(SWT.MIN | SWT.TITLE | SWT.MAX | SWT.RESIZE | SWT.MODELESS);
		final String dialogPattern = Messages.LegendDialog_0_xhed;
		this.title = MessageFormat.format(dialogPattern, new Object[] { dialogTitle });
		this.legendGroups = legendGroups;
	}

	/**
	 * Constructs LegendDialog that contains array of legend elements.
	 * 
	 * @param parent
	 *            parent-shell of the dialog.
	 * @param dialogTitle
	 *            The dialog title.
	 * @param legendElements
	 *            array of legend elements
	 */
	public LegendDialog(Shell parent, String dialogTitle, ILegendElement[] legendElements) {

		super(parent);
		setShellStyle(SWT.MIN | SWT.TITLE | SWT.MAX | SWT.RESIZE | SWT.MODELESS);
		if (!validateInput(legendElements)){
			throw new IllegalArgumentException("Could not initialize LegendDialog because argument \'legendElements\' is <null>."); //$NON-NLS-1$
		}
		this.legendElements = legendElements;
		final String dialogPattern = Messages.LegendDialog_1_xhed;
		this.title = MessageFormat.format(dialogPattern, new Object[] { dialogTitle });
	}

	/**
	 * Convenient method to show dialog with legend elements(every element contains image and description).
	 * 
	 * @param dialogTitle
	 *            The dialog title
	 * @param legendElements
	 *            array of legend elements
	 */
	public static void showLegendDialog(String dialogTitle, ILegendElement[] legendElements) {

		final LegendDialog dialog = new LegendDialog(getUsableShell(), dialogTitle, legendElements);
		dialog.open();
	}

	/**
	 * Convenient method to show dialog with groups of legend elements(every group contains title and array of legend elements).
	 * 
	 * @param dialogTitle
	 *            The dialog title
	 * @param legendGroups
	 *            array of legend groups
	 */
	public static void showLegendDialog(String dialogTitle, ILegendGroup[] legendGroups) {

		final LegendDialog dialog = new LegendDialog(getUsableShell(), dialogTitle, legendGroups);
		dialog.open();
	}

	@Override
	protected void configureShell(Shell shell) {

		super.configureShell(shell);
		if (this.title != null)
			shell.setText(this.title);
		if (this.dImage != null)
			shell.setImage(this.dImage);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createDialogArea(Composite parent) {

		// IWidgetFactory factory = SapUI.getDefaultWidgetFactory();
		final Composite top = new Composite(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(top);

		if (this.legendElements != null) {
			addLegendElToPane(top, this.legendElements);
		} else if (this.legendGroups != null) {
			for (int i = 0; i < this.legendGroups.length; i++) {
				if (this.legendGroups[i] != null) {
					final Label title = createLabel(top, SWT.NONE, this.legendGroups[i].getLegendGroupName());
					GridDataFactory.fillDefaults().span(2, 1).applyTo(title);
					// Label title =
					// pane.addTextLabel(legendGroups[i].getLegendGroupName(),
					// pane.createGridLayoutData(
					// IGridLayoutAlignment.DEFAULT,
					// IGridLayoutAlignment.DEFAULT,
					// false,
					// false,
					// 2,
					// 1));
					title.setFont(JFaceResources.getBannerFont());
					// title.setBackground(colorWhite);
					addLegendElToPane(top, this.legendGroups[i].getLegendElements());

					final Label separator = new Label(top, SWT.SEPARATOR | SWT.HORIZONTAL);
					GridDataFactory.fillDefaults().span(2, 1).applyTo(separator);
					// pane.addPlaceholder();
				}
			}
		}

		GridLayoutFactory.swtDefaults().numColumns(2).equalWidth(false).generateLayout(top);

		setComposite(parent);
		return top;

		// GridLayoutPaneConfiguration config = new
		// GridLayoutPaneConfiguration();
		// config.setNumberOfColumns(2);
		// config.setScrollable(true);
		// config.setHorizontalSpacing(20);
		// config.setMargin(10,10);
		// config.setBorderFlag(true);
		// Color colorWhite = getShell().getDisplay().getSystemColor(
		// SWT.COLOR_LIST_BACKGROUND );
		// IGridLayoutPane pane = PaneFactory.createGridLayoutPane(parent,
		// config);
		// if (parent.getLayout() instanceof GridLayout) {
		// GridLayout gl = (GridLayout) parent.getLayout();
		// gl.marginWidth = 10;
		// gl.marginHeight = 10;
		// }
		// GridData gd = new GridData(GridData.FILL_BOTH);
		// pane.getOuterComposite().setLayoutData(gd);
		// pane.getPaneComposite().setBackground(colorWhite);
		// if (legendElements != null) {
		// addLegendElToPane(pane, legendElements);
		// } else if (legendGroups != null) {
		// for (int i = 0; i < legendGroups.length; i++) {
		// if (legendGroups[i] != null) {
		// Label title = pane.addTextLabel(legendGroups[i].getLegendGroupName(),
		// pane.createGridLayoutData(
		// IGridLayoutAlignment.DEFAULT,
		// IGridLayoutAlignment.DEFAULT,
		// false,
		// false,
		// 2,
		// 1));
		// title.setFont( JFaceResources.getBannerFont() );
		// title.setBackground(colorWhite);
		// addLegendElToPane(pane, legendGroups[i].getLegendElements());
		// pane.addPlaceholder();
		// }
		// }
		// }
		// pane.getPaneComposite().pack();
		// pane.getPaneComposite().layout();
		// pane.getOuterComposite().setSize(getInitialSize());
		// return pane.getOuterComposite();
	}

	/**
	 * Checks for null legend objects in the array passed
	 */
	private boolean validateInput(ILegendElement[] legends) {

		if (legends == null)
			return false;
		for (int i = 0; i < legends.length; i++) {
			if (legends[i] == null || legends[i].getDescription() == null || legends[i].getFigureImage() == null)
				return false;
		}
		return true;
	}

	@SuppressWarnings("unused")
	private void addLegendElToPane(Composite parent, ILegendElement[] elements) {

		// IWidgetFactory factory = SapUI.getDefaultWidgetFactory();
		for (int i = 0; i < elements.length; i++) {
			if (elements[i] != null) {
				final Label imageL = createLabel(parent, SWT.NONE, elements[i].getFigureImage());
				final Label descr = createLabel(parent, SWT.NONE, elements[i].getDescription());
			}
		}
	}

	// private void addLegendElToPane(IGridLayoutPane pane, ILegendElement[]
	// elements) {
	// Color colorWhite = getShell().getDisplay().getSystemColor(
	// SWT.COLOR_LIST_BACKGROUND );
	// for (int i = 0; i < elements.length; i++) {
	// if (elements[i] != null) {
	// Label imageL = pane.addImage(elements[i].getFigureImage());
	// imageL.setBackground(colorWhite);
	// Label descr = pane.addTextLabel(elements[i].getDescription());
	// descr.setBackground(colorWhite);
	// }
	// }
	// }

	/**
	 * @see org.eclipse.jface.dialogs.Dialog#createButtonsForButtonBar(Composite)
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {

		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.CLOSE_LABEL, true);
	}

	/**
	 * Persists the size and location of the dialog
	 * 
	 */
	private void persistShellGeometry() {

		if (LegendDialog.storeTable == null)
			LegendDialog.storeTable = new Hashtable<String, Point>();
		final Point shellLocation = getShell().getLocation();
		final Point shellSize = getShell().getSize();
		LegendDialog.storeTable.put(this.title + LegendDialog.LEGEND_DIALOG_LOCATION, shellLocation);
		LegendDialog.storeTable.put(this.title + LegendDialog.LEGEND_DIALOG_SIZE, shellSize);
	}

	/**
	 * 
	 * 
	 * 
	 * 
	 * @return the initial size of the dialog
	 */
	@Override
	protected Point getInitialSize() {

		if (LegendDialog.storeTable != null) {
			final Point point = LegendDialog.storeTable.get(this.title + LegendDialog.LEGEND_DIALOG_SIZE);
			if (point != null)
				return point;
		}
		//final Shell s = getShell();
		// if (s != null) {
		// s.addControlListener(new ControlListener() {
		// public void controlMoved(ControlEvent arg0) {
		// }
		// public void controlResized(ControlEvent arg0) {
		// //if (composite != null)
		// getComposite().layout(true);
		// }
		// });
		// }

		final Point shellSize = super.getInitialSize();
		return new Point(Math.max(convertHorizontalDLUsToPixels(LegendDialog.MIN_DIALOG_WIDTH), shellSize.x), Math.max(
				convertVerticalDLUsToPixels(LegendDialog.MIN_DIALOG_HEIGHT), shellSize.y));

	}

	/**
	 * Returns the initial location to use for the shell. The default implementation centers the shell horizontally (1/2 of the difference
	 * to the left and 1/2 to the right) and vertically (1/3 above and 2/3 below) relative to the parent shell, or display bounds if there
	 * is no parent shell.
	 * 
	 * @param initialSize
	 *            the initial size of the shell, as returned by <code>getInitialSize</code>.
	 * @return the initial location of the shell
	 */
	@Override
	protected Point getInitialLocation(Point initialSize) {

		if (LegendDialog.storeTable != null) {
			final Point point = LegendDialog.storeTable.get(this.title + LegendDialog.LEGEND_DIALOG_LOCATION);
			if (point != null)
				return point;
		}
		return super.getInitialLocation(initialSize);
	}

	/**
	 * Persist the geometry of the dialog
	 */
	@Override
	public boolean close() {

		persistShellGeometry();
		return super.close();
	}

	/**
	 * @return Returns the composite.
	 */
	public Composite getComposite() {

		return this.composite;
	}

	/**
	 * @param composite
	 *            The composite to set.
	 */
	public void setComposite(Composite composite) {

		this.composite = composite;
	}

	/**
	 * Convenience method to get the current shell.
	 * 
	 * @return the shell of the active workbench window (if there is one).
	 */
	public static Shell getUsableShell() {

		Shell sh = null;
		final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (window != null) {
			sh = window.getShell();
		}
		return sh;
	}

	public final Label createLabel(Composite parent, int style, String labelText) {

		final Label label = new Label(parent, style);
		label.setText(labelText);
		return label;
	}

	public final Label createLabel(Composite parent, int style, Image image) {

		final Label label = new Label(parent, style);
		label.setImage(image);
		return label;
	}
}
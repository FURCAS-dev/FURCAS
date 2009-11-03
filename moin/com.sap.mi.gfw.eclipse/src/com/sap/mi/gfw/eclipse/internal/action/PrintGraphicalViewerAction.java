package com.sap.mi.gfw.eclipse.internal.action;

import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.ui.actions.PrintAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.printing.Printer;
import org.eclipse.swt.printing.PrinterData;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;

import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.eclipse.internal.util.ui.print.PrintFigureDialog;
import com.sap.mi.gfw.eclipse.internal.util.ui.print.PrintFigureScaleableOperation;
import com.sap.mi.gfw.features.IPrintFeature;
import com.sap.mi.gfw.features.context.IPrintContext;
import com.sap.mi.gfw.features.context.impl.PrintContext;

/**
 * An Action, which is used to print the contents of the GraphicalViewer.
 * <p>
 * Additional to the usual printing behaviour (the dialog, where the printer can be selected), this Action also adds another dialog, where
 * the size and position of the graphics on the paper can be specified.
 * 
 * @see com.sap.mi.gfw.pf.eclipse.internal.action.IActionFactory#createPrintGraphicalViewerAction()
 */
public class PrintGraphicalViewerAction extends PrintAction {

	/**
	 * This static Action is just used as a template, to initialize the ID, label and image of instances of this class accordingly.
	 */
	private static IAction TEMPLATE_ACTION = ActionFactory.PRINT.create(PlatformUI.getWorkbench().getActiveWorkbenchWindow());

	private IConfigurationProvider _configurationProvider;

	private IPrintFeature printFeature;

	/**
	 * Creates a new PrintGraphicalViewerAction. It initializes it with the proper ID, label and image.
	 * 
	 * @param configurationProvider
	 *            The IConfigurationProvider.
	 * @param part
	 *            The WorkbenchPart (e.g. the editor), to which this Action belongs. From the WorkbenchPart the GraphicalViewer will be
	 *            determined.
	 */
	public PrintGraphicalViewerAction(IConfigurationProvider configurationProvider, IWorkbenchPart part, IPrintFeature printFeature) {
		super(part);
		this.printFeature = printFeature;
		_configurationProvider = configurationProvider;

		// set all values of the TEMPLATE_ACTION for this Action.
		setId(TEMPLATE_ACTION.getId());
		setText(TEMPLATE_ACTION.getText());
		setToolTipText(TEMPLATE_ACTION.getToolTipText());
		setDescription(TEMPLATE_ACTION.getDescription());
		setAccelerator(TEMPLATE_ACTION.getAccelerator());
		setHelpListener(TEMPLATE_ACTION.getHelpListener());
		setImageDescriptor(TEMPLATE_ACTION.getImageDescriptor());
		setHoverImageDescriptor(TEMPLATE_ACTION.getHoverImageDescriptor());
		setDisabledImageDescriptor(TEMPLATE_ACTION.getDisabledImageDescriptor());
	}

	public IConfigurationProvider getConfigurationProvider() {
		return _configurationProvider;
	}

	/**
	 * Same as super.calculateEnabled(), except that it also checks, if the current WorkbenchPart has a GraphicalViewer.
	 */
	@Override
	protected boolean calculateEnabled() {
		if (getWorkbenchPart().getAdapter(GraphicalViewer.class) == null)
			return false;
		return super.calculateEnabled();

		// TODO ask also feature for canPrint() ?
	}

	/**
	 * Prints the GraphicalViewer of the WorkbenchPart. It is the same as super.run(), except that it opens the PrintModeDialog before
	 * printing. In this dialog the size of the graphics (fit-width, fit-height, ...) can be specified.
	 */
	@Override
	public void run() {
		IPrintContext printContext = new PrintContext();
		printFeature.prePrint(printContext);

		Shell shell = new Shell();

		// get viewer
		GraphicalViewer viewer = (GraphicalViewer) getWorkbenchPart().getAdapter(GraphicalViewer.class);

		// create default PrinterData
		PrinterData printerData = new PrinterData();

		// open PrintFigureDialog
		PrintFigureDialog printImageDialog = new PrintFigureDialog(shell, viewer, new Printer(printerData));
		printImageDialog.open();
		if (printImageDialog.getReturnCode() != Window.CANCEL) {

			// start the printing
			PrintFigureScaleableOperation op = new PrintFigureScaleableOperation(printImageDialog.getPrinter(), printImageDialog
					.getFigure(), printImageDialog.getScaledImage(), printImageDialog.getPreferences());
			op.run(getWorkbenchPart().getTitle());
			printImageDialog.cleanUp();
		}

		printFeature.postPrint(printContext);
	}
}

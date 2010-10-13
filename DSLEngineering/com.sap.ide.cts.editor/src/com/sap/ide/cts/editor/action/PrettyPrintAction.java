package com.sap.ide.cts.editor.action;

import org.antlr.runtime.Lexer;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import com.sap.furcas.metamodel.TCS.ClassTemplate;
import com.sap.furcas.metamodel.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.furcas.metamodel.textblocks.TextblocksPackage;
import com.sap.ide.cts.dialogs.ChooseConcreteSyntaxDialog;
import com.sap.ide.cts.dialogs.ChoosePrettyPrintModeDialog;
import com.sap.ide.cts.dialogs.PrettyPrinterInfoDialog;
import com.sap.ide.cts.dialogs.PrettyPrintingModes;
import com.sap.ide.cts.editor.EditorUtil;
import com.sap.ide.cts.editor.prettyprint.CtsTextBlockIncrementalTCSExtractorStream;
import com.sap.ide.cts.editor.prettyprint.IncrementalPrettyPrinter;
import com.sap.ide.cts.editor.prettyprint.imported.TCSExtractorStream;
import com.sap.ide.cts.moin.parserfactory.AbstractParserFactory;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sun.corba.se.pept.transport.Connection;

/**
 *
 * @author Andreas Landerer
 * @version 1.0
 *
 */
public class PrettyPrintAction extends Action {

	private final EObject modelElement;
	private final EClass clazz;
	private final boolean openEditorAfterPrettyPrint;
	private IncrementalPrettyPrinter pp;

	public PrettyPrintAction(EClass clazz, EObject modelElement,
			boolean openEditorAfterPrettyPrint) {
		super("Pretty Print", PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_ETOOL_PRINT_EDIT));
		this.setDisabledImageDescriptor(PlatformUI.getWorkbench()
				.getSharedImages().getImageDescriptor(
						ISharedImages.IMG_ETOOL_PRINT_EDIT_DISABLED));
		this.setId("prettyPrint");
		this.clazz = clazz;
		this.modelElement = modelElement;
		this.openEditorAfterPrettyPrint = openEditorAfterPrettyPrint;
		this.pp = new IncrementalPrettyPrinter();
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public void runWithEvent(Event event) {
		try {
			Connection connection = modelElement.get___Connection();
			MQLProcessor mql = connection.getMQLProcessor();

			// select corresponding templates
			String mqlTemplates = "select template \n"
					+ "from \"demo.sap.com/tcsmeta\"#TCS::ClassTemplate as template, \n"
					+ "\"" + ((EObject) clazz).get___Mri()
					+ "\" as class \n" + "where template.metaReference = class";

			// select corresponding text blocks to model element
			String mqlTextBlocks = "select tb \n"
					+ "from \"demo.sap.com/tcsmeta\"#textblocks::TextBlock as tb, \n"
					+ "\"" + ((EObject) modelElement).get___Mri()
					+ "\" as me \n"
					+ "where tb.correspondingModelElements = me";

			MQLResultSet resultSet = mql.execute(mqlTemplates);
			EObject[] templates = resultSet.getRefObjects("template");
			resultSet = mql.execute(mqlTextBlocks);
			EObject[] rootTbs = resultSet.getRefObjects("tb");

			try {
				// Choose concrete syntax to print textblock
				ConcreteSyntax syntax = null;
				TCSExtractorStream stream = null;
				ClassTemplate template = null;
				if (templates.length > 1) {
					// search and choose main template
					for (Object o : templates) {
						if (o instanceof ClassTemplate
								&& ((ClassTemplate) o).isMain()) {
							template = (ClassTemplate) o;
							syntax = template.getConcreteSyntax();
						}
					}
					if (syntax == null) {
						ChooseConcreteSyntaxDialog dialog = new ChooseConcreteSyntaxDialog(
								templates);
						Object o = dialog.execute(null);
						if (o instanceof ClassTemplate) {
							template = (ClassTemplate) o;
							syntax = template.getConcreteSyntax();
						}
					}
				} else if (templates.length == 1) {
					if (templates[0] instanceof ClassTemplate) {
						template = (ClassTemplate) templates[0];
						syntax = template.getConcreteSyntax();
					}
				} else {
					throw new Exception(
							"No template found to print model element!");
				}

				boolean ppMode = false;
				ChoosePrettyPrintModeDialog ppmDialog = new ChoosePrettyPrintModeDialog();
				ppmDialog.open();
				PrettyPrintingModes mode = ppmDialog.getSelectedMode();
				if(mode == null)
				{
					mode = PrettyPrintingModes.PROGRESSIVE;
				}
				switch(mode)
				{
					case CONSERVATIVE:
					{
						ppMode = true;
					}
				}

				AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory =
				    EditorUtil.constructParserFactoryForSyntax(syntax);
				stream = new CtsTextBlockIncrementalTCSExtractorStream(
    					connection.getPackage(TextblocksPackage.PACKAGE_DESCRIPTOR),
    					modelElement.eResource(),
    					parserFactory, ppMode);

				// pretty print textblock
				this.pp.prettyPrint(rootTbs, modelElement, syntax, stream,
						template);
				if (this.pp.getRootBlock() != null) {
					connection.save();
					PrettyPrinterInfoDialog dialog = new PrettyPrinterInfoDialog(
							"Pretty Printer",
							"Pretty Printer finished successfully!");
					dialog.execute(null);
					if (this.openEditorAfterPrettyPrint) {
						ModelManagerUI.getEditorManager().openEditor(
								modelElement, null, null);
					}
				} else {
					PrettyPrinterInfoDialog dialog = new PrettyPrinterInfoDialog(
							"Pretty Printer",
							"Model Element was not pretty printed, please try superior model element!");
					dialog.execute(null);
				}
			} catch (Exception e) {
				connection.revert();
				e.printStackTrace();
				PrettyPrinterInfoDialog dialog = new PrettyPrinterInfoDialog(
						"Pretty Printer",
						"Pretty Printer failed with exception, see console!");
				dialog.execute(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public TextBlock getRootBlock() {
		return this.pp.getRootBlock();
	}
}
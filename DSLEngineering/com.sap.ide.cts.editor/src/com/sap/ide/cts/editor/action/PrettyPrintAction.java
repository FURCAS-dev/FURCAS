package com.sap.ide.cts.editor.action;

import org.antlr.runtime.Lexer;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import tcs.ClassTemplate;
import tcs.ConcreteSyntax;
import tcs.Template;
import textblocks.TextBlock;
import textblocks.TextblocksPackage;

import com.sap.ide.cts.dialogs.ChooseConcreteSyntaxDialog;
import com.sap.ide.cts.dialogs.PrettyPrinterInfoDialog;
import com.sap.ide.cts.editor.EditorUtil;
import com.sap.ide.cts.editor.prettyprint.textblocks.IncrementalTextBlockPrettyPrinter;
import com.sap.ide.cts.editor.prettyprint.textblocks.TextBlockTCSExtractorStream;
import com.sap.ide.cts.moin.parserfactory.AbstractParserFactory;
import com.sap.mi.fwk.ui.ModelManagerUI;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.mql.MQLResultSet;

/**
 * 
 * @author Andreas Landerer
 * @version 1.0
 * 
 */
public class PrettyPrintAction extends Action {

    private final RefObject modelElement;
    private final MofClass clazz;
    private final boolean openEditorAfterPrettyPrint;
    private TextBlock resultBlock;

    public PrettyPrintAction(MofClass clazz, RefObject modelElement, boolean openEditorAfterPrettyPrint) {
	super("Pretty Print", PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ETOOL_PRINT_EDIT));
	this.setDisabledImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
		.getImageDescriptor(ISharedImages.IMG_ETOOL_PRINT_EDIT_DISABLED));
	this.setId("prettyPrint");
	this.clazz = clazz;
	this.modelElement = modelElement;
	this.openEditorAfterPrettyPrint = openEditorAfterPrettyPrint;
    }

    @Override
    public void runWithEvent(Event event) {
	try {
	    Connection connection = modelElement.get___Connection();

	    Template template = determineTemplate(connection);
	    ConcreteSyntax syntax = template.getConcretesyntax();
	    TextBlock textBlockToReuse = determineTextBlockToReuse(connection, template);

	    try {
		AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory = EditorUtil
			.constructParserFactoryForSyntax(syntax);
		TextBlockTCSExtractorStream stream = new TextBlockTCSExtractorStream(
			connection.getPackage(TextblocksPackage.PACKAGE_DESCRIPTOR), modelElement.get___Partition(),
			parserFactory);

		IncrementalTextBlockPrettyPrinter prettyPrinter = new IncrementalTextBlockPrettyPrinter();
		prettyPrinter.prettyPrint(modelElement, textBlockToReuse, syntax, template, stream);
		resultBlock = stream.getPrintedResultRootBlock();
		if (resultBlock != null) {
		    connection.save();
		    PrettyPrinterInfoDialog dialog = new PrettyPrinterInfoDialog("Pretty Printer",
			    "Pretty Printer finished successfully!");
		    dialog.execute(null);
		    if (this.openEditorAfterPrettyPrint) {
			ModelManagerUI.getEditorManager().openEditor(modelElement, null, null);
		    }
		} else {
		    PrettyPrinterInfoDialog dialog = new PrettyPrinterInfoDialog("Pretty Printer",
			    "Model Element was not pretty printed, please try superior model element!");
		    dialog.execute(null);
		}
	    } catch (Exception e) {
		connection.revert();
		e.printStackTrace();
		PrettyPrinterInfoDialog dialog = new PrettyPrinterInfoDialog("Pretty Printer",
			"Pretty Printer failed with exception, see console!");
		dialog.execute(null);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public Template determineTemplate(Connection connection) throws Exception {
	MQLProcessor mql = connection.getMQLProcessor();
	Template template = null;

	// select corresponding templates
	String mqlTemplates = "select template \n" + "from \"demo.sap.com/tcsmeta\"#TCS::ClassTemplate as template, \n" + "\""
		+ ((Partitionable) clazz).get___Mri() + "\" as class \n" + "where template.metaReference = class";
	MQLResultSet resultSet = mql.execute(mqlTemplates);
	RefObject[] templates = resultSet.getRefObjects("template");

	if (templates.length > 1) {
	    // search and choose main template
	    for (Object o : templates) {
		if (o instanceof ClassTemplate && ((ClassTemplate) o).isMain()) {
		    template = (ClassTemplate) o;
		}
	    }
	    if (template == null || template.getConcretesyntax() == null) {
		ChooseConcreteSyntaxDialog dialog = new ChooseConcreteSyntaxDialog(templates);
		Object o = dialog.execute(null);
		if (o instanceof ClassTemplate) {
		    template = (ClassTemplate) o;
		}
	    }
	} else if (templates.length == 1) {
	    if (templates[0] instanceof ClassTemplate) {
		template = (ClassTemplate) templates[0];
	    }
	} else {
	    throw new Exception("No template found to print model element!");
	}
	return template;
    }

    public TextBlock determineTextBlockToReuse(Connection connection, Template template) {
	MQLProcessor mql = connection.getMQLProcessor();
	TextBlock oldTextBlock = null;

	// select corresponding text blocks to model element
	String mqlTextBlocks = "select tb \n" + "from \"demo.sap.com/tcsmeta\"#textblocks::TextBlock as tb, \n" + "\""
		+ ((Partitionable) modelElement).get___Mri() + "\" as me \n" + "where tb.correspondingModelElements = me";

	MQLResultSet resultSet = mql.execute(mqlTextBlocks);
	RefObject[] rootTbs = resultSet.getRefObjects("tb");

	for (RefObject o : rootTbs) {
	    if (o instanceof TextBlock) {
		oldTextBlock = (TextBlock) o;

		// if template has no syntax contribution, pretty printing is
		// currently not possible
		if (oldTextBlock.getType() == null || !template.equals(oldTextBlock.getType().getParseRule())) {
		    oldTextBlock = null;
		} else {
		    break;
		}
	    }
	}
	return oldTextBlock;
    }

    public TextBlock getRootBlock() {
	return resultBlock;
    }
}
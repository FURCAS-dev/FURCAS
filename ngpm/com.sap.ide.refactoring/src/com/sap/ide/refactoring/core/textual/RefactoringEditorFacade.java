package com.sap.ide.refactoring.core.textual;

import java.util.Collection;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Display;

import com.sap.furcas.metamodel.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.furcas.metamodel.textblocks.TextblocksPackage;
import com.sap.ide.cts.editor.AbstractGrammarBasedEditor;
import com.sap.ide.cts.editor.document.CtsDocument;
import com.sap.ide.cts.editor.prettyprint.CtsPrettyPrinter;
import com.sap.ide.cts.editor.prettyprint.CtsTextBlockTCSExtractorStream;
import com.sap.ide.cts.editor.prettyprint.SyntaxAndModelMismatchException;
import com.sap.ide.cts.parser.incremental.ParserFactory;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.mi.textual.grammar.impl.ParsingError;
import com.sap.mi.textual.textblocks.model.TextBlocksModel;
import com.sun.corba.se.pept.transport.Connection;

/**
 * This class is intended to shield the refactoring subsystem from the surrounding complexity
 * of the FURCAS editor environment.
 *
 * Once the requirements are clear this class should be splitted into some smaller classes
 * which only bear one responsibility.
 *
 * @author D049157
 */
public class RefactoringEditorFacade {

    protected AbstractGrammarBasedEditor editor;

    public RefactoringEditorFacade(AbstractGrammarBasedEditor editor) {
	this.editor = editor;
    }

    protected CtsDocument getDocument() {
	return (CtsDocument) editor.getDocumentProvider().getDocument(editor.getEditorInput());
    }

    public TextBlocksModel getTextBlocksModel() {
	return getDocument().getTextBlocksModelStore().getModel();
    }

    public RefObject getDecoratedDomainRootObject() {
	return (RefObject) getDocument().getRootObject();
    }

    public String getContentAsText() {
	return getTextBlocksModel().get(0, getTextBlocksModel().getLength());
    }

    public Connection getConnection() {
	return editor.getWorkingConnection();
    }

    /**
     * Refresh the editor with the (new) information available in the model.
     */
    public void refreshUI() {
	Display.getDefault().asyncExec(new Runnable() {
	    @Override
	    public void run() {
		getDocument().repairLineInformation();
		((Viewer) getSourceViewer()).refresh();
	    }
	});
    }

    ISourceViewer getSourceViewer() {
	return editor.getSourceViewerPublic();
    }

    public void prettyPrintShort(TextBlocksModel model) {
	model.doShortPrettyPrintToEditableVersion();
    }

    public void prettyPrintFull(TextBlocksModel model) throws SyntaxAndModelMismatchException {
	ConcreteSyntax syntax = model.getRoot().getType().getParseRule().getConcretesyntax();
	TextblocksPackage pkg = getConnection().getPackage(TextblocksPackage.PACKAGE_DESCRIPTOR);
	ModelPartition partition = model.getRoot().get___Partition();
	CtsTextBlockTCSExtractorStream stream = new CtsTextBlockTCSExtractorStream(pkg, partition, getParserFactory());

	CtsPrettyPrinter.prettyPrint(getDecoratedDomainRootObject(), syntax, stream, /* ClassTemplate template */ null,
		/* PrettyPrintContext context */ null);
	model.setRootTextBlock(stream.getRootBlock());
    }

    protected ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> getParserFactory() {
	return editor.getParserFactory();
    }

    public Collection<ParsingError> checkAndGetSyntacticalErrors(TextBlock block) {
	ObservableInjectingParser parser = createDryParser();
	return parser.checkSyntaxWithoutInjecting();
    }

    protected ObservableInjectingParser createDryParser() {
	Lexer lexer = getParserFactory().createLexer(new ANTLRStringStream(getTextBlocksModel().getRoot().getCachedString()));
	return getParserFactory().createParser(new CommonTokenStream(lexer), getConnection());
    }


}

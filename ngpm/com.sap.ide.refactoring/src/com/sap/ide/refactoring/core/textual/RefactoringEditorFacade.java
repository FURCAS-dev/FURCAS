package com.sap.ide.refactoring.core.textual;

import java.util.Collection;
import java.util.HashSet;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Display;

import textblocks.TextBlock;

import com.sap.ide.cts.editor.AbstractGrammarBasedEditor;
import com.sap.ide.cts.editor.document.CtsDocument;
import com.sap.ide.cts.parser.incremental.ParserFactory;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.mi.textual.grammar.impl.ParsingError;
import com.sap.mi.textual.textblocks.model.TextBlocksModel;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * This class is intended to shield the refactoring subsystem from the surrounding complexity
 * of the FURCAS editor environment.
 *
 * @author Stephan Erb (d049157)
 */
public class RefactoringEditorFacade {

    protected AbstractGrammarBasedEditor editor;
    private Collection<String> tokenNames;

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

    public Connection getEditorConnection() {
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

    protected ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> getParserFactory() {
	return editor.getParserFactory();
    }

    public Collection<ParsingError> checkAndGetSyntacticalErrors(TextBlock block) {
	ObservableInjectingParser parser = createDryParser();
	return parser.checkSyntaxWithoutInjecting();
    }
    
    /* package */Collection<String> getTokenNames() {
	if (tokenNames == null) {
	    tokenNames = new HashSet<String>();
	    for (String tokenName : createDryParser().getTokenNames()) {
		if (tokenName.startsWith("'") && tokenName.endsWith("'")) {
		    tokenNames.add(tokenName.substring(1, tokenName.length() - 1));
		}
	    }
	}
	return tokenNames;
    }

    protected ObservableInjectingParser createDryParser() {
	Lexer lexer = getParserFactory().createLexer(new ANTLRStringStream(getTextBlocksModel().getRoot().getCachedString()));
	return getParserFactory().createParser(new CommonTokenStream(lexer), getEditorConnection());
    }

    public void updateRootBlock(TextBlock postChangeRootBlock) {
	getTextBlocksModel().setRootTextBlock(postChangeRootBlock);
	getDocument().setRootBlock(postChangeRootBlock);
	editor.setModel(postChangeRootBlock);
    }

}

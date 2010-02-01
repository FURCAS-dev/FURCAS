package com.sap.ide.refactoring.core.textual;

import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.viewers.Viewer;

import tcs.ConcreteSyntax;
import textblocks.TextblocksPackage;

import com.sap.ide.cts.editor.AbstractGrammarBasedEditor;
import com.sap.ide.cts.editor.EditorUtil;
import com.sap.ide.cts.editor.document.CtsDocument;
import com.sap.ide.cts.editor.prettyprint.CtsPrettyPrinter;
import com.sap.ide.cts.editor.prettyprint.CtsTextBlockTCSExtractorStream;
import com.sap.ide.cts.editor.prettyprint.SyntaxAndModelMismatchException;
import com.sap.mi.textual.textblocks.model.TextBlocksModel;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class RefactoringEditorFacade {

    private final AbstractGrammarBasedEditor editor;

    public RefactoringEditorFacade(AbstractGrammarBasedEditor editor) {
	this.editor = editor;
    }

    private CtsDocument getDocument() {
	return (CtsDocument) editor.getDocumentProvider().getDocument(editor.getEditorInput());
    }

    // private IModelElementInvestigator getModelElementInvestigator() {
    // RefPackage metamodelPackage =
    // editor.getParserFactory().getMetamodelPackage(getConnection());
    // return new MOINModelAdapter(metamodelPackage, getConnection(), null,
    // null);
    // }

    public String getContentAsText() {
	return getDocument().get();
    }

    public TextBlocksModel getTextBlocksModel() {
	return getDocument().getTextBlocksModelStore().getModel();
    }

    public RefObject getDecoratedDomainRootObject() {
	return (RefObject) getDocument().getRootObject();
    }

    /**
     * Refresh the editor with the (new) information available in the model.
     */
    public void refreshUI() {
	getDocument().repairLineInformation();
	((Viewer) getSourceViewer()).refresh();
    }

    public ISourceViewer getSourceViewer() {
	return editor.getSourceViewerPublic();
    }

    public void prettyPrintShort(TextBlocksModel model) {
	model.doShortPrettyPrintToEditableVersion();
    }

    public void prettyPrintFull(TextBlocksModel model) throws SyntaxAndModelMismatchException {
	ConcreteSyntax syntax = EditorUtil.getActiveSyntax(editor);
	TextblocksPackage pkg = getConnection().getPackage(TextblocksPackage.PACKAGE_DESCRIPTOR);
	ModelPartition partition = model.getRoot().get___Partition();
	CtsTextBlockTCSExtractorStream stream = new CtsTextBlockTCSExtractorStream(pkg, partition, editor.getParserFactory());

	CtsPrettyPrinter.prettyPrint(getDecoratedDomainRootObject(), syntax, stream);
	model.setRootTextBlock(stream.getRootBlock());
    }

    public Connection getConnection() {
	return editor.getWorkingConnection();
    }

}

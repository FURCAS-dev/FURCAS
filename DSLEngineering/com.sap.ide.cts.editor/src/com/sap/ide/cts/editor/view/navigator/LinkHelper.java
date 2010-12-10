package com.sap.ide.cts.editor.view.navigator;

import java.util.Collection;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.navigator.ILinkHelper;
import org.eclipse.ui.texteditor.IDocumentProvider;

import com.sap.furcas.ide.editor.AbstractGrammarBasedEditor;
import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage;
import com.sap.furcas.runtime.textblocks.TbUtil;
import com.sap.ide.cts.editor.document.CtsDocument;

public class LinkHelper implements ILinkHelper {

    public static final String ANNOTATION_HIGHLIGHT_TYPE = "com.sap.ide.cts.editor.link_highlight";

    private final Map<AbstractGrammarBasedEditor, Annotation> editorsToAnnotation = new WeakHashMap<AbstractGrammarBasedEditor, Annotation>();

    @Override
    public void activateEditor(IWorkbenchPage page,
	    IStructuredSelection selection) {
	IEditorPart editor = page.getActiveEditor();
	if (editor != null && editor instanceof AbstractGrammarBasedEditor) {
	    AbstractGrammarBasedEditor ctsEditor = (AbstractGrammarBasedEditor) editor;
	    IAdaptable adaptedSelection = (IAdaptable) selection
		    .getFirstElement();
	    EObject ro = (EObject) adaptedSelection
		    .getAdapter(EObject.class);
	    if (ro != null) {
		Collection<DocumentNode> docNodes = (ro)
			.get___Connection().getPackage(
				TextblocksPackage.PACKAGE_DESCRIPTOR)
			.getDocumentNodeReferencesCorrespondingModelElement()
			.getDocumentNode(ro);
		IDocumentProvider documentProvider = ctsEditor
			.getDocumentProvider();
		IEditorInput editorInput = ctsEditor.getEditorInput();
		CtsDocument doc = (CtsDocument) documentProvider
			.getDocument(editorInput);
		boolean found = false;
		if (doc.isCompletelyItitialized()) {
		    for (DocumentNode documentNode : docNodes) {
			TextBlock parentBlock = null;
			if (documentNode instanceof AbstractToken) {
			    parentBlock = ((AbstractToken) documentNode)
				    .getParent();
			} else {
			    parentBlock = (TextBlock) documentNode;
			}
			if (TbUtil
				.isAncestorOf(doc.getRootBlock(), parentBlock)) {
			    found = true;
			    int absoluteOffsetTok = TbUtil
				    .getAbsoluteOffsetWithoutBlanks(parentBlock);
			    int length = TbUtil
				    .getLengthWithoutStartingBlanks(parentBlock);
			    Annotation a = editorsToAnnotation.get(ctsEditor);
			    if (a == null) {
				a = new Annotation(ANNOTATION_HIGHLIGHT_TYPE,
					false, "Selection from tree");
				editorsToAnnotation.put(ctsEditor, a);
			    } else {
				documentProvider
					.getAnnotationModel(editorInput)
					.removeAnnotation(a);
			    }
			    Position pos = new Position(absoluteOffsetTok,
				    length);
			    documentProvider.getAnnotationModel(editorInput)
				    .addAnnotation(a, pos);
			    // ((AbstractGrammarBasedEditor)editor).selectAndReveal();
			}

		    }
		    if (!found) {
			Annotation a = editorsToAnnotation.get(ctsEditor);
			if (a != null) {
			    documentProvider.getAnnotationModel(editorInput)
				    .removeAnnotation(a);
			}
		    }
		    selection.getFirstElement();
		}
	    }
	}
    }

    @Override
    public IStructuredSelection findSelection(IEditorInput anInput) {
	if (anInput instanceof ModelEditorInput) {
	    ModelEditorInput mei = (ModelEditorInput) anInput;
	    return new StructuredSelection(mei.getRefObject());
	}
	return null;
    }

}

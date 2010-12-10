package com.sap.ide.cts.editor;

import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.part.EditorActionBarContributor;

import com.sap.furcas.ide.editor.AbstractGrammarBasedEditor;

public class AbstractGrammarBasedEditorActionBarContributor extends	EditorActionBarContributor {
	
//	CreateTestCaseAction action;
	
	@Override
	public void setActiveEditor(IEditorPart targetEditor) {
		assert targetEditor instanceof AbstractGrammarBasedEditor;
		
//		// Get the document the active editor is currently editing
//		IDocumentProvider provider = ((AbstractGrammarBasedEditor) targetEditor).getDocumentProvider();
//		CtsDocument document = (CtsDocument) provider.getDocument(targetEditor.getEditorInput());
//	
//		// Setup
//		action.initializeWithDocument(document);
//		action.setEnabled(document instanceof CtsHistoryDocument &&
//				((CtsHistoryDocument) document).hasActiveDocumentHistory());
	}

	@Override
	public void contributeToToolBar(IToolBarManager toolBarManager) {
		// JUnit Test Case create button
//		action = new CreateTestCaseAction();
//		toolBarManager.add(action);
	}



}

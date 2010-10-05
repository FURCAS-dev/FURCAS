package com.sap.ide.cts.editor.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.Saveable;
import org.eclipse.ui.internal.Workbench;
import org.junit.After;
import org.junit.Before;

import tcs.ClassTemplate;
import tcs.ConcreteSyntax;

import com.sap.furcas.textual.tcs.TcsUtil;
import com.sap.ide.cts.editor.AbstractGrammarBasedEditor;
import com.sap.ide.cts.editor.EditorUtil;
import com.sap.ide.cts.editor.document.CtsDocument;
import com.sap.ide.cts.editor.test.util.FixtureBasedTest;
import com.sap.mi.fwk.ui.ModelManagerUI;
import com.sap.mi.textual.parsing.textblocks.reference.GlobalDelayedReferenceResolver;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;


/**
 * Base class for editor integration tests
 *
 */
@SuppressWarnings("restriction")
public class CtsEditorTest extends FixtureBasedTest {

	public interface EditorRunnable {
		void runEditAction(IDocument document) throws BadLocationException;
	}

	@Before
	public void init() {
	    Workbench wb = Workbench.getInstance();
	    wb.getIntroManager().closeIntro(wb.getIntroManager().getIntro());
	}

	@After
	public void cleanup() {
	    GlobalDelayedReferenceResolver.getInstance().clearUnresolvedIAReferences();
	}



	public static List<String> list(String... entries) {
		ArrayList<String> list = new ArrayList<String>();
		if (entries != null) {
			for (int i = 0; i < entries.length; i++) {
				String entry = entries[i];
				list.add(entry);
			}
		}
		return list;
	}

	protected AbstractGrammarBasedEditor openEditor(RefObject refObject) {
		try {
		    AbstractGrammarBasedEditor editor = (AbstractGrammarBasedEditor) ModelManagerUI
		    		.getEditorManager().openEditor(refObject, null, null);
		    assertNotNull(editor);
		    return editor;
		} catch (PartInitException e) {
		    fail(e.getMessage());
		}
		return null;
	}

	protected void saveAll(AbstractGrammarBasedEditor editor) throws CoreException {
		for (Saveable s : editor.getSaveables()) {
		    s.doSave(new NullProgressMonitor());
		}

		GlobalDelayedReferenceResolver.getInstance().resolveReferences(new NullProgressMonitor());
		// when the above command has returns, we know that the reference resolver has finished running
		if(!GlobalDelayedReferenceResolver.getInstance().hasEmptyQueue()) {
		    fail("There are still delayed reference that were not re-evaluated.");
		}
	}

	protected void close(AbstractGrammarBasedEditor editor) {
		editor.close(false);
	}

	protected CtsDocument getDocument(AbstractGrammarBasedEditor editor) {
		CtsDocument document = (CtsDocument) editor.getDocumentProvider().getDocument(editor.getEditorInput());
		if (!document.isCompletelyItitialized()) {
			ConcreteSyntax syntax = EditorUtil.getActiveSyntax(editor);
			ClassTemplate rootTemplate = TcsUtil.getMainClassTemplate(syntax);
			document.completeInit(syntax, rootTemplate, editor.getParserFactory(), editor.getRecoveryStrategy(),editor.getParser(), new NullProgressMonitor());
		}

		if(document.getRootBlock().getType() == null || document.getRootBlock().getType().getParseRule() == null) {
		    fail("Fixture model not correctly initialized check consistency of mapping model and fixture model!");
		}
		return document;
	}

	protected void failOnError(AbstractGrammarBasedEditor editor) {
	    if(editor.getDocumentProvider() != null) {
		IAnnotationModel annotations = editor.getDocumentProvider()
				.getAnnotationModel(editor.getEditorInput());

		for (Iterator<?> it = annotations.getAnnotationIterator(); it.hasNext();) {
			Annotation a = (Annotation) it.next();
			if (a.getType().equals(AbstractGrammarBasedEditor.ERROR_TYPE)) {
				fail(a.getText());
			}
		}
	    }
	}

}
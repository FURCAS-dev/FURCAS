package com.sap.ide.refactoring.test;

import java.util.ArrayList;
import java.util.Collection;

import org.antlr.runtime.Lexer;

import textblocks.DocumentNode;
import textblocks.TextBlock;
import textblocks.TextblocksPackage;

import com.sap.ap.cts.monet.parser.ClassParserFactory;
import com.sap.ide.cts.editor.AbstractGrammarBasedEditor;
import com.sap.ide.cts.editor.test.CtsEditorTest;
import com.sap.ide.cts.parser.incremental.ParserFactory;
import com.sap.ide.refactoring.core.textual.RefactoringEditorFacade;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.mi.textual.parsing.textblocks.TbUtil;
import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.mql.MQLResultSet;

import data.classes.SapClass;

/**
 * Base class for refactoring tests.
 *
 * @author D049157
 *
 */
public class RefactoringBaseTest extends CtsEditorTest {

    protected boolean isIntegrationTest;
    private Collection<AbstractGrammarBasedEditor> openedEditors;

    public RefactoringBaseTest() {
	isIntegrationTest = false;
	memoryChangesOnly = true;
    }

    @Override
    public void init() {
	if (isIntegrationTest) {
	    openedEditors = new ArrayList<AbstractGrammarBasedEditor>();
	    super.init();
	}
    }

    @Override
    public void cleanup() {
	if (isIntegrationTest) {
	    connection.revert();
	    for (AbstractGrammarBasedEditor editor : openedEditors) {
		editor.close(/*save*/ false);
	    }
	    super.cleanup();
	}
    }

    public RefactoringEditorFacade createEditorFacadeForRunletClass(String className) {
	if (isIntegrationTest) {
	    SapClass clazz = findRunletClass(className);
	    AbstractGrammarBasedEditor editor = openEditor(clazz);
	    openedEditors.add(editor);
	    getDocument(editor);
	    return new RefactoringEditorFacade(editor);
	} else {
	    SapClass clazz = findRunletClass(className);

	    TextblocksPackage tbPackage = connection.getPackage(TextblocksPackage.PACKAGE_DESCRIPTOR);
	    Collection<DocumentNode> nodes = tbPackage.getDocumentNodeReferencesCorrespondingModelElement().getDocumentNode(clazz);

	    // TODO: refactor and reuse CtsDocument initialisation logic.
	    assert nodes.size() == 1 : "Assumed that we dont have overlapping views.";
	    TextBlock rootBlock = (TextBlock) TbUtil.getNewestVersion(nodes.iterator().next());
	    ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory = new ClassParserFactory();

	    return new RefactoringEditorFacadeStub(clazz, rootBlock, parserFactory);
	}
    }

    public SapClass findRunletClass(String classname) {
	MQLProcessor mql = connection.getMQLProcessor();
	MQLResultSet queryResult = mql.execute(
		"select c from data::classes::SapClass as c where for c(name='" + classname + "')", mql.getQueryScopeProvider(
		/* scopeInclusive */false, /* partitionScope */
		null, (String[]) null));
	SapClass clazz = (SapClass) queryResult.getRefObjects("c")[0];
	return clazz;
    }

}

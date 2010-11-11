package com.sap.ide.refactoring.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.antlr.runtime.Lexer;

import tcs.ConcreteSyntax;
import tcs.Template;
import textblocks.DocumentNode;
import textblocks.TextBlock;

import com.sap.ap.cts.monet.parser.ClassParserFactory;
import com.sap.ide.cts.editor.AbstractGrammarBasedEditor;
import com.sap.ide.cts.editor.test.CtsEditorTest;
import com.sap.ide.cts.parser.incremental.ParserFactory;
import com.sap.ide.refactoring.core.textual.RefactoringEditorFacade;
import com.sap.ide.refactoring.core.textual.TextBlockRefactoringUtil;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.mi.textual.parsing.textblocks.TbUtil;
import com.sap.tc.moin.repository.Connection;
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
	    for (AbstractGrammarBasedEditor editor : openedEditors) {
		close(editor);
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
	    Collection<DocumentNode> nodes = TextBlockRefactoringUtil.findCorrespondingTextBlocks(clazz, "Class");

	    // TODO: refactor and reuse CtsDocument initialisation logic.
	    nodes = filterForClasses(nodes);
	    if (nodes.size() != 1) {
		System.err.println("Assumed that we dont have overlapping views on " + className + ", but there are " + nodes.size() + " potential rootblocks.");
	    }
	    DocumentNode lastPotentialRootBlock = nodes.iterator().next();
	    TextBlock rootBlock = (TextBlock) TbUtil.getNewestVersion(lastPotentialRootBlock);
	    ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory = new ClassParserFactory();

	    return new RefactoringEditorFacadeStub(clazz, rootBlock, parserFactory);
	}
    }

    /**
     * Crude hack to workaround the existance of other views and other syntaxes...
     * @return 
     */
    private Collection<DocumentNode> filterForClasses(Collection<DocumentNode> nodes) {
	nodes = new ArrayList<DocumentNode>(nodes);
	Iterator<DocumentNode> iter = nodes.iterator();
	while (iter.hasNext()) {
	    boolean valid = true;
	    DocumentNode node = iter.next();
	    if (node instanceof TextBlock) {
		TextBlock block = (TextBlock) node;
		if (block.getType() == null) {
		    valid = false;
		}
		Template template = ((TextBlock) node).getType().getParseRule();
		ConcreteSyntax syntax = template.getConcretesyntax();
		if (!syntax.getName().equals("Class")) {
		    valid = false;
		}

	    } else {
		valid = false;
	    }
	    if (!valid) {
		iter.remove();
	    }
	}
	return nodes;
    }
    
    public SapClass findRunletClassUsingConnection(String classname, Connection connection) {
	MQLProcessor mql = connection.getMQLProcessor();
	MQLResultSet queryResult = mql.execute(
		"select c from data::classes::SapClass as c where for c(name='" + classname + "')", mql.getQueryScopeProvider(
		/* scopeInclusive */false, /* partitionScope */
		null, (String[]) null));
	SapClass clazz = (SapClass) queryResult.getRefObjects("c")[0];
	return clazz;
    }

    public SapClass findRunletClass(String classname) {
	return findRunletClassUsingConnection(classname, connection);
    }

}

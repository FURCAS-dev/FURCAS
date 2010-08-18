package com.sap.ide.refactoring.test;

import java.util.Collection;

import org.antlr.runtime.Lexer;

import com.sap.ap.cts.monet.parser.ClassParserFactory;
import com.sap.furcas.metamodel.textblocks.DocumentNode;
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.furcas.metamodel.textblocks.TextblocksPackage;
import com.sap.ide.cts.editor.test.util.FixtureBasedTest;
import com.sap.ide.cts.parser.incremental.ParserFactory;
import com.sap.ide.refactoring.core.textual.RefactoringEditorFacade;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;

/**
 * Base class for refactoring tests which don't need a UI.
 * 
 * @author D049157
 * 
 */
public class RefactoringBaseTest extends FixtureBasedTest {

    public RefactoringBaseTest() {
	memoryChangesOnly = true;
    }
   
    public RefactoringEditorFacade createEditorFacadeForRunletClass(String className) {
	SapClass clazz = findRunletClass(className);

	TextblocksPackage tbPackage = connection.getPackage(TextblocksPackage.PACKAGE_DESCRIPTOR);
	Collection<DocumentNode> nodes = tbPackage.getDocumentNodeReferencesCorrespondingModelElement().getDocumentNode(clazz);

	// TODO: refactor and reuse CtsDocument initialisation logic.
	assert nodes.size() == 1 : "Assumed that we dont have overlapping views.";
	TextBlock rootBlock = (TextBlock) nodes.iterator().next();
	ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory = new ClassParserFactory();

	return new RefactoringEditorFacadeStub(clazz, rootBlock, parserFactory);
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

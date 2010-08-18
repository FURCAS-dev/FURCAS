package com.sap.ide.refactoring.test;

import org.antlr.runtime.Lexer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.ide.cts.parser.incremental.ParserFactory;
import com.sap.ide.refactoring.core.textual.RefactoringEditorFacade;
import com.sap.mi.textual.grammar.IModelElementInvestigator;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.mi.textual.textblocks.model.TextBlocksModel;

/**
 * Version of the RefactoringEditorFacade which can work without a running
 * editor and is therefore suited for tests which do not need a UI.
 *
 * @author D049157
 *
 */
public class RefactoringEditorFacadeStub extends RefactoringEditorFacade {

    private ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory;
    private EObject rootObject;
    private TextBlock rootBlock;

    private TextBlocksModel textBlocksModel;

    public RefactoringEditorFacadeStub(EObject rootObject, TextBlock rootBlock,
	    ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory) {
	super(null);
	assert rootBlock != null : "rootBock must not be null";
	assert rootObject != null : "rootObject must not be null";
	this.parserFactory = parserFactory;
	this.rootObject = rootObject;
	this.rootBlock = rootBlock;

	this.textBlocksModel = new TextBlocksModel(rootBlock, getModelElementInvestigator());

    }

    private IModelElementInvestigator getModelElementInvestigator() {
	EPackage metamodelPackage = parserFactory.getMetamodelPackage(getConnection());
	return new MOINModelAdapter(metamodelPackage, getConnection(), null, null);
    }


    @Override
    public ResourceSet getConnection() {
	return this.rootBlock.get___Connection();
    }

    @Override
    public EObject getDecoratedDomainRootObject() {
	return rootObject;
    }

    @Override
    public TextBlocksModel getTextBlocksModel() {
	return textBlocksModel;
    }


    @Override
    protected ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> getParserFactory() {
	return parserFactory;
    }

    @Override
    public void refreshUI() {
	// do nothing
    }

}

package com.sap.ide.refactoring.test;

import org.antlr.runtime.Lexer;

import textblocks.TextBlock;

import com.sap.ide.cts.parser.incremental.ParserFactory;
import com.sap.ide.refactoring.core.textual.RefactoringEditorFacade;
import com.sap.mi.textual.grammar.IModelElementInvestigator;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.mi.textual.textblocks.model.TextBlocksModel;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.textual.moinadapter.adapter.MOINModelAdapter;

/**
 * Version of the RefactoringEditorFacade which can work without a running
 * editor and is therefore suited for tests which do not need a UI.
 *
 * @author D049157
 *
 */
public class RefactoringEditorFacadeStub extends RefactoringEditorFacade {

    private final ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory;
    private final RefObject rootObject;
    private TextBlock rootBlock;

    private final TextBlocksModel textBlocksModel;

    public RefactoringEditorFacadeStub(RefObject rootObject, TextBlock rootBlock,
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
	RefPackage metamodelPackage = parserFactory.getMetamodelPackage(getEditorConnection());
	return new MOINModelAdapter(metamodelPackage, getEditorConnection(), null, null);
    }


    @Override
    public Connection getEditorConnection() {
	return this.rootBlock.get___Connection();
    }

    @Override
    public RefObject getDecoratedDomainRootObject() {
	return rootObject;
    }

    @Override
    public TextBlocksModel getTextBlocksModel() {
	return textBlocksModel;
    }

    @Override
    public ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> getParserFactory() {
	return parserFactory;
    }

    @Override
    public void refreshUI() {
	// do nothing
    }
    
    @Override
    public void updateRootBlock(TextBlock postChangeRootBlock) {
	textBlocksModel.setRootTextBlock(postChangeRootBlock);
	rootBlock = postChangeRootBlock;
    }

}

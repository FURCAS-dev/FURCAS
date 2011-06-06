package com.sap.furcas.ide.editor.contentassist.parsinghandler;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.sap.furcas.ide.editor.contentassist.CtsContentAssistParsingHandler;
import com.sap.furcas.ide.editor.contentassist.TestCtsContentAssistParsingHandler;
import com.sap.furcas.ide.editor.contentassist.modeladapter.StubModelAdapter;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.parser.tcs.TCSParserFactory;
import com.sap.furcas.runtime.parser.IModelAdapter;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.exceptions.InvalidParserImplementationException;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;
import com.sap.furcas.runtime.parser.impl.DelegationParsingObserver;
import com.sap.furcas.runtime.parser.testbase.GeneratedParserBasedTest;
import com.sap.furcas.runtime.parser.textblocks.TextBlocksAwareModelAdapter;

public abstract class CtsContentAssistParsingHandlerTestBase extends GeneratedParserBasedTest {

    protected static CtsContentAssistParsingHandler observer;

    protected void observeFixture(String path) throws InvalidParserImplementationException, IOException, UnknownProductionRuleException {

        TCSParserFactory factory = new TCSParserFactory();

        ParserFacade facade = new ParserFacade(factory.getParserClass(), factory.getLexerClass(), factory.getLanguageId());
        InputStream in = TestCtsContentAssistParsingHandler.class.getResourceAsStream(path + ".dsl");

        IModelAdapter modelHandler = new TextBlocksAwareModelAdapter(new StubModelAdapter());

        ResourceSet resourceSet = new ResourceSetImpl();
        ConcreteSyntax syntax = (ConcreteSyntax) resourceSet.getEObject(URI.createURI(factory.getSyntaxUUID()), /*load*/true);

        // use delegator to monitor exceptions
        DelegationParsingObserver delegator = new DelegationParsingObserver();
        observer = new CtsContentAssistParsingHandler(syntax, resourceSet);
        delegator.addParsingObserver(observer);

        facade.parseProductionRule(in, modelHandler, null, null, delegator);
    }
}

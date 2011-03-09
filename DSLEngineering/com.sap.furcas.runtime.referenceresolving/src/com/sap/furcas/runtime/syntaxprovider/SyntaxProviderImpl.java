package com.sap.furcas.runtime.syntaxprovider;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;

import com.sap.emf.ocl.trigger.TriggerManager;
import com.sap.furcas.ide.parserfactory.AbstractParserFactory;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.runtime.referenceresolving.SyntaxRegistry;

public class SyntaxProviderImpl implements SyntaxProvider {
    private ConcreteSyntax syntax;
    private Resource syntaxResource;
    private final AbstractParserFactory<?, ?> parserFactory;
    private TriggerManager triggerManager;
    private final OppositeEndFinder oppositeEndFinder;
    
    public SyntaxProviderImpl(AbstractParserFactory<?, ?> parserFactory, OppositeEndFinder oppositeEndFinder) {
        super();
        this.parserFactory = parserFactory;
        this.oppositeEndFinder = oppositeEndFinder;
    }

    @Override
    public synchronized TriggerManager getTriggerManager(SyntaxRegistry syntaxRegistry) throws ParserException, IOException {
        if (triggerManager == null) {
            triggerManager = syntaxRegistry.getTriggerManagerForSyntax(getSyntax(null),
                    oppositeEndFinder, /* monitor */ null, parserFactory);
        }
        return triggerManager;
    }

    @Override
    public synchronized ConcreteSyntax getSyntax(ResourceSet loadSyntaxIn) throws IOException, ParserException {
        if (syntax == null && syntaxResource == null) {
            URI syntaxUri = parserFactory.getSyntaxUri();
            if (syntaxUri != null) {
                if (loadSyntaxIn == null) {
                    loadSyntaxIn = new ResourceSetImpl();
                }
                syntaxResource = loadSyntaxIn.createResource(syntaxUri);
                syntaxResource.load(/* options */null);
                for (EObject e : syntaxResource.getContents()) {
                    if (e instanceof ConcreteSyntax) {
                        syntax = (ConcreteSyntax) syntaxResource.getContents().iterator().next();
                        break;
                    }
                }
            }
        }
        return syntax;
    }

}

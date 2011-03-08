package com.sap.furcas.runtime.syntaxprovider;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
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
    private ResourceSet resourceSet;
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
    public synchronized ResourceSet getResourceSet() throws ParserException, IOException {
        if (resourceSet == null) {
            resourceSet = new ResourceSetImpl();
            triggerManager = SyntaxRegistry.getInstance().getTriggerManagerForSyntax(getSyntax(),
                    EPackage.Registry.INSTANCE, oppositeEndFinder, /* monitor */ null, parserFactory);
            triggerManager.addToObservedResourceSets(resourceSet);
        }
        return resourceSet;
    }

    @Override
    public synchronized ConcreteSyntax getSyntax() throws IOException, ParserException {
        if (syntax == null && syntaxResource == null) {
            URI syntaxUri = parserFactory.getSyntaxUri();
            if (syntaxUri != null) {
                syntaxResource = getResourceSet().createResource(syntaxUri);
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

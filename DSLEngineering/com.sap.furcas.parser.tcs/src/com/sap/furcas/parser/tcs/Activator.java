package com.sap.furcas.parser.tcs;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.runtime.referenceresolving.SyntaxRegistry;
import com.sap.furcas.runtime.syntaxprovider.SyntaxProvider;
import com.sap.furcas.runtime.syntaxprovider.SyntaxProviderImpl;

public class Activator implements BundleActivator, SyntaxProvider {
    
    private static Activator instance;
    private static SyntaxProvider delegate;
    
    /**
     * When a FURCAS language bundle is started, it registers itself with the
     * reference resolving {@link Activator}.
     */
    @Override
    public void start(BundleContext context) throws Exception {
        instance = this;
        delegate = new SyntaxProviderImpl(new TCSParserFactory());
    }

    @Override
    public void stop(BundleContext context) throws Exception {
    }
    
    public static Activator getDefault() {
        return instance;
    }

    @Override
    public ConcreteSyntax getSyntax() {
        return delegate.getSyntax();
    }

    @Override
    public void registerForIncrementalEvaluation(SyntaxRegistry registry) {
        delegate.registerForIncrementalEvaluation(registry);
    }
}

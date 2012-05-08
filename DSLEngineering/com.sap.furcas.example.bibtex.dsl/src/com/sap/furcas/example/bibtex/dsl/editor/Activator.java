package com.sap.furcas.example.bibtex.dsl.editor;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.sap.furcas.example.bibtex.dsl.parser.BibtexAuthorViewParserFactory;
import com.sap.furcas.example.bibtex.dsl.parser.BibtexLibraryViewParserFactory;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.runtime.referenceresolving.SyntaxRegistry;
import com.sap.furcas.runtime.syntaxprovider.SyntaxProvider;
import com.sap.furcas.runtime.syntaxprovider.SyntaxProviderImpl;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin implements SyntaxProvider {
    private final SyntaxProvider delegate;

    public static final String PLUGIN_ID = "Bibtex.dsl"; //NON-NLS-1
    private static Activator plugin;

    public Activator() {
    	// FIXME SyntaxProviderImpl does not support more than one syntax
    	// per project?
        delegate = new SyntaxProviderImpl(new BibtexLibraryViewParserFactory(),
                DefaultOppositeEndFinder.getInstance());
    }

    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);
    }

    public static Activator getDefault() {
        return plugin;
    }

    @Override
    public TriggerManager getTriggerManager(SyntaxRegistry syntaxRegistry) throws ParserException, IOException {
        return delegate.getTriggerManager(syntaxRegistry);
    }

    @Override
    public ConcreteSyntax getSyntax(ResourceSet loadSyntaxIn) throws IOException, ParserException {
        return delegate.getSyntax(loadSyntaxIn);
    }

}

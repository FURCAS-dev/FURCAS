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
public class Activator implements BundleActivator, SyntaxProvider {
    
    private static SyntaxProvider libraryViewSyntaxProvider;
    private static SyntaxProvider authorViewSyntaxProvider;

    public static final String PLUGIN_ID = "Bibtex.dsl"; //NON-NLS-1
    private static Activator plugin;

    @Override
    public void start(BundleContext context) throws Exception {
        plugin = this;
        libraryViewSyntaxProvider = new SyntaxProviderImpl(new BibtexLibraryViewParserFactory());
        authorViewSyntaxProvider = new SyntaxProviderImpl(new BibtexAuthorViewParserFactory());
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        plugin = null;
    }

    public static Activator getDefault() {
        return plugin;
    }
    
    @Override
    public ConcreteSyntax getSyntax() {
        throw new RuntimeException("Call delegates directly!");
    }

    @Override
    public void registerForIncrementalEvaluation(SyntaxRegistry registry) {
        getLibraryViewSyntaxProvider().registerForIncrementalEvaluation(registry);
        getAuthorViewSyntaxProvider().registerForIncrementalEvaluation(registry);
    }

    public SyntaxProvider getAuthorViewSyntaxProvider() {
        return authorViewSyntaxProvider;
    }

    public SyntaxProvider getLibraryViewSyntaxProvider() {
        return libraryViewSyntaxProvider;
    }

}

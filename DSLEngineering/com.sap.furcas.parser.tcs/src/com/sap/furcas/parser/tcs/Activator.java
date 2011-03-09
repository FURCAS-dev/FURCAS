package com.sap.furcas.parser.tcs;

import org.eclipse.ocl.ecore.opposites.DefaultOppositeEndFinder;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.sap.furcas.parser.tcs.stable.TCSParserFactory;
import com.sap.furcas.runtime.referenceresolving.SyntaxRegistry;
import com.sap.furcas.runtime.syntaxprovider.SyntaxProviderImpl;

public class Activator extends SyntaxProviderImpl implements BundleActivator {
    private static Activator instance;
    
    public Activator() {
        super(new TCSParserFactory(), DefaultOppositeEndFinder.getInstance());
    }

    /**
     * When a FURCAS language bundle is started, it registers itself with the
     * reference resolving {@link SyntaxRegistry}.
     */
    @Override
    public void start(BundleContext context) throws Exception {
        instance = this;
    }

    @Override
    public void stop(BundleContext context) throws Exception {
    }
    
    public static Activator getDefault() {
        if (instance == null) {
            // non-OSGi mode?
            instance = new Activator();
        }
        return instance;
    }
}

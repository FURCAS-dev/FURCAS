package com.sap.furcas.runtime.referenceresolving;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EPackage;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.sap.emf.bundlelistener.EcorePackageLoadListener;
import com.sap.emf.ocl.trigger.TriggerManager;
import com.sap.furcas.runtime.syntaxprovider.SyntaxProvider;

/** 
 * This class implements the com.sap.emf.bundlelistener extension point <code>emf_bundle_listener</code>,
 * implementing the {@link EcorePackageLoadListener} interface. As such, it receives update notifications whenever an
 * Ecore package's bundle is started for a package that is registered with the Ecore <code>generated_package</code>
 * extension point. These packages end up in the {@link EPackage.Registry#INSTANCE default package registry}.<p>
 * 
 * @author Axel Uhl (d043530)
 */
public class Activator implements BundleActivator, EcorePackageLoadListener {
    private static Logger log = Logger.getLogger("SyntaxRegistry");
    
    private static final String EXTENSION_POINT_ID = "furcas_syntax";
    private static final String METAMODEL_PROPERTY_NAME = "metamodel";
    
    /**
     * The values are the extensions specifying as the "provider_class" attribute the fully-qualified
     * class name of the {@link SyntaxProvider} class.
     */
    private Map<String, Set<IConfigurationElement>> metamodelNsURIToSyntaxProviders;

    private static Activator instance;
    private SyntaxRegistry registry;
        
    /**
     * Load all SyntaxProvider Implementations. 
     */
    @Override
    public void start(BundleContext context) throws Exception {
        instance = this;
        registry = new SyntaxRegistry();
        metamodelNsURIToSyntaxProviders = new HashMap<String, Set<IConfigurationElement>>();
        
        for (IConfigurationElement listenerConfig : Platform.getExtensionRegistry().getConfigurationElementsFor(
                context.getBundle().getSymbolicName()+"."+EXTENSION_POINT_ID)) {
            for (IConfigurationElement metamodelElement : listenerConfig.getChildren(METAMODEL_PROPERTY_NAME)) {
                
                String metamodelURI = metamodelElement.getAttribute("nsURI");
                Set<IConfigurationElement> syntaxProviders = metamodelNsURIToSyntaxProviders.get(metamodelURI);
                if (syntaxProviders == null) {
                    syntaxProviders = new HashSet<IConfigurationElement>();
                    metamodelNsURIToSyntaxProviders.put(metamodelURI, syntaxProviders);
                }
                syntaxProviders.add(listenerConfig);
            }
        }
    }

    @Override
    public void stop(BundleContext context) throws Exception {
    }

    SyntaxRegistry getSyntaxRegistry() {
        return registry;
    }

    /**
     * If syntaxes are registered for the Ecore package identified by <code>nsURI</code> then those syntaxes'
     * {@link SyntaxProvider providers} are fetched, their syntaxes are retrieved and their {@link TriggerManager}s
     * constructed.
     * <p>
     * 
     * By means of synchronization, concurrently registering all already loaded packages won't run out of synch.
     */
    @Override
    public synchronized void packageLoaded(String nsURI) {
        Set<IConfigurationElement> syntaxProviderConfigs = metamodelNsURIToSyntaxProviders.get(nsURI);
        if (syntaxProviderConfigs != null) {
            for (IConfigurationElement syntaxProviderConfig : syntaxProviderConfigs) {
                try {
                    SyntaxProvider syntaxProvider = (SyntaxProvider) syntaxProviderConfig.createExecutableExtension("provider_class");
                    syntaxProvider.registerForIncrementalEvaluation(registry);
                } catch (Exception e) {
                    log.throwing(Activator.class.getName(), "packageLoaded", e);
                }
            }
        }
    }

    public static Activator getDefault() {
        return instance;
    }
    

    
}

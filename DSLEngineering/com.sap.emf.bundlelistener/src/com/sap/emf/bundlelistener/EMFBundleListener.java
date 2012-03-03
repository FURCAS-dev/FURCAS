package com.sap.emf.bundlelistener;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.ContributorFactoryOSGi;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.BundleListener;

public class EMFBundleListener extends Plugin implements BundleListener {
    
    private static final String PLUGIN_ID = "com.sap.emf.bundlelistener";
    private static final String EXTENSION_POINT_ID = "emf_bundle_listener";
    private static final String EXTENSION_CLASS_PROPERTY_NAME = "classname";
    private static EMFBundleListener instance;
    private static BundleContext context;
    
    private Collection<EcorePackageLoadListener> listeners;
    
    static BundleContext getContext() {
        return context;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start(BundleContext bundleContext) throws Exception {
        EMFBundleListener.context = bundleContext;
        instance = this;
        bundleContext.addBundleListener(this);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        EMFBundleListener.context = null;
    }

    /**
     * Returns a started instance of this bundle's activator or <code>null</code> in case
     * we're not running in an OSGi environment.
     * 
     * @return May return <code>null</code>, e.g., in case this class runs outside of an OSGi environment
     */
    public static EMFBundleListener getDefault() {
        return instance;
    }

    @Override
    public void bundleChanged(BundleEvent event) {
        if (event.getType() == BundleEvent.STARTED) {
            Collection<String> contributedPackageURIs = getContributedEcorePackageURIs(event.getBundle());
            if (listeners == null && !contributedPackageURIs.isEmpty()) {
                listeners = loadListeners(context);
            }
            for (String nsURI : contributedPackageURIs) {
                for (EcorePackageLoadListener listener : listeners) {
                    listener.packageLoaded(URI.createURI(nsURI));
                }
            }
        }
    }
    

    /**
     * @return a non-<code>null</code> collection
     */
    private Collection<String> getContributedEcorePackageURIs(Bundle bundle) {
        Set<String> packageURIs = new HashSet<String>();
        addGeneratedPackageNames(bundle, packageURIs);
        return packageURIs;
    }

    private void addGeneratedPackageNames(Bundle bundle, Set<String> packageURIs) {
        IExtensionRegistry registry = Platform.getExtensionRegistry();
        IContributor contributor = ContributorFactoryOSGi.createContributor(bundle);
        IExtension[] extensions = registry.getExtensions(contributor);
        if (extensions != null) {
            for (IExtension extension : extensions) {
                if ("org.eclipse.emf.ecore.generated_package".equals(extension.getExtensionPointUniqueIdentifier())) {
                    IConfigurationElement[] configurationElements = extension.getConfigurationElements();
                    for (IConfigurationElement configurationElement : configurationElements) {
                        packageURIs.add(configurationElement.getAttribute("uri"));
                    }
                }
            }
        }
    }

    /**
     * Retrieve all listeners (and as a side-effect, force their bundles to load) 
     */
    private static Collection<EcorePackageLoadListener> loadListeners(BundleContext bundleContext) {
        Collection<EcorePackageLoadListener> listeners = new HashSet<EcorePackageLoadListener>();
        IExtensionRegistry registry = Platform.getExtensionRegistry();
        for (IConfigurationElement listenerConfig : registry.getConfigurationElementsFor(bundleContext.getBundle()
                .getSymbolicName() + "." + EXTENSION_POINT_ID)) {
            try {
                EcorePackageLoadListener listener = (EcorePackageLoadListener) listenerConfig
                        .createExecutableExtension(EXTENSION_CLASS_PROPERTY_NAME);
                listeners.add(listener);
            } catch (CoreException e) {
                getDefault().getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, IStatus.OK,
                        "Failed to load EcorePackageLoadListeners", e));
            }
        }
        return listeners;
    }
    
}

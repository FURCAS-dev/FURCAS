package com.sap.mi.textual.parsing.textblocks.reference;

import java.util.Collection;
import java.util.EventListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.xml.stream.EventFilter;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.runtime.common.interfaces.IRuleName;
import com.sap.furcas.runtime.parser.impl.DelayedReference;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;


public class GlobalDelayedReferenceResolver implements GlobalEventListener {
    static final String TEMPORARY_QUERY_PARAM_REPLACEMENT = "__TEMP__";

    private final Set<ReferenceResolvingListener> listeners = new HashSet<ReferenceResolvingListener>(1);
    private IncrementalReferenceEvaluationRegistry registry;

    private ReferenceResolver resolver;
    private static GlobalDelayedReferenceResolver instance;

    public GlobalDelayedReferenceResolver() {
	// Do the assignment here as the constructor will be invoked by the
	// extension point.
	instance = this;
    }

    public static synchronized GlobalDelayedReferenceResolver getInstance() {
	return instance;
    }

    @Override
    public Map<EventFilter, Map<ListenerType, EventListener>> getFilters(ResourceSet connection, BundleContext bundleContext) {
	BundleContext context = bundleContext;
	ServiceReference globalEventListenerRegistryRef = context
		.getServiceReference(GlobalEventListenerRegistry.class.getName());
	HashMap<EventFilter, Map<ListenerType, EventListener>> result = new HashMap<EventFilter, Map<ListenerType, EventListener>>();
	// addFilterAndListenerForDeleteEvent(connection, result);

	setupResolverInfrastructure(context, globalEventListenerRegistryRef);

	return result;
    }

    private void setupResolverInfrastructure(BundleContext context, ServiceReference globalEventListenerRegistryRef) {
	assert registry == null && resolver == null;
	registry = new IncrementalReferenceEvaluationRegistry(globalEventListenerRegistryRef, context);
	resolver = new ReferenceResolver(this, registry);
	registry.setResolver(resolver);
    }

    /**
     * Registers a new {@link ReferenceResolvingListener} that gets notified on
     * registration as well as resolving of {@link DelayedReference delayed
     * references}.
     *
     * @param listener
     *            The listener to be registered.
     */
    public void addReferenceResolvingListener(ReferenceResolvingListener listener) {
	listeners.add(listener);
    }

    /**
     * Unregisters a {@link ReferenceResolvingListener} that gets notified on
     * registration as well as resolving of {@link DelayedReference delayed
     * references}.
     *
     * @param listener
     *            The listener to be unregistered.
     */
    public void removeReferenceResolvingListener(ReferenceResolvingListener listener) {
	listeners.remove(listener);
    }

    void notifyReferenceResolvingListenerReferenceResolved(DelayedReference ref) {
	for (ReferenceResolvingListener listener : listeners) {
	    listener.referenceResolved(ref);
	}
    }

    void notifyReferenceResolvingListenerReferencesRemoved(Collection<DelayedReference> refs) {
	for (ReferenceResolvingListener listener : listeners) {
	    listener.outdatedReferencesRemoved(refs);
	}
    }

    public void registerReferenceForIncrementalEvaluation(ConcreteSyntax syntax, ResourceSet connection,
	    EPackage outermostPackageOfMetamodel, ObservableInjectingParser parser, IRuleName ruleNameBuilder,
	    IProgressMonitor monitor) {
	registry.registerReferenceForIncrementalEvaluation(syntax, connection, outermostPackageOfMetamodel, parser,
		ruleNameBuilder, monitor);
    }

    public String getDebugInfoAsCsv(ResourceSet connection) {
	return registry.getDebugInfo(connection);
    }

    public boolean hasEmptyQueue() {
	return resolver.hasEmptyQueue();
    }

    public void resolveReferences(IProgressMonitor monitor) {
	resolver.resolveReferences(monitor);
    }

    public void clearUnresolvedIAReferences() {
	resolver.clearUnresolvedReferences();
    }

}

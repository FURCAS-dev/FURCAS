package com.sap.mi.textual.parsing.textblocks.reference;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import tcs.ConcreteSyntax;

import com.sap.mi.textual.common.interfaces.IRuleName;
import com.sap.mi.textual.grammar.impl.DelayedReference;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.tc.moin.globalmodellistener.GlobalEventListener;
import com.sap.tc.moin.globalmodellistener.GlobalEventListenerRegistry;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.events.EventListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

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
    public Map<EventFilter, Map<ListenerType, EventListener>> getFilters(Connection connection, BundleContext bundleContext) {
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

    public void registerReferenceForIncrementalEvaluation(ConcreteSyntax syntax, Connection connection,
	    RefPackage outermostPackageOfMetamodel, ObservableInjectingParser parser, IRuleName ruleNameBuilder,
	    IProgressMonitor monitor) {
	registry.registerReferenceForIncrementalEvaluation(syntax, connection, outermostPackageOfMetamodel, parser,
		ruleNameBuilder, monitor);
    }

    public String getDebugInfoAsCsv(Connection connection) {
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

    void notifyReferenceUnset(DelayedReference reference, Object valueRemovedFromProperty) {
	for (ReferenceResolvingListener listener : listeners) {
	    listener.outdatedReferencesRemoved(reference, valueRemovedFromProperty);
	}
    }

    void notifyReferenceSet(DelayedReference reference, Object valueSetOnProperty) {
	for (ReferenceResolvingListener listener : listeners) {
	    listener.referenceResolved(reference, valueSetOnProperty);
	}
    }

}

package com.sap.furcas.runtime.referenceresolving;

import java.util.Collection;
import java.util.Map;
import java.util.WeakHashMap;

import javax.xml.stream.EventFilter;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ParserException;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;
import com.sap.emf.ocl.trigger.TriggerManager;
import com.sap.emf.ocl.trigger.TriggerManagerFactory;
import com.sap.furcas.metamodel.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.TCS.FilterPArg;
import com.sap.furcas.metamodel.TCS.ForeachPredicatePropertyInit;
import com.sap.furcas.metamodel.TCS.InjectorAction;
import com.sap.furcas.metamodel.TCS.LookupPropertyInit;
import com.sap.furcas.metamodel.TCS.Property;
import com.sap.furcas.metamodel.TCS.QueryPArg;
import com.sap.furcas.metamodel.TCS.Template;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.interfaces.IRuleName;
import com.sap.furcas.runtime.common.util.ContextAndForeachHelper;
import com.sap.furcas.runtime.parser.impl.DelayedReference;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.tcs.TcsUtil;

public class SyntaxRegistry implements BundleActivator {
    private static SyntaxRegistry instance;
    private final WeakHashMap<ConcreteSyntax, TriggerManager> triggerManagersForSyntax;
    
    public SyntaxRegistry() {
        triggerManagersForSyntax = new WeakHashMap<ConcreteSyntax, TriggerManager>();
    }
    
    @Override
    public void start(BundleContext context) throws Exception {
        instance = this;
    }

    @Override
    public void stop(BundleContext context) throws Exception {
    }

    public static SyntaxRegistry getInstance() {
        if (instance == null) {
            // Probably not running in an OSGi environment...
            instance = new SyntaxRegistry();
        }
        return instance;
    }

    /**
     * Registers a concrete syntax with all the OCL expressions it contains, producing or fetching
     * from a cache a {@link TriggerManager}
     */
    public TriggerManager getTriggerManagerForSyntax(ConcreteSyntax syntax, ObservableInjectingParser parser,
            OppositeEndFinder oppositeEndFinder, IRuleName ruleNameBuilder, IProgressMonitor monitor) throws ParserException {
        TriggerManager triggerManager = triggerManagersForSyntax.get(syntax);
        if (triggerManager == null) {
            triggerManager = TriggerManagerFactory.INSTANCE.createTriggerManager(oppositeEndFinder);
            triggerManagersForSyntax.put(syntax, triggerManager);
            fillTriggerManagerForSyntax(triggerManager, syntax, parser, oppositeEndFinder, ruleNameBuilder, monitor);
        }
        return triggerManager;
    }

    private void fillTriggerManagerForSyntax(TriggerManager triggerManager, ConcreteSyntax syntax, ObservableInjectingParser parser,
            OppositeEndFinder oppositeEndFinder, IRuleName ruleNameBuilder, IProgressMonitor monitor) throws ParserException {
        // fetch all InjectorAction and Property elements from the syntax
        Collection<InjectorAction> injectorActions = getInjectorActions(syntax);
        Collection<Property> propertyInits = getPropertyInits(syntax);
        monitor.beginTask("Registering OCL expressions for Impact Analysis for syntax: " + syntax.getName(),
                injectorActions.size()+ propertyInits.size());
        monitor.subTask("PropertyInits");
        for (InjectorAction injectorAction : injectorActions) {
            monitor.worked(1);
            if (injectorAction.getInjectorActionsBlock().getParentTemplate().getMetaReference() == null) {
                throw new RuntimeException("Cannot resolve reference to metamodel for template:\n"
                        + injectorAction.getInjectorActionsBlock().getParentTemplate() + "\n"
                        + "Make sure the metamodel is correctly referenced and loaded.");
            }
            if (injectorAction instanceof LookupPropertyInit) {
                triggerManager.register(new SimplePropertyInitUpdater((LookupPropertyInit) injectorAction, oppositeEndFinder));
            } else if (injectorAction instanceof ForeachPredicatePropertyInit) {
                registerForEachPropertyInitForIA(injectorAction, syntax, triggerManager, ruleNameBuilder);
            }
        }
        monitor.subTask("Property Queries");
        for (Property propertyInit : propertyInits) {
            monitor.worked(1);
            registerPropertyQueryForIA(propertyInit, syntax);
        }
        monitor.done(); // TODO was commented in original; why?
    }

    private void registerPropertyQueryForIA(Property propertyInit, ConcreteSyntax syntax) {
        Template template = propertyInit.getParentTemplate();
        if (template != null && template.getMetaReference() instanceof EClass) {
            // TODO what about DataTypes?
            QueryPArg qarg = TcsUtil.getQueryPArg(propertyInit);
            // TODO still needed? if not, delete
            // RefersToParg refersToArg = TcsUtil.getRefersToParg(property);
            FilterPArg filter = TcsUtil.getFilterPArg(propertyInit);
            if (qarg != null) {
                String query = qarg.getQuery();
                if (filter != null) {
                    query += filter.getFilter();
                }
                RefObject parsingContext = ContextAndForeachHelper.getParsingContext(connection, query, template,
                        packagesForLookup, elementClass);
                DelayedReference ref = new DelayedReference(null, null, null, property.getPropertyReference().getStrucfeature()
                        .getName(), null, null, query, false, null);
                query = MoinHelper.prepareOclQuery(query, GlobalDelayedReferenceResolver.TEMPORARY_QUERY_PARAM_REPLACEMENT);
                if (query != null) {
                    ref.setQueryElement(property);
                    ref.setGenericReference(true);
                    String name = "<genericReference>" + property.refMofId();
                    OclExpressionRegistration registration = (OclExpressionRegistration) connection.getOclRegistryService()
                            .getFreestyleRegistry().getRegistration(name);
                    if (registration != null) {
                        connection.getOclRegistryService().getFreestyleRegistry().deleteRegistration(name);
                    }
                    registration = connection
                            .getOclRegistryService()
                            .getFreestyleRegistry()
                            .createExpressionRegistration(name, query, OclRegistrationSeverity.Info,
                                    new String[] { "TCS Property Query" }, parsingContext,
                                    packagesForLookup.toArray(new RefPackage[] {}));
                    Map<EventFilter, Map<ListenerType, Adapter>> reEvaluationListener = createReEvaluationListener(ref,
                            registration);
                    GlobalEventListenerRegistry registry = (GlobalEventListenerRegistry) context
                            .getService(globalEventListenerRegistryRef);
                    registry.addFilters(reEvaluationListener);
                    registration2DelayedReference.put(registration.getName(), ref);
                    delayedReference2RegistrationNames.put(ref, new String[] { registration.getName() });
                    delayedReference2ReEvaluationListener.put(ref, reEvaluationListener);

                }
            }
        }
    }

    private void registerForEachPropertyInitForIA(InjectorAction injectorAction, ConcreteSyntax syntax,
            TriggerManager triggerManager, IRuleName ruleNameBuilder) {
        // TODO Implement SyntaxRegistry.registerForEachPropertyInitForIA(...)
        
    }

    private Collection<Property> getPropertyInits(ConcreteSyntax syntax) {
        // TODO Implement SyntaxRegistry.getPropertyInits(...)
        return null;
    }

    private Collection<InjectorAction> getInjectorActions(ConcreteSyntax syntax) {
        // TODO Implement SyntaxRegistry.getInjectorActions(...)
        return null;
    }

}

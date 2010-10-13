package com.sap.furcas.runtime.referenceresolving;

import java.util.Collection;
import java.util.WeakHashMap;

import org.eclipse.core.runtime.IProgressMonitor;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;
import com.sap.emf.ocl.trigger.TriggerManager;
import com.sap.emf.ocl.trigger.TriggerManagerFactory;
import com.sap.furcas.metamodel.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.TCS.ForeachPredicatePropertyInit;
import com.sap.furcas.metamodel.TCS.InjectorAction;
import com.sap.furcas.metamodel.TCS.LookupPropertyInit;
import com.sap.furcas.metamodel.TCS.Property;
import com.sap.furcas.runtime.common.interfaces.IRuleName;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;

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
     * @param syntax
     * @param oppositeEndFinder
     */
    public TriggerManager getTriggerManagerForSyntax(ConcreteSyntax syntax, ObservableInjectingParser parser,
            OppositeEndFinder oppositeEndFinder, IRuleName ruleNameBuilder, IProgressMonitor monitor) {
        TriggerManager triggerManager = triggerManagersForSyntax.get(syntax);
        if (triggerManager == null) {
            triggerManager = TriggerManagerFactory.INSTANCE.createTriggerManager(oppositeEndFinder);
            triggerManagersForSyntax.put(syntax, triggerManager);
            fillTriggerManagerForSyntax(triggerManager, syntax, parser, ruleNameBuilder, monitor);
        }
        return triggerManager;
    }

    private void fillTriggerManagerForSyntax(TriggerManager triggerManager, ConcreteSyntax syntax, ObservableInjectingParser parser,
            IRuleName ruleNameBuilder, IProgressMonitor monitor) {
        // TODO Implement SyntaxRegistry.fillTriggerManagerForSyntax(...)
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
                registerLookupPropertyInitForIA(injectorAction, syntax, triggerManager);
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
        // TODO Implement SyntaxRegistry.registerPropertyQueryForIA(...)
        
    }

    private void registerForEachPropertyInitForIA(InjectorAction injectorAction, ConcreteSyntax syntax,
            TriggerManager triggerManager, IRuleName ruleNameBuilder) {
        // TODO Implement SyntaxRegistry.registerForEachPropertyInitForIA(...)
        
    }

    private void registerLookupPropertyInitForIA(InjectorAction injectorAction, ConcreteSyntax syntax, TriggerManager triggerManager) {
        // TODO Implement SyntaxRegistry.registerLookupPropertyInitForIA(...)
        
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

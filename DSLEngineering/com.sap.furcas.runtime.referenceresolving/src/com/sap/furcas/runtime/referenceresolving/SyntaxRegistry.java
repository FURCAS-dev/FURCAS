package com.sap.furcas.runtime.referenceresolving;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.WeakHashMap;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.sap.emf.ocl.trigger.TriggerManager;
import com.sap.emf.ocl.trigger.TriggerManagerFactory;
import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.ForeachPredicatePropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.InjectorAction;
import com.sap.furcas.metamodel.FURCAS.TCS.LookupPropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
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
     * Registers a concrete syntax with all the OCL expressions it contains,
     * producing or fetching from a cache a {@link TriggerManager}
     * 
     * @param monitor
     *            optional; may be <code>null</code>
     * @return a {@link TriggerManager} object. Clients should hold on to it as
     *         long as they wish the triggers to be executed as this registry
     *         only weakly references it.
     */
    public TriggerManager getTriggerManagerForSyntax(ConcreteSyntax syntax, OppositeEndFinder oppositeEndFinder,
            IProgressMonitor monitor) throws ParserException {
        TriggerManager triggerManager = triggerManagersForSyntax.get(syntax);
        if (triggerManager == null) {
            triggerManager = TriggerManagerFactory.INSTANCE.createTriggerManager(oppositeEndFinder);
            triggerManagersForSyntax.put(syntax, triggerManager);
            fillTriggerManagerForSyntax(triggerManager, syntax, oppositeEndFinder, monitor);
        }
        return triggerManager;
    }

    private void fillTriggerManagerForSyntax(TriggerManager triggerManager, ConcreteSyntax syntax, OppositeEndFinder oppositeEndFinder,
            IProgressMonitor monitor) throws ParserException {
        // fetch all InjectorAction and Property elements from the syntax
        Collection<InjectorAction> injectorActions = getInjectorActions(syntax);
        Collection<Property> propertyInits = getPropertiesWithQuery(syntax);
        if (monitor != null) {
            monitor.beginTask(
                    "Registering OCL expressions for Impact Analysis for syntax: "
                            + syntax.getName(), injectorActions.size()
                            + propertyInits.size());
            monitor.subTask("PropertyInits");
        }
        for (InjectorAction injectorAction : injectorActions) {
            if (monitor != null) {
                monitor.worked(1);
            }
            if (injectorAction instanceof LookupPropertyInit) {
                triggerManager.register(new SimplePropertyInitUpdater((LookupPropertyInit) injectorAction, oppositeEndFinder));
            } else if (injectorAction instanceof ForeachPredicatePropertyInit) {
                triggerManager.register(new ForeachPropertyInitUpdater((ForeachPredicatePropertyInit) injectorAction, oppositeEndFinder));
            }
        }
        if (monitor != null) {
            monitor.subTask("Property Queries");
        }
        for (Property property : propertyInits) {
            if (monitor != null) {
                monitor.worked(1);
            }
            Template template = property.getParentTemplate();
            if (template != null && template instanceof ClassTemplate && TcsUtil.getQueryPArg(property) != null) {
                triggerManager.register(new OCLQueryPropertyUpdater(property, oppositeEndFinder));
            }
        }
        if (monitor != null) {
            monitor.done(); // TODO was commented in original; why?
        }
    }

    private Collection<Property> getPropertiesWithQuery(ConcreteSyntax syntax) {
        Collection<Property> result = getElementsOfType(syntax, Property.class);
        for (Iterator<Property> i = result.iterator(); i.hasNext(); ) {
            Property p = i.next();
            if (TcsUtil.getQueryPArg(p) == null) {
                i.remove();
            }
        }
        return result;
    }

    private Collection<InjectorAction> getInjectorActions(ConcreteSyntax syntax) {
        return getElementsOfType(syntax, InjectorAction.class);
    }
    
    private <T extends EObject> Collection<T> getElementsOfType(ConcreteSyntax syntax, Class<T> typeToFilterFor) {
        Collection<T> result = new LinkedList<T>();
        for (Iterator<EObject> i=syntax.eAllContents(); i.hasNext(); ) {
            EObject o = i.next();
            if (typeToFilterFor.isInstance(o)) {
                @SuppressWarnings("unchecked")
                T t = (T) o;
                result.add(t);
            }
        }
        return result;
    }

}

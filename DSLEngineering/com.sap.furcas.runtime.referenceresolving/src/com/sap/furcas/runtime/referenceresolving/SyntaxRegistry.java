package com.sap.furcas.runtime.referenceresolving;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import org.antlr.runtime.Lexer;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.eclipse.ocl.examples.eventmanager.EventManager;
import org.eclipse.ocl.examples.eventmanager.EventManagerFactory;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.sap.emf.bundlelistener.EcorePackageLoadListener;
import com.sap.emf.ocl.trigger.OCLBasedModelUpdater;
import com.sap.emf.ocl.trigger.TriggerManager;
import com.sap.emf.ocl.trigger.TriggerManagerFactory;
import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.ForeachPredicatePropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.InjectorAction;
import com.sap.furcas.metamodel.FURCAS.TCS.LookupPropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.metamodel.FURCAS.TCS.PropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.runtime.parser.ParserFactory;
import com.sap.furcas.runtime.parser.impl.ModelUpdaterRegistry;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.syntaxprovider.SyntaxProvider;
import com.sap.furcas.runtime.tcs.PropertyArgumentUtil;
import com.sap.furcas.runtime.tcs.TcsUtil;

/**
 * Manages the relationship between {@link ConcreteSyntax FURCAS syntaxes} with their OCL-based
 * {@link OCLBasedModelUpdater model updaters} and the Ecore metamodel packages for which the syntaxes are
 * registered. A plugin that contributes a FURCAS syntax and that wants the syntax's model
 * updaters to be loaded
 * 
 * The syntax registry implements the com.sap.emf.bundlelistener extension point <code>emf_bundle_listener</code>,
 * implementing the {@link EcorePackageLoadListener} interface. As such, it receives update notifications whenever an
 * Ecore package's bundle is started for a package that is registered with the Ecore <code>generated_package</code>
 * extension point. These packages end up in the {@link EPackage.Registry#INSTANCE default package registry}.<p>
 * 
 * TODO Currently, all TriggerManagers share a single EventManager which can cause trouble during individual registering/unregistering. Consider using a single TriggerManager only.
 * 
 * @author Axel Uhl (d043530)
 * 
 */
public class SyntaxRegistry implements BundleActivator, EcorePackageLoadListener, TokenChanger, ModelUpdaterRegistry {
    private static Logger log = Logger.getLogger(SyntaxRegistry.class.getName());
    
    private static final String EXTENSION_POINT_ID = "furcas_syntax";
    private static final String METAMODEL_PROPERTY_NAME = "metamodel";
    private static SyntaxRegistry instance;
    
    /**
     * The values are the extensions specifying as the "provider_class" attribute the fully-qualified
     * class name of the {@link SyntaxProvider} class.
     */
    private final Map<URI, Set<IConfigurationElement>> metamodelNsURIToSyntaxProviders;
    
    private final Map<URI, TriggerManager> triggerManagersForSyntax;

    /**
     * For each {@link Property} registered in either
     * {@link #registerPropertiesWithQuery(Collection, TriggerManager, OppositeEndFinder, IProgressMonitor)} or
     * {@link #registerInjectorActions(Collection, TriggerManager, ParserFactory, OppositeEndFinder, IProgressMonitor)},
     * stores the {@link Property}/{@link PropertyInit}'s {@link URI} and maps it to the model updater responsible for
     * keeping the property up-to-date.
     */
    private final Map<URI, AbstractFurcasOCLBasedModelUpdater> updatersForPropertiesAndInjectorActions;

    /**
     * The single event manager to be used by all {@link TriggerManager}s created by this registry.
     * This ensures that only one adapter needs to be registered and that all event filters can be
     * scalably centralized in one event manager instead of requiring another event manager per
     * syntax registered.
     */
    private final EventManager eventManager;
    
    private final Map<URI, ParserFactory<? extends ObservableInjectingParser, ? extends Lexer>> parserFactoriesForSyntax;
    
    private final Registry metamodelRegistry;
    
    /**
     * Components registered by {@link #addTokenChanger(TokenChanger)} and deregistered by
     * {@link #removeTokenValueChanger(TokenChanger)} that get called when, e.g., due to a rename,
     * a token shall change its value. However, as life cycle constraints such as read-only
     * resources or wide-ranging queries may complicate matters, token updates are not performed
     * immediately but are delegates to the components registered here.
     */
    private final Set<TokenChanger> tokenChangers;
    
    public SyntaxRegistry() {
        triggerManagersForSyntax = new HashMap<URI, TriggerManager>();
        parserFactoriesForSyntax = new HashMap<URI, ParserFactory<? extends ObservableInjectingParser, ? extends Lexer>>();
        metamodelNsURIToSyntaxProviders = new HashMap<URI, Set<IConfigurationElement>>();
        eventManager = EventManagerFactory.eINSTANCE.createEventManager();
        metamodelRegistry = Registry.INSTANCE;
        tokenChangers = new HashSet<TokenChanger>();
        updatersForPropertiesAndInjectorActions = new HashMap<URI, AbstractFurcasOCLBasedModelUpdater>();
    }
    
    @Override
    public void start(BundleContext context) throws Exception {
        instance = this;
        IExtensionRegistry registry = Platform.getExtensionRegistry();
        for (IConfigurationElement listenerConfig : registry.getConfigurationElementsFor(
                context.getBundle().getSymbolicName()+"."+EXTENSION_POINT_ID)) {
            for (IConfigurationElement metamodelElement : listenerConfig.getChildren(METAMODEL_PROPERTY_NAME)) {
                URI metamodelURI = URI.createURI(metamodelElement.getAttribute("nsURI"));
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

    public static SyntaxRegistry getInstance() {
        if (instance == null) {
            // Probably not running in an OSGi environment...
            instance = new SyntaxRegistry();
        }
        return instance;
    }
    
    public void addTokenChanger(TokenChanger tokenChanger) {
        tokenChangers.add(tokenChanger);
    }
    
    public void removeTokenValueChanger(TokenChanger tokenChanger) {
        tokenChangers.remove(tokenChanger);
    }

    /**
     * Registers a concrete syntax with all the OCL expressions it contains,
     * producing or fetching from a cache a {@link TriggerManager}
     * @param monitor
     *            optional; may be <code>null</code>
     * @return a {@link TriggerManager} object. Clients should hold on to it as
     *         long as they wish the triggers to be executed as this registry
     *         only weakly references it.
     */
    public TriggerManager getTriggerManagerForSyntax(ConcreteSyntax syntax, OppositeEndFinder oppositeEndFinder,
            IProgressMonitor monitor, ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory) throws ParserException {
        URI syntaxURI = EcoreUtil.getURI(syntax);
        TriggerManager triggerManager = triggerManagersForSyntax.get(syntaxURI);
        if (triggerManager == null) {
            parserFactoriesForSyntax.put(syntaxURI, parserFactory);
            triggerManager = TriggerManagerFactory.INSTANCE.createTriggerManager(oppositeEndFinder, eventManager);
            triggerManagersForSyntax.put(syntaxURI, triggerManager);
            fillTriggerManagerForSyntax(triggerManager, syntax, parserFactory, oppositeEndFinder, monitor);
        }
        return triggerManager;
    }

    private void fillTriggerManagerForSyntax(TriggerManager triggerManager, ConcreteSyntax syntax,
            ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory,
            OppositeEndFinder oppositeEndFinder, IProgressMonitor monitor)
            throws ParserException {
        // fetch all InjectorAction and Property elements from the syntax
        Collection<InjectorAction> injectorActions = getInjectorActions(syntax);
        Collection<Property> propertiesWithQuery = getPropertiesWithQuery(syntax);
        initMonitor(syntax, monitor, injectorActions.size()+propertiesWithQuery.size());
        registerInjectorActions(injectorActions, triggerManager, parserFactory, oppositeEndFinder, monitor);
        registerPropertiesWithQuery(propertiesWithQuery, triggerManager, oppositeEndFinder, monitor);
        if (monitor != null) {
            monitor.done();
        }
    }

    private void initMonitor(ConcreteSyntax syntax, IProgressMonitor monitor, int totalNumberOfElementsToProcess) {
        if (monitor != null) {
            monitor.beginTask(
                    "Registering OCL expressions for Impact Analysis for syntax: "
                            + syntax.getName(), totalNumberOfElementsToProcess);
        }
    }

    private void registerPropertiesWithQuery(Collection<Property> propertyInits, TriggerManager triggerManager,
            OppositeEndFinder oppositeEndFinder, IProgressMonitor monitor) throws ParserException {
        if (monitor != null) {
            monitor.subTask("Property Queries");
        }
        for (Property property : propertyInits) {
            if (monitor != null) {
                monitor.worked(1);
            }
            Template template = property.getParentTemplate();
            if (template != null && template instanceof ClassTemplate && PropertyArgumentUtil.getReferenceByPArg(property) != null) {
                OCLQueryPropertyUpdater updater = new OCLQueryPropertyUpdater(property, metamodelRegistry, oppositeEndFinder, this);
                triggerManager.register(updater);
                updatersForPropertiesAndInjectorActions.put(EcoreUtil.getURI(property), updater);
            }
        }
    }

    private void registerInjectorActions(Collection<InjectorAction> injectorActions, TriggerManager triggerManager,
            ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory,
            OppositeEndFinder oppositeEndFinder, IProgressMonitor monitor)
            throws ParserException {
        if (monitor != null) {
            monitor.subTask("PropertyInits");
        }
        for (InjectorAction injectorAction : injectorActions) {
            if (monitor != null) {
                monitor.worked(1);
            }
            AbstractFurcasOCLBasedModelUpdater updater = null;
            if (injectorAction instanceof LookupPropertyInit) {
                updater = new SimplePropertyInitUpdater((LookupPropertyInit) injectorAction,
                        metamodelRegistry, oppositeEndFinder);
                triggerManager.register(updater);
            } else if (injectorAction instanceof ForeachPredicatePropertyInit) {
                updater = new ForeachPropertyInitUpdater((ForeachPredicatePropertyInit) injectorAction,
                        metamodelRegistry, parserFactory, oppositeEndFinder);
                triggerManager.register(updater);
            }
            if (updater != null) {
                updatersForPropertiesAndInjectorActions.put(EcoreUtil.getURI(injectorAction), updater);
            }
        }
    }
    
    @Override
    public AbstractFurcasOCLBasedModelUpdater getModelUpdater(URI propertyOrInjectorActionURI) {
        return updatersForPropertiesAndInjectorActions.get(propertyOrInjectorActionURI);
    }

    private Collection<Property> getPropertiesWithQuery(ConcreteSyntax syntax) {
        Collection<Property> result = TcsUtil.getElementsOfType(syntax, Property.class);
        for (Iterator<Property> i = result.iterator(); i.hasNext(); ) {
            Property p = i.next();
            if (PropertyArgumentUtil.getLookupScopePArg(p) == null) {
                i.remove();
            }
        }
        return result;
    }

    private Collection<InjectorAction> getInjectorActions(ConcreteSyntax syntax) {
        return TcsUtil.getElementsOfType(syntax, InjectorAction.class);
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
                    syntaxProvider.getTriggerManager(this); // trigger manager is remembered in this SyntaxRegistry
                } catch (Exception e) {
                    log.throwing(SyntaxRegistry.class.getName(), "packageLoaded", e);
                }
            }
        }
    }
    
    /**
     * After calling this method, all change {@link Notification notifications} coming from the
     * <code>registerWith</code> resource set and all its contained elements are analyzed. If they
     * trigger any of the OCL-based model updater rules from any of the syntaxes currently loaded,
     * the updater fires and updates the model accordingly.
     */
    public void registerAllLoadedSyntaxesTriggerManagers(ResourceSet registerWith) {
        eventManager.addToObservedResourceSets(registerWith);
    }

    /**
     * If <code>oldTokenValue</code> and <code>newTokenValue</code> differ, dispatches this request to all
     * {@link TokenChanger}s that were {@link #addTokenChanger(TokenChanger) registered} with this syntax registry.
     */
    @Override
    public void requestTokenValueChange(LexedToken token, String oldTokenValue, String newTokenValue) {
        if (oldTokenValue != newTokenValue || (oldTokenValue != null && !oldTokenValue.equals(newTokenValue))) {
            for (TokenChanger tokenChanger : tokenChangers) {
                tokenChanger.requestTokenValueChange(token, oldTokenValue, newTokenValue);
            }
        }
    }

    /**
     * Dispatches this request to all {@link TokenChanger}s that were {@link #addTokenChanger(TokenChanger) registered}
     * with this syntax registry.
     */
    @Override
    public void requestClearReferencedElements(LexedToken token) {
        for (TokenChanger tokenChanger : tokenChangers) {
            tokenChanger.requestClearReferencedElements(token);
        }
    }

    /**
     * Dispatches this request to all {@link TokenChanger}s that were {@link #addTokenChanger(TokenChanger) registered}
     * with this syntax registry.
     */
    @Override
    public void requestAddToReferencedElements(LexedToken token, EObject referencedElement) {
        for (TokenChanger tokenChanger : tokenChangers) {
            tokenChanger.requestAddToReferencedElements(token, referencedElement);
        }
    }
    
    
}

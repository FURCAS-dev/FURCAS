package com.sap.mi.textual.parsing.textblocks.reference;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EventListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.stream.EventFilter;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.sap.furcas.metamodel.TCS.ClassTemplate;
import com.sap.furcas.metamodel.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.TCS.FilterPArg;
import com.sap.furcas.metamodel.TCS.ForeachPredicatePropertyInit;
import com.sap.furcas.metamodel.TCS.InjectorAction;
import com.sap.furcas.metamodel.TCS.InjectorActionsBlock;
import com.sap.furcas.metamodel.TCS.LookupPropertyInit;
import com.sap.furcas.metamodel.TCS.PredicateSemantic;
import com.sap.furcas.metamodel.TCS.Property;
import com.sap.furcas.metamodel.TCS.QueryPArg;
import com.sap.furcas.metamodel.TCS.Template;
import com.sap.mi.textual.common.exceptions.ModelAdapterException;
import com.sap.mi.textual.common.interfaces.IRuleName;
import com.sap.mi.textual.common.util.ContextAndForeachHelper;
import com.sap.mi.textual.grammar.impl.DelayedReference;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.mi.textual.tcs.util.TcsUtil;


/**
 * This registry is responsible to setup and register all {@link IAExpressionInvalidationChangeListener}
 * required to correctly observer and incrementally maintain all references of a given ConcreteSyntax
 *
 */
public class IncrementalReferenceEvaluationRegistry {

    private final Map<ConcreteSyntax, ObservableInjectingParser> parsersBySyntax = new HashMap<ConcreteSyntax, ObservableInjectingParser>();
    private final Set<ConcreteSyntax> registeredSytaxes = new HashSet<ConcreteSyntax>();
    private final Map<DelayedReference, String[]> delayedReference2RegistrationNames = new HashMap<DelayedReference, String[]>();
    private final Map<DelayedReference, Map<EventFilter, Map<ListenerType, EventListener>>> delayedReference2ReEvaluationListener = new HashMap<DelayedReference, Map<EventFilter, Map<ListenerType, EventListener>>>();
    private final Map<String, DelayedReference> registration2DelayedReference = new HashMap<String, DelayedReference>();

    private BundleContext context;
    private ServiceReference globalEventListenerRegistryRef;
    private ReferenceResolver resolver;

    public IncrementalReferenceEvaluationRegistry(ServiceReference globalEventListenerRegistryRef, BundleContext context) {
	this.context = context;
	this.globalEventListenerRegistryRef = globalEventListenerRegistryRef;
    }

    public void registerReferenceForIncrementalEvaluation(ConcreteSyntax cs, ResourceSet connection,
	    EPackage outermostPackageOfMetamodel, ObservableInjectingParser parser, IRuleName ruleNameBuilder,
	    IProgressMonitor monitor) {

	if (!registeredSytaxes.contains(cs)) {
	    parsersBySyntax.put(cs, parser);
	    Collection<EPackage> packagesForLookup = new ArrayList<EPackage>();
	    packagesForLookup.addAll(MoinHelper.getImportedRefPackages(outermostPackageOfMetamodel));
	    packagesForLookup.add(outermostPackageOfMetamodel);

	    EClass elementClass = MoinHelper.getReflectElement(connection);

	    String mqlQuery = "select instance \n" + "from TCS::InjectorAction as instance";

	    MQLResultSet resultSet = connection.getMQLProcessor().execute(mqlQuery,
		    connection.getMQLProcessor().getInclusivePartitionScopeProvider(cs.get___Partition().getPri()));

	    mqlQuery = "select instance \n" + "from TCS::Property as instance";

	    MQLResultSet resultSetQueries = connection.getMQLProcessor().execute(mqlQuery,
		    connection.getMQLProcessor().getInclusivePartitionScopeProvider(cs.get___Partition().getPri()));
	    try {
		monitor.beginTask("Registering OCL expressions for Impact Analysis for syntax: " + cs.getName(), resultSet
			.getSize()
			+ resultSetQueries.getSize());
		monitor.subTask("PropertyInits");

		for (EObject result : resultSet.getRefObjects("instance")) {
		    monitor.worked(1);
		    InjectorAction injectorActionBase = (InjectorAction) result;
		    // check if metamodel element is present
		    if (injectorActionBase.getInjectorActionsBlock().getParentTemplate().getMetaReference() == null) {
			throw new RuntimeException("Cannot resolve reference to metamodel for template:\n"
				+ injectorActionBase.getInjectorActionsBlock().getParentTemplate().get___Mri() + "\n"
				+ "Make sure the metamodel is correctly referenced and loaded.");
		    }
		    if (injectorActionBase instanceof LookupPropertyInit) {
			registerLookupPropertyInitForIA(cs, connection, packagesForLookup, elementClass, injectorActionBase);
		    } else if (injectorActionBase instanceof ForeachPredicatePropertyInit) {
			registerForEachPropertyInitForIA(cs, connection, packagesForLookup, elementClass, injectorActionBase,
				ruleNameBuilder);
		    }
		}
		monitor.subTask("Property Queries");

		for (EObject result : resultSetQueries.getRefObjects("instance")) {
		    monitor.worked(1);
		    Property property = (Property) result;
		    registerPropertyQueryForIA(connection, packagesForLookup, elementClass, property, cs);
		}
	    } finally {
		// monitor.done();
	    }
	    registeredSytaxes.add(cs);
	}
    }

    private void registerForEachPropertyInitForIA(ConcreteSyntax cs, ResourceSet connection,
	    Collection<EPackage> packagesForLookup, EClass elementClass, InjectorAction injectorActionBase,
	    IRuleName ruleNameFinder) {
	ForeachPredicatePropertyInit foreachPredicatePropertyInit = (ForeachPredicatePropertyInit) injectorActionBase;
	InjectorActionsBlock block = foreachPredicatePropertyInit.getInjectorActionsBlock();
	Template template = block.getParentTemplate();
	String query = foreachPredicatePropertyInit.getValue();
	try {
	    List<com.sap.mi.textual.grammar.impl.PredicateSemantic> list = new ArrayList<com.sap.mi.textual.grammar.impl.PredicateSemantic>();
	    String mode = template instanceof ClassTemplate ? ((ClassTemplate) template).getMode() : null;
	    for (PredicateSemantic next : foreachPredicatePropertyInit.getPredicatesemantic()) {
		String localMode = mode;
		if (next.getMode() != null) {
		    localMode = next.getMode();
		}
		if (next.getWhen() != null) {
		    list.add(new com.sap.mi.textual.grammar.impl.PredicateSemantic(next.getWhen(), ruleNameFinder.getRuleName(
			    next.getAs(), localMode)));

		} else {
		    list.add(new com.sap.mi.textual.grammar.impl.PredicateSemantic(null, ruleNameFinder.getRuleName(next.getAs(),
			    localMode)));
		}
	    }
	    boolean hasContext = false;
	    if (block.getParentTemplate() instanceof ClassTemplate) {
		hasContext = ((ClassTemplate) block.getParentTemplate()).isIsContext();
	    }
	    DelayedReference ref = new DelayedReference(null, null, DelayedReference.TYPE_SEMANTIC_PREDICATE, null,
		    foreachPredicatePropertyInit.getPropertyReference().getStrucfeature().getName(), query,
		    foreachPredicatePropertyInit.getMode(), list, ruleNameFinder, null, hasContext,
		    /*
		     * isOptional: ForEach is always considered optional as
		     * error reporting will be done based on metamodel
		     * constraints.
		     */true);
	    ref.setQueryElement(foreachPredicatePropertyInit);
	    ref.setGenericReference(true);

	    // now replace any #context parts within the query with self
	    // and use the context element type for registration if it is
	    // used here,
	    registerOclExpressionsOfForeachConstruct(connection, packagesForLookup, elementClass, foreachPredicatePropertyInit,
		    template, ref);
	} catch (OclManagerException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (ModelAdapterException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (MoinLocalizedBaseRuntimeException ex) {
	    System.err.println("Failed to register at IA: " + foreachPredicatePropertyInit.getValue() + "\n" + ex.getMessage());
	    ex.printStackTrace();
	}
    }

    private void registerLookupPropertyInitForIA(ConcreteSyntax cs, ResourceSet connection,
	    Collection<EPackage> packagesForLookup, EClass elementClass, InjectorAction injectorActionBase) {
	LookupPropertyInit injectorAction = (LookupPropertyInit) injectorActionBase;
	Template template = ((InjectorActionsBlock) injectorAction.refImmediateComposite()).getParentTemplate();
	String query = injectorAction.getValue();
	EObject parsingContext = ContextAndForeachHelper.getParsingContext(connection, query, template, packagesForLookup,
		elementClass);
	try {
	    DelayedReference ref = new DelayedReference(null, null, null, injectorAction.getPropertyReference().getStrucfeature()
		    .getName(), null, null, query, false, null);
	    // now replace any #context parts within the query with self
	    // and use the context element type for registration if it is
	    // used here,
	    query = MoinHelper.prepareOclQuery(query, null);
	    if (query != null) {
		ref.setQueryElement(injectorAction);
		ref.setGenericReference(true);
		String name = "<genericReference>" + injectorAction.refMofId();
		OclExpressionRegistration registration = (OclExpressionRegistration) connection.getOclRegistryService()
			.getFreestyleRegistry().getRegistration(name);
		if (registration != null) {
		    connection.getOclRegistryService().getFreestyleRegistry().deleteRegistration(name);
		}
		registration = connection.getOclRegistryService().getFreestyleRegistry().createExpressionRegistration(name,
			query, OclRegistrationSeverity.Info, new String[] { "TCS Property Init" }, parsingContext,
			packagesForLookup.toArray(new EPackage[] {}));
		Map<EventFilter, Map<ListenerType, EventListener>> reEvaluationListener = createReEvaluationListener(ref,
			registration);
		GlobalEventListenerRegistry registry = (GlobalEventListenerRegistry) context
			.getService(globalEventListenerRegistryRef);
		registry.addFilters(reEvaluationListener);
		registration2DelayedReference.put(registration.getName(), ref);
		delayedReference2RegistrationNames.put(ref, new String[] { registration.getName() });
		delayedReference2ReEvaluationListener.put(ref, reEvaluationListener);

	    }
	} catch (OclManagerException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (ModelAdapterException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (MoinLocalizedBaseRuntimeException ex) {
	    System.err.println("Failed to register at IA: " + injectorAction.getValue() + "\n" + ex.getMessage());
	    ex.printStackTrace();
	}
    }

    /**
     * Combine the <tt>foreach</tt> and all <tt>when</tt> expressions into one
     * event listener. For each expression a separate
     * {@link OclExpressionRegistration} is created. Their event filters are
     * combined into one filter by using an {@link OrFilter}. Therefore, events
     * that affect any of the <tt>foreach</tt> or the <tt>when</tt> expressions
     * are delivered to the <tt>ref</tt> reference only once. The same listener
     * instance is registered for the combined event filter.
     */
    private void registerOclExpressionsOfForeachConstruct(ResourceSet connection, Collection<EPackage> packagesForLookup,
	    EClass elementClass, ForeachPredicatePropertyInit foreachPredicatePropertyInit, Template template,
	    DelayedReference ref) throws ModelAdapterException, OclManagerException {
	Set<OclExpressionRegistration> registrations = new HashSet<OclExpressionRegistration>();
	Map<String, String> mofIdToOclQueryPairs = new HashMap<String, String>();
	if (foreachPredicatePropertyInit.getValue() != null) {
	    mofIdToOclQueryPairs.put(foreachPredicatePropertyInit.refMofId(), foreachPredicatePropertyInit.getValue());
	}
	for (tcs.PredicateSemantic whenClause : foreachPredicatePropertyInit.getPredicatesemantic()) {
	    if (whenClause.getWhen() != null) {
		mofIdToOclQueryPairs.put(whenClause.refMofId(), whenClause.getWhen());
	    }
	}
	List<String> registrationNames = new ArrayList<String>();
	for (String mofId : mofIdToOclQueryPairs.keySet()) {
	    String oclRegistrationName = "<genericReference>" + mofId;
	    OclExpressionRegistration registration = (OclExpressionRegistration) connection.getOclRegistryService()
		    .getFreestyleRegistry().getRegistration(oclRegistrationName);
	    if (registration != null) {
		connection.getOclRegistryService().getFreestyleRegistry().deleteRegistration(oclRegistrationName);
	    }
	    EObject parsingContext = ContextAndForeachHelper.getParsingContext(connection, mofIdToOclQueryPairs.get(mofId),
		    template, packagesForLookup, elementClass);
	    String preparedQuery = MoinHelper.prepareOclQuery(mofIdToOclQueryPairs.get(mofId), null);
	    registration = connection.getOclRegistryService().getFreestyleRegistry().createExpressionRegistration(
		    oclRegistrationName, preparedQuery, OclRegistrationSeverity.Info, new String[] { "TCS Property Init" },
		    parsingContext, packagesForLookup.toArray(new EPackage[] {}));
	    registrations.add(registration);
	    registration2DelayedReference.put(oclRegistrationName, ref);
	    registrationNames.add(oclRegistrationName);
	}
	delayedReference2RegistrationNames.put(ref, registrationNames.toArray(new String[0]));
	Map<EventFilter, Map<ListenerType, EventListener>> reEvaluationListener = createReEvaluationListener(ref, registrations
		.toArray(new OclExpressionRegistration[0]));
	GlobalEventListenerRegistry registry = (GlobalEventListenerRegistry) context.getService(globalEventListenerRegistryRef);
	registry.addFilters(reEvaluationListener);
	delayedReference2ReEvaluationListener.put(ref, reEvaluationListener);
    }

    private void registerPropertyQueryForIA(ResourceSet connection, Collection<EPackage> packagesForLookup,
	    EClass elementClass, Property property, ConcreteSyntax cs) {
	Template template = property.getParentTemplate();
	if (template != null && template.getMetaReference() instanceof EClass) {
	    // TODO what about StructureTypes?
	    QueryPArg qarg = TcsUtil.getQueryPArg(property);
	    // TODO still needed? if not, delete
	    // RefersToParg refersToArg = TcsUtil.getRefersToParg(property);
	    FilterPArg filter = TcsUtil.getFilterPArg(property);
	    if (qarg != null) {
		try {
		    String query = qarg.getQuery();
		    if (filter != null) {
			query += filter.getFilter();
		    }
		    EObject parsingContext = ContextAndForeachHelper.getParsingContext(connection, query, template,
			    packagesForLookup, elementClass);
		    DelayedReference ref = new DelayedReference(null, null, null, property.getPropertyReference()
			    .getStrucfeature().getName(), null, null, query, false, null);
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
			registration = connection.getOclRegistryService().getFreestyleRegistry().createExpressionRegistration(
				name, query, OclRegistrationSeverity.Info, new String[] { "TCS Property Query" }, parsingContext,
				packagesForLookup.toArray(new EPackage[] {}));
			Map<EventFilter, Map<ListenerType, EventListener>> reEvaluationListener = createReEvaluationListener(ref,
				registration);
			GlobalEventListenerRegistry registry = (GlobalEventListenerRegistry) context
				.getService(globalEventListenerRegistryRef);
			registry.addFilters(reEvaluationListener);
			registration2DelayedReference.put(registration.getName(), ref);
			delayedReference2RegistrationNames.put(ref, new String[] { registration.getName() });
			delayedReference2ReEvaluationListener.put(ref, reEvaluationListener);

		    }
		} catch (OclManagerException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		} catch (ModelAdapterException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		} catch (MoinLocalizedBaseRuntimeException ex) {
		    System.err.println("Failed to register at IA: " + qarg.getQuery() + "\n" + ex.getMessage());
		    ex.printStackTrace();
		}
	    }
	}
    }

    /**
     * Fetches the event filters for <tt>registrations</tt> (see
     * {@link OclExpressionRegistration#getEventFilter(boolean)}) and combines
     * them into one {@link OrFilter}. An event filter map suitable for use with
     * {@link GlobalEventListenerRegistry#addFilters(Map)} is created with a new
     * {@link IAExpressionInvalidationChangeListener} listener object for the
     * <tt>ref</tt> reference.
     */
    private Map<EventFilter, Map<ListenerType, EventListener>> createReEvaluationListener(DelayedReference ref,
	    OclExpressionRegistration... registrations) {
	IAExpressionInvalidationChangeListener listener = new IAExpressionInvalidationChangeListener(resolver, ref, registrations);
	Map<EventFilter, Map<ListenerType, EventListener>> map = new HashMap<EventFilter, Map<ListenerType, EventListener>>();
	Set<EventFilter> filters = new HashSet<EventFilter>();
	for (OclExpressionRegistration registration : registrations) {
	    // notifyNewContextElement can be set to false because element
	    // creation is handled by the
	    // parser itself, evaluating all properties initially that cna be
	    // evaluated at that point.
	    filters.add(registration.getEventFilter(/* notifyNewContextElement */false));
	}
	OrFilter filter = new OrFilter(filters.toArray(new EventFilter[0]));
	Map<ListenerType, EventListener> listenerForType = new HashMap<ListenerType, EventListener>();
	listenerForType.put(ListenerType.UPDATE, listener);
	listenerForType.put(ListenerType.POST_CHANGE, listener);
	map.put(filter, listenerForType);
	return map;
    }

    private Set<IAExpressionInvalidationChangeListener> getAllListeners() {
	Set<IAExpressionInvalidationChangeListener> result = new HashSet<IAExpressionInvalidationChangeListener>();
	for (Map<EventFilter, Map<ListenerType, EventListener>> m : delayedReference2ReEvaluationListener.values()) {
	    for (Map<ListenerType, EventListener> ltel : m.values()) {
		for (EventListener listener : ltel.values()) {
		    result.add((IAExpressionInvalidationChangeListener) listener);
		}
	    }
	}
	return result;
    }

    void removeRegistration(DelayedReference unresolvedRef) {

	GlobalEventListenerRegistry registry = (GlobalEventListenerRegistry) context.getService(globalEventListenerRegistryRef);

	String[] regs = delayedReference2RegistrationNames.remove(unresolvedRef);
	for (String reg : regs) {
	    registration2DelayedReference.remove(reg);
	}
	Map<EventFilter, Map<ListenerType, EventListener>> filter = delayedReference2ReEvaluationListener.remove(unresolvedRef);
	if (filter != null) {
	    registry.removeFilters(filter);
	}
    }

    ObservableInjectingParser getParser(ConcreteSyntax concretesyntax) {
	return parsersBySyntax.get(concretesyntax);
    }

    /**
     * Set the resolver that shall be passed on to and used by the created listeners.
     * @param resolver
     */
    void setResolver(ReferenceResolver resolver) {
	this.resolver = resolver;
    }

    public String getDebugInfo(ResourceSet conn) {
	StringBuilder result = new StringBuilder();
	for (IAExpressionInvalidationChangeListener listener : getAllListeners()) {
	    result.append(listener.getDebugInfo(conn));
	}
	return result.toString();
    }

    public String getDebugInfoAsCsv(ResourceSet conn) {
	Statistics oclIaStatistics = Statistics.getInstance();
	StringBuilder result = new StringBuilder();
	result.append(oclIaStatistics.getCsvHeader());
	for (IAExpressionInvalidationChangeListener listener : getAllListeners()) {
	    result.append(listener.getDebugInfoAsCsv(conn));
	}
	return result.toString();
    }

}

package com.sap.ocl.oppositefinder.query2;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query.index.ui.IndexFactory;
import org.eclipse.emf.query2.EcoreHelper;
import org.eclipse.emf.query2.QueryContext;
import org.eclipse.emf.query2.QueryProcessor;
import org.eclipse.emf.query2.QueryProcessorFactory;
import org.eclipse.emf.query2.ResultSet;

import com.sap.emf.ocl.hiddenopposites.DefaultOppositeEndFinder;
import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;
import com.sap.ocl.oppositefinder.query2.internal.DefaultQueryContextProvider;

import de.hpi.sam.bp2009.solution.queryContextScopeProvider.QueryContextProvider;
import de.hpi.sam.bp2009.solution.queryContextScopeProvider.impl.ProjectBasedQueryContextScopeProviderImpl;

/**
 * Uses EMF query2 to reverse-navigate a reference that has no opposite. The search scope
 * is dynamically determined for the start object of the navigation, using a
 * {@link QueryContextProvider}. If none is specifically passed to the constructor,
 * a default one is used which searches in the {@link ResourceSet} of the object
 * where navigation starts. However, with this default the implementation should behave
 * roughly like the base class implementation, except that no {@link ECrossReferenceAdapter}
 * is required.
 *  
 * @author Axel Uhl (D043530)
 *
 */
public class Query2OppositeEndFinder implements OppositeEndFinder {
    /**
     * Used to obtain a query context for a given {@link EObject}.
     */
    private final QueryContextProvider queryContextProvider;
    
    private final DefaultOppositeEndFinder delegate;
    
    private static Query2OppositeEndFinder instance;
    
    public static Query2OppositeEndFinder getInstance() {
        if (instance == null) {
            instance = new Query2OppositeEndFinder();
        }
        return instance;
    }
    
    /**
     * Uses a {@link DefaultQueryContextProvider} to determine the context for queries
     */
    public Query2OppositeEndFinder() {
        this(new DefaultQueryContextProvider());
    }
    
    public Query2OppositeEndFinder(QueryContextProvider queryContextProvider) {
        this.queryContextProvider = queryContextProvider;
        // using a singleton instance as delegate instead of inheriting saves the effort
        // of re-constructing the metadata cache managed by the DefaultOppositeEndFinder
        // over and over again
        delegate = DefaultOppositeEndFinder.getInstance();
    }
    
    @Override
    public Object navigateOppositeProperty(EStructuralFeature property, Object target)
            throws IllegalArgumentException {
        if (target instanceof EObject) {
            EObject etarget = (EObject) target;
            Collection<EObject> result = null;
            if (property instanceof EReference && ((EClass) ((EReference) property).getEType()).isSuperTypeOf(etarget.eClass())) {
                QueryContext queryContext = queryContextProvider.getQueryContext(etarget);
                ResourceSet rs = etarget.eResource().getResourceSet();
                if (rs == null) {
                    rs = new ResourceSetImpl();
                }
                result = EcoreHelper.getInstance().reverseNavigate(etarget, (EReference) property, queryContext, rs);
            }
            return result;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void findOppositeEnds(EClassifier classifier, String name, List<EStructuralFeature> ends) {
        delegate.findOppositeEnds(classifier, name, ends);
    }

    @Override
    public Map<String, EStructuralFeature> getAllOppositeEnds(EClassifier classifier) {
        return delegate.getAllOppositeEnds(classifier);
    }

    /**
     * Uses a backward-scope {see {@link ProjectBasedScopeProvider#getBackwardScopeAsQueryContext()}) (all things that can see
     * <code>context</code> are in scope) to find all elements of a type equal or conforming to <code>cls</code>.
     */
    @Override
    public Set<EObject> getAllInstancesSeeing(EClass cls, Notifier context) {
        QueryContext scope = new ProjectBasedQueryContextScopeProviderImpl(context).getBackwardScopeAsQueryContext();
        return getAllInstancesWithScope(cls, context, scope);
    }

    /**
     * Uses a forward-scope {see {@link ProjectBasedScopeProvider#getForwardScopeAsQueryContext()}) (all things visible from
     * <code>context</code> are in scope) to find all elements of a type equal or conforming to <code>cls</code>.
     */
    @Override
    public Set<EObject> getAllInstancesSeenBy(EClass cls, Notifier context) {
        QueryContext scope = new ProjectBasedQueryContextScopeProviderImpl(context).getForwardScopeAsQueryContext();
        return getAllInstancesWithScope(cls, context, scope);
    }

    private Set<EObject> getAllInstancesWithScope(EClass cls, Notifier context, QueryContext scope) {
        Set<EObject> result = new HashSet<EObject>();

        QueryProcessor queryProcessor = QueryProcessorFactory.getDefault().createQueryProcessor(IndexFactory.getInstance());
        // by default, a from-clause includes all subtypes unless the "withoutsubtypes" option is used
        String query = "select obj from [" + EcoreUtil.getURI(cls) + "] as obj";
        ResultSet resultSet = queryProcessor.execute(query, scope);
        if (!resultSet.isEmpty()) {
            for (int i = 0; i < resultSet.getSize(); i++) {
                String uri = resultSet.getUri(i, "obj").toString();
                EObject obj = getEObject(context, uri);
                result.add(obj);
            }
        }
        return result;
    }

    private EObject getEObject(Notifier context, String uri) {
        EObject result;
        if (context instanceof ResourceSet) {
            result = ((ResourceSet) context).getEObject(URI.createURI(uri), /* loadOnDemand */ true);
        } else if (context instanceof Resource) {
            Resource r = (Resource) context;
            String uriFragment = uri.split("#")[1];
            result = r.getEObject(uriFragment);
        } else if (context instanceof EObject) {
            Resource r = ((EObject) context).eResource();
            result = getEObject(r, uri);
        } else {
            throw new RuntimeException("Expected Resource, ResourceSet or EObject but got "+context.getClass().getName());
        }
        return result;
    }

}

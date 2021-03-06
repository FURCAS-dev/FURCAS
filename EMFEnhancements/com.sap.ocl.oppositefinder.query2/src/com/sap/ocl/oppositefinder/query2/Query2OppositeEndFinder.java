/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
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
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query.index.IndexFactory;
import org.eclipse.emf.query2.FromEntry;
import org.eclipse.emf.query2.FromType;
import org.eclipse.emf.query2.Query;
import org.eclipse.emf.query2.QueryContext;
import org.eclipse.emf.query2.QueryProcessor;
import org.eclipse.emf.query2.QueryProcessorFactory;
import org.eclipse.emf.query2.ResultSet;
import org.eclipse.emf.query2.SelectAlias;
import org.eclipse.emf.query2.SelectEntry;
import org.eclipse.ocl.ecore.opposites.DefaultOppositeEndFinder;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;

import de.hpi.sam.bp2009.solution.queryContextScopeProvider.QueryContextProvider;

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
    protected Query2OppositeEndFinder() {
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
    public Collection<EObject> navigateOppositePropertyWithForwardScope(EReference property, EObject target)
            throws IllegalArgumentException {
        if (target instanceof EObject) {
            EObject etarget = target;
            Collection<EObject> result = null;
            if (property instanceof EReference && (((EClass) (property).getEType()).isSuperTypeOf(etarget.eClass())
                    || ((EClass) (property).getEType()).equals(EcorePackage.eINSTANCE.getEObject()))) {
                QueryContext queryContext = queryContextProvider.getForwardScopeQueryContext(etarget);
                ResourceSet rs = etarget.eResource().getResourceSet();
                if (rs == null) {
                    rs = new ResourceSetImpl();
                }
                result = EcoreHelper.getInstance().reverseNavigate(etarget, property, queryContext, rs, IndexFactory.getInstance());
            }
            return result;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Collection<EObject> navigateOppositePropertyWithBackwardScope(EReference property, EObject etarget) {
        Collection<EObject> result = null;
        if (property instanceof EReference
                && (((EClass) (property).getEType()).isSuperTypeOf(etarget.eClass()) || ((EClass) (property).getEType())
                        .equals(EcorePackage.eINSTANCE.getEObject()))) {
            QueryContext queryContext = queryContextProvider.getBackwardScopeQueryContext(etarget);
            ResourceSet rs = null;
            if (etarget.eResource() != null) {
                rs = etarget.eResource().getResourceSet();
            }
            if (rs == null) {
                rs = queryContext.getResourceSet();
                if (rs == null) {
                    rs = new ResourceSetImpl();
                }
            }
            result = EcoreHelper.getInstance().reverseNavigate(etarget, property, queryContext, rs,
                    IndexFactory.getInstance());
        }
        return result;
    }

    @Override
    public void findOppositeEnds(EClassifier classifier, String name, List<EReference> ends) {
        delegate.findOppositeEnds(classifier, name, ends);
    }

    @Override
    public Map<String, EReference> getAllOppositeEnds(EClassifier classifier) {
        return delegate.getAllOppositeEnds(classifier);
    }

    /**
     * Uses a backward-scope {see {@link ProjectBasedScopeProvider#getBackwardScopeAsQueryContext()}) (all things that can see
     * <code>context</code> are in scope) to find all elements of a type equal or conforming to <code>cls</code>.
     */
    @Override
    public Set<EObject> getAllInstancesSeeing(EClass cls, Notifier context) {
        QueryContext scope = queryContextProvider.getBackwardScopeQueryContext(context);
        return getAllInstancesWithScope(cls, context, scope);
    }

    /**
     * Uses a forward-scope {see {@link ProjectBasedScopeProvider#getForwardScopeAsQueryContext()}) (all things visible from
     * <code>context</code> are in scope) to find all elements of a type equal or conforming to <code>cls</code>.
     */
    @Override
    public Set<EObject> getAllInstancesSeenBy(EClass cls, Notifier context) {
        QueryContext scope = queryContextProvider.getForwardScopeQueryContext(context);
        return getAllInstancesWithScope(cls, context, scope);
    }

    private Set<EObject> getAllInstancesWithScope(EClass cls, Notifier context, QueryContext scope) {
        Set<EObject> result = new HashSet<EObject>();

        QueryProcessor queryProcessor = QueryProcessorFactory.getDefault().createQueryProcessor(IndexFactory.getInstance());
        SelectEntry select = new SelectAlias("obj");
        FromType from = new FromType(/* aliasName */ "obj", /* type URI */ EcoreUtil.getURI(cls), /* withoutsubtypes */ false);
        Query query = new Query(new SelectEntry[] { select }, new FromEntry[] { from });
        // by default, a from-clause includes all subtypes unless the "withoutsubtypes" option is used
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
            ResourceSet rs = ((EObject) context).eResource().getResourceSet(); 
            result = getEObject(rs, uri); 
        } else {
            throw new RuntimeException("Expected Resource, ResourceSet or EObject but got "+context.getClass().getName());
        }
        return result;
    }

}

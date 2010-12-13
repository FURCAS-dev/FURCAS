/*******************************************************************************
 * Copyright (c) 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query.index.Index;
import org.eclipse.emf.query.index.query.IndexQueryFactory;
import org.eclipse.emf.query.index.query.QueryCommand;
import org.eclipse.emf.query.index.query.QueryExecutor;
import org.eclipse.emf.query.index.query.ResourceQuery;
import org.eclipse.emf.query.index.query.descriptors.ResourceDescriptor;
import org.eclipse.emf.query.index.update.IndexUpdater;
import org.eclipse.emf.query.index.update.ResourceIndexer;
import org.eclipse.emf.query.index.update.UpdateCommandAdapter;
import org.eclipse.emf.query2.internal.shared.EmfHelper;

public class EcoreHelper {
    private static EcoreHelper instance;
    private QueryProcessor queryProcessor;
    
    public static EcoreHelper getInstance() {
        if (instance == null) {
            instance = new EcoreHelper();
        }
        return instance;
    }
    
    public Collection<EClass> getAllSubclasses(EClass c, Index index) {
        return new EmfHelper(getQueryContext(new ResourceSetImpl(), index), index).getAllSubtypes(c);
    }
    
    /**
     * With references that may occur as hidden opposites (see {@link EReference#getOwnedOpposite()}),
     * it is not possible to simply ask the container of a reference to find the owning class.
     * Instead, for hidden opposites, the opposite's type will be used.
     */
    private EClass getOwningType(EReference reference) {
        if (reference.eContainer() instanceof EClass) {
            return (EClass) reference.eContainer();
        } else {
            return (EClass) reference.getEOpposite().getEType();
        }
    }
    
    private EList<EObject> createEList(boolean unique) {
        EList<EObject> result;
        if (unique) {
            result = new UniqueEList<EObject>();
        } else {
            result = new BasicEList<EObject>();
        }
        return result;
    }
    
    /**
     * Traverses <tt>forwardReference</tt> in reverse, that is, looks for objects that, when starting
     * from them and navigating <tt>forwardReference</tt>, it results in <tt>from</tt>.<p>
     * 
     * Precondition: <tt>forwardReference.getEOpposite() != null</tt>
     */
    public Collection<EObject> reverseNavigate(EObject from, EReference forwardReference, QueryContext scope, ResourceSet rs, Index index) {
        boolean unique;
        if (forwardReference.getEOpposite() != null) {
            unique = forwardReference.getEOpposite().isUnique();
        } else {
            unique = false;
        }
        Collection<EObject> result = createEList(unique);
        reverseNavigate(from, forwardReference, scope, rs, result, index);
        return result;
    }

    /**
     * Same as {@link #reverseNavigate(EObject, EReference, QueryContext, ResourceSet, Index)}, but <tt>forwardReference</tt>
     * does not have to have an opposite. Instead, uniqueness of the result collection is determined by the
     * <tt>unique</tt> parameter.
     */
    public Collection<EObject> reverseNavigate(EObject from, EReference forwardReference, QueryContext scope, ResourceSet rs, boolean unique, Index index) {
        Collection<EObject> result = createEList(unique);
        reverseNavigate(from, forwardReference, scope, rs, index);
        return result;
    }
    
    /**
     * Navigates along the <tt>to</tt> reference, starting at object <tt>from</tt>. The reference
     * can (and usually will) be a "hidden opposite" which is owned by another {@link EReference}
     * (see also {@link EReference#getOwnedOpposite()}). The <tt>to</tt> reference has to have
     * a valid {@link EReference#getEOpposite() opposite}.
     */
    public Collection<EObject> navigateByQuery(EObject from, EReference to, QueryContext scope, ResourceSet rs, Index index) {
        return reverseNavigate(from, to.getEOpposite(), scope, rs, index);
    }

    /**
     * Same as {@link #navigateByQuery(EObject, EReference, QueryContext, ResourceSet, Index)}, only that the
     * {@link ResourceSet} is determined from the <tt>from</tt> object
     */
    public Collection<EObject> navigateByQuery(EObject from, EReference to, QueryContext scope, Index index) {
        return reverseNavigate(from, to.getEOpposite(), scope, from.eResource().getResourceSet(), index);
    }
    
    /**
     * Same as {@link #reverseNavigate(EObject, EReference, QueryContext, ResourceSet, Index)}, only that
     * <tt>forwardReference</tt> does not have to have an {@link EReference#getEOpposite() opposite}.
     * Instead, a collection is passed in to which the result are added. Therefore, the opposite
     * reference is not required, as no uniqueness attribute needs to be determined.
     * @param rs used to resolve the element URIs resulting from the query
     */
    public void reverseNavigate(EObject from, EReference forwardReference, QueryContext scope, ResourceSet rs, Collection<EObject> result, Index index) {
        if (forwardReference.isContainment()) { // TODO this can be written much shorter using feature IDs
            EObject container = from.eContainer();
            if (container != null) {
                if ((forwardReference.isMany() && ((Collection<?>) container.eGet(forwardReference)).contains(from))
                        || (!forwardReference.isMany() && container == from)) {
                    result.add(container);
                }
            }
        } else {
            EClass owningType = getOwningType(forwardReference);
            SelectEntry select = new SelectAlias("target");
            FromFixedSet fromFromElement = new FromFixedSet("source", EcoreUtil.getURI(from.eClass()), new URI[] { EcoreUtil.getURI(from) });
            FromType fromTarget = new FromType("target", EcoreUtil.getURI(owningType), /* _withoutSubtypes */ false);
            WhereEntry where = new WhereRelationReference(/* _leftAlias */ "target", /* _featureName */ forwardReference.getName(),
                    /* _rightAlias */ "source");
            Query query = new Query(new SelectEntry[] { select }, new FromEntry[] { fromFromElement, fromTarget },
                    new WhereEntry[] { where });
            final ResultSet resultSet = getQueryProcessor(index).execute(query, scope);
            for (int i = 0; i < resultSet.getSize(); i++) {
                result.add(rs.getEObject(resultSet.getUri(i, "target"), /* loadOnDemand */true)); //$NON-NLS-1$
            }
        }
    }

    private QueryProcessor getQueryProcessor(Index index) {
        if (queryProcessor == null) {
            queryProcessor = QueryProcessorFactory.getDefault().createQueryProcessor(index);
        }
        return queryProcessor;
    }

    /**
     * Same as {@link #reverseNavigate(EObject, EReference, QueryContext, ResourceSet, Collection, Index)}, only
     * that the resource set is determined from the <tt>from</tt> object.
     */
    public void reverseNavigate(EObject from, EReference forwardReference, QueryContext scope, Collection<EObject> result, Index index) {
        reverseNavigate(from, forwardReference, scope, from.eResource().getResourceSet(), result, index);
    }
    
    /**
     * Constructs a query context that contains all of <tt>rs</tt>'s resources and all
     * metamodel resources
     */
    public QueryContext getQueryContext(final ResourceSet rs, final Index index) {
        return new QueryContext() {
                public URI[] getResourceScope() {
                        final List<URI> result = new ArrayList<URI>();
                        index.executeQueryCommand(new QueryCommand() {
                                public void execute(QueryExecutor queryExecutor) {
                                        ResourceQuery<ResourceDescriptor> resourceQuery = IndexQueryFactory.createResourceQuery();
                                        for (ResourceDescriptor desc : queryExecutor.execute(resourceQuery)) {
                                                result.add(desc.getURI());
                                        }
                                        for (Resource r:rs.getResources()) {
                                            result.add(r.getURI());
                                        }
                                }
                        });
                        return result.toArray(new URI[0]);
                }

                public ResourceSet getResourceSet() {
                        return rs;
                }
        };
    }
    
    public void addResourceToDefaultIndex(Index index, final Resource... resources) {
        index.executeUpdateCommand(new UpdateCommandAdapter() {
            @Override
            public void execute(IndexUpdater updater) {
                ResourceIndexer rd = new ResourceIndexer();
                for (Resource r : resources) {
                    if (r.isLoaded()) {
                        rd.resourceChanged(updater, r);
                    }
                }
            }
        });
    }
}

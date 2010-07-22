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
import org.eclipse.emf.query.index.query.IndexQueryFactory;
import org.eclipse.emf.query.index.query.QueryCommand;
import org.eclipse.emf.query.index.query.QueryExecutor;
import org.eclipse.emf.query.index.query.ResourceQuery;
import org.eclipse.emf.query.index.query.descriptors.ResourceDescriptor;
import org.eclipse.emf.query.index.ui.IndexFactory;
import org.eclipse.emf.query.index.update.IndexUpdater;
import org.eclipse.emf.query.index.update.ResourceIndexer;
import org.eclipse.emf.query.index.update.UpdateCommandAdapter;

public class EcoreHelper {
    private static EcoreHelper instance;
    private QueryProcessor queryProcessor;
    
    public static EcoreHelper getInstance() {
        if (instance == null) {
            instance = new EcoreHelper();
        }
        return instance;
    }
    
    public Collection<EClass> getAllSubclasses(EClass c) {
        return new EmfHelper(getQueryContext(new ResourceSetImpl()), IndexFactory.getInstance()).getAllSubtypes(c);
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
    public Collection<EObject> reverseNavigate(EObject from, EReference forwardReference, QueryContext scope, ResourceSet rs) {
        boolean unique;
        if (forwardReference.getEOpposite() != null) {
            unique = forwardReference.getEOpposite().isUnique();
        } else {
            unique = false;
        }
        Collection<EObject> result = createEList(unique);
        reverseNavigate(from, forwardReference, scope, rs, result);
        return result;
    }

    /**
     * Same as {@link #reverseNavigate(EObject, EReference, QueryContext, ResourceSet)}, but <tt>forwardReference</tt>
     * does not have to have an opposite. Instead, uniqueness of the result collection is determined by the
     * <tt>unique</tt> parameter.
     */
    public Collection<EObject> reverseNavigate(EObject from, EReference forwardReference, QueryContext scope, ResourceSet rs, boolean unique) {
        Collection<EObject> result = createEList(unique);
        reverseNavigate(from, forwardReference, scope, rs);
        return result;
    }
    
    /**
     * Navigates along the <tt>to</tt> reference, starting at object <tt>from</tt>. The reference
     * can (and usually will) be a "hidden opposite" which is owned by another {@link EReference}
     * (see also {@link EReference#getOwnedOpposite()}). The <tt>to</tt> reference has to have
     * a valid {@link EReference#getEOpposite() opposite}.
     */
    public Collection<EObject> navigateByQuery(EObject from, EReference to, QueryContext scope, ResourceSet rs) {
        return reverseNavigate(from, to.getEOpposite(), scope, rs);
    }

    /**
     * Same as {@link #navigateByQuery(EObject, EReference, QueryContext, ResourceSet)}, only that the
     * {@link ResourceSet} is determined from the <tt>from</tt> object
     */
    public Collection<EObject> navigateByQuery(EObject from, EReference to, QueryContext scope) {
        return reverseNavigate(from, to.getEOpposite(), scope, from.eResource().getResourceSet());
    }
    
    /**
     * Same as {@link #reverseNavigate(EObject, EReference, QueryContext, ResourceSet)}, only that
     * <tt>forwardReference</tt> does not have to have an {@link EReference#getEOpposite() opposite}.
     * Instead, a collection is passed in to which the result are added. Therefore, the opposite
     * reference is not required, as no uniqueness attribute needs to be determined.
     * 
     * @param rs used to resolve the element URIs resulting from the query
     */
    public void reverseNavigate(EObject from, EReference forwardReference, QueryContext scope, ResourceSet rs, Collection<EObject> result) {
        if (forwardReference.isContainment()) {
            EObject container = from.eContainer();
            if (container != null) {
                if ((forwardReference.isMany() && ((Collection<?>) container.eGet(forwardReference)).contains(from))
                        || (!forwardReference.isMany() && container == from)) {
                    result.add(container);
                }
            }
        } else {
            EClass owningType = getOwningType(forwardReference);
            final ResultSet resultSet = getQueryProcessor().execute(
                            "select target from [" + EcoreUtil.getURI(from.eClass()) + "] as source in elements {[" + //$NON-NLS-1$
                                    EcoreUtil.getURI(from) + "]}, [" + EcoreUtil.getURI(owningType) + "] as target "
                                    + "where target.\"" + forwardReference.getName() + "\" = source ", scope); //$NON-NLS-1$
            for (int i = 0; i < resultSet.getSize(); i++) {
                result.add(rs.getEObject(resultSet.getUri(i, "target"), /* loadOnDemand */true)); //$NON-NLS-1$
            }
        }
    }

    private QueryProcessor getQueryProcessor() {
        if (queryProcessor == null) {
            queryProcessor = QueryProcessorFactory.getDefault().createQueryProcessor(IndexFactory.getInstance());
        }
        return queryProcessor;
    }

    /**
     * Same as {@link #reverseNavigate(EObject, EReference, QueryContext, ResourceSet, Collection)}, only
     * that the resource set is determined from the <tt>from</tt> object.
     */
    public void reverseNavigate(EObject from, EReference forwardReference, QueryContext scope, Collection<EObject> result) {
        reverseNavigate(from, forwardReference, scope, from.eResource().getResourceSet(), result);
    }
    
    /**
     * Constructs a query context that contains all of <tt>rs</tt>'s resources and all
     * metamodel resources
     */
    public QueryContext getQueryContext(final ResourceSet rs) {
        return new QueryContext() {
                public URI[] getResourceScope() {
                        final List<URI> result = new ArrayList<URI>();
                        IndexFactory.getInstance().executeQueryCommand(new QueryCommand() {
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
    
    public void addResourceToDefaultIndex(final Resource... resources) {
        IndexFactory.getInstance().executeUpdateCommand(new UpdateCommandAdapter() {
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

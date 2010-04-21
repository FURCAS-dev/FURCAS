package de.hpi.sam.bp2009.solution.oclToAst;

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
import org.eclipse.emf.query2.EmfHelper;
import org.eclipse.emf.query2.QueryContext;
import org.eclipse.emf.query2.QueryProcessorFactory;
import org.eclipse.emf.query2.ResultSet;

public class EcoreHelper {
    private static EcoreHelper instance;
    
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
    
    private EList<EObject> createEList(EReference ref) {
        EList<EObject> result;
        if (ref.isUnique()) {
            result = new UniqueEList<EObject>();
        } else {
            result = new BasicEList<EObject>();
        }
        return result;
    }
    
    /**
     * Traverses <tt>forwardReference</tt> in reverse, that is, looks for objects that, when starting
     * from them and navigating <tt>forwardReference</tt>, it results in <tt>from</tt>.
     */
    public Collection<EObject> reverseNavigate(EObject from, EReference forwardReference, QueryContext scope, ResourceSet rs) {
        Collection<EObject> result = createEList(forwardReference.getEOpposite());
        EClass owningType = getOwningType(forwardReference);
        final ResultSet resultSet = QueryProcessorFactory.getDefault().createQueryProcessor(IndexFactory.getInstance()).execute(
                "select target from [" + EcoreUtil.getURI(from.eClass()) + "] as source in elements {[" + //$NON-NLS-1$
                        EcoreUtil.getURI(from) + "]}, [" + EcoreUtil.getURI(owningType) + "] as target "
                        + "where target.\"" + forwardReference.getName() + "\" = source ", getQueryContext(rs)); //$NON-NLS-1$
        for (int i = 0; i < resultSet.getSize(); i++) {
            result.add(rs.getEObject(resultSet.getUri(i, "target"), /* loadOnDemand */true)); //$NON-NLS-1$
        }
        return result;
    }

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
}

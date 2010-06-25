package com.sap.ocl.oppositefinder.query2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.query.index.query.IndexQueryFactory;
import org.eclipse.emf.query.index.query.QueryCommand;
import org.eclipse.emf.query.index.query.QueryExecutor;
import org.eclipse.emf.query.index.query.ResourceQuery;
import org.eclipse.emf.query.index.query.descriptors.ResourceDescriptor;
import org.eclipse.emf.query.index.ui.IndexFactory;
import org.eclipse.emf.query2.EcoreHelper;
import org.eclipse.emf.query2.QueryContext;
import org.eclipse.ocl.ecore.DefaultOppositeEndFinder;

public class Query2OppositeEndFinder extends DefaultOppositeEndFinder {
    @Override
    public Object navigateOppositeProperty(EStructuralFeature property, Object target)
            throws IllegalArgumentException {
        if (target instanceof EObject) {
            EObject etarget = (EObject) target;
            Collection<EObject> result = null;
            if (property instanceof EReference && ((EClass) ((EReference) property).getEType()).isSuperTypeOf(etarget.eClass())) {
                QueryContext queryContext = getQueryContext(etarget);
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

    /**
     * Provides a query context that contains all resources known to the current query2 index
     */
    private static QueryContext getWorkspaceQueryContext(final ResourceSet rs) {

        return new QueryContext() {

            public URI[] getResourceScope() {
                final List<URI> result = new ArrayList<URI>();
                IndexFactory.getInstance().executeQueryCommand(new QueryCommand() {

                    public void execute(QueryExecutor queryExecutor) {
                        ResourceQuery<ResourceDescriptor> resourceQuery = IndexQueryFactory.createResourceQuery();
                        for (ResourceDescriptor desc : queryExecutor.execute(resourceQuery)) {
                            result.add(desc.getURI());
                        }
                        for (Resource r : rs.getResources()) {
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

    private QueryContext getQueryContext(EObject etarget) {
        ResourceSet rs = null;
        if (etarget.eResource() != null) {
                rs = etarget.eResource().getResourceSet();
        }
        if (rs == null) {
                rs = new ResourceSetImpl();
        }
        return getWorkspaceQueryContext(rs);
    }

}

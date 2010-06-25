package com.sap.ocl.oppositefinder.query2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
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
import org.eclipse.emf.query2.EcoreHelper;
import org.eclipse.emf.query2.QueryContext;
import org.eclipse.emf.query2.QueryProcessorFactory;
import org.eclipse.emf.query2.ResultSet;
import org.eclipse.ocl.ecore.DefaultOppositeEndFinder;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.VoidType;

public class Query2OppositeEndFinder extends DefaultOppositeEndFinder {
    public void findOppositeEnds(EClassifier classifier, String name, List<EStructuralFeature> ends) {

        if (!(classifier instanceof VoidType)) { // OclVoid has no properties, not even opposites
            ResourceSet rs = classifier.eResource().getResourceSet();
            if (rs == null) {
                rs = new ResourceSetImpl();
            }
            StringBuilder allClassifierSupertypeUris = new StringBuilder();
            allClassifierSupertypeUris.append('[');
            allClassifierSupertypeUris.append(EcoreUtil.getURI(classifier));
            allClassifierSupertypeUris.append("]"); //$NON-NLS-1$
            if (classifier instanceof EClass) { // don't do this for the VoidType
                for (EClass supertype : ((EClass) classifier).getEAllSuperTypes()) {
                    allClassifierSupertypeUris.append(',');
                    allClassifierSupertypeUris.append('[');
                    allClassifierSupertypeUris.append(EcoreUtil.getURI(supertype));
                    allClassifierSupertypeUris.append(']');
                }
            }
            final ResultSet result = QueryProcessorFactory.getDefault().createQueryProcessor(IndexFactory.getInstance()).execute(
                    "select oppositeParent from [http://www.eclipse.org/emf/2002/Ecore#//EReference] as oppositeParent, " + //$NON-NLS-1$
                            "[http://www.eclipse.org/emf/2002/Ecore#//EAnnotation] as annotation, " + //$NON-NLS-1$
                            "[http://www.eclipse.org/emf/2002/Ecore#//EStringToStringMapEntry] as detail, " + //$NON-NLS-1$
                            "[http://www.eclipse.org/emf/2002/Ecore#//EClassifier] as classifier in elements {" + //$NON-NLS-1$
                            allClassifierSupertypeUris + "} " + //$NON-NLS-1$
                            "where oppositeParent.eAnnotations = annotation " + //$NON-NLS-1$
                            "where annotation.details = detail " + //$NON-NLS-1$
                            "where detail.key = '" //$NON-NLS-1$
                            + EcoreEnvironment.PROPERTY_OPPOSITE_ROLE_NAME_KEY + "' " + //$NON-NLS-1$ 
                            "where detail.value = '" + name + "' " + //$NON-NLS-1$ //$NON-NLS-2$
                            "where oppositeParent.eType = classifier", //$NON-NLS-1$
                    getWorkspaceQueryContext(rs));
            for (int i = 0; i < result.getSize(); i++) {
                ends.add((EReference) rs.getEObject(result.getUri(i, "oppositeParent"), /* loadOnDemand */true)); //$NON-NLS-1$
            }
        }
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

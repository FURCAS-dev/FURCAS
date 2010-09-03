package com.sap.mi.textual.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.query.index.query.IndexQueryFactory;
import org.eclipse.emf.query.index.query.QueryCommand;
import org.eclipse.emf.query.index.query.QueryExecutor;
import org.eclipse.emf.query.index.query.ResourceQuery;
import org.eclipse.emf.query.index.query.descriptors.ResourceDescriptor;
import org.eclipse.emf.query.index.ui.IndexFactory;
import org.eclipse.emf.query2.QueryContext;

public class EcoreHelper {

	public static EModelElement lookupElementExtended(EClassifier classifier, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Set<EReference> getUnexposedReferences(EObject classifier,
			boolean b) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Constructs a query context that contains all of <tt>rs</tt>'s resources and all
	 * metamodel resources
	 */
	public static QueryContext getQueryContext(final ResourceSet rs) {
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

	public static Object getOutermostPackage(EObject element) {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<String> getQualifiedName(EClassifier refObject) {
		// TODO Auto-generated method stub
		return null;
	}

}

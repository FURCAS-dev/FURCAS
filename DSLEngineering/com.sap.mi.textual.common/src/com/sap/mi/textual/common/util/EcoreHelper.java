package com.sap.mi.textual.common.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query.index.query.IndexQueryFactory;
import org.eclipse.emf.query.index.query.QueryCommand;
import org.eclipse.emf.query.index.query.QueryExecutor;
import org.eclipse.emf.query.index.query.ResourceQuery;
import org.eclipse.emf.query.index.query.descriptors.ResourceDescriptor;
import org.eclipse.emf.query.index.ui.IndexFactory;
import org.eclipse.emf.query2.QueryContext;
import org.eclipse.emf.query2.QueryProcessor;
import org.eclipse.emf.query2.QueryProcessorFactory;
import org.eclipse.emf.query2.ResultSet;

import com.sap.mi.textual.common.exceptions.MetaModelLookupException;

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
	            @Override
				public URI[] getResourceScope() {
	                    final List<URI> result = new ArrayList<URI>();
	                    IndexFactory.getInstance().executeQueryCommand(new QueryCommand() {
	                            @Override
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
	
	            @Override
				public ResourceSet getResourceSet() {
	                    return rs;
	            }
	    };
	}
	
	/**
	 * Constructs a query context that contains all all resources given as <tt>resources</tt>.
	 */
	public static QueryContext getQueryContext(final ResourceSet rs, final Set<URI> resources) {
	    return new QueryContext() {
	            @Override
				public URI[] getResourceScope() {
	                    final List<URI> result = new ArrayList<URI>();
	                    IndexFactory.getInstance().executeQueryCommand(new QueryCommand() {
	                            @Override
								public void execute(QueryExecutor queryExecutor) {
	                                    ResourceQuery<ResourceDescriptor> resourceQuery = IndexQueryFactory.createResourceQuery();
	                                    for (ResourceDescriptor desc : queryExecutor.execute(resourceQuery)) {
	                                            result.add(desc.getURI());
	                                    }
	                                   result.addAll(resources);
	                            }
	                    });
	                    return result.toArray(new URI[0]);
	            }
	
	            @Override
				public ResourceSet getResourceSet() {
	                    return rs;
	            }
	    };
	}

	public static EPackage getOutermostPackage(EObject element) {
		EObject parent = EcoreUtil.getRootContainer(element);
		if(parent instanceof EPackage) {
			return (EPackage) parent;
		} else {
			return null;
		}
	}

	/**
	 * @param query
	 * @param resourceSet 
	 * @return
	 * @throws MetaModelLookupException 
	 */
	public static ResultSet executeQuery(String query, ResourceSet resourceSet,  Set<URI> resourceURIs) throws MetaModelLookupException {
	    try {
	        QueryProcessor processor = QueryProcessorFactory.getDefault().createQueryProcessor(IndexFactory.getInstance());

	        ResultSet resultSet = processor.execute(query, EcoreHelper.getQueryContext(resourceSet, resourceURIs));
	        return resultSet;
	    } catch (RuntimeException rte) {
	        throw new MetaModelLookupException("Exception while making query: " + query + "\n Message :" + rte.getMessage(), rte);
	    }
	}
	
	/**
	 * @param query
	 * @param resourceSet 
	 * @return
	 * @throws MetaModelLookupException 
	 */
	public static ResultSet executeQuery(String query, ResourceSet resourceSet, QueryContext context) throws MetaModelLookupException {
	    try {
	        QueryProcessor processor = QueryProcessorFactory.getDefault().createQueryProcessor(IndexFactory.getInstance());

	        ResultSet resultSet = processor.execute(query, context);
	        return resultSet;
	    } catch (RuntimeException rte) {
	        throw new MetaModelLookupException("Exception while making query: " + query + "\n Message :" + rte.getMessage(), rte);
	    }
	}
	
	/**
	 * @param query
	 * @param resourceSet 
	 * @return
	 * @throws MetaModelLookupException 
	 */
	public static ResultSet executeQuery(String query, ResourceSet resourceSet) throws MetaModelLookupException {
	    try {
	        QueryProcessor processor = QueryProcessorFactory.getDefault().createQueryProcessor(IndexFactory.getInstance());

	        ResultSet resultSet = processor.execute(query, EcoreHelper.getQueryContext(resourceSet));
	        return resultSet;
	    } catch (RuntimeException rte) {
	        throw new MetaModelLookupException("Exception while making query: " + query + "\n Message :" + rte.getMessage(), rte);
	    }
	}
	
	public static List<String> getQualifiedName(EClassifier element) {
		if(element instanceof EModelElement) {
			List<String> names = new ArrayList<String>();
			names.add(element.getName());
			EObject parent = element.eContainer();
			while(parent != null && parent instanceof ENamedElement) {
				names.add(((ENamedElement) parent).getName());
				parent = parent.eContainer();
			}
			Collections.reverse(names);
			return names;
		}
		return null;
	}

	public static EClass getEObjectElement(ResourceSet resourceSet) {
		// TODO Auto-generated method stub
		return null;
	}

	public static boolean isInstanceOf(EObject refObject, EObject metaType,
			boolean b) {
		// TODO Auto-generated method stub
		return false;
	}

}

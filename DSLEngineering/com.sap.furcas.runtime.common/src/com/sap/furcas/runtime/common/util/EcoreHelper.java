package com.sap.furcas.runtime.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query.index.IndexFactory;
import org.eclipse.emf.query.index.query.IndexQueryFactory;
import org.eclipse.emf.query.index.query.QueryCommand;
import org.eclipse.emf.query.index.query.QueryExecutor;
import org.eclipse.emf.query.index.query.ResourceQuery;
import org.eclipse.emf.query.index.query.descriptors.ResourceDescriptor;
import org.eclipse.emf.query2.Query;
import org.eclipse.emf.query2.QueryContext;
import org.eclipse.emf.query2.QueryProcessor;
import org.eclipse.emf.query2.QueryProcessorFactory;
import org.eclipse.emf.query2.ResultSet;

import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;

import de.hpi.sam.bp2009.solution.queryContextScopeProvider.impl.ProjectDependencyQueryContextProvider;

public class EcoreHelper {

    /**
     * Constructs a query context that contains only the given <tt>resources</tt>.
     */
    public static QueryContext getQueryContext(final ResourceSet resourceSet) {
        return getQueryContext(resourceSet, new HashSet<URI>());
    }
	
    /**
     * Constructs a query context that contains the given <tt>resources</tt> as well as all resources in the given resource set.
     */
    public static QueryContext getQueryContext(final ResourceSet resourceSet, final Set<URI> referenceScope) {
        return new QueryContext() {
            @Override
            public URI[] getResourceScope() {
                Collection<URI> result = new HashSet<URI>(referenceScope);
                for (Resource resource : resourceSet.getResources()) {
                    result.add(resource.getURI());
                }
                return result.toArray(new URI[result.size()]);
            }

            @Override
            public ResourceSet getResourceSet() {
                return resourceSet;
            }
        };
    }
    
    /**
     * Constructs a query context that contains the given <tt>resources</tt> .
     */
    public static QueryContext getRestrictedQueryContext(final ResourceSet resourceSet, final Set<URI> resources) {
        return new QueryContext() {
            @Override
            public URI[] getResourceScope() {
                Collection<URI> result = new HashSet<URI>(resources);
                return result.toArray(new URI[result.size()]);
            }

            @Override
            public ResourceSet getResourceSet() {
                return resourceSet;
            }
        };
    }

    /**
     * Constructs a query context that contains all of <tt>rs</tt>'s resources and all metamodel resources
     */
    public static QueryContext getFullModelUniverseQueryContext(final ResourceSet rs) {
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
                        for (Resource r : rs.getResources()) {
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
    
    public static ProjectDependencyQueryContextProvider createProjectDependencyQueryContextProvider(ResourceSet resourceSet,
            Set<URI> localReferenceScope) {
        
        return new ProjectDependencyQueryContextProvider(getAdditionalScopeSeeds(resourceSet, localReferenceScope));
    }
    
    private static Notifier[] getAdditionalScopeSeeds(ResourceSet resourceSet, Set<URI> referenceScope) {
        Notifier[] result = new Notifier[referenceScope.size()+1];
        int i=0;
        for (URI uri : referenceScope) {
            result[i++] = resourceSet.getResource(uri, /* loadOnDemand */ false);
        }
        result[i] = resourceSet;
        return result;
    }
	

	public static EPackage getOutermostPackage(EObject element) {
		EObject parent = EcoreUtil.getRootContainer(element);
		if(parent instanceof EPackage) {
			return (EPackage) parent;
		} else {
			return null;
		}
	}
	

	public static ResultSet executeQuery(String query, QueryContext context) throws MetaModelLookupException {
	    try {
	        QueryProcessor processor = QueryProcessorFactory.getDefault().createQueryProcessor(IndexFactory.getInstance());
	        ResultSet resultSet = processor.execute(query, context);
	        return resultSet;
	    } catch (RuntimeException rte) {
	        throw new MetaModelLookupException("Exception while making query: " + query + "\n Message :" + rte.getMessage(), rte);
	    }
	}
	
	public static ResultSet executeQuery(Query query, QueryContext context) throws MetaModelLookupException {
	    try {
	        QueryProcessor processor = QueryProcessorFactory.getDefault().createQueryProcessor(IndexFactory.getInstance());
	        ResultSet resultSet = processor.execute(query, context);
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

    /**
     * Returns the classifier within the package with the given name.
     * 
     * This method can also be used to search for sub-parts of the qualified name. For example,
     * if the full qualified name is Pack::SubPack1::SubPack2::MyClassifier" one can also search for 
     * "SubPack2::MyClassifier" or just "MyClassifier".
     * 
     */
    public static EClassifier findClassifierByName(List<String> qualifiedClassifierName, EPackage pack) {
        Iterator<EObject> iter = EcoreUtil.getAllContents(pack, /*resolve*/ false);
        String outmostNamePart = qualifiedClassifierName.get(0);
        // check if it is a full qualified name
        if (outmostNamePart.equals(pack.getName())) {
            return findClassifierByFullQualifiedName(qualifiedClassifierName, pack);
        }
        // handle non-fully qualified name
        while (iter.hasNext()) {
            Object containedObject = iter.next();
            if (!(containedObject instanceof ENamedElement)) {
                continue;
            }
            if (!(outmostNamePart.equals(((ENamedElement) containedObject).getName()))) {
                continue;
            }
            if (containedObject instanceof EPackage) {
                return findClassifierByFullQualifiedName(qualifiedClassifierName, (EPackage) containedObject);
            } else if (containedObject instanceof EClassifier) {
                return (EClassifier) containedObject;
            } else {
                return null;
            }
        }
        return null;
    }
    
    /**
     * Returns the the classifier within the package which specified by a full qualified name
     * such as Pack::SubPack1::SubPack2::MyClassifier"
     */
    public static EClassifier findClassifierByFullQualifiedName(List<String> qualifiedClassifierName, EPackage pack) {
        for (String namePart : qualifiedClassifierName) {
            if (namePart.equals(pack.getName())) {
                continue;
            }
            pack.getEClassifier(namePart);
            EList<EPackage> eSubpackages = pack.getESubpackages();
            for (EPackage ePackage : eSubpackages) {
                if (ePackage.getName().equals(namePart)) {
                    pack = ePackage;
                    continue;
                }
            }
        }
        return pack.getEClassifier(qualifiedClassifierName.get(qualifiedClassifierName.size() - 1));
    }

	public static boolean isAlive(EObject object) {
		//TODO how to check whether an object is alive or not in EMF?
		return object.eResource() != null;
	}

    /**
     * Creates a new resource in the given {@link ResourceSet#} named according to the uri of the 
     * given <code>rootPackage</code> and postfixed with a generated UUID.
     * 
     * @param rootPackage
     *            the {@link EPackage} of the instances stored in the resource.
     *            Used for creating the {@link URI} of the resource.
     */
    public static Resource createTransientParsingResource(ResourceSet resourceSet, EPackage rootPackage) {
        Resource resource = resourceSet.createResource(URI.createURI(
                rootPackage.getNsURI() + "/transientParsingResource" + EcoreUtil.generateUUID()));
        return resource;
    }

}

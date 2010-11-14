/**
 * 
 */
package com.sap.furcas.modeladaptation.emf.lookup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query2.QueryContext;
import org.eclipse.emf.query2.ResultSet;

import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.common.interfaces.ResolvedNameAndReferenceBean;
import com.sap.furcas.runtime.common.util.EcoreHelper;

public class QueryBasedEcoreMetaModelLookUp extends AbstractEcoreMetaModelLookup {

    private final ResourceSet resourceSet;
    private final Set<URI> referenceScope;

    public QueryBasedEcoreMetaModelLookUp(ResourceSet resourceSet) {
        this.resourceSet = resourceSet;
        this.referenceScope = new HashSet<URI>();
        for (Resource resource : resourceSet.getResources()) {
            referenceScope.add(resource.getURI());
        }
    }

    public QueryBasedEcoreMetaModelLookUp(ResourceSet resourceSet, Set<URI> referenceScope) {
        this.resourceSet = resourceSet;
        this.referenceScope = referenceScope;
    }

    /**
     * Constructs a query context that contains only the given <tt>resources</tt>.
     */
    public QueryContext getQueryContext() {
        return new QueryContext() {
            @Override
            public URI[] getResourceScope() {
                Collection<URI> result = new HashSet<URI>(referenceScope);
                for (Resource resource: resourceSet.getResources()) {
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

    @Override
    protected EClassifier getClassifierByName(List<String> qualifiedNameOfType) throws MetaModelLookupException {
        List<EClassifier> list = getClassifiers(qualifiedNameOfType);

        if (list == null || list.size() == 0) {
            return null;
        }
        if (list.size() == 1) {
            return list.get(0);
        } else {
            throw new MetaModelLookupException("Ambiguous classifier name: " + qualifiedNameOfType);
        }
    }

    private List<EClassifier> getClassifiers(List<String> qualifiedNameOfType) throws MetaModelLookupException {
        if (qualifiedNameOfType == null || qualifiedNameOfType.size() == 0) {
            throw new IllegalArgumentException("qualifiedNameOfType must not be empty: " + qualifiedNameOfType);
        }

        // since we cannot query for the qualified name with MQL, query for the
        // name instead, and then compare qualified names to
        // filter out wrong results

        String name = qualifiedNameOfType.get(qualifiedNameOfType.size() - 1);
        List<EClassifier> classifiers = getClassifiers(name);

        if (qualifiedNameOfType.size() > 1) {
            classifiers = filterClassifiers(qualifiedNameOfType, classifiers);
        }
        return classifiers;

    }

    /**
     * removes those classifiers from the list which do not have the correct qualified name
     * 
     * @param qualifiedNameOfType
     * @param classifiers
     */
    protected static List<EClassifier> filterClassifiers(List<String> qualifiedNameOfType, List<EClassifier> classifiers) {
        if (classifiers == null || classifiers.size() == 0 || qualifiedNameOfType == null) {
            return Collections.emptyList();
        }
        List<EClassifier> resultList = new ArrayList<EClassifier>();
        for (EClassifier classifier : classifiers) {
            List<String> otherQualifiedName = EcoreHelper.getQualifiedName(classifier);
            if (otherQualifiedName.equals(qualifiedNameOfType)) {
                resultList.add(classifier);
            }
        }
        return resultList;
    }

    @Override
    protected List<EClassifier> getClassifiers(String name) throws MetaModelLookupException {
        URI uriEClassifier = EcoreUtil.getURI(EcorePackage.eINSTANCE.getEClassifier());
        String query = "select instance \n" + "from [" + uriEClassifier + "] as instance \n" + "where instance.name = '" + name
                + "'";

        List<EClassifier> result = null;

        ResultSet resultSet = EcoreHelper.executeQuery(query, resourceSet, getQueryContext());

        result = new ArrayList<EClassifier>(resultSet.getSize());

        for (int i = 0; i < resultSet.getSize(); i++) {
            URI mri = resultSet.getUri(i, "instance");
            EObject object = resourceSet.getEObject(mri, true);
            if (object != null) {
                EClassifier classifier = (EClassifier) object;
                result.add(classifier);
            }
        }

        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.interfaces.IMetaModelLookup#getDirectSubTypes(java .util.List)
     */
    @Override
    public List<ResolvedNameAndReferenceBean<EObject>> getDirectSubTypes(ResolvedNameAndReferenceBean<EObject> reference)
            throws MetaModelLookupException {

        String name = reference.getNameUnqualified(); // .get(reference.getNames().size()-1);
        URI uriEClassifier = EcoreUtil.getURI(EcorePackage.eINSTANCE.getEClassifier());
        URI uriEClass = EcoreUtil.getURI(EcorePackage.eINSTANCE.getEClass());
        String query = "select instance \n" + "from [" + uriEClass + "] as instance, \n" + "[" + uriEClassifier
                + "] as supertype \n" + "where supertype.name = '" + name + "' where instance.eSuperTypes = supertype";

        List<ResolvedNameAndReferenceBean<EObject>> result = null;

        ResultSet resultSet = EcoreHelper.executeQuery(query, resourceSet, getQueryContext());
        result = new ArrayList<ResolvedNameAndReferenceBean<EObject>>(resultSet.getSize());

        for (int i = 0; i < resultSet.getSize(); i++) {
            URI object = resultSet.getUri(i, "instance");
            if (object != null) {
                EClassifier classifier = (EClassifier) resourceSet.getEObject(object, true);
                result.add(getBean(classifier));
            }
        }
        return result;
    }

    @Override
    public void close() {
        
    }
    
    /**
     * FIXME: Does not work yet, because Syntax has no ID attribute defined and the ContextAndForEachHelper will therefore fail
     */
    @Override
    public List<String> validateOclQuery(Object template, String query, Object context) {
      return Collections.emptyList();
//        if (true) {  // context instanceof EObject && template instanceof Template
//            try {
//                
//                EClassifier parsingContext = ContextAndForeachHelper.getParsingContext(query, (Template) template);
//                
//                OCL ocl = OCLWithHiddenOpposites.newInstance(new Query2OppositeEndFinder(new ProjectDependencyQueryContextProvider()));
//                Helper oclHelper = ocl.createOCLHelper();
//                
//                oclHelper.setContext(parsingContext);
//                oclHelper.setValidating(true);
//                query = ContextAndForeachHelper.prepareOclQuery(query, "__TEMP__");
//                oclHelper.createQuery(query);
//                Diagnostic diagnostic = oclHelper.getProblems();
//                
//                if (diagnostic == null) {
//                    return Collections.emptyList();
//                } else {
//                    return Collections.singletonList(diagnostic.getMessage());
//                }
//
//            } catch (ParserException e) {
//                return Collections.singletonList(e.getDiagnostic().getMessage());
//            } catch (RuntimeException e) {
//                return Collections.singletonList(e.getMessage());
//            }
//        } else {
//            return Collections.singletonList("Failed to check OCL: " + query + " for errors on elements: " + template + ","
//                    + context);
//        }
    }

}

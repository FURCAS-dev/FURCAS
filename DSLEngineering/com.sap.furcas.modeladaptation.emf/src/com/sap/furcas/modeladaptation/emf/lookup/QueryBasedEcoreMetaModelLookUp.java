package com.sap.furcas.modeladaptation.emf.lookup;

import java.util.ArrayList;
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
import org.eclipse.emf.query.index.IndexFactory;
import org.eclipse.emf.query2.QueryContext;
import org.eclipse.emf.query2.QueryProcessor;
import org.eclipse.emf.query2.QueryProcessorFactory;
import org.eclipse.emf.query2.ResultSet;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.opposites.DefaultOppositeEndFinder;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;

import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.runtime.common.interfaces.ResolvedNameAndReferenceBean;
import com.sap.furcas.runtime.common.util.EcoreHelper;
import com.sap.furcas.runtime.common.util.TCSSpecificOCLEvaluator;
import com.sap.ocl.oppositefinder.query2.Query2OppositeEndFinder;

import de.hpi.sam.bp2009.solution.queryContextScopeProvider.QueryContextProvider;


/**
 * A query2 based {@link IMetaModelLookup} implementations.
 */
public class QueryBasedEcoreMetaModelLookUp extends AbstractEcoreMetaModelLookup {

    private final ResourceSet resourceSet;
    private final Set<URI> referenceScope;
    
    private final QueryProcessor queryProcessor;
    private final TCSSpecificOCLEvaluator oclEvaluator;

    public QueryBasedEcoreMetaModelLookUp(ResourceSet resourceSet, Set<URI> referenceScope) {
    	super(DefaultOppositeEndFinder.getInstance()); // FIXME inject OppositeEndFinder
        this.resourceSet = resourceSet;
        this.referenceScope = referenceScope;
        
        queryProcessor = QueryProcessorFactory.getDefault().createQueryProcessor(IndexFactory.getInstance());
        
        QueryContextProvider queryContext = EcoreHelper.createProjectDependencyQueryContextProvider(resourceSet, referenceScope);
        OppositeEndFinder oppositeEndFinder = new Query2OppositeEndFinder(queryContext);
        oclEvaluator = new TCSSpecificOCLEvaluator(oppositeEndFinder);
    }
    
    public QueryBasedEcoreMetaModelLookUp(ResourceSet resourceSet) {
        this(resourceSet, getResourceSetAsScope(resourceSet));
    }
    
    private static Set<URI> getResourceSetAsScope(ResourceSet resourceSet) {
        Set<URI> referenceScope = new HashSet<URI>();
        for (Resource resource : resourceSet.getResources()) {
            referenceScope.add(resource.getURI());
        }
        return referenceScope;
    }

    @Override
    protected EClassifier findClassifiersByQualifiedName(List<String> qualifiedNameOfType) throws MetaModelLookupException {
        if (qualifiedNameOfType == null || qualifiedNameOfType.size() == 0) {
            throw new IllegalArgumentException("qualifiedNameOfType must not be empty: " + qualifiedNameOfType);
        }
        // since we cannot query for the qualified name with MQL, query for the
        // name instead, and then compare qualified names to filter out wrong results
        String name = qualifiedNameOfType.get(qualifiedNameOfType.size() - 1);
        List<EClassifier> classifiers = findClassifiersByUnqualifiedName(name);

        if (qualifiedNameOfType.size() > 1) {
            classifiers = filterClassifiers(qualifiedNameOfType, classifiers);
        }

        if (classifiers == null || classifiers.size() == 0) {
            return null;
        } else if (classifiers.size() == 1) {
            return classifiers.get(0);
        } else {
            throw new MetaModelLookupException("Ambiguous classifier name: " + qualifiedNameOfType +
            		". Either try to use full qualified names, or do not reference several metamodels with" +
            		"the same metaclasses.");
        }
    }

    @Override
    protected List<EClassifier> findClassifiersByUnqualifiedName(String name) throws MetaModelLookupException {
        URI uriEClassifier = EcoreUtil.getURI(EcorePackage.eINSTANCE.getEClassifier());
        String query = "select instance \n" + "from [" + uriEClassifier + "] as instance \n" + "where instance.name = '" + name + "'";

        ResultSet resultSet = executeQuery(query);

        List<EClassifier> result = new ArrayList<EClassifier>(resultSet.getSize());
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
    
    /**
     * Removes those classifiers from the list which do not have the correct qualified name
     */
    protected static List<EClassifier> filterClassifiers(List<String> qualifiedNameOfType, List<EClassifier> classifiers) {
        if (classifiers == null || classifiers.size() == 0 || qualifiedNameOfType == null) {
            return Collections.emptyList();
        }
        List<EClassifier> resultList = new ArrayList<EClassifier>();
        for (EClassifier classifier : classifiers) {
            List<String> otherQualifiedName = EcoreHelper.getQualifiedName(classifier);
            if (otherQualifiedName.containsAll(qualifiedNameOfType)) {
                resultList.add(classifier);
            }
        }
        return resultList;
    }

    @Override
    public List<ResolvedNameAndReferenceBean<EObject>> getDirectSubTypes(ResolvedNameAndReferenceBean<EObject> reference)
            throws MetaModelLookupException {

        String name = reference.getNameUnqualified(); // .get(reference.getNames().size()-1);
        URI uriEClassifier = EcoreUtil.getURI(EcorePackage.eINSTANCE.getEClassifier());
        URI uriEClass = EcoreUtil.getURI(EcorePackage.eINSTANCE.getEClass());
        String query = "select instance \n" + "from [" + uriEClass + "] as instance, \n" + "[" + uriEClassifier
                + "] as supertype \n" + "where supertype.name = '" + name + "' where instance.eSuperTypes = supertype";

        List<ResolvedNameAndReferenceBean<EObject>> result = null;

        ResultSet resultSet = executeQuery(query);
        result = new ArrayList<ResolvedNameAndReferenceBean<EObject>>(resultSet.getSize());

        for (int i = 0; i < resultSet.getSize(); i++) {
            URI object = resultSet.getUri(i, "instance");
            if (object != null) {
                EClassifier classifier = (EClassifier) resourceSet.getEObject(object, true);
                result.add(createBean(classifier));
            }
        }
        return result;
    }
    
    private ResultSet executeQuery(String query) {
        try {
            QueryContext scopeProvider = EcoreHelper.getQueryContext(resourceSet, referenceScope);
            ResultSet resultSet = queryProcessor.execute(query, scopeProvider);
            return resultSet;
        } catch (RuntimeException rte) {
            rte.printStackTrace();
            throw rte;
        }
    }

    @Override
    public void close() {
        
    }
    
    @Override
    public List<String> validateOclQuery(Template template, String queryToValidate) {
        return oclEvaluator.validateOclQuery(template, queryToValidate);
    }
    @Override
    public List<String> validateOclQuery(EObject parsingContext, String queryToValidate) {
        if (parsingContext instanceof EClassifier) {
            return oclEvaluator.validateOclQuery((EClassifier) parsingContext, queryToValidate);
        } else {
            return Collections.singletonList("Parsing context must be of type EClassifier. Invalid OCL parsing context " + parsingContext);
        }
    }

    @Override
    public EObject getOclReturnType(EObject parsingContext, String oclQuery) throws MetaModelLookupException {
        try {
            return oclEvaluator.getOclReturnType((EClassifier) parsingContext, oclQuery);
        } catch (ParserException e) {
            throw new MetaModelLookupException("Unable to determine return type of expression " + oclQuery + ": " + e.getMessage(), e);
        }
    }

}

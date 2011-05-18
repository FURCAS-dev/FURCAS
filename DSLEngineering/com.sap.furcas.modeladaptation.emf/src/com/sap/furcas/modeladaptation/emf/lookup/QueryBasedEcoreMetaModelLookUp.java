package com.sap.furcas.modeladaptation.emf.lookup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query.index.IndexFactory;
import org.eclipse.emf.query2.QueryContext;
import org.eclipse.emf.query2.QueryProcessor;
import org.eclipse.emf.query2.QueryProcessorFactory;
import org.eclipse.emf.query2.ResultSet;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;

import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.runtime.common.interfaces.ResolvedNameAndReferenceBean;
import com.sap.furcas.runtime.common.util.EcoreHelper;
import com.sap.furcas.runtime.common.util.MessageUtil;
import com.sap.furcas.runtime.common.util.TCSSpecificOCLEvaluator;
import com.sap.ocl.oppositefinder.query2.Query2OppositeEndFinder;

import de.hpi.sam.bp2009.solution.queryContextScopeProvider.QueryContextProvider;


/**
 * A query2 based {@link IMetaModelLookup} implementations.
 */
public class QueryBasedEcoreMetaModelLookUp extends AbstractEcoreMetaModelLookup {

    /**
     * A simple scope provider that can only be used to navigate with interconnected
     * metamodels.
     */
    private class MetamodelQueryContextProvider implements QueryContextProvider {
        @Override
        public QueryContext getForwardScopeQueryContext(Notifier context) {
            return EcoreHelper.getRestrictedQueryContext(resourceSet, metaModelURIs);
        }
        @Override
        public QueryContext getBackwardScopeQueryContext(Notifier context) {
            return EcoreHelper.getRestrictedQueryContext(resourceSet, metaModelURIs);
        }
    }
    
    private final ResourceSet resourceSet;
    private final Set<URI> metaModelURIs;
    
    private final QueryProcessor queryProcessor;
    private final OppositeEndFinder oppositeEndFinder;
    private final TCSSpecificOCLEvaluator oclEvaluator;
    private final Map<List<String>, EClassifier> typeCache = new WeakHashMap<List<String>, EClassifier>();

    public QueryBasedEcoreMetaModelLookUp(ResourceSet resourceSet, Set<URI> metaModelURIs) {
        this.resourceSet = resourceSet;
        this.metaModelURIs = metaModelURIs;
        
        queryProcessor = QueryProcessorFactory.getDefault().createQueryProcessor(IndexFactory.getInstance());
        
        oppositeEndFinder = new Query2OppositeEndFinder(new MetamodelQueryContextProvider());
        oclEvaluator = new TCSSpecificOCLEvaluator(oppositeEndFinder);
    }
    
    @Override
    protected EClassifier findClassifiersByQualifiedName(List<String> qualifiedNameOfType) throws MetaModelLookupException {
        if (qualifiedNameOfType == null || qualifiedNameOfType.size() == 0) {
            throw new IllegalArgumentException("qualifiedNameOfType must not be empty: " + qualifiedNameOfType);
        }
        EClassifier result = typeCache .get(qualifiedNameOfType);
        if(result == null) {
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
                result = classifiers.get(0);
                typeCache.put(qualifiedNameOfType, result);
            } else {
                throw new MetaModelLookupException("Ambiguous classifier name " + MessageUtil.asModelName(qualifiedNameOfType)
                        + ". There are more than one class of that name within the metamodels " + MessageUtil.asMetaModelNames(metaModelURIs)
                        + ". Please use sufficiently qualified names.");
            }
        }
        return result;
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
        URI uriEClassifier = EcoreUtil.getURI(EcorePackage.eINSTANCE.getEClassifier());
        URI uriEClass = EcoreUtil.getURI(EcorePackage.eINSTANCE.getEClass());
      
        String query = "select instance \n" + "from [" + uriEClass + "] as instance , \n" + "[" + uriEClassifier
                + "] as supertype in elements { [" 
                        + EcoreUtil.getURI(reference.getReference())+  "] }\n" + "where instance.eSuperTypes = supertype";

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
            QueryContext scopeProvider = EcoreHelper.getQueryContext(resourceSet, metaModelURIs);
            ResultSet resultSet = queryProcessor.execute(query, scopeProvider);
            return resultSet;
        } catch (RuntimeException rte) {
            rte.printStackTrace();
            throw rte;
        }
    }

    @Override
    public List<Diagnostic> validateOclQuery(Template template, String queryToValidate) {
        return oclEvaluator.validateOclQuery(template, queryToValidate);
    }
    
    @Override
    public List<Diagnostic> validateOclQuery(EObject parsingContext, String queryToValidate) {
        if (parsingContext instanceof EClassifier) {
            return oclEvaluator.validateOclQuery((EClassifier) parsingContext, queryToValidate);
        } else {
            return Collections.singletonList((Diagnostic) new BasicDiagnostic(getClass().getName(), Diagnostic.ERROR, 
                    "Parsing context must be of type EClassifier. Invalid OCL parsing context: \"" + parsingContext + "\"", null));
        }
    }

    @Override
    public EObject getOclReturnType(EObject parsingContext, String oclQuery) throws MetaModelLookupException {
        try {
            return oclEvaluator.getOclReturnType((EClassifier) parsingContext, oclQuery);
        } catch (ParserException e) {
            // Client can call validate to find out what is wrong.
            return null;
        }
    }

    @Override
    protected OppositeEndFinder getOppositeEndFinder() {
        return oppositeEndFinder;
    }

    @Override
    public Set<URI> getMetaModelURIs() {
        return metaModelURIs;
    }

}

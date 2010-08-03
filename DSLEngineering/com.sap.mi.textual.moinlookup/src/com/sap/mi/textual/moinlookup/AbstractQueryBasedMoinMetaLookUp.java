/**
 * 
 */
package com.sap.mi.textual.moinlookup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.metamodel.TCS.Template;
import com.sap.mi.textual.common.exceptions.MetaModelLookupException;
import com.sap.mi.textual.common.exceptions.ModelAdapterException;
import com.sap.mi.textual.common.interfaces.ResolvedNameAndReferenceBean;
import com.sap.mi.textual.common.util.ContextAndForeachHelper;



/**
 *
 */
public abstract class AbstractQueryBasedMoinMetaLookUp extends AbstractEcoreLookup {

    private final ResourceSet connection;

    private static final String MOF14_CONTAINER_NAME = "sap.com/tc/moin/mof_1.4";

//    should not be used directly, always use getter
    private Set<PRI> queryPRIs;

    final Set<CRI> containerScope = new HashSet<CRI>(); 
    
    /**
     * 
     * @param connection
     * @param MOF14_CONTAINER_NAME name of MetaMetaModel, i.e. MOF1.4
     */
    public AbstractQueryBasedMoinMetaLookUp(ResourceSet connection) {
        this.connection = connection;
    }
    
    protected abstract Set<PRI> initQueryPRIs();
      
    protected Set<PRI> getQueryPRIs() {
        if (this.queryPRIs == null) {
            Set<PRI> subclassPRIs = initQueryPRIs();
            if (subclassPRIs != null) {
                this.queryPRIs = new HashSet<PRI>(subclassPRIs.size() + 1);
                this.queryPRIs.addAll(subclassPRIs);
            } else {
                this.queryPRIs = new HashSet<PRI>(1);
            }
//            this.queryPRIs = initQueryPRIs(); // does not work if list is immutable

            boolean primitivesIncluded = false;
            for (Iterator<PRI> iterator = subclassPRIs.iterator(); iterator
                    .hasNext();) {
                PRI pri = iterator.next();
                if ("PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/PrimitiveTypes.moinmm".equals(pri.toString())) {
                    primitivesIncluded = true;
                    break;
                }
            }
            if (! primitivesIncluded) {
                // Include MOF 1.4 primitive Types
                try {
                    PRI primPRI = connection.getSession().getMoin().getFacilityById("PF").getRIFactory().createPri(
                    		"MetaModelDataArea", "sap.com/tc/moin/mof_1.4", "moin/meta/PrimitiveTypes.moinmm");
                    queryPRIs.add(primPRI);
                } catch (Exception e) {
                    // this may happen due to bugs, it is non fatal usually and merely leads to primitiveTypes not being resolved.
                    e.printStackTrace();
                }
            }
        }
        return queryPRIs;
    }

    
    
    /* (non-Javadoc)
     * @see com.sap.mi.textual.moinlookup.AbstractMoinLookup#getClassifier(java.util.List)
     */
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
    
    protected List<EClassifier> getClassifiers(List<String> qualifiedNameOfType) throws MetaModelLookupException { 
        if (qualifiedNameOfType == null || qualifiedNameOfType.size() == 0) {
	    throw new IllegalArgumentException("qualifiedNameOfType must not be empty: " + qualifiedNameOfType);
	}

        // since we cannot query for the qualified name with MQL, query for the name instead, and then compare qualified names to
//        filter out wrong results
        
        String name = qualifiedNameOfType.get(qualifiedNameOfType.size()-1);
        List<EClassifier> classifiers = getClassifiers(name);

        if (qualifiedNameOfType.size() > 1) {

            classifiers = filterClassifiers(qualifiedNameOfType, classifiers);

        } 
        return classifiers;

    }

    /**
     * removes those classifiers from the list which do not have the correct qualified name
     * @param qualifiedNameOfType
     * @param classifiers
     */
    protected static List<EClassifier> filterClassifiers(List<String> qualifiedNameOfType,
            List<EClassifier> classifiers) {
        if (classifiers == null || classifiers.size() == 0 || qualifiedNameOfType == null ) {
            return Collections.emptyList();
        }
        List<EClassifier> resultList = new ArrayList<EClassifier>();
        for (Iterator<EClassifier> iterator = classifiers.iterator(); iterator.hasNext();) {
            EClassifier classifier = iterator.next();
            List<String> otherQualifiedName = classifier.getQualifiedName();
            if (otherQualifiedName.equals(qualifiedNameOfType)) {
                resultList.add(classifier);
            }
        }
        return resultList;
    }

    
    @Override
    protected List<EClassifier> getClassifiers(String name) throws MetaModelLookupException { 

        String query ="select instance \n" + 
        		"from \"" + MOF14_CONTAINER_NAME + "\"#" + "Model::Classifier as instance \n"
        		+ "where instance.name = '" + name + "'";
  
        List<EClassifier> result = null;

        MQLResultSet resultSet = executeQuery(query);

        result = new ArrayList<EClassifier>(resultSet.getSize());

        for (int i = 0; i < resultSet.getSize(); i++) {
            MRI mri = resultSet.getMri(i, "instance");
            EObject object = connection.getElement(mri);
            if (object != null) {
                EClassifier classifier = (EClassifier) object;
                result.add(classifier );
            }
        }
        
        return result;
    }

    

    /**
     * 
     */
    @Override
	protected EReference getAssociationEnd(ResolvedNameAndReferenceBean<EObject> reference,
			String otherEndName) throws MetaModelLookupException {

        		 
    	 EClassifier type = getClassifier(reference);
    	 if(type == null) {
    		 //TODO: Or throw Excption here?
    		 return null;
    	 }
    	 String query = "select aeReturn from \"" + MOF14_CONTAINER_NAME + "\"#" + "Model::AssociationEnd as aeReturn, " +
    	 "\"" + MOF14_CONTAINER_NAME + "\"#" + "Model::AssociationEnd as ae, " +
    	 "\"" + MOF14_CONTAINER_NAME + "\"#" + "Model::Association as assoc, " +
         "\"" + ( (EObject) type ).get___Mri( ) + "\" as t " +
         " where ae.\"type\" = t" +
         " where aeReturn.name = '" + otherEndName + "'" +
         " where aeReturn.container = assoc" +
         " where ae.container = assoc";// +
    	 //" where ae <> aeReturn";

    	 MQLResultSet resultSet = executeQuery(query);             

    	 EReference result = null;
    	 if (resultSet.getSize() == 1) {
    	     EObject object = resultSet.getRefObject(0, "aeReturn");
    	     if (object != null) {
    	         result = ((EReference) object);
    	     }
    	 }

    	 return result;
	}


	/**
	 * @param query
	 * @return
	 * @throws MetaModelLookupException 
	 */
	private MQLResultSet executeQuery(String query) throws MetaModelLookupException {
	    try {
	        MQLProcessor processor = connection.getMQLProcessor();
	        Set<PRI> tempPris = getQueryPRIs();
	        
	        // TODO remove this again or fix otherwise: enforce loading of MOF ROM/OCL partitions
	        connection.getClass(OclExpression.CLASS_DESCRIPTOR).getClass();
	        
	        
            QueryScopeProvider scopeProvider = processor.getQueryScopeProvider(true, tempPris, containerScope);
	        MQLResultSet resultSet = processor.execute(query, scopeProvider);
	        return resultSet;
	    } catch (RuntimeException rte) {
	        throw new MetaModelLookupException("Exception while making query: " + query + "\n Message :" + rte.getMessage(), rte);
	    }
	}
	
    /* (non-Javadoc)
	 * @see com.sap.mi.textual.interfaces.IMetaModelLookup#getDirectSubTypes(java.util.List)
	 */
	public List<ResolvedNameAndReferenceBean<EObject>> getDirectSubTypes(ResolvedNameAndReferenceBean<EObject> reference)
	throws MetaModelLookupException {

 
        String name = reference.getNameUnqualified(); //.get(reference.getNames().size()-1);
        
        String query ="select instance \n" + 
                "from \"" + MOF14_CONTAINER_NAME + "\"#" + "Model::Classifier as instance, \n" +
                "\"" + MOF14_CONTAINER_NAME + "\"#" + "Model::Classifier as supertype \n" +
                "where supertype.name = '" + name + "' where instance.supertypes = supertype";
  
        List<ResolvedNameAndReferenceBean<EObject>> result = null;

        MQLResultSet resultSet = executeQuery(query);
        result = new ArrayList<ResolvedNameAndReferenceBean<EObject>>(resultSet.getSize());

        for (int i = 0; i < resultSet.getSize(); i++) {
            EObject object = resultSet.getRefObject(i, "instance");
            if (object != null) {
                EClassifier classifier = (EClassifier) object;
                result.add(getBean(classifier));
            }
        }

        return result;
	}
	
    
	 
    @Override
    public List<String> validateOclQuery(Object template1, String query, Object context) {
	if (context instanceof EObject && template1 instanceof Template) {
	    EClass contextClass = (EClass) context;
	    Template template = (Template)template1;
	    EClass elementClass = MoinHelper.getReflectElement(connection);
	    try {
		EPackage outermost = MoinHelper.getOutermostPackageThroughClusteredImportsFromMofClass(((RefObject) context)
			.get___Connection(), contextClass);
		Collection<EPackage> packagesForLookup = new ArrayList<EPackage>();
		packagesForLookup.addAll(MoinHelper.getImportedRefPackages(outermost));
		packagesForLookup.add(outermost);
		EObject parsingContext = ContextAndForeachHelper.getParsingContext(connection, query, template,
			packagesForLookup, elementClass);
		query = MoinHelper.prepareOclQuery(
				query, "__TEMP__");
		if (query != null) {
		    String name = "<syntaxcheck>";
		    OclExpressionRegistration registration = (OclExpressionRegistration) connection
			    .getOclRegistryService()
			    .getFreestyleRegistry().getRegistration(
				    name);
		    if (registration != null) {
			connection.getOclRegistryService()
				.getFreestyleRegistry()
				.deleteRegistration(name);
		    }
		    
		    if( connection.getJmiHelper().
	                        getRefClassForMofClass((EClass) context) != null) {
		        EPackage outermostPackageOfMetamodel = connection.getJmiHelper().
                            getRefClassForMofClass((EClass) context).refOutermostPackage();
                        packagesForLookup.addAll(MoinHelper
                                .getImportedRefPackages(outermostPackageOfMetamodel));
                        packagesForLookup.add(outermostPackageOfMetamodel);
                        registration = connection
                            .getOclRegistryService()
                            .getFreestyleRegistry()
                            .createExpressionRegistration(
                                    name,
                                    query,
                                    OclRegistrationSeverity.Info,
                                    new String[] { "TCS Syntax Check" },
                                    parsingContext,
                                    packagesForLookup
                                            .toArray(new EPackage[] {}));
		    } else {
		        ArrayList<EPackage> packages = new ArrayList<EPackage>(MoinHelper
                            .getImportedMofPackages((EPackage) ((EClass) context).refOutermostComposite()));
		        packages.add((EPackage) ((EClass) context).refOutermostComposite());
		        
		        registration = connection
                            .getOclRegistryService()
                            .getFreestyleRegistry()
                            .createExpressionRegistration(
                                    name,
                                    query,
                                    OclRegistrationSeverity.Info,
                                    new String[] { "TCS Syntax Check" },
                                    parsingContext,
                                    packages.toArray(new EPackage[] {}));
		    }
		    
		    
		    
		}
		return Collections.emptyList();
	    } catch (OclManagerException e) {
		String message = e.getMessage();
		if(e.getCause() instanceof ParsingException) {
		    message += ". Reason:" + ((ParsingException)e.getCause()).getReport().toString();
		}
		return Collections.singletonList(message);
	    } catch (ModelAdapterException e) {
		return Collections.singletonList(e.getMessage());
	    } catch (RuntimeException e) {
		return Collections.singletonList(e.getMessage());
	    }
	} else {
	    return Collections.singletonList("Failed to check OCL: " + query + 
		    " for errors on elements: " + template1 +","+context);
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.interfaces.IMetaModelLookup#close()
     */
    public void close() {
	if (this.connection != null) {
	    this.connection.close();
	}
    }

}

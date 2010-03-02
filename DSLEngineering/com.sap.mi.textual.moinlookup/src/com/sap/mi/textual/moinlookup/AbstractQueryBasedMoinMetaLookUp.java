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

import org.omg.ocl.expressions.OclExpression;

import tcs.Template;

import com.sap.mi.textual.common.exceptions.MetaModelLookupException;
import com.sap.mi.textual.common.exceptions.ModelAdapterException;
import com.sap.mi.textual.common.interfaces.ResolvedNameAndReferenceBean;
import com.sap.mi.textual.common.util.ContextAndForeachHelper;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.mql.MQLResultSet;
import com.sap.tc.moin.repository.mql.QueryScopeProvider;
import com.sap.tc.moin.repository.ocl.exceptions.ParsingException;
import com.sap.tc.moin.repository.ocl.freestyle.OclExpressionRegistration;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationSeverity;
import com.sap.tc.moin.textual.moinadapter.adapter.MoinHelper;

/**
 *
 */
public abstract class AbstractQueryBasedMoinMetaLookUp extends AbstractMoinLookup {

    private final Connection connection;

    private static final String MOF14_CONTAINER_NAME = "sap.com/tc/moin/mof_1.4";

//    should not be used directly, always use getter
    private Set<PRI> queryPRIs;

    final Set<CRI> containerScope = new HashSet<CRI>(); 
    
    /**
     * 
     * @param connection
     * @param MOF14_CONTAINER_NAME name of MetaMetaModel, i.e. MOF1.4
     */
    public AbstractQueryBasedMoinMetaLookUp(Connection connection) {
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
    protected Classifier getClassifierByName(List<String> qualifiedNameOfType) throws MetaModelLookupException {
        List<Classifier> list = getClassifiers(qualifiedNameOfType);
        
        if (list == null || list.size() == 0) {
            return null;
        }
        if (list.size() == 1) {
            return list.get(0);
        } else {
            throw new MetaModelLookupException("Ambiguous classifier name: " + qualifiedNameOfType);
        }
    }
    
    protected List<Classifier> getClassifiers(List<String> qualifiedNameOfType) throws MetaModelLookupException { 
        if (qualifiedNameOfType == null || qualifiedNameOfType.size() == 0) {
	    throw new IllegalArgumentException("qualifiedNameOfType must not be empty: " + qualifiedNameOfType);
	}

        // since we cannot query for the qualified name with MQL, query for the name instead, and then compare qualified names to
//        filter out wrong results
        
        String name = qualifiedNameOfType.get(qualifiedNameOfType.size()-1);
        List<Classifier> classifiers = getClassifiers(name);

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
    protected static List<Classifier> filterClassifiers(List<String> qualifiedNameOfType,
            List<Classifier> classifiers) {
        if (classifiers == null || classifiers.size() == 0 || qualifiedNameOfType == null ) {
            return Collections.emptyList();
        }
        List<Classifier> resultList = new ArrayList<Classifier>();
        for (Iterator<Classifier> iterator = classifiers.iterator(); iterator.hasNext();) {
            Classifier classifier = iterator.next();
            List<String> otherQualifiedName = classifier.getQualifiedName();
            if (otherQualifiedName.equals(qualifiedNameOfType)) {
                resultList.add(classifier);
            }
        }
        return resultList;
    }

    
    @Override
    protected List<Classifier> getClassifiers(String name) throws MetaModelLookupException { 

        String query ="select instance \n" + 
        		"from \"" + MOF14_CONTAINER_NAME + "\"#" + "Model::Classifier as instance \n"
        		+ "where instance.name = '" + name + "'";
  
        List<Classifier> result = null;

        MQLResultSet resultSet = executeQuery(query);

        result = new ArrayList<Classifier>(resultSet.getSize());

        for (int i = 0; i < resultSet.getSize(); i++) {
            MRI mri = resultSet.getMri(i, "instance");
            RefBaseObject object = connection.getElement(mri);
            if (object != null) {
                Classifier classifier = (Classifier) object;
                result.add(classifier );
            }
        }
        
        return result;
    }

    

    /**
     * 
     */
    @Override
	protected AssociationEnd getAssociationEnd(ResolvedNameAndReferenceBean<RefObject> reference,
			String otherEndName) throws MetaModelLookupException {

        		 
    	 Classifier type = getClassifier(reference);
    	 if(type == null) {
    		 //TODO: Or throw Excption here?
    		 return null;
    	 }
    	 String query = "select aeReturn from \"" + MOF14_CONTAINER_NAME + "\"#" + "Model::AssociationEnd as aeReturn, " +
    	 "\"" + MOF14_CONTAINER_NAME + "\"#" + "Model::AssociationEnd as ae, " +
    	 "\"" + MOF14_CONTAINER_NAME + "\"#" + "Model::Association as assoc, " +
         "\"" + ( (Partitionable) type ).get___Mri( ) + "\" as t " +
         " where ae.\"type\" = t" +
         " where aeReturn.name = '" + otherEndName + "'" +
         " where aeReturn.container = assoc" +
         " where ae.container = assoc";// +
    	 //" where ae <> aeReturn";

    	 MQLResultSet resultSet = executeQuery(query);             

    	 AssociationEnd result = null;
    	 if (resultSet.getSize() == 1) {
    	     RefObject object = resultSet.getRefObject(0, "aeReturn");
    	     if (object != null) {
    	         result = ((AssociationEnd) object);
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
	public List<ResolvedNameAndReferenceBean<RefObject>> getDirectSubTypes(ResolvedNameAndReferenceBean<RefObject> reference)
	throws MetaModelLookupException {

 
        String name = reference.getNameUnqualified(); //.get(reference.getNames().size()-1);
        
        String query ="select instance \n" + 
                "from \"" + MOF14_CONTAINER_NAME + "\"#" + "Model::Classifier as instance, \n" +
                "\"" + MOF14_CONTAINER_NAME + "\"#" + "Model::Classifier as supertype \n" +
                "where supertype.name = '" + name + "' where instance.supertypes = supertype";
  
        List<ResolvedNameAndReferenceBean<RefObject>> result = null;

        MQLResultSet resultSet = executeQuery(query);
        result = new ArrayList<ResolvedNameAndReferenceBean<RefObject>>(resultSet.getSize());

        for (int i = 0; i < resultSet.getSize(); i++) {
            RefObject object = resultSet.getRefObject(i, "instance");
            if (object != null) {
                Classifier classifier = (Classifier) object;
                result.add(getBean(classifier));
            }
        }

        return result;
	}
	
    
	 
    @Override
    public List<String> validateOclQuery(Object template1, String query, Object context) {
	if (context instanceof RefObject && template1 instanceof Template) {
	    Template template = (Template)template1;
	    Collection<RefPackage> packagesForLookup = new ArrayList<RefPackage>();
	    MofClass elementClass = MoinHelper.getReflectElement(connection);
	    RefObject parsingContext = ContextAndForeachHelper.getParsingContext(connection, query, template, packagesForLookup, elementClass);
	    try {
		query = MoinHelper.prepareOclQuery(
				query, null, "__TEMP__");
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
	                        getRefClassForMofClass((MofClass) context) != null) {
		        RefPackage outermostPackageOfMetamodel = connection.getJmiHelper().
                            getRefClassForMofClass((MofClass) context).refOutermostPackage();
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
                                            .toArray(new RefPackage[] {}));
		    } else {
		        ArrayList<MofPackage> packages = new ArrayList<MofPackage>(MoinHelper
                            .getImportedMofPackages((MofPackage) ((MofClass) context).refOutermostComposite()));
		        packages.add((MofPackage) ((MofClass) context).refOutermostComposite());
		        
		        registration = connection
                            .getOclRegistryService()
                            .getFreestyleRegistry()
                            .createExpressionRegistration(
                                    name,
                                    query,
                                    OclRegistrationSeverity.Info,
                                    new String[] { "TCS Syntax Check" },
                                    parsingContext,
                                    packages.toArray(new MofPackage[] {}));
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

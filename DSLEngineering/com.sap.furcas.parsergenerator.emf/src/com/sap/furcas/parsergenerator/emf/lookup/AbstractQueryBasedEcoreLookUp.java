/**
 * 
 */
package com.sap.furcas.parsergenerator.emf.lookup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query2.ResultSet;

import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.common.interfaces.ResolvedNameAndReferenceBean;
import com.sap.furcas.runtime.common.util.EcoreHelper;

/**
 *
 */
public abstract class AbstractQueryBasedEcoreLookUp extends AbstractEcoreLookup {

    private final ResourceSet resourceSet;

    private static final String ECORE_RESOURCE_NAME = "http://www.eclipse.org/emf/2002/Ecore";

    // should not be used directly, always use getter
    private Set<URI> queryPRIs;

    final Set<URI> containerScope = new HashSet<URI>();

    /**
     * 
     * @param connection
     * @param ECORE_RESOURCE_NAME
     *            name of MetaMetaModel, i.e. MOF1.4
     */
    public AbstractQueryBasedEcoreLookUp(ResourceSet connection) {
	this.resourceSet = connection;
    }

    protected abstract Set<URI> initQueryPRIs();

    protected Set<URI> getQueryPRIs() {
	if (this.queryPRIs == null) {
	    Set<URI> subclassPRIs = initQueryPRIs();
	    if (subclassPRIs != null) {
		this.queryPRIs = new HashSet<URI>(subclassPRIs.size() + 1);
		this.queryPRIs.addAll(subclassPRIs);
	    } else {
		this.queryPRIs = new HashSet<URI>(1);
	    }
	    // this.queryPRIs = initQueryPRIs(); // does not work if list is
	    // immutable

	    boolean primitivesIncluded = false;
	    for (Iterator<URI> iterator = subclassPRIs.iterator(); iterator.hasNext();) {
		URI pri = iterator.next();
		if ("http://www.eclipse.org/emf/2002/Ecore".equals(pri.toString())) {
		    primitivesIncluded = true;
		    break;
		}
	    }
	    if (!primitivesIncluded) {
		// Include Ecore metamodel for primitive types
		try {
		    URI primPRI = URI.createURI("http://www.eclipse.org/emf/2002/Ecore");
		    queryPRIs.add(primPRI);
		} catch (Exception e) {
		    // this may happen due to bugs, it is non fatal usually and
		    // merely leads to primitiveTypes not being resolved.
		    e.printStackTrace();
		}
	    }
	}
	return queryPRIs;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sap.mi.textual.moinlookup.AbstractMoinLookup#getClassifier(java.util
     * .List)
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
     * removes those classifiers from the list which do not have the correct
     * qualified name
     * 
     * @param qualifiedNameOfType
     * @param classifiers
     */
    protected static List<EClassifier> filterClassifiers(List<String> qualifiedNameOfType, List<EClassifier> classifiers) {
	if (classifiers == null || classifiers.size() == 0 || qualifiedNameOfType == null) {
	    return Collections.emptyList();
	}
	List<EClassifier> resultList = new ArrayList<EClassifier>();
	for (Iterator<EClassifier> iterator = classifiers.iterator(); iterator.hasNext();) {
	    EClassifier classifier = iterator.next();
	    List<String> otherQualifiedName = EcoreHelper.getQualifiedName(classifier);
	    if (otherQualifiedName.equals(qualifiedNameOfType)) {
		resultList.add(classifier);
	    }
	}
	return resultList;
    }

    @Override
    protected List<EClassifier> getClassifiers(String name) throws MetaModelLookupException {

	String query = "select instance \n" + "from \"" + ECORE_RESOURCE_NAME + "\"#" + "Model::Classifier as instance \n"
		+ "where instance.name = '" + name + "'";

	List<EClassifier> result = null;

	ResultSet resultSet = EcoreHelper.executeQuery(query, resourceSet);

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

    /**
     * 
     */
    @Override
    protected EReference getAssociationEnd(ResolvedNameAndReferenceBean<EObject> reference, String otherEndName)
	    throws MetaModelLookupException {

	EClassifier type = getClassifier(reference);
	if (type == null) {
	    // TODO: Or throw Excption here?
	    return null;
	}
	String query = "select aeReturn from \"" + ECORE_RESOURCE_NAME + "\"#" + "Model::AssociationEnd as aeReturn, " + "\""
		+ ECORE_RESOURCE_NAME + "\"#" + "Model::AssociationEnd as ae, " + "\"" + ECORE_RESOURCE_NAME + "\"#"
		+ "Model::Association as assoc, " + "\"" + EcoreUtil.getID(type) + "\" as t " + " where ae.\"type\" = t"
		+ " where aeReturn.name = '" + otherEndName + "'" + " where aeReturn.container = assoc"
		+ " where ae.container = assoc";// +
	// " where ae <> aeReturn";

	ResultSet resultSet = EcoreHelper.executeQuery(query, resourceSet);

	EReference result = null;
	if (resultSet.getSize() == 1) {
	    URI object = resultSet.getUri(0, "aeReturn");
	    if (object != null) {
		result = (EReference) resourceSet.getEObject(object, true);
	    }
	}

	return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sap.mi.textual.interfaces.IMetaModelLookup#getDirectSubTypes(java
     * .util.List)
     */
    @Override
    public List<ResolvedNameAndReferenceBean<EObject>> getDirectSubTypes(ResolvedNameAndReferenceBean<EObject> reference)
	    throws MetaModelLookupException {

	String name = reference.getNameUnqualified(); // .get(reference.getNames().size()-1);

	String query = "select instance \n" + "from \"" + ECORE_RESOURCE_NAME + "\"#" + "Model::Classifier as instance, \n"
		+ "\"" + ECORE_RESOURCE_NAME + "\"#" + "Model::Classifier as supertype \n" + "where supertype.name = '" + name
		+ "' where instance.supertypes = supertype";

	List<ResolvedNameAndReferenceBean<EObject>> result = null;

	ResultSet resultSet = EcoreHelper.executeQuery(query, resourceSet);
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
    public List<String> validateOclQuery(Object template1, String query, Object context) {
	return Collections.singletonList("TODO: Implement validation!");
	// TODO Implement for Ecore!
	// if (context instanceof EObject && template1 instanceof Template) {
	// EClass contextClass = (EClass) context;
	// Template template = (Template)template1;
	// EClass elementClass = EcoreHelper.getEObjectElement(resourceSet);
	// try {
	// EPackage outermost = (EPackage)
	// EcoreHelper.getOutermostPackage((EObject) context);
	// Collection<EPackage> packagesForLookup = new ArrayList<EPackage>();
	// packagesForLookup.addAll(MoinHelper.getImportedRefPackages(outermost));
	// packagesForLookup.add(outermost);
	// EObject parsingContext =
	// ContextAndForeachHelper.getParsingContext(resourceSet, query,
	// template,
	// packagesForLookup, elementClass);
	// query = MoinHelper.prepareOclQuery(
	// query, "__TEMP__");
	// if (query != null) {
	// String name = "<syntaxcheck>";
	// OclExpressionRegistration registration = (OclExpressionRegistration)
	// resourceSet
	// .getOclRegistryService()
	// .getFreestyleRegistry().getRegistration(
	// name);
	// if (registration != null) {
	// resourceSet.getOclRegistryService()
	// .getFreestyleRegistry()
	// .deleteRegistration(name);
	// }
	//
	// if( resourceSet.getJmiHelper().
	// getRefClassForMofClass((EClass) context) != null) {
	// EPackage outermostPackageOfMetamodel = resourceSet.getJmiHelper().
	// getRefClassForMofClass((EClass) context).refOutermostPackage();
	// packagesForLookup.addAll(MoinHelper
	// .getImportedRefPackages(outermostPackageOfMetamodel));
	// packagesForLookup.add(outermostPackageOfMetamodel);
	// registration = resourceSet
	// .getOclRegistryService()
	// .getFreestyleRegistry()
	// .createExpressionRegistration(
	// name,
	// query,
	// OclRegistrationSeverity.Info,
	// new String[] { "TCS Syntax Check" },
	// parsingContext,
	// packagesForLookup
	// .toArray(new EPackage[] {}));
	// } else {
	// ArrayList<EPackage> packages = new ArrayList<EPackage>(MoinHelper
	// .getImportedMofPackages((EPackage) ((EClass)
	// context).refOutermostComposite()));
	// packages.add((EPackage) ((EClass) context).getEPackage());
	//
	// registration = resourceSet
	// .getOclRegistryService()
	// .getFreestyleRegistry()
	// .createExpressionRegistration(
	// name,
	// query,
	// OclRegistrationSeverity.Info,
	// new String[] { "TCS Syntax Check" },
	// parsingContext,
	// packages.toArray(new EPackage[] {}));
	// }
	//

	// }
	// return Collections.emptyList();
	// } catch (OclManagerException e) {
	// String message = e.getMessage();
	// if(e.getCause() instanceof ParsingException) {
	// message += ". Reason:" +
	// ((ParsingException)e.getCause()).getReport().toString();
	// }
	// return Collections.singletonList(message);
	// } catch (ModelAdapterException e) {
	// return Collections.singletonList(e.getMessage());
	// } catch (RuntimeException e) {
	// return Collections.singletonList(e.getMessage());
	// }
	// } else {
	// return Collections.singletonList("Failed to check OCL: " + query +
	// " for errors on elements: " + template1 +","+context);
	// }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.interfaces.IMetaModelLookup#close()
     */
    @Override
    public void close() {
	if (this.resourceSet != null) {
	    // TODO how to close a ResourceSet??
	}
    }

}

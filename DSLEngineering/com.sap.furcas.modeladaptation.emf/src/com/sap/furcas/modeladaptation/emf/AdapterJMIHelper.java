/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2008-04-10 13:55:50 +0200 (Do, 10 Apr 2008) $
 * @version $Revision: 859 $
 * @author: $Author: c5107456 $
 *******************************************************************************/
package com.sap.furcas.modeladaptation.emf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query.index.ui.IndexFactory;
import org.eclipse.emf.query2.FromEntry;
import org.eclipse.emf.query2.FromType;
import org.eclipse.emf.query2.LocalWhereEntry;
import org.eclipse.emf.query2.Operation;
import org.eclipse.emf.query2.Query;
import org.eclipse.emf.query2.QueryContext;
import org.eclipse.emf.query2.QueryProcessor;
import org.eclipse.emf.query2.QueryProcessorFactory;
import org.eclipse.emf.query2.ResultSet;
import org.eclipse.emf.query2.SelectAlias;
import org.eclipse.emf.query2.SelectEntry;
import org.eclipse.emf.query2.WhereClause;
import org.eclipse.emf.query2.WhereEntry;
import org.eclipse.emf.query2.WhereString;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCLExpression;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import com.sap.emf.ocl.hiddenopposites.OCLWithHiddenOpposites;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.exceptions.ReferenceSettingException;
import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;
import com.sap.furcas.runtime.common.util.ContextAndForeachHelper;
import com.sap.furcas.runtime.common.util.EcoreHelper;
import com.sap.ocl.oppositefinder.query2.Query2OppositeEndFinder;

import de.hpi.sam.bp2009.solution.queryContextScopeProvider.impl.ProjectDependencyQueryContextProvider;

/**
 * Util class containing methods dealing with MOIN JMI specific functionality.
 * 
 * @author C5107456
 * 
 */
public class AdapterJMIHelper {

    public static class AssociationBean {

        public final EReference refAss;
        public final boolean isFirst;

        public AssociationBean(EReference refAss, boolean isFirst) {
            this.refAss = refAss;
            this.isFirst = isFirst;
        }
    }

    private final EPackage rootPackage;
    private final ResourceSet resourceSet;
    private final Set<URI> referenceScope;

    private final Resource transientResource;

    private final QueryProcessor queryProcessor;
    private static final String MQL_ALIAS_INSTANCE = "instance";
    
    private static final String QUERY_PARAM_NAME = "\\?";
    
    private final OCL ocl;
    private final Helper oclHelper;

    
    
    public AdapterJMIHelper(EPackage rootPackage, ResourceSet resourceSet, Collection<URI> explicitReferenceScope) {
        this.rootPackage = rootPackage;
        this.resourceSet = resourceSet;

        ocl = OCLWithHiddenOpposites.newInstance(new Query2OppositeEndFinder(new ProjectDependencyQueryContextProvider()));
        oclHelper = ocl.createOCLHelper();

        queryProcessor = QueryProcessorFactory.getDefault().createQueryProcessor(IndexFactory.getInstance());

        referenceScope = new HashSet<URI>(explicitReferenceScope);
        referenceScope.add(EcoreUtil.getURI(rootPackage.eClass()));

        transientResource = resourceSet.createResource(URI.createURI("http://" + rootPackage.getNsURI()
                + "/transientParsingResource"));
        referenceScope.add(transientResource.getURI());

        // TODO: still needed in EMF?
        // packagesForLookup = new ArrayList<EPackage>();
        // // TODO check how this works in Ecore packagesForLookup.addAll(MoinHelper.getImportedEPackages(root));
        // packagesForLookup.add(rootPackage);
        // for (EPackage pack : packagesForLookup) {
        // referenceScope.add(rootPackage.eClass().eResource().getURI());
        // }
    }

    public EObject findEObjectOfType(List<String> targetType, String targetKeyName, Object targetKeyValue)
            throws ReferenceSettingException {
        EObject returnRefObject = null;

        URI qName = getMetaElementUri(targetType.toArray(new String[targetType.size()]));

        SelectEntry se = new SelectAlias(MQL_ALIAS_INSTANCE);
        FromEntry fe = new FromType(MQL_ALIAS_INSTANCE, qName, false);
        WhereClause clause = new WhereString(targetKeyName, Operation.EQUAL, String.valueOf(targetKeyValue));
        WhereEntry we = new LocalWhereEntry(MQL_ALIAS_INSTANCE, clause);
        Query mq = new Query(new SelectEntry[] { se }, new FromEntry[] { fe }, new WhereEntry[] { we });
        Set<URI> partScope = referenceScope;
        QueryContext scopeProvider = EcoreHelper.getQueryContext(resourceSet, partScope);
        ResultSet mrs = queryProcessor.execute(mq, scopeProvider); // ,
        // QueryProcessor.getInclusivePartitionScopeProvider(
        // ));
        if (mrs != null && mrs.getSize() > 0) {
            URI[] uris = mrs.getUris(MQL_ALIAS_INSTANCE);
            if (uris == null || uris.length == 0) {
                throw new ReferenceSettingException("Array of found RefObjects is null or empty: " + uris + " for search "
                        + MessageUtil.asModelName(targetType) + " with " + targetKeyName + " = " + targetKeyValue);
            }
            if (uris.length > 1) {
                throw new ReferenceSettingException("Found more than one candidate RefObjects (" + uris.length + ") for search "
                        + MessageUtil.asModelName(targetType) + " with " + targetKeyName + " = " + targetKeyValue);
            }
            returnRefObject = resourceSet.getEObject(uris[0], true);
        }
        return returnRefObject;

    }

    /**
     * @param type
     * @return
     */
    public EObject[] getElementsOfType(String targetType) {
        URI qName = getMetaElementUri(targetType);
        // String[] qName = (String[]) qname.toArray(new String[] {});

        SelectEntry se = new SelectAlias(MQL_ALIAS_INSTANCE);
        FromEntry fe = new FromType(MQL_ALIAS_INSTANCE, qName, true);
        Query mq = new Query(new SelectEntry[] { se }, new FromEntry[] { fe });
        Set<URI> partScope = referenceScope;
        QueryContext scopeProvider = EcoreHelper.getQueryContext(resourceSet, partScope);
        ResultSet mrs = queryProcessor.execute(mq, scopeProvider); // ,

        Set<EObject> eObjects = new HashSet<EObject>();
        for (URI uri : mrs.getUris(MQL_ALIAS_INSTANCE)) {
            eObjects.add(resourceSet.getEObject(uri, true));
        }
        return eObjects.toArray(new EObject[eObjects.size()]);
    }

    /**
     * returns a a modelElement or a mock object for StructureTypes.
     * 
     * @param typeName
     * @return
     * @throws ModelAdapterException
     */
    public Object createObject(List<String> qualifiedNameList) throws ModelAdapterException {
        // List<String> qualifiedNameList =
        // Arrays.asList(getQualifiedName(typeName));

        EModelElement modelElement = EcoreHelper.findElementByQualifiedName(qualifiedNameList, rootPackage);
        if (modelElement != null) {
            if (modelElement instanceof EClass) {
                EClass mofClass = (EClass) modelElement;
                EObject created = EcoreUtil.create(mofClass);
                transientResource.getContents().add(created);
                return created;
            } else if (modelElement instanceof EDataType) {
                EDataType structype = (EDataType) modelElement;
                StructureTypeMockObject mock = new StructureTypeMockObject(structype);
                // FIXME: resource assignment needed?
                return mock;
            } else {
                throw new RuntimeException("EModelElement Class " + modelElement.getClass()
                        + " RefClass lookup not supported yet.");
            }

        } else {
            throw new ModelAdapterException("No modelElement found for qualifiedName "
                    + MessageUtil.asModelName(qualifiedNameList) + " in package " + rootPackage);
        }
    }

    /**
     * creates a mock or throws an exception if e.g. required fields are not set.
     * 
     * @param mock
     * @throws ModelAdapterException
     */
    public Object actualCreateFromMock(StructureTypeMockObject mock) {
        // StructureType type = mock.getStructureType();
        // List<Object> params = new ArrayList<Object>();
        // List<EModelElement> fields = type.getContents();
        // for (Iterator<EModelElement> iterator = fields.iterator(); iterator
        // .hasNext();) {
        // EModelElement contentElement = iterator.next();
        // if (contentElement instanceof StructureField) {
        // StructureField strucField = (StructureField) contentElement;
        // Object value = mock.getStructureField(strucField.getName());
        // if(value == null) {
        // value = getDefaultValue(strucField);
        // }
        // params.add(value);
        // }
        // }
        //
        // RefStruct actualInstance =
        // EcoreHelper.getEPackageForMofPackage((MofPackage) type.getContainer()).refCreateStruct(type, params);
        throw new NotImplementedException();
    }

    // private Object getDefaultValue(EDataType strucField) {
    // if("String".equals(strucField.getType().getName())) {
    // return null;
    // } else if("Boolean".equals(strucField.getType().getName())) {
    // return false;
    // } else if("Integer".equals(strucField.getType().getName())) {
    // return 0;
    // } else if("Float".equals(strucField.getType().getName())) {
    // return 0.0;
    // } else {
    // return null;
    // }
    // throw new NotImplementedException();
    // }

    // void createAssociationLink(EReference reference, EObject endAObject, EObject endBObject) {
    // AssociationEnd endExposed = reference.getExposedEnd();
    // Association ass = (Association) endExposed.getContainer();
    // addAssociationLink(ass, endExposed, endAObject, endBObject);
    // }

    // void createAssociationLink(EReference reference, EObject endAObject,
    // EObject endBObject, int index) {
    // AssociationEnd endExposed = reference.getExposedEnd();
    // Association ass = (Association) endExposed.getContainer();
    // addAssociationLink(ass, endExposed, endAObject, endBObject, index);
    // }

    public EClass getEClass(List<String> qualifiedNameList) throws ModelAdapterException {

        String unqualifiedName = qualifiedNameList.get(qualifiedNameList.size() - 1);

        URI uriEClass = EcoreUtil.getURI(EcorePackage.eINSTANCE.getEClass());

        String query = "select instance \n" + "from [" + uriEClass + "] as instance \n" + "where instance.name = '"
                + unqualifiedName + "'\n";

        ResultSet resultSet = executeQuery(query);

        List<EClass> result = new ArrayList<EClass>(resultSet.getSize());

        if (resultSet.getSize() == 0) {
            throw new ModelAdapterException("Could not resolve any EClass for " + unqualifiedName);
        }

        for (int i = 0; i < resultSet.getSize(); i++) {
            URI uri = resultSet.getUri(i, "instance");
            EObject object = resourceSet.getEObject(uri, true);
            if (object != null) {
                EClass classifier = (EClass) object;
                if (qualifiedNameList.equals(EcoreHelper.getQualifiedName(classifier))) {
                    result.add(classifier);
                }
            } else {
                throw new AssertionError("Should never happen...");
            }
        }

        if (result.size() == 0) {
            throw new ModelAdapterException("Could not resolve EClass for " + MessageUtil.asModelName(qualifiedNameList));
        } else if (result.size() == 1) {
            return result.get(0);
        } else {
            throw new ModelAdapterException("Ambiguous EClass name '" + MessageUtil.asModelName(qualifiedNameList) + "', found "
                    + result.size() + " instances");
        }
    }

    /**
     * @param query
     * @return
     * @throws MetaModelLookupException
     */
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

    // boolean findAssociationAndAddLink(EObject refAObject,
    // String propertyName, Object value) throws ModelAdapterException {
    // boolean associationFound = false;
    // AssociationBean assocBean = findAssociation(refAObject, propertyName);
    // try {
    // if (assocBean.isFirst) {
    // if (value instanceof Collection<?>) {
    // for (Object obj : ((Collection<?>) value)) {
    // assocBean.refAss
    // .refAddLink(refAObject, (EObject) obj);
    // }
    // } else {
    // assocBean.refAss.refAddLink(refAObject, (EObject) value);
    // }
    // } else {
    // if (value instanceof Collection<?>) {
    // for (Object obj : ((Collection<?>) value)) {
    // assocBean.refAss
    // .refAddLink((EObject) obj, refAObject);
    // }
    // } else {
    // assocBean.refAss.refAddLink((EObject) value, refAObject);
    // }
    // }
    // } catch (CompositionViolationException cve) {
    // throw new ModelAdapterException(
    // "CompositionViolationException, check that in metamodel there is no ambiguous composition for either of "
    // + refAObject
    // + " or "
    // + value
    // + " :"
    // + cve.getMessage(), cve);
    // }
    // associationFound = true;
    // return associationFound;
    // }
    //
    // public static AssociationBean findAssociation(EObject refAObject, String propertyName) {
    // EClass mofClass = (EClass) refAObject.eClass();
    // Set<EReference> assoEnds =
    // for (AssociationEnd associationEndCandidate : assoEnds) {
    // AssociationEnd otherEnd = associationEndCandidate.otherEnd();
    // // now check whether this association is the one we were looking
    // // for, by checking that the other end has the right name
    // if (otherEnd.getName().equals(propertyName)) {
    // Association assoCandidate = (Association) associationEndCandidate.getContainer();
    // RefAssociation refAss = EcoreHelper.getRefAssociationForAssociation(assoCandidate);
    // boolean isFirst = EcoreHelper.isFirstAssociationEnd(assoCandidate, associationEndCandidate);
    // return new AssociationBean(refAss, isFirst);
    // }
    // }
    // return null;
    // }
    //
    //
    // private void addAssociationLink(Association ass, AssociationEnd endExposed,
    // EObject endAObject, EObject endBObject) {
    // RefAssociation refAss = EcoreHelper.getRefAssociationForAssociation(ass);
    // boolean isFirst = EcoreHelper.isFirstAssociationEnd(ass, endExposed);
    //
    // // endBObject = endBClass.refCreateInstance(null);
    //
    // // setLogicalKeys((Element) endBNode, defaultLogicalKey,
    // // logicalKeysPaths, logicalKeys);
    // // EObject endBObject = getInstance(endBClass); //, logicalKeys,
    // // null);
    // if (isFirst) {
    // if(refAss.refLinkExists(endAObject, endBObject)) {
    // //only add if upper mult > 1 and non unique
    // if((endExposed.otherEnd().getMultiplicity().getUpper() > 1 ||
    // endExposed.otherEnd().getMultiplicity().getUpper() == JmiHelper.MULTIPLICITY_BOUND_INFINITE)
    // && !endExposed.otherEnd().getMultiplicity().isUnique()) {
    // refAss.refAddLink(endAObject, endBObject);
    // }
    // } else {
    // refAss.refAddLink(endAObject, endBObject);
    // }
    // } else {
    // if(refAss.refLinkExists(endBObject, endAObject)) {
    // if((endExposed.getMultiplicity().getUpper() > 1 ||
    // endExposed.getMultiplicity().getUpper() == JmiHelper.MULTIPLICITY_BOUND_INFINITE)
    // && !endExposed.getMultiplicity().isUnique()) {
    // refAss.refAddLink(endBObject, endAObject);
    // }
    // } else {
    // refAss.refAddLink(endBObject, endAObject);
    // }
    // }
    // }
    //
    // private void addAssociationLink(Association ass, AssociationEnd endExposed,
    // EObject endAObject, EObject endBObject, int index) {
    // RefAssociation refAss = EcoreHelper.getRefAssociationForAssociation(ass);
    // if (endExposed.otherEnd().getMultiplicity().isOrdered()) {
    // ((List<EObject>) refAss.refQuery(endExposed, endAObject)).add(
    // index, endBObject);
    // } else {
    // refAss.refQuery(endExposed, endAObject).add(endBObject);
    // }
    // }

    /**
     * @param clazz
     * @param logicalKey
     * @param args
     * @return
     */
    private EObject createInstance(EClass clazz) { // , String[] logicalKey,
        // List<Object> args) {

        EObject result = null;

        if (true /* result == null */) {
            // result = ((RefClassCalculatedMofId)
            // clazz).refCreateInstance(args, locality, logicalKey);
            result = EcoreUtil.create(clazz);
        }
        return result;
    }

    private URI getMetaElementUri(String type) {
        String[] tokens = type.split("::");
        return getMetaElementUri(tokens);
    }

    private URI getMetaElementUri(String[] tokens) {
        EPackage pack = resourceSet.getPackageRegistry().getEPackage(tokens[0]);
        URI result = null;
        if (pack != null) {
            for (int i = 1; i < tokens.length - 1; i++) {
                String name = tokens[i];
                EList<EPackage> eSubpackages = pack.getESubpackages();
                for (EPackage ePackage : eSubpackages) {
                    if (ePackage.getName().equals(name)) {
                        pack = ePackage;
                        continue;
                    }
                }
            }
            EClassifier classifier = pack.getEClassifier(tokens[tokens.length - 1]);
            if (classifier != null) {
                result = EcoreUtil.getURI(classifier);
            }
        }
        return result;
    }

    /**
     * @param enumName
     * @param name
     * @return
     */
    public EEnumLiteral getEnumLiteral(List<String> qname, String name) throws ModelAdapterException {
        if (name == null) {
            return null;
        }
        EEnumLiteral returnEnum = null;
        // List<String> qname = Arrays.asList(getQualifiedName(enumName));
        EModelElement modelElement = EcoreHelper.findElementByQualifiedName(qname, rootPackage);
        if (modelElement instanceof EEnum) {
            EEnum mofEnum = (EEnum) modelElement;
            // EObject refObject = (EObject) modelElement;

            // List<String> labels = mofEnum.getLabels();
            // if (labels.contains(name)) {
            List<EEnumLiteral> constants = mofEnum.getELiterals();
            for (EEnumLiteral refEnum : constants) {
                // toString comparison is okay because EEnum javadoc says
                // toString returns enumLiteral
                if (name.equals(refEnum.toString())) {
                    returnEnum = refEnum;
                    break;
                }
            }

            // }
        } else {
            throw new ModelAdapterException(MessageUtil.asModelName(qname) + " is not an EnumerationType in Metamodel");
        }
        return returnEnum;
    }

    public Collection<?> findElementsWithOCLQuery(EObject sourceModelElement, Object keyValue,
            String oclQuery, Object contextObject) throws ModelAdapterException {

        String queryToExecute = oclQuery;
        Boolean useContextInsteadOfSelf = false;
        EObject contextRefObject = unwrapProxy(contextObject);

        useContextInsteadOfSelf = ContextAndForeachHelper.usesContext(queryToExecute);
        // TODO check use of #foreach
        queryToExecute = prepareOclQuery(queryToExecute, keyValue);
        OCLExpression exp;
        try {
            exp = oclHelper.createQuery(queryToExecute);

            Object result = ocl.evaluate(useContextInsteadOfSelf ? contextRefObject : sourceModelElement, exp);
            if (ocl.isInvalid(result)) {
                throw new ModelAdapterException("Cannot evaluate OCLExpression:" + queryToExecute + " Reason: "
                        + ocl.getEvaluationProblems().getMessage());
            }
            if (result instanceof Collection<?>) {
                if (((Collection<?>) result).size() == 0) {
                    return null;
                } else {
                    return (Collection<?>) result;
                }
            } else {
                Collection<?> al = Collections.singleton(result);
                return al;
            }

        } catch (ParserException e) {
            throw new ModelAdapterException("Cannot evaluate OCLExpression:" + queryToExecute + " Reason: "
                    + e.getDiagnostic().getMessage(), e);
        }
    }

    /**
     * It is possible to define an OCL QUery to find Elements. For multi-valued results a collection will be returned.
     * 
     * @param foreachObject
     *            TODO
     */
    public Object findElementWithOCLQuery(EObject sourceModelElement, Object keyValue,
            String oclQuery, Object contextObject, Object foreachObject)
            throws ModelAdapterException {

        String queryToExecute = oclQuery;
        EObject contextRefObject = unwrapProxy(contextObject);
        EObject objectForSelf;
        if (ContextAndForeachHelper.usesContext(oclQuery)) {
            objectForSelf = contextRefObject;
        } else if (ContextAndForeachHelper.usesForeach(oclQuery)) {
            objectForSelf = unwrapProxy(foreachObject);
        } else {
            objectForSelf = sourceModelElement;
        }
        queryToExecute = prepareOclQuery(queryToExecute, keyValue);
        try {
            oclHelper.setContext(objectForSelf.eClass());
            OCLExpression exp = oclHelper.createQuery(queryToExecute);

            Object result = ocl.evaluate(objectForSelf, exp);
            if (ocl.isInvalid(result)) {
                throw new ModelAdapterException("Cannot evaluate OCLExpression:" + queryToExecute + " Reason: "
                        + (ocl.getEvaluationProblems() == null ? "" : ocl.getEvaluationProblems().getMessage()));
            }
            if (result instanceof Collection<?>) {
                if (((Collection<?>) result).size() == 0) {
                    return null;
                } else {
                    return result;
                }
            } else {
                Collection<?> al = Collections.singleton(result);
                return al;
            }

        } catch (ParserException e) {
            throw new ModelAdapterException("Cannot evaluate OCLExpression:" + queryToExecute + " Reason: "
                    + e.getDiagnostic().getMessage(), e);
        }
    }
    

    private static String prepareOclQuery(String queryToExecute, Object keyValue) {
        String result = queryToExecute;
        if (queryToExecute != null) {
            if (result.startsWith("OCL:")) {
                result = result.replaceFirst("OCL:", "");
            }
            result = ContextAndForeachHelper.prepareOclQuery(queryToExecute);

            if (keyValue != null) {
                result = result.replaceAll(QUERY_PARAM_NAME, "'" + keyValue.toString() + "'");
            }
        }
        return result;
    }

    private EObject unwrapProxy(Object contextObject) {
        EObject contextRefObject = null;
        if (contextObject instanceof EObject) {
            contextRefObject = (EObject) contextObject;
        } else if (contextObject instanceof IModelElementProxy) {
            contextRefObject = (EObject) ((IModelElementProxy) contextObject).getRealObject();
        }
        return contextRefObject;
    }

    // /**
    // * uses an MQL Query to try to resolve the reference, there is a key value
    // pair
    // * that will probably be necessary for the query.
    // * The intended usage is that in the TCS template definition, there will
    // be something like:
    // * template MyClass
    // * :
    // * "theKeyword" myReference{refersTo=refPropertyName, mqlQuery='select
    // instance from ... where name = ?2'} ";"
    // * ;
    // *
    // * such that for the given dsl sample:
    // *
    // * theKeyword helloRef;
    // *
    // * finally will call findElementWithMQLQuery(myClassReferent, "helloRef",
    // "select instance...");
    // * which should allow the implementation to replace spots in the query
    // with the parsed value and
    // * the MOF ID of the referent (if relevant as context) and then execute
    // it.
    // * @param sourceModelElement
    // * @param keyValue
    // * @param mqlQuery
    // * @param contextObject
    // * @return
    // * @throws ModelAdapterException
    // */
    // Object findElementWithMQLQuery(EObject sourceModelElement,
    // Object keyValue, String mqlQuery, Object contextObject) throws
    // ModelAdapterException {
    //
    // //if (true) throw new
    // UnsupportedOperationException("Not implemented yet: Cannot execute query: '"
    // + mqlQuery + "'");
    //
    // // TODO if required initialize those
    // URI[] partitionScope = null;
    // URI[] containerScope = null;
    //
    // EObject partitionable = (EObject) root;
    // ResourceSet ResourceSet = partitionable.get___ResourceSet();
    //
    // //TODO
    // // - keyValue as parsed in the syntax (which may be a modelElement, or
    // even a StructureTypeMockObject?)
    //
    // //replace alias
    // mqlQuery = mqlQuery.replaceFirst("\\?", keyValue.toString());
    //
    // MQLQuery astQuery = null;
    // mqlParser.parse(mqlQuery, QueryProcessor);
    // try {
    // mqlParser.parse(mqlQuery, QueryProcessor);
    // } catch (MQLFormatException e) {
    // throw new ModelAdapterException("Error parsing MQL query:" +
    // e.getMessage());
    // }
    // // FIXME astQuery can only be null at this point!
    // List<FromEntry> fromEntries = Arrays.asList(astQuery.getFromEntries());
    // FromFixedElement fromThis = new FromFixedElement("this",
    // ((EObject)sourceModelElement).get___Mri());
    // fromEntries.add(fromThis);
    //
    // MQLQuery querytoExecute = new
    // MQLQuery(Arrays.asList(astQuery.getSelectEntries()),
    // fromEntries, Arrays.asList(astQuery.getWhereEntries()));
    //
    //
    // Object result = null;
    // try {
    // QueryProcessor processor = ResourceSet.getQueryProcessor();
    //
    // QueryScopeProvider scopeProvider = processor.getQueryScopeProvider(true,
    // partitionScope, containerScope);
    // MQLResultSet resultSet = processor.execute(querytoExecute,
    // scopeProvider);
    //
    // if (resultSet.getSize() == 1) {
    // EObject object = resultSet.getRefObject(0, "aeReturn");
    // if (object != null) {
    // result = object;
    // }
    // } else if (resultSet.getSize() > 1) {
    // throw new ReferenceSettingException(resultSet.getSize() +
    // " candidates found for queried reference.");
    // // best to put query in message or not?
    // }
    // } catch (RuntimeException rte) {
    // throw new ModelAdapterException("Exception while making query: " +
    // mqlQuery, rte);
    // }
    //
    // return result;
    // }

    /**
     * @param typeName
     * @param partitionableReferenceValuedAttributesKeys
     * @param attributes
     * @param multiValuedAttributesKeys2
     * @return
     */
    public Collection<Object> queryElement(List<String> typeName, Map<String, EObject> partitionableReferenceValuedAttributesMap,
            Map<String, Object> singleAttributesMap/*
                                                    * , Map<String, Collection<?>> multiValuedAttributeMap
                                                    */) {

        StringBuilder queryBuilder = new StringBuilder();

        queryBuilder.append("select instance \n").append("from ");
        for (Iterator<String> iterator = typeName.iterator(); iterator.hasNext();) {
            String string = iterator.next();
            queryBuilder.append(string);
            if (iterator.hasNext()) {
                queryBuilder.append("::");
            }
        }
        queryBuilder.append(" as instance");

        Set<String> singleValueFeatureNames = singleAttributesMap.keySet();
        int index = 0;
        for (Iterator<String> iterator = singleValueFeatureNames.iterator(); iterator.hasNext(); index++) {
            String featureName = iterator.next();
            Object value = singleAttributesMap.get(featureName);
            if (value != null) {
                String featureValueInQuery = getFeatureValueAlias(index);
                if (value instanceof IModelElementProxy && ((IModelElementProxy) value).getRealObject() != null) {
                    queryBuilder.append(", \"").append(EcoreUtil.getURI((EObject) ((IModelElementProxy) value).getRealObject()))
                            .append("\" as ").append(featureValueInQuery);
                } else if (value instanceof EObject) {
                    queryBuilder.append(", \"").append(EcoreUtil.getURI(((EObject) value))).append("\" as ")
                            .append(featureValueInQuery);
                }
            }
        }

        Set<String> partitionableFeatureNames = partitionableReferenceValuedAttributesMap.keySet();
        for (String featureName : partitionableFeatureNames) {
            EObject value = partitionableReferenceValuedAttributesMap.get(featureName);
            queryBuilder.append(",\n \"").append(EcoreUtil.getURI(value)).append("\" as ").append(featureName).append("_alias")
                    .append("\n");
        }
        for (String featureName : partitionableFeatureNames) {
            queryBuilder.append(" where instance.").append(featureName).append(" = ").append(featureName).append("_alias")
                    .append("\n");
        }

        index = 0;
        for (Iterator<String> iterator = singleValueFeatureNames.iterator(); iterator.hasNext(); index++) {
            String featureName = iterator.next();
            Object value = singleAttributesMap.get(featureName);

            queryBuilder.append(" where instance.").append(featureName);
            if (value != null) {
                if (value instanceof IModelElementProxy && ((IModelElementProxy) value).getRealObject() != null) {
                    String featureValueInQuery = getFeatureValueAlias(index);
                    queryBuilder.append(" = ").append(featureValueInQuery).append("\n");
                } else if (value instanceof EObject) {
                    String featureValueInQuery = getFeatureValueAlias(index);
                    queryBuilder.append(" = ").append(featureValueInQuery).append("\n");
                } else {
                    String valueString = String.valueOf(value);
                    queryBuilder.append(" = '").append(valueString).append("'\n");
                }
            } else {
                queryBuilder.append(" = null\n");
            }

        }

        ResultSet resultSet = executeQuery(queryBuilder.toString());

        List<Object> result = new ArrayList<Object>(resultSet.getSize());

        for (int i = 0; i < resultSet.getSize(); i++) {
            URI mri = resultSet.getUri(i, "instance");
            EObject object = resourceSet.getEObject(mri, true);
            if (object != null) {
                // TODO filter using multi-valued attributes
                // EClass classifier = (EClass) object;

                // if(qualifiedNameList.equals(classifier.getQualifiedName())) {
                result.add(object);
                // }
            } else {
                // Should never happen
            }
        }
        return result;

    }

    private String getFeatureValueAlias(int index) {
        return "feat" + index;
    }

    // public void removeAssociationLink(EReference reference,
    // EObject refAObject, EObject refObjectValue) {
    // AssociationEnd endExposed = reference.getExposedEnd();
    // Association ass = (Association) endExposed.getContainer();
    //
    // removeAssociationLink(ass, endExposed, refAObject, refObjectValue);
    //
    // }

    // private void removeAssociationLink(Association ass,
    // AssociationEnd endExposed, EObject refAObject,
    // EObject refObjectValue) {
    // RefAssociation refAss = EcoreHelper.getRefAssociationForAssociation(ass);
    // boolean isFirst = EcoreHelper.isFirstAssociationEnd(ass, endExposed);
    //
    // // endBObject = endBClass.refCreateInstance(null);
    //
    // // setLogicalKeys((Element) endBNode, defaultLogicalKey,
    // // logicalKeysPaths, logicalKeys);
    // // EObject endBObject = getInstance(endBClass); //, logicalKeys,
    // // null);
    // if (isFirst) {
    // refAss.refRemoveLink(refAObject, refObjectValue);
    // } else {
    // refAss.refRemoveLink(refObjectValue, refAObject);
    // }
    // }

}

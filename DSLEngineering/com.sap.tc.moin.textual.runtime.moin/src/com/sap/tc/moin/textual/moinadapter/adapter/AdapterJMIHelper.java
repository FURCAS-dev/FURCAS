/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2008-04-10 13:55:50 +0200 (Do, 10 Apr 2008) $
 * @version $Revision: 859 $
 * @author: $Author: c5107456 $
 *******************************************************************************/
package com.sap.tc.moin.textual.moinadapter.adapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.omg.ocl.expressions.OclExpression;

import com.sap.mi.textual.common.exceptions.MetaModelLookupException;
import com.sap.mi.textual.common.exceptions.ModelAdapterException;
import com.sap.mi.textual.common.interfaces.IModelElementProxy;
import com.sap.mi.textual.common.util.ContextAndForeachHelper;
import com.sap.mi.textual.grammar.exceptions.ReferenceSettingException;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.reflect.CompositionViolationException;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefEnum;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefStruct;
import com.sap.tc.moin.repository.mql.FromEntry;
import com.sap.tc.moin.repository.mql.FromType;
import com.sap.tc.moin.repository.mql.LocalWhereEntry;
import com.sap.tc.moin.repository.mql.MQLFormatException;
import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.mql.MQLQuery;
import com.sap.tc.moin.repository.mql.MQLResultSet;
import com.sap.tc.moin.repository.mql.Operation;
import com.sap.tc.moin.repository.mql.QueryScopeProvider;
import com.sap.tc.moin.repository.mql.SelectAlias;
import com.sap.tc.moin.repository.mql.SelectEntry;
import com.sap.tc.moin.repository.mql.WhereClause;
import com.sap.tc.moin.repository.mql.WhereEntry;
import com.sap.tc.moin.repository.mql.WhereString;
import com.sap.tc.moin.repository.ocl.exceptions.ParsingException;
import com.sap.tc.moin.repository.ocl.freestyle.OclExpressionRegistration;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationSeverity;

/**
 * Util class containing methods dealing with MOIN JMI specific functionality.
 * 
 * @author C5107456
 * 
 */
public class AdapterJMIHelper {

	public static class AssociationBean {

	    public final RefAssociation refAss;
	    public final boolean isFirst;

	    public AssociationBean(RefAssociation refAss, boolean isFirst) {
		this.refAss = refAss;
		this.isFirst = isFirst;
	    }

    }

	//private static final String OCL_SELF = "self";
	private final RefPackage root;
	private final Collection<RefPackage> packagesForLookup;
	private final JmiHelper jmiHelper;
	private final Connection connection;
	private final MQLProcessor mqlProcessor;
	// private MqlParser mqlParser;
	private Set<PRI> referenceScope;

	private static final String MQL_ALIAS_INSTANCE = "instance";
	//private static final String QUERY_PARAM_NAME = "\\?";
	private final Set<CRI> additionalCRIScope;

	public AdapterJMIHelper(RefPackage root, Connection connection, Collection<PRI> explicitReferenceScope, Collection<CRI> additionalCRIScope) {
		super();
		this.root = root;
		this.jmiHelper = jmiHelper;
		this.connection = connection;
		this.additionalCRIScope = new HashSet<CRI>();
		if(additionalCRIScope != null) {
		    this.additionalCRIScope.addAll(additionalCRIScope);
		}

		this.mqlProcessor = connection.getMQLProcessor();
		// this.mqlParser = new MqlParser(MAX_NO_OF_MQL_ERRORS,
		// connection.getSession().getMoin());
		if (explicitReferenceScope != null) {
			this.referenceScope = new HashSet<PRI>(explicitReferenceScope);
		} else {
			this.referenceScope = new HashSet<PRI>();
		}
		PRI metaPri = ((Partitionable) root.refMetaObject()).get___Partition()
				.getPri();
		this.referenceScope.add(metaPri);

		packagesForLookup = new ArrayList<RefPackage>();
		packagesForLookup.addAll(MoinHelper.getImportedRefPackages(root));
		packagesForLookup.add(root);
		for (RefPackage pack : packagesForLookup) {
			referenceScope.add(((Partitionable) pack.refMetaObject())
					.get___Partition().getPri());
		}
	}

	

	RefObject findRefObjectOfType(List<String> targetType,
			String targetKeyName, Object targetKeyValue)
			throws ReferenceSettingException {
		RefObject returnRefObject = null;

		// MofClass mofClass = getMofClass(targetType);
		String[] qName = targetType.toArray(new String[targetType.size()]);

		SelectEntry se = new SelectAlias(MQL_ALIAS_INSTANCE);
		FromEntry fe = new FromType(MQL_ALIAS_INSTANCE, qName, false);
		WhereClause clause = new WhereString(targetKeyName, Operation.EQUAL,
				String.valueOf(targetKeyValue));
		WhereEntry we = new LocalWhereEntry(MQL_ALIAS_INSTANCE, clause);
		MQLQuery mq = new MQLQuery(new SelectEntry[] { se },
				new FromEntry[] { fe }, new WhereEntry[] { we });
		Set<PRI> partScope = referenceScope;
		Set<CRI> contScope = null;
		QueryScopeProvider scopeProvider = mqlProcessor.getQueryScopeProvider(
				true, partScope, contScope);
		MQLResultSet mrs = mqlProcessor.execute(mq, scopeProvider); // ,
		// mqlProcessor.getInclusivePartitionScopeProvider(
		// ));
		if (mrs != null && mrs.getSize() > 0) {
			RefObject[] refObjects = mrs.getRefObjects(MQL_ALIAS_INSTANCE);
			if (refObjects == null || refObjects.length == 0) {
				throw new ReferenceSettingException(
						"Array of found RefObjects is null or empty: "
								+ refObjects + " for search "
								+ MessageUtil.asModelName(targetType)
								+ " with " + targetKeyName + " = "
								+ targetKeyValue);
			}
			if (refObjects.length > 1) {
				throw new ReferenceSettingException(
						"Found more than one candidate RefObjects ("
								+ refObjects.length + ") for search "
								+ MessageUtil.asModelName(targetType)
								+ " with " + targetKeyName + " = "
								+ targetKeyValue);
			}

			returnRefObject = refObjects[0];

		}
		return returnRefObject;

	}

	/**
	 * @param type
	 * @return
	 */
	RefObject[] getElementsOfType(String targetType) {
		RefObject[] refObjects = null;
		String[] qName = getQualifiedName(targetType);
		// String[] qName = (String[]) qname.toArray(new String[] {});

		SelectEntry se = new SelectAlias(MQL_ALIAS_INSTANCE);
		FromEntry fe = new FromType(MQL_ALIAS_INSTANCE, qName, true);
		MQLQuery mq = new MQLQuery(new SelectEntry[] { se },
				new FromEntry[] { fe });
		Set<PRI> partScope = referenceScope;
		Set<CRI> contScope = null;
		QueryScopeProvider scopeProvider = mqlProcessor.getQueryScopeProvider(
				true, partScope, contScope);
		MQLResultSet mrs = mqlProcessor.execute(mq, scopeProvider);
		if (mrs != null && mrs.getSize() > 0) {
			refObjects = mrs.getRefObjects(MQL_ALIAS_INSTANCE);
		}
		return refObjects;
	}

	/**
	 * returns a a modelElement or a mock object for StructureTypes.
	 * 
	 * @param typeName
	 * @return
	 * @throws ModelAdapterException
	 */
	Object createObject(List<String> qualifiedNameList)
			throws ModelAdapterException {
		// List<String> qualifiedNameList =
		// Arrays.asList(getQualifiedName(typeName));

		ModelElement modelElement = jmiHelper.findElementByQualifiedName(
				qualifiedNameList, root);
		if (modelElement != null) {
			if (modelElement instanceof MofClass) {
				MofClass mofClass = (MofClass) modelElement;
				RefClass refClass = jmiHelper.getRefClassForMofClass(mofClass);
				return createInstance(refClass);
			} else if (modelElement instanceof StructureType) {
				StructureType structype = (StructureType) modelElement;
				StructureTypeMockObject mock = new StructureTypeMockObject(
						structype);
				return mock;
			} else {
				throw new RuntimeException("ModelElement Class "
						+ modelElement.getClass()
						+ " RefClass lookup not supported yet.");
			}

		} else {
			throw new ModelAdapterException(
					"No modelElement found for qualifiedName "
							+ MessageUtil.asModelName(qualifiedNameList)
							+ " in package " + root);
		}
	}

	/**
	 * creates a mock or throws an exception if e.g. required fields are not
	 * set.
	 * 
	 * @param mock
	 * @throws ModelAdapterException
	 */
	public Object actualCreateFromMock(StructureTypeMockObject mock) {
		StructureType type = mock.getStructureType();
		List<Object> params = new ArrayList<Object>();
		List<ModelElement> fields = type.getContents();
		for (Iterator<ModelElement> iterator = fields.iterator(); iterator
				.hasNext();) {
			ModelElement contentElement = iterator.next();
			if (contentElement instanceof StructureField) {
				StructureField strucField = (StructureField) contentElement;
				Object value = mock.getStructureField(strucField.getName());
				if(value == null) {
				    value = getDefaultValue(strucField);
				}
				params.add(value);
			}
		}
		
		RefStruct actualInstance =
		    jmiHelper.getRefPackageForMofPackage((MofPackage) type.getContainer()).refCreateStruct(type, params);
		return actualInstance;
	}

	private Object getDefaultValue(StructureField strucField) {
	    if("String".equals(strucField.getType().getName())) {
		return null;
	    } else if("Boolean".equals(strucField.getType().getName())) {
		return false;
	    } else if("Integer".equals(strucField.getType().getName())) {
		return 0;
	    } else if("Float".equals(strucField.getType().getName())) {
		return 0.0;
	    } else {
		return null;
	    }
	}

    void createAssociationLink(Reference reference, RefObject endAObject, RefObject endBObject) {
	AssociationEnd endExposed = reference.getExposedEnd();
	Association ass = (Association) endExposed.getContainer();
	addAssociationLink(ass, endExposed, endAObject, endBObject);
    }

	void createAssociationLink(Reference reference, RefObject endAObject,
			RefObject endBObject, int index) {
		AssociationEnd endExposed = reference.getExposedEnd();
		Association ass = (Association) endExposed.getContainer();
		addAssociationLink(ass, endExposed, endAObject, endBObject, index);
	}

	MofClass getMofClass(List<String> qualifiedNameList)
			throws ModelAdapterException {

		String unqualifiedName = qualifiedNameList
				.get(qualifiedNameList.size() - 1);

		String query = "select instance \n"
				+ "from \"sap.com/tc/moin/mof_1.4\"#"
				+ "Model::Class as instance \n" + "where instance.name = '"
				+ unqualifiedName + "'";

		MQLResultSet resultSet = executeQuery(query);

		List<MofClass> result = new ArrayList<MofClass>(resultSet.getSize());

		if (resultSet.getSize() == 0) {
			throw new ModelAdapterException(
					"Could not resolve any MofClass for " + unqualifiedName);
		}

		for (int i = 0; i < resultSet.getSize(); i++) {
			MRI mri = resultSet.getMri(i, "instance");
			RefBaseObject object = connection.getElement(mri);
			if (object != null) {
				MofClass classifier = (MofClass) object;
				if (qualifiedNameList.equals(classifier.getQualifiedName())) {
					result.add(classifier);
				}
			} else {
				// Should never happen
			}
		}

		if (result.size() == 0) {
			throw new ModelAdapterException("Could not resolve MofClass for "
					+ MessageUtil.asModelName(qualifiedNameList));
		} else if (result.size() == 1) {
			return result.get(0);
		} else {
			throw new ModelAdapterException("Ambiguous MofClass name '"
					+ MessageUtil.asModelName(qualifiedNameList) + "', found "
					+ result.size() + " instances");
		}
	}

	/**
	 * @param query
	 * @return
	 * @throws MetaModelLookupException
	 */
	private MQLResultSet executeQuery(String query) {
		try {
			// TODO remove this again or fix otherwise: enforce loading of MOF
			// ROM/OCL partitions
			connection.getClass(OclExpression.CLASS_DESCRIPTOR).getClass();

			QueryScopeProvider scopeProvider = mqlProcessor
					.getQueryScopeProvider(true, referenceScope, additionalCRIScope);
			MQLResultSet resultSet = mqlProcessor.execute(query, scopeProvider);
			return resultSet;
		} catch (MQLFormatException mqle) {
			System.err.println("Following Stack Trace for query:\n" + query);
			mqle.printStackTrace();
			throw mqle;
		} catch (RuntimeException rte) {
			rte.printStackTrace();
			throw rte;
		}
	}

	boolean findAssociationAndAddLink(RefObject refAObject,
	    String propertyName, Object value) throws ModelAdapterException {
	boolean associationFound = false;
	AssociationBean assocBean = findAssociation(refAObject, propertyName, jmiHelper);
	try {
	    if (assocBean.isFirst) {
		if (value instanceof Collection<?>) {
		    for (Object obj : ((Collection<?>) value)) {
			assocBean.refAss
				.refAddLink(refAObject, (RefObject) obj);
		    }
		} else {
		    assocBean.refAss.refAddLink(refAObject, (RefObject) value);
		}
	    } else {
		if (value instanceof Collection<?>) {
		    for (Object obj : ((Collection<?>) value)) {
			assocBean.refAss
				.refAddLink((RefObject) obj, refAObject);
		    }
		} else {
		    assocBean.refAss.refAddLink((RefObject) value, refAObject);
		}
	    }
	} catch (CompositionViolationException cve) {
	    throw new ModelAdapterException(
		    "CompositionViolationException, check that in metamodel there is no ambiguous composition for either of "
			    + refAObject
			    + " or "
			    + value
			    + " :"
			    + cve.getMessage(), cve);
	}
	associationFound = true;
	return associationFound;
    }

    public static AssociationBean findAssociation(RefObject refAObject, String propertyName, JmiHelper jmiHelper) {
	MofClass mofClass = (MofClass) refAObject.refMetaObject();
	Set<AssociationEnd> assoEnds = jmiHelper.getAssociationEnds(mofClass, true);
	for (AssociationEnd associationEndCandidate : assoEnds) {
	    AssociationEnd otherEnd = associationEndCandidate.otherEnd();
	    // now check whether this association is the one we were looking
	    // for, by checking that the other end has the right name
	    if (otherEnd.getName().equals(propertyName)) {
		Association assoCandidate = (Association) associationEndCandidate.getContainer();
		RefAssociation refAss = jmiHelper.getRefAssociationForAssociation(assoCandidate);
		boolean isFirst = jmiHelper.isFirstAssociationEnd(assoCandidate, associationEndCandidate);
		return new AssociationBean(refAss, isFirst);
	    }
	}
	return null;
    }


	private void addAssociationLink(Association ass, AssociationEnd endExposed,
			RefObject endAObject, RefObject endBObject) {
		RefAssociation refAss = jmiHelper.getRefAssociationForAssociation(ass);
		boolean isFirst = jmiHelper.isFirstAssociationEnd(ass, endExposed);

		// endBObject = endBClass.refCreateInstance(null);

		// setLogicalKeys((Element) endBNode, defaultLogicalKey,
		// logicalKeysPaths, logicalKeys);
		// RefObject endBObject = getInstance(endBClass); //, logicalKeys,
		// null);
		if (isFirst) {
		    if(refAss.refLinkExists(endAObject, endBObject)) {
		        //only add if upper mult > 1 and non unique
		        if((endExposed.otherEnd().getMultiplicity().getUpper() > 1 || 
		                    endExposed.otherEnd().getMultiplicity().getUpper() == JmiHelper.MULTIPLICITY_BOUND_INFINITE) 
		                && !endExposed.otherEnd().getMultiplicity().isUnique()) {
		            refAss.refAddLink(endAObject, endBObject);
		        }
		    } else {
			refAss.refAddLink(endAObject, endBObject);
		    }
		} else {
		    if(refAss.refLinkExists(endBObject, endAObject)) {
		        if((endExposed.getMultiplicity().getUpper() > 1 || 
                                    endExposed.getMultiplicity().getUpper() == JmiHelper.MULTIPLICITY_BOUND_INFINITE) 
                               && !endExposed.getMultiplicity().isUnique()) {
                            refAss.refAddLink(endBObject, endAObject);
                        }
                    } else {
			refAss.refAddLink(endBObject, endAObject);
                    }
		}
	}

	private void addAssociationLink(Association ass, AssociationEnd endExposed,
			RefObject endAObject, RefObject endBObject, int index) {
		RefAssociation refAss = jmiHelper.getRefAssociationForAssociation(ass);
		if (endExposed.otherEnd().getMultiplicity().isOrdered()) {
			((List<RefObject>) refAss.refQuery(endExposed, endAObject)).add(
					index, endBObject);
		} else {
			refAss.refQuery(endExposed, endAObject).add(endBObject);
		}
	}

	/**
	 * @param clazz
	 * @param logicalKey
	 * @param args
	 * @return
	 */
	private RefObject createInstance(RefClass clazz) { // , String[] logicalKey,
		// List<Object> args) {

		RefObject result = null;
		// get DataAreaDescriptor from current partition's PRI (as set during
		// doImport)

		// DataAreaDescriptor dad = pri.getDataAreaDescriptor();
		// assumption: use MofId of RefClass as locality scope
		// String locality = clazz.refMofId();
		// String mofId = ((RefClassCalculatedMofId)
		// clazz).calculateMofId(locality, logicalKey);
		// LRI lri =
		// connection.getSession().getMoin().createLri(dad.getFacilityId(),
		// dad.getDataAreaName(), mofId);
		// result = (RefObject) connection.getElement(lri);

		if (true /* result == null */) {
			// result = ((RefClassCalculatedMofId)
			// clazz).refCreateInstance(args, locality, logicalKey);
			result = clazz.refCreateInstance(); // pass args here if any
		}
		return result;
	}

	private String[] getQualifiedName(String type) {
		String[] tokens = type.split("::");
		return tokens;
	}

	/**
	 * @param enumName
	 * @param name
	 * @return
	 */
	RefEnum getEnumLiteral(List<String> qname, String name)
			throws ModelAdapterException {
		if (name == null) {
			return null;
		}
		RefEnum returnEnum = null;
		// List<String> qname = Arrays.asList(getQualifiedName(enumName));
		ModelElement modelElement = jmiHelper.findElementByQualifiedName(qname,
				root);
		if (modelElement instanceof EnumerationType) {
			EnumerationType mofEnum = (EnumerationType) modelElement;
			// RefObject refObject = (RefObject) modelElement;

			// List<String> labels = mofEnum.getLabels();
			// if (labels.contains(name)) {
			List<RefEnum> constants = jmiHelper
					.getEnumerationConstants(mofEnum);
			for (Iterator<RefEnum> iterator = constants.iterator(); iterator
					.hasNext();) {
				RefEnum refEnum = iterator.next();
				// toString comparison is okay because RefEnum javadoc says
				// toString returns enumLiteral
				if (name.equals(refEnum.toString())) {
					returnEnum = refEnum;
					break;
				}
			}

			// }
		} else {
			throw new ModelAdapterException(MessageUtil.asModelName(qname)
					+ " is not an EnumerationType in Metamodel");
		}
		return returnEnum;
	}

	public Collection<?> findElementsWithOCLQuery(RefObject sourceModelElement,
			String referencePropertyName, Object keyValue, String oclQuery,
			Object contextObject) throws ModelAdapterException {

		String queryToExecute = oclQuery;
		Boolean useContextInsteadOfSelf = false;
		RefObject contextRefObject = unwrapProxy(contextObject);

		useContextInsteadOfSelf = ContextAndForeachHelper.usesContext(queryToExecute);
		// TODO check use of #foreach
		queryToExecute = MoinHelper.prepareOclQuery(queryToExecute, keyValue);
		try {
	            RefClass registerForBaseClass = useContextInsteadOfSelf ? contextRefObject
                            .refClass() : sourceModelElement
                            .refClass();
		    	String registrationName = getOclRegistrationName(queryToExecute, registerForBaseClass);
			OclExpressionRegistration reg = (OclExpressionRegistration) connection
					.getOclRegistryService().getFreestyleRegistry()
					.getRegistration(registrationName);
			if (reg == null) {
				reg = connection.getOclRegistryService().getFreestyleRegistry()
						.createExpressionRegistration(
							        registrationName,
								queryToExecute,
								OclRegistrationSeverity.Warning,
								new String[] { "TCSPropertyQuery" },
								registerForBaseClass,
								packagesForLookup.toArray(new RefPackage[] {}));
				// new RefPackage[0]);

			}
			Object result = reg
					.evaluateExpression(useContextInsteadOfSelf ? contextRefObject
							: sourceModelElement);
			if (result instanceof Collection<?>) {
				if (((Collection<?>) result).size() == 0) {
					return null;
				} else {
					return (Collection<?>)result;
				}
			} 
			else
			{
				Collection<?> al = Collections.singleton(result);
				return al;
			}
		} catch (OclManagerException e) {
			if (e.getCause() instanceof ParsingException) {
				throw new ModelAdapterException(
						"Cannot evaluate OCLExpression:"
								+ queryToExecute
								+ " Reason: "
								+ ((ParsingException) e.getCause()).getReport()
										.toString(), e);
			}
			throw new ModelAdapterException("Cannot evaluate OCLExpression:"
					+ queryToExecute, e);
		}
	}



	public static String getOclRegistrationName(String queryToExecute, RefClass registerForBaseClass) {
	    return ""+registerForBaseClass.refMetaObject().getQualifiedName()+" "+
	    	queryToExecute;
	}
	
	public Object findElementWithOCLQuery(RefObject sourceModelElement,
                String referencePropertyName, Object keyValue, String oclQuery,
                Object contextObject, Object foreachObject) throws ModelAdapterException {
	    return findElementWithOCLQuery(sourceModelElement, referencePropertyName, keyValue, oclQuery, contextObject, null, foreachObject);
	}

	/**
	 * It is possible to define an OCL QUery to find Elements. For multi-valued results a
	 * collection will be returned.
	 * @param foreachObject TODO
	 */
	public Object findElementWithOCLQuery(RefObject sourceModelElement,
			String referencePropertyName, Object keyValue, String oclQuery,
			Object contextObject, RefClass registerForBaseClass, Object foreachObject) throws ModelAdapterException {

		String queryToExecute = oclQuery;
		RefObject contextRefObject = unwrapProxy(contextObject);
		RefObject objectForSelf;
		if (ContextAndForeachHelper.usesContext(oclQuery)) {
		    objectForSelf = contextRefObject;
		} else if (ContextAndForeachHelper.usesForeach(oclQuery)) {
		    objectForSelf = unwrapProxy(foreachObject);
		} else {
		    objectForSelf = sourceModelElement;
		}
		queryToExecute = MoinHelper.prepareOclQuery(queryToExecute, keyValue);
		try {
		        if(registerForBaseClass == null) {
		            registerForBaseClass = objectForSelf.refClass();
		        }
		    	String registrationName = getOclRegistrationName(queryToExecute, registerForBaseClass);
			OclExpressionRegistration reg = (OclExpressionRegistration) connection
					.getOclRegistryService().getFreestyleRegistry()
					.getRegistration(registrationName);
			if (reg == null) {
				reg = connection.getOclRegistryService().getFreestyleRegistry()
						.createExpressionRegistration(
								registrationName,
								queryToExecute,
								OclRegistrationSeverity.Warning,
								new String[] { "TCSPropertyQuery" },
								registerForBaseClass,
								packagesForLookup.toArray(new RefPackage[] {}));
				// new RefPackage[0]);

			}
			Object result = reg
					.evaluateExpression(objectForSelf);
			if (result instanceof Collection<?>) {
				if (((Collection<?>) result).size() == 0) {
					return null;
				} else if (((Collection<?>) result).size() == 1) {
					return ((Collection<?>) result).iterator().next();
				} else /* if(((Collection)result).size() > 1) */{
					return result;
				}
			} else {
				return result;
			}
		} catch (OclManagerException e) {
			if (e.getCause() instanceof ParsingException) {
				throw new ModelAdapterException(
						"Cannot evaluate OCLExpression:"
								+ queryToExecute
								+ " Reason: "
								+ ((ParsingException) e.getCause()).getReport()
										.toString(), e);
			}
			throw new ModelAdapterException("Cannot evaluate OCLExpression:"
					+ queryToExecute, e);
		}
	}



	private RefObject unwrapProxy(Object contextObject) {
		RefObject contextRefObject = null;
		if(contextObject instanceof RefObject) {
			contextRefObject = (RefObject) contextObject;
		} else if(contextObject instanceof IModelElementProxy) {
			contextRefObject = (RefObject) ((IModelElementProxy) contextObject).getRealObject();
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
	// Object findElementWithMQLQuery(RefObject sourceModelElement,
	// Object keyValue, String mqlQuery, Object contextObject) throws
	// ModelAdapterException {
	//        
	// //if (true) throw new
	// UnsupportedOperationException("Not implemented yet: Cannot execute query: '"
	// + mqlQuery + "'");
	//        
	// // TODO if required initialize those
	// PRI[] partitionScope = null;
	// CRI[] containerScope = null;
	//        
	// Partitionable partitionable = (Partitionable) root;
	// Connection connection = partitionable.get___Connection();
	//
	// //TODO
	// // - keyValue as parsed in the syntax (which may be a modelElement, or
	// even a StructureTypeMockObject?)
	//        
	// //replace alias
	// mqlQuery = mqlQuery.replaceFirst("\\?", keyValue.toString());
	//        
	// MQLQuery astQuery = null;
	// mqlParser.parse(mqlQuery, mqlProcessor);
	// try {
	// mqlParser.parse(mqlQuery, mqlProcessor);
	// } catch (MQLFormatException e) {
	// throw new ModelAdapterException("Error parsing MQL query:" +
	// e.getMessage());
	// }
	// // FIXME astQuery can only be null at this point!
	// List<FromEntry> fromEntries = Arrays.asList(astQuery.getFromEntries());
	// FromFixedElement fromThis = new FromFixedElement("this",
	// ((Partitionable)sourceModelElement).get___Mri());
	// fromEntries.add(fromThis);
	//		
	// MQLQuery querytoExecute = new
	// MQLQuery(Arrays.asList(astQuery.getSelectEntries()),
	// fromEntries, Arrays.asList(astQuery.getWhereEntries()));
	//	
	//        
	// Object result = null;
	// try {
	// MQLProcessor processor = connection.getMQLProcessor();
	//            
	// QueryScopeProvider scopeProvider = processor.getQueryScopeProvider(true,
	// partitionScope, containerScope);
	// MQLResultSet resultSet = processor.execute(querytoExecute,
	// scopeProvider);
	//            
	// if (resultSet.getSize() == 1) {
	// RefObject object = resultSet.getRefObject(0, "aeReturn");
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
	Collection<Object> queryElement(
			List<String> typeName,
			Map<String, Partitionable> partitionableReferenceValuedAttributesMap,
			Map<String, Object> singleAttributesMap/*
													 * , Map<String,
													 * Collection<?>>
													 * multiValuedAttributeMap
													 */) {

		StringBuilder queryBuilder = new StringBuilder();

		queryBuilder.append("select instance \n").append("from ");
		for (Iterator<String> iterator = typeName.iterator(); iterator
				.hasNext();) {
			String string = iterator.next();
			queryBuilder.append(string);
			if (iterator.hasNext()) {
				queryBuilder.append("::");
			}
		}
		queryBuilder.append(" as instance");

		Set<String> singleValueFeatureNames = singleAttributesMap.keySet();
		int index = 0;
		for (Iterator<String> iterator = singleValueFeatureNames.iterator(); iterator
				.hasNext(); index++) {
			String featureName = iterator.next();
			Object value = singleAttributesMap.get(featureName);
			if (value != null) {
				String featureValueInQuery = getFeatureValueAlias(index);
				if (value instanceof IModelElementProxy
						&& ((IModelElementProxy) value).getRealObject() != null) {
					queryBuilder.append(", \"").append(
							((Partitionable) ((IModelElementProxy) value)
									.getRealObject()).get___Mri()).append(
							"\" as ").append(featureValueInQuery);
				} else if (value instanceof RefObject) {
					queryBuilder.append(", \"").append(
							((Partitionable) ((RefObject) value)).get___Mri())
							.append("\" as ").append(featureValueInQuery);
				}
			}
		}

		Set<String> partitionableFeatureNames = partitionableReferenceValuedAttributesMap
				.keySet();
		for (Iterator<String> iterator = partitionableFeatureNames.iterator(); iterator
				.hasNext();) {
			String featureName = iterator.next();
			Partitionable value = partitionableReferenceValuedAttributesMap
					.get(featureName);
			queryBuilder.append(",\n \"").append(value.get___Mri()).append(
					"\" as ").append(featureName).append("_alias").append("\n");
		}
		for (Iterator<String> iterator = partitionableFeatureNames.iterator(); iterator
				.hasNext();) {
			String featureName = iterator.next();
			queryBuilder.append(" where instance.").append(featureName).append(
					" = ").append(featureName).append("_alias").append("\n");
		}

		index = 0;
		for (Iterator<String> iterator = singleValueFeatureNames.iterator(); iterator
				.hasNext(); index++) {
			String featureName = iterator.next();
			Object value = singleAttributesMap.get(featureName);

			queryBuilder.append(" where instance.").append(featureName);
			if (value != null) {
				if (value instanceof IModelElementProxy
						&& ((IModelElementProxy) value).getRealObject() != null) {
					String featureValueInQuery = getFeatureValueAlias(index);
					queryBuilder.append(" = ").append(featureValueInQuery)
							.append("\n");
				} else if (value instanceof RefObject) {
					String featureValueInQuery = getFeatureValueAlias(index);
					queryBuilder.append(" = ").append(featureValueInQuery)
							.append("\n");
				} else {
					String valueString = String.valueOf(value);
					queryBuilder.append(" = '").append(valueString).append(
							"'\n");
				}
			} else {
				queryBuilder.append(" = null\n");
			}

		}

		MQLResultSet resultSet = executeQuery(queryBuilder.toString());

		List<Object> result = new ArrayList<Object>(resultSet.getSize());

		for (int i = 0; i < resultSet.getSize(); i++) {
			MRI mri = resultSet.getMri(i, "instance");
			RefBaseObject object = connection.getElement(mri);
			if (object != null) {
				// TODO filter using multi-valued attributes
				// MofClass classifier = (MofClass) object;

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

	public void removeAssociationLink(Reference reference,
			RefObject refAObject, RefObject refObjectValue) {
		AssociationEnd endExposed = reference.getExposedEnd();
		Association ass = (Association) endExposed.getContainer();

		removeAssociationLink(ass, endExposed, refAObject, refObjectValue);

	}

	private void removeAssociationLink(Association ass,
			AssociationEnd endExposed, RefObject refAObject,
			RefObject refObjectValue) {
		RefAssociation refAss = jmiHelper.getRefAssociationForAssociation(ass);
		boolean isFirst = jmiHelper.isFirstAssociationEnd(ass, endExposed);

		// endBObject = endBClass.refCreateInstance(null);

		// setLogicalKeys((Element) endBNode, defaultLogicalKey,
		// logicalKeysPaths, logicalKeys);
		// RefObject endBObject = getInstance(endBClass); //, logicalKeys,
		// null);
		if (isFirst) {
			refAss.refRemoveLink(refAObject, refObjectValue);
		} else {
			refAss.refRemoveLink(refObjectValue, refAObject);
		}
	}

}

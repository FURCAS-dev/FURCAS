/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
/*
 * Created on 02.02.2006
 */
package org.eclipse.emf.query2.internal.moinql.preprocessor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query2.EmfHelper;
import org.eclipse.emf.query2.FromEntry;
import org.eclipse.emf.query2.FromFixedSet;
import org.eclipse.emf.query2.FromType;
import org.eclipse.emf.query2.JoinWhereEntry;
import org.eclipse.emf.query2.LocalWhereEntry;
import org.eclipse.emf.query2.Operation;
import org.eclipse.emf.query2.Query;
import org.eclipse.emf.query2.QueryElement;
import org.eclipse.emf.query2.QueryFormatException;
import org.eclipse.emf.query2.SelectAlias;
import org.eclipse.emf.query2.SelectAttrs;
import org.eclipse.emf.query2.SelectEntry;
import org.eclipse.emf.query2.WhereBool;
import org.eclipse.emf.query2.WhereComparator;
import org.eclipse.emf.query2.WhereComparisonAliases;
import org.eclipse.emf.query2.WhereComparisonAttrs;
import org.eclipse.emf.query2.WhereDouble;
import org.eclipse.emf.query2.WhereEntry;
import org.eclipse.emf.query2.WhereFloat;
import org.eclipse.emf.query2.WhereInt;
import org.eclipse.emf.query2.WhereLong;
import org.eclipse.emf.query2.WhereNary;
import org.eclipse.emf.query2.WhereNestedReference;
import org.eclipse.emf.query2.WhereNot;
import org.eclipse.emf.query2.WhereOr;
import org.eclipse.emf.query2.WhereRelationReference;
import org.eclipse.emf.query2.WhereString;
import org.eclipse.emf.query2.exception.LocalizedString;
import org.eclipse.emf.query2.internal.fql.SpiFqlComparisonOperation;
import org.eclipse.emf.query2.internal.fql.SpiFqlFromTypeCategory;
import org.eclipse.emf.query2.internal.fql.SpiFqlPrimitiveType;
import org.eclipse.emf.query2.internal.logger.LoggerFactory;
import org.eclipse.emf.query2.internal.logger.QueryLogger;
import org.eclipse.emf.query2.internal.messages.ApiMessages;
import org.eclipse.emf.query2.internal.messages.BugMessages;
import org.eclipse.emf.query2.internal.moinql.ast.AliasName;
import org.eclipse.emf.query2.internal.moinql.ast.AssocPredicate;
import org.eclipse.emf.query2.internal.moinql.ast.AtomicAttrReference;
import org.eclipse.emf.query2.internal.moinql.ast.AtomicEntry;
import org.eclipse.emf.query2.internal.moinql.ast.AtomicEntryFixedSet;
import org.eclipse.emf.query2.internal.moinql.ast.AtomicEntryReference;
import org.eclipse.emf.query2.internal.moinql.ast.AttrComparison;
import org.eclipse.emf.query2.internal.moinql.ast.InternalQuery;
import org.eclipse.emf.query2.internal.moinql.ast.LeafQuery;
import org.eclipse.emf.query2.internal.moinql.ast.LeafSelectEntry;
import org.eclipse.emf.query2.internal.moinql.ast.LikeComparison;
import org.eclipse.emf.query2.internal.moinql.ast.LinksPredicate;
import org.eclipse.emf.query2.internal.moinql.ast.NaryWhereClause;
import org.eclipse.emf.query2.internal.moinql.ast.NumericComparison;
import org.eclipse.emf.query2.internal.moinql.ast.TypeAttrReference;
import org.eclipse.emf.query2.internal.moinql.ast.TypeComparison;
import org.eclipse.emf.query2.internal.moinql.ast.TypeReference;
import org.eclipse.emf.query2.internal.moinql.ast.WhereClause;
import org.eclipse.emf.query2.internal.moinql.ast.WithEntry;
import org.eclipse.emf.query2.internal.shared.AuxServices;
import org.eclipse.emf.query2.internal.shared.BugException;
import org.eclipse.emf.query2.internal.shared.UsageException;
import org.eclipse.emf.query2.report.LocalizedProcessException;
import org.eclipse.emf.query2.report.ProcessErrorImpl;
import org.eclipse.emf.query2.report.ProcessReport;
import org.eclipse.emf.query2.report.ProcessWarningImpl;


/**
 * The type checker transforms the client API into the internal data structure.
 * In doing so, it checks for formatting and type errors.
 */
@SuppressWarnings("unchecked")
final public class TypeCheckerImpl implements TypeChecker {

	// trace setup
	@SuppressWarnings("unused")
	private static final QueryLogger logger = LoggerFactory.getLogger(TypeCheckerImpl.class);

	private ProcessReport report;

	// private CoreConnection conn;

	/*
	 * Keeps track of how alias names are mapped onto atomic entries, locally
	 * per level of nested query
	 */
	private Map<String, AtomicEntry> environment = null;

	/*
	 * Keeps track of the all aliases used in the entire query
	 */
	private Set<String> usedAliases = null;

	private EmfHelper emfHelper;

	public TypeCheckerImpl(EmfHelper emfHelper) {

		this.emfHelper = emfHelper;
		// this.jmiHelper = this.conn.getCoreJmiHelper( );
	}

	public InternalQuery convert(Query mqlQuery, ProcessReport _report) throws QueryFormatException {

		// empty environment to start.
		this.usedAliases = new HashSet<String>();

		// set the report
		this.report = _report;

		// the top-level query argument is a non-nested query
		InternalQuery internalQuery = this.convertQuery(mqlQuery, false);

		return internalQuery;
	}

	/* ----------------- */
	/* Private methods */
	/* ----------------- */

	/**
	 * A fatal error implies that the type-checker should give up because
	 * subsequent problems would not be handled. This version uses the
	 * MQLElement for positional information
	 */
	private void reportFatal(QueryElement element, LocalizedString message, Object... args) throws QueryFormatException {

		if (element.getStartPos() >= 0) {
			this.report.reportFatalError(new ProcessErrorImpl(new UsageException(message, args), element.getStartLine(), element
					.getStartColumn(), element.getEndLine(), element.getEndColumn(), element.getStartPos(), element.getEndPos()));
		} else {
			this.report.reportFatalError(new ProcessErrorImpl(new UsageException(message, args)));
		}

		throw new QueryFormatException(this.report);
	}

	private void reportFatal(LocalizedString message, Object... args) throws QueryFormatException {

		this.report.reportFatalError(new ProcessErrorImpl(new UsageException(message, args)));

		throw new QueryFormatException(this.report);
	}

	/**
	 * A non-fatal error is simply collected and type-checking can proceed. This
	 * version uses the MQLElement for positional information
	 */
	private void reportError(QueryElement element, LocalizedString message, Object... args) {

		if (element.getStartPos() >= 0) {
			this.report.reportError(new ProcessErrorImpl(new UsageException(message, args), element.getStartLine(), element
					.getStartColumn(), element.getEndLine(), element.getEndColumn(), element.getStartPos(), element.getEndPos()));
		} else {
			this.report.reportError(new ProcessErrorImpl(new UsageException(message, args)));
		}

		if (this.report.getProcessStatus() == ProcessReport.FATAL) {
			throw new QueryFormatException(this.report);
		}
	}

	/**
	 * A non-fatal error is simply collected and type-checking can proceed
	 */
	private void reportError(LocalizedString message, Object... args) {

		this.report.reportError(new ProcessErrorImpl(new UsageException(message, args)));

		if (this.report.getProcessStatus() == ProcessReport.FATAL) {
			throw new QueryFormatException(this.report);
		}
	}

	/**
	 * A warning is simply collected and type-checking can proceed
	 */
	private void reportWarning(QueryElement element, LocalizedString message, Object... args) {

		if (element.getStartPos() >= 0) {
			StackTraceElement[] trace = new LocalizedProcessException(message, args).getStackTrace();
			ProcessWarningImpl warn = new ProcessWarningImpl(trace, element.getStartLine(), element.getStartColumn(), element.getEndLine(),
					element.getEndColumn(), element.getStartPos(), element.getEndPos(), message, args);
			this.report.reportWarning(warn);
		} else {
			ProcessWarningImpl warn = new ProcessWarningImpl(null, message, args);
			this.report.reportWarning(warn);
		}
	}

	/**
	 * Convert entire query. If nested==true, then some additional constraints
	 * have to hold on the format of the MQLQuery because it is nested in a
	 * linked predicate.
	 */
	@SuppressWarnings("null")
	private LeafQuery convertQuery(Query mqlQuery, boolean nested) throws QueryFormatException {

		// a select clause should not be null
		if (mqlQuery == null) {
			this.reportFatal(ApiMessages.EMPTY_QUERY_PART, "Select"); //$NON-NLS-1$
		}

		/*
		 * (1) From Types
		 */

		// the local environment only remembers the aliases of the from entries
		// at *this* level
		this.environment = new HashMap<String, AtomicEntry>();

		// transform the from-clause and build up the environment
		List<AtomicEntry> atomicEntries = this.convertFromEntries(mqlQuery.getFromEntries());

		/*
		 * (2) Select Entries
		 */

		// translate the select entries
		List<LeafSelectEntry> internalSelectEntries = this.convertSelectEntries(mqlQuery.getSelectEntries(), nested);

		/*
		 * (3) Where Entries
		 */

		// obtain the local and joining where entries
		List<LocalWhereEntry> localWhereEntries = new ArrayList<LocalWhereEntry>();
		List<JoinWhereEntry> joinWhereEntries = new ArrayList<JoinWhereEntry>();

		for (WhereEntry whereEntry : mqlQuery.getWhereEntries()) {
			if (whereEntry instanceof LocalWhereEntry) {
				localWhereEntries.add((LocalWhereEntry) whereEntry);
			} else if (whereEntry instanceof JoinWhereEntry) {
				joinWhereEntries.add((JoinWhereEntry) whereEntry);
			} else {
				throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, whereEntry.getClass().getCanonicalName(), "WhereEntry"); //$NON-NLS-1$
			}
		}

		// attach the local where entries to the respective AtomicEntries in the
		// environment. Note that some local where entries
		// are actually joining where entries (the parser encoded them as local
		// where entries). This is the point where we extract
		// them if necessary
		List<WithEntry> internalWithEntriesFromLocalWhereEntries = this.convertLocalWhereEntries(localWhereEntries);

		// convert the joining where entries as they were original entered
		List<WithEntry> internalWithEntries = this.convertJoinWhereEntries(joinWhereEntries);

		// now add the extracted with entries to the regular with entries
		internalWithEntries.addAll(internalWithEntriesFromLocalWhereEntries);

		// build result query from converted parts.

		// first set the new alias
		AliasName newAlias = (nested ? new AliasName(AuxServices.NESTEDALIAS) : new AliasName(AuxServices.RESULTALIAS));

		// check for restrictions on Reflect::Element
		if (!nested && atomicEntries.size() == 1 && atomicEntries.get(0).isReflectElement() && !atomicEntries.get(0).isScopeInclusive()) {
			this.reportFatal(ApiMessages.MUST_RESTRICT_SCOPE_FOR_ELEMENT);
		}

		// construct result
		LeafQuery resultingInternalQuery = LeafQuery.construct(newAlias, atomicEntries, internalWithEntries, internalSelectEntries);

		return resultingInternalQuery;
	}

	/**
	 * Convert FromEntries and return a map from alias names to AtomicEntries
	 */
	@SuppressWarnings("null")
	private List<AtomicEntry> convertFromEntries(FromEntry[] mqlFromEntries) throws QueryFormatException {

		// it is mandatory to provide at least one from-entry
		if (mqlFromEntries == null || mqlFromEntries.length == 0) {
			this.reportFatal(ApiMessages.EMPTY_QUERY_PART, "FromEntry[]"); //$NON-NLS-1$
		}

		List<AtomicEntry> atomicEntries = new ArrayList<AtomicEntry>(mqlFromEntries.length);

		// loop over all from-entries and register them in the environment
		for (int i = 0; i < mqlFromEntries.length; i++) {
			FromEntry mqlFromEntry = mqlFromEntries[i];
			// convert each from-entry
			atomicEntries.add(this.convertFromEntry(mqlFromEntry));
		}

		return atomicEntries;
	}

	/**
	 * Converts one FromEntry and put it in the environment
	 */
	@SuppressWarnings("null")
	private AtomicEntry convertFromEntry(FromEntry mqlFromEntry) throws QueryFormatException {

		// a from-entry should not be null
		if (mqlFromEntry == null) {
			this.reportFatal(ApiMessages.EMPTY_QUERY_PART, "FromEntry"); //$NON-NLS-1$
		}

		// set the alias name
		String fromAlias = mqlFromEntry.getAliasName();

		// check if the alias provided by the client makes sense
		if (fromAlias == null || fromAlias.equals(AuxServices.EMPTYSTR)) {
			this.reportFatal(ApiMessages.EMPTY_ALIAS);
		}

		// check if the alias has already been used in the query
		if (this.usedAliases.contains(fromAlias)) {
			this.reportFatal(mqlFromEntry, ApiMessages.DUPLICATE_ALIAS, fromAlias);
		}

		/* 1. calculate the top type of the from entry */
		/* --------------------------------------------- */

		// mri of the type
		URI mriOfType = null;

		// if ( mqlFromEntry instanceof FromTypeMri ) {
		// // the MRI of the type was provided by the user
		// mriOfType = ( (FromTypeMri) mqlFromEntry ).getMri( );
		//
		// } else
		if (mqlFromEntry instanceof FromType) {
			// only the qualified name of the type was provided by the user
			mriOfType = ((FromType) mqlFromEntry).getTypeUri();
			// String containerName = ( (FromType) mqlFromEntry
			// ).getContainerName( );

			// calculate the MRI of the qualified name
			if ((mriOfType == null)) {
				this.reportFatal(ApiMessages.EMPTY_QUALIFIED_NAMES);
			}
			//            mriOfType = this.emfHelper.createUri( qName[0] );
			// this.mriOfType = this.resolveMRIForQualifiedName( qName,
			// containerName, mqlFromEntry );

			//		} else if (mqlFromEntry instanceof FromFixedElement) {
			//			throw new IllegalArgumentException();
			// URI element = ( (FromFixedElement) mqlFromEntry ).getElement( );
			//
			// EObject elementAsObject = this.conn.getElement( element );
			// // We expect a refObject so we can obtain the type
			// if ( elementAsObject instanceof RefObject ) {
			// // get the type of this element
			// mriOfType = ( (Partitionable) ( ( (RefObject) elementAsObject
			// ).refMetaObject( ) ) ).get___Mri( );
			// } else {
			// // it is illegal to not provide a MofClass or StructureType
			// this.reportFatal( mqlFromEntry,
			// MQLApiMessages.MRI_MISSING_ONE_FIXED_ELEMENT );
			// }
			//
		} else {
			throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, mqlFromEntry.getClass().getCanonicalName(), "FROMENTRY"); //$NON-NLS-1$
		}

		// get the model Element for the MRI
		EObject typeAsModelElement = this.emfHelper.getElement(mriOfType);

		// we have to verify if we are dealing with Reflect::Element
		boolean isReflectElement = this.checkForReflectElement(typeAsModelElement);

		// verify if we are dealing with a MofClass or StructureType
		SpiFqlFromTypeCategory modelElementCategory = null;
		if (typeAsModelElement instanceof EClass) {
			modelElementCategory = SpiFqlFromTypeCategory.CLASS;
			// } else if ( typeAsModelElement instanceof StructureType ) {
			// modelElementCategory = SpiFqlFromTypeCategory.STRUCTURETYPE;
		} else {
			// it is illegal to not provide a MofClass or StructureType
			this.reportFatal(mqlFromEntry, ApiMessages.CLASS_OR_STRUCTTYPE_EXPECTED, fromAlias, mriOfType);
		}

		// calculate the name of the MofClass or StructureType
		String nameOfType = mriOfType.toString();
		// String nameOfType = this.printTypeName( ( (ModelElementInternal)
		// typeAsModelElement ).getQualifiedName( this.conn ),
		// mriOfType.getContainerName( ) );

		/* 2. calculate the subtypes of the top type if this was asked for */
		/* ----------------------------------------------------------------- */

		// initialize by adding the main type to the front of the lists
		List<URI> classMRIs = new ArrayList<URI>();
		classMRIs.add(mriOfType);

		List<String> classNames = new ArrayList<String>();
		classNames.add(nameOfType);

		// Obtain the explicitly provided exclusion types if any
		Set<URI> withoutSubTypeSet = mqlFromEntry.getWithoutSubtypeSet();

		// if the boolean flag is set to true and no explicit set was provided,
		// we definitely exclude all subtypes
		boolean noSubtypes = mqlFromEntry.isWithoutSubtypes() && withoutSubTypeSet == null;

		// we only consider the withoutSubtypes clause whenever the model
		// element is a MofClass and not Reflect::Element
		// FIXME This is the spot where something needs to be done if structure
		// types can inherit from each other!
		if (!noSubtypes && !isReflectElement && typeAsModelElement instanceof EClass) {

			// we have a mofClass
			EClass typeAsMofClass = (EClass) typeAsModelElement;

			// now try to resolve the explicit exclusion types
			Set<URI> withoutSubTypeMRISet = null;
			if (withoutSubTypeSet != null) {
				withoutSubTypeMRISet = new HashSet<URI>(withoutSubTypeSet.size());
				for (URI mriOfExcludedType : withoutSubTypeSet) {
					// try to resolve
					//                    URI mriOfExcludedType = this.emfHelper.createUri( qualName.qualifiedMofName[0] );
					// MRI mriOfExcludedType = this.resolveMRIForQualifiedName(
					// qualName.qualifiedMofName, qualName.containerName,
					// mqlFromEntry );

					// if already in exclusion set - keep going
					if (!withoutSubTypeMRISet.contains(mriOfExcludedType)) {

						// check if the resolution is actually a type (i.e.
						// MofClass)
						EObject excludedTypeAsRefBaseObject = this.emfHelper.getElement(mriOfExcludedType);
						if (excludedTypeAsRefBaseObject instanceof EClass) {
							EClass excludedEClass = (EClass) excludedTypeAsRefBaseObject;
							if (!excludedEClass.getEAllSuperTypes().contains(typeAsMofClass)) {
								this.reportError(mqlFromEntry, ApiMessages.EXCLUDED_TYPE_IS_NOT_SUBTYPE, mriOfExcludedType, mriOfType);
							} else {

								withoutSubTypeMRISet.add(mriOfExcludedType);

								// also add all its subtypes -> this was removed
								// because it is not general enough
								Collection<EClass> subTypesOfExcludedType = this.emfHelper.getAllSubtypes(excludedEClass);
								for (EClass element : subTypesOfExcludedType) {
									URI subTypeofExcludedTypeAsMri = EcoreUtil.getURI(element);
									// add to exclusion set
									withoutSubTypeMRISet.add(subTypeofExcludedTypeAsMri);
								}
							}
						} else {
							// report error if the exclusion includes something
							// which is not a MofClass
							this.reportError(mqlFromEntry, ApiMessages.TRYING_TO_EXCLUDE_NON_MOF_CLASS,
									new Object[] { mriOfType.toString() });
						}
					}
				}

				// we have to check that the top-level type of this from entry
				// is not in the exclusion set
				if (withoutSubTypeMRISet.contains(mriOfType)) {
					this.reportFatal(mqlFromEntry, ApiMessages.FROMENTRY_TYPE_IN_SUBTYPE_EXCLUSION_SET, nameOfType);
				}
			} else {
				withoutSubTypeMRISet = Collections.emptySet();
			}

			// now obtain the subtypes
			this.getSubTypes(typeAsMofClass, withoutSubTypeMRISet, classMRIs, classNames);

		}

		/* 3. Deal with fixed elements if they were provided */
		/* --------------------------------------------------- */

		Set<URI> elements = null;

		// first case is for more than one fixed element
		if (mqlFromEntry instanceof FromFixedSet) {

			// verify if we are dealing with a mofClass only, i.e. not a
			// structure type
			// if ( typeAsModelElement instanceof StructureType ) {
			// this.reportError( mqlFromEntry,
			// MQLApiMessages.NO_STRUCTTYPE_FOR_FIXED_SET, fromAlias );
			// }

			elements = new HashSet<URI>();

			// get the provided "unverified" elements
			URI[] uncheckedElements = null;
			// if ( mqlFromEntry instanceof FromFixedSet ) {
			uncheckedElements = ((FromFixedSet) mqlFromEntry).getElements();
			// } else if ( mqlFromEntry instanceof FromMriTypeFixedSet ) {
			// uncheckedElements = ( (FromMriTypeFixedSet) mqlFromEntry
			// ).getElements( );
			// }

			// we expect at least one such element
			if (uncheckedElements != null && uncheckedElements.length > 0) {
				// we need the following stuff for finding the type of a MRI
				// ReferenceManager rm = this.conn.getSession(
				// ).getWorkspaceSet( ).getReferenceManager( );

				// verify for each if it is type-conform, where Reflect::Element
				// typed elements always conform
				for (int i = 0; i < uncheckedElements.length; i++) {
					URI element = uncheckedElements[i];
					if (isReflectElement) {
						// for Reflect::Element, we do not have to do the
						// (possibly expensive) type-check
						elements.add(element);
					} else {
						// obtain the type of the element
						EObject eElement = this.emfHelper.getElement(element);
						if (eElement != null) {
							EClass mofTypeOfElement = eElement.eClass();
							if (classMRIs.contains(EcoreUtil.getURI(mofTypeOfElement))) {
								elements.add(element);
							} else {
								this.reportError(mqlFromEntry, ApiMessages.PROVIDED_ELEMENT_OF_WRONG_TYPE, element, fromAlias, nameOfType);
							}
						}
					}
				}

			} else {
				this.reportError(mqlFromEntry, ApiMessages.EMPTY_FIXED_SET, fromAlias);
			}

			//		} else if (mqlFromEntry instanceof FromFixedElement) {
			//			// second case is for one element
			//			throw new IllegalArgumentException();
			// elements = new HashSet<MRI>( );
			// elements.add( ( (FromFixedElement) mqlFromEntry ).getElement( )
			// );
		}

		/* 4. Deal with scope if it was provided for */
		/* ------------------------------------------- */

		boolean isIncluded = mqlFromEntry.isIncluded();

		// copy the original partition scope in a set
		URI[] originalPriScope = mqlFromEntry.getPartitionScope();
		Set<URI> priScope = new HashSet<URI>(originalPriScope.length);
		for (int i = 0; i < originalPriScope.length; i++) {
			if (originalPriScope[i] == null) {
				this.reportError(ApiMessages.PARTITION_NULL_IN_SCOPE);
			} else {
				priScope.add(originalPriScope[i]);
			}
		}

		// if we ask for Reflect::Element and have no inclusion scope, we issue
		// a warning. Note that it may be legal to
		// provide no scope for a reflect::element if it is connected to another
		// atomic entry
		if (isReflectElement && !isIncluded) {
			this.reportWarning(mqlFromEntry, ApiMessages.REFLECT_ELEMENT_SAFER_WITH_SCOPE);
		}

		// Structure types should not be scoped as their scope is calculated
		// from their connection to Class-based atomic entries
		// if ( typeAsModelElement instanceof StructureType && priScope.size( )
		// > 0 ) {
		// this.reportWarning( mqlFromEntry,
		// MQLApiMessages.STRUCTURE_TYPE_SHOULD_NOT_HAVE_SCOPE );
		// }

		// copy the container scope
		// CRI[] originalModelContainersInScope = mqlFromEntry.getCriScope( );
		// Set<CRI> modelContainersInScope = new HashSet<CRI>(
		// originalModelContainersInScope.length );
		// for ( int i = 0; i < originalModelContainersInScope.length; i++ ) {
		// if ( originalModelContainersInScope[i] == null ) {
		// this.reportError( MQLApiMessages.NULL_CONTAINER );
		// } else {
		// modelContainersInScope.add( originalModelContainersInScope[i] );
		// }
		// }

		/* 5. Construct the atomic entry */
		/* ------------------------------- */

		AtomicEntry internalFromEntry = null;
		AliasName newFromAlias = new AliasName(fromAlias);

		if (elements == null) {
			// if we have no fixed elements
			internalFromEntry = new AtomicEntry(newFromAlias, classMRIs, classNames, modelElementCategory, isReflectElement, priScope,
					null, isIncluded);
		} else {
			// throw new IllegalArgumentException();
			// if we have fixed elements (currently only inclusive)
			internalFromEntry = new AtomicEntryFixedSet(newFromAlias, classMRIs, classNames, elements, isReflectElement, null, null, false);
		}

		// insert in the local query environment
		this.environment.put(fromAlias, internalFromEntry);

		// insert also in the global environment
		this.usedAliases.add(fromAlias);

		return internalFromEntry;
	}

	private void getSubTypes(EClass typeAsMofClass, Set<URI> withoutSubTypeMRISet, List<URI> classMRIs, List<String> classNames) {

		Collection<EClass> subTypes = this.emfHelper.getAllSubtypes(typeAsMofClass);
		for (Iterator<EClass> iter = subTypes.iterator(); iter.hasNext();) {
			EClass generalizableElement = iter.next();
			// obtain the MRI of the subtype
			URI mriOfSubType = EcoreUtil.getURI(generalizableElement);

			// we only add a subtype if it is *not* in the exclusion set
			if (!withoutSubTypeMRISet.contains(mriOfSubType)) {

				// add it to the list
				classMRIs.add(mriOfSubType);

				// obtain the name of subtype
				String nameOfSubType = mriOfSubType.toString();
				// String nameOfSubType = this.printTypeName(
				// MoinMetamodelCode.getQualifiedName( this.conn, (ModelElement)
				// generalizableElement, (RefObjectImpl) generalizableElement ),
				// mriOfSubType.getContainerName( ) );

				// add it to the list
				classNames.add(nameOfSubType);
			}
		}
	}

	/**
	 * Convert SelectEntries. Observe that we do not permit that the same
	 * alias.attr combination, or also alias combination occurs twice in the
	 * query, because it would not be possible to unambiguously select the right
	 * column from the result-set (which happens on an alias, or alias/attribute
	 * name basis.
	 */
	@SuppressWarnings("null")
	private List<LeafSelectEntry> convertSelectEntries(SelectEntry[] mqlSelectEntries, boolean nested) throws QueryFormatException {

		// make sure that at least one selection is made
		if (mqlSelectEntries == null || mqlSelectEntries.length == 0) {
			this.reportFatal(ApiMessages.EMPTY_QUERY_PART, "SelectEntry[]"); //$NON-NLS-1$
		}

		// collect all SelectEntries
		List<LeafSelectEntry> internalSelectEntries = new ArrayList<LeafSelectEntry>();

		// we keep a set of alias names to determine whether the alias was
		// selected before
		Set<String> seenAliasSelections = new HashSet<String>();

		// we also keep a map from alias names to seen attribute names
		Map<String, Set<String>> seenAttributeSelections = new HashMap<String, Set<String>>();

		for (int i = 0; i < mqlSelectEntries.length; i++) {
			SelectEntry mqlSelectEntry = mqlSelectEntries[i];
			String mqlSelectEntryAlias = mqlSelectEntry.getAliasName();

			// check if the selection refers to an alias at the same level in
			// the query
			AtomicEntry atomicEntry = this.environment.get(mqlSelectEntryAlias);
			if (atomicEntry == null) {
				this.reportFatal(mqlSelectEntry, ApiMessages.UNDEFINED_ALIAS_AT_PEER_LEVEL, mqlSelectEntryAlias);
			} else {

				// The selection selects a model element only
				if (mqlSelectEntry instanceof SelectAlias) {
					if (!seenAliasSelections.add(mqlSelectEntryAlias)) {
						// if we selected the alias before (i.e. no attribute
						// only), we have a problem
						this.reportError(mqlSelectEntry, ApiMessages.REPEATED_SELECT_ENTRY, mqlSelectEntryAlias);
					}

					// when an alias is selected, we disallow structure types to
					// be selected
					// (this makes no sense because structure types have no
					// identity)
					if (atomicEntry.getTypeCategory().equals(SpiFqlFromTypeCategory.STRUCTURETYPE)) {
						String topTypeName = atomicEntry.getClassName();
						this.reportError(mqlSelectEntry, ApiMessages.STRUCTURE_FIELD_EXPECTED, mqlSelectEntryAlias, topTypeName);
					}

					// build the reference
					internalSelectEntries.add(new LeafSelectEntry(new AtomicEntryReference(atomicEntry)));

				} else if (mqlSelectEntry instanceof SelectAttrs) {
					// The selection selects attributes of a model element
					Set<String> selectedAttributes = seenAttributeSelections.get(mqlSelectEntryAlias);

					if (selectedAttributes == null) {
						// we have not done any attribute selection for this
						// alias before
						selectedAttributes = new HashSet<String>();
						seenAttributeSelections.put(mqlSelectEntryAlias, selectedAttributes);
					}

					// obtain the attribute names
					String[] attrNames = ((SelectAttrs) mqlSelectEntry).getAttrNames();

					for (int j = 0; j < attrNames.length; j++) {
						// check if not seen before
						if (selectedAttributes.add(attrNames[j])) {

							// check if the attribute exists for the type
							AttributeResolution attrRes = this.resolveAttributeForAtomicEntry(atomicEntry, attrNames[j], mqlSelectEntry);
							// construct the reference if so
							AtomicAttrReference elRef = new AtomicAttrReference(atomicEntry, attrNames[j], attrRes.attrType,
									attrRes.multivalued, attrRes.isOrdered, attrRes.isUnique);
							internalSelectEntries.add(new LeafSelectEntry(elRef));
						} else {
							// attribute selection already made
							this.reportError(ApiMessages.SELATTR_JUST_ONCE, attrNames[j], mqlSelectEntryAlias);
						}
					}
				} else {
					throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, mqlSelectEntry.getClass().getCanonicalName(), "SelectEntry"); //$NON-NLS-1$
				}
			}
		}

		// if we are in a nested select, we have to check that only one
		// selection to an alias is made
		if (nested) {
			TypeReference typeRef = internalSelectEntries.get(0).getTypeReference();

			if (!(internalSelectEntries.size() == 1 && (typeRef instanceof AtomicEntryReference) && !(typeRef instanceof AtomicAttrReference))) {
				// the condition for a nested select is not given
				this.reportFatal(ApiMessages.INVALID_NESTED_QUERY_SELECT);
			}
		}

		return internalSelectEntries;
	}

	/**
	 * Convert Local WhereEntrys
	 */
	private List<WithEntry> convertLocalWhereEntries(List<LocalWhereEntry> localWhereEntries) throws QueryFormatException {

		// we collect the possible with-entries, which were encoded as local
		// where entries. All assoc references comparing with
		// null are encoded as local where entries by the parser, even though we
		// internally have to convert them to joining where entries
		// e.g. myAlias.reference[Package::Assoc] = null
		// will be encoded as a local where entry, even though it really is a
		// joining where entry (encoded with a nested query)
		List<WithEntry> resultingWithEntries = new ArrayList<WithEntry>();

		// we only proceed if the array of where entries is not null
		if (localWhereEntries != null) {
			for (LocalWhereEntry whereEntry : localWhereEntries) {
				// first obtain the alias name and the actual where clause
				String aliasName = whereEntry.getLeftAlias();

				// check if the alias is actually defined at the same peer-level
				// from clause
				AtomicEntry atomicEntry = this.environment.get(aliasName);
				if (atomicEntry == null) {
					this.reportFatal(whereEntry, ApiMessages.UNDEFINED_ALIAS_AT_PEER_LEVEL, aliasName);
				} else {
					// convert the where clause (the conversion starts by not
					// having a negation - this property is propagated)
					WhereClause internalWhereClause = this.convertWhereClause(atomicEntry, whereEntry.getNestedClause(),
							resultingWithEntries, false);

					// only do something if we obtained a valid
					// internalWhereClause
					if (internalWhereClause != null) {

						// possibly the atomic entry already has an internal
						// where
						// clause for that alias. In that case, we simply put in
						// a logical AND with the existing where clause
						WhereClause existingWhereClause = atomicEntry.getWhereClause();

						if (existingWhereClause != null) {
							// if the existing clause is already a logical AND,
							// we
							// simply add the current internal where clause
							if ((existingWhereClause instanceof NaryWhereClause)
									&& (!((NaryWhereClause) existingWhereClause).isOrConnected())) {
								if ((internalWhereClause instanceof NaryWhereClause)
										&& (!((NaryWhereClause) internalWhereClause).isOrConnected())) {
									List<WhereClause> nestedWhereClauses = ((NaryWhereClause) internalWhereClause).getNestedClauses();
									// case where both where clauses are logical
									// ANDs, so just connect
									((NaryWhereClause) existingWhereClause).getNestedClauses().addAll(nestedWhereClauses);
								} else {
									// case where only the existingWhereClause
									// is a logical AND, so add without changing
									// the structure of the internalWhereClause
									((NaryWhereClause) existingWhereClause).getNestedClauses().add(internalWhereClause);
								}
							} else if ((internalWhereClause instanceof NaryWhereClause)
									&& (!((NaryWhereClause) internalWhereClause).isOrConnected())) {
								// case where only the internalWhereClause is a
								// logical AND, so add without changing the
								// structure of the existingWhereClause
								((NaryWhereClause) internalWhereClause).getNestedClauses().add(existingWhereClause);
								atomicEntry.setWhereClause(internalWhereClause);
							} else {
								// case where none of the two is a logical AND
								// clause, so put them both together as a
								// logical end without changing the structure
								List<WhereClause> newNestedWhereClauses = new ArrayList<WhereClause>(2);
								newNestedWhereClauses.add(existingWhereClause);
								newNestedWhereClauses.add(internalWhereClause);
								atomicEntry.setWhereClause(new NaryWhereClause(atomicEntry, false, newNestedWhereClauses));
							}
						} else {
							// case where no existing where clause existed in
							// the first place
							atomicEntry.setWhereClause(internalWhereClause);
						}
					}
				}
			}
		}

		return resultingWithEntries;
	}

	/**
	 * Convert the WhereClause
	 */
	@SuppressWarnings("null")
	private WhereClause convertWhereClause(AtomicEntry atomicEntry, org.eclipse.emf.query2.WhereClause mqlWhereClause,
			List<WithEntry> resultingWithEntries, boolean negated) throws QueryFormatException {

		// make sure that a where clause was constructed
		if (mqlWhereClause == null) {
			this.reportFatal(ApiMessages.EMPTY_QUERY_PART, "WhereClause"); //$NON-NLS-1$
		}

		WhereClause internalWhereClause = null;

		// case distinction and construction of internal where clause
		if (mqlWhereClause instanceof WhereNot) {
			WhereNot mqlNotWhereClause = (WhereNot) mqlWhereClause;

			// convert nested clause
			// Notice that it is not possible to have joining where entries
			// encoded as local where entries once we dive into the boolean
			// expression (hence the null value)
			// Notice that we flip the negation here
			internalWhereClause = this.convertWhereClause(atomicEntry, mqlNotWhereClause.getNestedClause(), null, !negated);

		} else if (mqlWhereClause instanceof WhereNary) {
			WhereNary mqlNaryWhereClause = (WhereNary) mqlWhereClause;

			// define the conjunction - note that we have to swap the
			// conjunction if we propagate the negation
			boolean withOr = (negated ? !(mqlWhereClause instanceof WhereOr) : mqlWhereClause instanceof WhereOr);

			// convert nested clauses
			org.eclipse.emf.query2.WhereClause[] mqlNestedClauses = mqlNaryWhereClause.getNestedClauses();
			List<WhereClause> nestedClauses = new ArrayList<WhereClause>(mqlNestedClauses.length);
			for (int i = 0; i < mqlNestedClauses.length; i++) {
				// (Notice that it is not possible to have joining where entries
				// encoded as local where entries once we dive into the boolean
				// expression (hence the null value)
				nestedClauses.add(i, this.convertWhereClause(atomicEntry, mqlNestedClauses[i], null, negated));
			}

			// construct result
			internalWhereClause = new NaryWhereClause(atomicEntry, withOr, nestedClauses);

		} else if (mqlWhereClause instanceof WhereComparator) {
			WhereComparator mqlComparatorClause = (WhereComparator) mqlWhereClause;
			Operation operation = mqlComparatorClause.getOperation();
			String attrName = mqlComparatorClause.getAttrName();

			// first, we verify if this is a null-comparison by investigating if
			// the attrName is really an association end or reference
			ReferenceResolution assocResolution = this.resolveFeatureForAttomicEntry(atomicEntry, attrName);

			if (assocResolution != null) {
				// throw new IllegalArgumentException( "NULL not supported" );
				// this is only possible when the whereClause was *immediately*
				// a WhereComparator, not after being nested in a negation or
				// logical conjunction
				if (resultingWithEntries == null) {
					throw new BugException(BugMessages.ASSOC_BASED_COMPARISON_IN_NESTED_FOR_CLAUSE);
				}

				// we have an association reference here. This implies we only
				// accept a WhereString, comparing with a
				// null value for equality or inequality
				if (mqlComparatorClause instanceof WhereString) {
					if (((WhereString) mqlComparatorClause).getStringValue() == null) {

						boolean negatedLink = false;
						switch (operation) {
						case EQUAL:
							negatedLink = true;
							break;
						case NOTEQUAL:
							negatedLink = false;
							break;
						default:
							throw new BugException(BugMessages.NULL_COMPARISON_WITH_ILLEGAL_OPERATOR, operation);
						}

						LeafQuery nestedLeafQuery = this.constructNestedQueryForAssociationReferenceNullPointerCheck(
								assocResolution.assocMRI, assocResolution.assocName);

						AtomicEntryReference fromType = new AtomicEntryReference(atomicEntry);

						// construct and add the links predicate
						LinksPredicate linksPredicate = new LinksPredicate(negatedLink, assocResolution.assocMRI,
								assocResolution.assocName, fromType, nestedLeafQuery);

						resultingWithEntries.add(linksPredicate);

					} else {
						this.reportFatal(mqlComparatorClause, ApiMessages.UNEXPECTED_ASSOC_WITH_LITERAL_OP_COMPARE, attrName,
								((WhereString) mqlComparatorClause).getStringValue(), operation);
					}
				}

			} else {

				// since it is not referring to an association, we have to
				// generally check if we have a valid operation for the
				// attribute
				AttributeResolution attrRes = this.resolveAttributeForAtomicEntry(atomicEntry, attrName, mqlComparatorClause);

				// obtain the value of the comparison and verify if the type is
				// correct
				Object value;

				// switch ( attrRes.attrType ) {
				// case BOOLEAN:
				// if ( !( mqlWhereClause instanceof WhereBool ) ) {
				// this.reportError( mqlWhereClause,
				// MQLApiMessages.COMPARISON_INCOMPATIBLE_TYPE_CHECK, new
				// Object[] { attrName, attrRes.attrType,
				// SpiFqlPrimitiveType.BOOLEAN } );
				// }
				// value = Boolean.valueOf( ( (WhereBool) mqlWhereClause
				// ).getBoolValue( ) );
				// break;
				// case DOUBLE:
				// case FLOAT:
				// case INTEGER:
				// case LONG:
				// if ( mqlWhereClause instanceof WhereInt ) {
				// value = Integer.valueOf( ( (WhereInt) mqlWhereClause
				// ).getIntValue( ) );
				// } else if ( mqlWhereClause instanceof WhereLong ) {
				// value = Long.valueOf( ( (WhereLong) mqlWhereClause
				// ).getLongValue( ) );
				// } else if ( mqlWhereClause instanceof WhereFloat ) {
				// value = new Float( ( (WhereFloat) mqlWhereClause
				// ).getFloatValue( ) );
				// } else if ( mqlWhereClause instanceof WhereDouble ) {
				// value = new Double( ( (WhereDouble) mqlWhereClause
				// ).getDoubleValue( ) );
				// } else if ( mqlWhereClause instanceof WhereBool ) {
				// this.reportError( mqlWhereClause,
				// MQLApiMessages.COMPARISON_INCOMPATIBLE_TYPE_CHECK, new
				// Object[] { attrName, attrRes.attrType,
				// SpiFqlPrimitiveType.BOOLEAN } );
				// value = Boolean.valueOf( ( (WhereBool) mqlWhereClause
				// ).getBoolValue( ) );
				// } else if ( mqlWhereClause instanceof WhereString ) {
				// this.reportError( mqlWhereClause,
				// MQLApiMessages.COMPARISON_INCOMPATIBLE_TYPE_CHECK, new
				// Object[] { attrName, attrRes.attrType,
				// SpiFqlPrimitiveType.STRING } );
				// value = ( (WhereString) mqlWhereClause ).getStringValue( );
				// } else {
				//                            throw new MQLBugException( MQLBugMessages.UNEXPECTED_SUBTYPE, mqlWhereClause.getClass( ).getCanonicalName( ), "WhereComparator" ); //$NON-NLS-1$
				// }
				// break;
				// case STRING:
				// if ( !( mqlWhereClause instanceof WhereString ) ) {
				// this.reportError( mqlWhereClause,
				// MQLApiMessages.COMPARISON_INCOMPATIBLE_TYPE_CHECK, new
				// Object[] { attrName, attrRes.attrType,
				// SpiFqlPrimitiveType.STRING } );
				// }
				// value = ( (WhereString) mqlWhereClause ).getStringValue( );
				// break;
				// default:
				//                        throw new MQLBugException( MQLBugMessages.UNEXPECTED_SUBTYPE, mqlWhereClause.getClass( ).getCanonicalName( ), "WhereComparator" ); //$NON-NLS-1$
				// }

				if (mqlWhereClause instanceof WhereBool) {
					if (!(attrRes.attrType.equals(SpiFqlPrimitiveType.BOOLEAN))) {
						this.reportError(mqlWhereClause, ApiMessages.COMPARISON_INCOMPATIBLE_TYPE_CHECK, new Object[] { attrName,
								attrRes.attrType, SpiFqlPrimitiveType.BOOLEAN });
					}
					value = Boolean.valueOf(((WhereBool) mqlWhereClause).getBoolValue());
				} else if (mqlWhereClause instanceof WhereInt) {
					value = Integer.valueOf(((WhereInt) mqlWhereClause).getIntValue());
					if (!(attrRes.attrType.equals(SpiFqlPrimitiveType.INTEGER))) {
						if (attrRes.attrType.equals(SpiFqlPrimitiveType.LONG)) {
							value = ((Number) value).longValue();
						} else {
							this.reportError(mqlWhereClause, ApiMessages.COMPARISON_INCOMPATIBLE_TYPE_CHECK, new Object[] { attrName,
									attrRes.attrType, SpiFqlPrimitiveType.INTEGER });
						}
					}
				} else if (mqlWhereClause instanceof WhereLong) {
					if (!(attrRes.attrType.equals(SpiFqlPrimitiveType.LONG))) {
						this.reportError(mqlWhereClause, ApiMessages.COMPARISON_INCOMPATIBLE_TYPE_CHECK, new Object[] { attrName,
								attrRes.attrType, SpiFqlPrimitiveType.LONG });
					}
					value = Long.valueOf(((WhereLong) mqlWhereClause).getLongValue());
				} else if (mqlWhereClause instanceof WhereFloat) {
					float flValue = ((WhereFloat) mqlWhereClause).getFloatValue();
					if (flValue == Float.POSITIVE_INFINITY || flValue == Float.NEGATIVE_INFINITY) {
						this.reportError(mqlWhereClause, ApiMessages.COMPARISON_INFINITY_NOT_ALLOWED);
					}
					value = new Float(flValue);
					if (!(attrRes.attrType.equals(SpiFqlPrimitiveType.FLOAT))) {
						this.reportError(mqlWhereClause, ApiMessages.COMPARISON_INCOMPATIBLE_TYPE_CHECK, new Object[] { attrName,
								attrRes.attrType, SpiFqlPrimitiveType.FLOAT });
					}
				} else if (mqlWhereClause instanceof WhereDouble) {
					double dblValue = ((WhereDouble) mqlWhereClause).getDoubleValue();
					if (dblValue == Double.POSITIVE_INFINITY || dblValue == Double.NEGATIVE_INFINITY) {
						this.reportError(mqlWhereClause, ApiMessages.COMPARISON_INFINITY_NOT_ALLOWED);
					}
					value = new Double(dblValue);
					if (!(attrRes.attrType.equals(SpiFqlPrimitiveType.DOUBLE))) {
						if (attrRes.attrType.equals(SpiFqlPrimitiveType.FLOAT) && dblValue < Float.MAX_VALUE && dblValue > -Float.MAX_VALUE) {
							value = ((Number) value).floatValue();
						} else {
							this.reportError(mqlWhereClause, ApiMessages.COMPARISON_INCOMPATIBLE_TYPE_CHECK, new Object[] { attrName,
									attrRes.attrType, SpiFqlPrimitiveType.DOUBLE });
						}
					}
				} else if (mqlWhereClause instanceof WhereString) {
					if (!(attrRes.attrType.equals(SpiFqlPrimitiveType.STRING))) {
						this.reportError(mqlWhereClause, ApiMessages.COMPARISON_INCOMPATIBLE_TYPE_CHECK, new Object[] { attrName,
								attrRes.attrType, SpiFqlPrimitiveType.STRING });
					}
					value = ((WhereString) mqlWhereClause).getStringValue();
				} else {
					throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, mqlWhereClause.getClass().getCanonicalName(),
							"WhereComparator"); //$NON-NLS-1$
				}

				// if we are dealing with strings, check if we have trailing
				// blanks
				// in the constant or pattern. Also, a string cannot exceed a
				// certain number of characters
				if (attrRes.attrType.equals(SpiFqlPrimitiveType.STRING)) {
					String str = (String) value;
					if (this.hasTrailingBlank(str)) {
						this.reportError(mqlWhereClause, ApiMessages.TRAILING_BLANKS_NOT_ALLOWED, str);
					}

					if (str != null) {
						int strLen = str.length();
						if (strLen > AuxServices.STRING_COMPARISON_MAX_LENGTH) {
							this.reportError(mqlWhereClause, ApiMessages.STRING_CONSTANT_TOO_LONG, str);
						}
					}
				}

				// verify and convert the operation
				SpiFqlComparisonOperation newOp = this.convertOperationValue(operation, negated, attrRes.attrType, true, mqlWhereClause);

				// construct result
				if (newOp == null) {
					// if the operation is null, we are dealing with the LIKE
					// operation, which has its own internal structure

					// In this case, we do not allow the comparing value
					// (pattern) to be null
					if (value == null) {
						this.reportError(ApiMessages.NULL_COMPARISON_PROBLEM, attrName, "LIKE"); //$NON-NLS-1$
					}

					// build the LIKE internal object
					internalWhereClause = new LikeComparison(atomicEntry, attrName, negated, (String) value);
				} else {
					switch (newOp) {
					case EQUAL:
					case NOT_EQUAL:
						break;
					default:
						// if the comparing value is null, we only allow
						// comparisons for equal and not equal
						if (value == null) {
							this.reportError(mqlWhereClause, ApiMessages.NULL_COMPARISON_PROBLEM, attrName, newOp);
						}
					}

					// build the Numerical internal object
					internalWhereClause = new NumericComparison(atomicEntry, attrName, attrRes.attrType, attrRes.multivalued, newOp, value);
				}
			}

		} else {
			throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, mqlWhereClause.getClass().getCanonicalName(), "WhereClause"); //$NON-NLS-1$
		}

		return internalWhereClause;
	}

	/**
	 * Given an assoc resolution and an atomic entry with an operation for a
	 * null-check, this method constructs the links predicate
	 */
	private LeafQuery constructNestedQueryForAssociationReferenceNullPointerCheck(URI assocMRI, String assocName) {

		// obtain the type for the right-hand side, which we need to construct
		// the nested query
		EReference assoc = this.emfHelper.getReference(assocMRI);
		// Association assoc = this.getMofAssociationForMri( assocMRI );

		if (assoc == null) {
			// we only support associations, i.e. no structure types because
			// structure types cannot be selected in the nested query
			this.reportFatal(ApiMessages.NULL_COMPARISON_NOT_POSSIBLE_FOR_STRUCT, "", assocName);
		}

		// List assocEnds = this.jmiHelper.getAssociationEnds(
		// this.conn.getSession( ), assoc );
		// AssociationEnd rightAssocEnd = (AssociationEnd) ( assocEnds.get(
		// rightAssocEndNumber ) );
		// Classifier rightAssocEndType = this.jmiHelper.getNonAliasType(
		// this.conn.getSession( ), rightAssocEnd );
		EClass rightAssocEndType = assoc.getEReferenceType();
		// MRI rightAssocEndTypeMri = ( (Partitionable) rightAssocEndType
		// ).get___Mri( );
		URI rightAssocEndTypeMri = EcoreUtil.getURI(rightAssocEndType);

		// disallow a nested query for Reflect::Element, because it would crash
		// the system
		if (this.checkForReflectElement(rightAssocEndType)) {
			this.reportFatal(ApiMessages.NULL_COMPARISON_FORBIDDEN_FOR_ELEMENT, null, assocName);
		}

		// now construct the internal representation for the nested query
		List<URI> nestedClassMris = new ArrayList<URI>();
		nestedClassMris.add(rightAssocEndTypeMri);
		List<String> nestedClassNames = new ArrayList<String>();
		// nestedClassNames.add( this.printTypeName( ( (ModelElementInternal)
		// rightAssocEndType ).getQualifiedName( this.conn ),
		// rightAssocEndTypeMri.getContainerName( ) ) );
		nestedClassNames.add(rightAssocEndType.getName());

		// FIXME subtypes
		if (!this.checkForReflectElement(rightAssocEndType) && rightAssocEndType instanceof EClass) {
			this.getSubTypes(rightAssocEndType, Collections.EMPTY_SET, nestedClassMris, nestedClassNames);
		}

		List<AtomicEntry> nestedFromEntries = new ArrayList<AtomicEntry>(1);
		AliasName nestedAliasName = new AliasName(AuxServices.INTERNALALIASPREFIX + new Object().hashCode());
		AtomicEntry oneAtomicEntry = new AtomicEntry(nestedAliasName, nestedClassMris, nestedClassNames, SpiFqlFromTypeCategory.CLASS,
				false, null, null, false);
		nestedFromEntries.add(oneAtomicEntry);
		LeafSelectEntry leafSelectEntry = new LeafSelectEntry(new AtomicEntryReference(oneAtomicEntry));
		List<LeafSelectEntry> nestedLeafSelectEntries = new ArrayList<LeafSelectEntry>(1);
		nestedLeafSelectEntries.add(leafSelectEntry);

		AliasName nestedQueryName = new AliasName(AuxServices.INTERNALALIASPREFIX + oneAtomicEntry.hashCode());

		return LeafQuery.construct(nestedQueryName, nestedFromEntries, null, nestedLeafSelectEntries);
	}

	/**
	 * Convert Joining Where Entries
	 */
	private List<WithEntry> convertJoinWhereEntries(List<JoinWhereEntry> joinWhereEntries) throws QueryFormatException {

		List<WithEntry> result = new ArrayList<WithEntry>();

		// first check if we have any joining where entries at all.
		if (joinWhereEntries != null) {
			// now convert them one by one
			for (JoinWhereEntry joinWhereEntry : joinWhereEntries) {
				WithEntry internalWithEntry = this.convertJoinWhereEntry(joinWhereEntry);

				// add the internalWithEntry to the result if it exists
				if (internalWithEntry != null) {
					result.add(internalWithEntry);
				}
			}
		}

		return result;
	}

	/**
	 * Convert one JoinWhereEntry
	 */
	@SuppressWarnings("null")
	private WithEntry convertJoinWhereEntry(JoinWhereEntry joinWhereEntry) throws QueryFormatException {

		// make sure a join where entry was constructed
		if (joinWhereEntry == null) {
			this.reportFatal(ApiMessages.EMPTY_QUERY_PART, "JoinWhereEntry"); //$NON-NLS-1$
		}

		WithEntry result = null;

		// obtain the left alias name
		String aliasName = joinWhereEntry.getLeftAlias();

		// check if the alias is actual defined in the from-clause at the same
		// level
		AtomicEntry atomicEntry = this.environment.get(aliasName);
		if (atomicEntry == null) {
			this.reportFatal(joinWhereEntry, ApiMessages.UNDEFINED_ALIAS_AT_PEER_LEVEL, aliasName);
		} else {

			// case analysis on the subtype
			if (joinWhereEntry instanceof WhereComparisonAttrs) {
				result = this.convertWhereComparisonAttrs(atomicEntry, (WhereComparisonAttrs) joinWhereEntry);
			} else if (joinWhereEntry instanceof WhereComparisonAliases) {
				result = this.convertWhereComparisonAliases(atomicEntry, (WhereComparisonAliases) joinWhereEntry);
			} else if (joinWhereEntry instanceof WhereRelationReference) {
				result = this.convertWhereRelation(atomicEntry, (WhereRelationReference) joinWhereEntry);
			} else if (joinWhereEntry instanceof WhereNestedReference) {
				result = this.convertWhereNestedEntry(atomicEntry, (WhereNestedReference) joinWhereEntry);
			} else {
				throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, joinWhereEntry.getClass().getCanonicalName(), "JoinWhereEntry"); //$NON-NLS-1$
			}
		}

		return result;
	}

	/**
	 * Converts a WhereComparisonAttrs into a AttrComparison
	 */
	private WithEntry convertWhereComparisonAttrs(AtomicEntry leftAtomicEntry, WhereComparisonAttrs whereComparisonAttrsEntry)
			throws QueryFormatException {

		String rightAliasName = whereComparisonAttrsEntry.getRightAlias();
		WithEntry result = null;

		// first check if the provided alias name is valid
		AtomicEntry rightAtomicEntry = this.environment.get(rightAliasName);
		if (rightAtomicEntry == null) {
			this.reportFatal(whereComparisonAttrsEntry, ApiMessages.UNDEFINED_ALIAS_AT_PEER_LEVEL, rightAliasName);
		} else {
			String leftAttrName = whereComparisonAttrsEntry.getLeftAttrName();
			String rightAttrName = whereComparisonAttrsEntry.getRightAttrName();

			// check if the provided attributes exist and are of primitive type
			AttributeResolution leftAttrRes = this.resolveAttributeForAtomicEntry(leftAtomicEntry, leftAttrName, whereComparisonAttrsEntry);
			AttributeResolution rightAttrRes = this.resolveAttributeForAtomicEntry(rightAtomicEntry, rightAttrName,
					whereComparisonAttrsEntry);

			// type check
			if (leftAttrRes.attrType != rightAttrRes.attrType) {
				this.reportError(whereComparisonAttrsEntry, ApiMessages.FEATURE_TYPE_INCOMPATIBILITY, leftAtomicEntry.getClassName(),
						leftAttrName, rightAtomicEntry.getClassName(), rightAttrName);
			}

			// create the type attr references
			TypeAttrReference leftAttrRef = new AtomicAttrReference(leftAtomicEntry, leftAttrName, leftAttrRes.attrType,
					leftAttrRes.multivalued, leftAttrRes.isOrdered, leftAttrRes.isUnique);
			TypeAttrReference rightAttrRef = new AtomicAttrReference(rightAtomicEntry, rightAttrName, rightAttrRes.attrType,
					rightAttrRes.multivalued, rightAttrRes.isOrdered, rightAttrRes.isUnique);

			// convert operation
			SpiFqlComparisonOperation newOp = this.convertOperationValue(whereComparisonAttrsEntry.getOperation(), false,
					leftAttrRes.attrType, false, whereComparisonAttrsEntry);

			result = new AttrComparison(newOp, leftAttrRef, rightAttrRef);
		}

		return result;
	}

	/**
	 * Converts a WhereComparisonAliases into a TypeComparison
	 */
	private WithEntry convertWhereComparisonAliases(AtomicEntry leftAtomicEntry, WhereComparisonAliases whereComparisonAliasesEntry)
			throws QueryFormatException {

		String rightAliasName = whereComparisonAliasesEntry.getRightAlias();
		WithEntry result = null;

		// first check if the provided alias name is valid
		AtomicEntry rightAtomicEntry = this.environment.get(rightAliasName);
		if (rightAtomicEntry == null) {
			this.reportFatal(whereComparisonAliasesEntry, ApiMessages.UNDEFINED_ALIAS_AT_PEER_LEVEL, rightAliasName);
		} else {
			// now check if these two aliases are type compatible, and thus
			// comparable
			List<URI> leftClassMRIs = leftAtomicEntry.getClassMRIs();
			List<URI> rightClassMRIs = rightAtomicEntry.getClassMRIs();
			boolean comparable = leftAtomicEntry.isReflectElement() || rightAtomicEntry.isReflectElement();

			// if any of the subtypes on either side is equal, the two from
			// entries are comparable. Note that if one from entry
			// has withoutsubtypes, type compatibility is strengthened to the
			// one provided top type.
			for (Iterator iter = leftClassMRIs.iterator(); !comparable && iter.hasNext();) {
				URI leftClassMRI = (URI) iter.next();
				for (Iterator iterator = rightClassMRIs.iterator(); !comparable && iterator.hasNext();) {
					URI rightClassMRI = (URI) iterator.next();
					comparable = leftClassMRI.equals(rightClassMRI);
				}
			}

			// if the two subclass sets do not share at least one type, no
			// instances can ever be found that fulfill the predicate, so we
			// issue a warning
			if (!comparable) {
				this.reportWarning(whereComparisonAliasesEntry, ApiMessages.COMPARE_INCOMPATIBLE_TYPES, leftAtomicEntry.getAliasName(),
						rightAtomicEntry.getAliasName());
			}

			// if both atomic entries are the same, this predicate is always
			// true and we throw it out
			if (!leftAtomicEntry.equals(rightAtomicEntry)) {
				// otherwise, construct the type comparison

				// construct alias references
				AtomicEntryReference leftAtomicEntryRef = new AtomicEntryReference(leftAtomicEntry);
				AtomicEntryReference rightAtomicEntryRef = new AtomicEntryReference(rightAtomicEntry);

				// construct result
				result = new TypeComparison(leftAtomicEntryRef, rightAtomicEntryRef);
			}
		}

		return result;
	}

	/**
	 * Converts a WhereRelation into an AssocPredicate
	 */
	@SuppressWarnings("null")
	private WithEntry convertWhereRelation(AtomicEntry leftAtomicEntry, WhereRelationReference whereRelationEntry)
			throws QueryFormatException {

		String leftAliasName = leftAtomicEntry.getAliasName().getOriginalName();
		String rightAliasName = whereRelationEntry.getRightAlias();

		// do not allow the same alias in one assoc predicate
		if (leftAliasName.equals(rightAliasName)) {
			this.reportError(whereRelationEntry, ApiMessages.ALIAS_TWICE_IN_ASSOC_PREDICATE, leftAliasName);
		}

		WithEntry result = null;

		// first check if the provided alias name is valid
		AtomicEntry rightAtomicEntry = this.environment.get(rightAliasName);
		if (rightAtomicEntry == null) {
			this.reportFatal(whereRelationEntry, ApiMessages.UNDEFINED_ALIAS_AT_PEER_LEVEL, rightAliasName);
		} else {
			// construct atomic entry references
			AtomicEntryReference leftAtomicEntryRef = new AtomicEntryReference(leftAtomicEntry);
			AtomicEntryReference rightAtomicEntryRef = new AtomicEntryReference(rightAtomicEntry);

			URI assocMRI = null;
			String assocName = ">>assoc name not assigned<<"; //$NON-NLS-1$
			// int leftAssocEnd = -1;
			// boolean leftStorage = false;
			//            String leftAssocEndName = ">>left assoc end name not assigned<<"; //$NON-NLS-1$
			// int rightAssocEnd = -1;
			// boolean rightStorage = false;
			//            String rightAssocEndName = ">>right assoc end name not assigned<<"; //$NON-NLS-1$

			// we need differentiation depending on the type of WhereRelation
			// if ( whereRelationEntry instanceof WhereRelationAssoc ) {
			// WhereRelationAssoc whereRelationAssocEntry = (WhereRelationAssoc)
			// whereRelationEntry;
			//
			// String[] qName = whereRelationAssocEntry.getAssocQName( );
			// String containerName = whereRelationAssocEntry.getContainerName(
			// );
			//
			// // first obtain the MRI of the assoc and its name
			// assocMRI = this.resolveMRIForQualifiedName( qName, containerName,
			// whereRelationAssocEntry );
			//
			// Association assoc = this.getMofAssociationForMri( assocMRI );
			// if ( assoc == null ) {
			// this.reportFatal( whereRelationAssocEntry,
			// MQLApiMessages.ASSOC_QUALIFIER_NOT_AN_ASSOC, this.printTypeName(
			// qName, containerName ) );
			// }
			// List<String> assocQName = ( (AssociationInternal) assoc
			// ).getQualifiedName( this.conn );
			// assocName = this.printTypeName( assocQName,
			// assocMRI.getContainerName( ) );
			//
			// // set the category
			// assocCategory = SpiFqlAssociationCategory.ASSOCIATION;
			//
			// // resolve the right association end
			// rightAssocEndName = whereRelationAssocEntry.getRightAssocEndName(
			// );
			// AssocEndResolution rightAssocEndResolution =
			// this.resolveAssocEnd( assoc, rightAssocEndName,
			// whereRelationAssocEntry );
			//
			// // resolve left association end
			// AssocEndResolution leftAssocEndResolution = this.resolveAssocEnd(
			// assoc, 1 - rightAssocEndResolution.assocEnd );
			//
			// // construct result parts
			// leftAssocEnd = leftAssocEndResolution.assocEnd;
			// leftStorage = leftAssocEndResolution.storage;
			// rightAssocEnd = rightAssocEndResolution.assocEnd;
			// rightStorage = rightAssocEndResolution.storage;
			//
			// // check if the association ends have the correct types
			// this.checkAssocEndTypes( assocMRI, leftAssocEnd,
			// leftAtomicEntryRef, rightAtomicEntryRef, whereRelationAssocEntry
			// );
			//
			// } else if ( whereRelationEntry instanceof WhereRelationAssocMri )
			// {
			// WhereRelationAssocMri whereRelationAssocMriEntry =
			// (WhereRelationAssocMri) whereRelationEntry;
			//
			// // the MRI of the type was provided by the user
			// assocMRI = whereRelationAssocMriEntry.getAssocMRI( );
			//
			// // resolve the user-provided data and check if they make sense
			// ReferenceResolution assocResolution = this.resolveAssociation(
			// assocMRI, 1 - whereRelationAssocMriEntry.getRightAssocEnd( ),
			// whereRelationAssocMriEntry.getRightAssocEnd( ),
			// whereRelationAssocMriEntry );
			//
			// // set the category
			// assocCategory = assocResolution.assocCategory;
			//
			// // obtain the names and ends
			// leftAssocEndName = assocResolution.leftAssocEndName;
			// leftAssocEnd = assocResolution.leftAssocEnd;
			// rightAssocEndName = assocResolution.rightAssocEndName;
			// rightAssocEnd = assocResolution.rightAssocEnd;
			// assocName = assocResolution.assocName;
			//
			// // obtain the storage information
			// leftStorage = assocResolution.leftStorage;
			// rightStorage = assocResolution.rightStorage;
			//
			// // check if the association ends have the correct types
			// this.checkAssocEndTypes( assocMRI, leftAssocEnd,
			// leftAtomicEntryRef, rightAtomicEntryRef,
			// whereRelationAssocMriEntry );
			//
			// } else
			if (whereRelationEntry instanceof WhereRelationReference) {
				String featureName = (whereRelationEntry).getFeatureName();

				// resolve the feature
				ReferenceResolution featureResolution = this.resolveFeatureBetweenAtomicEntryReferences(leftAtomicEntryRef,
						rightAtomicEntryRef, featureName, whereRelationEntry);

				// assign results
				assocMRI = featureResolution.assocMRI;
				// assocCategory = featureResolution.assocCategory;
				assocName = featureResolution.assocName;
				// leftAssocEnd = featureResolution.leftAssocEnd;
				// leftStorage = featureResolution.leftStorage;
				// leftAssocEndName = featureResolution.leftAssocEndName;
				// rightStorage = featureResolution.rightStorage;
				// rightAssocEnd = featureResolution.rightAssocEnd;
				// rightAssocEndName = featureResolution.rightAssocEndName;

			} else {
				throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, whereRelationEntry.getClass().getCanonicalName(), "WhereRelation"); //$NON-NLS-1$
			}

			// construct result
			result = new AssocPredicate(assocMRI, assocName, leftAtomicEntryRef, rightAtomicEntryRef);
		}

		return result;
	}

	/**
	 * Converts a WhereNested into a LinksPredicate
	 */
	private WithEntry convertWhereNestedEntry(AtomicEntry atomicEntry, WhereNestedReference whereNestedEntry) throws QueryFormatException {

		// construct atomicEntryReference
		AtomicEntryReference atomicEntryRef = new AtomicEntryReference(atomicEntry);

		// calculate recursively the internal query for the nested query if it
		// is actually provided
		// if this is not possible, we derive the internalNestedSelect later
		LeafQuery internalNestedSelect = null;
		if (whereNestedEntry.getNestedQuery() != null) {
			internalNestedSelect = this.convertQuery(whereNestedEntry.getNestedQuery(), true);
		}

		// fetch the negation
		boolean isNot = whereNestedEntry.isNot();

		// we need to calculate the assocMRI, the assocEnd numbers and their
		// storages
		URI assocMRI = null;
		// SpiFqlAssociationCategory assocCategory = null;
		String assocName = ">>assoc name not assigned<<"; //$NON-NLS-1$
		// int assocEnd = -1;
		// int leftAssocEnd = -1;
		// boolean stored = false;
		// boolean linkedToStored = false;
		//        String assocEndName = ">>right assoc end name not assigned<<"; //$NON-NLS-1$
		//        String leftAssocEndName = ">>left assoc end name not assigned<<"; //$NON-NLS-1$

		// we need differentiation depending on the type of WithNestedEntry
		//        if ( whereNestedEntry instanceof WhereNestedReference ) {
		//            throw new IllegalArgumentException( );
		// WhereNestedAssoc whereNestedAssocEntry = (WhereNestedAssoc)
		// whereNestedEntry;
		//
		// String[] assocQname = whereNestedAssocEntry.getAssocQName( );
		// String containerName = whereNestedAssocEntry.getContainerName( );
		//
		// // first calculate assoc MRI
		// assocMRI = this.resolveMRIForQualifiedName( assocQname,
		// containerName, whereNestedAssocEntry );
		// Association assoc = this.getMofAssociationForMri( assocMRI );
		// if ( assoc == null ) {
		// this.reportFatal( whereNestedEntry,
		// MQLApiMessages.ASSOC_QUALIFIER_NOT_AN_ASSOC, this.printTypeName(
		// assocQname, containerName ) );
		// }
		// assocName = this.printTypeName( assocQname, containerName );
		//
		// // set category
		// assocCategory = SpiFqlAssociationCategory.ASSOCIATION;
		//
		// // calculate assoc end number and name
		// assocEndName = whereNestedAssocEntry.getAssocEndName( );
		// AssocEndResolution assocEndResolution = this.resolveAssocEnd(
		// assoc, assocEndName, whereNestedAssocEntry );
		//
		// assocEnd = assocEndResolution.assocEnd;
		// stored = assocEndResolution.storage;
		//
		// // define other end
		// leftAssocEnd = ( assocEnd == 0 ? 1 : 0 );
		//
		// // define the storage for the other side
		// List assocEnds = this.jmiHelper.getAssociationEnds(
		// this.conn.getSession( ), assoc );
		// AssociationEnd actualLeftAssocEnd = (AssociationEnd) (
		// assocEnds.get( leftAssocEnd ) );
		// leftAssocEndName = actualLeftAssocEnd.getName( );
		// linkedToStored = this.jmiHelper.isEndStored(
		// this.conn.getSession( ), actualLeftAssocEnd );
		//
		// // depending on whether we have a nestedQuery or not, we either
		// check the nested query or derive it
		// if ( internalNestedSelect != null ) {
		// // check if the association ends have the correct types
		// this.checkAssocEndTypes( assocMRI, leftAssocEnd, atomicEntryRef,
		// internalNestedSelect.getSelectEntries( ).get( 0
		// ).getAtomicEntryReference( ), whereNestedAssocEntry );
		//
		// } else {
		// internalNestedSelect =
		// constructNestedQueryForAssociationReferenceNullPointerCheck(
		// assocMRI, assocName, assocEnd, assocEndName );
		// }

		//        } else if ( whereNestedEntry instanceof WhereNestedAssocMri ) {
		//            throw new IllegalArgumentException( );
		// WhereNestedAssocMri whereNestedAssocMriEntry =
		// (WhereNestedAssocMri) whereNestedEntry;
		//
		// // the MRI of the type was provided by the user
		// assocMRI = whereNestedAssocMriEntry.getAssocMRI( );
		//
		// // set the association end
		// assocEnd = whereNestedAssocMriEntry.getAssocEnd( );
		//
		// // calculate the other end
		// leftAssocEnd = ( assocEnd == 0 ? 1 : 0 );
		//
		// // check if the provided values are valid
		// ReferenceResolution assocResolution = this.resolveAssociation(
		// assocMRI, leftAssocEnd, assocEnd, whereNestedAssocMriEntry );
		//
		// // set category
		// assocCategory = assocResolution.assocCategory;
		//
		// // assign names
		// assocName = assocResolution.assocName;
		// assocEndName = assocResolution.rightAssocEndName;
		// leftAssocEndName = assocResolution.leftAssocEndName;
		//
		// // assign storage information
		// linkedToStored = assocResolution.leftStorage;
		// stored = assocResolution.rightStorage;
		//
		// // depending on whether we have a nestedQuery or not, we either
		// check the nested query or derive it
		// if ( internalNestedSelect != null ) {
		// // check if the association ends have the correct types
		// this.checkAssocEndTypes( assocMRI, leftAssocEnd, atomicEntryRef,
		// internalNestedSelect.getSelectEntries( ).get( 0
		// ).getAtomicEntryReference( ), whereNestedAssocMriEntry );
		// } else {
		// internalNestedSelect =
		// constructNestedQueryForAssociationReferenceNullPointerCheck(
		// assocMRI, assocName, assocEnd, assocEndName );
		// }
		//
		//        } else 
		if (whereNestedEntry instanceof WhereNestedReference) {
			String featureName = (whereNestedEntry).getFeatureName();

			// WhereNestedFeatures without nested select is not possible. The
			// parser will not create it without a nested select,
			// so only a user can create such a WhereNestedFeature
			if (internalNestedSelect == null) {
				throw new BugException(BugMessages.UNEXPECTED_WHERE_NESTED_FEATURE);
			}

			// resolve the feature
			ReferenceResolution featureResolution = this.resolveFeatureBetweenAtomicEntryReferences(atomicEntryRef, internalNestedSelect
					.getSelectEntries().get(0).getAtomicEntryReference(), featureName, whereNestedEntry);

			// assign results
			assocMRI = featureResolution.assocMRI;
			// assocCategory = featureResolution.assocCategory;
			assocName = featureResolution.assocName;
			// assocEnd = featureResolution.rightAssocEnd;
			// leftAssocEnd = featureResolution.leftAssocEnd;
			// assocEndName = featureResolution.rightAssocEndName;
			// leftAssocEndName = featureResolution.leftAssocEndName;
			// linkedToStored = featureResolution.leftStorage;
			// stored = featureResolution.rightStorage;

		} else {
			throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, whereNestedEntry.getClass().getCanonicalName(), "WhereNestedEntry"); //$NON-NLS-1$
		}

		// construct result
		return new LinksPredicate(isNot, assocMRI, assocName, atomicEntryRef, internalNestedSelect);
	}

	/**
	 * Converts an MQL Operation into the internal Operation. Behaves slightly
	 * different depending on whether the likeOperation is permitted. Checks if
	 * the operation is valid for the provided type and throws a format
	 * exception if not. If like is permitted and provided, null is returned.
	 */
	private SpiFqlComparisonOperation convertOperationValue(Operation operation, boolean not, SpiFqlPrimitiveType attrType,
			boolean likeOperationAllowed, QueryElement element) throws QueryFormatException {

		SpiFqlComparisonOperation result = null;

		// first check if the operation is as expected
		boolean ok = false;
		switch (attrType) {
		case BOOLEAN:
			// we only allow the equality operation for boolean attributes
			ok = operation.equals(Operation.EQUAL); // || operation.equals(
			// Operation.NOTEQUAL );
			break;
		case STRING:
			// we only allow equality and liking for string attributes (provided
			// the caller permits like-operations)
			ok = (operation.equals(Operation.EQUAL) || operation.equals(Operation.NOTEQUAL) || (operation.equals(Operation.LIKE) && likeOperationAllowed));
			break;
		default:
			// all other types do not allow liking under any circumstances
			ok = !operation.equals(Operation.LIKE);
		}

		if (!ok) {
			this.reportError(element, ApiMessages.INVALID_OPERATION, operation, attrType);
		} else {
			// if ok, we convert the operation and integrate a negation if
			// necessary
			switch (operation) {
			case NOTEQUAL:
				result = (not ? SpiFqlComparisonOperation.EQUAL : SpiFqlComparisonOperation.NOT_EQUAL);
				break;
			case EQUAL:
				result = (not ? SpiFqlComparisonOperation.NOT_EQUAL : SpiFqlComparisonOperation.EQUAL);
				break;
			case GREATER:
				result = (not ? SpiFqlComparisonOperation.LESS_OR_EQUAL : SpiFqlComparisonOperation.GREATER);
				break;
			case GREATEREQUAL:
				result = (not ? SpiFqlComparisonOperation.LESS : SpiFqlComparisonOperation.GREATER_OR_EQUAL);
				break;
			case SMALLER:
				result = (not ? SpiFqlComparisonOperation.GREATER_OR_EQUAL : SpiFqlComparisonOperation.LESS);
				break;
			case SMALLEREQUAL:
				result = (not ? SpiFqlComparisonOperation.GREATER : SpiFqlComparisonOperation.LESS_OR_EQUAL);
				break;
			case LIKE:
				break;
			default:
				throw new BugException(BugMessages.UNKNOWN_OPERATOR, operation);
			}
		}

		return result;
	}

	/* ---------------------------------------- */
	/* Utility functions for the type checker */
	/* ---------------------------------------- */

	/**
	 * Prints the qualified name as one useable string
	 */
	private String printTypeName(List<String> qName, String containerName) {

		String resultString = (containerName == null ? AuxServices.EMPTYSTR : containerName + AuxServices.SHARP_T);
		for (Iterator<String> iter = qName.iterator(); iter.hasNext();) {
			resultString = resultString + iter.next();
			if (iter.hasNext()) {
				resultString = resultString + AuxServices.COLONCOLON_T;
			}
		}
		return resultString;
	}

	/**
	 * Prints the qualified name as one useable string
	 */
	private String printTypeName(String[] qName, String containerName) {

		return this.printTypeName(Arrays.asList(qName), containerName);
	}

	/**
	 * Returns true if the string has at least one trailing blank
	 */
	private boolean hasTrailingBlank(String str) {

		boolean hasBlank = false;
		if (str != null) {
			int length = str.length();

			if (length > 0) {
				hasBlank = str.substring(length - 1, length).equals(" "); //$NON-NLS-1$
			}
		}
		return hasBlank;
	}

	/**
	 * Returns the classifier for an MRI of a MOF Classifier
	 */
	// private Classifier getClassifierForMri( MRI mri ) {
	//
	// throw new IllegalArgumentException( );
	// Classifier classifier = null;
	// RefBaseObject modelElement = this.conn.getElement( mri );
	// if ( modelElement instanceof Classifier ) {
	// classifier = (Classifier) modelElement;
	// } else {
	// throw new MQLBugException( MQLBugMessages.MRI_IS_NOT_MOF_CLASS );
	// }
	// return classifier;
	// }
	/**
	 * Returns the MOF association for an MRI of a MOF association. Returns null
	 * if the mri is not an association!
	 */
	// private Association getMofAssociationForMri( MRI mri ) {
	//
	// throw new IllegalArgumentException( );
	// // Association mofAssociation = null;
	// // RefBaseObject modelElement = this.conn.getElement( mri );
	// // if ( modelElement instanceof Association ) {
	// // mofAssociation = (Association) modelElement;
	// // }
	// // return mofAssociation;
	// }
	/**
	 * Return true if the mri (denoting a type) is actually referring to
	 * Reflect::Element from MOIN's MOF
	 */
	private boolean checkForReflectElement(EObject modelElement) {

		return EcorePackage.Literals.EOBJECT.equals(modelElement);
	}

	/**
	 * This method resolves the MRI of the MOF ModelElement, which is identified
	 * by the provided qualified name, possibly restricted to the provided
	 * container.
	 */
	// @SuppressWarnings( "null" )
	// private MRI resolveMRIForQualifiedName( String[] qName, String
	// containerName, MQLElement element ) throws MQLFormatException {
	//
	// throw new IllegalArgumentException( );
	//
	// // for the result
	// ModelElement modelElement = null;
	//
	// // first check if we have usable qualified name
	// if ( ( qName == null ) || ( qName.length == 0 ) ) {
	// this.reportFatal( MQLApiMessages.EMPTY_QUALIFIED_NAMES );
	// } else if ( qName.length == 1 ) {
	// this.reportFatal( element, MQLApiMessages.INVALID_QUALIFIED_NAME,
	// qName[0] );
	// } else {
	//
	// // if the qualified name makes sense, we obtain the extent manager
	// ExtentManager extentManager = this.conn.getSession( ).getWorkspaceSet(
	// ).getMoin( ).getExtentManager( );
	//
	// // obtain all model elements valid for the provided qualified name
	// ModelElement[] modelElements;
	// if ( containerName == null ) {
	// modelElements = extentManager.selectModelElements( this.conn.getSession(
	// ), qName );
	// } else {
	// // with a qualifying container name
	// modelElements = extentManager.selectModelElements( this.conn.getSession(
	// ), qName, new String[] { containerName } );
	// }
	//
	// // examine the possible resolutions
	// int numberOfResolutions = modelElements.length;
	// if ( numberOfResolutions == 1 ) {
	// // found the answer
	// modelElement = modelElements[0];
	// } else if ( numberOfResolutions < 1 ) {
	// // no resolutions found at all
	// String qualifiedName = this.printTypeName( qName, containerName );
	// this.reportFatal( element, MQLApiMessages.UNRESOLVABLE_QUALIFIED_NAME,
	// qualifiedName );
	// } else {
	// // multiple resolutions found
	// String qualifiedName = this.printTypeName( qName, containerName );
	// this.reportError( element, MQLApiMessages.AMBIGUOUS_QUALIFIED_NAME,
	// qualifiedName );
	// modelElement = modelElements[0];
	// }
	// }
	//
	// // get the MRI
	// return ( (Partitionable) modelElement ).get___Mri( );
	// }
	/**
	 * This is the result of a checkAttributeForAtomicEntry. It has multivalued
	 * true if the attribute has multiplicity > 1. The javaType contains the
	 * primitive java type of the attribute (which has to be either of primtive
	 * type or enumeration type)
	 */
	public static final class AttributeResolution {

		public boolean multivalued;

		public boolean isOrdered;

		public boolean isUnique;

		// if the attribute type is not simple, then attrType == null
		public SpiFqlPrimitiveType attrType;
	}

	/**
	 * Resolves an attribute for the atomic entry. It is expected that 1) for a
	 * MofClass, we have primitive attribute or an enumeration type or 2) for a
	 * StructureType we have a primitive structure field or an enumeration type.
	 * The method throws a format exception otherwise.
	 */
	private AttributeResolution resolveAttributeForAtomicEntry(AtomicEntry atomicEntry, String attrName, QueryElement element)
			throws QueryFormatException {

		// obtain the classifier of the atomic entry.
		URI classifierMri = atomicEntry.getClassMRI();
		EClass classifier = this.emfHelper.getTypeElement(classifierMri);

		// keep track if we have a multivalued attribute
		boolean isMultivalued = false;
		boolean isUnique = false;
		boolean isOrdered = false;

		// we look for the type of the attribute
		EDataType attrMofType = null;

		// we have only two possible classifiers
		if (classifier instanceof EClass) {
			// we have mofClass
			EClass mofClass = classifier;

			// obtain the attribute
			EStructuralFeature attr = this.emfHelper.getFeatureByName(mofClass, attrName);
			if (attr instanceof EAttribute) {

				// if it does not exist, throw a format exception
				if (attr == null) {
					throw new IllegalArgumentException();
					// String className = this.printTypeName( (
					// (MofClassInternal) mofClass ).getQualifiedName( this.conn
					// ), classifierMri.getContainerName( ) );
					// this.reportFatal( element,
					// MQLApiMessages.UNDEFINED_ATTRIBUTE, attrName, className
					// );
				} else {
					// if it does exist, obtain the attribute.
					attrMofType = ((EAttribute) attr).getEAttributeType();

					// check if the multiplicity > 1
					isMultivalued = attr.isMany();

					// ordered and uniqueness properties
					if (isMultivalued) {
						isOrdered = attr.isOrdered();
						isUnique = attr.isUnique();
					}

					// do not permit derived attributes
					if (attr.isDerived()) {
						this.reportFatal(element, ApiMessages.DERIVE_ATTRIBUTES_NOT_ALLOWED, attrName);
					}
				}
			} else {
				// this.reportFatal( element,
				// MQLApiMessages.DERIVE_ATTRIBUTES_NOT_ALLOWED, attrName );
				this.reportFatal(element, ApiMessages.UNDEFINED_ATTRIBUTE, attrName, classifierMri);
			}

			// } else if ( classifier instanceof StructureType ) {
			// // we have a structure type
			// StructureType structType = (StructureType) classifier;
			//
			// // obtain the structure field
			// StructureField field = this.jmiHelper.getStructureFieldByName(
			// this.conn, structType, attrName, true );
			//
			// // if it does not exist, throw a format exception
			// if ( field == null ) {
			// String className = this.printTypeName( ( (StructureTypeInternal)
			// structType ).getQualifiedName( this.conn ),
			// classifierMri.getContainerName( ) );
			// this.reportFatal( element, MQLApiMessages.UNDEFINED_ATTRIBUTE,
			// new Object[] { attrName, className } );
			// } else {
			// // if it does exist, obtain the field type
			// attrMofType = this.jmiHelper.getNonAliasType(
			// this.conn.getSession( ), field );
			// }

		} else {
			throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, classifier.getClass().getCanonicalName(), "Classifier"); //$NON-NLS-1$

		}

		// we now verify if the attribute type is valid, i.e. primitive or
		// enumeration
		SpiFqlPrimitiveType attrType = null;
		if (attrMofType instanceof EEnum) {
			// enumeration labels are handled as strings
			attrType = SpiFqlPrimitiveType.STRING;
		} else if (attrMofType instanceof EDataType) {
			String primName = attrMofType.getName();
			Class<?> instanceClass = attrMofType.getInstanceClass();
			if (primName.equals("EBoolean") || instanceClass == boolean.class || instanceClass == Boolean.class) { //$NON-NLS-1$
				attrType = SpiFqlPrimitiveType.BOOLEAN;
			} else if (primName.equals("EInt") || instanceClass == int.class || instanceClass == Integer.class) { //$NON-NLS-1$
				attrType = SpiFqlPrimitiveType.INTEGER;
			} else if (primName.equals("ELong") || instanceClass == long.class || instanceClass == Integer.class) { //$NON-NLS-1$
				attrType = SpiFqlPrimitiveType.LONG;
			} else if (primName.equals("EFloat") || instanceClass == float.class || instanceClass == Float.class) { //$NON-NLS-1$
				attrType = SpiFqlPrimitiveType.FLOAT;
			} else if (primName.equals("EDouble") || instanceClass == double.class || instanceClass == Double.class) { //$NON-NLS-1$
				attrType = SpiFqlPrimitiveType.DOUBLE;
			} else if (primName.equals("EString") || instanceClass == String.class) { //$NON-NLS-1$
				attrType = SpiFqlPrimitiveType.STRING;
			} else {
				throw new BugException(BugMessages.UNKNOWN_PRIMITIVE_TYPE, primName);
			}
		} else {
			this.reportFatal(element, ApiMessages.PRIMITIVE_OR_ENUM_EXPECTED, attrName);
		}

		// construct the result
		AttributeResolution result = new AttributeResolution();
		result.multivalued = isMultivalued;
		result.isOrdered = isOrdered;
		result.isUnique = isUnique;
		result.attrType = attrType;

		return result;
	}

	/**
	 * Checks if the association ends for the association are type correct with
	 * the given AtomicEntryReferences
	 */
	// @SuppressWarnings( "null" )
	// private void checkAssocEndTypes( MRI assocMRI, int leftAssocEnd,
	// AtomicEntryReference leftAtomicEntryRef, AtomicEntryReference
	// rightAtomicEntryRef, MQLElement element ) throws MQLFormatException {
	//
	// // fetch the association ends
	// Association assoc = this.getMofAssociationForMri( assocMRI );
	// if ( assoc == null ) {
	// this.reportFatal( element, MQLApiMessages.ASSOC_QUALIFIER_NOT_AN_ASSOC,
	// assocMRI );
	// }
	// List assocEnds = this.jmiHelper.getAssociationEnds( this.conn.getSession(
	// ), assoc );
	//
	// AssociationEnd assocEnd1 = (AssociationEnd) ( assocEnds.get( 0 ) );
	// AssociationEnd assocEnd2 = (AssociationEnd) ( assocEnds.get( 1 ) );
	//
	// // put the association ends in the correct order with respect to leftand
	// right
	// AssociationEnd assocEndLeft = null;
	// AssociationEnd assocEndRight = null;
	// if ( this.jmiHelper.getAssociationEndNumber( this.conn.getSession( ),
	// assocEnd1 ) == leftAssocEnd ) {
	// assocEndLeft = assocEnd1;
	// assocEndRight = assocEnd2;
	// } else {
	// assocEndLeft = assocEnd2;
	// assocEndRight = assocEnd1;
	// }
	//
	// // fetch all subtypes of the association end types
	// Classifier assocEndLeftType = this.jmiHelper.getNonAliasType(
	// this.conn.getSession( ), assocEndLeft );
	// Collection<GeneralizableElement> leftSubTypesAssocEnd =
	// this.jmiHelper.getAllSubtypes( this.conn, assocEndLeftType );
	// leftSubTypesAssocEnd.add( assocEndLeftType );
	//
	// Classifier assocEndRightType = this.jmiHelper.getNonAliasType(
	// this.conn.getSession( ), assocEndRight );
	// Collection<GeneralizableElement> rightSubTypesAssocEnd =
	// this.jmiHelper.getAllSubtypes( this.conn, assocEndRightType );
	// rightSubTypesAssocEnd.add( assocEndRightType );
	//
	// // fetch the mof classes for the alias references
	// Classifier leftClassifier = this.getClassifierForMri(
	// leftAtomicEntryRef.getAtomicEntry( ).getClassMRI( ) );
	// Classifier rightClassifier = this.getClassifierForMri(
	// rightAtomicEntryRef.getAtomicEntry( ).getClassMRI( ) );
	//
	// // compare the types on the left side
	// boolean containedInSubTypes = this.checkForReflectElement(
	// assocEndLeftType );
	// for ( Iterator<GeneralizableElement> iter =
	// leftSubTypesAssocEnd.iterator( ); !containedInSubTypes && iter.hasNext(
	// ); ) {
	// containedInSubTypes = iter.next( ).equals( leftClassifier );
	// }
	//
	// if ( !containedInSubTypes ) {
	// this.reportError( element, MQLApiMessages.ASSOCIATION_END_TYPE_MISMATCH,
	// assocEndLeft.getName( ), assoc.getName( ), assocEndLeftType.getName( ),
	// leftClassifier.getName( ) );
	// }
	//
	// // compare the types on the right side
	// containedInSubTypes = this.checkForReflectElement( assocEndRightType );
	// for ( Iterator<GeneralizableElement> iter =
	// rightSubTypesAssocEnd.iterator( ); !containedInSubTypes && iter.hasNext(
	// ); ) {
	// containedInSubTypes = iter.next( ).equals( rightClassifier );
	// }
	//
	// if ( !containedInSubTypes ) {
	// this.reportError( element, MQLApiMessages.ASSOCIATION_END_TYPE_MISMATCH,
	// assocEndRight.getName( ), assoc.getName( ), assocEndRightType.getName( ),
	// rightClassifier.getName( ) );
	// }
	// }
	/**
	 * Record for the result of a resolution of an association end
	 */
	public static final class AssocEndResolution {

		public int assocEnd;

		public boolean storage;
	}

	/**
	 * Resolves an association end based on end name and association object.
	 * Throws an exception if the end name does not exist for the association
	 */
	// private AssocEndResolution resolveAssocEnd( Association assoc, String
	// assocEndName, MQLElement element ) throws MQLFormatException {
	// throw new IllegalArgumentException( );
	// // now fetch the association ends
	// List assocEnds = this.jmiHelper.getAssociationEnds( this.conn.getSession(
	// ), assoc );
	// AssociationEnd assocEnd1 = (AssociationEnd) ( assocEnds.get( 0 ) );
	// AssociationEnd assocEnd2 = (AssociationEnd) ( assocEnds.get( 1 ) );
	//
	// // figure out the association end of interest
	// int assocEnd = -1;
	// boolean storage = false;
	// if ( assocEndName.equals( assocEnd1.getName( ) ) ) {
	// assocEnd = this.jmiHelper.getAssociationEndNumber( this.conn.getSession(
	// ), assocEnd1 );
	// storage = this.jmiHelper.isEndStored( this.conn.getSession( ), assocEnd1
	// );
	// } else if ( assocEndName.equals( assocEnd2.getName( ) ) ) {
	// assocEnd = this.jmiHelper.getAssociationEndNumber( this.conn.getSession(
	// ), assocEnd2 );
	// storage = this.jmiHelper.isEndStored( this.conn.getSession( ), assocEnd2
	// );
	// } else {
	// this.reportFatal( element, MQLApiMessages.UNDEFINED_ASSOCIATION_END,
	// assoc.getName( ), assocEndName );
	// }
	//
	// // construct result
	// AssocEndResolution result = new AssocEndResolution( );
	// result.assocEnd = assocEnd;
	// result.storage = storage;
	//
	// return result;
	// }
	// /**
	// * Resolves an association end based on end number and association object.
	// */
	// private AssocEndResolution resolveAssocEnd( Association assoc, int
	// assocEnd ) throws MQLFormatException {
	//
	// // now fetch the association ends
	// List assocEnds = this.jmiHelper.getAssociationEnds( this.conn.getSession(
	// ), assoc );
	// AssociationEnd actualAssocEnd = (AssociationEnd) ( assocEnds.get(
	// assocEnd ) );
	// boolean storage = this.jmiHelper.isEndStored( this.conn.getSession( ),
	// actualAssocEnd );
	//
	// // construct result
	// AssocEndResolution result = new AssocEndResolution( );
	// result.assocEnd = assocEnd;
	// result.storage = storage;
	//
	// return result;
	// }
	/**
	 * Record for the result of a resolution of an Association
	 */
	public static final class ReferenceResolution {

		public URI assocMRI;

		// public SpiFqlAssociationCategory assocCategory;

		// public int leftAssocEnd;

		// public boolean leftStorage;

		// public int rightAssocEnd;

		// public boolean rightStorage;

		public String assocName;

		// public String leftAssocEndName;

		// public String rightAssocEndName;
	}

	/**
	 * Resolves an association based on user-provided MRIs and assoc ends
	 */
	// private ReferenceResolution resolveAssociation( MRI assocMRI, int
	// leftAssocEnd, int rightAssocEnd, MQLElement element ) throws
	// MQLFormatException {
	// throw new IllegalArgumentException( );
	// // check if the mri is really an instance of Association
	// RefBaseObject modelElement = this.conn.getElement( assocMRI );
	//
	// if ( !( modelElement instanceof Association ) ) {
	// this.reportFatal( element, MQLApiMessages.ASSOCIATION_EXPECTED, assocMRI
	// );
	// }
	//
	// // check if the association ends are actually correct association ends
	// if ( leftAssocEnd == 0 ) {
	// if ( rightAssocEnd != 1 ) {
	//                this.reportFatal( element, MQLApiMessages.ILLEGAL_ASSOCIATION_END, "right", 1, rightAssocEnd ); //$NON-NLS-1$
	// }
	// } else if ( leftAssocEnd == 1 ) {
	// if ( rightAssocEnd != 0 ) {
	//                this.reportFatal( element, MQLApiMessages.ILLEGAL_ASSOCIATION_END, "right", 0, rightAssocEnd ); //$NON-NLS-1$
	// }
	// } else if ( rightAssocEnd == 0 ) {
	//            this.reportFatal( element, MQLApiMessages.ILLEGAL_ASSOCIATION_END, "left", 1, leftAssocEnd ); //$NON-NLS-1$
	// } else if ( rightAssocEnd == 1 ) {
	//            this.reportFatal( element, MQLApiMessages.ILLEGAL_ASSOCIATION_END, "left", 0, leftAssocEnd ); //$NON-NLS-1$
	// } else {
	// this.reportFatal( element, MQLApiMessages.ILLEGAL_ASSOCIATION_ENDS,
	// leftAssocEnd, rightAssocEnd );
	// }
	//
	// // build result
	// ReferenceResolution result = new ReferenceResolution( );
	//
	// result.assocMRI = assocMRI;
	// result.assocCategory = SpiFqlAssociationCategory.ASSOCIATION;
	// result.leftAssocEnd = leftAssocEnd;
	// result.rightAssocEnd = rightAssocEnd;
	//
	// // the qualified name of the association
	// List<String> classifierQName = ( (ClassifierInternal)
	// getClassifierForMri( assocMRI ) ).getQualifiedName( this.conn );
	// String[] assocQName = classifierQName.toArray( new
	// String[classifierQName.size( )] );
	//
	// String containerName = assocMRI.getContainerName( );
	// result.assocName = this.printTypeName( assocQName, containerName );
	//
	// // construct the result
	// Association assoc = (Association) modelElement;
	// List assocEnds = this.jmiHelper.getAssociationEnds( this.conn.getSession(
	// ), assoc );
	// AssociationEnd leftAssocEndEl = (AssociationEnd) ( assocEnds.get(
	// leftAssocEnd ) );
	// AssociationEnd rightAssocEndEl = (AssociationEnd) ( assocEnds.get(
	// rightAssocEnd ) );
	// result.leftAssocEndName = leftAssocEndEl.getName( );
	// result.leftStorage = this.jmiHelper.isEndStored( this.conn.getSession( ),
	// leftAssocEndEl );
	// result.rightAssocEndName = rightAssocEndEl.getName( );
	// result.rightStorage = this.jmiHelper.isEndStored( this.conn.getSession(
	// ), rightAssocEndEl );
	//
	// return result;
	// }
	/**
	 * Calculates for the feature of the left atomic entry reference how it is
	 * to be encoded as association to the right atomic entry reference. It
	 * deals with class-valued attributes as well as references.
	 */
	@SuppressWarnings("null")
	private ReferenceResolution resolveFeatureBetweenAtomicEntryReferences(AtomicEntryReference leftAtomicEntryRef,
			AtomicEntryReference rightAtomicEntryRef, String featureName, QueryElement element) throws QueryFormatException {

		URI assocMRI = null;
		// SpiFqlAssociationCategory assocCategory = null;
		String assocName = ">>assoc name not assigned<<"; //$NON-NLS-1$

		// fetch the mof classes or structure types for the alias references
		EClass leftClassifier = this.emfHelper.getTypeElement(leftAtomicEntryRef.getAtomicEntry().getClassMRI());
		EClass rightClassifier = this.emfHelper.getTypeElement(rightAtomicEntryRef.getAtomicEntry().getClassMRI());

		// we have three possible resolutions of the feature
		Object leftAttributeOrStructureField = null;
		EReference leftRef = null;
		// Set<AssociationEnd> rightMofAssocEnds = null;

		// case distinction on the type of the classifier. This prepares the
		// results for the resolution
		if (leftClassifier instanceof EClass) {
			// we are dealing with a MofClass
			EClass leftClass = leftClassifier;

			EStructuralFeature feature = this.emfHelper.getFeatureByName(leftClass, featureName);
			// obtain the attribute of the left-hand side mof class if it exists

			if (feature instanceof EReference)
				leftRef = (EReference) feature;

			// obtain the reference of the left-hand side mof class if it exists
			// leftRef = this.jmiHelper.getReferenceByName( this.conn,
			// leftClass, featureName, true );

			// obtain the association end(s) opposite of the left-hand side mof
			// class if they exist
			// rightMofAssocEnds = this.jmiHelper.getAssociationEnds(
			// this.conn.getSession( ), rightClassifier, true );
			// we need the association ends of the left-hand side as well
			// Set<AssociationEnd> leftMofAssocEnds =
			// this.jmiHelper.getAssociationEnds( this.conn.getSession( ),
			// leftClassifier, true );

			// filter for those with the right name where the other association
			// end points back to the left-hand side
			// for ( Iterator rightMofAssocEndsIterator =
			// rightMofAssocEnds.iterator( ); rightMofAssocEndsIterator.hasNext(
			// ); ) {
			// AssociationEndInternal rightMofAssocEnd =
			// (AssociationEndInternal) rightMofAssocEndsIterator.next( );
			//
			// if ( rightMofAssocEnd.getName( ).equals( featureName ) ) {
			// // we have a feature name match with the assoc end
			//
			// Association mofAssoc = (Association) (
			// rightMofAssocEnd.getContainer( this.conn ) );
			// List<AssociationEnd> mofAssocEnds =
			// this.jmiHelper.getAssociationEnds( this.conn.getSession( ),
			// mofAssoc );
			// AssociationEnd leftMofAssocEnd = null;
			// if ( mofAssocEnds.get( 0 ).equals( rightMofAssocEnd ) ) {
			// leftMofAssocEnd = mofAssocEnds.get( 1 );
			// } else {
			// leftMofAssocEnd = mofAssocEnds.get( 0 );
			// }
			//
			// // remove the right assoc end if the left-hand side
			// // element's association ends do not contain the found
			// leftMofAssocEnd
			// if ( !( leftMofAssocEnds.contains( leftMofAssocEnd ) ) ) {
			// rightMofAssocEndsIterator.remove( );
			// }
			//
			// // otherwise, we can keep the element
			// } else {
			// // no name match, so remove
			// rightMofAssocEndsIterator.remove( );
			// }
			// }

			// } else if ( leftClassifier instanceof StructureType ) {
			// // we are dealing with a Structure Type
			// leftAttributeOrStructureField =
			// this.jmiHelper.getStructureFieldByName( this.conn,
			// (StructureType) leftClassifier, featureName, true );
		} else {
			throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, leftClassifier.getClass().getCanonicalName(), "MofClass"); //$NON-NLS-1$
		}

		// now, do a case study on the found results
		if (leftAttributeOrStructureField != null) {
			throw new IllegalArgumentException();
			// // we have an attribute or a field, so we have to check if it is
			// class-level
			// Classifier leftType = this.jmiHelper.getNonAliasType(
			// this.conn.getSession( ), leftAttributeOrStructureField );
			//
			// // only mof classes or structure types are allowed
			// if ( !( leftType instanceof MofClass || leftType instanceof
			// StructureType ) ) {
			// this.reportError( element,
			// MQLApiMessages.FEATURE_TO_CLASS_OR_STRUCTTYPE, featureName );
			// }
			//
			// // these are the default assignments for class-valued attributes
			// leftAssocEnd = 0;
			// leftStorage = true;
			// rightAssocEnd = 1;
			// rightStorage = false;
			// assocMRI = ( (Partitionable) leftAttributeOrStructureField
			// ).get___Mri( );
			//
			// // set the category
			// assocCategory = SpiFqlAssociationCategory.ATTRIBUTE;
			//
			// // assign the correct names for the association data
			// List<String> leftQName = ( (ModelElementInternal)
			// leftAttributeOrStructureField ).getQualifiedName( this.conn );
			// assocName = this.printTypeName( leftQName,
			// assocMRI.getContainerName( ) );
			//
			// // for the assoc end name itself, the non-qualified version of
			// the attribute name is sufficient
			// leftAssocEndName = leftAttributeOrStructureField.getName( );
			// // for the other side of the association end name, we use the
			// non-qualified name of the class
			// rightAssocEndName = rightClassifier.getName( );
			//
		} else {
			// AssociationEnd assocEndLeft = null;
			// AssociationEnd assocEndRight = null;
			// Association assoc = null;

			// if we have a valid reference, we can set the association
			if (leftRef != null) {
				// assocEndLeft = ( (ReferenceInternal) leftRef ).getExposedEnd(
				// this.conn );
				// assocEndRight = ( (ReferenceInternal) leftRef
				// ).getReferencedEnd( this.conn );
				// assoc = (Association) ( (AssociationEndInternal) assocEndLeft
				// ).getContainer( this.conn );
				// } else if ( rightMofAssocEnds != null &&
				// rightMofAssocEnds.size( ) == 1 ) {
				// // if we have an unambigious assoc end, we are good as well
				// assocEndRight = rightMofAssocEnds.iterator( ).next( );
				// assoc = (Association) ( (AssociationEndInternal)
				// assocEndRight ).getContainer( this.conn );
				//
				// List<AssociationEnd> mofAssocEnds =
				// this.jmiHelper.getAssociationEnds( this.conn.getSession( ),
				// assoc );
				// if ( mofAssocEnds.get( 0 ).equals( assocEndRight ) ) {
				// assocEndLeft = mofAssocEnds.get( 1 );
				// } else {
				// assocEndLeft = mofAssocEnds.get( 0 );
				// }
			} else {
				// we have a problem - there are 2 possibilities
				// if ( rightMofAssocEnds != null && rightMofAssocEnds.size( ) >
				// 1 ) {
				// // we have an ambiguity
				// this.reportFatal( element,
				// MQLApiMessages.AMBIGUOUS_ASSOC_END_NAME, featureName,
				// rightClassifier.getName( ) );
				// } else {
				// otherwise simply an invalid feature
				this.reportFatal(element, ApiMessages.INVALID_FEATURE_NAME, featureName, leftClassifier.getName());
				// }
			}

			// assign the values to the internal representation
			// leftAssocEnd = this.jmiHelper.getAssociationEndNumber(
			// this.conn.getSession( ), assocEndLeft );
			// leftStorage = this.jmiHelper.isEndStored( this.conn.getSession(
			// ), assocEndLeft );
			// rightAssocEnd = 1 - leftAssocEnd;
			// rightStorage = this.jmiHelper.isEndStored( this.conn.getSession(
			// ), assocEndRight );

			// assocMRI = ( (Partitionable) assoc ).get___Mri( );
			assocMRI = EcoreUtil.getURI(leftRef);

			// set the category
			// assocCategory = SpiFqlAssociationCategory.ASSOCIATION;

			// check if the association ends have the correct types
			// this.checkAssocEndTypes( assocMRI, leftAssocEnd,
			// leftAtomicEntryRef, rightAtomicEntryRef, element );

			// assign the correct names for the association data
			// List<String> assocQName = ( (AssociationInternal) assoc
			// ).getQualifiedName( this.conn );
			// assocName = this.printTypeName( assocQName,
			// assocMRI.getContainerName( ) );
			assocName = leftRef.getName();
			// we reuse the attribute name, but for the assoc end, the
			// non-qualified version is sufficient
			// leftAssocEndName = assocEndLeft.getName( );
			// rightAssocEndName = assocEndRight.getName( );
		}

		// construct result
		ReferenceResolution result = new ReferenceResolution();
		result.assocMRI = assocMRI;
		// result.assocCategory = assocCategory;
		result.assocName = assocName;
		// result.leftAssocEnd = leftAssocEnd;
		// result.leftStorage = leftStorage;
		// result.leftAssocEndName = leftAssocEndName;
		// result.rightAssocEnd = rightAssocEnd;
		// result.rightStorage = rightStorage;
		// result.rightAssocEndName = rightAssocEndName;

		return result;
	}

	/**
	 * Calculates for the feature of the provided atomic entry how it is to be
	 * encoded as an association. This only needs to include the reference and
	 * attribute scenarios. Association ends by themselves had to be qualified
	 * because the other side is not known. If the featureName is not a complex
	 * attribute or assoc reference, then null is returned.
	 */
	private ReferenceResolution resolveFeatureForAttomicEntry(AtomicEntry atomicEntry, String featureName) throws QueryFormatException {

		// for the result
		ReferenceResolution result = null;

		// fetch the Classifier element for the atomic entry
		EClass leftClassifier = this.emfHelper.getTypeElement(atomicEntry.getClassMRI());

		// we have two possible resolutions of the feature
		EReference leftReference = null;

		// case distinction on the type of the classifier. This prepares the
		// results for the resolution
		if (leftClassifier instanceof EClass) {
			// we are dealing with a MofClass
			EClass leftClass = leftClassifier;

			EStructuralFeature featureByName = this.emfHelper.getFeatureByName(leftClass, featureName);

			if (featureByName instanceof EReference) {
				// obtain the reference of the left-hand side mof class if it
				// exists
				leftReference = (EReference) featureByName;
			} else if (featureByName instanceof EAttribute) {
				return null;
			} else {
				throw new IllegalArgumentException();
			}

			// } else if ( leftClassifier instanceof StructureType ) {
			// // we are dealing with a Structure Type, so obtain the field if
			// it exists
			// leftAttributeOrField = this.jmiHelper.getStructureFieldByName(
			// this.conn, (StructureType) leftClassifier, featureName, true );
		} else {
			throw new BugException(BugMessages.UNEXPECTED_SUBTYPE, leftClassifier.getClass().getCanonicalName(), "Classifier"); //$NON-NLS-1$
		}

		// now, do a case study on the found results
		// if ( leftAttributeOrField != null ) {
		// // we have an attribute or a field, so we have to check if it is
		// class-level
		// EClassifier typeOfAttributeOrField = this.
		// Classifier typeOfAttributeOrField = this.jmiHelper.getNonAliasType(
		// this.conn.getSession( ), leftAttributeOrField );
		//
		// // only mof classes and structure types are considered here (all
		// other scenarios should lead to a null AssocResolution)
		// if ( typeOfAttributeOrField instanceof MofClass ||
		// typeOfAttributeOrField instanceof StructureType ) {
		//
		// result = new AssocResolution( );
		// // these are the default assignments for class-valued attributes
		// result.leftAssocEnd = 0;
		// result.leftStorage = true;
		// result.rightAssocEnd = 1;
		// result.rightStorage = false;
		// result.assocMRI = ( (Partitionable) leftAttributeOrField ).get___Mri(
		// );
		//
		// // set the category
		// result.assocCategory = SpiFqlAssociationCategory.ATTRIBUTE;
		//
		// // Observe that the strings are there for debugging and logging
		// purposes
		//
		// // assign the correct names for the association data
		// List<String> leftQName = ( (ModelElementInternal)
		// leftAttributeOrField ).getQualifiedName( this.conn );
		// result.assocName = this.printTypeName( leftQName,
		// result.assocMRI.getContainerName( ) );
		// // for the assoc end name itself, the non-qualified version of the
		// attribute name is sufficient
		// result.leftAssocEndName = leftAttributeOrField.getName( );
		// // for the other side of the association end name, we use the
		// non-qualified name of the type of the attribute
		// result.rightAssocEndName = typeOfAttributeOrField.getName( );
		// }
		// } else
		if (leftReference != null) {

			// if we have a valid reference, we can set the association
			result = new ReferenceResolution();

			// we first get the immediate information of the reference
			// AssociationEnd assocEndLeft = ( (ReferenceInternal) leftReference
			// ).getExposedEnd( this.conn );
			// AssociationEnd assocEndRight = ( (ReferenceInternal)
			// leftReference ).getReferencedEnd( this.conn );
			// Association assoc = (Association) ( (AssociationEndInternal)
			// assocEndLeft ).getContainer( this.conn );

			// obtain some additional information
			// result.leftAssocEnd = this.jmiHelper.getAssociationEndNumber(
			// this.conn.getSession( ), assocEndLeft );
			// result.leftStorage = this.jmiHelper.isEndStored(
			// this.conn.getSession( ), assocEndLeft );
			// result.rightAssocEnd = 1 - result.leftAssocEnd;
			// result.rightStorage = this.jmiHelper.isEndStored(
			// this.conn.getSession( ), assocEndRight );
			// result.assocMRI = ( (Partitionable) assoc ).get___Mri( );
			result.assocMRI = EcoreUtil.getURI(leftReference);

			// set the category
			// result.assocCategory = SpiFqlAssociationCategory.ASSOCIATION;

			// Observe that the strings are there for debugging and logging
			// purposes

			// assign the correct names for the association data
			// List<String> assocQName = ( (AssociationInternal) assoc
			// ).getQualifiedName( this.conn );
			// result.assocName = this.printTypeName( assocQName,
			// result.assocMRI.getContainerName( ) );
			result.assocName = leftReference.getName();
			// we reuse the attribute name, but for the assoc end, the
			// non-qualified version is sufficient
			// result.leftAssocEndName = assocEndLeft.getName( );
			// result.rightAssocEndName = assocEndRight.getName( );
		}

		return result;
	}
}

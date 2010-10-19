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
package org.eclipse.emf.query2.internal.moinql.parser.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.query2.FromFixedSet;
import org.eclipse.emf.query2.FromType;
import org.eclipse.emf.query2.Operation;
import org.eclipse.emf.query2.Query;
import org.eclipse.emf.query2.QueryElement;
import org.eclipse.emf.query2.QueryFormatException;
import org.eclipse.emf.query2.QueryProcessor;
import org.eclipse.emf.query2.SelectAttrs;
import org.eclipse.emf.query2.SelectEntry;
import org.eclipse.emf.query2.TypeScopeProvider;
import org.eclipse.emf.query2.WhereAnd;
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
import org.eclipse.emf.query2.exception.LocalizedBaseRuntimeException;
import org.eclipse.emf.query2.internal.messages.ApiMessages;
import org.eclipse.emf.query2.internal.messages.BugMessages;
import org.eclipse.emf.query2.internal.moinql.parser.CstNode;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.AbstractMqlAstVisitor;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.AliasComparisonClause;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.AndWhereCondition;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.AssocOrComparisonPredicate;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.ComparisonGreaterEqualPredicate;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.ComparisonGreaterPredicate;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.ComparisonLikePredicate;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.ComparisonNotEqualPredicate;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.ComparisonNotLikePredicate;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.ComparisonPredicate;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.ComparisonSmallerEqualPredicate;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.ComparisonSmallerPredicate;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.ElementPathNameN;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.FalseLiteral;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.FragmentAddress;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.FromClause;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.FromEntry;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.FromEntryN;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.Ident;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.IdentifierComparisonInPredicate;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.IdentifierEqualsComparisonInPredicate;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.IdentifierN;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.IelementPathNameM;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.IidentifierN;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.Iliteral;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.IlocalWhereCondition;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.InElements;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.InegativeWhereCondition;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.IntegerLiteral;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.IuriM;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.JoinWhereEntry;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.LinkPredicate;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.LiteralComparisonInPredicate;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.LiteralEqualsComparisonInPredicate;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.LocalWhereEntry;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.MqlQuery;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.NameBasedNavigation;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.Node;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.Not;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.NotLike;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.NotWhereCondition;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.NullLiteral;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.OpEqual;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.OpGreater;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.OpGreaterEqual;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.OpLike;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.OpNotEqual;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.OpSmaller;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.OpSmallerEqual;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.OperationCondition;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.OrWhereCondition;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.ParenthesizedLocalWhereCondition;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.PartitionScope;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.PathNameIdent;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.RealLiteral;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.ScopeClause;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.SelectAlias;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.SelectAttribute;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.SelectClause;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.SelectEntryN;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.StringLiteral;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.TrueLiteral;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.TypePathNameN;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.TypeQName;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.TypeSetClause;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.Uri;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.UriN;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.WhereClause;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.WhereClauseN;
import org.eclipse.emf.query2.internal.moinql.parser.gen.mqlAst.Withoutsubtypes;
import org.eclipse.emf.query2.internal.shared.BugException;
import org.eclipse.emf.query2.internal.shared.EmfHelper;
import org.eclipse.emf.query2.internal.shared.UsageException;
import org.eclipse.emf.query2.report.ProcessMessage;
import org.eclipse.emf.query2.report.ProcessReport;


/**
 * 
 */
public class MqlAstBuilder extends AbstractMqlAstVisitor {

	private static final String OPERATION_TAG = "operation"; //$NON-NLS-1$

	private static final String NESTED_TAG = "nested"; //$NON-NLS-1$

	/**
	 * We need the Moin instance for some services with regard to URI and MRI
	 * parsing
	 */
	private EmfHelper moin;

	/**
	 * We use the mqlProcesor for certain services
	 */
	private QueryProcessor mqlProcessor;

	/**
	 * For the result
	 */
	private Query mqlQuery;

	/**
	 * @param _report
	 * @param _moin
	 * @param _mqlProcessor
	 */
	public MqlAstBuilder(ProcessReport _report, EmfHelper _moin, QueryProcessor _mqlProcessor) {

		super();
		this.moin = _moin;
		this.report = _report;
		this.mqlProcessor = _mqlProcessor;
	}

	/**
	 * @return the query
	 */
	public Query getMQLQuery() {

		return this.mqlQuery;
	}

	private ProcessMessage reportError(UsageException e, CstNode n) {

		return this.reportMessage(e, n, MessageType.ERROR);
	}

	private void reportFatalMQLError(Node n, LocalizedBaseRuntimeException ex) {

		super.reportFatalError(ex, n);
		throw new QueryFormatException(super.report);
	}

	/**
	 * This method transfers positional information from the cst node to the ast
	 * node
	 */
	private void transferPositionInformation(QueryElement element, Node n) {

		element.setEndColumn(n.getEndColumn());
		element.setEndLine(n.getEndLine());
		element.setEndPos(n.getEndOffset());
		element.setStartColumn(n.getColumn());
		element.setStartLine(n.getLine());
		element.setStartPos(n.getStartOffset());
	}

	/**
	 * We need a simple sum record to handle type clauses
	 */
	public static abstract class TypeClause {

		public boolean withoutSubTypes;

		public Set<URI> withoutSubtypeSet;
	}

	final static public class MriElement extends TypeClause {

		public URI mri;
	}

	final static public class QualNameType extends TypeClause {

		public String typeUriString;
	}

	/**
	 * We need a simple sum record to handle scopes
	 */
	public static abstract class ExplicitScope {

		public boolean inclusive;
	}

	final static public class PriScopeClause extends ExplicitScope {

		public Set<URI> scope;
	}

	final static public class ElementScopeClause extends ExplicitScope {

		public Set<URI> elements;
	}

	/**
	 * For lists of identifiers
	 */
	final static public class IdentifierAndNode {

		public String identifier;

		public CstNode node;
	}

	/**
	 * We need a simple sum record to handle identifiers.
	 */
	public static abstract class ParsedIdentifier {
		// an identifier may be a URI or something else when occurring in a path
	}

	static public class FoundMri extends ParsedIdentifier {

		// the identifier parsed to a MRI
		public URI mri;
	}

	static public class NoMri extends ParsedIdentifier {

		// the message from attempting to parse an identifier into a MRI
		public String errorMessageForMriParse;

		// the identifier actually found
		public String foundIdentifier;
	}

	/**
	 * We need a simple sum record to handle navigation steps for Joining where
	 * entries
	 */
	public static abstract class NavigationStep {

		// has at least a starting alias
		public String alias;
	}

	static public class FeatureNavigationStep extends NavigationStep {

		// the feature
		public String feature;
	}

	/**
	 * Obtains a set of IdentifierAndNodes for a possibly empty list of
	 * identifiers
	 */
	@SuppressWarnings("unchecked")
	private Set<IdentifierAndNode> obtainScopeSet(CstNode n, IuriM identifierM) {

		Set<IdentifierAndNode> scope = null;
		if (identifierM != null) {
			identifierM.accept(this);
			Object o = this.getUpProperty((Node) identifierM);

			if (o instanceof MriElement) {
				scope = new HashSet<IdentifierAndNode>(1);
				IdentifierAndNode identNode = new IdentifierAndNode();
				identNode.identifier = ((MriElement) o).mri.toString();
				identNode.node = (Node) identifierM;
				scope.add(identNode);
			} else if (o instanceof Set) {
				scope = (Set<IdentifierAndNode>) o;
			} else if (o instanceof List) {
				scope = new HashSet<IdentifierAndNode>((List<IdentifierAndNode>) o);
			} else {
				this.reportInternalError(n, BugMessages.SCOPE_CLAUSE_TYPE_WRONG);
			}
		} else {
			scope = new HashSet<IdentifierAndNode>(0);
		}

		return scope;
	}

	// FIXME duplicate
	@SuppressWarnings("unchecked")
	private Set<IdentifierAndNode> obtainScopeSet(CstNode n, IelementPathNameM identifierM) {

		Set<IdentifierAndNode> scope = null;
		if (identifierM != null) {
			identifierM.accept(this);
			Object o = this.getUpProperty((Node) identifierM);

			if (o instanceof MriElement) {
				scope = new HashSet<IdentifierAndNode>(1);
				IdentifierAndNode identNode = new IdentifierAndNode();
				identNode.identifier = ((MriElement) o).mri.toString();
				identNode.node = (Node) identifierM;
				scope.add(identNode);
			} else if (o instanceof List) {
				scope = new HashSet<IdentifierAndNode>((List<IdentifierAndNode>) o);
			} else if (o instanceof Set) {
				scope = (Set) o;
			} else {
				this.reportInternalError(n, BugMessages.SCOPE_CLAUSE_TYPE_WRONG);
			}
		} else {
			scope = new HashSet<IdentifierAndNode>(0);
		}

		return scope;
	}

	/**
	 * Handles n-ary local where clauses
	 */
	private void handleNaryClauses(CstNode n, IlocalWhereCondition localClause, InegativeWhereCondition negativeClause, boolean andOperation) {

		// get left one
		localClause.accept(this);
		org.eclipse.emf.query2.WhereClause localWhereClause = (org.eclipse.emf.query2.WhereClause) this
				.getUpProperty((Node) localClause);

		// get right one
		negativeClause.accept(this);
		org.eclipse.emf.query2.WhereClause negativeWhereClause = (org.eclipse.emf.query2.WhereClause) this
				.getUpProperty((Node) negativeClause);

		// we just put these together
		WhereNary result = null;
		if (andOperation) {
			result = new WhereAnd(new org.eclipse.emf.query2.WhereClause[] { localWhereClause, negativeWhereClause });
		} else {
			result = new WhereOr(new org.eclipse.emf.query2.WhereClause[] { localWhereClause, negativeWhereClause });
		}

		// propagate
		this.setUpProperty(n, result);
	}

	/**
	 * Handles local comparison operations on attributes and literal values
	 */
	private void handleOperation(Operation op, Node n, Iliteral literalN) {

		// get the alias
		String feature = (String) this.getDownProperty(n);

		// get the literal involved
		literalN.accept(this);

		// for the result
		WhereComparator result = null;

		Object o = this.getUpProperty((Node) literalN);
		// distinguish the options
		if (o instanceof String) {
			result = new WhereString(feature, op, (String) o);
		} else if (o instanceof Boolean) {
			switch (op) {
			case EQUAL:
				result = new WhereBool(feature, (Boolean) o);
				break;
			case NOTEQUAL:
				result = new WhereBool(feature, !((Boolean) o));
				break;
			default:
				this.reportFatalMQLError(n, new UsageException(ApiMessages.BOOLEAN_ONLY_ALLOW_EQUALITY, op));
			}
		} else if (o instanceof Integer) {
			result = new WhereInt(feature, op, (Integer) o);
		} else if (o instanceof Long) {
			result = new WhereLong(feature, op, (Long) o);
		} else if (o instanceof Float) {
			result = new WhereFloat(feature, op, (Float) o);
		} else if (o instanceof Double) {
			result = new WhereDouble(feature, op, (Double) o);
		} else if (o instanceof List) {
			// this is the encoding for the null literal
			switch (op) {
			case EQUAL:
			case NOTEQUAL:
				result = new WhereString(feature, op, null);
				break;
			default:
				this.reportFatalMQLError(n, new UsageException(ApiMessages.NULL_COMPARISON_ONLY_FOR_EQUALITY, op));
			}
		} else {
			this.reportInternalError(n, BugMessages.INVALID_LITERAL_TYPE_IN_OPERATION);
		}

		// propagate
		this.setUpProperty(n, result);
	}

	/*
	 * Visitor methods
	 */

	/**
	 * <b> <li>query ::= selectClause fromClause whereClauseM </b>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void visit(MqlQuery n) {

		n.getselectClause().accept(this);
		List<SelectEntry> selectEntries = (List<SelectEntry>) this.getUpProperty(n.getselectClause());

		n.getfromClause().accept(this);
		List<org.eclipse.emf.query2.FromEntry> fromEntries = (List<org.eclipse.emf.query2.FromEntry>) this.getUpProperty(n
				.getfromClause());

		// for the result
		Query constructedQuery = null;

		if (n.getwhereClauseM() != null) {
			// we also have where conditions
			n.getwhereClauseM().accept(this);
			Object o = this.getUpProperty((Node) n.getwhereClauseM());

			List<WhereEntry> whereEntries = null;
			if (o instanceof WhereEntry) {
				whereEntries = new ArrayList<WhereEntry>(1);
				whereEntries.add((WhereEntry) o);
			} else if (o instanceof List) {
				whereEntries = (List<WhereEntry>) o;
			} else {
				this.reportInternalError(n, BugMessages.ENTRY_OR_LIST_OF_ENTRY_EXPECTED, "WhereEntry"); //$NON-NLS-1$
			}
			// set the query
			constructedQuery = new Query(selectEntries, fromEntries, whereEntries);
		} else {
			// no where entries
			constructedQuery = new Query(selectEntries, fromEntries);
		}
		this.transferPositionInformation(constructedQuery, n);

		if (this.hasDownProperty(n, NESTED_TAG)) {
			// we are handling a nested query
			this.setUpProperty(n, constructedQuery);
		} else {
			// this is the result query
			this.mqlQuery = constructedQuery;
		}
	}

	/**
	 * <b> <li>selectEntry ::= identifier . identifier </b>
	 */
	@Override
	public void visit(SelectAttribute n) {

		n.getidentifier().accept(this);
		String aliasName = (String) this.getUpProperty(n.getidentifier());
		n.getidentifier3().accept(this);
		String attrName = (String) this.getUpProperty(n.getidentifier3());

		SelectAttrs selectAttr = new SelectAttrs(aliasName, new String[] { attrName });
		this.transferPositionInformation(selectAttr, n);

		// does this work with separated attribute selections?
		this.setUpProperty(n, selectAttr);
	}

	/**
	 * <b> <li>selectEntry ::= identifier </b>
	 */
	@Override
	public void visit(SelectAlias n) {

		n.getidentifier().accept(this);
		String aliasName = (String) this.getUpProperty(n.getidentifier());

		org.eclipse.emf.query2.SelectAlias selectAlias = new org.eclipse.emf.query2.SelectAlias(aliasName);
		this.transferPositionInformation(selectAlias, n);

		this.setUpProperty(n, selectAlias);
	}

	/**
	 * <b> <li>selectClause ::= select selectEntryN </b>
	 */
	@Override
	public void visit(SelectClause n) {

		n.getselectEntryN().accept(this);
		Object o = this.getUpProperty((Node) n.getselectEntryN());

		// we may have one element or a list
		if (o instanceof List) {
			this.setUpProperty(n, o);
		} else if (o instanceof SelectEntry) {
			List<SelectEntry> selectEntries = new ArrayList<SelectEntry>(1);
			selectEntries.add((SelectEntry) o);
			this.setUpProperty(n, selectEntries);
		} else {
			this.reportInternalError(n, BugMessages.ENTRY_OR_LIST_OF_ENTRY_EXPECTED, "SelectEntry"); //$NON-NLS-1$
		}
	}

	/**
	 * <b> <li>selectEntryN ::= selectEntry , selectEntryN </b>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void visit(SelectEntryN n) {

		n.getselectEntry().accept(this);
		SelectEntry selectEntry = (SelectEntry) this.getUpProperty((Node) n.getselectEntry());

		n.getselectEntryN().accept(this);
		Object o = this.getUpProperty((Node) n.getselectEntryN());

		List<SelectEntry> selectEntryList = null;

		// if we selectEntryN is again a list, we prepend the select entry,
		// otherwise, we construct a list of two elements
		if (o instanceof List) {
			selectEntryList = (List<SelectEntry>) o;
			selectEntryList.add(0, selectEntry);
		} else if (o instanceof SelectEntry) {
			SelectEntry selectEntry2 = (SelectEntry) o;
			selectEntryList = new ArrayList<SelectEntry>();
			selectEntryList.add(selectEntry);
			selectEntryList.add(selectEntry2);
		} else {
			this.reportInternalError(n, BugMessages.ENTRY_OR_LIST_OF_ENTRY_EXPECTED, "SelectEntry"); //$NON-NLS-1$
		}

		this.setUpProperty(n, selectEntryList);
	}

	/**
	 * <b> <li>fromClause ::= from fromEntryN </b>
	 */
	@Override
	public void visit(FromClause n) {

		n.getfromEntryN().accept(this);
		Object o = this.getUpProperty((Node) n.getfromEntryN());

		// we may have one element or a list
		if (o instanceof List) {
			this.setUpProperty(n, o);
		} else if (o instanceof org.eclipse.emf.query2.FromEntry) {
			List<org.eclipse.emf.query2.FromEntry> fromEntries = new ArrayList<org.eclipse.emf.query2.FromEntry>(1);
			fromEntries.add((org.eclipse.emf.query2.FromEntry) o);
			this.setUpProperty(n, fromEntries);
		} else {
			this.reportInternalError(n, BugMessages.ENTRY_OR_LIST_OF_ENTRY_EXPECTED, "FromEntry"); //$NON-NLS-1$
		}
	}

	/**
	 * <b> <li>fromEntry ::= typeClause as identifier scopeClauseOpt </b>
	 */
	@Override
	public void visit(FromEntry n) {

		// get the type clause
		n.gettypeClause().accept(this);
		TypeClause typeClause = (TypeClause) this.getUpProperty(n.gettypeClause());

		// get the alias
		n.getidentifier().accept(this);
		String aliasName = (String) this.getUpProperty(n.getidentifier());

		// get the scope
		ExplicitScope scopeClause = null;
		if (n.getscopeClauseOpt() != null) {
			n.getscopeClauseOpt().accept(this);
			scopeClause = (ExplicitScope) this.getUpProperty(n.getscopeClauseOpt());
		}

		// a type clause is either a qualified name or a mri
		org.eclipse.emf.query2.FromEntry resultFromEntry = null;

		//        if ( typeClause instanceof MriType ) {
		//            throw new IllegalArgumentException( );
		//            MriType mriType = (MriType) typeClause;
		//
		//            if ( scopeClause instanceof PriScopeClause ) {
		//                QueryScopeProvider queryScopeProvider = this.mqlProcessor.getQueryScopeProvider( scopeClause.inclusive, ( (PriScopeClause) scopeClause ).scope );
		//                resultFromEntry = new FromTypeMri( aliasName, mriType.mri, mriType.withoutSubTypes, queryScopeProvider );
		//            } else if ( scopeClause instanceof ContainerScopeClause ) {
		//                throw new IllegalArgumentException( );
		//                // QueryScopeProvider queryScopeProvider =
		//                // this.mqlProcessor.getQueryScopeProvider(
		//                // scopeClause.inclusive, null, ( (ContainerScopeClause)
		//                // scopeClause ).scope );
		//                // resultFromEntry = new FromTypeMri( aliasName, mriType.mri,
		//                // mriType.withoutSubTypes, queryScopeProvider );
		//            } else if ( scopeClause instanceof ElementScopeClause ) {
		//                if ( !scopeClause.inclusive ) {
		//                    this.reportError( new MQLUsageException( MQLApiMessages.ELEMENTS_CANNOT_BE_NEGATED ), n.getscopeClauseOpt( ) );
		//                }
		//                resultFromEntry = new FromMriTypeFixedSet( aliasName, mriType.mri, ( (ElementScopeClause) scopeClause ).elements );
		//            } else {
		//                resultFromEntry = new FromTypeMri( aliasName, mriType.mri, mriType.withoutSubTypes );
		//            }

		//        } else if ( typeClause instanceof QualNameType ) {
		//            throw new IllegalArgumentException( );
		//            QualNameType qualNameType = (QualNameType) typeClause;
		//
		//            if ( scopeClause instanceof PriScopeClause ) {
		//                QueryScopeProvider queryScopeProvider = this.mqlProcessor.getQueryScopeProvider( scopeClause.inclusive, ( (PriScopeClause) scopeClause ).scope );
		//                resultFromEntry = new FromType( aliasName, qualNameType.qualifiedMofName.toArray( new String[qualNameType.qualifiedMofName.size( )] ), qualNameType.containerName, qualNameType.withoutSubTypes, queryScopeProvider );
		//            } else if ( scopeClause instanceof ContainerScopeClause ) {
		//                throw new IllegalArgumentException( );
		//                // QueryScopeProvider queryScopeProvider =
		//                // this.mqlProcessor.getQueryScopeProvider(
		//                // scopeClause.inclusive, null, ( (ContainerScopeClause)
		//                // scopeClause ).scope );
		//                // resultFromEntry = new FromType( aliasName,
		//                // qualNameType.qualifiedMofName.toArray( new
		//                // String[qualNameType.qualifiedMofName.size( )] ),
		//                // qualNameType.containerName, qualNameType.withoutSubTypes,
		//                // queryScopeProvider );
		//            } else if ( scopeClause instanceof ElementScopeClause ) {
		//                if ( !scopeClause.inclusive ) {
		//                    this.reportError( new MQLUsageException( MQLApiMessages.ELEMENTS_CANNOT_BE_NEGATED ), n.getscopeClauseOpt( ) );
		//                }
		//                resultFromEntry = new FromFixedSet( aliasName, qualNameType.qualifiedMofName.toArray( new String[qualNameType.qualifiedMofName.size( )] ), qualNameType.containerName, ( (ElementScopeClause) scopeClause ).elements );
		//            } else {
		//                resultFromEntry = new FromType( aliasName, qualNameType.qualifiedMofName.toArray( new String[qualNameType.qualifiedMofName.size( )] ), qualNameType.containerName, qualNameType.withoutSubTypes );
		//            }

		//        } else 
		if (typeClause instanceof MriElement) {

			if (scopeClause instanceof PriScopeClause) {
				TypeScopeProvider queryScopeProvider = this.mqlProcessor.getQueryScopeProvider(scopeClause.inclusive,
						((PriScopeClause) scopeClause).scope);
				resultFromEntry = new FromType(aliasName, ((MriElement) typeClause).mri, typeClause.withoutSubTypes, queryScopeProvider);
			} else if (scopeClause instanceof ElementScopeClause) {
				if (!scopeClause.inclusive) {
					this.reportError(new UsageException(ApiMessages.ELEMENTS_CANNOT_BE_NEGATED), n.getscopeClauseOpt());
				}
				resultFromEntry = new FromFixedSet(aliasName, ((MriElement) typeClause).mri, ((ElementScopeClause) scopeClause).elements);
			} else {
				resultFromEntry = new FromType(aliasName, ((MriElement) typeClause).mri, typeClause.withoutSubTypes);
			}
			// resultFromEntry = new FromType(aliasName,
			// new String[] { ((MriElement) typeClause).mri.toString() },
			// typeClause.withoutSubTypes);

		} else {
			throw new IllegalArgumentException();
		}

		// transfer positional information
		if (resultFromEntry != null) {
			this.transferPositionInformation(resultFromEntry, n);

			// set withoutSubTypeSet
			resultFromEntry.setWithoutSubtypeSet(typeClause.withoutSubtypeSet);
		}

		this.setUpProperty(n, resultFromEntry);
	}

	/**
	 * <b> <li>fromEntryN ::= fromEntry , fromEntryN </b>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void visit(FromEntryN n) {

		n.getfromEntry().accept(this);
		org.eclipse.emf.query2.FromEntry fromEntry = (org.eclipse.emf.query2.FromEntry) this.getUpProperty(n.getfromEntry());

		n.getfromEntryN().accept(this);
		Object o = this.getUpProperty((Node) n.getfromEntryN());

		List<org.eclipse.emf.query2.FromEntry> fromEntryList = null;

		// if we fromEntryN is again a list, we prepend the from entry,
		// otherwise, we construct a list of two elements
		if (o instanceof List) {
			fromEntryList = (List<org.eclipse.emf.query2.FromEntry>) o;
			fromEntryList.add(0, fromEntry);
		} else if (o instanceof org.eclipse.emf.query2.FromEntry) {
			org.eclipse.emf.query2.FromEntry fromEntry2 = (org.eclipse.emf.query2.FromEntry) o;
			fromEntryList = new ArrayList<org.eclipse.emf.query2.FromEntry>();
			fromEntryList.add(fromEntry);
			fromEntryList.add(fromEntry2);
		} else {
			this.reportInternalError(n, BugMessages.ENTRY_OR_LIST_OF_ENTRY_EXPECTED, "FromEntry"); //$NON-NLS-1$
		}

		this.setUpProperty(n, fromEntryList);
	}

	//    /**
	//     * <b> <li>typeClauseMri ::= type identifier withoutsubtypesOpt </b>
	//     */
	//    @Override
	//    public void visit( TypeMri n ) {
	//
	//        // get the type identifier
	//        n.getidentifier( ).accept( this );
	//        String mriAsString = (String) this.getUpProperty( n.getidentifier( ) );
	//
	//        MriType resultRecord = new MriType( );
	//        try {
	//            resultRecord.mri = this.moin.createUri( mriAsString );
	//        } catch ( IllegalArgumentException e ) {
	//            this.reportFatalMQLError( n.getidentifier( ), new MQLUsageException( MQLApiMessages.INVALID_MRI_STRING, mriAsString ) );
	//        }
	//
	//        // are we dealing with or without subtypes
	//        resultRecord.withoutSubTypes = ( n.getwithoutsubtypesOpt( ) != null );
	//
	//        // push up the result
	//        this.setUpProperty( n, resultRecord );
	//    }

	/**
	 * <b> <li>typeClauseQName ::= typePathName withoutsubtypesOpt </b>
	 */
	@SuppressWarnings( { "null", "unchecked" })
	@Override
	public void visit(TypeQName n) {

		// get the type
		n.getfragmentaddress().accept(this);
		Object o = this.getUpProperty(n.getfragmentaddress());

		// for the result
		TypeClause typeClause = null;

		//        if ( o instanceof ParsedIdentifier ) {
		//            // this is only ok if we found a MRI
		//            if ( o instanceof FoundMri ) {
		//                typeClause = new MriElement( );
		//                ( (MriElement) typeClause ).mri = ( (FoundMri) o ).mri;
		//            } else if ( o instanceof NoMri ) {
		//                // not ok - maybe we tried to see a MRI
		//                this.reportFatalMQLError( n.getfragmentaddress( ), new MQLUsageException( MQLApiMessages.INVALID_FIXED_ELEMENT, ( (NoMri) o ).foundIdentifier, ( (NoMri) o ).errorMessageForMriParse ) );
		//            } else {
		//                this.reportInternalError( n, MQLBugMessages.EXPECT_FOUNDMRI_NOMRI );
		//            }
		//        } else 
		if (o instanceof TypeClause) {
			typeClause = (TypeClause) o;
		} else {
			// FIXME 
			this.reportInternalError(n, BugMessages.EXPECTED_TYPE_CLAUSE_OR_PARSED_ID);
		}

		// are we dealing with or without subtypes
		Withoutsubtypes ws = n.getwithoutsubtypesOpt();

		if (ws != null) {
			typeClause.withoutSubTypes = true;
			ws.accept(this);
			typeClause.withoutSubtypeSet = (Set) this.getUpProperty(ws);

		} else {
			typeClause.withoutSubTypes = false;
		}

		// push up the result
		this.setUpProperty(n, typeClause);
	}

	/**
	 *<b> <li>withoutsubtypesOpt ::= withoutsubtypes typeSetClauseOpt </b>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void visit(Withoutsubtypes n) {

		Set<URI> resultWithoutSubTypeSet = null;

		TypeSetClause tsc = n.gettypeSetClauseOpt();
		if (tsc != null) {
			// a type-set clause has been provided
			tsc.accept(this);
			resultWithoutSubTypeSet = (Set) this.getUpProperty(tsc);
		}

		this.setUpProperty(n, resultWithoutSubTypeSet);
	}

	/**
	 *<b> <li>typeSetClauseOpt ::= { typePathNameN } </b>
	 */
	@Override
	public void visit(TypeSetClause n) {

		n.gettypePathNameN().accept(this);
		Set<URI> resultWithoutSubTypeSet = this.obtainQualNameList(this.getUpProperty((Node) n.gettypePathNameN()));
		this.setUpProperty(n, resultWithoutSubTypeSet);
	}

	/**
	 *<b> <li>typePathNameN ::= typePathName , typePathNameN </b>
	 */
	@Override
	public void visit(TypePathNameN n) {

		n.gettypePathNameN().accept(this);
		Set<URI> resultWithoutSubTypeSet = this.obtainQualNameList(this.getUpProperty((Node) n.gettypePathNameN()));

		n.getfragmentaddress().accept(this);
		TypeClause tc = (TypeClause) this.getUpProperty(n.getfragmentaddress());

		//        if ( tc instanceof QualNameType ) {
		//            QualNameType qnt = (QualNameType) tc;
		//            QualName qualName = new org.eclipse.emf.query2.mql.FromEntry.QualName( );
		//            qualName.containerName = qnt.containerName;
		//            qualName.qualifiedMofName = qnt.qualifiedMofName.toArray( new String[qnt.qualifiedMofName.size( )] );
		//            resultWithoutSubTypeSet.add( qualName );
		//        }

		if (tc instanceof MriElement) {
			resultWithoutSubTypeSet.add(((MriElement) tc).mri);
		}

		this.setUpProperty(n, resultWithoutSubTypeSet);
	}

	@Override
	public void visit(ElementPathNameN n) {

		n.getelementPathNameN().accept(this);
		Object o = this.getUpProperty((Node) n.getelementPathNameN());

		Set<IdentifierAndNode> result = null;
		if (o instanceof Set) {
			result = (Set<IdentifierAndNode>) o;
		} else if (o instanceof MriElement) {
			result = new HashSet<IdentifierAndNode>();
			IdentifierAndNode ian = new IdentifierAndNode();
			ian.identifier = ((MriElement) o).mri.toString();
			ian.node = (Node) n.getelementPathNameN();
			result.add(ian);
		} else {
			throw new IllegalArgumentException();
		}

		n.getfragmentaddress().accept(this);
		MriElement uri = (MriElement) this.getUpProperty(n.getfragmentaddress());

		if (uri != null) {
			if (result == null) {
				result = new HashSet<IdentifierAndNode>();
			}
			IdentifierAndNode ian = new IdentifierAndNode();
			ian.identifier = (uri).mri.toString();
			ian.node = (Node) n.getelementPathNameN();
			result.add(ian);
		}

		this.setUpProperty(n, result);
	}

	@Override
	public void visit(Uri n) {

		MriElement typeClause = null;
		try {
			String typeClauseString = n.getIToken().toString();
			if (typeClauseString != null && typeClauseString.length() > 1) {
				URI uri = URI.createURI(typeClauseString.substring(1, typeClauseString.length() - 1));
				typeClause = new MriElement();
				typeClause.mri = uri;
			}
		} catch (IllegalArgumentException e) {
			// FIXME report error
		}

		this.setUpProperty(n, typeClause);
	}

	@Override
	public void visit(UriN n) {

		n.geturiN().accept(this);
		Object o = this.getUpProperty((Node) n.geturiN());

		Set<IdentifierAndNode> result = null;
		if (o instanceof Set) {
			result = (Set<IdentifierAndNode>) o;
		} else if (o instanceof MriElement) {
			result = new HashSet<IdentifierAndNode>();
			IdentifierAndNode ian = new IdentifierAndNode();
			ian.identifier = ((MriElement) o).mri.toString();
			ian.node = (Node) n.geturiN();
			result.add(ian);
		} else {
			throw new IllegalArgumentException();
		}

		n.geturi().accept(this);
		MriElement uri = (MriElement) this.getUpProperty(n.geturi());

		if (uri != null) {
			if (result == null) {
				result = new HashSet<IdentifierAndNode>();
			}
			IdentifierAndNode ian = new IdentifierAndNode();
			ian.identifier = (uri).mri.toString();
			ian.node = n.geturi();
			result.add(ian);
		}

		this.setUpProperty(n, result);
	}

	@Override
	public void visit(FragmentAddress n) {

		MriElement typeClause = null;
		try {
			String typeClauseString = n.getIToken().toString();
			if (typeClauseString != null && typeClauseString.length() > 1) {
				URI uri = URI.createURI(typeClauseString.substring(1, typeClauseString.length() - 1));
				typeClause = new MriElement();
				typeClause.mri = uri;
			}
		} catch (IllegalArgumentException e) {

		}

		this.setUpProperty(n, typeClause);
	}

	@SuppressWarnings("unchecked")
	private Set<URI> obtainQualNameList(Object entryObject) {

		Set<URI> resultWithoutSubTypeSet = null;
		if (entryObject instanceof QualNameType) {
			throw new IllegalArgumentException();
			//            QualNameType qnt = (QualNameType) entryObject;
			//            resultWithoutSubTypeSet = new HashSet<QualName>( );
			//            QualName qualName = new org.eclipse.emf.query2.mql.FromEntry.QualName( );
			//            qualName.containerName = qnt.containerName;
			//            qualName.qualifiedMofName = qnt.qualifiedMofName.toArray( new String[qnt.qualifiedMofName.size( )] );
			//            resultWithoutSubTypeSet.add( qualName );
		} else if (entryObject instanceof Set) {
			resultWithoutSubTypeSet = (Set) entryObject;
		} else if (entryObject instanceof MriElement) {
			resultWithoutSubTypeSet = new HashSet<URI>();
			resultWithoutSubTypeSet.add(((MriElement) entryObject).mri);
		} else {
			throw new BugException(BugMessages.UNEXPECTED_PARSE_OBJECT);
		}

		return resultWithoutSubTypeSet;
	}

	/**
	 * <b> <li>scopeClauseOpt ::= notOpt in scopeClause </b>
	 */
	@Override
	public void visit(ScopeClause n) {

		boolean inclusive = n.getnotOpt() == null;

		n.getscopeClause().accept(this);

		// for the result
		ExplicitScope explicitScope = (ExplicitScope) this.getUpProperty((Node) n.getscopeClause());

		// set the inclusivity property
		explicitScope.inclusive = inclusive;

		// propagate
		this.setUpProperty(n, explicitScope);
	}

	/**
	 * <b> <li>scopeClause ::= partitions { identifierM } </b>
	 */
	@Override
	public void visit(PartitionScope n) {

		Set<IdentifierAndNode> scope = this.obtainScopeSet(n, n.geturiM());

		// try to parse as PRIs
		PriScopeClause result = new PriScopeClause();
		result.scope = new HashSet<URI>(scope.size());

		for (IdentifierAndNode element : scope) {
			// try to parse
			try {
				URI pri = this.moin.createUri(element.identifier);
				result.scope.add(pri);
			} catch (IllegalArgumentException e) {
				this.reportError(new UsageException(ApiMessages.SCOPE_ELEMENT_NOT_PRI, element.identifier), element.node);
			}
		}

		// propagate
		this.setUpProperty(n, result);
	}

	/**
	 * <b> <li>scopeClause ::= elements { identifierM } </b>
	 */
	@Override
	public void visit(InElements n) {

		Set<IdentifierAndNode> scope = this.obtainScopeSet(n, n.getelementPathNameM());

		// try to parse as PRIs
		ElementScopeClause result = new ElementScopeClause();
		result.elements = new HashSet<URI>(scope.size());

		for (IdentifierAndNode element : scope) {
			// try to parse
			try {
				URI mri = this.moin.createUri(element.identifier);
				result.elements.add(mri);
			} catch (IllegalArgumentException e) {
				this.reportError(new UsageException(ApiMessages.SCOPE_ELEMENT_NOT_MRI, element.identifier), element.node);
			}
		}

		// propagate
		this.setUpProperty(n, result);
	}

	//    /**
	//     * <b> <li>scopeClause ::= containers { identifierM } </b>
	//     */
	//    @Override
	//    public void visit( ContainerScope n ) {
	//
	//        throw new IllegalArgumentException( );
	//        // Set<IdentifierAndNode> scope = this.obtainScopeSet( n,
	//        // n.getidentifierM( ) );
	//        //
	//        // // try to parse as PRIs
	//        // ContainerScopeClause result = new ContainerScopeClause( );
	//        // result.scope = new HashSet<URI>( scope.size( ) );
	//        //
	//        // for ( IdentifierAndNode element : scope ) {
	//        // // try to parse
	//        // try {
	//        // URI cri = this.moin.createUri( element.identifier );
	//        // result.scope.add( cri );
	//        // } catch ( InvalidResourceIdentifierException e ) {
	//        // // if we cannot parse this, we assume it is a normal container name
	//        // URI[] cris = this.mqlProcessor.getCrisForContainerNames( new String[]
	//        // { element.identifier } );
	//        // for ( int i = 0; i < cris.length; i++ ) {
	//        // result.scope.add( cris[i] );
	//        // }
	//        //
	//        // //this.reportError( new MoinBaseException(
	//        // MQLApiMessages.SCOPE_ELEMENT_NOT_PRI.getLocalizedMessage( new
	//        // Object[] { element.identifier, e.getLocalizedMessage( ) } ) ),
	//        // element.node );
	//        // }
	//        // }
	//        //
	//        // // propagate
	//        // this.setUpProperty( n, result );
	//    }

	/**
	 * <b> <li>localWhereEntry ::= for identifier ( localWhereCondition ) </b>
	 */
	@Override
	public void visit(LocalWhereEntry n) {

		// get the alias on which the condition applies
		n.getidentifier().accept(this);
		String alias = (String) this.getUpProperty(n.getidentifier());

		// handle the whereClause inside the local where entry
		n.getlocalWhereCondition().accept(this);
		org.eclipse.emf.query2.WhereClause whereClause = (org.eclipse.emf.query2.WhereClause) this.getUpProperty((Node) n
				.getlocalWhereCondition());

		// transfer position info
		this.transferPositionInformation(whereClause, (Node) n.getlocalWhereCondition());

		// construct result
		org.eclipse.emf.query2.LocalWhereEntry result = new org.eclipse.emf.query2.LocalWhereEntry(alias, whereClause);

		// propagate
		this.setUpProperty(n, result);
	}

	/**
	 * <b> <li>notOpt ::= not </b>
	 */
	@Override
	public void visit(Not n) {

		// don't do anything - just check if it exists
	}

	/**
	 * <b> <li>negativeWhereCondition ::= not negativeWhereCondition </b>
	 */
	@Override
	public void visit(NotWhereCondition n) {

		n.getnegativeWhereCondition().accept(this);
		org.eclipse.emf.query2.WhereClause nestedWhereClause = (org.eclipse.emf.query2.WhereClause) this.getUpProperty((Node) n
				.getnegativeWhereCondition());

		// the result
		org.eclipse.emf.query2.WhereClause result = new WhereNot(nestedWhereClause);

		// propagate
		this.setUpProperty(n, result);
	}

	/**
	 * <b> <li>operationCondition ::= identifier operationPart </b>
	 */
	@Override
	public void visit(OperationCondition n) {

		n.getidentifier().accept(this);
		String feature = (String) this.getUpProperty(n.getidentifier());

		// move the alias downwards
		this.setDownProperty((Node) n.getoperationPart(), feature);
		n.getoperationPart().accept(this);

		// get the constructed result
		org.eclipse.emf.query2.WhereClause whereClause = (org.eclipse.emf.query2.WhereClause) this.getUpProperty((Node) n
				.getoperationPart());

		// propagate
		this.setUpProperty(n, whereClause);
	}

	/**
	 * <b> <li>operationPart ::= = literal </b>
	 */
	@Override
	public void visit(OpEqual n) {

		this.handleOperation(Operation.EQUAL, n, n.getliteral());
	}

	/**
	 * <b> <li>operationPart ::= > literal </b>
	 */
	@Override
	public void visit(OpGreater n) {

		this.handleOperation(Operation.GREATER, n, n.getliteral());
	}

	/**
	 * <b> <li>operationPart ::= >= literal </b>
	 */
	@Override
	public void visit(OpGreaterEqual n) {

		this.handleOperation(Operation.GREATEREQUAL, n, n.getliteral());
	}

	/**
	 * <b> <li>operationPart ::= like literal </b>
	 */
	@Override
	public void visit(OpLike n) {

		this.handleOperation(Operation.LIKE, n, n.getliteral());
	}

	/**
	 * <b> <li>operationPart ::= not like literal </b>
	 */
	@Override
	public void visit(NotLike n) {

		// treat it as a like first
		this.handleOperation(Operation.LIKE, n, n.getliteral());

		// wrap it in a negation
		WhereString whereString = (WhereString) this.getUpProperty(n);
		WhereNot whereNot = new WhereNot(whereString);
		this.setUpProperty(n, whereNot);
	}

	/**
	 * <b> <li>operationPart ::= <> literal </b>
	 */
	@Override
	public void visit(OpNotEqual n) {

		this.handleOperation(Operation.NOTEQUAL, n, n.getliteral());
	}

	/**
	 * <b> <li>operationPart ::= < literal </b>
	 */
	@Override
	public void visit(OpSmaller n) {

		this.handleOperation(Operation.SMALLER, n, n.getliteral());
	}

	/**
	 * <b> <li>operationPart ::= <= literal </b>
	 */
	@Override
	public void visit(OpSmallerEqual n) {

		this.handleOperation(Operation.SMALLEREQUAL, n, n.getliteral());
	}

	/**
	 * <b> <li>operationCondition ::= ( localWhereCondition ) </b>
	 */
	@Override
	public void visit(ParenthesizedLocalWhereCondition n) {

		n.getlocalWhereCondition().accept(this);
		// simply propagate
		this.setUpProperty(n, this.getUpProperty((Node) n.getlocalWhereCondition()));
	}

	/**
	 * <b> <li>whereClause ::= where whereEntry </b>
	 */
	@Override
	public void visit(WhereClause n) {

		n.getwhereEntry().accept(this);
		WhereEntry whereEntry = (WhereEntry) this.getUpProperty((Node) n.getwhereEntry());
		this.transferPositionInformation(whereEntry, n);

		// simply propagate
		this.setUpProperty(n, whereEntry);
	}

	/**
	 * <b> <li>whereClauseN ::= whereClause whereClauseN </b>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void visit(WhereClauseN n) {

		// first where clause
		n.getwhereClause().accept(this);
		WhereEntry whereEntry = (WhereEntry) this.getUpProperty(n.getwhereClause());

		// others
		n.getwhereClauseN().accept(this);
		Object o = this.getUpProperty((Node) n.getwhereClauseN());

		// result
		List<WhereEntry> result = null;
		if (o instanceof WhereEntry) {
			result = new ArrayList<WhereEntry>();
			result.add(whereEntry);
			result.add((WhereEntry) o);
		} else if (o instanceof List) {
			result = (List<WhereEntry>) o;
			result.add(0, whereEntry);
		} else {
			this.reportInternalError(n, BugMessages.ENTRY_OR_LIST_OF_ENTRY_EXPECTED, "WhereEntry"); //$NON-NLS-1$
		}

		// propagate
		this.setUpProperty(n, result);
	}

	/**
	 * <b> <li>Rule 43: localWhereCondition ::= localWhereCondition and
	 * negativeWhereCondition </b>
	 */
	@Override
	public void visit(AndWhereCondition n) {

		this.handleNaryClauses(n, n.getlocalWhereCondition(), n.getnegativeWhereCondition(), true);
	}

	/**
	 * <b> <li>localWhereCondition ::= localWhereCondition or
	 * negativeWhereCondition </b>
	 */
	@Override
	public void visit(OrWhereCondition n) {

		this.handleNaryClauses(n, n.getlocalWhereCondition(), n.getnegativeWhereCondition(), false);
	}

	/**
	 * <b> <li>joinWhereEntry ::= identifier = identifier </b>
	 */
	@Override
	public void visit(AliasComparisonClause n) {

		// left alias
		n.getidentifier().accept(this);
		String leftAlias = (String) this.getUpProperty(n.getidentifier());

		// right alias
		n.getidentifier3().accept(this);
		String rightAlias = (String) this.getUpProperty(n.getidentifier3());

		// result
		org.eclipse.emf.query2.JoinWhereEntry aliasComparison = new WhereComparisonAliases(leftAlias, rightAlias);

		// propagate
		this.setUpProperty(n, aliasComparison);
	}

	/**
	 * <b> <li>joinWhereEntry ::= identifier . navigationStep joinPart </b>
	 */
	@Override
	public void visit(JoinWhereEntry n) {

		// get the start alias and push it down into the navigation
		n.getidentifier().accept(this);
		this.setDownProperty((Node) n.getnavigationStep(), this.getUpProperty(n.getidentifier()));

		// handle navigation steps and push its result down into the joinPart
		n.getnavigationStep().accept(this);
		this.setDownProperty((Node) n.getjoinPart(), this.getUpProperty((Node) n.getnavigationStep()));

		// finally handle the join part and push the result upwards
		n.getjoinPart().accept(this);
		this.setUpProperty(n, this.getUpProperty((Node) n.getjoinPart()));
	}

	//    /**
	//     * <b> <li>navigationDisambiguationOpt ::= [ pathName ] </b>
	//     */
	//    @Override
	//    public void visit( AssocNavigation n ) {
	//
	//        // handle the path name
	//        n.getpathName( ).accept( this );
	//        Object o = this.getUpProperty( (Node) n.getpathName( ) );
	//
	//        // we only allow QualNameType. All other scenarios are not usable or
	//        // acceptable
	//        if ( !( o instanceof QualNameType ) ) {
	//            this.reportFatalError( new MQLUsageException( MQLApiMessages.ASSOC_DISAMBIGUATION_INVALID_QUAL_NAME, n.getpathName( ) ), n );
	//        }
	//
	//        this.setUpProperty( n, o );
	//    }

	//    /**
	//     * <b> <li>navigationStep ::= INTEGER_LITERAL [ identifier ] </b>
	//     */
	//    @Override
	//    public void visit( MriBasedNavigation n ) {
	//
	//        // get the numeral
	//        String numeral = n.getLeftIToken( ).toString( );
	//
	//        // get the identifier
	//        n.getidentifier( ).accept( this );
	//        String mriIdent = (String) this.getUpProperty( n.getidentifier( ) );
	//
	//        // first check if we have a MRI
	//        URI assocMRI = null;
	//        try {
	//            assocMRI = this.moin.createUri( mriIdent );
	//        } catch ( IllegalArgumentException e ) {
	//            this.reportFatalError( new MQLUsageException( MQLApiMessages.INVALID_FIXED_ELEMENT, mriIdent ), n );
	//        }
	//
	//        int assocEnd = 0;
	//        // check if the literal
	//        if ( numeral.equals( "0" ) ) { //$NON-NLS-1$
	//            assocEnd = 0;
	//        } else if ( numeral.equals( "1" ) ) { //$NON-NLS-1$
	//            assocEnd = 1;
	//        } else {
	//            this.reportError( new MQLUsageException( MQLApiMessages.ASSOC_PER_MRI_HAS_INVALID_ASSOC_END, numeral ), n );
	//        }
	//
	//        AssocMRINavigationStep step = new AssocMRINavigationStep( );
	//        step.alias = (String) this.getDownProperty( n );
	//        step.assocEnd = assocEnd;
	//        step.assocMri = assocMRI;
	//
	//        // propagate
	//        this.setUpProperty( n, step );
	//    }

	/**
	 * <b> <li>navigationStep ::= identifier navigationDisambiguationOpt </b>
	 */
	@Override
	public void visit(NameBasedNavigation n) {

		// get feature
		n.getidentifier().accept(this);
		String feature = (String) this.getUpProperty(n.getidentifier());

		// for the result
		NavigationStep step = null;

		//        if ( n.getnavigationDisambiguationOpt( ) == null ) {
		FeatureNavigationStep featureNavStep = new FeatureNavigationStep();
		featureNavStep.alias = (String) this.getDownProperty(n);
		featureNavStep.feature = feature;
		step = featureNavStep;
		//        } else {
		//            n.getnavigationDisambiguationOpt( ).accept( this );
		//            QualNameType qualNameType = (QualNameType) this.getUpProperty( n.getnavigationDisambiguationOpt( ) );
		//            AssocNavigationStep assocNavStep = new AssocNavigationStep( );
		//            assocNavStep.alias = (String) this.getDownProperty( n );
		//            assocNavStep.assocEnd = feature;
		//            assocNavStep.qualName = qualNameType;
		//            step = assocNavStep;
		//        }

		// propagate
		this.setUpProperty(n, step);
	}

	/**
	 * <b> <li>nonLinkPredicate ::= = comparisonPostElementEquals </b>
	 */
	@Override
	public void visit(AssocOrComparisonPredicate n) {

		// move the down properties
		this.setDownProperty((Node) n.getcomparisonPostElementEquals(), this.getDownProperty(n));

		// execute
		n.getcomparisonPostElementEquals().accept(this);

		// move the up properties
		this.setUpProperty(n, this.getUpProperty((Node) n.getcomparisonPostElementEquals()));
	}

	/**
	 * <b> <li>comparisonPostElementEquals ::= identifier comparisonPostFix </b>
	 */
	@Override
	public void visit(IdentifierEqualsComparisonInPredicate n) {

		// get the nav step
		NavigationStep navStep = (NavigationStep) this.getDownProperty(n);

		// get the right alias
		n.getidentifier().accept(this);
		String aliasOrFeature = (String) this.getUpProperty(n.getidentifier());

		// for the result
		org.eclipse.emf.query2.JoinWhereEntry result = null;

		if (n.getcomparisonPostFix() == null) {
			// we have an alias on the right hand side

			if (navStep instanceof FeatureNavigationStep) {
				FeatureNavigationStep featureNavStep = (FeatureNavigationStep) navStep;
				result = new WhereRelationReference(featureNavStep.alias, featureNavStep.feature, aliasOrFeature);
			} else {
				this.reportInternalError(n, BugMessages.UNEXPECTED_STEP);
			}

			// propagate
			this.setUpProperty(n, result);

		} else {
			n.getcomparisonPostFix().accept(this);
			String rightFeature = (String) this.getUpProperty(n.getcomparisonPostFix());

			// we have an attribute comparison for equality
			this.handleAttributeComparisons(navStep, n, Operation.EQUAL, aliasOrFeature, rightFeature);
		}
	}

	/**
	 * <b> <li>comparisonPostElementEquals ::= literal </b>
	 */
	@Override
	public void visit(LiteralEqualsComparisonInPredicate n) {

		this.handleLiteralComparisonInPredicate(Operation.EQUAL, n, n.getliteral());
	}

	/**
	 * Handle a comparison between an attribute and a literal, but as a naked
	 * where-clause
	 */
	private void handleLiteralComparisonInPredicate(Operation op, Node n, Iliteral literal) {

		// get the nav step, which should be FeatureNavigationStep here,
		// otherwise, we have a syntax error
		NavigationStep navStep = (NavigationStep) this.getDownProperty(n);

		String leftAlias = navStep.alias;
		String leftFeature = null;
		QualNameType assocQualName = null;

		if (navStep instanceof FeatureNavigationStep) {
			leftFeature = ((FeatureNavigationStep) navStep).feature;
		} else {
			this.reportInternalError(n, BugMessages.UNEXPECTED_STEP);
		}

		// overwrite the down property
		this.setDownProperty(n, leftFeature);

		// actually handle the operation - observe that the null literal
		// automatically leads to a string type
		// in the case of associations
		this.handleOperation(op, n, literal);

		// obtain the original up-property for the node
		org.eclipse.emf.query2.WhereClause whereClause = (org.eclipse.emf.query2.WhereClause) this.getUpProperty(n);

		// we make a distinction between a local and join where entry
		org.eclipse.emf.query2.WhereEntry whereEntry = null;

		if (assocQualName == null) {
			// we have a local where entry and we do not know if it is a
			// comparison on an attribute or an association, so we delay this
			// decision to the type checker
			whereEntry = new org.eclipse.emf.query2.LocalWhereEntry(leftAlias, whereClause);
		} else {
			// in this case, we only permit a very limited case, which is a
			// string comparison on null
			if ((whereClause instanceof WhereString) && (((WhereString) whereClause).getStringValue() == null)) {
				boolean negated = false;
				switch (((WhereString) whereClause).getOperation()) {
				case EQUAL:
					negated = true;
					break;
				case NOTEQUAL:
					negated = false;
					break;
				default:
					throw new BugException(BugMessages.EQUAL_OR_NOT_EQUAL_EXPECTED, ((WhereString) whereClause).getOperation());
				}
				whereEntry = new WhereNestedReference(negated, leftAlias, leftFeature, null);
			} else {
				this.reportFatalError(new UsageException(ApiMessages.UNEXPECTED_ASSOC_WITH_LITERAL_OP_COMPARE, leftFeature, literal,
						op), n);
			}
		}

		// this is the new up-property for the node
		this.setUpProperty(n, whereEntry);
	}

	/**
	 * <b> <li>nonLinkPredicate ::= like literal </b>
	 */
	@Override
	public void visit(ComparisonLikePredicate n) {

		this.handleLiteralComparisonInPredicate(Operation.LIKE, n, n.getliteral());
	}

	/**
	 * <b> <li>nonLinkPredicate ::= not like literal </b>
	 */
	@Override
	public void visit(ComparisonNotLikePredicate n) {

		this.handleLiteralComparisonInPredicate(Operation.LIKE, n, n.getliteral());

		// wrap it in a negation
		org.eclipse.emf.query2.LocalWhereEntry localWhereEntry = (org.eclipse.emf.query2.LocalWhereEntry) this.getUpProperty(n);
		WhereNot whereNot = new WhereNot(localWhereEntry.getNestedClause());
		org.eclipse.emf.query2.LocalWhereEntry newLocalWhereEntry = new org.eclipse.emf.query2.LocalWhereEntry(localWhereEntry
				.getLeftAlias(), whereNot);

		// reset the up-property
		this.setUpProperty(n, newLocalWhereEntry);
	}

	/**
	 * Handle a comparison between two attributes of respective aliases
	 */
	private void handleAttributeComparisons(NavigationStep step, CstNode n, Operation op, String rightAlias, String rightFeature) {

		org.eclipse.emf.query2.JoinWhereEntry result = null;

		// in this case, we only accept a FeatureNavigationStep
		if (step instanceof FeatureNavigationStep) {
			FeatureNavigationStep featureStep = (FeatureNavigationStep) step;
			result = new WhereComparisonAttrs(featureStep.alias, featureStep.feature, op, rightAlias, rightFeature);
		} else {
			this.reportFatalError(new UsageException(ApiMessages.ASSOC_DISAMBIGUATION_FOUND_AT_ATTRIBUTE_COMPARISON), n);
		}

		// propagate
		this.setUpProperty(n, result);
	}

	/**
	 * Handle Attribute comparisons for two features when not compared for
	 * equality
	 */
	private void handleAttributeComparisonsForOtherThanEqual(Ident rightAliasN, Ident rightFeatureN, CstNode n, Operation op) {

		// get the nav step
		NavigationStep step = (NavigationStep) this.getDownProperty(n);

		// right alias
		rightAliasN.accept(this);
		String rightAlias = (String) this.getUpProperty(rightAliasN);

		// right feature
		rightFeatureN.accept(this);
		String rightFeature = (String) this.getUpProperty(rightFeatureN);

		this.handleAttributeComparisons(step, n, op, rightAlias, rightFeature);
	}

	/**
	 * <b> <li>comparisonPostElementOtherOperation ::= identifier . identifier
	 * </b>
	 */
	@Override
	public void visit(IdentifierComparisonInPredicate n) {

		Operation op = (Operation) this.getDownProperty(n, OPERATION_TAG);
		this.handleAttributeComparisonsForOtherThanEqual(n.getidentifier(), n.getidentifier3(), n, op);
	}

	/**
	 * <b> <li>comparisonPostElementOtherOperation ::= literal </b>
	 */
	@Override
	public void visit(LiteralComparisonInPredicate n) {

		Operation op = (Operation) this.getDownProperty(n, OPERATION_TAG);
		this.handleLiteralComparisonInPredicate(op, n, n.getliteral());
	}

	/**
	 * <b> <li>nonLinkPredicate ::= >= comparisonPostElementOtherOperation </b>
	 */
	@Override
	public void visit(ComparisonGreaterEqualPredicate n) {

		// set the down properties
		this.setDownProperty((Node) n.getcomparisonPostElementOtherOperation(), OPERATION_TAG, Operation.GREATEREQUAL);
		this.setDownProperty((Node) n.getcomparisonPostElementOtherOperation(), this.getDownProperty(n));

		// do it
		n.getcomparisonPostElementOtherOperation().accept(this);

		// set the up property
		this.setUpProperty(n, this.getUpProperty((Node) n.getcomparisonPostElementOtherOperation()));
	}

	/**
	 * <b> <li>nonLinkPredicate ::= > comparisonPostElementOtherOperation </b>
	 */
	@Override
	public void visit(ComparisonGreaterPredicate n) {

		// set the down properties
		this.setDownProperty((Node) n.getcomparisonPostElementOtherOperation(), OPERATION_TAG, Operation.GREATER);
		this.setDownProperty((Node) n.getcomparisonPostElementOtherOperation(), this.getDownProperty(n));

		// do it
		n.getcomparisonPostElementOtherOperation().accept(this);

		// set the up property
		this.setUpProperty(n, this.getUpProperty((Node) n.getcomparisonPostElementOtherOperation()));
	}

	/**
	 * <b> <li>nonLinkPredicate ::= <> comparisonPostElementOtherOperation </b>
	 */
	@Override
	public void visit(ComparisonNotEqualPredicate n) {

		// set the down properties
		this.setDownProperty((Node) n.getcomparisonPostElementOtherOperation(), OPERATION_TAG, Operation.NOTEQUAL);
		this.setDownProperty((Node) n.getcomparisonPostElementOtherOperation(), this.getDownProperty(n));

		// do it
		n.getcomparisonPostElementOtherOperation().accept(this);

		// set the up property
		this.setUpProperty(n, this.getUpProperty((Node) n.getcomparisonPostElementOtherOperation()));
	}

	/**
	 * <b> <li>nonLinkPredicate ::= <= comparisonPostElementOtherOperation </b>
	 */
	@Override
	public void visit(ComparisonSmallerEqualPredicate n) {

		// set the down properties
		this.setDownProperty((Node) n.getcomparisonPostElementOtherOperation(), OPERATION_TAG, Operation.SMALLEREQUAL);
		this.setDownProperty((Node) n.getcomparisonPostElementOtherOperation(), this.getDownProperty(n));

		// do it
		n.getcomparisonPostElementOtherOperation().accept(this);

		// set the up property
		this.setUpProperty(n, this.getUpProperty((Node) n.getcomparisonPostElementOtherOperation()));
	}

	/**
	 * <b> <li>nonLinkPredicate ::= < comparisonPostElementOtherOperation </b>
	 */
	@Override
	public void visit(ComparisonSmallerPredicate n) {

		// set the down properties
		this.setDownProperty((Node) n.getcomparisonPostElementOtherOperation(), OPERATION_TAG, Operation.SMALLER);
		this.setDownProperty((Node) n.getcomparisonPostElementOtherOperation(), this.getDownProperty(n));

		// do it
		n.getcomparisonPostElementOtherOperation().accept(this);

		// set the up property
		this.setUpProperty(n, this.getUpProperty((Node) n.getcomparisonPostElementOtherOperation()));
	}

	/**
	 * <b> <li>comparisonPostFix ::= . identifier </b>
	 */
	@Override
	public void visit(ComparisonPredicate n) {

		// simply propagates
		n.getidentifier().accept(this);
		this.setUpProperty(n, this.getUpProperty(n.getidentifier()));
	}

	/**
	 * <b> <li>joinPart ::= notOpt in ( query ) </b>
	 */
	@Override
	public void visit(LinkPredicate n) {

		// obtain the navigation info
		NavigationStep navStep = (NavigationStep) this.getDownProperty(n);

		// is this query negated?
		boolean negated = n.getnotOpt() != null;

		// make sure we inform that we are dealing with a nested query here
		this.setDownProperty(n.getquery(), NESTED_TAG, true);
		n.getquery().accept(this);

		// obtain the result
		Query nestedQuery = (Query) this.getUpProperty(n.getquery());

		// construct result
		WhereNestedReference result = null;

		if (navStep instanceof FeatureNavigationStep) {
			FeatureNavigationStep featureNavStep = (FeatureNavigationStep) navStep;
			result = new WhereNestedReference(negated, featureNavStep.alias, featureNavStep.feature, nestedQuery);
		} else {
			this.reportInternalError(n, BugMessages.UNEXPECTED_STEP);
		}

		// propagate
		this.setUpProperty(n, result);
	}

	/**
	 * <b> <li>identifier ::= IDENTIFIER </b>
	 */
	@Override
	public void visit(Ident n) {

		String identifier = n.getIToken().toString();
		identifier = this.processIdentifier(identifier);

		this.setUpProperty(n, identifier);
	}

	/**
	 * <b> <li>identifierN ::= identifier , identifierN </b>
	 */
	@Override
	public void visit(IdentifierN n) {

		IdentifierN rollingN = n;

		List<IdentifierAndNode> result = new ArrayList<IdentifierAndNode>();

		IdentifierAndNode identNode = new IdentifierAndNode();
		identNode.identifier = rollingN.getidentifier().toString();
		identNode.identifier = this.processIdentifier(identNode.identifier);

		identNode.node = rollingN.getidentifier();

		result.add(identNode);

		for (;;) {
			IidentifierN identN = rollingN.getidentifierN();

			if (identN instanceof Ident) {
				Ident literal = (Ident) identN;

				identNode = new IdentifierAndNode();
				identNode.identifier = literal.toString();
				identNode.identifier = this.processIdentifier(identNode.identifier);

				identNode.node = literal;

				result.add(identNode);

				break;
			} else if (identN instanceof IdentifierN) {

				IdentifierN nextN = (IdentifierN) identN;

				identNode = new IdentifierAndNode();
				identNode.identifier = nextN.getidentifier().toString();
				identNode.identifier = this.processIdentifier(identNode.identifier);
				identNode.node = nextN.getidentifier();
				result.add(identNode);

				rollingN = (IdentifierN) identN;
			} else {
				throw new IllegalStateException();
			}

		}

		this.setUpProperty(n, result);
	}

	/**
	 * <b> <li>sPathName ::= identifier </b>
	 */
	@Override
	public void visit(PathNameIdent n) {

		// get the identifier
		n.getidentifier().accept(this);
		String ident = (String) this.getUpProperty(n.getidentifier());

		// for the result
		ParsedIdentifier parsedId = null;

		// try to parse this into a MRI
		try {
			URI mri = this.moin.createUri(ident);

			// worked alright, set it as foundMri
			parsedId = new FoundMri();
			((FoundMri) parsedId).mri = mri;
			// } catch ( InvalidResourceIdentifierException e ) {
		} catch (IllegalArgumentException e) {
			// did not work, keep the identifier
			NoMri noMri = new NoMri();
			noMri.errorMessageForMriParse = e.getLocalizedMessage();
			noMri.foundIdentifier = ident;
			parsedId = noMri;
		}

		// propagate the result
		this.setUpProperty(n, parsedId);
	}

	//    /**
	//     * <b> <li>sPathName ::= identifier :: sPathName </b>
	//     */
	//    @Override
	//    public void visit( PathNames n ) {
	//
	//        // get the first identifier
	//        n.getidentifier( ).accept( this );
	//        String ident = (String) this.getUpProperty( n.getidentifier( ) );
	//
	//        // get the path name behind it
	//        n.getsPathName( ).accept( this );
	//        Object o = this.getUpProperty( (Node) n.getsPathName( ) );
	//
	//        // for the result
	//        TypeClause typeClause = null;
	//
	//        if ( o instanceof QualNameType ) {
	//            // we already saw a qual name, so extend it
	//            QualNameType qualNameType = (QualNameType) o;
	//            qualNameType.qualifiedMofName.add( 0, ident );
	//            typeClause = qualNameType;
	//
	//        } else if ( o instanceof ParsedIdentifier ) {
	//            // here we distinguish between a found URI and something else
	//            if ( o instanceof NoMri ) {
	//                // this is ok, set the data
	//                QualNameType qualNameType = new QualNameType( );
	//                qualNameType.qualifiedMofName = new ArrayList<String>( );
	//                qualNameType.qualifiedMofName.add( 0, ident );
	//                qualNameType.qualifiedMofName.add( 1, ( (NoMri) o ).foundIdentifier );
	//                typeClause = qualNameType;
	//            } else if ( o instanceof FoundMri ) {
	//                // no good
	//                URI mri = ( (FoundMri) o ).mri;
	//                typeClause = new MriElement( );
	//                ( (MriElement) typeClause ).mri = mri;
	//                this.reportError( new MQLUsageException( MQLApiMessages.MRI_IN_PATH, mri ), n );
	//            }
	//        } else if ( o instanceof MriElement ) {
	//            // just propagate
	//        } else {
	//            this.reportInternalError( n, MQLBugMessages.EXPECT_QUALNAMETYPE_MRIELEMENT_PARSEDIDENTIFIER );
	//        }
	//
	//        // propagate
	//        this.setUpProperty( n, typeClause );
	//
	//    }

	//    /**
	//     * <b> <li>identifierWithOptContainerPrefix ::= identifier # sPathName </b>
	//     */
	//    @Override
	//    public void visit( ContainerNamePrefix n ) {
	//
	//        // get the container name
	//        n.getidentifier( ).accept( this );
	//        String containerName = (String) this.getUpProperty( n.getidentifier( ) );
	//
	//        // get the path name
	//        n.getsPathName( ).accept( this );
	//        Object o = this.getUpProperty( (Node) n.getsPathName( ) );
	//
	//        TypeClause typeClause = null;
	//        if ( o instanceof ParsedIdentifier ) {
	//            // this is never allowed
	//            if ( o instanceof NoMri ) {
	//                // we saw only one identifier, which is not a full path
	//                this.reportFatalError( new MQLUsageException( MQLApiMessages.CONTAINER_QUAL_EXPECTS_QUALIFIED_NAME, ( (NoMri) o ).foundIdentifier ), ( (Node) n.getsPathName( ) ) );
	//            } else if ( o instanceof FoundMri ) {
	//                // we found a MRI
	//                typeClause = new MriElement( );
	//                ( (MriElement) typeClause ).mri = ( (FoundMri) o ).mri;
	//                this.reportError( new MQLUsageException( MQLApiMessages.FIXED_MRI_ELEMENT_WITH_CONTAINER ), n );
	//            } else {
	//                this.reportInternalError( n, MQLBugMessages.EXPECT_FOUNDMRI_NOMRI );
	//            }
	//        } else if ( o instanceof QualNameType ) {
	//            // this is what we expect
	//            typeClause = (QualNameType) o;
	//            ( (QualNameType) typeClause ).containerName = containerName;
	//        } else if ( o instanceof MriElement ) {
	//            // just propagate
	//        } else {
	//            this.reportInternalError( n, MQLBugMessages.EXPECT_QUALNAMETYPE_MRIELEMENT_PARSEDIDENTIFIER );
	//        }
	//
	//        // propagate
	//        this.setUpProperty( n, typeClause );
	//    }

	/**
	 * <b> <li>literal ::= STRING_LITERAL </b>
	 */
	@Override
	public void visit(StringLiteral n) {

		String literal = n.getIToken().toString();
		// escape the string literal
		literal = this.processString(literal);
		this.setUpProperty(n, literal);
	}

	/**
	 * <b> <li>literal ::= INTEGER_LITERAL </b>
	 */
	@Override
	public void visit(IntegerLiteral n) {

		String integerLiteral = n.getIToken().toString();

		// result
		Number result = null;

		// try to parse as integer
		try {
			result = Integer.parseInt(integerLiteral);
		} catch (NumberFormatException e) {
			// try as long

			try {
				result = Long.parseLong(integerLiteral);
			} catch (NumberFormatException e2) {
				this.reportInternalError(n, BugMessages.PARSING_OF_INT_FAILED, integerLiteral);
			}

		}

		// propagate
		this.setUpProperty(n, result);
	}

	/**
	 * <b> <li>literal ::= REAL_LITERAL </b>
	 */
	@Override
	public void visit(RealLiteral n) {

		String floatLiteral = n.getIToken().toString();

		// result
		Number result = null;

		// // try to parse as float
		// try {
		// result = Float.parseFloat( floatLiteral );
		// } catch ( NumberFormatException e ) {
		// try as long

		try {
			result = Double.parseDouble(floatLiteral);
		} catch (NumberFormatException e2) {
			this.reportInternalError(n, BugMessages.PARSING_OF_REAL_FAILED, floatLiteral);
		}
		// }

		// propagate
		this.setUpProperty(n, result);
	}

	@Override
	public void visit(NullLiteral n) {

		// we set an object of a type which other literals cannot produce
		this.setUpProperty(n, new ArrayList<Object>(0));
	}

	/**
	 * <b> <li>literal ::= true </b>
	 */
	@Override
	public void visit(TrueLiteral n) {

		this.setUpProperty(n, true);
	}

	/**
	 * <b> <li>literal ::= false </b>
	 */
	@Override
	public void visit(FalseLiteral n) {

		this.setUpProperty(n, false);
	}

}

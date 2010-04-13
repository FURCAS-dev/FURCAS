package org.eclipse.emf.query2.transformation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query2.FromEntry;
import org.eclipse.emf.query2.FromFixedSet;
import org.eclipse.emf.query2.FromType;
import org.eclipse.emf.query2.LocalWhereEntry;
import org.eclipse.emf.query2.Operation;
import org.eclipse.emf.query2.Query;
import org.eclipse.emf.query2.SelectAlias;
import org.eclipse.emf.query2.SelectAttrs;
import org.eclipse.emf.query2.SelectEntry;
import org.eclipse.emf.query2.TypeScopeProvider;
import org.eclipse.emf.query2.WhereAnd;
import org.eclipse.emf.query2.WhereBool;
import org.eclipse.emf.query2.WhereClause;
import org.eclipse.emf.query2.WhereComparisonAliases;
import org.eclipse.emf.query2.WhereComparisonAttrs;
import org.eclipse.emf.query2.WhereDouble;
import org.eclipse.emf.query2.WhereEntry;
import org.eclipse.emf.query2.WhereLong;
import org.eclipse.emf.query2.WhereNestedReference;
import org.eclipse.emf.query2.WhereOr;
import org.eclipse.emf.query2.WhereRelationReference;
import org.eclipse.emf.query2.WhereString;
import org.eclipse.emf.query2.query.AliasAttributeExpression;
import org.eclipse.emf.query2.query.AndWhereEntry;
import org.eclipse.emf.query2.query.BooleanExpression;
import org.eclipse.emf.query2.query.DoubleExpression;
import org.eclipse.emf.query2.query.ElementScope;
import org.eclipse.emf.query2.query.Expression;
import org.eclipse.emf.query2.query.ExpressionWhereEntry;
import org.eclipse.emf.query2.query.LongExpression;
import org.eclipse.emf.query2.query.MQLquery;
import org.eclipse.emf.query2.query.NullExpression;
import org.eclipse.emf.query2.query.Operator;
import org.eclipse.emf.query2.query.OrWhereEntry;
import org.eclipse.emf.query2.query.QueryExpression;
import org.eclipse.emf.query2.query.ResourceScope;
import org.eclipse.emf.query2.query.StringExpression;
import org.eclipse.emf.query2.query.util.QuerySwitch;

public class QueryTransformer {

	private static final URI[] URI_ARRAY = new URI[0];

	public static Query transform(MQLquery query) {
		List<SelectEntry> selectEntries = transformSelect(query.getSelectEntries());
		List<FromEntry> fromEntries = transformFrom(query.getFromEntries());
		List<WhereEntry> whereEntries = transformWhere(query.getWhereEntry());

		return new Query(selectEntries, fromEntries, whereEntries);

	}

	private static List<SelectEntry> transformSelect(EList<org.eclipse.emf.query2.query.SelectEntry> selectEntries) {
		List<SelectEntry> result = new ArrayList<SelectEntry>(selectEntries.size());

		for (org.eclipse.emf.query2.query.SelectEntry entry : selectEntries) {
			String alias = entry.getSelect().getAlias();
			if (entry.getAttribute() == null) {
				result.add(new SelectAlias(alias));
			} else {
				result.add(new SelectAttrs(alias, new String[] { entry.getAttribute().getName() }));
			}
		}
		return result;
	}

	private static List<FromEntry> transformFrom(EList<org.eclipse.emf.query2.query.FromEntry> fromEntries) {
		List<FromEntry> result = new ArrayList<FromEntry>(fromEntries.size());
		for (org.eclipse.emf.query2.query.FromEntry entry : fromEntries) {
			if (entry.getScopeClause() instanceof ElementScope) {
				ElementScope es = (ElementScope) entry.getScopeClause();
				result.add(new FromFixedSet(entry.getAlias(), EcoreUtil.getURI(entry.getType()), es.getUris().toArray(URI_ARRAY)));
			} else {
				final ResourceScope es = (ResourceScope) entry.getScopeClause();
				EList<EClass> withoutsubtypes = entry.getWithoutsubtypesTypes();
				FromType from = new FromType(entry.getAlias(), EcoreUtil.getURI(entry.getType()), entry.isWithoutsubtypes(),
						new TypeScopeProvider() {

							@Override
							public boolean isInclusiveScope() {
								return es == null ? false : !es.isNotIn();
							}

							@Override
							public URI[] getPartitionScope() {
								if (es == null) {
									return new URI[0];
								}
								URI[] result = new URI[es.getUris().size()];
								int i = 0;
								for (String uri : es.getUris()) {
									result[i] = URI.createURI(uri);
									i++;
								}
								return result;
							}
						});
				if (withoutsubtypes.size() != 0) {
					Set<URI> uris = new HashSet<URI>(withoutsubtypes.size());
					for (EClass cls : withoutsubtypes) {
						uris.add(EcoreUtil.getURI(cls));
					}
					from.setWithoutSubtypeSet(uris);
				}

				result.add(from);
			}
		}
		return result;
	}

	private static List<WhereEntry> transformWhere(org.eclipse.emf.query2.query.WhereEntry whereEntry) {
		if (whereEntry == null)
			return Collections.emptyList();
		WhereEntryTransformer whereEntryTransformer = new WhereEntryTransformer();
		return whereEntryTransformer.doSwitch(whereEntry);
	}

	private static class WhereEntryTransformer extends QuerySwitch<List<WhereEntry>> {

		@Override
		public List<WhereEntry> caseAndWhereEntry(AndWhereEntry object) {
			List<WhereEntry> result = new ArrayList<WhereEntry>();
			for (org.eclipse.emf.query2.query.WhereEntry entry : object.getEntries()) {
				result.addAll(doSwitch(entry));
			}
			return result;
		}

		@Override
		public List<WhereEntry> caseExpressionWhereEntry(ExpressionWhereEntry object) {
			Expression rhs = object.getRhs();
			AliasAttributeExpression lhs = object.getLhs();
			String alias = lhs.getAlias().getAlias();
			if (rhs instanceof AliasAttributeExpression && lhs.getAttribute() == null
					&& ((AliasAttributeExpression) rhs).getAttribute() == null) {
				return toList(new WhereComparisonAliases(alias, ((AliasAttributeExpression) rhs).getAlias().getAlias()));
			}
			String name = lhs.getAttribute().getName();
			if (rhs instanceof AliasAttributeExpression) {
				AliasAttributeExpression aae = (AliasAttributeExpression) rhs;
				if (aae.getAttribute() != null) {
					return toList(new WhereComparisonAttrs(alias, name, getOperation(object.getOperator()), aae.getAlias().getAlias(), aae
							.getAttribute().getName()));
				} else {
					return toList(new WhereRelationReference(alias, name, aae.getAlias().getAlias()));
				}
			}
			if (rhs instanceof BooleanExpression) {
				BooleanExpression be = (BooleanExpression) rhs;
				return createWhereEntry(lhs, new WhereBool(name, be.isTrue()));

			}
			if (rhs instanceof StringExpression) {
				return createWhereEntry(lhs, new WhereString(name, getOperation(object.getOperator()), ((StringExpression) object.getRhs())
						.getValue()));

			}
			if (rhs instanceof LongExpression) {
				return createWhereEntry(lhs, new WhereLong(name, getOperation(object.getOperator()), ((LongExpression) object.getRhs()).getValue()));
			}
			if (rhs instanceof DoubleExpression) {
				return createWhereEntry(lhs, new WhereDouble(name, getOperation(object.getOperator()), ((DoubleExpression) object)
						.getValue()));
			}
			if (rhs instanceof NullExpression) {
				return toList(new LocalWhereEntry(alias, new WhereString(name, getOperation(object.getOperator()), null)));
			}
			if (rhs instanceof QueryExpression) {
				Query query = QueryTransformer.transform(((QueryExpression) rhs).getValue());
				return toList(new WhereNestedReference(object.getOperator() == Operator.NOT_IN, alias, name, query));
			}

			throw new IllegalArgumentException(object.getRhs().getClass() + " is unknown");
		}

		@Override
		public List<WhereEntry> caseOrWhereEntry(OrWhereEntry object) {
			List<WhereClause> result = new ArrayList<WhereClause>();
			for (org.eclipse.emf.query2.query.WhereEntry entry : object.getEntries()) {
				result.add(new WhereClauseTransformer().doSwitch(entry));
			}
			String alias = findAlias(object);
			return toList(new LocalWhereEntry(alias, new WhereOr(result)));
		}

		private String findAlias(org.eclipse.emf.query2.query.WhereEntry object) {
			if (object instanceof ExpressionWhereEntry) {
				return ((ExpressionWhereEntry) object).getLhs().getAlias().getAlias();
			}
			if (object instanceof AndWhereEntry) {
				return findAlias(((AndWhereEntry) object).getEntries().get(0));
			} else {
				return findAlias(((OrWhereEntry) object).getEntries().get(0));
			}
		}

		private List<WhereEntry> createWhereEntry(AliasAttributeExpression object, WhereClause whereClause) {
			return toList(new LocalWhereEntry(object.getAlias().getAlias(), whereClause));
		}

		private List<WhereEntry> toList(WhereEntry entry) {
			return Collections.<WhereEntry> singletonList(entry);
		}
	}
	
	private static Operation getOperation(Operator operator) {
		switch (operator) {
		case EQUAL:
			return Operation.EQUAL;
		case NOT_EQUAL:
			return Operation.NOTEQUAL;
		case GREATER_EQUAL:
			return Operation.GREATEREQUAL;
		case GREATER_THEN:
			return Operation.GREATER;
		case LESS_EQUAL:
			return Operation.SMALLEREQUAL;
		case LESS_THEN:
			return Operation.SMALLER;
		case LIKE:
			return Operation.LIKE;
			// case NOT_LIKE:
			// return Operation.NOT_LIKE;
		}

		throw new IllegalArgumentException("unexpected operator: " + operator.toString());
	}

	private static class WhereClauseTransformer extends QuerySwitch<WhereClause> {

		@Override
		public WhereClause caseExpressionWhereEntry(ExpressionWhereEntry object) {

			Expression rhs = object.getRhs();
			AliasAttributeExpression lhs = object.getLhs();
			String name = lhs.getAttribute().getName();
			if (rhs instanceof BooleanExpression) {
				return new WhereBool(name, ((BooleanExpression) rhs).isTrue());
			}
			if (rhs instanceof StringExpression) {
				return new WhereString(name, getOperation(object.getOperator()), ((StringExpression) rhs).getValue());

			}
			if (rhs instanceof LongExpression) {
				return new WhereLong(name, getOperation(object.getOperator()), ((LongExpression) rhs).getValue());
			}
			if (rhs instanceof DoubleExpression) {
				return new WhereDouble(name, getOperation(object.getOperator()), ((DoubleExpression) rhs).getValue());
			}
			// TODO Auto-generated method stub
			return super.caseExpressionWhereEntry(object);
		}

		@Override
		public WhereClause caseAndWhereEntry(AndWhereEntry object) {
			List<WhereClause> nestedClauses = new ArrayList<WhereClause>(object.getEntries().size());
			for (org.eclipse.emf.query2.query.WhereEntry entry : object.getEntries()) {
				nestedClauses.add(doSwitch(entry));
			}
			return new WhereAnd(nestedClauses);
		}

		@Override
		public WhereClause caseOrWhereEntry(OrWhereEntry object) {
			List<WhereClause> nestedClauses = new ArrayList<WhereClause>(object.getEntries().size());
			for (org.eclipse.emf.query2.query.WhereEntry entry : object.getEntries()) {
				nestedClauses.add(doSwitch(entry));
			}
			return new WhereOr(nestedClauses);
		}
	}

}

package org.eclipse.emf.query2.transformation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
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
import org.eclipse.emf.query2.query.AbstractAliasWhereEntry;
import org.eclipse.emf.query2.query.AliasWhereEntry;
import org.eclipse.emf.query2.query.AndWhereEntry;
import org.eclipse.emf.query2.query.AttributeWhereEntry;
import org.eclipse.emf.query2.query.BooleanAttributeWhereEntry;
import org.eclipse.emf.query2.query.BooleanOperator;
import org.eclipse.emf.query2.query.DoubleWhereEntry;
import org.eclipse.emf.query2.query.ElementScope;
import org.eclipse.emf.query2.query.LongWhereEntry;
import org.eclipse.emf.query2.query.MQLquery;
import org.eclipse.emf.query2.query.NullWhereEntry;
import org.eclipse.emf.query2.query.NumericOperator;
import org.eclipse.emf.query2.query.OrWhereEntry;
import org.eclipse.emf.query2.query.ReferenceAliasWhereEntry;
import org.eclipse.emf.query2.query.ResourceScope;
import org.eclipse.emf.query2.query.StringAttributeWhereEntry;
import org.eclipse.emf.query2.query.StringOperator;
import org.eclipse.emf.query2.query.SubselectWhereEntry;
import org.eclipse.emf.query2.query.VariableWhereEntry;
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
		Map<String, ArrayList<String>> map = new LinkedHashMap<String, ArrayList<String>>();
		for (org.eclipse.emf.query2.query.SelectEntry entry : selectEntries) {
			String alias = entry.getSelect().getAlias();
			if (entry.getAttribute() != null) {
				ArrayList<String> attributeNames;
				if ((attributeNames = map.get(alias)) == null) {
					attributeNames = new ArrayList<String>();
					map.put(alias, attributeNames);
				}
				attributeNames.add(entry.getAttribute().getName());
			}
		}
		for (org.eclipse.emf.query2.query.SelectEntry entry : selectEntries) {
			String alias = entry.getSelect().getAlias();
			if (entry.getAttribute() == null) {
				result.add(new SelectAlias(alias));
			} else {
				result.add(new SelectAttrs(alias, map.get(alias)));
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
				result.add(new FromType(entry.getAlias(), EcoreUtil.getURI(entry.getType()), entry.isWithoutsubtypes(),
						new TypeScopeProvider() {

							@Override
							public boolean isInclusiveScope() {
								return !es.isNotIn();
							}

							@Override
							public URI[] getPartitionScope() {
								URI[] result = new URI[es.getUris().size()];
								int i = 0;
								for (String uri : es.getUris()) {
									result[i] = URI.createURI(uri);
									i++;
								}
								return result;
							}
						}));
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
		public List<WhereEntry> caseBooleanAttributeWhereEntry(BooleanAttributeWhereEntry object) {
			return createWhereEntry(object, new WhereBool(object.getAttribute().getName(), object.isIsTrue()));
		}

		@Override
		public List<WhereEntry> caseStringAttributeWhereEntry(StringAttributeWhereEntry object) {
			return createWhereEntry(object, new WhereString(object.getAttribute().getName(), getOperation(object.getOperator()), object
					.getPattern()));
		}

		@Override
		public List<WhereEntry> caseLongWhereEntry(LongWhereEntry object) {
			return createWhereEntry(object, new WhereLong(object.getAttribute().getName(), getOperation(object.getOperator()), object
					.getValue()));
		}

		@Override
		public List<WhereEntry> caseDoubleWhereEntry(DoubleWhereEntry object) {
			return createWhereEntry(object, new WhereDouble(object.getAttribute().getName(), getOperation(object.getOperator()), object
					.getValue()));
		}

		@Override
		public List<WhereEntry> caseVariableWhereEntry(VariableWhereEntry object) {
			return toList(new WhereComparisonAttrs(object.getAlias().getAlias(), object.getAttribute().getName(), getOperation(object
					.getOperator()), object.getRightAlias().getAlias(), object.getRightAttribute().getName()));
		}

		@Override
		public List<WhereEntry> caseNullWhereEntry(NullWhereEntry object) {
			return toList(new LocalWhereEntry(object.getAlias().getAlias(), new WhereString(object.getFeature().getName(),
					getOperation(object.getOperator()), null)));
		}

		@Override
		public List<WhereEntry> caseReferenceAliasWhereEntry(ReferenceAliasWhereEntry object) {
			return toList(new WhereRelationReference(object.getAlias().getAlias(), object.getReference().getName(), object.getRightAlias()
					.getAlias()));
		}

		@Override
		public List<WhereEntry> caseSubselectWhereEntry(SubselectWhereEntry object) {
			Query query = QueryTransformer.transform(object.getSubQuery());
			return toList(new WhereNestedReference(object.isNotIn(), object.getAlias().getAlias(), object.getReference().getName(), query));

		}

		@Override
		public List<WhereEntry> caseAliasWhereEntry(AliasWhereEntry object) {
			return toList(new WhereComparisonAliases(object.getAlias().getAlias(), object.getRightAlias().getAlias()));
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
			if (object instanceof AbstractAliasWhereEntry) {
				return ((AbstractAliasWhereEntry) object).getAlias().getAlias();
			}
			if (object instanceof AndWhereEntry) {
				return findAlias(((AndWhereEntry) object).getEntries().get(0));
			} else {
				return findAlias(((OrWhereEntry) object).getEntries().get(0));
			}
		}

		private Operation getOperation(BooleanOperator operator) {
			switch (operator) {
			case EQUAL:
				return Operation.EQUAL;
			case NOT_EQUAL:
				return Operation.NOTEQUAL;
			}
			throw new IllegalArgumentException("unexpected operator: " + operator.toString());
		}

		private Operation getOperation(NumericOperator operator) {
			switch (operator) {
			case EQUAL:
				return Operation.EQUAL;
			case GREATER_EQUAL:
				return Operation.GREATEREQUAL;
			case GREATER_THEN:
				return Operation.GREATER;
			case LESS_EQUAL:
				return Operation.SMALLEREQUAL;
			case LESS_THEN:
				return Operation.SMALLER;
			case NOT_EQUAL:
				return Operation.NOTEQUAL;
			}
			throw new IllegalArgumentException("unexpected operator: " + operator.toString());
		}

		private List<WhereEntry> createWhereEntry(AttributeWhereEntry object, WhereClause whereClause) {
			return toList(new LocalWhereEntry(object.getAlias().getAlias(), whereClause));
		}

		private Operation getOperation(StringOperator operator) {
			switch (operator) {
			case EQUAL:
				return Operation.EQUAL;
			case LIKE:
				return Operation.LIKE;
			case NOT_EQUAL:
				return Operation.NOTEQUAL;
			default:
				throw new UnsupportedOperationException(operator.toString() + " not yet implemented");
			}
		}

		private List<WhereEntry> toList(WhereEntry entry) {
			return Collections.<WhereEntry> singletonList(entry);
		}
	}

	private static class WhereClauseTransformer extends QuerySwitch<WhereClause> {

		@Override
		public WhereClause caseBooleanAttributeWhereEntry(BooleanAttributeWhereEntry object) {
			return new WhereBool(object.getAttribute().getName(), object.isIsTrue());
		}

		@Override
		public WhereClause caseStringAttributeWhereEntry(StringAttributeWhereEntry object) {
			return new WhereString(object.getAttribute().getName(), getOperation(object.getOperator()), object.getPattern());
		}

		@Override
		public WhereClause caseLongWhereEntry(LongWhereEntry object) {
			return new WhereLong(object.getAttribute().getName(), getOperation(object.getOperator()), object.getValue());
		}

		@Override
		public WhereClause caseDoubleWhereEntry(DoubleWhereEntry object) {
			return new WhereDouble(object.getAttribute().getName(), getOperation(object.getOperator()), object.getValue());
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

		
		private Operation getOperation(NumericOperator operator) {
			switch (operator) {
			case EQUAL:
				return Operation.EQUAL;
			case GREATER_EQUAL:
				return Operation.GREATEREQUAL;
			case GREATER_THEN:
				return Operation.GREATER;
			case LESS_EQUAL:
				return Operation.SMALLEREQUAL;
			case LESS_THEN:
				return Operation.SMALLER;
			case NOT_EQUAL:
				return Operation.NOTEQUAL;
			}
			throw new IllegalArgumentException("unexpected operator: " + operator.toString());
		}

		private Operation getOperation(StringOperator operator) {
			switch (operator) {
			case EQUAL:
				return Operation.EQUAL;
			case LIKE:
				return Operation.LIKE;
			case NOT_EQUAL:
				return Operation.NOTEQUAL;
			default:
				throw new UnsupportedOperationException(operator.toString() + " not yet implemented");
			}
		}

	}

}

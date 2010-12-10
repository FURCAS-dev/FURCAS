package org.eclipse.emf.query2.syntax.validation;

import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage.Literals;
import org.eclipse.emf.query2.syntax.query.AliasAttributeExpression;
import org.eclipse.emf.query2.syntax.query.BooleanExpression;
import org.eclipse.emf.query2.syntax.query.DoubleExpression;
import org.eclipse.emf.query2.syntax.query.Expression;
import org.eclipse.emf.query2.syntax.query.ExpressionWhereEntry;
import org.eclipse.emf.query2.syntax.query.FromEntry;
import org.eclipse.emf.query2.syntax.query.LongExpression;
import org.eclipse.emf.query2.syntax.query.MQLquery;
import org.eclipse.emf.query2.syntax.query.NullExpression;
import org.eclipse.emf.query2.syntax.query.Operator;
import org.eclipse.emf.query2.syntax.query.OrWhereEntry;
import org.eclipse.emf.query2.syntax.query.QueryExpression;
import org.eclipse.emf.query2.syntax.query.QueryPackage;
import org.eclipse.emf.query2.syntax.query.SelectEntry;
import org.eclipse.emf.query2.syntax.query.StringExpression;
import org.eclipse.emf.query2.syntax.validation.AbstractQueryJavaValidator;
import org.eclipse.xtext.validation.Check;

public class QueryJavaValidator extends AbstractQueryJavaValidator {

	@Check
	public void checkOperatorAndType(ExpressionWhereEntry entry) {
		EStructuralFeature lhsAttribute = entry.getLhs().getAttribute();
		Operator operator = entry.getOperator();
		Expression rhs = entry.getRhs();

		if (lhsAttribute == null) {
			if (operator != Operator.EQUAL) {
				error("Only '=' operator allowed if no attribute or reference is specified on left hand side",
						QueryPackage.EXPRESSION_WHERE_ENTRY__OPERATOR);
			}
		}

		else if (lhsAttribute instanceof EReference) {
			if (rhs instanceof NullExpression) {
				if (operator != Operator.EQUAL && operator != Operator.NOT_EQUAL) {
					error("Only '=' or '!=' is allowed as operator if 'null' is specified on the right side",
							QueryPackage.EXPRESSION_WHERE_ENTRY__OPERATOR);
				}
			} else if (rhs instanceof AliasAttributeExpression && ((AliasAttributeExpression) rhs).getAttribute() == null) {
				if (operator != Operator.EQUAL && operator != Operator.NOT_EQUAL) {
					error("Only '=' or '!=' is allowed as operator if an alias is specified on the right side",
							QueryPackage.EXPRESSION_WHERE_ENTRY__OPERATOR);
				}
			} else if (rhs instanceof QueryExpression) {
				if (operator != Operator.IN && operator != Operator.NOT_IN) {
					error("Only 'in' or 'not in' is allowed as operator for subqueries on the right side",
							QueryPackage.EXPRESSION_WHERE_ENTRY__OPERATOR);
				}
				MQLquery query = ((QueryExpression) rhs).getValue();
				SelectEntry selectEntry = query.getSelectEntries().get(0);
				EClassifier type = selectEntry.getAttribute() == null ? selectEntry.getSelect().getType() : selectEntry.getAttribute().getEType();
				if (type instanceof EClass) {
					EClass innerType = (EClass) type;
					EClass referenceType = (EClass) lhsAttribute.getEType();
					if (referenceType != innerType && !referenceType.getEAllSuperTypes().contains(innerType)) {
						error("Result of nested query is incompatible with type of the given reference", query,
								QueryPackage.MQ_LQUERY__SELECT_ENTRIES);
					}

				} else {
					error("Only instances of EClass are allowed as result of a nested query", query ,
							QueryPackage.MQ_LQUERY__SELECT_ENTRIES);
				}
			} else {
				error(
						"If a reference is specified on the left side of the operator only 'null', an alias or a subquery is allowed on the right side",
						QueryPackage.EXPRESSION_WHERE_ENTRY__RHS);
			}

		} else {
			// lhsAttribute instance of EAttribute
			EClassifier lhsType = lhsAttribute.getEType();
			if (rhs instanceof AliasAttributeExpression) {
				EClassifier rhsType = ((AliasAttributeExpression) rhs).getAttribute().getEType();
				checkType(lhsType, rhsType, QueryPackage.EXPRESSION_WHERE_ENTRY__RHS);
				checkNumericOp(operator);
			} else if (rhs instanceof DoubleExpression) {
				checkType(lhsType, Literals.EDOUBLE, QueryPackage.EXPRESSION_WHERE_ENTRY__RHS);
				checkNumericOp(operator);
			} else if (rhs instanceof LongExpression) {
				checkType(lhsType, Literals.ELONG, QueryPackage.EXPRESSION_WHERE_ENTRY__RHS);
				checkNumericOp(operator);
			} else if (rhs instanceof StringExpression) {
				checkType(lhsType, Literals.ESTRING, QueryPackage.EXPRESSION_WHERE_ENTRY__RHS);
				checkStringOp(operator);
			} else if (rhs instanceof NullExpression) {
				if (lhsType != Literals.ESTRING && !(lhsType instanceof EClass)) {
					error("Only attributes with type EString or references are allowed with a null check",
							QueryPackage.EXPRESSION_WHERE_ENTRY__RHS);
				}
				checkBooleanOp(operator);
			} else if (rhs instanceof BooleanExpression) {
				checkType(lhsType, Literals.EBOOLEAN, QueryPackage.EXPRESSION_WHERE_ENTRY__RHS);
				checkBooleanOp(operator);
			} else {
				throw new IllegalStateException("unknown type: " + rhs.toString());
			}
		}

	}

	private void checkBooleanOp(Operator operator) {
		if (operator != Operator.EQUAL && operator != Operator.NOT_EQUAL) {
			error("Wrong comparison operator specified. Only '=' or '!=' is allowed", QueryPackage.EXPRESSION_WHERE_ENTRY__RHS);
		}
	}

	private void checkStringOp(Operator operator) {
		if (operator != Operator.LIKE && operator != Operator.NOT_LIKE && operator != Operator.EQUAL && operator != Operator.NOT_EQUAL) {
			error("Wrong comparison operator specified. Only 'like', 'not like', '=' or '!=' are allowed",
					QueryPackage.EXPRESSION_WHERE_ENTRY__RHS);
		}
		if (operator==Operator.NOT_LIKE){
			error("'not like' is not yet supported as an operator for strings", QueryPackage.EXPRESSION_WHERE_ENTRY__OPERATOR);
		}
	}

	private void checkNumericOp(Operator operator) {
		if (operator != Operator.LESS_THEN && operator != Operator.GREATER_THEN && operator != Operator.GREATER_EQUAL
				&& operator != Operator.LESS_EQUAL && operator != Operator.EQUAL && operator != Operator.NOT_EQUAL) {
			error("Wrong comparison operator specified. Only '<', '<=', '>', '>=', '=' or '!=' are allowed",
					QueryPackage.EXPRESSION_WHERE_ENTRY__RHS);
		}
	}

	private void checkType(EClassifier left, EClassifier right, int id) {
		if (left == Literals.EDOUBLE || left == Literals.EDOUBLE_OBJECT || left == Literals.EFLOAT || left == Literals.EFLOAT_OBJECT) {
			if (right != Literals.EDOUBLE && right != Literals.EDOUBLE_OBJECT && right != Literals.EFLOAT
					&& right != Literals.EFLOAT_OBJECT) {
				error("Types are incompatible. Both must be assignable to float or double", id);
			}
		} else if (left == Literals.EINT || left == Literals.EINTEGER_OBJECT || left == Literals.ELONG || left == Literals.ELONG_OBJECT) {
			if (right != Literals.EINT && right != Literals.EINTEGER_OBJECT && right != Literals.ELONG && right != Literals.ELONG_OBJECT) {
				error("Types are incompatible. Both must be assignable to int or long", id);
			}
		} else if (left == Literals.ESTRING && right != Literals.ESTRING) {
			error("Types are incompatible. Both must be assignable to string", id);
		} else if (left instanceof EClass) {
			if (left != right && !((EClass) left).getEAllSuperTypes().contains(right)) {
				error("Only aliases with compatible type are allowed here", id);
			}
		}
	}

	@Check
	public void checkNoTuplesInSubSelects(QueryExpression entry) {
		if (entry.getValue().getSelectEntries().size() > 1) {
			error("Only one select entry is allowed in a nested query", entry.getValue(), QueryPackage.MQ_LQUERY__SELECT_ENTRIES);
		}
	}

	@Check
	public void checkAliasInOr(OrWhereEntry entry) {
		FromEntry fe = null;
		for (Iterator<EObject> iterator = entry.eAllContents(); iterator.hasNext();) {
			EObject eObj = iterator.next();
			if (eObj instanceof ExpressionWhereEntry) {
				ExpressionWhereEntry awe = (ExpressionWhereEntry) eObj;
				if (fe == null) {
					fe = awe.getLhs().getAlias();
					continue;
				}
				if (awe.getLhs().getAlias() != fe) {
					error("The current query can only execute where entries in an or subtree if they share the same alias", awe,
							QueryPackage.OR_WHERE_ENTRY__ENTRIES);
				}
			}

		}
	}

}

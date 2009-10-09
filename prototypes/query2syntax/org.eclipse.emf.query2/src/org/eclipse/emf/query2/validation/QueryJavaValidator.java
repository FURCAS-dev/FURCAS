package org.eclipse.emf.query2.validation;

import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage.Literals;
import org.eclipse.emf.query2.query.AbstractAliasWhereEntry;
import org.eclipse.emf.query2.query.DoubleWhereEntry;
import org.eclipse.emf.query2.query.FromEntry;
import org.eclipse.emf.query2.query.LongWhereEntry;
import org.eclipse.emf.query2.query.NullWhereEntry;
import org.eclipse.emf.query2.query.OrWhereEntry;
import org.eclipse.emf.query2.query.QueryPackage;
import org.eclipse.emf.query2.query.ReferenceAliasWhereEntry;
import org.eclipse.emf.query2.query.SelectEntry;
import org.eclipse.emf.query2.query.StringAttributeWhereEntry;
import org.eclipse.emf.query2.query.SubselectWhereEntry;
import org.eclipse.xtext.validation.Check;

public class QueryJavaValidator extends AbstractQueryJavaValidator {

	@Check
	public void checkType(DoubleWhereEntry entry) {
		EClassifier eType = entry.getAttribute().getEType();
		if (eType != Literals.EDOUBLE && eType != Literals.EDOUBLE_OBJECT && eType != Literals.EFLOAT && eType != Literals.EFLOAT_OBJECT) {
			error("Only attributes with type EDouble, EDoubleObject, EFloat or EFloatObject are allowed here",
					QueryPackage.ATTRIBUTE_WHERE_ENTRY__ATTRIBUTE);
		}
	}

	@Check
	public void checkType(LongWhereEntry entry) {
		EClassifier eType = entry.getAttribute().getEType();
		if (eType != Literals.EINT && eType != Literals.EINTEGER_OBJECT && eType != Literals.ELONG && eType != Literals.ELONG_OBJECT) {
			error("Only attributes with type EInt, EIntObject, ELong or ELongObject are allowed here",
					QueryPackage.ATTRIBUTE_WHERE_ENTRY__ATTRIBUTE);
		}
	}

	@Check
	public void checkType(StringAttributeWhereEntry entry) {
		EClassifier eType = entry.getAttribute().getEType();
		if (eType != Literals.ESTRING) {
			error("Only attributes with type EString are allowed here", QueryPackage.ATTRIBUTE_WHERE_ENTRY__ATTRIBUTE);
		}
	}

	@Check
	public void checkType(NullWhereEntry entry) {
		EClassifier eType = entry.getFeature().getEType();
		if (eType != Literals.ESTRING && !(eType instanceof EClass)) {
			error("Only attributes with type EString ore references are allowed here", QueryPackage.NULL_WHERE_ENTRY__FEATURE);
		}
	}

	@Check
	public void checkType(ReferenceAliasWhereEntry entry) {
		EClass referenceType = (EClass) entry.getReference().getEType();
		EClass aliasType = entry.getRightAlias().getType();
		if (referenceType != aliasType && !referenceType.getEAllSuperTypes().contains(aliasType)) {
			error("Only aliases with compatible type are allowed here", QueryPackage.REFERENCE_ALIAS_WHERE_ENTRY__RIGHT_ALIAS);
		}
	}

	@Check
	public void checkType(SubselectWhereEntry entry) {
		SelectEntry selectEntry = entry.getSubQuery().getSelectEntries().get(0);
		EClassifier type = selectEntry.getAttribute() == null ? selectEntry.getSelect().getType() : selectEntry.getAttribute().getEType();
		if (type instanceof EClass) {
			EClass innerType = (EClass) type;
			EClass referenceType = (EClass) entry.getReference().getEType();
			if (referenceType != innerType && !referenceType.getEAllSuperTypes().contains(innerType)) {
				error("Result of nested query is incompatible with type of the given reference", entry.getSubQuery(),
						QueryPackage.MQ_LQUERY__SELECT_ENTRIES);
			}

		} else {
			error("Only instances of EClasses are allowed as result of a nested query", entry.getSubQuery(),
					QueryPackage.MQ_LQUERY__SELECT_ENTRIES);
		}
	}

	@Check
	public void checkNoTuplesInSubSelects(SubselectWhereEntry entry) {
		if (entry.getSubQuery().getSelectEntries().size() > 1) {
			error("Only one selectenty is allowed in nested query", entry.getSubQuery(), QueryPackage.MQ_LQUERY__SELECT_ENTRIES);
		}
	}
	
	@Check
	public void checkAliasInOr(OrWhereEntry entry){
		FromEntry fe = null;
		for (Iterator<EObject> iterator = entry.eAllContents(); iterator.hasNext();) {
			EObject eObj = iterator.next();
			if (eObj instanceof AbstractAliasWhereEntry) {
				AbstractAliasWhereEntry awe = (AbstractAliasWhereEntry) eObj;
				if(fe == null){
					fe = awe.getAlias();
					continue;
				}
				if (awe.getAlias() != fe) {
					error("The current query can only execute where entries in an or subtree if they share the same alias", awe, QueryPackage.OR_WHERE_ENTRY__ENTRIES);
				}
			}
			
		}
	}

}

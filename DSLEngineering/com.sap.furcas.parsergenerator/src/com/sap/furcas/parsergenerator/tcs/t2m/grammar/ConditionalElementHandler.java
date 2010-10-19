/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2009-09-18 14:13:44 +0200 (Fr, 18 Sep 2009) $
 * @version $Revision: 7886 $
 * @author: $Author: c5106462 $
 *******************************************************************************/
package com.sap.furcas.parsergenerator.tcs.t2m.grammar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;

import com.sap.furcas.metamodel.FURCAS.TCS.AndExp;
import com.sap.furcas.metamodel.FURCAS.TCS.AtomExp;
import com.sap.furcas.metamodel.FURCAS.TCS.BooleanPropertyExp;
import com.sap.furcas.metamodel.FURCAS.TCS.ConditionalElement;
import com.sap.furcas.metamodel.FURCAS.TCS.EnumLiteralVal;
import com.sap.furcas.metamodel.FURCAS.TCS.EqualsExp;
import com.sap.furcas.metamodel.FURCAS.TCS.InstanceOfExp;
import com.sap.furcas.metamodel.FURCAS.TCS.IntegerVal;
import com.sap.furcas.metamodel.FURCAS.TCS.IsDefinedExp;
import com.sap.furcas.metamodel.FURCAS.TCS.NegativeIntegerVal;
import com.sap.furcas.metamodel.FURCAS.TCS.OneExp;
import com.sap.furcas.metamodel.FURCAS.TCS.PropertyReference;
import com.sap.furcas.metamodel.FURCAS.TCS.QualifiedNamedElement;
import com.sap.furcas.metamodel.FURCAS.TCS.Sequence;
import com.sap.furcas.metamodel.FURCAS.TCS.StringVal;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.TCS.Value;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.constraints.PropertyInstanceOfConstraint;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.constraints.PropertyQuantityConstraint;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.constraints.RuleBodyPropertyConstraint;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.common.exceptions.NameResolutionFailedException;
import com.sap.furcas.runtime.common.exceptions.SyntaxElementException;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.runtime.common.interfaces.ResolvedNameAndReferenceBean;
import com.sap.furcas.runtime.parser.exceptions.SyntaxParsingException;
import com.sap.furcas.runtime.tcs.MetaModelElementResolutionHelper;
import com.sap.furcas.runtime.tcs.SyntaxLookup;
import com.sap.furcas.runtime.tcs.TemplateNamingHelper;

/**
 * The Class ConditionalElementHandler.
 */
public class ConditionalElementHandler<Type extends Object> {

    private IMetaModelLookup<Type> metaLookup;
    private SyntaxLookup syntaxLookup;
    private TemplateNamingHelper<Type> namingHelper;

    private SemanticErrorBucket errorBucket;

    private MetaModelElementResolutionHelper<Type> resolutionHelper;

    /**
     * Instantiates a new conditional element handler.
     * 
     * @param metaLookup
     * @param syntaxLookup
     * @param namingHelper
     * @param resHelper
     */
    protected ConditionalElementHandler(IMetaModelLookup<Type> metaLookup, SyntaxLookup syntaxLookup,
	    TemplateNamingHelper<Type> namingHelper, MetaModelElementResolutionHelper<Type> resHelper,
	    SemanticErrorBucket errorBucket) {
	super();
	this.metaLookup = metaLookup;
	this.syntaxLookup = syntaxLookup;
	this.namingHelper = namingHelper;
	this.resolutionHelper = resHelper;
	this.errorBucket = errorBucket;
    }

    /**
     * @param handlerConfig
     */
    protected ConditionalElementHandler(SyntaxElementHandlerConfigurationBean<Type> handlerConfig) {
	this(handlerConfig.getMetaLookup(), handlerConfig.getSyntaxLookup(), handlerConfig.getNamingHelper(), handlerConfig
		.getResolutionHelper(), handlerConfig.getErrorBucket());
    }

    /**
     * Adds a rule body element for the conditional element. This method is a
     * bit tricky, because it needs to reason what we can set in the model
     * should we parse a dsl string. I.e. if the Syntax defines (x=3 ? "three"
     * ), then when we parse "three", we should set x = 3. Also, multiplicity is
     * a special problem, as if a property is multi valued, within (one books ?
     * "My" "Book:" books ) the grammar should enforce that the sequence
     * "My Book book" really contains only one such book. Same for isDefined.
     * This causes the need to communicate with the propertyHandler in the
     * context of a ruleBody.
     * 
     * @param element
     *            the element
     * @param buffer
     *            the buffer
     * 
     * @throws SyntaxParsingException
     *             the syntax parsing exception
     * @throws MetaModelLookupException
     *             the meta model lookup exception
     */
    public void addElement(ConditionalElement element, RuleBodyStringBuffer buffer) throws SyntaxElementException,
	    MetaModelLookupException {

	if (element.getCondition() == null) {
	    throw new IllegalArgumentException("Condition Element was null for " + element);
	}

	QualifiedNamedElement propertyOwnerTypeTemplate = syntaxLookup.getEnclosingQualifiedElement(element);
	ResolvedNameAndReferenceBean<Type> metaElementRef;
	try {
	    metaElementRef = resolutionHelper.resolve(propertyOwnerTypeTemplate);
	} catch (NameResolutionFailedException e) {
	    throw new SyntaxElementException(e.getMessage(), element, e);
	}
	if (metaElementRef == null) {
	    throw new SyntaxElementException("Metamodel Element for template " + propertyOwnerTypeTemplate
		    + " could not be resolved.", element);
	}

	// at the time of writing, TCS does not define other instances of
	// Expression than AndExp,
	// and the code would need change if there ever was a new
	// implementation, so ClassCastException is okay
	AndExp expression = (AndExp) element.getCondition();

	if (expression.getExpressions() == null) {
	    throw new IllegalArgumentException("Condition Element has null expressions: " + element);
	}

	buffer.append(" (");

	// need to check the conditions to see whether they contain any
	// IsDefinedExp, InstanceOf or OneExp, since those
	// will influence assumptions about properties in embedded syntax
	// elements (E.g. within OneExp, we assume a
	// multi-property attribute will only have one element)
	Collection<AtomExp> conditions = expression.getExpressions();
	List<RuleBodyPropertyConstraint> myAddedThenConstraints = new ArrayList<RuleBodyPropertyConstraint>();

	for (AtomExp atomExp : conditions) {
	    // first validate the property actually exists in Metamodel
	    String propName = getPropertyName(atomExp);
	    if (metaLookup.getMultiplicity(metaElementRef, propName) == null) {
		// means feature used in condition does not actually exist in
		// metamodel
		errorBucket.addError("Feature with name " + propName + " does not exist for metamodel type "
			+ metaElementRef.getNames(), atomExp);
	    }

	    if (atomExp instanceof IsDefinedExp) {
		// IsDefinedExp isDefined = (IsDefinedExp) atomExp;
		PropertyQuantityConstraint constraint = new PropertyQuantityConstraint(propName,
			PropertyQuantityConstraint.ISDEFINED_KEY, true);
		buffer.setPropertyConstraint(constraint);
		myAddedThenConstraints.add(constraint);
	    } else if (atomExp instanceof OneExp) {
		// OneExp oneExp = (OneExp) atomExp;
		PropertyQuantityConstraint constraint = new PropertyQuantityConstraint(propName,
			PropertyQuantityConstraint.ONE_KEY, true);
		buffer.setPropertyConstraint(constraint);
		myAddedThenConstraints.add(constraint);
	    } else if (atomExp instanceof InstanceOfExp) {
		InstanceOfExp instExp = (InstanceOfExp) atomExp;
		PropertyInstanceOfConstraint constraint = new PropertyInstanceOfConstraint( propName, instExp.getSupertype());
		buffer.setPropertyConstraint(constraint);
		myAddedThenConstraints.add(constraint);
	    }
	    // TODO: validate these constraints against existing constraints and
	    // the metamodel (e.g. one(xyz) AND NOT one(xyz))
	}

	Sequence thenSeq = element.getThenSequence();

	// For the one Exp, need to consider here that the multiplicity of
	// the argument when used in the then part shall be one, (and in the
	// else part >=2?)
	// also for isDefined the property should be present in the then part
	// and absent in the else part
	// PropertyHandler to use the constratints set previoulsy
	ObservationDirectivesHelper.appendEnterAlternativeNotification(buffer, 0);
	buffer.addToRuleFragment(thenSeq);

	// remove the constraints that were set, and later for the else bit add
	// their inverse instead
	Collections.reverse(myAddedThenConstraints);
	for (Iterator<RuleBodyPropertyConstraint> iterator = myAddedThenConstraints.iterator(); iterator.hasNext();) {
	    RuleBodyPropertyConstraint propertyConstraint = iterator.next();
	    buffer.removeConstraint(propertyConstraint);
	}
	// apend the directives relevant for model injection
	appendThenPartForInjector(expression, buffer);
	ObservationDirectivesHelper.appendExitAlternativeNotification(buffer);

	// now use inverse reasoning to find out what to set in model if this
	// then part has been parsed
	// parsed Expression might be (isDefined(p1) and p(2)==5 and isTrue(3))
	// then we would have to set something in the model for each "and part".
	// And later in the else for most of the invert cases as well.

	// Always append some alternative, even if the alternative is
	// parseNothing, doNothing, then this creates (...| ), which is
	// equivalent to ()?
	// Except for the InstanceOf-Element with empty else part
	if (!(((AndExp) element.getCondition()).getExpressions().size() > 0
		&& ((AndExp) element.getCondition()).getExpressions().iterator().next() instanceof InstanceOfExp && element
		.getElseSequence() == null)) {
	    buffer.append(" | ");
	    ObservationDirectivesHelper.appendEnterAlternativeNotification(buffer, 1);
	    Sequence elseSeq = element.getElseSequence();
	    if (elseSeq != null) {
		Collections.reverse(myAddedThenConstraints);
		List<RuleBodyPropertyConstraint> myAddedElseConstraints = new ArrayList<RuleBodyPropertyConstraint>();
		for (Iterator<RuleBodyPropertyConstraint> iterator = myAddedThenConstraints.iterator(); iterator.hasNext();) {
		    RuleBodyPropertyConstraint propertyConstraint = iterator.next();

		    RuleBodyPropertyConstraint inverseConstraint = propertyConstraint.getInverseConstraint();
		    if (inverseConstraint != null) {
			buffer.setPropertyConstraint(inverseConstraint);
			myAddedElseConstraints.add(inverseConstraint);
		    }
		}

		buffer.addToRuleFragment(elseSeq);

		Collections.reverse(myAddedElseConstraints);
		for (Iterator<RuleBodyPropertyConstraint> iterator = myAddedElseConstraints.iterator(); iterator.hasNext();) {
		    RuleBodyPropertyConstraint propertyConstraint = iterator.next();
		    buffer.removeConstraint(propertyConstraint);
		}
	    }

	    appendElsePartForInjector(expression, buffer);
	    ObservationDirectivesHelper.appendExitAlternativeNotification(buffer);
	}
	buffer.append(')');
	buffer.append('\n');
    }

    /**
     * call for iterating expressions. For those where we can know something
     * about the model from the condition being true, we set what we know in the
     * model. For those that do not help us, we don't care.
     * 
     * @param buffer
     *            the buffer
     * @param andExpression
     *            the and expression
     * @throws SyntaxParsingException
     * @throws SyntaxElementException
     */
    private void appendThenPartForInjector(AndExp andExpression, RuleBodyStringBuffer buffer) throws SyntaxElementException {
	if (andExpression == null || andExpression.getExpressions() == null || andExpression.getExpressions().size() == 0) {
	    throw new IllegalArgumentException("Condition expression was null or empty " + andExpression);
	}
	Collection<AtomExp> exprList = andExpression.getExpressions();
	List<AtomExp> addToList = new ArrayList<AtomExp>(exprList.size());

	// add relevant conditions to list, only do something if resulting list
	// is not empty
	for (AtomExp atomExp : exprList) {
	    if ((atomExp instanceof BooleanPropertyExp) || (atomExp instanceof EqualsExp)) {
		addToList.add(atomExp);
	    } else if (atomExp instanceof IsDefinedExp || atomExp instanceof OneExp) {
		// don't care, as we cannot define without knowing value
	    } else if (atomExp instanceof InstanceOfExp) {
		// don't care, as we cannot define without knowing value
	    } else {
		// should never be thrown, unless TCS syntax metamodel changes
		throw new RuntimeException("Unknown AtomExp type: " + atomExp.getClass().getName());
	    }
	}
	if (addToList.size() == 0) {
	    return;
	}
	buffer.append('{');
	for (AtomExp atomExp2 : addToList) {
	    String propName = getPropertyName(atomExp2);
	    if (atomExp2 instanceof BooleanPropertyExp) {
		buffer.append("setProperty(ret, \"", propName, "\", java.lang.Boolean.TRUE);");
	    } else if (atomExp2 instanceof EqualsExp) {
		EqualsExp eqE = (EqualsExp) atomExp2;

		// i.e. set(ret, "name", new String("John"));
		buffer.append("setProperty(ret, \"", propName, "\",");
		Value value = eqE.getValue();
		if (value instanceof EnumLiteralVal) {
		    EnumLiteralVal val = (EnumLiteralVal) value;

		    Template owningTemplate = syntaxLookup.getEnclosingQualifiedElement(eqE);
		    // need to find property, then PropertyType, as this would
		    // be the enum
		    try {
			ResolvedNameAndReferenceBean<Type> metaTypeRef = resolutionHelper.resolve(owningTemplate);
			ResolvedNameAndReferenceBean<Type> enumName = metaLookup.getFeatureClassReference(metaTypeRef, propName);
			if (enumName != null) {
			    String enumNameParamString = namingHelper.getMetaTypeListParameter(enumName);
			    buffer.append(" createEnumLiteral(", enumNameParamString, ",\"", val.getName(), "\")");
			} else {
			    throw new SyntaxElementException("Type has no such Property: " + owningTemplate + "." + propName, eqE);
			}
		    } catch (MetaModelLookupException e) {
			throw new SyntaxElementException("Equals Condition generating failed: " + e.getMessage(), eqE, e);
		    } catch (NameResolutionFailedException e) {
			throw new SyntaxElementException("Equals Condition generating failed: " + e.getMessage(), eqE, e);
		    }

		} else {
		    appendValueCreationCommand(buffer, value);
		}
		buffer.append(");");
	    }
	}
	buffer.append('}');
    }

    /**
     * creates a declaration for the property to set (i.e. new String, or maybe
     * something else like create()?). In case the DSL sample matched. I.e. If
     * syntax says (value = "test" ? "A" : "B" ) Then in case of "A", the
     * property "value" should be set to "test".
     * 
     * Need to TypeCheck the Value to decide what kind of Object to create in
     * target model.
     * 
     * @param buffer
     * @param propertyName
     * @param value
     */
    private void appendValueCreationCommand(RuleBodyStringBuffer buffer, Value value) {
	// i.e.: new String("John")
	if (value == null) {
	    throw new IllegalArgumentException("EqualsExpression had null comparison value");
	}

	String valueClassName;// = value.getClass().getName();
	String valueInitParameter;// = value.toString();

	if (value instanceof StringVal) {
	    valueClassName = "String";
	    // just use the String instead of "new String()"?
	    StringVal val = (StringVal) value;
	    valueInitParameter = '\"' + val.getSymbol() + '\"';
	} else if (value instanceof IntegerVal) {
	    valueClassName = "Integer";
	    IntegerVal val = (IntegerVal) value;
	    valueInitParameter = Integer.toString(val.getSymbol());
	} else if (value instanceof NegativeIntegerVal) {
	    valueClassName = "Integer";
	    NegativeIntegerVal val = (NegativeIntegerVal) value;
	    valueInitParameter = "-" + Integer.toString(val.getSymbol());
	} else {
	    throw new RuntimeException("Unknown subclass of Value: " + value.getClass());
	}

	buffer.append(" new ", valueClassName, '(', valueInitParameter, ")");

    }

    /**
     * call for iterating expressions. For those where we can know something
     * about the model from the condition being FALSE, we set what we know in
     * the model.
     * 
     * @param buffer
     *            the buffer
     * @param andExpression
     *            the and expression
     */
    private void appendElsePartForInjector(AndExp andExpression, RuleBodyStringBuffer buffer) throws SyntaxElementException {
	if (andExpression == null || andExpression.getExpressions() == null) {
	    return;
	}
	// TODO[1] check if right-hand side contains a feature assignment for the feature used in the equality comparison;
	// in that case it's ok, and no separate feature assignment needs to be generated here
	Collection<AtomExp> exprList = andExpression.getExpressions();
	List<AtomExp> addToList = new ArrayList<AtomExp>(exprList.size());

	for (AtomExp atomExp : exprList) {
	    if ((atomExp instanceof BooleanPropertyExp) || (atomExp instanceof EqualsExp)) {
		addToList.add(atomExp);
	    } else if ((atomExp instanceof IsDefinedExp) || (atomExp instanceof EqualsExp || atomExp instanceof OneExp)) {
		// don't care, as we cannot define without knowing value
	    } else if (atomExp instanceof InstanceOfExp) {
		// don't care, as we cannot define without knowing value
	    } else {
		// should never be thrown, unless TCS syntax metamodel changes
		throw new RuntimeException("Unknown AtomExp type: " + atomExp.getClass().getName());
	    }
	}
	if (addToList.size() == 0) {
	    return;
	}
	buffer.append('{');
	for (AtomExp atomExp2 : addToList) {
	    String propName = getPropertyName(atomExp2);
	    if (atomExp2 instanceof BooleanPropertyExp) {
		buffer.append("setProperty(ret, \"", propName, "\", java.lang.Boolean.FALSE);");
	    } else if (atomExp2 instanceof EqualsExp) {
		EqualsExp eqE = (EqualsExp) atomExp2;
		Value value = eqE.getValue();
		if (value instanceof EnumLiteralVal) {
		    EnumLiteralVal val = (EnumLiteralVal) value;

		    Template owningTemplate = syntaxLookup.getEnclosingQualifiedElement(eqE);
		    
		    // need to find property, then PropertyType, as this would
		    // be the enum
		    try {
			ResolvedNameAndReferenceBean<Type> metaTypeRef = resolutionHelper.resolve(owningTemplate);
			ResolvedNameAndReferenceBean<Type> enumName = metaLookup.getFeatureClassReference(metaTypeRef, propName);
			if (enumName != null) {
			    List<String> enumLiterals = metaLookup.getEnumLiterals(enumName);
			    String enumNameParamString = namingHelper.getMetaTypeListParameter(enumName);
			    if (enumLiterals.size() != 2) {
				throw new SyntaxElementException("Don't know how to handle conditional on Enum "+enumNameParamString+" with more than two literals", eqE);
			    }
			    String otherEnumValue = getOtherEnumLiteral(enumLiterals, val.getName());
			    buffer.append("setProperty(ret, \"", propName, "\",");
			    buffer.append(" createEnumLiteral(", enumNameParamString, ",\"", otherEnumValue, "\")");
			    buffer.append(");");
			} else {
			    throw new SyntaxElementException("Type has no such Property: " + owningTemplate + "." + propName, eqE);
			}
		    } catch (MetaModelLookupException e) {
			throw new SyntaxElementException("Equals Condition generating failed: " + e.getMessage(), eqE, e);
		    } catch (NameResolutionFailedException e) {
			throw new SyntaxElementException("Equals Condition generating failed: " + e.getMessage(), eqE, e);
		    }
		    //if TODO[1] is done we can re-add this here
//		} else if (value instanceof IntegerVal || value instanceof NegativeIntegerVal) {
//		    buffer.append("setProperty(ret, \"", propName, "\",");
//		    buffer.append("0");
//		    buffer.append(");");
//		} else if (value instanceof StringVal) {
// 		    buffer.append("setProperty(ret, \"", propName, "\",");
//		    buffer.append("null");
//		    buffer.append(");");
		} else {
		    // throw new SyntaxElementException("Don't know how to handle conditional with non-Boolean and non-Enum feature", eqE);
		}
	    }
	}
	buffer.append('}');
    }

    /**
     * Given a list of enumeration literals with exactly two elements and one
     * literal assumed to be contained in that list, determines the other
     * literal.
     */
    private String getOtherEnumLiteral(List<String> enumLiterals, String oneLiteral) {
	assert enumLiterals.size() == 2;
	assert enumLiterals.contains(oneLiteral);
	return enumLiterals.get(1-enumLiterals.indexOf(oneLiteral));
    }

    /**
     * @param atomExp
     * @return
     */
    private static String getPropertyName(AtomExp atomExp) {
	PropertyReference propRef = atomExp.getPropertyReference();
	if (propRef != null) {
	    if (propRef.getName() != null) {
		return propRef.getName();
	    } else {
		EStructuralFeature strucFeat = propRef.getStrucfeature();
		if (strucFeat != null) {
		    return strucFeat.getName();
		}
	    }
	}
	return null;
    }

}

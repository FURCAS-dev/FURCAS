/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.util;

import com.sap.furcas.metamodel.FURCAS.TCS.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage
 * @generated
 */
public class TCSSwitch<T> {
        /**
	 * The cached model package
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        protected static TCSPackage modelPackage;

        /**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public TCSSwitch() {
		if (modelPackage == null) {
			modelPackage = TCSPackage.eINSTANCE;
		}
	}

        /**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
        public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

        /**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
        protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

        /**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
        protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case TCSPackage.LOCATED_ELEMENT: {
				LocatedElement locatedElement = (LocatedElement)theEObject;
				T result = caseLocatedElement(locatedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.NAMED_ELEMENT: {
				NamedElement namedElement = (NamedElement)theEObject;
				T result = caseNamedElement(namedElement);
				if (result == null) result = caseLocatedElement(namedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.CONCRETE_SYNTAX: {
				ConcreteSyntax concreteSyntax = (ConcreteSyntax)theEObject;
				T result = caseConcreteSyntax(concreteSyntax);
				if (result == null) result = caseNamedElement(concreteSyntax);
				if (result == null) result = caseLocatedElement(concreteSyntax);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.TEMPLATE: {
				Template template = (Template)theEObject;
				T result = caseTemplate(template);
				if (result == null) result = caseQualifiedNamedElement(template);
				if (result == null) result = caseLocatedElement(template);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.FUNCTION_TEMPLATE: {
				FunctionTemplate functionTemplate = (FunctionTemplate)theEObject;
				T result = caseFunctionTemplate(functionTemplate);
				if (result == null) result = caseTemplate(functionTemplate);
				if (result == null) result = caseQualifiedNamedElement(functionTemplate);
				if (result == null) result = caseLocatedElement(functionTemplate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.CLASS_TEMPLATE: {
				ClassTemplate classTemplate = (ClassTemplate)theEObject;
				T result = caseClassTemplate(classTemplate);
				if (result == null) result = caseContextTemplate(classTemplate);
				if (result == null) result = caseTemplate(classTemplate);
				if (result == null) result = caseQualifiedNamedElement(classTemplate);
				if (result == null) result = caseLocatedElement(classTemplate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.PRIMITIVE_TEMPLATE: {
				PrimitiveTemplate primitiveTemplate = (PrimitiveTemplate)theEObject;
				T result = casePrimitiveTemplate(primitiveTemplate);
				if (result == null) result = caseTemplate(primitiveTemplate);
				if (result == null) result = caseQualifiedNamedElement(primitiveTemplate);
				if (result == null) result = caseLocatedElement(primitiveTemplate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.OPERATOR_TEMPLATE: {
				OperatorTemplate operatorTemplate = (OperatorTemplate)theEObject;
				T result = caseOperatorTemplate(operatorTemplate);
				if (result == null) result = caseContextTemplate(operatorTemplate);
				if (result == null) result = caseTemplate(operatorTemplate);
				if (result == null) result = caseQualifiedNamedElement(operatorTemplate);
				if (result == null) result = caseLocatedElement(operatorTemplate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.ENUMERATION_TEMPLATE: {
				EnumerationTemplate enumerationTemplate = (EnumerationTemplate)theEObject;
				T result = caseEnumerationTemplate(enumerationTemplate);
				if (result == null) result = caseTemplate(enumerationTemplate);
				if (result == null) result = caseQualifiedNamedElement(enumerationTemplate);
				if (result == null) result = caseLocatedElement(enumerationTemplate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.ENUM_LITERAL_MAPPING: {
				EnumLiteralMapping enumLiteralMapping = (EnumLiteralMapping)theEObject;
				T result = caseEnumLiteralMapping(enumLiteralMapping);
				if (result == null) result = caseLocatedElement(enumLiteralMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.LITERAL: {
				Literal literal = (Literal)theEObject;
				T result = caseLiteral(literal);
				if (result == null) result = caseNamedElement(literal);
				if (result == null) result = caseLocatedElement(literal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.SYMBOL: {
				Symbol symbol = (Symbol)theEObject;
				T result = caseSymbol(symbol);
				if (result == null) result = caseLiteral(symbol);
				if (result == null) result = caseNamedElement(symbol);
				if (result == null) result = caseLocatedElement(symbol);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.KEYWORD: {
				Keyword keyword = (Keyword)theEObject;
				T result = caseKeyword(keyword);
				if (result == null) result = caseLiteral(keyword);
				if (result == null) result = caseNamedElement(keyword);
				if (result == null) result = caseLocatedElement(keyword);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.OPERATOR_LIST: {
				OperatorList operatorList = (OperatorList)theEObject;
				T result = caseOperatorList(operatorList);
				if (result == null) result = caseLocatedElement(operatorList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.PRIORITY: {
				Priority priority = (Priority)theEObject;
				T result = casePriority(priority);
				if (result == null) result = caseLocatedElement(priority);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.OPERATOR: {
				Operator operator = (Operator)theEObject;
				T result = caseOperator(operator);
				if (result == null) result = caseNamedElement(operator);
				if (result == null) result = caseLocatedElement(operator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.SEQUENCE: {
				Sequence sequence = (Sequence)theEObject;
				T result = caseSequence(sequence);
				if (result == null) result = caseLocatedElement(sequence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.SEQUENCE_ELEMENT: {
				SequenceElement sequenceElement = (SequenceElement)theEObject;
				T result = caseSequenceElement(sequenceElement);
				if (result == null) result = caseLocatedElement(sequenceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.LITERAL_REF: {
				LiteralRef literalRef = (LiteralRef)theEObject;
				T result = caseLiteralRef(literalRef);
				if (result == null) result = caseSequenceElement(literalRef);
				if (result == null) result = caseLocatedElement(literalRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.PROPERTY: {
				Property property = (Property)theEObject;
				T result = caseProperty(property);
				if (result == null) result = caseSequenceElement(property);
				if (result == null) result = caseLocatedElement(property);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.CUSTOM_SEPARATOR: {
				CustomSeparator customSeparator = (CustomSeparator)theEObject;
				T result = caseCustomSeparator(customSeparator);
				if (result == null) result = caseSequenceElement(customSeparator);
				if (result == null) result = caseLocatedElement(customSeparator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.BLOCK: {
				Block block = (Block)theEObject;
				T result = caseBlock(block);
				if (result == null) result = caseSequenceElement(block);
				if (result == null) result = caseLocatedElement(block);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.CONDITIONAL_ELEMENT: {
				ConditionalElement conditionalElement = (ConditionalElement)theEObject;
				T result = caseConditionalElement(conditionalElement);
				if (result == null) result = caseSequenceElement(conditionalElement);
				if (result == null) result = caseLocatedElement(conditionalElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.PRIMITIVE_PROPERTY_INIT: {
				PrimitivePropertyInit primitivePropertyInit = (PrimitivePropertyInit)theEObject;
				T result = casePrimitivePropertyInit(primitivePropertyInit);
				if (result == null) result = casePropertyInit(primitivePropertyInit);
				if (result == null) result = caseInjectorAction(primitivePropertyInit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.ALTERNATIVE: {
				Alternative alternative = (Alternative)theEObject;
				T result = caseAlternative(alternative);
				if (result == null) result = caseSequenceElement(alternative);
				if (result == null) result = caseLocatedElement(alternative);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.FUNCTION_CALL: {
				FunctionCall functionCall = (FunctionCall)theEObject;
				T result = caseFunctionCall(functionCall);
				if (result == null) result = caseSequenceElement(functionCall);
				if (result == null) result = caseLocatedElement(functionCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.PROPERTY_ARG: {
				PropertyArg propertyArg = (PropertyArg)theEObject;
				T result = casePropertyArg(propertyArg);
				if (result == null) result = caseLocatedElement(propertyArg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.REFERS_TO_PARG: {
				RefersToPArg refersToPArg = (RefersToPArg)theEObject;
				T result = caseRefersToPArg(refersToPArg);
				if (result == null) result = casePropertyArg(refersToPArg);
				if (result == null) result = caseLocatedElement(refersToPArg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.LOOK_IN_PARG: {
				LookInPArg lookInPArg = (LookInPArg)theEObject;
				T result = caseLookInPArg(lookInPArg);
				if (result == null) result = casePropertyArg(lookInPArg);
				if (result == null) result = caseLocatedElement(lookInPArg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.CREATE_IN_PARG: {
				CreateInPArg createInPArg = (CreateInPArg)theEObject;
				T result = caseCreateInPArg(createInPArg);
				if (result == null) result = casePropertyArg(createInPArg);
				if (result == null) result = caseLocatedElement(createInPArg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.REFERS_TO_KEY_PARG: {
				RefersToKeyPArg refersToKeyPArg = (RefersToKeyPArg)theEObject;
				T result = caseRefersToKeyPArg(refersToKeyPArg);
				if (result == null) result = casePropertyArg(refersToKeyPArg);
				if (result == null) result = caseLocatedElement(refersToKeyPArg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.SEPARATOR_PARG: {
				SeparatorPArg separatorPArg = (SeparatorPArg)theEObject;
				T result = caseSeparatorPArg(separatorPArg);
				if (result == null) result = casePropertyArg(separatorPArg);
				if (result == null) result = caseLocatedElement(separatorPArg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.AUTO_CREATE_PARG: {
				AutoCreatePArg autoCreatePArg = (AutoCreatePArg)theEObject;
				T result = caseAutoCreatePArg(autoCreatePArg);
				if (result == null) result = casePropertyArg(autoCreatePArg);
				if (result == null) result = caseLocatedElement(autoCreatePArg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.IMPORT_CONTEXT_PARG: {
				ImportContextPArg importContextPArg = (ImportContextPArg)theEObject;
				T result = caseImportContextPArg(importContextPArg);
				if (result == null) result = casePropertyArg(importContextPArg);
				if (result == null) result = caseLocatedElement(importContextPArg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.FORCED_LOWER_PARG: {
				ForcedLowerPArg forcedLowerPArg = (ForcedLowerPArg)theEObject;
				T result = caseForcedLowerPArg(forcedLowerPArg);
				if (result == null) result = casePropertyArg(forcedLowerPArg);
				if (result == null) result = caseLocatedElement(forcedLowerPArg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.CREATE_AS_PARG: {
				CreateAsPArg createAsPArg = (CreateAsPArg)theEObject;
				T result = caseCreateAsPArg(createAsPArg);
				if (result == null) result = casePropertyArg(createAsPArg);
				if (result == null) result = caseLocatedElement(createAsPArg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.AS_PARG: {
				AsPArg asPArg = (AsPArg)theEObject;
				T result = caseAsPArg(asPArg);
				if (result == null) result = casePropertyArg(asPArg);
				if (result == null) result = caseLocatedElement(asPArg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.MODE_PARG: {
				ModePArg modePArg = (ModePArg)theEObject;
				T result = caseModePArg(modePArg);
				if (result == null) result = casePropertyArg(modePArg);
				if (result == null) result = caseLocatedElement(modePArg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.BLOCK_ARG: {
				BlockArg blockArg = (BlockArg)theEObject;
				T result = caseBlockArg(blockArg);
				if (result == null) result = caseLocatedElement(blockArg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.NB_NLB_ARG: {
				NbNLBArg nbNLBArg = (NbNLBArg)theEObject;
				T result = caseNbNLBArg(nbNLBArg);
				if (result == null) result = caseBlockArg(nbNLBArg);
				if (result == null) result = caseLocatedElement(nbNLBArg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.INDENT_INCR_BARG: {
				IndentIncrBArg indentIncrBArg = (IndentIncrBArg)theEObject;
				T result = caseIndentIncrBArg(indentIncrBArg);
				if (result == null) result = caseBlockArg(indentIncrBArg);
				if (result == null) result = caseLocatedElement(indentIncrBArg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.START_NLB_ARG: {
				StartNLBArg startNLBArg = (StartNLBArg)theEObject;
				T result = caseStartNLBArg(startNLBArg);
				if (result == null) result = caseBlockArg(startNLBArg);
				if (result == null) result = caseLocatedElement(startNLBArg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.START_NB_NLB_ARG: {
				StartNbNLBArg startNbNLBArg = (StartNbNLBArg)theEObject;
				T result = caseStartNbNLBArg(startNbNLBArg);
				if (result == null) result = caseBlockArg(startNbNLBArg);
				if (result == null) result = caseLocatedElement(startNbNLBArg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.END_NLB_ARG: {
				EndNLBArg endNLBArg = (EndNLBArg)theEObject;
				T result = caseEndNLBArg(endNLBArg);
				if (result == null) result = caseBlockArg(endNLBArg);
				if (result == null) result = caseLocatedElement(endNLBArg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.EXPRESSION: {
				Expression expression = (Expression)theEObject;
				T result = caseExpression(expression);
				if (result == null) result = caseLocatedElement(expression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.AND_EXP: {
				AndExp andExp = (AndExp)theEObject;
				T result = caseAndExp(andExp);
				if (result == null) result = caseExpression(andExp);
				if (result == null) result = caseLocatedElement(andExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.ATOM_EXP: {
				AtomExp atomExp = (AtomExp)theEObject;
				T result = caseAtomExp(atomExp);
				if (result == null) result = caseLocatedElement(atomExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.EQUALS_EXP: {
				EqualsExp equalsExp = (EqualsExp)theEObject;
				T result = caseEqualsExp(equalsExp);
				if (result == null) result = caseAtomExp(equalsExp);
				if (result == null) result = caseLocatedElement(equalsExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.BOOLEAN_PROPERTY_EXP: {
				BooleanPropertyExp booleanPropertyExp = (BooleanPropertyExp)theEObject;
				T result = caseBooleanPropertyExp(booleanPropertyExp);
				if (result == null) result = caseAtomExp(booleanPropertyExp);
				if (result == null) result = caseLocatedElement(booleanPropertyExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.IS_DEFINED_EXP: {
				IsDefinedExp isDefinedExp = (IsDefinedExp)theEObject;
				T result = caseIsDefinedExp(isDefinedExp);
				if (result == null) result = caseAtomExp(isDefinedExp);
				if (result == null) result = caseLocatedElement(isDefinedExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.ONE_EXP: {
				OneExp oneExp = (OneExp)theEObject;
				T result = caseOneExp(oneExp);
				if (result == null) result = caseAtomExp(oneExp);
				if (result == null) result = caseLocatedElement(oneExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.VALUE: {
				Value value = (Value)theEObject;
				T result = caseValue(value);
				if (result == null) result = caseLocatedElement(value);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.PROPERTY_VAL: {
				PropertyVal propertyVal = (PropertyVal)theEObject;
				T result = casePropertyVal(propertyVal);
				if (result == null) result = caseValue(propertyVal);
				if (result == null) result = caseLocatedElement(propertyVal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.TOKEN: {
				Token token = (Token)theEObject;
				T result = caseToken(token);
				if (result == null) result = caseNamedElement(token);
				if (result == null) result = caseLocatedElement(token);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.OR_PATTERN: {
				OrPattern orPattern = (OrPattern)theEObject;
				T result = caseOrPattern(orPattern);
				if (result == null) result = caseLocatedElement(orPattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.SIMPLE_PATTERN: {
				SimplePattern simplePattern = (SimplePattern)theEObject;
				T result = caseSimplePattern(simplePattern);
				if (result == null) result = caseNamedElement(simplePattern);
				if (result == null) result = caseLocatedElement(simplePattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.RULE_PATTERN: {
				RulePattern rulePattern = (RulePattern)theEObject;
				T result = caseRulePattern(rulePattern);
				if (result == null) result = caseSimplePattern(rulePattern);
				if (result == null) result = caseNamedElement(rulePattern);
				if (result == null) result = caseLocatedElement(rulePattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.RULE: {
				Rule rule = (Rule)theEObject;
				T result = caseRule(rule);
				if (result == null) result = caseLocatedElement(rule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.WORD_RULE: {
				WordRule wordRule = (WordRule)theEObject;
				T result = caseWordRule(wordRule);
				if (result == null) result = caseRule(wordRule);
				if (result == null) result = caseLocatedElement(wordRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.WORD: {
				Word word = (Word)theEObject;
				T result = caseWord(word);
				if (result == null) result = caseNamedElement(word);
				if (result == null) result = caseLocatedElement(word);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.END_OF_LINE_RULE: {
				EndOfLineRule endOfLineRule = (EndOfLineRule)theEObject;
				T result = caseEndOfLineRule(endOfLineRule);
				if (result == null) result = caseRule(endOfLineRule);
				if (result == null) result = caseLocatedElement(endOfLineRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.MULTI_LINE_RULE: {
				MultiLineRule multiLineRule = (MultiLineRule)theEObject;
				T result = caseMultiLineRule(multiLineRule);
				if (result == null) result = caseRule(multiLineRule);
				if (result == null) result = caseLocatedElement(multiLineRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.MAPPING: {
				Mapping mapping = (Mapping)theEObject;
				T result = caseMapping(mapping);
				if (result == null) result = caseLocatedElement(mapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.SIMPLE_MAPPING: {
				SimpleMapping simpleMapping = (SimpleMapping)theEObject;
				T result = caseSimpleMapping(simpleMapping);
				if (result == null) result = caseMapping(simpleMapping);
				if (result == null) result = caseLocatedElement(simpleMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.WILDCARD_MAPPING: {
				WildcardMapping wildcardMapping = (WildcardMapping)theEObject;
				T result = caseWildcardMapping(wildcardMapping);
				if (result == null) result = caseMapping(wildcardMapping);
				if (result == null) result = caseLocatedElement(wildcardMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.OCTAL_MAPPING: {
				OctalMapping octalMapping = (OctalMapping)theEObject;
				T result = caseOctalMapping(octalMapping);
				if (result == null) result = caseMapping(octalMapping);
				if (result == null) result = caseLocatedElement(octalMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.HEXADECIMAL_MAPPING: {
				HexadecimalMapping hexadecimalMapping = (HexadecimalMapping)theEObject;
				T result = caseHexadecimalMapping(hexadecimalMapping);
				if (result == null) result = caseMapping(hexadecimalMapping);
				if (result == null) result = caseLocatedElement(hexadecimalMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.STRING_PATTERN: {
				StringPattern stringPattern = (StringPattern)theEObject;
				T result = caseStringPattern(stringPattern);
				if (result == null) result = caseSimplePattern(stringPattern);
				if (result == null) result = caseNamedElement(stringPattern);
				if (result == null) result = caseLocatedElement(stringPattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.CLASS_PATTERN: {
				ClassPattern classPattern = (ClassPattern)theEObject;
				T result = caseClassPattern(classPattern);
				if (result == null) result = caseSimplePattern(classPattern);
				if (result == null) result = caseNamedElement(classPattern);
				if (result == null) result = caseLocatedElement(classPattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.QUALIFIED_NAMED_ELEMENT: {
				QualifiedNamedElement qualifiedNamedElement = (QualifiedNamedElement)theEObject;
				T result = caseQualifiedNamedElement(qualifiedNamedElement);
				if (result == null) result = caseLocatedElement(qualifiedNamedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.FORCED_UPPER_PARG: {
				ForcedUpperPArg forcedUpperPArg = (ForcedUpperPArg)theEObject;
				T result = caseForcedUpperPArg(forcedUpperPArg);
				if (result == null) result = casePropertyArg(forcedUpperPArg);
				if (result == null) result = caseLocatedElement(forcedUpperPArg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.INJECTOR_ACTIONS_BLOCK: {
				InjectorActionsBlock injectorActionsBlock = (InjectorActionsBlock)theEObject;
				T result = caseInjectorActionsBlock(injectorActionsBlock);
				if (result == null) result = caseSequenceElement(injectorActionsBlock);
				if (result == null) result = caseLocatedElement(injectorActionsBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.QUERY_PARG: {
				QueryPArg queryPArg = (QueryPArg)theEObject;
				T result = caseQueryPArg(queryPArg);
				if (result == null) result = caseOclPArg(queryPArg);
				if (result == null) result = casePropertyArg(queryPArg);
				if (result == null) result = caseLocatedElement(queryPArg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.FILTER_PARG: {
				FilterPArg filterPArg = (FilterPArg)theEObject;
				T result = caseFilterPArg(filterPArg);
				if (result == null) result = caseOclPArg(filterPArg);
				if (result == null) result = casePropertyArg(filterPArg);
				if (result == null) result = caseLocatedElement(filterPArg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.OCL_PARG: {
				OclPArg oclPArg = (OclPArg)theEObject;
				T result = caseOclPArg(oclPArg);
				if (result == null) result = casePropertyArg(oclPArg);
				if (result == null) result = caseLocatedElement(oclPArg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.PROPERTY_REFERENCE: {
				PropertyReference propertyReference = (PropertyReference)theEObject;
				T result = casePropertyReference(propertyReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.CONTEXT_TEMPLATE: {
				ContextTemplate contextTemplate = (ContextTemplate)theEObject;
				T result = caseContextTemplate(contextTemplate);
				if (result == null) result = caseTemplate(contextTemplate);
				if (result == null) result = caseQualifiedNamedElement(contextTemplate);
				if (result == null) result = caseLocatedElement(contextTemplate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.CONTEXT_TAGS: {
				ContextTags contextTags = (ContextTags)theEObject;
				T result = caseContextTags(contextTags);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.INJECTOR_ACTION: {
				InjectorAction injectorAction = (InjectorAction)theEObject;
				T result = caseInjectorAction(injectorAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.PROPERTY_INIT: {
				PropertyInit propertyInit = (PropertyInit)theEObject;
				T result = casePropertyInit(propertyInit);
				if (result == null) result = caseInjectorAction(propertyInit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.OCL_PROPERTY_INIT: {
				OclPropertyInit oclPropertyInit = (OclPropertyInit)theEObject;
				T result = caseOclPropertyInit(oclPropertyInit);
				if (result == null) result = casePropertyInit(oclPropertyInit);
				if (result == null) result = caseInjectorAction(oclPropertyInit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.SCOPE_ARG: {
				ScopeArg scopeArg = (ScopeArg)theEObject;
				T result = caseScopeArg(scopeArg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.INVERT_PARG: {
				InvertPArg invertPArg = (InvertPArg)theEObject;
				T result = caseInvertPArg(invertPArg);
				if (result == null) result = caseOclPArg(invertPArg);
				if (result == null) result = casePropertyArg(invertPArg);
				if (result == null) result = caseLocatedElement(invertPArg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.FOREACH_PREDICATE_PROPERTY_INIT: {
				ForeachPredicatePropertyInit foreachPredicatePropertyInit = (ForeachPredicatePropertyInit)theEObject;
				T result = caseForeachPredicatePropertyInit(foreachPredicatePropertyInit);
				if (result == null) result = casePropertyInit(foreachPredicatePropertyInit);
				if (result == null) result = caseInjectorAction(foreachPredicatePropertyInit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.PREDICATE_SEMANTIC: {
				PredicateSemantic predicateSemantic = (PredicateSemantic)theEObject;
				T result = casePredicateSemantic(predicateSemantic);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.SEQUENCE_IN_ALTERNATIVE: {
				SequenceInAlternative sequenceInAlternative = (SequenceInAlternative)theEObject;
				T result = caseSequenceInAlternative(sequenceInAlternative);
				if (result == null) result = caseSequence(sequenceInAlternative);
				if (result == null) result = caseLocatedElement(sequenceInAlternative);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.PARTIAL_PARG: {
				PartialPArg partialPArg = (PartialPArg)theEObject;
				T result = casePartialPArg(partialPArg);
				if (result == null) result = casePropertyArg(partialPArg);
				if (result == null) result = caseLocatedElement(partialPArg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.DISAMBIGUATE_PARG: {
				DisambiguatePArg disambiguatePArg = (DisambiguatePArg)theEObject;
				T result = caseDisambiguatePArg(disambiguatePArg);
				if (result == null) result = casePropertyArg(disambiguatePArg);
				if (result == null) result = caseLocatedElement(disambiguatePArg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.INSTANCE_OF_EXP: {
				InstanceOfExp instanceOfExp = (InstanceOfExp)theEObject;
				T result = caseInstanceOfExp(instanceOfExp);
				if (result == null) result = caseAtomExp(instanceOfExp);
				if (result == null) result = caseLocatedElement(instanceOfExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.ENUM_LITERAL_VAL: {
				EnumLiteralVal enumLiteralVal = (EnumLiteralVal)theEObject;
				T result = caseEnumLiteralVal(enumLiteralVal);
				if (result == null) result = caseValue(enumLiteralVal);
				if (result == null) result = caseLocatedElement(enumLiteralVal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.STRING_VAL: {
				StringVal stringVal = (StringVal)theEObject;
				T result = caseStringVal(stringVal);
				if (result == null) result = caseValue(stringVal);
				if (result == null) result = caseLocatedElement(stringVal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.INTEGER_VAL: {
				IntegerVal integerVal = (IntegerVal)theEObject;
				T result = caseIntegerVal(integerVal);
				if (result == null) result = caseValue(integerVal);
				if (result == null) result = caseLocatedElement(integerVal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.NEGATIVE_INTEGER_VAL: {
				NegativeIntegerVal negativeIntegerVal = (NegativeIntegerVal)theEObject;
				T result = caseNegativeIntegerVal(negativeIntegerVal);
				if (result == null) result = caseValue(negativeIntegerVal);
				if (result == null) result = caseLocatedElement(negativeIntegerVal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TCSPackage.LOOKUP_PROPERTY_INIT: {
				LookupPropertyInit lookupPropertyInit = (LookupPropertyInit)theEObject;
				T result = caseLookupPropertyInit(lookupPropertyInit);
				if (result == null) result = casePropertyInit(lookupPropertyInit);
				if (result == null) result = caseInjectorAction(lookupPropertyInit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Located Element</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Located Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseLocatedElement(LocatedElement object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseNamedElement(NamedElement object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Concrete Syntax</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concrete Syntax</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseConcreteSyntax(ConcreteSyntax object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Template</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseTemplate(Template object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Function Template</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Template</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseFunctionTemplate(FunctionTemplate object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Class Template</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Template</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseClassTemplate(ClassTemplate object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Template</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Template</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T casePrimitiveTemplate(PrimitiveTemplate object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Operator Template</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operator Template</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseOperatorTemplate(OperatorTemplate object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Enumeration Template</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumeration Template</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseEnumerationTemplate(EnumerationTemplate object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Literal Mapping</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Literal Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseEnumLiteralMapping(EnumLiteralMapping object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Literal</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseLiteral(Literal object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Symbol</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Symbol</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseSymbol(Symbol object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Keyword</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Keyword</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseKeyword(Keyword object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Operator List</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operator List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseOperatorList(OperatorList object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Priority</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Priority</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T casePriority(Priority object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Operator</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseOperator(Operator object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseSequence(Sequence object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Element</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseSequenceElement(SequenceElement object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Ref</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseLiteralRef(LiteralRef object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Property</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseProperty(Property object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Custom Separator</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Custom Separator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseCustomSeparator(CustomSeparator object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Block</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseBlock(Block object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Conditional Element</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conditional Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseConditionalElement(ConditionalElement object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Property Init</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Property Init</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T casePrimitivePropertyInit(PrimitivePropertyInit object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Alternative</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Alternative</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseAlternative(Alternative object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Function Call</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseFunctionCall(FunctionCall object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Property Arg</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Arg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T casePropertyArg(PropertyArg object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Refers To PArg</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Refers To PArg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseRefersToPArg(RefersToPArg object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Look In PArg</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Look In PArg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseLookInPArg(LookInPArg object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Create In PArg</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Create In PArg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseCreateInPArg(CreateInPArg object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Refers To Key PArg</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Refers To Key PArg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseRefersToKeyPArg(RefersToKeyPArg object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Separator PArg</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Separator PArg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseSeparatorPArg(SeparatorPArg object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Auto Create PArg</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Auto Create PArg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseAutoCreatePArg(AutoCreatePArg object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Import Context PArg</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Import Context PArg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseImportContextPArg(ImportContextPArg object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Forced Lower PArg</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Forced Lower PArg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseForcedLowerPArg(ForcedLowerPArg object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Create As PArg</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Create As PArg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseCreateAsPArg(CreateAsPArg object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>As PArg</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>As PArg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseAsPArg(AsPArg object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Mode PArg</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mode PArg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseModePArg(ModePArg object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Block Arg</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block Arg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseBlockArg(BlockArg object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Nb NLB Arg</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nb NLB Arg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseNbNLBArg(NbNLBArg object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Indent Incr BArg</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Indent Incr BArg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseIndentIncrBArg(IndentIncrBArg object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Start NLB Arg</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Start NLB Arg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseStartNLBArg(StartNLBArg object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Start Nb NLB Arg</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Start Nb NLB Arg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseStartNbNLBArg(StartNbNLBArg object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>End NLB Arg</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>End NLB Arg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseEndNLBArg(EndNLBArg object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseExpression(Expression object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>And Exp</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>And Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseAndExp(AndExp object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Atom Exp</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Atom Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseAtomExp(AtomExp object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Equals Exp</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Equals Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseEqualsExp(EqualsExp object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Property Exp</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Property Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseBooleanPropertyExp(BooleanPropertyExp object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Is Defined Exp</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Is Defined Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseIsDefinedExp(IsDefinedExp object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>One Exp</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>One Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseOneExp(OneExp object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Value</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseValue(Value object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Property Val</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Val</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T casePropertyVal(PropertyVal object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Token</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Token</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseToken(Token object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Or Pattern</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Or Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseOrPattern(OrPattern object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Pattern</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseSimplePattern(SimplePattern object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Rule Pattern</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rule Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseRulePattern(RulePattern object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Rule</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseRule(Rule object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Word Rule</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Word Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseWordRule(WordRule object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Word</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Word</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseWord(Word object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>End Of Line Rule</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>End Of Line Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseEndOfLineRule(EndOfLineRule object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Multi Line Rule</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multi Line Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseMultiLineRule(MultiLineRule object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseMapping(Mapping object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Mapping</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseSimpleMapping(SimpleMapping object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Wildcard Mapping</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Wildcard Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseWildcardMapping(WildcardMapping object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Octal Mapping</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Octal Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseOctalMapping(OctalMapping object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Hexadecimal Mapping</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hexadecimal Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseHexadecimalMapping(HexadecimalMapping object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>String Pattern</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseStringPattern(StringPattern object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Class Pattern</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseClassPattern(ClassPattern object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Qualified Named Element</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Qualified Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseQualifiedNamedElement(QualifiedNamedElement object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Forced Upper PArg</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Forced Upper PArg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseForcedUpperPArg(ForcedUpperPArg object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Injector Actions Block</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Injector Actions Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseInjectorActionsBlock(InjectorActionsBlock object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Query PArg</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Query PArg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseQueryPArg(QueryPArg object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Filter PArg</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Filter PArg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseFilterPArg(FilterPArg object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Ocl PArg</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ocl PArg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseOclPArg(OclPArg object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Property Reference</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T casePropertyReference(PropertyReference object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Context Template</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Context Template</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseContextTemplate(ContextTemplate object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Context Tags</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Context Tags</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseContextTags(ContextTags object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Injector Action</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Injector Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseInjectorAction(InjectorAction object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Property Init</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Init</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T casePropertyInit(PropertyInit object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Ocl Property Init</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ocl Property Init</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseOclPropertyInit(OclPropertyInit object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Scope Arg</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scope Arg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseScopeArg(ScopeArg object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Invert PArg</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invert PArg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseInvertPArg(InvertPArg object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Foreach Predicate Property Init</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Foreach Predicate Property Init</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseForeachPredicatePropertyInit(ForeachPredicatePropertyInit object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Predicate Semantic</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Predicate Semantic</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T casePredicateSemantic(PredicateSemantic object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence In Alternative</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence In Alternative</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseSequenceInAlternative(SequenceInAlternative object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Partial PArg</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Partial PArg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T casePartialPArg(PartialPArg object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Disambiguate PArg</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Disambiguate PArg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseDisambiguatePArg(DisambiguatePArg object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Instance Of Exp</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instance Of Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseInstanceOfExp(InstanceOfExp object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Literal Val</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Literal Val</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseEnumLiteralVal(EnumLiteralVal object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>String Val</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Val</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseStringVal(StringVal object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Val</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Val</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseIntegerVal(IntegerVal object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Negative Integer Val</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Negative Integer Val</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseNegativeIntegerVal(NegativeIntegerVal object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>Lookup Property Init</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lookup Property Init</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
        public T caseLookupPropertyInit(LookupPropertyInit object) {
		return null;
	}

        /**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
         * This implementation returns null;
         * returning a non-null result will terminate the switch, but this is the last case anyway.
         * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
        public T defaultCase(EObject object) {
		return null;
	}

} //TCSSwitch

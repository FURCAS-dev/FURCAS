/**
 * <copyright>
 *
 * Copyright (c) 2002-2005 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */

package org.eclipse.emf.ocl.helper;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;

import antlr.ANTLRException;
import antlr.Token;
import antlr.TokenStream;
import antlr.TokenStreamException;

import org.eclipse.emf.ocl.expressions.AssociationClassCallExp;
import org.eclipse.emf.ocl.expressions.AssociationEndCallExp;
import org.eclipse.emf.ocl.expressions.AttributeCallExp;
import org.eclipse.emf.ocl.expressions.BooleanLiteralExp;
import org.eclipse.emf.ocl.expressions.CollectionKind;
import org.eclipse.emf.ocl.expressions.CollectionLiteralExp;
import org.eclipse.emf.ocl.expressions.EnumLiteralExp;
import org.eclipse.emf.ocl.expressions.ExpressionsFactory;
import org.eclipse.emf.ocl.expressions.IfExp;
import org.eclipse.emf.ocl.expressions.IntegerLiteralExp;
import org.eclipse.emf.ocl.expressions.IterateExp;
import org.eclipse.emf.ocl.expressions.IteratorExp;
import org.eclipse.emf.ocl.expressions.LetExp;
import org.eclipse.emf.ocl.expressions.OclExpression;
import org.eclipse.emf.ocl.expressions.OperationCallExp;
import org.eclipse.emf.ocl.expressions.RealLiteralExp;
import org.eclipse.emf.ocl.expressions.StringLiteralExp;
import org.eclipse.emf.ocl.expressions.TupleLiteralExp;
import org.eclipse.emf.ocl.expressions.UnspecifiedValueExp;
import org.eclipse.emf.ocl.expressions.VariableDeclaration;
import org.eclipse.emf.ocl.expressions.VariableExp;
import org.eclipse.emf.ocl.expressions.Visitor;
import org.eclipse.emf.ocl.expressions.util.ExpressionsUtil;
import org.eclipse.emf.ocl.internal.parser.OclLexer;
import org.eclipse.emf.ocl.internal.parser.OclParser;
import org.eclipse.emf.ocl.internal.parser.OclParserTokenTypes;
import org.eclipse.emf.ocl.internal.parser.OclToken;
import org.eclipse.emf.ocl.parser.EcoreEnvironment;
import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.parser.EnvironmentFactory;
import org.eclipse.emf.ocl.types.AnyType;
import org.eclipse.emf.ocl.types.BagType;
import org.eclipse.emf.ocl.types.CollectionType;
import org.eclipse.emf.ocl.types.MessageType;
import org.eclipse.emf.ocl.types.ModelElementType;
import org.eclipse.emf.ocl.types.OrderedSetType;
import org.eclipse.emf.ocl.types.PrimitiveBoolean;
import org.eclipse.emf.ocl.types.PrimitiveInteger;
import org.eclipse.emf.ocl.types.PrimitiveReal;
import org.eclipse.emf.ocl.types.PrimitiveString;
import org.eclipse.emf.ocl.types.PrimitiveType;
import org.eclipse.emf.ocl.types.SequenceType;
import org.eclipse.emf.ocl.types.SetType;
import org.eclipse.emf.ocl.types.TupleType;
import org.eclipse.emf.ocl.types.VoidType;
import org.eclipse.emf.ocl.types.util.TypesSwitch;
import org.eclipse.emf.ocl.uml.AssociationClassEnd;
import org.eclipse.emf.ocl.uml.Constraint;

/**
 * Engine for computation of possible syntax completions at a point in the
 * an OCL expression.
 * 
 * @author Yasser Lulu 
 * @author Christian W. Damus (cdamus)
 */
final class OclSyntaxHelper {

	private static final int NONE = -1;

	private static final int DOT = 0;

	private static final int ARROW = 1;

	private static final int DOUBLE_COLON = 2;

	//collection
	private static final Choice COLLECTION_SIZE = new Choice("size", //$NON-NLS-1$
		"size() : Integer", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice INCLUDES = new Choice("includes", //$NON-NLS-1$
		"includes(object : OclAny) : Boolean", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice EXCLUDES = new Choice("excludes", //$NON-NLS-1$
		"excludes(object : OclAny) : Boolean", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice COUNT = new Choice("count", //$NON-NLS-1$
		"count(object : OclAny) : Integer", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice INCLUDES_ALL = new Choice("includesAll", //$NON-NLS-1$
		"includesAll(c : Collection(T)) : Boolean", //$NON-NLS-1$
		ChoiceType.BEHAVIORAL_FEATURE);

	private static final Choice EXCLUDES_ALL = new Choice("excludesAll", //$NON-NLS-1$
		"excludesAll(c : Collection(T)) : Boolean", //$NON-NLS-1$
		ChoiceType.BEHAVIORAL_FEATURE);

	private static final Choice IS_EMPTY = new Choice("isEmpty", //$NON-NLS-1$
		"isEmpty() : Boolean", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice NOT_EMPTY = new Choice("notEmpty", //$NON-NLS-1$
		"notEmpty() : Boolean", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice SUM = new Choice("sum", "sum() : T", //$NON-NLS-2$//$NON-NLS-1$
		ChoiceType.BEHAVIORAL_FEATURE);

	private static final Choice PRODUCT = new Choice("product", //$NON-NLS-1$
		"product(c2: Collection(T2)) : Set( Tuple( first: T, second: T2) )", //$NON-NLS-1$
		ChoiceType.BEHAVIORAL_FEATURE);

	//collection_iterator
	private static final Choice EXISTS = new Choice("exists", //$NON-NLS-1$
		"exists(expr : OclExpression) : Boolean", //$NON-NLS-1$
		ChoiceType.BEHAVIORAL_FEATURE);

	private static final Choice FOR_ALL = new Choice("forAll", //$NON-NLS-1$
		"forAll(expr : OclExpression) : Boolean", //$NON-NLS-1$
		ChoiceType.BEHAVIORAL_FEATURE);

	private static final Choice IS_UNIQUE = new Choice("isUnique", //$NON-NLS-1$
		"isUnique(expr : OclExpression) : Boolean", //$NON-NLS-1$
		ChoiceType.BEHAVIORAL_FEATURE);

	private static final Choice ITERATE = new Choice("iterate", //$NON-NLS-1$
		"iterate(expr : OclExpression) : expr.evaluationType()", //$NON-NLS-1$
		ChoiceType.BEHAVIORAL_FEATURE);

	private static final Choice ANY = new Choice("any", //$NON-NLS-1$
		"any(expr : OclExpression) : T", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice ONE = new Choice("one", //$NON-NLS-1$
		"one(expr : OclExpression) : Boolean", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice COLLECT = new Choice("collect", //$NON-NLS-1$
		"collect(expr : OclExpression) : Collection(expr.evaluationType())", //$NON-NLS-1$
		ChoiceType.BEHAVIORAL_FEATURE);

	//common: set + bag 
	private static final Choice UNION_BAG_BAG = new Choice("union", //$NON-NLS-1$
		"union(bag : Bag(T)) : Bag(T)", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice INTERSECTION_SET_SET = new Choice(
		"intersection", "intersection(set : Set(T)) : Set(T)", //$NON-NLS-2$//$NON-NLS-1$
		ChoiceType.BEHAVIORAL_FEATURE);

	//set
	private static final Choice FLATTEN_SET = new Choice("flatten", //$NON-NLS-1$
		"flatten() : Set(T2)", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice UNION_SET_SET = new Choice("union", //$NON-NLS-1$
		"union(set : Set(T)) : Set(T)", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice INTERSECTION_BAG_SET = new Choice(
		"intersection", "intersection(bag : Bag(T)) : Set(T)", //$NON-NLS-2$//$NON-NLS-1$
		ChoiceType.BEHAVIORAL_FEATURE);

	private static final Choice SYMMETRIC_DIFF_SET_SET = new Choice(
		"symmetricDifference", "symmetricDifference(set : Set(T)) : Set(T)", //$NON-NLS-2$//$NON-NLS-1$
		ChoiceType.BEHAVIORAL_FEATURE);

	private static final Choice INCLUDING_SET = new Choice("including", //$NON-NLS-1$
		"including(object : T) : Set(T)", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice EXCLUDING_SET = new Choice("excluding", //$NON-NLS-1$
		"including(object : T) : Set(T)", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	//set-iterator
	private static final Choice SELECT_SET = new Choice("select", //$NON-NLS-1$
		"select(expr : OclExpression) : Set(T)", //$NON-NLS-1$
		ChoiceType.BEHAVIORAL_FEATURE);

	private static final Choice REJECT_SET = new Choice("reject", //$NON-NLS-1$
		"reject(expr : OclExpression) : Set(T)", //$NON-NLS-1$
		ChoiceType.BEHAVIORAL_FEATURE);

	private static final Choice SORTED_BY_ORDESET = new Choice(
		"sortedBy", "sortedBy(expr : OclExpression) : OrderedSet(T)", //$NON-NLS-2$//$NON-NLS-1$
		ChoiceType.BEHAVIORAL_FEATURE);

	//common: set-iterator + bag-iterator
	private static final Choice COLLECT_NESTED_BAG = new Choice(
		"collectNested", //$NON-NLS-1$
		"collectNested(expr : OclExpression) : Bag(expr.evaluationType())", //$NON-NLS-1$
		ChoiceType.BEHAVIORAL_FEATURE);

	//common: set + sequence + bag
	private static final Choice AS_SEQUENCE = new Choice("asSequence", //$NON-NLS-1$
		"asSequence() : Sequence(T)", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice AS_BAG = new Choice("asBag", //$NON-NLS-1$
		"asBag() : Bag(T)", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice AS_SET = new Choice("asSet", //$NON-NLS-1$
		"asSet() : Set(T)", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice AS_ORDERED_SET = new Choice(
		"asOrderedSet", "asOrderedSet() : OrderedSet(T)", //$NON-NLS-2$//$NON-NLS-1$
		ChoiceType.BEHAVIORAL_FEATURE);

	//common: orderedSet + sequence 
	private static final Choice AT = new Choice("at", //$NON-NLS-1$
		"at(i : Integer) : T", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice FIRST = new Choice("first", //$NON-NLS-1$
		"first() : T", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice LAST = new Choice("last", "last() : T", //$NON-NLS-2$//$NON-NLS-1$
		ChoiceType.BEHAVIORAL_FEATURE);

	private static final Choice INDEX_OF = new Choice("indexOf", //$NON-NLS-1$
		"indexOf(obj : T) : Integer)", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	//sequence
	private static final Choice UNION_SEQ_SEQ = new Choice("union", //$NON-NLS-1$
		"union(s : Sequence(T)) : Sequence(T)", //$NON-NLS-1$
		ChoiceType.BEHAVIORAL_FEATURE);

	private static final Choice APPEND_SEQ = new Choice("append", //$NON-NLS-1$
		"append(object : T) : Sequence(T)", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice PREPEND_SEQ = new Choice("prepend", //$NON-NLS-1$
		"prepend(object : T) : Sequence(T)", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice SUB_SEQ = new Choice("subSequence", //$NON-NLS-1$
		"subSequence(lower : Integer, upper : Integer) : Sequence(T)", //$NON-NLS-1$
		ChoiceType.BEHAVIORAL_FEATURE);

	private static final Choice INCLUDING_SEQ = new Choice("including", //$NON-NLS-1$
		"including(object : T) : Sequence(T)", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice EXCLUDING_SEQ = new Choice("excluding", //$NON-NLS-1$
		"including(object : T) : Sequence(T)", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice FLATTEN_SEQ = new Choice("flatten", //$NON-NLS-1$
		"flatten() : Sequence(T2))", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice INSERT_AT_SEQ = new Choice("insertAt", //$NON-NLS-1$
		"insertAt(index : Integer, object : T) : Sequence(T))", //$NON-NLS-1$
		ChoiceType.BEHAVIORAL_FEATURE);

	//sequence-iterator	
	private static final Choice SELECT_SEQ = new Choice("select", //$NON-NLS-1$
		"select(expr : OclExpression) : Sequence(T)", //$NON-NLS-1$
		ChoiceType.BEHAVIORAL_FEATURE);

	private static final Choice REJECT_SEQ = new Choice("reject", //$NON-NLS-1$
		"reject(expr : OclExpression) : Sequence(T)", //$NON-NLS-1$
		ChoiceType.BEHAVIORAL_FEATURE);

	private static final Choice COLLECT_NESTED_SEQ = new Choice(
		"collectNested", //$NON-NLS-1$
		"collectNested(expr : OclExpression) : Sequence(expr.evaluationType())", //$NON-NLS-1$
		ChoiceType.BEHAVIORAL_FEATURE);

	//common: sequence-iterator + bag-iterator
	private static final Choice SORTED_BY_SEQ = new Choice("sortedBy", //$NON-NLS-1$
		"sortedBy(expr : OclExpression) : Sequence(T)", //$NON-NLS-1$
		ChoiceType.BEHAVIORAL_FEATURE);

	//bag
	private static final Choice UNION_SET_BAG = new Choice("union", //$NON-NLS-1$
		"union(set : Set(T)) : Bag(T)", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice INTERSECTION_BAG_BAG = new Choice(
		"intersection", "intersection(bag : Bag(T)) : Bag(T)", //$NON-NLS-2$//$NON-NLS-1$
		ChoiceType.BEHAVIORAL_FEATURE);

	private static final Choice INCLUDING_BAG = new Choice("including", //$NON-NLS-1$
		"including(object : T) : Bag(T)", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice EXCLUDING_BAG = new Choice("excluding", //$NON-NLS-1$
		"including(object : T) : Bag(T)", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice FLATTEN_BAG = new Choice("flatten", //$NON-NLS-1$
		"flatten() : Bag(T2)", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	//bag-iterator
	private static final Choice SELECT_BAG = new Choice("select", //$NON-NLS-1$
		"select(expr : OclExpression) : Bag(T)", //$NON-NLS-1$
		ChoiceType.BEHAVIORAL_FEATURE);

	private static final Choice REJECT_BAG = new Choice("reject", //$NON-NLS-1$
		"reject(expr : OclExpression) : Bag(T)", //$NON-NLS-1$
		ChoiceType.BEHAVIORAL_FEATURE);

	//orderedSet    
	private static final Choice APPEND_ORDSET = new Choice("append", //$NON-NLS-1$
		"append(object : T) : OrderedSet(T)", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice PREPEND_ORDSET = new Choice("prepend", //$NON-NLS-1$
		"prepend(object : T) : OrderedSet(T)", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice SUB_ORDSET = new Choice("subOrderedSet", //$NON-NLS-1$
		"subOrderedSet(lower : Integer, upper : Integer) : OrderedSet(T)", //$NON-NLS-1$
		ChoiceType.BEHAVIORAL_FEATURE);

	private static final Choice INSERT_AT_ORDSET = new Choice("insertAt", //$NON-NLS-1$
		"insertAt(index : Integer, object : T) : OrderedSet(T))", //$NON-NLS-1$
		ChoiceType.BEHAVIORAL_FEATURE);

	//OclAny
	private static final Choice IS_KIND_OF = new Choice("oclIsKindOf", //$NON-NLS-1$
		"oclIsKindOf(type : OclType) : Boolean", //$NON-NLS-1$
		ChoiceType.BEHAVIORAL_FEATURE);

	private static final Choice IS_TYPE_OF = new Choice("oclIsTypeOf", //$NON-NLS-1$
		"oclIsTypeOf(type : OclType) : Boolean", //$NON-NLS-1$
		ChoiceType.BEHAVIORAL_FEATURE);

	private static final Choice AS_TYPE = new Choice("oclAsType", //$NON-NLS-1$
		"oclAsType(type : OclType) : type", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

//  RATLC00529981: Hide this choice until we can support it in the OCL parser
//	private static final Choice IN_STATE = new Choice("oclIsInState", //$NON-NLS-1$
//		"oclIsInState(state : OclState) : Boolean", //$NON-NLS-1$
//		ChoiceType.BEHAVIORAL_FEATURE);
//
	private static final Choice IS_NEW = new Choice("oclIsNew", //$NON-NLS-1$
		"oclIsNew() : Boolean", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice IS_UNDEFINED = new Choice(
		"oclIsUndefined", "oclIsUndefined() : Boolean", //$NON-NLS-2$//$NON-NLS-1$
		ChoiceType.BEHAVIORAL_FEATURE);

	private static final Choice ALL_INSTANCES = new Choice(
		"allInstances", "allInstances() : Set( T )", //$NON-NLS-2$//$NON-NLS-1$
		ChoiceType.BEHAVIORAL_FEATURE);

	//OclReal
	private static final Choice ABS_REAL = new Choice("abs", //$NON-NLS-1$
		"abs() : Real", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice FLOOR = new Choice("floor", //$NON-NLS-1$
		"floor() : Integer", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice ROUND = new Choice("round", //$NON-NLS-1$
		"round() : Integer", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice MAX_REAL = new Choice("max", //$NON-NLS-1$
		"max(r : Real) : Real", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice MIN_REAL = new Choice("min", //$NON-NLS-1$
		"min(r : Real) : Real", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	//OclInteger
	private static final Choice ABS_INT = new Choice("abs", //$NON-NLS-1$
		"abs() : Integer", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice DIV = new Choice("div", //$NON-NLS-1$
		"div(i : Integer) : Integer", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice MOD = new Choice("mod", //$NON-NLS-1$
		"mod(i : Integer) : Integer", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice MAX_INT = new Choice("max", //$NON-NLS-1$
		"max(i : Integer) : Integer", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice MIN_INT = new Choice("min", //$NON-NLS-1$
		"min(i : Integer) : Integer", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	//OclString
	private static final Choice STRING_SIZE = new Choice("size", //$NON-NLS-1$
		"size() : Integer", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice CONCAT = new Choice("concat", //$NON-NLS-1$
		"concat(s : String) : String", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice TO_UPPER = new Choice("toUpper", //$NON-NLS-1$
		"toUpper() : String", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice TO_LOWER = new Choice("toLower", //$NON-NLS-1$
		"toLower() : String", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice SUBSTRING = new Choice("substring", //$NON-NLS-1$
		"substring(lower : Integer, upper : Integer) : String", //$NON-NLS-1$
		ChoiceType.BEHAVIORAL_FEATURE);

	private static final Choice TO_INT = new Choice("toInteger", //$NON-NLS-1$
		"toInteger() : Integer", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice TO_REAL = new Choice("toReal", //$NON-NLS-1$
		"toReal() : Real", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	//OclBoolean: NOTE: a space is added intentioanlly at the beginning of the Choice name
	private static final Choice OR = new Choice(" or", //$NON-NLS-1$
		"or(b : Boolean) : Boolean", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice XOR = new Choice(" xor", //$NON-NLS-1$
		"xor(b : Boolean) : Boolean", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice AND = new Choice(" and", //$NON-NLS-1$
		"and(b : Boolean) : Boolean", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	private static final Choice NOT = new Choice(" not", "not : Boolean", //$NON-NLS-2$//$NON-NLS-1$
		ChoiceType.BEHAVIORAL_FEATURE);

	private static final Choice IMPLIES = new Choice(" implies", //$NON-NLS-1$
		"implies(b : Boolean) : Boolean", ChoiceType.BEHAVIORAL_FEATURE);//$NON-NLS-1$

	//	collections
	private static List collectionOclChoices;

	private static List sequenceOclChoices;

	private static List setOclChoices;

	private static List bagOclChoices;

	private static List orderedSetOclChoices;

	//primitives
	private static List booleanOclChoices;

	private static List stringOclChoices;

	private static List integerOclChoices;

	private static List realOclChoices;

	//OclAny
	private static List oclAnyOclChoices;

	private int syntaxHelpStringSuffix;

	private TypesSwitch oclTypesSwitch;

	private EnvironmentFactory environmentFactory;
	
	private Environment environment;

	OclSyntaxHelper(EnvironmentFactory factory) {
		environmentFactory = factory;
	}

	/**
	 * return collection applicable operations (syntax help)
	 * @return List
	 */
	private static List getCollectionOclChoices() {
		if (collectionOclChoices == null) {
			collectionOclChoices = new ArrayList();
			collectionOclChoices.add(COLLECTION_SIZE);
			collectionOclChoices.add(INCLUDES);
			collectionOclChoices.add(EXCLUDES);
			collectionOclChoices.add(COUNT);
			collectionOclChoices.add(INCLUDES_ALL);
			collectionOclChoices.add(EXCLUDES_ALL);
			collectionOclChoices.add(IS_EMPTY);
			collectionOclChoices.add(NOT_EMPTY);
			collectionOclChoices.add(SUM);
			collectionOclChoices.add(PRODUCT);
			collectionOclChoices.add(EXISTS);
			collectionOclChoices.add(FOR_ALL);
			collectionOclChoices.add(IS_UNIQUE);
			collectionOclChoices.add(ITERATE);
			collectionOclChoices.add(ANY);
			collectionOclChoices.add(ONE);
			collectionOclChoices.add(COLLECT);
		}
		return collectionOclChoices;
	}

	/**
	 * return sequence applicable operations (syntax help)
	 * 
	 * @return a list of {@link Choice}s
	 */
	private static List getSequenceOclChoices() {
		if (sequenceOclChoices == null) {
			sequenceOclChoices = new ArrayList();
			sequenceOclChoices.addAll(getCollectionOclChoices());
			sequenceOclChoices.add(AT);
			sequenceOclChoices.add(FIRST);
			sequenceOclChoices.add(LAST);
			sequenceOclChoices.add(INDEX_OF);
			sequenceOclChoices.add(UNION_SEQ_SEQ);
			sequenceOclChoices.add(APPEND_SEQ);
			sequenceOclChoices.add(PREPEND_SEQ);
			sequenceOclChoices.add(SUB_SEQ);
			sequenceOclChoices.add(INCLUDING_SEQ);
			sequenceOclChoices.add(EXCLUDING_SEQ);
			sequenceOclChoices.add(FLATTEN_SEQ);
			sequenceOclChoices.add(INSERT_AT_SEQ);
			sequenceOclChoices.add(SELECT_SEQ);
			sequenceOclChoices.add(REJECT_SEQ);
			sequenceOclChoices.add(COLLECT_NESTED_SEQ);
			sequenceOclChoices.add(SORTED_BY_SEQ);
			sequenceOclChoices.add(AS_SEQUENCE);
			sequenceOclChoices.add(AS_BAG);
			sequenceOclChoices.add(AS_SET);
			sequenceOclChoices.add(AS_ORDERED_SET);
		}
		return sequenceOclChoices;
	}

	/**
	 * return set applicable operations (syntax help)
	 * 
	 * @return a list of {@link Choice}s
	 */
	private static List getSetOclChoices() {
		if (setOclChoices == null) {
			setOclChoices = new ArrayList();
			setOclChoices.addAll(getCollectionOclChoices());
			setOclChoices.add(FLATTEN_SET);
			setOclChoices.add(UNION_SET_SET);
			setOclChoices.add(INTERSECTION_BAG_SET);
			setOclChoices.add(SYMMETRIC_DIFF_SET_SET);
			setOclChoices.add(INCLUDING_SET);
			setOclChoices.add(EXCLUDING_SET);
			setOclChoices.add(UNION_BAG_BAG);
			setOclChoices.add(INTERSECTION_SET_SET);
			setOclChoices.add(SELECT_SET);
			setOclChoices.add(REJECT_SET);
			setOclChoices.add(SORTED_BY_ORDESET);
			setOclChoices.add(COLLECT_NESTED_BAG);
			setOclChoices.add(AS_SEQUENCE);
			setOclChoices.add(AS_BAG);
			setOclChoices.add(AS_SET);
			setOclChoices.add(AS_ORDERED_SET);
		}
		return setOclChoices;
	}

	/**
	 * return bag applicable operations (syntax help)
	 * 
	 * @return a list of {@link Choice}s
	 */
	private static List getBagOclChoices() {
		if (bagOclChoices == null) {
			bagOclChoices = new ArrayList();
			bagOclChoices.addAll(getCollectionOclChoices());
			bagOclChoices.add(UNION_SET_BAG);
			bagOclChoices.add(INTERSECTION_BAG_BAG);
			bagOclChoices.add(INCLUDING_BAG);
			bagOclChoices.add(EXCLUDING_BAG);
			bagOclChoices.add(FLATTEN_BAG);
			bagOclChoices.add(SELECT_BAG);
			bagOclChoices.add(REJECT_BAG);
			bagOclChoices.add(UNION_BAG_BAG);
			bagOclChoices.add(INTERSECTION_SET_SET);
			bagOclChoices.add(SORTED_BY_SEQ);
			bagOclChoices.add(COLLECT_NESTED_BAG);
			bagOclChoices.add(AS_SEQUENCE);
			bagOclChoices.add(AS_BAG);
			bagOclChoices.add(AS_SET);
			bagOclChoices.add(AS_ORDERED_SET);
		}
		return bagOclChoices;
	}

	/**
	 * return ordered-set applicable operations (syntax help)
	 * 
	 * @return a list of {@link Choice}s
	 */
	private static List getOrderedSetOclChoices() {
		if (orderedSetOclChoices == null) {
			orderedSetOclChoices = new ArrayList();
			orderedSetOclChoices.addAll(getCollectionOclChoices());
			orderedSetOclChoices.add(AT);
			orderedSetOclChoices.add(FIRST);
			orderedSetOclChoices.add(LAST);
			orderedSetOclChoices.add(INDEX_OF);
			orderedSetOclChoices.add(APPEND_ORDSET);
			orderedSetOclChoices.add(PREPEND_ORDSET);
			orderedSetOclChoices.add(SUB_ORDSET);
			orderedSetOclChoices.add(INSERT_AT_ORDSET);
		}
		return orderedSetOclChoices;
	}

	/** 
	 * return boolean applicable operations (syntax help)
	 * 
	 * @return a list of {@link Choice}s
	 */
	private static List getBooleanOclChoices() {
		if (booleanOclChoices == null) {
			booleanOclChoices = new ArrayList();
			//            choices.addAll(getOclAnyOclChoices());
			booleanOclChoices.add(OR);
			booleanOclChoices.add(XOR);
			booleanOclChoices.add(AND);
			booleanOclChoices.add(NOT);
			booleanOclChoices.add(IMPLIES);
		}
		return booleanOclChoices;
	}

	/**
	 * return integer applicable operations (syntax help)
	 * 
	 * @return a list of {@link Choice}s
	 */
	private static List getIntegerOclChoices() {
		if (integerOclChoices == null) {
			integerOclChoices = new ArrayList();
			integerOclChoices.addAll(getOclAnyOclChoices());
			integerOclChoices.add(ABS_INT);
			integerOclChoices.add(DIV);
			integerOclChoices.add(MOD);
			integerOclChoices.add(MAX_INT);
			integerOclChoices.add(MIN_INT);
		}
		return integerOclChoices;
	}

	/**
	 * return real applicable operations (syntax help)
	 * 
	 * @return a list of {@link Choice}s
	 */
	private static List getRealOclChoices() {
		if (realOclChoices == null) {
			realOclChoices = new ArrayList();
			realOclChoices.addAll(getOclAnyOclChoices());
			realOclChoices.add(ABS_REAL);
			realOclChoices.add(FLOOR);
			realOclChoices.add(ROUND);
			realOclChoices.add(MAX_REAL);
			realOclChoices.add(MIN_REAL);
		}
		return realOclChoices;
	}

	/**
	 * return string applicable operations (syntax help)
	 * 
	 * @return a list of {@link Choice}s
	 */
	private static List getStringOclChoices() {
		if (stringOclChoices == null) {
			stringOclChoices = new ArrayList();
			stringOclChoices.addAll(getOclAnyOclChoices());
			stringOclChoices.add(STRING_SIZE);
			stringOclChoices.add(CONCAT);
			stringOclChoices.add(TO_UPPER);
			stringOclChoices.add(TO_LOWER);
			stringOclChoices.add(SUBSTRING);
			stringOclChoices.add(TO_INT);
			stringOclChoices.add(TO_REAL);
		}
		return stringOclChoices;
	}

	/**
	 * return OclAny applicable operations (syntax help)
	 * 
	 * @return a list of {@link Choice}s
	 */
	private static List getOclAnyOclChoices() {
		if (oclAnyOclChoices == null) {
			oclAnyOclChoices = new ArrayList();
			oclAnyOclChoices.add(IS_KIND_OF);
			oclAnyOclChoices.add(IS_TYPE_OF);
			oclAnyOclChoices.add(AS_TYPE);
//			oclAnyOclChoices.add(IN_STATE);
			oclAnyOclChoices.add(IS_NEW);
			oclAnyOclChoices.add(IS_UNDEFINED);
			oclAnyOclChoices.add(ALL_INSTANCES);
		}
		return oclAnyOclChoices;
	}

	/**
	 * return OclAny applicable operations (syntax help)
	 * 
	 * @return a list of {@link Choice}s
	 */
	private List getBasicOclChoices() {
		if (syntaxHelpStringSuffix == ARROW) {
			return getSetOclChoices();
		} else if (syntaxHelpStringSuffix == DOT) {
			return getOclAnyOclChoices();
		} else {
			return Collections.EMPTY_LIST;
		}
	}

	private class OclASTVisitor
		implements Visitor {

		private final int completionPosition;
		private final String text;
		private final ConstraintType constraintType;
		
		/**
		 * Initializes me with the position at which we are trying to find
		 * completions and the text that we are completing.
		 * 
		 * @param text the text to complete
		 * @param position the completion position
		 * @param constraintType the type of constraint that we are completing
		 */
		OclASTVisitor(String text, int position, ConstraintType constraintType) {
			this.text = text;
			completionPosition = position;
			this.constraintType = constraintType;
		}
		
		public Object visitAttributeCallExp(AttributeCallExp exp) {
			return getOclChoices(exp, constraintType);
		}

		public Object visitOperationCallExp(OperationCallExp exp) {
			if (exp.getEndPosition() == completionPosition) {
				// we may be looking at a binary operation (such as "=" or "and")
				//   in which case we need to see whether the last argument
				//   is actually what needs to be completed
				List args = exp.getArguments();
				
				if (!args.isEmpty()) {
					OclExpression last = (OclExpression) args.get(args.size() - 1);
					if (last.getEndPosition() == completionPosition) {
						// complete this argument, instead
						return last.accept(this);
					}
				}
			}
			
			return getOclChoices(exp, constraintType);
		}

		public Object visitVariableExp(VariableExp variableexp) {
			return getOclChoices(variableexp, constraintType);
		}

		public Object visitAssociationEndCallExp(
			AssociationEndCallExp associationendcallexp) {
			return getOclChoices(associationendcallexp, constraintType);
		}

		public Object visitAssociationClassCallExp(
			AssociationClassCallExp exp) {
			return getOclChoices(exp, constraintType);
		}

		public Object visitVariableDeclaration(
			VariableDeclaration variabledeclaration) {
			return Collections.EMPTY_LIST;
		}

		public Object visitIfExp(IfExp exp) {
			if (text.charAt(exp.getEndPosition() - 1) == ')') {
				return getOclChoices(exp, constraintType);
			}
			
			return Collections.EMPTY_LIST;
		}

		public Object visitUnspecifiedValueExp(
			UnspecifiedValueExp unspecifiedvalueexp) {
			return getOclChoices(unspecifiedvalueexp, constraintType);
		}

		public Object visitIntegerLiteralExp(IntegerLiteralExp integerliteralexp) {
			return getIntegerOclChoices();
		}

		public Object visitRealLiteralExp(RealLiteralExp realliteralexp) {
			return getRealOclChoices();
		}

		public Object visitStringLiteralExp(StringLiteralExp stringliteralexp) {
			return getStringOclChoices();
		}

		public Object visitBooleanLiteralExp(BooleanLiteralExp booleanliteralexp) {
			return getOclChoices(booleanliteralexp, constraintType);
		}

		public Object visitTupleLiteralExp(TupleLiteralExp tupleliteralexp) {
			return getOclChoices(tupleliteralexp, constraintType);
		}

		public Object visitLetExp(LetExp letexp) {
			return getOclChoices(letexp.getType(), constraintType);
		}

		public Object visitEnumLiteralExp(EnumLiteralExp enumliteralexp) {
			return getOclChoices(enumliteralexp, constraintType);
		}

		public Object visitCollectionLiteralExp(
			CollectionLiteralExp collectionliteralexp) {
			org.eclipse.emf.ocl.expressions.CollectionKind kind = collectionliteralexp
				.getKind();
			switch (kind.getValue()) {
				case CollectionKind.BAG: {
					return getOclTypesSwitch().caseBagType(null);
				}
				case CollectionKind.COLLECTION: {
					return getOclTypesSwitch().caseCollectionType(null);
				}
				case CollectionKind.SET: {
					return getOclTypesSwitch().caseSetType(null);
				}
				case CollectionKind.SEQUENCE: {
					return getOclTypesSwitch().caseSequenceType(null);
				}
				case CollectionKind.ORDERED_SET: {
					return getOclTypesSwitch().caseOrderedSetType(null);
				}
				default:
					HelperUtil.throwException(new IllegalArgumentException(
						"Unknown collection type"), getClass(), //$NON-NLS-1$
						"visitCollectionLiteralExp"); //$NON-NLS-1$
			}
			return Collections.EMPTY_LIST;
		}

		public Object visitIteratorExp(IteratorExp exp) {
			if (exp.getEndPosition() == completionPosition) {
				// return completion on the entire expression
				return getOclChoices(exp.getType(), constraintType);
			}
			
			// otherwise, we are completing something within the expression body
			return exp.getBody().accept(this);
		}

		public Object visitIterateExp(IterateExp exp) {
			if (exp.getEndPosition() == completionPosition) {
				// the result type of an iterate expression is the type of the
				//    accumulator variable
				return getOclChoices(exp.getType(), constraintType);
			}
			
			// otherwise, we are completing something within the expression body
			return exp.getBody().accept(this);
		}
		
		public Object visitConstraint(Constraint constraint) {
			return Collections.EMPTY_LIST;
		}
	} //OclASTVisitor class

	private class OclTypesSwitch
		extends TypesSwitch {
		
		public Object caseAnyType(AnyType object) {
			return getBasicOclChoices();
		}

		public Object caseBagType(BagType object) {
			return (syntaxHelpStringSuffix == ARROW) ? getBagOclChoices()
				: Collections.EMPTY_LIST;
		}

		public Object caseCollectionType(CollectionType object) {
			return (syntaxHelpStringSuffix == ARROW) ? getCollectionOclChoices()
				: Collections.EMPTY_LIST;
		}

		public Object caseEClass(EClass object) {
			if (syntaxHelpStringSuffix == ARROW) {
				return getSetOclChoices();
			} else if (syntaxHelpStringSuffix == DOT) {
				List list = getOclChoicesForEClassEStructuralFeatures(object);
				list.addAll(getOclChoicesForEClassEOperations(object));
				list.addAll(getOclAnyOclChoices());
				return list;
			} else {
				return Collections.EMPTY_LIST;
			}
		}

		/**
		 * returns the oclchoices list of structural features for the passed eclass
		 * @param eClass the eclass to get features from 
		 * @return List oclchoices list for structural features
		 */
		private List getOclChoicesForEClassEStructuralFeatures(EClass eClass) {
			List list = new ArrayList();
			Set features = new HashSet(eClass.getEAllStructuralFeatures());
			features.removeAll(EcorePackage.eINSTANCE.getEModelElement()
				.getEAllStructuralFeatures());
			Iterator it = features.iterator();
			EStructuralFeature eFeature = null;
			while (it.hasNext()) {
				eFeature = (EStructuralFeature) it.next();
				list
					.add(new Choice(
						eFeature.getName(),
						getDescription(eFeature),
						(eFeature.getEType() instanceof EEnum) ? ChoiceType.ENUMERATION_LITERAL
							: ChoiceType.STRUCTURAL_FEATURE));
				
				// handle association class ends
				if (eFeature instanceof AssociationClassEnd) {
					EClass assocClass = ((AssociationClassEnd) eFeature).getAssociationClass();
					String name = EcoreEnvironment.initialLower(assocClass);
					
					Choice choice = new Choice(
						name,
						getDescription(assocClass),
						ChoiceType.STRUCTURAL_FEATURE);
					
					// don't repeat in case we have multiple ends of this
					//    association class
					if (!list.contains(choice)) {
						list.add(choice);
					}
				}
			}
			return list;
		}

		/**
		 * returns the oclchoices list of eoperations for the passed eclass
		 * @param eClass the eclass to get eoperations from 
		 * @return Collection oclchoices collection for eoperations
		 */
		private Collection getOclChoicesForEClassEOperations(EClass eClass) {
			Map operationsMap = new HashMap();
			Set operations = new HashSet(eClass.getEAllOperations());
			operations.removeAll(EcorePackage.eINSTANCE.getEModelElement()
				.getEAllOperations());
			Iterator it = operations.iterator();
			EOperation eOperation = null;
			String description = null;
			while (it.hasNext()) {
				eOperation = (EOperation) it.next();
				
				if (isQuery(eOperation)) {
					description = getEOperationDescription(eOperation);
					operationsMap.put(description, new Choice(eOperation
						.getName(), description, ChoiceType.BEHAVIORAL_FEATURE));
				}
			}
			return operationsMap.values();
		}
		
		/**
		 * Determines whether an operation is a query, if this is a user-model
		 * syntax helper.
		 * 
		 * @param operation an operation
		 * @return <code>true</code> if either we are a metamodel helper or
		 *    the user-model operation is a query; <code>false</code>, otherwise
		 */
		private boolean isQuery(EOperation operation) {
			return EcoreEnvironment.isQuery(operation);
		}

		private String getEOperationDescription(EOperation eOperation) {
			StringBuffer signature = new StringBuffer(eOperation.getName()
				+ HelperUtil.OPEN_PARENTHESE);
			List parameters = eOperation.getEParameters();
			if (parameters.isEmpty() == false) {
				Iterator it = parameters.iterator();
				EParameter eParameter = null;
				while (it.hasNext()) {
					eParameter = (EParameter) it.next();
					signature.append(eParameter.getName()).append(
						HelperUtil.SEPARATOR).append(
						(eParameter.getEType() == null) ? HelperUtil.VOID
							: getDescription(eParameter));
					if (it.hasNext()) {
						signature.append(HelperUtil.COMMA);
					}
				}
			}
			return signature
				.append(HelperUtil.CLOSE_PARENTHESE)
				.append(
					(eOperation.getEType() == null) ? HelperUtil.VOID
						: (HelperUtil.SEPARATOR + getDescription(eOperation)))
				.toString();
		}

		/**
		 * @see org.eclipse.emf.ocl.types.util.TypesSwitch#caseEClassifier(org.eclipse.emf.ecore.EClassifier)
		 */
		public Object caseEClassifier(EClassifier object) {
			return getBasicOclChoices();
		}

		/**
		 * @see org.eclipse.emf.ocl.types.util.TypesSwitch#caseEDataType(org.eclipse.emf.ecore.EDataType)
		 */
		public Object caseEDataType(EDataType object) {
			if (syntaxHelpStringSuffix == ARROW) {
				return getSetOclChoices();
			} else if (object instanceof EEnum) {
				return caseEClassifier(null);
			} else if (syntaxHelpStringSuffix == DOT) {
				Class instanceClass = object.getInstanceClass();
				if (instanceClass == java.lang.Boolean.class
					|| instanceClass == Boolean.TYPE) {
					return casePrimitiveBoolean(null);
				} else if (instanceClass == java.lang.Double.class
					|| instanceClass == Double.TYPE
					|| instanceClass == java.lang.Float.class
					|| instanceClass == Float.TYPE) {
					return casePrimitiveReal(null);
				} else if (instanceClass == java.lang.String.class) {
					return casePrimitiveString(null);
				} else if (instanceClass == java.lang.Integer.class
					|| instanceClass == Integer.TYPE
					|| instanceClass == java.lang.Long.class
					|| instanceClass == Long.TYPE
					|| instanceClass == java.lang.Short.class
					|| instanceClass == Short.TYPE) {
					return casePrimitiveInteger(null);
				} else if (List.class.isAssignableFrom(instanceClass)) {
					return caseOrderedSetType(null);
				} else if (Set.class.isAssignableFrom(instanceClass)) {
					return caseSetType(null);
				} else if (Collection.class.isAssignableFrom(instanceClass)) {
					return caseCollectionType(null);
				} else {
					return getOclAnyOclChoices();
				}
			} else {
				return Collections.EMPTY_LIST;
			}

		}

		/**
		 * @see org.eclipse.emf.ocl.types.util.TypesSwitch#caseEModelElement(org.eclipse.emf.ecore.EModelElement)
		 */
		public Object caseEModelElement(EModelElement object) {
			return getBasicOclChoices();
		}

		/**
		 * @see org.eclipse.emf.ocl.types.util.TypesSwitch#caseENamedElement(org.eclipse.emf.ecore.ENamedElement)
		 */
		public Object caseENamedElement(ENamedElement object) {
			return getBasicOclChoices();
		}

		/**
		 * @see org.eclipse.emf.ocl.types.util.TypesSwitch#caseMessageType(org.eclipse.emf.ocl.types.MessageType)
		 */
		public Object caseMessageType(MessageType object) {
			return Collections.EMPTY_LIST;
		}

		/**
		 * @see org.eclipse.emf.ocl.types.util.TypesSwitch#caseModelElementType(org.eclipse.emf.ocl.types.ModelElementType)
		 */
		public Object caseModelElementType(ModelElementType object) {
			return getBasicOclChoices();
		}

		/**
		 * @see org.eclipse.emf.ocl.types.util.TypesSwitch#caseOrderedSetType(org.eclipse.emf.ocl.types.OrderedSetType)
		 */
		public Object caseOrderedSetType(OrderedSetType object) {
			if (syntaxHelpStringSuffix == ARROW) {
				return getOrderedSetOclChoices();
			} else {
				return Collections.EMPTY_LIST;
			}
		}

		/**
		 * @see org.eclipse.emf.ocl.types.util.TypesSwitch#casePrimitiveBoolean(org.eclipse.emf.ocl.types.PrimitiveBoolean)
		 */
		public Object casePrimitiveBoolean(PrimitiveBoolean object) {
			if (syntaxHelpStringSuffix == NONE) {
				return getBooleanOclChoices();
			} else if (syntaxHelpStringSuffix == DOT) {
				return getOclAnyOclChoices();
			} else if (syntaxHelpStringSuffix == ARROW) {
				return getSetOclChoices();
			} else {
				return Collections.EMPTY_LIST;
			}
		}

		/**
		 * @see org.eclipse.emf.ocl.types.util.TypesSwitch#casePrimitiveInteger(org.eclipse.emf.ocl.types.PrimitiveInteger)
		 */
		public Object casePrimitiveInteger(PrimitiveInteger object) {
			if (syntaxHelpStringSuffix == DOT) {
				return getIntegerOclChoices();
			} else if (syntaxHelpStringSuffix == ARROW) {
				return getSetOclChoices();
			} else {
				return Collections.EMPTY_LIST;
			}
		}

		/**
		 * @see org.eclipse.emf.ocl.types.util.TypesSwitch#casePrimitiveReal(org.eclipse.emf.ocl.types.PrimitiveReal)
		 */
		public Object casePrimitiveReal(PrimitiveReal object) {
			if (syntaxHelpStringSuffix == DOT) {
				return getRealOclChoices();
			} else if (syntaxHelpStringSuffix == ARROW) {
				return getSetOclChoices();
			} else {
				return Collections.EMPTY_LIST;
			}
		}

		/**
		 * @see org.eclipse.emf.ocl.types.util.TypesSwitch#casePrimitiveString(org.eclipse.emf.ocl.types.PrimitiveString)
		 */
		public Object casePrimitiveString(PrimitiveString object) {
			if (syntaxHelpStringSuffix == DOT) {
				return getStringOclChoices();
			} else if (syntaxHelpStringSuffix == ARROW) {
				return getSetOclChoices();
			} else {
				return Collections.EMPTY_LIST;
			}
		}

		/**
		 * @see org.eclipse.emf.ocl.types.util.TypesSwitch#casePrimitiveType(org.eclipse.emf.ocl.types.PrimitiveType)
		 */
		public Object casePrimitiveType(PrimitiveType object) {
			return getBasicOclChoices();
		}

		/**
		 * @see org.eclipse.emf.ocl.types.util.TypesSwitch#caseSequenceType(org.eclipse.emf.ocl.types.SequenceType)
		 */
		public Object caseSequenceType(SequenceType object) {
			if (syntaxHelpStringSuffix == ARROW) {
				return getSequenceOclChoices();
			} else {
				return Collections.EMPTY_LIST;
			}
		}

		/**
		 * @see org.eclipse.emf.ocl.types.util.TypesSwitch#caseSetType(org.eclipse.emf.ocl.types.SetType)
		 */
		public Object caseSetType(SetType object) {
			if (syntaxHelpStringSuffix == ARROW) {
				return getSetOclChoices();
			} else {
				return Collections.EMPTY_LIST;
			}
		}

		/**
		 * @see org.eclipse.emf.ocl.types.util.TypesSwitch#caseTupleType(org.eclipse.emf.ocl.types.TupleType)
		 */
		public Object caseTupleType(TupleType object) {
			if (syntaxHelpStringSuffix == ARROW) {
				return getSetOclChoices();
			} else if (syntaxHelpStringSuffix == DOT) {
				List list = getOclChoicesForEClassEStructuralFeatures(object);
				list.addAll(getOclAnyOclChoices());
				return list;
			} else {
				return Collections.EMPTY_LIST;
			}
		}

		/**
		 * @see org.eclipse.emf.ocl.types.util.TypesSwitch#caseVoidType(org.eclipse.emf.ocl.types.VoidType)
		 */
		public Object caseVoidType(VoidType object) {
			return getBasicOclChoices();
		}

		/**
		 * @see org.eclipse.emf.ocl.types.util.TypesSwitch#defaultCase(org.eclipse.emf.ecore.EObject)
		 */
		public Object defaultCase(EObject object) {
			if (object instanceof EClass) {
				return caseEClass((EClass) object);
			} else if (object instanceof EDataType) {
				return caseEDataType((EDataType) object);
			} else {
				return getBasicOclChoices();
			}
		}
	} //OclTypesSwitch class

	/**
	 * returns the syntax help choices applicable for the passed OclExpression
	 * 
	 * @param oclExpression the AST node to check and return relevant syntax 
	 * help choices for.
	 * @param constraintType the type of constraint that we are completing
	 * 
	 * @return OclChoices syntax help choices for user, could be empty
	 */
	private List getOclChoices(OclExpression oclExpression, ConstraintType constraintType) {
		return getOclChoices(oclExpression.getType(), constraintType);
	}
	
	private List getOclChoices(EClassifier oclType, ConstraintType constraintType) {
		return filter(
				(List) getOclTypesSwitch().doSwitch(oclType),
				constraintType);
	}
	
	/**
	 * Filters the specified choices to remove choices not valid in the
	 * specified type of constraint.
	 * 
	 * @param choices the choices to filter
	 * @param constraintType the type of constraint that we are completing
	 * 
	 * @return the filtered choices
	 */
	private List filter(List choices, ConstraintType constraintType) {
		List result = choices;
		
		switch (constraintType.getValue()) {
		case ConstraintType.POSTCONDITION_VALUE:
			break;
		default:
			// only postconditions may include oclIsNew()
			result = new ArrayList(result);
			result.remove(IS_NEW);
			
			break;
		}
		
		return result;
	}

	/**
	 * Returns the valid subcontents of a path string that has double-colons in
	 * it.
	 * 
	 * @param txt the line that potentially has a path
	 * @param env the current OCL environment
	 * 
	 * @throws Exception if anything at all goes awry
	 * 
	 * @return a list of {@link Choice}s, possibly empty
	 */
	private List getPathOclChoices(String txt, Environment env) throws Exception {
		OclLexer lexer = new OclLexer(new StringReader(txt));
		Token token = null;
		
		for (;;) {
			Token next = lexer.nextToken();
			
			if (next.getType() == Token.EOF_TYPE) {
				break;
			} else {
				token = next;
			}
		}
		
		if (token != null) {
			OclParser parser = new OclParser(new SingletonTokenStream(token));
			Vector path = parser.pathNameCS();
			
			EPackage ePackage = env.lookupPackage(path);
			
			if (ePackage != null) {
				return getPathOclChoices(ePackage);
			} else {
				//could it be an enum?
				EClassifier eClassifier = env.lookupPathName(path);
				
				if (eClassifier instanceof EEnum) {
					return getPathOclChoices(((EEnum) eClassifier));
				}
			}
		}
		
		return Collections.EMPTY_LIST;
	}

	private List getPathOclChoices(EEnum eEnum) {
		List contents = new ArrayList();
		Iterator it = eEnum.getELiterals().iterator();
		while (it.hasNext()) {
			EEnumLiteral eEnumLiteral = (EEnumLiteral) it.next();
			contents.add(new Choice(eEnumLiteral.getName(),
				getDescription(eEnumLiteral), ChoiceType.STRUCTURAL_FEATURE));
		}
		return contents;
	}

	/**
	 * builds and returns a list of Choice that represent the directly
	 * contained classifiers.
	 * 
	 * @param ePackage
	 *            teh package to explore and return appropriate classifiers
	 * @return List the list of Choice object to return to the caller.
	 */
	private List getPathOclChoices(EPackage ePackage) {
		Set choices = new java.util.LinkedHashSet();  // retain order
		
		for (Iterator iter = ePackage.getESubpackages().iterator(); iter.hasNext();) {
			EPackage next = (EPackage) iter.next();
			choices.add(new Choice(next.getName(), getDescription(next),
				ChoiceType.STRUCTURAL_FEATURE));
		}
		
		Iterator it = ePackage.getEClassifiers().iterator();
		EClassifier eClassifier = null;
		while (it.hasNext()) {
			eClassifier = (EClassifier) it.next();
			choices.add(new Choice(eClassifier.getName(), getDescription(eClassifier),
				ChoiceType.STRUCTURAL_FEATURE));
		}
		
		return new ArrayList(choices);
	}

	private List getVariableOclChoices(Environment env, String txt, ConstraintType constraintType) {
		Set choices = new java.util.LinkedHashSet();  // retain order
		
		// add features of the context classifier.  If the context is an
		//    operation, then the parameters were already added to the
		//    environment
		int oldSuffix = syntaxHelpStringSuffix;
		syntaxHelpStringSuffix = DOT;
		choices.addAll((Collection) getOclTypesSwitch().doSwitch(
			env.getSelfVariable().getType()));
		syntaxHelpStringSuffix = oldSuffix;
		
		List tokens = tokenize(txt);
		
		try {
			getVariables(env, txt, tokens.listIterator(tokens.size()));
		} catch (Exception e) {
			// maybe we found a few variables.  Ignore the exception
		}
		
		for (Iterator iter = env.getVariables().iterator(); iter.hasNext();) {
			VariableDeclaration next = (VariableDeclaration) iter.next();
			
			choices.add(new Choice(
				next.getVarName(),
				getDescription(next.getType()),
				ChoiceType.VARIABLE));
		}
	
		return filter(new ArrayList(choices), constraintType);
	}

	/**
	 * Gets choices for completion of partial names starting at a specified
	 * position after a ".", "->", or "::".
	 * 
	 * @param text the text to complete
	 * @param env the OCL environment
	 * @param constraintType the kind of constraint for which to get partial
	 *     name suggestions
	 * @param position the position at which the partial name starts
	 * 
	 * @return the appropriate choices
	 */
	private List getPartialNameChoices(String text, Environment env,
			ConstraintType constraintType, int position) {
		
		// get raw choices
		List result = getSyntaxHelp(env, constraintType, text.substring(0, position));
		
		// filter out choices that don't start with the partial text
		String partial = text.substring(position).trim();
		
		for (Iterator iter = result.iterator(); iter.hasNext();) {
			Choice next = (Choice) iter.next();
			
			if (!next.getName().startsWith(partial)) {
				iter.remove();
			}
		}
		
		return result;
	}
	
	/**
	 * Converts the specified OCL text to a list of {@link OclToken}s.
	 * 
	 * @param text the text to tokenize
	 * @return the corresponding {@link OclToken}s
	 */
	private List tokenize(String text) {
		OclLexer lexer = new OclLexer(new StringReader(text));
		OclToken token = null;
		List result = new ArrayList();
		
		for (;;) {
			try {
				token = (OclToken) lexer.nextToken();
				
				if (token.getType() == Token.EOF_TYPE) {
					break;
				} else {			
					result.add(token);
				}
			} catch (Exception e) {
				// got as many as we can.  Ignore the exception
				break;
			}
		}
		
		return result;
	}
	
	/**
	 * Gets the most appropriate description available of the specified
	 * named element.
	 * 
	 * @param namedElement a named element presented to the user as a choice
	 * @return the most appropriate description for the element
	 */
	private String getDescription(ENamedElement namedElement) {
		if (environment != null) {
			return environment.getDescription(namedElement);
		} else if (namedElement instanceof ETypedElement) {
			return getDescription(((ETypedElement) namedElement).getEType());
		} else if (namedElement instanceof EEnumLiteral) {
			return ((EEnumLiteral) namedElement).getEEnum().getName();
		} else {
			return namedElement.getName();
		}
	}

	/**
	 * Gets syntax help choices for the specified <code>context</code>
	 * classifier or operation.
	 * 
	 * @param env the current OCL environment
	 * @param constraintType the kind of constraint for which to get completion
	 *     suggestions
	 * @param txt the string we got from client that contains the ocl expression
	 * @param context the context classifier or operation to use for the ocl
	 *     expression parsing 
	 * @return a list of {@link Choice}s representing the syntax help choices
	 *     for the user; could be empty
	 */
	List getSyntaxHelp(Environment env, ConstraintType constraintType, String txt) {
		
		try {
			txt = txt.trim();//just to be sure
			if (txt.endsWith(HelperUtil.DOT)) {
				syntaxHelpStringSuffix = DOT;
				int position = txt.lastIndexOf(HelperUtil.DOT);
				
				return (List) getOclExpression(txt.lastIndexOf(HelperUtil.DOT),
					txt, env, constraintType).accept(
							new OclASTVisitor(txt, position, constraintType));
			} else if (txt.endsWith(HelperUtil.ARROW)) {
				syntaxHelpStringSuffix = ARROW;
				int position = txt.lastIndexOf(HelperUtil.ARROW);
				
				return (List) getOclExpression(txt.lastIndexOf(HelperUtil.ARROW),
					txt, env, constraintType).accept(
							new OclASTVisitor(txt, position, constraintType));
			} else if (txt.endsWith(HelperUtil.DOUBLE_COLON)) {
				syntaxHelpStringSuffix = DOUBLE_COLON;
				// path choices are not affected by the variables in the operation
				//   namespace (e.g., parameters)
				
				return getPathOclChoices(
					txt.substring(0, txt.lastIndexOf(HelperUtil.DOUBLE_COLON)),
					env);
			} else {
				// see whether we can complete a partial name
				List tokens = tokenize(txt);
				if (tokens.size() > 2) {
					OclToken last = (OclToken) tokens.get(tokens.size() - 1);
					OclToken prev = (OclToken) tokens.get(tokens.size() - 2);
					
					if (last.getType() == OclParserTokenTypes.NAME) {
						switch (prev.getType()) {
							case OclParserTokenTypes.ARROW:
							case OclParserTokenTypes.DOT:
							case OclParserTokenTypes.DOUBLECOLON:
								return getPartialNameChoices(
									txt, env, constraintType,
									prev.getEndPosition());
						}
					}
				}
				
				// see whether we can complete a partial path
				if (tokens.size() > 1) {
					OclToken last = (OclToken) tokens.get(tokens.size() - 1);
					
					if (last.getType() == OclParserTokenTypes.PATHNAME) {
						return getPartialNameChoices(txt, env, constraintType,
							txt.lastIndexOf(HelperUtil.DOUBLE_COLON) + HelperUtil.DOUBLE_COLON.length());
					}
				}
				
				// no partial names to complete:  go for variables
				syntaxHelpStringSuffix = NONE;
				
				// create a copy of the environment, to embellish it without
				//     disrupting the caller's environment
				env = copyEnvironment(env);
				return getVariableOclChoices(env, txt, constraintType);
			}
		} catch (Exception e) {
			// didn't work?  Just try some simple variable choices, then
			env = copyEnvironment(env);
			return getVariableOclChoices(env, txt, constraintType);
		}
	}

	private OclExpression getOclExpression(int index, String txt,
		Environment env, ConstraintType constraintType) throws Exception {
		try {
			return getOclExpression(env, txt.substring(0, index), constraintType);
		} catch (Exception ex) {
			//give it one more try to handle partial ocl expression i.e., 
			//if this is a compound statement and we are at the second statement,
			//therefore we'll try to remove the first statement and parse the second part
			List tokens = tokenize(txt.substring(0, index));
			ListIterator it = tokens.listIterator(tokens.size());
			
			OclToken token = null;
			while (it.hasPrevious()) {
				token = (OclToken) it.previous();
				if (token.getType() == OclParserTokenTypes.NAME) {
					if (it.hasPrevious()) {
						OclToken previousToken = (OclToken) it.previous();
						if ((previousToken.getType() == OclParserTokenTypes.ARROW)
							|| (previousToken.getType() == OclParserTokenTypes.DOT)) {
							continue;
						}
						if (token.getText() != null) {
							// step back over the previous token in case it is
							//    a "|" or an "in"
							it.next();
							
							int beginIndex = token.getStartPosition();
							
							env = copyEnvironment(env);
							getVariables(env, txt.substring(0, index), it);
							
							if (beginIndex != NONE) {
								return getOclExpression(
									env,
									txt.substring(beginIndex, index),
									constraintType);
							}
						}
						break;//failure, then exit to rethrow the exception
					}//it.hasPrevious()
				}//if (token.getType() == OclParserTokenTypes.NAME)
			}//while
			throw ex;//failed... then just rethrow			
		}
	}
	
	private void getVariables(Environment env, String text, ListIterator tokens) throws ANTLRException {
		OclToken token = null;
		
		while (tokens.hasPrevious()) {
			token = (OclToken) tokens.previous();
			
			if (token.getType() == OclParserTokenTypes.BAR) {
				// we are looking at a nested namespace in an iterator expression.
				//   Parse the iterator variable declarations into our environment
				int beginIndex = 0;
				while (tokens.hasPrevious()) {
					// search for the left parenthesis
					OclToken ot = (OclToken) tokens.previous();
					if (ot.getType() == OclParserTokenTypes.LPAREN) {
						beginIndex = ot.getEndPosition();
						break;
					}
				}
				
				parseIterators(
					env,
					text.substring(beginIndex, token.getEndPosition()));
			} else if (token.getType() == OclParserTokenTypes.LITERAL_in) {
				// we are looking at a nested namespace in a let expression.
				//   Parse the iterator variable declarations into our environment
				int beginIndex = 0;
				while (tokens.hasPrevious()) {
					// search for the "let" token
					OclToken ot = (OclToken) tokens.previous();
					if (ot.getType() == OclParserTokenTypes.LITERAL_let) {
						beginIndex = ot.getEndPosition();
						break;
					}
				}
				
				parseVariable(
					env,
					text.substring(beginIndex, token.getEndPosition()));
			}
		}
	}
	
	private void parseIterators(Environment env, String variables) throws ANTLRException {
		OclLexer lexer = new OclLexer(new StringReader(variables));
		OclParser parser = new OclParser(lexer);
		
		parseVariableDeclaration(env, parser);
		
		Token token = parser.LT(1);
		
		while (token.getType() != Token.EOF_TYPE) {
			parser.consume();
			
			if ((token.getType() == OclParserTokenTypes.COMMA)
					|| (token.getType() == OclParserTokenTypes.SEMICOLON)) {
				
				parseVariableDeclaration(env, parser);
				token = parser.LT(1);
			} else {
				token = parser.LT(1);
			}
		}
	}
	
	private void parseVariable(Environment env, String variables) throws ANTLRException {
		OclLexer lexer = new OclLexer(new StringReader(variables));
		OclParser parser = new OclParser(lexer);
		
		parseVariableDeclaration(env, parser);
	}
	
	private void parseVariableDeclaration(Environment env, OclParser p) {
		try {
			Token token = p.LT(1);
			
			if (token.getType() == OclParserTokenTypes.NAME) {
				String name = token.getText();
				p.consume();
				
				token = p.LT(1);
				if (token.getType() == OclParserTokenTypes.COLON) {
					token = p.LT(1);
					p.consume();
					
					EClassifier type = p.typeCS(env);
					
					if (type != null) {
						VariableDeclaration vdecl = ExpressionsFactory.eINSTANCE.createVariableDeclaration();
						vdecl.setName(name);
						vdecl.setType(type);
						
						env.addElement(name, vdecl, true);
					}
				}
			}
		} catch (ANTLRException e) {
			// ignore:  this will happen when the variable has already
			//    been used (i.e., if a non-containing scope that is
			//    farther left in the input uses the same name), but in
			//    this case it's safe to ignore the variable because it
			//    couldn't be referenced anyway
		}
	}
	
	/**
	 * Copies the initial environment, so that we may change it at will.
	 * 
	 * @param env the environment to copy
	 * @return the copy
	 */
	private Environment copyEnvironment(Environment env) {
		// don't actually create a "copy", but a child environment that will
		//    delegate unknown variables to the parent.  We cannot modify the
		//    parent by this means
		return environmentFactory.createEnvironment(env);
	}
	
	/**
	 * Parses the specified text in the specified environment.
	 * 
	 * @param env the parser environment
	 * @param text the OCL text
	 * @param constraintType the kind of constraint to parse
	 * @return the OCL expression, if it successfully parsed
	 * 
	 * @throws Exception any exception thrown in parsing
	 */
	private OclExpression getOclExpression(Environment env, String text, ConstraintType constraintType)
			throws Exception {
		
		OclExpression result = null;
		switch (constraintType.getValue()) {
		case ConstraintType.PRECONDITION_VALUE:
			result = ExpressionsUtil.createPrecondition(
				env, text, false);   // don't validate
			break;
		case ConstraintType.BODYCONDITION_VALUE:
			result = ExpressionsUtil.createBodyCondition(
				env, text, false);   // don't validate
			break;
		case ConstraintType.POSTCONDITION_VALUE:
			result = ExpressionsUtil.createPostcondition(
				env, text, false);   // don't validate
			break;
		default:
			result = ExpressionsUtil.createInvariant(
				env, text, false);   // don't validate
			break;
		}
		
		return result;
	}

	/**
	 * type switcher to use to get to the type of the last AST node
	 * @return TypesSwitch
	 */
	private TypesSwitch getOclTypesSwitch() {
		if (oclTypesSwitch == null) {
			oclTypesSwitch = new OclTypesSwitch();
		}
		return oclTypesSwitch;
	}

	/**
	 * A token stream that only provides a single token, then EOF.
	 *
	 * @author Christian W. Damus (cdamus)
	 */
	private static final class SingletonTokenStream implements TokenStream {
		private Token token;
		private Token eof = new Token(Token.EOF_TYPE);
		
		/**
		 * Initializes me with my token.
		 * 
		 * @param token my token
		 */
		SingletonTokenStream(Token token) {
			this.token = token;
		}
		
		public Token nextToken() throws TokenStreamException {
			Token result = token;
			token = eof;
			return result;
		}
	}
}
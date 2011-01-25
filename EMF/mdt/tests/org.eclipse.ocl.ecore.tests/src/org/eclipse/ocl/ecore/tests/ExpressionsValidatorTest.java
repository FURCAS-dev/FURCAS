/**
 * <copyright>
 * 
 * Copyright (c) 2008,2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   A. Sanchez-Barbudo - Test case contribution - Bug 236247
 *
 * </copyright>
 *
 * $Id: ExpressionsValidatorTest.java,v 1.7 2009/11/28 17:47:10 ewillink Exp $
 */

package org.eclipse.ocl.ecore.tests;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ecore.BooleanLiteralExp;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.CollectionItem;
import org.eclipse.ocl.ecore.CollectionLiteralExp;
import org.eclipse.ocl.ecore.CollectionRange;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.ecore.EnumLiteralExp;
import org.eclipse.ocl.ecore.IfExp;
import org.eclipse.ocl.ecore.IntegerLiteralExp;
import org.eclipse.ocl.ecore.IterateExp;
import org.eclipse.ocl.ecore.IteratorExp;
import org.eclipse.ocl.ecore.LetExp;
import org.eclipse.ocl.ecore.LoopExp;
import org.eclipse.ocl.ecore.MessageExp;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.PropertyCallExp;
import org.eclipse.ocl.ecore.RealLiteralExp;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.StringLiteralExp;
import org.eclipse.ocl.ecore.TupleLiteralExp;
import org.eclipse.ocl.ecore.TupleLiteralPart;
import org.eclipse.ocl.ecore.TupleType;
import org.eclipse.ocl.ecore.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.ecore.UnspecifiedValueExp;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.ecore.VariableExp;
import org.eclipse.ocl.ecore.tests.MessagesTest.MessagingFruitEnvironmentFactory;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.expressions.util.ExpressionsValidator;


/**
 * Tests the generated validator constraints for the Expressions package.
 *
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class ExpressionsValidatorTest extends AbstractTestSuite {

	private final EcoreFactory factory = EcoreFactory.eINSTANCE;
	
	public void test_BooleanLiteralExp_checkBooleanType() {
		BooleanLiteralExp bl = factory.createBooleanLiteralExp();
		bl.setBooleanSymbol(true);
		bl.setType(apple);
		
		assertProblem(bl, ExpressionsValidator.BOOLEAN_LITERAL_EXP__BOOLEAN_TYPE);
		
		bl.setType(getOCLStandardLibrary().getInteger());
		
		assertProblem(bl, ExpressionsValidator.BOOLEAN_LITERAL_EXP__BOOLEAN_TYPE);
		
		bl.setType(getOCLStandardLibrary().getBoolean());
		
		assertOK(bl, ExpressionsValidator.BOOLEAN_LITERAL_EXP__BOOLEAN_TYPE);
	}
	
	public void test_CollectionItem_checkItemType() {
		CollectionItem i = factory.createCollectionItem();
		CollectionType ctype = factory.createCollectionType();
		ctype.setElementType(fruit);
		i.setType(ctype);
		
		CollectionLiteralExp item = factory.createCollectionLiteralExp();
		CollectionType itemType = factory.createCollectionType();
		itemType.setElementType(apple);
		item.setType(itemType);
		
		i.setItem(item);
		
		assertProblem(i, ExpressionsValidator.COLLECTION_ITEM__ITEM_TYPE);
		
		item.setType(ctype);
		
		assertOK(i, ExpressionsValidator.COLLECTION_ITEM__ITEM_TYPE);
	}
	
	public void test_CollectionLiteralExp_checkNoCollectionInstances() {
		CollectionLiteralExp cl = factory.createCollectionLiteralExp();
		cl.setKind(CollectionKind.COLLECTION_LITERAL);
		
		assertProblem(cl, ExpressionsValidator.COLLECTION_LITERAL_EXP__NO_COLLECTION_INSTANCES);
		
		cl.setKind(CollectionKind.BAG_LITERAL);
		
		assertOK(cl, ExpressionsValidator.COLLECTION_LITERAL_EXP__NO_COLLECTION_INSTANCES);
	}
	
	public void test_CollectionLiteralExp_checkSetKind() {
		CollectionLiteralExp cl = factory.createCollectionLiteralExp();
		cl.setKind(CollectionKind.COLLECTION_LITERAL);
		cl.setType(factory.createBagType());
		
		assertOK(cl, ExpressionsValidator.COLLECTION_LITERAL_EXP__SET_KIND);
		
		cl.setKind(CollectionKind.SET_LITERAL);
		
		assertProblem(cl, ExpressionsValidator.COLLECTION_LITERAL_EXP__SET_KIND);
		
		cl.setType(factory.createSetType());
		
		assertOK(cl, ExpressionsValidator.COLLECTION_LITERAL_EXP__SET_KIND);
	}
	
	public void test_CollectionLiteralExp_checkSequenceKind() {
		CollectionLiteralExp cl = factory.createCollectionLiteralExp();
		cl.setKind(CollectionKind.COLLECTION_LITERAL);
		cl.setType(factory.createBagType());
		
		assertOK(cl, ExpressionsValidator.COLLECTION_LITERAL_EXP__SEQUENCE_KIND);
		
		cl.setKind(CollectionKind.SEQUENCE_LITERAL);
		
		assertProblem(cl, ExpressionsValidator.COLLECTION_LITERAL_EXP__SEQUENCE_KIND);
		
		cl.setType(factory.createSequenceType());
		
		assertOK(cl, ExpressionsValidator.COLLECTION_LITERAL_EXP__SEQUENCE_KIND);
	}
	
	public void test_CollectionLiteralExp_checkBagKind() {
		CollectionLiteralExp cl = factory.createCollectionLiteralExp();
		cl.setKind(CollectionKind.COLLECTION_LITERAL);
		cl.setType(factory.createSetType());
		
		assertOK(cl, ExpressionsValidator.COLLECTION_LITERAL_EXP__BAG_KIND);
		
		cl.setKind(CollectionKind.BAG_LITERAL);
		
		assertProblem(cl, ExpressionsValidator.COLLECTION_LITERAL_EXP__BAG_KIND);
		
		cl.setType(factory.createBagType());
		
		assertOK(cl, ExpressionsValidator.COLLECTION_LITERAL_EXP__BAG_KIND);
	}
	
	public void test_CollectionLiteralExp_checkElementType() {
		CollectionLiteralExp cl = factory.createCollectionLiteralExp();
		cl.setKind(CollectionKind.SET_LITERAL);
		CollectionType ctype = factory.createSetType();
		ctype.setElementType(fruit);
		cl.setType(ctype);
		
		CollectionItem item1 = factory.createCollectionItem();
		item1.setType(apple);
		CollectionItem item2 = factory.createCollectionItem();
		item2.setType(color);
		
		cl.getPart().add(item1);
		cl.getPart().add(item2);
		
		assertProblem(cl, ExpressionsValidator.COLLECTION_LITERAL_EXP__ELEMENT_TYPE);
		
		item2.setType(fruit);
		
		assertOK(cl, ExpressionsValidator.COLLECTION_LITERAL_EXP__ELEMENT_TYPE);
	}
	
	public void test_CollectionLiteralExp_checkElementType_emptySet() {
		CollectionLiteralExp cl = factory.createCollectionLiteralExp();
		cl.setKind(CollectionKind.SET_LITERAL);
		CollectionType ctype = factory.createSetType();
		ctype.setElementType(fruit);
		cl.setType(ctype);
		
		assertProblem(cl, ExpressionsValidator.COLLECTION_LITERAL_EXP__ELEMENT_TYPE);
		
		ctype.setElementType(getOCLStandardLibrary().getOclVoid());
		
		assertOK(cl, ExpressionsValidator.COLLECTION_LITERAL_EXP__ELEMENT_TYPE);
	}
	
	public void test_CollectionRange_checkRangeType() {
		CollectionRange r = factory.createCollectionRange();
		r.setType(fruit);
		
		IntegerLiteralExp first = factory.createIntegerLiteralExp();
		first.setType(apple);
		TupleLiteralExp last = factory.createTupleLiteralExp();
		last.setType(color);
		
		r.setFirst(first);
		r.setLast(last);
		
		assertProblem(r, ExpressionsValidator.COLLECTION_RANGE__RANGE_TYPE);
		
		last.setType(fruit);
		
		assertOK(r, ExpressionsValidator.COLLECTION_RANGE__RANGE_TYPE);
	}
	
	public void test_EnumLiteralExp_checkEnumType() {
		EnumLiteralExp el = factory.createEnumLiteralExp();
		el.setType(fruit);
		el.setReferredEnumLiteral(color_red);
		
		assertProblem(el, ExpressionsValidator.ENUM_LITERAL_EXP__ENUM_TYPE);
		
		el.setType(color);
		
		assertOK(el, ExpressionsValidator.ENUM_LITERAL_EXP__ENUM_TYPE);
	}
	
	public void test_IfExp_checkBooleanCondition() {
		IfExp ie = factory.createIfExp();
		OCLExpression cond = factory.createBooleanLiteralExp();
		cond.setType(getOCLStandardLibrary().getInteger());
		
		ie.setCondition(cond);
		
		assertProblem(ie, ExpressionsValidator.IF_EXP__BOOLEAN_CONDITION);
		
		cond.setType(getOCLStandardLibrary().getBoolean());
		
		assertOK(ie, ExpressionsValidator.IF_EXP__BOOLEAN_CONDITION);
	}
	
	public void test_IfExp_checkIfType() {
		IfExp ie = factory.createIfExp();
		ie.setType(fruit);
		
		OCLExpression thenPart = factory.createBooleanLiteralExp();
		thenPart.setType(apple);
		OCLExpression elsePart = factory.createTupleLiteralExp();
		elsePart.setType(color);
		
		ie.setThenExpression(thenPart);
		ie.setElseExpression(elsePart);
		
		assertProblem(ie, ExpressionsValidator.IF_EXP__IF_TYPE);
		
		elsePart.setType(fruit);
		
		assertOK(ie, ExpressionsValidator.IF_EXP__IF_TYPE);
	}
	
	public void test_IntegerLiteralExp_checkIntegerType() {
		IntegerLiteralExp il = factory.createIntegerLiteralExp();
		il.setIntegerSymbol(42);
		il.setType(apple);
		
		assertProblem(il, ExpressionsValidator.INTEGER_LITERAL_EXP__INTEGER_TYPE);
		
		il.setType(getOCLStandardLibrary().getBoolean());
		
		assertProblem(il, ExpressionsValidator.INTEGER_LITERAL_EXP__INTEGER_TYPE);
		
		il.setType(getOCLStandardLibrary().getInteger());
		
		assertOK(il, ExpressionsValidator.INTEGER_LITERAL_EXP__INTEGER_TYPE);
	}
	
	public void test_IterateExp_checkIterateType() {
		IterateExp i = factory.createIterateExp();
		i.setType(fruit);
		
		Variable resultVar = factory.createVariable();
		resultVar.setType(color);
		i.setResult(resultVar);
		
		assertProblem(i, ExpressionsValidator.ITERATE_EXP__ITERATE_TYPE);
		
		resultVar.setType(apple);
		
		assertProblem(i, ExpressionsValidator.ITERATE_EXP__ITERATE_TYPE);
		
		i.setType(apple);
		
		assertOK(i, ExpressionsValidator.ITERATE_EXP__ITERATE_TYPE);
	}
	
	public void test_IterateExp_checkBodyType() {
		IterateExp i = factory.createIterateExp();
		i.setType(fruit);
		
		Variable resultVar = factory.createVariable();
		resultVar.setType(fruit);
		i.setResult(resultVar);
		
		OCLExpression body = factory.createBooleanLiteralExp();
		body.setType(color);
		i.setBody(body);
		
		assertProblem(i, ExpressionsValidator.ITERATE_EXP__BODY_TYPE);
		
		body.setType(apple);
		
		assertOK(i, ExpressionsValidator.ITERATE_EXP__BODY_TYPE);
	}
	
	public void test_IterateExp_checkResultInit() {
		IterateExp i = factory.createIterateExp();
		i.setType(fruit);
		
		Variable resultVar = factory.createVariable();
		resultVar.setType(fruit);
		i.setResult(resultVar);
		
		assertProblem(i, ExpressionsValidator.ITERATE_EXP__RESULT_INIT);
		
		resultVar.setInitExpression(factory.createUnspecifiedValueExp());
		
		assertOK(i, ExpressionsValidator.ITERATE_EXP__RESULT_INIT);
	}
	
	public void test_IteratorExp_checkBooleanType() {
		IteratorExp i = factory.createIteratorExp();
		i.setType(apple);
		
		i.setName("select");
		assertOK(i, ExpressionsValidator.ITERATOR_EXP__BOOLEAN_TYPE);
		
		for (String name : Arrays.asList("forAll", "exists", "isUnique")) {
			i.setName(name);
			assertProblem(i, ExpressionsValidator.ITERATOR_EXP__BOOLEAN_TYPE);
		}
		
		i.setType(getOCLStandardLibrary().getBoolean());
		
		for (String name : Arrays.asList("forAll", "exists", "isUnique")) {
			i.setName(name);
			assertOK(i, ExpressionsValidator.ITERATOR_EXP__BOOLEAN_TYPE);
		}
	}
	
	public void test_IteratorExp_checkCollectType() {
		EClassifier set = getOCLStandardLibrary().getSet();
		EClassifier orderedSet = getOCLStandardLibrary().getOrderedSet();
		EClassifier sequence = getOCLStandardLibrary().getSequence();
		EClassifier bag = getOCLStandardLibrary().getBag();
		List<EClassifier[]> badPairs = new java.util.ArrayList<EClassifier[]>();
		badPairs.add(new EClassifier[] {set, sequence});
		badPairs.add(new EClassifier[] {bag, sequence});
		badPairs.add(new EClassifier[] {sequence, bag});
		badPairs.add(new EClassifier[] {sequence, set});
		badPairs.add(new EClassifier[] {orderedSet, bag});
 		List<EClassifier[]> goodPairs = new java.util.ArrayList<EClassifier[]>();
		goodPairs.add(new EClassifier[] {set, bag});
		goodPairs.add(new EClassifier[] {bag, bag});
		goodPairs.add(new EClassifier[] {sequence, sequence});
		goodPairs.add(new EClassifier[] {orderedSet, sequence});
		
		IteratorExp i = factory.createIteratorExp();
		i.setName("collect");
		
		OCLExpression source = factory.createBooleanLiteralExp();
		i.setSource(source);
		
		for (EClassifier[] pair : badPairs) {
			source.setType(pair[0]);
			i.setType(pair[1]);
			assertProblem(i, ExpressionsValidator.ITERATOR_EXP__COLLECT_TYPE);
		}
		
		for (EClassifier[] pair : goodPairs) {
			source.setType(pair[0]);
			i.setType(pair[1]);
			assertOK(i, ExpressionsValidator.ITERATOR_EXP__COLLECT_TYPE);
		}
	}
	
	public void test_IteratorExp_checkSelectRejectType() {
		IteratorExp i = factory.createIteratorExp();
		i.setType(getOCLStandardLibrary().getSet());
		
		OCLExpression source = factory.createBooleanLiteralExp();
		source.setType(getOCLStandardLibrary().getBag());
		i.setSource(source);
				
		for (String name : Arrays.asList("select", "reject")) {
			i.setName(name);
			assertProblem(i, ExpressionsValidator.ITERATOR_EXP__SELECT_REJECT_TYPE);
		}
		
		i.setType(getOCLStandardLibrary().getBag());
		
		for (String name : Arrays.asList("select", "reject")) {
			i.setName(name);
			assertOK(i, ExpressionsValidator.ITERATOR_EXP__SELECT_REJECT_TYPE);
		}
	}
	
	public void test_IteratorExp_checkBooleanBodyType() {
		List<String> names = Arrays.asList("select", "reject", "forAll", "exists", "any", "one");
		IteratorExp i = factory.createIteratorExp();
		i.setType(getOCLStandardLibrary().getSet());
		
		OCLExpression body = factory.createBooleanLiteralExp();
		body.setType(getOCLStandardLibrary().getBag());
		i.setBody(body);
		
		i.setName("collect");
		assertOK(i, ExpressionsValidator.ITERATOR_EXP__BOOLEAN_BODY_TYPE);
				
		for (String name : names) {
			i.setName(name);
			assertProblem(i, ExpressionsValidator.ITERATOR_EXP__BOOLEAN_BODY_TYPE);
		}
		
		body.setType(getOCLStandardLibrary().getBoolean());
		
		for (String name : names) {
			i.setName(name);
			assertOK(i, ExpressionsValidator.ITERATOR_EXP__BOOLEAN_BODY_TYPE);
		}
	}
	
	public void test_LetExp_checkLetType() {
		LetExp l = factory.createLetExp();
		l.setType(getOCLStandardLibrary().getBag());
		
		OCLExpression in = factory.createBooleanLiteralExp();
		in.setType(getOCLStandardLibrary().getBoolean());
		l.setIn(in);
		
		assertProblem(l, ExpressionsValidator.LET_EXP__LET_TYPE);
		
		l.setType(in.getType());
		
		assertOK(l, ExpressionsValidator.LET_EXP__LET_TYPE);
	}
	
	public void test_LoopExp_checkSourceCollection() {
		LoopExp l = factory.createIterateExp();
		
		OCLExpression source = factory.createBooleanLiteralExp();
		l.setSource(source);
		
		source.setType(getOCLStandardLibrary().getBoolean());
		
		assertProblem(l, ExpressionsValidator.LOOP_EXP__SOURCE_COLLECTION);
		
		source.setType(getOCLStandardLibrary().getSet());
		
		assertOK(l, ExpressionsValidator.LOOP_EXP__SOURCE_COLLECTION);
	}
	
	public void test_LoopExp_checkLoopVariableInit() {
		LoopExp l = factory.createIterateExp();
		
		Variable iter = factory.createVariable();
		l.getIterator().add(iter);
		
		iter = factory.createVariable();
		l.getIterator().add(iter);
		
		assertOK(l, ExpressionsValidator.LOOP_EXP__LOOP_VARIABLE_INIT);
		
		iter.setInitExpression(factory.createBooleanLiteralExp());
		
		assertProblem(l, ExpressionsValidator.LOOP_EXP__LOOP_VARIABLE_INIT);
	}
	
	public void test_LoopExp_checkLoopVariableType() {
		LoopExp l = factory.createIterateExp();
		
		CollectionType ctype = factory.createCollectionType();
		ctype.setElementType(fruit);
		OCLExpression source = factory.createCollectionLiteralExp();
		source.setType(ctype);
		l.setSource(source);
		
		Variable iter = factory.createVariable();
		iter.setType(fruit);
		l.getIterator().add(iter);
		
		iter = factory.createVariable();
		iter.setType(apple);
		l.getIterator().add(iter);
		
		assertProblem(l, ExpressionsValidator.LOOP_EXP__LOOP_VARIABLE_TYPE);
		
		iter.setType(fruit);
		
		assertOK(l, ExpressionsValidator.LOOP_EXP__LOOP_VARIABLE_TYPE);
	}
	
	public void test_MessageExp_checkOperationArguments() {
		MessageExp m = factory.createMessageExp();
		
		CallOperationAction action = factory.createCallOperationAction();
		m.setCalledOperation(action);
		action.setOperation(fruit_ripen);
		
		UnspecifiedValueExp arg = factory.createUnspecifiedValueExp();
		arg.setType(getOCLStandardLibrary().getBoolean());
		m.getArgument().add(arg);
		
		assertProblem(m, ExpressionsValidator.MESSAGE_EXP__OPERATION_ARGUMENTS);
		
		arg.setType(color);
		
		assertOK(m, ExpressionsValidator.MESSAGE_EXP__OPERATION_ARGUMENTS);
		
		// no-arg operation
		action.setOperation(fruit_newFruit);
		
		// wrong number of message args
		assertProblem(m, ExpressionsValidator.MESSAGE_EXP__OPERATION_ARGUMENTS);
		
		m.getArgument().clear();
		
		assertOK(m, ExpressionsValidator.MESSAGE_EXP__OPERATION_ARGUMENTS);
	}
	
	public void test_MessageExp_checkSignalArguments() {
		expectModified = true;
		MessagingFruitEnvironmentFactory envFactory = new MessagesTest.MessagingFruitEnvironmentFactory(this);
		ocl.dispose();
		ocl = OCL.newInstance(envFactory);
		helper = ocl.createOCLHelper();
		((InitEnvironment) ocl.getEnvironment()).init();
		
		MessageExp m = factory.createMessageExp();
		
		SendSignalAction action = factory.createSendSignalAction();
		m.setSentSignal(action);
		
		EClass drop = (EClass) fruitPackage.getEClassifier("Drop");
		assertNotNull(drop);
		action.setSignal(drop);
		
		UnspecifiedValueExp arg = factory.createUnspecifiedValueExp();
		arg.setType(getOCLStandardLibrary().getInteger());
		m.getArgument().add(arg);
		
		arg = factory.createUnspecifiedValueExp();
		arg.setType(getOCLStandardLibrary().getBoolean());
		m.getArgument().add(arg);
		
		assertProblem(m, ExpressionsValidator.MESSAGE_EXP__SIGNAL_ARGUMENTS);
		
		arg.setType(stem);
		
		assertOK(m, ExpressionsValidator.MESSAGE_EXP__SIGNAL_ARGUMENTS);
		
		// wrong number of arguments
		m.getArgument().remove(arg);
		
		assertProblem(m, ExpressionsValidator.MESSAGE_EXP__SIGNAL_ARGUMENTS);
	}
	
	public void test_MessageExp_checkTargetDefinesOperation() {
		MessageExp m = factory.createMessageExp();
		
		CallOperationAction action = factory.createCallOperationAction();
		m.setCalledOperation(action);
		action.setOperation(fruit_ripen);
		
		UnspecifiedValueExp arg = factory.createUnspecifiedValueExp();
		arg.setType(color);
		m.getArgument().add(arg);
		
		OCLExpression target = factory.createBooleanLiteralExp();
		m.setTarget(target);
		target.setType(color);
		
		assertProblem(m, ExpressionsValidator.MESSAGE_EXP__TARGET_DEFINES_OPERATION);
		
		target.setType(fruit);
		
		assertOK(m, ExpressionsValidator.MESSAGE_EXP__TARGET_DEFINES_OPERATION);
	}
	
	public void test_MessageExp_checkHasOperationOrSignal() {
		MessageExp m = factory.createMessageExp();
		
		CallOperationAction coa = factory.createCallOperationAction();
		coa.setOperation(fruit_ripen);
		
		SendSignalAction ssa = factory.createSendSignalAction();
		ssa.setSignal(stem);
		
		m.setCalledOperation(coa);
		
		assertOK(m, ExpressionsValidator.MESSAGE_EXP__HAS_OPERATION_OR_SIGNAL);
		
		m.setSentSignal(ssa);
		
		assertProblem(m, ExpressionsValidator.MESSAGE_EXP__HAS_OPERATION_OR_SIGNAL);
		
		m.setCalledOperation(null);
		
		assertOK(m, ExpressionsValidator.MESSAGE_EXP__HAS_OPERATION_OR_SIGNAL);
		
		m.setSentSignal(null);
		
		assertProblem(m, ExpressionsValidator.MESSAGE_EXP__HAS_OPERATION_OR_SIGNAL);
		
	}
	
	public void test_MessageExp_checkTargetNotCollection() {
		MessageExp m = factory.createMessageExp();
		
		CallOperationAction action = factory.createCallOperationAction();
		m.setCalledOperation(action);
		action.setOperation(fruit_ripen);
		
		UnspecifiedValueExp arg = factory.createUnspecifiedValueExp();
		arg.setType(color);
		m.getArgument().add(arg);
		
		OCLExpression target = factory.createBooleanLiteralExp();
		m.setTarget(target);
		target.setType(factory.createSequenceType());
		
		assertProblem(m, ExpressionsValidator.MESSAGE_EXP__TARGET_NOT_COLLECTION);
		
		target.setType(fruit);
		
		assertOK(m, ExpressionsValidator.MESSAGE_EXP__TARGET_NOT_COLLECTION);
	}
	
	public void test_OperationCallExp_checkArgumentsConform() {
		OperationCallExp o = factory.createOperationCallExp();
		
		EClass fruitUtil = (EClass) fruitPackage.getEClassifier("FruitUtil");
		EOperation oper = fruitUtil.getEOperations().get(0);
		o.setReferredOperation(oper);
		
		OCLExpression arg = factory.createUnspecifiedValueExp();
		o.getArgument().add(arg);
		CollectionType ctype = factory.createOrderedSetType();
		ctype.setElementType(color);
		arg.setType(ctype);
		
		OCLExpression source = factory.createUnspecifiedValueExp();
		source.setType(fruitUtil);
		o.setSource(source);
		
		assertProblem(o, ExpressionsValidator.OPERATION_CALL_EXP__ARGUMENTS_CONFORM);
		
		ctype.setElementType(fruit);
		
		assertOK(o, ExpressionsValidator.OPERATION_CALL_EXP__ARGUMENTS_CONFORM);
	}
	
	/**
	 * Tests that operation call expressions involving generic arguments
	 * pass the constraint.  These are the generic <tt>T</tt> and <tt>T2</tt>
	 * parameters from collection operations in the standard library.
	 */
	public void test_OperationCallExp_checkArgumentsConform_generic_232028() {
		OperationCallExp o = (OperationCallExp) parseUnvalidated(
			"context ecore::EString inv: Set{}->including('foo')");
		
		OCLExpression arg = factory.createUnspecifiedValueExp();
		arg.setType(getOCLStandardLibrary().getInteger());
		o.getArgument().add(arg);
		
		// wrong number of arguments does not trigger this constraint
		assertOK(o, ExpressionsValidator.OPERATION_CALL_EXP__ARGUMENTS_CONFORM);
		
		o.getArgument().remove(arg);
		
		// this is a well-formed expression
		assertOK(o, ExpressionsValidator.OPERATION_CALL_EXP__ARGUMENTS_CONFORM);
		
		o.getArgument().set(0, arg);
		
		assertOK(o, ExpressionsValidator.OPERATION_CALL_EXP__ARGUMENTS_CONFORM);
	}

	/**
	 * Tests that operation call expressions involving standard library operations
	 * which have a generic collection as parameter pass the constraint.
	 * 
	 */
	public void test_OperationCallExp_checkArgumentsConform_generic_collections_236247() {
		OperationCallExp o = (OperationCallExp) parseUnvalidated(
			"context ecore::EString inv: Set{'foo'}->includesAll(Set{'bar'})");
		assertOK(o);
	}
	
	public void test_OperationCallExp_checkArgumentCount() {
		OperationCallExp o = factory.createOperationCallExp();
		
		EClass fruitUtil = (EClass) fruitPackage.getEClassifier("FruitUtil");
		EOperation oper = fruitUtil.getEOperations().get(0);
		o.setReferredOperation(oper);
		
		OCLExpression arg = factory.createUnspecifiedValueExp();
		o.getArgument().add(arg);
		CollectionType ctype = factory.createOrderedSetType();
		ctype.setElementType(color);
		arg.setType(ctype);
		
		assertOK(o, ExpressionsValidator.OPERATION_CALL_EXP__ARGUMENT_COUNT);

		o.getArgument().add(factory.createCollectionLiteralExp());
		
		assertProblem(o, ExpressionsValidator.OPERATION_CALL_EXP__ARGUMENT_COUNT);

		o.getArgument().clear();
		
		assertProblem(o, ExpressionsValidator.OPERATION_CALL_EXP__ARGUMENT_COUNT);
	}
	
	/**
	 * Tests the case of a null operation (that it doesn't throw an NPE).
	 */
	public void test_OperationCallExp_checkArgumentCount_nullOperation_231515() {
		OperationCallExp o = factory.createOperationCallExp();
		
		o.setReferredOperation(null);  // be explicit on the purpose of the test
		
		OCLExpression arg = factory.createUnspecifiedValueExp();
		o.getArgument().add(arg);
		CollectionType ctype = factory.createOrderedSetType();
		ctype.setElementType(color);
		arg.setType(ctype);
		
		assertOK(o, ExpressionsValidator.OPERATION_CALL_EXP__ARGUMENT_COUNT);

		o.getArgument().add(factory.createCollectionLiteralExp());
		
		assertOK(o, ExpressionsValidator.OPERATION_CALL_EXP__ARGUMENT_COUNT);

		o.getArgument().clear();
		
		assertOK(o, ExpressionsValidator.OPERATION_CALL_EXP__ARGUMENT_COUNT);
	}
	
	public void test_PropertyCallExp_checkPropertyType() {
		PropertyCallExp p = factory.createPropertyCallExp();
		
		p.setReferredProperty(apple_label);
		p.setType(getOCLStandardLibrary().getBoolean());
		
		OCLExpression source = factory.createUnspecifiedValueExp();
		source.setType(apple);
		p.setSource(source);
		
		assertProblem(p, ExpressionsValidator.PROPERTY_CALL_EXP__PROPERTY_TYPE);

		p.setType(getOCLStandardLibrary().getString());
		
		assertOK(p, ExpressionsValidator.PROPERTY_CALL_EXP__PROPERTY_TYPE);
	}
	
	public void test_RealLiteralExp_checkRealType() {
		RealLiteralExp rl = factory.createRealLiteralExp();
		rl.setRealSymbol(42.0);
		rl.setType(apple);
		
		assertProblem(rl, ExpressionsValidator.REAL_LITERAL_EXP__REAL_TYPE);
		
		rl.setType(getOCLStandardLibrary().getInteger());
		
		assertProblem(rl, ExpressionsValidator.REAL_LITERAL_EXP__REAL_TYPE);
		
		rl.setType(getOCLStandardLibrary().getReal());
		
		assertOK(rl, ExpressionsValidator.REAL_LITERAL_EXP__REAL_TYPE);
	}
	
	public void test_StringLiteralExp_checkStringType() {
		StringLiteralExp sl = factory.createStringLiteralExp();
		sl.setStringSymbol("42");
		sl.setType(apple);
		
		assertProblem(sl, ExpressionsValidator.STRING_LITERAL_EXP__STRING_TYPE);
		
		sl.setType(getOCLStandardLibrary().getInteger());
		
		assertProblem(sl, ExpressionsValidator.STRING_LITERAL_EXP__STRING_TYPE);
		
		sl.setType(getOCLStandardLibrary().getString());
		
		assertOK(sl, ExpressionsValidator.STRING_LITERAL_EXP__STRING_TYPE);
	}
	
	public void test_TupleLiteralExp_checkTupleType() {
		TupleLiteralExp t = factory.createTupleLiteralExp();
		TupleLiteralPart part1 = factory.createTupleLiteralPart();
		part1.setName("a");
		part1.setType(getOCLStandardLibrary().getString());
		t.getPart().add(part1);
		TupleLiteralPart part2 = factory.createTupleLiteralPart();
		part2.setName("b");
		part2.setType(getOCLStandardLibrary().getInteger());
		t.getPart().add(part2);
		
		t.setType(getOCLStandardLibrary().getBag());
		
		assertProblem(t, ExpressionsValidator.TUPLE_LITERAL_EXP__TUPLE_TYPE);
		
		TupleType tt = factory.createTupleType();
		t.setType(tt);
		
		assertProblem(t, ExpressionsValidator.TUPLE_LITERAL_EXP__TUPLE_TYPE);
		
		EStructuralFeature a = ocl.getEnvironment().getUMLReflection()
				.createProperty("a", getOCLStandardLibrary().getString());
		tt.getEStructuralFeatures().add(a);
		part1.setAttribute(a);
		
		assertProblem(t, ExpressionsValidator.TUPLE_LITERAL_EXP__TUPLE_TYPE);
		
		EStructuralFeature b = ocl.getEnvironment().getUMLReflection()
				.createProperty("b", getOCLStandardLibrary().getInteger());
		tt.getEStructuralFeatures().add(b);
		part2.setAttribute(b);
		
		assertOK(t, ExpressionsValidator.TUPLE_LITERAL_EXP__TUPLE_TYPE);
	}
	
	public void test_TupleLiteralExp_checkPartsUnique() {
		TupleLiteralExp t = factory.createTupleLiteralExp();
		TupleLiteralPart part1 = factory.createTupleLiteralPart();
		part1.setName("a");
		part1.setType(getOCLStandardLibrary().getString());
		t.getPart().add(part1);
		TupleLiteralPart part2 = factory.createTupleLiteralPart();
		part2.setName("a");
		part2.setType(getOCLStandardLibrary().getInteger());
		t.getPart().add(part2);
		
		assertProblem(t, ExpressionsValidator.TUPLE_LITERAL_EXP__PARTS_UNIQUE);
		
		part2.setName("b");
		
		assertOK(t, ExpressionsValidator.TUPLE_LITERAL_EXP__PARTS_UNIQUE);
	}
	
	public void test_TupleLiteralExp_checkValueType() {
		TupleLiteralPart p = factory.createTupleLiteralPart();
		p.setName("a");
		p.setType(fruit);
		
		OCLExpression value = factory.createUnspecifiedValueExp();
		value.setType(apple);
		p.setValue(value);
		
		EStructuralFeature a = ocl.getEnvironment().getUMLReflection()
				.createProperty("a", fruit);
		p.setAttribute(a);
		
		assertProblem(p, ExpressionsValidator.TUPLE_LITERAL_PART__VALUE_TYPE);
		
		value.setType(fruit);
		
		assertOK(p, ExpressionsValidator.TUPLE_LITERAL_PART__VALUE_TYPE);
	}
	
	public void test_UnlimitedNaturalLiteralExp_checkNaturalType() {
		UnlimitedNaturalLiteralExp ul = factory.createUnlimitedNaturalLiteralExp();
		ul.setIntegerSymbol(42);
		ul.setType(apple);
		
		assertProblem(ul, ExpressionsValidator.UNLIMITED_NATURAL_LITERAL_EXP__NATURAL_TYPE);
		
		ul.setType(getOCLStandardLibrary().getString());
		
		assertProblem(ul, ExpressionsValidator.UNLIMITED_NATURAL_LITERAL_EXP__NATURAL_TYPE);
		
		ul.setType(getOCLStandardLibrary().getUnlimitedNatural());
		
		assertOK(ul, ExpressionsValidator.UNLIMITED_NATURAL_LITERAL_EXP__NATURAL_TYPE);
	}
	
	public void test_VariableExp_checkVarType() {
		VariableExp v = factory.createVariableExp();
		v.setType(fruit);
		
		Variable var = factory.createVariable();
		var.setName("a");
		var.setType(apple);
		v.setReferredVariable(var);
		
		assertProblem(v, ExpressionsValidator.VARIABLE_EXP__VAR_TYPE);
		
		var.setType(fruit);

		assertOK(v, ExpressionsValidator.VARIABLE_EXP__VAR_TYPE);
	}
	
	public void test_Variable_checknitType() {
		Variable v = factory.createVariable();
		v.setName("a");
		v.setType(fruit);

		assertOK(v, ExpressionsValidator.VARIABLE__INIT_TYPE);
		
		OCLExpression init = factory.createUnspecifiedValueExp();
		init.setType(color);
		v.setInitExpression(init);
		
		assertProblem(v, ExpressionsValidator.VARIABLE__INIT_TYPE);
		
		init.setType(apple);

		assertOK(v, ExpressionsValidator.VARIABLE__INIT_TYPE);
	}

	//
	// Fixture methods
	//
	
	protected Diagnostic validate(EObject target) {
		Map<Object, Object> ctx = new java.util.HashMap<Object, Object>();
		ctx.put(Environment.class, ocl.getEnvironment());
		return Diagnostician.INSTANCE.validate(target, ctx);
	}
	
	protected void assertProblem(EObject target, int code) {
		assertProblem(validate(target), target, code);
	}
	
	protected void assertProblem(Diagnostic diagnostic, EObject target, int code) {
		Diagnostic problem = findProblem(diagnostic, target, code);
		assertNotNull("Problem not found", problem);
		System.out.println("Found expected problem: " + problem.getMessage());
	}
	
	protected Diagnostic findProblem(Diagnostic diagnostic, EObject target, int code) {
		if (ExpressionsValidator.DIAGNOSTIC_SOURCE.equals(diagnostic
				.getSource())
				&& (diagnostic.getSeverity() != Diagnostic.OK)
				&& diagnostic.getData().contains(target)
				&& (diagnostic.getCode() == code)) {
			return diagnostic;
		}
		
		for (Diagnostic child : diagnostic.getChildren()) {
			Diagnostic result = findProblem(child, target, code);
			
			if (result != null) {
				return result;
			}
		}
		
		return null;
	}
	
	protected Diagnostic findProblem(Diagnostic diagnostic, EObject target) {
		if (ExpressionsValidator.DIAGNOSTIC_SOURCE.equals(diagnostic
				.getSource())
				&& (diagnostic.getSeverity() != Diagnostic.OK)
				&& diagnostic.getData().contains(target)) {
			return diagnostic;
		}
		
		for (Diagnostic child : diagnostic.getChildren()) {
			Diagnostic result = findProblem(child, target);
			
			if (result != null) {
				return result;
			}
		}
		
		return null;
	}
	
	protected void assertOK(EObject target, int code) {
		assertOK(validate(target), target, code);
	}
	
	protected void assertOK(Diagnostic diagnostic, EObject target, int code) {
		assertNull("Problem found", findProblem(diagnostic, target, code));
	}
	
	protected void assertOK(EObject target) {
		assertOK(validate(target), target);
	}
	
	protected void assertOK(Diagnostic diagnostic, EObject target) {
		assertNull("Problem found", findProblem(diagnostic, target));
	}
}

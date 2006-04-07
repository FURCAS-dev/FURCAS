/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
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

package org.eclipse.emf.ocl.tests;

import java.util.Iterator;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ocl.expressions.AssociationClassCallExp;
import org.eclipse.emf.ocl.expressions.BooleanLiteralExp;
import org.eclipse.emf.ocl.expressions.CollectionItem;
import org.eclipse.emf.ocl.expressions.CollectionLiteralExp;
import org.eclipse.emf.ocl.expressions.CollectionLiteralPart;
import org.eclipse.emf.ocl.expressions.CollectionRange;
import org.eclipse.emf.ocl.expressions.EnumLiteralExp;
import org.eclipse.emf.ocl.expressions.FeatureCallExp;
import org.eclipse.emf.ocl.expressions.IfExp;
import org.eclipse.emf.ocl.expressions.IntegerLiteralExp;
import org.eclipse.emf.ocl.expressions.InvalidLiteralExp;
import org.eclipse.emf.ocl.expressions.IterateExp;
import org.eclipse.emf.ocl.expressions.IteratorExp;
import org.eclipse.emf.ocl.expressions.LetExp;
import org.eclipse.emf.ocl.expressions.LoopExp;
import org.eclipse.emf.ocl.expressions.MessageExp;
import org.eclipse.emf.ocl.expressions.NullLiteralExp;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.OperationCallExp;
import org.eclipse.emf.ocl.expressions.PropertyCallExp;
import org.eclipse.emf.ocl.expressions.RealLiteralExp;
import org.eclipse.emf.ocl.expressions.StateExp;
import org.eclipse.emf.ocl.expressions.StringLiteralExp;
import org.eclipse.emf.ocl.expressions.TupleLiteralExp;
import org.eclipse.emf.ocl.expressions.TupleLiteralPart;
import org.eclipse.emf.ocl.expressions.TypeExp;
import org.eclipse.emf.ocl.expressions.UnspecifiedValueExp;
import org.eclipse.emf.ocl.expressions.Variable;
import org.eclipse.emf.ocl.expressions.VariableExp;
import org.eclipse.emf.ocl.expressions.Visitor;
import org.eclipse.emf.ocl.expressions.util.ExpressionsUtil;
import org.eclipse.emf.ocl.types.CollectionType;
import org.eclipse.emf.ocl.uml.Constraint;
import org.eclipse.emf.ocl.utilities.ASTNode;
import org.eclipse.emf.ocl.utilities.CallingASTNode;
import org.eclipse.emf.ocl.utilities.TypedASTNode;

/**
 * Tests for recording of token location information in parsed OCL expressions.
 *
 * @author Christian W. Damus (cwdamus)
 */
public class LocationInformationTest
	extends AbstractTestSuite {

	public LocationInformationTest(String name) {
		super(name);
	}
	
	public static Test suite() {
		return new TestSuite(LocationInformationTest.class, "Location Information Tests"); //$NON-NLS-1$
	}
	
	/**
	 * Tests the <code>implies</code> expression, boolean literal, enumeration
	 * literal, attribute call, and not-equals expression in an invariant
	 * constraint.
	 */
	public void test_invariant() {
		final String exprString = "true implies self.color <> Color::black"; //$NON-NLS-1$
		OCLExpression constraint = createQuery(apple, exprString);
		
		OperationCallExp impliesExp = asOperationCall(constraint);
		assertLocation(impliesExp, 0, exprString.length());
		
		BooleanLiteralExp bl = asBooleanLiteral(impliesExp.getSource());
		assertLocation(bl, 0, "true".length()); //$NON-NLS-1$
		
		int selfPos = exprString.indexOf("self"); //$NON-NLS-1$
		
		OperationCallExp notEqualsExp = asOperationCall(
			impliesExp.getArgument().get(0));
		assertLocation(notEqualsExp, selfPos, exprString.length());
		
		PropertyCallExp attrCall = asPropertyCall(notEqualsExp.getSource());
		assertLocation(attrCall, selfPos, selfPos + "self.color".length()); //$NON-NLS-1$
		
		VariableExp selfVar = asVariable(attrCall.getSource());
		assertLocation(selfVar, selfPos, selfPos + "self".length()); //$NON-NLS-1$
		
		EnumLiteralExp enumLiteral = asEnumLiteral(notEqualsExp.getArgument().get(0));
		assertLocation(enumLiteral, exprString.indexOf("Color"), exprString.length()); //$NON-NLS-1$
	}
	
	/**
	 * Tests the <code>if</code> expression, string literal, collection literal,
	 * and iterator expression in an query condition.
	 */
	public void test_query() {
		final String exprString =
			"if false then 'Spy' else " + //$NON-NLS-1$
			"Set{'Spartan', 'GrannySmith', 'Macintosh'}->any(i : String | i <> '')" + //$NON-NLS-1$
			" endif"; //$NON-NLS-1$
		OCLExpression constraint = createQuery(apple, exprString);
		
		IfExp ifExp = asIf(constraint);
		assertLocation(ifExp, 0, exprString.length());
		
		int falsePos = exprString.indexOf("false"); //$NON-NLS-1$
		
		BooleanLiteralExp bl = asBooleanLiteral(ifExp.getCondition());
		assertLocation(bl, falsePos, falsePos + "false".length()); //$NON-NLS-1$
		
		int spyPos = exprString.indexOf("'Spy'"); //$NON-NLS-1$
		
		StringLiteralExp stringLiteral = asStringLiteral(ifExp.getThenExpression());
		assertLocation(stringLiteral, spyPos, spyPos + "'Spy'".length()); //$NON-NLS-1$
		
		IteratorExp anyIterator = asIterator(ifExp.getElseExpression());
		assertLocation(anyIterator,
			exprString.indexOf("Set"), //$NON-NLS-1$
			exprString.indexOf("endif") - 1); //$NON-NLS-1$
		
		Variable vdecl = asVariableDeclaration(anyIterator.getIterator().get(0));
		assertLocation(vdecl,
			exprString.indexOf("i :"), //$NON-NLS-1$
			exprString.indexOf("|") - 1); //$NON-NLS-1$
		
		OCLExpression anyBody = anyIterator.getBody();
		assertLocation(anyBody,
			exprString.indexOf("i <>"), //$NON-NLS-1$
			exprString.indexOf(")")); //$NON-NLS-1$
		
		CollectionLiteralExp collLiteral = asCollectionLiteral(anyIterator.getSource());
		assertLocation(collLiteral,
			exprString.indexOf("Set"), //$NON-NLS-1$
			exprString.indexOf("->")); //$NON-NLS-1$
		
		int grannyPos = exprString.indexOf("'GrannySmith'"); //$NON-NLS-1$
		
		// get the second item
		CollectionItem item = asCollectionItem(collLiteral.getPart().get(1));
		stringLiteral = asStringLiteral(item.getItem());
		assertLocation(stringLiteral,
			grannyPos,
			grannyPos + "'GrannySmith'".length()); //$NON-NLS-1$
	}
	
	/**
	 * Tests the <code>@pre</code> model property calls in a postcondition,
	 * with a let expression for good measure.
	 */
	public void test_postcondition() {
		final String exprString =
			"let oldColor : Color = self.color@pre in oldColor <> self.color"; //$NON-NLS-1$
		OCLExpression constraint = createPostcondition(fruit_ripen, exprString);
		
		LetExp letExp = asLet(constraint);
		assertLocation(letExp, 0, exprString.length());
		
		Variable vdecl = letExp.getVariable();
		assertLocation(vdecl,
			exprString.indexOf("oldColor :"), //$NON-NLS-1$
			exprString.indexOf(" in ")); //$NON-NLS-1$
		
		PropertyCallExp attrExp = asPropertyCall(vdecl.getInitExpression());
		assertLocation(attrExp,
			exprString.indexOf("self"), //$NON-NLS-1$
			exprString.indexOf(" in ")); //$NON-NLS-1$
		
		OperationCallExp notEqualExp = asOperationCall(letExp.getIn());
		assertLocation(notEqualExp,
			exprString.indexOf("oldColor <>"), //$NON-NLS-1$
			exprString.length());
	}
	
	/**
	 * Tests the effect of parentheses around expressions.
	 */
	public void test_parentheses() {
		final String exprString =
			"( (true) implies ( (false) or ((true)) ) )"; //$NON-NLS-1$
		OCLExpression constraint = createQuery(fruit, exprString);
		
		OperationCallExp operCall = asOperationCall(constraint);
		assertLocation(operCall, 0, exprString.length());
		
		BooleanLiteralExp literal = asBooleanLiteral(operCall.getSource());
		assertLocation(literal,
			exprString.indexOf("(true) imp"), //$NON-NLS-1$
			exprString.indexOf(" imp")); //$NON-NLS-1$
		
		operCall = asOperationCall(operCall.getArgument().get(0));
		assertLocation(operCall,
			exprString.indexOf("( (false"), //$NON-NLS-1$
			exprString.length() - 2);
		
		literal = asBooleanLiteral(operCall.getSource());
		assertLocation(literal,
			exprString.indexOf("(false) or"), //$NON-NLS-1$
			exprString.indexOf(" or")); //$NON-NLS-1$
		
		literal = asBooleanLiteral(operCall.getArgument().get(0));
		assertLocation(literal,
			exprString.indexOf("((true)) )"), //$NON-NLS-1$
			exprString.length() - 4);
	}
	
	/**
	 * Tests the retention of location information for type names.
	 */
	public void test_typePositions() {
		final String exprString =
			"let isApple : Boolean = self.oclIsKindOf(Apple) in " + //$NON-NLS-1$
			"isApple implies Apple.allInstances()->includes(self.oclAsType(Apple))"; //$NON-NLS-1$
		OCLExpression constraint = createQuery(fruit, exprString);
		
		LetExp letExp = asLet(constraint);
		assertLocation(letExp, 0, exprString.length());
		
		Variable vdecl = letExp.getVariable();
		assertTypeLocation(vdecl,
			exprString.indexOf("Boolean"), //$NON-NLS-1$
			exprString.indexOf(" = ")); //$NON-NLS-1$
		
		TypeExp typeExp = asType(
			asOperationCall(vdecl.getInitExpression()).getArgument().get(0));
		assertLocation(typeExp,
			exprString.indexOf("Apple) in "), //$NON-NLS-1$
			exprString.indexOf(") in ")); //$NON-NLS-1$
		
		OperationCallExp operCall = asOperationCall(
			asOperationCall(letExp.getIn()).getArgument().get(0));
		
		operCall = asOperationCall(operCall.getSource());
		typeExp = asType(operCall.getSource());
		assertLocation(typeExp,
			exprString.indexOf("Apple.all"), //$NON-NLS-1$
			exprString.indexOf(".all")); //$NON-NLS-1$
	}
	
	/**
	 * Tests the retention of location information for collection element types.
	 */
	public void test_elementTypePositions() {
		final String exprString =
			"let allApples : Set(Apple) = Apple.allInstances() in " + //$NON-NLS-1$
			"allApples->includes(self)"; //$NON-NLS-1$
		OCLExpression constraint = createQuery(apple, exprString);
		
		LetExp letExp = asLet(constraint);
		assertLocation(letExp, 0, exprString.length());
		
		Variable vdecl = letExp.getVariable();
		assertTypeLocation(vdecl,
			exprString.indexOf("Set("), //$NON-NLS-1$
			exprString.indexOf(" = ")); //$NON-NLS-1$
		
		CollectionType collType = (CollectionType) vdecl.getType();
		assertTypeLocation(collType,
			exprString.indexOf("Apple) = "), //$NON-NLS-1$
			exprString.indexOf(") = ")); //$NON-NLS-1$
	}

	/**
	 * Tests the retention of location information for property names referenced
	 * by operation call expressions.
	 */
	public void test_propertyPositions_operationCall() {
		final String exprString =
			"Apple.allInstances()->includes(self)"; //$NON-NLS-1$
		OCLExpression constraint = createQuery(apple, exprString);

		// collection operation (arrow)
		OperationCallExp includesExp = asOperationCall(constraint);
		assertPropertyLocation(includesExp,
			exprString.indexOf("includes"), //$NON-NLS-1$
			exprString.indexOf("(self)")); //$NON-NLS-1$

		// element operation (dot)
		FeatureCallExp mpcExp = asFeatureCall(
			includesExp.getSource());
		assertPropertyLocation(mpcExp,
			exprString.indexOf("allInst"), //$NON-NLS-1$
			exprString.indexOf("()")); //$NON-NLS-1$


	}
	
	/**
	 * Tests the retention of location information for property names referenced
	 * by attribute call expressions.
	 */
	public void test_propertyPositions_attributeCall() {
		// throw in spaces for fun
		final String exprString =
			"not ripen(self. color )"; //$NON-NLS-1$
		OCLExpression constraint = createQuery(apple, exprString);

		OperationCallExp notExp = asOperationCall(constraint);
		OperationCallExp ripenExp = asOperationCall(notExp.getSource());

		FeatureCallExp mpcExp = asFeatureCall(
			ripenExp.getArgument().get(0));
		assertPropertyLocation(mpcExp,
			exprString.indexOf("color "), //$NON-NLS-1$
			exprString.indexOf(" )")); //$NON-NLS-1$
	}

	/**
	 * Tests the retention of location information for property names referenced
	 * by association end call expressions.
	 */
	public void test_propertyPositions_associationEndCall() {
		final String exprString =
			"self.stem->notEmpty()"; //$NON-NLS-1$
		OCLExpression constraint = createQuery(apple, exprString);
		
		OperationCallExp notEmptyExp = asOperationCall(constraint);
		
		// the OCL is implicitly Set{self.stem}->notEmpty()
		CollectionLiteralExp setExp = asCollectionLiteral(notEmptyExp.getSource());
		
		FeatureCallExp mpcExp = asFeatureCall(
			((CollectionItem) setExp.getPart().get(0)).getItem());
		assertPropertyLocation(mpcExp,
			exprString.indexOf("stem"), //$NON-NLS-1$
			exprString.indexOf("->")); //$NON-NLS-1$
	}

	/**
	 * Tests the retention of location information for property names referenced
	 * by implied collect expressions.
	 */
	public void test_propertyPositions_implicitCollect() {
		final String exprString =
			"orderedSet.color->asSet()->size() = 1"; //$NON-NLS-1$
		OCLExpression constraint = createQuery(
			(EClass) fruitPackage.getEClassifier("FruitUtil"), //$NON-NLS-1$
			exprString);
		
		OperationCallExp eqExp = asOperationCall(constraint);
		OperationCallExp sizeExp = asOperationCall(eqExp.getSource());
		OperationCallExp asSetExp = asOperationCall(sizeExp.getSource());
		
		// implied collect expression
		IteratorExp iterExp = asIterator(asSetExp.getSource());

		FeatureCallExp mpcExp = asFeatureCall(iterExp.getBody());
		assertPropertyLocation(mpcExp,
			exprString.indexOf("color"), //$NON-NLS-1$
			exprString.indexOf("->asSet")); //$NON-NLS-1$
	}
	
	/**
	 * Tests the retention of location information for EReference names referenced
	 * by implied collect expressions.  This test was added to validate a problem found
	 * in code review.
	 */
	public void test_referencePositions_implicitCollect() {
		final String exprString =
			"Apple.allInstances().stem->asSet()->size() > 1"; //$NON-NLS-1$
		OCLExpression constraint = createQuery(apple, exprString);

		OperationCallExp eqExp = asOperationCall(constraint);
		OperationCallExp sizeExp = asOperationCall(eqExp.getSource());
		OperationCallExp asSetExp = asOperationCall(sizeExp.getSource());

		// implied collect expression
		IteratorExp iterExp = asIterator(asSetExp.getSource());

		FeatureCallExp mpcExp = asFeatureCall(iterExp.getBody());
		assertPropertyLocation(mpcExp,
			exprString.indexOf("stem"), //$NON-NLS-1$
			exprString.indexOf("->asSet")); //$NON-NLS-1$
	}
	
	/**
	 * Tests the retention of location information for the components of a
	 * message expression.
	 */
	public void test_messageExp_positions() {
		final String exprString =
			"self^ripen(? : Color)"; //$NON-NLS-1$
		OCLExpression constraint = createQuery(fruit, exprString);
		
		MessageExp msgExp = asMessage(constraint);
		assertLocation(msgExp, 0, exprString.length());
		assertPropertyLocation(msgExp,
				exprString.indexOf("ripen"), //$NON-NLS-1$
				exprString.indexOf("(")); //$NON-NLS-1$
		
		VariableExp var = asVariable(msgExp.getTarget());
		assertLocation(var,	0, exprString.indexOf("^")); //$NON-NLS-1$
		
		UnspecifiedValueExp unspecExp = asUnspecifiedValue(
			msgExp.getArgument().get(0));
		assertLocation(unspecExp,
			exprString.indexOf("?"), //$NON-NLS-1$
			exprString.indexOf(")")); //$NON-NLS-1$
		assertTypeLocation(unspecExp,
			exprString.indexOf("Color"), //$NON-NLS-1$
			exprString.indexOf(")")); //$NON-NLS-1$
	}
	
	//
	// Framework methods
	//
	
	static OCLExpression createQuery(EClass context, String text) {
		OCLExpression result = null;
		
		try {
			result = ExpressionsUtil.createQuery(context, text, true);
			
			assertAllPositionsSet(result);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		return result;
	}
	
	static OCLExpression createInvariant(EClass context, String text) {
		OCLExpression result = null;
		
		try {
			result = ExpressionsUtil.createInvariant(context, text, true);
			
			assertAllPositionsSet(result);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		return result;
	}
	
	static OCLExpression createPrecondition(EOperation context, String text) {
		OCLExpression result = null;
		
		try {
			result = ExpressionsUtil.createPrecondition(
				context.getEContainingClass(), context, text, true);
			
			assertAllPositionsSet(result);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		return result;
	}
	
	static OCLExpression createPostcondition(EOperation context, String text) {
		OCLExpression result = null;
		
		try {
			result = ExpressionsUtil.createPostcondition(
				context.getEContainingClass(), context, text, true);
			
			assertAllPositionsSet(result);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		return result;
	}
	
	static OCLExpression createBodyCondition(EOperation context, String text) {
		OCLExpression result = null;
		
		try {
			result = ExpressionsUtil.createBodyCondition(
				context.getEContainingClass(), context, text, true);
			
			assertAllPositionsSet(result);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		return result;
	}
	
	static IfExp asIf(Object obj) {
		return (IfExp) cast(obj, IfExp.class);
	}
	
	static EnumLiteralExp asEnumLiteral(Object obj) {
		return (EnumLiteralExp) cast(obj, EnumLiteralExp.class);
	}
	
	static VariableExp asVariable(Object obj) {
		return (VariableExp) cast(obj, VariableExp.class);
	}
	
	static LetExp asLet(Object obj) {
		return (LetExp) cast(obj, LetExp.class);
	}
	
	static LoopExp asLoop(Object obj) {
		return (LoopExp) cast(obj, LoopExp.class);
	}
	
	static IteratorExp asIterator(Object obj) {
		return (IteratorExp) cast(obj, IteratorExp.class);
	}
	
	static PropertyCallExp asPropertyCall(Object obj) {
		return (PropertyCallExp) cast(obj, PropertyCallExp.class);
	}

	static FeatureCallExp asFeatureCall(Object obj) {
		return (FeatureCallExp) cast(obj, FeatureCallExp.class);
	}

	static AssociationClassCallExp asAssociationClassCall(Object obj) {
		return (AssociationClassCallExp) cast(obj, AssociationClassCallExp.class);
	}
	
	static OperationCallExp asOperationCall(Object obj) {
		return (OperationCallExp) cast(obj, OperationCallExp.class);
	}
	
	static BooleanLiteralExp asBooleanLiteral(Object obj) {
		return (BooleanLiteralExp) cast(obj, BooleanLiteralExp.class);
	}
	
	static StringLiteralExp asStringLiteral(Object obj) {
		return (StringLiteralExp) cast(obj, StringLiteralExp.class);
	}
	
	static CollectionLiteralExp asCollectionLiteral(Object obj) {
		return (CollectionLiteralExp) cast(obj, CollectionLiteralExp.class);
	}
	
	static CollectionItem asCollectionItem(Object obj) {
		return (CollectionItem) cast(obj, CollectionItem.class);
	}
	
	static Variable asVariableDeclaration(Object obj) {
		return (Variable) cast(obj, Variable.class);
	}
	
	static TypeExp asType(Object obj) {
		return (TypeExp) cast(obj, TypeExp.class);
	}
	
	static MessageExp asMessage(Object obj) {
		return (MessageExp) cast(obj, MessageExp.class);
	}
	
	static UnspecifiedValueExp asUnspecifiedValue(Object obj) {
		return (UnspecifiedValueExp) cast(obj, UnspecifiedValueExp.class);
	}
	
	static Object cast(Object obj, Class expectedClass) {
		assertTrue("Expected type: " + expectedClass + ", got: " + obj.getClass(),  //$NON-NLS-1$//$NON-NLS-2$
			expectedClass.isInstance(obj));
		
		return obj;
	}
	
	static void assertAllPositionsSet(OCLExpression expr) {
		assertNotNull(expr);
		expr.accept(LocationVerifier.INSTANCE);
	}
	
	static void assertLocation(ASTNode node, int start, int end) {
		assertEquals("Wrong start position", start, node.getStartPosition()); //$NON-NLS-1$
		assertEquals("Wrong end position", end, node.getEndPosition()); //$NON-NLS-1$
	}
	
	static void assertTypeLocation(TypedASTNode node, int start, int end) {
		assertEquals("Wrong type start position", start, node.getTypeStartPosition()); //$NON-NLS-1$
		assertEquals("Wrong type end position", end, node.getTypeEndPosition()); //$NON-NLS-1$
	}

	static void assertPropertyLocation(CallingASTNode node, int start, int end) {
		assertEquals("Wrong property start position", start, node.getPropertyStartPosition()); //$NON-NLS-1$
		assertEquals("Wrong property end position", end, node.getPropertyEndPosition()); //$NON-NLS-1$
	}
	
	/**
	 * Visitor implementation that checks all AST nodes that they have their
	 * start and end positions set.
	 *
	 * @author Christian W. Damus (cdamus)
	 */
	private static class LocationVerifier implements Visitor {
		static LocationVerifier INSTANCE = new LocationVerifier();

		private boolean isExempt(OCLExpression expr) {
			if (expr instanceof VariableExp) {
				return isImplicit(((VariableExp) expr).getReferredVariable());
			}

			return (expr instanceof CollectionLiteralExp)
				|| (expr instanceof CollectionLiteralPart);
		}

		private boolean isImplicit(Variable vdecl) {
			// ignore "self" because it may be implicit.
			// Anything starting with "temp" is an implicit variable declaration
			String name = vdecl.getName();

			return (name == null)
				|| name.equals("self") //$NON-NLS-1$
				|| name.startsWith("temp"); //$NON-NLS-1$
		}

		private void assertPositions(OCLExpression expr) {
			if (!isExempt(expr)) {
				assertFalse("Start not set: " + expr, expr.getStartPosition() < 0); //$NON-NLS-1$
				assertFalse("End not set: " + expr, expr.getEndPosition() < 0); //$NON-NLS-1$
				assertTrue("End not after start: " + expr, expr.getEndPosition() > expr.getStartPosition()); //$NON-NLS-1$
			}
		}

		private void assertPositions(Variable vdecl) {
			if (!isImplicit(vdecl)) {
				assertFalse("Start not set: " + vdecl, vdecl.getStartPosition() < 0); //$NON-NLS-1$
				assertFalse("End not set: " + vdecl, vdecl.getEndPosition() < 0); //$NON-NLS-1$
				assertTrue("End not after start: " + vdecl, //$NON-NLS-1$
					vdecl.getEndPosition() > vdecl.getStartPosition());
			}
		}

		public Object visitOperationCallExp(OperationCallExp oc) {
			assertPositions(oc);
			
			oc.getSource().accept(this);
			
			for (Iterator iter = oc.getArgument().iterator(); iter.hasNext();) {
				((OCLExpression) iter.next()).accept(this);
			}
			
			return null;
		}

		public Object visitVariableExp(VariableExp v) {
			assertPositions(v);
			
			v.getReferredVariable().accept(this);
			
			return null;
		}

		public Object visitPropertyCallExp(PropertyCallExp pc) {
			assertPositions(pc);
			
			if (pc.getSource() != null) {
				// can be null if 'pc' is qualifier of an association class call
				pc.getSource().accept(this);
			}
			
			for (Iterator iter = pc.getQualifier().iterator(); iter.hasNext();) {
				((OCLExpression) iter.next()).accept(this);
			}
			
			return null;
		}

		public Object visitAssociationClassCallExp(AssociationClassCallExp ac) {
			assertPositions(ac);
			
			ac.getSource().accept(this);
			
			for (Iterator iter = ac.getQualifier().iterator(); iter.hasNext();) {
				((OCLExpression) iter.next()).accept(this);
			}
			
			return null;
		}

		public Object visitVariable(Variable vd) {
			// the 'self' variable is often implicit, in which case it is not
			//    in the input at all, so don't verify it
			if (!"self".equals(vd.getName())) { //$NON-NLS-1$
				assertPositions(vd);
			}
			
			if (vd.getInitExpression() != null) {
				vd.getInitExpression().accept(this);
			}
			
			return null;
		}

		public Object visitIfExp(IfExp i) {
			assertPositions(i);
			
			i.getCondition().accept(this);
			i.getThenExpression().accept(this);
			i.getElseExpression().accept(this);
			
			return null;
		}

		public Object visitTypeExp(TypeExp t) {
			assertPositions(t);
			return null;
		}

		public Object visitUnspecifiedValueExp(UnspecifiedValueExp uv) {
			assertPositions(uv);
			return null;
		}
		
		public Object visitStateExp(StateExp s) {
			assertPositions(s);
			return null;
		}
		
		public Object visitMessageExp(MessageExp m) {
			assertPositions(m);
			
			m.getTarget().accept(this);
			
			for (Iterator iter = m.getArgument().iterator(); iter.hasNext();) {
				((OCLExpression) iter.next()).accept(this);
			}
			
			return null;
		}

		public Object visitIntegerLiteralExp(IntegerLiteralExp il) {
			assertPositions(il);
			return null;
		}

		public Object visitRealLiteralExp(RealLiteralExp rl) {
			assertPositions(rl);
			return null;
		}

		public Object visitStringLiteralExp(StringLiteralExp sl) {
			assertPositions(sl);
			return null;
		}

		public Object visitBooleanLiteralExp(BooleanLiteralExp bl) {
			assertPositions(bl);
			return null;
		}

		public Object visitTupleLiteralExp(TupleLiteralExp tl) {
			assertPositions(tl);
			
			for (Iterator iter = tl.getPart().iterator(); iter.hasNext();) {
				((Variable) iter.next()).accept(this);
			}
			
			return null;
		}
		
		public Object visitTupleLiteralPart(TupleLiteralPart tp) {
			if (tp.getValue() != null) {
				tp.getValue().accept(this);
			}
			
			return null;
		}

		public Object visitLetExp(LetExp l) {
			assertPositions(l);
			
			l.getVariable().accept(this);
			l.getIn().accept(this);
			
			return null;
		}

		public Object visitEnumLiteralExp(EnumLiteralExp el) {
			assertPositions(el);
			return null;
		}

		public Object visitCollectionLiteralExp(CollectionLiteralExp cl) {
			assertPositions(cl);
			
			for (Iterator iter = cl.getPart().iterator(); iter.hasNext();) {
				Object next = iter.next();
				
				if (next instanceof CollectionItem) {
					((CollectionItem) next).getItem().accept(this);
				} else if (next instanceof CollectionRange) {
					((CollectionRange) next).getFirst().accept(this);
					((CollectionRange) next).getLast().accept(this);
				}
			}
			
			return null;
		}

		public Object visitIteratorExp(IteratorExp ie) {
			assertPositions(ie);
			
			ie.getSource().accept(this);
			
			for (Iterator iter = ie.getIterator().iterator(); iter.hasNext();) {
				((Variable) iter.next()).accept(this);
			}
			
			ie.getBody().accept(this);
			
			return null;
		}

		public Object visitIterateExp(IterateExp ie) {
			assertPositions(ie);
			
			ie.getSource().accept(this);
			
			for (Iterator iter = ie.getIterator().iterator(); iter.hasNext();) {
				((Variable) iter.next()).accept(this);
			}
			
			ie.getBody().accept(this);
			ie.getResult().accept(this);
			
			return null;
		}

		public Object visitConstraint(Constraint constraint) {
			return null;
		}

		public Object visitInvalidLiteralExp(InvalidLiteralExp il) {
			assertPositions(il);
			return null;
		}

		public Object visitNullLiteralExp(NullLiteralExp il) {
			assertPositions(il);
			return null;
		}
	}
}

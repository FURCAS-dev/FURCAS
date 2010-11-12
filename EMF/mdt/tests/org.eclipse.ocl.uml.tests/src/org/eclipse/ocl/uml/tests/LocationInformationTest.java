/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 248869
 *
 * </copyright>
 *
 * $Id: LocationInformationTest.java,v 1.8 2009/12/18 06:32:28 ewillink Exp $
 */

package org.eclipse.ocl.uml.tests;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.EnvironmentFactory;
import org.eclipse.ocl.expressions.AssociationClassCallExp;
import org.eclipse.ocl.expressions.BooleanLiteralExp;
import org.eclipse.ocl.expressions.CollectionItem;
import org.eclipse.ocl.expressions.CollectionLiteralExp;
import org.eclipse.ocl.expressions.CollectionLiteralPart;
import org.eclipse.ocl.expressions.EnumLiteralExp;
import org.eclipse.ocl.expressions.FeatureCallExp;
import org.eclipse.ocl.expressions.IfExp;
import org.eclipse.ocl.expressions.IntegerLiteralExp;
import org.eclipse.ocl.expressions.InvalidLiteralExp;
import org.eclipse.ocl.expressions.IterateExp;
import org.eclipse.ocl.expressions.IteratorExp;
import org.eclipse.ocl.expressions.LetExp;
import org.eclipse.ocl.expressions.LoopExp;
import org.eclipse.ocl.expressions.MessageExp;
import org.eclipse.ocl.expressions.NullLiteralExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.expressions.RealLiteralExp;
import org.eclipse.ocl.expressions.StateExp;
import org.eclipse.ocl.expressions.StringLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralPart;
import org.eclipse.ocl.expressions.TypeExp;
import org.eclipse.ocl.expressions.UnspecifiedValueExp;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.VariableExp;
import org.eclipse.ocl.uml.CollectionType;
import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.ocl.utilities.AbstractVisitor;
import org.eclipse.ocl.utilities.CallingASTNode;
import org.eclipse.ocl.utilities.TypedASTNode;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.SendSignalAction;
import org.eclipse.uml2.uml.State;

/**
 * Tests for recording of token location information in parsed OCL expressions.
 *
 * @author Christian W. Damus (cwdamus)
 */
@SuppressWarnings("nls")
public class LocationInformationTest
	extends AbstractTestSuite {
	
	/**
	 * Tests the <code>implies</code> expression, boolean literal, enumeration
	 * literal, attribute call, and not-equals expression in an invariant
	 * constraint.
	 */
	public void test_invariant() {
		final String exprString = "true implies self.color <> Color::black";
		OCLExpression<Classifier> constraint = createQuery(apple, exprString);
		
		OperationCallExp<Classifier, Operation> impliesExp = asOperationCall(constraint);
		assertLocation(impliesExp, 0, exprString.length());
		
		BooleanLiteralExp<Classifier> bl = asBooleanLiteral(impliesExp.getSource());
		assertLocation(bl, 0, "true".length());
		
		int selfPos = exprString.indexOf("self");
		
		OperationCallExp<Classifier, Operation> notEqualsExp = asOperationCall(
			impliesExp.getArgument().get(0));
		assertLocation(notEqualsExp, selfPos, exprString.length());
		
		PropertyCallExp<Classifier, Property> attrCall = asPropertyCall(notEqualsExp.getSource());
		assertLocation(attrCall, selfPos, selfPos + "self.color".length());
		
		VariableExp<Classifier, Parameter> selfVar = asVariable(attrCall.getSource());
		assertLocation(selfVar, selfPos, selfPos + "self".length());
		
		EnumLiteralExp<Classifier, EnumerationLiteral> enumLiteral = asEnumLiteral(notEqualsExp.getArgument().get(0));
		assertLocation(enumLiteral, exprString.indexOf("Color"), exprString.length());
	}
	
	/**
	 * Tests the <code>if</code> expression, string literal, collection literal,
	 * and iterator expression in an query condition.
	 */
	public void test_query() {
		final String exprString =
			"if false then 'Spy' else " +
			"Set{'Spartan', 'GrannySmith', 'Macintosh'}->any(i : String | i <> '')" +
			" endif";
		OCLExpression<Classifier> constraint = createQuery(apple, exprString);
		
		IfExp<Classifier> ifExp = asIf(constraint);
		assertLocation(ifExp, 0, exprString.length());
		
		int falsePos = exprString.indexOf("false");
		
		BooleanLiteralExp<Classifier> bl = asBooleanLiteral(ifExp.getCondition());
		assertLocation(bl, falsePos, falsePos + "false".length());
		
		int spyPos = exprString.indexOf("'Spy'");
		
		StringLiteralExp<Classifier> stringLiteral = asStringLiteral(ifExp.getThenExpression());
		assertLocation(stringLiteral, spyPos, spyPos + "'Spy'".length());
		
		IteratorExp<Classifier, Parameter> anyIterator = asIterator(ifExp.getElseExpression());
		assertLocation(anyIterator,
			exprString.indexOf("Set"),
			exprString.indexOf("endif") - 1);
		
		Variable<Classifier, Parameter> vdecl = asVariableDeclaration(anyIterator.getIterator().get(0));
		assertLocation(vdecl,
			exprString.indexOf("i :"),
			exprString.indexOf("|") - 1);
		
		OCLExpression<Classifier> anyBody = anyIterator.getBody();
		assertLocation(anyBody,
			exprString.indexOf("i <>"),
			exprString.indexOf(")"));
		
		CollectionLiteralExp<Classifier> collLiteral = asCollectionLiteral(anyIterator.getSource());
		assertLocation(collLiteral,
			exprString.indexOf("Set"),
			exprString.indexOf("->"));
		
		int grannyPos = exprString.indexOf("'GrannySmith'");
		
		// get the second item
		CollectionItem<Classifier> item = asCollectionItem(collLiteral.getPart().get(1));
		stringLiteral = asStringLiteral(item.getItem());
		assertLocation(stringLiteral,
			grannyPos,
			grannyPos + "'GrannySmith'".length());
	}
	
	/**
	 * Tests the <code>@pre</code> model property calls in a postcondition,
	 * with a let expression for good measure.
	 */
	public void test_postcondition() {
		final String exprString =
			"let oldColor : Color = self.color@pre in oldColor <> self.color";
		OCLExpression<Classifier> constraint = createPostcondition(
				fruit_ripen, exprString);
		
		LetExp<Classifier, Parameter> letExp = asLet(constraint);
		assertLocation(letExp, 0, exprString.length());
		
		Variable<Classifier, Parameter> vdecl = letExp.getVariable();
		assertLocation(vdecl,
			exprString.indexOf("oldColor :"),
			exprString.indexOf(" in "));
		
		PropertyCallExp<Classifier, Property> attrExp = asPropertyCall(vdecl.getInitExpression());
		assertLocation(attrExp,
			exprString.indexOf("self"),
			exprString.indexOf(" in "));
		
		OperationCallExp<Classifier, Operation> notEqualExp = asOperationCall(letExp.getIn());
		assertLocation(notEqualExp,
			exprString.indexOf("oldColor <>"),
			exprString.length());
	}
	
	/**
	 * Tests the effect of parentheses around expressions.
	 */
	public void test_parentheses() {
		final String exprString =
			"( (true) implies ( (false) or ((true)) ) )";
		OCLExpression<Classifier> constraint = createQuery(fruit, exprString);
		
		OperationCallExp<Classifier, Operation> operCall = asOperationCall(constraint);
		assertLocation(operCall, 0, exprString.length());
		
		BooleanLiteralExp<Classifier> literal = asBooleanLiteral(operCall.getSource());
		assertLocation(literal,
			exprString.indexOf("(true) imp"),
			exprString.indexOf(" imp"));
		
		operCall = asOperationCall(operCall.getArgument().get(0));
		assertLocation(operCall,
			exprString.indexOf("( (false"),
			exprString.length() - 2);
		
		literal = asBooleanLiteral(operCall.getSource());
		assertLocation(literal,
			exprString.indexOf("(false) or"),
			exprString.indexOf(" or"));
		
		literal = asBooleanLiteral(operCall.getArgument().get(0));
		assertLocation(literal,
			exprString.indexOf("((true)) )"),
			exprString.length() - 4);
	}
	
	/**
	 * Tests the retention of location information for type names.
	 */
	public void test_typePositions() {
		final String exprString =
			"let isApple : Boolean = self.oclIsKindOf(Apple) in " +
			"isApple implies Apple.allInstances()->includes(self.oclAsType(Apple))";
		OCLExpression<Classifier> constraint = createQuery(fruit, exprString);
		
		LetExp<Classifier, Parameter> letExp = asLet(constraint);
		assertLocation(letExp, 0, exprString.length());
		
		Variable<Classifier, Parameter> vdecl = letExp.getVariable();
		assertTypeLocation(vdecl,
			exprString.indexOf("Boolean"),
			exprString.indexOf(" = "));
		
		TypeExp<Classifier> typeExp = asType(
			asOperationCall(vdecl.getInitExpression()).getArgument().get(0));
		assertLocation(typeExp,
			exprString.indexOf("Apple) in "),
			exprString.indexOf(") in "));
		
		OperationCallExp<Classifier, Operation> operCall = asOperationCall(
			asOperationCall(letExp.getIn()).getArgument().get(0));
		
		operCall = asOperationCall(operCall.getSource());
		typeExp = asType(operCall.getSource());
		assertLocation(typeExp,
			exprString.indexOf("Apple.all"),
			exprString.indexOf(".all"));
	}
	
	/**
	 * Tests the retention of location information for collection element types.
	 */
	public void test_elementTypePositions() {
		final String exprString =
			"let allApples : Set(Apple) = Apple.allInstances() in " +
			"allApples->includes(self)";
		OCLExpression<Classifier> constraint = createQuery(apple, exprString);
		
		LetExp<Classifier, Parameter> letExp = asLet(constraint);
		assertLocation(letExp, 0, exprString.length());
		
		Variable<Classifier, Parameter> vdecl = letExp.getVariable();
		assertTypeLocation(vdecl,
			exprString.indexOf("Set("),
			exprString.indexOf(" = "));
		
		CollectionType collType = (CollectionType) vdecl.getType();
		assertTypeLocation(collType,
			exprString.indexOf("Apple) = "),
			exprString.indexOf(") = "));
	}

	/**
	 * Tests the retention of location information for property names referenced
	 * by operation call expressions.
	 */
	public void test_propertyPositions_operationCall() {
		final String exprString =
			"Apple.allInstances()->includes(self)";
		OCLExpression<Classifier> constraint = createQuery(apple, exprString);

		// collection operation (arrow)
		OperationCallExp<Classifier, Operation> includesExp = asOperationCall(constraint);
		assertPropertyLocation(includesExp,
			exprString.indexOf("includes"),
			exprString.indexOf("(self)"));

		// element operation (dot)
		FeatureCallExp<Classifier> mpcExp = asFeatureCall(
			includesExp.getSource());
		assertPropertyLocation(mpcExp,
			exprString.indexOf("allInst"),
			exprString.indexOf("()"));


	}
	
	/**
	 * Tests the retention of location information for property names referenced
	 * by attribute call expressions.
	 */
	public void test_propertyPositions_attributeCall() {
		// throw in spaces for fun
		final String exprString =
			"not ripen(self. color )";
		OCLExpression<Classifier> constraint = createQuery(apple, exprString);

		OperationCallExp<Classifier, Operation> notExp = asOperationCall(constraint);
		OperationCallExp<Classifier, Operation> ripenExp = asOperationCall(notExp.getSource());

		FeatureCallExp<Classifier> mpcExp = asFeatureCall(
			ripenExp.getArgument().get(0));
		assertPropertyLocation(mpcExp,
			exprString.indexOf("color "),
			exprString.indexOf(" )"));
	}

	/**
	 * Tests the retention of location information for property names referenced
	 * by association end call expressions.
	 */
	public void test_propertyPositions_associationEndCall() {
		final String exprString =
			"self.stem->notEmpty()";
		OCLExpression<Classifier> constraint = createQuery(apple, exprString);
		
		OperationCallExp<Classifier, Operation> notEmptyExp = asOperationCall(constraint);
		
		// the OCL is implicitly Set{self.stem}->notEmpty()
		CollectionLiteralExp<Classifier> setExp = asCollectionLiteral(notEmptyExp.getSource());
		
		FeatureCallExp<Classifier> mpcExp = asFeatureCall(
			((CollectionItem<Classifier>) setExp.getPart().get(0)).getItem());
		assertPropertyLocation(mpcExp,
			exprString.indexOf("stem"),
			exprString.indexOf("->"));
	}

	/**
	 * Tests the retention of location information for property names referenced
	 * by implied collect expressions.
	 */
	public void test_propertyPositions_implicitCollect() {
		final String exprString =
			"orderedSet.color->asSet()->size() = 1";
		OCLExpression<Classifier> constraint = createQuery(
			(Class) fruitPackage.getOwnedType("FruitUtil"),
			exprString);
		
		OperationCallExp<Classifier, Operation> eqExp = asOperationCall(constraint);
		OperationCallExp<Classifier, Operation> sizeExp = asOperationCall(eqExp.getSource());
		OperationCallExp<Classifier, Operation> asSetExp = asOperationCall(sizeExp.getSource());
		
		// implied collect expression
		IteratorExp<Classifier, Parameter> iterExp = asIterator(asSetExp.getSource());

		FeatureCallExp<Classifier> mpcExp = asFeatureCall(iterExp.getBody());
		assertPropertyLocation(mpcExp,
			exprString.indexOf("color"),
			exprString.indexOf("->asSet"));
	}
	
	/**
	 * Tests the retention of location information for EReference names referenced
	 * by implied collect expressions.  This test was added to validate a problem found
	 * in code review.
	 */
	public void test_referencePositions_implicitCollect() {
		final String exprString =
			"Apple.allInstances().stem->asSet()->size() > 1";
		OCLExpression<Classifier> constraint = createQuery(apple, exprString);

		OperationCallExp<Classifier, Operation> eqExp = asOperationCall(constraint);
		OperationCallExp<Classifier, Operation> sizeExp = asOperationCall(eqExp.getSource());
		OperationCallExp<Classifier, Operation> asSetExp = asOperationCall(sizeExp.getSource());

		// implied collect expression
		IteratorExp<Classifier, Parameter> iterExp = asIterator(asSetExp.getSource());

		FeatureCallExp<Classifier> mpcExp = asFeatureCall(iterExp.getBody());
		assertPropertyLocation(mpcExp,
			exprString.indexOf("stem"),
			exprString.indexOf("->asSet"));
	}
	
	/**
	 * Tests the retention of location information for the components of a
	 * message expression.
	 */
	public void test_messageExp_positions() {
		final String exprString =
			"self^ripen(? : Color)";
		OCLExpression<Classifier> constraint = createQuery(fruit, exprString);
		
		MessageExp<Classifier, ?, ?> msgExp = asMessage(constraint);
		assertLocation(msgExp, 0, exprString.length());
		assertPropertyLocation(msgExp,
				exprString.indexOf("ripen"),
				exprString.indexOf("("));
		
		VariableExp<Classifier, Parameter> var = asVariable(msgExp.getTarget());
		assertLocation(var,	0, exprString.indexOf("^"));
		
		UnspecifiedValueExp<Classifier> unspecExp = asUnspecifiedValue(
			msgExp.getArgument().get(0));
		assertLocation(unspecExp,
			exprString.indexOf("?"),
			exprString.indexOf(")"));
		assertTypeLocation(unspecExp,
			exprString.indexOf("Color"),
			exprString.indexOf(")"));
	}
	
	/**
	 * Tests the retention of location information for state expressions.
	 */
	public void test_stateExp_positions() {
		final String exprString =
			"self.oclIsInState(Bad::Rotten)";
		OCLExpression<Classifier> constraint = createQuery(apple, exprString);
		
		OperationCallExp<Classifier, Operation> callExp = asOperationCall(constraint);
		assertLocation(callExp, 0, exprString.length());
		
		
		StateExp<Classifier, ?> state = asState(callExp.getArgument().get(0));
		assertLocation(state,
				exprString.indexOf("Bad"),
				exprString.indexOf(")"));
	}
	
	//
	// Framework methods
	//
	
	@Override
	protected OCLExpression<Classifier> createQuery(Class context, String text) {
		OCLExpression<Classifier> result = super.createQuery(context, text);
		
		assertAllPositionsSet(result);
		
		return result;
	}
	
	protected OCLExpression<Classifier> createQuery(
			EnvironmentFactory<Package, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint, Class, EObject> envFactory,
			Class context, String text) {
		
		OCLExpression<Classifier> result = super.createQuery(
				envFactory, context, text);
		
		assertAllPositionsSet(result);
		
		return result;
	}
	
	protected OCLExpression<Classifier> createInvariant(Class context, String text) {
		OCLExpression<Classifier> result = super.createInvariant(context, text);
		
		assertAllPositionsSet(result);
		
		return result;
	}
	
	@Override
    protected OCLExpression<Classifier> createPrecondition(Operation context, String text) {
		OCLExpression<Classifier> result = super.createPrecondition(context, text);
		
		assertAllPositionsSet(result);
		
		return result;
	}
	
	@Override
    protected OCLExpression<Classifier> createPostcondition(Operation context, String text) {
		OCLExpression<Classifier> result = super.createPostcondition(context, text);
		
		assertAllPositionsSet(result);
		
		return result;
	}
	
	@Override
    protected OCLExpression<Classifier> createBodyCondition(Operation context, String text) {
		OCLExpression<Classifier> result = super.createBodyCondition(context, text);
		
		assertAllPositionsSet(result);
		
		return result;
	}
	
	static IfExp<Classifier> asIf(Object obj) {
		return cast(obj, IfExp.class);
	}
	
	static EnumLiteralExp<Classifier, EnumerationLiteral> asEnumLiteral(Object obj) {
		return cast(obj, EnumLiteralExp.class);
	}
	
	static VariableExp<Classifier, Parameter> asVariable(Object obj) {
		return cast(obj, VariableExp.class);
	}
	
	static LetExp<Classifier, Parameter> asLet(Object obj) {
		return cast(obj, LetExp.class);
	}
	
	static LoopExp<Classifier, Parameter> asLoop(Object obj) {
		return cast(obj, LoopExp.class);
	}
	
	static IteratorExp<Classifier, Parameter> asIterator(Object obj) {
		return cast(obj, IteratorExp.class);
	}
	
	static PropertyCallExp<Classifier, Property> asPropertyCall(Object obj) {
		return cast(obj, PropertyCallExp.class);
	}

	static FeatureCallExp<Classifier> asFeatureCall(Object obj) {
		return cast(obj, FeatureCallExp.class);
	}

	static AssociationClassCallExp<Classifier, Property> asAssociationClassCall(Object obj) {
		return cast(obj, AssociationClassCallExp.class);
	}
	
	static OperationCallExp<Classifier, Operation> asOperationCall(Object obj) {
		return cast(obj, OperationCallExp.class);
	}
	
	static BooleanLiteralExp<Classifier> asBooleanLiteral(Object obj) {
		return cast(obj, BooleanLiteralExp.class);
	}
	
	static StringLiteralExp<Classifier> asStringLiteral(Object obj) {
		return cast(obj, StringLiteralExp.class);
	}
	
	static CollectionLiteralExp<Classifier> asCollectionLiteral(Object obj) {
		return cast(obj, CollectionLiteralExp.class);
	}
	
	static CollectionItem<Classifier> asCollectionItem(Object obj) {
		return cast(obj, CollectionItem.class);
	}
	
	static Variable<Classifier, Parameter> asVariableDeclaration(Object obj) {
		return cast(obj, Variable.class);
	}
	
	static StateExp<Classifier, ?> asState(Object obj) {
		return cast(obj, StateExp.class);
	}
	
	static TypeExp<Classifier> asType(Object obj) {
		return cast(obj, TypeExp.class);
	}
	
	static MessageExp<Classifier, ?, ?> asMessage(Object obj) {
		return cast(obj, MessageExp.class);
	}
	
	static UnspecifiedValueExp<Classifier> asUnspecifiedValue(Object obj) {
		return cast(obj, UnspecifiedValueExp.class);
	}
	
	@SuppressWarnings("unchecked")
	static <T> T cast(Object obj, java.lang.Class<?> expectedClass) {
		assertTrue("Expected type: " + expectedClass + ", got: " + obj.getClass(),
			expectedClass.isInstance(obj));
		
		return (T) obj;
	}
	
	static void assertAllPositionsSet(OCLExpression<Classifier> expr) {
		assertNotNull(expr);
		expr.accept(LocationVerifier.INSTANCE);
	}
	
	static void assertLocation(ASTNode node, int start, int end) {
		assertEquals("Wrong start position", start, node.getStartPosition());
		assertEquals("Wrong end position", end, node.getEndPosition());
	}
	
	static void assertTypeLocation(TypedASTNode node, int start, int end) {
		assertEquals("Wrong type start position", start, node.getTypeStartPosition());
		assertEquals("Wrong type end position", end, node.getTypeEndPosition());
	}

	static void assertPropertyLocation(CallingASTNode node, int start, int end) {
		assertEquals("Wrong property start position", start, node.getPropertyStartPosition());
		assertEquals("Wrong property end position", end, node.getPropertyEndPosition());
	}
	
	/**
	 * Visitor implementation that checks all AST nodes that they have their
	 * start and end positions set.
	 *
	 * @author Christian W. Damus (cdamus)
	 */
	private static class LocationVerifier
			extends AbstractVisitor<Object, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint> {
		static LocationVerifier INSTANCE = new LocationVerifier();

		@SuppressWarnings("unchecked")
		private boolean isExempt(OCLExpression<Classifier> expr) {
			if (expr instanceof VariableExp<?, ?>) {
				return isImplicit(((VariableExp<Classifier, Parameter>) expr).getReferredVariable());
			}

			return (expr instanceof CollectionLiteralExp<?>)
				|| (expr instanceof CollectionLiteralPart<?>);
		}

		private boolean isImplicit(Variable<Classifier, Parameter> vdecl) {
			// ignore "self" because it may be implicit.
			// Anything starting with "temp" is an implicit variable declaration
			String name = vdecl.getName();

			return (name == null)
				|| name.equals("self")
				|| name.startsWith("temp");
		}

		private void assertPositions(OCLExpression<Classifier> expr) {
			if (!isExempt(expr)) {
				assertFalse("Start not set: " + expr, expr.getStartPosition() < 0);
				assertFalse("End not set: " + expr, expr.getEndPosition() < 0);
				assertTrue("End not after start: " + expr, expr.getEndPosition() > expr.getStartPosition());
			}
		}

		private void assertPositions(Variable<Classifier, Parameter> vdecl) {
			if (!isImplicit(vdecl)) {
				assertFalse("Start not set: " + vdecl, vdecl.getStartPosition() < 0);
				assertFalse("End not set: " + vdecl, vdecl.getEndPosition() < 0);
				assertTrue("End not after start: " + vdecl,
					vdecl.getEndPosition() > vdecl.getStartPosition());
			}
		}
		
		private void assertPositions(TupleLiteralPart<Classifier, Property> tp) {
			assertFalse("Start not set: " + tp, tp.getStartPosition() < 0);
			assertFalse("End not set: " + tp, tp.getEndPosition() < 0);
			assertTrue("End not after start: " + tp, tp.getEndPosition() > tp.getStartPosition());
		}

		@Override
        public Object visitOperationCallExp(OperationCallExp<Classifier, Operation> oc) {
			assertPositions(oc);

			return super.visitOperationCallExp(oc);
		}

		@Override
        public Object visitVariableExp(VariableExp<Classifier, Parameter> v) {
			assertPositions(v);
			
			return super.visitVariableExp(v);
		}

		@Override
        public Object visitPropertyCallExp(PropertyCallExp<Classifier, Property> pc) {
			assertPositions(pc);
			
			return super.visitPropertyCallExp(pc);
		}

		@Override
        public Object visitAssociationClassCallExp(AssociationClassCallExp<Classifier, Property> ac) {
			assertPositions(ac);
			
			return super.visitAssociationClassCallExp(ac);
		}

		@Override
        public Object visitVariable(Variable<Classifier, Parameter> vd) {
			// the 'self' variable is often implicit, in which case it is not
			//    in the input at all, so don't verify it
			if (!"self".equals(vd.getName())) {
				assertPositions(vd);
			}
			
			return super.visitVariable(vd);
		}

		@Override
        public Object visitIfExp(IfExp<Classifier> i) {
			assertPositions(i);
			
			return super.visitIfExp(i);
		}

		@Override
        public Object visitTypeExp(TypeExp<Classifier> t) {
			assertPositions(t);
			return null;
		}

		@Override
        public Object visitUnspecifiedValueExp(UnspecifiedValueExp<Classifier> uv) {
			assertPositions(uv);
			return null;
		}
		
		@Override
        public Object visitStateExp(StateExp<Classifier, State> s) {
			assertPositions(s);
			return null;
		}
		
		@Override
        public Object visitMessageExp(MessageExp<Classifier, CallOperationAction, SendSignalAction> m) {
			assertPositions(m);
			
			return super.visitMessageExp(m);
		}

		@Override
        public Object visitIntegerLiteralExp(IntegerLiteralExp<Classifier> il) {
			assertPositions(il);
			return null;
		}

		@Override
        public Object visitRealLiteralExp(RealLiteralExp<Classifier> rl) {
			assertPositions(rl);
			return null;
		}

		@Override
        public Object visitStringLiteralExp(StringLiteralExp<Classifier> sl) {
			assertPositions(sl);
			return null;
		}

		@Override
        public Object visitBooleanLiteralExp(BooleanLiteralExp<Classifier> bl) {
			assertPositions(bl);
			return null;
		}

		@Override
        public Object visitTupleLiteralExp(TupleLiteralExp<Classifier, Property> tl) {
			assertPositions(tl);
			
			return super.visitTupleLiteralExp(tl);
		}
		
		@Override
        public Object visitTupleLiteralPart(TupleLiteralPart<Classifier, Property> tp) {
			assertPositions(tp);
			
			return super.visitTupleLiteralPart(tp);
		}

		@Override
        public Object visitLetExp(LetExp<Classifier, Parameter> l) {
			assertPositions(l);
			
			return super.visitLetExp(l);
		}

		@Override
        public Object visitEnumLiteralExp(EnumLiteralExp<Classifier, EnumerationLiteral> el) {
			assertPositions(el);
			return null;
		}

		@Override
        public Object visitCollectionLiteralExp(CollectionLiteralExp<Classifier> cl) {
			assertPositions(cl);
			
			return super.visitCollectionLiteralExp(cl);
		}

		@Override
        public Object visitIteratorExp(IteratorExp<Classifier, Parameter> ie) {
			assertPositions(ie);
			
			return super.visitIteratorExp(ie);
		}

		@Override
        public Object visitIterateExp(IterateExp<Classifier, Parameter> ie) {
			assertPositions(ie);
			
			return super.visitIterateExp(ie);
		}

		@Override
        public Object visitInvalidLiteralExp(InvalidLiteralExp<Classifier> il) {
			assertPositions(il);
			return null;
		}

		@Override
        public Object visitNullLiteralExp(NullLiteralExp<Classifier> il) {
			assertPositions(il);
			return null;
		}
	}
}

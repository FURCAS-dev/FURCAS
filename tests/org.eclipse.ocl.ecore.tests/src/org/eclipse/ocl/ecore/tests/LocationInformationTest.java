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
 * $Id: LocationInformationTest.java,v 1.9 2009/12/18 06:34:08 ewillink Exp $
 */

package org.eclipse.ocl.ecore.tests;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.EnvironmentFactory;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
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
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.lpg.StringProblemHandler;
import org.eclipse.ocl.parser.OCLAnalyzer;
import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.ocl.utilities.AbstractVisitor;
import org.eclipse.ocl.utilities.CallingASTNode;
import org.eclipse.ocl.utilities.TypedASTNode;

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
		OCLExpression<EClassifier> constraint = createQuery(apple, exprString);
		
		OperationCallExp<EClassifier, EOperation> impliesExp = asOperationCall(constraint);
		assertLocation(impliesExp, 0, exprString.length());
		
		BooleanLiteralExp<EClassifier> bl = asBooleanLiteral(impliesExp.getSource());
		assertLocation(bl, 0, "true".length());
		
		int selfPos = exprString.indexOf("self");
		
		OperationCallExp<EClassifier, EOperation> notEqualsExp = asOperationCall(
			impliesExp.getArgument().get(0));
		assertLocation(notEqualsExp, selfPos, exprString.length());
		
		PropertyCallExp<EClassifier, EStructuralFeature> attrCall = asPropertyCall(notEqualsExp.getSource());
		assertLocation(attrCall, selfPos, selfPos + "self.color".length());
		
		VariableExp<EClassifier, EParameter> selfVar = asVariable(attrCall.getSource());
		assertLocation(selfVar, selfPos, selfPos + "self".length());
		
		EnumLiteralExp<EClassifier, EEnumLiteral> enumLiteral = asEnumLiteral(notEqualsExp.getArgument().get(0));
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
		OCLExpression<EClassifier> constraint = createQuery(apple, exprString);
		
		IfExp<EClassifier> ifExp = asIf(constraint);
		assertLocation(ifExp, 0, exprString.length());
		
		int falsePos = exprString.indexOf("false");
		
		BooleanLiteralExp<EClassifier> bl = asBooleanLiteral(ifExp.getCondition());
		assertLocation(bl, falsePos, falsePos + "false".length());
		
		int spyPos = exprString.indexOf("'Spy'");
		
		StringLiteralExp<EClassifier> stringLiteral = asStringLiteral(ifExp.getThenExpression());
		assertLocation(stringLiteral, spyPos, spyPos + "'Spy'".length());
		
		IteratorExp<EClassifier, EParameter> anyIterator = asIterator(ifExp.getElseExpression());
		assertLocation(anyIterator,
			exprString.indexOf("Set"),
			exprString.indexOf("endif") - 1);
		
		Variable<EClassifier, EParameter> vdecl = asVariableDeclaration(anyIterator.getIterator().get(0));
		assertLocation(vdecl,
			exprString.indexOf("i :"),
			exprString.indexOf("|") - 1);
		
		OCLExpression<EClassifier> anyBody = anyIterator.getBody();
		assertLocation(anyBody,
			exprString.indexOf("i <>"),
			exprString.indexOf(")"));
		
		CollectionLiteralExp<EClassifier> collLiteral = asCollectionLiteral(anyIterator.getSource());
		assertLocation(collLiteral,
			exprString.indexOf("Set"),
			exprString.indexOf("->"));
		
		int grannyPos = exprString.indexOf("'GrannySmith'");
		
		// get the second item
		CollectionItem<EClassifier> item = asCollectionItem(collLiteral.getPart().get(1));
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
		OCLExpression<EClassifier> constraint = createPostcondition(fruit_ripen, exprString);
		
		LetExp<EClassifier, EParameter> letExp = asLet(constraint);
		assertLocation(letExp, 0, exprString.length());
		
		Variable<EClassifier, EParameter> vdecl = letExp.getVariable();
		assertLocation(vdecl,
			exprString.indexOf("oldColor :"),
			exprString.indexOf(" in "));
		
		PropertyCallExp<EClassifier, EStructuralFeature> attrExp =
			asPropertyCall(vdecl.getInitExpression());
		assertLocation(attrExp,
			exprString.indexOf("self"),
			exprString.indexOf(" in "));
		
		OperationCallExp<EClassifier, EOperation> notEqualExp = asOperationCall(
				letExp.getIn());
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
		OCLExpression<EClassifier> constraint = createQuery(fruit, exprString);
		
		OperationCallExp<EClassifier, EOperation> operCall = asOperationCall(constraint);
		assertLocation(operCall, 0, exprString.length());
		
		BooleanLiteralExp<EClassifier> literal = asBooleanLiteral(operCall.getSource());
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
		OCLExpression<EClassifier> constraint = createQuery(fruit, exprString);
		
		LetExp<EClassifier, EParameter> letExp = asLet(constraint);
		assertLocation(letExp, 0, exprString.length());
		
		Variable<EClassifier, EParameter> vdecl = letExp.getVariable();
		assertTypeLocation(vdecl,
			exprString.indexOf("Boolean"),
			exprString.indexOf(" = "));
		
		TypeExp<EClassifier> typeExp = asType(
			asOperationCall(vdecl.getInitExpression()).getArgument().get(0));
		assertLocation(typeExp,
			exprString.indexOf("Apple) in "),
			exprString.indexOf(") in "));
		
		OperationCallExp<EClassifier, EOperation> operCall = asOperationCall(
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
		OCLExpression<EClassifier> constraint = createQuery(apple, exprString);
		
		LetExp<EClassifier, EParameter> letExp = asLet(constraint);
		assertLocation(letExp, 0, exprString.length());
		
		Variable<EClassifier, EParameter> vdecl = letExp.getVariable();
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
		OCLExpression<EClassifier> constraint = createQuery(apple, exprString);

		// collection operation (arrow)
		OperationCallExp<EClassifier, EOperation> includesExp = asOperationCall(constraint);
		assertPropertyLocation(includesExp,
			exprString.indexOf("includes"),
			exprString.indexOf("(self)"));

		// element operation (dot)
		FeatureCallExp<EClassifier> mpcExp = asFeatureCall(
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
		OCLExpression<EClassifier> constraint = createQuery(apple, exprString);

		OperationCallExp<EClassifier, EOperation> notExp = asOperationCall(constraint);
		OperationCallExp<EClassifier, EOperation> ripenExp = asOperationCall(notExp.getSource());

		FeatureCallExp<EClassifier> mpcExp = asFeatureCall(
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
		OCLExpression<EClassifier> constraint = createQuery(apple, exprString);
		
		OperationCallExp<EClassifier, EOperation> notEmptyExp = asOperationCall(constraint);
		
		// the OCL is implicitly Set{self.stem}->notEmpty()
		CollectionLiteralExp<EClassifier> setExp = asCollectionLiteral(notEmptyExp.getSource());
		
		FeatureCallExp<EClassifier> mpcExp = asFeatureCall(
			((CollectionItem<EClassifier>) setExp.getPart().get(0)).getItem());
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
		OCLExpression<EClassifier> constraint = createQuery(
			(EClass) fruitPackage.getEClassifier("FruitUtil"),
			exprString);
		
		OperationCallExp<EClassifier, EOperation> eqExp = asOperationCall(constraint);
		OperationCallExp<EClassifier, EOperation> sizeExp = asOperationCall(eqExp.getSource());
		OperationCallExp<EClassifier, EOperation> asSetExp = asOperationCall(sizeExp.getSource());
		
		// implied collect expression
		IteratorExp<EClassifier, EParameter> iterExp = asIterator(asSetExp.getSource());

		FeatureCallExp<EClassifier> mpcExp = asFeatureCall(iterExp.getBody());
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
		OCLExpression<EClassifier> constraint = createQuery(apple, exprString);

		OperationCallExp<EClassifier, EOperation> eqExp = asOperationCall(constraint);
		OperationCallExp<EClassifier, EOperation> sizeExp = asOperationCall(eqExp.getSource());
		OperationCallExp<EClassifier, EOperation> asSetExp = asOperationCall(sizeExp.getSource());

		// implied collect expression
		IteratorExp<EClassifier, EParameter> iterExp = asIterator(asSetExp.getSource());

		FeatureCallExp<EClassifier> mpcExp = asFeatureCall(iterExp.getBody());
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
		OCLExpression<EClassifier> constraint = createQuery(fruit, exprString);
		
		MessageExp<EClassifier, ?, ?> msgExp = asMessage(constraint);
		assertLocation(msgExp, 0, exprString.length());
		assertPropertyLocation(msgExp,
				exprString.indexOf("ripen"),
				exprString.indexOf("("));
		
		VariableExp<EClassifier, EParameter> var = asVariable(msgExp.getTarget());
		assertLocation(var,	0, exprString.indexOf("^"));
		
		UnspecifiedValueExp<EClassifier> unspecExp = asUnspecifiedValue(
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
		OCLExpression<EClassifier> constraint = createQuery(
				new StatesTest.StatefulFruitEnvironmentFactory(this), apple, exprString);
		
		OperationCallExp<EClassifier, EOperation> callExp = asOperationCall(constraint);
		assertLocation(callExp, 0, exprString.length());
		
		
		StateExp<EClassifier, ?> state = asState(callExp.getArgument().get(0));
		assertLocation(state,
				exprString.indexOf("Bad"),
				exprString.indexOf(")"));
	}

	public void test_atPrePosition() {
		checkDocumentWithAnalyzeFailureAt(
			"package ecore context EPackage::getEClassifier(name : String) : post: name = name@pre endpackage",
			OCLMessages.IllegalAtPre_ERROR_,
			"@pre");
    }

	/**
	 * Check that the OCL document defined by oclText generates an analyzeFailure for its subText.
	 * @param oclText
	 * @param failure
	 * @param subText
	 */
	protected void checkDocumentWithAnalyzeFailureAt(final String oclText, final String failure, final String subText) {
		OCLAnalyzer<?, ?, ?, ?, ?, ?, ?, ?, ?, Constraint, ?, ?> analyzer = ocl.createAnalyzer(oclText);
		StringProblemHandler problemHandler = new StringProblemHandler(analyzer.getAbstractParser())
		{
			@Override
			public void handleProblem(Severity problemSeverity, Phase processingPhase, String problemMessage,
					String processingContext, int startOffset, int endOffset) {
				int expectedStart = oclText.indexOf(subText);
				int expectedEnd = expectedStart + subText.length() - 1;
				assertEquals(failure, problemMessage);
				assertEquals(expectedStart, startOffset);
				assertEquals(expectedEnd, endOffset);
				super.handleProblem(problemSeverity, processingPhase, problemMessage,
					processingContext, startOffset, endOffset);
			}
		};
		analyzer.getEnvironment().setProblemHandler(problemHandler);
		try {
			List<Constraint> result = new java.util.ArrayList<Constraint>();
			analyzer.parseOCLDocument(result);
            assertEquals(1, problemHandler.getProblemCount());
        } catch (Exception e) {
            fail(e.getLocalizedMessage());
        }
	}
	
	//
	// Framework methods
	//
	
	@Override
    protected OCLExpression<EClassifier> createQuery(EClass context, String text) {
		OCLExpression<EClassifier> result = super.createQuery(context, text);
		
		assertAllPositionsSet(result);
		
		return result;
	}
	
	@Override
    protected OCLExpression<EClassifier> createQuery(
			EnvironmentFactory<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> envFactory,
			EClassifier context, String text) {
		
		OCLExpression<EClassifier> result = super.createQuery(
				envFactory, context, text);
		
		assertAllPositionsSet(result);
		
		return result;
	}
	
	@Override
    protected OCLExpression<EClassifier> createInvariant(EClassifier context, String text) {
		OCLExpression<EClassifier> result = super.createInvariant(context, text);
		
		assertAllPositionsSet(result);
		
		return result;
	}
	
	@Override
    protected OCLExpression<EClassifier> createPrecondition(EOperation context, String text) {
		OCLExpression<EClassifier> result = super.createPrecondition(context, text);
		
		assertAllPositionsSet(result);
		
		return result;
	}
	
	@Override
    protected OCLExpression<EClassifier> createPostcondition(EOperation context, String text) {
		OCLExpression<EClassifier> result = super.createPostcondition(context, text);
		
		assertAllPositionsSet(result);
		
		return result;
	}
	
	@Override
    protected OCLExpression<EClassifier> createBodyCondition(EOperation context, String text) {
		OCLExpression<EClassifier> result = super.createBodyCondition(context, text);
		
		assertAllPositionsSet(result);
		
		return result;
	}
	
	static IfExp<EClassifier> asIf(Object obj) {
		return cast(obj, IfExp.class);
	}
	
	static EnumLiteralExp<EClassifier, EEnumLiteral> asEnumLiteral(Object obj) {
		return cast(obj, EnumLiteralExp.class);
	}
	
	static VariableExp<EClassifier, EParameter> asVariable(Object obj) {
		return cast(obj, VariableExp.class);
	}
	
	static LetExp<EClassifier, EParameter> asLet(Object obj) {
		return cast(obj, LetExp.class);
	}
	
	static LoopExp<EClassifier, EParameter> asLoop(Object obj) {
		return cast(obj, LoopExp.class);
	}
	
	static IteratorExp<EClassifier, EParameter> asIterator(Object obj) {
		return cast(obj, IteratorExp.class);
	}
	
	static PropertyCallExp<EClassifier, EStructuralFeature> asPropertyCall(Object obj) {
		return cast(obj, PropertyCallExp.class);
	}

	static FeatureCallExp<EClassifier> asFeatureCall(Object obj) {
		return cast(obj, FeatureCallExp.class);
	}

	static AssociationClassCallExp<EClassifier, EStructuralFeature> asAssociationClassCall(Object obj) {
		return cast(obj, AssociationClassCallExp.class);
	}
	
	static OperationCallExp<EClassifier, EOperation> asOperationCall(Object obj) {
		return cast(obj, OperationCallExp.class);
	}
	
	static BooleanLiteralExp<EClassifier> asBooleanLiteral(Object obj) {
		return cast(obj, BooleanLiteralExp.class);
	}
	
	static StringLiteralExp<EClassifier> asStringLiteral(Object obj) {
		return cast(obj, StringLiteralExp.class);
	}
	
	static CollectionLiteralExp<EClassifier> asCollectionLiteral(Object obj) {
		return cast(obj, CollectionLiteralExp.class);
	}
	
	static CollectionItem<EClassifier> asCollectionItem(Object obj) {
		return cast(obj, CollectionItem.class);
	}
	
	static Variable<EClassifier, EParameter> asVariableDeclaration(Object obj) {
		return cast(obj, Variable.class);
	}
	
	static StateExp<EClassifier, ?> asState(Object obj) {
		return cast(obj, StateExp.class);
	}
	
	static TypeExp<EClassifier> asType(Object obj) {
		return cast(obj, TypeExp.class);
	}
	
	static MessageExp<EClassifier, ?, ?> asMessage(Object obj) {
		return cast(obj, MessageExp.class);
	}
	
	static UnspecifiedValueExp<EClassifier> asUnspecifiedValue(Object obj) {
		return cast(obj, UnspecifiedValueExp.class);
	}
	
	@SuppressWarnings("unchecked")
	static <T> T cast(Object obj, Class<?> expectedClass) {
		assertTrue("Expected type: " + expectedClass + ", got: " + obj.getClass(),
			expectedClass.isInstance(obj));
		
		return (T) obj;
	}
	
	static void assertAllPositionsSet(OCLExpression<EClassifier> expr) {
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
			extends AbstractVisitor<Object, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> {
		static LocationVerifier INSTANCE = new LocationVerifier();

		@SuppressWarnings("unchecked")
		private boolean isExempt(OCLExpression<EClassifier> expr) {
			if (expr instanceof VariableExp<?, ?>) {
				return isImplicit(((VariableExp<EClassifier, EParameter>) expr).getReferredVariable());
			}

			return (expr instanceof CollectionLiteralExp<?>)
				|| (expr instanceof CollectionLiteralPart<?>);
		}

		private boolean isImplicit(Variable<EClassifier, EParameter> vdecl) {
			// ignore "self" because it may be implicit.
			// Anything starting with "temp" is an implicit variable declaration
			String name = vdecl.getName();

			return (name == null)
				|| name.equals("self")
				|| name.startsWith("temp");
		}

		private void assertPositions(OCLExpression<EClassifier> expr) {
			if (!isExempt(expr)) {
				assertFalse("Start not set: " + expr, expr.getStartPosition() < 0);
				assertFalse("End not set: " + expr, expr.getEndPosition() < 0);
				assertTrue("End not after start: " + expr, expr.getEndPosition() > expr.getStartPosition());
			}
		}

		private void assertPositions(Variable<EClassifier, EParameter> vdecl) {
			if (!isImplicit(vdecl)) {
				assertFalse("Start not set: " + vdecl, vdecl.getStartPosition() < 0);
				assertFalse("End not set: " + vdecl, vdecl.getEndPosition() < 0);
				assertTrue("End not after start: " + vdecl,
					vdecl.getEndPosition() > vdecl.getStartPosition());
			}
		}
		
		private void assertPositions(TupleLiteralPart<EClassifier, EStructuralFeature> tp) {
			assertFalse("Start not set: " + tp, tp.getStartPosition() < 0);
			assertFalse("End not set: " + tp, tp.getEndPosition() < 0);
			assertTrue("End not after start: " + tp, tp.getEndPosition() > tp.getStartPosition());
		}

		@Override
        public Object visitOperationCallExp(OperationCallExp<EClassifier, EOperation> oc) {
			assertPositions(oc);

			return super.visitOperationCallExp(oc);
		}

		@Override
        public Object visitVariableExp(VariableExp<EClassifier, EParameter> v) {
			assertPositions(v);
			
			return super.visitVariableExp(v);
		}

		@Override
        public Object visitPropertyCallExp(PropertyCallExp<EClassifier, EStructuralFeature> pc) {
			assertPositions(pc);
			
			return super.visitPropertyCallExp(pc);
		}

		@Override
        public Object visitAssociationClassCallExp(AssociationClassCallExp<EClassifier, EStructuralFeature> ac) {
			assertPositions(ac);
			
			return super.visitAssociationClassCallExp(ac);
		}

		@Override
        public Object visitVariable(Variable<EClassifier, EParameter> vd) {
			// the 'self' variable is often implicit, in which case it is not
			//    in the input at all, so don't verify it
			if (!"self".equals(vd.getName())) {
				assertPositions(vd);
			}
			
			return super.visitVariable(vd);
		}

		@Override
        public Object visitIfExp(IfExp<EClassifier> i) {
			assertPositions(i);
			
			return super.visitIfExp(i);
		}

		@Override
        public Object visitTypeExp(TypeExp<EClassifier> t) {
			assertPositions(t);
			return null;
		}

		@Override
        public Object visitUnspecifiedValueExp(UnspecifiedValueExp<EClassifier> uv) {
			assertPositions(uv);
			return null;
		}
		
		@Override
        public Object visitStateExp(StateExp<EClassifier, EObject> s) {
			assertPositions(s);
			return null;
		}
		
		@Override
        public Object visitMessageExp(MessageExp<EClassifier, CallOperationAction, SendSignalAction> m) {
			assertPositions(m);
			
			return super.visitMessageExp(m);
		}

		@Override
        public Object visitIntegerLiteralExp(IntegerLiteralExp<EClassifier> il) {
			assertPositions(il);
			return null;
		}

		@Override
        public Object visitRealLiteralExp(RealLiteralExp<EClassifier> rl) {
			assertPositions(rl);
			return null;
		}

		@Override
        public Object visitStringLiteralExp(StringLiteralExp<EClassifier> sl) {
			assertPositions(sl);
			return null;
		}

		@Override
        public Object visitBooleanLiteralExp(BooleanLiteralExp<EClassifier> bl) {
			assertPositions(bl);
			return null;
		}

		@Override
        public Object visitTupleLiteralExp(TupleLiteralExp<EClassifier, EStructuralFeature> tl) {
			assertPositions(tl);
			
			return super.visitTupleLiteralExp(tl);
		}
		
		@Override
        public Object visitTupleLiteralPart(TupleLiteralPart<EClassifier, EStructuralFeature> tp) {
			assertPositions(tp);
			
			return super.visitTupleLiteralPart(tp);
		}

		@Override
        public Object visitLetExp(LetExp<EClassifier, EParameter> l) {
			assertPositions(l);
			
			return super.visitLetExp(l);
		}

		@Override
        public Object visitEnumLiteralExp(EnumLiteralExp<EClassifier, EEnumLiteral> el) {
			assertPositions(el);
			return null;
		}

		@Override
        public Object visitCollectionLiteralExp(CollectionLiteralExp<EClassifier> cl) {
			assertPositions(cl);
			
			return super.visitCollectionLiteralExp(cl);
		}

		@Override
        public Object visitIteratorExp(IteratorExp<EClassifier, EParameter> ie) {
			assertPositions(ie);
			
			return super.visitIteratorExp(ie);
		}

		@Override
        public Object visitIterateExp(IterateExp<EClassifier, EParameter> ie) {
			assertPositions(ie);
			
			return super.visitIterateExp(ie);
		}

		@Override
        public Object visitInvalidLiteralExp(InvalidLiteralExp<EClassifier> il) {
			assertPositions(il);
			return null;
		}

		@Override
        public Object visitNullLiteralExp(NullLiteralExp<EClassifier> il) {
			assertPositions(il);
			return null;
		}
	}
}

package com.sap.emf.ocl.hiddenopposites;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.EvaluationVisitorDecorator;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.AssociationClassCallExp;
import org.eclipse.ocl.expressions.BooleanLiteralExp;
import org.eclipse.ocl.expressions.CollectionItem;
import org.eclipse.ocl.expressions.CollectionLiteralExp;
import org.eclipse.ocl.expressions.CollectionRange;
import org.eclipse.ocl.expressions.EnumLiteralExp;
import org.eclipse.ocl.expressions.IfExp;
import org.eclipse.ocl.expressions.IntegerLiteralExp;
import org.eclipse.ocl.expressions.InvalidLiteralExp;
import org.eclipse.ocl.expressions.IterateExp;
import org.eclipse.ocl.expressions.IteratorExp;
import org.eclipse.ocl.expressions.LetExp;
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
import org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.expressions.UnspecifiedValueExp;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.VariableExp;
import org.eclipse.ocl.utilities.ExpressionInOCL;

import com.sap.emf.ocl.oclwithhiddenopposites.expressions.OppositePropertyCallExp;

/**
 * A decorator for evaluation visitors that is installed when evaluation tracing
 * is enabled, to trace interim evaluation results to the console.
 * 
 * @author Christian W. Damus (cdamus)
 * @author Axel Uhl
 */
public class TracingEvaluationVisitorWithHiddenOpposites
		extends
		EvaluationVisitorDecorator<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject>
		implements EvaluationVisitorWithHiddenOpposites {

	/**
	 * Initializes me with the visitor whose evaluation I trace to the console.
	 * 
	 * @param decorated
	 *            a real evaluation visitor
	 */
	public TracingEvaluationVisitorWithHiddenOpposites(
			EvaluationVisitorWithHiddenOpposites decorated) {
		super(decorated);
	}
	
	private boolean isInvalid(Object value) {
		return value == getEnvironment().getOCLStandardLibrary().getInvalid();
	}

	private Object trace(Object expression, Object value) {
		try {
			System.out.println("Evaluate: " + expression); //$NON-NLS-1$
			System.out.println("Result  : " + //$NON-NLS-1$
					(isInvalid(value) ? "OclInvalid" : String.valueOf(value))); //$NON-NLS-1$
		} catch (Exception e) {
			// tracing must not interfere with evaluation
		}

		return value;
	}

	@Override
	public Object visitAssociationClassCallExp(
			AssociationClassCallExp<EClassifier, EStructuralFeature> callExp) {
		return trace(callExp,
				getDelegate().visitAssociationClassCallExp(callExp));
	}

	@Override
	public Object visitBooleanLiteralExp(BooleanLiteralExp<EClassifier> literalExp) {
		return trace(literalExp,
				getDelegate().visitBooleanLiteralExp(literalExp));
	}

	@Override
	public Object visitCollectionItem(CollectionItem<EClassifier> item) {
		return trace(item, getDelegate().visitCollectionItem(item));
	}

	@Override
	public Object visitCollectionLiteralExp(CollectionLiteralExp<EClassifier> literalExp) {
		return trace(literalExp,
				getDelegate().visitCollectionLiteralExp(literalExp));
	}

	@Override
	public Object visitCollectionRange(CollectionRange<EClassifier> range) {
		return trace(range, getDelegate().visitCollectionRange(range));
	}

	@Override
	public Object visitConstraint(Constraint constraint) {
		return trace(constraint, getDelegate().visitConstraint(constraint));
	}

	@Override
	public Object visitEnumLiteralExp(EnumLiteralExp<EClassifier, EEnumLiteral> literalExp) {
		return trace(literalExp, getDelegate().visitEnumLiteralExp(literalExp));
	}

	@Override
	public Object visitExpression(OCLExpression<EClassifier> expression) {
		return trace(expression, getDelegate().visitExpression(expression));
	}

	@Override
	public Object visitExpressionInOCL(ExpressionInOCL<EClassifier, EParameter> expression) {
		return trace(expression, getDelegate().visitExpressionInOCL(expression));
	}

	@Override
	public Object visitIfExp(IfExp<EClassifier> ifExp) {
		return trace(ifExp, getDelegate().visitIfExp(ifExp));
	}

	@Override
	public Object visitIntegerLiteralExp(IntegerLiteralExp<EClassifier> literalExp) {
		return trace(literalExp,
				getDelegate().visitIntegerLiteralExp(literalExp));
	}

	@Override
	public Object visitInvalidLiteralExp(InvalidLiteralExp<EClassifier> literalExp) {
		return trace(literalExp,
				getDelegate().visitInvalidLiteralExp(literalExp));
	}

	@Override
	public Object visitIterateExp(IterateExp<EClassifier, EParameter> callExp) {
		return trace(callExp, getDelegate().visitIterateExp(callExp));
	}

	@Override
	public Object visitIteratorExp(IteratorExp<EClassifier, EParameter> callExp) {
		return trace(callExp, getDelegate().visitIteratorExp(callExp));
	}

	@Override
	public Object visitLetExp(LetExp<EClassifier, EParameter> letExp) {
		return trace(letExp, getDelegate().visitLetExp(letExp));
	}

	@Override
	public Object visitMessageExp(MessageExp<EClassifier, CallOperationAction, SendSignalAction> messageExp) {
		return trace(messageExp, getDelegate().visitMessageExp(messageExp));
	}

	@Override
	public Object visitNullLiteralExp(NullLiteralExp<EClassifier> literalExp) {
		return trace(literalExp, getDelegate().visitNullLiteralExp(literalExp));
	}

	@Override
	public Object visitOperationCallExp(OperationCallExp<EClassifier, EOperation> callExp) {
		return trace(callExp, getDelegate().visitOperationCallExp(callExp));
	}

	@Override
	public Object visitPropertyCallExp(PropertyCallExp<EClassifier, EStructuralFeature> callExp) {
		return trace(callExp, getDelegate().visitPropertyCallExp(callExp));
	}

	@Override
	public Object visitRealLiteralExp(RealLiteralExp<EClassifier> literalExp) {
		return trace(literalExp, getDelegate().visitRealLiteralExp(literalExp));
	}

	@Override
	public Object visitStateExp(StateExp<EClassifier, EObject> stateExp) {
		return trace(stateExp, getDelegate().visitStateExp(stateExp));
	}

	@Override
	public Object visitStringLiteralExp(StringLiteralExp<EClassifier> literalExp) {
		return trace(literalExp, getDelegate()
				.visitStringLiteralExp(literalExp));
	}

	@Override
	public Object visitTupleLiteralExp(TupleLiteralExp<EClassifier, EStructuralFeature> literalExp) {
		return trace(literalExp, getDelegate().visitTupleLiteralExp(literalExp));
	}

	@Override
	public Object visitTupleLiteralPart(TupleLiteralPart<EClassifier, EStructuralFeature> part) {
		return trace(part, getDelegate().visitTupleLiteralPart(part));
	}

	@Override
	public Object visitTypeExp(TypeExp<EClassifier> typeExp) {
		return trace(typeExp, getDelegate().visitTypeExp(typeExp));
	}

	@Override
	public Object visitUnlimitedNaturalLiteralExp(
			UnlimitedNaturalLiteralExp<EClassifier> literalExp) {
		return trace(literalExp,
				getDelegate().visitUnlimitedNaturalLiteralExp(literalExp));
	}

	@Override
	public Object visitUnspecifiedValueExp(UnspecifiedValueExp<EClassifier> unspecExp) {
		return trace(unspecExp,
				getDelegate().visitUnspecifiedValueExp(unspecExp));
	}

	@Override
	public Object visitVariable(Variable<EClassifier, EParameter> variable) {
		return trace(variable, getDelegate().visitVariable(variable));
	}

	@Override
	public Object visitVariableExp(VariableExp<EClassifier, EParameter> variableExp) {
		return trace(variableExp, getDelegate().visitVariableExp(variableExp));
	}

	public Object visitOppositePropertyCallExp(OppositePropertyCallExp callExp) {
		return trace(callExp, ((EvaluationVisitorWithHiddenOpposites) getDelegate()).visitOppositePropertyCallExp(callExp));
	}
}

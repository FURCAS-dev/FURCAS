/**
 * 
 * @author Octavian Patrascoiu
 *
 */

package org.oslo.ocl20.syntax.parser;

import java.util.List;
import java.util.Vector;

import org.oslo.ocl20.syntax.ast.AstFactory;
import org.oslo.ocl20.syntax.ast.AstPackage;
import org.oslo.ocl20.syntax.ast.contexts.ClassifierContextDeclAS;
import org.oslo.ocl20.syntax.ast.contexts.ConstraintAS;
import org.oslo.ocl20.syntax.ast.contexts.ConstraintKindAS;
import org.oslo.ocl20.syntax.ast.contexts.ContextDeclarationAS;
import org.oslo.ocl20.syntax.ast.contexts.ContextsFactory;
import org.oslo.ocl20.syntax.ast.contexts.OperationAS;
import org.oslo.ocl20.syntax.ast.contexts.OperationContextDeclAS;
import org.oslo.ocl20.syntax.ast.contexts.PackageDeclarationAS;
import org.oslo.ocl20.syntax.ast.contexts.PropertyContextDeclAS;
import org.oslo.ocl20.syntax.ast.contexts.VariableDeclarationAS;
import org.oslo.ocl20.syntax.ast.expressions.AndExpAS;
import org.oslo.ocl20.syntax.ast.expressions.ArrowSelectionExpAS;
import org.oslo.ocl20.syntax.ast.expressions.BooleanLiteralExpAS;
import org.oslo.ocl20.syntax.ast.expressions.CallExpAS;
import org.oslo.ocl20.syntax.ast.expressions.CollectionItemAS;
import org.oslo.ocl20.syntax.ast.expressions.CollectionKindAS;
import org.oslo.ocl20.syntax.ast.expressions.CollectionLiteralExpAS;
import org.oslo.ocl20.syntax.ast.expressions.CollectionRangeAS;
import org.oslo.ocl20.syntax.ast.expressions.DotSelectionExpAS;
import org.oslo.ocl20.syntax.ast.expressions.EnumLiteralExpAS;
import org.oslo.ocl20.syntax.ast.expressions.ExpressionsFactory;
import org.oslo.ocl20.syntax.ast.expressions.IfExpAS;
import org.oslo.ocl20.syntax.ast.expressions.ImpliesExpAS;
import org.oslo.ocl20.syntax.ast.expressions.IntegerLiteralExpAS;
import org.oslo.ocl20.syntax.ast.expressions.IterateExpAS;
import org.oslo.ocl20.syntax.ast.expressions.LetExpAS;
import org.oslo.ocl20.syntax.ast.expressions.LoopExpAS;
import org.oslo.ocl20.syntax.ast.expressions.NotExpAS;
import org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS;
import org.oslo.ocl20.syntax.ast.expressions.OclMessageArgAS;
import org.oslo.ocl20.syntax.ast.expressions.OclMessageExpAS;
import org.oslo.ocl20.syntax.ast.expressions.OclMessageKindAS;
import org.oslo.ocl20.syntax.ast.expressions.OperationCallExpAS;
import org.oslo.ocl20.syntax.ast.expressions.OrExpAS;
import org.oslo.ocl20.syntax.ast.expressions.PathNameExpAS;
import org.oslo.ocl20.syntax.ast.expressions.RealLiteralExpAS;
import org.oslo.ocl20.syntax.ast.expressions.StringLiteralExpAS;
import org.oslo.ocl20.syntax.ast.expressions.TupleLiteralExpAS;
import org.oslo.ocl20.syntax.ast.expressions.XorExpAS;
import org.oslo.ocl20.syntax.ast.types.ClassifierAS;
import org.oslo.ocl20.syntax.ast.types.CollectionTypeAS;
import org.oslo.ocl20.syntax.ast.types.TupleTypeAS;
import org.oslo.ocl20.syntax.ast.types.TypeAS;
import org.oslo.ocl20.syntax.ast.types.TypesFactory;

import uk.ac.kent.cs.kmf.util.ILog;

public class ASTBuilder {
	protected ILog log;
	public ASTBuilder(ILog log) {
		this.log = log;
	}
	protected AstFactory factory = AstFactory.eINSTANCE;
		//new astFactory(log);
	//
	// Build context
	//
	/** Build PackageDeclaration */
	public PackageDeclarationAS buildPackageDeclaration(List path, List contextDecls) {
		
		PackageDeclarationAS result = ContextsFactory.eINSTANCE.createPackageDeclarationAS();
		result.getPathName().addAll(path);
		result.getContextDecls().addAll(contextDecls);
		return result;
	}
	/** Build PropertyContextDeclaration */
	public PropertyContextDeclAS buildPropertyContextDeclaration(List path, String name, TypeAS type, List constraints) {
		PropertyContextDeclAS res = ContextsFactory.eINSTANCE.createPropertyContextDeclAS();
		res.getPathName().addAll(path);
		res.setName(name);
		res.setType(type);
		res.getConstraints().addAll(constraints);
		return res;
	}
	/** Build ClassifierContextDeclaration */
	public ClassifierContextDeclAS buildClassifierContextDeclaration(TypeAS t, List constraints) {
		ClassifierContextDeclAS res = ContextsFactory.eINSTANCE.createClassifierContextDeclAS();
		res.setType(t);
		res.getConstraints().addAll(constraints);
		return res;
	}
	
	public ClassifierContextDeclAS buildClassifierContextDeclaration(List path, List constraints) {
		ClassifierContextDeclAS res = ContextsFactory.eINSTANCE.createClassifierContextDeclAS();
		res.getPathName().addAll(path);
		res.getConstraints().addAll(constraints);
		return res;
	}
	
	/** Build OperationContextDeclaration */
	public OperationContextDeclAS buildOperationContextDeclaration(OperationAS oper, List constraints) {
		OperationContextDeclAS result = ContextsFactory.eINSTANCE.createOperationContextDeclAS();
		result.setOperation(oper);
		result.getConstraints().addAll(constraints);
		return result;
	}
	/** Build Operation */
	public OperationAS buildOperation(List path, String name, List params, TypeAS type) {
		OperationAS oper = ContextsFactory.eINSTANCE.createOperationAS();
		oper.getPathName().addAll(path);
		oper.setName(name);
		oper.getParameters().addAll(params);
		oper.setType(type);
		return oper;
	}	
	/** Build Constraint */
	public ConstraintAS buildConstraint(ConstraintKindAS kind, String name, OclExpressionAS body, Object varOrOper) {
		ConstraintAS cons = ContextsFactory.eINSTANCE.createConstraintAS();
		cons.setKind(kind);
		cons.setName(name);
		cons.setBodyExpression(body);
		if (varOrOper instanceof VariableDeclarationAS) {
			cons.setDefVariable((VariableDeclarationAS)varOrOper);
		} else if (varOrOper instanceof OperationAS) {
			cons.setDefOperation((OperationAS)varOrOper);
		}
		return cons;
	}

	//
	// Build variables and types
	//
	/** Build VariableDeclaration */
	public VariableDeclarationAS buildVariableDeclaration(String name, TypeAS type, OclExpressionAS init) {
		VariableDeclarationAS var = ContextsFactory.eINSTANCE.createVariableDeclarationAS();
		var.setName(name);
		var.setType(type);
		var.setInitExp(init);
		return var;
	}
	/** Build PathNameType */
	public ClassifierAS buildPathNameType(List path) {
		ClassifierAS type = TypesFactory.eINSTANCE.createClassifierAS();
		type.setPathName(path);
		return type;
	}
	/** Build CollectionType */
	public CollectionTypeAS buildCollectionType(CollectionKindAS kind, TypeAS elementType) {
		CollectionTypeAS type = null;
		if (kind == CollectionKindAS.BAG_LITERAL) {
			type = TypesFactory.eINSTANCE.createBagTypeAS();
			type.setElementType(elementType);
		} else if (kind == CollectionKindAS.COLLECTION_LITERAL) {
			type = TypesFactory.eINSTANCE.createCollectionTypeAS();
			type.setElementType(elementType);
		} else if (kind == CollectionKindAS.SEQUENCE_LITERAL) {
			type = TypesFactory.eINSTANCE.createSequenceTypeAS();
			type.setElementType(elementType);
		} else if (kind == CollectionKindAS.SET_LITERAL) {
			type = TypesFactory.eINSTANCE.createSetTypeAS();
			type.setElementType(elementType);
		} else if (kind == CollectionKindAS.ORDERED_SET_LITERAL) {
			type = TypesFactory.eINSTANCE.createOrderedSetTypeAS();
			type.setElementType(elementType);
		} else {
			type = null;
		}
		return type;
	}
	/** Build TypeType */
	public TupleTypeAS buildTupleType(List varList) {
		TupleTypeAS type = TypesFactory.eINSTANCE.createTupleTypeAS();
		type.getVariableDeclarationList().addAll(varList);
		return type;
	}
	
	//
	// Build expressions
	//
	/** Build PathNameExp */
	public PathNameExpAS buildPathNameExp(List path, Boolean isMarkedPre) {
		PathNameExpAS res = ExpressionsFactory.eINSTANCE.createPathNameExpAS();
		res.getPathName().addAll(path);
		res.setIsMarkedPre(isMarkedPre);
		return res;
	}
	/** Build DotSelectionExp */
	public DotSelectionExpAS buildDotSelectionExp(OclExpressionAS exp, String name, Boolean isMarkedPre) {
		DotSelectionExpAS res = ExpressionsFactory.eINSTANCE.createDotSelectionExpAS();
		res.setSource(exp);
		res.setName(name);
		res.setIsMarkedPre(isMarkedPre);
		exp.setParent(res);
		return res;
	}
	/** Build ArrowSelectionExp */
	public ArrowSelectionExpAS buildArrowSelectionExp(OclExpressionAS exp, String name) {
		ArrowSelectionExpAS res = ExpressionsFactory.eINSTANCE.createArrowSelectionExpAS();
		res.setSource(exp);
		res.setName(name);
		exp.setParent(res);
		return res;
	}
	/** Build OperationCallExp for +, -, *, / aso */
	public OclExpressionAS buildOperationCallExp(String name, OclExpressionAS left, OclExpressionAS right) {
		// Create source
		DotSelectionExpAS source = ExpressionsFactory.eINSTANCE.createDotSelectionExpAS();
		source.setSource(left);
		source.setName(name);
		// Create acll
		OperationCallExpAS res = ExpressionsFactory.eINSTANCE.createOperationCallExpAS();
		res.setSource(source);
		res.getArguments().addAll(new Vector());
		if (right != null)
			res.getArguments().add(right);
		left.setParent(res);
		return res;
	}
	/** Build OperationCallExp */
	public CallExpAS buildOperationCallExp(OclExpressionAS exp, List arguments) {
		CallExpAS res = ExpressionsFactory.eINSTANCE.createOperationCallExpAS();
		res.setSource(exp);
		res.getArguments().addAll(arguments);
		exp.setParent(res);
		return res;
	}
	/** Build IteratorCallExp */
	public LoopExpAS buildIteratorCallExp(OclExpressionAS srcArrowExp1, List varList, OclExpressionAS exp2) {
		LoopExpAS res = ExpressionsFactory.eINSTANCE.createIteratorExpAS();
		res.setSource(srcArrowExp1);
		res.getIterator().addAll(varList);
		res.setBody(exp2);
		srcArrowExp1.setParent(res);
		return res;
	}
	/** Build AssociationCallExp */
	public CallExpAS buildAssociationCallExp(OclExpressionAS exp, List arguments, Boolean isMarkedPre) {
		CallExpAS res = ExpressionsFactory.eINSTANCE.createAssociationCallExpAS();
		res.setSource(exp);
		res.getArguments().addAll(arguments);
		res.setIsMarkedPre(isMarkedPre);
		exp.setParent(res);
		return res;
	}
	/** Create an IterateExp */
	public OclExpressionAS buildIterateExp(OclExpressionAS source, VariableDeclarationAS iterator, VariableDeclarationAS result, OclExpressionAS body) {
		IterateExpAS res = ExpressionsFactory.eINSTANCE.createIterateExpAS();
		res.setSource(source);
		res.setName("iterate");
		List x = new Vector();
		x.add(iterator);
		res.getIterator().addAll(x);
		res.setResult(result);
		res.setBody(body);
		source.setParent(res);
		return res;
	}
	/** Build LogicalExp */
	public OclExpressionAS buildNotExp(OclExpressionAS left) {
				NotExpAS res = ExpressionsFactory.eINSTANCE.createNotExpAS();
				res.setLeftOperand(left);
				left.setParent(res);
				return res;
	}
	
	public OclExpressionAS buildOrExp(OclExpressionAS left, OclExpressionAS right) {
				OrExpAS res = ExpressionsFactory.eINSTANCE.createOrExpAS();
				res.setLeftOperand(left);
				res.setRightOperand(right);
				left.setParent(res);
				return res;
	}
	
	public OclExpressionAS buildAndExp(OclExpressionAS left, OclExpressionAS right) {
				AndExpAS res = ExpressionsFactory.eINSTANCE.createAndExpAS();
				res.setLeftOperand(left);
				res.setRightOperand(right);
				left.setParent(res);
				return res;
	}
	
	public OclExpressionAS buildXorExp(OclExpressionAS left, OclExpressionAS right) {
				XorExpAS res = ExpressionsFactory.eINSTANCE.createXorExpAS();
				res.setLeftOperand(left);
				res.setRightOperand(right);
				left.setParent(res);
				return res;
} 
	public OclExpressionAS buildImpliesExp(OclExpressionAS left, OclExpressionAS right) {
				ImpliesExpAS res = ExpressionsFactory.eINSTANCE.createImpliesExpAS();
				res.setLeftOperand(left);
				res.setRightOperand(right);
				left.setParent(res);
				return res;
	}

	/** Create an OclMessageExp */
	public OclExpressionAS buildOclMessageExp(OclMessageKindAS kind, OclExpressionAS target, String name, List arguments) {
		OclMessageExpAS res = ExpressionsFactory.eINSTANCE.createOclMessageExpAS();
		res.setKind(kind);
		res.setName(name);
		res.setTarget(target);
		res.getArguments().addAll(arguments);
		target.setParent(res);
		return res;
	}
	/** Build OclMessageArg */
	public OclMessageArgAS buildOclMessageArg(OclExpressionAS exp, TypeAS type) {
		OclMessageArgAS arg = ExpressionsFactory.eINSTANCE.createOclMessageArgAS();
		arg.setExpression(exp);
		arg.setType(type);
		return arg;
	}
	/** Build IfExp */
	public IfExpAS buildIfExp(OclExpressionAS condition, OclExpressionAS thenExp, OclExpressionAS elseExp) {
		IfExpAS res = ExpressionsFactory.eINSTANCE.createIfExpAS();
		res.setCondition(condition);
		res.setThenExpression(thenExp);
		res.setElseExpression(elseExp);
		return res;
	}
	/** Build LetExp */
	public LetExpAS buildLetExp(List variables, OclExpressionAS exp) {
		LetExpAS res = ExpressionsFactory.eINSTANCE.createLetExpAS();
		res.getVariables().addAll(variables);
		res.setIn(exp);
		return res;
	}
	
	//
	// Build primitive expressions
	//
	/** Build EnumLiteralExp */
	public EnumLiteralExpAS buildEnumLiteralExp(List path) {
		EnumLiteralExpAS exp = ExpressionsFactory.eINSTANCE.createEnumLiteralExpAS();
		exp.getPathName().addAll(path);
		return exp;
	}
	/** Build CollectionLiteralExp */
	public CollectionLiteralExpAS buildCollectionLiteralExp(CollectionKindAS kind, List parts) {
		CollectionLiteralExpAS exp = ExpressionsFactory.eINSTANCE.createCollectionLiteralExpAS();
		exp.setKind(kind);
		exp.getCollectionParts().addAll(parts);
		return exp;
	}
	/** Build CollectionItem */
	public CollectionItemAS buildCollectionItem(OclExpressionAS exp) {
		CollectionItemAS item = ExpressionsFactory.eINSTANCE.createCollectionItemAS();
		item.setItem(exp);
		return item;
	}
	/** Build CollectionRange */
	public CollectionRangeAS buildCollectionRange(OclExpressionAS first, OclExpressionAS last) {
		CollectionRangeAS exp = ExpressionsFactory.eINSTANCE.createCollectionRangeAS();
		exp.setFirst(first);
		exp.setLast(last);
		return exp;
	}
	/** Build BooleanLiteralExp */
	public BooleanLiteralExpAS buildBooleanLiteralExp(String value) {
		BooleanLiteralExpAS exp = ExpressionsFactory.eINSTANCE.createBooleanLiteralExpAS();
		if (value != null && !value.equals("undefined"))
			exp.setValue(Boolean.valueOf(value));
		else
			exp.setValue(null);
		return exp;
	}
	/** Build IntegerLiteralExp */
	public IntegerLiteralExpAS buildIntegerLiteralExp(String value) {
		IntegerLiteralExpAS exp = ExpressionsFactory.eINSTANCE.createIntegerLiteralExpAS();
		exp.setValue(Integer.valueOf(value));
		return exp;
	}
	/** Build RealLiteralExp */
	public RealLiteralExpAS buildRealLiteralExp(String value) {
		RealLiteralExpAS exp = ExpressionsFactory.eINSTANCE.createRealLiteralExpAS();
		exp.setValue(Double.valueOf(value));
		return exp;
	}
	/** Build StringLiteralExp */
	public StringLiteralExpAS buildStringLiteralExp(String value) {
		StringLiteralExpAS exp = ExpressionsFactory.eINSTANCE.createStringLiteralExpAS();
		exp.setValue(value.substring(1,value.length()-1));
		return exp;
	}
	/** Build TupleLiteralExp */
	public TupleLiteralExpAS buildTupleLiteralExp(List seq) {
		TupleLiteralExpAS exp = ExpressionsFactory.eINSTANCE.createTupleLiteralExpAS();
		exp.getTupleParts().addAll(seq);
		return exp;
	}
}

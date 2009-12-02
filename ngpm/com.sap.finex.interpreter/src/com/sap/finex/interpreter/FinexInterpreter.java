package com.sap.finex.interpreter;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import structure.Association;
import structure.Field;
import structure.FinexClass;
import structure.Type;
import behavior.actions.ExpressionStatement;
import behavior.actions.Statement;
import behavior.expressions.Alias;
import behavior.expressions.All;
import behavior.expressions.BinaryBooleanOperator;
import behavior.expressions.BinaryNumericOperator;
import behavior.expressions.Count;
import behavior.expressions.Equals;
import behavior.expressions.Expression;
import behavior.expressions.FilterExpression;
import behavior.expressions.ImplicitContext;
import behavior.expressions.NamedValueExpression;
import behavior.expressions.Not;
import behavior.expressions.NumericAggregate;
import behavior.expressions.ObjectCreationExpression;
import behavior.expressions.PathExpression;
import behavior.expressions.This;
import behavior.expressions.Tuple;
import behavior.expressions.Unequals;
import behavior.expressions.literals.BinaryLiteral;
import behavior.expressions.literals.BooleanLiteral;
import behavior.expressions.literals.DateLiteral;
import behavior.expressions.literals.DecimalLiteral;
import behavior.expressions.literals.IntegerLiteral;
import behavior.expressions.literals.MultiObjectLiteral;
import behavior.expressions.literals.StringLiteral;
import behavior.functions.NativeImpl;
import behavior.functions.SignatureImplementation;

import com.sap.finex.interpreter.expressions.AllInterpreter;
import com.sap.finex.interpreter.expressions.BinaryBooleanOperatorInterpreter;
import com.sap.finex.interpreter.expressions.BinaryLiteralInterpreter;
import com.sap.finex.interpreter.expressions.BinaryNumericOperatorInterpreter;
import com.sap.finex.interpreter.expressions.BooleanLiteralInterpreter;
import com.sap.finex.interpreter.expressions.CountInterpreter;
import com.sap.finex.interpreter.expressions.DateLiteralInterpreter;
import com.sap.finex.interpreter.expressions.DecimalLiteralInterpreter;
import com.sap.finex.interpreter.expressions.EqualsInterpreter;
import com.sap.finex.interpreter.expressions.FilterExpressionInterpreter;
import com.sap.finex.interpreter.expressions.ImplicitContextInterpreter;
import com.sap.finex.interpreter.expressions.IntegerLiteralInterpreter;
import com.sap.finex.interpreter.expressions.MultiObjectLiteralInterpreter;
import com.sap.finex.interpreter.expressions.NamedValueInterpreter;
import com.sap.finex.interpreter.expressions.NotInterpreter;
import com.sap.finex.interpreter.expressions.NumericAggregateInterpreter;
import com.sap.finex.interpreter.expressions.ObjectCreationInterpreter;
import com.sap.finex.interpreter.expressions.PathExpressionInterpreter;
import com.sap.finex.interpreter.expressions.StringLiteralInterpreter;
import com.sap.finex.interpreter.expressions.ThisInterpreter;
import com.sap.finex.interpreter.expressions.TupleInterpreter;
import com.sap.finex.interpreter.expressions.UnequalsInterpreter;
import com.sap.finex.interpreter.objects.FinexNativeObject;
import com.sap.finex.interpreter.statements.ExpressionStatementInterpreter;
import com.sap.finex.metamodel.utils.MetamodelUtils;
import com.sap.runlet.abstractinterpreter.AbstractRunletInterpreter;
import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.ClassTypedObject;
import com.sap.runlet.abstractinterpreter.objects.EmptyObject;
import com.sap.runlet.abstractinterpreter.objects.MultiValuedObject;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.abstractinterpreter.repository.Repository;
import com.sap.runlet.abstractinterpreter.util.Fraction;
import com.sap.tc.moin.repository.Connection;

public class FinexInterpreter
	extends
	AbstractRunletInterpreter<FinexClass, Type, FinexClass, Association, Field, Statement, Expression, SignatureImplementation, FinexStackFrame, NativeImpl, FinexInterpreter> {

    public FinexInterpreter(
	    Connection conn,
	    Repository<Association, Field, FinexClass, Type, FinexClass> repository) {
	super(conn, repository, new FinexModelAdapter(), new NativeInterpreterFactory(), new FinexLinkContainer(
		Activator.getDefault().getModelAdapter(), repository));
    }

    /**
     * Spawns a new interpreter for parallel execution. This interpreter re-uses
     * the registries for subinterpreters for expressions, statements etc., the
     * MOIN {@link #connection}, the {@link #debugSession} as well as the shared
     * state consisting of the {@link #linkContainer}. The spawned interpreter
     * has a new {@link #callstack call stack} that is initialized with the
     * <tt>parent</tt> interpreter's top stack frame.
     * <p>
     * 
     * This means that a spawned interpreter may not have all of the first stack
     * frame's scope parent frames on its own stack. If this first frame happens
     * to have a scope parent, this is referenced by a regular Java reference.
     * <p>
     * 
     * The spawned interpreter created here will start out with an empty set of
     * {@link #runningChildren} child interpreters. It starts out in non-
     * {@link #running running} mode.
     * <p>
     */
    private FinexInterpreter(FinexInterpreter parent) {
	super(parent);
    }

    @Override
    protected FinexValueObject createValueObjectWithoutEqualityRelevantLinks(
	    FinexClass type, Map<Field, Collection<ClassTypedObject<Field, Type, FinexClass>>> propertyValues) {
	return new FinexValueObject(type, propertyValues, getUpdatingTag(), this);
    }
    
    @Override
    public FinexValueObject createValueObject(
	    FinexClass type, Map<Field, Collection<ClassTypedObject<Field, Type, FinexClass>>> propertyValues) {
	return (FinexValueObject) super.createValueObject(type, propertyValues);
    }

    @Override
    protected void initExpressionInterpreterFactory(Connection conn) {
	getExpressionInterpreterFactory().registerInterpreter(StringLiteralInterpreter.class,
		conn.getClass(StringLiteral.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(BinaryLiteralInterpreter.class,
		conn.getClass(BinaryLiteral.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(BooleanLiteralInterpreter.class,
		conn.getClass(BooleanLiteral.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(DateLiteralInterpreter.class,
		conn.getClass(DateLiteral.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(DecimalLiteralInterpreter.class,
		conn.getClass(DecimalLiteral.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(IntegerLiteralInterpreter.class,
		conn.getClass(IntegerLiteral.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(BinaryBooleanOperatorInterpreter.class,
		conn.getClass(BinaryBooleanOperator.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(NotInterpreter.class,
		conn.getClass(Not.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(BinaryNumericOperatorInterpreter.class,
		conn.getClass(BinaryNumericOperator.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(ObjectCreationInterpreter.class,
		conn.getClass(ObjectCreationExpression.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(CountInterpreter.class,
		conn.getClass(Count.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(PathExpressionInterpreter.class,
		conn.getClass(PathExpression.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(FilterExpressionInterpreter.class,
		conn.getClass(FilterExpression.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(ImplicitContextInterpreter.class,
		conn.getClass(ImplicitContext.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(ThisInterpreter.class,
		conn.getClass(This.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(EqualsInterpreter.class,
		conn.getClass(Equals.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(UnequalsInterpreter.class,
		conn.getClass(Unequals.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(TupleInterpreter.class,
		conn.getClass(Tuple.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(NamedValueInterpreter.class,
		conn.getClass(NamedValueExpression.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(MultiObjectLiteralInterpreter.class, 
		conn.getClass(MultiObjectLiteral.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(NumericAggregateInterpreter.class, 
		conn.getClass(NumericAggregate.CLASS_DESCRIPTOR).refMetaObject());
	getExpressionInterpreterFactory().registerInterpreter(AllInterpreter.class, 
		conn.getClass(All.CLASS_DESCRIPTOR).refMetaObject());
    }

    @Override
    protected void initNativeInterpreterFactory(Connection conn) {
	// TODO Auto-generated method stub
	
    }

    @Override
    protected void initSignatureImplementationInterpreterFactory(Connection conn) {
	// TODO Auto-generated method stub
	
    }

    @Override
    protected void initStatementInterpreterFactory(Connection conn) {
	getStatementInterpreterFactory().registerInterpreter(ExpressionStatementInterpreter.class,
		conn.getClass(ExpressionStatement.CLASS_DESCRIPTOR).refMetaObject());
    }

    @Override
    public FinexInterpreter spawn() {
	return new FinexInterpreter(this);
    }

    /**
     * If <tt>isMany</tt> is <tt>true</tt>, the result will be a {@link MultiValuedObject}. Otherwise,
     * the result will be an {@link EmptyObject} if the <tt>source</tt> object contains no objects,
     * or the single first object of <tt>source</tt> otherwise.
     */
    public static RunletObject<Field, Type, FinexClass> turnIntoObjectOfAppropriateMultiplicity(
            Type type, FinexInterpreter interpreter,
            List<RunletObject<Field, Type, FinexClass>> source, boolean isMany) {
        RunletObject<Field, Type, FinexClass> result;
        if (isMany) {
            // TODO what about ordering and uniqueness?
            result = new MultiValuedObject<Field, Type, FinexClass>(type, source, /* ordered */ false, /* unique */ false);
        } else {
            if (source.size() > 0) {
        	result = source.iterator().next();
            } else {
        	result = new EmptyObject<Field, FinexClass, Type, FinexClass>(type, interpreter.getModelAdapter());
            }
        }
        return result;
    }

    /**
     * In addition to calling the superclass method, if an {@link Alias} is defined for <tt>e</tt>, then for each object of the
     * flattened results adds an entry to the current stack frame's {@link AliasValues} map.
     * <p>
     * 
     * Implementations of the micro-{@link Interpreter}s for expression types must ensure that for any operand they compute they
     * enter alias values for the operand's evaluation onto the operand evaluation's stack frame.
     */
    @Override
    public RunletObject<Field, Type, FinexClass> evaluate(Expression e) throws SecurityException,
	    IllegalArgumentException, NoSuchMethodException, InstantiationException, IllegalAccessException,
	    InvocationTargetException {
	RunletObject<Field, Type, FinexClass> result = super.evaluate(e);
	Alias a = e.getAlias();
	if (a != null) {
	    AliasValues aliasValues = getCallstack().peek().getAliasValues();
	    for (RunletObject<Field, Type, FinexClass> o:result.flatten()) {
		aliasValues.enterAliasValue(e, o, a, o);
	    }
	}
	return result;
    }

    public FinexNativeObject convertFractionToNativeObject(Fraction result, Type targetType) {
        FinexNativeObject runletResult;
        if (targetType.equals(MetamodelUtils.findClass(getConnection(), "Decimal"))) {
        // decimals are represented as Fractions, we're okay
        runletResult = new FinexNativeObject((FinexClass) targetType, result, getDefaultSnapshot(),
        	this);
        } else {
        // Integers are represented as long; convert
        runletResult = new FinexNativeObject((FinexClass) targetType, result.asLong(),
        	getDefaultSnapshot(), this);
        }
        return runletResult;
    }

}

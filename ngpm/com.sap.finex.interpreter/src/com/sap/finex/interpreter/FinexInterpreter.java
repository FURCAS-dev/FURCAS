package com.sap.finex.interpreter;

import java.util.Collection;
import java.util.Map;

import structure.Association;
import structure.Field;
import structure.FinexClass;
import structure.Type;
import behavior.actions.Statement;
import behavior.expressions.BinaryBooleanOperator;
import behavior.expressions.BinaryNumericOperator;
import behavior.expressions.Expression;
import behavior.expressions.Not;
import behavior.expressions.literals.BinaryLiteral;
import behavior.expressions.literals.BooleanLiteral;
import behavior.expressions.literals.DateLiteral;
import behavior.expressions.literals.DecimalLiteral;
import behavior.expressions.literals.IntegerLiteral;
import behavior.expressions.literals.StringLiteral;
import behavior.functions.NativeImpl;
import behavior.functions.SignatureImplementation;

import com.sap.finex.interpreter.expressions.BinaryBooleanOperatorInterpreter;
import com.sap.finex.interpreter.expressions.BinaryLiteralInterpreter;
import com.sap.finex.interpreter.expressions.BinaryNumericOperatorInterpreter;
import com.sap.finex.interpreter.expressions.BooleanLiteralInterpreter;
import com.sap.finex.interpreter.expressions.DateLiteralInterpreter;
import com.sap.finex.interpreter.expressions.DecimalLiteralInterpreter;
import com.sap.finex.interpreter.expressions.IntegerLiteralInterpreter;
import com.sap.finex.interpreter.expressions.NotInterpreter;
import com.sap.finex.interpreter.expressions.StringLiteralInterpreter;
import com.sap.runlet.abstractinterpreter.AbstractRunletInterpreter;
import com.sap.runlet.abstractinterpreter.objects.AbstractValueObject;
import com.sap.runlet.abstractinterpreter.objects.ClassTypedObject;
import com.sap.runlet.abstractinterpreter.repository.Repository;
import com.sap.tc.moin.repository.Connection;

public class FinexInterpreter
	extends
	AbstractRunletInterpreter<FinexClass, Type, FinexClass, Association, Field, Statement, Expression, SignatureImplementation, FinexStackFrame, NativeImpl, FinexInterpreter> {

    public FinexInterpreter(
	    Connection conn,
	    Repository<Association, Field, FinexClass, Type, FinexClass> repository) {
	super(conn, repository, new FinexModelAdapter(), new NativeInterpreterFactory(), new FinexLinkContainer(
		Activator.getDefault().getModelAdapter(),
		new FinexInMemoryRepository(Activator.getDefault().getModelAdapter())));
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
    protected AbstractValueObject<Association, Field, FinexClass, Type, FinexClass> createValueObjectWithoutEqualityRelevantLinks(
	    FinexClass type, Map<Field, Collection<ClassTypedObject<Field, Type, FinexClass>>> propertyValues) {
	return new FinexValueObject(type, propertyValues, getUpdatingTag(), this);
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
	// TODO Auto-generated method stub
	
    }

    @Override
    public FinexInterpreter spawn() {
	return new FinexInterpreter(this);
    }

}

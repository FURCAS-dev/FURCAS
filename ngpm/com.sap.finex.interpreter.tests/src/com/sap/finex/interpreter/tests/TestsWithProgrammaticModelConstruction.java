package com.sap.finex.interpreter.tests;

import java.lang.reflect.InvocationTargetException;

import junit.framework.TestCase;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;

import structure.Field;
import structure.FinexClass;
import structure.Type;
import behavior.expressions.BinaryBooleanOperator;
import behavior.expressions.BinaryNumericOperator;
import behavior.expressions.Not;
import behavior.expressions.literals.BooleanLiteral;
import behavior.expressions.literals.DecimalLiteral;
import behavior.expressions.literals.IntegerLiteral;

import com.sap.finex.interpreter.Activator;
import com.sap.finex.interpreter.FinexInMemoryRepository;
import com.sap.finex.interpreter.FinexInterpreter;
import com.sap.finex.interpreter.objects.FinexNativeObject;
import com.sap.finex.metamodel.utils.MetamodelUtils;
import com.sap.mi.fwk.ConnectionManager;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.abstractinterpreter.util.Fraction;
import com.sap.tc.moin.repository.Connection;

public class TestsWithProgrammaticModelConstruction extends TestCase {
    private FinexInterpreter interpreter;

    @Override
    public void setUp() {
	Connection conn = getConnection("finex.stdlib");
	interpreter = new FinexInterpreter(conn, new FinexInMemoryRepository(Activator.getDefault().getModelAdapter()));

    }

    public void testBinaryIntegerOperationsSingle() throws SecurityException, IllegalArgumentException, NoSuchMethodException,
	    InstantiationException, IllegalAccessException, InvocationTargetException {
	BinaryNumericOperator bno = interpreter.getConnection().createElement(BinaryNumericOperator.CLASS_DESCRIPTOR);
	bno.setType(MetamodelUtils.findClass(interpreter.getConnection(), "Integer"));
	bno.setOperator("*");
	IntegerLiteral left = createIntLiteral(28);
	bno.setLeft(left);
	IntegerLiteral right = createIntLiteral(4);
	bno.setRight(right);
	RunletObject<Field, Type, FinexClass> result = interpreter.evaluate(bno);
	assertTrue(result instanceof FinexNativeObject);
	assertEquals(28l*4l, ((FinexNativeObject) result).getNativeObject());
	
	bno.setOperator("/");
	result = interpreter.evaluate(bno);
	assertTrue(result instanceof FinexNativeObject);
	assertEquals(28l/4l, ((FinexNativeObject) result).getNativeObject());

	bno.setOperator("-");
	result = interpreter.evaluate(bno);
	assertTrue(result instanceof FinexNativeObject);
	assertEquals(28l-4l, ((FinexNativeObject) result).getNativeObject());

	bno.setOperator("+");
	result = interpreter.evaluate(bno);
	assertTrue(result instanceof FinexNativeObject);
	assertEquals(28l+4l, ((FinexNativeObject) result).getNativeObject());
    }

    public void testBinaryDecimalOperationsSingle() throws SecurityException, IllegalArgumentException, NoSuchMethodException,
	    InstantiationException, IllegalAccessException, InvocationTargetException {
	BinaryNumericOperator bno = interpreter.getConnection().createElement(BinaryNumericOperator.CLASS_DESCRIPTOR);
	bno.setType(MetamodelUtils.findClass(interpreter.getConnection(), "Decimal"));
	bno.setOperator("*");
	DecimalLiteral left = createDecLiteral("28");
	bno.setLeft(left);
	DecimalLiteral right = createDecLiteral("5");
	bno.setRight(right);
	RunletObject<Field, Type, FinexClass> result = interpreter.evaluate(bno);
	assertTrue(result instanceof FinexNativeObject);
	assertEquals(new Fraction(28).times(new Fraction(5)), ((FinexNativeObject) result).getNativeObject());

	bno.setOperator("/");
	result = interpreter.evaluate(bno);
	assertTrue(result instanceof FinexNativeObject);
	assertEquals(new Fraction(28).dividedBy(new Fraction(5)), ((FinexNativeObject) result).getNativeObject());

	bno.setOperator("-");
	result = interpreter.evaluate(bno);
	assertTrue(result instanceof FinexNativeObject);
	assertEquals(new Fraction(28).minus(new Fraction(5)), ((FinexNativeObject) result).getNativeObject());

	bno.setOperator("+");
	result = interpreter.evaluate(bno);
	assertTrue(result instanceof FinexNativeObject);
	assertEquals(new Fraction(28).plus(new Fraction(5)), ((FinexNativeObject) result).getNativeObject());
    }

    private IntegerLiteral createIntLiteral(long value) {
	IntegerLiteral literal = interpreter.getConnection().createElement(IntegerLiteral.CLASS_DESCRIPTOR);
	literal.setLiteral(Long.toString(value));
	return literal;
    }

    private DecimalLiteral createDecLiteral(String value) {
	DecimalLiteral literal = interpreter.getConnection().createElement(DecimalLiteral.CLASS_DESCRIPTOR);
	literal.setLiteral(value);
	return literal;
    }

    public void testSimpleNot() throws SecurityException, IllegalArgumentException, NoSuchMethodException,
	    InstantiationException, IllegalAccessException, InvocationTargetException {
	BooleanLiteral op = createBoolLiteral(true);
	Not not = interpreter.getConnection().createElement(Not.CLASS_DESCRIPTOR);
	not.setOperand(op);
	RunletObject<Field, Type, FinexClass> result = interpreter.evaluate(not);
	assertTrue(result instanceof FinexNativeObject);
	assertEquals(false, ((FinexNativeObject) result).getNativeObject());

	op = createBoolLiteral(false);
	not.setOperand(op);
	result = interpreter.evaluate(not);
	assertTrue(result instanceof FinexNativeObject);
	assertEquals(true, ((FinexNativeObject) result).getNativeObject());
    }

    public void testBooleanAndAndOrSingle() throws SecurityException, IllegalArgumentException, NoSuchMethodException,
	    InstantiationException, IllegalAccessException, InvocationTargetException {
	BinaryBooleanOperator bbo = interpreter.getConnection().createElement(BinaryBooleanOperator.CLASS_DESCRIPTOR);
	bbo.setOperator("and");
	BooleanLiteral left = createBoolLiteral(true);
	bbo.setLeft(left);
	BooleanLiteral right = createBoolLiteral(false);
	bbo.setRight(right);
	RunletObject<Field, Type, FinexClass> result = interpreter.evaluate(bbo);
	assertTrue(result instanceof FinexNativeObject);
	assertEquals(false, ((FinexNativeObject) result).getNativeObject());

	bbo.setOperator("or");
	left = createBoolLiteral(true);
	bbo.setLeft(left);
	right = createBoolLiteral(false);
	bbo.setRight(right);
	result = interpreter.evaluate(bbo);
	assertTrue(result instanceof FinexNativeObject);
	assertEquals(true, ((FinexNativeObject) result).getNativeObject());

	bbo.setOperator("and");
	left = createBoolLiteral(true);
	bbo.setRight(left);
	right = createBoolLiteral(true);
	bbo.setLeft(right);
	result = interpreter.evaluate(bbo);
	assertTrue(result instanceof FinexNativeObject);
	assertEquals(true, ((FinexNativeObject) result).getNativeObject());

	bbo.setOperator("or");
	left = createBoolLiteral(false);
	bbo.setLeft(left);
	right = createBoolLiteral(false);
	bbo.setRight(right);
	result = interpreter.evaluate(bbo);
	assertTrue(result instanceof FinexNativeObject);
	assertEquals(false, ((FinexNativeObject) result).getNativeObject());
    }

    private BooleanLiteral createBoolLiteral(boolean value) {
	BooleanLiteral literal = interpreter.getConnection().createElement(BooleanLiteral.CLASS_DESCRIPTOR);
	literal.setLiteral(Boolean.toString(value));
	return literal;
    }

    public void testIntegerLiteral() throws SecurityException, IllegalArgumentException, NoSuchMethodException,
	    InstantiationException, IllegalAccessException, InvocationTargetException {
	IntegerLiteral il = createIntLiteral(123);
	RunletObject<Field, Type, FinexClass> result = interpreter.evaluate(il);
	assertTrue(result instanceof FinexNativeObject);
	assertEquals(123l, ((FinexNativeObject) result).getNativeObject());
    }

    public void testDecimalLiteral() throws SecurityException, IllegalArgumentException, NoSuchMethodException,
	    InstantiationException, IllegalAccessException, InvocationTargetException {
	DecimalLiteral dl = interpreter.getConnection().createElement(DecimalLiteral.CLASS_DESCRIPTOR);
	dl.setLiteral("123.45");
	RunletObject<Field, Type, FinexClass> result = interpreter.evaluate(dl);
	assertTrue(result instanceof FinexNativeObject);
	assertEquals(new Fraction(12345, 100), ((FinexNativeObject) result).getNativeObject());
    }

    private static Connection getConnection(String projectName) {
	final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
	final Connection[] conn = new Connection[1];
	IRunnableWithProgress operation = new IRunnableWithProgress() {
	    public void run(IProgressMonitor monitor) {
		// non UI thread
		try {
		    project.open(/* progress monitor */null);
		} catch (CoreException e) {
		    throw new RuntimeException(e);
		}
		conn[0] = ConnectionManager.getInstance().getOrCreateDefaultConnection(project);
	    }
	};
	IProgressService ps = PlatformUI.getWorkbench().getProgressService();
	try {
	    if (Thread.currentThread() == Display.getDefault().getThread()) {
		ps.busyCursorWhile(operation);
	    } else {
		operation.run(null);
	    }
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
	return conn[0];
    }

}
